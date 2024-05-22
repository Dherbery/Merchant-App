package com.onesignal.common;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.preferences.PreferenceStores;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidSupportV4Compat.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/onesignal/common/AndroidSupportV4Compat;", "", "()V", "ActivityCompat", "ActivityCompatApi23", "ContextCompat", "RequestPermissionsRequestCodeValidator", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class AndroidSupportV4Compat {

    /* compiled from: AndroidSupportV4Compat.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/onesignal/common/AndroidSupportV4Compat$RequestPermissionsRequestCodeValidator;", "", "validateRequestPermissionsRequestCode", "", "requestCode", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int requestCode);
    }

    /* compiled from: AndroidSupportV4Compat.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lcom/onesignal/common/AndroidSupportV4Compat$ContextCompat;", "", "()V", "checkSelfPermission", "", "context", "Landroid/content/Context;", "permission", "", "getColor", "id", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ContextCompat {
        public static final ContextCompat INSTANCE = new ContextCompat();

        private ContextCompat() {
        }

        public final int checkSelfPermission(Context context, String permission) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(permission, "permission");
            try {
                return context.checkPermission(permission, Process.myPid(), Process.myUid());
            } catch (Throwable unused) {
                Log.e(PreferenceStores.ONESIGNAL, "checkSelfPermission failed, returning PERMISSION_DENIED");
                return -1;
            }
        }

        public final int getColor(Context context, int id) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getColor(id);
        }
    }

    /* compiled from: AndroidSupportV4Compat.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\t¨\u0006\u0010"}, d2 = {"Lcom/onesignal/common/AndroidSupportV4Compat$ActivityCompat;", "", "()V", "requestPermissions", "", "activity", "Landroid/app/Activity;", "permissions", "", "", "requestCode", "", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "shouldShowRequestPermissionRationale", "", "permission", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ActivityCompat {
        public static final ActivityCompat INSTANCE = new ActivityCompat();

        private ActivityCompat() {
        }

        public final void requestPermissions(Activity activity, String[] permissions, int requestCode) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            ActivityCompatApi23.INSTANCE.requestPermissions(activity, permissions, requestCode);
        }

        public final boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
            return ActivityCompatApi23.INSTANCE.shouldShowRequestPermissionRationale(activity, permission);
        }
    }

    /* compiled from: AndroidSupportV4Compat.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\t¨\u0006\u0010"}, d2 = {"Lcom/onesignal/common/AndroidSupportV4Compat$ActivityCompatApi23;", "", "()V", "requestPermissions", "", "activity", "Landroid/app/Activity;", "permissions", "", "", "requestCode", "", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "shouldShowRequestPermissionRationale", "", "permission", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ActivityCompatApi23 {
        public static final ActivityCompatApi23 INSTANCE = new ActivityCompatApi23();

        private ActivityCompatApi23() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void requestPermissions(Activity activity, String[] permissions, int requestCode) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity instanceof RequestPermissionsRequestCodeValidator) {
                ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(requestCode);
            }
            Intrinsics.checkNotNull(permissions);
            activity.requestPermissions(permissions, requestCode);
        }

        public final boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
            Intrinsics.checkNotNull(activity);
            Intrinsics.checkNotNull(permission);
            return androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale(activity, permission);
        }
    }
}
