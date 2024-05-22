package expo.modules.sensors;

import android.content.Context;
import expo.modules.core.BasePackage;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.sensors.services.AccelerometerService;
import expo.modules.sensors.services.BarometerService;
import expo.modules.sensors.services.GravitySensorService;
import expo.modules.sensors.services.GyroscopeService;
import expo.modules.sensors.services.LightSensorService;
import expo.modules.sensors.services.LinearAccelerationSensorService;
import expo.modules.sensors.services.MagnetometerService;
import expo.modules.sensors.services.MagnetometerUncalibratedService;
import expo.modules.sensors.services.PedometerService;
import expo.modules.sensors.services.RotationVectorSensorService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SensorsPackage.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/sensors/SensorsPackage;", "Lexpo/modules/core/BasePackage;", "()V", "createInternalModules", "", "Lexpo/modules/core/interfaces/InternalModule;", "context", "Landroid/content/Context;", "expo-sensors_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SensorsPackage extends BasePackage {
    @Override // expo.modules.core.BasePackage, expo.modules.core.interfaces.Package
    public List<InternalModule> createInternalModules(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CollectionsKt.listOf((Object[]) new InternalModule[]{new AccelerometerService(context), new BarometerService(context), new GravitySensorService(context), new GyroscopeService(context), new LightSensorService(context), new LinearAccelerationSensorService(context), new MagnetometerService(context), new MagnetometerUncalibratedService(context), new RotationVectorSensorService(context), new PedometerService(context)});
    }
}
