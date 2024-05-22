package com.onesignal.inAppMessages.internal.display.impl;

import androidx.constraintlayout.solver.widgets.Optimizer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebViewManager.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.WebViewManager$onActivityAvailable$1", f = "WebViewManager.kt", i = {}, l = {256, Optimizer.OPTIMIZATION_STANDARD, 267}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class WebViewManager$onActivityAvailable$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $lastActivityName;
    int label;
    final /* synthetic */ WebViewManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewManager$onActivityAvailable$1(String str, WebViewManager webViewManager, Continuation<? super WebViewManager$onActivityAvailable$1> continuation) {
        super(1, continuation);
        this.$lastActivityName = str;
        this.this$0 = webViewManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new WebViewManager$onActivityAvailable$1(this.$lastActivityName, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((WebViewManager$onActivityAvailable$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Object calculateHeightAndShowWebViewAfterNewActivity;
        Integer num;
        Object showMessageView;
        Object showMessageView2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str2 = this.$lastActivityName;
            if (str2 == null) {
                this.label = 1;
                showMessageView2 = this.this$0.showMessageView(null, this);
                if (showMessageView2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                str = this.this$0.currentActivityName;
                if (!Intrinsics.areEqual(str2, str)) {
                    if (!this.this$0.closing) {
                        if (this.this$0.messageView != null) {
                            InAppMessageView inAppMessageView = this.this$0.messageView;
                            Intrinsics.checkNotNull(inAppMessageView);
                            inAppMessageView.removeAllViews();
                        }
                        WebViewManager webViewManager = this.this$0;
                        num = webViewManager.lastPageHeight;
                        this.label = 2;
                        showMessageView = webViewManager.showMessageView(num, this);
                        if (showMessageView == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    this.label = 3;
                    calculateHeightAndShowWebViewAfterNewActivity = this.this$0.calculateHeightAndShowWebViewAfterNewActivity(this);
                    if (calculateHeightAndShowWebViewAfterNewActivity == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else if (i == 1 || i == 2 || i == 3) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
