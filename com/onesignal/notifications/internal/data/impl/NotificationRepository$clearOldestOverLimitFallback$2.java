package com.onesignal.notifications.internal.data.impl;

import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.data.INotificationQueryHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NotificationRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$clearOldestOverLimitFallback$2", f = "NotificationRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class NotificationRepository$clearOldestOverLimitFallback$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $maxNumberOfNotificationsInt;
    final /* synthetic */ int $notificationsToMakeRoomFor;
    int label;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationRepository$clearOldestOverLimitFallback$2(int i, NotificationRepository notificationRepository, int i2, Continuation<? super NotificationRepository$clearOldestOverLimitFallback$2> continuation) {
        super(2, continuation);
        this.$maxNumberOfNotificationsInt = i;
        this.this$0 = notificationRepository;
        this.$notificationsToMakeRoomFor = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationRepository$clearOldestOverLimitFallback$2(this.$maxNumberOfNotificationsInt, this.this$0, this.$notificationsToMakeRoomFor, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationRepository$clearOldestOverLimitFallback$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IDatabaseProvider iDatabaseProvider;
        INotificationQueryHelper iNotificationQueryHelper;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String valueOf = String.valueOf(this.$maxNumberOfNotificationsInt);
        try {
            iDatabaseProvider = this.this$0._databaseProvider;
            IDatabase os = iDatabaseProvider.getOs();
            String[] strArr = {OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID};
            iNotificationQueryHelper = this.this$0._queryHelper;
            String sb = iNotificationQueryHelper.recentUninteractedWithNotificationsWhere().toString();
            String str = valueOf + this.$notificationsToMakeRoomFor;
            final int i = this.$maxNumberOfNotificationsInt;
            final int i2 = this.$notificationsToMakeRoomFor;
            final NotificationRepository notificationRepository = this.this$0;
            IDatabase.DefaultImpls.query$default(os, OneSignalDbContract.NotificationTable.TABLE_NAME, strArr, sb, null, null, null, "_id", str, new Function1<ICursor, Unit>() { // from class: com.onesignal.notifications.internal.data.impl.NotificationRepository$clearOldestOverLimitFallback$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ICursor iCursor) {
                    invoke2(iCursor);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ICursor it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    int count = (it.getCount() - i) + i2;
                    if (count < 1) {
                        return;
                    }
                    while (it.moveToNext()) {
                        notificationRepository.internalMarkAsDismissed(it.getInt(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID));
                        count--;
                        if (count <= 0) {
                            return;
                        }
                    }
                }
            }, 56, null);
        } catch (Throwable th) {
            Logging.error("Error clearing oldest notifications over limit! ", th);
        }
        return Unit.INSTANCE;
    }
}
