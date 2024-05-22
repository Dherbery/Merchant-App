package com.onesignal.user.internal.backend.impl;

import com.amplitude.api.Constants;
import com.facebook.react.animated.InterpolationAnimatedNode;
import com.facebook.react.uimanager.ViewProps;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.core.BuildConfig;
import com.onesignal.user.internal.backend.CreateUserResponse;
import com.onesignal.user.internal.backend.PropertiesDeltasObject;
import com.onesignal.user.internal.backend.PropertiesObject;
import com.onesignal.user.internal.backend.PurchaseObject;
import com.onesignal.user.internal.backend.SubscriptionObject;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JSONConverter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u0007\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010¨\u0006\u0011"}, d2 = {"Lcom/onesignal/user/internal/backend/impl/JSONConverter;", "", "()V", "convertToCreateUserResponse", "Lcom/onesignal/user/internal/backend/CreateUserResponse;", "jsonObject", "Lorg/json/JSONObject;", "convertToJSON", "propertiesDeltas", "Lcom/onesignal/user/internal/backend/PropertiesDeltasObject;", DiagnosticsEntry.Event.PROPERTIES_KEY, "Lcom/onesignal/user/internal/backend/PropertiesObject;", "subscription", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "Lorg/json/JSONArray;", "subscriptions", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class JSONConverter {
    public static final JSONConverter INSTANCE = new JSONConverter();

    private JSONConverter() {
    }

    public final CreateUserResponse convertToCreateUserResponse(JSONObject jsonObject) {
        LinkedHashMap emptyMap;
        LinkedHashMap linkedHashMap;
        JSONObject safeJSONObject;
        Map<String, Object> map;
        Map<String, Object> map2;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        JSONObject safeJSONObject2 = JSONObjectExtensionsKt.safeJSONObject(jsonObject, InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        if (safeJSONObject2 == null || (map2 = JSONObjectExtensionsKt.toMap(safeJSONObject2)) == null) {
            emptyMap = MapsKt.emptyMap();
        } else {
            emptyMap = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
            Iterator<T> it = map2.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                emptyMap.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        JSONObject safeJSONObject3 = JSONObjectExtensionsKt.safeJSONObject(jsonObject, DiagnosticsEntry.Event.PROPERTIES_KEY);
        if (safeJSONObject3 == null || (safeJSONObject = JSONObjectExtensionsKt.safeJSONObject(safeJSONObject3, "tags")) == null || (map = JSONObjectExtensionsKt.toMap(safeJSONObject)) == null) {
            linkedHashMap = null;
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            Iterator<T> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it2.next();
                linkedHashMap2.put(entry2.getKey(), String.valueOf(entry2.getValue()));
            }
            linkedHashMap = linkedHashMap2;
        }
        return new CreateUserResponse(emptyMap, new PropertiesObject(linkedHashMap, safeJSONObject3 != null ? JSONObjectExtensionsKt.safeString(safeJSONObject3, Constants.AMP_TRACKING_OPTION_LANGUAGE) : null, safeJSONObject3 != null ? JSONObjectExtensionsKt.safeString(safeJSONObject3, "timezone_id") : null, safeJSONObject3 != null ? JSONObjectExtensionsKt.safeString(safeJSONObject3, Constants.AMP_TRACKING_OPTION_COUNTRY) : null, safeJSONObject3 != null ? JSONObjectExtensionsKt.safeDouble(safeJSONObject3, "lat") : null, safeJSONObject3 != null ? JSONObjectExtensionsKt.safeDouble(safeJSONObject3, "long") : null), JSONObjectExtensionsKt.expandJSONArray(jsonObject, "subscriptions", new Function1<JSONObject, SubscriptionObject>() { // from class: com.onesignal.user.internal.backend.impl.JSONConverter$convertToCreateUserResponse$respSubscriptions$1
            @Override // kotlin.jvm.functions.Function1
            public final SubscriptionObject invoke(JSONObject it3) {
                Intrinsics.checkNotNullParameter(it3, "it");
                SubscriptionObjectType.Companion companion = SubscriptionObjectType.INSTANCE;
                String string = it3.getString("type");
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(\"type\")");
                SubscriptionObjectType fromString = companion.fromString(string);
                if (fromString != null) {
                    return new SubscriptionObject(it3.getString("id"), fromString, JSONObjectExtensionsKt.safeString(it3, "token"), JSONObjectExtensionsKt.safeBool(it3, ViewProps.ENABLED), JSONObjectExtensionsKt.safeInt(it3, "notification_types"), JSONObjectExtensionsKt.safeString(it3, "sdk"), JSONObjectExtensionsKt.safeString(it3, Constants.AMP_TRACKING_OPTION_DEVICE_MODEL), JSONObjectExtensionsKt.safeString(it3, "device_os"), JSONObjectExtensionsKt.safeBool(it3, "rooted"), JSONObjectExtensionsKt.safeInt(it3, "net_type"), JSONObjectExtensionsKt.safeString(it3, Constants.AMP_TRACKING_OPTION_CARRIER), JSONObjectExtensionsKt.safeString(it3, "app_version"));
                }
                return null;
            }
        }));
    }

    public final JSONObject convertToJSON(PropertiesObject properties) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        return JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putMap(new JSONObject(), "tags", properties.getTags()), Constants.AMP_TRACKING_OPTION_LANGUAGE, properties.getLanguage()), "timezone_id", properties.getTimezoneId()), "lat", properties.getLatitude()), "long", properties.getLongitude()), Constants.AMP_TRACKING_OPTION_COUNTRY, properties.getCountry());
    }

    public final JSONObject convertToJSON(PropertiesDeltasObject propertiesDeltas) {
        Intrinsics.checkNotNullParameter(propertiesDeltas, "propertiesDeltas");
        JSONObject putSafe = JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(new JSONObject(), "session_time", propertiesDeltas.getSessionTime()), "session_count", propertiesDeltas.getSessionCount());
        BigDecimal amountSpent = propertiesDeltas.getAmountSpent();
        return JSONObjectExtensionsKt.putJSONArray(JSONObjectExtensionsKt.putSafe(putSafe, "amount_spent", amountSpent != null ? amountSpent.toString() : null), "purchases", propertiesDeltas.getPurchases(), new Function1<PurchaseObject, JSONObject>() { // from class: com.onesignal.user.internal.backend.impl.JSONConverter$convertToJSON$1
            @Override // kotlin.jvm.functions.Function1
            public final JSONObject invoke(PurchaseObject it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new JSONObject().put("sku", it.getSku()).put("iso", it.getIso()).put("amount", it.getAmount().toString());
            }
        });
    }

    public final JSONArray convertToJSON(List<SubscriptionObject> subscriptions) {
        Intrinsics.checkNotNullParameter(subscriptions, "subscriptions");
        JSONArray jSONArray = new JSONArray();
        Iterator<SubscriptionObject> it = subscriptions.iterator();
        while (it.hasNext()) {
            jSONArray.put(convertToJSON(it.next()));
        }
        return jSONArray;
    }

    public final JSONObject convertToJSON(SubscriptionObject subscription) {
        Intrinsics.checkNotNullParameter(subscription, "subscription");
        JSONObject putSafe = JSONObjectExtensionsKt.putSafe(new JSONObject(), "id", subscription.getId());
        SubscriptionObjectType type = subscription.getType();
        return JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(putSafe, "type", type != null ? type.getValue() : null), "token", subscription.getToken()), ViewProps.ENABLED, subscription.getEnabled()), "notification_types", subscription.getNotificationTypes()), "sdk", subscription.getSdk()), Constants.AMP_TRACKING_OPTION_DEVICE_MODEL, subscription.getDeviceModel()), "device_os", subscription.getDeviceOS()), "rooted", subscription.getRooted()), "net_type", subscription.getNetType()), Constants.AMP_TRACKING_OPTION_CARRIER, subscription.getCarrier()), "app_version", subscription.getAppVersion());
    }
}
