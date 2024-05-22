package com.onesignal.session.internal.outcomes.impl;

import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.session.internal.influence.Influence;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OutcomeEventsRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2", f = "OutcomeEventsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Influence> $influences;
    final /* synthetic */ String $name;
    final /* synthetic */ List<Influence> $uniqueInfluences;
    int label;
    final /* synthetic */ OutcomeEventsRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2(List<Influence> list, String str, OutcomeEventsRepository outcomeEventsRepository, List<Influence> list2, Continuation<? super OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2> continuation) {
        super(2, continuation);
        this.$influences = list;
        this.$name = str;
        this.this$0 = outcomeEventsRepository;
        this.$uniqueInfluences = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2(this.$influences, this.$name, this.this$0, this.$uniqueInfluences, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IDatabaseProvider iDatabaseProvider;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            for (Influence influence : this.$influences) {
                final JSONArray jSONArray = new JSONArray();
                JSONArray ids = influence.getIds();
                if (ids != null) {
                    int length = ids.length();
                    for (int i = 0; i < length; i++) {
                        final String string = ids.getString(i);
                        String[] strArr = {string, influence.getInfluenceChannel().getNameValue(), this.$name};
                        iDatabaseProvider = this.this$0._databaseProvider;
                        IDatabase.DefaultImpls.query$default(iDatabaseProvider.getOs(), "cached_unique_outcome", new String[0], "channel_influence_id = ? AND channel_type = ? AND name = ?", strArr, null, null, null, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, new Function1<ICursor, Unit>() { // from class: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ICursor iCursor) {
                                invoke2(iCursor);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ICursor it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (it.getCount() == 0) {
                                    jSONArray.put(string);
                                }
                            }
                        }, 112, null);
                    }
                    if (jSONArray.length() > 0) {
                        Influence copy = influence.copy();
                        copy.setIds(jSONArray);
                        this.$uniqueInfluences.add(copy);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Unit.INSTANCE;
    }
}
