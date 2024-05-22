package com.onesignal.inAppMessages.internal.display.impl;

import android.widget.RelativeLayout;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppMessageView.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$finishAfterDelay$2", f = "InAppMessageView.kt", i = {}, l = {464, 466}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class InAppMessageView$finishAfterDelay$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InAppMessageView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessageView$finishAfterDelay$2(InAppMessageView inAppMessageView, Continuation<? super InAppMessageView$finishAfterDelay$2> continuation) {
        super(2, continuation);
        this.this$0 = inAppMessageView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InAppMessageView$finishAfterDelay$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InAppMessageView$finishAfterDelay$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        Object animateAndDismissLayout;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(600L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        z = this.this$0.hasBackground;
        if (z) {
            relativeLayout = this.this$0.parentRelativeLayout;
            if (relativeLayout != null) {
                InAppMessageView inAppMessageView = this.this$0;
                relativeLayout2 = inAppMessageView.parentRelativeLayout;
                Intrinsics.checkNotNull(relativeLayout2);
                this.label = 2;
                animateAndDismissLayout = inAppMessageView.animateAndDismissLayout(relativeLayout2, this);
                if (animateAndDismissLayout == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        this.this$0.cleanupViewsAfterDismiss();
        return Unit.INSTANCE;
    }
}
