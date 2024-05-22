package com.onesignal.inAppMessages.internal.display.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebViewManager.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.WebViewManager", f = "WebViewManager.kt", i = {1, 2}, l = {221, 226, 232}, m = "calculateHeightAndShowWebViewAfterNewActivity", n = {"this", "this"}, s = {"L$0", "L$0"})
/* loaded from: classes5.dex */
public final class WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebViewManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1(WebViewManager webViewManager, Continuation<? super WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1> continuation) {
        super(continuation);
        this.this$0 = webViewManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object calculateHeightAndShowWebViewAfterNewActivity;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        calculateHeightAndShowWebViewAfterNewActivity = this.this$0.calculateHeightAndShowWebViewAfterNewActivity(this);
        return calculateHeightAndShowWebViewAfterNewActivity;
    }
}
