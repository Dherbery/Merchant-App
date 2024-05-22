package com.onesignal.core.internal.operations.impl;

import com.facebook.imageutils.JfifUtil;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.impl.OperationRepo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OperationRepo.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.core.internal.operations.impl.OperationRepo$executeOperations$5", f = "OperationRepo.kt", i = {0}, l = {JfifUtil.MARKER_SOS}, m = "invokeSuspend", n = {"waitTime"}, s = {"J$0"})
/* loaded from: classes5.dex */
public final class OperationRepo$executeOperations$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    int label;
    final /* synthetic */ OperationRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationRepo$executeOperations$5(OperationRepo operationRepo, Continuation<? super OperationRepo$executeOperations$5> continuation) {
        super(2, continuation);
        this.this$0 = operationRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OperationRepo$executeOperations$5(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OperationRepo$executeOperations$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConfigModelStore configModelStore;
        long j;
        List list;
        List list2;
        WaiterWithValue waiterWithValue;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            configModelStore = this.this$0._configModelStore;
            long opRepoPostCreateDelay = configModelStore.getModel().getOpRepoPostCreateDelay();
            this.J$0 = opRepoPostCreateDelay;
            this.label = 1;
            if (DelayKt.delay(opRepoPostCreateDelay, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = opRepoPostCreateDelay;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
        }
        list = this.this$0.queue;
        OperationRepo operationRepo = this.this$0;
        synchronized (list) {
            list2 = operationRepo.queue;
            if (true ^ list2.isEmpty()) {
                waiterWithValue = operationRepo.waiter;
                waiterWithValue.wake(new OperationRepo.LoopWaiterMessage(false, j));
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
