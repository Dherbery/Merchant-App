package com.onesignal.user;

import com.onesignal.core.BuildConfig;
import com.onesignal.user.state.IUserStateObserver;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IUserManager.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u001e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H&J\u001c\u0010\u0010\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012H&J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0003H&J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0003H&J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H&J\u001c\u0010\u001d\u001a\u00020\r2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012H&J\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012H&J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H&J\u0016\u0010!\u001a\u00020\r2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#H&J\u0010\u0010$\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0003H&J\u0010\u0010%\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010&\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010'\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0003H&J\u0016\u0010(\u001a\u00020\r2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030#H&J\u0010\u0010*\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006+"}, d2 = {"Lcom/onesignal/user/IUserManager;", "", "externalId", "", "getExternalId", "()Ljava/lang/String;", "onesignalId", "getOnesignalId", "pushSubscription", "Lcom/onesignal/user/subscriptions/IPushSubscription;", "getPushSubscription", "()Lcom/onesignal/user/subscriptions/IPushSubscription;", "addAlias", "", "label", "id", "addAliases", "aliases", "", "addEmail", "email", "addObserver", "observer", "Lcom/onesignal/user/state/IUserStateObserver;", "addSms", "sms", "addTag", SubscriberAttributeKt.JSON_NAME_KEY, "value", "addTags", "tags", "getTags", "removeAlias", "removeAliases", "labels", "", "removeEmail", "removeObserver", "removeSms", "removeTag", "removeTags", "keys", "setLanguage", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IUserManager {
    void addAlias(String label, String id);

    void addAliases(Map<String, String> aliases);

    void addEmail(String email);

    void addObserver(IUserStateObserver observer);

    void addSms(String sms);

    void addTag(String key, String value);

    void addTags(Map<String, String> tags);

    String getExternalId();

    String getOnesignalId();

    IPushSubscription getPushSubscription();

    Map<String, String> getTags();

    void removeAlias(String label);

    void removeAliases(Collection<String> labels);

    void removeEmail(String email);

    void removeObserver(IUserStateObserver observer);

    void removeSms(String sms);

    void removeTag(String key);

    void removeTags(Collection<String> keys);

    void setLanguage(String value);
}
