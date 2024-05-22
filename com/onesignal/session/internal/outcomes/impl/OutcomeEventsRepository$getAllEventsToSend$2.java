package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.InfluenceType;
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
import okhttp3.HttpUrl;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OutcomeEventsRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$2", f = "OutcomeEventsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class OutcomeEventsRepository$getAllEventsToSend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<OutcomeEventParams> $events;
    int label;
    final /* synthetic */ OutcomeEventsRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutcomeEventsRepository$getAllEventsToSend$2(OutcomeEventsRepository outcomeEventsRepository, List<OutcomeEventParams> list, Continuation<? super OutcomeEventsRepository$getAllEventsToSend$2> continuation) {
        super(2, continuation);
        this.this$0 = outcomeEventsRepository;
        this.$events = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OutcomeEventsRepository$getAllEventsToSend$2(this.this$0, this.$events, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OutcomeEventsRepository$getAllEventsToSend$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IDatabaseProvider iDatabaseProvider;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        iDatabaseProvider = this.this$0._databaseProvider;
        IDatabase os = iDatabaseProvider.getOs();
        final OutcomeEventsRepository outcomeEventsRepository = this.this$0;
        final List<OutcomeEventParams> list = this.$events;
        IDatabase.DefaultImpls.query$default(os, "outcome", null, null, null, null, null, null, null, new Function1<ICursor, Unit>() { // from class: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$2.1
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
            public final void invoke2(ICursor cursor) {
                OutcomeSource notificationInfluenceSource;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                if (!cursor.moveToFirst()) {
                    return;
                }
                do {
                    InfluenceType fromString = InfluenceType.INSTANCE.fromString(cursor.getString(OutcomeEventsTable.COLUMN_NAME_NOTIFICATION_INFLUENCE_TYPE));
                    InfluenceType fromString2 = InfluenceType.INSTANCE.fromString(cursor.getString(OutcomeEventsTable.COLUMN_NAME_IAM_INFLUENCE_TYPE));
                    String optString = cursor.getOptString("notification_ids");
                    if (optString == null) {
                        optString = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                    }
                    String optString2 = cursor.getOptString(OutcomeEventsTable.COLUMN_NAME_IAM_IDS);
                    String str = optString2 == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : optString2;
                    String string = cursor.getString("name");
                    float f = cursor.getFloat("weight");
                    long j = cursor.getLong("timestamp");
                    long j2 = cursor.getLong("session_time");
                    try {
                        OutcomeSourceBody outcomeSourceBody = new OutcomeSourceBody(null, null, 3, null);
                        OutcomeSourceBody outcomeSourceBody2 = new OutcomeSourceBody(null, null, 3, null);
                        notificationInfluenceSource = OutcomeEventsRepository.this.getNotificationInfluenceSource(fromString, outcomeSourceBody, outcomeSourceBody2, optString);
                        OutcomeEventsRepository.this.getIAMInfluenceSource(fromString2, outcomeSourceBody, outcomeSourceBody2, str, notificationInfluenceSource);
                        if (notificationInfluenceSource == null) {
                            notificationInfluenceSource = new OutcomeSource(null, null);
                        }
                        list.add(new OutcomeEventParams(string, notificationInfluenceSource, f, j2, j));
                    } catch (JSONException e) {
                        Logging.error("Generating JSONArray from notifications ids outcome:JSON Failed.", e);
                    }
                } while (cursor.moveToNext());
            }
        }, 254, null);
        return Unit.INSTANCE;
    }
}
