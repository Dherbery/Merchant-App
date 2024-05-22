package com.onesignal.session.internal.influence;

import com.onesignal.core.BuildConfig;
import com.onesignal.notifications.internal.bundle.impl.NotificationBundleProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Influence.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001a\u001a\u00020\u0000J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u0003J\b\u0010!\u001a\u00020\u0003H\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/onesignal/session/internal/influence/Influence;", "", "jsonString", "", "(Ljava/lang/String;)V", "influenceChannel", "Lcom/onesignal/session/internal/influence/InfluenceChannel;", "influenceType", "Lcom/onesignal/session/internal/influence/InfluenceType;", "ids", "Lorg/json/JSONArray;", "(Lcom/onesignal/session/internal/influence/InfluenceChannel;Lcom/onesignal/session/internal/influence/InfluenceType;Lorg/json/JSONArray;)V", "directId", "getDirectId", "()Ljava/lang/String;", "getIds", "()Lorg/json/JSONArray;", "setIds", "(Lorg/json/JSONArray;)V", "<set-?>", "getInfluenceChannel", "()Lcom/onesignal/session/internal/influence/InfluenceChannel;", "getInfluenceType", "()Lcom/onesignal/session/internal/influence/InfluenceType;", "setInfluenceType", "(Lcom/onesignal/session/internal/influence/InfluenceType;)V", "copy", "equals", "", NotificationBundleProcessor.PUSH_MINIFIED_BUTTONS_LIST, "hashCode", "", "toJSONString", "toString", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class Influence {
    public static final String INFLUENCE_CHANNEL = "influence_channel";
    public static final String INFLUENCE_IDS = "influence_ids";
    public static final String INFLUENCE_TYPE = "influence_type";
    private JSONArray ids;
    private InfluenceChannel influenceChannel;
    private InfluenceType influenceType;

    public final InfluenceType getInfluenceType() {
        return this.influenceType;
    }

    public final void setInfluenceType(InfluenceType influenceType) {
        Intrinsics.checkNotNullParameter(influenceType, "<set-?>");
        this.influenceType = influenceType;
    }

    public final InfluenceChannel getInfluenceChannel() {
        return this.influenceChannel;
    }

    public final JSONArray getIds() {
        return this.ids;
    }

    public final void setIds(JSONArray jSONArray) {
        this.ids = jSONArray;
    }

    public Influence(String jsonString) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        JSONObject jSONObject = new JSONObject(jsonString);
        String string = jSONObject.getString(INFLUENCE_CHANNEL);
        String string2 = jSONObject.getString(INFLUENCE_TYPE);
        String ids = jSONObject.getString(INFLUENCE_IDS);
        this.influenceChannel = InfluenceChannel.INSTANCE.fromString(string);
        this.influenceType = InfluenceType.INSTANCE.fromString(string2);
        Intrinsics.checkNotNullExpressionValue(ids, "ids");
        this.ids = ids.length() == 0 ? null : new JSONArray(ids);
    }

    public Influence(InfluenceChannel influenceChannel, InfluenceType influenceType, JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(influenceChannel, "influenceChannel");
        Intrinsics.checkNotNullParameter(influenceType, "influenceType");
        this.influenceChannel = influenceChannel;
        this.influenceType = influenceType;
        this.ids = jSONArray;
    }

    public final String getDirectId() throws JSONException {
        JSONArray jSONArray = this.ids;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        return jSONArray.getString(0);
    }

    public final Influence copy() {
        return new Influence(this.influenceChannel, this.influenceType, this.ids);
    }

    public final String toJSONString() throws JSONException {
        JSONObject put = new JSONObject().put(INFLUENCE_CHANNEL, this.influenceChannel.getNameValue()).put(INFLUENCE_TYPE, this.influenceType.toString());
        JSONArray jSONArray = this.ids;
        String jSONObject = put.put(INFLUENCE_IDS, jSONArray != null ? String.valueOf(jSONArray) : "").toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject()\n           …)\n            .toString()");
        return jSONObject;
    }

    public String toString() {
        return "SessionInfluence{influenceChannel=" + this.influenceChannel + ", influenceType=" + this.influenceType + ", ids=" + this.ids + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !Intrinsics.areEqual(getClass(), o.getClass())) {
            return false;
        }
        Influence influence = (Influence) o;
        return this.influenceChannel == influence.influenceChannel && this.influenceType == influence.influenceType;
    }

    public int hashCode() {
        return (this.influenceChannel.hashCode() * 31) + this.influenceType.hashCode();
    }
}
