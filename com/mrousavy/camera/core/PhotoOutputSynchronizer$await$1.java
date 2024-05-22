package com.mrousavy.camera.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhotoOutputSynchronizer.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.mrousavy.camera.core.PhotoOutputSynchronizer", f = "PhotoOutputSynchronizer.kt", i = {0, 0}, l = {17}, m = "await", n = {"this", "timestamp"}, s = {"L$0", "J$0"})
/* loaded from: classes5.dex */
public final class PhotoOutputSynchronizer$await$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PhotoOutputSynchronizer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoOutputSynchronizer$await$1(PhotoOutputSynchronizer photoOutputSynchronizer, Continuation<? super PhotoOutputSynchronizer$await$1> continuation) {
        super(continuation);
        this.this$0 = photoOutputSynchronizer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.await(0L, this);
    }
}
