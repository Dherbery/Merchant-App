package com.revenuecat.purchases.common.caching;

import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.ReceiptStrings;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: DateExtensions.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0000\u001a-\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"CACHE_REFRESH_PERIOD_IN_BACKGROUND", "Lkotlin/time/Duration;", "J", "CACHE_REFRESH_PERIOD_IN_FOREGROUND", "isCacheStale", "", "Ljava/util/Date;", "appInBackground", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "cacheDuration", "isCacheStale-8Mi8wO0", "(Ljava/util/Date;JLcom/revenuecat/purchases/common/DateProvider;)Z", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class DateExtensionsKt {
    private static final long CACHE_REFRESH_PERIOD_IN_BACKGROUND;
    private static final long CACHE_REFRESH_PERIOD_IN_FOREGROUND;

    static {
        Duration.Companion companion = Duration.INSTANCE;
        CACHE_REFRESH_PERIOD_IN_FOREGROUND = DurationKt.toDuration(5, DurationUnit.MINUTES);
        Duration.Companion companion2 = Duration.INSTANCE;
        CACHE_REFRESH_PERIOD_IN_BACKGROUND = DurationKt.toDuration(25, DurationUnit.HOURS);
    }

    public static /* synthetic */ boolean isCacheStale$default(Date date, boolean z, DateProvider dateProvider, int i, Object obj) {
        if ((i & 2) != 0) {
            dateProvider = new DefaultDateProvider();
        }
        return isCacheStale(date, z, dateProvider);
    }

    public static final boolean isCacheStale(Date date, boolean z, DateProvider dateProvider) {
        long j;
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        if (date == null) {
            return true;
        }
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(ReceiptStrings.CHECKING_IF_CACHE_STALE, Arrays.copyOf(new Object[]{Boolean.valueOf(z)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        if (z) {
            j = CACHE_REFRESH_PERIOD_IN_BACKGROUND;
        } else {
            j = CACHE_REFRESH_PERIOD_IN_FOREGROUND;
        }
        return m1089isCacheStale8Mi8wO0(date, j, dateProvider);
    }

    /* renamed from: isCacheStale-8Mi8wO0$default, reason: not valid java name */
    public static /* synthetic */ boolean m1090isCacheStale8Mi8wO0$default(Date date, long j, DateProvider dateProvider, int i, Object obj) {
        if ((i & 2) != 0) {
            dateProvider = new DefaultDateProvider();
        }
        return m1089isCacheStale8Mi8wO0(date, j, dateProvider);
    }

    /* renamed from: isCacheStale-8Mi8wO0, reason: not valid java name */
    public static final boolean m1089isCacheStale8Mi8wO0(Date date, long j, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        if (date == null) {
            return true;
        }
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.m2695compareToLRDsOJo(DurationKt.toDuration(dateProvider.getNow().getTime() - date.getTime(), DurationUnit.MILLISECONDS), j) >= 0;
    }
}
