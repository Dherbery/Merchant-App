package com.onesignal.user.internal;

import com.onesignal.common.IDManager;
import com.onesignal.common.OneSignalUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.modeling.ISingletonModelStoreChangeHandler;
import com.onesignal.common.modeling.MapModel;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.IUserManager;
import com.onesignal.user.internal.backend.IdentityConstants;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.internal.subscriptions.SubscriptionList;
import com.onesignal.user.state.IUserStateObserver;
import com.onesignal.user.state.UserChangedState;
import com.onesignal.user.state.UserState;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserManager.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\b\b\u0010\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0016H\u0016J\u001c\u0010/\u001a\u00020,2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0010\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u0016H\u0016J\u0010\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020\u001bH\u0016J\u0010\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020\u0016H\u0016J\u0018\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0016H\u0016J\u001c\u00109\u001a\u00020,2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0014\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0018\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0016H\u0016J\u0018\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020A2\u0006\u0010>\u001a\u00020\u0016H\u0016J\u0010\u0010B\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0016H\u0016J\u0016\u0010C\u001a\u00020,2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00160EH\u0016J\u0010\u0010F\u001a\u00020,2\u0006\u00101\u001a\u00020\u0016H\u0016J\u0010\u0010G\u001a\u00020,2\u0006\u00103\u001a\u00020\u001bH\u0016J\u0010\u0010H\u001a\u00020,2\u0006\u00105\u001a\u00020\u0016H\u0016J\u0010\u0010I\u001a\u00020,2\u0006\u00107\u001a\u00020\u0016H\u0016J\u0016\u0010J\u001a\u00020,2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00160EH\u0016J\u0010\u0010L\u001a\u00020,2\u0006\u00108\u001a\u00020\u0016H\u0016R\u0014\u0010\r\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00158F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006M"}, d2 = {"Lcom/onesignal/user/internal/UserManager;", "Lcom/onesignal/user/IUserManager;", "Lcom/onesignal/common/modeling/ISingletonModelStoreChangeHandler;", "Lcom/onesignal/user/internal/identity/IdentityModel;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "_languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "(Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/core/internal/language/ILanguageContext;)V", "_identityModel", "get_identityModel", "()Lcom/onesignal/user/internal/identity/IdentityModel;", "_propertiesModel", "Lcom/onesignal/user/internal/properties/PropertiesModel;", "get_propertiesModel", "()Lcom/onesignal/user/internal/properties/PropertiesModel;", "aliases", "", "", "getAliases", "()Ljava/util/Map;", "changeHandlersNotifier", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/user/state/IUserStateObserver;", "getChangeHandlersNotifier", "()Lcom/onesignal/common/events/EventProducer;", "externalId", "getExternalId", "()Ljava/lang/String;", "onesignalId", "getOnesignalId", "pushSubscription", "Lcom/onesignal/user/subscriptions/IPushSubscription;", "getPushSubscription", "()Lcom/onesignal/user/subscriptions/IPushSubscription;", "subscriptions", "Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "getSubscriptions", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "addAlias", "", "label", "id", "addAliases", "addEmail", "email", "addObserver", "observer", "addSms", "sms", "addTag", SubscriberAttributeKt.JSON_NAME_KEY, "value", "addTags", "tags", "getTags", "onModelReplaced", "model", "tag", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "removeAlias", "removeAliases", "labels", "", "removeEmail", "removeObserver", "removeSms", "removeTag", "removeTags", "keys", "setLanguage", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public class UserManager implements IUserManager, ISingletonModelStoreChangeHandler<IdentityModel> {
    private final IdentityModelStore _identityModelStore;
    private final ILanguageContext _languageContext;
    private final PropertiesModelStore _propertiesModelStore;
    private final ISubscriptionManager _subscriptionManager;
    private final EventProducer<IUserStateObserver> changeHandlersNotifier;

    @Override // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelReplaced(IdentityModel model, String tag) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    public UserManager(ISubscriptionManager _subscriptionManager, IdentityModelStore _identityModelStore, PropertiesModelStore _propertiesModelStore, ILanguageContext _languageContext) {
        Intrinsics.checkNotNullParameter(_subscriptionManager, "_subscriptionManager");
        Intrinsics.checkNotNullParameter(_identityModelStore, "_identityModelStore");
        Intrinsics.checkNotNullParameter(_propertiesModelStore, "_propertiesModelStore");
        Intrinsics.checkNotNullParameter(_languageContext, "_languageContext");
        this._subscriptionManager = _subscriptionManager;
        this._identityModelStore = _identityModelStore;
        this._propertiesModelStore = _propertiesModelStore;
        this._languageContext = _languageContext;
        this.changeHandlersNotifier = new EventProducer<>();
        _identityModelStore.subscribe((ISingletonModelStoreChangeHandler) this);
    }

    @Override // com.onesignal.user.IUserManager
    public String getOnesignalId() {
        return IDManager.INSTANCE.isLocalId(get_identityModel().getOnesignalId()) ? "" : get_identityModel().getOnesignalId();
    }

    @Override // com.onesignal.user.IUserManager
    public String getExternalId() {
        String externalId = get_identityModel().getExternalId();
        return externalId == null ? "" : externalId;
    }

    public final Map<String, String> getAliases() {
        IdentityModel identityModel = get_identityModel();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : identityModel.entrySet()) {
            if (!Intrinsics.areEqual(entry.getKey(), "id")) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return MapsKt.toMap(linkedHashMap);
    }

    public final SubscriptionList getSubscriptions() {
        return this._subscriptionManager.getSubscriptions();
    }

    public final EventProducer<IUserStateObserver> getChangeHandlersNotifier() {
        return this.changeHandlersNotifier;
    }

    @Override // com.onesignal.user.IUserManager
    public IPushSubscription getPushSubscription() {
        return this._subscriptionManager.getSubscriptions().getPush();
    }

    private final IdentityModel get_identityModel() {
        return this._identityModelStore.getModel();
    }

    private final PropertiesModel get_propertiesModel() {
        return this._propertiesModelStore.getModel();
    }

    @Override // com.onesignal.user.IUserManager
    public void setLanguage(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._languageContext.setLanguage(value);
    }

    @Override // com.onesignal.user.IUserManager
    public void addAlias(String label, String id) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(id, "id");
        Logging.log(LogLevel.DEBUG, "setAlias(label: " + label + ", id: " + id + ')');
        if (label.length() == 0) {
            Logging.log(LogLevel.ERROR, "Cannot add empty alias");
        } else if (Intrinsics.areEqual(label, IdentityConstants.ONESIGNAL_ID)) {
            Logging.log(LogLevel.ERROR, "Cannot add 'onesignal_id' alias");
        } else {
            get_identityModel().put((IdentityModel) label, id);
        }
    }

    @Override // com.onesignal.user.IUserManager
    public void addAliases(Map<String, String> aliases) {
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        Logging.log(LogLevel.DEBUG, "addAliases(aliases: " + aliases);
        for (Map.Entry<String, String> entry : aliases.entrySet()) {
            if (entry.getKey().length() == 0) {
                Logging.log(LogLevel.ERROR, "Cannot add empty alias");
                return;
            } else if (Intrinsics.areEqual(entry.getKey(), IdentityConstants.ONESIGNAL_ID)) {
                Logging.log(LogLevel.ERROR, "Cannot add 'onesignal_id' alias");
                return;
            }
        }
        for (Map.Entry<String, String> entry2 : aliases.entrySet()) {
            get_identityModel().put((IdentityModel) entry2.getKey(), entry2.getValue());
        }
    }

    @Override // com.onesignal.user.IUserManager
    public void removeAlias(String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        Logging.log(LogLevel.DEBUG, "removeAlias(label: " + label + ')');
        if (label.length() == 0) {
            Logging.log(LogLevel.ERROR, "Cannot remove empty alias");
        } else if (Intrinsics.areEqual(label, IdentityConstants.ONESIGNAL_ID)) {
            Logging.log(LogLevel.ERROR, "Cannot remove 'onesignal_id' alias");
        } else {
            get_identityModel().remove((Object) label);
        }
    }

    @Override // com.onesignal.user.IUserManager
    public void removeAliases(Collection<String> labels) {
        Intrinsics.checkNotNullParameter(labels, "labels");
        Logging.log(LogLevel.DEBUG, "removeAliases(labels: " + labels + ')');
        Collection<String> collection = labels;
        for (String str : collection) {
            if (str.length() == 0) {
                Logging.log(LogLevel.ERROR, "Cannot remove empty alias");
                return;
            } else if (Intrinsics.areEqual(str, IdentityConstants.ONESIGNAL_ID)) {
                Logging.log(LogLevel.ERROR, "Cannot remove 'onesignal_id' alias");
                return;
            }
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            get_identityModel().remove(it.next());
        }
    }

    @Override // com.onesignal.user.IUserManager
    public void addEmail(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        Logging.log(LogLevel.DEBUG, "addEmail(email: " + email + ')');
        if (!OneSignalUtils.INSTANCE.isValidEmail(email)) {
            Logging.log(LogLevel.ERROR, "Cannot add invalid email address as subscription: " + email);
            return;
        }
        this._subscriptionManager.addEmailSubscription(email);
    }

    @Override // com.onesignal.user.IUserManager
    public void removeEmail(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        Logging.log(LogLevel.DEBUG, "removeEmail(email: " + email + ')');
        if (!OneSignalUtils.INSTANCE.isValidEmail(email)) {
            Logging.log(LogLevel.ERROR, "Cannot remove invalid email address as subscription: " + email);
            return;
        }
        this._subscriptionManager.removeEmailSubscription(email);
    }

    @Override // com.onesignal.user.IUserManager
    public void addSms(String sms) {
        Intrinsics.checkNotNullParameter(sms, "sms");
        Logging.log(LogLevel.DEBUG, "addSms(sms: " + sms + ')');
        if (!OneSignalUtils.INSTANCE.isValidPhoneNumber(sms)) {
            Logging.log(LogLevel.ERROR, "Cannot add invalid sms number as subscription: " + sms);
            return;
        }
        this._subscriptionManager.addSmsSubscription(sms);
    }

    @Override // com.onesignal.user.IUserManager
    public void removeSms(String sms) {
        Intrinsics.checkNotNullParameter(sms, "sms");
        Logging.log(LogLevel.DEBUG, "removeSms(sms: " + sms + ')');
        if (!OneSignalUtils.INSTANCE.isValidPhoneNumber(sms)) {
            Logging.log(LogLevel.ERROR, "Cannot remove invalid sms number as subscription: " + sms);
            return;
        }
        this._subscriptionManager.removeSmsSubscription(sms);
    }

    @Override // com.onesignal.user.IUserManager
    public void addTag(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Logging.log(LogLevel.DEBUG, "setTag(key: " + key + ", value: " + value + ')');
        if (key.length() == 0) {
            Logging.log(LogLevel.ERROR, "Cannot add tag with empty key");
        } else {
            get_propertiesModel().getTags().put((MapModel<String>) key, value);
        }
    }

    @Override // com.onesignal.user.IUserManager
    public void addTags(Map<String, String> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        Logging.log(LogLevel.DEBUG, "setTags(tags: " + tags + ')');
        Iterator<Map.Entry<String, String>> it = tags.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().length() == 0) {
                Logging.log(LogLevel.ERROR, "Cannot add tag with empty key");
                return;
            }
        }
        for (Map.Entry<String, String> entry : tags.entrySet()) {
            get_propertiesModel().getTags().put((MapModel<String>) entry.getKey(), entry.getValue());
        }
    }

    @Override // com.onesignal.user.IUserManager
    public void removeTag(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Logging.log(LogLevel.DEBUG, "removeTag(key: " + key + ')');
        if (key.length() == 0) {
            Logging.log(LogLevel.ERROR, "Cannot remove tag with empty key");
        } else {
            get_propertiesModel().getTags().remove((Object) key);
        }
    }

    @Override // com.onesignal.user.IUserManager
    public void removeTags(Collection<String> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Logging.log(LogLevel.DEBUG, "removeTags(keys: " + keys + ')');
        Collection<String> collection = keys;
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).length() == 0) {
                Logging.log(LogLevel.ERROR, "Cannot remove tag with empty key");
                return;
            }
        }
        Iterator<T> it2 = collection.iterator();
        while (it2.hasNext()) {
            get_propertiesModel().getTags().remove(it2.next());
        }
    }

    @Override // com.onesignal.user.IUserManager
    public Map<String, String> getTags() {
        return MapsKt.toMap(get_propertiesModel().getTags());
    }

    @Override // com.onesignal.user.IUserManager
    public void addObserver(IUserStateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.changeHandlersNotifier.subscribe(observer);
    }

    @Override // com.onesignal.user.IUserManager
    public void removeObserver(IUserStateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.changeHandlersNotifier.unsubscribe(observer);
    }

    @Override // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs args, String tag) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (Intrinsics.areEqual(args.getProperty(), IdentityConstants.ONESIGNAL_ID)) {
            final UserState userState = new UserState(String.valueOf(args.getNewValue()), getExternalId());
            this.changeHandlersNotifier.fire(new Function1<IUserStateObserver, Unit>() { // from class: com.onesignal.user.internal.UserManager$onModelUpdated$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IUserStateObserver iUserStateObserver) {
                    invoke2(iUserStateObserver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IUserStateObserver it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onUserStateChange(new UserChangedState(UserState.this));
                }
            });
        }
    }
}
