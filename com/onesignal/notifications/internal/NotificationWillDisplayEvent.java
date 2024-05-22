package com.onesignal.notifications.internal;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.INotificationWillDisplayEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationWillDisplayEvent.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/onesignal/notifications/internal/NotificationWillDisplayEvent;", "Lcom/onesignal/notifications/INotificationWillDisplayEvent;", OneSignalDbContract.NotificationTable.TABLE_NAME, "Lcom/onesignal/notifications/internal/Notification;", "(Lcom/onesignal/notifications/internal/Notification;)V", "isPreventDefault", "", "()Z", "setPreventDefault", "(Z)V", "getNotification", "()Lcom/onesignal/notifications/internal/Notification;", "preventDefault", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationWillDisplayEvent implements INotificationWillDisplayEvent {
    private boolean isPreventDefault;
    private final Notification notification;

    public NotificationWillDisplayEvent(Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        this.notification = notification;
    }

    @Override // com.onesignal.notifications.INotificationWillDisplayEvent
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

    @Override // com.onesignal.notifications.INotificationWillDisplayEvent
    public void preventDefault() {
        Logging.debug$default("NotificationWillDisplayEvent.preventDefault()", null, 2, null);
        this.isPreventDefault = true;
    }
}
