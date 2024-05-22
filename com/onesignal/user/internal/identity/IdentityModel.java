package com.onesignal.user.internal.identity;

import com.onesignal.common.modeling.MapModel;
import com.onesignal.common.modeling.Model;
import com.onesignal.core.BuildConfig;
import com.onesignal.user.internal.backend.IdentityConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdentityModel.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003R(\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/onesignal/user/internal/identity/IdentityModel;", "Lcom/onesignal/common/modeling/MapModel;", "", "()V", "value", "externalId", "getExternalId", "()Ljava/lang/String;", "setExternalId", "(Ljava/lang/String;)V", "onesignalId", "getOnesignalId", "setOnesignalId", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class IdentityModel extends MapModel<String> {
    public IdentityModel() {
        super(null, null, 3, null);
    }

    @Override // com.onesignal.common.modeling.MapModel, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof String) {
            return containsValue((String) obj);
        }
        return false;
    }

    public /* bridge */ boolean containsValue(String str) {
        return super.containsValue((IdentityModel) str);
    }

    @Override // com.onesignal.common.modeling.MapModel, java.util.Map
    public final /* bridge */ String get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    @Override // com.onesignal.common.modeling.MapModel
    public /* bridge */ String get(String str) {
        return (String) super.get(str);
    }

    public final /* bridge */ String getOrDefault(Object obj, String str) {
        return !(obj instanceof String) ? str : getOrDefault((String) obj, str);
    }

    public /* bridge */ String getOrDefault(String str, String str2) {
        return (String) super.getOrDefault((Object) str, str2);
    }

    @Override // com.onesignal.common.modeling.MapModel, java.util.Map
    public final /* bridge */ String remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // com.onesignal.common.modeling.MapModel
    public /* bridge */ String remove(String str) {
        return (String) super.remove(str);
    }

    public final String getOnesignalId() {
        return Model.getStringProperty$default(this, IdentityConstants.ONESIGNAL_ID, null, 2, null);
    }

    public final void setOnesignalId(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Model.setStringProperty$default(this, IdentityConstants.ONESIGNAL_ID, value, null, false, 12, null);
    }

    public final String getExternalId() {
        return Model.getOptStringProperty$default(this, IdentityConstants.EXTERNAL_ID, null, 2, null);
    }

    public final void setExternalId(String str) {
        Model.setOptStringProperty$default(this, IdentityConstants.EXTERNAL_ID, str, null, false, 12, null);
    }
}
