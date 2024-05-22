package com.onesignal.inAppMessages.internal.preview;

import androidx.core.text.HtmlCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppMessagePreviewHandler.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler", f = "InAppMessagePreviewHandler.kt", i = {0, 0, 1}, l = {60, HtmlCompat.FROM_HTML_MODE_COMPACT}, m = "canOpenNotification", n = {"this", "previewUUID", "this"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes5.dex */
public final class InAppMessagePreviewHandler$canOpenNotification$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppMessagePreviewHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessagePreviewHandler$canOpenNotification$1(InAppMessagePreviewHandler inAppMessagePreviewHandler, Continuation<? super InAppMessagePreviewHandler$canOpenNotification$1> continuation) {
        super(continuation);
        this.this$0 = inAppMessagePreviewHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.canOpenNotification(null, null, this);
    }
}
