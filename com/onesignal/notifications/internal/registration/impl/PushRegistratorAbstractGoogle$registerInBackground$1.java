package com.onesignal.notifications.internal.registration.impl;

import androidx.appcompat.app.AppCompatDelegate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushRegistratorAbstractGoogle.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle", f = "PushRegistratorAbstractGoogle.kt", i = {0, 0, 0, 1, 1, 1}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 113}, m = "registerInBackground", n = {"this", "senderId", "currentRetry", "this", "senderId", "currentRetry"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"})
/* loaded from: classes5.dex */
public final class PushRegistratorAbstractGoogle$registerInBackground$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushRegistratorAbstractGoogle this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushRegistratorAbstractGoogle$registerInBackground$1(PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle, Continuation<? super PushRegistratorAbstractGoogle$registerInBackground$1> continuation) {
        super(continuation);
        this.this$0 = pushRegistratorAbstractGoogle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object registerInBackground;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        registerInBackground = this.this$0.registerInBackground(null, this);
        return registerInBackground;
    }
}
