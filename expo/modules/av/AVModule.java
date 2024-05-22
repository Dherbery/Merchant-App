package expo.modules.av;

import androidx.tracing.Trace;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: AVModule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lexpo/modules/av/AVModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "_avManager", "Lexpo/modules/av/AVManagerInterface;", "get_avManager", "()Lexpo/modules/av/AVManagerInterface;", "_avManager$delegate", "Lkotlin/Lazy;", "avManager", "getAvManager", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-av_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AVModule extends Module {

    /* renamed from: _avManager$delegate, reason: from kotlin metadata */
    private final Lazy _avManager = LazyKt.lazy(new Function0<AVManagerInterface>() { // from class: expo.modules.av.AVModule$_avManager$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AVManagerInterface invoke() {
            Object obj;
            try {
                obj = AVModule.this.getAppContext().getLegacyModuleRegistry().getModule(AVManagerInterface.class);
            } catch (Exception unused) {
                obj = null;
            }
            return (AVManagerInterface) obj;
        }
    });

    private final AVManagerInterface get_avManager() {
        return (AVManagerInterface) this._avManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AVManagerInterface getAvManager() {
        AVManagerInterface aVManagerInterface = get_avManager();
        if (aVManagerInterface != null) {
            return aVManagerInterface;
        }
        throw new AVManagerModuleNotFound();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AVModule aVModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (aVModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(aVModule);
            moduleDefinitionBuilder.Name("ExponentAV");
            moduleDefinitionBuilder.Events("didUpdatePlaybackStatus", "ExponentAV.onError", "Expo.Recording.recorderUnloaded");
            moduleDefinitionBuilder.getAsyncFunctions().put("setAudioIsEnabled", Boolean.class == Promise.class ? new AsyncFunctionWithPromiseComponent("setAudioIsEnabled", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$1
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    boolean booleanValue = ((Boolean) promise).booleanValue();
                    avManager = AVModule.this.getAvManager();
                    avManager.setAudioIsEnabled(Boolean.valueOf(booleanValue));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("setAudioIsEnabled", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        avManager = AVModule.this.getAvManager();
                        avManager.setAudioIsEnabled(Boolean.valueOf(booleanValue));
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("setAudioMode", ReadableArguments.class == Promise.class ? new AsyncFunctionWithPromiseComponent("setAudioMode", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$4
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    avManager = AVModule.this.getAvManager();
                    avManager.setAudioMode((ReadableArguments) promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("setAudioMode", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        avManager = AVModule.this.getAvManager();
                        avManager.setAudioMode((ReadableArguments) obj);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("loadForSound", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("loadForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$9
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                    }
                    ReadableArguments readableArguments = (ReadableArguments) obj;
                    Object obj2 = args[1];
                    if (obj2 != null) {
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.loadForSound(readableArguments, (ReadableArguments) obj2, legacyPromise);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("loadForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$13
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                    }
                    ReadableArguments readableArguments = (ReadableArguments) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                    }
                    ReadableArguments readableArguments2 = (ReadableArguments) obj2;
                    Object obj3 = it[2];
                    if (obj3 != null) {
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj3);
                        avManager.loadForSound(readableArguments, readableArguments2, legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("unloadForSound", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("unloadForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$15
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        int intValue = ((Integer) obj).intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.unloadForSound(valueOf, legacyPromise);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("unloadForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$18
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        int intValue = num.intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj2);
                        avManager.unloadForSound(valueOf, legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("setStatusForSound", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("setStatusForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$21
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    Object obj2 = args[1];
                    if (obj2 != null) {
                        int intValue = num.intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.setStatusForSound(valueOf, (ReadableArguments) obj2, legacyPromise);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("setStatusForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$25
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                    }
                    ReadableArguments readableArguments = (ReadableArguments) obj2;
                    Object obj3 = it[2];
                    if (obj3 != null) {
                        int intValue = num.intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj3);
                        avManager.setStatusForSound(valueOf, readableArguments, legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("replaySound", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("replaySound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$26
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$27
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$28
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    Object obj2 = args[1];
                    if (obj2 != null) {
                        int intValue = num.intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.replaySound(valueOf, (ReadableArguments) obj2, legacyPromise);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("replaySound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$29
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$31
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$32
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                    }
                    ReadableArguments readableArguments = (ReadableArguments) obj2;
                    Object obj3 = it[2];
                    if (obj3 != null) {
                        int intValue = num.intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj3);
                        avManager.replaySound(valueOf, readableArguments, legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getStatusForSound", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getStatusForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$33
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$34
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        int intValue = ((Integer) obj).intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.getStatusForSound(valueOf, legacyPromise);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getStatusForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$35
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$37
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        int intValue = num.intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj2);
                        avManager.getStatusForSound(valueOf, legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("loadForVideo", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("loadForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$38
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), true, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$39
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), true, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$40
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$41
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        ReadableArguments readableArguments = (ReadableArguments) args[1];
                        ReadableArguments readableArguments2 = (ReadableArguments) args[2];
                        int intValue = ((Integer) obj).intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.loadForVideo(valueOf, readableArguments, readableArguments2, legacyPromise);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("loadForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$42
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), true, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$43
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), true, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$44
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$45
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$46
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    ReadableArguments readableArguments = (ReadableArguments) it[1];
                    ReadableArguments readableArguments2 = (ReadableArguments) it[2];
                    Object obj2 = it[3];
                    if (obj2 != null) {
                        int intValue = num.intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj2);
                        avManager.loadForVideo(valueOf, readableArguments, readableArguments2, legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("unloadForVideo", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("unloadForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$47
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$48
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        int intValue = ((Integer) obj).intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.unloadForVideo(valueOf, legacyPromise);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("unloadForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$49
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$50
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$51
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        int intValue = num.intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj2);
                        avManager.unloadForVideo(valueOf, legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("setStatusForVideo", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("setStatusForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$52
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$53
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$54
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    Object obj2 = args[1];
                    if (obj2 != null) {
                        int intValue = num.intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.setStatusForVideo(valueOf, (ReadableArguments) obj2, legacyPromise);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("setStatusForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$55
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$56
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$57
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$58
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                    }
                    ReadableArguments readableArguments = (ReadableArguments) obj2;
                    Object obj3 = it[2];
                    if (obj3 != null) {
                        int intValue = num.intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj3);
                        avManager.setStatusForVideo(valueOf, readableArguments, legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("replayVideo", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("replayVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$59
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$60
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$61
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    Object obj2 = args[1];
                    if (obj2 != null) {
                        int intValue = num.intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.replayVideo(valueOf, (ReadableArguments) obj2, legacyPromise);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("replayVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$62
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$63
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$64
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$65
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                    }
                    ReadableArguments readableArguments = (ReadableArguments) obj2;
                    Object obj3 = it[2];
                    if (obj3 != null) {
                        int intValue = num.intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj3);
                        avManager.replayVideo(valueOf, readableArguments, legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getStatusForVideo", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getStatusForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$66
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$67
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        int intValue = ((Integer) obj).intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.getStatusForVideo(valueOf, legacyPromise);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getStatusForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$68
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$69
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$70
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    Integer num = (Integer) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        int intValue = num.intValue();
                        avManager = AVModule.this.getAvManager();
                        Integer valueOf = Integer.valueOf(intValue);
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj2);
                        avManager.getStatusForVideo(valueOf, legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("prepareAudioRecorder", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("prepareAudioRecorder", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$71
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$72
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.prepareAudioRecorder((ReadableArguments) obj, legacyPromise);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("prepareAudioRecorder", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$73
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$74
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$75
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                    }
                    ReadableArguments readableArguments = (ReadableArguments) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj2);
                        avManager.prepareAudioRecorder(readableArguments, legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getAvailableInputs", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getAvailableInputs", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$76
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    avManager = AVModule.this.getAvManager();
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.getAvailableInputs(legacyPromise);
                }
            }) : new AsyncFunctionComponent("getAvailableInputs", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$77
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$78
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj);
                        avManager.getAvailableInputs(legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getCurrentInput", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getCurrentInput", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$79
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    avManager = AVModule.this.getAvManager();
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.getCurrentInput(legacyPromise);
                }
            }) : new AsyncFunctionComponent("getCurrentInput", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$80
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$81
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj);
                        avManager.getCurrentInput(legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("setInput", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("setInput", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$82
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$83
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.setInput((String) obj, legacyPromise);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("setInput", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$84
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$85
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$86
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj2);
                        avManager.setInput(str, legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("startAudioRecording", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("startAudioRecording", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$87
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    avManager = AVModule.this.getAvManager();
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.startAudioRecording(legacyPromise);
                }
            }) : new AsyncFunctionComponent("startAudioRecording", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$88
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$89
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj);
                        avManager.startAudioRecording(legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("pauseAudioRecording", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("pauseAudioRecording", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$90
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    avManager = AVModule.this.getAvManager();
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.pauseAudioRecording(legacyPromise);
                }
            }) : new AsyncFunctionComponent("pauseAudioRecording", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$91
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$92
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj);
                        avManager.pauseAudioRecording(legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("stopAudioRecording", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("stopAudioRecording", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$93
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    avManager = AVModule.this.getAvManager();
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.stopAudioRecording(legacyPromise);
                }
            }) : new AsyncFunctionComponent("stopAudioRecording", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$94
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$95
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj);
                        avManager.stopAudioRecording(legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getAudioRecordingStatus", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getAudioRecordingStatus", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$96
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    avManager = AVModule.this.getAvManager();
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.getAudioRecordingStatus(legacyPromise);
                }
            }) : new AsyncFunctionComponent("getAudioRecordingStatus", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$97
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$98
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj);
                        avManager.getAudioRecordingStatus(legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("unloadAudioRecorder", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("unloadAudioRecorder", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$99
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    avManager = AVModule.this.getAvManager();
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.unloadAudioRecorder(legacyPromise);
                }
            }) : new AsyncFunctionComponent("unloadAudioRecorder", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$100
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$101
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise((Promise) obj);
                        avManager.unloadAudioRecorder(legacyPromise);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("requestPermissionsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$102
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Permissions.CC.askForPermissionsWithPermissionsManager(AVModule.this.getAppContext().getPermissions(), promise, "android.permission.RECORD_AUDIO");
                }
            }) : new AsyncFunctionComponent("requestPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$103
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$104
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    Permissions.CC.askForPermissionsWithPermissionsManager(AVModule.this.getAppContext().getPermissions(), (Promise) obj, "android.permission.RECORD_AUDIO");
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getPermissionsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$105
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Permissions.CC.getPermissionsWithPermissionsManager(AVModule.this.getAppContext().getPermissions(), promise, "android.permission.RECORD_AUDIO");
                }
            }) : new AsyncFunctionComponent("getPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$106
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.av.AVModule$definition$lambda$23$$inlined$AsyncFunction$107
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    Permissions.CC.getPermissionsWithPermissionsManager(AVModule.this.getAppContext().getPermissions(), (Promise) obj, "android.permission.RECORD_AUDIO");
                    return Unit.INSTANCE;
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
