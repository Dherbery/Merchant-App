package com.onesignal.user.internal.identity;

import com.facebook.react.animated.InterpolationAnimatedNode;
import com.onesignal.common.modeling.SimpleModelStore;
import com.onesignal.common.modeling.SingletonModelStore;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.preferences.IPreferencesService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdentityModelStore.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/onesignal/user/internal/identity/IdentityModelStore;", "Lcom/onesignal/common/modeling/SingletonModelStore;", "Lcom/onesignal/user/internal/identity/IdentityModel;", "prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public class IdentityModelStore extends SingletonModelStore<IdentityModel> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdentityModelStore(IPreferencesService prefs) {
        super(new SimpleModelStore(new Function0<IdentityModel>() { // from class: com.onesignal.user.internal.identity.IdentityModelStore.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IdentityModel invoke() {
                return new IdentityModel();
            }
        }, InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY, prefs));
        Intrinsics.checkNotNullParameter(prefs, "prefs");
    }
}
