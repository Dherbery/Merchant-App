package com.onesignal.notifications.internal.common;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.WorkManager;
import androidx.work.impl.WorkManagerImpl;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OSWorkManagerHelper.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0003¨\u0006\t"}, d2 = {"Lcom/onesignal/notifications/internal/common/OSWorkManagerHelper;", "", "()V", "getInstance", "Landroidx/work/WorkManager;", "context", "Landroid/content/Context;", "isInitialized", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OSWorkManagerHelper {
    public static final OSWorkManagerHelper INSTANCE = new OSWorkManagerHelper();

    private OSWorkManagerHelper() {
    }

    private final boolean isInitialized() {
        return WorkManagerImpl.getInstance() != null;
    }

    @JvmStatic
    public static final synchronized WorkManager getInstance(Context context) {
        WorkManager workManager;
        synchronized (OSWorkManagerHelper.class) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (!INSTANCE.isInitialized()) {
                try {
                    WorkManager.initialize(context, new Configuration.Builder().build());
                } catch (IllegalStateException e) {
                    Logging.error("OSWorkManagerHelper initializing WorkManager failed: ", e);
                }
            }
            workManager = WorkManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(context)");
        }
        return workManager;
    }
}
