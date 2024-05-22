package com.onesignal.inAppMessages.internal.triggers;

import com.onesignal.common.modeling.SimpleModelStore;
import com.onesignal.inAppMessages.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: TriggerModelStore.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/TriggerModelStore;", "Lcom/onesignal/common/modeling/SimpleModelStore;", "Lcom/onesignal/inAppMessages/internal/triggers/TriggerModel;", "()V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public class TriggerModelStore extends SimpleModelStore<TriggerModel> {
    public TriggerModelStore() {
        super(new Function0<TriggerModel>() { // from class: com.onesignal.inAppMessages.internal.triggers.TriggerModelStore.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TriggerModel invoke() {
                return new TriggerModel();
            }
        }, null, null, 6, null);
    }
}
