package com.onesignal.notifications;

import android.content.Context;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import kotlin.Metadata;

/* compiled from: INotificationReceivedEvent.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/onesignal/notifications/INotificationReceivedEvent;", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", OneSignalDbContract.NotificationTable.TABLE_NAME, "Lcom/onesignal/notifications/IDisplayableMutableNotification;", "getNotification", "()Lcom/onesignal/notifications/IDisplayableMutableNotification;", "preventDefault", "", com.onesignal.core.BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface INotificationReceivedEvent {
    Context getContext();

    IDisplayableMutableNotification getNotification();

    void preventDefault();
}
