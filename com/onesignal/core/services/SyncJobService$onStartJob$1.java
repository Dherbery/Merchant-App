package com.onesignal.core.services;

import android.app.job.JobParameters;
import com.onesignal.core.internal.background.IBackgroundManager;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: SyncJobService.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.core.services.SyncJobService$onStartJob$1", f = "SyncJobService.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SyncJobService$onStartJob$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<IBackgroundManager> $backgroundService;
    final /* synthetic */ JobParameters $jobParameters;
    int label;
    final /* synthetic */ SyncJobService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncJobService$onStartJob$1(Ref.ObjectRef<IBackgroundManager> objectRef, SyncJobService syncJobService, JobParameters jobParameters, Continuation<? super SyncJobService$onStartJob$1> continuation) {
        super(1, continuation);
        this.$backgroundService = objectRef;
        this.this$0 = syncJobService;
        this.$jobParameters = jobParameters;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SyncJobService$onStartJob$1(this.$backgroundService, this.this$0, this.$jobParameters, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((SyncJobService$onStartJob$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$backgroundService.element.runBackgroundServices(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Logging.debug$default("LollipopSyncRunnable:JobFinished needsJobReschedule: " + this.$backgroundService.element.getNeedsJobReschedule(), null, 2, null);
        boolean needsJobReschedule = this.$backgroundService.element.getNeedsJobReschedule();
        this.$backgroundService.element.setNeedsJobReschedule(false);
        this.this$0.jobFinished(this.$jobParameters, needsJobReschedule);
        return Unit.INSTANCE;
    }
}
