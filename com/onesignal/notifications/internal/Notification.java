package com.onesignal.notifications.internal;

import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.messaging.Constants;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.common.threading.Waiter;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.BackgroundImageLayout;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.IActionButton;
import com.onesignal.notifications.IDisplayableMutableNotification;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Notification.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u007fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B/\b\u0016\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\b\u0010s\u001a\u00020tH\u0016J\u0006\u0010u\u001a\u00020vJ\u0018\u0010w\u001a\u00020t2\u0006\u0010x\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010y\u001a\u00020tH\u0002J\u0010\u0010z\u001a\u00020t2\u0006\u0010x\u001a\u00020\u0003H\u0002J\u0012\u0010{\u001a\u00020t2\b\u0010|\u001a\u0004\u0018\u00010JH\u0016J\u0006\u0010}\u001a\u00020\u0003J\b\u0010~\u001a\u00020#H\u0016R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001c\u0010+\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010%\"\u0004\b4\u0010'R\u001c\u00105\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010%\"\u0004\b7\u0010'R\u001c\u00108\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010%\"\u0004\b:\u0010'R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R\u001c\u0010=\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010%\"\u0004\b?\u0010'R\u001c\u0010@\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010%\"\u0004\bB\u0010'R\u001c\u0010C\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010%\"\u0004\bE\u0010'R\u001a\u0010F\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0019\"\u0004\bH\u0010\u001bR\u001c\u0010I\u001a\u0004\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010O\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010%\"\u0004\bQ\u0010'R\u001a\u0010R\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0019\"\u0004\bT\u0010\u001bR\u001a\u0010U\u001a\u00020#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010%\"\u0004\bW\u0010'R\u001a\u0010X\u001a\u00020YX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001c\u0010^\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010%\"\u0004\b`\u0010'R\u001c\u0010a\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010%\"\u0004\bc\u0010'R\u001c\u0010d\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010%\"\u0004\bf\u0010'R\u001c\u0010g\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010%\"\u0004\bi\u0010'R\u001c\u0010j\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010%\"\u0004\bl\u0010'R\u001c\u0010m\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010%\"\u0004\bo\u0010'R\u001a\u0010p\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0019\"\u0004\br\u0010\u001b¨\u0006\u0080\u0001"}, d2 = {"Lcom/onesignal/notifications/internal/Notification;", "Lcom/onesignal/notifications/IDisplayableMutableNotification;", "payload", "Lorg/json/JSONObject;", "time", "Lcom/onesignal/core/internal/time/ITime;", "(Lorg/json/JSONObject;Lcom/onesignal/core/internal/time/ITime;)V", "groupedNotifications", "", "jsonPayload", NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, "", "(Ljava/util/List;Lorg/json/JSONObject;ILcom/onesignal/core/internal/time/ITime;)V", "actionButtons", "Lcom/onesignal/notifications/IActionButton;", "getActionButtons", "()Ljava/util/List;", "setActionButtons", "(Ljava/util/List;)V", "additionalData", "getAdditionalData", "()Lorg/json/JSONObject;", "setAdditionalData", "(Lorg/json/JSONObject;)V", "getAndroidNotificationId", "()I", "setAndroidNotificationId", "(I)V", "backgroundImageLayout", "Lcom/onesignal/notifications/BackgroundImageLayout;", "getBackgroundImageLayout", "()Lcom/onesignal/notifications/BackgroundImageLayout;", "setBackgroundImageLayout", "(Lcom/onesignal/notifications/BackgroundImageLayout;)V", "bigPicture", "", "getBigPicture", "()Ljava/lang/String;", "setBigPicture", "(Ljava/lang/String;)V", TtmlNode.TAG_BODY, "getBody", "setBody", "collapseId", "getCollapseId", "setCollapseId", "displayWaiter", "Lcom/onesignal/common/threading/Waiter;", "getDisplayWaiter", "()Lcom/onesignal/common/threading/Waiter;", "fromProjectNumber", "getFromProjectNumber", "setFromProjectNumber", "groupKey", "getGroupKey", "setGroupKey", "groupMessage", "getGroupMessage", "setGroupMessage", "getGroupedNotifications", "setGroupedNotifications", "largeIcon", "getLargeIcon", "setLargeIcon", "launchURL", "getLaunchURL", "setLaunchURL", "ledColor", "getLedColor", "setLedColor", "lockScreenVisibility", "getLockScreenVisibility", "setLockScreenVisibility", "notificationExtender", "Landroidx/core/app/NotificationCompat$Extender;", "getNotificationExtender", "()Landroidx/core/app/NotificationCompat$Extender;", "setNotificationExtender", "(Landroidx/core/app/NotificationCompat$Extender;)V", "notificationId", "getNotificationId", "setNotificationId", "priority", "getPriority", "setPriority", "rawPayload", "getRawPayload", "setRawPayload", "sentTime", "", "getSentTime", "()J", "setSentTime", "(J)V", "smallIcon", "getSmallIcon", "setSmallIcon", "smallIconAccentColor", "getSmallIconAccentColor", "setSmallIconAccentColor", "sound", "getSound", "setSound", "templateId", "getTemplateId", "setTemplateId", "templateName", "getTemplateName", "setTemplateName", "title", "getTitle", "setTitle", "ttl", "getTtl", "setTtl", "display", "", "hasNotificationId", "", "initPayloadData", "currentJsonPayload", "setActionButtonsFromData", "setBackgroundImageLayoutFromData", "setExtender", "extender", "toJSONObject", "toString", "ActionButton", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class Notification implements IDisplayableMutableNotification {
    private List<? extends IActionButton> actionButtons;
    private JSONObject additionalData;
    private int androidNotificationId;
    private BackgroundImageLayout backgroundImageLayout;
    private String bigPicture;
    private String body;
    private String collapseId;
    private final Waiter displayWaiter;
    private String fromProjectNumber;
    private String groupKey;
    private String groupMessage;
    private List<Notification> groupedNotifications;
    private String largeIcon;
    private String launchURL;
    private String ledColor;
    private int lockScreenVisibility;
    private NotificationCompat.Extender notificationExtender;
    private String notificationId;
    private int priority;
    private String rawPayload;
    private long sentTime;
    private String smallIcon;
    private String smallIconAccentColor;
    private String sound;
    private String templateId;
    private String templateName;
    private String title;
    private int ttl;

    public final NotificationCompat.Extender getNotificationExtender() {
        return this.notificationExtender;
    }

    public final void setNotificationExtender(NotificationCompat.Extender extender) {
        this.notificationExtender = extender;
    }

    public final Waiter getDisplayWaiter() {
        return this.displayWaiter;
    }

    @Override // com.onesignal.notifications.INotification
    public List<Notification> getGroupedNotifications() {
        return this.groupedNotifications;
    }

    public void setGroupedNotifications(List<Notification> list) {
        this.groupedNotifications = list;
    }

    @Override // com.onesignal.notifications.INotification
    public int getAndroidNotificationId() {
        return this.androidNotificationId;
    }

    public void setAndroidNotificationId(int i) {
        this.androidNotificationId = i;
    }

    @Override // com.onesignal.notifications.INotification
    public String getNotificationId() {
        return this.notificationId;
    }

    public void setNotificationId(String str) {
        this.notificationId = str;
    }

    @Override // com.onesignal.notifications.INotification
    public String getTemplateName() {
        return this.templateName;
    }

    public void setTemplateName(String str) {
        this.templateName = str;
    }

    @Override // com.onesignal.notifications.INotification
    public String getTemplateId() {
        return this.templateId;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    @Override // com.onesignal.notifications.INotification
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // com.onesignal.notifications.INotification
    public String getBody() {
        return this.body;
    }

    public void setBody(String str) {
        this.body = str;
    }

    @Override // com.onesignal.notifications.INotification
    public JSONObject getAdditionalData() {
        return this.additionalData;
    }

    public void setAdditionalData(JSONObject jSONObject) {
        this.additionalData = jSONObject;
    }

    @Override // com.onesignal.notifications.INotification
    public String getSmallIcon() {
        return this.smallIcon;
    }

    public void setSmallIcon(String str) {
        this.smallIcon = str;
    }

    @Override // com.onesignal.notifications.INotification
    public String getLargeIcon() {
        return this.largeIcon;
    }

    public void setLargeIcon(String str) {
        this.largeIcon = str;
    }

    @Override // com.onesignal.notifications.INotification
    public String getBigPicture() {
        return this.bigPicture;
    }

    public void setBigPicture(String str) {
        this.bigPicture = str;
    }

    @Override // com.onesignal.notifications.INotification
    public String getSmallIconAccentColor() {
        return this.smallIconAccentColor;
    }

    public void setSmallIconAccentColor(String str) {
        this.smallIconAccentColor = str;
    }

    @Override // com.onesignal.notifications.INotification
    public String getLaunchURL() {
        return this.launchURL;
    }

    public void setLaunchURL(String str) {
        this.launchURL = str;
    }

    @Override // com.onesignal.notifications.INotification
    public String getSound() {
        return this.sound;
    }

    public void setSound(String str) {
        this.sound = str;
    }

    @Override // com.onesignal.notifications.INotification
    public String getLedColor() {
        return this.ledColor;
    }

    public void setLedColor(String str) {
        this.ledColor = str;
    }

    @Override // com.onesignal.notifications.INotification
    public int getLockScreenVisibility() {
        return this.lockScreenVisibility;
    }

    public void setLockScreenVisibility(int i) {
        this.lockScreenVisibility = i;
    }

    @Override // com.onesignal.notifications.INotification
    public String getGroupKey() {
        return this.groupKey;
    }

    public void setGroupKey(String str) {
        this.groupKey = str;
    }

    @Override // com.onesignal.notifications.INotification
    public String getGroupMessage() {
        return this.groupMessage;
    }

    public void setGroupMessage(String str) {
        this.groupMessage = str;
    }

    @Override // com.onesignal.notifications.INotification
    public List<IActionButton> getActionButtons() {
        return this.actionButtons;
    }

    public void setActionButtons(List<? extends IActionButton> list) {
        this.actionButtons = list;
    }

    @Override // com.onesignal.notifications.INotification
    public String getFromProjectNumber() {
        return this.fromProjectNumber;
    }

    public void setFromProjectNumber(String str) {
        this.fromProjectNumber = str;
    }

    @Override // com.onesignal.notifications.INotification
    public BackgroundImageLayout getBackgroundImageLayout() {
        return this.backgroundImageLayout;
    }

    public void setBackgroundImageLayout(BackgroundImageLayout backgroundImageLayout) {
        this.backgroundImageLayout = backgroundImageLayout;
    }

    @Override // com.onesignal.notifications.INotification
    public String getCollapseId() {
        return this.collapseId;
    }

    public void setCollapseId(String str) {
        this.collapseId = str;
    }

    @Override // com.onesignal.notifications.INotification
    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    @Override // com.onesignal.notifications.INotification
    public long getSentTime() {
        return this.sentTime;
    }

    public void setSentTime(long j) {
        this.sentTime = j;
    }

    @Override // com.onesignal.notifications.INotification
    public int getTtl() {
        return this.ttl;
    }

    public void setTtl(int i) {
        this.ttl = i;
    }

    @Override // com.onesignal.notifications.INotification
    public String getRawPayload() {
        return this.rawPayload;
    }

    public void setRawPayload(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rawPayload = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Notification(JSONObject payload, ITime time) {
        this(null, payload, 0, time);
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(time, "time");
    }

    public Notification(List<Notification> list, JSONObject jsonPayload, int i, ITime time) {
        Intrinsics.checkNotNullParameter(jsonPayload, "jsonPayload");
        Intrinsics.checkNotNullParameter(time, "time");
        this.displayWaiter = new Waiter();
        this.lockScreenVisibility = 1;
        this.rawPayload = "";
        initPayloadData(jsonPayload, time);
        setGroupedNotifications(list);
        setAndroidNotificationId(i);
    }

    private final void initPayloadData(JSONObject currentJsonPayload, ITime time) {
        try {
            JSONObject customJSONObject = NotificationHelper.INSTANCE.getCustomJSONObject(currentJsonPayload);
            long currentTimeMillis = time.getCurrentTimeMillis();
            if (currentJsonPayload.has("google.ttl")) {
                setSentTime(currentJsonPayload.optLong("google.sent_time", currentTimeMillis) / 1000);
                setTtl(currentJsonPayload.optInt("google.ttl", 259200));
            } else if (currentJsonPayload.has("hms.ttl")) {
                setSentTime(currentJsonPayload.optLong("hms.sent_time", currentTimeMillis) / 1000);
                setTtl(currentJsonPayload.optInt("hms.ttl", 259200));
            } else {
                setSentTime(currentTimeMillis / 1000);
                setTtl(259200);
            }
            setNotificationId(JSONObjectExtensionsKt.safeString(customJSONObject, "i"));
            setTemplateId(JSONObjectExtensionsKt.safeString(customJSONObject, "ti"));
            setTemplateName(JSONObjectExtensionsKt.safeString(customJSONObject, "tn"));
            String jSONObject = currentJsonPayload.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "currentJsonPayload.toString()");
            setRawPayload(jSONObject);
            setAdditionalData(JSONObjectExtensionsKt.safeJSONObject(customJSONObject, "a"));
            setLaunchURL(JSONObjectExtensionsKt.safeString(customJSONObject, "u"));
            setBody(JSONObjectExtensionsKt.safeString(currentJsonPayload, "alert"));
            setTitle(JSONObjectExtensionsKt.safeString(currentJsonPayload, "title"));
            setSmallIcon(JSONObjectExtensionsKt.safeString(currentJsonPayload, "sicon"));
            setBigPicture(JSONObjectExtensionsKt.safeString(currentJsonPayload, "bicon"));
            setLargeIcon(JSONObjectExtensionsKt.safeString(currentJsonPayload, "licon"));
            setSound(JSONObjectExtensionsKt.safeString(currentJsonPayload, "sound"));
            setGroupKey(JSONObjectExtensionsKt.safeString(currentJsonPayload, "grp"));
            setGroupMessage(JSONObjectExtensionsKt.safeString(currentJsonPayload, "grp_msg"));
            setSmallIconAccentColor(JSONObjectExtensionsKt.safeString(currentJsonPayload, "bgac"));
            setLedColor(JSONObjectExtensionsKt.safeString(currentJsonPayload, "ledc"));
            String safeString = JSONObjectExtensionsKt.safeString(currentJsonPayload, "vis");
            if (safeString != null) {
                setLockScreenVisibility(Integer.parseInt(safeString));
            }
            setFromProjectNumber(JSONObjectExtensionsKt.safeString(currentJsonPayload, Constants.MessagePayloadKeys.FROM));
            setPriority(currentJsonPayload.optInt("pri", 0));
            String safeString2 = JSONObjectExtensionsKt.safeString(currentJsonPayload, Constants.MessagePayloadKeys.COLLAPSE_KEY);
            if (!Intrinsics.areEqual("do_not_collapse", safeString2)) {
                setCollapseId(safeString2);
            }
            try {
                setActionButtonsFromData();
            } catch (Throwable th) {
                Logging.error("Error assigning OSNotificationReceivedEvent.actionButtons values!", th);
            }
            try {
                setBackgroundImageLayoutFromData(currentJsonPayload);
            } catch (Throwable th2) {
                Logging.error("Error assigning OSNotificationReceivedEvent.backgroundImageLayout values!", th2);
            }
        } catch (Throwable th3) {
            Logging.error("Error assigning OSNotificationReceivedEvent payload values!", th3);
        }
    }

    private final void setActionButtonsFromData() throws Throwable {
        if (getAdditionalData() != null) {
            JSONObject additionalData = getAdditionalData();
            Intrinsics.checkNotNull(additionalData);
            if (additionalData.has("actionButtons")) {
                JSONObject additionalData2 = getAdditionalData();
                Intrinsics.checkNotNull(additionalData2);
                JSONArray jSONArray = additionalData2.getJSONArray("actionButtons");
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jsonActionButton = jSONArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jsonActionButton, "jsonActionButton");
                    arrayList.add(new ActionButton(JSONObjectExtensionsKt.safeString(jsonActionButton, "id"), JSONObjectExtensionsKt.safeString(jsonActionButton, "text"), JSONObjectExtensionsKt.safeString(jsonActionButton, "icon")));
                }
                setActionButtons(arrayList);
                JSONObject additionalData3 = getAdditionalData();
                Intrinsics.checkNotNull(additionalData3);
                additionalData3.remove(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID);
                JSONObject additionalData4 = getAdditionalData();
                Intrinsics.checkNotNull(additionalData4);
                additionalData4.remove("actionButtons");
            }
        }
    }

    private final void setBackgroundImageLayoutFromData(JSONObject currentJsonPayload) throws Throwable {
        String safeString = JSONObjectExtensionsKt.safeString(currentJsonPayload, "bg_img");
        if (safeString != null) {
            JSONObject jSONObject = new JSONObject(safeString);
            setBackgroundImageLayout(new BackgroundImageLayout(JSONObjectExtensionsKt.safeString(jSONObject, "img"), JSONObjectExtensionsKt.safeString(jSONObject, "tc"), JSONObjectExtensionsKt.safeString(jSONObject, "bc")));
        }
    }

    @Override // com.onesignal.notifications.IMutableNotification
    public void setExtender(NotificationCompat.Extender extender) {
        this.notificationExtender = extender;
    }

    public final boolean hasNotificationId() {
        return getAndroidNotificationId() != 0;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, getAndroidNotificationId());
            JSONArray jSONArray = new JSONArray();
            if (getGroupedNotifications() != null) {
                List<Notification> groupedNotifications = getGroupedNotifications();
                Intrinsics.checkNotNull(groupedNotifications);
                Iterator<Notification> it = groupedNotifications.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSONObject());
                }
            }
            jSONObject.put("groupedNotifications", jSONArray);
            jSONObject.put("notificationId", getNotificationId());
            jSONObject.put("templateName", getTemplateName());
            jSONObject.put("templateId", getTemplateId());
            jSONObject.put("title", getTitle());
            jSONObject.put(TtmlNode.TAG_BODY, getBody());
            jSONObject.put("smallIcon", getSmallIcon());
            jSONObject.put("largeIcon", getLargeIcon());
            jSONObject.put("bigPicture", getBigPicture());
            jSONObject.put("smallIconAccentColor", getSmallIconAccentColor());
            jSONObject.put("launchURL", getLaunchURL());
            jSONObject.put("sound", getSound());
            jSONObject.put("ledColor", getLedColor());
            jSONObject.put("lockScreenVisibility", getLockScreenVisibility());
            jSONObject.put("groupKey", getGroupKey());
            jSONObject.put("groupMessage", getGroupMessage());
            jSONObject.put("fromProjectNumber", getFromProjectNumber());
            jSONObject.put("collapseId", getCollapseId());
            jSONObject.put("priority", getPriority());
            if (getAdditionalData() != null) {
                jSONObject.put("additionalData", getAdditionalData());
            }
            if (getActionButtons() != null) {
                JSONArray jSONArray2 = new JSONArray();
                List<IActionButton> actionButtons = getActionButtons();
                Intrinsics.checkNotNull(actionButtons);
                for (IActionButton iActionButton : actionButtons) {
                    Intrinsics.checkNotNull(iActionButton, "null cannot be cast to non-null type com.onesignal.notifications.internal.Notification.ActionButton");
                    jSONArray2.put(((ActionButton) iActionButton).toJSONObject());
                }
                jSONObject.put("actionButtons", jSONArray2);
            }
            jSONObject.put("rawPayload", getRawPayload());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "OSNotification{notificationExtender=" + this.notificationExtender + ", groupedNotifications=" + getGroupedNotifications() + ", androidNotificationId=" + getAndroidNotificationId() + ", notificationId='" + getNotificationId() + "', templateName='" + getTemplateName() + "', templateId='" + getTemplateId() + "', title='" + getTitle() + "', body='" + getBody() + "', additionalData=" + getAdditionalData() + ", smallIcon='" + getSmallIcon() + "', largeIcon='" + getLargeIcon() + "', bigPicture='" + getBigPicture() + "', smallIconAccentColor='" + getSmallIconAccentColor() + "', launchURL='" + getLaunchURL() + "', sound='" + getSound() + "', ledColor='" + getLedColor() + "', lockScreenVisibility=" + getLockScreenVisibility() + ", groupKey='" + getGroupKey() + "', groupMessage='" + getGroupMessage() + "', actionButtons=" + getActionButtons() + ", fromProjectNumber='" + getFromProjectNumber() + "', backgroundImageLayout=" + getBackgroundImageLayout() + ", collapseId='" + getCollapseId() + "', priority=" + getPriority() + ", rawPayload='" + getRawPayload() + "'}";
    }

    @Override // com.onesignal.notifications.IDisplayableNotification
    public void display() {
        this.displayWaiter.wake();
    }

    /* compiled from: Notification.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/onesignal/notifications/internal/Notification$ActionButton;", "Lcom/onesignal/notifications/IActionButton;", "id", "", "text", "icon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "getId", "getText", "toJSONObject", "Lorg/json/JSONObject;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ActionButton implements IActionButton {
        private final String icon;
        private final String id;
        private final String text;

        public ActionButton() {
            this(null, null, null, 7, null);
        }

        public ActionButton(String str, String str2, String str3) {
            this.id = str;
            this.text = str2;
            this.icon = str3;
        }

        public /* synthetic */ ActionButton(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Override // com.onesignal.notifications.IActionButton
        public String getId() {
            return this.id;
        }

        @Override // com.onesignal.notifications.IActionButton
        public String getText() {
            return this.text;
        }

        @Override // com.onesignal.notifications.IActionButton
        public String getIcon() {
            return this.icon;
        }

        public final JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", getId());
                jSONObject.put("text", getText());
                jSONObject.put("icon", getIcon());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
    }
}
