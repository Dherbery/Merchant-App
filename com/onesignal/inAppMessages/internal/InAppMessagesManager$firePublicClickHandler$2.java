package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.IInAppMessageClickListener;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: InAppMessagesManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/onesignal/inAppMessages/IInAppMessageClickListener;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$firePublicClickHandler$2", f = "InAppMessagesManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class InAppMessagesManager$firePublicClickHandler$2 extends SuspendLambda implements Function2<IInAppMessageClickListener, Continuation<? super Unit>, Object> {
    final /* synthetic */ InAppMessageClickEvent $result;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessagesManager$firePublicClickHandler$2(InAppMessageClickEvent inAppMessageClickEvent, Continuation<? super InAppMessagesManager$firePublicClickHandler$2> continuation) {
        super(2, continuation);
        this.$result = inAppMessageClickEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InAppMessagesManager$firePublicClickHandler$2 inAppMessagesManager$firePublicClickHandler$2 = new InAppMessagesManager$firePublicClickHandler$2(this.$result, continuation);
        inAppMessagesManager$firePublicClickHandler$2.L$0 = obj;
        return inAppMessagesManager$firePublicClickHandler$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(IInAppMessageClickListener iInAppMessageClickListener, Continuation<? super Unit> continuation) {
        return ((InAppMessagesManager$firePublicClickHandler$2) create(iInAppMessageClickListener, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ((IInAppMessageClickListener) this.L$0).onClick(this.$result);
        return Unit.INSTANCE;
    }
}
