package kotlin.time.jdk8;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: DurationConversions.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u0001H\u0087\bø\u0001\u0001¢\u0006\u0002\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"toJavaDuration", "Ljava/time/Duration;", "Lkotlin/time/Duration;", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "toKotlinDuration", "(Ljava/time/Duration;)J", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 8, 0}, pn = "kotlin.time", xi = 48)
/* loaded from: classes6.dex */
public final class DurationConversionsJDK8Kt {
    private static final long toKotlinDuration(Duration duration) {
        long seconds;
        int nano;
        Intrinsics.checkNotNullParameter(duration, "<this>");
        seconds = duration.getSeconds();
        long duration2 = DurationKt.toDuration(seconds, DurationUnit.SECONDS);
        nano = duration.getNano();
        return kotlin.time.Duration.m2732plusLRDsOJo(duration2, DurationKt.toDuration(nano, DurationUnit.NANOSECONDS));
    }

    /* renamed from: toJavaDuration-LRDsOJo, reason: not valid java name */
    private static final Duration m2857toJavaDurationLRDsOJo(long j) {
        Duration ofSeconds;
        ofSeconds = Duration.ofSeconds(kotlin.time.Duration.m2717getInWholeSecondsimpl(j), kotlin.time.Duration.m2719getNanosecondsComponentimpl(j));
        Intrinsics.checkNotNullExpressionValue(ofSeconds, "toJavaDuration-LRDsOJo");
        return ofSeconds;
    }
}
