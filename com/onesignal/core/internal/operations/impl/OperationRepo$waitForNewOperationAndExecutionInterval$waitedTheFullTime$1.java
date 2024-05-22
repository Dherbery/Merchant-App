package com.onesignal.core.internal.operations.impl;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.operations.impl.OperationRepo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OperationRepo.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1", f = "OperationRepo.kt", i = {}, l = {PsExtractor.PRIVATE_STREAM_1}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<OperationRepo.LoopWaiterMessage> $wakeMessage;
    Object L$0;
    int label;
    final /* synthetic */ OperationRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1(Ref.ObjectRef<OperationRepo.LoopWaiterMessage> objectRef, OperationRepo operationRepo, Continuation<? super OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1> continuation) {
        super(2, continuation);
        this.$wakeMessage = objectRef;
        this.this$0 = operationRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1(this.$wakeMessage, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WaiterWithValue waiterWithValue;
        Ref.ObjectRef<OperationRepo.LoopWaiterMessage> objectRef;
        T t;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<OperationRepo.LoopWaiterMessage> objectRef2 = this.$wakeMessage;
            waiterWithValue = this.this$0.waiter;
            this.L$0 = objectRef2;
            this.label = 1;
            Object waitForWake = waiterWithValue.waitForWake(this);
            if (waitForWake == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            t = waitForWake;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            t = obj;
        }
        objectRef.element = t;
        return Unit.INSTANCE;
    }
}
