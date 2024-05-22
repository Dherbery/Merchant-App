package com.revenuecat.purchases.subscriberattributes;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: SubscriberAttributesPoster.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0082\u0001\u0010\u0005\u001a\u00020\u00062 \u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b0\b2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2B\u0010\r\u001a>\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;", "", "backendHelper", "Lcom/revenuecat/purchases/common/BackendHelper;", "(Lcom/revenuecat/purchases/common/BackendHelper;)V", "postSubscriberAttributes", "", "attributes", "", "", "appUserID", "onSuccessHandler", "Lkotlin/Function0;", "onErrorHandler", "Lkotlin/Function3;", "Lcom/revenuecat/purchases/PurchasesError;", "", "Lkotlin/ParameterName;", "name", "didBackendGetAttributes", "", "Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "attributeErrors", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriberAttributesPoster {
    private final BackendHelper backendHelper;

    public SubscriberAttributesPoster(BackendHelper backendHelper) {
        Intrinsics.checkNotNullParameter(backendHelper, "backendHelper");
        this.backendHelper = backendHelper;
    }

    public final void postSubscriberAttributes(Map<String, ? extends Map<String, ? extends Object>> attributes, String appUserID, final Function0<Unit> onSuccessHandler, final Function3<? super PurchasesError, ? super Boolean, ? super List<SubscriberAttributeError>, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        this.backendHelper.performRequest(new Endpoint.PostAttributes(appUserID), MapsKt.mapOf(TuplesKt.to("attributes", attributes)), null, Delay.DEFAULT, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster$postSubscriberAttributes$1
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
                onErrorHandler.invoke(error, false, CollectionsKt.emptyList());
            }
        }, new Function3<PurchasesError, Integer, JSONObject, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster$postSubscriberAttributes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, Integer num, JSONObject jSONObject) {
                invoke(purchasesError, num.intValue(), jSONObject);
                return Unit.INSTANCE;
            }

            public final void invoke(PurchasesError purchasesError, int i, JSONObject body) {
                Unit unit;
                Intrinsics.checkNotNullParameter(body, "body");
                if (purchasesError != null) {
                    Function3<PurchasesError, Boolean, List<SubscriberAttributeError>, Unit> function3 = onErrorHandler;
                    boolean z = (RCHTTPStatusCodes.INSTANCE.isServerError(i) || (i == 404)) ? false : true;
                    List<SubscriberAttributeError> emptyList = CollectionsKt.emptyList();
                    if (purchasesError.getCode() == PurchasesErrorCode.InvalidSubscriberAttributesError) {
                        emptyList = BackendHelpersKt.getAttributeErrors(body);
                    }
                    function3.invoke(purchasesError, Boolean.valueOf(z), emptyList);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    onSuccessHandler.invoke();
                }
            }
        });
    }
}
