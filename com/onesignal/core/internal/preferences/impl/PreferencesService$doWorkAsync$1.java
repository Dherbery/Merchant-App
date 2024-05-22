package com.onesignal.core.internal.preferences.impl;

import com.facebook.imageutils.JfifUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreferencesService.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.core.internal.preferences.impl.PreferencesService$doWorkAsync$1", f = "PreferencesService.kt", i = {0, 1}, l = {221, JfifUtil.MARKER_APP1}, m = "invokeSuspend", n = {"lastSyncTime", "lastSyncTime"}, s = {"J$0", "J$0"})
/* loaded from: classes5.dex */
public final class PreferencesService$doWorkAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    int label;
    final /* synthetic */ PreferencesService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferencesService$doWorkAsync$1(PreferencesService preferencesService, Continuation<? super PreferencesService$doWorkAsync$1> continuation) {
        super(2, continuation);
        this.this$0 = preferencesService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreferencesService$doWorkAsync$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PreferencesService$doWorkAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b A[Catch: all -> 0x011c, TryCatch #2 {all -> 0x011c, blocks: (B:7:0x0037, B:8:0x0045, B:10:0x004b, B:69:0x0068, B:13:0x0072, B:14:0x0076, B:57:0x00d8, B:58:0x00d9, B:63:0x00df, B:64:0x00e0, B:72:0x00e1, B:82:0x0108, B:16:0x0077, B:17:0x007f, B:19:0x0085, B:53:0x0093, B:22:0x0099, B:50:0x009d, B:25:0x00a7, B:47:0x00ab, B:28:0x00b5, B:44:0x00b9, B:31:0x00c3, B:41:0x00c7, B:36:0x00cf, B:56:0x00d3), top: B:6:0x0037, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0107 A[EDGE_INSN: B:89:0x0107->B:81:0x0107 BREAK  A[LOOP:0: B:6:0x0037->B:88:0x0121], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0119 -> B:5:0x0037). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.preferences.impl.PreferencesService$doWorkAsync$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
