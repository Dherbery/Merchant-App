package expo.modules.core;

import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.RegistryLifecycleListener;
import expo.modules.core.interfaces.SingletonModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class ModuleRegistry {
    private final Map<Class, InternalModule> mInternalModulesMap = new HashMap();
    private final Map<String, ExportedModule> mExportedModulesMap = new HashMap();
    private final Map<Class, ExportedModule> mExportedModulesByClassMap = new HashMap();
    private final Map<String, SingletonModule> mSingletonModulesMap = new HashMap();
    private final List<WeakReference<RegistryLifecycleListener>> mExtraRegistryLifecycleListeners = new ArrayList();
    private volatile boolean mIsInitialized = false;

    public ModuleRegistry(Collection<InternalModule> collection, Collection<ExportedModule> collection2, Collection<ViewManager> collection3, Collection<SingletonModule> collection4) {
        Iterator<InternalModule> it = collection.iterator();
        while (it.hasNext()) {
            registerInternalModule(it.next());
        }
        Iterator<ExportedModule> it2 = collection2.iterator();
        while (it2.hasNext()) {
            registerExportedModule(it2.next());
        }
        Iterator<SingletonModule> it3 = collection4.iterator();
        while (it3.hasNext()) {
            registerSingletonModule(it3.next());
        }
    }

    public <T> T getModule(Class<T> cls) {
        return (T) this.mInternalModulesMap.get(cls);
    }

    public ExportedModule getExportedModule(String str) {
        return this.mExportedModulesMap.get(str);
    }

    public ExportedModule getExportedModuleOfClass(Class cls) {
        return this.mExportedModulesByClassMap.get(cls);
    }

    public Collection<ExportedModule> getAllExportedModules() {
        return this.mExportedModulesMap.values();
    }

    public <T> T getSingletonModule(String str, Class<T> cls) {
        return (T) this.mSingletonModulesMap.get(str);
    }

    public void registerInternalModule(InternalModule internalModule) {
        Iterator<? extends Class> it = internalModule.getExportedInterfaces().iterator();
        while (it.hasNext()) {
            this.mInternalModulesMap.put(it.next(), internalModule);
        }
    }

    public InternalModule unregisterInternalModule(Class cls) {
        return this.mInternalModulesMap.remove(cls);
    }

    public void registerExportedModule(ExportedModule exportedModule) {
        this.mExportedModulesMap.put(exportedModule.getName(), exportedModule);
        this.mExportedModulesByClassMap.put(exportedModule.getClass(), exportedModule);
    }

    public void registerSingletonModule(SingletonModule singletonModule) {
        this.mSingletonModulesMap.put(singletonModule.getName(), singletonModule);
    }

    public void registerExtraListener(RegistryLifecycleListener registryLifecycleListener) {
        this.mExtraRegistryLifecycleListeners.add(new WeakReference<>(registryLifecycleListener));
    }

    public synchronized void ensureIsInitialized() {
        if (!this.mIsInitialized) {
            initialize();
            this.mIsInitialized = true;
        }
    }

    public void initialize() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mExportedModulesMap.values());
        arrayList.addAll(this.mInternalModulesMap.values());
        for (WeakReference<RegistryLifecycleListener> weakReference : this.mExtraRegistryLifecycleListeners) {
            if (weakReference.get() != null) {
                arrayList.add(weakReference.get());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((RegistryLifecycleListener) it.next()).onCreate(this);
        }
    }

    public void onDestroy() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mExportedModulesMap.values());
        arrayList.addAll(this.mInternalModulesMap.values());
        for (WeakReference<RegistryLifecycleListener> weakReference : this.mExtraRegistryLifecycleListeners) {
            if (weakReference.get() != null) {
                arrayList.add(weakReference.get());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((RegistryLifecycleListener) it.next()).onDestroy();
        }
    }
}
