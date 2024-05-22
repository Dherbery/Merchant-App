package com.revenuecat.purchases.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.LocaleList;
import android.util.Base64;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.security.MessageDigest;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: utils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u000e\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u0004H\u0000\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0003H\u0002\u001a\f\u0010\u000f\u001a\u00020\u0003*\u00020\u0003H\u0000\u001a\f\u0010\u0010\u001a\u00020\u0003*\u00020\u0003H\u0000\u001a\f\u0010\u0011\u001a\u00020\u0003*\u00020\fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u001a\u0010\t\u001a\u0004\u0018\u00010\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006¨\u0006\u0012"}, d2 = {"MICROS_MULTIPLIER", "", "playServicesVersionName", "", "Landroid/content/Context;", "getPlayServicesVersionName", "(Landroid/content/Context;)Ljava/lang/String;", "playStoreVersionName", "getPlayStoreVersionName", "versionName", "getVersionName", "getLocale", "Ljava/util/Locale;", "packageVersionName", "packageName", "sha1", SigningManager.POST_PARAMS_ALGORITHM, "toBCP47", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class UtilsKt {
    public static final int MICROS_MULTIPLIER = 1000000;

    public static final Locale getLocale(Context context) {
        LocaleList locales;
        Locale locale;
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (Build.VERSION.SDK_INT >= 24) {
            locales = context.getResources().getConfiguration().getLocales();
            locale = locales.get(0);
            return locale;
        }
        return context.getResources().getConfiguration().locale;
    }

    public static final String toBCP47(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        String languageTag = locale.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag()");
        return languageTag;
    }

    public static final String sha1(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] encode = Base64.encode(messageDigest.digest(bytes), 2);
        Intrinsics.checkNotNullExpressionValue(encode, "encode(it, Base64.NO_WRAP)");
        return new String(encode, Charsets.UTF_8);
    }

    public static final String sha256(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] encode = Base64.encode(messageDigest.digest(bytes), 2);
        Intrinsics.checkNotNullExpressionValue(encode, "encode(it, Base64.NO_WRAP)");
        return new String(encode, Charsets.UTF_8);
    }

    public static final String getVersionName(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
    }

    private static final String packageVersionName(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static final String getPlayStoreVersionName(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return packageVersionName(context, "com.android.vending");
    }

    public static final String getPlayServicesVersionName(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return packageVersionName(context, "com.google.android.gms");
    }
}
