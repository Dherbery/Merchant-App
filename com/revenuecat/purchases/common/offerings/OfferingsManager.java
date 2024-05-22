package com.revenuecat.purchases.common.offerings;

import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.OfferingStrings;
import com.revenuecat.purchases.utils.OfferingImagePreDownloader;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: OfferingsManager.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ@\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00122\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012H\u0002J\u0016\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018H\u0002JF\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00122\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012JF\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00122\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012J&\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00132\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012H\u0002J\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/revenuecat/purchases/common/offerings/OfferingsManager;", "", "offeringsCache", "Lcom/revenuecat/purchases/common/offerings/OfferingsCache;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "offeringsFactory", "Lcom/revenuecat/purchases/common/offerings/OfferingsFactory;", "offeringImagePreDownloader", "Lcom/revenuecat/purchases/utils/OfferingImagePreDownloader;", "mainHandler", "Landroid/os/Handler;", "(Lcom/revenuecat/purchases/common/offerings/OfferingsCache;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/offerings/OfferingsFactory;Lcom/revenuecat/purchases/utils/OfferingImagePreDownloader;Landroid/os/Handler;)V", "createAndCacheOfferings", "", "offeringsJSON", "Lorg/json/JSONObject;", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "onSuccess", "Lcom/revenuecat/purchases/Offerings;", "dispatch", "action", "Lkotlin/Function0;", "fetchAndCacheOfferings", "appUserID", "", "appInBackground", "", "getOfferings", "handleErrorFetchingOfferings", "error", "onAppForeground", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OfferingsManager {
    private final Backend backend;
    private final Handler mainHandler;
    private final OfferingImagePreDownloader offeringImagePreDownloader;
    private final OfferingsCache offeringsCache;
    private final OfferingsFactory offeringsFactory;

    public OfferingsManager(OfferingsCache offeringsCache, Backend backend, OfferingsFactory offeringsFactory, OfferingImagePreDownloader offeringImagePreDownloader, Handler handler) {
        Intrinsics.checkNotNullParameter(offeringsCache, "offeringsCache");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(offeringsFactory, "offeringsFactory");
        Intrinsics.checkNotNullParameter(offeringImagePreDownloader, "offeringImagePreDownloader");
        this.offeringsCache = offeringsCache;
        this.backend = backend;
        this.offeringsFactory = offeringsFactory;
        this.offeringImagePreDownloader = offeringImagePreDownloader;
        this.mainHandler = handler;
    }

    public /* synthetic */ OfferingsManager(OfferingsCache offeringsCache, Backend backend, OfferingsFactory offeringsFactory, OfferingImagePreDownloader offeringImagePreDownloader, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(offeringsCache, backend, offeringsFactory, offeringImagePreDownloader, (i & 16) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getOfferings$default(OfferingsManager offeringsManager, String str, boolean z, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        offeringsManager.getOfferings(str, z, function1, function12);
    }

    public final void getOfferings(String appUserID, boolean appInBackground, Function1<? super PurchasesError, Unit> onError, final Function1<? super Offerings, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        final Offerings cachedOfferings = this.offeringsCache.getCachedOfferings();
        if (cachedOfferings == null) {
            LogWrapperKt.log(LogIntent.DEBUG, OfferingStrings.NO_CACHED_OFFERINGS_FETCHING_NETWORK);
            fetchAndCacheOfferings(appUserID, appInBackground, onError, onSuccess);
            return;
        }
        LogWrapperKt.log(LogIntent.DEBUG, OfferingStrings.VENDING_OFFERINGS_CACHE);
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$getOfferings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function1<Offerings, Unit> function1 = onSuccess;
                if (function1 != null) {
                    function1.invoke(cachedOfferings);
                }
            }
        });
        if (this.offeringsCache.isOfferingsCacheStale(appInBackground)) {
            LogWrapperKt.log(LogIntent.DEBUG, appInBackground ? OfferingStrings.OFFERINGS_STALE_UPDATING_IN_BACKGROUND : OfferingStrings.OFFERINGS_STALE_UPDATING_IN_FOREGROUND);
            fetchAndCacheOfferings$default(this, appUserID, appInBackground, null, null, 12, null);
        }
    }

    public final void onAppForeground(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        if (this.offeringsCache.isOfferingsCacheStale(false)) {
            LogWrapperKt.log(LogIntent.DEBUG, OfferingStrings.OFFERINGS_STALE_UPDATING_IN_FOREGROUND);
            fetchAndCacheOfferings$default(this, appUserID, false, null, null, 12, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchAndCacheOfferings$default(OfferingsManager offeringsManager, String str, boolean z, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        offeringsManager.fetchAndCacheOfferings(str, z, function1, function12);
    }

    public final void fetchAndCacheOfferings(String appUserID, boolean appInBackground, final Function1<? super PurchasesError, Unit> onError, final Function1<? super Offerings, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        LogWrapperKt.log(LogIntent.RC_SUCCESS, OfferingStrings.OFFERINGS_START_UPDATE_FROM_NETWORK);
        this.backend.getOfferings(appUserID, appInBackground, new Function1<JSONObject, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$fetchAndCacheOfferings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                invoke2(jSONObject);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject it) {
                Intrinsics.checkNotNullParameter(it, "it");
                OfferingsManager.this.createAndCacheOfferings(it, onError, onSuccess);
            }
        }, new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$fetchAndCacheOfferings$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, Boolean bool) {
                invoke(purchasesError, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PurchasesError backendError, boolean z) {
                OfferingsCache offeringsCache;
                Intrinsics.checkNotNullParameter(backendError, "backendError");
                if (z) {
                    offeringsCache = OfferingsManager.this.offeringsCache;
                    JSONObject cachedOfferingsResponse = offeringsCache.getCachedOfferingsResponse();
                    if (cachedOfferingsResponse == null) {
                        OfferingsManager.this.handleErrorFetchingOfferings(backendError, onError);
                        return;
                    } else {
                        LogUtilsKt.warnLog(OfferingStrings.ERROR_FETCHING_OFFERINGS_USING_DISK_CACHE);
                        OfferingsManager.this.createAndCacheOfferings(cachedOfferingsResponse, onError, onSuccess);
                        return;
                    }
                }
                OfferingsManager.this.handleErrorFetchingOfferings(backendError, onError);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void createAndCacheOfferings$default(OfferingsManager offeringsManager, JSONObject jSONObject, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = null;
        }
        offeringsManager.createAndCacheOfferings(jSONObject, function1, function12);
    }

    public final void createAndCacheOfferings(final JSONObject offeringsJSON, final Function1<? super PurchasesError, Unit> onError, final Function1<? super Offerings, Unit> onSuccess) {
        this.offeringsFactory.createOfferings(offeringsJSON, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$createAndCacheOfferings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                OfferingsManager.this.handleErrorFetchingOfferings(error, onError);
            }
        }, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$createAndCacheOfferings$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offerings offerings) {
                invoke2(offerings);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Offerings offerings) {
                OfferingsCache offeringsCache;
                OfferingImagePreDownloader offeringImagePreDownloader;
                Intrinsics.checkNotNullParameter(offerings, "offerings");
                Offering current = offerings.getCurrent();
                if (current != null) {
                    offeringImagePreDownloader = OfferingsManager.this.offeringImagePreDownloader;
                    offeringImagePreDownloader.preDownloadOfferingImages(current);
                }
                offeringsCache = OfferingsManager.this.offeringsCache;
                offeringsCache.cacheOfferings(offerings, offeringsJSON);
                OfferingsManager offeringsManager = OfferingsManager.this;
                final Function1<Offerings, Unit> function1 = onSuccess;
                offeringsManager.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$createAndCacheOfferings$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Function1<Offerings, Unit> function12 = function1;
                        if (function12 != null) {
                            function12.invoke(offerings);
                        }
                    }
                });
            }
        });
    }

    public final void handleErrorFetchingOfferings(final PurchasesError error, final Function1<? super PurchasesError, Unit> onError) {
        LogIntent logIntent = SetsKt.setOf((Object[]) new PurchasesErrorCode[]{PurchasesErrorCode.ConfigurationError, PurchasesErrorCode.UnexpectedBackendResponseError}).contains(error.getCode()) ? LogIntent.RC_ERROR : LogIntent.GOOGLE_ERROR;
        String format = String.format(OfferingStrings.FETCHING_OFFERINGS_ERROR, Arrays.copyOf(new Object[]{error}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.offeringsCache.clearOfferingsCacheTimestamp();
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$handleErrorFetchingOfferings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function1<PurchasesError, Unit> function1 = onError;
                if (function1 != null) {
                    function1.invoke(error);
                }
            }
        });
    }

    public final void dispatch(final Function0<Unit> action) {
        if (!Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            Handler handler = this.mainHandler;
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    OfferingsManager.dispatch$lambda$0(Function0.this);
                }
            });
            return;
        }
        action.invoke();
    }

    public static final void dispatch$lambda$0(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }
}
