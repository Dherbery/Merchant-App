package com.onesignal.notifications.internal.data.impl;

import android.app.NotificationManager;
import android.content.ContentValues;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.notifications.internal.badges.IBadgeCountUpdater;
import com.onesignal.notifications.internal.common.NotificationHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NotificationRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissedForOutstanding$2", f = "NotificationRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class NotificationRepository$markAsDismissedForOutstanding$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationRepository$markAsDismissedForOutstanding$2(NotificationRepository notificationRepository, Continuation<? super NotificationRepository$markAsDismissedForOutstanding$2> continuation) {
        super(2, continuation);
        this.this$0 = notificationRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationRepository$markAsDismissedForOutstanding$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationRepository$markAsDismissedForOutstanding$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IApplicationService iApplicationService;
        IDatabaseProvider iDatabaseProvider;
        IDatabaseProvider iDatabaseProvider2;
        IBadgeCountUpdater iBadgeCountUpdater;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        iApplicationService = this.this$0._applicationService;
        final NotificationManager notificationManager = NotificationHelper.INSTANCE.getNotificationManager(iApplicationService.getAppContext());
        String[] strArr = {OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID};
        iDatabaseProvider = this.this$0._databaseProvider;
        IDatabase.DefaultImpls.query$default(iDatabaseProvider.getOs(), OneSignalDbContract.NotificationTable.TABLE_NAME, strArr, "dismissed = 0 AND opened = 0", null, null, null, null, null, new Function1<ICursor, Unit>() { // from class: com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissedForOutstanding$2.1
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
                if (!it.moveToFirst()) {
                    return;
                }
                do {
                    notificationManager.cancel(it.getInt(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID));
                } while (it.moveToNext());
            }
        }, 248, null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("dismissed", Boxing.boxInt(1));
        iDatabaseProvider2 = this.this$0._databaseProvider;
        iDatabaseProvider2.getOs().update(OneSignalDbContract.NotificationTable.TABLE_NAME, contentValues, "opened = 0", null);
        iBadgeCountUpdater = this.this$0._badgeCountUpdater;
        iBadgeCountUpdater.updateCount(0);
        return Unit.INSTANCE;
    }
}
