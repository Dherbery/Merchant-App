package com.revenuecat.purchases.amazon;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.networking.Endpoint;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AmazonBackend.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J>\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\f2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00110\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RÌ\u0001\u0010\u0014\u001aU\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0012A\u0012?\u0012;\u00129\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00110\f0\u000bj\u0002`\u00130\n0\u00062Y\u0010\u0005\u001aU\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0012A\u0012?\u0012;\u00129\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00110\f0\u000bj\u0002`\u00130\n0\u00068F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/amazon/AmazonBackend;", "", "backendHelper", "Lcom/revenuecat/purchases/common/BackendHelper;", "(Lcom/revenuecat/purchases/common/BackendHelper;)V", "<set-?>", "", "", "", "Lcom/revenuecat/purchases/amazon/CallbackCacheKey;", "", "Lkotlin/Pair;", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "response", "", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/amazon/PostAmazonReceiptCallback;", "postAmazonReceiptCallbacks", "getPostAmazonReceiptCallbacks", "()Ljava/util/Map;", "setPostAmazonReceiptCallbacks", "(Ljava/util/Map;)V", "getAmazonReceiptData", b.E, "storeUserID", "onSuccess", "onError", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class AmazonBackend {
    private final BackendHelper backendHelper;
    private volatile Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>>> postAmazonReceiptCallbacks;

    public AmazonBackend(BackendHelper backendHelper) {
        Intrinsics.checkNotNullParameter(backendHelper, "backendHelper");
        this.backendHelper = backendHelper;
        this.postAmazonReceiptCallbacks = new LinkedHashMap();
    }

    public final synchronized Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>>> getPostAmazonReceiptCallbacks() {
        return this.postAmazonReceiptCallbacks;
    }

    public final synchronized void setPostAmazonReceiptCallbacks(Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.postAmazonReceiptCallbacks = map;
    }

    public final void getAmazonReceiptData(final String receiptId, final String storeUserID, Function1<? super JSONObject, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(receiptId, "receiptId");
        Intrinsics.checkNotNullParameter(storeUserID, "storeUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final List<String> listOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{receiptId, storeUserID});
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBackend$getAmazonReceiptData$call$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                BackendHelper backendHelper;
                backendHelper = AmazonBackend.this.backendHelper;
                Endpoint.GetAmazonReceipt getAmazonReceipt = new Endpoint.GetAmazonReceipt(storeUserID, receiptId);
                Delay delay = Delay.NONE;
                final AmazonBackend amazonBackend = AmazonBackend.this;
                final List<String> list = listOfNotNull;
                Function1<PurchasesError, Unit> function1 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBackend$getAmazonReceiptData$call$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>> remove;
                        Intrinsics.checkNotNullParameter(error, "error");
                        AmazonBackend amazonBackend2 = AmazonBackend.this;
                        List<String> list2 = list;
                        synchronized (amazonBackend2) {
                            remove = amazonBackend2.getPostAmazonReceiptCallbacks().remove(list2);
                        }
                        if (remove != null) {
                            Iterator<T> it = remove.iterator();
                            while (it.hasNext()) {
                                ((Function1) ((Pair) it.next()).component2()).invoke(error);
                            }
                        }
                    }
                };
                final AmazonBackend amazonBackend2 = AmazonBackend.this;
                final List<String> list2 = listOfNotNull;
                backendHelper.performRequest(getAmazonReceipt, null, null, delay, function1, new Function3<PurchasesError, Integer, JSONObject, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBackend$getAmazonReceiptData$call$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, Integer num, JSONObject jSONObject) {
                        invoke(purchasesError, num.intValue(), jSONObject);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PurchasesError purchasesError, int i, JSONObject body) {
                        List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>> remove;
                        Intrinsics.checkNotNullParameter(body, "body");
                        AmazonBackend amazonBackend3 = AmazonBackend.this;
                        List<String> list3 = list2;
                        synchronized (amazonBackend3) {
                            remove = amazonBackend3.getPostAmazonReceiptCallbacks().remove(list3);
                        }
                        if (remove != null) {
                            Iterator<T> it = remove.iterator();
                            while (it.hasNext()) {
                                Pair pair = (Pair) it.next();
                                Function1 function12 = (Function1) pair.component1();
                                Function1 function13 = (Function1) pair.component2();
                                if (purchasesError != null) {
                                    function13.invoke(purchasesError);
                                } else {
                                    function12.invoke(body);
                                }
                            }
                        }
                    }
                });
            }
        };
        Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>> pair = TuplesKt.to(onSuccess, onError);
        synchronized (this) {
            if (!this.postAmazonReceiptCallbacks.containsKey(listOfNotNull)) {
                this.postAmazonReceiptCallbacks.put(listOfNotNull, CollectionsKt.mutableListOf(pair));
                function0.invoke();
                Unit unit = Unit.INSTANCE;
            } else {
                List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>> list = this.postAmazonReceiptCallbacks.get(listOfNotNull);
                Intrinsics.checkNotNull(list);
                Boolean.valueOf(list.add(pair));
            }
        }
    }
}
