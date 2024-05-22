package expo.modules.sensors.modules;

import android.hardware.SensorEvent;
import android.os.Build;
import android.os.Bundle;
import androidx.tracing.Trace;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.interfaces.sensors.SensorServiceInterface;
import expo.modules.interfaces.sensors.services.PedometerServiceInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.sensors.SensorProxy;
import expo.modules.sensors.SensorProxyKt;
import expo.modules.sensors.ServiceNotFoundException;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: PedometerModule.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u000e"}, d2 = {"Lexpo/modules/sensors/modules/PedometerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "sensorProxy", "Lexpo/modules/sensors/SensorProxy;", "getSensorProxy", "()Lexpo/modules/sensors/SensorProxy;", "sensorProxy$delegate", "Lkotlin/Lazy;", "stepsAtTheBeginning", "", "Ljava/lang/Integer;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-sensors_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PedometerModule extends Module {

    /* renamed from: sensorProxy$delegate, reason: from kotlin metadata */
    private final Lazy sensorProxy = LazyKt.lazy(new Function0<SensorProxy>() { // from class: expo.modules.sensors.modules.PedometerModule$sensorProxy$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SensorProxy invoke() {
            final PedometerModule pedometerModule = PedometerModule.this;
            final WeakReference weakReference = new WeakReference(pedometerModule);
            final String str = "Exponent.pedometerUpdate";
            return new SensorProxy(new Function0<PedometerServiceInterface>() { // from class: expo.modules.sensors.modules.PedometerModule$sensorProxy$2$invoke$$inlined$createSensorProxy$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r1v3, types: [expo.modules.interfaces.sensors.SensorServiceInterface, expo.modules.interfaces.sensors.services.PedometerServiceInterface] */
                @Override // kotlin.jvm.functions.Function0
                public final PedometerServiceInterface invoke() {
                    Module module = (Module) weakReference.get();
                    Object obj = null;
                    AppContext appContext = module != null ? module.getAppContext() : null;
                    if (appContext != null) {
                        try {
                            obj = appContext.getLegacyModuleRegistry().getModule(PedometerServiceInterface.class);
                        } catch (Exception unused) {
                        }
                        ?? r1 = (SensorServiceInterface) obj;
                        if (r1 != 0) {
                            return r1;
                        }
                    }
                    throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(PedometerServiceInterface.class));
                }
            }, new Function1<SensorEvent, Unit>() { // from class: expo.modules.sensors.modules.PedometerModule$sensorProxy$2$invoke$$inlined$createSensorProxy$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SensorEvent sensorEvent) {
                    invoke2(sensorEvent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SensorEvent sensorEvent) {
                    Integer num;
                    Integer num2;
                    Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
                    Module module = (Module) weakReference.get();
                    if (module != null) {
                        String str2 = str;
                        num = pedometerModule.stepsAtTheBeginning;
                        if (num == null) {
                            pedometerModule.stepsAtTheBeginning = Integer.valueOf(((int) sensorEvent.values[0]) - 1);
                        }
                        Bundle bundle = new Bundle();
                        float f = sensorEvent.values[0];
                        num2 = pedometerModule.stepsAtTheBeginning;
                        bundle.putDouble("steps", f - (num2 != null ? num2.intValue() : ((int) sensorEvent.values[0]) - 1));
                        module.sendEvent(str2, bundle);
                    }
                }
            });
        }
    });
    private Integer stepsAtTheBeginning;

    /* JADX INFO: Access modifiers changed from: private */
    public final SensorProxy getSensorProxy() {
        return (SensorProxy) this.sensorProxy.getValue();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        PedometerModule pedometerModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (pedometerModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(pedometerModule);
            moduleDefinitionBuilder.Name("ExponentPedometer");
            SensorProxyKt.UseSensorProxy(moduleDefinitionBuilder, this, 19, "Exponent.pedometerUpdate", new Function0<Unit>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    PedometerModule.this.stepsAtTheBeginning = null;
                }
            }, new Function0<SensorProxy>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final SensorProxy invoke() {
                    SensorProxy sensorProxy;
                    sensorProxy = PedometerModule.this.getSensorProxy();
                    return sensorProxy;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getPermissionsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$3$$inlined$AsyncFunction$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    if (Build.VERSION.SDK_INT >= 29) {
                        Permissions.CC.getPermissionsWithPermissionsManager(PedometerModule.this.getAppContext().getPermissions(), promise, "android.permission.ACTIVITY_RECOGNITION");
                    } else {
                        Permissions.CC.getPermissionsWithPermissionsManager(PedometerModule.this.getAppContext().getPermissions(), promise, new String[0]);
                    }
                }
            }) : new AsyncFunctionComponent("getPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$3$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$3$$inlined$AsyncFunction$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    Promise promise = (Promise) obj;
                    if (Build.VERSION.SDK_INT >= 29) {
                        Permissions.CC.getPermissionsWithPermissionsManager(PedometerModule.this.getAppContext().getPermissions(), promise, "android.permission.ACTIVITY_RECOGNITION");
                    } else {
                        Permissions.CC.getPermissionsWithPermissionsManager(PedometerModule.this.getAppContext().getPermissions(), promise, new String[0]);
                    }
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("requestPermissionsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$3$$inlined$AsyncFunction$4
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    if (Build.VERSION.SDK_INT >= 29) {
                        Permissions.CC.askForPermissionsWithPermissionsManager(PedometerModule.this.getAppContext().getPermissions(), promise, "android.permission.ACTIVITY_RECOGNITION");
                    } else {
                        Permissions.CC.askForPermissionsWithPermissionsManager(PedometerModule.this.getAppContext().getPermissions(), promise, new String[0]);
                    }
                }
            }) : new AsyncFunctionComponent("requestPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$3$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$3$$inlined$AsyncFunction$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    Promise promise = (Promise) obj;
                    if (Build.VERSION.SDK_INT >= 29) {
                        Permissions.CC.askForPermissionsWithPermissionsManager(PedometerModule.this.getAppContext().getPermissions(), promise, "android.permission.ACTIVITY_RECOGNITION");
                    } else {
                        Permissions.CC.askForPermissionsWithPermissionsManager(PedometerModule.this.getAppContext().getPermissions(), promise, new String[0]);
                    }
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getStepCountAsync", Integer.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getStepCountAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$3$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$3$$inlined$AsyncFunction$8
                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    ((Integer) promise).intValue();
                    ((Integer) obj).intValue();
                    throw new NotSupportedException("Getting step count for date range is not supported on Android yet");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getStepCountAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$3$$inlined$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$3$$inlined$AsyncFunction$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$3$$inlined$AsyncFunction$11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    ((Integer) obj2).intValue();
                    num.intValue();
                    throw new NotSupportedException("Getting step count for date range is not supported on Android yet");
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
