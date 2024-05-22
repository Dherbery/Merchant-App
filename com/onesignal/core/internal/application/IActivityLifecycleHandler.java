package com.onesignal.core.internal.application;

import android.app.Activity;
import com.onesignal.core.BuildConfig;
import kotlin.Metadata;

/* compiled from: IActivityLifecycleHandler.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/onesignal/core/internal/application/IActivityLifecycleHandler;", "", "onActivityAvailable", "", "activity", "Landroid/app/Activity;", "onActivityStopped", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IActivityLifecycleHandler {
    void onActivityAvailable(Activity activity);

    void onActivityStopped(Activity activity);
}
