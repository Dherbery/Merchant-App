package com.onesignal.notifications;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import kotlin.Metadata;

/* compiled from: INotificationWillDisplayEvent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/onesignal/notifications/INotificationWillDisplayEvent;", "", OneSignalDbContract.NotificationTable.TABLE_NAME, "Lcom/onesignal/notifications/IDisplayableNotification;", "getNotification", "()Lcom/onesignal/notifications/IDisplayableNotification;", "preventDefault", "", com.onesignal.core.BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface INotificationWillDisplayEvent {
    IDisplayableNotification getNotification();

    void preventDefault();
}
