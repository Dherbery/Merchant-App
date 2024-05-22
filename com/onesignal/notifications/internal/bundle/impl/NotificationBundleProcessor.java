package com.onesignal.notifications.internal.bundle.impl;

import android.content.Context;
import android.os.Bundle;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.onesignal.common.JSONUtils;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.onesignal.notifications.internal.generation.INotificationGenerationWorkManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NotificationBundleProcessor.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/onesignal/notifications/internal/bundle/impl/NotificationBundleProcessor;", "Lcom/onesignal/notifications/internal/bundle/INotificationBundleProcessor;", "_workManager", "Lcom/onesignal/notifications/internal/generation/INotificationGenerationWorkManager;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/notifications/internal/generation/INotificationGenerationWorkManager;Lcom/onesignal/core/internal/time/ITime;)V", "maximizeButtonsFromBundle", "", "fcmBundle", "Landroid/os/Bundle;", "processBundleFromReceiver", "Lcom/onesignal/notifications/internal/bundle/INotificationBundleProcessor$ProcessedBundleResult;", "context", "Landroid/content/Context;", "bundle", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationBundleProcessor implements INotificationBundleProcessor {
    private static final String ANDROID_NOTIFICATION_ID = "android_notif_id";
    public static final String DEFAULT_ACTION = "__DEFAULT__";
    public static final String PUSH_ADDITIONAL_DATA_KEY = "a";
    public static final String PUSH_MINIFIED_BUTTONS_LIST = "o";
    public static final String PUSH_MINIFIED_BUTTON_ICON = "p";
    public static final String PUSH_MINIFIED_BUTTON_ID = "i";
    public static final String PUSH_MINIFIED_BUTTON_TEXT = "n";
    private final ITime _time;
    private final INotificationGenerationWorkManager _workManager;

    public NotificationBundleProcessor(INotificationGenerationWorkManager _workManager, ITime _time) {
        Intrinsics.checkNotNullParameter(_workManager, "_workManager");
        Intrinsics.checkNotNullParameter(_time, "_time");
        this._workManager = _workManager;
        this._time = _time;
    }

    private final void maximizeButtonsFromBundle(Bundle fcmBundle) {
        JSONObject jSONObject;
        String str;
        if (fcmBundle.containsKey(PUSH_MINIFIED_BUTTONS_LIST)) {
            try {
                JSONObject jSONObject2 = new JSONObject(fcmBundle.getString("custom"));
                if (jSONObject2.has("a")) {
                    jSONObject = jSONObject2.getJSONObject("a");
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "{\n                    cu…      )\n                }");
                } else {
                    jSONObject = new JSONObject();
                }
                JSONArray jSONArray = new JSONArray(fcmBundle.getString(PUSH_MINIFIED_BUTTONS_LIST));
                fcmBundle.remove(PUSH_MINIFIED_BUTTONS_LIST);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    String string = jSONObject3.getString(PUSH_MINIFIED_BUTTON_TEXT);
                    jSONObject3.remove(PUSH_MINIFIED_BUTTON_TEXT);
                    if (jSONObject3.has("i")) {
                        str = jSONObject3.getString("i");
                        jSONObject3.remove("i");
                    } else {
                        str = string;
                    }
                    jSONObject3.put("id", str);
                    jSONObject3.put("text", string);
                    if (jSONObject3.has("p")) {
                        jSONObject3.put("icon", jSONObject3.getString("p"));
                        jSONObject3.remove("p");
                    }
                }
                jSONObject.put("actionButtons", jSONArray);
                jSONObject.put(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID, DEFAULT_ACTION);
                if (!jSONObject2.has("a")) {
                    jSONObject2.put("a", jSONObject);
                }
                fcmBundle.putString("custom", jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.onesignal.notifications.internal.bundle.INotificationBundleProcessor
    public INotificationBundleProcessor.ProcessedBundleResult processBundleFromReceiver(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        INotificationBundleProcessor.ProcessedBundleResult processedBundleResult = new INotificationBundleProcessor.ProcessedBundleResult();
        if (!NotificationFormatHelper.INSTANCE.isOneSignalBundle(bundle)) {
            return processedBundleResult;
        }
        processedBundleResult.setOneSignalPayload(true);
        maximizeButtonsFromBundle(bundle);
        JSONObject bundleAsJSONObject = JSONUtils.INSTANCE.bundleAsJSONObject(bundle);
        long currentTimeMillis = this._time.getCurrentTimeMillis() / 1000;
        boolean z = bundle.getBoolean("is_restoring", false);
        String string = bundle.getString("pri", SessionDescription.SUPPORTED_SDP_VERSION);
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(\"pri\", \"0\")");
        boolean z2 = Integer.parseInt(string) > 9;
        String oSNotificationIdFromJson = NotificationFormatHelper.INSTANCE.getOSNotificationIdFromJson(bundleAsJSONObject);
        int i = bundle.containsKey(ANDROID_NOTIFICATION_ID) ? bundle.getInt(ANDROID_NOTIFICATION_ID) : 0;
        INotificationGenerationWorkManager iNotificationGenerationWorkManager = this._workManager;
        Intrinsics.checkNotNull(oSNotificationIdFromJson);
        processedBundleResult.setWorkManagerProcessing(iNotificationGenerationWorkManager.beginEnqueueingWork(context, oSNotificationIdFromJson, i, bundleAsJSONObject, currentTimeMillis, z, z2));
        return processedBundleResult;
    }
}
