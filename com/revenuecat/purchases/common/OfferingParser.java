package com.revenuecat.purchases.common;

import com.amazon.a.a.o.b;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.strings.OfferingStrings;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: OfferingParser.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bH\u0007J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bJ4\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J,\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\u0011\u001a\u00020\u0006H$¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/common/OfferingParser;", "", "()V", "createOffering", "Lcom/revenuecat/purchases/Offering;", "offeringJson", "Lorg/json/JSONObject;", "productsById", "", "", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "createOfferings", "Lcom/revenuecat/purchases/Offerings;", "offeringsJson", "createPackage", "Lcom/revenuecat/purchases/Package;", "packageJson", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "findMatchingProduct", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public abstract class OfferingParser {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Json json = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.revenuecat.purchases.common.OfferingParser$Companion$json$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setIgnoreUnknownKeys(true);
        }
    }, 1, null);

    protected abstract StoreProduct findMatchingProduct(Map<String, ? extends List<? extends StoreProduct>> productsById, JSONObject packageJson);

    /* compiled from: OfferingParser.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/common/OfferingParser$Companion;", "", "()V", "json", "Lkotlinx/serialization/json/Json;", "getJson$purchases_defaultsRelease$annotations", "getJson$purchases_defaultsRelease", "()Lkotlinx/serialization/json/Json;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getJson$purchases_defaultsRelease$annotations() {
        }

        private Companion() {
        }

        public final Json getJson$purchases_defaultsRelease() {
            return OfferingParser.json;
        }
    }

    public final Offerings createOfferings(JSONObject offeringsJson, Map<String, ? extends List<? extends StoreProduct>> productsById) {
        Intrinsics.checkNotNullParameter(offeringsJson, "offeringsJson");
        Intrinsics.checkNotNullParameter(productsById, "productsById");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(OfferingStrings.BUILDING_OFFERINGS, Arrays.copyOf(new Object[]{Integer.valueOf(productsById.size())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        JSONArray jSONArray = offeringsJson.getJSONArray("offerings");
        String string = offeringsJson.getString("current_offering_id");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject offeringJson = jSONArray.getJSONObject(i);
            Intrinsics.checkNotNullExpressionValue(offeringJson, "offeringJson");
            Offering createOffering = createOffering(offeringJson, productsById);
            if (createOffering != null) {
                linkedHashMap.put(createOffering.getIdentifier(), createOffering);
                if (createOffering.getAvailablePackages().isEmpty()) {
                    String format2 = String.format(OfferingStrings.OFFERING_EMPTY, Arrays.copyOf(new Object[]{createOffering.getIdentifier()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                    LogUtilsKt.warnLog(format2);
                }
            }
        }
        return new Offerings((Offering) linkedHashMap.get(string), linkedHashMap);
    }

    public final Offering createOffering(JSONObject offeringJson, Map<String, ? extends List<? extends StoreProduct>> productsById) {
        Map emptyMap;
        PaywallData paywallData;
        PaywallData paywallData2;
        Intrinsics.checkNotNullParameter(offeringJson, "offeringJson");
        Intrinsics.checkNotNullParameter(productsById, "productsById");
        String offeringIdentifier = offeringJson.getString("identifier");
        JSONObject optJSONObject = offeringJson.optJSONObject(TtmlNode.TAG_METADATA);
        if (optJSONObject == null || (emptyMap = JSONObjectExtensionsKt.toMap(optJSONObject, true)) == null) {
            emptyMap = MapsKt.emptyMap();
        }
        Map map = emptyMap;
        JSONArray jSONArray = offeringJson.getJSONArray("packages");
        Intrinsics.checkNotNullExpressionValue(offeringIdentifier, "offeringIdentifier");
        PresentedOfferingContext presentedOfferingContext = new PresentedOfferingContext(offeringIdentifier);
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject packageJson = jSONArray.getJSONObject(i);
            Intrinsics.checkNotNullExpressionValue(packageJson, "packageJson");
            Package createPackage = createPackage(packageJson, productsById, presentedOfferingContext);
            if (createPackage != null) {
                arrayList.add(createPackage);
            }
        }
        JSONObject optJSONObject2 = offeringJson.optJSONObject("paywall");
        if (optJSONObject2 != null) {
            try {
                Json json2 = json;
                String jSONObject = optJSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "it.toString()");
                KSerializer<Object> serializer = SerializersKt.serializer(json2.getSerializersModule(), Reflection.typeOf(PaywallData.class));
                Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                paywallData = (PaywallData) json2.decodeFromString(serializer, jSONObject);
            } catch (Exception e) {
                LogUtilsKt.errorLog("Error deserializing paywall data", e);
                paywallData = null;
            }
            paywallData2 = paywallData;
        } else {
            paywallData2 = null;
        }
        if (!(!arrayList.isEmpty())) {
            return null;
        }
        String string = offeringJson.getString(b.c);
        Intrinsics.checkNotNullExpressionValue(string, "offeringJson.getString(\"description\")");
        return new Offering(offeringIdentifier, string, map, arrayList, paywallData2);
    }

    public final Package createPackage(JSONObject packageJson, Map<String, ? extends List<? extends StoreProduct>> productsById, PresentedOfferingContext presentedOfferingContext) {
        PackageType packageType;
        Intrinsics.checkNotNullParameter(packageJson, "packageJson");
        Intrinsics.checkNotNullParameter(productsById, "productsById");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        String packageIdentifier = packageJson.getString("identifier");
        StoreProduct findMatchingProduct = findMatchingProduct(productsById, packageJson);
        Intrinsics.checkNotNullExpressionValue(packageIdentifier, "packageIdentifier");
        packageType = OfferingParserKt.toPackageType(packageIdentifier);
        if (findMatchingProduct != null) {
            return new Package(packageIdentifier, packageType, findMatchingProduct.copyWithPresentedOfferingContext(presentedOfferingContext), presentedOfferingContext);
        }
        return null;
    }
}
