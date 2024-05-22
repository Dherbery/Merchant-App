package com.onesignal.session.internal.outcomes.impl;

import androidx.core.app.NotificationCompat;
import com.onesignal.common.exceptions.BackendException;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.session.internal.influence.Influence;
import com.onesignal.session.internal.influence.InfluenceChannel;
import com.onesignal.session.internal.influence.InfluenceType;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OutcomeEventsController.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BU\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J/\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020#H\u0016J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u0019\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020#2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010.\u001a\u00020#H\u0002J\u0010\u0010/\u001a\u00020#2\u0006\u0010*\u001a\u00020+H\u0002J9\u00100\u001a\u0004\u0018\u0001012\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020&2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0082@ø\u0001\u0000¢\u0006\u0002\u00105J\u001b\u00106\u001a\u0004\u0018\u0001012\u0006\u0010\u001f\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u00107J#\u00108\u001a\u0004\u0018\u0001012\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u00102\u001a\u000203H\u0096@ø\u0001\u0000¢\u0006\u0002\u00109J\u0019\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020+H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0011\u0010<\u001a\u00020#H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010=J\u001b\u0010>\u001a\u0004\u0018\u0001012\u0006\u0010%\u001a\u00020&H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010?J\u001b\u0010@\u001a\u0004\u0018\u0001012\u0006\u0010\u001f\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u00107J)\u0010@\u001a\u0004\u0018\u0001012\u0006\u0010\u001f\u001a\u00020\u001b2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0018\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020CH\u0002J\b\u0010F\u001a\u00020#H\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006G"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventsController;", "Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "_session", "Lcom/onesignal/session/internal/session/ISessionService;", "_influenceManager", "Lcom/onesignal/session/internal/influence/IInfluenceManager;", "_outcomeEventsCache", "Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsRepository;", "_outcomeEventsPreferences", "Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsPreferences;", "_outcomeEventsBackend", "Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsBackendService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/session/internal/influence/IInfluenceManager;Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsRepository;Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsPreferences;Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsBackendService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/core/internal/time/ITime;)V", "unattributedUniqueOutcomeEventsSentOnSession", "", "", "getUniqueIds", "", "Lcom/onesignal/session/internal/influence/Influence;", "name", "influences", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSessionActive", "", "onSessionEnded", "duration", "", "onSessionStarted", "removeDisabledInfluences", "requestMeasureOutcomeEvent", "eventParams", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventParams;", "(Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAttributedUniqueOutcomeNotifications", "saveUnattributedUniqueOutcomeEvents", "saveUniqueOutcome", "sendAndCreateOutcomeEvent", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeEvent;", "weight", "", "sessionTime", "(Ljava/lang/String;FJLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendOutcomeEvent", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendOutcomeEventWithValue", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSavedOutcomeEvent", NotificationCompat.CATEGORY_EVENT, "sendSavedOutcomes", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSessionEndOutcomeEvent", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendUniqueOutcomeEvent", "sessionInfluences", "setSourceChannelIds", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;", "influence", "sourceBody", "start", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OutcomeEventsController implements IOutcomeEventsController, IStartableService, ISessionLifecycleHandler {
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final IdentityModelStore _identityModelStore;
    private final IInfluenceManager _influenceManager;
    private final IOutcomeEventsBackendService _outcomeEventsBackend;
    private final IOutcomeEventsRepository _outcomeEventsCache;
    private final IOutcomeEventsPreferences _outcomeEventsPreferences;
    private final ISessionService _session;
    private final ISubscriptionManager _subscriptionManager;
    private final ITime _time;
    private Set<String> unattributedUniqueOutcomeEventsSentOnSession;

    /* compiled from: OutcomeEventsController.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[InfluenceType.values().length];
            iArr[InfluenceType.DIRECT.ordinal()] = 1;
            iArr[InfluenceType.INDIRECT.ordinal()] = 2;
            iArr[InfluenceType.UNATTRIBUTED.ordinal()] = 3;
            iArr[InfluenceType.DISABLED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[InfluenceChannel.values().length];
            iArr2[InfluenceChannel.IAM.ordinal()] = 1;
            iArr2[InfluenceChannel.NOTIFICATION.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionActive() {
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionEnded(long duration) {
    }

    public OutcomeEventsController(ISessionService _session, IInfluenceManager _influenceManager, IOutcomeEventsRepository _outcomeEventsCache, IOutcomeEventsPreferences _outcomeEventsPreferences, IOutcomeEventsBackendService _outcomeEventsBackend, ConfigModelStore _configModelStore, IdentityModelStore _identityModelStore, ISubscriptionManager _subscriptionManager, IDeviceService _deviceService, ITime _time) {
        LinkedHashSet mutableSet;
        Intrinsics.checkNotNullParameter(_session, "_session");
        Intrinsics.checkNotNullParameter(_influenceManager, "_influenceManager");
        Intrinsics.checkNotNullParameter(_outcomeEventsCache, "_outcomeEventsCache");
        Intrinsics.checkNotNullParameter(_outcomeEventsPreferences, "_outcomeEventsPreferences");
        Intrinsics.checkNotNullParameter(_outcomeEventsBackend, "_outcomeEventsBackend");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_identityModelStore, "_identityModelStore");
        Intrinsics.checkNotNullParameter(_subscriptionManager, "_subscriptionManager");
        Intrinsics.checkNotNullParameter(_deviceService, "_deviceService");
        Intrinsics.checkNotNullParameter(_time, "_time");
        this._session = _session;
        this._influenceManager = _influenceManager;
        this._outcomeEventsCache = _outcomeEventsCache;
        this._outcomeEventsPreferences = _outcomeEventsPreferences;
        this._outcomeEventsBackend = _outcomeEventsBackend;
        this._configModelStore = _configModelStore;
        this._identityModelStore = _identityModelStore;
        this._subscriptionManager = _subscriptionManager;
        this._deviceService = _deviceService;
        this._time = _time;
        this.unattributedUniqueOutcomeEventsSentOnSession = new LinkedHashSet();
        Set<String> unattributedUniqueOutcomeEventsSentByChannel = _outcomeEventsPreferences.getUnattributedUniqueOutcomeEventsSentByChannel();
        this.unattributedUniqueOutcomeEventsSentOnSession = (unattributedUniqueOutcomeEventsSentByChannel == null || (mutableSet = CollectionsKt.toMutableSet(unattributedUniqueOutcomeEventsSentByChannel)) == null) ? new LinkedHashSet() : mutableSet;
        _session.subscribe(this);
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        ThreadUtilsKt.suspendifyOnThread$default(0, new OutcomeEventsController$start$1(this, null), 1, null);
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionStarted() {
        Logging.debug$default("OutcomeEventsController.sessionStarted: Cleaning outcomes for new session", null, 2, null);
        this.unattributedUniqueOutcomeEventsSentOnSession = new LinkedHashSet();
        saveUnattributedUniqueOutcomeEvents();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendSavedOutcomes(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomes$1
            if (r0 == 0) goto L14
            r0 = r6
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomes$1 r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomes$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomes$1 r0 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomes$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r2 = r0.L$1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$0
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController r4 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5e
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3d:
            java.lang.Object r2 = r0.L$0
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController r2 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L56
        L45:
            kotlin.ResultKt.throwOnFailure(r6)
            com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository r6 = r5._outcomeEventsCache
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.getAllEventsToSend(r0)
            if (r6 != r1) goto L55
            return r1
        L55:
            r2 = r5
        L56:
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
            r4 = r2
            r2 = r6
        L5e:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L77
            java.lang.Object r6 = r2.next()
            com.onesignal.session.internal.outcomes.impl.OutcomeEventParams r6 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventParams) r6
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r6 = r4.sendSavedOutcomeEvent(r6, r0)
            if (r6 != r1) goto L5e
            return r1
        L77:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendSavedOutcomes(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(8:5|6|7|(1:(1:(4:11|12|13|14)(2:16|17))(2:18|19))(3:23|24|(1:26)(1:27))|20|(1:22)|13|14))|30|6|7|(0)(0)|20|(0)|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
    
        com.onesignal.debug.internal.logging.Logging.warn$default("OutcomeEventsController.sendSavedOutcomeEvent: Sending outcome with name: " + r7.getOutcomeId() + " failed with status code: " + r8.getStatusCode() + " and response: " + r8.getResponse() + "\nOutcome event was cached and will be reattempted on app cold start", null, 2, null);
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendSavedOutcomeEvent(com.onesignal.session.internal.outcomes.impl.OutcomeEventParams r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomeEvent$1
            if (r0 == 0) goto L14
            r0 = r8
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomeEvent$1 r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomeEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomeEvent$1 r0 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomeEvent$1
            r0.<init>(r6, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            r5 = 2
            if (r2 == 0) goto L46
            if (r2 == r3) goto L3a
            if (r2 != r5) goto L32
            java.lang.Object r7 = r0.L$0
            com.onesignal.session.internal.outcomes.impl.OutcomeEventParams r7 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventParams) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: com.onesignal.common.exceptions.BackendException -> L66
            goto L99
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            java.lang.Object r7 = r0.L$1
            com.onesignal.session.internal.outcomes.impl.OutcomeEventParams r7 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventParams) r7
            java.lang.Object r2 = r0.L$0
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController r2 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: com.onesignal.common.exceptions.BackendException -> L66
            goto L57
        L46:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r6     // Catch: com.onesignal.common.exceptions.BackendException -> L66
            r0.L$1 = r7     // Catch: com.onesignal.common.exceptions.BackendException -> L66
            r0.label = r3     // Catch: com.onesignal.common.exceptions.BackendException -> L66
            java.lang.Object r8 = r6.requestMeasureOutcomeEvent(r7, r0)     // Catch: com.onesignal.common.exceptions.BackendException -> L66
            if (r8 != r1) goto L56
            return r1
        L56:
            r2 = r6
        L57:
            com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository r8 = r2._outcomeEventsCache     // Catch: com.onesignal.common.exceptions.BackendException -> L66
            r0.L$0 = r7     // Catch: com.onesignal.common.exceptions.BackendException -> L66
            r0.L$1 = r4     // Catch: com.onesignal.common.exceptions.BackendException -> L66
            r0.label = r5     // Catch: com.onesignal.common.exceptions.BackendException -> L66
            java.lang.Object r7 = r8.deleteOldOutcomeEvent(r7, r0)     // Catch: com.onesignal.common.exceptions.BackendException -> L66
            if (r7 != r1) goto L99
            return r1
        L66:
            r8 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "OutcomeEventsController.sendSavedOutcomeEvent: Sending outcome with name: "
            r0.<init>(r1)
            java.lang.String r7 = r7.getOutcomeId()
            r0.append(r7)
            java.lang.String r7 = " failed with status code: "
            r0.append(r7)
            int r7 = r8.getStatusCode()
            r0.append(r7)
            java.lang.String r7 = " and response: "
            r0.append(r7)
            java.lang.String r7 = r8.getResponse()
            r0.append(r7)
            java.lang.String r7 = "\nOutcome event was cached and will be reattempted on app cold start"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.onesignal.debug.internal.logging.Logging.warn$default(r7, r4, r5, r4)
        L99:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendSavedOutcomeEvent(com.onesignal.session.internal.outcomes.impl.OutcomeEventParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.onesignal.session.internal.outcomes.IOutcomeEventsController
    public Object sendSessionEndOutcomeEvent(long j, Continuation<? super OutcomeEvent> continuation) {
        List<Influence> influences = this._influenceManager.getInfluences();
        Iterator<Influence> it = influences.iterator();
        while (it.hasNext()) {
            if (it.next().getIds() != null) {
                return sendAndCreateOutcomeEvent("os__session_duration", 0.0f, j, influences, continuation);
            }
        }
        return null;
    }

    @Override // com.onesignal.session.internal.outcomes.IOutcomeEventsController
    public Object sendUniqueOutcomeEvent(String str, Continuation<? super OutcomeEvent> continuation) {
        return sendUniqueOutcomeEvent(str, this._influenceManager.getInfluences(), continuation);
    }

    @Override // com.onesignal.session.internal.outcomes.IOutcomeEventsController
    public Object sendOutcomeEvent(String str, Continuation<? super OutcomeEvent> continuation) {
        return sendAndCreateOutcomeEvent(str, 0.0f, 0L, this._influenceManager.getInfluences(), continuation);
    }

    @Override // com.onesignal.session.internal.outcomes.IOutcomeEventsController
    public Object sendOutcomeEventWithValue(String str, float f, Continuation<? super OutcomeEvent> continuation) {
        return sendAndCreateOutcomeEvent(str, f, 0L, this._influenceManager.getInfluences(), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendUniqueOutcomeEvent(java.lang.String r11, java.util.List<com.onesignal.session.internal.influence.Influence> r12, kotlin.coroutines.Continuation<? super com.onesignal.session.internal.outcomes.impl.OutcomeEvent> r13) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendUniqueOutcomeEvent(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0155 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0154 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendAndCreateOutcomeEvent(java.lang.String r22, float r23, long r24, java.util.List<com.onesignal.session.internal.influence.Influence> r26, kotlin.coroutines.Continuation<? super com.onesignal.session.internal.outcomes.impl.OutcomeEvent> r27) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendAndCreateOutcomeEvent(java.lang.String, float, long, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final OutcomeSourceBody setSourceChannelIds(Influence influence, OutcomeSourceBody sourceBody) {
        int i = WhenMappings.$EnumSwitchMapping$1[influence.getInfluenceChannel().ordinal()];
        if (i == 1) {
            sourceBody.setInAppMessagesIds(influence.getIds());
        } else if (i == 2) {
            sourceBody.setNotificationIds(influence.getIds());
        }
        return sourceBody;
    }

    private final List<Influence> removeDisabledInfluences(List<Influence> influences) {
        List<Influence> mutableList = CollectionsKt.toMutableList((Collection) influences);
        for (Influence influence : influences) {
            if (influence.getInfluenceType().isDisabled()) {
                Logging.debug$default("OutcomeEventsController.removeDisabledInfluences: Outcomes disabled for channel: " + influence.getInfluenceChannel(), null, 2, null);
                mutableList.remove(influence);
            }
        }
        return mutableList;
    }

    private final void saveUniqueOutcome(OutcomeEventParams eventParams) {
        if (eventParams.isUnattributed()) {
            saveUnattributedUniqueOutcomeEvents();
        } else {
            saveAttributedUniqueOutcomeNotifications(eventParams);
        }
    }

    private final void saveAttributedUniqueOutcomeNotifications(OutcomeEventParams eventParams) {
        ThreadUtilsKt.suspendifyOnThread(10, new OutcomeEventsController$saveAttributedUniqueOutcomeNotifications$1(this, eventParams, null));
    }

    private final void saveUnattributedUniqueOutcomeEvents() {
        this._outcomeEventsPreferences.setUnattributedUniqueOutcomeEventsSentByChannel(this.unattributedUniqueOutcomeEventsSentOnSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getUniqueIds(java.lang.String r5, java.util.List<com.onesignal.session.internal.influence.Influence> r6, kotlin.coroutines.Continuation<? super java.util.List<com.onesignal.session.internal.influence.Influence>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$getUniqueIds$1
            if (r0 == 0) goto L14
            r0 = r7
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$getUniqueIds$1 r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$getUniqueIds$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$getUniqueIds$1 r0 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$getUniqueIds$1
            r0.<init>(r4, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L40
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository r7 = r4._outcomeEventsCache
            r0.label = r3
            java.lang.Object r7 = r7.getNotCachedUniqueInfluencesForOutcome(r5, r6, r0)
            if (r7 != r1) goto L40
            return r1
        L40:
            java.util.List r7 = (java.util.List) r7
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r5 = r7.isEmpty()
            if (r5 == 0) goto L4b
            r7 = 0
        L4b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.getUniqueIds(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestMeasureOutcomeEvent(OutcomeEventParams outcomeEventParams, Continuation<? super Unit> continuation) {
        Boolean boxBoolean;
        String appId = this._configModelStore.getModel().getAppId();
        String id = this._subscriptionManager.getSubscriptions().getPush().getId();
        String value = SubscriptionObjectType.INSTANCE.fromDeviceType(this._deviceService.getDeviceType()).getValue();
        if (!(id.length() == 0)) {
            if (!(value.length() == 0)) {
                OutcomeEvent fromOutcomeEventParamstoOutcomeEvent = OutcomeEvent.INSTANCE.fromOutcomeEventParamstoOutcomeEvent(outcomeEventParams);
                int i = WhenMappings.$EnumSwitchMapping$0[fromOutcomeEventParamstoOutcomeEvent.getSession().ordinal()];
                if (i == 1) {
                    boxBoolean = Boxing.boxBoolean(true);
                } else {
                    boxBoolean = i != 2 ? null : Boxing.boxBoolean(false);
                }
                Object sendOutcomeEvent = this._outcomeEventsBackend.sendOutcomeEvent(appId, this._identityModelStore.getModel().getOnesignalId(), id, value, boxBoolean, fromOutcomeEventParamstoOutcomeEvent, continuation);
                return sendOutcomeEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendOutcomeEvent : Unit.INSTANCE;
            }
        }
        throw new BackendException(0, null, null, 6, null);
    }
}
