package com.onesignal.user.internal.operations.impl.executors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginUserOperationExecutor.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor", f = "LoginUserOperationExecutor.kt", i = {1, 1, 1}, l = {73, 79, 120, 127}, m = "loginUser", n = {"this", "loginUserOp", "operations"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes5.dex */
public final class LoginUserOperationExecutor$loginUser$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginUserOperationExecutor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginUserOperationExecutor$loginUser$1(LoginUserOperationExecutor loginUserOperationExecutor, Continuation<? super LoginUserOperationExecutor$loginUser$1> continuation) {
        super(continuation);
        this.this$0 = loginUserOperationExecutor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loginUser;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loginUser = this.this$0.loginUser(null, null, this);
        return loginUser;
    }
}
