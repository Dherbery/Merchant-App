package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.soloader.SoLoader;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.ModuleRegistry;
import expo.modules.kotlin.defaultmodules.CoreModule;
import expo.modules.kotlin.exception.JavaScriptEvaluateException;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.kotlin.sharedobjects.SharedObjectId;
import expo.modules.kotlin.sharedobjects.SharedObjectRegistry;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JSIInteropModuleRegistry.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\f\u001a\u00020\rH\u0086 J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u000fH\u0086 J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086 J\b\u0010\u0015\u001a\u00020\u000fH\u0004J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u0014H\u0007J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u001bH\u0007¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\rH\u0086 J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u0014H\u0007J\t\u0010 \u001a\u00020\u000bH\u0082 J!\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0086 J\u0006\u0010(\u001a\u00020\u000fJ\u0011\u0010(\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0086 J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\rH\u0007J\t\u0010-\u001a\u00020\u000fH\u0086 R\"\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lexpo/modules/kotlin/jni/JSIInteropModuleRegistry;", "Lexpo/modules/kotlin/jni/Destructible;", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Lexpo/modules/kotlin/AppContext;)V", "appContextHolder", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getAppContextHolder$expo_modules_core_release", "()Ljava/lang/ref/WeakReference;", "mHybridData", "Lcom/facebook/jni/HybridData;", "createObject", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "deallocate", "", "drainJSEventLoop", "evaluateScript", "Lexpo/modules/kotlin/jni/JavaScriptValue;", "script", "", "finalize", "getCoreModuleObject", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "getJavaScriptModuleObject", "name", "getJavaScriptModulesName", "", "()[Ljava/lang/String;", "global", "hasModule", "", "initHybrid", "installJSI", "jsRuntimePointer", "", "jniDeallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "jsInvokerHolder", "Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;", "installJSIForTests", "registerSharedObject", "native", "", "js", "wasDeallocated", "Companion", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JSIInteropModuleRegistry implements Destructible {
    private final WeakReference<AppContext> appContextHolder;
    private final HybridData mHybridData;

    private final native HybridData initHybrid();

    public final native JavaScriptObject createObject();

    public final native void drainJSEventLoop();

    public final native JavaScriptValue evaluateScript(String script) throws JavaScriptEvaluateException;

    public final native JavaScriptObject global();

    public final native void installJSI(long jsRuntimePointer, JNIDeallocator jniDeallocator, CallInvokerHolderImpl jsInvokerHolder);

    public final native void installJSIForTests(JNIDeallocator jniDeallocator);

    public final native void wasDeallocated();

    public JSIInteropModuleRegistry(AppContext appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContextHolder = new WeakReference<>(appContext);
        this.mHybridData = initHybrid();
    }

    public final WeakReference<AppContext> getAppContextHolder$expo_modules_core_release() {
        return this.appContextHolder;
    }

    public final void installJSIForTests() {
        AppContext appContext = this.appContextHolder.get();
        Intrinsics.checkNotNull(appContext);
        installJSIForTests(appContext.getJniDeallocator());
    }

    public final JavaScriptModuleObject getJavaScriptModuleObject(String name) {
        ModuleRegistry registry;
        ModuleHolder<?> moduleHolder;
        Intrinsics.checkNotNullParameter(name, "name");
        AppContext appContext = this.appContextHolder.get();
        if (appContext == null || (registry = appContext.getRegistry()) == null || (moduleHolder = registry.getModuleHolder(name)) == null) {
            return null;
        }
        return moduleHolder.getJsObject();
    }

    public final boolean hasModule(String name) {
        ModuleRegistry registry;
        Intrinsics.checkNotNullParameter(name, "name");
        AppContext appContext = this.appContextHolder.get();
        if (appContext == null || (registry = appContext.getRegistry()) == null) {
            return false;
        }
        return registry.hasModule(name);
    }

    public final String[] getJavaScriptModulesName() {
        ModuleRegistry registry;
        Map<String, ModuleHolder<?>> registry2;
        Set<String> keySet;
        String[] strArr;
        AppContext appContext = this.appContextHolder.get();
        return (appContext == null || (registry = appContext.getRegistry()) == null || (registry2 = registry.getRegistry()) == null || (keySet = registry2.keySet()) == null || (strArr = (String[]) keySet.toArray(new String[0])) == null) ? new String[0] : strArr;
    }

    public final void registerSharedObject(Object r2, JavaScriptObject js) {
        SharedObjectRegistry sharedObjectRegistry;
        Intrinsics.checkNotNullParameter(r2, "native");
        Intrinsics.checkNotNullParameter(js, "js");
        AppContext appContext = this.appContextHolder.get();
        if (appContext == null || (sharedObjectRegistry = appContext.getSharedObjectRegistry()) == null) {
            return;
        }
        SharedObjectId.m1274boximpl(sharedObjectRegistry.m1284add5WKnsLU$expo_modules_core_release((SharedObject) r2, js));
    }

    public final JavaScriptModuleObject getCoreModuleObject() {
        ModuleHolder<CoreModule> coreModule$expo_modules_core_release;
        AppContext appContext = this.appContextHolder.get();
        if (appContext == null || (coreModule$expo_modules_core_release = appContext.getCoreModule$expo_modules_core_release()) == null) {
            return null;
        }
        return coreModule$expo_modules_core_release.getJsObject();
    }

    protected final void finalize() throws Throwable {
        deallocate();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    public void deallocate() {
        this.mHybridData.resetNative();
    }

    static {
        SoLoader.loadLibrary("expo-modules-core");
    }
}
