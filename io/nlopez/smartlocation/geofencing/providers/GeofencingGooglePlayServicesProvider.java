package io.nlopez.smartlocation.geofencing.providers;

import android.app.Activity;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.location.LocationServices;
import com.onesignal.location.internal.common.LocationConstants;
import io.nlopez.smartlocation.OnGeofencingTransitionListener;
import io.nlopez.smartlocation.geofencing.GeofencingProvider;
import io.nlopez.smartlocation.geofencing.GeofencingStore;
import io.nlopez.smartlocation.geofencing.model.GeofenceModel;
import io.nlopez.smartlocation.geofencing.utils.TransitionGeofence;
import io.nlopez.smartlocation.utils.GooglePlayServicesListener;
import io.nlopez.smartlocation.utils.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class GeofencingGooglePlayServicesProvider implements GeofencingProvider, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ResultCallback<Status> {
    public static final String BROADCAST_INTENT_ACTION = GeofencingGooglePlayServicesProvider.class.getCanonicalName() + ".GEOFENCE_TRANSITION";
    public static final String GEOFENCES_EXTRA_ID = "geofences";
    public static final String LOCATION_EXTRA_ID = "location";
    public static final int RESULT_CODE = 10003;
    public static final String TRANSITION_EXTRA_ID = "transition";
    private GoogleApiClient client;
    private Context context;
    private final List<Geofence> geofencesToAdd;
    private final List<String> geofencesToRemove;
    private BroadcastReceiver geofencingReceiver;
    private GeofencingStore geofencingStore;
    private final GooglePlayServicesListener googlePlayServicesListener;
    private OnGeofencingTransitionListener listener;
    private Logger logger;
    private PendingIntent pendingIntent;
    private boolean stopped;

    public GeofencingGooglePlayServicesProvider() {
        this(null);
    }

    public GeofencingGooglePlayServicesProvider(GooglePlayServicesListener googlePlayServicesListener) {
        this.geofencesToAdd = Collections.synchronizedList(new ArrayList());
        this.geofencesToRemove = Collections.synchronizedList(new ArrayList());
        this.stopped = false;
        this.geofencingReceiver = new BroadcastReceiver() { // from class: io.nlopez.smartlocation.geofencing.providers.GeofencingGooglePlayServicesProvider.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (GeofencingGooglePlayServicesProvider.BROADCAST_INTENT_ACTION.equals(intent.getAction()) && intent.hasExtra(GeofencingGooglePlayServicesProvider.GEOFENCES_EXTRA_ID)) {
                    GeofencingGooglePlayServicesProvider.this.logger.d("Received geofencing event", new Object[0]);
                    int intExtra = intent.getIntExtra(GeofencingGooglePlayServicesProvider.TRANSITION_EXTRA_ID, -1);
                    for (String str : intent.getStringArrayListExtra(GeofencingGooglePlayServicesProvider.GEOFENCES_EXTRA_ID)) {
                        GeofenceModel geofenceModel = GeofencingGooglePlayServicesProvider.this.geofencingStore.get(str);
                        if (geofenceModel != null) {
                            GeofencingGooglePlayServicesProvider.this.listener.onGeofenceTransition(new TransitionGeofence(geofenceModel, intExtra));
                        } else {
                            GeofencingGooglePlayServicesProvider.this.logger.w("Tried to retrieve geofence " + str + " but it was not in the store", new Object[0]);
                        }
                    }
                }
            }
        };
        this.googlePlayServicesListener = googlePlayServicesListener;
    }

    @Override // io.nlopez.smartlocation.geofencing.GeofencingProvider
    public void init(Context context, Logger logger) {
        this.context = context;
        this.logger = logger;
        this.geofencingStore = new GeofencingStore(context);
        GoogleApiClient build = new GoogleApiClient.Builder(context).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
        this.client = build;
        build.connect();
        this.pendingIntent = PendingIntent.getService(context, 0, new Intent(context, (Class<?>) GeofencingService.class), C.BUFFER_FLAG_FIRST_SAMPLE);
    }

    @Override // io.nlopez.smartlocation.geofencing.GeofencingProvider
    public void addGeofence(GeofenceModel geofenceModel) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(geofenceModel);
        addGeofences(arrayList);
    }

    @Override // io.nlopez.smartlocation.geofencing.GeofencingProvider
    public void addGeofences(List<GeofenceModel> list) {
        ArrayList arrayList = new ArrayList();
        for (GeofenceModel geofenceModel : list) {
            this.geofencingStore.put(geofenceModel.getRequestId(), geofenceModel);
            arrayList.add(geofenceModel.toGeofence());
        }
        if (this.client.isConnected()) {
            if (this.geofencesToAdd.size() > 0) {
                arrayList.addAll(this.geofencesToAdd);
                this.geofencesToAdd.clear();
            }
            if (ActivityCompat.checkSelfPermission(this.context, LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING) != 0) {
                return;
            }
            LocationServices.GeofencingApi.addGeofences(this.client, arrayList, this.pendingIntent);
            return;
        }
        Iterator<GeofenceModel> it = list.iterator();
        while (it.hasNext()) {
            this.geofencesToAdd.add(it.next().toGeofence());
        }
    }

    @Override // io.nlopez.smartlocation.geofencing.GeofencingProvider
    public void removeGeofence(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        removeGeofences(arrayList);
    }

    @Override // io.nlopez.smartlocation.geofencing.GeofencingProvider
    public void removeGeofences(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.geofencingStore.remove(it.next());
        }
        if (this.client.isConnected()) {
            if (this.geofencesToRemove.size() > 0) {
                list.addAll(this.geofencesToRemove);
                this.geofencesToRemove.clear();
            }
            LocationServices.GeofencingApi.removeGeofences(this.client, list);
            return;
        }
        this.geofencesToRemove.addAll(list);
    }

    @Override // io.nlopez.smartlocation.geofencing.GeofencingProvider
    public void start(OnGeofencingTransitionListener onGeofencingTransitionListener) {
        this.listener = onGeofencingTransitionListener;
        this.context.registerReceiver(this.geofencingReceiver, new IntentFilter(BROADCAST_INTENT_ACTION));
        if (!this.client.isConnected()) {
            this.logger.d("still not connected - scheduled start when connection is ok", new Object[0]);
        } else if (this.stopped) {
            this.client.connect();
            this.stopped = false;
        }
    }

    @Override // io.nlopez.smartlocation.geofencing.GeofencingProvider
    public void stop() {
        this.logger.d("stop", new Object[0]);
        if (this.client.isConnected()) {
            this.client.disconnect();
        }
        try {
            this.context.unregisterReceiver(this.geofencingReceiver);
        } catch (IllegalArgumentException unused) {
            this.logger.d("Silenced 'receiver not registered' stuff (calling stop more times than necessary did this)", new Object[0]);
        }
        this.stopped = true;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        this.logger.d("onConnected", new Object[0]);
        if (this.client.isConnected()) {
            if (this.geofencesToAdd.size() > 0) {
                if (ActivityCompat.checkSelfPermission(this.context, LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING) != 0) {
                    return;
                }
                LocationServices.GeofencingApi.addGeofences(this.client, this.geofencesToAdd, this.pendingIntent);
                this.geofencesToAdd.clear();
            }
            if (this.geofencesToRemove.size() > 0) {
                LocationServices.GeofencingApi.removeGeofences(this.client, this.geofencesToRemove);
                this.geofencesToRemove.clear();
            }
        }
        GooglePlayServicesListener googlePlayServicesListener = this.googlePlayServicesListener;
        if (googlePlayServicesListener != null) {
            googlePlayServicesListener.onConnected(bundle);
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        this.logger.d("onConnectionSuspended " + i, new Object[0]);
        GooglePlayServicesListener googlePlayServicesListener = this.googlePlayServicesListener;
        if (googlePlayServicesListener != null) {
            googlePlayServicesListener.onConnectionSuspended(i);
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.logger.d("onConnectionFailed", new Object[0]);
        GooglePlayServicesListener googlePlayServicesListener = this.googlePlayServicesListener;
        if (googlePlayServicesListener != null) {
            googlePlayServicesListener.onConnectionFailed(connectionResult);
        }
    }

    /* loaded from: classes.dex */
    public static class GeofencingService extends IntentService {
        public GeofencingService() {
            super(GeofencingService.class.getSimpleName());
        }

        @Override // android.app.IntentService
        protected void onHandleIntent(Intent intent) {
            GeofencingEvent fromIntent = GeofencingEvent.fromIntent(intent);
            if (fromIntent == null || fromIntent.hasError()) {
                return;
            }
            int geofenceTransition = fromIntent.getGeofenceTransition();
            Intent intent2 = new Intent(GeofencingGooglePlayServicesProvider.BROADCAST_INTENT_ACTION);
            intent2.putExtra(GeofencingGooglePlayServicesProvider.TRANSITION_EXTRA_ID, geofenceTransition);
            intent2.putExtra("location", fromIntent.getTriggeringLocation());
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<Geofence> it = fromIntent.getTriggeringGeofences().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getRequestId());
            }
            intent2.putStringArrayListExtra(GeofencingGooglePlayServicesProvider.GEOFENCES_EXTRA_ID, arrayList);
            sendBroadcast(intent2);
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public void onResult(Status status) {
        if (status.isSuccess()) {
            this.logger.d("Geofencing update request successful", new Object[0]);
            return;
        }
        if (status.hasResolution() && (this.context instanceof Activity)) {
            this.logger.w("Unable to register, but we can solve this - will startActivityForResult expecting result code 10003 (if received, please try again)", new Object[0]);
            try {
                status.startResolutionForResult((Activity) this.context, RESULT_CODE);
                return;
            } catch (IntentSender.SendIntentException e) {
                this.logger.e(e, "problem with startResolutionForResult", new Object[0]);
                return;
            }
        }
        this.logger.e("Registering failed: " + status.getStatusMessage(), new Object[0]);
    }
}
