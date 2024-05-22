package com.revenuecat.purchases.common.subscriberattributes;

import com.onesignal.core.internal.preferences.PreferenceStores;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpecialSubscriberAttributes.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\f\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !¨\u0006\""}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "", "backendKey", "", "(Ljava/lang/String;)V", "getBackendKey", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "AttributionIds", "CampaignParameters", "Custom", "DeviceIdentifiers", "DisplayName", "Email", "FCMTokens", "IntegrationIds", "PhoneNumber", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$Custom;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$DeviceIdentifiers$AmazonAdID;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$DeviceIdentifiers$AndroidID;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$DeviceIdentifiers$GPSAdID;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$DeviceIdentifiers$IP;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$DisplayName;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$Email;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$FCMTokens;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$PhoneNumber;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public abstract class SubscriberAttributeKey {
    private final String backendKey;

    public /* synthetic */ SubscriberAttributeKey(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private SubscriberAttributeKey(String str) {
        this.backendKey = str;
    }

    public final String getBackendKey() {
        return this.backendKey;
    }

    /* compiled from: SpecialSubscriberAttributes.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$Email;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Email extends SubscriberAttributeKey {
        public static final Email INSTANCE = new Email();

        private Email() {
            super(ReservedSubscriberAttribute.EMAIL.getValue(), null);
        }
    }

    /* compiled from: SpecialSubscriberAttributes.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$DisplayName;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DisplayName extends SubscriberAttributeKey {
        public static final DisplayName INSTANCE = new DisplayName();

        private DisplayName() {
            super(ReservedSubscriberAttribute.DISPLAY_NAME.getValue(), null);
        }
    }

    /* compiled from: SpecialSubscriberAttributes.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$PhoneNumber;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PhoneNumber extends SubscriberAttributeKey {
        public static final PhoneNumber INSTANCE = new PhoneNumber();

        private PhoneNumber() {
            super(ReservedSubscriberAttribute.PHONE_NUMBER.getValue(), null);
        }
    }

    /* compiled from: SpecialSubscriberAttributes.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$FCMTokens;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class FCMTokens extends SubscriberAttributeKey {
        public static final FCMTokens INSTANCE = new FCMTokens();

        private FCMTokens() {
            super(ReservedSubscriberAttribute.FCM_TOKENS.getValue(), null);
        }
    }

    /* compiled from: SpecialSubscriberAttributes.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$Custom;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "value", "", "(Ljava/lang/String;)V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Custom extends SubscriberAttributeKey {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Custom(String value) {
            super(value, null);
            Intrinsics.checkNotNullParameter(value, "value");
        }
    }

    /* compiled from: SpecialSubscriberAttributes.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$DeviceIdentifiers;", "", "()V", "AmazonAdID", "AndroidID", "GPSAdID", "IP", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class DeviceIdentifiers {
        public /* synthetic */ DeviceIdentifiers(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$DeviceIdentifiers$GPSAdID;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class GPSAdID extends SubscriberAttributeKey {
            public static final GPSAdID INSTANCE = new GPSAdID();

            private GPSAdID() {
                super(ReservedSubscriberAttribute.GPS_AD_ID.getValue(), null);
            }
        }

        private DeviceIdentifiers() {
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$DeviceIdentifiers$AndroidID;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class AndroidID extends SubscriberAttributeKey {
            public static final AndroidID INSTANCE = new AndroidID();

            private AndroidID() {
                super(ReservedSubscriberAttribute.ANDROID_ID.getValue(), null);
            }
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$DeviceIdentifiers$IP;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class IP extends SubscriberAttributeKey {
            public static final IP INSTANCE = new IP();

            private IP() {
                super(ReservedSubscriberAttribute.IP.getValue(), null);
            }
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$DeviceIdentifiers$AmazonAdID;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class AmazonAdID extends SubscriberAttributeKey {
            public static final AmazonAdID INSTANCE = new AmazonAdID();

            private AmazonAdID() {
                super(ReservedSubscriberAttribute.AMAZON_AD_ID.getValue(), null);
            }
        }
    }

    /* compiled from: SpecialSubscriberAttributes.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0005\u0006\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u0082\u0001\u0005\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "backendKey", "Lcom/revenuecat/purchases/common/subscriberattributes/ReservedSubscriberAttribute;", "(Lcom/revenuecat/purchases/common/subscriberattributes/ReservedSubscriberAttribute;)V", "Adjust", "AppsFlyer", "CleverTap", "Facebook", "Mparticle", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds$Adjust;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds$AppsFlyer;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds$CleverTap;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds$Facebook;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds$Mparticle;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class AttributionIds extends SubscriberAttributeKey {
        public /* synthetic */ AttributionIds(ReservedSubscriberAttribute reservedSubscriberAttribute, DefaultConstructorMarker defaultConstructorMarker) {
            this(reservedSubscriberAttribute);
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds$Adjust;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Adjust extends AttributionIds {
            public static final Adjust INSTANCE = new Adjust();

            private Adjust() {
                super(ReservedSubscriberAttribute.ADJUST_ID, null);
            }
        }

        private AttributionIds(ReservedSubscriberAttribute reservedSubscriberAttribute) {
            super(reservedSubscriberAttribute.getValue(), null);
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds$AppsFlyer;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class AppsFlyer extends AttributionIds {
            public static final AppsFlyer INSTANCE = new AppsFlyer();

            private AppsFlyer() {
                super(ReservedSubscriberAttribute.APPSFLYER_ID, null);
            }
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds$Facebook;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Facebook extends AttributionIds {
            public static final Facebook INSTANCE = new Facebook();

            private Facebook() {
                super(ReservedSubscriberAttribute.FB_ANON_ID, null);
            }
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds$Mparticle;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Mparticle extends AttributionIds {
            public static final Mparticle INSTANCE = new Mparticle();

            private Mparticle() {
                super(ReservedSubscriberAttribute.MPARTICLE_ID, null);
            }
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds$CleverTap;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class CleverTap extends AttributionIds {
            public static final CleverTap INSTANCE = new CleverTap();

            private CleverTap() {
                super(ReservedSubscriberAttribute.CLEVER_TAP_ID, null);
            }
        }
    }

    /* compiled from: SpecialSubscriberAttributes.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0005\u0006\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u0082\u0001\u0005\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "backendKey", "Lcom/revenuecat/purchases/common/subscriberattributes/ReservedSubscriberAttribute;", "(Lcom/revenuecat/purchases/common/subscriberattributes/ReservedSubscriberAttribute;)V", "Airship", "FirebaseAppInstanceId", "MixpanelDistinctId", PreferenceStores.ONESIGNAL, "OneSignalUserId", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds$Airship;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds$FirebaseAppInstanceId;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds$MixpanelDistinctId;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds$OneSignal;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds$OneSignalUserId;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class IntegrationIds extends SubscriberAttributeKey {
        public /* synthetic */ IntegrationIds(ReservedSubscriberAttribute reservedSubscriberAttribute, DefaultConstructorMarker defaultConstructorMarker) {
            this(reservedSubscriberAttribute);
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds$MixpanelDistinctId;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class MixpanelDistinctId extends IntegrationIds {
            public static final MixpanelDistinctId INSTANCE = new MixpanelDistinctId();

            private MixpanelDistinctId() {
                super(ReservedSubscriberAttribute.MIXPANEL_DISTINCT_ID, null);
            }
        }

        private IntegrationIds(ReservedSubscriberAttribute reservedSubscriberAttribute) {
            super(reservedSubscriberAttribute.getValue(), null);
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds$OneSignal;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class OneSignal extends IntegrationIds {
            public static final OneSignal INSTANCE = new OneSignal();

            private OneSignal() {
                super(ReservedSubscriberAttribute.ONESIGNAL_ID, null);
            }
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds$OneSignalUserId;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class OneSignalUserId extends IntegrationIds {
            public static final OneSignalUserId INSTANCE = new OneSignalUserId();

            private OneSignalUserId() {
                super(ReservedSubscriberAttribute.ONESIGNAL_USER_ID, null);
            }
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds$Airship;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Airship extends IntegrationIds {
            public static final Airship INSTANCE = new Airship();

            private Airship() {
                super(ReservedSubscriberAttribute.AIRSHIP_CHANNEL_ID, null);
            }
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds$FirebaseAppInstanceId;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$IntegrationIds;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class FirebaseAppInstanceId extends IntegrationIds {
            public static final FirebaseAppInstanceId INSTANCE = new FirebaseAppInstanceId();

            private FirebaseAppInstanceId() {
                super(ReservedSubscriberAttribute.FIREBASE_APP_INSTANCE_ID, null);
            }
        }
    }

    /* compiled from: SpecialSubscriberAttributes.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0005\u0006\u0007\b\t\nB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u0082\u0001\u0006\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "backendKey", "Lcom/revenuecat/purchases/common/subscriberattributes/ReservedSubscriberAttribute;", "(Lcom/revenuecat/purchases/common/subscriberattributes/ReservedSubscriberAttribute;)V", "Ad", "AdGroup", "Campaign", "Creative", "Keyword", "MediaSource", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters$Ad;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters$AdGroup;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters$Campaign;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters$Creative;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters$Keyword;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters$MediaSource;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class CampaignParameters extends SubscriberAttributeKey {
        public /* synthetic */ CampaignParameters(ReservedSubscriberAttribute reservedSubscriberAttribute, DefaultConstructorMarker defaultConstructorMarker) {
            this(reservedSubscriberAttribute);
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters$MediaSource;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class MediaSource extends CampaignParameters {
            public static final MediaSource INSTANCE = new MediaSource();

            private MediaSource() {
                super(ReservedSubscriberAttribute.MEDIA_SOURCE, null);
            }
        }

        private CampaignParameters(ReservedSubscriberAttribute reservedSubscriberAttribute) {
            super(reservedSubscriberAttribute.getValue(), null);
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters$Campaign;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Campaign extends CampaignParameters {
            public static final Campaign INSTANCE = new Campaign();

            private Campaign() {
                super(ReservedSubscriberAttribute.CAMPAIGN, null);
            }
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters$AdGroup;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class AdGroup extends CampaignParameters {
            public static final AdGroup INSTANCE = new AdGroup();

            private AdGroup() {
                super(ReservedSubscriberAttribute.AD_GROUP, null);
            }
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters$Ad;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Ad extends CampaignParameters {
            public static final Ad INSTANCE = new Ad();

            private Ad() {
                super(ReservedSubscriberAttribute.AD, null);
            }
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters$Keyword;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Keyword extends CampaignParameters {
            public static final Keyword INSTANCE = new Keyword();

            private Keyword() {
                super(ReservedSubscriberAttribute.KEYWORD, null);
            }
        }

        /* compiled from: SpecialSubscriberAttributes.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters$Creative;", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$CampaignParameters;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creative extends CampaignParameters {
            public static final Creative INSTANCE = new Creative();

            private Creative() {
                super(ReservedSubscriberAttribute.CREATIVE, null);
            }
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey");
        return Intrinsics.areEqual(this.backendKey, ((SubscriberAttributeKey) other).backendKey);
    }

    public int hashCode() {
        return this.backendKey.hashCode();
    }

    public String toString() {
        return "SubscriberAttributeKey('" + this.backendKey + "')";
    }
}
