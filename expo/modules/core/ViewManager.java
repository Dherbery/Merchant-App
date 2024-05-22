package expo.modules.core;

import android.view.View;
import expo.modules.core.interfaces.RegistryLifecycleListener;

@Deprecated
/* loaded from: classes5.dex */
public abstract class ViewManager<V extends View> implements RegistryLifecycleListener {
    @Override // expo.modules.core.interfaces.RegistryLifecycleListener
    public /* synthetic */ void onCreate(ModuleRegistry moduleRegistry) {
        RegistryLifecycleListener.CC.$default$onCreate(this, moduleRegistry);
    }

    @Override // expo.modules.core.interfaces.RegistryLifecycleListener
    public /* synthetic */ void onDestroy() {
        RegistryLifecycleListener.CC.$default$onDestroy(this);
    }
}
