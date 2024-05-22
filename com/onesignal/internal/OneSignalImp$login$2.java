package com.onesignal.internal;

import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.operations.LoginUserOperation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: OneSignalImp.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.internal.OneSignalImp$login$2", f = "OneSignalImp.kt", i = {}, l = {375}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class OneSignalImp$login$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $currentIdentityExternalId;
    final /* synthetic */ Ref.ObjectRef<String> $currentIdentityOneSignalId;
    final /* synthetic */ String $externalId;
    final /* synthetic */ Ref.ObjectRef<String> $newIdentityOneSignalId;
    int label;
    final /* synthetic */ OneSignalImp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneSignalImp$login$2(OneSignalImp oneSignalImp, Ref.ObjectRef<String> objectRef, String str, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, Continuation<? super OneSignalImp$login$2> continuation) {
        super(1, continuation);
        this.this$0 = oneSignalImp;
        this.$newIdentityOneSignalId = objectRef;
        this.$externalId = str;
        this.$currentIdentityExternalId = objectRef2;
        this.$currentIdentityOneSignalId = objectRef3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new OneSignalImp$login$2(this.this$0, this.$newIdentityOneSignalId, this.$externalId, this.$currentIdentityExternalId, this.$currentIdentityOneSignalId, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((OneSignalImp$login$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IOperationRepo iOperationRepo;
        ConfigModel configModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            iOperationRepo = this.this$0.operationRepo;
            Intrinsics.checkNotNull(iOperationRepo);
            configModel = this.this$0.configModel;
            Intrinsics.checkNotNull(configModel);
            String appId = configModel.getAppId();
            String str = this.$newIdentityOneSignalId.element;
            String str2 = this.$externalId;
            String str3 = this.$currentIdentityExternalId.element == null ? this.$currentIdentityOneSignalId.element : null;
            this.label = 1;
            obj = IOperationRepo.DefaultImpls.enqueueAndWait$default(iOperationRepo, new LoginUserOperation(appId, str, str2, str3), false, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (!((Boolean) obj).booleanValue()) {
            Logging.log(LogLevel.ERROR, "Could not login user");
        }
        return Unit.INSTANCE;
    }
}
