package com.onesignal.notifications.internal.display.impl;

import android.R;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.R;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.bundle.impl.NotificationBundleProcessor;
import com.onesignal.notifications.internal.channels.INotificationChannelManager;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.display.INotificationDisplayBuilder;
import com.onesignal.notifications.receivers.NotificationDismissReceiver;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NotificationDisplayBuilder.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001UB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J4\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0#H\u0002J,\u0010%\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0#H\u0002J4\u0010&\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010-\u001a\u00020\u001e2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u0014H\u0002J\u0012\u00104\u001a\u0004\u0018\u0001052\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u00106\u001a\u00020/2\u0006\u00107\u001a\u000208H\u0016J\u0014\u00109\u001a\u0004\u0018\u00010\u00102\b\u0010:\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010\u00102\u0006\u0010<\u001a\u00020\u001aH\u0002J\u0012\u0010=\u001a\u0004\u0018\u00010\u00102\u0006\u0010>\u001a\u00020\u001aH\u0002J\u0010\u0010?\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u001aH\u0002J\b\u0010@\u001a\u00020\u0014H\u0016J\u0012\u0010A\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010+\u001a\u00020\u0014H\u0016J\u0018\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020CH\u0016J\u0012\u0010H\u001a\u00020\u00142\b\u0010I\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010J\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010K\u001a\u00020L2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010M\u001a\u00020N2\u0006\u0010 \u001a\u00020!H\u0002J\u0012\u0010O\u001a\u00020\u001e2\b\u0010P\u001a\u0004\u0018\u00010*H\u0016J\u0014\u0010Q\u001a\u0004\u0018\u00010\u00102\b\u0010R\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010S\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010T\u001a\u00020*H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006V"}, d2 = {"Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder;", "Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationChannelManager", "Lcom/onesignal/notifications/internal/channels/INotificationChannelManager;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/channels/INotificationChannelManager;)V", "contextResources", "Landroid/content/res/Resources;", "getContextResources", "()Landroid/content/res/Resources;", "currentContext", "Landroid/content/Context;", "getCurrentContext", "()Landroid/content/Context;", "defaultLargeIcon", "Landroid/graphics/Bitmap;", "getDefaultLargeIcon", "()Landroid/graphics/Bitmap;", "defaultSmallIconId", "", "getDefaultSmallIconId", "()I", "notificationDismissedClass", "Ljava/lang/Class;", "packageName", "", "getPackageName", "()Ljava/lang/String;", "addAlertButtons", "", "context", "fcmJson", "Lorg/json/JSONObject;", "buttonsLabels", "", "buttonsIds", "addCustomAlertButtons", "addNotificationActionButtons", "intentGenerator", "Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;", "mBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "notificationId", "groupSummary", "addXiaomiSettings", "oneSignalNotificationBuilder", "Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder$OneSignalNotificationBuilder;", OneSignalDbContract.NotificationTable.TABLE_NAME, "Landroid/app/Notification;", "convertOSToAndroidPriority", "priority", "getAccentColor", "Ljava/math/BigInteger;", "getBaseOneSignalNotificationBuilder", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "getBitmap", "name", "getBitmapFromAssetsOrResourceName", "bitmapStr", "getBitmapFromURL", "location", "getDrawableId", "getGroupAlertBehavior", "getLargeIcon", "getNewBaseDismissIntent", "Landroid/content/Intent;", "getNewDismissActionPendingIntent", "Landroid/app/PendingIntent;", "requestCode", "intent", "getResourceIcon", "iconName", "getSmallIconId", "getTitle", "", "isSoundEnabled", "", "removeNotifyOptions", "builder", "resizeBitmapForLargeIconArea", "bitmap", "setAlertnessOptions", "notifBuilder", "OneSignalNotificationBuilder", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationDisplayBuilder implements INotificationDisplayBuilder {
    private final IApplicationService _applicationService;
    private final INotificationChannelManager _notificationChannelManager;
    private final Class<?> notificationDismissedClass;

    private final int convertOSToAndroidPriority(int priority) {
        if (priority > 9) {
            return 2;
        }
        if (priority > 7) {
            return 1;
        }
        if (priority > 4) {
            return 0;
        }
        return priority > 2 ? -1 : -2;
    }

    public NotificationDisplayBuilder(IApplicationService _applicationService, INotificationChannelManager _notificationChannelManager) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_notificationChannelManager, "_notificationChannelManager");
        this._applicationService = _applicationService;
        this._notificationChannelManager = _notificationChannelManager;
        this.notificationDismissedClass = NotificationDismissReceiver.class;
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

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public int getGroupAlertBehavior() {
        return Build.VERSION.SDK_INT >= 24 ? 2 : 1;
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public CharSequence getTitle(JSONObject fcmJson) {
        Intrinsics.checkNotNullParameter(fcmJson, "fcmJson");
        String optString = fcmJson.optString("title", null);
        if (optString != null) {
            return optString;
        }
        Context currentContext = getCurrentContext();
        Intrinsics.checkNotNull(currentContext);
        PackageManager packageManager = currentContext.getPackageManager();
        Context currentContext2 = getCurrentContext();
        Intrinsics.checkNotNull(currentContext2);
        CharSequence applicationLabel = packageManager.getApplicationLabel(currentContext2.getApplicationInfo());
        Intrinsics.checkNotNullExpressionValue(applicationLabel, "currentContext!!.package…cationInfo,\n            )");
        return applicationLabel;
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public PendingIntent getNewDismissActionPendingIntent(int requestCode, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        PendingIntent broadcast = PendingIntent.getBroadcast(getCurrentContext(), requestCode, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(\n          …FLAG_IMMUTABLE,\n        )");
        return broadcast;
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public Intent getNewBaseDismissIntent(int notificationId) {
        Intent putExtra = new Intent(getCurrentContext(), this.notificationDismissedClass).putExtra(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, notificationId).putExtra("dismissed", true);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(currentContext, n…tExtra(\"dismissed\", true)");
        return putExtra;
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public OneSignalNotificationBuilder getBaseOneSignalNotificationBuilder(NotificationGenerationJob notificationJob) {
        NotificationCompat.Builder builder;
        int i;
        Intrinsics.checkNotNullParameter(notificationJob, "notificationJob");
        JSONObject jsonPayload = notificationJob.getJsonPayload();
        Intrinsics.checkNotNull(jsonPayload);
        OneSignalNotificationBuilder oneSignalNotificationBuilder = new OneSignalNotificationBuilder();
        try {
            String createNotificationChannel = this._notificationChannelManager.createNotificationChannel(notificationJob);
            Context currentContext = getCurrentContext();
            Intrinsics.checkNotNull(currentContext);
            builder = new NotificationCompat.Builder(currentContext, createNotificationChannel);
        } catch (Throwable unused) {
            Context currentContext2 = getCurrentContext();
            Intrinsics.checkNotNull(currentContext2);
            builder = new NotificationCompat.Builder(currentContext2);
        }
        String optString = jsonPayload.optString("alert", null);
        builder.setAutoCancel(true).setSmallIcon(getSmallIconId(jsonPayload)).setStyle(new NotificationCompat.BigTextStyle().bigText(optString)).setContentText(optString).setTicker(optString);
        if (Build.VERSION.SDK_INT < 24 || !Intrinsics.areEqual(jsonPayload.optString("title"), "")) {
            builder.setContentTitle(getTitle(jsonPayload));
        }
        try {
            BigInteger accentColor = getAccentColor(jsonPayload);
            if (accentColor != null) {
                builder.setColor(accentColor.intValue());
            }
        } catch (Throwable unused2) {
        }
        try {
            if (jsonPayload.has("vis")) {
                String optString2 = jsonPayload.optString("vis");
                Intrinsics.checkNotNullExpressionValue(optString2, "fcmJson.optString(\"vis\")");
                i = Integer.parseInt(optString2);
            } else {
                i = 1;
            }
            builder.setVisibility(i);
        } catch (Throwable unused3) {
        }
        Bitmap largeIcon = getLargeIcon(jsonPayload);
        if (largeIcon != null) {
            oneSignalNotificationBuilder.setHasLargeIcon(true);
            builder.setLargeIcon(largeIcon);
        }
        Bitmap bitmap = getBitmap(jsonPayload.optString("bicon", null));
        if (bitmap != null) {
            builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).setSummaryText(optString));
        }
        if (notificationJob.getShownTimeStamp() != null) {
            try {
                Long shownTimeStamp = notificationJob.getShownTimeStamp();
                Intrinsics.checkNotNull(shownTimeStamp);
                builder.setWhen(shownTimeStamp.longValue() * 1000);
            } catch (Throwable unused4) {
            }
        }
        setAlertnessOptions(jsonPayload, builder);
        oneSignalNotificationBuilder.setCompatBuilder(builder);
        return oneSignalNotificationBuilder;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setAlertnessOptions(org.json.JSONObject r7, androidx.core.app.NotificationCompat.Builder r8) {
        /*
            r6 = this;
            java.lang.String r0 = "pri"
            r1 = 6
            int r0 = r7.optInt(r0, r1)
            int r0 = r6.convertOSToAndroidPriority(r0)
            r8.setPriority(r0)
            r1 = 0
            r2 = 1
            if (r0 >= 0) goto L14
            r0 = r2
            goto L15
        L14:
            r0 = r1
        L15:
            if (r0 == 0) goto L18
            return
        L18:
            java.lang.String r0 = "ledc"
            boolean r3 = r7.has(r0)
            r4 = 4
            if (r3 == 0) goto L40
            java.lang.String r3 = "led"
            int r3 = r7.optInt(r3, r2)
            if (r3 != r2) goto L40
            java.math.BigInteger r3 = new java.math.BigInteger     // Catch: java.lang.Throwable -> L40
            java.lang.String r0 = r7.optString(r0)     // Catch: java.lang.Throwable -> L40
            r5 = 16
            r3.<init>(r0, r5)     // Catch: java.lang.Throwable -> L40
            int r0 = r3.intValue()     // Catch: java.lang.Throwable -> L40
            r3 = 2000(0x7d0, float:2.803E-42)
            r5 = 5000(0x1388, float:7.006E-42)
            r8.setLights(r0, r3, r5)     // Catch: java.lang.Throwable -> L40
            goto L41
        L40:
            r1 = r4
        L41:
            java.lang.String r0 = "vib"
            int r0 = r7.optInt(r0, r2)
            if (r0 != r2) goto L5f
            java.lang.String r0 = "vib_pt"
            boolean r0 = r7.has(r0)
            if (r0 == 0) goto L5d
            com.onesignal.notifications.internal.common.NotificationHelper r0 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
            long[] r0 = r0.parseVibrationPattern(r7)
            if (r0 == 0) goto L5f
            r8.setVibrate(r0)
            goto L5f
        L5d:
            r1 = r1 | 2
        L5f:
            boolean r0 = r6.isSoundEnabled(r7)
            if (r0 == 0) goto L81
            com.onesignal.notifications.internal.common.NotificationHelper r0 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
            android.content.Context r2 = r6.getCurrentContext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r3 = "sound"
            r4 = 0
            java.lang.String r7 = r7.optString(r3, r4)
            android.net.Uri r7 = r0.getSoundUri(r2, r7)
            if (r7 == 0) goto L7f
            r8.setSound(r7)
            goto L81
        L7f:
            r1 = r1 | 1
        L81:
            r8.setDefaults(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder.setAlertnessOptions(org.json.JSONObject, androidx.core.app.NotificationCompat$Builder):void");
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public void removeNotifyOptions(NotificationCompat.Builder builder) {
        Intrinsics.checkNotNull(builder);
        builder.setOnlyAlertOnce(true).setDefaults(0).setSound(null).setVibrate(null).setTicker(null);
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public void addXiaomiSettings(OneSignalNotificationBuilder oneSignalNotificationBuilder, Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        Intrinsics.checkNotNull(oneSignalNotificationBuilder);
        if (oneSignalNotificationBuilder.getHasLargeIcon()) {
            try {
                Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
                Field declaredField = newInstance.getClass().getDeclaredField("customizedIcon");
                declaredField.setAccessible(true);
                declaredField.set(newInstance, true);
                Field field = notification.getClass().getField("extraNotification");
                field.setAccessible(true);
                field.set(notification, newInstance);
            } catch (Throwable unused) {
            }
        }
    }

    private final Bitmap getLargeIcon(JSONObject fcmJson) {
        Bitmap bitmap = getBitmap(fcmJson.optString("licon"));
        if (bitmap == null) {
            bitmap = getBitmapFromAssetsOrResourceName("ic_onesignal_large_icon_default");
        }
        if (bitmap == null) {
            return null;
        }
        return resizeBitmapForLargeIconArea(bitmap);
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public Bitmap getDefaultLargeIcon() {
        return resizeBitmapForLargeIconArea(getBitmapFromAssetsOrResourceName("ic_onesignal_large_icon_default"));
    }

    private final Bitmap resizeBitmapForLargeIconArea(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            Resources contextResources = getContextResources();
            Intrinsics.checkNotNull(contextResources);
            int dimension = (int) contextResources.getDimension(R.dimen.notification_large_icon_height);
            Resources contextResources2 = getContextResources();
            Intrinsics.checkNotNull(contextResources2);
            int dimension2 = (int) contextResources2.getDimension(R.dimen.notification_large_icon_width);
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            if (width <= dimension2 && height <= dimension) {
                return bitmap;
            }
            if (height > width) {
                dimension2 = (int) (dimension * (width / height));
            } else if (width > height) {
                dimension = (int) (dimension2 * (height / width));
            }
            return Bitmap.createScaledBitmap(bitmap, dimension2, dimension, true);
        } catch (Throwable unused) {
            return bitmap;
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

    private final int getSmallIconId(JSONObject fcmJson) {
        int resourceIcon = getResourceIcon(fcmJson.optString("sicon", null));
        return resourceIcon != 0 ? resourceIcon : getDefaultSmallIconId();
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public int getDefaultSmallIconId() {
        int drawableId = getDrawableId("ic_stat_onesignal_default");
        if (drawableId != 0) {
            return drawableId;
        }
        int drawableId2 = getDrawableId("corona_statusbar_icon_default");
        if (drawableId2 != 0) {
            return drawableId2;
        }
        int drawableId3 = getDrawableId("ic_os_notification_fallback_white_24dp");
        return drawableId3 != 0 ? drawableId3 : android.R.drawable.ic_popup_reminder;
    }

    private final int getDrawableId(String name) {
        Resources contextResources = getContextResources();
        Intrinsics.checkNotNull(contextResources);
        return contextResources.getIdentifier(name, "drawable", getPackageName());
    }

    private final boolean isSoundEnabled(JSONObject fcmJson) {
        String optString = fcmJson.optString("sound", null);
        return (Intrinsics.areEqual("null", optString) || Intrinsics.areEqual("nil", optString)) ? false : true;
    }

    private final BigInteger getAccentColor(JSONObject fcmJson) {
        try {
            if (fcmJson.has("bgac")) {
                return new BigInteger(fcmJson.optString("bgac", null), 16);
            }
        } catch (Throwable unused) {
        }
        try {
            String resourceString = AndroidUtils.INSTANCE.getResourceString(this._applicationService.getAppContext(), "onesignal_notification_accent_color", null);
            if (resourceString != null) {
                return new BigInteger(resourceString, 16);
            }
        } catch (Throwable unused2) {
        }
        try {
            String manifestMeta = AndroidUtils.INSTANCE.getManifestMeta(this._applicationService.getAppContext(), "com.onesignal.NotificationAccentColor.DEFAULT");
            if (manifestMeta != null) {
                return new BigInteger(manifestMeta, 16);
            }
        } catch (Throwable unused3) {
        }
        return null;
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public void addNotificationActionButtons(JSONObject fcmJson, IntentGeneratorForAttachingToNotifications intentGenerator, NotificationCompat.Builder mBuilder, int notificationId, String groupSummary) {
        int i;
        Intrinsics.checkNotNullParameter(fcmJson, "fcmJson");
        Intrinsics.checkNotNullParameter(intentGenerator, "intentGenerator");
        try {
            JSONObject jSONObject = new JSONObject(fcmJson.optString("custom"));
            if (jSONObject.has("a")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("a");
                if (jSONObject2.has("actionButtons")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("actionButtons");
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        JSONObject jSONObject3 = new JSONObject(fcmJson.toString());
                        Intent newBaseIntent = intentGenerator.getNewBaseIntent(notificationId);
                        newBaseIntent.setAction("" + i2);
                        newBaseIntent.putExtra("action_button", true);
                        jSONObject3.put(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID, optJSONObject.optString("id"));
                        newBaseIntent.putExtra(NotificationConstants.BUNDLE_KEY_ONESIGNAL_DATA, jSONObject3.toString());
                        if (groupSummary != null) {
                            newBaseIntent.putExtra("summary", groupSummary);
                        } else if (fcmJson.has("grp")) {
                            newBaseIntent.putExtra("grp", fcmJson.optString("grp"));
                        }
                        PendingIntent newActionPendingIntent = intentGenerator.getNewActionPendingIntent(notificationId, newBaseIntent);
                        if (optJSONObject.has("icon")) {
                            try {
                                i = getResourceIcon(optJSONObject.optString("icon"));
                            } catch (Throwable th) {
                                th = th;
                                th.printStackTrace();
                                return;
                            }
                        } else {
                            i = 0;
                        }
                        Intrinsics.checkNotNull(mBuilder);
                        mBuilder.addAction(i, optJSONObject.optString("text"), newActionPendingIntent);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final void addAlertButtons(Context context, JSONObject fcmJson, List<String> buttonsLabels, List<String> buttonsIds) {
        try {
            addCustomAlertButtons(fcmJson, buttonsLabels, buttonsIds);
        } catch (Throwable th) {
            Logging.error("Failed to parse JSON for custom buttons for alert dialog.", th);
        }
        if (buttonsLabels.size() == 0 || buttonsLabels.size() < 3) {
            String resourceString = AndroidUtils.INSTANCE.getResourceString(context, "onesignal_in_app_alert_ok_button_text", "Ok");
            Intrinsics.checkNotNull(resourceString);
            buttonsLabels.add(resourceString);
            buttonsIds.add(NotificationBundleProcessor.DEFAULT_ACTION);
        }
    }

    private final void addCustomAlertButtons(JSONObject fcmJson, List<String> buttonsLabels, List<String> buttonsIds) throws JSONException {
        JSONObject jSONObject = new JSONObject(fcmJson.optString("custom"));
        if (jSONObject.has("a")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("a");
            if (jSONObject2.has("actionButtons")) {
                JSONArray optJSONArray = jSONObject2.optJSONArray("actionButtons");
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject3.optString("text");
                    Intrinsics.checkNotNullExpressionValue(optString, "button.optString(\"text\")");
                    buttonsLabels.add(optString);
                    String optString2 = jSONObject3.optString("id");
                    Intrinsics.checkNotNullExpressionValue(optString2, "button.optString(\"id\")");
                    buttonsIds.add(optString2);
                }
            }
        }
    }

    /* compiled from: NotificationDisplayBuilder.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder$OneSignalNotificationBuilder;", "", "()V", "compatBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "getCompatBuilder", "()Landroidx/core/app/NotificationCompat$Builder;", "setCompatBuilder", "(Landroidx/core/app/NotificationCompat$Builder;)V", "hasLargeIcon", "", "getHasLargeIcon", "()Z", "setHasLargeIcon", "(Z)V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OneSignalNotificationBuilder {
        private NotificationCompat.Builder compatBuilder;
        private boolean hasLargeIcon;

        public final NotificationCompat.Builder getCompatBuilder() {
            return this.compatBuilder;
        }

        public final void setCompatBuilder(NotificationCompat.Builder builder) {
            this.compatBuilder = builder;
        }

        public final boolean getHasLargeIcon() {
            return this.hasLargeIcon;
        }

        public final void setHasLargeIcon(boolean z) {
            this.hasLargeIcon = z;
        }
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
