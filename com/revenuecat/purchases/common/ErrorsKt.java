package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.verification.SignatureVerificationException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* compiled from: errors.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u00060\u0006j\u0002`\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0002H\u0002¨\u0006\n"}, d2 = {"toPurchasesError", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/common/BackendErrorCode;", "underlyingErrorMessage", "", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "toPurchasesErrorCode", "Lcom/revenuecat/purchases/PurchasesErrorCode;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ErrorsKt {

    /* compiled from: errors.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BackendErrorCode.values().length];
            try {
                iArr[BackendErrorCode.BackendStoreProblem.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BackendErrorCode.BackendCannotTransferPurchase.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidReceiptToken.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidPlayStoreCredentials.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidAuthToken.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidAPIKey.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidPaymentModeOrIntroPriceNotProvided.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BackendErrorCode.BackendProductIdForGoogleReceiptNotProvided.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BackendErrorCode.BackendEmptyAppUserId.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BackendErrorCode.BackendPlayStoreQuotaExceeded.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[BackendErrorCode.BackendPlayStoreInvalidPackageName.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidPlatform.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[BackendErrorCode.BackendPlayStoreGenericError.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[BackendErrorCode.BackendUserIneligibleForPromoOffer.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidSubscriberAttributes.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidSubscriberAttributesBody.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidAppStoreSharedSecret.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[BackendErrorCode.BackendInvalidAppleSubscriptionKey.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[BackendErrorCode.BackendBadRequest.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[BackendErrorCode.BackendInternalServerError.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[BackendErrorCode.BackendProductIDsMalformed.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final PurchasesError toPurchasesError(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        if (exc instanceof JSONException ? true : exc instanceof IOException) {
            return new PurchasesError(PurchasesErrorCode.NetworkError, exc.getLocalizedMessage());
        }
        if (exc instanceof SecurityException) {
            return new PurchasesError(PurchasesErrorCode.InsufficientPermissionsError, ((SecurityException) exc).getLocalizedMessage());
        }
        if (exc instanceof SignatureVerificationException) {
            return new PurchasesError(PurchasesErrorCode.SignatureVerificationError, ((SignatureVerificationException) exc).getLocalizedMessage());
        }
        return new PurchasesError(PurchasesErrorCode.UnknownError, exc.getLocalizedMessage());
    }

    private static final PurchasesError toPurchasesError(BackendErrorCode backendErrorCode, String str) {
        return new PurchasesError(toPurchasesErrorCode(backendErrorCode), str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0055, code lost:
    
        if (r1 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.revenuecat.purchases.PurchasesError toPurchasesError(com.revenuecat.purchases.common.networking.HTTPResult r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            org.json.JSONObject r0 = r5.getBody()
            java.lang.String r1 = "code"
            boolean r0 = r0.has(r1)
            if (r0 == 0) goto L21
            org.json.JSONObject r0 = r5.getBody()
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L22
        L21:
            r0 = 0
        L22:
            org.json.JSONObject r1 = r5.getBody()
            java.lang.String r2 = "message"
            boolean r1 = r1.has(r2)
            if (r1 == 0) goto L3e
            org.json.JSONObject r5 = r5.getBody()
            java.lang.Object r5 = r5.get(r2)
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r1)
            java.lang.String r5 = (java.lang.String) r5
            goto L40
        L3e:
            java.lang.String r5 = ""
        L40:
            if (r0 == 0) goto L57
            r1 = r0
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            com.revenuecat.purchases.common.BackendErrorCode$Companion r2 = com.revenuecat.purchases.common.BackendErrorCode.INSTANCE
            com.revenuecat.purchases.common.BackendErrorCode r1 = r2.valueOf(r1)
            if (r1 == 0) goto L57
            com.revenuecat.purchases.PurchasesError r1 = toPurchasesError(r1, r5)
            if (r1 != 0) goto L78
        L57:
            com.revenuecat.purchases.PurchasesError r1 = new com.revenuecat.purchases.PurchasesError
            com.revenuecat.purchases.PurchasesErrorCode r2 = com.revenuecat.purchases.PurchasesErrorCode.UnknownBackendError
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Backend Code: "
            r3.<init>(r4)
            if (r0 != 0) goto L66
            java.lang.String r0 = "N/A"
        L66:
            r3.append(r0)
            java.lang.String r0 = " - "
            r3.append(r0)
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            r1.<init>(r2, r5)
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.ErrorsKt.toPurchasesError(com.revenuecat.purchases.common.networking.HTTPResult):com.revenuecat.purchases.PurchasesError");
    }

    private static final PurchasesErrorCode toPurchasesErrorCode(BackendErrorCode backendErrorCode) {
        switch (WhenMappings.$EnumSwitchMapping$0[backendErrorCode.ordinal()]) {
            case 1:
                return PurchasesErrorCode.StoreProblemError;
            case 2:
                return PurchasesErrorCode.ReceiptAlreadyInUseError;
            case 3:
                return PurchasesErrorCode.InvalidReceiptError;
            case 4:
            case 5:
            case 6:
                return PurchasesErrorCode.InvalidCredentialsError;
            case 7:
            case 8:
                return PurchasesErrorCode.PurchaseInvalidError;
            case 9:
                return PurchasesErrorCode.InvalidAppUserIdError;
            case 10:
                return PurchasesErrorCode.StoreProblemError;
            case 11:
            case 12:
                return PurchasesErrorCode.ConfigurationError;
            case 13:
                return PurchasesErrorCode.StoreProblemError;
            case 14:
                return PurchasesErrorCode.IneligibleError;
            case 15:
            case 16:
                return PurchasesErrorCode.InvalidSubscriberAttributesError;
            case 17:
            case 18:
            case 19:
            case 20:
                return PurchasesErrorCode.UnexpectedBackendResponseError;
            case 21:
                return PurchasesErrorCode.UnsupportedError;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
