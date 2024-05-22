package expo.modules.adapters.react;

import android.util.SparseArray;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.ExpoModulesHelper;
import expo.modules.kotlin.KPromiseWrapper;
import expo.modules.kotlin.KotlinInteropModuleRegistry;
import expo.modules.kotlin.ModulesProvider;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
public class NativeModulesProxy extends ReactContextBaseJavaModule {
    private static final String ARGS_TYPES_MISMATCH_ERROR = "E_ARGS_TYPES_MISMATCH";
    private static final String EXPORTED_METHODS_KEY = "exportedMethods";
    private static final String METHOD_INFO_ARGUMENTS_COUNT = "argumentsCount";
    private static final String METHOD_INFO_KEY = "key";
    private static final String METHOD_INFO_NAME = "name";
    private static final String MODULES_CONSTANTS_KEY = "modulesConstants";
    private static final String NAME = "NativeUnimoduleProxy";
    private static final String UNDEFINED_METHOD_ERROR = "E_UNDEFINED_METHOD";
    private static final String UNEXPECTED_ERROR = "E_UNEXPECTED_ERROR";
    private static final String VIEW_MANAGERS_METADATA_KEY = "viewManagersMetadata";
    private Map<String, Object> cachedConstants;
    private Map<String, Map<String, Integer>> mExportedMethodsKeys;
    private Map<String, SparseArray<String>> mExportedMethodsReverseKeys;
    private KotlinInteropModuleRegistry mKotlinInteropModuleRegistry;
    private ModuleRegistry mModuleRegistry;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    public NativeModulesProxy(ReactApplicationContext reactApplicationContext, ModuleRegistry moduleRegistry) {
        super(reactApplicationContext);
        this.mModuleRegistry = moduleRegistry;
        this.mExportedMethodsKeys = new HashMap();
        this.mExportedMethodsReverseKeys = new HashMap();
        this.mKotlinInteropModuleRegistry = new KotlinInteropModuleRegistry((ModulesProvider) Objects.requireNonNull(ExpoModulesHelper.INSTANCE.getModulesProvider()), moduleRegistry, new WeakReference(reactApplicationContext));
    }

    public NativeModulesProxy(ReactApplicationContext reactApplicationContext, ModuleRegistry moduleRegistry, ModulesProvider modulesProvider) {
        super(reactApplicationContext);
        this.mModuleRegistry = moduleRegistry;
        this.mExportedMethodsKeys = new HashMap();
        this.mExportedMethodsReverseKeys = new HashMap();
        this.mKotlinInteropModuleRegistry = new KotlinInteropModuleRegistry((ModulesProvider) Objects.requireNonNull(modulesProvider), moduleRegistry, new WeakReference(reactApplicationContext));
    }

