package com.revenuecat.purchases.common.networking;

import android.content.Context;
import android.content.SharedPreferences;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.strings.NetworkStrings;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ETagManager.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ5\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0014JK\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\b J\u0017\u0010!\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\"J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0016H\u0002J\u0015\u0010'\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b(J\u0018\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J%\u0010+\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u000fH\u0000¢\u0006\u0002\b-J \u0010.\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u000fH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/revenuecat/purchases/common/networking/ETagManager;", "", "context", "Landroid/content/Context;", "prefs", "Lkotlin/Lazy;", "Landroid/content/SharedPreferences;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Landroid/content/Context;Lkotlin/Lazy;Lcom/revenuecat/purchases/common/DateProvider;)V", "clearCaches", "", "clearCaches$purchases_defaultsRelease", "getETagHeaders", "", "", ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, "verificationRequested", "", "refreshETag", "getETagHeaders$purchases_defaultsRelease", "getHTTPResultFromCacheOrBackend", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "responseCode", "", "payload", "eTagHeader", "urlPathWithVersion", "requestDate", "Ljava/util/Date;", "verificationResult", "Lcom/revenuecat/purchases/VerificationResult;", "getHTTPResultFromCacheOrBackend$purchases_defaultsRelease", "getStoredResult", "getStoredResult$purchases_defaultsRelease", "getStoredResultSavedInSharedPreferences", "Lcom/revenuecat/purchases/common/networking/HTTPResultWithETag;", "shouldStoreBackendResult", "resultFromBackend", "shouldUseCachedVersion", "shouldUseCachedVersion$purchases_defaultsRelease", "shouldUseETag", "storedResult", "storeBackendResultIfNoError", "eTagInResponse", "storeBackendResultIfNoError$purchases_defaultsRelease", "storeResult", "result", "eTag", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ETagManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DateProvider dateProvider;
    private final Lazy<SharedPreferences> prefs;

    /* compiled from: ETagManager.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VerificationResult.values().length];
            try {
                iArr[VerificationResult.VERIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VerificationResult.NOT_REQUESTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VerificationResult.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VerificationResult.VERIFIED_ON_DEVICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean shouldUseCachedVersion$purchases_defaultsRelease(int responseCode) {
        return responseCode == 304;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ETagManager(Context context, Lazy<? extends SharedPreferences> prefs, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.prefs = prefs;
        this.dateProvider = dateProvider;
    }

    public /* synthetic */ ETagManager(final Context context, Lazy lazy, DefaultDateProvider defaultDateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.revenuecat.purchases.common.networking.ETagManager.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                return ETagManager.INSTANCE.initializeSharedPreferences(context);
            }
        }) : lazy, (i & 4) != 0 ? new DefaultDateProvider() : defaultDateProvider);
    }

    public static /* synthetic */ Map getETagHeaders$purchases_defaultsRelease$default(ETagManager eTagManager, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return eTagManager.getETagHeaders$purchases_defaultsRelease(str, z, z2);
    }

    public final Map<String, String> getETagHeaders$purchases_defaultsRelease(String path, boolean verificationRequested, boolean refreshETag) {
        ETagData eTagData;
        Date lastRefreshTime;
        Intrinsics.checkNotNullParameter(path, "path");
        String str = null;
        HTTPResultWithETag storedResultSavedInSharedPreferences = refreshETag ? null : getStoredResultSavedInSharedPreferences(path);
        if (storedResultSavedInSharedPreferences == null || (eTagData = storedResultSavedInSharedPreferences.getETagData()) == null || !shouldUseETag(storedResultSavedInSharedPreferences, verificationRequested)) {
            eTagData = null;
        }
        Pair[] pairArr = new Pair[2];
        String eTag = eTagData != null ? eTagData.getETag() : null;
        if (eTag == null) {
            eTag = "";
        }
        pairArr[0] = TuplesKt.to("X-RevenueCat-ETag", eTag);
        if (eTagData != null && (lastRefreshTime = eTagData.getLastRefreshTime()) != null) {
            str = Long.valueOf(lastRefreshTime.getTime()).toString();
        }
        pairArr[1] = TuplesKt.to(HTTPRequest.ETAG_LAST_REFRESH_NAME, str);
        return MapsKt.mapOf(pairArr);
    }

    public final HTTPResult getHTTPResultFromCacheOrBackend$purchases_defaultsRelease(int responseCode, String payload, String eTagHeader, String urlPathWithVersion, boolean refreshETag, Date requestDate, VerificationResult verificationResult) {
        HTTPResult hTTPResult;
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(urlPathWithVersion, "urlPathWithVersion");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        HTTPResult hTTPResult2 = new HTTPResult(responseCode, payload, HTTPResult.Origin.BACKEND, requestDate, verificationResult);
        if (eTagHeader != null) {
            if (shouldUseCachedVersion$purchases_defaultsRelease(responseCode)) {
                HTTPResult storedResult$purchases_defaultsRelease = getStoredResult$purchases_defaultsRelease(urlPathWithVersion);
                if (storedResult$purchases_defaultsRelease != null) {
                    hTTPResult = HTTPResult.copy$default(storedResult$purchases_defaultsRelease, 0, null, null, requestDate == null ? storedResult$purchases_defaultsRelease.getRequestDate() : requestDate, verificationResult, 7, null);
                } else {
                    hTTPResult = null;
                }
                if (hTTPResult != null) {
                    return hTTPResult;
                }
                if (!refreshETag) {
                    return null;
                }
                LogIntent logIntent = LogIntent.WARNING;
                String format = String.format(NetworkStrings.ETAG_CALL_ALREADY_RETRIED, Arrays.copyOf(new Object[]{hTTPResult2}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogWrapperKt.log(logIntent, format);
                return hTTPResult2;
            }
            storeBackendResultIfNoError$purchases_defaultsRelease(urlPathWithVersion, hTTPResult2, eTagHeader);
        }
        return hTTPResult2;
    }

    public final HTTPResult getStoredResult$purchases_defaultsRelease(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        HTTPResultWithETag storedResultSavedInSharedPreferences = getStoredResultSavedInSharedPreferences(path);
        if (storedResultSavedInSharedPreferences != null) {
            return storedResultSavedInSharedPreferences.getHttpResult();
        }
        return null;
    }

    public final void storeBackendResultIfNoError$purchases_defaultsRelease(String path, HTTPResult resultFromBackend, String eTagInResponse) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(resultFromBackend, "resultFromBackend");
        Intrinsics.checkNotNullParameter(eTagInResponse, "eTagInResponse");
        if (shouldStoreBackendResult(resultFromBackend)) {
            storeResult(path, resultFromBackend, eTagInResponse);
        }
    }

    public final synchronized void clearCaches$purchases_defaultsRelease() {
        this.prefs.getValue().edit().clear().apply();
    }

    private final synchronized void storeResult(String path, HTTPResult result, String eTag) {
        this.prefs.getValue().edit().putString(path, new HTTPResultWithETag(new ETagData(eTag, this.dateProvider.getNow()), HTTPResult.copy$default(result, 0, null, HTTPResult.Origin.CACHE, null, null, 27, null)).serialize()).apply();
    }

    private final HTTPResultWithETag getStoredResultSavedInSharedPreferences(String path) {
        String string = this.prefs.getValue().getString(path, null);
        if (string != null) {
            return HTTPResultWithETag.INSTANCE.deserialize(string);
        }
        return null;
    }

    private final boolean shouldStoreBackendResult(HTTPResult resultFromBackend) {
        int responseCode = resultFromBackend.getResponseCode();
        return (responseCode == 304 || responseCode >= 500 || resultFromBackend.getVerificationResult() == VerificationResult.FAILED) ? false : true;
    }

    private final boolean shouldUseETag(HTTPResultWithETag storedResult, boolean verificationRequested) {
        int i = WhenMappings.$EnumSwitchMapping$0[storedResult.getHttpResult().getVerificationResult().ordinal()];
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            if (i != 3 && i != 4) {
                throw new NoWhenBranchMatchedException();
            }
        } else if (!verificationRequested) {
            return true;
        }
        return false;
    }

    /* compiled from: ETagManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/networking/ETagManager$Companion;", "", "()V", "initializeSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SharedPreferences initializeSharedPreferences(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences_etags", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…DE_PRIVATE,\n            )");
            return sharedPreferences;
        }
    }
}
