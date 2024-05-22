package expo.modules.core.interfaces;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactRootView;

/* loaded from: classes5.dex */
public interface ReactActivityHandler {

    /* renamed from: expo.modules.core.interfaces.ReactActivityHandler$-CC, reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
        public static ReactRootView $default$createReactRootView(ReactActivityHandler _this, Activity activity) {
            return null;
        }

        public static ViewGroup $default$createReactRootViewContainer(ReactActivityHandler _this, Activity activity) {
            return null;
        }

        public static DelayLoadAppHandler $default$getDelayLoadAppHandler(ReactActivityHandler _this, ReactActivity reactActivity, ReactNativeHost reactNativeHost) {
            return null;
        }

        public static ReactActivityDelegate $default$onDidCreateReactActivityDelegate(ReactActivityHandler _this, ReactActivity reactActivity, ReactActivityDelegate reactActivityDelegate) {
            return null;
        }

        public static boolean $default$onKeyUp(ReactActivityHandler _this, int i, KeyEvent keyEvent) {
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public interface DelayLoadAppHandler {
        void whenReady(Runnable runnable);
    }

    ReactRootView createReactRootView(Activity activity);

    ViewGroup createReactRootViewContainer(Activity activity);

    DelayLoadAppHandler getDelayLoadAppHandler(ReactActivity reactActivity, ReactNativeHost reactNativeHost);

    ReactActivityDelegate onDidCreateReactActivityDelegate(ReactActivity reactActivity, ReactActivityDelegate reactActivityDelegate);

    boolean onKeyUp(int i, KeyEvent keyEvent);
}
