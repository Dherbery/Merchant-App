package com.onesignal.notifications.internal.display.impl;

import android.R;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.onesignal.common.AndroidSupportV4Compat;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.exceptions.MainThreadException;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.R;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.display.INotificationDisplayBuilder;
import com.onesignal.notifications.internal.display.INotificationDisplayer;
import com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer;
import com.onesignal.notifications.internal.limiting.INotificationLimitManager;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: NotificationDisplayer.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0002J*\u0010#\u001a\u00020$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0002J\u0019\u0010*\u001a\u00020+2\u0006\u0010 \u001a\u00020!H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0019\u0010-\u001a\u00020+2\u0006\u0010 \u001a\u00020!H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0014\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u00101\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u00020\u0017H\u0002J\u0012\u00103\u001a\u0004\u0018\u00010/2\u0006\u00104\u001a\u00020\u0017H\u0002J\u0010\u00105\u001a\u00020)2\u0006\u00100\u001a\u00020\u0017H\u0002J\u0012\u00106\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u00010\u0017H\u0002J!\u00108\u001a\u0004\u0018\u00010)2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u00109\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010:J2\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020=2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u0017H\u0002J\u0019\u0010A\u001a\u00020+2\u0006\u0010 \u001a\u00020!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayer;", "Lcom/onesignal/notifications/internal/display/INotificationDisplayer;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationLimitManager", "Lcom/onesignal/notifications/internal/limiting/INotificationLimitManager;", "_summaryNotificationDisplayer", "Lcom/onesignal/notifications/internal/display/ISummaryNotificationDisplayer;", "_notificationDisplayBuilder", "Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/limiting/INotificationLimitManager;Lcom/onesignal/notifications/internal/display/ISummaryNotificationDisplayer;Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;)V", "contextResources", "Landroid/content/res/Resources;", "getContextResources", "()Landroid/content/res/Resources;", "currentContext", "Landroid/content/Context;", "getCurrentContext", "()Landroid/content/Context;", "isRunningOnMainThreadCheck", "", "()Lkotlin/Unit;", "packageName", "", "getPackageName", "()Ljava/lang/String;", "addBackgroundImage", "fcmJson", "Lorg/json/JSONObject;", "notifBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "applyNotificationExtender", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "notificationBuilder", "createGenericPendingIntentsForNotif", "Landroid/app/Notification;", "intentGenerator", "Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;", "gcmBundle", "notificationId", "", "displayIAMPreviewNotification", "", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayNotification", "getBitmap", "Landroid/graphics/Bitmap;", "name", "getBitmapFromAssetsOrResourceName", "bitmapStr", "getBitmapFromURL", "location", "getDrawableId", "getResourceIcon", "iconName", "safeGetColorFromHex", "colorKey", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "setTextColor", "customView", "Landroid/widget/RemoteViews;", "viewId", "colorPayloadKey", "colorDefaultResource", "showNotification", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationDisplayer implements INotificationDisplayer {
    private final IApplicationService _applicationService;
    private final INotificationDisplayBuilder _notificationDisplayBuilder;
    private final INotificationLimitManager _notificationLimitManager;
    private final ISummaryNotificationDisplayer _summaryNotificationDisplayer;

    public NotificationDisplayer(IApplicationService _applicationService, INotificationLimitManager _notificationLimitManager, ISummaryNotificationDisplayer _summaryNotificationDisplayer, INotificationDisplayBuilder _notificationDisplayBuilder) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_notificationLimitManager, "_notificationLimitManager");
        Intrinsics.checkNotNullParameter(_summaryNotificationDisplayer, "_summaryNotificationDisplayer");
        Intrinsics.checkNotNullParameter(_notificationDisplayBuilder, "_notificationDisplayBuilder");
        this._applicationService = _applicationService;
        this._notificationLimitManager = _notificationLimitManager;
        this._summaryNotificationDisplayer = _summaryNotificationDisplayer;
        this._notificationDisplayBuilder = _notificationDisplayBuilder;
    }

    private final Resources getContextResources() {
        return this._applicationService.getAppContext().getResources();
    }

    private final Context getCurrentContext() {
        return this._applicationService.getAppContext();
    }

    private final String getPackageName() {
        return this._applicationService.getAppContext().getPackageName();
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayer
    public Object displayNotification(NotificationGenerationJob notificationGenerationJob, Continuation<? super Boolean> continuation) {
        isRunningOnMainThreadCheck();
        return showNotification(notificationGenerationJob, continuation);
    }

    public final Object displayIAMPreviewNotification(NotificationGenerationJob notificationGenerationJob, Continuation<? super Boolean> continuation) {
        return showNotification(notificationGenerationJob, continuation);
    }

    public final Unit isRunningOnMainThreadCheck() {
        if (AndroidUtils.INSTANCE.isRunningOnMainThread()) {
            throw new MainThreadException("Process for showing a notification should never been done on Main Thread!");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:36|(2:38|(9:42|43|44|45|46|(1:48)|(1:50)(1:55)|51|(1:53)(1:54)))|59|43|44|45|46|(0)|(0)(0)|51|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e5, code lost:
    
        com.onesignal.debug.internal.logging.Logging.error("Could not set background notification image!", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object showNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob r26, kotlin.coroutines.Continuation<? super java.lang.Boolean> r27) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.display.impl.NotificationDisplayer.showNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Notification createGenericPendingIntentsForNotif(NotificationCompat.Builder notifBuilder, IntentGeneratorForAttachingToNotifications intentGenerator, JSONObject gcmBundle, int notificationId) {
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt();
        Intent putExtra = intentGenerator.getNewBaseIntent(notificationId).putExtra(NotificationConstants.BUNDLE_KEY_ONESIGNAL_DATA, gcmBundle.toString());
        Intrinsics.checkNotNullExpressionValue(putExtra, "intentGenerator.getNewBa…TA, gcmBundle.toString())");
        PendingIntent newActionPendingIntent = intentGenerator.getNewActionPendingIntent(nextInt, putExtra);
        Intrinsics.checkNotNull(notifBuilder);
        notifBuilder.setContentIntent(newActionPendingIntent);
        notifBuilder.setDeleteIntent(this._notificationDisplayBuilder.getNewDismissActionPendingIntent(secureRandom.nextInt(), this._notificationDisplayBuilder.getNewBaseDismissIntent(notificationId)));
        Notification build = notifBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "notifBuilder.build()");
        return build;
    }

    private final void applyNotificationExtender(NotificationGenerationJob notificationJob, NotificationCompat.Builder notificationBuilder) {
        if (notificationJob.hasExtender()) {
            try {
                Field declaredField = NotificationCompat.Builder.class.getDeclaredField("mNotification");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(notificationBuilder);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.app.Notification");
                Notification notification = (Notification) obj;
                notificationJob.setOrgFlags(Integer.valueOf(notification.flags));
                notificationJob.setOrgSound(notification.sound);
                Intrinsics.checkNotNull(notificationBuilder);
                com.onesignal.notifications.internal.Notification notification2 = notificationJob.getNotification();
                Intrinsics.checkNotNull(notification2);
                NotificationCompat.Extender notificationExtender = notification2.getNotificationExtender();
                Intrinsics.checkNotNull(notificationExtender);
                notificationBuilder.extend(notificationExtender);
                Object obj2 = declaredField.get(notificationBuilder);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.app.Notification");
                Notification notification3 = (Notification) obj2;
                Field declaredField2 = NotificationCompat.Builder.class.getDeclaredField("mContentText");
                declaredField2.setAccessible(true);
                CharSequence charSequence = (CharSequence) declaredField2.get(notificationBuilder);
                Field declaredField3 = NotificationCompat.Builder.class.getDeclaredField("mContentTitle");
                declaredField3.setAccessible(true);
                CharSequence charSequence2 = (CharSequence) declaredField3.get(notificationBuilder);
                notificationJob.setOverriddenBodyFromExtender(charSequence);
                notificationJob.setOverriddenTitleFromExtender(charSequence2);
                if (notificationJob.getIsRestoring()) {
                    return;
                }
                notificationJob.setOverriddenFlags(Integer.valueOf(notification3.flags));
                notificationJob.setOverriddenSound(notification3.sound);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private final void addBackgroundImage(JSONObject fcmJson, NotificationCompat.Builder notifBuilder) throws Throwable {
        Bitmap bitmap;
        JSONObject jSONObject;
        String str;
        if (Build.VERSION.SDK_INT >= 31) {
            Logging.verbose$default("Cannot use background images in notifications for device on version: " + Build.VERSION.SDK_INT, null, 2, null);
            return;
        }
        String optString = fcmJson.optString("bg_img", null);
        if (optString != null) {
            jSONObject = new JSONObject(optString);
            bitmap = getBitmap(jSONObject.optString("img", null));
        } else {
            bitmap = null;
            jSONObject = null;
        }
        if (bitmap == null) {
            bitmap = getBitmapFromAssetsOrResourceName("onesignal_bgimage_default_image");
        }
        if (bitmap != null) {
            Context currentContext = getCurrentContext();
            Intrinsics.checkNotNull(currentContext);
            RemoteViews remoteViews = new RemoteViews(currentContext.getPackageName(), R.layout.onesignal_bgimage_notif_layout);
            remoteViews.setTextViewText(R.id.os_bgimage_notif_title, this._notificationDisplayBuilder.getTitle(fcmJson));
            remoteViews.setTextViewText(R.id.os_bgimage_notif_body, fcmJson.optString("alert"));
            JSONObject jSONObject2 = jSONObject;
            setTextColor(remoteViews, jSONObject2, R.id.os_bgimage_notif_title, "tc", "onesignal_bgimage_notif_title_color");
            setTextColor(remoteViews, jSONObject2, R.id.os_bgimage_notif_body, "bc", "onesignal_bgimage_notif_body_color");
            if (jSONObject != null && jSONObject.has("img_align")) {
                str = jSONObject.getString("img_align");
            } else {
                Resources contextResources = getContextResources();
                Intrinsics.checkNotNull(contextResources);
                int identifier = contextResources.getIdentifier("onesignal_bgimage_notif_image_align", "string", getPackageName());
                if (identifier != 0) {
                    Resources contextResources2 = getContextResources();
                    Intrinsics.checkNotNull(contextResources2);
                    str = contextResources2.getString(identifier);
                } else {
                    str = null;
                }
            }
            if (Intrinsics.areEqual("right", str)) {
                remoteViews.setViewPadding(R.id.os_bgimage_notif_bgimage_align_layout, -5000, 0, 0, 0);
                remoteViews.setImageViewBitmap(R.id.os_bgimage_notif_bgimage_right_aligned, bitmap);
                remoteViews.setViewVisibility(R.id.os_bgimage_notif_bgimage_right_aligned, 0);
                remoteViews.setViewVisibility(R.id.os_bgimage_notif_bgimage, 8);
            } else {
                remoteViews.setImageViewBitmap(R.id.os_bgimage_notif_bgimage, bitmap);
            }
            Intrinsics.checkNotNull(notifBuilder);
            notifBuilder.setContent(remoteViews);
            notifBuilder.setStyle(null);
        }
    }

    private final void setTextColor(RemoteViews customView, JSONObject fcmJson, int viewId, String colorPayloadKey, String colorDefaultResource) {
        Integer safeGetColorFromHex = safeGetColorFromHex(fcmJson, colorPayloadKey);
        if (safeGetColorFromHex != null) {
            customView.setTextColor(viewId, safeGetColorFromHex.intValue());
            return;
        }
        Resources contextResources = getContextResources();
        Intrinsics.checkNotNull(contextResources);
        int identifier = contextResources.getIdentifier(colorDefaultResource, "color", getPackageName());
        if (identifier != 0) {
            AndroidSupportV4Compat.ContextCompat contextCompat = AndroidSupportV4Compat.ContextCompat.INSTANCE;
            Context currentContext = getCurrentContext();
            Intrinsics.checkNotNull(currentContext);
            customView.setTextColor(viewId, contextCompat.getColor(currentContext, identifier));
        }
    }

    private final Integer safeGetColorFromHex(JSONObject fcmJson, String colorKey) {
        if (fcmJson == null) {
            return null;
        }
        try {
            if (fcmJson.has(colorKey)) {
                return Integer.valueOf(new BigInteger(fcmJson.optString(colorKey), 16).intValue());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private final Bitmap getBitmapFromAssetsOrResourceName(String bitmapStr) {
        Bitmap bitmap;
        try {
            Context currentContext = getCurrentContext();
            Intrinsics.checkNotNull(currentContext);
            bitmap = BitmapFactory.decodeStream(currentContext.getAssets().open(bitmapStr));
        } catch (Throwable unused) {
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        try {
            for (String str : Arrays.asList(".png", ".webp", ".jpg", ".gif", ".bmp")) {
                try {
                    Context currentContext2 = getCurrentContext();
                    Intrinsics.checkNotNull(currentContext2);
                    bitmap = BitmapFactory.decodeStream(currentContext2.getAssets().open(bitmapStr + str));
                } catch (Throwable unused2) {
                }
                if (bitmap != null) {
                    return bitmap;
                }
            }
            int resourceIcon = getResourceIcon(bitmapStr);
            if (resourceIcon != 0) {
                return BitmapFactory.decodeResource(getContextResources(), resourceIcon);
            }
        } catch (Throwable unused3) {
        }
        return null;
    }

    private final Bitmap getBitmapFromURL(String location) {
        try {
            return BitmapFactory.decodeStream(new URL(location).openConnection().getInputStream());
        } catch (Throwable th) {
            Logging.warn("Could not download image!", th);
            return null;
        }
    }

    private final int getDrawableId(String name) {
        Resources contextResources = getContextResources();
        Intrinsics.checkNotNull(contextResources);
        return contextResources.getIdentifier(name, "drawable", getPackageName());
    }

    private final Bitmap getBitmap(String name) {
        if (name == null) {
            return null;
        }
        String str = name;
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String obj = str.subSequence(i, length + 1).toString();
        if (StringsKt.startsWith$default(obj, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(obj, "https://", false, 2, (Object) null)) {
            return getBitmapFromURL(obj);
        }
        return getBitmapFromAssetsOrResourceName(name);
    }

    private final int getResourceIcon(String iconName) {
        if (iconName == null) {
            return 0;
        }
        String str = iconName;
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String obj = str.subSequence(i, length + 1).toString();
        if (!AndroidUtils.INSTANCE.isValidResourceName(obj)) {
            return 0;
        }
        int drawableId = getDrawableId(obj);
        if (drawableId != 0) {
            return drawableId;
        }
        try {
            return R.drawable.class.getField(iconName).getInt(null);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
