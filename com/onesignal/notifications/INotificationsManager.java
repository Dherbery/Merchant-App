package com.onesignal.notifications;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: INotificationsManager.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\tH&J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH&J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0019\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001dR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/onesignal/notifications/INotificationsManager;", "", "canRequestPermission", "", "getCanRequestPermission", "()Z", "permission", "getPermission", "addClickListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/onesignal/notifications/INotificationClickListener;", "addForegroundLifecycleListener", "Lcom/onesignal/notifications/INotificationLifecycleListener;", "addPermissionObserver", "observer", "Lcom/onesignal/notifications/IPermissionObserver;", "clearAllNotifications", "removeClickListener", "removeForegroundLifecycleListener", "removeGroupedNotifications", "group", "", "removeNotification", "id", "", "removePermissionObserver", "requestPermission", "fallbackToSettings", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", com.onesignal.core.BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface INotificationsManager {
    /* renamed from: addClickListener */
    void mo1030addClickListener(INotificationClickListener listener);

    /* renamed from: addForegroundLifecycleListener */
    void mo1031addForegroundLifecycleListener(INotificationLifecycleListener listener);

    /* renamed from: addPermissionObserver */
    void mo1032addPermissionObserver(IPermissionObserver observer);

    /* renamed from: clearAllNotifications */
    void mo1033clearAllNotifications();

    boolean getCanRequestPermission();

    boolean getPermission();

    /* renamed from: removeClickListener */
    void mo1034removeClickListener(INotificationClickListener listener);

    /* renamed from: removeForegroundLifecycleListener */
    void mo1035removeForegroundLifecycleListener(INotificationLifecycleListener listener);

    /* renamed from: removeGroupedNotifications */
    void mo1036removeGroupedNotifications(String group);

    /* renamed from: removeNotification */
    void mo1037removeNotification(int id);

    /* renamed from: removePermissionObserver */
    void mo1038removePermissionObserver(IPermissionObserver observer);

    Object requestPermission(boolean z, Continuation<? super Boolean> continuation);
}
