package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.UiThreadUtil;
import com.onesignal.notifications.internal.bundle.impl.NotificationBundleProcessor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ViewHierarchyDumper {
    public static JSONObject toJSON(View view) throws JSONException {
        UiThreadUtil.assertOnUiThread();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_TEXT, view.getClass().getName());
        jSONObject.put("i", System.identityHashCode(view));
        Object tag = view.getTag();
        if (tag != null && (tag instanceof String)) {
            jSONObject.put("t", tag);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    jSONArray.put(i, toJSON(viewGroup.getChildAt(i)));
                }
                jSONObject.put("c", jSONArray);
            }
        }
        return jSONObject;
    }
}
