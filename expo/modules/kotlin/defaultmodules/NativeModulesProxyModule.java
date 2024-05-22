package expo.modules.kotlin.defaultmodules;

import androidx.tracing.Trace;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReadableArray;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.PromiseKt;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: NativeModulesProxyModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/defaultmodules/NativeModulesProxyModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NativeModulesProxyModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        NativeModulesProxyModule nativeModulesProxyModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (nativeModulesProxyModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(nativeModulesProxyModule);
            moduleDefinitionBuilder.Name(NativeModulesProxyModuleKt.NativeModulesProxyModuleName);
            moduleDefinitionBuilder.Constants(new Function0<Map<String, ? extends Object>>() { // from class: expo.modules.kotlin.defaultmodules.NativeModulesProxyModule$definition$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends Object> invoke() {
                    BaseJavaModule baseJavaModule;
                    WeakReference<NativeModulesProxy> legacyModulesProxyHolder$expo_modules_core_release = NativeModulesProxyModule.this.getAppContext().getLegacyModulesProxyHolder$expo_modules_core_release();
                    Map<String, Object> constants = (legacyModulesProxyHolder$expo_modules_core_release == null || (baseJavaModule = (NativeModulesProxy) legacyModulesProxyHolder$expo_modules_core_release.get()) == null) ? null : baseJavaModule.getConstants();
                    return constants == null ? MapsKt.emptyMap() : constants;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("callMethod", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("callMethod", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.NativeModulesProxyModule$definition$lambda$1$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.NativeModulesProxyModule$definition$lambda$1$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArray.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.NativeModulesProxyModule$definition$lambda$1$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArray.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.defaultmodules.NativeModulesProxyModule$definition$lambda$1$$inlined$AsyncFunction$4
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    NativeModulesProxy nativeModulesProxy;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = args[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str2 = (String) obj2;
                    Object obj3 = args[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReadableArray");
                    }
                    ReadableArray readableArray = (ReadableArray) obj3;
                    com.facebook.react.bridge.Promise bridgePromise = PromiseKt.toBridgePromise(promise);
                    WeakReference<NativeModulesProxy> legacyModulesProxyHolder$expo_modules_core_release = NativeModulesProxyModule.this.getAppContext().getLegacyModulesProxyHolder$expo_modules_core_release();
                    if (legacyModulesProxyHolder$expo_modules_core_release == null || (nativeModulesProxy = legacyModulesProxyHolder$expo_modules_core_release.get()) == null) {
                        throw new UnexpectedException("The legacy modules proxy holder has been lost");
                    }
                    Intrinsics.checkNotNullExpressionValue(nativeModulesProxy, "appContext.legacyModules…xy holder has been lost\")");
                    nativeModulesProxy.callMethod(str, str2, readableArray, bridgePromise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("callMethod", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.NativeModulesProxyModule$definition$lambda$1$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.NativeModulesProxyModule$definition$lambda$1$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArray.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.NativeModulesProxyModule$definition$lambda$1$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArray.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.NativeModulesProxyModule$definition$lambda$1$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.defaultmodules.NativeModulesProxyModule$definition$lambda$1$$inlined$AsyncFunction$9
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    NativeModulesProxy nativeModulesProxy;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str2 = (String) obj2;
                    Object obj3 = it[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReadableArray");
                    }
                    ReadableArray readableArray = (ReadableArray) obj3;
                    Object obj4 = it[3];
                    if (obj4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    com.facebook.react.bridge.Promise bridgePromise = PromiseKt.toBridgePromise((Promise) obj4);
                    WeakReference<NativeModulesProxy> legacyModulesProxyHolder$expo_modules_core_release = NativeModulesProxyModule.this.getAppContext().getLegacyModulesProxyHolder$expo_modules_core_release();
                    if (legacyModulesProxyHolder$expo_modules_core_release == null || (nativeModulesProxy = legacyModulesProxyHolder$expo_modules_core_release.get()) == null) {
                        throw new UnexpectedException("The legacy modules proxy holder has been lost");
                    }
                    Intrinsics.checkNotNullExpressionValue(nativeModulesProxy, "appContext.legacyModules…xy holder has been lost\")");
                    nativeModulesProxy.callMethod(str, str2, readableArray, bridgePromise);
                    return Unit.INSTANCE;
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
