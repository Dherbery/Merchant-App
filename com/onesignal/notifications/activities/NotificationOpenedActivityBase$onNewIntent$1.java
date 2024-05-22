package com.onesignal.notifications.activities;

import android.content.Intent;
import com.facebook.soloader.Elf64_Ehdr;
import com.onesignal.OneSignal;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: NotificationOpenedActivityBase.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.activities.NotificationOpenedActivityBase$onNewIntent$1", f = "NotificationOpenedActivityBase.kt", i = {}, l = {Elf64_Ehdr.e_shstrndx}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class NotificationOpenedActivityBase$onNewIntent$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<NotificationOpenedActivityBase> $self;
    int label;
    final /* synthetic */ NotificationOpenedActivityBase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationOpenedActivityBase$onNewIntent$1(Ref.ObjectRef<NotificationOpenedActivityBase> objectRef, NotificationOpenedActivityBase notificationOpenedActivityBase, Continuation<? super NotificationOpenedActivityBase$onNewIntent$1> continuation) {
        super(1, continuation);
        this.$self = objectRef;
        this.this$0 = notificationOpenedActivityBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new NotificationOpenedActivityBase$onNewIntent$1(this.$self, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((NotificationOpenedActivityBase$onNewIntent$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            INotificationOpenedProcessor iNotificationOpenedProcessor = (INotificationOpenedProcessor) OneSignal.INSTANCE.getServices().getService(INotificationOpenedProcessor.class);
            NotificationOpenedActivityBase notificationOpenedActivityBase = this.$self.element;
            Intent intent = this.this$0.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent()");
            this.label = 1;
            if (iNotificationOpenedProcessor.processFromContext(notificationOpenedActivityBase, intent, this) == coroutine_suspended) {
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
