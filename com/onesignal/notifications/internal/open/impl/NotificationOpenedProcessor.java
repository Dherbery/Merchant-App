package com.onesignal.notifications.internal.open.impl;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessor;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationOpenedProcessor.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J)\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001aH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J!\u0010 \u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010!J!\u0010\"\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010!J/\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/onesignal/notifications/internal/open/impl/NotificationOpenedProcessor;", "Lcom/onesignal/notifications/internal/open/INotificationOpenedProcessor;", "_summaryManager", "Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;", "_dataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_lifecycleService", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "(Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;)V", "addChildNotifications", "", "dataArray", "Lorg/json/JSONArray;", "summaryGroup", "", "(Lorg/json/JSONArray;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearStatusBarNotifications", "context", "Landroid/content/Context;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleDismissFromActionButtonPress", "intent", "Landroid/content/Intent;", "isOneSignalIntent", "", "markNotificationsConsumed", "dismissed", "(Landroid/content/Context;Landroid/content/Intent;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newContentValuesWithConsumed", "Landroid/content/ContentValues;", "processFromContext", "(Landroid/content/Context;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processIntent", "processToOpenIntent", "Lcom/onesignal/notifications/internal/open/impl/NotificationIntentExtras;", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationOpenedProcessor implements INotificationOpenedProcessor {
    private final ConfigModelStore _configModelStore;
    private final INotificationRepository _dataController;
    private final INotificationLifecycleService _lifecycleService;
    private final INotificationSummaryManager _summaryManager;

    public NotificationOpenedProcessor(INotificationSummaryManager _summaryManager, INotificationRepository _dataController, ConfigModelStore _configModelStore, INotificationLifecycleService _lifecycleService) {
        Intrinsics.checkNotNullParameter(_summaryManager, "_summaryManager");
        Intrinsics.checkNotNullParameter(_dataController, "_dataController");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_lifecycleService, "_lifecycleService");
        this._summaryManager = _summaryManager;
        this._dataController = _dataController;
        this._configModelStore = _configModelStore;
        this._lifecycleService = _lifecycleService;
    }

    @Override // com.onesignal.notifications.internal.open.INotificationOpenedProcessor
    public Object processFromContext(Context context, Intent intent, Continuation<? super Unit> continuation) {
        if (!isOneSignalIntent(intent)) {
            return Unit.INSTANCE;
        }
        handleDismissFromActionButtonPress(context, intent);
        Object processIntent = processIntent(context, intent, continuation);
        return processIntent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? processIntent : Unit.INSTANCE;
    }

    private final boolean isOneSignalIntent(Intent intent) {
        return intent.hasExtra(NotificationConstants.BUNDLE_KEY_ONESIGNAL_DATA) || intent.hasExtra("summary") || intent.hasExtra(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID);
    }

    private final void handleDismissFromActionButtonPress(Context context, Intent intent) {
        if (intent.getBooleanExtra("action_button", false)) {
            Intrinsics.checkNotNull(context);
            NotificationManagerCompat.from(context).cancel(intent.getIntExtra(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, 0));
            if (Build.VERSION.SDK_INT < 31) {
                context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processIntent(android.content.Context r12, android.content.Intent r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.processIntent(android.content.Context, android.content.Intent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processToOpenIntent(android.content.Context r11, android.content.Intent r12, java.lang.String r13, kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.open.impl.NotificationIntentExtras> r14) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.processToOpenIntent(android.content.Context, android.content.Intent, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0052 A[LOOP:0: B:11:0x004c->B:13:0x0052, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object addChildNotifications(org.json.JSONArray r5, java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$addChildNotifications$1
            if (r0 == 0) goto L14
            r0 = r7
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$addChildNotifications$1 r0 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$addChildNotifications$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$addChildNotifications$1 r0 = new com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$addChildNotifications$1
            r0.<init>(r4, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L46
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            com.onesignal.notifications.internal.data.INotificationRepository r7 = r4._dataController
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = r7.listNotificationsForGroup(r6, r0)
            if (r7 != r1) goto L46
            return r1
        L46:
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r6 = r7.iterator()
        L4c:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L65
            java.lang.Object r7 = r6.next()
            com.onesignal.notifications.internal.data.INotificationRepository$NotificationData r7 = (com.onesignal.notifications.internal.data.INotificationRepository.NotificationData) r7
            org.json.JSONObject r0 = new org.json.JSONObject
            java.lang.String r7 = r7.getFullData()
            r0.<init>(r7)
            r5.put(r0)
            goto L4c
        L65:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.addChildNotifications(org.json.JSONArray, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object markNotificationsConsumed(android.content.Context r8, android.content.Intent r9, boolean r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$markNotificationsConsumed$1
            if (r0 == 0) goto L14
            r0 = r11
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$markNotificationsConsumed$1 r0 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$markNotificationsConsumed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$markNotificationsConsumed$1 r0 = new com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor$markNotificationsConsumed$1
            r0.<init>(r7, r11)
        L19:
            r6 = r0
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L4a
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            kotlin.ResultKt.throwOnFailure(r11)
            goto L8e
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            boolean r10 = r6.Z$0
            java.lang.Object r8 = r6.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r6.L$1
            android.content.Intent r9 = (android.content.Intent) r9
            java.lang.Object r1 = r6.L$0
            com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor r1 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor) r1
            kotlin.ResultKt.throwOnFailure(r11)
            r4 = r8
            r3 = r10
            goto L67
        L4a:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.String r11 = "summary"
            java.lang.String r11 = r9.getStringExtra(r11)
            r6.L$0 = r7
            r6.L$1 = r9
            r6.L$2 = r11
            r6.Z$0 = r10
            r6.label = r3
            java.lang.Object r8 = r7.clearStatusBarNotifications(r8, r11, r6)
            if (r8 != r0) goto L64
            return r0
        L64:
            r1 = r7
            r3 = r10
            r4 = r11
        L67:
            com.onesignal.notifications.internal.data.INotificationRepository r8 = r1._dataController
            java.lang.String r10 = "androidNotificationId"
            r11 = 0
            int r9 = r9.getIntExtra(r10, r11)
            com.onesignal.core.internal.config.ConfigModelStore r10 = r1._configModelStore
            com.onesignal.common.modeling.Model r10 = r10.getModel()
            com.onesignal.core.internal.config.ConfigModel r10 = (com.onesignal.core.internal.config.ConfigModel) r10
            boolean r5 = r10.getClearGroupOnSummaryClick()
            r10 = 0
            r6.L$0 = r10
            r6.L$1 = r10
            r6.L$2 = r10
            r6.label = r2
            r1 = r8
            r2 = r9
            java.lang.Object r8 = r1.markAsConsumed(r2, r3, r4, r5, r6)
            if (r8 != r0) goto L8e
            return r0
        L8e:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.markNotificationsConsumed(android.content.Context, android.content.Intent, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object clearStatusBarNotifications(Context context, String str, Continuation<? super Unit> continuation) {
        if (str != null) {
            Object clearNotificationOnSummaryClick = this._summaryManager.clearNotificationOnSummaryClick(str, continuation);
            return clearNotificationOnSummaryClick == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clearNotificationOnSummaryClick : Unit.INSTANCE;
        }
        if (NotificationHelper.INSTANCE.getGrouplessNotifsCount(context) < 1) {
            NotificationHelper.INSTANCE.getNotificationManager(context).cancel(NotificationHelper.GROUPLESS_SUMMARY_ID);
        }
        return Unit.INSTANCE;
    }

    private final ContentValues newContentValuesWithConsumed(Intent intent) {
        ContentValues contentValues = new ContentValues();
        if (intent.getBooleanExtra("dismissed", false)) {
            contentValues.put("dismissed", (Integer) 1);
        } else {
            contentValues.put("opened", (Integer) 1);
        }
        return contentValues;
    }
}
