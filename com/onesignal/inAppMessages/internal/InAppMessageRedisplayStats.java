package com.onesignal.inAppMessages.internal;

import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InAppMessageRedisplayStats.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001)B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bB\r\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0002\u0010\rJ\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0000J\u0006\u0010%\u001a\u00020\u001bJ\u0006\u0010&\u001a\u00020\nJ\b\u0010'\u001a\u00020(H\u0016R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u001e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012¨\u0006*"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageRedisplayStats;", "", "displayQuantity", "", "lastDisplayTime", "", "time", "Lcom/onesignal/core/internal/time/ITime;", "(IJLcom/onesignal/core/internal/time/ITime;)V", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;Lcom/onesignal/core/internal/time/ITime;)V", "_time", "(Lcom/onesignal/core/internal/time/ITime;)V", "displayDelay", "getDisplayDelay", "()J", "setDisplayDelay", "(J)V", "displayLimit", "getDisplayLimit", "()I", "setDisplayLimit", "(I)V", "getDisplayQuantity", "setDisplayQuantity", "isDelayTimeSatisfied", "", "()Z", "<set-?>", "isRedisplayEnabled", "getLastDisplayTime", "setLastDisplayTime", "incrementDisplayQuantity", "", "setDisplayStats", "displayStats", "shouldDisplayAgain", "toJSONObject", "toString", "", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppMessageRedisplayStats {
    private static final String DISPLAY_DELAY = "delay";
    private static final String DISPLAY_LIMIT = "limit";
    private final ITime _time;
    private long displayDelay;
    private int displayLimit;
    private int displayQuantity;
    private boolean isRedisplayEnabled;
    private long lastDisplayTime;

    public InAppMessageRedisplayStats(ITime _time) {
        Intrinsics.checkNotNullParameter(_time, "_time");
        this._time = _time;
        this.lastDisplayTime = -1L;
        this.displayLimit = 1;
    }

    public final long getLastDisplayTime() {
        return this.lastDisplayTime;
    }

    public final void setLastDisplayTime(long j) {
        this.lastDisplayTime = j;
    }

    public final int getDisplayQuantity() {
        return this.displayQuantity;
    }

    public final void setDisplayQuantity(int i) {
        this.displayQuantity = i;
    }

    public final int getDisplayLimit() {
        return this.displayLimit;
    }

    public final void setDisplayLimit(int i) {
        this.displayLimit = i;
    }

    public final long getDisplayDelay() {
        return this.displayDelay;
    }

    public final void setDisplayDelay(long j) {
        this.displayDelay = j;
    }

    /* renamed from: isRedisplayEnabled, reason: from getter */
    public final boolean getIsRedisplayEnabled() {
        return this.isRedisplayEnabled;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InAppMessageRedisplayStats(int i, long j, ITime time) {
        this(time);
        Intrinsics.checkNotNullParameter(time, "time");
        this.displayQuantity = i;
        this.lastDisplayTime = j;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InAppMessageRedisplayStats(JSONObject json, ITime time) {
        this(time);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(time, "time");
        this.isRedisplayEnabled = true;
        Object obj = json.get(DISPLAY_LIMIT);
        Object obj2 = json.get(DISPLAY_DELAY);
        if (obj instanceof Integer) {
            this.displayLimit = ((Number) obj).intValue();
        }
        if (obj2 instanceof Long) {
            this.displayDelay = ((Number) obj2).longValue();
        } else if (obj2 instanceof Integer) {
            this.displayDelay = ((Number) obj2).intValue();
        }
    }

    public final void setDisplayStats(InAppMessageRedisplayStats displayStats) {
        Intrinsics.checkNotNullParameter(displayStats, "displayStats");
        this.lastDisplayTime = displayStats.lastDisplayTime;
        this.displayQuantity = displayStats.displayQuantity;
    }

    public final void incrementDisplayQuantity() {
        this.displayQuantity++;
    }

    public final boolean shouldDisplayAgain() {
        boolean z = this.displayQuantity < this.displayLimit;
        Logging.debug$default("OSInAppMessage shouldDisplayAgain: " + z, null, 2, null);
        return z;
    }

    public final boolean isDelayTimeSatisfied() {
        if (this.lastDisplayTime < 0) {
            return true;
        }
        long currentTimeMillis = this._time.getCurrentTimeMillis() / 1000;
        long j = currentTimeMillis - this.lastDisplayTime;
        Logging.debug$default("OSInAppMessage lastDisplayTime: " + this.lastDisplayTime + " currentTimeInSeconds: " + currentTimeMillis + " diffInSeconds: " + j + " displayDelay: " + this.displayDelay, null, 2, null);
        return j >= this.displayDelay;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DISPLAY_LIMIT, this.displayLimit);
            jSONObject.put(DISPLAY_DELAY, this.displayDelay);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "OSInAppMessageDisplayStats{lastDisplayTime=" + this.lastDisplayTime + ", displayQuantity=" + this.displayQuantity + ", displayLimit=" + this.displayLimit + ", displayDelay=" + this.displayDelay + AbstractJsonLexerKt.END_OBJ;
    }
}
