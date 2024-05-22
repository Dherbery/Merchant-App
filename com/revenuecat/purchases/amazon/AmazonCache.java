package com.revenuecat.purchases.amazon;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AmazonCache.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u001a\u0010\u000e\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010J\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010R\u001b\u0010\u0005\u001a\u00020\u00068@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/amazon/AmazonCache;", "", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;)V", "amazonPostedTokensKey", "", "getAmazonPostedTokensKey$purchases_defaultsRelease", "()Ljava/lang/String;", "amazonPostedTokensKey$delegate", "Lkotlin/Lazy;", "addSuccessfullyPostedToken", "", "token", "cacheSkusByToken", "receiptsToSkus", "", "getReceiptSkus", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class AmazonCache {

    /* renamed from: amazonPostedTokensKey$delegate, reason: from kotlin metadata */
    private final Lazy amazonPostedTokensKey;
    private final DeviceCache deviceCache;

    public AmazonCache(DeviceCache deviceCache) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        this.deviceCache = deviceCache;
        this.amazonPostedTokensKey = LazyKt.lazy(new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonCache$amazonPostedTokensKey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                DeviceCache deviceCache2;
                deviceCache2 = AmazonCache.this.deviceCache;
                return deviceCache2.newKey("amazon.tokens");
            }
        });
    }

    public final String getAmazonPostedTokensKey$purchases_defaultsRelease() {
        return (String) this.amazonPostedTokensKey.getValue();
    }

    public final synchronized void cacheSkusByToken(Map<String, String> receiptsToSkus) {
        Intrinsics.checkNotNullParameter(receiptsToSkus, "receiptsToSkus");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AmazonStrings.CACHING_RECEIPT_TERM_SKUS, Arrays.copyOf(new Object[]{receiptsToSkus}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        JSONObject jSONObject = new JSONObject(MapsKt.plus(getReceiptSkus(), receiptsToSkus));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("receiptsToSkus", jSONObject);
        DeviceCache deviceCache = this.deviceCache;
        String amazonPostedTokensKey$purchases_defaultsRelease = getAmazonPostedTokensKey$purchases_defaultsRelease();
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonToCache.toString()");
        deviceCache.putString(amazonPostedTokensKey$purchases_defaultsRelease, jSONObject3);
    }

    public final synchronized Map<String, String> getReceiptSkus() {
        Map<String, String> emptyMap;
        JSONObject jSONObjectOrNull = this.deviceCache.getJSONObjectOrNull(getAmazonPostedTokensKey$purchases_defaultsRelease());
        JSONObject jSONObject = jSONObjectOrNull != null ? jSONObjectOrNull.getJSONObject("receiptsToSkus") : null;
        if (jSONObject == null || (emptyMap = JSONObjectExtensionsKt.toMap$default(jSONObject, false, 1, null)) == null) {
            emptyMap = MapsKt.emptyMap();
        }
        return emptyMap;
    }

    public final synchronized void addSuccessfullyPostedToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.deviceCache.addSuccessfullyPostedToken(token);
    }
}
