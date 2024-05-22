package expo.modules.location.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.revenuecat.purchases.common.Constants;
import com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationTaskService.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J\u0019\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0017J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0012\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0003J\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\"\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lexpo/modules/location/services/LocationTaskService;", "Landroid/app/Service;", "()V", "mBinder", "Landroid/os/IBinder;", "mChannelId", "", "mKillService", "", "mParentContext", "Landroid/content/Context;", "mServiceId", "", "buildServiceNotification", "Landroid/app/Notification;", "serviceOptions", "Landroid/os/Bundle;", "colorStringToInteger", "color", "(Ljava/lang/String;)Ljava/lang/Integer;", "onBind", "intent", "Landroid/content/Intent;", "onStartCommand", "flags", "startId", "onTaskRemoved", "", "rootIntent", "prepareChannel", "id", "setParentContext", "context", "startForeground", "stop", "Companion", "ServiceBinder", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocationTaskService extends Service {
    private static int sServiceId = 481756;
    private final IBinder mBinder;
    private String mChannelId;
    private boolean mKillService;
    private Context mParentContext;
    private final int mServiceId;

    public LocationTaskService() {
        int i = sServiceId;
        sServiceId = i + 1;
        this.mServiceId = i;
        this.mBinder = new ServiceBinder();
    }

    /* compiled from: LocationTaskService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/location/services/LocationTaskService$ServiceBinder;", "Landroid/os/Binder;", "(Lexpo/modules/location/services/LocationTaskService;)V", NotificationCompat.CATEGORY_SERVICE, "Lexpo/modules/location/services/LocationTaskService;", "getService", "()Lexpo/modules/location/services/LocationTaskService;", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class ServiceBinder extends Binder {
        public ServiceBinder() {
        }

        /* renamed from: getService, reason: from getter */
        public final LocationTaskService getThis$0() {
            return LocationTaskService.this;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return this.mBinder;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return 3;
        }
        this.mChannelId = extras.getString("appId") + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + extras.getString("taskName");
        this.mKillService = extras.getBoolean("killService", false);
        return 3;
    }

    public final void setParentContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mParentContext = context;
    }

    public final void stop() {
        stopForeground(true);
        stopSelf();
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        Intrinsics.checkNotNullParameter(rootIntent, "rootIntent");
        if (this.mKillService) {
            super.onTaskRemoved(rootIntent);
            stop();
        }
    }

    public final void startForeground(Bundle serviceOptions) {
        Intrinsics.checkNotNullParameter(serviceOptions, "serviceOptions");
        startForeground(this.mServiceId, buildServiceNotification(serviceOptions));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x004b, code lost:
    
        if (r3.setColor(r7.intValue()) == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.app.Notification buildServiceNotification(android.os.Bundle r7) {
        /*
            r6 = this;
            java.lang.String r0 = r6.mChannelId
            r6.prepareChannel(r0)
            com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m1125m$3()
            r0 = r6
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r1 = r6.mChannelId
            android.app.Notification$Builder r1 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m(r0, r1)
            java.lang.String r2 = "notificationTitle"
            java.lang.String r2 = r7.getString(r2)
            java.lang.String r3 = "notificationBody"
            java.lang.String r3 = r7.getString(r3)
            java.lang.String r4 = "notificationColor"
            java.lang.String r7 = r7.getString(r4)
            java.lang.Integer r7 = r6.colorStringToInteger(r7)
            if (r2 == 0) goto L2e
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setContentTitle(r2)
        L2e:
            if (r3 == 0) goto L35
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setContentText(r3)
        L35:
            r2 = 0
            if (r7 == 0) goto L4d
            r3 = r7
            java.lang.Number r3 = (java.lang.Number) r3
            r3.intValue()
            r3 = 1
            android.app.Notification$Builder r3 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m(r1, r3)
            int r7 = r7.intValue()
            android.app.Notification$Builder r7 = r3.setColor(r7)
            if (r7 != 0) goto L53
        L4d:
            r7 = r6
            expo.modules.location.services.LocationTaskService r7 = (expo.modules.location.services.LocationTaskService) r7
            com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m(r1, r2)
        L53:
            android.content.Context r7 = r6.mParentContext
            r3 = 0
            java.lang.String r4 = "mParentContext"
            if (r7 != 0) goto L5e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r7 = r3
        L5e:
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            android.content.Context r5 = r6.mParentContext
            if (r5 != 0) goto L6a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L6b
        L6a:
            r3 = r5
        L6b:
            java.lang.String r3 = r3.getPackageName()
            android.content.Intent r7 = r7.getLaunchIntentForPackage(r3)
            if (r7 == 0) goto L8e
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            r7.setFlags(r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            if (r3 < r4) goto L83
            r3 = 33554432(0x2000000, float:9.403955E-38)
            goto L84
        L83:
            r3 = r2
        L84:
            r4 = 134217728(0x8000000, float:3.85186E-34)
            r3 = r3 | r4
            android.app.PendingIntent r7 = android.app.PendingIntent.getActivity(r0, r2, r7, r3)
            r1.setContentIntent(r7)
        L8e:
            java.lang.String r7 = "service"
            android.app.Notification$Builder r7 = r1.setCategory(r7)
            android.content.pm.ApplicationInfo r0 = r6.getApplicationInfo()
            int r0 = r0.icon
            android.app.Notification$Builder r7 = r7.setSmallIcon(r0)
            android.app.Notification r7 = r7.build()
            java.lang.String r0 = "builder.setCategory(Noti…Info.icon)\n      .build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.services.LocationTaskService.buildServiceNotification(android.os.Bundle):android.app.Notification");
    }

    private final void prepareChannel(String id) {
        NotificationChannel notificationChannel;
        Object systemService = getSystemService(OneSignalDbContract.NotificationTable.TABLE_NAME);
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (notificationManager == null) {
            return;
        }
        String obj = getApplicationInfo().loadLabel(getPackageManager()).toString();
        notificationChannel = notificationManager.getNotificationChannel(id);
        if (notificationChannel == null) {
            Downloader$$ExternalSyntheticApiModelOutline0.m1126m$4();
            NotificationChannel m = Downloader$$ExternalSyntheticApiModelOutline0.m(id, obj, 2);
            m.setDescription("Background location notification channel");
            notificationManager.createNotificationChannel(m);
        }
    }

    private final Integer colorStringToInteger(String color) {
        try {
            return Integer.valueOf(Color.parseColor(color));
        } catch (Exception unused) {
            return null;
        }
    }
}
