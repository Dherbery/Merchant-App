package com.onesignal.internal;

import android.os.Build;
import com.amazon.a.a.o.b;
import com.onesignal.IOneSignal;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.DeviceUtils;
import com.onesignal.common.IDManager;
import com.onesignal.common.OneSignalUtils;
import com.onesignal.common.modeling.IModelStore;
import com.onesignal.common.modeling.ISingletonModelStore;
import com.onesignal.common.modeling.ModelChangeTags;
import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.IServiceProvider;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.common.services.ServiceProvider;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.CoreModule;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.startup.StartupService;
import com.onesignal.debug.IDebugManager;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.DebugManager;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.onesignal.location.ILocationManager;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.session.ISessionManager;
import com.onesignal.session.SessionModule;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import com.onesignal.session.internal.session.SessionModel;
import com.onesignal.user.IUserManager;
import com.onesignal.user.UserModule;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.LoginUserOperation;
import com.onesignal.user.internal.operations.TransferSubscriptionOperation;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: OneSignalImp.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003JN\u0010O\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020\u00052:\b\u0002\u0010R\u001a4\u0012\u0013\u0012\u00110T¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(W\u0012\u0013\u0012\u00110X¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(Y\u0012\u0004\u0012\u00020P\u0018\u00010SH\u0002J\"\u0010Z\u001a\b\u0012\u0004\u0012\u0002H[0/\"\u0004\b\u0000\u0010[2\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002H[0]H\u0016J!\u0010^\u001a\u0002H[\"\u0004\b\u0000\u0010[2\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002H[0]H\u0016¢\u0006\u0002\u0010_J#\u0010`\u001a\u0004\u0018\u0001H[\"\u0004\b\u0000\u0010[2\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002H[0]H\u0016¢\u0006\u0002\u0010_J\u001c\u0010a\u001a\u00020\u0005\"\u0004\b\u0000\u0010[2\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002H[0]H\u0016J\u001a\u0010b\u001a\u00020\u00052\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u000100H\u0016J\u001a\u0010f\u001a\u00020P2\u0006\u0010g\u001a\u0002002\b\u0010h\u001a\u0004\u0018\u000100H\u0016J\b\u0010i\u001a\u00020PH\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u000200X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010N¨\u0006j"}, d2 = {"Lcom/onesignal/internal/OneSignalImp;", "Lcom/onesignal/IOneSignal;", "Lcom/onesignal/common/services/IServiceProvider;", "()V", "_consentGiven", "", "Ljava/lang/Boolean;", "_consentRequired", "_disableGMSMissingPrompt", "_location", "Lcom/onesignal/location/ILocationManager;", "_notifications", "Lcom/onesignal/notifications/INotificationsManager;", "_session", "Lcom/onesignal/session/ISessionManager;", "_user", "Lcom/onesignal/user/IUserManager;", "configModel", "Lcom/onesignal/core/internal/config/ConfigModel;", "value", "consentGiven", "getConsentGiven", "()Z", "setConsentGiven", "(Z)V", "consentRequired", "getConsentRequired", "setConsentRequired", b.ao, "Lcom/onesignal/debug/IDebugManager;", "getDebug", "()Lcom/onesignal/debug/IDebugManager;", "disableGMSMissingPrompt", "getDisableGMSMissingPrompt", "setDisableGMSMissingPrompt", "iam", "Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "inAppMessages", "getInAppMessages", "()Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "initLock", "", "isInitialized", "setInitialized", "listOfModules", "", "", "location", "getLocation", "()Lcom/onesignal/location/ILocationManager;", "loginLock", "notifications", "getNotifications", "()Lcom/onesignal/notifications/INotificationsManager;", "operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "preferencesService", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", b.I, "getSdkVersion", "()Ljava/lang/String;", "services", "Lcom/onesignal/common/services/ServiceProvider;", OutcomeEventsTable.COLUMN_NAME_SESSION, "getSession", "()Lcom/onesignal/session/ISessionManager;", "sessionModel", "Lcom/onesignal/session/internal/session/SessionModel;", "startupService", "Lcom/onesignal/core/internal/startup/StartupService;", "subscriptionModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "user", "getUser", "()Lcom/onesignal/user/IUserManager;", "createAndSwitchToNewUser", "", "suppressBackendOperation", "modify", "Lkotlin/Function2;", "Lcom/onesignal/user/internal/identity/IdentityModel;", "Lkotlin/ParameterName;", "name", "identityModel", "Lcom/onesignal/user/internal/properties/PropertiesModel;", "propertiesModel", "getAllServices", "T", "c", "Ljava/lang/Class;", "getService", "(Ljava/lang/Class;)Ljava/lang/Object;", "getServiceOrNull", "hasService", "initWithContext", "context", "Landroid/content/Context;", "appId", "login", "externalId", "jwtBearerToken", "logout", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OneSignalImp implements IOneSignal, IServiceProvider {
    private Boolean _consentGiven;
    private Boolean _consentRequired;
    private Boolean _disableGMSMissingPrompt;
    private ILocationManager _location;
    private INotificationsManager _notifications;
    private ISessionManager _session;
    private IUserManager _user;
    private ConfigModel configModel;
    private IInAppMessagesManager iam;
    private IdentityModelStore identityModelStore;
    private boolean isInitialized;
    private final List<String> listOfModules;
    private IOperationRepo operationRepo;
    private IPreferencesService preferencesService;
    private PropertiesModelStore propertiesModelStore;
    private final ServiceProvider services;
    private SessionModel sessionModel;
    private StartupService startupService;
    private SubscriptionModelStore subscriptionModelStore;
    private final String sdkVersion = OneSignalUtils.SDK_VERSION;
    private final IDebugManager debug = new DebugManager();
    private final Object initLock = new Object();
    private final Object loginLock = new Object();

    public OneSignalImp() {
        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{"com.onesignal.notifications.NotificationsModule", "com.onesignal.inAppMessages.InAppMessagesModule", "com.onesignal.location.LocationModule"});
        this.listOfModules = listOf;
        ServiceBuilder serviceBuilder = new ServiceBuilder();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CoreModule());
        arrayList.add(new SessionModule());
        arrayList.add(new UserModule());
        Iterator<String> it = listOf.iterator();
        while (it.hasNext()) {
            try {
                Object newInstance = Class.forName(it.next()).newInstance();
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.onesignal.common.modules.IModule");
                arrayList.add((IModule) newInstance);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((IModule) it2.next()).register(serviceBuilder);
        }
        this.services = serviceBuilder.build();
    }

    @Override // com.onesignal.IOneSignal
    public void login(String str) {
        IOneSignal.DefaultImpls.login(this, str);
    }

    @Override // com.onesignal.IOneSignal
    public String getSdkVersion() {
        return this.sdkVersion;
    }

    @Override // com.onesignal.IOneSignal
    /* renamed from: isInitialized, reason: from getter */
    public boolean getIsInitialized() {
        return this.isInitialized;
    }

    public void setInitialized(boolean z) {
        this.isInitialized = z;
    }

    @Override // com.onesignal.IOneSignal
    public boolean getConsentRequired() {
        Boolean consentRequired;
        ConfigModel configModel = this.configModel;
        return (configModel == null || (consentRequired = configModel.getConsentRequired()) == null) ? Intrinsics.areEqual((Object) this._consentRequired, (Object) true) : consentRequired.booleanValue();
    }

    @Override // com.onesignal.IOneSignal
    public void setConsentRequired(boolean z) {
        this._consentRequired = Boolean.valueOf(z);
        ConfigModel configModel = this.configModel;
        if (configModel == null) {
            return;
        }
        configModel.setConsentRequired(Boolean.valueOf(z));
    }

    @Override // com.onesignal.IOneSignal
    public boolean getConsentGiven() {
        Boolean consentGiven;
        ConfigModel configModel = this.configModel;
        return (configModel == null || (consentGiven = configModel.getConsentGiven()) == null) ? Intrinsics.areEqual((Object) this._consentGiven, (Object) true) : consentGiven.booleanValue();
    }

    @Override // com.onesignal.IOneSignal
    public void setConsentGiven(boolean z) {
        this._consentGiven = Boolean.valueOf(z);
        ConfigModel configModel = this.configModel;
        if (configModel == null) {
            return;
        }
        configModel.setConsentGiven(Boolean.valueOf(z));
    }

    @Override // com.onesignal.IOneSignal
    public boolean getDisableGMSMissingPrompt() {
        ConfigModel configModel = this.configModel;
        return configModel != null ? configModel.getDisableGMSMissingPrompt() : Intrinsics.areEqual((Object) this._disableGMSMissingPrompt, (Object) true);
    }

    @Override // com.onesignal.IOneSignal
    public void setDisableGMSMissingPrompt(boolean z) {
        this._disableGMSMissingPrompt = Boolean.valueOf(z);
        ConfigModel configModel = this.configModel;
        if (configModel == null) {
            return;
        }
        configModel.setDisableGMSMissingPrompt(z);
    }

    @Override // com.onesignal.IOneSignal
    public IDebugManager getDebug() {
        return this.debug;
    }

    @Override // com.onesignal.IOneSignal
    public ISessionManager getSession() {
        if (getIsInitialized()) {
            ISessionManager iSessionManager = this._session;
            Intrinsics.checkNotNull(iSessionManager);
            return iSessionManager;
        }
        throw new Exception("Must call 'initWithContext' before use");
    }

    @Override // com.onesignal.IOneSignal
    public INotificationsManager getNotifications() {
        if (getIsInitialized()) {
            INotificationsManager iNotificationsManager = this._notifications;
            Intrinsics.checkNotNull(iNotificationsManager);
            return iNotificationsManager;
        }
        throw new Exception("Must call 'initWithContext' before use");
    }

    @Override // com.onesignal.IOneSignal
    public ILocationManager getLocation() {
        if (getIsInitialized()) {
            ILocationManager iLocationManager = this._location;
            Intrinsics.checkNotNull(iLocationManager);
            return iLocationManager;
        }
        throw new Exception("Must call 'initWithContext' before use");
    }

    @Override // com.onesignal.IOneSignal
    public IInAppMessagesManager getInAppMessages() {
        if (getIsInitialized()) {
            IInAppMessagesManager iInAppMessagesManager = this.iam;
            Intrinsics.checkNotNull(iInAppMessagesManager);
            return iInAppMessagesManager;
        }
        throw new Exception("Must call 'initWithContext' before use");
    }

    @Override // com.onesignal.IOneSignal
    public IUserManager getUser() {
        if (!getIsInitialized()) {
            throw new Exception("Must call 'initWithContext' before use");
        }
        IUserManager iUserManager = this._user;
        Intrinsics.checkNotNull(iUserManager);
        return iUserManager;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x026f, code lost:
    
        if (r0.intValue() != r7) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0273, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0260, code lost:
    
        if (r0.intValue() != r7) goto L51;
     */
    @Override // com.onesignal.IOneSignal
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean initWithContext(android.content.Context r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 831
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.internal.OneSignalImp.initWithContext(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.lang.String] */
    @Override // com.onesignal.IOneSignal
    public void login(final String externalId, String jwtBearerToken) {
        Intrinsics.checkNotNullParameter(externalId, "externalId");
        Logging.log(LogLevel.DEBUG, "login(externalId: " + externalId + ", jwtBearerToken: " + jwtBearerToken + ')');
        if (!getIsInitialized()) {
            throw new Exception("Must call 'initWithContext' before 'login'");
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = "";
        synchronized (this.loginLock) {
            IdentityModelStore identityModelStore = this.identityModelStore;
            Intrinsics.checkNotNull(identityModelStore);
            objectRef.element = identityModelStore.getModel().getExternalId();
            IdentityModelStore identityModelStore2 = this.identityModelStore;
            Intrinsics.checkNotNull(identityModelStore2);
            objectRef2.element = identityModelStore2.getModel().getOnesignalId();
            if (Intrinsics.areEqual(objectRef.element, externalId)) {
                return;
            }
            createAndSwitchToNewUser$default(this, false, new Function2<IdentityModel, PropertiesModel, Unit>() { // from class: com.onesignal.internal.OneSignalImp$login$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(IdentityModel identityModel, PropertiesModel propertiesModel) {
                    invoke2(identityModel, propertiesModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IdentityModel identityModel, PropertiesModel propertiesModel) {
                    Intrinsics.checkNotNullParameter(identityModel, "identityModel");
                    Intrinsics.checkNotNullParameter(propertiesModel, "<anonymous parameter 1>");
                    identityModel.setExternalId(externalId);
                }
            }, 1, null);
            IdentityModelStore identityModelStore3 = this.identityModelStore;
            Intrinsics.checkNotNull(identityModelStore3);
            objectRef3.element = identityModelStore3.getModel().getOnesignalId();
            Unit unit = Unit.INSTANCE;
            ThreadUtilsKt.suspendifyOnThread$default(0, new OneSignalImp$login$2(this, objectRef3, externalId, objectRef, objectRef2, null), 1, null);
        }
    }

    @Override // com.onesignal.IOneSignal
    public void logout() {
        Logging.log(LogLevel.DEBUG, "logout()");
        if (!getIsInitialized()) {
            throw new Exception("Must call 'initWithContext' before 'logout'");
        }
        synchronized (this.loginLock) {
            IdentityModelStore identityModelStore = this.identityModelStore;
            Intrinsics.checkNotNull(identityModelStore);
            if (identityModelStore.getModel().getExternalId() == null) {
                return;
            }
            createAndSwitchToNewUser$default(this, false, null, 3, null);
            IOperationRepo iOperationRepo = this.operationRepo;
            Intrinsics.checkNotNull(iOperationRepo);
            ConfigModel configModel = this.configModel;
            Intrinsics.checkNotNull(configModel);
            String appId = configModel.getAppId();
            IdentityModelStore identityModelStore2 = this.identityModelStore;
            Intrinsics.checkNotNull(identityModelStore2);
            String onesignalId = identityModelStore2.getModel().getOnesignalId();
            IdentityModelStore identityModelStore3 = this.identityModelStore;
            Intrinsics.checkNotNull(identityModelStore3);
            IOperationRepo.DefaultImpls.enqueue$default(iOperationRepo, new LoginUserOperation(appId, onesignalId, identityModelStore3.getModel().getExternalId(), null, 8, null), false, 2, null);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void createAndSwitchToNewUser$default(OneSignalImp oneSignalImp, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        oneSignalImp.createAndSwitchToNewUser(z, function2);
    }

    private final void createAndSwitchToNewUser(boolean suppressBackendOperation, Function2<? super IdentityModel, ? super PropertiesModel, Unit> modify) {
        Object obj;
        String createLocalId;
        String str;
        SubscriptionStatus subscriptionStatus;
        Logging.debug$default("createAndSwitchToNewUser()", null, 2, null);
        String createLocalId2 = IDManager.INSTANCE.createLocalId();
        IdentityModel identityModel = new IdentityModel();
        identityModel.setOnesignalId(createLocalId2);
        PropertiesModel propertiesModel = new PropertiesModel();
        propertiesModel.setOnesignalId(createLocalId2);
        if (modify != null) {
            modify.invoke(identityModel, propertiesModel);
        }
        ArrayList arrayList = new ArrayList();
        SubscriptionModelStore subscriptionModelStore = this.subscriptionModelStore;
        Intrinsics.checkNotNull(subscriptionModelStore);
        Iterator it = subscriptionModelStore.list().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            String id = ((SubscriptionModel) obj).getId();
            ConfigModel configModel = this.configModel;
            Intrinsics.checkNotNull(configModel);
            if (Intrinsics.areEqual(id, configModel.getPushSubscriptionId())) {
                break;
            }
        }
        SubscriptionModel subscriptionModel = (SubscriptionModel) obj;
        SubscriptionModel subscriptionModel2 = new SubscriptionModel();
        if (subscriptionModel == null || (createLocalId = subscriptionModel.getId()) == null) {
            createLocalId = IDManager.INSTANCE.createLocalId();
        }
        subscriptionModel2.setId(createLocalId);
        subscriptionModel2.setType(SubscriptionType.PUSH);
        subscriptionModel2.setOptedIn(subscriptionModel != null ? subscriptionModel.getOptedIn() : true);
        if (subscriptionModel == null || (str = subscriptionModel.getAddress()) == null) {
            str = "";
        }
        subscriptionModel2.setAddress(str);
        if (subscriptionModel == null || (subscriptionStatus = subscriptionModel.getStatus()) == null) {
            subscriptionStatus = SubscriptionStatus.NO_PERMISSION;
        }
        subscriptionModel2.setStatus(subscriptionStatus);
        subscriptionModel2.setSdk(OneSignalUtils.SDK_VERSION);
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        subscriptionModel2.setDeviceOS(RELEASE);
        String carrierName = DeviceUtils.INSTANCE.getCarrierName(((IApplicationService) this.services.getService(IApplicationService.class)).getAppContext());
        if (carrierName == null) {
            carrierName = "";
        }
        subscriptionModel2.setCarrier(carrierName);
        String appVersion = AndroidUtils.INSTANCE.getAppVersion(((IApplicationService) this.services.getService(IApplicationService.class)).getAppContext());
        subscriptionModel2.setAppVersion(appVersion != null ? appVersion : "");
        ConfigModel configModel2 = this.configModel;
        Intrinsics.checkNotNull(configModel2);
        configModel2.setPushSubscriptionId(subscriptionModel2.getId());
        arrayList.add(subscriptionModel2);
        SubscriptionModelStore subscriptionModelStore2 = this.subscriptionModelStore;
        Intrinsics.checkNotNull(subscriptionModelStore2);
        subscriptionModelStore2.clear(ModelChangeTags.NO_PROPOGATE);
        IdentityModelStore identityModelStore = this.identityModelStore;
        Intrinsics.checkNotNull(identityModelStore);
        ISingletonModelStore.DefaultImpls.replace$default(identityModelStore, identityModel, null, 2, null);
        PropertiesModelStore propertiesModelStore = this.propertiesModelStore;
        Intrinsics.checkNotNull(propertiesModelStore);
        ISingletonModelStore.DefaultImpls.replace$default(propertiesModelStore, propertiesModel, null, 2, null);
        if (suppressBackendOperation) {
            SubscriptionModelStore subscriptionModelStore3 = this.subscriptionModelStore;
            Intrinsics.checkNotNull(subscriptionModelStore3);
            subscriptionModelStore3.replaceAll(arrayList, ModelChangeTags.NO_PROPOGATE);
        } else {
            if (subscriptionModel != null) {
                IOperationRepo iOperationRepo = this.operationRepo;
                Intrinsics.checkNotNull(iOperationRepo);
                ConfigModel configModel3 = this.configModel;
                Intrinsics.checkNotNull(configModel3);
                IOperationRepo.DefaultImpls.enqueue$default(iOperationRepo, new TransferSubscriptionOperation(configModel3.getAppId(), subscriptionModel.getId(), createLocalId2), false, 2, null);
                SubscriptionModelStore subscriptionModelStore4 = this.subscriptionModelStore;
                Intrinsics.checkNotNull(subscriptionModelStore4);
                subscriptionModelStore4.replaceAll(arrayList, ModelChangeTags.NO_PROPOGATE);
                return;
            }
            SubscriptionModelStore subscriptionModelStore5 = this.subscriptionModelStore;
            Intrinsics.checkNotNull(subscriptionModelStore5);
            IModelStore.DefaultImpls.replaceAll$default(subscriptionModelStore5, arrayList, null, 2, null);
        }
    }

    @Override // com.onesignal.common.services.IServiceProvider
    public <T> boolean hasService(Class<T> c) {
        Intrinsics.checkNotNullParameter(c, "c");
        return this.services.hasService(c);
    }

    @Override // com.onesignal.common.services.IServiceProvider
    public <T> T getService(Class<T> c) {
        Intrinsics.checkNotNullParameter(c, "c");
        return (T) this.services.getService(c);
    }

    @Override // com.onesignal.common.services.IServiceProvider
    public <T> T getServiceOrNull(Class<T> c) {
        Intrinsics.checkNotNullParameter(c, "c");
        return (T) this.services.getServiceOrNull(c);
    }

    @Override // com.onesignal.common.services.IServiceProvider
    public <T> List<T> getAllServices(Class<T> c) {
        Intrinsics.checkNotNullParameter(c, "c");
        return this.services.getAllServices(c);
    }
}
