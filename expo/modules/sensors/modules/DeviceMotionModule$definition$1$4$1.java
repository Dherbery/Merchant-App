package expo.modules.sensors.modules;

import expo.modules.interfaces.sensors.SensorServiceSubscriptionInterface;
import expo.modules.kotlin.Promise;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceMotionModule.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceMotionModule$definition$1$4$1 implements Runnable {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ DeviceMotionModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceMotionModule$definition$1$4$1(DeviceMotionModule deviceMotionModule, Promise promise) {
        this.this$0 = deviceMotionModule;
        this.$promise = promise;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        list = this.this$0.serviceSubscriptions;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceSubscriptions");
            list = null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((SensorServiceSubscriptionInterface) it.next()).stop();
        }
        this.this$0.currentFrameCallback.stop();
        this.$promise.resolve(null);
    }
}
