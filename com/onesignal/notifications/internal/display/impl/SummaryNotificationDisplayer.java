package com.onesignal.notifications.internal.display.impl;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.display.INotificationDisplayBuilder;
import com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: SummaryNotificationDisplayer.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J2\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J1\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010H\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u001a\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J+\u0010%\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010&2\u0006\u0010!\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/onesignal/notifications/internal/display/impl/SummaryNotificationDisplayer;", "Lcom/onesignal/notifications/internal/display/ISummaryNotificationDisplayer;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_dataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_notificationDisplayBuilder", "Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;)V", "currentContext", "Landroid/content/Context;", "getCurrentContext", "()Landroid/content/Context;", "createBaseSummaryIntent", "Landroid/content/Intent;", "summaryNotificationId", "", "intentGenerator", "Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;", "fcmJson", "Lorg/json/JSONObject;", "group", "", "createGenericPendingIntentsForGroup", "", "notifBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "gcmBundle", "notificationId", "createGrouplessSummaryNotification", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "grouplessNotifCount", "groupAlertBehavior", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSingleNotificationBeforeSummaryBuilder", "Landroid/app/Notification;", "createSummaryNotification", "Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder$OneSignalNotificationBuilder;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder$OneSignalNotificationBuilder;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSummaryNotification", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class SummaryNotificationDisplayer implements ISummaryNotificationDisplayer {
    private final IApplicationService _applicationService;
    private final INotificationRepository _dataController;
    private final INotificationDisplayBuilder _notificationDisplayBuilder;

    public SummaryNotificationDisplayer(IApplicationService _applicationService, INotificationRepository _dataController, INotificationDisplayBuilder _notificationDisplayBuilder) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_dataController, "_dataController");
        Intrinsics.checkNotNullParameter(_notificationDisplayBuilder, "_notificationDisplayBuilder");
        this._applicationService = _applicationService;
        this._dataController = _dataController;
        this._notificationDisplayBuilder = _notificationDisplayBuilder;
    }

    private final Context getCurrentContext() {
        return this._applicationService.getAppContext();
    }

    @Override // com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer
    public void createGenericPendingIntentsForGroup(NotificationCompat.Builder notifBuilder, IntentGeneratorForAttachingToNotifications intentGenerator, JSONObject gcmBundle, String group, int notificationId) {
        Intrinsics.checkNotNullParameter(intentGenerator, "intentGenerator");
        Intrinsics.checkNotNullParameter(gcmBundle, "gcmBundle");
        Intrinsics.checkNotNullParameter(group, "group");
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt();
        Intent putExtra = intentGenerator.getNewBaseIntent(notificationId).putExtra(NotificationConstants.BUNDLE_KEY_ONESIGNAL_DATA, gcmBundle.toString()).putExtra("grp", group);
        Intrinsics.checkNotNullExpressionValue(putExtra, "intentGenerator.getNewBa…)).putExtra(\"grp\", group)");
        PendingIntent newActionPendingIntent = intentGenerator.getNewActionPendingIntent(nextInt, putExtra);
        Intrinsics.checkNotNull(notifBuilder);
        notifBuilder.setContentIntent(newActionPendingIntent);
        INotificationDisplayBuilder iNotificationDisplayBuilder = this._notificationDisplayBuilder;
        int nextInt2 = secureRandom.nextInt();
        Intent putExtra2 = this._notificationDisplayBuilder.getNewBaseDismissIntent(notificationId).putExtra("grp", group);
        Intrinsics.checkNotNullExpressionValue(putExtra2, "_notificationDisplayBuil…d).putExtra(\"grp\", group)");
        notifBuilder.setDeleteIntent(iNotificationDisplayBuilder.getNewDismissActionPendingIntent(nextInt2, putExtra2));
        notifBuilder.setGroup(group);
        try {
            notifBuilder.setGroupAlertBehavior(this._notificationDisplayBuilder.getGroupAlertBehavior());
        } catch (Throwable unused) {
        }
    }

    @Override // com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer
    public Notification createSingleNotificationBeforeSummaryBuilder(NotificationGenerationJob notificationJob, NotificationCompat.Builder notifBuilder) {
        Intrinsics.checkNotNullParameter(notificationJob, "notificationJob");
        boolean z = Build.VERSION.SDK_INT < 24 && !notificationJob.getIsRestoring();
        if (z && notificationJob.getOverriddenSound() != null) {
            Uri overriddenSound = notificationJob.getOverriddenSound();
            Intrinsics.checkNotNull(overriddenSound);
            if (!overriddenSound.equals(notificationJob.getOrgSound())) {
                Intrinsics.checkNotNull(notifBuilder);
                notifBuilder.setSound(null);
            }
        }
        Intrinsics.checkNotNull(notifBuilder);
        Notification build = notifBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "notifBuilder!!.build()");
        if (z) {
            notifBuilder.setSound(notificationJob.getOverriddenSound());
        }
        return build;
    }

    @Override // com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer
    public Object updateSummaryNotification(NotificationGenerationJob notificationGenerationJob, Continuation<? super Unit> continuation) {
        Object createSummaryNotification = createSummaryNotification(notificationGenerationJob, null, this._notificationDisplayBuilder.getGroupAlertBehavior(), continuation);
        return createSummaryNotification == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? createSummaryNotification : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x02b3, code lost:
    
        if (r7 == null) goto L65;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0257 A[EDGE_INSN: B:34:0x0257->B:35:0x0257 BREAK  A[LOOP:0: B:13:0x01d4->B:21:0x024d], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    @Override // com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object createSummaryNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob r27, com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder.OneSignalNotificationBuilder r28, int r29, kotlin.coroutines.Continuation<? super kotlin.Unit> r30) {
        /*
            Method dump skipped, instructions count: 1115
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer.createSummaryNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob, com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder$OneSignalNotificationBuilder, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:3|(12:5|6|(1:(1:9)(2:24|25))(2:26|(1:28)(1:29))|10|(1:12)|13|(1:15)|16|17|18|19|20))|30|6|(0)(0)|10|(0)|13|(0)|16|17|18|19|20) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object createGrouplessSummaryNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob r10, com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications r11, int r12, int r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer.createGrouplessSummaryNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob, com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Intent createBaseSummaryIntent(int summaryNotificationId, IntentGeneratorForAttachingToNotifications intentGenerator, JSONObject fcmJson, String group) {
        Intent putExtra = intentGenerator.getNewBaseIntent(summaryNotificationId).putExtra(NotificationConstants.BUNDLE_KEY_ONESIGNAL_DATA, fcmJson.toString()).putExtra("summary", group);
        Intrinsics.checkNotNullExpressionValue(putExtra, "intentGenerator.getNewBa…utExtra(\"summary\", group)");
        return putExtra;
    }
}
