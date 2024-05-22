package com.onesignal.core.internal.http.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpClient.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.core.internal.http.impl.HttpClient", f = "HttpClient.kt", i = {0}, l = {264}, m = "makeRequestIODispatcher", n = {"retVal"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class HttpClient$makeRequestIODispatcher$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpClient this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClient$makeRequestIODispatcher$1(HttpClient httpClient, Continuation<? super HttpClient$makeRequestIODispatcher$1> continuation) {
        super(continuation);
        this.this$0 = httpClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object makeRequestIODispatcher;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        makeRequestIODispatcher = this.this$0.makeRequestIODispatcher(null, null, null, 0, null, this);
        return makeRequestIODispatcher;
    }
}
