package com.onesignal.user.internal.subscriptions.impl;

import android.os.Build;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.DeviceUtils;
import com.onesignal.common.IDManager;
import com.onesignal.common.OneSignalUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.modeling.IModelStore;
import com.onesignal.common.modeling.IModelStoreChangeHandler;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.internal.EmailSubscription;
import com.onesignal.user.internal.PushSubscription;
import com.onesignal.user.internal.SmsSubscription;
import com.onesignal.user.internal.Subscription;
import com.onesignal.user.internal.UninitializedPushSubscription;
import com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.internal.subscriptions.SubscriptionList;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import com.onesignal.user.subscriptions.IEmailSubscription;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.onesignal.user.subscriptions.IPushSubscriptionObserver;
import com.onesignal.user.subscriptions.ISmsSubscription;
import com.onesignal.user.subscriptions.ISubscription;
import com.onesignal.user.subscriptions.PushSubscriptionChangedState;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionManager.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001fH\u0016J$\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0018\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u001fH\u0016J\u0018\u00102\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u001fH\u0016J\u0018\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u0002052\u0006\u00101\u001a\u00020\u001fH\u0016J\b\u00106\u001a\u00020\u001dH\u0016J\u0010\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u001dH\u0016J\b\u0010;\u001a\u00020\u001dH\u0002J\u0010\u0010<\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001fH\u0016J\u0010\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020.H\u0002J\u0010\u0010@\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020.H\u0002J\u0010\u0010A\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020\u000eH\u0016J\u0010\u0010C\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006D"}, d2 = {"Lcom/onesignal/user/internal/subscriptions/impl/SubscriptionManager;", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "Lcom/onesignal/common/modeling/IModelStoreChangeHandler;", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_sessionService", "Lcom/onesignal/session/internal/session/ISessionService;", "_subscriptionModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;)V", "events", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionChangedHandler;", "hasSubscribers", "", "getHasSubscribers", "()Z", "pushSubscriptionModel", "getPushSubscriptionModel", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "subscriptions", "Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "getSubscriptions", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "setSubscriptions", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionList;)V", "addEmailSubscription", "", "email", "", "addOrUpdatePushSubscriptionToken", "pushToken", "pushTokenStatus", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "addSmsSubscription", "sms", "addSubscriptionToModels", "type", "Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "address", "status", "createSubscriptionAndAddToSubscriptionList", "subscriptionModel", "createSubscriptionFromModel", "Lcom/onesignal/user/subscriptions/ISubscription;", "onModelAdded", "model", "tag", "onModelRemoved", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "onSessionActive", "onSessionEnded", "duration", "", "onSessionStarted", "refreshPushSubscriptionState", "removeEmailSubscription", "removeSmsSubscription", "removeSubscriptionFromModels", "subscription", "removeSubscriptionFromSubscriptionList", "subscribe", "handler", "unsubscribe", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionManager implements ISubscriptionManager, IModelStoreChangeHandler<SubscriptionModel>, ISessionLifecycleHandler {
    private final IApplicationService _applicationService;
    private final ISessionService _sessionService;
    private final SubscriptionModelStore _subscriptionModelStore;
    private final EventProducer<ISubscriptionChangedHandler> events;
    private SubscriptionList subscriptions;

    /* compiled from: SubscriptionManager.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SubscriptionType.values().length];
            iArr[SubscriptionType.SMS.ordinal()] = 1;
            iArr[SubscriptionType.EMAIL.ordinal()] = 2;
            iArr[SubscriptionType.PUSH.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionActive() {
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionEnded(long duration) {
    }

    public SubscriptionManager(IApplicationService _applicationService, ISessionService _sessionService, SubscriptionModelStore _subscriptionModelStore) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_sessionService, "_sessionService");
        Intrinsics.checkNotNullParameter(_subscriptionModelStore, "_subscriptionModelStore");
        this._applicationService = _applicationService;
        this._sessionService = _sessionService;
        this._subscriptionModelStore = _subscriptionModelStore;
        this.events = new EventProducer<>();
        this.subscriptions = new SubscriptionList(CollectionsKt.emptyList(), new UninitializedPushSubscription());
        Iterator it = _subscriptionModelStore.list().iterator();
        while (it.hasNext()) {
            createSubscriptionAndAddToSubscriptionList((SubscriptionModel) it.next());
        }
        this._subscriptionModelStore.subscribe((IModelStoreChangeHandler) this);
        this._sessionService.subscribe(this);
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public SubscriptionList getSubscriptions() {
        return this.subscriptions;
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void setSubscriptions(SubscriptionList subscriptionList) {
        Intrinsics.checkNotNullParameter(subscriptionList, "<set-?>");
        this.subscriptions = subscriptionList;
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public SubscriptionModel getPushSubscriptionModel() {
        IPushSubscription push = getSubscriptions().getPush();
        Intrinsics.checkNotNull(push, "null cannot be cast to non-null type com.onesignal.user.internal.PushSubscription");
        return ((PushSubscription) push).getModel();
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionStarted() {
        refreshPushSubscriptionState();
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void addEmailSubscription(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        addSubscriptionToModels$default(this, SubscriptionType.EMAIL, email, null, 4, null);
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void addSmsSubscription(String sms) {
        Intrinsics.checkNotNullParameter(sms, "sms");
        addSubscriptionToModels$default(this, SubscriptionType.SMS, sms, null, 4, null);
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void addOrUpdatePushSubscriptionToken(String pushToken, SubscriptionStatus pushTokenStatus) {
        Intrinsics.checkNotNullParameter(pushTokenStatus, "pushTokenStatus");
        ISubscription push = getSubscriptions().getPush();
        if (push instanceof UninitializedPushSubscription) {
            SubscriptionType subscriptionType = SubscriptionType.PUSH;
            if (pushToken == null) {
                pushToken = "";
            }
            addSubscriptionToModels(subscriptionType, pushToken, pushTokenStatus);
            return;
        }
        Intrinsics.checkNotNull(push, "null cannot be cast to non-null type com.onesignal.user.internal.Subscription");
        SubscriptionModel model = ((Subscription) push).getModel();
        if (pushToken != null) {
            model.setAddress(pushToken);
        }
        model.setStatus(pushTokenStatus);
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void removeEmailSubscription(String email) {
        Object obj;
        Intrinsics.checkNotNullParameter(email, "email");
        Iterator<T> it = getSubscriptions().getEmails().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            IEmailSubscription iEmailSubscription = (IEmailSubscription) obj;
            if ((iEmailSubscription instanceof EmailSubscription) && Intrinsics.areEqual(iEmailSubscription.getEmail(), email)) {
                break;
            }
        }
        IEmailSubscription iEmailSubscription2 = (IEmailSubscription) obj;
        if (iEmailSubscription2 != null) {
            removeSubscriptionFromModels(iEmailSubscription2);
        }
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void removeSmsSubscription(String sms) {
        Object obj;
        Intrinsics.checkNotNullParameter(sms, "sms");
        Iterator<T> it = getSubscriptions().getSmss().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ISmsSubscription iSmsSubscription = (ISmsSubscription) obj;
            if ((iSmsSubscription instanceof SmsSubscription) && Intrinsics.areEqual(iSmsSubscription.getNumber(), sms)) {
                break;
            }
        }
        ISmsSubscription iSmsSubscription2 = (ISmsSubscription) obj;
        if (iSmsSubscription2 != null) {
            removeSubscriptionFromModels(iSmsSubscription2);
        }
    }

    static /* synthetic */ void addSubscriptionToModels$default(SubscriptionManager subscriptionManager, SubscriptionType subscriptionType, String str, SubscriptionStatus subscriptionStatus, int i, Object obj) {
        if ((i & 4) != 0) {
            subscriptionStatus = null;
        }
        subscriptionManager.addSubscriptionToModels(subscriptionType, str, subscriptionStatus);
    }

    private final void addSubscriptionToModels(SubscriptionType type, String address, SubscriptionStatus status) {
        Logging.log(LogLevel.DEBUG, "SubscriptionManager.addSubscription(type: " + type + ", address: " + address + ')');
        SubscriptionModel subscriptionModel = new SubscriptionModel();
        subscriptionModel.setId(IDManager.INSTANCE.createLocalId());
        subscriptionModel.setOptedIn(true);
        subscriptionModel.setType(type);
        subscriptionModel.setAddress(address);
        if (status == null) {
            status = SubscriptionStatus.SUBSCRIBED;
        }
        subscriptionModel.setStatus(status);
        IModelStore.DefaultImpls.add$default(this._subscriptionModelStore, subscriptionModel, null, 2, null);
    }

    private final void removeSubscriptionFromModels(ISubscription subscription) {
        Logging.log(LogLevel.DEBUG, "SubscriptionManager.removeSubscription(subscription: " + subscription + ')');
        IModelStore.DefaultImpls.remove$default(this._subscriptionModelStore, subscription.getId(), null, 2, null);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(ISubscriptionChangedHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.events.subscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(ISubscriptionChangedHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.events.unsubscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.events.getHasSubscribers();
    }

    @Override // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelAdded(SubscriptionModel model, String tag) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(tag, "tag");
        createSubscriptionAndAddToSubscriptionList(model);
    }

    @Override // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelUpdated(final ModelChangedArgs args, String tag) {
        Object obj;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Iterator<T> it = getSubscriptions().getCollection().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ISubscription iSubscription = (ISubscription) obj;
            Model model = args.getModel();
            Intrinsics.checkNotNull(iSubscription, "null cannot be cast to non-null type com.onesignal.user.internal.Subscription");
            if (Intrinsics.areEqual(model, ((Subscription) iSubscription).getModel())) {
                break;
            }
        }
        final ISubscription iSubscription2 = (ISubscription) obj;
        if (iSubscription2 == null) {
            Model model2 = args.getModel();
            Intrinsics.checkNotNull(model2, "null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionModel");
            createSubscriptionAndAddToSubscriptionList((SubscriptionModel) model2);
        } else {
            if (iSubscription2 instanceof PushSubscription) {
                ((PushSubscription) iSubscription2).getChangeHandlersNotifier().fireOnMain(new Function1<IPushSubscriptionObserver, Unit>() { // from class: com.onesignal.user.internal.subscriptions.impl.SubscriptionManager$onModelUpdated$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IPushSubscriptionObserver iPushSubscriptionObserver) {
                        invoke2(iPushSubscriptionObserver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(IPushSubscriptionObserver it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        it2.onPushSubscriptionChange(new PushSubscriptionChangedState(((PushSubscription) ISubscription.this).getSavedState(), ((PushSubscription) ISubscription.this).refreshState()));
                    }
                });
            }
            this.events.fire(new Function1<ISubscriptionChangedHandler, Unit>() { // from class: com.onesignal.user.internal.subscriptions.impl.SubscriptionManager$onModelUpdated$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ISubscriptionChangedHandler iSubscriptionChangedHandler) {
                    invoke2(iSubscriptionChangedHandler);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ISubscriptionChangedHandler it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    it2.onSubscriptionChanged(ISubscription.this, args);
                }
            });
        }
    }

    @Override // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelRemoved(SubscriptionModel model, String tag) {
        Object obj;
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Iterator<T> it = getSubscriptions().getCollection().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((ISubscription) obj).getId(), model.getId())) {
                    break;
                }
            }
        }
        ISubscription iSubscription = (ISubscription) obj;
        if (iSubscription != null) {
            removeSubscriptionFromSubscriptionList(iSubscription);
        }
    }

    private final void createSubscriptionAndAddToSubscriptionList(SubscriptionModel subscriptionModel) {
        final ISubscription createSubscriptionFromModel = createSubscriptionFromModel(subscriptionModel);
        List mutableList = CollectionsKt.toMutableList((Collection) getSubscriptions().getCollection());
        if (subscriptionModel.getType() == SubscriptionType.PUSH) {
            IPushSubscription push = getSubscriptions().getPush();
            Intrinsics.checkNotNull(push, "null cannot be cast to non-null type com.onesignal.user.internal.PushSubscription");
            PushSubscription pushSubscription = (PushSubscription) push;
            Intrinsics.checkNotNull(createSubscriptionFromModel, "null cannot be cast to non-null type com.onesignal.user.internal.PushSubscription");
            ((PushSubscription) createSubscriptionFromModel).getChangeHandlersNotifier().subscribeAll(pushSubscription.getChangeHandlersNotifier());
            mutableList.remove(pushSubscription);
        }
        mutableList.add(createSubscriptionFromModel);
        setSubscriptions(new SubscriptionList(mutableList, new UninitializedPushSubscription()));
        this.events.fire(new Function1<ISubscriptionChangedHandler, Unit>() { // from class: com.onesignal.user.internal.subscriptions.impl.SubscriptionManager$createSubscriptionAndAddToSubscriptionList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ISubscriptionChangedHandler iSubscriptionChangedHandler) {
                invoke2(iSubscriptionChangedHandler);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ISubscriptionChangedHandler it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onSubscriptionAdded(ISubscription.this);
            }
        });
    }

    private final void removeSubscriptionFromSubscriptionList(final ISubscription subscription) {
        List mutableList = CollectionsKt.toMutableList((Collection) getSubscriptions().getCollection());
        mutableList.remove(subscription);
        setSubscriptions(new SubscriptionList(mutableList, new UninitializedPushSubscription()));
        this.events.fire(new Function1<ISubscriptionChangedHandler, Unit>() { // from class: com.onesignal.user.internal.subscriptions.impl.SubscriptionManager$removeSubscriptionFromSubscriptionList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ISubscriptionChangedHandler iSubscriptionChangedHandler) {
                invoke2(iSubscriptionChangedHandler);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ISubscriptionChangedHandler it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onSubscriptionRemoved(ISubscription.this);
            }
        });
    }

    private final ISubscription createSubscriptionFromModel(SubscriptionModel subscriptionModel) {
        int i = WhenMappings.$EnumSwitchMapping$0[subscriptionModel.getType().ordinal()];
        if (i == 1) {
            return new SmsSubscription(subscriptionModel);
        }
        if (i == 2) {
            return new EmailSubscription(subscriptionModel);
        }
        if (i == 3) {
            return new PushSubscription(subscriptionModel);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void refreshPushSubscriptionState() {
        ISubscription push = getSubscriptions().getPush();
        if (push instanceof UninitializedPushSubscription) {
            return;
        }
        Intrinsics.checkNotNull(push, "null cannot be cast to non-null type com.onesignal.user.internal.Subscription");
        SubscriptionModel model = ((Subscription) push).getModel();
        model.setSdk(OneSignalUtils.SDK_VERSION);
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        model.setDeviceOS(RELEASE);
        String carrierName = DeviceUtils.INSTANCE.getCarrierName(this._applicationService.getAppContext());
        if (carrierName != null) {
            model.setCarrier(carrierName);
        }
        String appVersion = AndroidUtils.INSTANCE.getAppVersion(this._applicationService.getAppContext());
        if (appVersion != null) {
            model.setAppVersion(appVersion);
        }
    }
}
