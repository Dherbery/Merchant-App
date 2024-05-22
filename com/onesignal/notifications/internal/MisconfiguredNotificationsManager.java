package com.onesignal.notifications.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.onesignal.core.BuildConfig;
import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.notifications.IPermissionObserver;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MisconfiguredNotificationsManager.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0019\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/onesignal/notifications/internal/MisconfiguredNotificationsManager;", "Lcom/onesignal/notifications/INotificationsManager;", "()V", "canRequestPermission", "", "getCanRequestPermission", "()Z", "permission", "getPermission", "addClickListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/onesignal/notifications/INotificationClickListener;", "addForegroundLifecycleListener", "Lcom/onesignal/notifications/INotificationLifecycleListener;", "addPermissionObserver", "observer", "Lcom/onesignal/notifications/IPermissionObserver;", "clearAllNotifications", "removeClickListener", "removeForegroundLifecycleListener", "removeGroupedNotifications", "group", "", "removeNotification", "id", "", "removePermissionObserver", "requestPermission", "fallbackToSettings", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class MisconfiguredNotificationsManager implements INotificationsManager {
    private static final Exception EXCEPTION = new Exception("Must include gradle module com.onesignal:Notification in order to use this functionality!");

    @Override // com.onesignal.notifications.INotificationsManager
    public boolean getPermission() {
        throw EXCEPTION;
    }

    @Override // com.onesignal.notifications.INotificationsManager
    public boolean getCanRequestPermission() {
        throw EXCEPTION;
    }

    @Override // com.onesignal.notifications.INotificationsManager
    public Object requestPermission(boolean z, Continuation<? super Boolean> continuation) {
        throw EXCEPTION;
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: removeNotification, reason: merged with bridge method [inline-methods] */
    public Void mo1037removeNotification(int id) {
        throw EXCEPTION;
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: removeGroupedNotifications, reason: merged with bridge method [inline-methods] */
    public Void mo1036removeGroupedNotifications(String group) {
        Intrinsics.checkNotNullParameter(group, "group");
        throw EXCEPTION;
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: clearAllNotifications, reason: merged with bridge method [inline-methods] */
    public Void mo1033clearAllNotifications() {
        throw EXCEPTION;
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: addPermissionObserver, reason: merged with bridge method [inline-methods] */
    public Void mo1032addPermissionObserver(IPermissionObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        throw EXCEPTION;
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: removePermissionObserver, reason: merged with bridge method [inline-methods] */
    public Void mo1038removePermissionObserver(IPermissionObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        throw EXCEPTION;
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: addForegroundLifecycleListener, reason: merged with bridge method [inline-methods] */
    public Void mo1031addForegroundLifecycleListener(INotificationLifecycleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        throw EXCEPTION;
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: removeForegroundLifecycleListener, reason: merged with bridge method [inline-methods] */
    public Void mo1035removeForegroundLifecycleListener(INotificationLifecycleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        throw EXCEPTION;
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: addClickListener, reason: merged with bridge method [inline-methods] */
    public Void mo1030addClickListener(INotificationClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        throw EXCEPTION;
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: removeClickListener, reason: merged with bridge method [inline-methods] */
    public Void mo1034removeClickListener(INotificationClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        throw EXCEPTION;
    }
}
