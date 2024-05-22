package com.revenuecat.purchases.hybridcommon.mappers;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.hybridcommon.ErrorContainer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PurchasesError.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0016\b\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¨\u0006\u0007"}, d2 = {"map", "Lcom/revenuecat/purchases/hybridcommon/ErrorContainer;", "Lcom/revenuecat/purchases/PurchasesError;", "extra", "", "", "", "hybridcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PurchasesErrorKt {
    public static /* synthetic */ ErrorContainer map$default(PurchasesError purchasesError, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        return map(purchasesError, map);
    }

    public static final ErrorContainer map(PurchasesError purchasesError, Map<String, ? extends Object> extra) {
        Intrinsics.checkNotNullParameter(purchasesError, "<this>");
        Intrinsics.checkNotNullParameter(extra, "extra");
        int code = purchasesError.getCode().getCode();
        String message = purchasesError.getMessage();
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("code", Integer.valueOf(purchasesError.getCode().getCode()));
        pairArr[1] = TuplesKt.to(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, purchasesError.getMessage());
        pairArr[2] = TuplesKt.to("readableErrorCode", purchasesError.getCode().name());
        pairArr[3] = TuplesKt.to("readable_error_code", purchasesError.getCode().name());
        String underlyingErrorMessage = purchasesError.getUnderlyingErrorMessage();
        if (underlyingErrorMessage == null) {
            underlyingErrorMessage = "";
        }
        pairArr[4] = TuplesKt.to("underlyingErrorMessage", underlyingErrorMessage);
        return new ErrorContainer(code, message, MapsKt.plus(MapsKt.mapOf(pairArr), extra));
    }
}
