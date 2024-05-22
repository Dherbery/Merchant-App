package expo.modules.splashscreen;

import android.app.Activity;
import androidx.tracing.Trace;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.splashscreen.singletons.SplashScreen;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: SplashScreenModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lexpo/modules/splashscreen/SplashScreenModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-splash-screen_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SplashScreenModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        SplashScreenModule splashScreenModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (splashScreenModule.getClass() + ".ModuleDefinition"));
        try {
            final ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(splashScreenModule);
            moduleDefinitionBuilder.Name("ExpoSplashScreen");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Promise.class == Promise.class) {
                asyncFunctionComponent = new AsyncFunctionWithPromiseComponent("preventAutoHideAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.splashscreen.SplashScreenModule$definition$lambda$6$$inlined$AsyncFunction$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        Unit unit;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Activity currentActivity = SplashScreenModule.this.getAppContext().getCurrentActivity();
                        if (currentActivity != null) {
                            SplashScreen.INSTANCE.preventAutoHide(currentActivity, new SplashScreenModule$definition$1$1$1$1(promise), new SplashScreenModule$definition$1$1$1$2(promise));
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            promise.resolve(false);
                        }
                    }
                });
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent("preventAutoHideAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.splashscreen.SplashScreenModule$definition$lambda$6$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.splashscreen.SplashScreenModule$definition$lambda$6$$inlined$AsyncFunction$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                        }
                        Promise promise = (Promise) obj;
                        Activity currentActivity = SplashScreenModule.this.getAppContext().getCurrentActivity();
                        if (currentActivity != null) {
                            SplashScreen.INSTANCE.preventAutoHide(currentActivity, new SplashScreenModule$definition$1$1$1$1(promise), new SplashScreenModule$definition$1$1$1$2(promise));
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            promise.resolve(false);
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("preventAutoHideAsync", asyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Promise.class == Promise.class) {
                asyncFunctionComponent2 = new AsyncFunctionWithPromiseComponent("hideAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.splashscreen.SplashScreenModule$definition$lambda$6$$inlined$AsyncFunction$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        Unit unit;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Activity currentActivity = SplashScreenModule.this.getAppContext().getCurrentActivity();
                        if (currentActivity != null) {
                            SplashScreen.INSTANCE.hide(currentActivity, new SplashScreenModule$definition$1$2$1$1(promise), new SplashScreenModule$definition$1$2$1$2(promise));
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            promise.resolve(false);
                        }
                    }
                });
            } else {
                asyncFunctionComponent2 = new AsyncFunctionComponent("hideAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.splashscreen.SplashScreenModule$definition$lambda$6$$inlined$AsyncFunction$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.splashscreen.SplashScreenModule$definition$lambda$6$$inlined$AsyncFunction$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                        }
                        Promise promise = (Promise) obj;
                        Activity currentActivity = SplashScreenModule.this.getAppContext().getCurrentActivity();
                        if (currentActivity != null) {
                            SplashScreen.INSTANCE.hide(currentActivity, new SplashScreenModule$definition$1$2$1$1(promise), new SplashScreenModule$definition$1$2$1$2(promise));
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            promise.resolve(false);
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("hideAsync", asyncFunctionComponent2);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
