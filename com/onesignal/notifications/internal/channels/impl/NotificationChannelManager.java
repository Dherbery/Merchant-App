package com.onesignal.notifications.internal.channels.impl;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import com.google.android.exoplayer2.util.Util$$ExternalSyntheticApiModelOutline0;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.channels.INotificationChannelManager;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.common.NotificationHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NotificationChannelManager.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/onesignal/notifications/internal/channels/impl/NotificationChannelManager;", "Lcom/onesignal/notifications/internal/channels/INotificationChannelManager;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/language/ILanguageContext;)V", "hexPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "createChannel", "", "context", "Landroid/content/Context;", "notificationManager", "Landroid/app/NotificationManager;", "payload", "Lorg/json/JSONObject;", "createDefaultChannel", "createNotificationChannel", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "createRestoreChannel", "priorityToImportance", "", "priority", "processChannelList", "", "list", "Lorg/json/JSONArray;", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationChannelManager implements INotificationChannelManager {
    private static final String CHANNEL_PREFIX = "OS_";
    private static final String DEFAULT_CHANNEL_ID = "fcm_fallback_notification_channel";
    private static final String RESTORE_CHANNEL_ID = "restored_OS_notifications";
    private final IApplicationService _applicationService;
    private final ILanguageContext _languageContext;
    private final Pattern hexPattern;

    private final int priorityToImportance(int priority) {
        if (priority > 9) {
            return 5;
        }
        if (priority > 7) {
            return 4;
        }
        if (priority > 5) {
            return 3;
        }
        if (priority > 3) {
            return 2;
        }
        return priority > 1 ? 1 : 0;
    }

    public NotificationChannelManager(IApplicationService _applicationService, ILanguageContext _languageContext) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_languageContext, "_languageContext");
        this._applicationService = _applicationService;
        this._languageContext = _languageContext;
        this.hexPattern = Pattern.compile("^([A-Fa-f0-9]{8})$");
    }

    @Override // com.onesignal.notifications.internal.channels.INotificationChannelManager
    public String createNotificationChannel(NotificationGenerationJob notificationJob) {
        NotificationChannel notificationChannel;
        Intrinsics.checkNotNullParameter(notificationJob, "notificationJob");
        if (Build.VERSION.SDK_INT < 26) {
            return "fcm_fallback_notification_channel";
        }
        Context appContext = this._applicationService.getAppContext();
        JSONObject jsonPayload = notificationJob.getJsonPayload();
        Intrinsics.checkNotNull(jsonPayload);
        NotificationManager notificationManager = NotificationHelper.INSTANCE.getNotificationManager(appContext);
        if (notificationJob.getIsRestoring()) {
            return createRestoreChannel(notificationManager);
        }
        if (jsonPayload.has("oth_chnl")) {
            String otherChannel = jsonPayload.optString("oth_chnl");
            notificationChannel = notificationManager.getNotificationChannel(otherChannel);
            if (notificationChannel != null) {
                Intrinsics.checkNotNullExpressionValue(otherChannel, "otherChannel");
                return otherChannel;
            }
        }
        if (!jsonPayload.has("chnl")) {
            return createDefaultChannel(notificationManager);
        }
        try {
            return createChannel(appContext, notificationManager, jsonPayload);
        } catch (JSONException e) {
            Logging.error("Could not create notification channel due to JSON payload error!", e);
            return "fcm_fallback_notification_channel";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:1|(1:3)(1:65)|4|(1:6)|7|(2:9|(22:11|12|(1:14)|15|(4:17|(1:19)|20|21)|25|(1:27)(1:63)|28|(1:32)|33|(1:35)(1:62)|36|(2:38|(1:40)(2:41|(1:45)))|46|(1:48)(1:61)|49|(1:51)|52|53|54|55|56))|64|12|(0)|15|(0)|25|(0)(0)|28|(2:30|32)|33|(0)(0)|36|(0)|46|(0)(0)|49|(0)|52|53|54|55|56) */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0163, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0164, code lost:
    
        r9.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String createChannel(android.content.Context r9, android.app.NotificationManager r10, org.json.JSONObject r11) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.channels.impl.NotificationChannelManager.createChannel(android.content.Context, android.app.NotificationManager, org.json.JSONObject):java.lang.String");
    }

    private final String createDefaultChannel(NotificationManager notificationManager) {
        Util$$ExternalSyntheticApiModelOutline0.m$1();
        NotificationChannel m = ComponentDialog$$ExternalSyntheticApiModelOutline0.m("fcm_fallback_notification_channel", "Miscellaneous", 3);
        m.enableLights(true);
        m.enableVibration(true);
        notificationManager.createNotificationChannel(m);
        return "fcm_fallback_notification_channel";
    }

    private final String createRestoreChannel(NotificationManager notificationManager) {
        Util$$ExternalSyntheticApiModelOutline0.m$1();
        notificationManager.createNotificationChannel(ComponentDialog$$ExternalSyntheticApiModelOutline0.m(RESTORE_CHANNEL_ID, "Restored", 2));
        return RESTORE_CHANNEL_ID;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.List, java.lang.Object] */
    @Override // com.onesignal.notifications.internal.channels.INotificationChannelManager
    public void processChannelList(JSONArray list) {
        String id;
        ?? notificationChannels;
        if (Build.VERSION.SDK_INT < 26 || list == null || list.length() == 0) {
            return;
        }
        NotificationManager notificationManager = NotificationHelper.INSTANCE.getNotificationManager(this._applicationService.getAppContext());
        HashSet hashSet = new HashSet();
        int length = list.length();
        for (int i = 0; i < length; i++) {
            try {
                Context appContext = this._applicationService.getAppContext();
                JSONObject jSONObject = list.getJSONObject(i);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "list.getJSONObject(i)");
                hashSet.add(createChannel(appContext, notificationManager, jSONObject));
            } catch (JSONException e) {
                Logging.error("Could not create notification channel due to JSON payload error!", e);
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            notificationChannels = notificationManager.getNotificationChannels();
            Intrinsics.checkNotNullExpressionValue(notificationChannels, "notificationManager.notificationChannels");
            arrayList = notificationChannels;
        } catch (NullPointerException e2) {
            Logging.error$default("Error when trying to delete notification channel: " + e2.getMessage(), null, 2, null);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            id = ComponentDialog$$ExternalSyntheticApiModelOutline0.m5m(it.next()).getId();
            Intrinsics.checkNotNullExpressionValue(id, "id");
            if (StringsKt.startsWith$default(id, CHANNEL_PREFIX, false, 2, (Object) null) && !hashSet.contains(id)) {
                notificationManager.deleteNotificationChannel(id);
            }
        }
    }
}
