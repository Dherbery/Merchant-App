package com.onesignal.common;

import com.onesignal.core.BuildConfig;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OneSignalUtils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/onesignal/common/OneSignalUtils;", "", "()V", "SDK_VERSION", "", "isValidEmail", "", "email", "isValidPhoneNumber", "number", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OneSignalUtils {
    public static final OneSignalUtils INSTANCE = new OneSignalUtils();
    public static final String SDK_VERSION = "050110";

    private OneSignalUtils() {
    }

    public final boolean isValidEmail(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        String str = email;
        if (str.length() == 0) {
            return false;
        }
        Pattern compile = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(emRegex)");
        return compile.matcher(str).matches();
    }

    public final boolean isValidPhoneNumber(String number) {
        Intrinsics.checkNotNullParameter(number, "number");
        String str = number;
        if (str.length() == 0) {
            return false;
        }
        Pattern compile = Pattern.compile("^\\+?[1-9]\\d{1,14}$");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(emRegex)");
        return compile.matcher(str).matches();
    }
}
