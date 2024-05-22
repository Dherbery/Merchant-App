package com.onesignal.common;

import android.os.Build;
import com.onesignal.core.BuildConfig;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeUtils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/common/TimeUtils;", "", "()V", "getTimeZoneId", "", "getTimeZoneOffset", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class TimeUtils {
    public static final TimeUtils INSTANCE = new TimeUtils();

    private TimeUtils() {
    }

    public final int getTimeZoneOffset() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        if (timeZone.inDaylightTime(new Date())) {
            rawOffset += timeZone.getDSTSavings();
        }
        return rawOffset / 1000;
    }

    public final String getTimeZoneId() {
        ZoneId systemDefault;
        String id;
        if (Build.VERSION.SDK_INT >= 26) {
            systemDefault = ZoneId.systemDefault();
            id = systemDefault.getId();
            Intrinsics.checkNotNullExpressionValue(id, "{\n            ZoneId.systemDefault().id\n        }");
            return id;
        }
        String id2 = TimeZone.getDefault().getID();
        Intrinsics.checkNotNullExpressionValue(id2, "{\n            TimeZone.getDefault().id\n        }");
        return id2;
    }
}
