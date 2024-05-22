package com.revenuecat.purchases.common.subscriberattributes;

import kotlin.Metadata;

/* compiled from: SpecialSubscriberAttributes.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/ReservedSubscriberAttribute;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "EMAIL", "DISPLAY_NAME", "PHONE_NUMBER", "FCM_TOKENS", "IDFA", "IDFV", "IP", "GPS_AD_ID", "ANDROID_ID", "AMAZON_AD_ID", "ADJUST_ID", "APPSFLYER_ID", "FB_ANON_ID", "MPARTICLE_ID", "ONESIGNAL_ID", "ONESIGNAL_USER_ID", "AIRSHIP_CHANNEL_ID", "CLEVER_TAP_ID", "MIXPANEL_DISTINCT_ID", "FIREBASE_APP_INSTANCE_ID", "MEDIA_SOURCE", "CAMPAIGN", "AD_GROUP", "AD", "KEYWORD", "CREATIVE", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public enum ReservedSubscriberAttribute {
    EMAIL("$email"),
    DISPLAY_NAME("$displayName"),
    PHONE_NUMBER("$phoneNumber"),
    FCM_TOKENS("$fcmTokens"),
    IDFA("$idfa"),
    IDFV("$idfv"),
    IP("$ip"),
    GPS_AD_ID("$gpsAdId"),
    ANDROID_ID("$androidId"),
    AMAZON_AD_ID("$amazonAdId"),
    ADJUST_ID("$adjustId"),
    APPSFLYER_ID("$appsflyerId"),
    FB_ANON_ID("$fbAnonId"),
    MPARTICLE_ID("$mparticleId"),
    ONESIGNAL_ID("$onesignalId"),
    ONESIGNAL_USER_ID("$onesignalUserId"),
    AIRSHIP_CHANNEL_ID("$airshipChannelId"),
    CLEVER_TAP_ID("$clevertapId"),
    MIXPANEL_DISTINCT_ID("$mixpanelDistinctId"),
    FIREBASE_APP_INSTANCE_ID("$firebaseAppInstanceId"),
    MEDIA_SOURCE("$mediaSource"),
    CAMPAIGN("$campaign"),
    AD_GROUP("$adGroup"),
    AD("$ad"),
    KEYWORD("$keyword"),
    CREATIVE("$creative");

    private final String value;

    ReservedSubscriberAttribute(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