    public KotlinInteropModuleRegistry getKotlinInteropModuleRegistry() {
        return this.mKotlinInteropModuleRegistry;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @Nullable
    public Map<String, Object> getConstants() {
        Map<String, Object> map = this.cachedConstants;
        if (map != null) {
            return map;
        }
        this.mModuleRegistry.ensureIsInitialized();
        KotlinInteropModuleRegistry kotlinInteropModuleRegistry = getKotlinInteropModuleRegistry();
        kotlinInteropModuleRegistry.emitOnCreate();
        kotlinInteropModuleRegistry.installJSIInterop();
        Collection<ExportedModule> allExportedModules = this.mModuleRegistry.getAllExportedModules();
        HashMap hashMap = new HashMap(allExportedModules.size());
        HashMap hashMap2 = new HashMap(allExportedModules.size());
        for (ExportedModule exportedModule : allExportedModules) {
            String name = exportedModule.getName();
            hashMap.put(name, exportedModule.getConstants());
            List<Map<String, Object>> transformExportedMethodsMap = transformExportedMethodsMap(exportedModule.getExportedMethods());
            assignExportedMethodsKeys(name, transformExportedMethodsMap);
            hashMap2.put(name, transformExportedMethodsMap);
        }
        hashMap.putAll(this.mKotlinInteropModuleRegistry.exportedModulesConstants());
        hashMap2.putAll(this.mKotlinInteropModuleRegistry.exportMethods(new Function2() { // from class: expo.modules.adapters.react.NativeModulesProxy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit lambda$getConstants$0;
                lambda$getConstants$0 = NativeModulesProxy.this.lambda$getConstants$0((String) obj, (List) obj2);
                return lambda$getConstants$0;
            }
        }));
        HashMap hashMap3 = new HashMap(3);
        hashMap3.put(MODULES_CONSTANTS_KEY, hashMap);
        hashMap3.put(EXPORTED_METHODS_KEY, hashMap2);
        hashMap3.put(VIEW_MANAGERS_METADATA_KEY, this.mKotlinInteropModuleRegistry.viewManagersMetadata());
        CoreLoggerKt.getLogger().info("✅ Constants were exported");
        this.cachedConstants = hashMap3;
        return hashMap3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$getConstants$0(String str, List list) {
        assignExportedMethodsKeys(str, list);
        return null;
    }

    @ReactMethod
    public void callMethod(String str, Dynamic dynamic, ReadableArray readableArray, Promise promise) {
        String str2;
        if (dynamic.getType() == ReadableType.String) {
            str2 = dynamic.asString();
        } else if (dynamic.getType() == ReadableType.Number) {
            str2 = this.mExportedMethodsReverseKeys.get(str).get(dynamic.asInt());
        } else {
            promise.reject(UNEXPECTED_ERROR, "Method key is neither a String nor an Integer -- don't know how to map it to method name.");
            return;
        }
        callMethod(str, str2, readableArray, promise);
    }

    public void callMethod(String str, String str2, ReadableArray readableArray, Promise promise) {
        if (this.mKotlinInteropModuleRegistry.hasModule(str)) {
            this.mKotlinInteropModuleRegistry.callMethod(str, str2, readableArray, new KPromiseWrapper(promise));
            return;
        }
        try {
            List<Object> nativeArgumentsForMethod = getNativeArgumentsForMethod(readableArray, this.mModuleRegistry.getExportedModule(str).getExportedMethodInfos().get(str2));
            nativeArgumentsForMethod.add(new PromiseWrapper(promise));
            this.mModuleRegistry.getExportedModule(str).invokeExportedMethod(str2, nativeArgumentsForMethod);
        } catch (IllegalArgumentException e) {
            promise.reject(ARGS_TYPES_MISMATCH_ERROR, e.getMessage(), e);
        } catch (NoSuchMethodException e2) {
            promise.reject(UNDEFINED_METHOD_ERROR, "Method " + str2 + " of Java module " + str + " is undefined.", e2);
        } catch (RuntimeException e3) {
            promise.reject(UNEXPECTED_ERROR, "Encountered an exception while calling native method: " + e3.getMessage(), e3);
        }
    }

    private static List<Object> getNativeArgumentsForMethod(ReadableArray readableArray, ExportedModule.MethodInfo methodInfo) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(ArgumentsHelper.getNativeArgumentForExpectedClass(readableArray.getDynamic(i), methodInfo.getParameterTypes()[i]));
        }
        return arrayList;
    }

    private List<Map<String, Object>> transformExportedMethodsMap(Map<String, Method> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, Method> entry : map.entrySet()) {
            arrayList.add(getMethodInfo(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private Map<String, Object> getMethodInfo(String str, Method method) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("name", str);
        hashMap.put(METHOD_INFO_ARGUMENTS_COUNT, Integer.valueOf(method.getParameterTypes().length - 1));
        return hashMap;
    }

    private void assignExportedMethodsKeys(String str, List<Map<String, Object>> list) {
        if (this.mExportedMethodsKeys.get(str) == null) {
            this.mExportedMethodsKeys.put(str, new HashMap());
        }
        if (this.mExportedMethodsReverseKeys.get(str) == null) {
            this.mExportedMethodsReverseKeys.put(str, new SparseArray<>());
        }
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            if (map.get("name") == null || !(map.get("name") instanceof String)) {
                throw new RuntimeException("No method name in MethodInfo - " + map.toString());
            }
            String str2 = (String) map.get("name");
            Integer num = this.mExportedMethodsKeys.get(str).get(str2);
            if (num == null) {
                int size = this.mExportedMethodsKeys.get(str).values().size();
                map.put("key", Integer.valueOf(size));
                this.mExportedMethodsKeys.get(str).put(str2, Integer.valueOf(size));
                this.mExportedMethodsReverseKeys.get(str).put(size, str2);
            } else {
                map.put("key", Integer.valueOf(num.intValue()));
            }
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        this.mModuleRegistry.onDestroy();
        this.mKotlinInteropModuleRegistry.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModuleRegistry getModuleRegistry() {
        return this.mModuleRegistry;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReactApplicationContext getReactContext() {
        return getReactApplicationContext();
    }
}
