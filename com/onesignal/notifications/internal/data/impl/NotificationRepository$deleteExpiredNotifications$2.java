package com.onesignal.notifications.internal.data.impl;

import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.time.ITime;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NotificationRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$deleteExpiredNotifications$2", f = "NotificationRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class NotificationRepository$deleteExpiredNotifications$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationRepository$deleteExpiredNotifications$2(NotificationRepository notificationRepository, Continuation<? super NotificationRepository$deleteExpiredNotifications$2> continuation) {
        super(2, continuation);
        this.this$0 = notificationRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationRepository$deleteExpiredNotifications$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationRepository$deleteExpiredNotifications$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ITime iTime;
        IDatabaseProvider iDatabaseProvider;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        iTime = this.this$0._time;
        String valueOf = String.valueOf((iTime.getCurrentTimeMillis() / 1000) - 604800);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(\n               …FETIME,\n                )");
        iDatabaseProvider = this.this$0._databaseProvider;
        iDatabaseProvider.getOs().delete(OneSignalDbContract.NotificationTable.TABLE_NAME, "created_time < ?", new String[]{valueOf});
        return Unit.INSTANCE;
    }
}
