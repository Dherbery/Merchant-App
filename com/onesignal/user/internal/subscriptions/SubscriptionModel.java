package com.onesignal.user.internal.subscriptions;

import com.amplitude.api.Constants;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangeTags;
import com.onesignal.core.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "Lcom/onesignal/common/modeling/Model;", "()V", "value", "", "address", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "appVersion", "getAppVersion", "setAppVersion", Constants.AMP_TRACKING_OPTION_CARRIER, "getCarrier", "setCarrier", "deviceOS", "getDeviceOS", "setDeviceOS", "", "optedIn", "getOptedIn", "()Z", "setOptedIn", "(Z)V", "sdk", "getSdk", "setSdk", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "status", "getStatus", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "setStatus", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;)V", "Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "type", "getType", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "setType", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionType;)V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionModel extends Model {
    public SubscriptionModel() {
        super(null, null, 3, null);
    }

    public final boolean getOptedIn() {
        return Model.getBooleanProperty$default(this, "optedIn", null, 2, null);
    }

    public final void setOptedIn(boolean z) {
        Model.setBooleanProperty$default(this, "optedIn", z, null, false, 12, null);
    }

    public final SubscriptionType getType() {
        Enum r3 = null;
        Object optAnyProperty$default = Model.getOptAnyProperty$default(this, "type", null, 2, null);
        if (optAnyProperty$default != null) {
            if (optAnyProperty$default instanceof SubscriptionType) {
                r3 = (Enum) optAnyProperty$default;
            } else if (optAnyProperty$default instanceof String) {
                r3 = SubscriptionType.valueOf((String) optAnyProperty$default);
            } else {
                if (optAnyProperty$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionType");
                }
                r3 = (SubscriptionType) optAnyProperty$default;
            }
        }
        if (r3 != null) {
            return (SubscriptionType) r3;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionType");
    }

    public final String getAddress() {
        return Model.getStringProperty$default(this, "address", null, 2, null);
    }

    public final void setAddress(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Model.setStringProperty$default(this, "address", value, null, false, 12, null);
    }

    public final SubscriptionStatus getStatus() {
        Enum r2 = null;
        if (!hasProperty("status")) {
            SubscriptionStatus subscriptionStatus = SubscriptionStatus.SUBSCRIBED;
            setOptAnyProperty("status", subscriptionStatus != null ? subscriptionStatus.toString() : null, ModelChangeTags.NORMAL, false);
        }
        Object optAnyProperty$default = Model.getOptAnyProperty$default(this, "status", null, 2, null);
        if (optAnyProperty$default != null) {
            if (optAnyProperty$default instanceof SubscriptionStatus) {
                r2 = (Enum) optAnyProperty$default;
            } else if (optAnyProperty$default instanceof String) {
                r2 = SubscriptionStatus.valueOf((String) optAnyProperty$default);
            } else {
                if (optAnyProperty$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionStatus");
                }
                r2 = (SubscriptionStatus) optAnyProperty$default;
            }
        }
        if (r2 != null) {
            return (SubscriptionStatus) r2;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionStatus");
    }

    public final String getSdk() {
        return getStringProperty("sdk", new Function0<String>() { // from class: com.onesignal.user.internal.subscriptions.SubscriptionModel$sdk$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "";
            }
        });
    }

    public final void setSdk(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Model.setStringProperty$default(this, "sdk", value, null, false, 12, null);
    }

    public final String getDeviceOS() {
        return getStringProperty("deviceOS", new Function0<String>() { // from class: com.onesignal.user.internal.subscriptions.SubscriptionModel$deviceOS$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "";
            }
        });
    }

    public final void setDeviceOS(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Model.setStringProperty$default(this, "deviceOS", value, null, false, 12, null);
    }

    public final String getCarrier() {
        return getStringProperty(Constants.AMP_TRACKING_OPTION_CARRIER, new Function0<String>() { // from class: com.onesignal.user.internal.subscriptions.SubscriptionModel$carrier$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "";
            }
        });
    }

    public final void setCarrier(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Model.setStringProperty$default(this, Constants.AMP_TRACKING_OPTION_CARRIER, value, null, false, 12, null);
    }

    public final String getAppVersion() {
        return getStringProperty("appVersion", new Function0<String>() { // from class: com.onesignal.user.internal.subscriptions.SubscriptionModel$appVersion$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "";
            }
        });
    }

    public final void setAppVersion(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Model.setStringProperty$default(this, "appVersion", value, null, false, 12, null);
    }

    public final void setType(SubscriptionType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        setOptAnyProperty("type", value.toString(), ModelChangeTags.NORMAL, false);
    }

    public final void setStatus(SubscriptionStatus value) {
        Intrinsics.checkNotNullParameter(value, "value");
        setOptAnyProperty("status", value.toString(), ModelChangeTags.NORMAL, false);
    }
}
