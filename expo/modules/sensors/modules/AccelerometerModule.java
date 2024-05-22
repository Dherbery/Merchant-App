package expo.modules.sensors.modules;

import android.hardware.SensorEvent;
import android.os.Bundle;
import androidx.tracing.Trace;
import expo.modules.interfaces.sensors.SensorServiceInterface;
import expo.modules.interfaces.sensors.services.AccelerometerServiceInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: AccelerometerModule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lexpo/modules/sensors/modules/AccelerometerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "sensorProxy", "Lexpo/modules/sensors/SensorProxy;", "getSensorProxy", "()Lexpo/modules/sensors/SensorProxy;", "sensorProxy$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-sensors_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AccelerometerModule extends Module {

    /* renamed from: sensorProxy$delegate, reason: from kotlin metadata */
    private final Lazy sensorProxy = LazyKt.lazy(new Function0<SensorProxy>() { // from class: expo.modules.sensors.modules.AccelerometerModule$sensorProxy$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SensorProxy invoke() {
            final WeakReference weakReference = new WeakReference(AccelerometerModule.this);
            final String str = "accelerometerDidUpdate";
            return new SensorProxy(new Function0<AccelerometerServiceInterface>() { // from class: expo.modules.sensors.modules.AccelerometerModule$sensorProxy$2$invoke$$inlined$createSensorProxy$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r1v3, types: [expo.modules.interfaces.sensors.services.AccelerometerServiceInterface, expo.modules.interfaces.sensors.SensorServiceInterface] */
                @Override // kotlin.jvm.functions.Function0
                public final AccelerometerServiceInterface invoke() {
                    Module module = (Module) weakReference.get();
                    Object obj = null;
                    AppContext appContext = module != null ? module.getAppContext() : null;
                    if (appContext != null) {
                        try {
                            obj = appContext.getLegacyModuleRegistry().getModule(AccelerometerServiceInterface.class);
                        } catch (Exception unused) {
                        }
                        ?? r1 = (SensorServiceInterface) obj;
                        if (r1 != 0) {
                            return r1;
                        }
                    }
                    throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(AccelerometerServiceInterface.class));
                }
            }, new Function1<SensorEvent, Unit>() { // from class: expo.modules.sensors.modules.AccelerometerModule$sensorProxy$2$invoke$$inlined$createSensorProxy$2
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
                    Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
                    Module module = (Module) weakReference.get();
                    if (module != null) {
                        String str2 = str;
                        Bundle bundle = new Bundle();
                        bundle.putDouble("x", sensorEvent.values[0] / 9.80665f);
                        bundle.putDouble("y", sensorEvent.values[1] / 9.80665f);
                        bundle.putDouble("z", sensorEvent.values[2] / 9.80665f);
                        module.sendEvent(str2, bundle);
                    }
                }
            });
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final SensorProxy getSensorProxy() {
        return (SensorProxy) this.sensorProxy.getValue();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AccelerometerModule accelerometerModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (accelerometerModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(accelerometerModule);
            moduleDefinitionBuilder.Name("ExponentAccelerometer");
            SensorProxyKt.UseSensorProxy$default(moduleDefinitionBuilder, this, 1, "accelerometerDidUpdate", null, new Function0<SensorProxy>() { // from class: expo.modules.sensors.modules.AccelerometerModule$definition$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final SensorProxy invoke() {
                    SensorProxy sensorProxy;
                    sensorProxy = AccelerometerModule.this.getSensorProxy();
                    return sensorProxy;
                }
            }, 8, null);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
