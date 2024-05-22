package com.onesignal.session.internal.session.impl;

import com.onesignal.common.events.EventProducer;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.session.internal.session.SessionModel;
import com.onesignal.session.internal.session.SessionModelStore;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionService.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0011\u0010 \u001a\u00020!H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u001cH\u0016J\u0010\u0010(\u001a\u00020!2\u0006\u0010'\u001a\u00020\u001cH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/onesignal/session/internal/session/impl/SessionService;", "Lcom/onesignal/session/internal/session/ISessionService;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/core/internal/background/IBackgroundService;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_sessionModelStore", "Lcom/onesignal/session/internal/session/SessionModelStore;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/session/internal/session/SessionModelStore;Lcom/onesignal/core/internal/time/ITime;)V", "config", "Lcom/onesignal/core/internal/config/ConfigModel;", "hasSubscribers", "", "getHasSubscribers", "()Z", "scheduleBackgroundRunIn", "", "getScheduleBackgroundRunIn", "()Ljava/lang/Long;", OutcomeEventsTable.COLUMN_NAME_SESSION, "Lcom/onesignal/session/internal/session/SessionModel;", "sessionLifeCycleNotifier", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "startTime", "getStartTime", "()J", "backgroundRun", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFocus", "onUnfocused", "start", "subscribe", "handler", "unsubscribe", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class SessionService implements ISessionService, IStartableService, IBackgroundService, IApplicationLifecycleHandler {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final SessionModelStore _sessionModelStore;
    private final ITime _time;
    private ConfigModel config;
    private SessionModel session;
    private final EventProducer<ISessionLifecycleHandler> sessionLifeCycleNotifier;

    public SessionService(IApplicationService _applicationService, ConfigModelStore _configModelStore, SessionModelStore _sessionModelStore, ITime _time) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_sessionModelStore, "_sessionModelStore");
        Intrinsics.checkNotNullParameter(_time, "_time");
        this._applicationService = _applicationService;
        this._configModelStore = _configModelStore;
        this._sessionModelStore = _sessionModelStore;
        this._time = _time;
        this.sessionLifeCycleNotifier = new EventProducer<>();
    }

    @Override // com.onesignal.session.internal.session.ISessionService
    public long getStartTime() {
        SessionModel sessionModel = this.session;
        Intrinsics.checkNotNull(sessionModel);
        return sessionModel.getStartTime();
    }

    @Override // com.onesignal.core.internal.background.IBackgroundService
    public Long getScheduleBackgroundRunIn() {
        SessionModel sessionModel = this.session;
        Intrinsics.checkNotNull(sessionModel);
        if (!sessionModel.isValid()) {
            return null;
        }
        ConfigModel configModel = this.config;
        Intrinsics.checkNotNull(configModel);
        return Long.valueOf(configModel.getSessionFocusTimeout());
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this.session = this._sessionModelStore.getModel();
        this.config = this._configModelStore.getModel();
        this._applicationService.addApplicationLifecycleHandler(this);
    }

    @Override // com.onesignal.core.internal.background.IBackgroundService
    public Object backgroundRun(Continuation<? super Unit> continuation) {
        Logging.log(LogLevel.DEBUG, "SessionService.backgroundRun()");
        SessionModel sessionModel = this.session;
        Intrinsics.checkNotNull(sessionModel);
        if (!sessionModel.isValid()) {
            return Unit.INSTANCE;
        }
        StringBuilder sb = new StringBuilder("SessionService: Session ended. activeDuration: ");
        SessionModel sessionModel2 = this.session;
        Intrinsics.checkNotNull(sessionModel2);
        sb.append(sessionModel2.getActiveDuration());
        Logging.debug$default(sb.toString(), null, 2, null);
        SessionModel sessionModel3 = this.session;
        Intrinsics.checkNotNull(sessionModel3);
        sessionModel3.setValid(false);
        this.sessionLifeCycleNotifier.fire(new Function1<ISessionLifecycleHandler, Unit>() { // from class: com.onesignal.session.internal.session.impl.SessionService$backgroundRun$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ISessionLifecycleHandler iSessionLifecycleHandler) {
                invoke2(iSessionLifecycleHandler);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ISessionLifecycleHandler it) {
                SessionModel sessionModel4;
                Intrinsics.checkNotNullParameter(it, "it");
                sessionModel4 = SessionService.this.session;
                Intrinsics.checkNotNull(sessionModel4);
                it.onSessionEnded(sessionModel4.getActiveDuration());
            }
        });
        return Unit.INSTANCE;
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus() {
        Logging.log(LogLevel.DEBUG, "SessionService.onFocus()");
        SessionModel sessionModel = this.session;
        Intrinsics.checkNotNull(sessionModel);
        if (!sessionModel.isValid()) {
            SessionModel sessionModel2 = this.session;
            Intrinsics.checkNotNull(sessionModel2);
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            sessionModel2.setSessionId(uuid);
            SessionModel sessionModel3 = this.session;
            Intrinsics.checkNotNull(sessionModel3);
            sessionModel3.setStartTime(this._time.getCurrentTimeMillis());
            SessionModel sessionModel4 = this.session;
            Intrinsics.checkNotNull(sessionModel4);
            SessionModel sessionModel5 = this.session;
            Intrinsics.checkNotNull(sessionModel5);
            sessionModel4.setFocusTime(sessionModel5.getStartTime());
            SessionModel sessionModel6 = this.session;
            Intrinsics.checkNotNull(sessionModel6);
            sessionModel6.setActiveDuration(0L);
            SessionModel sessionModel7 = this.session;
            Intrinsics.checkNotNull(sessionModel7);
            sessionModel7.setValid(true);
            StringBuilder sb = new StringBuilder("SessionService: New session started at ");
            SessionModel sessionModel8 = this.session;
            Intrinsics.checkNotNull(sessionModel8);
            sb.append(sessionModel8.getStartTime());
            Logging.debug$default(sb.toString(), null, 2, null);
            this.sessionLifeCycleNotifier.fire(new Function1<ISessionLifecycleHandler, Unit>() { // from class: com.onesignal.session.internal.session.impl.SessionService$onFocus$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ISessionLifecycleHandler iSessionLifecycleHandler) {
                    invoke2(iSessionLifecycleHandler);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ISessionLifecycleHandler it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onSessionStarted();
                }
            });
            return;
        }
        SessionModel sessionModel9 = this.session;
        Intrinsics.checkNotNull(sessionModel9);
        sessionModel9.setFocusTime(this._time.getCurrentTimeMillis());
        this.sessionLifeCycleNotifier.fire(new Function1<ISessionLifecycleHandler, Unit>() { // from class: com.onesignal.session.internal.session.impl.SessionService$onFocus$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ISessionLifecycleHandler iSessionLifecycleHandler) {
                invoke2(iSessionLifecycleHandler);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ISessionLifecycleHandler it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onSessionActive();
            }
        });
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
        Logging.log(LogLevel.DEBUG, "SessionService.onUnfocused()");
        long currentTimeMillis = this._time.getCurrentTimeMillis();
        SessionModel sessionModel = this.session;
        Intrinsics.checkNotNull(sessionModel);
        long focusTime = currentTimeMillis - sessionModel.getFocusTime();
        SessionModel sessionModel2 = this.session;
        Intrinsics.checkNotNull(sessionModel2);
        sessionModel2.setActiveDuration(sessionModel2.getActiveDuration() + focusTime);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(ISessionLifecycleHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.sessionLifeCycleNotifier.subscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(ISessionLifecycleHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.sessionLifeCycleNotifier.unsubscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.sessionLifeCycleNotifier.getHasSubscribers();
    }
}
