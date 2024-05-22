package com.onesignal.inAppMessages.internal.display.impl;

import android.app.Activity;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.solver.widgets.Optimizer;
import com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout;
import com.onesignal.inAppMessages.internal.display.impl.InAppMessageView;
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
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$showDraggableView$2", f = "InAppMessageView.kt", i = {}, l = {Optimizer.OPTIMIZATION_STANDARD}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class InAppMessageView$showDraggableView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WebViewManager.Position $displayLocation;
    final /* synthetic */ RelativeLayout.LayoutParams $draggableRelativeLayoutParams;
    final /* synthetic */ RelativeLayout.LayoutParams $relativeLayoutParams;
    final /* synthetic */ DraggableRelativeLayout.Params $webViewLayoutParams;
    int label;
    final /* synthetic */ InAppMessageView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessageView$showDraggableView$2(InAppMessageView inAppMessageView, RelativeLayout.LayoutParams layoutParams, RelativeLayout.LayoutParams layoutParams2, DraggableRelativeLayout.Params params, WebViewManager.Position position, Continuation<? super InAppMessageView$showDraggableView$2> continuation) {
        super(2, continuation);
        this.this$0 = inAppMessageView;
        this.$relativeLayoutParams = layoutParams;
        this.$draggableRelativeLayoutParams = layoutParams2;
        this.$webViewLayoutParams = params;
        this.$displayLocation = position;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InAppMessageView$showDraggableView$2(this.this$0, this.$relativeLayoutParams, this.$draggableRelativeLayoutParams, this.$webViewLayoutParams, this.$displayLocation, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InAppMessageView$showDraggableView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WebView webView;
        WebView webView2;
        Activity activity;
        Activity activity2;
        RelativeLayout relativeLayout;
        InAppMessageView.InAppMessageViewListener inAppMessageViewListener;
        Object startDismissTimerIfNeeded;
        DraggableRelativeLayout draggableRelativeLayout;
        RelativeLayout relativeLayout2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            webView = this.this$0.webView;
            if (webView != null) {
                webView2 = this.this$0.webView;
                Intrinsics.checkNotNull(webView2);
                webView2.setLayoutParams(this.$relativeLayoutParams);
                InAppMessageView inAppMessageView = this.this$0;
                activity = inAppMessageView.currentActivity;
                Intrinsics.checkNotNull(activity);
                inAppMessageView.setUpDraggableLayout(activity, this.$draggableRelativeLayoutParams, this.$webViewLayoutParams);
                InAppMessageView inAppMessageView2 = this.this$0;
                activity2 = inAppMessageView2.currentActivity;
                Intrinsics.checkNotNull(activity2);
                inAppMessageView2.setUpParentRelativeLayout(activity2);
                InAppMessageView inAppMessageView3 = this.this$0;
                relativeLayout = inAppMessageView3.parentRelativeLayout;
                Intrinsics.checkNotNull(relativeLayout);
                inAppMessageView3.createPopupWindow(relativeLayout);
                inAppMessageViewListener = this.this$0.messageController;
                if (inAppMessageViewListener != null) {
                    InAppMessageView inAppMessageView4 = this.this$0;
                    WebViewManager.Position position = this.$displayLocation;
                    draggableRelativeLayout = inAppMessageView4.draggableRelativeLayout;
                    Intrinsics.checkNotNull(draggableRelativeLayout);
                    relativeLayout2 = this.this$0.parentRelativeLayout;
                    Intrinsics.checkNotNull(relativeLayout2);
                    inAppMessageView4.animateInAppMessage(position, draggableRelativeLayout, relativeLayout2);
                }
                this.label = 1;
                startDismissTimerIfNeeded = this.this$0.startDismissTimerIfNeeded(this);
                if (startDismissTimerIfNeeded == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                return Unit.INSTANCE;
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
