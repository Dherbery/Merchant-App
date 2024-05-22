package com.facebook.hermes.intl;

import android.icu.text.DecimalFormat;
import android.icu.text.MeasureFormat;
import android.icu.text.RuleBasedCollator;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Measure;
import android.icu.util.MeasureUnit;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class PlatformCollatorICU$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ DecimalFormat m(Object obj) {
        return (DecimalFormat) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ RuleBasedCollator m313m(Object obj) {
        return (RuleBasedCollator) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ SimpleDateFormat m314m(Object obj) {
        return (SimpleDateFormat) obj;
    }

    public static /* synthetic */ Measure m(Number number, MeasureUnit measureUnit) {
        return new Measure(number, measureUnit);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ MeasureUnit m317m(Object obj) {
        return (MeasureUnit) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m324m() {
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m327m(Object obj) {
        return obj instanceof DecimalFormat;
    }

    public static /* bridge */ /* synthetic */ boolean m$1(Object obj) {
        return obj instanceof MeasureFormat;
    }
}
