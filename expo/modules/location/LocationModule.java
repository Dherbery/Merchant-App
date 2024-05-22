package expo.modules.location;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import androidx.tracing.Trace;
import com.amazon.a.a.o.b;
import com.canhub.cropper.CropImageOptions;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.onesignal.location.internal.common.LocationConstants;
import expo.modules.core.interfaces.ActivityEventListener;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.interfaces.taskManager.TaskManagerInterface;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.location.LocationHelpers;
import expo.modules.location.records.GeocodeResponse;
import expo.modules.location.records.GeofencingOptions;
import expo.modules.location.records.Heading;
import expo.modules.location.records.HeadingEventResponse;
import expo.modules.location.records.LocationLastKnownOptions;
import expo.modules.location.records.LocationOptions;
import expo.modules.location.records.LocationProviderStatus;
import expo.modules.location.records.LocationResponse;
import expo.modules.location.records.LocationTaskOptions;
import expo.modules.location.records.PermissionRequestResponse;
import expo.modules.location.records.ReverseGeocodeLocation;
import expo.modules.location.records.ReverseGeocodeResponse;
import expo.modules.location.taskConsumers.GeofencingTaskConsumer;
import expo.modules.location.taskConsumers.LocationTaskConsumer;
import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.geocoding.utils.LocationAddress;
import io.nlopez.smartlocation.location.config.LocationParams;
import io.nlopez.smartlocation.location.utils.LocationState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: LocationModule.kt */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u007f2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u007fB\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\"H\u0002J\u0010\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0015H\u0002J\u0010\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0015H\u0002J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020/H\u0002J\u0010\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u001f\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<2\u0006\u0010>\u001a\u00020?H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010@J\u0011\u0010A\u001a\u00020BH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u0018\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0002J\u0011\u0010I\u001a\u00020BH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u0013\u0010J\u001a\u0004\u0018\u00010KH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u001b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010E\u001a\u00020NH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010OJ\b\u0010P\u001a\u00020\rH\u0002J\b\u0010Q\u001a\u00020\rH\u0002J\b\u0010R\u001a\u00020\rH\u0002J\b\u0010S\u001a\u00020\rH\u0002J\u001a\u0010T\u001a\u00020/2\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010W\u001a\u00020\u0007H\u0016J,\u0010X\u001a\u00020/2\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010[\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\b\u0010^\u001a\u00020/H\u0016J\b\u0010_\u001a\u00020/H\u0016J\b\u0010`\u001a\u00020/H\u0016J\u0012\u0010a\u001a\u00020/2\b\u0010b\u001a\u0004\u0018\u00010]H\u0016J\u0012\u0010c\u001a\u00020/2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u0010\u0010f\u001a\u00020/2\u0006\u0010g\u001a\u00020\u0007H\u0002J\u0010\u0010h\u001a\u00020/2\u0006\u0010g\u001a\u00020\u0007H\u0002J\u0011\u0010i\u001a\u00020BH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010CJ%\u0010j\u001a\u00020/2\u0006\u00100\u001a\u00020\u001f2\b\u0010g\u001a\u0004\u0018\u00010\u00072\u0006\u0010k\u001a\u00020l¢\u0006\u0002\u0010mJ\u0010\u0010n\u001a\u00020/2\u0006\u00100\u001a\u00020\u001fH\u0002J\b\u0010o\u001a\u00020/H\u0002J\u001f\u0010p\u001a\b\u0012\u0004\u0012\u00020q0<2\u0006\u0010r\u001a\u00020sH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010tJ\u001d\u0010u\u001a\u00020/2\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020MH\u0000¢\u0006\u0002\bxJ\b\u0010y\u001a\u00020/H\u0002J\b\u0010z\u001a\u00020\rH\u0003J\b\u0010{\u001a\u00020/H\u0002J\b\u0010|\u001a\u00020/H\u0002J\b\u0010}\u001a\u00020/H\u0002J\b\u0010~\u001a\u00020/H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a`\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R*\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u0019j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f`\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0080\u0001"}, d2 = {"Lexpo/modules/location/LocationModule;", "Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/core/interfaces/LifecycleEventListener;", "Landroid/hardware/SensorEventListener;", "Lexpo/modules/core/interfaces/ActivityEventListener;", "()V", "mAccuracy", "", "mActivityProvider", "Lexpo/modules/core/interfaces/ActivityProvider;", "mContext", "Landroid/content/Context;", "mGeocoderPaused", "", "mGeofield", "Landroid/hardware/GeomagneticField;", "mGeomagnetic", "", "mGravity", "mHeadingId", "mLastAzimuth", "", "mLastUpdate", "", "mLocationCallbacks", "Ljava/util/HashMap;", "Lcom/google/android/gms/location/LocationCallback;", "Lkotlin/collections/HashMap;", "mLocationProvider", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "mLocationRequests", "Lcom/google/android/gms/location/LocationRequest;", "mPendingLocationRequests", "Ljava/util/ArrayList;", "Lexpo/modules/location/LocationActivityResultListener;", "Lkotlin/collections/ArrayList;", "mSensorManager", "Landroid/hardware/SensorManager;", "mTaskManager", "Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "getMTaskManager", "()Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "mTaskManager$delegate", "Lkotlin/Lazy;", "mUIManager", "Lexpo/modules/core/interfaces/services/UIManager;", "addPendingLocationRequest", "", "locationRequest", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "calcMagNorth", "azimuth", "calcTrueNorth", "magNorth", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "destroyHeadingWatch", "executePendingRequests", "resultCode", "geocode", "", "Lexpo/modules/location/records/GeocodeResponse;", "address", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBackgroundPermissionsAsync", "Lexpo/modules/location/records/PermissionRequestResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentPositionAsync", "options", "Lexpo/modules/location/records/LocationOptions;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "getForegroundPermissionsAsync", "getLastKnownLocation", "Landroid/location/Location;", "getLastKnownPositionAsync", "Lexpo/modules/location/records/LocationResponse;", "Lexpo/modules/location/records/LocationLastKnownOptions;", "(Lexpo/modules/location/records/LocationLastKnownOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasForegroundServicePermissions", "isBackgroundPermissionInManifest", "isMissingBackgroundPermissions", "isMissingForegroundPermissions", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", "accuracy", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "data", "Landroid/content/Intent;", "onHostDestroy", "onHostPause", "onHostResume", "onNewIntent", "intent", "onSensorChanged", NotificationCompat.CATEGORY_EVENT, "Landroid/hardware/SensorEvent;", "pauseLocationUpdatesForRequest", b.B, "removeLocationUpdatesForRequest", "requestBackgroundPermissionsAsync", "requestLocationUpdates", "callbacks", "Lexpo/modules/location/LocationRequestCallbacks;", "(Lcom/google/android/gms/location/LocationRequest;Ljava/lang/Integer;Lexpo/modules/location/LocationRequestCallbacks;)V", "resolveUserSettingsForRequest", "resumeLocationUpdates", "reverseGeocode", "Lexpo/modules/location/records/ReverseGeocodeResponse;", "location", "Lexpo/modules/location/records/ReverseGeocodeLocation;", "(Lexpo/modules/location/records/ReverseGeocodeLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendLocationResponse", "watchId", "response", "sendLocationResponse$expo_location_release", "sendUpdate", "shouldAskBackgroundPermissions", "startHeadingUpdate", "startWatching", "stopHeadingWatch", "stopWatching", "Companion", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocationModule extends Module implements LifecycleEventListener, SensorEventListener, ActivityEventListener {
    public static final int ACCURACY_BALANCED = 3;
    public static final int ACCURACY_BEST_FOR_NAVIGATION = 6;
    public static final int ACCURACY_HIGH = 4;
    public static final int ACCURACY_HIGHEST = 5;
    public static final int ACCURACY_LOW = 2;
    public static final int ACCURACY_LOWEST = 1;
    private static final int CHECK_SETTINGS_REQUEST_CODE = 42;
    public static final double DEGREE_DELTA = 0.0355d;
    public static final int GEOFENCING_EVENT_ENTER = 1;
    public static final int GEOFENCING_EVENT_EXIT = 2;
    private static final String HEADING_EVENT_NAME = "Expo.headingChanged";
    private static final String LOCATION_EVENT_NAME = "Expo.locationChanged";
    public static final float TIME_DELTA = 50.0f;
    private int mAccuracy;
    private ActivityProvider mActivityProvider;
    private Context mContext;
    private boolean mGeocoderPaused;
    private GeomagneticField mGeofield;
    private int mHeadingId;
    private float mLastAzimuth;
    private long mLastUpdate;
    private FusedLocationProviderClient mLocationProvider;
    private SensorManager mSensorManager;
    private UIManager mUIManager;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "LocationModule";
    private final HashMap<Integer, LocationCallback> mLocationCallbacks = new HashMap<>();
    private final HashMap<Integer, LocationRequest> mLocationRequests = new HashMap<>();
    private ArrayList<LocationActivityResultListener> mPendingLocationRequests = new ArrayList<>();
    private float[] mGravity = new float[9];
    private float[] mGeomagnetic = new float[9];

    /* renamed from: mTaskManager$delegate, reason: from kotlin metadata */
    private final Lazy mTaskManager = LazyKt.lazy(new Function0<TaskManagerInterface>() { // from class: expo.modules.location.LocationModule$mTaskManager$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TaskManagerInterface invoke() {
            Object obj;
            try {
                obj = LocationModule.this.getAppContext().getLegacyModuleRegistry().getModule(TaskManagerInterface.class);
            } catch (Exception unused) {
                obj = null;
            }
            TaskManagerInterface taskManagerInterface = (TaskManagerInterface) obj;
            if (taskManagerInterface != null) {
                return taskManagerInterface;
            }
            throw new TaskManagerNotFoundException();
        }
    });

    @Override // expo.modules.core.interfaces.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TaskManagerInterface getMTaskManager() {
        return (TaskManagerInterface) this.mTaskManager.getValue();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        LocationModule locationModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (locationModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(locationModule);
            moduleDefinitionBuilder.Name("ExpoLocation");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$OnCreate$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Object obj;
                    Object obj2;
                    Context context;
                    Context context2;
                    LocationModule locationModule2 = LocationModule.this;
                    Context reactContext = locationModule2.getAppContext().getReactContext();
                    if (reactContext != null) {
                        locationModule2.mContext = reactContext;
                        LocationModule locationModule3 = LocationModule.this;
                        try {
                            obj = locationModule3.getAppContext().getLegacyModuleRegistry().getModule(UIManager.class);
                        } catch (Exception unused) {
                            obj = null;
                        }
                        UIManager uIManager = (UIManager) obj;
                        if (uIManager != null) {
                            locationModule3.mUIManager = uIManager;
                            LocationModule locationModule4 = LocationModule.this;
                            try {
                                obj2 = locationModule4.getAppContext().getLegacyModuleRegistry().getModule(ActivityProvider.class);
                            } catch (Exception unused2) {
                                obj2 = null;
                            }
                            ActivityProvider activityProvider = (ActivityProvider) obj2;
                            if (activityProvider != null) {
                                locationModule4.mActivityProvider = activityProvider;
                                LocationModule locationModule5 = LocationModule.this;
                                context = locationModule5.mContext;
                                if (context == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                                    context = null;
                                }
                                FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
                                Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "getFusedLocationProviderClient(mContext)");
                                locationModule5.mLocationProvider = fusedLocationProviderClient;
                                LocationModule locationModule6 = LocationModule.this;
                                context2 = locationModule6.mContext;
                                if (context2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                                    context2 = null;
                                }
                                Object systemService = context2.getSystemService("sensor");
                                SensorManager sensorManager = systemService instanceof SensorManager ? (SensorManager) systemService : null;
                                if (sensorManager != null) {
                                    locationModule6.mSensorManager = sensorManager;
                                    return;
                                }
                                throw new SensorManagerUnavailable();
                            }
                            throw new MissingActivityManagerException();
                        }
                        throw new MissingUIManagerException();
                    }
                    throw new Exceptions.ReactContextLost();
                }
            }));
            moduleDefinitionBuilder.Events(HEADING_EVENT_NAME, LOCATION_EVENT_NAME);
            AsyncFunctionBuilder AsyncFunction = moduleDefinitionBuilder.AsyncFunction("requestPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(AsyncFunction.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$1(null, this));
            AsyncFunction.setAsyncFunctionComponent(suspendFunctionComponent);
            SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
            AsyncFunctionBuilder AsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("getPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent3 = new SuspendFunctionComponent(AsyncFunction2.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$2(null, this));
            AsyncFunction2.setAsyncFunctionComponent(suspendFunctionComponent3);
            SuspendFunctionComponent suspendFunctionComponent4 = suspendFunctionComponent3;
            AsyncFunctionBuilder AsyncFunction3 = moduleDefinitionBuilder.AsyncFunction("requestForegroundPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent5 = new SuspendFunctionComponent(AsyncFunction3.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$3(null, this));
            AsyncFunction3.setAsyncFunctionComponent(suspendFunctionComponent5);
            SuspendFunctionComponent suspendFunctionComponent6 = suspendFunctionComponent5;
            AsyncFunctionBuilder AsyncFunction4 = moduleDefinitionBuilder.AsyncFunction("requestBackgroundPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent7 = new SuspendFunctionComponent(AsyncFunction4.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$4(null, this));
            AsyncFunction4.setAsyncFunctionComponent(suspendFunctionComponent7);
            SuspendFunctionComponent suspendFunctionComponent8 = suspendFunctionComponent7;
            AsyncFunctionBuilder AsyncFunction5 = moduleDefinitionBuilder.AsyncFunction("getForegroundPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent9 = new SuspendFunctionComponent(AsyncFunction5.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$5(null, this));
            AsyncFunction5.setAsyncFunctionComponent(suspendFunctionComponent9);
            SuspendFunctionComponent suspendFunctionComponent10 = suspendFunctionComponent9;
            AsyncFunctionBuilder AsyncFunction6 = moduleDefinitionBuilder.AsyncFunction("getBackgroundPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent11 = new SuspendFunctionComponent(AsyncFunction6.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$6(null, this));
            AsyncFunction6.setAsyncFunctionComponent(suspendFunctionComponent11);
            SuspendFunctionComponent suspendFunctionComponent12 = suspendFunctionComponent11;
            AsyncFunctionBuilder AsyncFunction7 = moduleDefinitionBuilder.AsyncFunction("getLastKnownPositionAsync");
            AsyncFunction7.setAsyncFunctionComponent(new SuspendFunctionComponent(AsyncFunction7.getName(), new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(LocationLastKnownOptions.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$Coroutine$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(LocationLastKnownOptions.class);
                }
            }))}, new LocationModule$definition$lambda$27$$inlined$Coroutine$8(null, this)));
            moduleDefinitionBuilder.getAsyncFunctions().put("getCurrentPositionAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getCurrentPositionAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(LocationOptions.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(LocationOptions.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$2
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.location.records.LocationOptions");
                    }
                    LocationModule.this.getCurrentPositionAsync((LocationOptions) obj, promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getCurrentPositionAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(LocationOptions.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(LocationOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.location.records.LocationOptions");
                    }
                    LocationOptions locationOptions = (LocationOptions) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    LocationModule.this.getCurrentPositionAsync(locationOptions, (Promise) obj2);
                    return Unit.INSTANCE;
                }
            }));
            AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("getProviderStatusAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Context context;
                    Intrinsics.checkNotNullParameter(it, "it");
                    context = LocationModule.this.mContext;
                    if (context == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        context = null;
                    }
                    LocationState state = SmartLocation.with(context).location().state();
                    LocationProviderStatus locationProviderStatus = new LocationProviderStatus(null, null, null, false, null, 31, null);
                    locationProviderStatus.setBackgroundModeEnabled(Boolean.valueOf(state.locationServicesEnabled()));
                    locationProviderStatus.setGpsAvailable(Boolean.valueOf(state.isGpsAvailable()));
                    locationProviderStatus.setNetworkAvailable(Boolean.valueOf(state.isNetworkAvailable()));
                    locationProviderStatus.setLocationServicesEnabled(state.locationServicesEnabled());
                    locationProviderStatus.setPassiveAvailable(Boolean.valueOf(state.isPassiveAvailable()));
                    return locationProviderStatus;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getProviderStatusAsync", asyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionComponent;
            moduleDefinitionBuilder.getAsyncFunctions().put("watchDeviceHeading", Integer.class == Promise.class ? new AsyncFunctionWithPromiseComponent("watchDeviceHeading", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$6
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    LocationModule.this.mHeadingId = ((Integer) promise).intValue();
                    LocationModule.this.startHeadingUpdate();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("watchDeviceHeading", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$8
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        LocationModule.this.mHeadingId = ((Integer) obj).intValue();
                        LocationModule.this.startHeadingUpdate();
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("watchPositionImplAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("watchPositionImplAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(LocationOptions.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(LocationOptions.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$11
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    boolean isMissingForegroundPermissions;
                    Context context;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    Object obj2 = args[1];
                    if (obj2 != null) {
                        LocationOptions locationOptions = (LocationOptions) obj2;
                        int intValue = num.intValue();
                        isMissingForegroundPermissions = LocationModule.this.isMissingForegroundPermissions();
                        if (isMissingForegroundPermissions) {
                            promise.reject(new LocationUnauthorizedException());
                            return;
                        }
                        LocationRequest prepareLocationRequest$expo_location_release = LocationHelpers.INSTANCE.prepareLocationRequest$expo_location_release(locationOptions);
                        boolean mayShowUserSettingsDialog = locationOptions.getMayShowUserSettingsDialog();
                        LocationHelpers.Companion companion = LocationHelpers.INSTANCE;
                        context = LocationModule.this.mContext;
                        if (context == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mContext");
                            context = null;
                        }
                        if (companion.hasNetworkProviderEnabled(context) || !mayShowUserSettingsDialog) {
                            LocationHelpers.INSTANCE.requestContinuousUpdates(LocationModule.this, prepareLocationRequest$expo_location_release, intValue, promise);
                            return;
                        } else {
                            LocationModule locationModule2 = LocationModule.this;
                            locationModule2.addPendingLocationRequest(prepareLocationRequest$expo_location_release, new LocationModule$definition$1$12$1(locationModule2, prepareLocationRequest$expo_location_release, intValue, promise));
                            return;
                        }
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.location.records.LocationOptions");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("watchPositionImplAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(LocationOptions.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(LocationOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$15
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    boolean isMissingForegroundPermissions;
                    Context context;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.location.records.LocationOptions");
                    }
                    LocationOptions locationOptions = (LocationOptions) obj2;
                    Object obj3 = it[2];
                    if (obj3 != null) {
                        Promise promise = (Promise) obj3;
                        int intValue = num.intValue();
                        isMissingForegroundPermissions = LocationModule.this.isMissingForegroundPermissions();
                        if (isMissingForegroundPermissions) {
                            promise.reject(new LocationUnauthorizedException());
                        } else {
                            LocationRequest prepareLocationRequest$expo_location_release = LocationHelpers.INSTANCE.prepareLocationRequest$expo_location_release(locationOptions);
                            boolean mayShowUserSettingsDialog = locationOptions.getMayShowUserSettingsDialog();
                            LocationHelpers.Companion companion = LocationHelpers.INSTANCE;
                            context = LocationModule.this.mContext;
                            if (context == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                                context = null;
                            }
                            if (companion.hasNetworkProviderEnabled(context) || !mayShowUserSettingsDialog) {
                                LocationHelpers.INSTANCE.requestContinuousUpdates(LocationModule.this, prepareLocationRequest$expo_location_release, intValue, promise);
                            } else {
                                LocationModule locationModule2 = LocationModule.this;
                                locationModule2.addPendingLocationRequest(prepareLocationRequest$expo_location_release, new LocationModule$definition$1$12$1(locationModule2, prepareLocationRequest$expo_location_release, intValue, promise));
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("removeWatchAsync", Integer.class == Promise.class ? new AsyncFunctionWithPromiseComponent("removeWatchAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$16
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    boolean isMissingForegroundPermissions;
                    int i;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    int intValue = ((Integer) promise).intValue();
                    isMissingForegroundPermissions = LocationModule.this.isMissingForegroundPermissions();
                    if (!isMissingForegroundPermissions) {
                        i = LocationModule.this.mHeadingId;
                        if (intValue == i) {
                            LocationModule.this.destroyHeadingWatch();
                            return;
                        } else {
                            LocationModule.this.removeLocationUpdatesForRequest(intValue);
                            return;
                        }
                    }
                    throw new LocationUnauthorizedException();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("removeWatchAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$18
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    boolean isMissingForegroundPermissions;
                    int i;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        int intValue = ((Integer) obj).intValue();
                        isMissingForegroundPermissions = LocationModule.this.isMissingForegroundPermissions();
                        if (!isMissingForegroundPermissions) {
                            i = LocationModule.this.mHeadingId;
                            if (intValue == i) {
                                LocationModule.this.destroyHeadingWatch();
                            } else {
                                LocationModule.this.removeLocationUpdatesForRequest(intValue);
                            }
                            return Unit.INSTANCE;
                        }
                        throw new LocationUnauthorizedException();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            }));
            AsyncFunctionBuilder AsyncFunction8 = moduleDefinitionBuilder.AsyncFunction("geocodeAsync");
            AsyncFunction8.setAsyncFunctionComponent(new SuspendFunctionComponent(AsyncFunction8.getName(), new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$Coroutine$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new LocationModule$definition$lambda$27$$inlined$Coroutine$10(null, this)));
            AsyncFunctionBuilder AsyncFunction9 = moduleDefinitionBuilder.AsyncFunction("reverseGeocodeAsync");
            AsyncFunction9.setAsyncFunctionComponent(new SuspendFunctionComponent(AsyncFunction9.getName(), new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReverseGeocodeLocation.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$Coroutine$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReverseGeocodeLocation.class);
                }
            }))}, new LocationModule$definition$lambda$27$$inlined$Coroutine$12(null, this)));
            AsyncFunctionBuilder AsyncFunction10 = moduleDefinitionBuilder.AsyncFunction("enableNetworkProviderAsync");
            SuspendFunctionComponent suspendFunctionComponent13 = new SuspendFunctionComponent(AsyncFunction10.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$13(null, this));
            AsyncFunction10.setAsyncFunctionComponent(suspendFunctionComponent13);
            SuspendFunctionComponent suspendFunctionComponent14 = suspendFunctionComponent13;
            AsyncFunctionComponent asyncFunctionComponent3 = new AsyncFunctionComponent("hasServicesEnabledAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunctionWithoutArgs$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Context context;
                    Intrinsics.checkNotNullParameter(it, "it");
                    LocationHelpers.Companion companion = LocationHelpers.INSTANCE;
                    context = LocationModule.this.mContext;
                    if (context == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        context = null;
                    }
                    return Boolean.valueOf(companion.isAnyProviderAvailable(context));
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("hasServicesEnabledAsync", asyncFunctionComponent3);
            AsyncFunctionComponent asyncFunctionComponent4 = asyncFunctionComponent3;
            moduleDefinitionBuilder.getAsyncFunctions().put("startLocationUpdatesAsync", LocationTaskOptions.class == Promise.class ? new AsyncFunctionWithPromiseComponent("startLocationUpdatesAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$20
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    boolean isMissingForegroundPermissions;
                    boolean hasForegroundServicePermissions;
                    TaskManagerInterface mTaskManager;
                    boolean isMissingBackgroundPermissions;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    LocationTaskOptions locationTaskOptions = (LocationTaskOptions) promise;
                    boolean z = locationTaskOptions.getForegroundService() != null;
                    isMissingForegroundPermissions = LocationModule.this.isMissingForegroundPermissions();
                    if (isMissingForegroundPermissions) {
                        throw new LocationBackgroundUnauthorizedException();
                    }
                    if (!z) {
                        isMissingBackgroundPermissions = LocationModule.this.isMissingBackgroundPermissions();
                        if (isMissingBackgroundPermissions) {
                            throw new LocationBackgroundUnauthorizedException();
                        }
                    }
                    if (AppForegroundedSingleton.INSTANCE.isForegrounded() || locationTaskOptions.getForegroundService() == null) {
                        hasForegroundServicePermissions = LocationModule.this.hasForegroundServicePermissions();
                        if (hasForegroundServicePermissions) {
                            mTaskManager = LocationModule.this.getMTaskManager();
                            mTaskManager.registerTask(str, LocationTaskConsumer.class, locationTaskOptions.toMutableMap$expo_location_release());
                            return;
                        }
                        throw new ForegroundServicePermissionsException();
                    }
                    throw new ForegroundServiceStartNotAllowedException();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("startLocationUpdatesAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(LocationTaskOptions.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(LocationTaskOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$23
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    boolean isMissingForegroundPermissions;
                    boolean hasForegroundServicePermissions;
                    TaskManagerInterface mTaskManager;
                    boolean isMissingBackgroundPermissions;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.location.records.LocationTaskOptions");
                    }
                    LocationTaskOptions locationTaskOptions = (LocationTaskOptions) obj2;
                    boolean z = locationTaskOptions.getForegroundService() != null;
                    isMissingForegroundPermissions = LocationModule.this.isMissingForegroundPermissions();
                    if (isMissingForegroundPermissions) {
                        throw new LocationBackgroundUnauthorizedException();
                    }
                    if (!z) {
                        isMissingBackgroundPermissions = LocationModule.this.isMissingBackgroundPermissions();
                        if (isMissingBackgroundPermissions) {
                            throw new LocationBackgroundUnauthorizedException();
                        }
                    }
                    if (AppForegroundedSingleton.INSTANCE.isForegrounded() || locationTaskOptions.getForegroundService() == null) {
                        hasForegroundServicePermissions = LocationModule.this.hasForegroundServicePermissions();
                        if (hasForegroundServicePermissions) {
                            mTaskManager = LocationModule.this.getMTaskManager();
                            mTaskManager.registerTask(str, LocationTaskConsumer.class, locationTaskOptions.toMutableMap$expo_location_release());
                            return Unit.INSTANCE;
                        }
                        throw new ForegroundServicePermissionsException();
                    }
                    throw new ForegroundServiceStartNotAllowedException();
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("stopLocationUpdatesAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("stopLocationUpdatesAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$24
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    TaskManagerInterface mTaskManager;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    mTaskManager = LocationModule.this.getMTaskManager();
                    mTaskManager.unregisterTask((String) promise, LocationTaskConsumer.class);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("stopLocationUpdatesAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$25
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$26
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    TaskManagerInterface mTaskManager;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        mTaskManager = LocationModule.this.getMTaskManager();
                        mTaskManager.unregisterTask((String) obj, LocationTaskConsumer.class);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("hasStartedLocationUpdatesAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("hasStartedLocationUpdatesAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$27
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    TaskManagerInterface mTaskManager;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    mTaskManager = LocationModule.this.getMTaskManager();
                    mTaskManager.taskHasConsumerOfClass((String) promise, LocationTaskConsumer.class);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("hasStartedLocationUpdatesAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$28
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$29
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    TaskManagerInterface mTaskManager;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        mTaskManager = LocationModule.this.getMTaskManager();
                        return Boolean.valueOf(mTaskManager.taskHasConsumerOfClass((String) obj, LocationTaskConsumer.class));
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("startGeofencingAsync", GeofencingOptions.class == Promise.class ? new AsyncFunctionWithPromiseComponent("startGeofencingAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$31
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    boolean isMissingBackgroundPermissions;
                    TaskManagerInterface mTaskManager;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        String str = (String) obj;
                        GeofencingOptions geofencingOptions = (GeofencingOptions) promise;
                        isMissingBackgroundPermissions = LocationModule.this.isMissingBackgroundPermissions();
                        if (!isMissingBackgroundPermissions) {
                            mTaskManager = LocationModule.this.getMTaskManager();
                            mTaskManager.registerTask(str, GeofencingTaskConsumer.class, geofencingOptions.toMap$expo_location_release());
                            return;
                        }
                        throw new LocationBackgroundUnauthorizedException();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("startGeofencingAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$32
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(GeofencingOptions.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$33
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(GeofencingOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$34
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    boolean isMissingBackgroundPermissions;
                    TaskManagerInterface mTaskManager;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        GeofencingOptions geofencingOptions = (GeofencingOptions) obj2;
                        isMissingBackgroundPermissions = LocationModule.this.isMissingBackgroundPermissions();
                        if (!isMissingBackgroundPermissions) {
                            mTaskManager = LocationModule.this.getMTaskManager();
                            mTaskManager.registerTask(str, GeofencingTaskConsumer.class, geofencingOptions.toMap$expo_location_release());
                            return Unit.INSTANCE;
                        }
                        throw new LocationBackgroundUnauthorizedException();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.location.records.GeofencingOptions");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("hasStartedGeofencingAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("hasStartedGeofencingAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$35
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    boolean isMissingBackgroundPermissions;
                    TaskManagerInterface mTaskManager;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) promise;
                    isMissingBackgroundPermissions = LocationModule.this.isMissingBackgroundPermissions();
                    if (!isMissingBackgroundPermissions) {
                        mTaskManager = LocationModule.this.getMTaskManager();
                        mTaskManager.taskHasConsumerOfClass(str, GeofencingTaskConsumer.class);
                        return;
                    }
                    throw new LocationBackgroundUnauthorizedException();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("hasStartedGeofencingAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$37
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    boolean isMissingBackgroundPermissions;
                    TaskManagerInterface mTaskManager;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        String str = (String) obj;
                        isMissingBackgroundPermissions = LocationModule.this.isMissingBackgroundPermissions();
                        if (!isMissingBackgroundPermissions) {
                            mTaskManager = LocationModule.this.getMTaskManager();
                            return Boolean.valueOf(mTaskManager.taskHasConsumerOfClass(str, GeofencingTaskConsumer.class));
                        }
                        throw new LocationBackgroundUnauthorizedException();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("stopGeofencingAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("stopGeofencingAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$38
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    boolean isMissingBackgroundPermissions;
                    TaskManagerInterface mTaskManager;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) promise;
                    isMissingBackgroundPermissions = LocationModule.this.isMissingBackgroundPermissions();
                    if (!isMissingBackgroundPermissions) {
                        mTaskManager = LocationModule.this.getMTaskManager();
                        mTaskManager.unregisterTask(str, GeofencingTaskConsumer.class);
                        return;
                    }
                    throw new LocationBackgroundUnauthorizedException();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("stopGeofencingAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$39
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$40
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    boolean isMissingBackgroundPermissions;
                    TaskManagerInterface mTaskManager;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        String str = (String) obj;
                        isMissingBackgroundPermissions = LocationModule.this.isMissingBackgroundPermissions();
                        if (!isMissingBackgroundPermissions) {
                            mTaskManager = LocationModule.this.getMTaskManager();
                            mTaskManager.unregisterTask(str, GeofencingTaskConsumer.class);
                            return Unit.INSTANCE;
                        }
                        throw new LocationBackgroundUnauthorizedException();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_FOREGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_FOREGROUND, new Function0<Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$OnActivityEntersForeground$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AppForegroundedSingleton.INSTANCE.setForegrounded(true);
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_BACKGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_BACKGROUND, new Function0<Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$OnActivityEntersBackground$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AppForegroundedSingleton.INSTANCE.setForegrounded(false);
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getForegroundPermissionsAsync(kotlin.coroutines.Continuation<? super expo.modules.location.records.PermissionRequestResponse> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof expo.modules.location.LocationModule$getForegroundPermissionsAsync$1
            if (r0 == 0) goto L14
            r0 = r8
            expo.modules.location.LocationModule$getForegroundPermissionsAsync$1 r0 = (expo.modules.location.LocationModule$getForegroundPermissionsAsync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            expo.modules.location.LocationModule$getForegroundPermissionsAsync$1 r0 = new expo.modules.location.LocationModule$getForegroundPermissionsAsync$1
            r0.<init>(r7, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r0 = r0.L$0
            expo.modules.location.records.PermissionRequestResponse r0 = (expo.modules.location.records.PermissionRequestResponse) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L79
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L39:
            java.lang.Object r2 = r0.L$0
            expo.modules.interfaces.permissions.Permissions r2 = (expo.modules.interfaces.permissions.Permissions) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L61
        L41:
            kotlin.ResultKt.throwOnFailure(r8)
            expo.modules.kotlin.AppContext r8 = r7.getAppContext()
            expo.modules.interfaces.permissions.Permissions r2 = r8.getPermissions()
            if (r2 == 0) goto L97
            expo.modules.location.LocationHelpers$Companion r8 = expo.modules.location.LocationHelpers.INSTANCE
            java.lang.String r5 = "android.permission.ACCESS_COARSE_LOCATION"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r8 = r8.getPermissionsWithPermissionsManager$expo_location_release(r2, r5, r0)
            if (r8 != r1) goto L61
            return r1
        L61:
            expo.modules.location.records.PermissionRequestResponse r8 = (expo.modules.location.records.PermissionRequestResponse) r8
            expo.modules.location.LocationHelpers$Companion r4 = expo.modules.location.LocationHelpers.INSTANCE
            java.lang.String r5 = "android.permission.ACCESS_FINE_LOCATION"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r0 = r4.getPermissionsWithPermissionsManager$expo_location_release(r2, r5, r0)
            if (r0 != r1) goto L76
            return r1
        L76:
            r6 = r0
            r0 = r8
            r8 = r6
        L79:
            expo.modules.location.records.PermissionRequestResponse r8 = (expo.modules.location.records.PermissionRequestResponse) r8
            boolean r1 = r0.getGranted()
            if (r1 == 0) goto L84
            java.lang.String r1 = "coarse"
            goto L86
        L84:
            java.lang.String r1 = "none"
        L86:
            boolean r8 = r8.getGranted()
            if (r8 == 0) goto L8e
            java.lang.String r1 = "fine"
        L8e:
            expo.modules.location.records.PermissionDetailsLocationAndroid r8 = new expo.modules.location.records.PermissionDetailsLocationAndroid
            r8.<init>(r1, r1)
            r0.setAndroid(r8)
            return r0
        L97:
            expo.modules.location.NoPermissionsModuleException r8 = new expo.modules.location.NoPermissionsModuleException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.LocationModule.getForegroundPermissionsAsync(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object requestBackgroundPermissionsAsync(kotlin.coroutines.Continuation<? super expo.modules.location.records.PermissionRequestResponse> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof expo.modules.location.LocationModule$requestBackgroundPermissionsAsync$1
            if (r0 == 0) goto L14
            r0 = r6
            expo.modules.location.LocationModule$requestBackgroundPermissionsAsync$1 r0 = (expo.modules.location.LocationModule$requestBackgroundPermissionsAsync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            expo.modules.location.LocationModule$requestBackgroundPermissionsAsync$1 r0 = new expo.modules.location.LocationModule$requestBackgroundPermissionsAsync$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L6d
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L51
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.isBackgroundPermissionInManifest()
            if (r6 == 0) goto L7b
            boolean r6 = r5.shouldAskBackgroundPermissions()
            if (r6 != 0) goto L52
            r0.label = r4
            java.lang.Object r6 = r5.getForegroundPermissionsAsync(r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            return r6
        L52:
            expo.modules.kotlin.AppContext r6 = r5.getAppContext()
            expo.modules.interfaces.permissions.Permissions r6 = r6.getPermissions()
            if (r6 == 0) goto L75
            expo.modules.location.LocationHelpers$Companion r2 = expo.modules.location.LocationHelpers.INSTANCE
            java.lang.String r4 = "android.permission.ACCESS_BACKGROUND_LOCATION"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r0.label = r3
            java.lang.Object r6 = r2.askForPermissionsWithPermissionsManager$expo_location_release(r6, r4, r0)
            if (r6 != r1) goto L6d
            return r1
        L6d:
            android.os.Bundle r6 = (android.os.Bundle) r6
            expo.modules.location.records.PermissionRequestResponse r0 = new expo.modules.location.records.PermissionRequestResponse
            r0.<init>(r6)
            return r0
        L75:
            expo.modules.location.NoPermissionsModuleException r6 = new expo.modules.location.NoPermissionsModuleException
            r6.<init>()
            throw r6
        L7b:
            expo.modules.location.NoPermissionInManifestException r6 = new expo.modules.location.NoPermissionInManifestException
            java.lang.String r0 = "ACCESS_BACKGROUND_LOCATION"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.LocationModule.requestBackgroundPermissionsAsync(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getBackgroundPermissionsAsync(Continuation<? super PermissionRequestResponse> continuation) {
        if (!isBackgroundPermissionInManifest()) {
            throw new NoPermissionInManifestException("ACCESS_BACKGROUND_LOCATION");
        }
        if (!shouldAskBackgroundPermissions()) {
            return getForegroundPermissionsAsync(continuation);
        }
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return LocationHelpers.INSTANCE.getPermissionsWithPermissionsManager$expo_location_release(permissions, new String[]{LocationConstants.ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING}, continuation);
        }
        throw new NoPermissionsModuleException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getLastKnownPositionAsync(expo.modules.location.records.LocationLastKnownOptions r5, kotlin.coroutines.Continuation<? super expo.modules.location.records.LocationResponse> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof expo.modules.location.LocationModule$getLastKnownPositionAsync$1
            if (r0 == 0) goto L14
            r0 = r6
            expo.modules.location.LocationModule$getLastKnownPositionAsync$1 r0 = (expo.modules.location.LocationModule$getLastKnownPositionAsync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            expo.modules.location.LocationModule$getLastKnownPositionAsync$1 r0 = new expo.modules.location.LocationModule$getLastKnownPositionAsync$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            expo.modules.location.records.LocationLastKnownOptions r5 = (expo.modules.location.records.LocationLastKnownOptions) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4a
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r4.isMissingForegroundPermissions()
            if (r6 != 0) goto L5f
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.getLastKnownLocation(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            android.location.Location r6 = (android.location.Location) r6
            r0 = 0
            if (r6 != 0) goto L50
            return r0
        L50:
            expo.modules.location.LocationHelpers$Companion r1 = expo.modules.location.LocationHelpers.INSTANCE
            boolean r5 = r1.isLocationValid$expo_location_release(r6, r5)
            if (r5 == 0) goto L5e
            expo.modules.location.records.LocationResponse r5 = new expo.modules.location.records.LocationResponse
            r5.<init>(r6)
            return r5
        L5e:
            return r0
        L5f:
            expo.modules.location.LocationUnauthorizedException r5 = new expo.modules.location.LocationUnauthorizedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.LocationModule.getLastKnownPositionAsync(expo.modules.location.records.LocationLastKnownOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCurrentPositionAsync(LocationOptions options, final Promise promise) {
        LocationRequest prepareLocationRequest$expo_location_release = LocationHelpers.INSTANCE.prepareLocationRequest$expo_location_release(options);
        final CurrentLocationRequest prepareCurrentLocationRequest$expo_location_release = LocationHelpers.INSTANCE.prepareCurrentLocationRequest$expo_location_release(options);
        boolean mayShowUserSettingsDialog = options.getMayShowUserSettingsDialog();
        if (isMissingForegroundPermissions()) {
            promise.reject(new LocationUnauthorizedException());
            return;
        }
        LocationHelpers.Companion companion = LocationHelpers.INSTANCE;
        Context context = this.mContext;
        FusedLocationProviderClient fusedLocationProviderClient = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        if (companion.hasNetworkProviderEnabled(context) || !mayShowUserSettingsDialog) {
            LocationHelpers.Companion companion2 = LocationHelpers.INSTANCE;
            FusedLocationProviderClient fusedLocationProviderClient2 = this.mLocationProvider;
            if (fusedLocationProviderClient2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
            } else {
                fusedLocationProviderClient = fusedLocationProviderClient2;
            }
            companion2.requestSingleLocation(fusedLocationProviderClient, prepareCurrentLocationRequest$expo_location_release, promise);
            return;
        }
        addPendingLocationRequest(prepareLocationRequest$expo_location_release, new LocationActivityResultListener() { // from class: expo.modules.location.LocationModule$getCurrentPositionAsync$1
            @Override // expo.modules.location.LocationActivityResultListener
            public void onResult(int resultCode) {
                FusedLocationProviderClient fusedLocationProviderClient3;
                if (resultCode == -1) {
                    LocationHelpers.Companion companion3 = LocationHelpers.INSTANCE;
                    fusedLocationProviderClient3 = LocationModule.this.mLocationProvider;
                    if (fusedLocationProviderClient3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
                        fusedLocationProviderClient3 = null;
                    }
                    companion3.requestSingleLocation(fusedLocationProviderClient3, prepareCurrentLocationRequest$expo_location_release, promise);
                    return;
                }
                promise.reject(new LocationSettingsUnsatisfiedException());
            }
        });
    }

    public final void requestLocationUpdates(LocationRequest locationRequest, Integer requestId, final LocationRequestCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(locationRequest, "locationRequest");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        FusedLocationProviderClient fusedLocationProviderClient = this.mLocationProvider;
        if (fusedLocationProviderClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
            fusedLocationProviderClient = null;
        }
        LocationCallback locationCallback = new LocationCallback() { // from class: expo.modules.location.LocationModule$requestLocationUpdates$locationCallback$1
            private boolean isLocationAvailable;

            /* renamed from: isLocationAvailable, reason: from getter */
            public final boolean getIsLocationAvailable() {
                return this.isLocationAvailable;
            }

            public final void setLocationAvailable(boolean z) {
                this.isLocationAvailable = z;
            }

            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationResult(LocationResult locationResult) {
                Intrinsics.checkNotNullParameter(locationResult, "locationResult");
                Location lastLocation = locationResult.getLastLocation();
                if (lastLocation != null) {
                    LocationRequestCallbacks.this.onLocationChanged(lastLocation);
                } else if (!this.isLocationAvailable) {
                    LocationRequestCallbacks.this.onLocationError(new LocationUnavailableException());
                } else {
                    LocationRequestCallbacks.this.onRequestFailed(new LocationUnknownException());
                }
            }

            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                Intrinsics.checkNotNullParameter(locationAvailability, "locationAvailability");
                this.isLocationAvailable = locationAvailability.isLocationAvailable();
            }
        };
        if (requestId != null) {
            this.mLocationCallbacks.put(requestId, locationCallback);
            this.mLocationRequests.put(requestId, locationRequest);
        }
        try {
            fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
            callbacks.onRequestSuccess();
        } catch (SecurityException e) {
            callbacks.onRequestFailed(new LocationRequestRejectedException(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addPendingLocationRequest(LocationRequest locationRequest, LocationActivityResultListener listener) {
        this.mPendingLocationRequests.add(listener);
        if (this.mPendingLocationRequests.size() == 1) {
            resolveUserSettingsForRequest(locationRequest);
        }
    }

    private final void resolveUserSettingsForRequest(LocationRequest locationRequest) {
        ActivityProvider activityProvider = this.mActivityProvider;
        Context context = null;
        if (activityProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityProvider");
            activityProvider = null;
        }
        final Activity currentActivity = activityProvider.getCurrentActivity();
        if (currentActivity == null) {
            executePendingRequests(0);
            return;
        }
        LocationSettingsRequest.Builder addLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
        Intrinsics.checkNotNullExpressionValue(addLocationRequest, "Builder().addLocationRequest(locationRequest)");
        Context context2 = this.mContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context = context2;
        }
        SettingsClient settingsClient = LocationServices.getSettingsClient(context);
        Intrinsics.checkNotNullExpressionValue(settingsClient, "getSettingsClient(mContext)");
        Task<LocationSettingsResponse> checkLocationSettings = settingsClient.checkLocationSettings(addLocationRequest.build());
        Intrinsics.checkNotNullExpressionValue(checkLocationSettings, "client.checkLocationSettings(builder.build())");
        final Function1<LocationSettingsResponse, Unit> function1 = new Function1<LocationSettingsResponse, Unit>() { // from class: expo.modules.location.LocationModule$resolveUserSettingsForRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LocationSettingsResponse locationSettingsResponse) {
                invoke2(locationSettingsResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LocationSettingsResponse locationSettingsResponse) {
                LocationModule.this.executePendingRequests(-1);
            }
        };
        checkLocationSettings.addOnSuccessListener(new OnSuccessListener() { // from class: expo.modules.location.LocationModule$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                LocationModule.resolveUserSettingsForRequest$lambda$31(Function1.this, obj);
            }
        });
        checkLocationSettings.addOnFailureListener(new OnFailureListener() { // from class: expo.modules.location.LocationModule$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                LocationModule.resolveUserSettingsForRequest$lambda$32(LocationModule.this, currentActivity, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolveUserSettingsForRequest$lambda$31(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolveUserSettingsForRequest$lambda$32(LocationModule this$0, Activity activity, Exception e) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(e, "e");
        if (((ApiException) e).getStatusCode() == 6) {
            try {
                ResolvableApiException resolvableApiException = (ResolvableApiException) e;
                UIManager uIManager = this$0.mUIManager;
                if (uIManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUIManager");
                    uIManager = null;
                }
                uIManager.registerActivityEventListener(this$0);
                resolvableApiException.startResolutionForResult(activity, 42);
                return;
            } catch (IntentSender.SendIntentException unused) {
                this$0.executePendingRequests(0);
                return;
            }
        }
        this$0.executePendingRequests(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void executePendingRequests(int resultCode) {
        Iterator<LocationActivityResultListener> it = this.mPendingLocationRequests.iterator();
        while (it.hasNext()) {
            it.next().onResult(resultCode);
        }
        this.mPendingLocationRequests.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startHeadingUpdate() {
        Context context = this.mContext;
        SensorManager sensorManager = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        SmartLocation.LocationControl config = SmartLocation.with(context).location().oneFix().config(LocationParams.BEST_EFFORT);
        Location lastLocation = config.getLastLocation();
        if (lastLocation != null) {
            this.mGeofield = new GeomagneticField((float) lastLocation.getLatitude(), (float) lastLocation.getLongitude(), (float) lastLocation.getAltitude(), System.currentTimeMillis());
        } else {
            config.start(new OnLocationUpdatedListener() { // from class: expo.modules.location.LocationModule$$ExternalSyntheticLambda2
                @Override // io.nlopez.smartlocation.OnLocationUpdatedListener
                public final void onLocationUpdated(Location location) {
                    LocationModule.startHeadingUpdate$lambda$33(LocationModule.this, location);
                }
            });
        }
        SensorManager sensorManager2 = this.mSensorManager;
        if (sensorManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
            sensorManager2 = null;
        }
        LocationModule locationModule = this;
        SensorManager sensorManager3 = this.mSensorManager;
        if (sensorManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
            sensorManager3 = null;
        }
        sensorManager2.registerListener(locationModule, sensorManager3.getDefaultSensor(2), 3);
        SensorManager sensorManager4 = this.mSensorManager;
        if (sensorManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
            sensorManager4 = null;
        }
        SensorManager sensorManager5 = this.mSensorManager;
        if (sensorManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
        } else {
            sensorManager = sensorManager5;
        }
        sensorManager4.registerListener(locationModule, sensorManager.getDefaultSensor(1), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startHeadingUpdate$lambda$33(LocationModule this$0, Location location) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(location, "location");
        this$0.mGeofield = new GeomagneticField((float) location.getLatitude(), (float) location.getLongitude(), (float) location.getAltitude(), System.currentTimeMillis());
    }

    private final void sendUpdate() {
        float[] fArr = new float[9];
        if (SensorManager.getRotationMatrix(fArr, new float[9], this.mGravity, this.mGeomagnetic)) {
            float[] fArr2 = new float[3];
            SensorManager.getOrientation(fArr, fArr2);
            if (Math.abs(fArr2[0] - this.mLastAzimuth) <= 0.0355d || ((float) (System.currentTimeMillis() - this.mLastUpdate)) <= 50.0f) {
                return;
            }
            this.mLastAzimuth = fArr2[0];
            this.mLastUpdate = System.currentTimeMillis();
            float calcMagNorth = calcMagNorth(fArr2[0]);
            sendEvent(HEADING_EVENT_NAME, new HeadingEventResponse(Integer.valueOf(this.mHeadingId), new Heading(calcTrueNorth(calcMagNorth), calcMagNorth, this.mAccuracy)).toBundle$expo_location_release());
        }
    }

    public final void sendLocationResponse$expo_location_release(int watchId, LocationResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Bundle bundleOf = BundleKt.bundleOf();
        bundleOf.putBundle("location", (Bundle) response.toBundle$expo_location_release(Bundle.class));
        bundleOf.putInt("watchId", watchId);
        sendEvent(LOCATION_EVENT_NAME, bundleOf);
    }

    private final float calcMagNorth(float azimuth) {
        float degrees = (float) Math.toDegrees(azimuth);
        float f = CropImageOptions.DEGREES_360;
        return (degrees + f) % f;
    }

    private final float calcTrueNorth(float magNorth) {
        GeomagneticField geomagneticField = this.mGeofield;
        if (!(!isMissingForegroundPermissions())) {
            geomagneticField = null;
        }
        if (geomagneticField == null) {
            return -1.0f;
        }
        return (magNorth + geomagneticField.getDeclination()) % CropImageOptions.DEGREES_360;
    }

    private final void stopHeadingWatch() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
            sensorManager = null;
        }
        sensorManager.unregisterListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void destroyHeadingWatch() {
        stopHeadingWatch();
        this.mGravity = new float[9];
        this.mGeomagnetic = new float[9];
        this.mGeofield = null;
        this.mHeadingId = 0;
        this.mLastAzimuth = 0.0f;
        this.mAccuracy = 0;
    }

    private final void startWatching() {
        if (!isMissingForegroundPermissions()) {
            this.mGeocoderPaused = false;
        }
        resumeLocationUpdates();
    }

    private final void stopWatching() {
        if (Geocoder.isPresent() && !isMissingForegroundPermissions()) {
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            SmartLocation.with(context).geocoding().stop();
            this.mGeocoderPaused = true;
        }
        for (Integer requestId : this.mLocationCallbacks.keySet()) {
            Intrinsics.checkNotNullExpressionValue(requestId, "requestId");
            pauseLocationUpdatesForRequest(requestId.intValue());
        }
    }

    private final void pauseLocationUpdatesForRequest(int requestId) {
        LocationCallback locationCallback = this.mLocationCallbacks.get(Integer.valueOf(requestId));
        if (locationCallback != null) {
            FusedLocationProviderClient fusedLocationProviderClient = this.mLocationProvider;
            if (fusedLocationProviderClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
                fusedLocationProviderClient = null;
            }
            fusedLocationProviderClient.removeLocationUpdates(locationCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeLocationUpdatesForRequest(int requestId) {
        pauseLocationUpdatesForRequest(requestId);
        this.mLocationCallbacks.remove(Integer.valueOf(requestId));
        this.mLocationRequests.remove(Integer.valueOf(requestId));
    }

    private final void resumeLocationUpdates() {
        Integer next;
        LocationCallback locationCallback;
        LocationRequest locationRequest;
        Iterator<Integer> it = this.mLocationCallbacks.keySet().iterator();
        while (it.hasNext() && (locationCallback = this.mLocationCallbacks.get((next = it.next()))) != null && (locationRequest = this.mLocationRequests.get(next)) != null) {
            try {
                FusedLocationProviderClient fusedLocationProviderClient = this.mLocationProvider;
                if (fusedLocationProviderClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
                    fusedLocationProviderClient = null;
                }
                fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());
            } catch (SecurityException e) {
                Log.e(TAG, "Error occurred while resuming location updates: " + e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getLastKnownLocation(Continuation<? super Location> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        try {
            FusedLocationProviderClient fusedLocationProviderClient = this.mLocationProvider;
            if (fusedLocationProviderClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
                fusedLocationProviderClient = null;
            }
            Task<Location> lastLocation = fusedLocationProviderClient.getLastLocation();
            final Function1<Location, Unit> function1 = new Function1<Location, Unit>() { // from class: expo.modules.location.LocationModule$getLastKnownLocation$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Location location) {
                    invoke2(location);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Location location) {
                    Continuation<Location> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1318constructorimpl(location));
                }
            };
            lastLocation.addOnSuccessListener(new OnSuccessListener(function1) { // from class: expo.modules.location.LocationModule$sam$com_google_android_gms_tasks_OnSuccessListener$0
                private final /* synthetic */ Function1 function;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    Intrinsics.checkNotNullParameter(function1, "function");
                    this.function = function1;
                }

                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final /* synthetic */ void onSuccess(Object obj) {
                    this.function.invoke(obj);
                }
            }).addOnCanceledListener(new OnCanceledListener() { // from class: expo.modules.location.LocationModule$getLastKnownLocation$2$2
                @Override // com.google.android.gms.tasks.OnCanceledListener
                public final void onCanceled() {
                    Continuation<Location> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1318constructorimpl(null));
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: expo.modules.location.LocationModule$getLastKnownLocation$2$3
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Continuation<Location> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1318constructorimpl(null));
                }
            });
        } catch (SecurityException unused) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1318constructorimpl(null));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object geocode(String str, Continuation<? super List<GeocodeResponse>> continuation) {
        Unit unit = null;
        if (this.mGeocoderPaused) {
            throw new GeocodeException("Geocoder is not running", null, 2, null);
        }
        if (isMissingForegroundPermissions()) {
            throw new LocationUnauthorizedException();
        }
        if (!Geocoder.isPresent()) {
            throw new NoGeocodeException();
        }
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        SafeContinuation safeContinuation2 = safeContinuation;
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        List<Address> fromLocationName = new Geocoder(context, Locale.getDefault()).getFromLocationName(str, 1);
        if (fromLocationName != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = fromLocationName.iterator();
            while (it.hasNext()) {
                LocationAddress locationAddress = new LocationAddress((Address) it.next());
                GeocodeResponse.Companion companion = GeocodeResponse.INSTANCE;
                Location location = locationAddress.getLocation();
                Intrinsics.checkNotNullExpressionValue(location, "locationAddress.location");
                GeocodeResponse from = companion.from(location);
                if (from != null) {
                    arrayList.add(from);
                }
            }
            Result.Companion companion2 = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1318constructorimpl(arrayList));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            Result.Companion companion3 = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1318constructorimpl(CollectionsKt.emptyList()));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object reverseGeocode(ReverseGeocodeLocation reverseGeocodeLocation, Continuation<? super List<ReverseGeocodeResponse>> continuation) {
        ReverseGeocodeResponse reverseGeocodeResponse;
        Unit unit = null;
        if (this.mGeocoderPaused) {
            throw new GeocodeException("Geocoder is not running", null, 2, null);
        }
        if (isMissingForegroundPermissions()) {
            throw new LocationUnauthorizedException();
        }
        if (!Geocoder.isPresent()) {
            throw new NoGeocodeException();
        }
        Location location = new Location("");
        location.setLatitude(reverseGeocodeLocation.getLatitude());
        location.setLongitude(reverseGeocodeLocation.getLongitude());
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        SafeContinuation safeContinuation2 = safeContinuation;
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        List<Address> fromLocation = new Geocoder(context, Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        if (fromLocation != null) {
            ArrayList arrayList = new ArrayList();
            for (Address address : fromLocation) {
                if (address != null) {
                    Intrinsics.checkNotNullExpressionValue(address, "address");
                    reverseGeocodeResponse = new ReverseGeocodeResponse(address);
                } else {
                    reverseGeocodeResponse = null;
                }
                if (reverseGeocodeResponse != null) {
                    arrayList.add(reverseGeocodeResponse);
                }
            }
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1318constructorimpl(arrayList));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            Result.Companion companion2 = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1318constructorimpl(CollectionsKt.emptyList()));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMissingForegroundPermissions() {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return (permissions.hasGrantedPermissions(LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING) || permissions.hasGrantedPermissions(LocationConstants.ANDROID_COARSE_LOCATION_PERMISSION_STRING)) ? false : true;
        }
        throw new Exceptions.AppContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasForegroundServicePermissions() {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            if (Build.VERSION.SDK_INT >= 34) {
                return permissions.hasGrantedPermissions("android.permission.FOREGROUND_SERVICE") && permissions.hasGrantedPermissions("android.permission.FOREGROUND_SERVICE_LOCATION");
            }
            if (Build.VERSION.SDK_INT >= 28) {
                return permissions.hasGrantedPermissions("android.permission.FOREGROUND_SERVICE");
            }
            return true;
        }
        throw new Exceptions.AppContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMissingBackgroundPermissions() {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return Build.VERSION.SDK_INT >= 29 && !permissions.hasGrantedPermissions(LocationConstants.ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING);
        }
        return true;
    }

    private final boolean shouldAskBackgroundPermissions() {
        return Build.VERSION.SDK_INT >= 29;
    }

    private final boolean isBackgroundPermissionInManifest() {
        if (Build.VERSION.SDK_INT < 29) {
            return true;
        }
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return permissions.isPermissionPresentInManifest(LocationConstants.ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING);
        }
        throw new NoPermissionsModuleException();
    }

    /* compiled from: LocationModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\u00100\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lexpo/modules/location/LocationModule$Companion;", "", "()V", "ACCURACY_BALANCED", "", "ACCURACY_BEST_FOR_NAVIGATION", "ACCURACY_HIGH", "ACCURACY_HIGHEST", "ACCURACY_LOW", "ACCURACY_LOWEST", "CHECK_SETTINGS_REQUEST_CODE", "DEGREE_DELTA", "", "GEOFENCING_EVENT_ENTER", "GEOFENCING_EVENT_EXIT", "HEADING_EVENT_NAME", "", "LOCATION_EVENT_NAME", "TAG", "kotlin.jvm.PlatformType", "getTAG$expo_location_release", "()Ljava/lang/String;", "TIME_DELTA", "", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$expo_location_release() {
            return LocationModule.TAG;
        }
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostResume() {
        startWatching();
        startHeadingUpdate();
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostPause() {
        stopWatching();
        stopHeadingWatch();
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostDestroy() {
        stopWatching();
        stopHeadingWatch();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        if (event == null) {
            return;
        }
        if (event.sensor.getType() == 1) {
            float[] fArr = event.values;
            Intrinsics.checkNotNullExpressionValue(fArr, "event.values");
            this.mGravity = fArr;
        } else if (event.sensor.getType() == 2) {
            float[] fArr2 = event.values;
            Intrinsics.checkNotNullExpressionValue(fArr2, "event.values");
            this.mGeomagnetic = fArr2;
        }
        sendUpdate();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        this.mAccuracy = accuracy;
    }

    @Override // expo.modules.core.interfaces.ActivityEventListener
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        if (requestCode != 42) {
            return;
        }
        executePendingRequests(resultCode);
        UIManager uIManager = this.mUIManager;
        if (uIManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIManager");
            uIManager = null;
        }
        uIManager.unregisterActivityEventListener(this);
    }
}
