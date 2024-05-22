package com.onesignal.user.internal.backend;

import com.onesignal.core.BuildConfig;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IUserBackendService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/onesignal/user/internal/backend/CreateUserResponse;", "", "identities", "", "", DiagnosticsEntry.Event.PROPERTIES_KEY, "Lcom/onesignal/user/internal/backend/PropertiesObject;", "subscriptions", "", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "(Ljava/util/Map;Lcom/onesignal/user/internal/backend/PropertiesObject;Ljava/util/List;)V", "getIdentities", "()Ljava/util/Map;", "getProperties", "()Lcom/onesignal/user/internal/backend/PropertiesObject;", "getSubscriptions", "()Ljava/util/List;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class CreateUserResponse {
    private final Map<String, String> identities;
    private final PropertiesObject properties;
    private final List<SubscriptionObject> subscriptions;

    public CreateUserResponse(Map<String, String> identities, PropertiesObject properties, List<SubscriptionObject> subscriptions) {
        Intrinsics.checkNotNullParameter(identities, "identities");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(subscriptions, "subscriptions");
        this.identities = identities;
        this.properties = properties;
        this.subscriptions = subscriptions;
    }

    public final Map<String, String> getIdentities() {
        return this.identities;
    }

    public final PropertiesObject getProperties() {
        return this.properties;
    }

    public final List<SubscriptionObject> getSubscriptions() {
        return this.subscriptions;
    }
}
