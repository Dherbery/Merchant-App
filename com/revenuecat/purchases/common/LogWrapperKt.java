package com.revenuecat.purchases.common;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.revenuecat.purchases.LogHandler;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: logWrapper.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"currentLogHandler", "Lcom/revenuecat/purchases/LogHandler;", "getCurrentLogHandler", "()Lcom/revenuecat/purchases/LogHandler;", "setCurrentLogHandler", "(Lcom/revenuecat/purchases/LogHandler;)V", "log", "", "intent", "Lcom/revenuecat/purchases/common/LogIntent;", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class LogWrapperKt {
    private static LogHandler currentLogHandler = new DefaultLogHandler();

    /* compiled from: logWrapper.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogIntent.values().length];
            try {
                iArr[LogIntent.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogIntent.GOOGLE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogIntent.GOOGLE_WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogIntent.INFO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LogIntent.PURCHASE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LogIntent.RC_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LogIntent.RC_PURCHASE_SUCCESS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[LogIntent.RC_SUCCESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[LogIntent.USER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[LogIntent.WARNING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[LogIntent.AMAZON_WARNING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[LogIntent.AMAZON_ERROR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final LogHandler getCurrentLogHandler() {
        return currentLogHandler;
    }

    public static final void setCurrentLogHandler(LogHandler logHandler) {
        Intrinsics.checkNotNullParameter(logHandler, "<set-?>");
        currentLogHandler = logHandler;
    }

    public static final void log(LogIntent intent, String message) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(message, "message");
        String str = CollectionsKt.joinToString$default(intent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + message;
        switch (WhenMappings.$EnumSwitchMapping$0[intent.ordinal()]) {
            case 1:
                LogUtilsKt.debugLog(str);
                return;
            case 2:
                LogUtilsKt.errorLog$default(str, null, 2, null);
                return;
            case 3:
                LogUtilsKt.warnLog(str);
                return;
            case 4:
                LogUtilsKt.infoLog(str);
                return;
            case 5:
                LogUtilsKt.debugLog(str);
                return;
            case 6:
                LogUtilsKt.errorLog$default(str, null, 2, null);
                return;
            case 7:
                LogUtilsKt.infoLog(str);
                return;
            case 8:
                LogUtilsKt.debugLog(str);
                return;
            case 9:
                LogUtilsKt.debugLog(str);
                return;
            case 10:
                LogUtilsKt.warnLog(str);
                return;
            case 11:
                LogUtilsKt.warnLog(str);
                return;
            case 12:
                LogUtilsKt.errorLog$default(str, null, 2, null);
                return;
            default:
                return;
        }
    }
}
