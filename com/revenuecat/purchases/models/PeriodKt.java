package com.revenuecat.purchases.models;

import com.revenuecat.purchases.models.Period;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: Period.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"toPeriod", "Lkotlin/Pair;", "", "Lcom/revenuecat/purchases/models/Period$Unit;", "", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PeriodKt {
    public static final Pair<Integer, Period.Unit> toPeriod(String str) {
        MatchResult matchEntire = new Regex("^P(?!$)(\\d+(?:\\.\\d+)?Y)?(\\d+(?:\\.\\d+)?M)?(\\d+(?:\\.\\d+)?W)?(\\d+(?:\\.\\d+)?D)?$").matchEntire(str);
        if (matchEntire != null) {
            PeriodKt$toPeriod$1$toInt$1 periodKt$toPeriod$1$toInt$1 = new Function1<String, Integer>() { // from class: com.revenuecat.purchases.models.PeriodKt$toPeriod$1$toInt$1
                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(String part) {
                    Intrinsics.checkNotNullParameter(part, "part");
                    Integer intOrNull = StringsKt.toIntOrNull(StringsKt.dropLast(part, 1));
                    return Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 0);
                }
            };
            MatchResult.Destructured destructured = matchEntire.getDestructured();
            String str2 = destructured.getMatch().getGroupValues().get(1);
            String str3 = destructured.getMatch().getGroupValues().get(2);
            String str4 = destructured.getMatch().getGroupValues().get(3);
            String str5 = destructured.getMatch().getGroupValues().get(4);
            int intValue = periodKt$toPeriod$1$toInt$1.invoke((PeriodKt$toPeriod$1$toInt$1) str2).intValue();
            int intValue2 = periodKt$toPeriod$1$toInt$1.invoke((PeriodKt$toPeriod$1$toInt$1) str3).intValue();
            int intValue3 = periodKt$toPeriod$1$toInt$1.invoke((PeriodKt$toPeriod$1$toInt$1) str4).intValue();
            int intValue4 = periodKt$toPeriod$1$toInt$1.invoke((PeriodKt$toPeriod$1$toInt$1) str5).intValue();
            if (intValue > 0) {
                return new Pair<>(Integer.valueOf(intValue), Period.Unit.YEAR);
            }
            if (intValue2 > 0) {
                return new Pair<>(Integer.valueOf(intValue2), Period.Unit.MONTH);
            }
            if (intValue3 > 0) {
                return new Pair<>(Integer.valueOf(intValue3), Period.Unit.WEEK);
            }
            if (intValue4 > 0) {
                return new Pair<>(Integer.valueOf(intValue4), Period.Unit.DAY);
            }
            return new Pair<>(0, Period.Unit.UNKNOWN);
        }
        return new Pair<>(0, Period.Unit.UNKNOWN);
    }
}
