package com.facebook.react;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.turbomodule.core.TurboModuleManagerDelegate;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public abstract class ReactPackageTurboModuleManagerDelegate extends TurboModuleManagerDelegate {
    private final List<ModuleProvider> mModuleProviders = new ArrayList();
    private final Map<ModuleProvider, Map<String, ReactModuleInfo>> mPackageModuleInfos = new HashMap();
    private final boolean mShouldEnableLegacyModuleInterop;
    private final boolean mShouldRouteTurboModulesThroughLegacyModuleInterop;

    /* loaded from: classes.dex */
    interface ModuleProvider {
        NativeModule getModule(String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ReactPackageTurboModuleManagerDelegate() {
        boolean z = ReactFeatureFlags.enableBridgelessArchitecture && ReactFeatureFlags.unstable_useTurboModuleInterop;
        this.mShouldEnableLegacyModuleInterop = z;
        this.mShouldRouteTurboModulesThroughLegacyModuleInterop = z && ReactFeatureFlags.unstable_useTurboModuleInteropForAllTurboModules;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ReactPackageTurboModuleManagerDelegate(final ReactApplicationContext reactApplicationContext, List<ReactPackage> list) {
        ReactModuleInfo reactModuleInfo;
        boolean z = ReactFeatureFlags.enableBridgelessArchitecture && ReactFeatureFlags.unstable_useTurboModuleInterop;
        this.mShouldEnableLegacyModuleInterop = z;
        this.mShouldRouteTurboModulesThroughLegacyModuleInterop = z && ReactFeatureFlags.unstable_useTurboModuleInteropForAllTurboModules;
        for (ReactPackage reactPackage : list) {
            if (reactPackage instanceof TurboReactPackage) {
                final TurboReactPackage turboReactPackage = (TurboReactPackage) reactPackage;
                ModuleProvider moduleProvider = new ModuleProvider() { // from class: com.facebook.react.ReactPackageTurboModuleManagerDelegate$$ExternalSyntheticLambda0
                    @Override // com.facebook.react.ReactPackageTurboModuleManagerDelegate.ModuleProvider
                    public final NativeModule getModule(String str) {
                        NativeModule module;
                        module = TurboReactPackage.this.getModule(str, reactApplicationContext);
                        return module;
                    }
                };
                this.mModuleProviders.add(moduleProvider);
                this.mPackageModuleInfos.put(moduleProvider, turboReactPackage.getReactModuleInfoProvider().getReactModuleInfos());
            } else if (shouldSupportLegacyPackages() && (reactPackage instanceof LazyReactPackage)) {
                LazyReactPackage lazyReactPackage = (LazyReactPackage) reactPackage;
                List<ModuleSpec> nativeModules = lazyReactPackage.getNativeModules(reactApplicationContext);
                final HashMap hashMap = new HashMap();
                for (ModuleSpec moduleSpec : nativeModules) {
                    hashMap.put(moduleSpec.getName(), moduleSpec.getProvider());
                }
                ModuleProvider moduleProvider2 = new ModuleProvider() { // from class: com.facebook.react.ReactPackageTurboModuleManagerDelegate$$ExternalSyntheticLambda1
                    @Override // com.facebook.react.ReactPackageTurboModuleManagerDelegate.ModuleProvider
                    public final NativeModule getModule(String str) {
                        return ReactPackageTurboModuleManagerDelegate.lambda$new$1(hashMap, str);
                    }
                };
                this.mModuleProviders.add(moduleProvider2);
                this.mPackageModuleInfos.put(moduleProvider2, lazyReactPackage.getReactModuleInfoProvider().getReactModuleInfos());
            } else if (!shouldSupportLegacyPackages() || !(reactPackage instanceof ReactInstancePackage)) {
                if (shouldSupportLegacyPackages()) {
                    List<NativeModule> createNativeModules = reactPackage.createNativeModules(reactApplicationContext);
                    final HashMap hashMap2 = new HashMap();
                    HashMap hashMap3 = new HashMap();
                    for (NativeModule nativeModule : createNativeModules) {
                        Class<?> cls = nativeModule.getClass();
                        ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
                        String name = reactModule != null ? reactModule.name() : nativeModule.getName();
                        if (reactModule != null) {
                            reactModuleInfo = new ReactModuleInfo(name, cls.getName(), reactModule.canOverrideExistingModule(), true, reactModule.isCxxModule(), TurboModule.class.isAssignableFrom(cls));
                        } else {
                            reactModuleInfo = new ReactModuleInfo(name, cls.getName(), nativeModule.canOverrideExistingModule(), true, CxxModuleWrapper.class.isAssignableFrom(cls), TurboModule.class.isAssignableFrom(cls));
                        }
                        hashMap3.put(name, reactModuleInfo);
                        hashMap2.put(name, nativeModule);
                    }
                    ModuleProvider moduleProvider3 = new ModuleProvider() { // from class: com.facebook.react.ReactPackageTurboModuleManagerDelegate$$ExternalSyntheticLambda2
                        @Override // com.facebook.react.ReactPackageTurboModuleManagerDelegate.ModuleProvider
                        public final NativeModule getModule(String str) {
                            return (NativeModule) hashMap2.get(str);
                        }
                    };
                    this.mModuleProviders.add(moduleProvider3);
                    this.mPackageModuleInfos.put(moduleProvider3, hashMap3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ NativeModule lambda$new$1(Map map, String str) {
        Provider provider = (Provider) map.get(str);
        if (provider != null) {
            return (NativeModule) provider.get();
        }
        return null;
    }

    @Override // com.facebook.react.turbomodule.core.TurboModuleManagerDelegate
    public boolean unstable_shouldEnableLegacyModuleInterop() {
        return this.mShouldEnableLegacyModuleInterop;
    }

    @Override // com.facebook.react.turbomodule.core.TurboModuleManagerDelegate
    public boolean unstable_shouldRouteTurboModulesThroughLegacyModuleInterop() {
        return this.mShouldRouteTurboModulesThroughLegacyModuleInterop;
    }

    @Override // com.facebook.react.turbomodule.core.TurboModuleManagerDelegate
    public TurboModule getModule(String str) {
        Object obj = null;
        for (ModuleProvider moduleProvider : this.mModuleProviders) {
            try {
                ReactModuleInfo reactModuleInfo = this.mPackageModuleInfos.get(moduleProvider).get(str);
                if (reactModuleInfo != null && reactModuleInfo.isTurboModule() && (obj == null || reactModuleInfo.canOverrideExistingModule())) {
                    Object module = moduleProvider.getModule(str);
                    if (module != null) {
                        obj = module;
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        if (!(obj instanceof TurboModule)) {
            return null;
        }
        return (TurboModule) obj;
    }

    @Override // com.facebook.react.turbomodule.core.TurboModuleManagerDelegate
    public boolean unstable_isModuleRegistered(String str) {
        Iterator<ModuleProvider> it = this.mModuleProviders.iterator();
        while (it.hasNext()) {
            ReactModuleInfo reactModuleInfo = this.mPackageModuleInfos.get(it.next()).get(str);
            if (reactModuleInfo != null && reactModuleInfo.isTurboModule()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.react.turbomodule.core.TurboModuleManagerDelegate
    public boolean unstable_isLegacyModuleRegistered(String str) {
        Iterator<ModuleProvider> it = this.mModuleProviders.iterator();
        while (it.hasNext()) {
            ReactModuleInfo reactModuleInfo = this.mPackageModuleInfos.get(it.next()).get(str);
            if (reactModuleInfo != null && !reactModuleInfo.isTurboModule()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.react.turbomodule.core.TurboModuleManagerDelegate
    public NativeModule getLegacyModule(String str) {
        if (!unstable_shouldEnableLegacyModuleInterop()) {
            return null;
        }
        NativeModule nativeModule = null;
        for (ModuleProvider moduleProvider : this.mModuleProviders) {
            try {
                ReactModuleInfo reactModuleInfo = this.mPackageModuleInfos.get(moduleProvider).get(str);
                if (reactModuleInfo != null && !reactModuleInfo.isTurboModule() && (nativeModule == null || reactModuleInfo.canOverrideExistingModule())) {
                    NativeModule module = moduleProvider.getModule(str);
                    if (module != null) {
                        nativeModule = module;
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        if (!(nativeModule instanceof TurboModule)) {
            return nativeModule;
        }
        return null;
    }

    @Override // com.facebook.react.turbomodule.core.TurboModuleManagerDelegate
    public List<String> getEagerInitModuleNames() {
        ArrayList arrayList = new ArrayList();
        Iterator<ModuleProvider> it = this.mModuleProviders.iterator();
        while (it.hasNext()) {
            for (ReactModuleInfo reactModuleInfo : this.mPackageModuleInfos.get(it.next()).values()) {
                if (reactModuleInfo.isTurboModule() && reactModuleInfo.needsEagerInit()) {
                    arrayList.add(reactModuleInfo.name());
                }
            }
        }
        return arrayList;
    }

    private boolean shouldSupportLegacyPackages() {
        return unstable_shouldEnableLegacyModuleInterop();
    }

    /* loaded from: classes.dex */
    public static abstract class Builder {
        private ReactApplicationContext mContext;
        private List<ReactPackage> mPackages;

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract ReactPackageTurboModuleManagerDelegate build(ReactApplicationContext reactApplicationContext, List<ReactPackage> list);

        public Builder setPackages(List<ReactPackage> list) {
            this.mPackages = new ArrayList(list);
            return this;
        }

        public Builder setReactApplicationContext(ReactApplicationContext reactApplicationContext) {
            this.mContext = reactApplicationContext;
            return this;
        }

        public ReactPackageTurboModuleManagerDelegate build() {
            Assertions.assertNotNull(this.mContext, "The ReactApplicationContext must be provided to create ReactPackageTurboModuleManagerDelegate");
            Assertions.assertNotNull(this.mPackages, "A set of ReactPackages must be provided to create ReactPackageTurboModuleManagerDelegate");
            return build(this.mContext, this.mPackages);
        }
    }
}
