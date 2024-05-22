package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InAppMessageTag.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageTag;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "tagsToAdd", "getTagsToAdd", "()Lorg/json/JSONObject;", "setTagsToAdd", "tagsToRemove", "Lorg/json/JSONArray;", "getTagsToRemove", "()Lorg/json/JSONArray;", "setTagsToRemove", "(Lorg/json/JSONArray;)V", "toJSONObject", "toString", "", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppMessageTag {
    private static final String ADD_TAGS = "adds";
    private static final String REMOVE_TAGS = "removes";
    private JSONObject tagsToAdd;
    private JSONArray tagsToRemove;

    public InAppMessageTag(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.tagsToAdd = json.has(ADD_TAGS) ? json.getJSONObject(ADD_TAGS) : null;
        this.tagsToRemove = json.has(REMOVE_TAGS) ? json.getJSONArray(REMOVE_TAGS) : null;
    }

    public final JSONObject getTagsToAdd() {
        return this.tagsToAdd;
    }

    public final void setTagsToAdd(JSONObject jSONObject) {
        this.tagsToAdd = jSONObject;
    }

    public final JSONArray getTagsToRemove() {
        return this.tagsToRemove;
    }

    public final void setTagsToRemove(JSONArray jSONArray) {
        this.tagsToRemove = jSONArray;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = this.tagsToAdd;
            if (jSONObject2 != null) {
                jSONObject.put(ADD_TAGS, jSONObject2);
            }
            JSONArray jSONArray = this.tagsToRemove;
            if (jSONArray != null) {
                jSONObject.put(REMOVE_TAGS, jSONArray);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "OSInAppMessageTag{adds=" + this.tagsToAdd + ", removes=" + this.tagsToRemove + AbstractJsonLexerKt.END_OBJ;
    }
}
