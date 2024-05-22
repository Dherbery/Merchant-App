package com.onesignal.inAppMessages.internal.prompt.impl;

import com.onesignal.inAppMessages.BuildConfig;
import com.onesignal.location.ILocationManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InAppMessageLocationPrompt.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u0004\u0018\u00010\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessageLocationPrompt;", "Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt;", "_locationManager", "Lcom/onesignal/location/ILocationManager;", "(Lcom/onesignal/location/ILocationManager;)V", "promptKey", "", "getPromptKey", "()Ljava/lang/String;", "handlePrompt", "Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt$PromptActionResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppMessageLocationPrompt extends InAppMessagePrompt {
    private final ILocationManager _locationManager;

    @Override // com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt
    public String getPromptKey() {
        return "location";
    }

    public InAppMessageLocationPrompt(ILocationManager _locationManager) {
        Intrinsics.checkNotNullParameter(_locationManager, "_locationManager");
        this._locationManager = _locationManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object handlePrompt(kotlin.coroutines.Continuation<? super com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt.PromptActionResult> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.onesignal.inAppMessages.internal.prompt.impl.InAppMessageLocationPrompt$handlePrompt$1
            if (r0 == 0) goto L14
            r0 = r5
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessageLocationPrompt$handlePrompt$1 r0 = (com.onesignal.inAppMessages.internal.prompt.impl.InAppMessageLocationPrompt$handlePrompt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessageLocationPrompt$handlePrompt$1 r0 = new com.onesignal.inAppMessages.internal.prompt.impl.InAppMessageLocationPrompt$handlePrompt$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L40
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            com.onesignal.location.ILocationManager r5 = r4._locationManager
            r0.label = r3
            java.lang.Object r5 = r5.requestPermission(r0)
            if (r5 != r1) goto L40
            return r1
        L40:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != r3) goto L4b
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt$PromptActionResult r5 = com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt.PromptActionResult.PERMISSION_GRANTED
            goto L4f
        L4b:
            if (r5 != 0) goto L50
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt$PromptActionResult r5 = com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt.PromptActionResult.PERMISSION_DENIED
        L4f:
            return r5
        L50:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.prompt.impl.InAppMessageLocationPrompt.handlePrompt(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
