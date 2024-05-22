package com.onesignal.core.internal.operations.impl;

import com.facebook.imagepipeline.common.RotationOptions;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OperationRepo.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.core.internal.operations.impl.OperationRepo", f = "OperationRepo.kt", i = {0, 0, 1, 1}, l = {RotationOptions.ROTATE_180, TsExtractor.TS_PACKET_SIZE}, m = "waitForNewOperationAndExecutionInterval", n = {"this", "wakeMessage", "this", "wakeMessage"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes5.dex */
public final class OperationRepo$waitForNewOperationAndExecutionInterval$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OperationRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationRepo$waitForNewOperationAndExecutionInterval$1(OperationRepo operationRepo, Continuation<? super OperationRepo$waitForNewOperationAndExecutionInterval$1> continuation) {
        super(continuation);
        this.this$0 = operationRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object waitForNewOperationAndExecutionInterval;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        waitForNewOperationAndExecutionInterval = this.this$0.waitForNewOperationAndExecutionInterval(this);
        return waitForNewOperationAndExecutionInterval;
    }
}
