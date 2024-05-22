package com.onesignal.notifications.internal.permissions.impl;

import android.app.Activity;
import android.os.Build;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.ApplicationLifecycleHandlerBase;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings;
import com.onesignal.core.internal.permissions.IRequestPermissionService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.R;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.permissions.INotificationPermissionChangedHandler;
import com.onesignal.notifications.internal.permissions.INotificationPermissionController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationPermissionController.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0000\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\fH\u0016J\u0019\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\fH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0011H\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/onesignal/notifications/internal/permissions/impl/NotificationPermissionController;", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService$PermissionCallback;", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionController;", "_application", "Lcom/onesignal/core/internal/application/IApplicationService;", "_requestPermission", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService;", "_applicationService", "_preferenceService", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/permissions/IRequestPermissionService;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "canRequestPermission", "", "getCanRequestPermission", "()Z", "events", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionChangedHandler;", "hasSubscribers", "getHasSubscribers", "supportsNativePrompt", "getSupportsNativePrompt", "waiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "notificationsEnabled", "onAccept", "", "onReject", "fallbackToSettings", "prompt", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showFallbackAlertDialog", "subscribe", "handler", "unsubscribe", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationPermissionController implements IRequestPermissionService.PermissionCallback, INotificationPermissionController {
    private static final String ANDROID_PERMISSION_STRING = "android.permission.POST_NOTIFICATIONS";
    private static final String PERMISSION_TYPE = "NOTIFICATION";
    private final IApplicationService _application;
    private final IApplicationService _applicationService;
    private final IPreferencesService _preferenceService;
    private final IRequestPermissionService _requestPermission;
    private final EventProducer<INotificationPermissionChangedHandler> events;
    private final boolean supportsNativePrompt;
    private final WaiterWithValue<Boolean> waiter;

    public NotificationPermissionController(IApplicationService _application, IRequestPermissionService _requestPermission, IApplicationService _applicationService, IPreferencesService _preferenceService) {
        Intrinsics.checkNotNullParameter(_application, "_application");
        Intrinsics.checkNotNullParameter(_requestPermission, "_requestPermission");
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_preferenceService, "_preferenceService");
        this._application = _application;
        this._requestPermission = _requestPermission;
        this._applicationService = _applicationService;
        this._preferenceService = _preferenceService;
        this.waiter = new WaiterWithValue<>();
        this.events = new EventProducer<>();
        _requestPermission.registerAsCallback(PERMISSION_TYPE, this);
        this.supportsNativePrompt = Build.VERSION.SDK_INT > 32 && AndroidUtils.INSTANCE.getTargetSdkVersion(_application.getAppContext()) > 32;
    }

    @Override // com.onesignal.notifications.internal.permissions.INotificationPermissionController
    public boolean getCanRequestPermission() {
        Intrinsics.checkNotNull(this._preferenceService.getBool(PreferenceStores.ONESIGNAL, "USER_RESOLVED_PERMISSION_android.permission.POST_NOTIFICATIONS", false));
        return !r0.booleanValue();
    }

    public final boolean getSupportsNativePrompt() {
        return this.supportsNativePrompt;
    }

    @Override // com.onesignal.notifications.internal.permissions.INotificationPermissionController
    public Object prompt(boolean z, Continuation<? super Boolean> continuation) {
        if (notificationsEnabled()) {
            return Boxing.boxBoolean(true);
        }
        if (this.supportsNativePrompt) {
            this._requestPermission.startPrompt(z, PERMISSION_TYPE, ANDROID_PERMISSION_STRING, getClass());
        } else if (z) {
            showFallbackAlertDialog();
        } else {
            return Boxing.boxBoolean(false);
        }
        return this.waiter.waitForWake(continuation);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(INotificationPermissionChangedHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.events.subscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(INotificationPermissionChangedHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.events.subscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.events.getHasSubscribers();
    }

    @Override // com.onesignal.core.internal.permissions.IRequestPermissionService.PermissionCallback
    public void onAccept() {
        this.waiter.wake(true);
        this.events.fire(new Function1<INotificationPermissionChangedHandler, Unit>() { // from class: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$onAccept$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(INotificationPermissionChangedHandler iNotificationPermissionChangedHandler) {
                invoke2(iNotificationPermissionChangedHandler);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(INotificationPermissionChangedHandler it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onNotificationPermissionChanged(true);
            }
        });
    }

    @Override // com.onesignal.core.internal.permissions.IRequestPermissionService.PermissionCallback
    public void onReject(boolean fallbackToSettings) {
        if (fallbackToSettings ? showFallbackAlertDialog() : false) {
            return;
        }
        this.waiter.wake(false);
        this.events.fire(new Function1<INotificationPermissionChangedHandler, Unit>() { // from class: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$onReject$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(INotificationPermissionChangedHandler iNotificationPermissionChangedHandler) {
                invoke2(iNotificationPermissionChangedHandler);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(INotificationPermissionChangedHandler it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onNotificationPermissionChanged(false);
            }
        });
    }

    private final boolean showFallbackAlertDialog() {
        final Activity activity = this._application.get_current();
        if (activity == null) {
            return false;
        }
        AlertDialogPrepromptForAndroidSettings alertDialogPrepromptForAndroidSettings = AlertDialogPrepromptForAndroidSettings.INSTANCE;
        String string = activity.getString(R.string.notification_permission_name_for_title);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…ermission_name_for_title)");
        String string2 = activity.getString(R.string.notification_permission_settings_message);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str…mission_settings_message)");
        alertDialogPrepromptForAndroidSettings.show(activity, string, string2, new AlertDialogPrepromptForAndroidSettings.Callback() { // from class: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$showFallbackAlertDialog$1
            @Override // com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings.Callback
            public void onAccept() {
                IApplicationService iApplicationService;
                iApplicationService = NotificationPermissionController.this._applicationService;
                final NotificationPermissionController notificationPermissionController = NotificationPermissionController.this;
                iApplicationService.addApplicationLifecycleHandler(new ApplicationLifecycleHandlerBase() { // from class: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$showFallbackAlertDialog$1$onAccept$1
                    @Override // com.onesignal.core.internal.application.ApplicationLifecycleHandlerBase, com.onesignal.core.internal.application.IApplicationLifecycleHandler
                    public void onFocus() {
                        IApplicationService iApplicationService2;
                        IApplicationService iApplicationService3;
                        WaiterWithValue waiterWithValue;
                        EventProducer eventProducer;
                        super.onFocus();
                        iApplicationService2 = NotificationPermissionController.this._applicationService;
                        iApplicationService2.removeApplicationLifecycleHandler(this);
                        AndroidUtils androidUtils = AndroidUtils.INSTANCE;
                        iApplicationService3 = NotificationPermissionController.this._applicationService;
                        final boolean hasPermission = androidUtils.hasPermission("android.permission.POST_NOTIFICATIONS", true, iApplicationService3);
                        waiterWithValue = NotificationPermissionController.this.waiter;
                        waiterWithValue.wake(Boolean.valueOf(hasPermission));
                        eventProducer = NotificationPermissionController.this.events;
                        eventProducer.fire(new Function1<INotificationPermissionChangedHandler, Unit>() { // from class: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$showFallbackAlertDialog$1$onAccept$1$onFocus$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(INotificationPermissionChangedHandler iNotificationPermissionChangedHandler) {
                                invoke2(iNotificationPermissionChangedHandler);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(INotificationPermissionChangedHandler it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                it.onNotificationPermissionChanged(hasPermission);
                            }
                        });
                    }
                });
                NavigateToAndroidSettingsForNotifications.INSTANCE.show(activity);
            }

            @Override // com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings.Callback
            public void onDecline() {
                WaiterWithValue waiterWithValue;
                EventProducer eventProducer;
                waiterWithValue = NotificationPermissionController.this.waiter;
                waiterWithValue.wake(false);
                eventProducer = NotificationPermissionController.this.events;
                eventProducer.fire(new Function1<INotificationPermissionChangedHandler, Unit>() { // from class: com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController$showFallbackAlertDialog$1$onDecline$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(INotificationPermissionChangedHandler iNotificationPermissionChangedHandler) {
                        invoke2(iNotificationPermissionChangedHandler);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(INotificationPermissionChangedHandler it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.onNotificationPermissionChanged(false);
                    }
                });
            }
        });
        return true;
    }

    private final boolean notificationsEnabled() {
        return NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, this._application.getAppContext(), null, 2, null);
    }
}
