package com.onesignal.notifications.internal.restoration;

import android.content.Context;
import com.onesignal.notifications.BuildConfig;
import kotlin.Metadata;

/* compiled from: INotificationRestoreWorkManager.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/onesignal/notifications/internal/restoration/INotificationRestoreWorkManager;", "", "beginEnqueueingWork", "", "context", "Landroid/content/Context;", "shouldDelay", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface INotificationRestoreWorkManager {
    void beginEnqueueingWork(Context context, boolean shouldDelay);
}
