package expo.modules.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.work.WorkRequest;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.location.LocationHelpers;
import expo.modules.location.LocationRequestCallbacks;
import expo.modules.location.records.LocationLastKnownOptions;
import expo.modules.location.records.LocationOptions;
import expo.modules.location.records.LocationResponse;
import expo.modules.location.records.PermissionRequestResponse;
import io.nlopez.smartlocation.location.config.LocationAccuracy;
import io.nlopez.smartlocation.location.config.LocationParams;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationHelpers.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lexpo/modules/location/LocationHelpers;", "", "()V", "Companion", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocationHelpers {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: LocationHelpers.kt */
    @Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0080@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J/\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u001f\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020!H\u0002J\u0015\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020!H\u0000¢\u0006\u0002\b$J\u0015\u0010%\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020!H\u0000¢\u0006\u0002\b'J&\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/J\u001e\u00100\u001a\u00020)2\u0006\u00101\u001a\u0002022\u0006\u0010,\u001a\u00020#2\u0006\u0010.\u001a\u00020/\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lexpo/modules/location/LocationHelpers$Companion;", "", "()V", "askForPermissionsWithPermissionsManager", "Landroid/os/Bundle;", "contextPermissions", "Lexpo/modules/interfaces/permissions/Permissions;", "permissionStrings", "", "", "askForPermissionsWithPermissionsManager$expo_location_release", "(Lexpo/modules/interfaces/permissions/Permissions;[Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildLocationParamsForAccuracy", "Lio/nlopez/smartlocation/location/config/LocationParams$Builder;", "accuracy", "", "getPermissionsWithPermissionsManager", "Lexpo/modules/location/records/PermissionRequestResponse;", "getPermissionsWithPermissionsManager$expo_location_release", "hasNetworkProviderEnabled", "", "context", "Landroid/content/Context;", "isAnyProviderAvailable", "isLocationValid", "location", "Landroid/location/Location;", "options", "Lexpo/modules/location/records/LocationLastKnownOptions;", "isLocationValid$expo_location_release", "mapAccuracyToPriority", "mapOptionsToLocationParams", "Lio/nlopez/smartlocation/location/config/LocationParams;", "Lexpo/modules/location/records/LocationOptions;", "prepareCurrentLocationRequest", "Lcom/google/android/gms/location/CurrentLocationRequest;", "prepareCurrentLocationRequest$expo_location_release", "prepareLocationRequest", "Lcom/google/android/gms/location/LocationRequest;", "prepareLocationRequest$expo_location_release", "requestContinuousUpdates", "", "locationModule", "Lexpo/modules/location/LocationModule;", "locationRequest", "watchId", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "requestSingleLocation", "locationProvider", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int mapAccuracyToPriority(int accuracy) {
            switch (accuracy) {
                case 1:
                    return 104;
                case 2:
                case 3:
                default:
                    return 102;
                case 4:
                case 5:
                case 6:
                    return 100;
            }
        }

        private Companion() {
        }

        public final boolean isLocationValid$expo_location_release(Location location, LocationLastKnownOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            if (location == null) {
                return false;
            }
            Double maxAge = options.getMaxAge();
            double doubleValue = maxAge != null ? maxAge.doubleValue() : Double.MAX_VALUE;
            Double requiredAccuracy = options.getRequiredAccuracy();
            return ((double) (System.currentTimeMillis() - location.getTime())) <= doubleValue && ((double) location.getAccuracy()) <= (requiredAccuracy != null ? requiredAccuracy.doubleValue() : Double.MAX_VALUE);
        }

        public final boolean hasNetworkProviderEnabled(Context context) {
            if (context == null) {
                return false;
            }
            Object systemService = context.getSystemService("location");
            LocationManager locationManager = systemService instanceof LocationManager ? (LocationManager) systemService : null;
            return locationManager != null && locationManager.isProviderEnabled("network");
        }

        public final LocationRequest prepareLocationRequest$expo_location_release(LocationOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            LocationParams mapOptionsToLocationParams = mapOptionsToLocationParams(options);
            LocationRequest build = new LocationRequest.Builder(mapOptionsToLocationParams.getInterval()).setMinUpdateIntervalMillis(mapOptionsToLocationParams.getInterval()).setMaxUpdateDelayMillis(mapOptionsToLocationParams.getInterval()).setMinUpdateDistanceMeters(mapOptionsToLocationParams.getDistance()).setPriority(mapAccuracyToPriority(options.getAccuracy())).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder(locationParams.i…curacy))\n        .build()");
            return build;
        }

        public final CurrentLocationRequest prepareCurrentLocationRequest$expo_location_release(LocationOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            LocationParams mapOptionsToLocationParams = mapOptionsToLocationParams(options);
            CurrentLocationRequest.Builder builder = new CurrentLocationRequest.Builder();
            builder.setGranularity(0);
            builder.setPriority(LocationHelpers.INSTANCE.mapAccuracyToPriority(options.getAccuracy()));
            builder.setMaxUpdateAgeMillis(mapOptionsToLocationParams.getInterval());
            CurrentLocationRequest build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder().apply {\n      …interval)\n      }.build()");
            return build;
        }

        public final void requestSingleLocation(FusedLocationProviderClient locationProvider, CurrentLocationRequest locationRequest, final Promise promise) {
            Intrinsics.checkNotNullParameter(locationProvider, "locationProvider");
            Intrinsics.checkNotNullParameter(locationRequest, "locationRequest");
            Intrinsics.checkNotNullParameter(promise, "promise");
            try {
                Task<Location> currentLocation = locationProvider.getCurrentLocation(locationRequest, (CancellationToken) null);
                final Function1<Location, Unit> function1 = new Function1<Location, Unit>() { // from class: expo.modules.location.LocationHelpers$Companion$requestSingleLocation$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        if (location == null) {
                            Promise.this.reject(new CurrentLocationIsUnavailableException());
                        } else {
                            Promise.this.resolve(new LocationResponse(location));
                        }
                    }
                };
                currentLocation.addOnSuccessListener(new OnSuccessListener() { // from class: expo.modules.location.LocationHelpers$Companion$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        LocationHelpers.Companion.requestSingleLocation$lambda$1(Function1.this, obj);
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: expo.modules.location.LocationHelpers$Companion$$ExternalSyntheticLambda1
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        LocationHelpers.Companion.requestSingleLocation$lambda$2(Promise.this, exc);
                    }
                }).addOnCanceledListener(new OnCanceledListener() { // from class: expo.modules.location.LocationHelpers$Companion$$ExternalSyntheticLambda2
                    @Override // com.google.android.gms.tasks.OnCanceledListener
                    public final void onCanceled() {
                        LocationHelpers.Companion.requestSingleLocation$lambda$3(Promise.this);
                    }
                });
            } catch (SecurityException e) {
                promise.reject(new LocationRequestRejectedException(e));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void requestSingleLocation$lambda$1(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void requestSingleLocation$lambda$2(Promise promise, Exception it) {
            Intrinsics.checkNotNullParameter(promise, "$promise");
            Intrinsics.checkNotNullParameter(it, "it");
            promise.reject(new LocationRequestRejectedException(it));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void requestSingleLocation$lambda$3(Promise promise) {
            Intrinsics.checkNotNullParameter(promise, "$promise");
            promise.reject(new LocationRequestCancelledException());
        }

        public final void requestContinuousUpdates(final LocationModule locationModule, LocationRequest locationRequest, final int watchId, final Promise promise) {
            Intrinsics.checkNotNullParameter(locationModule, "locationModule");
            Intrinsics.checkNotNullParameter(locationRequest, "locationRequest");
            Intrinsics.checkNotNullParameter(promise, "promise");
            locationModule.requestLocationUpdates(locationRequest, Integer.valueOf(watchId), new LocationRequestCallbacks() { // from class: expo.modules.location.LocationHelpers$Companion$requestContinuousUpdates$1
                @Override // expo.modules.location.LocationRequestCallbacks
                public void onLocationError(CodedException codedException) {
                    LocationRequestCallbacks.DefaultImpls.onLocationError(this, codedException);
                }

                @Override // expo.modules.location.LocationRequestCallbacks
                public void onLocationChanged(Location location) {
                    Intrinsics.checkNotNullParameter(location, "location");
                    LocationModule.this.sendLocationResponse$expo_location_release(watchId, new LocationResponse(location));
                }

                @Override // expo.modules.location.LocationRequestCallbacks
                public void onRequestSuccess() {
                    promise.resolve(null);
                }

                @Override // expo.modules.location.LocationRequestCallbacks
                public void onRequestFailed(CodedException cause) {
                    Intrinsics.checkNotNullParameter(cause, "cause");
                    promise.reject(cause);
                }
            });
        }

        private final LocationParams mapOptionsToLocationParams(LocationOptions options) {
            LocationParams.Builder buildLocationParamsForAccuracy = buildLocationParamsForAccuracy(options.getAccuracy());
            Long timeInterval = options.getTimeInterval();
            if (timeInterval != null) {
                buildLocationParamsForAccuracy.setInterval(timeInterval.longValue());
            }
            if (options.getDistanceInterval() != null) {
                buildLocationParamsForAccuracy.setDistance(r4.intValue());
            }
            LocationParams build = buildLocationParamsForAccuracy.build();
            Intrinsics.checkNotNullExpressionValue(build, "locationParamsBuilder.build()");
            return build;
        }

        private final LocationParams.Builder buildLocationParamsForAccuracy(int accuracy) {
            switch (accuracy) {
                case 1:
                    LocationParams.Builder interval = new LocationParams.Builder().setAccuracy(LocationAccuracy.LOWEST).setDistance(3000.0f).setInterval(WorkRequest.MIN_BACKOFF_MILLIS);
                    Intrinsics.checkNotNullExpressionValue(interval, "Builder()\n          .set…      .setInterval(10000)");
                    return interval;
                case 2:
                    LocationParams.Builder interval2 = new LocationParams.Builder().setAccuracy(LocationAccuracy.LOW).setDistance(1000.0f).setInterval(5000L);
                    Intrinsics.checkNotNullExpressionValue(interval2, "Builder()\n          .set…       .setInterval(5000)");
                    return interval2;
                case 3:
                    LocationParams.Builder interval3 = new LocationParams.Builder().setAccuracy(LocationAccuracy.MEDIUM).setDistance(100.0f).setInterval(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    Intrinsics.checkNotNullExpressionValue(interval3, "Builder()\n          .set…       .setInterval(3000)");
                    return interval3;
                case 4:
                    LocationParams.Builder interval4 = new LocationParams.Builder().setAccuracy(LocationAccuracy.HIGH).setDistance(50.0f).setInterval(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    Intrinsics.checkNotNullExpressionValue(interval4, "Builder()\n          .set…       .setInterval(2000)");
                    return interval4;
                case 5:
                    LocationParams.Builder interval5 = new LocationParams.Builder().setAccuracy(LocationAccuracy.HIGH).setDistance(25.0f).setInterval(1000L);
                    Intrinsics.checkNotNullExpressionValue(interval5, "Builder()\n          .set…       .setInterval(1000)");
                    return interval5;
                case 6:
                    LocationParams.Builder interval6 = new LocationParams.Builder().setAccuracy(LocationAccuracy.HIGH).setDistance(0.0f).setInterval(500L);
                    Intrinsics.checkNotNullExpressionValue(interval6, "Builder()\n          .set…        .setInterval(500)");
                    return interval6;
                default:
                    LocationParams.Builder interval7 = new LocationParams.Builder().setAccuracy(LocationAccuracy.MEDIUM).setDistance(100.0f).setInterval(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    Intrinsics.checkNotNullExpressionValue(interval7, "Builder()\n          .set…       .setInterval(3000)");
                    return interval7;
            }
        }

        public final boolean isAnyProviderAvailable(Context context) {
            Object systemService = context != null ? context.getSystemService("location") : null;
            LocationManager locationManager = systemService instanceof LocationManager ? (LocationManager) systemService : null;
            if (locationManager == null) {
                return false;
            }
            return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
        }

        public final Object getPermissionsWithPermissionsManager$expo_location_release(Permissions permissions, String[] strArr, Continuation<? super PermissionRequestResponse> continuation) {
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
            final SafeContinuation safeContinuation2 = safeContinuation;
            Permissions.CC.getPermissionsWithPermissionsManager(permissions, new Promise() { // from class: expo.modules.location.LocationHelpers$Companion$getPermissionsWithPermissionsManager$2$1
                @Override // expo.modules.kotlin.Promise
                public void reject(CodedException codedException) {
                    Promise.DefaultImpls.reject(this, codedException);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve() {
                    Promise.DefaultImpls.resolve(this);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(Object value) {
                    Bundle bundle = value instanceof Bundle ? (Bundle) value : null;
                    if (bundle == null) {
                        throw new ConversionException(Object.class, Bundle.class, "value returned by the permission promise is not a Bundle");
                    }
                    Continuation<PermissionRequestResponse> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1318constructorimpl(new PermissionRequestResponse(bundle)));
                }

                @Override // expo.modules.kotlin.Promise
                public void reject(String code, String message, Throwable cause) {
                    Intrinsics.checkNotNullParameter(code, "code");
                    Continuation<PermissionRequestResponse> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1318constructorimpl(ResultKt.createFailure(new CodedException(code, message, cause))));
                }
            }, (String[]) Arrays.copyOf(strArr, strArr.length));
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }

        public final Object askForPermissionsWithPermissionsManager$expo_location_release(Permissions permissions, String[] strArr, Continuation<? super Bundle> continuation) {
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
            final SafeContinuation safeContinuation2 = safeContinuation;
            Permissions.CC.askForPermissionsWithPermissionsManager(permissions, new Promise() { // from class: expo.modules.location.LocationHelpers$Companion$askForPermissionsWithPermissionsManager$2$1
                @Override // expo.modules.kotlin.Promise
                public void reject(CodedException codedException) {
                    Promise.DefaultImpls.reject(this, codedException);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve() {
                    Promise.DefaultImpls.resolve(this);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(Object value) {
                    Continuation<Bundle> continuation2 = safeContinuation2;
                    Bundle bundle = value instanceof Bundle ? (Bundle) value : null;
                    if (bundle != null) {
                        Result.Companion companion = Result.INSTANCE;
                        continuation2.resumeWith(Result.m1318constructorimpl(bundle));
                        return;
                    }
                    throw new ConversionException(Object.class, Bundle.class, "value returned by the permission promise is not a Bundle");
                }

                @Override // expo.modules.kotlin.Promise
                public void reject(String code, String message, Throwable cause) {
                    Intrinsics.checkNotNullParameter(code, "code");
                    Continuation<Bundle> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1318constructorimpl(ResultKt.createFailure(new CodedException(code, message, cause))));
                }
            }, (String[]) Arrays.copyOf(strArr, strArr.length));
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
    }
}
