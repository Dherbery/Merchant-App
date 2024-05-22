package com.onesignal.user.internal.operations.impl.executors;

import com.facebook.soloader.Elf64_Ehdr;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RefreshUserOperationExecutor.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor", f = "RefreshUserOperationExecutor.kt", i = {0, 0}, l = {Elf64_Ehdr.e_shentsize}, m = "getUser", n = {"this", "op"}, s = {"L$0", "L$1"})
/* loaded from: classes5.dex */
public final class RefreshUserOperationExecutor$getUser$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RefreshUserOperationExecutor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RefreshUserOperationExecutor$getUser$1(RefreshUserOperationExecutor refreshUserOperationExecutor, Continuation<? super RefreshUserOperationExecutor$getUser$1> continuation) {
        super(continuation);
        this.this$0 = refreshUserOperationExecutor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object user;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        user = this.this$0.getUser(null, this);
        return user;
    }
}
