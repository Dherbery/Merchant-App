package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.OfferingParser;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.strings.OfferingStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OfferingsFactory.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u000eJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0002JP\u0010\u0015\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132$\u0010\u0017\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018\u0012\u0004\u0012\u00020\n0\u000e2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u000eH\u0002J7\u0010\u001b\u001a\u0004\u0018\u00010\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018H\u0002¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/common/offerings/OfferingsFactory;", "", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "offeringParser", "Lcom/revenuecat/purchases/common/OfferingParser;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "(Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/common/OfferingParser;Lcom/revenuecat/purchases/common/Dispatcher;)V", "createOfferings", "", "offeringsJSON", "Lorg/json/JSONObject;", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "onSuccess", "Lcom/revenuecat/purchases/Offerings;", "extractProductIdentifiers", "", "", "getStoreProductsById", "productIds", "onCompleted", "", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "logMissingProducts", "allProductIdsInOfferings", "storeProductByID", "(Ljava/util/Set;Ljava/util/Map;)Lkotlin/Unit;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OfferingsFactory {
    private final BillingAbstract billing;
    private final Dispatcher dispatcher;
    private final OfferingParser offeringParser;

    public OfferingsFactory(BillingAbstract billing, OfferingParser offeringParser, Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(offeringParser, "offeringParser");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.billing = billing;
        this.offeringParser = offeringParser;
        this.dispatcher = dispatcher;
    }

    public final void createOfferings(final JSONObject offeringsJSON, final Function1<? super PurchasesError, Unit> onError, final Function1<? super Offerings, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(offeringsJSON, "offeringsJSON");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        try {
            final Set<String> extractProductIdentifiers = extractProductIdentifiers(offeringsJSON);
            if (extractProductIdentifiers.isEmpty()) {
                onError.invoke(new PurchasesError(PurchasesErrorCode.ConfigurationError, OfferingStrings.CONFIGURATION_ERROR_NO_PRODUCTS_FOR_OFFERINGS));
            } else {
                getStoreProductsById(extractProductIdentifiers, new Function1<Map<String, ? extends List<? extends StoreProduct>>, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory$createOfferings$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends List<? extends StoreProduct>> map) {
                        invoke2(map);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Map<String, ? extends List<? extends StoreProduct>> productsById) {
                        OfferingParser offeringParser;
                        Intrinsics.checkNotNullParameter(productsById, "productsById");
                        try {
                            OfferingsFactory.this.logMissingProducts(extractProductIdentifiers, productsById);
                            offeringParser = OfferingsFactory.this.offeringParser;
                            Offerings createOfferings = offeringParser.createOfferings(offeringsJSON, productsById);
                            if (createOfferings.getAll().isEmpty()) {
                                onError.invoke(new PurchasesError(PurchasesErrorCode.ConfigurationError, OfferingStrings.CONFIGURATION_ERROR_PRODUCTS_NOT_FOUND));
                            } else {
                                String format = String.format(OfferingStrings.CREATED_OFFERINGS, Arrays.copyOf(new Object[]{createOfferings}, 1));
                                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                                LogUtilsKt.verboseLog(format);
                                onSuccess.invoke(createOfferings);
                            }
                        } catch (Exception e) {
                            if (e instanceof JSONException ? true : e instanceof SerializationException) {
                                LogIntent logIntent = LogIntent.RC_ERROR;
                                String format2 = String.format(OfferingStrings.JSON_EXCEPTION_ERROR, Arrays.copyOf(new Object[]{e.getLocalizedMessage()}, 1));
                                Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                                LogWrapperKt.log(logIntent, format2);
                                onError.invoke(new PurchasesError(PurchasesErrorCode.UnexpectedBackendResponseError, e.getLocalizedMessage()));
                                return;
                            }
                            throw e;
                        }
                    }
                }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory$createOfferings$2
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
                        onError.invoke(error);
                    }
                });
            }
        } catch (JSONException e) {
            LogIntent logIntent = LogIntent.RC_ERROR;
            String format = String.format(OfferingStrings.JSON_EXCEPTION_ERROR, Arrays.copyOf(new Object[]{e.getLocalizedMessage()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
            onError.invoke(new PurchasesError(PurchasesErrorCode.UnexpectedBackendResponseError, e.getLocalizedMessage()));
        }
    }

    private final Set<String> extractProductIdentifiers(JSONObject offeringsJSON) {
        JSONArray jSONArray = offeringsJSON.getJSONArray("offerings");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("packages");
            int length2 = jSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                String it = jSONArray2.getJSONObject(i2).optString("platform_product_identifier");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!(!StringsKt.isBlank(it))) {
                    it = null;
                }
                if (it != null) {
                    linkedHashSet.add(it);
                }
            }
        }
        return linkedHashSet;
    }

    private final void getStoreProductsById(Set<String> productIds, Function1<? super Map<String, ? extends List<? extends StoreProduct>>, Unit> onCompleted, final Function1<? super PurchasesError, Unit> onError) {
        this.billing.queryProductDetailsAsync(ProductType.SUBS, productIds, new OfferingsFactory$getStoreProductsById$1(this, productIds, onCompleted, onError), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory$getStoreProductsById$2
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
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                onError.invoke(it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Unit logMissingProducts(Set<String> allProductIdsInOfferings, Map<String, ? extends List<? extends StoreProduct>> storeProductByID) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : allProductIdsInOfferings) {
            if (!storeProductByID.containsKey((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!(!arrayList2.isEmpty())) {
            arrayList2 = null;
        }
        if (arrayList2 == null) {
            return null;
        }
        LogIntent logIntent = LogIntent.GOOGLE_WARNING;
        String format = String.format(OfferingStrings.CANNOT_FIND_PRODUCT_CONFIGURATION_ERROR, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(arrayList2, ", ", null, null, 0, null, null, 62, null)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        return Unit.INSTANCE;
    }
}
