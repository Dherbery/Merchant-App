package com.onesignal.notifications.internal.pushtoken;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushTokenManager.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.pushtoken.PushTokenManager", f = "PushTokenManager.kt", i = {0}, l = {31}, m = "retrievePushToken", n = {"this"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class PushTokenManager$retrievePushToken$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushTokenManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushTokenManager$retrievePushToken$1(PushTokenManager pushTokenManager, Continuation<? super PushTokenManager$retrievePushToken$1> continuation) {
        super(continuation);
        this.this$0 = pushTokenManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.retrievePushToken(this);
    }
}
