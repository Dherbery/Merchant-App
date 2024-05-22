package com.revenuecat.purchases.paywalls.events;

import com.amplitude.api.Constants;
import com.revenuecat.purchases.common.Backend;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: PaywallBackendEvent.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u0000 E2\u00020\u0001:\u0002DEB\u008d\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014B]\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0015J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\rHÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003Jw\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0005HÆ\u0001J\u0013\u00109\u001a\u00020\u00102\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001J!\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CHÇ\u0001R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u001c\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\u0019R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019R\u001c\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010&R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&¨\u0006F"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallBackendEvent;", "", "seen1", "", "id", "", Constants.AMP_PLAN_VERSION, "type", "appUserID", "sessionID", "offeringID", "paywallRevision", "timestamp", "", "displayMode", "darkMode", "", "localeIdentifier", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;)V", "getAppUserID$annotations", "()V", "getAppUserID", "()Ljava/lang/String;", "getDarkMode$annotations", "getDarkMode", "()Z", "getDisplayMode$annotations", "getDisplayMode", "getId", "getLocaleIdentifier$annotations", "getLocaleIdentifier", "getOfferingID$annotations", "getOfferingID", "getPaywallRevision$annotations", "getPaywallRevision", "()I", "getSessionID$annotations", "getSessionID", "getTimestamp", "()J", "getType", "getVersion", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class PaywallBackendEvent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int PAYWALL_EVENT_SCHEMA_VERSION = 1;
    private final String appUserID;
    private final boolean darkMode;
    private final String displayMode;
    private final String id;
    private final String localeIdentifier;
    private final String offeringID;
    private final int paywallRevision;
    private final String sessionID;
    private final long timestamp;
    private final String type;
    private final int version;

    @SerialName(Backend.APP_USER_ID)
    public static /* synthetic */ void getAppUserID$annotations() {
    }

    @SerialName("dark_mode")
    public static /* synthetic */ void getDarkMode$annotations() {
    }

    @SerialName("display_mode")
    public static /* synthetic */ void getDisplayMode$annotations() {
    }

    @SerialName(com.facebook.hermes.intl.Constants.LOCALE)
    public static /* synthetic */ void getLocaleIdentifier$annotations() {
    }

    @SerialName("offering_id")
    public static /* synthetic */ void getOfferingID$annotations() {
    }

    @SerialName("paywall_revision")
    public static /* synthetic */ void getPaywallRevision$annotations() {
    }

    @SerialName("session_id")
    public static /* synthetic */ void getSessionID$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getDarkMode() {
        return this.darkMode;
    }

    /* renamed from: component11, reason: from getter */
    public final String getLocaleIdentifier() {
        return this.localeIdentifier;
    }

    /* renamed from: component2, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAppUserID() {
        return this.appUserID;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSessionID() {
        return this.sessionID;
    }

    /* renamed from: component6, reason: from getter */
    public final String getOfferingID() {
        return this.offeringID;
    }

    /* renamed from: component7, reason: from getter */
    public final int getPaywallRevision() {
        return this.paywallRevision;
    }

    /* renamed from: component8, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDisplayMode() {
        return this.displayMode;
    }

    public final PaywallBackendEvent copy(String id, int version, String type, String appUserID, String sessionID, String offeringID, int paywallRevision, long timestamp, String displayMode, boolean darkMode, String localeIdentifier) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        Intrinsics.checkNotNullParameter(offeringID, "offeringID");
        Intrinsics.checkNotNullParameter(displayMode, "displayMode");
        Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
        return new PaywallBackendEvent(id, version, type, appUserID, sessionID, offeringID, paywallRevision, timestamp, displayMode, darkMode, localeIdentifier);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaywallBackendEvent)) {
            return false;
        }
        PaywallBackendEvent paywallBackendEvent = (PaywallBackendEvent) other;
        return Intrinsics.areEqual(this.id, paywallBackendEvent.id) && this.version == paywallBackendEvent.version && Intrinsics.areEqual(this.type, paywallBackendEvent.type) && Intrinsics.areEqual(this.appUserID, paywallBackendEvent.appUserID) && Intrinsics.areEqual(this.sessionID, paywallBackendEvent.sessionID) && Intrinsics.areEqual(this.offeringID, paywallBackendEvent.offeringID) && this.paywallRevision == paywallBackendEvent.paywallRevision && this.timestamp == paywallBackendEvent.timestamp && Intrinsics.areEqual(this.displayMode, paywallBackendEvent.displayMode) && this.darkMode == paywallBackendEvent.darkMode && Intrinsics.areEqual(this.localeIdentifier, paywallBackendEvent.localeIdentifier);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((((this.id.hashCode() * 31) + this.version) * 31) + this.type.hashCode()) * 31) + this.appUserID.hashCode()) * 31) + this.sessionID.hashCode()) * 31) + this.offeringID.hashCode()) * 31) + this.paywallRevision) * 31) + UByte$$ExternalSyntheticBackport0.m(this.timestamp)) * 31) + this.displayMode.hashCode()) * 31;
        boolean z = this.darkMode;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + this.localeIdentifier.hashCode();
    }

    public String toString() {
        return "PaywallBackendEvent(id=" + this.id + ", version=" + this.version + ", type=" + this.type + ", appUserID=" + this.appUserID + ", sessionID=" + this.sessionID + ", offeringID=" + this.offeringID + ", paywallRevision=" + this.paywallRevision + ", timestamp=" + this.timestamp + ", displayMode=" + this.displayMode + ", darkMode=" + this.darkMode + ", localeIdentifier=" + this.localeIdentifier + ')';
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PaywallBackendEvent(int i, String str, int i2, String str2, @SerialName("app_user_id") String str3, @SerialName("session_id") String str4, @SerialName("offering_id") String str5, @SerialName("paywall_revision") int i3, long j, @SerialName("display_mode") String str6, @SerialName("dark_mode") boolean z, @SerialName("locale") String str7, SerializationConstructorMarker serializationConstructorMarker) {
        if (2047 != (i & 2047)) {
            PluginExceptionsKt.throwMissingFieldException(i, 2047, PaywallBackendEvent$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.version = i2;
        this.type = str2;
        this.appUserID = str3;
        this.sessionID = str4;
        this.offeringID = str5;
        this.paywallRevision = i3;
        this.timestamp = j;
        this.displayMode = str6;
        this.darkMode = z;
        this.localeIdentifier = str7;
    }

    public PaywallBackendEvent(String id, int i, String type, String appUserID, String sessionID, String offeringID, int i2, long j, String displayMode, boolean z, String localeIdentifier) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        Intrinsics.checkNotNullParameter(offeringID, "offeringID");
        Intrinsics.checkNotNullParameter(displayMode, "displayMode");
        Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
        this.id = id;
        this.version = i;
        this.type = type;
        this.appUserID = appUserID;
        this.sessionID = sessionID;
        this.offeringID = offeringID;
        this.paywallRevision = i2;
        this.timestamp = j;
        this.displayMode = displayMode;
        this.darkMode = z;
        this.localeIdentifier = localeIdentifier;
    }

    @JvmStatic
    public static final void write$Self(PaywallBackendEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeIntElement(serialDesc, 1, self.version);
        output.encodeStringElement(serialDesc, 2, self.type);
        output.encodeStringElement(serialDesc, 3, self.appUserID);
        output.encodeStringElement(serialDesc, 4, self.sessionID);
        output.encodeStringElement(serialDesc, 5, self.offeringID);
        output.encodeIntElement(serialDesc, 6, self.paywallRevision);
        output.encodeLongElement(serialDesc, 7, self.timestamp);
        output.encodeStringElement(serialDesc, 8, self.displayMode);
        output.encodeBooleanElement(serialDesc, 9, self.darkMode);
        output.encodeStringElement(serialDesc, 10, self.localeIdentifier);
    }

    public final String getId() {
        return this.id;
    }

    public final int getVersion() {
        return this.version;
    }

    public final String getType() {
        return this.type;
    }

    public final String getAppUserID() {
        return this.appUserID;
    }

    public final String getSessionID() {
        return this.sessionID;
    }

    public final String getOfferingID() {
        return this.offeringID;
    }

    public final int getPaywallRevision() {
        return this.paywallRevision;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getDisplayMode() {
        return this.displayMode;
    }

    public final boolean getDarkMode() {
        return this.darkMode;
    }

    public final String getLocaleIdentifier() {
        return this.localeIdentifier;
    }

    /* compiled from: PaywallBackendEvent.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallBackendEvent$Companion;", "", "()V", "PAYWALL_EVENT_SCHEMA_VERSION", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallBackendEvent;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PaywallBackendEvent> serializer() {
            return PaywallBackendEvent$$serializer.INSTANCE;
        }
    }
}
