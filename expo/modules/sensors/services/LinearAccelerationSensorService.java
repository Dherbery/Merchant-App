package expo.modules.sensors.services;

import android.content.Context;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.interfaces.sensors.services.LinearAccelerationSensorServiceInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: LinearAccelerationSensorService.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fH\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lexpo/modules/sensors/services/LinearAccelerationSensorService;", "Lexpo/modules/sensors/services/SubscribableSensorService;", "Lexpo/modules/core/interfaces/InternalModule;", "Lexpo/modules/interfaces/sensors/services/LinearAccelerationSensorServiceInterface;", "reactContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sensorType", "", "getSensorType", "()I", "getExportedInterfaces", "", "Ljava/lang/Class;", "expo-sensors_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LinearAccelerationSensorService extends SubscribableSensorService implements InternalModule, LinearAccelerationSensorServiceInterface {
    private final int sensorType;

    public LinearAccelerationSensorService(Context context) {
        super(context);
        this.sensorType = 10;
    }

    @Override // expo.modules.sensors.services.BaseSensorService
    public int getSensorType() {
        return this.sensorType;
    }

    @Override // expo.modules.core.interfaces.InternalModule
    public List<Class<?>> getExportedInterfaces() {
        return CollectionsKt.listOf(LinearAccelerationSensorServiceInterface.class);
    }
}
