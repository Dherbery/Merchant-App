package com.onesignal.notifications.internal.data.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NotificationRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsConsumed$2", f = "NotificationRepository.kt", i = {0, 0}, l = {322}, m = "invokeSuspend", n = {"whereStr", "isGroupless"}, s = {"L$0", "Z$0"})
/* loaded from: classes5.dex */
final class NotificationRepository$markAsConsumed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $androidId;
    final /* synthetic */ boolean $clearGroupOnSummaryClick;
    final /* synthetic */ boolean $dismissed;
    final /* synthetic */ String $summaryGroup;
    Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationRepository$markAsConsumed$2(String str, boolean z, boolean z2, NotificationRepository notificationRepository, int i, Continuation<? super NotificationRepository$markAsConsumed$2> continuation) {
        super(2, continuation);
        this.$summaryGroup = str;
        this.$dismissed = z;
        this.$clearGroupOnSummaryClick = z2;
        this.this$0 = notificationRepository;
        this.$androidId = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationRepository$markAsConsumed$2(this.$summaryGroup, this.$dismissed, this.$clearGroupOnSummaryClick, this.this$0, this.$androidId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationRepository$markAsConsumed$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L1d
            if (r1 != r2) goto L15
            boolean r0 = r7.Z$0
            java.lang.Object r1 = r7.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5a
        L15:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1d:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 0
            r1 = r8
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.lang.String r1 = r7.$summaryGroup
            if (r1 == 0) goto L7d
            java.lang.String r3 = "os_group_undefined"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L33
            java.lang.String r3 = "group_id IS NULL"
            goto L3b
        L33:
            java.lang.String r8 = r7.$summaryGroup
            java.lang.String[] r8 = new java.lang.String[]{r8}
            java.lang.String r3 = "group_id = ?"
        L3b:
            boolean r4 = r7.$dismissed
            if (r4 != 0) goto L8d
            boolean r4 = r7.$clearGroupOnSummaryClick
            if (r4 != 0) goto L8d
            com.onesignal.notifications.internal.data.impl.NotificationRepository r8 = r7.this$0
            java.lang.String r4 = r7.$summaryGroup
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.L$0 = r3
            r7.Z$0 = r1
            r7.label = r2
            r6 = 0
            java.lang.Object r8 = r8.getAndroidIdForGroup(r4, r6, r5)
            if (r8 != r0) goto L58
            return r0
        L58:
            r0 = r1
            r1 = r3
        L5a:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = " AND android_notification_id = ?"
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            if (r0 == 0) goto L76
            java.lang.String[] r8 = new java.lang.String[]{r8}
            goto L8d
        L76:
            java.lang.String r0 = r7.$summaryGroup
            java.lang.String[] r8 = new java.lang.String[]{r0, r8}
            goto L8d
        L7d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "android_notification_id = "
            r0.<init>(r1)
            int r1 = r7.$androidId
            r0.append(r1)
            java.lang.String r3 = r0.toString()
        L8d:
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            boolean r1 = r7.$dismissed
            if (r1 == 0) goto La0
            java.lang.String r1 = "dismissed"
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            r0.put(r1, r2)
            goto La9
        La0:
            java.lang.String r1 = "opened"
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            r0.put(r1, r2)
        La9:
            com.onesignal.notifications.internal.data.impl.NotificationRepository r1 = r7.this$0
            com.onesignal.core.internal.database.IDatabaseProvider r1 = com.onesignal.notifications.internal.data.impl.NotificationRepository.access$get_databaseProvider$p(r1)
            com.onesignal.core.internal.database.IDatabase r1 = r1.getOs()
            java.lang.String r2 = "notification"
            r1.update(r2, r0, r3, r8)
            com.onesignal.notifications.internal.data.impl.NotificationRepository r8 = r7.this$0
            com.onesignal.notifications.internal.badges.IBadgeCountUpdater r8 = com.onesignal.notifications.internal.data.impl.NotificationRepository.access$get_badgeCountUpdater$p(r8)
            r8.update()
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsConsumed$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
