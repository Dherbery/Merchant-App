package com.revenuecat.purchases.common;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NONE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: Dispatcher.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001a\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/common/Delay;", "", "minDelay", "Lkotlin/time/Duration;", "maxDelay", "(Ljava/lang/String;IJJ)V", "getMaxDelay-UwyO8pc", "()J", "J", "getMinDelay-UwyO8pc", "NONE", "DEFAULT", "LONG", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class Delay {
    private static final /* synthetic */ Delay[] $VALUES;
    public static final Delay DEFAULT;
    public static final Delay LONG;
    public static final Delay NONE;
    private final long maxDelay;
    private final long minDelay;

    private static final /* synthetic */ Delay[] $values() {
        return new Delay[]{NONE, DEFAULT, LONG};
    }

    public static Delay valueOf(String str) {
        return (Delay) Enum.valueOf(Delay.class, str);
    }

    public static Delay[] values() {
        return (Delay[]) $VALUES.clone();
    }

    private Delay(String str, int i, long j, long j2) {
        this.minDelay = j;
        this.maxDelay = j2;
    }

    /* renamed from: getMaxDelay-UwyO8pc, reason: not valid java name and from getter */
    public final long getMaxDelay() {
        return this.maxDelay;
    }

    /* renamed from: getMinDelay-UwyO8pc, reason: not valid java name and from getter */
    public final long getMinDelay() {
        return this.minDelay;
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        long duration = DurationKt.toDuration(0, DurationUnit.MILLISECONDS);
        Duration.Companion companion2 = Duration.INSTANCE;
        NONE = new Delay("NONE", 0, duration, DurationKt.toDuration(0, DurationUnit.MILLISECONDS));
        Duration.Companion companion3 = Duration.INSTANCE;
        DEFAULT = new Delay("DEFAULT", 1, DurationKt.toDuration(0, DurationUnit.MILLISECONDS), DispatcherConstants.INSTANCE.m1087getJitterDelayUwyO8pc());
        LONG = new Delay("LONG", 2, DispatcherConstants.INSTANCE.m1087getJitterDelayUwyO8pc(), DispatcherConstants.INSTANCE.m1088getJitterLongDelayUwyO8pc());
        $VALUES = $values();
    }
}
