package com.onesignal.session.internal.influence.impl;

import com.onesignal.common.JSONUtils;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.application.AppEntryAction;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.session.internal.influence.Influence;
import com.onesignal.session.internal.influence.InfluenceType;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* compiled from: InfluenceManager.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001c\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020$H\u0002J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u001fH\u0016J\u0010\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020\"H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u001fH\u0016J\u0010\u0010.\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u001fH\u0016J\b\u0010/\u001a\u00020\"H\u0016J\u0010\u00100\u001a\u00020\"2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\"H\u0016J\u0010\u00104\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J,\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u001f2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J,\u0010=\u001a\u0002062\u0006\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u001f2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/onesignal/session/internal/influence/impl/InfluenceManager;", "Lcom/onesignal/session/internal/influence/IInfluenceManager;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "_sessionService", "Lcom/onesignal/session/internal/session/ISessionService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "preferences", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "timeProvider", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/preferences/IPreferencesService;Lcom/onesignal/core/internal/time/ITime;)V", "channels", "", "Lcom/onesignal/session/internal/influence/impl/IChannelTracker;", "getChannels", "()Ljava/util/List;", "dataRepository", "Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;", "iAMChannelTracker", "getIAMChannelTracker", "()Lcom/onesignal/session/internal/influence/impl/IChannelTracker;", "influences", "Lcom/onesignal/session/internal/influence/Influence;", "getInfluences", "notificationChannelTracker", "getNotificationChannelTracker", "trackers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/onesignal/session/internal/influence/impl/ChannelTracker;", "attemptSessionUpgrade", "", "entryAction", "Lcom/onesignal/core/internal/application/AppEntryAction;", "directId", "getChannelByEntryAction", "getChannelsToResetByEntryAction", "onDirectInfluenceFromIAM", "messageId", "onDirectInfluenceFromNotification", "notificationId", "onInAppMessageDismissed", "onInAppMessageDisplayed", "onNotificationReceived", "onSessionActive", "onSessionEnded", "duration", "", "onSessionStarted", "restartSessionTrackersIfNeeded", "setSessionTracker", "", "channelTracker", "influenceType", "Lcom/onesignal/session/internal/influence/InfluenceType;", "directNotificationId", "indirectNotificationIds", "Lorg/json/JSONArray;", "willChangeSessionTracker", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class InfluenceManager implements IInfluenceManager, ISessionLifecycleHandler {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final ISessionService _sessionService;
    private final InfluenceDataRepository dataRepository;
    private final ConcurrentHashMap<String, ChannelTracker> trackers;

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionEnded(long duration) {
    }

    public InfluenceManager(ISessionService _sessionService, IApplicationService _applicationService, ConfigModelStore _configModelStore, IPreferencesService preferences, ITime timeProvider) {
        Intrinsics.checkNotNullParameter(_sessionService, "_sessionService");
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this._sessionService = _sessionService;
        this._applicationService = _applicationService;
        this._configModelStore = _configModelStore;
        ConcurrentHashMap<String, ChannelTracker> concurrentHashMap = new ConcurrentHashMap<>();
        this.trackers = concurrentHashMap;
        InfluenceDataRepository influenceDataRepository = new InfluenceDataRepository(preferences, _configModelStore);
        this.dataRepository = influenceDataRepository;
        concurrentHashMap.put(InfluenceConstants.INSTANCE.getIAM_TAG(), new InAppMessageTracker(influenceDataRepository, timeProvider));
        concurrentHashMap.put(InfluenceConstants.INSTANCE.getNOTIFICATION_TAG(), new NotificationTracker(influenceDataRepository, timeProvider));
        _sessionService.subscribe(this);
        Collection<ChannelTracker> values = concurrentHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "trackers.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((ChannelTracker) it.next()).initInfluencedTypeFromCache();
        }
    }

    @Override // com.onesignal.session.internal.influence.IInfluenceManager
    public List<Influence> getInfluences() {
        Collection<ChannelTracker> values = this.trackers.values();
        Intrinsics.checkNotNullExpressionValue(values, "trackers.values");
        Collection<ChannelTracker> collection = values;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((ChannelTracker) it.next()).getCurrentSessionInfluence());
        }
        return arrayList;
    }

    private final IChannelTracker getIAMChannelTracker() {
        ChannelTracker channelTracker = this.trackers.get(InfluenceConstants.INSTANCE.getIAM_TAG());
        Intrinsics.checkNotNull(channelTracker);
        return channelTracker;
    }

    private final IChannelTracker getNotificationChannelTracker() {
        ChannelTracker channelTracker = this.trackers.get(InfluenceConstants.INSTANCE.getNOTIFICATION_TAG());
        Intrinsics.checkNotNull(channelTracker);
        return channelTracker;
    }

    private final List<IChannelTracker> getChannels() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getNotificationChannelTracker());
        arrayList.add(getIAMChannelTracker());
        return arrayList;
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionStarted() {
        restartSessionTrackersIfNeeded(this._applicationService.getEntryState());
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionActive() {
        attemptSessionUpgrade$default(this, this._applicationService.getEntryState(), null, 2, null);
    }

    private final IChannelTracker getChannelByEntryAction(AppEntryAction entryAction) {
        if (entryAction.isNotificationClick()) {
            return getNotificationChannelTracker();
        }
        return null;
    }

    private final List<IChannelTracker> getChannelsToResetByEntryAction(AppEntryAction entryAction) {
        ArrayList arrayList = new ArrayList();
        if (entryAction.isAppClose()) {
            return arrayList;
        }
        IChannelTracker notificationChannelTracker = entryAction.isAppOpen() ? getNotificationChannelTracker() : null;
        if (notificationChannelTracker != null) {
            arrayList.add(notificationChannelTracker);
        }
        arrayList.add(getIAMChannelTracker());
        return arrayList;
    }

    @Override // com.onesignal.session.internal.influence.IInfluenceManager
    public void onNotificationReceived(String notificationId) {
        Intrinsics.checkNotNullParameter(notificationId, "notificationId");
        Logging.debug$default("InfluenceManager.onNotificationReceived(notificationId: " + notificationId + ')', null, 2, null);
        if (notificationId.length() == 0) {
            return;
        }
        getNotificationChannelTracker().saveLastId(notificationId);
    }

    @Override // com.onesignal.session.internal.influence.IInfluenceManager
    public void onDirectInfluenceFromNotification(String notificationId) {
        Intrinsics.checkNotNullParameter(notificationId, "notificationId");
        Logging.debug$default("InfluenceManager.onDirectInfluenceFromNotification(notificationId: " + notificationId + ')', null, 2, null);
        if (notificationId.length() == 0) {
            return;
        }
        attemptSessionUpgrade(AppEntryAction.NOTIFICATION_CLICK, notificationId);
    }

    @Override // com.onesignal.session.internal.influence.IInfluenceManager
    public void onInAppMessageDisplayed(String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Logging.debug$default("InfluenceManager.onInAppMessageReceived(messageId: " + messageId + ')', null, 2, null);
        IChannelTracker iAMChannelTracker = getIAMChannelTracker();
        iAMChannelTracker.saveLastId(messageId);
        iAMChannelTracker.resetAndInitInfluence();
    }

    @Override // com.onesignal.session.internal.influence.IInfluenceManager
    public void onDirectInfluenceFromIAM(String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Logging.debug$default("InfluenceManager.onDirectInfluenceFromIAM(messageId: " + messageId + ')', null, 2, null);
        setSessionTracker(getIAMChannelTracker(), InfluenceType.DIRECT, messageId, null);
    }

    @Override // com.onesignal.session.internal.influence.IInfluenceManager
    public void onInAppMessageDismissed() {
        Logging.debug$default("InfluenceManager.onInAppMessageDismissed()", null, 2, null);
        getIAMChannelTracker().resetAndInitInfluence();
    }

    private final void restartSessionTrackersIfNeeded(AppEntryAction entryAction) {
        boolean sessionTracker;
        List<IChannelTracker> channelsToResetByEntryAction = getChannelsToResetByEntryAction(entryAction);
        ArrayList arrayList = new ArrayList();
        Logging.debug$default("InfluenceManager.restartSessionIfNeeded(entryAction: " + entryAction + "):\n channelTrackers: " + channelsToResetByEntryAction, null, 2, null);
        for (IChannelTracker iChannelTracker : channelsToResetByEntryAction) {
            JSONArray lastReceivedIds = iChannelTracker.getLastReceivedIds();
            Logging.debug$default("InfluenceManager.restartSessionIfNeeded: lastIds: " + lastReceivedIds, null, 2, null);
            Influence currentSessionInfluence = iChannelTracker.getCurrentSessionInfluence();
            if (lastReceivedIds.length() > 0) {
                sessionTracker = setSessionTracker(iChannelTracker, InfluenceType.INDIRECT, null, lastReceivedIds);
            } else {
                sessionTracker = setSessionTracker(iChannelTracker, InfluenceType.UNATTRIBUTED, null, null);
            }
            if (sessionTracker) {
                arrayList.add(currentSessionInfluence);
            }
        }
    }

    private final boolean setSessionTracker(IChannelTracker channelTracker, InfluenceType influenceType, String directNotificationId, JSONArray indirectNotificationIds) {
        if (!willChangeSessionTracker(channelTracker, influenceType, directNotificationId, indirectNotificationIds)) {
            return false;
        }
        Logging.debug$default(StringsKt.trimIndent("\n            ChannelTracker changed: " + channelTracker.getIdTag() + "\n            from:\n            influenceType: " + channelTracker.getInfluenceType() + ", directNotificationId: " + channelTracker.getDirectId() + ", indirectNotificationIds: " + channelTracker.getIndirectIds() + "\n            to:\n            influenceType: " + influenceType + ", directNotificationId: " + directNotificationId + ", indirectNotificationIds: " + indirectNotificationIds + "\n            "), null, 2, null);
        channelTracker.setInfluenceType(influenceType);
        channelTracker.setDirectId(directNotificationId);
        channelTracker.setIndirectIds(indirectNotificationIds);
        channelTracker.cacheState();
        StringBuilder sb = new StringBuilder("InfluenceManager.setSessionTracker: Trackers changed to: ");
        sb.append(getChannels());
        Logging.debug$default(sb.toString(), null, 2, null);
        return true;
    }

    private final boolean willChangeSessionTracker(IChannelTracker channelTracker, InfluenceType influenceType, String directNotificationId, JSONArray indirectNotificationIds) {
        if (influenceType != channelTracker.getInfluenceType()) {
            return true;
        }
        InfluenceType influenceType2 = channelTracker.getInfluenceType();
        if ((influenceType2 != null && influenceType2.isDirect()) && channelTracker.getDirectId() != null && !Intrinsics.areEqual(channelTracker.getDirectId(), directNotificationId)) {
            return true;
        }
        if ((influenceType2 != null && influenceType2.isIndirect()) && channelTracker.getIndirectIds() != null) {
            JSONArray indirectIds = channelTracker.getIndirectIds();
            Intrinsics.checkNotNull(indirectIds);
            if (indirectIds.length() > 0 && !JSONUtils.INSTANCE.compareJSONArrays(channelTracker.getIndirectIds(), indirectNotificationIds)) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void attemptSessionUpgrade$default(InfluenceManager influenceManager, AppEntryAction appEntryAction, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        influenceManager.attemptSessionUpgrade(appEntryAction, str);
    }

    private final void attemptSessionUpgrade(AppEntryAction entryAction, String directId) {
        Influence influence;
        boolean z;
        Logging.debug$default("InfluenceManager.attemptSessionUpgrade(entryAction: " + entryAction + ", directId: " + directId + ')', null, 2, null);
        IChannelTracker channelByEntryAction = getChannelByEntryAction(entryAction);
        List<IChannelTracker> channelsToResetByEntryAction = getChannelsToResetByEntryAction(entryAction);
        ArrayList arrayList = new ArrayList();
        if (channelByEntryAction != null) {
            influence = channelByEntryAction.getCurrentSessionInfluence();
            InfluenceType influenceType = InfluenceType.DIRECT;
            if (directId == null) {
                directId = channelByEntryAction.getDirectId();
            }
            z = setSessionTracker(channelByEntryAction, influenceType, directId, null);
        } else {
            influence = null;
            z = false;
        }
        if (z) {
            Logging.debug$default("InfluenceManager.attemptSessionUpgrade: channel updated, search for ending direct influences on channels: " + channelsToResetByEntryAction, null, 2, null);
            Intrinsics.checkNotNull(influence);
            arrayList.add(influence);
            for (IChannelTracker iChannelTracker : channelsToResetByEntryAction) {
                InfluenceType influenceType2 = iChannelTracker.getInfluenceType();
                if (influenceType2 != null && influenceType2.isDirect()) {
                    arrayList.add(iChannelTracker.getCurrentSessionInfluence());
                    iChannelTracker.resetAndInitInfluence();
                }
            }
        }
        Logging.debug$default("InfluenceManager.attemptSessionUpgrade: try UNATTRIBUTED to INDIRECT upgrade", null, 2, null);
        for (IChannelTracker iChannelTracker2 : channelsToResetByEntryAction) {
            InfluenceType influenceType3 = iChannelTracker2.getInfluenceType();
            if (influenceType3 != null && influenceType3.isUnattributed()) {
                JSONArray lastReceivedIds = iChannelTracker2.getLastReceivedIds();
                if (lastReceivedIds.length() > 0 && !entryAction.isAppClose()) {
                    Influence currentSessionInfluence = iChannelTracker2.getCurrentSessionInfluence();
                    if (setSessionTracker(iChannelTracker2, InfluenceType.INDIRECT, null, lastReceivedIds)) {
                        arrayList.add(currentSessionInfluence);
                    }
                }
            }
        }
        Logging.debug$default("InfluenceManager.attemptSessionUpgrade: Trackers after update attempt: " + getChannels(), null, 2, null);
    }
}
