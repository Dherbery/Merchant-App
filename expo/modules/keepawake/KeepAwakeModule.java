package expo.modules.keepawake;

import androidx.tracing.Trace;
import expo.modules.core.errors.CurrentActivityNotFoundException;
import expo.modules.core.interfaces.services.KeepAwakeManager;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: KeepAwakeModule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lexpo/modules/keepawake/KeepAwakeModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "keepAwakeManager", "Lexpo/modules/core/interfaces/services/KeepAwakeManager;", "getKeepAwakeManager", "()Lexpo/modules/core/interfaces/services/KeepAwakeManager;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-keep-awake_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KeepAwakeModule extends Module {
    /* JADX INFO: Access modifiers changed from: private */
    public final KeepAwakeManager getKeepAwakeManager() {
        Object obj;
        try {
            obj = getAppContext().getLegacyModuleRegistry().getModule(KeepAwakeManager.class);
        } catch (Exception unused) {
            obj = null;
        }
        KeepAwakeManager keepAwakeManager = (KeepAwakeManager) obj;
        if (keepAwakeManager != null) {
            return keepAwakeManager;
        }
        throw new MissingModuleException("KeepAwakeManager");
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        KeepAwakeModule keepAwakeModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (keepAwakeModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(keepAwakeModule);
            moduleDefinitionBuilder.Name("ExpoKeepAwake");
            moduleDefinitionBuilder.getAsyncFunctions().put("activate", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("activate", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$2
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    KeepAwakeManager keepAwakeManager;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        String str = (String) obj;
                        try {
                            keepAwakeManager = KeepAwakeModule.this.getKeepAwakeManager();
                            keepAwakeManager.activate(str, new KeepAwakeModule$definition$1$1$1(promise));
                            return;
                        } catch (CurrentActivityNotFoundException unused) {
                            promise.reject(new ActivateKeepAwakeException());
                            return;
                        }
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("activate", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    KeepAwakeManager keepAwakeManager;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        Promise promise = (Promise) obj2;
                        try {
                            keepAwakeManager = KeepAwakeModule.this.getKeepAwakeManager();
                            keepAwakeManager.activate(str, new KeepAwakeModule$definition$1$1$1(promise));
                        } catch (CurrentActivityNotFoundException unused) {
                            promise.reject(new ActivateKeepAwakeException());
                        }
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("deactivate", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("deactivate", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$7
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    KeepAwakeManager keepAwakeManager;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        String str = (String) obj;
                        try {
                            keepAwakeManager = KeepAwakeModule.this.getKeepAwakeManager();
                            keepAwakeManager.deactivate(str, new KeepAwakeModule$definition$1$2$1(promise));
                            return;
                        } catch (CurrentActivityNotFoundException unused) {
                            promise.reject(new DeactivateKeepAwakeException());
                            return;
                        }
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("deactivate", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$10
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    KeepAwakeManager keepAwakeManager;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        Promise promise = (Promise) obj2;
                        try {
                            keepAwakeManager = KeepAwakeModule.this.getKeepAwakeManager();
                            keepAwakeManager.deactivate(str, new KeepAwakeModule$definition$1$2$1(promise));
                        } catch (CurrentActivityNotFoundException unused) {
                            promise.reject(new DeactivateKeepAwakeException());
                        }
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("isActivated", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    KeepAwakeManager keepAwakeManager;
                    Intrinsics.checkNotNullParameter(it, "it");
                    keepAwakeManager = KeepAwakeModule.this.getKeepAwakeManager();
                    return Boolean.valueOf(keepAwakeManager.isActivated());
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("isActivated", asyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionComponent;
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
