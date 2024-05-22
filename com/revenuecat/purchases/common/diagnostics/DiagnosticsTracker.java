package com.revenuecat.purchases.common.diagnostics;

import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.utils.AndroidVersionUtilsKt;
import com.revenuecat.purchases.utils.EventsFileHelper;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* compiled from: DiagnosticsTracker.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 .2\u00020\u0001:\u0001.B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u0015\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0010J3\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001aJ3\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001aJE\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020#J\u0016\u0010-\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "diagnosticsFileHelper", "Lcom/revenuecat/purchases/utils/EventsFileHelper;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry;", "diagnosticsAnonymizer", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsAnonymizer;", "diagnosticsDispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/utils/EventsFileHelper;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsAnonymizer;Lcom/revenuecat/purchases/common/Dispatcher;)V", "trackEvent", "", "diagnosticsEntry", "trackEventInCurrentThread", "trackEventInCurrentThread$purchases_defaultsRelease", "trackGoogleQueryProductDetailsRequest", "productType", "", "billingResponseCode", "", "billingDebugMessage", "responseTime", "Lkotlin/time/Duration;", "trackGoogleQueryProductDetailsRequest-Wn2Vu4Y", "(Ljava/lang/String;ILjava/lang/String;J)V", "trackGoogleQueryPurchaseHistoryRequest", "trackGoogleQueryPurchaseHistoryRequest-Wn2Vu4Y", "trackGoogleQueryPurchasesRequest", "trackGoogleQueryPurchasesRequest-Wn2Vu4Y", "trackHttpRequestPerformed", "endpoint", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "wasSuccessful", "", "responseCode", "resultOrigin", "Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "verificationResult", "Lcom/revenuecat/purchases/VerificationResult;", "trackHttpRequestPerformed-NcHsxvU", "(Lcom/revenuecat/purchases/common/networking/Endpoint;JZILcom/revenuecat/purchases/common/networking/HTTPResult$Origin;Lcom/revenuecat/purchases/VerificationResult;)V", "trackMaxEventsStoredLimitReached", "useCurrentThread", "trackProductDetailsNotSupported", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class DiagnosticsTracker {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String ENDPOINT_NAME_KEY = "endpoint_name";

    @Deprecated
    public static final String ETAG_HIT_KEY = "etag_hit";

    @Deprecated
    public static final String PRODUCT_TYPE_QUERIED_KEY = "product_type_queried";

    @Deprecated
    public static final String RESPONSE_CODE_KEY = "response_code";

    @Deprecated
    public static final String RESPONSE_TIME_MILLIS_KEY = "response_time_millis";

    @Deprecated
    public static final String SUCCESSFUL_KEY = "successful";

    @Deprecated
    public static final String VERIFICATION_RESULT_KEY = "verification_result";
    private final AppConfig appConfig;
    private final DiagnosticsAnonymizer diagnosticsAnonymizer;
    private final Dispatcher diagnosticsDispatcher;
    private final EventsFileHelper<DiagnosticsEntry> diagnosticsFileHelper;

    public DiagnosticsTracker(AppConfig appConfig, EventsFileHelper<DiagnosticsEntry> diagnosticsFileHelper, DiagnosticsAnonymizer diagnosticsAnonymizer, Dispatcher diagnosticsDispatcher) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(diagnosticsFileHelper, "diagnosticsFileHelper");
        Intrinsics.checkNotNullParameter(diagnosticsAnonymizer, "diagnosticsAnonymizer");
        Intrinsics.checkNotNullParameter(diagnosticsDispatcher, "diagnosticsDispatcher");
        this.appConfig = appConfig;
        this.diagnosticsFileHelper = diagnosticsFileHelper;
        this.diagnosticsAnonymizer = diagnosticsAnonymizer;
        this.diagnosticsDispatcher = diagnosticsDispatcher;
    }

    /* compiled from: DiagnosticsTracker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker$Companion;", "", "()V", "ENDPOINT_NAME_KEY", "", "ETAG_HIT_KEY", "PRODUCT_TYPE_QUERIED_KEY", "RESPONSE_CODE_KEY", "RESPONSE_TIME_MILLIS_KEY", "SUCCESSFUL_KEY", "VERIFICATION_RESULT_KEY", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: trackHttpRequestPerformed-NcHsxvU, reason: not valid java name */
    public final void m1094trackHttpRequestPerformedNcHsxvU(Endpoint endpoint, long responseTime, boolean wasSuccessful, int responseCode, HTTPResult.Origin resultOrigin, VerificationResult verificationResult) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        boolean z = resultOrigin == HTTPResult.Origin.CACHE;
        trackEvent(new DiagnosticsEntry.Event(DiagnosticsEventName.HTTP_REQUEST_PERFORMED, MapsKt.mapOf(TuplesKt.to(ENDPOINT_NAME_KEY, endpoint.getName()), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m2714getInWholeMillisecondsimpl(responseTime))), TuplesKt.to(SUCCESSFUL_KEY, Boolean.valueOf(wasSuccessful)), TuplesKt.to(RESPONSE_CODE_KEY, Integer.valueOf(responseCode)), TuplesKt.to(ETAG_HIT_KEY, Boolean.valueOf(z)), TuplesKt.to(VERIFICATION_RESULT_KEY, verificationResult.name())), null, null, 12, null));
        trackEvent(new DiagnosticsEntry.Counter(DiagnosticsCounterName.HTTP_REQUEST_PERFORMED, MapsKt.mapOf(TuplesKt.to(ENDPOINT_NAME_KEY, endpoint.getName()), TuplesKt.to(SUCCESSFUL_KEY, String.valueOf(wasSuccessful)), TuplesKt.to(RESPONSE_CODE_KEY, String.valueOf(responseCode)), TuplesKt.to(ETAG_HIT_KEY, String.valueOf(z)), TuplesKt.to(VERIFICATION_RESULT_KEY, verificationResult.name())), 1));
    }

    /* renamed from: trackGoogleQueryProductDetailsRequest-Wn2Vu4Y, reason: not valid java name */
    public final void m1091trackGoogleQueryProductDetailsRequestWn2Vu4Y(String productType, int billingResponseCode, String billingDebugMessage, long responseTime) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(billingDebugMessage, "billingDebugMessage");
        trackEvent(new DiagnosticsEntry.Event(DiagnosticsEventName.GOOGLE_QUERY_PRODUCT_DETAILS_REQUEST, MapsKt.mapOf(TuplesKt.to(PRODUCT_TYPE_QUERIED_KEY, productType), TuplesKt.to("billing_response_code", Integer.valueOf(billingResponseCode)), TuplesKt.to("billing_debug_message", billingDebugMessage), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m2714getInWholeMillisecondsimpl(responseTime)))), null, null, 12, null));
    }

    /* renamed from: trackGoogleQueryPurchasesRequest-Wn2Vu4Y, reason: not valid java name */
    public final void m1093trackGoogleQueryPurchasesRequestWn2Vu4Y(String productType, int billingResponseCode, String billingDebugMessage, long responseTime) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(billingDebugMessage, "billingDebugMessage");
        trackEvent(new DiagnosticsEntry.Event(DiagnosticsEventName.GOOGLE_QUERY_PURCHASES_REQUEST, MapsKt.mapOf(TuplesKt.to(PRODUCT_TYPE_QUERIED_KEY, productType), TuplesKt.to("billing_response_code", Integer.valueOf(billingResponseCode)), TuplesKt.to("billing_debug_message", billingDebugMessage), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m2714getInWholeMillisecondsimpl(responseTime)))), null, null, 12, null));
    }

    /* renamed from: trackGoogleQueryPurchaseHistoryRequest-Wn2Vu4Y, reason: not valid java name */
    public final void m1092trackGoogleQueryPurchaseHistoryRequestWn2Vu4Y(String productType, int billingResponseCode, String billingDebugMessage, long responseTime) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(billingDebugMessage, "billingDebugMessage");
        trackEvent(new DiagnosticsEntry.Event(DiagnosticsEventName.GOOGLE_QUERY_PURCHASE_HISTORY_REQUEST, MapsKt.mapOf(TuplesKt.to(PRODUCT_TYPE_QUERIED_KEY, productType), TuplesKt.to("billing_response_code", Integer.valueOf(billingResponseCode)), TuplesKt.to("billing_debug_message", billingDebugMessage), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m2714getInWholeMillisecondsimpl(responseTime)))), null, null, 12, null));
    }

    public static /* synthetic */ void trackMaxEventsStoredLimitReached$default(DiagnosticsTracker diagnosticsTracker, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        diagnosticsTracker.trackMaxEventsStoredLimitReached(z);
    }

    public final void trackMaxEventsStoredLimitReached(boolean useCurrentThread) {
        DiagnosticsEntry.Event event = new DiagnosticsEntry.Event(DiagnosticsEventName.MAX_EVENTS_STORED_LIMIT_REACHED, MapsKt.emptyMap(), null, null, 12, null);
        if (useCurrentThread) {
            trackEventInCurrentThread$purchases_defaultsRelease(event);
        } else {
            trackEvent(event);
        }
    }

    public final void trackProductDetailsNotSupported(int billingResponseCode, String billingDebugMessage) {
        Intrinsics.checkNotNullParameter(billingDebugMessage, "billingDebugMessage");
        DiagnosticsCounterName diagnosticsCounterName = DiagnosticsCounterName.PRODUCT_DETAILS_NOT_SUPPORTED;
        Pair[] pairArr = new Pair[4];
        String playStoreVersionName = this.appConfig.getPlayStoreVersionName();
        if (playStoreVersionName == null) {
            playStoreVersionName = "";
        }
        pairArr[0] = TuplesKt.to("play_store_version", playStoreVersionName);
        String playServicesVersionName = this.appConfig.getPlayServicesVersionName();
        pairArr[1] = TuplesKt.to("play_services_version", playServicesVersionName != null ? playServicesVersionName : "");
        pairArr[2] = TuplesKt.to("billing_response_code", String.valueOf(billingResponseCode));
        pairArr[3] = TuplesKt.to("billing_debug_message", billingDebugMessage);
        trackEvent(new DiagnosticsEntry.Counter(diagnosticsCounterName, MapsKt.mapOf(pairArr), 1));
    }

    public final void trackEvent(final DiagnosticsEntry diagnosticsEntry) {
        Intrinsics.checkNotNullParameter(diagnosticsEntry, "diagnosticsEntry");
        Dispatcher.enqueue$default(this.diagnosticsDispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DiagnosticsTracker.trackEvent$lambda$0(DiagnosticsTracker.this, diagnosticsEntry);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trackEvent$lambda$0(DiagnosticsTracker this$0, DiagnosticsEntry diagnosticsEntry) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(diagnosticsEntry, "$diagnosticsEntry");
        this$0.trackEventInCurrentThread$purchases_defaultsRelease(diagnosticsEntry);
    }

    public final void trackEventInCurrentThread$purchases_defaultsRelease(DiagnosticsEntry diagnosticsEntry) {
        Intrinsics.checkNotNullParameter(diagnosticsEntry, "diagnosticsEntry");
        if (AndroidVersionUtilsKt.isAndroidNOrNewer()) {
            DiagnosticsEntry anonymizeEntryIfNeeded = this.diagnosticsAnonymizer.anonymizeEntryIfNeeded(diagnosticsEntry);
            LogUtilsKt.verboseLog("Tracking diagnostics event: " + anonymizeEntryIfNeeded);
            try {
                this.diagnosticsFileHelper.appendEvent(anonymizeEntryIfNeeded);
            } catch (IOException e) {
                LogUtilsKt.verboseLog("Error tracking diagnostics event: " + e);
            }
        }
    }
}
