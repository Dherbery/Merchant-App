package expo.modules.screenorientation;

import android.app.Activity;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.tracing.Trace;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.screenorientation.enums.Orientation;
import expo.modules.screenorientation.enums.OrientationAttr;
import expo.modules.screenorientation.enums.OrientationLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: ScreenOrientationModule.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u001f"}, d2 = {"Lexpo/modules/screenorientation/ScreenOrientationModule;", "Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/core/interfaces/LifecycleEventListener;", "()V", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "initialOrientation", "", "Ljava/lang/Integer;", "uiManager", "Lexpo/modules/core/interfaces/services/UIManager;", "getUiManager", "()Lexpo/modules/core/interfaces/services/UIManager;", "weakCurrentActivity", "getWeakCurrentActivity", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getScreenOrientation", "Lexpo/modules/screenorientation/enums/Orientation;", "activity", "isPortraitNaturalOrientation", "", ViewProps.ROTATION, "width", "height", "onHostDestroy", "", "onHostPause", "onHostResume", "expo-screen-orientation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScreenOrientationModule extends Module implements LifecycleEventListener {
    private Integer initialOrientation;

    private final boolean isPortraitNaturalOrientation(int rotation, int width, int height) {
        if ((rotation == 0 || rotation == 2) && height > width) {
            return true;
        }
        return (rotation == 1 || rotation == 3) && width > height;
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostPause() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getWeakCurrentActivity() {
        ActivityProvider activityProvider = getAppContext().getActivityProvider();
        if (activityProvider != null) {
            return activityProvider.getCurrentActivity();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getCurrentActivity() {
        Activity weakCurrentActivity = getWeakCurrentActivity();
        if (weakCurrentActivity != null) {
            return weakCurrentActivity;
        }
        throw new Exceptions.MissingActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UIManager getUiManager() {
        UIManager uIManager = (UIManager) getAppContext().getLegacyModuleRegistry().getModule(UIManager.class);
        if (uIManager != null) {
            return uIManager;
        }
        throw new IllegalStateException("Could not find implementation for UIManager.");
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionComponent asyncFunctionComponent3;
        ScreenOrientationModule screenOrientationModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (screenOrientationModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(screenOrientationModule);
            moduleDefinitionBuilder.Name("ExpoScreenOrientation");
            moduleDefinitionBuilder.Events("expoDidUpdateDimensions");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (OrientationLock.class == Promise.class) {
                asyncFunctionComponent = new AsyncFunctionWithPromiseComponent("lockAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Activity currentActivity;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        OrientationLock orientationLock = (OrientationLock) promise;
                        try {
                            currentActivity = ScreenOrientationModule.this.getCurrentActivity();
                            currentActivity.setRequestedOrientation(orientationLock.toPlatformInt$expo_screen_orientation_release());
                        } catch (InvalidArgumentException e) {
                            throw new InvalidOrientationLockException(orientationLock.getValue(), e);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent("lockAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(OrientationLock.class), false, new Function0<KType>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(OrientationLock.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        Activity currentActivity;
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj != null) {
                            OrientationLock orientationLock = (OrientationLock) obj;
                            try {
                                currentActivity = ScreenOrientationModule.this.getCurrentActivity();
                                currentActivity.setRequestedOrientation(orientationLock.toPlatformInt$expo_screen_orientation_release());
                                return Unit.INSTANCE;
                            } catch (InvalidArgumentException e) {
                                throw new InvalidOrientationLockException(orientationLock.getValue(), e);
                            }
                        }
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.screenorientation.enums.OrientationLock");
                    }
                });
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("lockAsync", asyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (OrientationAttr.class == Promise.class) {
                asyncFunctionComponent2 = new AsyncFunctionWithPromiseComponent("lockPlatformAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$4
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Activity currentActivity;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        currentActivity = ScreenOrientationModule.this.getCurrentActivity();
                        currentActivity.setRequestedOrientation(((OrientationAttr) promise).getValue());
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                asyncFunctionComponent2 = new AsyncFunctionComponent("lockPlatformAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(OrientationAttr.class), false, new Function0<KType>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(OrientationAttr.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        Activity currentActivity;
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj != null) {
                            currentActivity = ScreenOrientationModule.this.getCurrentActivity();
                            currentActivity.setRequestedOrientation(((OrientationAttr) obj).getValue());
                            return Unit.INSTANCE;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.screenorientation.enums.OrientationAttr");
                    }
                });
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("lockPlatformAsync", asyncFunctionComponent2);
            AsyncFunctionComponent asyncFunctionComponent4 = new AsyncFunctionComponent("getOrientationAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Activity currentActivity;
                    Orientation screenOrientation;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ScreenOrientationModule screenOrientationModule2 = ScreenOrientationModule.this;
                    currentActivity = screenOrientationModule2.getCurrentActivity();
                    screenOrientation = screenOrientationModule2.getScreenOrientation(currentActivity);
                    return Integer.valueOf(screenOrientation.getValue());
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getOrientationAsync", asyncFunctionComponent4);
            AsyncFunctionComponent asyncFunctionComponent5 = asyncFunctionComponent4;
            AsyncFunctionComponent asyncFunctionComponent6 = new AsyncFunctionComponent("getOrientationLockAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunctionWithoutArgs$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Activity currentActivity;
                    Intrinsics.checkNotNullParameter(it, "it");
                    try {
                        OrientationLock.Companion companion = OrientationLock.INSTANCE;
                        currentActivity = ScreenOrientationModule.this.getCurrentActivity();
                        return companion.fromPlatformInt(currentActivity.getRequestedOrientation());
                    } catch (Exception e) {
                        throw new GetOrientationLockException(e);
                    }
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getOrientationLockAsync", asyncFunctionComponent6);
            AsyncFunctionComponent asyncFunctionComponent7 = asyncFunctionComponent6;
            AsyncFunctionComponent asyncFunctionComponent8 = new AsyncFunctionComponent("getPlatformOrientationLockAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunctionWithoutArgs$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Activity currentActivity;
                    Intrinsics.checkNotNullParameter(it, "it");
                    try {
                        currentActivity = ScreenOrientationModule.this.getCurrentActivity();
                        return Integer.valueOf(currentActivity.getRequestedOrientation());
                    } catch (Exception e) {
                        throw new GetPlatformOrientationLockException(e);
                    }
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getPlatformOrientationLockAsync", asyncFunctionComponent8);
            AsyncFunctionComponent asyncFunctionComponent9 = asyncFunctionComponent8;
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Integer.class == Promise.class) {
                asyncFunctionComponent3 = new AsyncFunctionWithPromiseComponent("supportsOrientationLockAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$7
                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        OrientationLock.INSTANCE.supportsOrientationLock(((Integer) promise).intValue());
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                asyncFunctionComponent3 = new AsyncFunctionComponent("supportsOrientationLockAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                        }
                        return Boolean.valueOf(OrientationLock.INSTANCE.supportsOrientationLock(((Integer) obj).intValue()));
                    }
                });
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("supportsOrientationLockAsync", asyncFunctionComponent3);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$OnCreate$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    UIManager uiManager;
                    uiManager = ScreenOrientationModule.this.getUiManager();
                    uiManager.registerLifecycleEventListener(ScreenOrientationModule.this);
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$OnDestroy$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    UIManager uiManager;
                    Integer num;
                    Activity weakCurrentActivity;
                    uiManager = ScreenOrientationModule.this.getUiManager();
                    uiManager.unregisterLifecycleEventListener(ScreenOrientationModule.this);
                    num = ScreenOrientationModule.this.initialOrientation;
                    if (num != null) {
                        int intValue = num.intValue();
                        weakCurrentActivity = ScreenOrientationModule.this.getWeakCurrentActivity();
                        if (weakCurrentActivity == null) {
                            return;
                        }
                        weakCurrentActivity.setRequestedOrientation(intValue);
                    }
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostResume() {
        Integer num = this.initialOrientation;
        if (num == null) {
            Activity weakCurrentActivity = getWeakCurrentActivity();
            num = weakCurrentActivity != null ? Integer.valueOf(weakCurrentActivity.getRequestedOrientation()) : null;
        }
        this.initialOrientation = num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Orientation getScreenOrientation(Activity activity) {
        int rotation;
        DisplayMetrics displayMetrics;
        WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        int systemBars;
        Insets insetsIgnoringVisibility;
        Rect bounds;
        int i;
        int i2;
        Rect bounds2;
        int i3;
        int i4;
        Display display;
        WindowManager windowManager = activity.getWindowManager();
        if (windowManager == null) {
            return Orientation.UNKNOWN;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            display = getCurrentActivity().getWindow().getContext().getDisplay();
            if (display == null) {
                return Orientation.UNKNOWN;
            }
            rotation = display.getRotation();
        } else {
            rotation = windowManager.getDefaultDisplay().getRotation();
        }
        if (Build.VERSION.SDK_INT >= 30) {
            currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "windowManager.currentWindowMetrics");
            windowInsets = currentWindowMetrics.getWindowInsets();
            systemBars = WindowInsets.Type.systemBars();
            insetsIgnoringVisibility = windowInsets.getInsetsIgnoringVisibility(systemBars);
            Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "windowMetrics.windowInse…Insets.Type.systemBars())");
            displayMetrics = new DisplayMetrics();
            bounds = currentWindowMetrics.getBounds();
            int width = bounds.width();
            i = insetsIgnoringVisibility.left;
            int i5 = width - i;
            i2 = insetsIgnoringVisibility.right;
            displayMetrics.widthPixels = i5 - i2;
            bounds2 = currentWindowMetrics.getBounds();
            int height = bounds2.height();
            i3 = insetsIgnoringVisibility.top;
            i4 = insetsIgnoringVisibility.bottom;
            displayMetrics.heightPixels = (height - i3) - i4;
        } else {
            displayMetrics = new DisplayMetrics();
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "windowManager.defaultDisplay");
            defaultDisplay.getMetrics(displayMetrics);
        }
        if (isPortraitNaturalOrientation(rotation, displayMetrics.widthPixels, displayMetrics.heightPixels)) {
            if (rotation == 0) {
                return Orientation.PORTRAIT_UP;
            }
            if (rotation == 1) {
                return Orientation.LANDSCAPE_RIGHT;
            }
            if (rotation == 2) {
                return Orientation.PORTRAIT_DOWN;
            }
            if (rotation == 3) {
                return Orientation.LANDSCAPE_LEFT;
            }
            return Orientation.UNKNOWN;
        }
        if (rotation == 0) {
            return Orientation.LANDSCAPE_RIGHT;
        }
        if (rotation == 1) {
            return Orientation.PORTRAIT_DOWN;
        }
        if (rotation == 2) {
            return Orientation.LANDSCAPE_LEFT;
        }
        if (rotation == 3) {
            return Orientation.PORTRAIT_UP;
        }
        return Orientation.UNKNOWN;
    }
}
