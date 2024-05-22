package com.onesignal.inAppMessages.internal.display.impl;

import android.app.Activity;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InAppDisplayer.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$2", f = "InAppDisplayer.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class InAppDisplayer$initInAppMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $base64Str;
    final /* synthetic */ InAppMessageContent $content;
    final /* synthetic */ Activity $currentActivity;
    final /* synthetic */ WebViewManager $webViewManager;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppDisplayer$initInAppMessage$2(WebViewManager webViewManager, Activity activity, String str, InAppMessageContent inAppMessageContent, Continuation<? super InAppDisplayer$initInAppMessage$2> continuation) {
        super(2, continuation);
        this.$webViewManager = webViewManager;
        this.$currentActivity = activity;
        this.$base64Str = str;
        this.$content = inAppMessageContent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InAppDisplayer$initInAppMessage$2(this.$webViewManager, this.$currentActivity, this.$base64Str, this.$content, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InAppDisplayer$initInAppMessage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                WebViewManager webViewManager = this.$webViewManager;
                Activity activity = this.$currentActivity;
                String base64Str = this.$base64Str;
                Intrinsics.checkNotNullExpressionValue(base64Str, "base64Str");
                this.label = 1;
                if (webViewManager.setupWebView(activity, base64Str, this.$content.getIsFullBleed(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e) {
            if (e.getMessage() != null) {
                String message = e.getMessage();
                Intrinsics.checkNotNull(message);
                if (StringsKt.contains$default((CharSequence) message, (CharSequence) "No WebView installed", false, 2, (Object) null)) {
                    Logging.error("Error setting up WebView: ", e);
                }
            }
            throw e;
        }
        return Unit.INSTANCE;
    }
}
