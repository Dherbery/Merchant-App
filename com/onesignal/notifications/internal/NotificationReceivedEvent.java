package com.onesignal.notifications.internal;

import android.content.Context;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.INotificationReceivedEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationReceivedEvent.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/onesignal/notifications/internal/NotificationReceivedEvent;", "Lcom/onesignal/notifications/INotificationReceivedEvent;", "context", "Landroid/content/Context;", OneSignalDbContract.NotificationTable.TABLE_NAME, "Lcom/onesignal/notifications/internal/Notification;", "(Landroid/content/Context;Lcom/onesignal/notifications/internal/Notification;)V", "getContext", "()Landroid/content/Context;", "isPreventDefault", "", "()Z", "setPreventDefault", "(Z)V", "getNotification", "()Lcom/onesignal/notifications/internal/Notification;", "preventDefault", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationReceivedEvent implements INotificationReceivedEvent {
    private final Context context;
    private boolean isPreventDefault;
    private final Notification notification;

    public NotificationReceivedEvent(Context context, Notification notification) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notification, "notification");
        this.context = context;
        this.notification = notification;
    }

    @Override // com.onesignal.notifications.INotificationReceivedEvent
    public Context getContext() {
        return this.context;
    }

    @Override // com.onesignal.notifications.INotificationReceivedEvent
    public Notification getNotification() {
        return this.notification;
    }

    /* renamed from: isPreventDefault, reason: from getter */
    public final boolean getIsPreventDefault() {
        return this.isPreventDefault;
    }

    public final void setPreventDefault(boolean z) {
        this.isPreventDefault = z;
    }

    @Override // com.onesignal.notifications.INotificationReceivedEvent
    public void preventDefault() {
        Logging.debug$default("NotificationReceivedEvent.preventDefault()", null, 2, null);
        this.isPreventDefault = true;
    }
}
