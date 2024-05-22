package com.onesignal.inAppMessages.internal.display.impl;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout;
import com.onesignal.inAppMessages.internal.display.impl.WebViewManager;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppMessageView.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$updateHeight$2", f = "InAppMessageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class InAppMessageView$updateHeight$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pageHeight;
    int label;
    final /* synthetic */ InAppMessageView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessageView$updateHeight$2(InAppMessageView inAppMessageView, int i, Continuation<? super InAppMessageView$updateHeight$2> continuation) {
        super(2, continuation);
        this.this$0 = inAppMessageView;
        this.$pageHeight = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InAppMessageView$updateHeight$2(this.this$0, this.$pageHeight, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InAppMessageView$updateHeight$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WebView webView;
        WebView webView2;
        WebView webView3;
        DraggableRelativeLayout draggableRelativeLayout;
        DraggableRelativeLayout draggableRelativeLayout2;
        boolean z;
        DraggableRelativeLayout.Params createDraggableLayoutParams;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        webView = this.this$0.webView;
        if (webView != null) {
            webView2 = this.this$0.webView;
            Intrinsics.checkNotNull(webView2);
            ViewGroup.LayoutParams layoutParams = webView2.getLayoutParams();
            if (layoutParams == null) {
                Logging.warn$default("WebView height update skipped because of null layoutParams, new height will be used once it is displayed.", null, 2, null);
                return Unit.INSTANCE;
            }
            layoutParams.height = this.$pageHeight;
            webView3 = this.this$0.webView;
            Intrinsics.checkNotNull(webView3);
            webView3.setLayoutParams(layoutParams);
            draggableRelativeLayout = this.this$0.draggableRelativeLayout;
            if (draggableRelativeLayout != null) {
                draggableRelativeLayout2 = this.this$0.draggableRelativeLayout;
                Intrinsics.checkNotNull(draggableRelativeLayout2);
                InAppMessageView inAppMessageView = this.this$0;
                int i = this.$pageHeight;
                WebViewManager.Position displayPosition = inAppMessageView.getDisplayPosition();
                z = this.this$0.disableDragDismiss;
                createDraggableLayoutParams = inAppMessageView.createDraggableLayoutParams(i, displayPosition, z);
                draggableRelativeLayout2.setParams(createDraggableLayoutParams);
            }
            return Unit.INSTANCE;
        }
        Logging.warn$default("WebView height update skipped, new height will be used once it is displayed.", null, 2, null);
        return Unit.INSTANCE;
    }
}
