package com.onesignal.notifications.internal.common;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.NotificationClickEvent;
import com.onesignal.notifications.internal.NotificationClickResult;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NotificationHelper.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006J*\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011H\u0007J\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J \u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\t\u001a\u00020\nH\u0007J\u001b\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b2\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010!J\u000e\u0010&\u001a\u00020'2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\t\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010\u0006J\u0010\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0010H\u0007J\u0010\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/onesignal/notifications/internal/common/NotificationHelper;", "", "()V", "GROUPLESS_SUMMARY_ID", "", "GROUPLESS_SUMMARY_KEY", "", "areNotificationsEnabled", "", "context", "Landroid/content/Context;", "channelId", "assignGrouplessNotifications", "", "grouplessNotifs", "Ljava/util/ArrayList;", "Landroid/service/notification/StatusBarNotification;", "Lkotlin/collections/ArrayList;", "generateNotificationOpenedResult", "Lcom/onesignal/notifications/internal/NotificationClickEvent;", "jsonArray", "Lorg/json/JSONArray;", "time", "Lcom/onesignal/core/internal/time/ITime;", "generateNotificationOpenedResult$com_onesignal_notifications", "getActiveGrouplessNotifications", "getActiveNotifications", "", "(Landroid/content/Context;)[Landroid/service/notification/StatusBarNotification;", "getCampaignNameFromNotification", OneSignalDbContract.NotificationTable.TABLE_NAME, "Lcom/onesignal/notifications/INotification;", "getCustomJSONObject", "Lorg/json/JSONObject;", "jsonObject", "getGrouplessNotifsCount", "getNotificationIdFromFCMJson", "fcmJson", "getNotificationManager", "Landroid/app/NotificationManager;", "getSoundUri", "Landroid/net/Uri;", "sound", "isGroupSummary", "notif", "parseVibrationPattern", "", "fcmBundle", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationHelper {
    public static final int GROUPLESS_SUMMARY_ID = -718463522;
    public static final String GROUPLESS_SUMMARY_KEY = "os_group_undefined";
    public static final NotificationHelper INSTANCE = new NotificationHelper();

    private NotificationHelper() {
    }

    public final StatusBarNotification[] getActiveNotifications(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        StatusBarNotification[] statusBarNotificationArr = new StatusBarNotification[0];
        try {
            StatusBarNotification[] activeNotifications = getNotificationManager(context).getActiveNotifications();
            Intrinsics.checkNotNullExpressionValue(activeNotifications, "getNotificationManager(c…text).activeNotifications");
            return activeNotifications;
        } catch (Throwable unused) {
            return statusBarNotificationArr;
        }
    }

    public final int getGrouplessNotifsCount(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = 0;
        for (StatusBarNotification statusBarNotification : getActiveNotifications(context)) {
            if (!NotificationCompat.isGroupSummary(statusBarNotification.getNotification()) && Intrinsics.areEqual(GROUPLESS_SUMMARY_KEY, statusBarNotification.getNotification().getGroup())) {
                i++;
            }
        }
        return i;
    }

    public final ArrayList<StatusBarNotification> getActiveGrouplessNotifications(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList<StatusBarNotification> arrayList = new ArrayList<>();
        for (StatusBarNotification statusBarNotification : getActiveNotifications(context)) {
            Notification notification = statusBarNotification.getNotification();
            boolean isGroupSummary = isGroupSummary(statusBarNotification);
            boolean z = notification.getGroup() == null || Intrinsics.areEqual(notification.getGroup(), GROUPLESS_SUMMARY_KEY);
            if (!isGroupSummary && z) {
                arrayList.add(statusBarNotification);
            }
        }
        return arrayList;
    }

    public final boolean isGroupSummary(StatusBarNotification notif) {
        Intrinsics.checkNotNullParameter(notif, "notif");
        return (notif.getNotification().flags & 512) != 0;
    }

    public final void assignGrouplessNotifications(Context context, ArrayList<StatusBarNotification> grouplessNotifs) {
        Notification.Builder recoverBuilder;
        Intrinsics.checkNotNullParameter(grouplessNotifs, "grouplessNotifs");
        Iterator<StatusBarNotification> it = grouplessNotifs.iterator();
        while (it.hasNext()) {
            StatusBarNotification next = it.next();
            recoverBuilder = Notification.Builder.recoverBuilder(context, next.getNotification());
            Intrinsics.checkNotNullExpressionValue(recoverBuilder, "recoverBuilder(context, …uplessNotif.notification)");
            Notification build = recoverBuilder.setGroup(GROUPLESS_SUMMARY_KEY).setOnlyAlertOnce(true).build();
            Intrinsics.checkNotNullExpressionValue(build, "grouplessNotifBuilder\n  …                 .build()");
            Intrinsics.checkNotNull(context);
            NotificationManagerCompat.from(context).notify(next.getId(), build);
        }
    }

    public static /* synthetic */ boolean areNotificationsEnabled$default(NotificationHelper notificationHelper, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return notificationHelper.areNotificationsEnabled(context, str);
    }

    public final boolean areNotificationsEnabled(Context context, String channelId) {
        int importance;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                return false;
            }
            if (channelId == null || Build.VERSION.SDK_INT < 26) {
                return true;
            }
            NotificationManager notificationManager = getNotificationManager(context);
            NotificationChannel notificationChannel = notificationManager != null ? notificationManager.getNotificationChannel(channelId) : null;
            if (notificationChannel == null) {
                return true;
            }
            importance = notificationChannel.getImportance();
            return importance != 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    public final NotificationManager getNotificationManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(OneSignalDbContract.NotificationTable.TABLE_NAME);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    public final JSONObject getCustomJSONObject(JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        return new JSONObject(jsonObject.optString("custom"));
    }

    public final String getNotificationIdFromFCMJson(JSONObject fcmJson) {
        JSONObject jSONObject;
        if (fcmJson == null) {
            return null;
        }
        try {
            jSONObject = new JSONObject(fcmJson.getString("custom"));
        } catch (JSONException unused) {
            Logging.debug$default("Not a OneSignal formatted FCM message. No 'custom' field in the JSONObject.", null, 2, null);
        }
        if (jSONObject.has("i")) {
            return jSONObject.optString("i", null);
        }
        Logging.debug$default("Not a OneSignal formatted FCM message. No 'i' field in custom.", null, 2, null);
        return null;
    }

    public final long[] parseVibrationPattern(JSONObject fcmBundle) {
        JSONArray jSONArray;
        Intrinsics.checkNotNullParameter(fcmBundle, "fcmBundle");
        try {
            Object opt = fcmBundle.opt("vib_pt");
            if (opt instanceof String) {
                jSONArray = new JSONArray((String) opt);
            } else {
                Intrinsics.checkNotNull(opt, "null cannot be cast to non-null type org.json.JSONArray");
                jSONArray = (JSONArray) opt;
            }
            long[] jArr = new long[jSONArray.length()];
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                jArr[i] = jSONArray.optLong(i);
            }
            return jArr;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final Uri getSoundUri(Context context, String sound) {
        int identifier;
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        if (AndroidUtils.INSTANCE.isValidResourceName(sound) && (identifier = resources.getIdentifier(sound, "raw", packageName)) != 0) {
            return Uri.parse("android.resource://" + packageName + IOUtils.DIR_SEPARATOR_UNIX + identifier);
        }
        int identifier2 = resources.getIdentifier("onesignal_default_sound", "raw", packageName);
        if (identifier2 == 0) {
            return null;
        }
        return Uri.parse("android.resource://" + packageName + IOUtils.DIR_SEPARATOR_UNIX + identifier2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        if ((r0.length() == 0) == true) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getCampaignNameFromNotification(com.onesignal.notifications.INotification r4) {
        /*
            r3 = this;
            java.lang.String r0 = "notification"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = r4.getTemplateName()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1c
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L17
            r0 = r1
            goto L18
        L17:
            r0 = r2
        L18:
            if (r0 != r1) goto L1c
            r0 = r1
            goto L1d
        L1c:
            r0 = r2
        L1d:
            if (r0 != 0) goto L53
            java.lang.String r0 = r4.getTemplateId()
            if (r0 == 0) goto L33
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L2f
            r0 = r1
            goto L30
        L2f:
            r0 = r2
        L30:
            if (r0 != r1) goto L33
            goto L34
        L33:
            r1 = r2
        L34:
            if (r1 != 0) goto L53
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r4.getTemplateName()
            r0.append(r1)
            java.lang.String r1 = " - "
            r0.append(r1)
            java.lang.String r4 = r4.getTemplateId()
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            return r4
        L53:
            java.lang.String r0 = r4.getTitle()
            if (r0 == 0) goto L7b
            java.lang.String r0 = r4.getTitle()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r4 = r4.getTitle()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r4 = r4.length()
            r1 = 10
            int r4 = java.lang.Math.min(r1, r4)
            java.lang.String r4 = r0.substring(r2, r4)
            java.lang.String r0 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            return r4
        L7b:
            java.lang.String r4 = ""
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.common.NotificationHelper.getCampaignNameFromNotification(com.onesignal.notifications.INotification):java.lang.String");
    }

    public final NotificationClickEvent generateNotificationOpenedResult$com_onesignal_notifications(JSONArray jsonArray, ITime time) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        Intrinsics.checkNotNullParameter(time, "time");
        int length = jsonArray.length();
        int optInt = jsonArray.optJSONObject(0).optInt(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID);
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        JSONObject jSONObject = null;
        String str = null;
        for (int i = 0; i < length; i++) {
            try {
                jSONObject = jsonArray.getJSONObject(i);
                if (str == null && jSONObject.has(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID)) {
                    str = jSONObject.optString(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID, null);
                }
                if (z) {
                    z = false;
                } else {
                    arrayList.add(new com.onesignal.notifications.internal.Notification(jSONObject, time));
                }
            } catch (Throwable th) {
                Logging.error("Error parsing JSON item " + i + IOUtils.DIR_SEPARATOR_UNIX + length + " for callback.", th);
            }
        }
        Intrinsics.checkNotNull(jSONObject);
        com.onesignal.notifications.internal.Notification notification = new com.onesignal.notifications.internal.Notification(arrayList, jSONObject, optInt, time);
        return new NotificationClickEvent(notification, new NotificationClickResult(str, notification.getLaunchURL()));
    }
}
