package com.onesignal.user.internal.subscriptions;

import com.onesignal.common.modeling.ModelChangeTags;
import com.onesignal.common.modeling.SimpleModelStore;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.preferences.IPreferencesService;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionModelStore.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "Lcom/onesignal/common/modeling/SimpleModelStore;", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "replaceAll", "", "models", "", "tag", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public class SubscriptionModelStore extends SimpleModelStore<SubscriptionModel> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionModelStore(IPreferencesService prefs) {
        super(new Function0<SubscriptionModel>() { // from class: com.onesignal.user.internal.subscriptions.SubscriptionModelStore.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SubscriptionModel invoke() {
                return new SubscriptionModel();
            }
        }, "subscriptions", prefs);
        Intrinsics.checkNotNullParameter(prefs, "prefs");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.onesignal.common.modeling.ModelStore, com.onesignal.common.modeling.IModelStore
    public void replaceAll(List<SubscriptionModel> models, String tag) {
        Intrinsics.checkNotNullParameter(models, "models");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!Intrinsics.areEqual(tag, ModelChangeTags.HYDRATE)) {
            super.replaceAll(models, tag);
            return;
        }
        synchronized (models) {
            Iterator<SubscriptionModel> it = models.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SubscriptionModel next = it.next();
                if (next.getType() == SubscriptionType.PUSH) {
                    SubscriptionModel subscriptionModel = (SubscriptionModel) get(next.getId());
                    if (subscriptionModel != null) {
                        next.setSdk(subscriptionModel.getSdk());
                        next.setDeviceOS(subscriptionModel.getDeviceOS());
                        next.setCarrier(subscriptionModel.getCarrier());
                        next.setAppVersion(subscriptionModel.getAppVersion());
                        next.setStatus(subscriptionModel.getStatus());
                    }
                }
            }
            super.replaceAll(models, tag);
            Unit unit = Unit.INSTANCE;
        }
    }
}
