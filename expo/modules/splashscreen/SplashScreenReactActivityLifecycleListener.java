package expo.modules.splashscreen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.react.ReactRootView;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import expo.modules.splashscreen.SplashScreenImageResizeMode;
import expo.modules.splashscreen.singletons.SplashScreen;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SplashScreenReactActivityLifecycleListener.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lexpo/modules/splashscreen/SplashScreenReactActivityLifecycleListener;", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "activityContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getResizeMode", "Lexpo/modules/splashscreen/SplashScreenImageResizeMode;", "context", "getStatusBarTranslucent", "", "onContentChanged", "", "activity", "Landroid/app/Activity;", "expo-splash-screen_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SplashScreenReactActivityLifecycleListener implements ReactActivityLifecycleListener {
    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public /* synthetic */ boolean onBackPressed() {
        return ReactActivityLifecycleListener.CC.$default$onBackPressed(this);
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public /* synthetic */ void onCreate(Activity activity, Bundle bundle) {
        ReactActivityLifecycleListener.CC.$default$onCreate(this, activity, bundle);
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public /* synthetic */ void onDestroy(Activity activity) {
        ReactActivityLifecycleListener.CC.$default$onDestroy(this, activity);
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public /* synthetic */ boolean onNewIntent(Intent intent) {
        return ReactActivityLifecycleListener.CC.$default$onNewIntent(this, intent);
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public /* synthetic */ void onPause(Activity activity) {
        ReactActivityLifecycleListener.CC.$default$onPause(this, activity);
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public /* synthetic */ void onResume(Activity activity) {
        ReactActivityLifecycleListener.CC.$default$onResume(this, activity);
    }

    public SplashScreenReactActivityLifecycleListener(Context activityContext) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public void onContentChanged(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Activity activity2 = activity;
        SplashScreen.show$default(activity, getResizeMode(activity2), ReactRootView.class, getStatusBarTranslucent(activity2), null, null, null, 112, null);
    }

    private final SplashScreenImageResizeMode getResizeMode(Context context) {
        SplashScreenImageResizeMode.Companion companion = SplashScreenImageResizeMode.INSTANCE;
        String string = context.getString(R.string.expo_splash_screen_resize_mode);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…plash_screen_resize_mode)");
        String lowerCase = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        SplashScreenImageResizeMode fromString = companion.fromString(lowerCase);
        return fromString == null ? SplashScreenImageResizeMode.CONTAIN : fromString;
    }

    private final boolean getStatusBarTranslucent(Context context) {
        return Boolean.parseBoolean(context.getString(R.string.expo_splash_screen_status_bar_translucent));
    }
}
