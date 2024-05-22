package com.revenuecat.purchases.common;

import com.revenuecat.purchases.LogHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: logUtils.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public /* synthetic */ class LogUtilsKt$debugLog$1 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LogUtilsKt$debugLog$1(Object obj) {
        super(2, obj, LogHandler.class, "d", "d(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
        invoke2(str, str2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((LogHandler) this.receiver).d(p0, p1);
    }
}
