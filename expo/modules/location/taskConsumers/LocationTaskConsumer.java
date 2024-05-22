package expo.modules.location.taskConsumers;

import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.util.Log;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import expo.modules.core.MapHelper;
import expo.modules.core.arguments.MapArguments;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.interfaces.taskManager.TaskConsumer;
import expo.modules.interfaces.taskManager.TaskConsumerInterface;
import expo.modules.interfaces.taskManager.TaskExecutionCallback;
import expo.modules.interfaces.taskManager.TaskInterface;
import expo.modules.interfaces.taskManager.TaskManagerUtilsInterface;
import expo.modules.location.AppForegroundedSingleton;
import expo.modules.location.LocationHelpers;
import expo.modules.location.records.LocationOptions;
import expo.modules.location.records.LocationResponse;
import expo.modules.location.services.LocationTaskService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationTaskConsumer.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001EB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0002J\u0018\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u001eH\u0016J\b\u0010-\u001a\u00020 H\u0016J(\u0010.\u001a\u00020 2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020100j\b\u0012\u0004\u0012\u000201`22\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020 H\u0002J\b\u00106\u001a\u00020 H\u0002J\b\u00107\u001a\u00020 H\u0016J\b\u00108\u001a\u00020 H\u0016J\b\u00109\u001a\u00020 H\u0016J\b\u0010:\u001a\u00020\u001aH\u0002J\u001c\u0010;\u001a\u00020 2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0=H\u0016J\b\u0010@\u001a\u00020\u000fH\u0002J\b\u0010A\u001a\u00020 H\u0002J\b\u0010B\u001a\u00020 H\u0002J\b\u0010C\u001a\u00020 H\u0002J\b\u0010D\u001a\u00020>H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lexpo/modules/location/taskConsumers/LocationTaskConsumer;", "Lexpo/modules/interfaces/taskManager/TaskConsumer;", "Lexpo/modules/interfaces/taskManager/TaskConsumerInterface;", "Lexpo/modules/core/interfaces/LifecycleEventListener;", "context", "Landroid/content/Context;", "taskManagerUtils", "Lexpo/modules/interfaces/taskManager/TaskManagerUtilsInterface;", "(Landroid/content/Context;Lexpo/modules/interfaces/taskManager/TaskManagerUtilsInterface;)V", "mDeferredDistance", "", "mDeferredLocations", "", "Landroid/location/Location;", "mIsHostPaused", "", "mLastReportedLocation", "mLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getMLocationClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "mLocationClient$delegate", "Lkotlin/Lazy;", "mLocationRequest", "Lcom/google/android/gms/location/LocationRequest;", "mPendingIntent", "Landroid/app/PendingIntent;", "mService", "Lexpo/modules/location/services/LocationTaskService;", "mTask", "Lexpo/modules/interfaces/taskManager/TaskInterface;", "deferLocations", "", "locations", "", "didExecuteJob", "jobService", "Landroid/app/job/JobService;", OutcomeEventsTable.COLUMN_NAME_PARAMS, "Landroid/app/job/JobParameters;", "didReceiveBroadcast", "intent", "Landroid/content/Intent;", "didRegister", "task", "didUnregister", "executeTaskWithLocationBundles", "locationBundles", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "callback", "Lexpo/modules/interfaces/taskManager/TaskExecutionCallback;", "maybeReportDeferredLocations", "maybeStartForegroundService", "onHostDestroy", "onHostPause", "onHostResume", "preparePendingIntent", "setOptions", "options", "", "", "", "shouldReportDeferredLocations", "startLocationUpdates", "stopForegroundService", "stopLocationUpdates", "taskType", "Companion", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocationTaskConsumer extends TaskConsumer implements TaskConsumerInterface, LifecycleEventListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String FOREGROUND_SERVICE_KEY = "foregroundService";
    private static final String TAG = "LocationTaskConsumer";
    private static long sLastTimestamp;
    private double mDeferredDistance;
    private final List<Location> mDeferredLocations;
    private boolean mIsHostPaused;
    private Location mLastReportedLocation;

    /* renamed from: mLocationClient$delegate, reason: from kotlin metadata */
    private final Lazy mLocationClient;
    private LocationRequest mLocationRequest;
    private PendingIntent mPendingIntent;
    private LocationTaskService mService;
    private TaskInterface mTask;

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public String taskType() {
        return "location";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationTaskConsumer(final Context context, TaskManagerUtilsInterface taskManagerUtilsInterface) {
        super(context, taskManagerUtilsInterface);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDeferredLocations = new ArrayList();
        this.mIsHostPaused = true;
        this.mLocationClient = LazyKt.lazy(new Function0<FusedLocationProviderClient>() { // from class: expo.modules.location.taskConsumers.LocationTaskConsumer$mLocationClient$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FusedLocationProviderClient invoke() {
                FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
                Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "getFusedLocationProviderClient(context)");
                return fusedLocationProviderClient;
            }
        });
    }

    private final FusedLocationProviderClient getMLocationClient() {
        return (FusedLocationProviderClient) this.mLocationClient.getValue();
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public void didRegister(TaskInterface task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.mTask = task;
        startLocationUpdates();
        maybeStartForegroundService();
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public void didUnregister() {
        stopLocationUpdates();
        stopForegroundService();
        this.mTask = null;
        this.mPendingIntent = null;
        this.mLocationRequest = null;
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumer, expo.modules.interfaces.taskManager.TaskConsumerInterface
    public void setOptions(Map<String, ? extends Object> options) {
        Intrinsics.checkNotNullParameter(options, "options");
        super.setOptions(options);
        stopLocationUpdates();
        startLocationUpdates();
        maybeStartForegroundService();
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumer, expo.modules.interfaces.taskManager.TaskConsumerInterface
    public void didReceiveBroadcast(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (this.mTask == null) {
            return;
        }
        LocationResult extractResult = LocationResult.extractResult(intent);
        if (extractResult != null) {
            List<Location> locations = extractResult.getLocations();
            Intrinsics.checkNotNullExpressionValue(locations, "result.locations");
            deferLocations(locations);
            maybeReportDeferredLocations();
            return;
        }
        try {
            getMLocationClient().getLastLocation().addOnCompleteListener(new OnCompleteListener() { // from class: expo.modules.location.taskConsumers.LocationTaskConsumer$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    LocationTaskConsumer.didReceiveBroadcast$lambda$1(LocationTaskConsumer.this, task);
                }
            });
        } catch (SecurityException e) {
            Log.e(TAG, "Cannot get last location: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void didReceiveBroadcast$lambda$1(LocationTaskConsumer this$0, Task task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(task, "task");
        Location location = (Location) task.getResult();
        if (location != null) {
            this$0.deferLocations(CollectionsKt.listOf(location));
            this$0.maybeReportDeferredLocations();
        }
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumer, expo.modules.interfaces.taskManager.TaskConsumerInterface
    public boolean didExecuteJob(final JobService jobService, final JobParameters params) {
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(params, "params");
        List<PersistableBundle> extractDataFromJobParams = getTaskManagerUtils().extractDataFromJobParams(params);
        ArrayList<Bundle> arrayList = new ArrayList<>();
        for (PersistableBundle persistableBundle : extractDataFromJobParams) {
            Bundle bundle = new Bundle();
            Bundle bundle2 = new Bundle();
            if (persistableBundle != null) {
                bundle2.putAll(persistableBundle.getPersistableBundle("coords"));
                bundle.putAll(persistableBundle);
                bundle.putBundle("coords", bundle2);
                arrayList.add(bundle);
            }
        }
        executeTaskWithLocationBundles(arrayList, new TaskExecutionCallback() { // from class: expo.modules.location.taskConsumers.LocationTaskConsumer$$ExternalSyntheticLambda1
            @Override // expo.modules.interfaces.taskManager.TaskExecutionCallback
            public final void onFinished(Map map) {
                LocationTaskConsumer.didExecuteJob$lambda$2(jobService, params, map);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void didExecuteJob$lambda$2(JobService jobService, JobParameters params, Map map) {
        Intrinsics.checkNotNullParameter(jobService, "$jobService");
        Intrinsics.checkNotNullParameter(params, "$params");
        jobService.jobFinished(params, false);
    }

    private final void startLocationUpdates() {
        Context context = getContext();
        if (context == null) {
            Log.w(TAG, "The context has been abandoned");
            return;
        }
        if (!LocationHelpers.INSTANCE.isAnyProviderAvailable(context)) {
            Log.w(TAG, "There is no location provider available");
            return;
        }
        TaskInterface taskInterface = this.mTask;
        if (taskInterface == null) {
            Log.w(TAG, "Could not find a location task for the location update");
            return;
        }
        LocationHelpers.Companion companion = LocationHelpers.INSTANCE;
        Map<String, Object> options = taskInterface.getOptions();
        Intrinsics.checkNotNullExpressionValue(options, "task.options");
        this.mLocationRequest = companion.prepareLocationRequest$expo_location_release(new LocationOptions(options));
        PendingIntent preparePendingIntent = preparePendingIntent();
        this.mPendingIntent = preparePendingIntent;
        LocationRequest locationRequest = this.mLocationRequest;
        if (locationRequest == null) {
            Log.w(TAG, "Could not find a location request for the location update");
            return;
        }
        if (preparePendingIntent == null) {
            Log.w(TAG, "Could not find intent for the location update");
            return;
        }
        try {
            getMLocationClient().requestLocationUpdates(locationRequest, preparePendingIntent);
        } catch (SecurityException e) {
            Log.w(TAG, "Location request has been rejected.", e);
        }
    }

    private final void stopLocationUpdates() {
        PendingIntent pendingIntent = this.mPendingIntent;
        if (pendingIntent != null) {
            getMLocationClient().removeLocationUpdates(pendingIntent);
            pendingIntent.cancel();
        }
    }

    private final void maybeStartForegroundService() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (!AppForegroundedSingleton.INSTANCE.isForegrounded()) {
            Log.w(TAG, "Foreground location task cannot be started while the app is in the background!");
            return;
        }
        TaskInterface taskInterface = this.mTask;
        if (taskInterface == null) {
            Log.w(TAG, "Location task is null");
            return;
        }
        MapArguments mapArguments = new MapArguments(taskInterface.getOptions());
        Companion companion = INSTANCE;
        Map<String, ? extends Object> options = taskInterface.getOptions();
        Intrinsics.checkNotNullExpressionValue(options, "task.options");
        boolean shouldUseForegroundService = companion.shouldUseForegroundService(options);
        LocationTaskService locationTaskService = this.mService;
        if (locationTaskService != null && !shouldUseForegroundService) {
            stopForegroundService();
            return;
        }
        if (shouldUseForegroundService) {
            if (locationTaskService != null) {
                if (locationTaskService != null) {
                    Bundle bundle = mapArguments.getArguments(FOREGROUND_SERVICE_KEY).toBundle();
                    Intrinsics.checkNotNullExpressionValue(bundle, "options.getArguments(FOR…D_SERVICE_KEY).toBundle()");
                    locationTaskService.startForeground(bundle);
                    return;
                }
                return;
            }
            Intent intent = new Intent(getContext(), (Class<?>) LocationTaskService.class);
            Bundle bundle2 = new Bundle();
            final Bundle bundle3 = mapArguments.getArguments(FOREGROUND_SERVICE_KEY).toBundle();
            bundle2.putString("appId", taskInterface.getAppScopeKey());
            bundle2.putString("taskName", taskInterface.getName());
            bundle2.putBoolean("killService", bundle3.getBoolean("killServiceOnDestroy", false));
            intent.putExtras(bundle2);
            getContext().startForegroundService(intent);
            getContext().bindService(intent, new ServiceConnection() { // from class: expo.modules.location.taskConsumers.LocationTaskConsumer$maybeStartForegroundService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName name, IBinder service) {
                    LocationTaskService locationTaskService2;
                    Context context;
                    Intrinsics.checkNotNullParameter(name, "name");
                    Intrinsics.checkNotNullParameter(service, "service");
                    LocationTaskConsumer locationTaskConsumer = LocationTaskConsumer.this;
                    LocationTaskService.ServiceBinder serviceBinder = service instanceof LocationTaskService.ServiceBinder ? (LocationTaskService.ServiceBinder) service : null;
                    locationTaskConsumer.mService = serviceBinder != null ? serviceBinder.getThis$0() : null;
                    locationTaskService2 = LocationTaskConsumer.this.mService;
                    if (locationTaskService2 != null) {
                        LocationTaskConsumer locationTaskConsumer2 = LocationTaskConsumer.this;
                        Bundle serviceOptions = bundle3;
                        context = locationTaskConsumer2.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        locationTaskService2.setParentContext(context);
                        Intrinsics.checkNotNullExpressionValue(serviceOptions, "serviceOptions");
                        locationTaskService2.startForeground(serviceOptions);
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName name) {
                    LocationTaskService locationTaskService2;
                    Intrinsics.checkNotNullParameter(name, "name");
                    locationTaskService2 = LocationTaskConsumer.this.mService;
                    if (locationTaskService2 != null) {
                        locationTaskService2.stop();
                    }
                    LocationTaskConsumer.this.mService = null;
                }
            }, 1);
        }
    }

    private final void stopForegroundService() {
        LocationTaskService locationTaskService = this.mService;
        if (locationTaskService != null) {
            locationTaskService.stop();
        }
    }

    private final void deferLocations(List<? extends Location> locations) {
        int size = this.mDeferredLocations.size();
        Location location = size > 0 ? this.mDeferredLocations.get(size - 1) : this.mLastReportedLocation;
        for (Location location2 : locations) {
            if (location != null) {
                this.mDeferredDistance += Math.abs(location2.distanceTo(location));
            }
            location = location2;
        }
        this.mDeferredLocations.addAll(locations);
    }

    private final void maybeReportDeferredLocations() {
        if (shouldReportDeferredLocations()) {
            Context applicationContext = getContext().getApplicationContext();
            ArrayList arrayList = new ArrayList();
            for (Location location : this.mDeferredLocations) {
                long time = location.getTime();
                if (time > sLastTimestamp) {
                    arrayList.add((PersistableBundle) new LocationResponse(location).toBundle$expo_location_release(PersistableBundle.class));
                    sLastTimestamp = time;
                }
            }
            if (arrayList.size() > 0) {
                this.mLastReportedLocation = this.mDeferredLocations.get(r2.size() - 1);
                this.mDeferredDistance = 0.0d;
                this.mDeferredLocations.clear();
                getTaskManagerUtils().scheduleJob(applicationContext, this.mTask, arrayList);
            }
        }
    }

    private final boolean shouldReportDeferredLocations() {
        TaskInterface taskInterface = this.mTask;
        if (taskInterface == null || this.mDeferredLocations.size() == 0) {
            return false;
        }
        if (!this.mIsHostPaused) {
            return true;
        }
        Location location = this.mLastReportedLocation;
        if (location == null) {
            location = this.mDeferredLocations.get(0);
        }
        List<Location> list = this.mDeferredLocations;
        Location location2 = list.get(list.size() - 1);
        MapHelper mapHelper = new MapHelper(taskInterface.getOptions());
        return location2.getTime() - location.getTime() >= mapHelper.getLong("deferredUpdatesInterval") && this.mDeferredDistance >= mapHelper.getDouble("deferredUpdatesDistance");
    }

    private final PendingIntent preparePendingIntent() {
        PendingIntent createTaskIntent = getTaskManagerUtils().createTaskIntent(getContext(), this.mTask);
        Intrinsics.checkNotNullExpressionValue(createTaskIntent, "taskManagerUtils.createTaskIntent(context, mTask)");
        return createTaskIntent;
    }

    private final void executeTaskWithLocationBundles(ArrayList<Bundle> locationBundles, TaskExecutionCallback callback) {
        if (locationBundles.size() > 0 && this.mTask != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("locations", locationBundles);
            TaskInterface taskInterface = this.mTask;
            if (taskInterface != null) {
                taskInterface.execute(bundle, null, callback);
                return;
            }
            return;
        }
        callback.onFinished(null);
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostResume() {
        this.mIsHostPaused = false;
        maybeReportDeferredLocations();
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostPause() {
        this.mIsHostPaused = true;
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostDestroy() {
        this.mIsHostPaused = true;
    }

    /* compiled from: LocationTaskConsumer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lexpo/modules/location/taskConsumers/LocationTaskConsumer$Companion;", "", "()V", "FOREGROUND_SERVICE_KEY", "", "TAG", "sLastTimestamp", "", "shouldUseForegroundService", "", "options", "", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean shouldUseForegroundService(Map<String, ? extends Object> options) {
            Intrinsics.checkNotNullParameter(options, "options");
            return options.containsKey(LocationTaskConsumer.FOREGROUND_SERVICE_KEY);
        }
    }
}
