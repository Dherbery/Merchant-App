package expo.modules.kotlin;

import androidx.tracing.Trace;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewManager;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.kotlin.defaultmodules.NativeModulesProxyModuleKt;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import expo.modules.kotlin.views.GroupViewManagerWrapper;
import expo.modules.kotlin.views.SimpleViewManagerWrapper;
import expo.modules.kotlin.views.ViewManagerDefinition;
import expo.modules.kotlin.views.ViewManagerType;
import expo.modules.kotlin.views.ViewManagerWrapperDelegate;
import expo.modules.kotlin.views.ViewWrapperDelegateHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: KotlinInteropModuleRegistry.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0013Jb\u0010\u001c\u001a*\u0012\b\u0012\u00060\u0015j\u0002`\u001e\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dj\u0002` 0\u001f0\u001d22\b\u0002\u0010!\u001a,\u0012\u0004\u0012\u00020\u0015\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dj\u0002` 0\u001f\u0012\u0004\u0012\u00020\u00130\"J\u0014\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030$0\u001fJ(\u0010%\u001a$\u0012\b\u0012\u00060\u0015j\u0002`\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dj\u0002`&0\u001dJ\"\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u001f2\u0014\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030$0\u001fJ\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0015J\u0006\u0010-\u001a\u00020\u0013J\u0006\u0010.\u001a\u00020\u0013J\u000e\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u000201J\u0014\u00102\u001a\u00020\u00132\f\u00103\u001a\b\u0012\u0004\u0012\u00020(0\u001fJ\u001e\u00104\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u001d0\u001dR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u00065"}, d2 = {"Lexpo/modules/kotlin/KotlinInteropModuleRegistry;", "", "modulesProvider", "Lexpo/modules/kotlin/ModulesProvider;", "legacyModuleRegistry", "Lexpo/modules/core/ModuleRegistry;", "reactContext", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lexpo/modules/kotlin/ModulesProvider;Lexpo/modules/core/ModuleRegistry;Ljava/lang/ref/WeakReference;)V", "appContext", "Lexpo/modules/kotlin/AppContext;", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "getRegistry", "()Lexpo/modules/kotlin/ModuleRegistry;", "callMethod", "", "moduleName", "", "method", "arguments", "Lcom/facebook/react/bridge/ReadableArray;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "emitOnCreate", "exportMethods", "", "Lexpo/modules/kotlin/ModuleName;", "", "Lexpo/modules/kotlin/ModuleMethodInfo;", "exportKey", "Lkotlin/Function2;", "exportViewManagers", "Lcom/facebook/react/uimanager/ViewManager;", "exportedModulesConstants", "Lexpo/modules/kotlin/ModuleConstants;", "extractViewManagersDelegateHolders", "Lexpo/modules/kotlin/views/ViewWrapperDelegateHolder;", "viewManagers", "hasModule", "", "name", "installJSIInterop", "onDestroy", "setLegacyModulesProxy", "proxyModule", "Lexpo/modules/adapters/react/NativeModulesProxy;", "updateModuleHoldersInViewManagers", "viewWrapperHolders", "viewManagersMetadata", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KotlinInteropModuleRegistry {
    private final AppContext appContext;

    /* compiled from: KotlinInteropModuleRegistry.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ViewManagerType.values().length];
            try {
                iArr[ViewManagerType.SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ViewManagerType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public KotlinInteropModuleRegistry(ModulesProvider modulesProvider, expo.modules.core.ModuleRegistry legacyModuleRegistry, WeakReference<ReactApplicationContext> reactContext) {
        Intrinsics.checkNotNullParameter(modulesProvider, "modulesProvider");
        Intrinsics.checkNotNullParameter(legacyModuleRegistry, "legacyModuleRegistry");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.appContext = new AppContext(modulesProvider, legacyModuleRegistry, reactContext);
    }

    public final AppContext getAppContext() {
        return this.appContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ModuleRegistry getRegistry() {
        return this.appContext.getRegistry();
    }

    public final boolean hasModule(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getRegistry().hasModule(name);
    }

    public final void callMethod(String moduleName, String method, ReadableArray arguments, Promise promise) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            ModuleHolder<?> moduleHolder = getRegistry().getModuleHolder(moduleName);
            if (moduleHolder == null) {
                throw new IllegalArgumentException(("Trying to call '" + method + "' on the non-existing module '" + moduleName + "'").toString());
            }
            moduleHolder.call(method, arguments, promise);
        } catch (CodedException e) {
            promise.reject(e);
        } catch (Throwable th) {
            promise.reject(new UnexpectedException(th));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Map exportMethods$default(KotlinInteropModuleRegistry kotlinInteropModuleRegistry, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = new Function2<String, List<? extends Map<String, ? extends Object>>, Unit>() { // from class: expo.modules.kotlin.KotlinInteropModuleRegistry$exportMethods$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str, List<? extends Map<String, ? extends Object>> list) {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(list, "<anonymous parameter 1>");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, List<? extends Map<String, ? extends Object>> list) {
                    invoke2(str, list);
                    return Unit.INSTANCE;
                }
            };
        }
        return kotlinInteropModuleRegistry.exportMethods(function2);
    }

    public final void onDestroy() {
        this.appContext.onDestroy$expo_modules_core_release();
        CoreLoggerKt.getLogger().info("✅ KotlinInteropModuleRegistry was destroyed");
    }

    public final void installJSIInterop() {
        this.appContext.installJSIInterop();
    }

    public final void emitOnCreate() {
        this.appContext.onCreate();
    }

    public final void setLegacyModulesProxy(NativeModulesProxy proxyModule) {
        Intrinsics.checkNotNullParameter(proxyModule, "proxyModule");
        this.appContext.setLegacyModulesProxyHolder$expo_modules_core_release(new WeakReference<>(proxyModule));
    }

    public final Map<String, Map<String, Object>> exportedModulesConstants() {
        Trace.beginSection("[ExpoModulesCore] KotlinInteropModuleRegistry.exportedModulesConstants");
        try {
            ModuleRegistry registry = getRegistry();
            ArrayList arrayList = new ArrayList();
            for (ModuleHolder<?> moduleHolder : registry) {
                if (!Intrinsics.areEqual(moduleHolder.getName(), NativeModulesProxyModuleKt.NativeModulesProxyModuleName)) {
                    arrayList.add(moduleHolder);
                }
            }
            ArrayList<ModuleHolder> arrayList2 = arrayList;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
            for (ModuleHolder moduleHolder2 : arrayList2) {
                Pair pair = TuplesKt.to(moduleHolder2.getName(), moduleHolder2.getDefinition().getConstantsProvider().invoke());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        } finally {
            Trace.endSection();
        }
    }

    public final Map<String, List<Map<String, Object>>> exportMethods(Function2<? super String, ? super List<? extends Map<String, ? extends Object>>, Unit> exportKey) {
        Intrinsics.checkNotNullParameter(exportKey, "exportKey");
        Trace.beginSection("[ExpoModulesCore] KotlinInteropModuleRegistry.exportMethods");
        try {
            ModuleRegistry registry = getRegistry();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(registry, 10)), 16));
            for (ModuleHolder<?> moduleHolder : registry) {
                Map<String, BaseAsyncFunctionComponent> asyncFunctions = moduleHolder.getDefinition().getAsyncFunctions();
                ArrayList arrayList = new ArrayList(asyncFunctions.size());
                for (Map.Entry<String, BaseAsyncFunctionComponent> entry : asyncFunctions.entrySet()) {
                    arrayList.add(MapsKt.mapOf(TuplesKt.to("name", entry.getKey()), TuplesKt.to("argumentsCount", Integer.valueOf(entry.getValue().getArgsCount$expo_modules_core_release()))));
                }
                ArrayList arrayList2 = arrayList;
                exportKey.invoke(moduleHolder.getName(), arrayList2);
                Pair pair = TuplesKt.to(moduleHolder.getName(), arrayList2);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        } finally {
            Trace.endSection();
        }
    }

    public final List<ViewManager<?, ?>> exportViewManagers() {
        ViewManager simpleViewManagerWrapper;
        Trace.beginSection("[ExpoModulesCore] KotlinInteropModuleRegistry.exportViewManagers");
        try {
            ModuleRegistry registry = getRegistry();
            ArrayList arrayList = new ArrayList();
            Iterator<ModuleHolder<?>> it = registry.iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                ModuleHolder<?> next = it.next();
                if (next.getDefinition().getViewManagerDefinition() == null) {
                    z = false;
                }
                if (z) {
                    arrayList.add(next);
                }
            }
            ArrayList<ModuleHolder> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (ModuleHolder moduleHolder : arrayList2) {
                ViewManagerWrapperDelegate viewManagerWrapperDelegate = new ViewManagerWrapperDelegate(moduleHolder);
                ViewManagerDefinition viewManagerDefinition = moduleHolder.getDefinition().getViewManagerDefinition();
                Intrinsics.checkNotNull(viewManagerDefinition);
                int i = WhenMappings.$EnumSwitchMapping$0[viewManagerDefinition.getViewManagerType().ordinal()];
                if (i == 1) {
                    simpleViewManagerWrapper = new SimpleViewManagerWrapper(viewManagerWrapperDelegate);
                } else {
                    if (i != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    simpleViewManagerWrapper = new GroupViewManagerWrapper(viewManagerWrapperDelegate);
                }
                arrayList3.add(simpleViewManagerWrapper);
            }
            return arrayList3;
        } finally {
            Trace.endSection();
        }
    }

    public final Map<String, Map<String, Object>> viewManagersMetadata() {
        List<String> emptyList;
        Trace.beginSection("[ExpoModulesCore] KotlinInteropModuleRegistry.viewManagersMetadata");
        try {
            ModuleRegistry registry = getRegistry();
            ArrayList arrayList = new ArrayList();
            for (ModuleHolder<?> moduleHolder : registry) {
                if (moduleHolder.getDefinition().getViewManagerDefinition() != null) {
                    arrayList.add(moduleHolder);
                }
            }
            ArrayList<ModuleHolder> arrayList2 = arrayList;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
            for (ModuleHolder moduleHolder2 : arrayList2) {
                String name = moduleHolder2.getName();
                ViewManagerDefinition viewManagerDefinition = moduleHolder2.getDefinition().getViewManagerDefinition();
                if (viewManagerDefinition == null || (emptyList = viewManagerDefinition.getPropsNames()) == null) {
                    emptyList = CollectionsKt.emptyList();
                }
                Pair pair = TuplesKt.to(name, MapsKt.mapOf(TuplesKt.to("propsNames", emptyList)));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        } finally {
            Trace.endSection();
        }
    }

    public final List<ViewWrapperDelegateHolder> extractViewManagersDelegateHolders(List<? extends ViewManager<?, ?>> viewManagers) {
        Intrinsics.checkNotNullParameter(viewManagers, "viewManagers");
        Trace.beginSection("[ExpoModulesCore] KotlinInteropModuleRegistry.extractViewManagersDelegateHolders");
        try {
            ArrayList arrayList = new ArrayList();
            for (Object obj : viewManagers) {
                if (obj instanceof ViewWrapperDelegateHolder) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        } finally {
            Trace.endSection();
        }
    }

    public final void updateModuleHoldersInViewManagers(List<? extends ViewWrapperDelegateHolder> viewWrapperHolders) {
        Intrinsics.checkNotNullParameter(viewWrapperHolders, "viewWrapperHolders");
        Trace.beginSection("[ExpoModulesCore] KotlinInteropModuleRegistry.updateModuleHoldersInViewManagers");
        try {
            List<? extends ViewWrapperDelegateHolder> list = viewWrapperHolders;
            ArrayList<ViewManagerWrapperDelegate> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((ViewWrapperDelegateHolder) it.next()).getViewWrapperDelegate());
            }
            for (ViewManagerWrapperDelegate viewManagerWrapperDelegate : arrayList) {
                ModuleHolder<?> moduleHolder = getRegistry().getModuleHolder(viewManagerWrapperDelegate.getModuleHolder$expo_modules_core_release().getName());
                if (moduleHolder == null) {
                    throw new IllegalArgumentException(("Cannot update the module holder for " + viewManagerWrapperDelegate.getModuleHolder$expo_modules_core_release().getName() + ".").toString());
                }
                viewManagerWrapperDelegate.setModuleHolder$expo_modules_core_release(moduleHolder);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }
}
