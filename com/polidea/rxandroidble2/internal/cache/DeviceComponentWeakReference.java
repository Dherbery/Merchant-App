package com.polidea.rxandroidble2.internal.cache;

import com.polidea.rxandroidble2.internal.DeviceComponent;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
class DeviceComponentWeakReference extends WeakReference<DeviceComponent> {

    /* loaded from: classes5.dex */
    public interface Provider {
        DeviceComponentWeakReference provide(DeviceComponent deviceComponent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceComponentWeakReference(DeviceComponent deviceComponent) {
        super(deviceComponent);
    }

    DeviceComponentWeakReference(DeviceComponent deviceComponent, ReferenceQueue<? super DeviceComponent> referenceQueue) {
        super(deviceComponent, referenceQueue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean contains(Object obj) {
        DeviceComponent deviceComponent = (DeviceComponent) get();
        return (obj instanceof DeviceComponent) && deviceComponent != null && deviceComponent.provideDevice() == ((DeviceComponent) obj).provideDevice();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WeakReference)) {
            return false;
        }
        DeviceComponent deviceComponent = (DeviceComponent) get();
        Object obj2 = ((WeakReference) obj).get();
        return deviceComponent != null && (obj2 instanceof DeviceComponent) && deviceComponent.provideDevice().equals(((DeviceComponent) obj2).provideDevice());
    }

    public int hashCode() {
        if (get() != null) {
            return ((DeviceComponent) get()).hashCode();
        }
        return 0;
    }

    public boolean isEmpty() {
        return get() == null;
    }
}
