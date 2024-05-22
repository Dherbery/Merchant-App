package com.revenuecat.purchases.common;

import com.facebook.react.uimanager.ViewProps;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: logUtils.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u001c\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000\u001a\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001aP\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000426\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\t\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0002\u001a\u00020\u0004*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"PURCHASES_LOG_TAG", "", "debugLogsEnabled", "", "Lcom/revenuecat/purchases/LogLevel;", "getDebugLogsEnabled", "(Lcom/revenuecat/purchases/LogLevel;)Z", "debugLog", "", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "errorLog", "error", "Lcom/revenuecat/purchases/PurchasesError;", "throwable", "", "infoLog", "logIfEnabled", "level", "logger", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "tag", "verboseLog", "warnLog", "Lcom/revenuecat/purchases/LogLevel$Companion;", ViewProps.ENABLED, "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class LogUtilsKt {
    private static final String PURCHASES_LOG_TAG = "[Purchases]";

    /* compiled from: logUtils.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchasesErrorCode.values().length];
            try {
                iArr[PurchasesErrorCode.UnknownError.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchasesErrorCode.NetworkError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PurchasesErrorCode.ReceiptAlreadyInUseError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PurchasesErrorCode.UnexpectedBackendResponseError.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PurchasesErrorCode.InvalidAppUserIdError.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PurchasesErrorCode.OperationAlreadyInProgressError.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PurchasesErrorCode.UnknownBackendError.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PurchasesErrorCode.LogOutWithAnonymousUserError.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PurchasesErrorCode.ConfigurationError.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PurchasesErrorCode.UnsupportedError.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[PurchasesErrorCode.EmptySubscriberAttributesError.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[PurchasesErrorCode.CustomerInfoError.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[PurchasesErrorCode.SignatureVerificationError.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[PurchasesErrorCode.InvalidSubscriberAttributesError.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[PurchasesErrorCode.PurchaseCancelledError.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[PurchasesErrorCode.StoreProblemError.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[PurchasesErrorCode.PurchaseNotAllowedError.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[PurchasesErrorCode.PurchaseInvalidError.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[PurchasesErrorCode.ProductNotAvailableForPurchaseError.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[PurchasesErrorCode.ProductAlreadyPurchasedError.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[PurchasesErrorCode.InvalidReceiptError.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[PurchasesErrorCode.MissingReceiptFileError.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[PurchasesErrorCode.InvalidAppleSubscriptionKeyError.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[PurchasesErrorCode.IneligibleError.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[PurchasesErrorCode.InsufficientPermissionsError.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[PurchasesErrorCode.PaymentPendingError.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[PurchasesErrorCode.InvalidCredentialsError.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean getDebugLogsEnabled(LogLevel logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "<this>");
        return logLevel.compareTo(LogLevel.DEBUG) <= 0;
    }

    public static final LogLevel debugLogsEnabled(LogLevel.Companion companion, boolean z) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        if (z) {
            return LogLevel.DEBUG;
        }
        return LogLevel.INFO;
    }

    public static final void verboseLog(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        logIfEnabled(LogLevel.VERBOSE, new LogUtilsKt$verboseLog$1(LogWrapperKt.getCurrentLogHandler()), message);
    }

    public static final void debugLog(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        logIfEnabled(LogLevel.DEBUG, new LogUtilsKt$debugLog$1(LogWrapperKt.getCurrentLogHandler()), message);
    }

    public static final void infoLog(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        logIfEnabled(LogLevel.INFO, new LogUtilsKt$infoLog$1(LogWrapperKt.getCurrentLogHandler()), message);
    }

    public static final void warnLog(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        logIfEnabled(LogLevel.WARN, new LogUtilsKt$warnLog$1(LogWrapperKt.getCurrentLogHandler()), message);
    }

    public static /* synthetic */ void errorLog$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        errorLog(str, th);
    }

    public static final void errorLog(String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", message, th);
    }

    private static final void logIfEnabled(LogLevel logLevel, Function2<? super String, ? super String, Unit> function2, String str) {
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            function2.invoke("[Purchases] - " + logLevel.name(), str);
        }
    }

    public static final void errorLog(PurchasesError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        switch (WhenMappings.$EnumSwitchMapping$0[error.getCode().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                LogWrapperKt.log(LogIntent.RC_ERROR, error.toString());
                return;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                LogWrapperKt.log(LogIntent.GOOGLE_ERROR, error.toString());
                return;
            default:
                return;
        }
    }
}
