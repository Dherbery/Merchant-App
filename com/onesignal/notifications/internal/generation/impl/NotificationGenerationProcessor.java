package com.onesignal.notifications.internal.generation.impl;

import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.Notification;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.display.INotificationDisplayer;
import com.onesignal.notifications.internal.generation.INotificationGenerationProcessor;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NotificationGenerationProcessor.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ)\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u0010$\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001dH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ+\u0010%\u001a\u0004\u0018\u00010\u00152\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J9\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/H\u0096@ø\u0001\u0000¢\u0006\u0002\u00100J!\u00101\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001dH\u0002J\u0010\u00105\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lcom/onesignal/notifications/internal/generation/impl/NotificationGenerationProcessor;", "Lcom/onesignal/notifications/internal/generation/INotificationGenerationProcessor;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationDisplayer", "Lcom/onesignal/notifications/internal/display/INotificationDisplayer;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_dataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_notificationSummaryManager", "Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;", "_lifecycleService", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/display/INotificationDisplayer;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;Lcom/onesignal/core/internal/time/ITime;)V", "getCustomJSONObject", "Lorg/json/JSONObject;", "jsonObject", "isDuplicateNotification", "", OneSignalDbContract.NotificationTable.TABLE_NAME, "Lcom/onesignal/notifications/internal/Notification;", "(Lcom/onesignal/notifications/internal/Notification;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNotificationWithinTTL", "markNotificationAsDismissed", "", "notifiJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postProcessNotification", "notificationJob", "wasOpened", "wasDisplayed", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCollapseKey", "processHandlerResponse", "wantsToDisplay", "isRestoring", "processNotificationData", "context", "Landroid/content/Context;", NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, "", "jsonPayload", "timestamp", "", "(Landroid/content/Context;ILorg/json/JSONObject;ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveNotification", "opened", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldDisplayNotification", "shouldFireForegroundHandlers", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationGenerationProcessor implements INotificationGenerationProcessor {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final INotificationRepository _dataController;
    private final INotificationLifecycleService _lifecycleService;
    private final INotificationDisplayer _notificationDisplayer;
    private final INotificationSummaryManager _notificationSummaryManager;
    private final ITime _time;

    public NotificationGenerationProcessor(IApplicationService _applicationService, INotificationDisplayer _notificationDisplayer, ConfigModelStore _configModelStore, INotificationRepository _dataController, INotificationSummaryManager _notificationSummaryManager, INotificationLifecycleService _lifecycleService, ITime _time) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_notificationDisplayer, "_notificationDisplayer");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_dataController, "_dataController");
        Intrinsics.checkNotNullParameter(_notificationSummaryManager, "_notificationSummaryManager");
        Intrinsics.checkNotNullParameter(_lifecycleService, "_lifecycleService");
        Intrinsics.checkNotNullParameter(_time, "_time");
        this._applicationService = _applicationService;
        this._notificationDisplayer = _notificationDisplayer;
        this._configModelStore = _configModelStore;
        this._dataController = _dataController;
        this._notificationSummaryManager = _notificationSummaryManager;
        this._lifecycleService = _lifecycleService;
        this._time = _time;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002b. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0293 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0201 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0162  */
    @Override // com.onesignal.notifications.internal.generation.INotificationGenerationProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object processNotificationData(android.content.Context r21, int r22, org.json.JSONObject r23, boolean r24, long r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData(android.content.Context, int, org.json.JSONObject, boolean, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processHandlerResponse(com.onesignal.notifications.internal.common.NotificationGenerationJob r8, boolean r9, boolean r10, kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processHandlerResponse$1
            if (r0 == 0) goto L14
            r0 = r11
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processHandlerResponse$1 r0 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processHandlerResponse$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processHandlerResponse$1 r0 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processHandlerResponse$1
            r0.<init>(r7, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L46
            if (r2 == r6) goto L3a
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            goto L36
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L9d
        L3a:
            java.lang.Object r8 = r0.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r8 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r8
            java.lang.Object r9 = r0.L$0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r9 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L73
        L46:
            kotlin.ResultKt.throwOnFailure(r11)
            if (r9 == 0) goto L86
            com.onesignal.common.AndroidUtils r9 = com.onesignal.common.AndroidUtils.INSTANCE
            com.onesignal.notifications.internal.Notification r11 = r8.getNotification()
            java.lang.String r11 = r11.getBody()
            boolean r9 = r9.isStringNotEmpty(r11)
            com.onesignal.notifications.internal.Notification r11 = r8.getNotification()
            boolean r11 = r7.isNotificationWithinTTL(r11)
            if (r9 == 0) goto L86
            if (r11 == 0) goto L86
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r6
            java.lang.Object r9 = r7.processCollapseKey(r8, r0)
            if (r9 != r1) goto L72
            return r1
        L72:
            r9 = r7
        L73:
            boolean r9 = r9.shouldDisplayNotification(r8)
            if (r9 == 0) goto L81
            r8.setNotificationToDisplay(r6)
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r8
        L81:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r8
        L86:
            if (r10 == 0) goto L91
            r0.label = r4
            java.lang.Object r8 = r7.markNotificationAsDismissed(r8, r0)
            if (r8 != r1) goto L9d
            return r1
        L91:
            r8.setNotificationToDisplay(r5)
            r0.label = r3
            java.lang.Object r8 = r7.postProcessNotification(r8, r6, r5, r0)
            if (r8 != r1) goto L9d
            return r1
        L9d:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processHandlerResponse(com.onesignal.notifications.internal.common.NotificationGenerationJob, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean isNotificationWithinTTL(Notification notification) {
        if (this._configModelStore.getModel().getRestoreTTLFilter()) {
            return notification.getSentTime() + ((long) notification.getTtl()) > this._time.getCurrentTimeMillis() / ((long) 1000);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object isDuplicateNotification(Notification notification, Continuation<? super Boolean> continuation) {
        return this._dataController.doesNotificationExist(notification.getNotificationId(), continuation);
    }

    private final boolean shouldDisplayNotification(NotificationGenerationJob notificationJob) {
        return notificationJob.hasExtender() || AndroidUtils.INSTANCE.isStringNotEmpty(notificationJob.getJsonPayload().optString("alert"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object postProcessNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob r7, boolean r8, boolean r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$postProcessNotification$1
            if (r0 == 0) goto L14
            r0 = r10
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$postProcessNotification$1 r0 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$postProcessNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$postProcessNotification$1 r0 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$postProcessNotification$1
            r0.<init>(r6, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4a
            if (r2 == r5) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            kotlin.ResultKt.throwOnFailure(r10)
            goto L7f
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L6d
        L3c:
            boolean r9 = r0.Z$0
            java.lang.Object r7 = r0.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r7 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r7
            java.lang.Object r8 = r0.L$0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r8 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L5d
        L4a:
            kotlin.ResultKt.throwOnFailure(r10)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.Z$0 = r9
            r0.label = r5
            java.lang.Object r8 = r6.saveNotification(r7, r8, r0)
            if (r8 != r1) goto L5c
            return r1
        L5c:
            r8 = r6
        L5d:
            r10 = 0
            if (r9 != 0) goto L70
            r0.L$0 = r10
            r0.L$1 = r10
            r0.label = r4
            java.lang.Object r7 = r8.markNotificationAsDismissed(r7, r0)
            if (r7 != r1) goto L6d
            return r1
        L6d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L70:
            com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService r8 = r8._lifecycleService
            r0.L$0 = r10
            r0.L$1 = r10
            r0.label = r3
            java.lang.Object r7 = r8.notificationReceived(r7, r0)
            if (r7 != r1) goto L7f
            return r1
        L7f:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.postProcessNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|(1:(1:10)(2:14|15))(11:16|17|(1:37)(1:21)|22|(1:24)(1:36)|25|(1:27)(1:35)|28|(1:30)(1:34)|31|(1:33))|11|12))|40|6|7|(0)(0)|11|12) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0031, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f7, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object saveNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob r19, boolean r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.saveNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object markNotificationAsDismissed(com.onesignal.notifications.internal.common.NotificationGenerationJob r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$markNotificationAsDismissed$1
            if (r0 == 0) goto L14
            r0 = r8
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$markNotificationAsDismissed$1 r0 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$markNotificationAsDismissed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$markNotificationAsDismissed$1 r0 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$markNotificationAsDismissed$1
            r0.<init>(r6, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L42
            if (r2 == r3) goto L36
            if (r2 != r4) goto L2e
            kotlin.ResultKt.throwOnFailure(r8)
            goto L8e
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            java.lang.Object r7 = r0.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r7 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r7
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r2 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L73
        L42:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r7.getIsNotificationToDisplay()
            if (r8 != 0) goto L4e
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L4e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r2 = "Marking restored or disabled notifications as dismissed: "
            r8.<init>(r2)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r8, r5, r4, r5)
            com.onesignal.notifications.internal.data.INotificationRepository r8 = r6._dataController
            int r2 = r7.getAndroidId()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = r8.markAsDismissed(r2, r0)
            if (r8 != r1) goto L72
            return r1
        L72:
            r2 = r6
        L73:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L91
            com.onesignal.notifications.internal.summary.INotificationSummaryManager r8 = r2._notificationSummaryManager
            int r7 = r7.getAndroidId()
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r4
            java.lang.Object r7 = r8.updatePossibleDependentSummaryOnDismiss(r7, r0)
            if (r7 != r1) goto L8e
            return r1
        L8e:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L91:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.markNotificationAsDismissed(com.onesignal.notifications.internal.common.NotificationGenerationJob, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processCollapseKey(com.onesignal.notifications.internal.common.NotificationGenerationJob r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processCollapseKey$1
            if (r0 == 0) goto L14
            r0 = r7
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processCollapseKey$1 r0 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processCollapseKey$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processCollapseKey$1 r0 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processCollapseKey$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            com.onesignal.notifications.internal.common.NotificationGenerationJob r6 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L79
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6.getIsRestoring()
            if (r7 == 0) goto L42
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L42:
            org.json.JSONObject r7 = r6.getJsonPayload()
            java.lang.String r2 = "collapse_key"
            boolean r7 = r7.has(r2)
            if (r7 == 0) goto L8b
            org.json.JSONObject r7 = r6.getJsonPayload()
            java.lang.String r7 = r7.optString(r2)
            java.lang.String r4 = "do_not_collapse"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r7)
            if (r7 == 0) goto L5f
            goto L8b
        L5f:
            org.json.JSONObject r7 = r6.getJsonPayload()
            java.lang.String r7 = r7.optString(r2)
            com.onesignal.notifications.internal.data.INotificationRepository r2 = r5._dataController
            java.lang.String r4 = "collapseId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r2.getAndroidIdFromCollapseKey(r7, r0)
            if (r7 != r1) goto L79
            return r1
        L79:
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 == 0) goto L88
            com.onesignal.notifications.internal.Notification r6 = r6.getNotification()
            int r7 = r7.intValue()
            r6.setAndroidNotificationId(r7)
        L88:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L8b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processCollapseKey(com.onesignal.notifications.internal.common.NotificationGenerationJob, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final JSONObject getCustomJSONObject(JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        return new JSONObject(jsonObject.optString("custom"));
    }

    private final boolean shouldFireForegroundHandlers(NotificationGenerationJob notificationJob) {
        if (!this._applicationService.isInForeground()) {
            Logging.info$default("App is in background, show notification", null, 2, null);
            return false;
        }
        if (!notificationJob.getIsRestoring()) {
            return true;
        }
        Logging.info$default("Not firing notificationWillShowInForegroundHandler for restored notifications", null, 2, null);
        return false;
    }
}
