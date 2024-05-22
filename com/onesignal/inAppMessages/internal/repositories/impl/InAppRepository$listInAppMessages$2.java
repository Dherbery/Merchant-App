package com.onesignal.inAppMessages.internal.repositories.impl;

import com.onesignal.common.JSONUtils;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageRedisplayStats;
import java.util.List;
import java.util.Set;
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
/* compiled from: InAppRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$2", f = "InAppRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class InAppRepository$listInAppMessages$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<InAppMessage> $inAppMessages;
    int label;
    final /* synthetic */ InAppRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppRepository$listInAppMessages$2(InAppRepository inAppRepository, List<InAppMessage> list, Continuation<? super InAppRepository$listInAppMessages$2> continuation) {
        super(2, continuation);
        this.this$0 = inAppRepository;
        this.$inAppMessages = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InAppRepository$listInAppMessages$2(this.this$0, this.$inAppMessages, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InAppRepository$listInAppMessages$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            iDatabaseProvider = this.this$0._databaseProvider;
            IDatabase os = iDatabaseProvider.getOs();
            final InAppRepository inAppRepository = this.this$0;
            final List<InAppMessage> list = this.$inAppMessages;
            IDatabase.DefaultImpls.query$default(os, OneSignalDbContract.InAppMessageTable.TABLE_NAME, null, null, null, null, null, null, null, new Function1<ICursor, Unit>() { // from class: com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$2.1
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
                    ITime iTime;
                    ITime iTime2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (!it.moveToFirst()) {
                        return;
                    }
                    do {
                        String string = it.getString("message_id");
                        String string2 = it.getString(OneSignalDbContract.InAppMessageTable.COLUMN_CLICK_IDS);
                        int i = it.getInt(OneSignalDbContract.InAppMessageTable.COLUMN_NAME_DISPLAY_QUANTITY);
                        long j = it.getLong(OneSignalDbContract.InAppMessageTable.COLUMN_NAME_LAST_DISPLAY);
                        boolean z = it.getInt(OneSignalDbContract.InAppMessageTable.COLUMN_DISPLAYED_IN_SESSION) == 1;
                        Set<String> newStringSetFromJSONArray = JSONUtils.INSTANCE.newStringSetFromJSONArray(new JSONArray(string2));
                        iTime = InAppRepository.this._time;
                        InAppMessageRedisplayStats inAppMessageRedisplayStats = new InAppMessageRedisplayStats(i, j, iTime);
                        iTime2 = InAppRepository.this._time;
                        list.add(new InAppMessage(string, newStringSetFromJSONArray, z, inAppMessageRedisplayStats, iTime2));
                    } while (it.moveToNext());
                }
            }, 254, null);
        } catch (JSONException e) {
            Logging.error("Generating JSONArray from iam click ids:JSON Failed.", e);
        }
        return Unit.INSTANCE;
    }
}
