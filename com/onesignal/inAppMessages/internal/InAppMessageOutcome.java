package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InAppMessageOutcome.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0003J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageOutcome;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "isUnique", "", "()Z", "setUnique", "(Z)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "weight", "", "getWeight", "()F", "setWeight", "(F)V", "toJSONObject", "toString", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppMessageOutcome {
    private static final String OUTCOME_NAME = "name";
    private static final String OUTCOME_UNIQUE = "unique";
    private static final String OUTCOME_WEIGHT = "weight";
    private boolean isUnique;
    private String name;
    private float weight;

    public InAppMessageOutcome(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        String string = json.getString("name");
        Intrinsics.checkNotNullExpressionValue(string, "json.getString(OUTCOME_NAME)");
        this.name = string;
        this.weight = json.has("weight") ? (float) json.getDouble("weight") : 0.0f;
        this.isUnique = json.has(OUTCOME_UNIQUE) && json.getBoolean(OUTCOME_UNIQUE);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final float getWeight() {
        return this.weight;
    }

    public final void setWeight(float f) {
        this.weight = f;
    }

    /* renamed from: isUnique, reason: from getter */
    public final boolean getIsUnique() {
        return this.isUnique;
    }

    public final void setUnique(boolean z) {
        this.isUnique = z;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.name);
            jSONObject.put("weight", this.weight);
            jSONObject.put(OUTCOME_UNIQUE, this.isUnique);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "OSInAppMessageOutcome{name='" + this.name + "', weight=" + this.weight + ", unique=" + this.isUnique + AbstractJsonLexerKt.END_OBJ;
    }
}
