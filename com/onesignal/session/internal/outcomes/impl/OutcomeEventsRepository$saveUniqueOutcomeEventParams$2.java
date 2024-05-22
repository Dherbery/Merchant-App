package com.onesignal.session.internal.outcomes.impl;

import android.content.ContentValues;
import com.onesignal.core.internal.database.IDatabaseProvider;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: OutcomeEventsRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$saveUniqueOutcomeEventParams$2", f = "OutcomeEventsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class OutcomeEventsRepository$saveUniqueOutcomeEventParams$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OutcomeEventParams $eventParams;
    int label;
    final /* synthetic */ OutcomeEventsRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutcomeEventsRepository$saveUniqueOutcomeEventParams$2(OutcomeEventParams outcomeEventParams, OutcomeEventsRepository outcomeEventsRepository, Continuation<? super OutcomeEventsRepository$saveUniqueOutcomeEventParams$2> continuation) {
        super(2, continuation);
        this.$eventParams = outcomeEventParams;
        this.this$0 = outcomeEventsRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OutcomeEventsRepository$saveUniqueOutcomeEventParams$2(this.$eventParams, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OutcomeEventsRepository$saveUniqueOutcomeEventParams$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IDatabaseProvider iDatabaseProvider;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String outcomeId = this.$eventParams.getOutcomeId();
        ArrayList<CachedUniqueOutcome> arrayList = new ArrayList();
        OutcomeSource outcomeSource = this.$eventParams.getOutcomeSource();
        OutcomeSourceBody directBody = outcomeSource != null ? outcomeSource.getDirectBody() : null;
        OutcomeSource outcomeSource2 = this.$eventParams.getOutcomeSource();
        OutcomeSourceBody indirectBody = outcomeSource2 != null ? outcomeSource2.getIndirectBody() : null;
        this.this$0.addIdsToListFromSource(arrayList, directBody);
        this.this$0.addIdsToListFromSource(arrayList, indirectBody);
        for (CachedUniqueOutcome cachedUniqueOutcome : arrayList) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("channel_influence_id", cachedUniqueOutcome.getInfluenceId());
            contentValues.put("channel_type", cachedUniqueOutcome.getChannel().getNameValue());
            contentValues.put("name", outcomeId);
            iDatabaseProvider = this.this$0._databaseProvider;
            iDatabaseProvider.getOs().insert("cached_unique_outcome", null, contentValues);
        }
        return Unit.INSTANCE;
    }
}
