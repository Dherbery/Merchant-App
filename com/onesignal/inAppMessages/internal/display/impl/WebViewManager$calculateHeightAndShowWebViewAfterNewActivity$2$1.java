package com.onesignal.inAppMessages.internal.display.impl;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebViewManager.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1", f = "WebViewManager.kt", i = {}, l = {PsExtractor.VIDEO_STREAM_MASK}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pagePxHeight;
    int label;
    final /* synthetic */ WebViewManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1(WebViewManager webViewManager, int i, Continuation<? super WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1> continuation) {
        super(1, continuation);
        this.this$0 = webViewManager;
        this.$pagePxHeight = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1(this.this$0, this.$pagePxHeight, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object showMessageView;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            showMessageView = this.this$0.showMessageView(Boxing.boxInt(this.$pagePxHeight), this);
            if (showMessageView == coroutine_suspended) {
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
