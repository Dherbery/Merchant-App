package com.revenuecat.purchases.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomActivityLifecycleHandler.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/utils/CustomActivityLifecycleHandler;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface CustomActivityLifecycleHandler extends Application.ActivityLifecycleCallbacks {

    /* compiled from: CustomActivityLifecycleHandler.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static void onActivityCreated(CustomActivityLifecycleHandler customActivityLifecycleHandler, Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public static void onActivityDestroyed(CustomActivityLifecycleHandler customActivityLifecycleHandler, Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public static void onActivityPaused(CustomActivityLifecycleHandler customActivityLifecycleHandler, Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public static void onActivityResumed(CustomActivityLifecycleHandler customActivityLifecycleHandler, Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public static void onActivitySaveInstanceState(CustomActivityLifecycleHandler customActivityLifecycleHandler, Activity activity, Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        public static void onActivityStarted(CustomActivityLifecycleHandler customActivityLifecycleHandler, Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public static void onActivityStopped(CustomActivityLifecycleHandler customActivityLifecycleHandler, Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    void onActivityCreated(Activity activity, Bundle savedInstanceState);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    void onActivityDestroyed(Activity activity);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    void onActivityPaused(Activity activity);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    void onActivityResumed(Activity activity);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    void onActivitySaveInstanceState(Activity activity, Bundle outState);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    void onActivityStarted(Activity activity);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    void onActivityStopped(Activity activity);
}
