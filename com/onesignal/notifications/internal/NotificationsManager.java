package com.onesignal.notifications.internal;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.notifications.IPermissionObserver;
import com.onesignal.notifications.internal.common.GenerateNotificationOpenIntentFromPushPayload;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.permissions.INotificationPermissionChangedHandler;
import com.onesignal.notifications.internal.permissions.INotificationPermissionController;
import com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NotificationsManager.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B5\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\b\u0010&\u001a\u00020\u001eH\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J!\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020\u001eH\u0002J\u0010\u00101\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u00102\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\"H\u0016J\u0010\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001cH\u0016J\u0019\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u0013H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010<J\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0015\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Lcom/onesignal/notifications/internal/NotificationsManager;", "Lcom/onesignal/notifications/INotificationsManager;", "Lcom/onesignal/notifications/internal/INotificationActivityOpener;", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionChangedHandler;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationPermissionController", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionController;", "_notificationRestoreWorkManager", "Lcom/onesignal/notifications/internal/restoration/INotificationRestoreWorkManager;", "_notificationLifecycleService", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "_notificationDataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_summaryManager", "Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/permissions/INotificationPermissionController;Lcom/onesignal/notifications/internal/restoration/INotificationRestoreWorkManager;Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;)V", "canRequestPermission", "", "getCanRequestPermission", "()Z", "permission", "getPermission", "setPermission", "(Z)V", "permissionChangedNotifier", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/notifications/IPermissionObserver;", "addClickListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/onesignal/notifications/INotificationClickListener;", "addForegroundLifecycleListener", "Lcom/onesignal/notifications/INotificationLifecycleListener;", "addPermissionObserver", "observer", "clearAllNotifications", "onFocus", "onNotificationPermissionChanged", ViewProps.ENABLED, "onUnfocused", "openDestinationActivity", "activity", "Landroid/app/Activity;", "pushPayloads", "Lorg/json/JSONArray;", "(Landroid/app/Activity;Lorg/json/JSONArray;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshNotificationState", "removeClickListener", "removeForegroundLifecycleListener", "removeGroupedNotifications", "group", "", "removeNotification", "id", "", "removePermissionObserver", "requestPermission", "fallbackToSettings", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPermissionStatusAndFire", "isEnabled", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationsManager implements INotificationsManager, INotificationActivityOpener, INotificationPermissionChangedHandler, IApplicationLifecycleHandler {
    private final IApplicationService _applicationService;
    private final INotificationRepository _notificationDataController;
    private final INotificationLifecycleService _notificationLifecycleService;
    private final INotificationPermissionController _notificationPermissionController;
    private final INotificationRestoreWorkManager _notificationRestoreWorkManager;
    private final INotificationSummaryManager _summaryManager;
    private boolean permission;
    private final EventProducer<IPermissionObserver> permissionChangedNotifier;

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
    }

    public NotificationsManager(IApplicationService _applicationService, INotificationPermissionController _notificationPermissionController, INotificationRestoreWorkManager _notificationRestoreWorkManager, INotificationLifecycleService _notificationLifecycleService, INotificationRepository _notificationDataController, INotificationSummaryManager _summaryManager) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_notificationPermissionController, "_notificationPermissionController");
        Intrinsics.checkNotNullParameter(_notificationRestoreWorkManager, "_notificationRestoreWorkManager");
        Intrinsics.checkNotNullParameter(_notificationLifecycleService, "_notificationLifecycleService");
        Intrinsics.checkNotNullParameter(_notificationDataController, "_notificationDataController");
        Intrinsics.checkNotNullParameter(_summaryManager, "_summaryManager");
        this._applicationService = _applicationService;
        this._notificationPermissionController = _notificationPermissionController;
        this._notificationRestoreWorkManager = _notificationRestoreWorkManager;
        this._notificationLifecycleService = _notificationLifecycleService;
        this._notificationDataController = _notificationDataController;
        this._summaryManager = _summaryManager;
        this.permission = NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, _applicationService.getAppContext(), null, 2, null);
        this.permissionChangedNotifier = new EventProducer<>();
        _applicationService.addApplicationLifecycleHandler(this);
        _notificationPermissionController.subscribe(this);
        ThreadUtilsKt.suspendifyOnThread$default(0, new AnonymousClass1(null), 1, null);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    public boolean getPermission() {
        return this.permission;
    }

    public void setPermission(boolean z) {
        this.permission = z;
    }

    @Override // com.onesignal.notifications.INotificationsManager
    public boolean getCanRequestPermission() {
        return this._notificationPermissionController.getCanRequestPermission();
    }

    /* compiled from: NotificationsManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.onesignal.notifications.internal.NotificationsManager$1", f = "NotificationsManager.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.onesignal.notifications.internal.NotificationsManager$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (NotificationsManager.this._notificationDataController.deleteExpiredNotifications(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus() {
        refreshNotificationState();
    }

    @Override // com.onesignal.notifications.internal.permissions.INotificationPermissionChangedHandler
    public void onNotificationPermissionChanged(boolean enabled) {
        setPermissionStatusAndFire(enabled);
    }

    private final void refreshNotificationState() {
        this._notificationRestoreWorkManager.beginEnqueueingWork(this._applicationService.getAppContext(), false);
        setPermissionStatusAndFire(NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, this._applicationService.getAppContext(), null, 2, null));
    }

    @Override // com.onesignal.notifications.INotificationsManager
    public Object requestPermission(boolean z, Continuation<? super Boolean> continuation) {
        Logging.debug$default("NotificationsManager.requestPermission()", null, 2, null);
        return BuildersKt.withContext(Dispatchers.getMain(), new NotificationsManager$requestPermission$2(this, z, null), continuation);
    }

    private final void setPermissionStatusAndFire(final boolean isEnabled) {
        boolean permission = getPermission();
        setPermission(isEnabled);
        if (permission != isEnabled) {
            this.permissionChangedNotifier.fireOnMain(new Function1<IPermissionObserver, Unit>() { // from class: com.onesignal.notifications.internal.NotificationsManager$setPermissionStatusAndFire$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IPermissionObserver iPermissionObserver) {
                    invoke2(iPermissionObserver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IPermissionObserver it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onNotificationPermissionChange(isEnabled);
                }
            });
        }
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: removeNotification */
    public void mo1037removeNotification(int id) {
        Logging.debug$default("NotificationsManager.removeNotification(id: " + id + ')', null, 2, null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new NotificationsManager$removeNotification$1(this, id, null), 1, null);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: removeGroupedNotifications */
    public void mo1036removeGroupedNotifications(String group) {
        Intrinsics.checkNotNullParameter(group, "group");
        Logging.debug$default("NotificationsManager.removeGroupedNotifications(group: " + group + ')', null, 2, null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new NotificationsManager$removeGroupedNotifications$1(this, group, null), 1, null);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: clearAllNotifications */
    public void mo1033clearAllNotifications() {
        Logging.debug$default("NotificationsManager.clearAllNotifications()", null, 2, null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new NotificationsManager$clearAllNotifications$1(this, null), 1, null);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: addPermissionObserver */
    public void mo1032addPermissionObserver(IPermissionObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Logging.debug$default("NotificationsManager.addPermissionObserver(observer: " + observer + ')', null, 2, null);
        this.permissionChangedNotifier.subscribe(observer);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: removePermissionObserver */
    public void mo1038removePermissionObserver(IPermissionObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Logging.debug$default("NotificationsManager.removePermissionObserver(observer: " + observer + ')', null, 2, null);
        this.permissionChangedNotifier.unsubscribe(observer);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: addForegroundLifecycleListener */
    public void mo1031addForegroundLifecycleListener(INotificationLifecycleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logging.debug$default("NotificationsManager.addForegroundLifecycleListener(listener: " + listener + ')', null, 2, null);
        this._notificationLifecycleService.addExternalForegroundLifecycleListener(listener);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: removeForegroundLifecycleListener */
    public void mo1035removeForegroundLifecycleListener(INotificationLifecycleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logging.debug$default("NotificationsManager.removeForegroundLifecycleListener(listener: " + listener + ')', null, 2, null);
        this._notificationLifecycleService.removeExternalForegroundLifecycleListener(listener);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: addClickListener */
    public void mo1030addClickListener(INotificationClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logging.debug$default("NotificationsManager.addClickListener(handler: " + listener + ')', null, 2, null);
        this._notificationLifecycleService.addExternalClickListener(listener);
    }

    @Override // com.onesignal.notifications.INotificationsManager
    /* renamed from: removeClickListener */
    public void mo1034removeClickListener(INotificationClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logging.debug$default("NotificationsManager.removeClickListener(listener: " + listener + ')', null, 2, null);
        this._notificationLifecycleService.removeExternalClickListener(listener);
    }

    @Override // com.onesignal.notifications.internal.INotificationActivityOpener
    public Object openDestinationActivity(Activity activity, JSONArray jSONArray, Continuation<? super Unit> continuation) {
        try {
            JSONObject firstPayloadItem = jSONArray.getJSONObject(0);
            Intrinsics.checkNotNullExpressionValue(firstPayloadItem, "firstPayloadItem");
            Intent intentVisible = GenerateNotificationOpenIntentFromPushPayload.INSTANCE.create(activity, firstPayloadItem).getIntentVisible();
            if (intentVisible != null) {
                Logging.info$default("SDK running startActivity with Intent: " + intentVisible, null, 2, null);
                activity.startActivity(intentVisible);
            } else {
                Logging.info$default("SDK not showing an Activity automatically due to it's settings.", null, 2, null);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Unit.INSTANCE;
    }
}
