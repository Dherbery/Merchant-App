package com.onesignal.notifications.internal.listeners;

import android.app.Activity;
import com.onesignal.common.JSONUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.INotificationActivityOpener;
import com.onesignal.notifications.internal.NotificationClickEvent;
import com.onesignal.notifications.internal.analytics.IAnalyticsTracker;
import com.onesignal.notifications.internal.backend.INotificationBackendService;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.common.OSNotificationOpenAppSettings;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleEventHandler;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptWorkManager;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NotificationListener.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B]\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J)\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0019\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020 H\u0002J\b\u0010,\u001a\u00020\u001eH\u0016R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lcom/onesignal/notifications/internal/listeners/NotificationListener;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleEventHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationLifecycleService", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_influenceManager", "Lcom/onesignal/session/internal/influence/IInfluenceManager;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_backend", "Lcom/onesignal/notifications/internal/backend/INotificationBackendService;", "_receiveReceiptWorkManager", "Lcom/onesignal/notifications/internal/receivereceipt/IReceiveReceiptWorkManager;", "_activityOpener", "Lcom/onesignal/notifications/internal/INotificationActivityOpener;", "_analyticsTracker", "Lcom/onesignal/notifications/internal/analytics/IAnalyticsTracker;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/session/internal/influence/IInfluenceManager;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/notifications/internal/backend/INotificationBackendService;Lcom/onesignal/notifications/internal/receivereceipt/IReceiveReceiptWorkManager;Lcom/onesignal/notifications/internal/INotificationActivityOpener;Lcom/onesignal/notifications/internal/analytics/IAnalyticsTracker;Lcom/onesignal/core/internal/time/ITime;)V", "postedOpenedNotifIds", "", "", "onNotificationOpened", "", "activity", "Landroid/app/Activity;", "data", "Lorg/json/JSONArray;", "notificationId", "(Landroid/app/Activity;Lorg/json/JSONArray;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onNotificationReceived", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldInitDirectSessionFromNotificationOpen", "", "context", "start", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationListener implements IStartableService, INotificationLifecycleEventHandler {
    private final INotificationActivityOpener _activityOpener;
    private final IAnalyticsTracker _analyticsTracker;
    private final IApplicationService _applicationService;
    private final INotificationBackendService _backend;
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final IInfluenceManager _influenceManager;
    private final INotificationLifecycleService _notificationLifecycleService;
    private final IReceiveReceiptWorkManager _receiveReceiptWorkManager;
    private final ISubscriptionManager _subscriptionManager;
    private final ITime _time;
    private final Set<String> postedOpenedNotifIds;

    public NotificationListener(IApplicationService _applicationService, INotificationLifecycleService _notificationLifecycleService, ConfigModelStore _configModelStore, IInfluenceManager _influenceManager, ISubscriptionManager _subscriptionManager, IDeviceService _deviceService, INotificationBackendService _backend, IReceiveReceiptWorkManager _receiveReceiptWorkManager, INotificationActivityOpener _activityOpener, IAnalyticsTracker _analyticsTracker, ITime _time) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_notificationLifecycleService, "_notificationLifecycleService");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_influenceManager, "_influenceManager");
        Intrinsics.checkNotNullParameter(_subscriptionManager, "_subscriptionManager");
        Intrinsics.checkNotNullParameter(_deviceService, "_deviceService");
        Intrinsics.checkNotNullParameter(_backend, "_backend");
        Intrinsics.checkNotNullParameter(_receiveReceiptWorkManager, "_receiveReceiptWorkManager");
        Intrinsics.checkNotNullParameter(_activityOpener, "_activityOpener");
        Intrinsics.checkNotNullParameter(_analyticsTracker, "_analyticsTracker");
        Intrinsics.checkNotNullParameter(_time, "_time");
        this._applicationService = _applicationService;
        this._notificationLifecycleService = _notificationLifecycleService;
        this._configModelStore = _configModelStore;
        this._influenceManager = _influenceManager;
        this._subscriptionManager = _subscriptionManager;
        this._deviceService = _deviceService;
        this._backend = _backend;
        this._receiveReceiptWorkManager = _receiveReceiptWorkManager;
        this._activityOpener = _activityOpener;
        this._analyticsTracker = _analyticsTracker;
        this._time = _time;
        this.postedOpenedNotifIds = new LinkedHashSet();
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._notificationLifecycleService.addInternalNotificationLifecycleEventHandler(this);
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleEventHandler
    public Object onNotificationReceived(NotificationGenerationJob notificationGenerationJob, Continuation<? super Unit> continuation) {
        this._receiveReceiptWorkManager.enqueueReceiveReceipt(notificationGenerationJob.getApiNotificationId());
        this._influenceManager.onNotificationReceived(notificationGenerationJob.getApiNotificationId());
        try {
            JSONObject jSONObject = new JSONObject(notificationGenerationJob.getJsonPayload().toString());
            jSONObject.put(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, notificationGenerationJob.getAndroidId());
            NotificationClickEvent generateNotificationOpenedResult$com_onesignal_notifications = NotificationHelper.INSTANCE.generateNotificationOpenedResult$com_onesignal_notifications(JSONUtils.INSTANCE.wrapInJsonArray(jSONObject), this._time);
            IAnalyticsTracker iAnalyticsTracker = this._analyticsTracker;
            String notificationId = generateNotificationOpenedResult$com_onesignal_notifications.getNotification().getNotificationId();
            Intrinsics.checkNotNull(notificationId);
            iAnalyticsTracker.trackReceivedEvent(notificationId, NotificationHelper.INSTANCE.getCampaignNameFromNotification(generateNotificationOpenedResult$com_onesignal_notifications.getNotification()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:26|(1:27)|28|29|30|31|(1:33)(5:34|19|20|21|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f5, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f6, code lost:
    
        r13 = r3;
        r12 = r4;
        r3 = r15;
        r15 = r16;
        r11 = r17;
        r10 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0114, code lost:
    
        r9 = r19;
        r8 = r20;
        r4 = r21;
        r22 = r14;
        r14 = r2;
        r2 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x011f, code lost:
    
        com.onesignal.debug.internal.logging.Logging.error$default("Notification opened confirmation failed with statusCode: " + r0.getStatusCode() + " response: " + r0.getResponse(), null, 2, null);
        r5 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00a7 -> B:21:0x0155). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00df -> B:19:0x00f3). Please report as a decompilation issue!!! */
    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleEventHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object onNotificationOpened(android.app.Activity r26, org.json.JSONArray r27, java.lang.String r28, kotlin.coroutines.Continuation<? super kotlin.Unit> r29) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.listeners.NotificationListener.onNotificationOpened(android.app.Activity, org.json.JSONArray, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean shouldInitDirectSessionFromNotificationOpen(Activity context) {
        if (this._applicationService.isInForeground()) {
            return false;
        }
        try {
            return OSNotificationOpenAppSettings.INSTANCE.getShouldOpenActivity(context);
        } catch (JSONException e) {
            e.printStackTrace();
            return true;
        }
    }
}
