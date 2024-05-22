package com.onesignal.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.onesignal.common.AndroidSupportV4Compat;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: AndroidUtils.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001<B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J$\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0013J\u0006\u0010#\u001a\u00020\u000fJ\u0006\u0010$\u001a\u00020\u000fJ\u001e\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010)\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!J\u0006\u0010*\u001a\u00020\u000fJ\u0010\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u0005J\u0010\u0010-\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u0005J\u0014\u0010/\u001a\u00020\u000f2\n\u00100\u001a\u0006\u0012\u0002\b\u000301H\u0007J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u000206J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u0005J\u000e\u00108\u001a\u0002092\u0006\u00105\u001a\u000206J\u000e\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020\u0013¨\u0006="}, d2 = {"Lcom/onesignal/common/AndroidUtils;", "", "()V", "filterManifestPermissions", "", "", "permissions", "applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "getAppVersion", "context", "Landroid/content/Context;", "getManifestMeta", "metaName", "getManifestMetaBoolean", "", "getManifestMetaBundle", "Landroid/os/Bundle;", "getRandomDelay", "", "minDelay", "maxDelay", "getResourceString", SubscriberAttributeKt.JSON_NAME_KEY, "defaultStr", "getRootCauseMessage", "throwable", "", "getRootCauseThrowable", "subjectThrowable", "getTargetSdkVersion", "hasConfigChangeFlag", "activity", "Landroid/app/Activity;", "configChangeFlag", "hasJobIntentService", "hasNotificationManagerCompat", "hasPermission", "permission", "isUserGranted", "hasWakefulBroadcastReceiver", "isActivityFullyReady", "isRunningOnMainThread", "isStringNotEmpty", TtmlNode.TAG_BODY, "isValidResourceName", "name", "opaqueHasClass", "_class", "Ljava/lang/Class;", "openURLInBrowser", "", "appContext", "uri", "Landroid/net/Uri;", ImagesContract.URL, "openURLInBrowserIntent", "Landroid/content/Intent;", "sleep", "ms", "SchemaType", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class AndroidUtils {
    public static final AndroidUtils INSTANCE = new AndroidUtils();

    /* compiled from: AndroidUtils.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SchemaType.values().length];
            iArr[SchemaType.DATA.ordinal()] = 1;
            iArr[SchemaType.HTTPS.ordinal()] = 2;
            iArr[SchemaType.HTTP.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean hasJobIntentService() {
        return true;
    }

    public final boolean hasNotificationManagerCompat() {
        return true;
    }

    public final boolean hasWakefulBroadcastReceiver() {
        return true;
    }

    public final boolean opaqueHasClass(Class<?> _class) {
        Intrinsics.checkNotNullParameter(_class, "_class");
        return true;
    }

    private AndroidUtils() {
    }

    public final int getRandomDelay(int minDelay, int maxDelay) {
        return new Random().nextInt((maxDelay + 1) - minDelay) + minDelay;
    }

    public final boolean isStringNotEmpty(String body) {
        return !TextUtils.isEmpty(body);
    }

    public final boolean isActivityFullyReady(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        boolean z = activity.getWindow().getDecorView().getApplicationWindowToken() != null;
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        return z && (decorView.getRootWindowInsets() != null);
    }

    public final void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public final boolean hasConfigChangeFlag(Activity activity, int configChangeFlag) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            return (activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).configChanges & configChangeFlag) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final String getAppVersion(Context context) {
        Integer num;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            num = Integer.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            num = null;
        }
        if (num != null) {
            return num.toString();
        }
        return null;
    }

    public final String getManifestMeta(Context context, String metaName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle manifestMetaBundle = getManifestMetaBundle(context);
        if (manifestMetaBundle != null) {
            return manifestMetaBundle.getString(metaName);
        }
        return null;
    }

    public final boolean getManifestMetaBoolean(Context context, String metaName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle manifestMetaBundle = getManifestMetaBundle(context);
        if (manifestMetaBundle != null) {
            return manifestMetaBundle.getBoolean(metaName);
        }
        return false;
    }

    public final Bundle getManifestMetaBundle(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "context.packageManager.g…A_DATA,\n                )");
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            Logging.error("Manifest application info not found", e);
            return null;
        }
    }

    public final String getResourceString(Context context, String key, String defaultStr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(key, "string", context.getPackageName());
        return identifier != 0 ? resources.getString(identifier) : defaultStr;
    }

    public final boolean isValidResourceName(String name) {
        if (name != null) {
            if (!new Regex("^[0-9]").matches(name)) {
                return true;
            }
        }
        return false;
    }

    public final Throwable getRootCauseThrowable(Throwable subjectThrowable) {
        Intrinsics.checkNotNullParameter(subjectThrowable, "subjectThrowable");
        while (subjectThrowable.getCause() != null && subjectThrowable.getCause() != subjectThrowable) {
            subjectThrowable = subjectThrowable.getCause();
            Intrinsics.checkNotNull(subjectThrowable);
        }
        return subjectThrowable;
    }

    public final String getRootCauseMessage(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        return getRootCauseThrowable(throwable).getMessage();
    }

    public final boolean isRunningOnMainThread() {
        return Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread());
    }

    public final int getTargetSdkVersion(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "packageManager.getApplicationInfo(packageName, 0)");
            return applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 15;
        }
    }

    public final void openURLInBrowser(Context appContext, Uri uri) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(uri, "uri");
        appContext.startActivity(openURLInBrowserIntent(uri));
    }

    public final Intent openURLInBrowserIntent(Uri uri) {
        Intent makeMainSelectorActivity;
        Intrinsics.checkNotNullParameter(uri, "uri");
        SchemaType fromString = uri.getScheme() != null ? SchemaType.INSTANCE.fromString(uri.getScheme()) : null;
        if (fromString == null) {
            fromString = SchemaType.HTTP;
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            if (!StringsKt.contains$default((CharSequence) uri2, (CharSequence) "://", false, 2, (Object) null)) {
                uri = Uri.parse("http://" + uri);
                Intrinsics.checkNotNullExpressionValue(uri, "parse(\"http://$uri\")");
            }
        }
        int i = WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()];
        if (i == 1) {
            makeMainSelectorActivity = Intent.makeMainSelectorActivity("android.intent.action.MAIN", "android.intent.category.APP_BROWSER");
            Intrinsics.checkNotNullExpressionValue(makeMainSelectorActivity, "makeMainSelectorActivity…ent.CATEGORY_APP_BROWSER)");
            makeMainSelectorActivity.setData(uri);
        } else if (i == 2 || i == 3) {
            makeMainSelectorActivity = new Intent("android.intent.action.VIEW", uri);
        } else {
            makeMainSelectorActivity = new Intent("android.intent.action.VIEW", uri);
        }
        makeMainSelectorActivity.addFlags(268435456);
        return makeMainSelectorActivity;
    }

    public final boolean hasPermission(String permission, boolean isUserGranted, IApplicationService applicationService) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(applicationService, "applicationService");
        try {
            PackageInfo packageInfo = applicationService.getAppContext().getPackageManager().getPackageInfo(applicationService.getAppContext().getPackageName(), 4096);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "applicationService.appCo…NS,\n                    )");
            String[] strArr = packageInfo.requestedPermissions;
            Intrinsics.checkNotNullExpressionValue(strArr, "packageInfo.requestedPermissions");
            if (!CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length)).contains(permission)) {
                return false;
            }
            if (isUserGranted) {
                if (AndroidSupportV4Compat.ContextCompat.INSTANCE.checkSelfPermission(applicationService.getAppContext(), permission) == -1) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final List<String> filterManifestPermissions(List<String> permissions, IApplicationService applicationService) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(applicationService, "applicationService");
        PackageInfo packageInfo = applicationService.getAppContext().getPackageManager().getPackageInfo(applicationService.getAppContext().getPackageName(), 4096);
        Intrinsics.checkNotNullExpressionValue(packageInfo, "applicationService.appCo…eManager.GET_PERMISSIONS)");
        String[] strArr = packageInfo.requestedPermissions;
        Intrinsics.checkNotNullExpressionValue(strArr, "packageInfo.requestedPermissions");
        List listOf = CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length));
        ArrayList arrayList = new ArrayList();
        for (Object obj : permissions) {
            if (listOf.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* compiled from: AndroidUtils.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/onesignal/common/AndroidUtils$SchemaType;", "", "text", "", "(Ljava/lang/String;ILjava/lang/String;)V", "DATA", "HTTPS", "HTTP", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public enum SchemaType {
        DATA("data"),
        HTTPS("https"),
        HTTP("http");


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String text;

        SchemaType(String str) {
            this.text = str;
        }

        /* compiled from: AndroidUtils.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/common/AndroidUtils$SchemaType$Companion;", "", "()V", "fromString", "Lcom/onesignal/common/AndroidUtils$SchemaType;", "text", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final SchemaType fromString(String text) {
                for (SchemaType schemaType : SchemaType.values()) {
                    if (StringsKt.equals(schemaType.text, text, true)) {
                        return schemaType;
                    }
                }
                return null;
            }
        }
    }

    public final void openURLInBrowser(Context appContext, String url) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(url, "url");
        String str = url;
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        Uri parse = Uri.parse(str.subSequence(i, length + 1).toString());
        Intrinsics.checkNotNullExpressionValue(parse, "parse(url.trim { it <= ' ' })");
        openURLInBrowser(appContext, parse);
    }
}
