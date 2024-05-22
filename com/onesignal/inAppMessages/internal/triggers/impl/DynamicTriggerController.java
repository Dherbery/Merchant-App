package com.onesignal.inAppMessages.internal.triggers.impl;

import com.onesignal.common.events.EventProducer;
import com.onesignal.common.events.IEventNotifier;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.BuildConfig;
import com.onesignal.inAppMessages.internal.Trigger;
import com.onesignal.inAppMessages.internal.state.InAppStateService;
import com.onesignal.inAppMessages.internal.triggers.ITriggerHandler;
import com.onesignal.session.internal.session.ISessionService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicTriggerController.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017J \u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/impl/DynamicTriggerController;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerHandler;", "_state", "Lcom/onesignal/inAppMessages/internal/state/InAppStateService;", "_session", "Lcom/onesignal/session/internal/session/ISessionService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/inAppMessages/internal/state/InAppStateService;Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/core/internal/time/ITime;)V", "events", "Lcom/onesignal/common/events/EventProducer;", "getEvents", "()Lcom/onesignal/common/events/EventProducer;", "hasSubscribers", "", "getHasSubscribers", "()Z", "scheduledMessages", "", "", "dynamicTriggerShouldFire", "trigger", "Lcom/onesignal/inAppMessages/internal/Trigger;", "evaluateTimeIntervalWithOperator", "timeInterval", "", "currentTimeInterval", "operator", "Lcom/onesignal/inAppMessages/internal/Trigger$OSTriggerOperator;", "roughlyEqual", "left", "right", "subscribe", "", "handler", "unsubscribe", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class DynamicTriggerController implements IEventNotifier<ITriggerHandler> {
    private static final long DEFAULT_LAST_IN_APP_TIME_AGO = 999999;
    private static final double REQUIRED_ACCURACY = 0.3d;
    private final ISessionService _session;
    private final InAppStateService _state;
    private final ITime _time;
    private final EventProducer<ITriggerHandler> events;
    private final List<String> scheduledMessages;

    /* compiled from: DynamicTriggerController.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Trigger.OSTriggerKind.values().length];
            iArr[Trigger.OSTriggerKind.SESSION_TIME.ordinal()] = 1;
            iArr[Trigger.OSTriggerKind.TIME_SINCE_LAST_IN_APP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Trigger.OSTriggerOperator.values().length];
            iArr2[Trigger.OSTriggerOperator.LESS_THAN.ordinal()] = 1;
            iArr2[Trigger.OSTriggerOperator.LESS_THAN_OR_EQUAL_TO.ordinal()] = 2;
            iArr2[Trigger.OSTriggerOperator.GREATER_THAN.ordinal()] = 3;
            iArr2[Trigger.OSTriggerOperator.GREATER_THAN_OR_EQUAL_TO.ordinal()] = 4;
            iArr2[Trigger.OSTriggerOperator.EQUAL_TO.ordinal()] = 5;
            iArr2[Trigger.OSTriggerOperator.NOT_EQUAL_TO.ordinal()] = 6;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public DynamicTriggerController(InAppStateService _state, ISessionService _session, ITime _time) {
        Intrinsics.checkNotNullParameter(_state, "_state");
        Intrinsics.checkNotNullParameter(_session, "_session");
        Intrinsics.checkNotNullParameter(_time, "_time");
        this._state = _state;
        this._session = _session;
        this._time = _time;
        this.events = new EventProducer<>();
        this.scheduledMessages = new ArrayList();
    }

    public final EventProducer<ITriggerHandler> getEvents() {
        return this.events;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0088 A[Catch: all -> 0x00bd, TRY_LEAVE, TryCatch #0 {, blocks: (B:8:0x0014, B:12:0x001e, B:17:0x0062, B:19:0x0088, B:26:0x00a0, B:30:0x00aa, B:33:0x0033, B:37:0x003d, B:41:0x0049, B:42:0x0060, B:43:0x0054), top: B:7:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean dynamicTriggerShouldFire(com.onesignal.inAppMessages.internal.Trigger r18) {
        /*
            r17 = this;
            r7 = r17
            java.lang.String r0 = "trigger"
            r1 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.Object r0 = r18.getValue()
            r8 = 0
            if (r0 != 0) goto L11
            return r8
        L11:
            java.util.List<java.lang.String> r9 = r7.scheduledMessages
            monitor-enter(r9)
            java.lang.Object r0 = r18.getValue()     // Catch: java.lang.Throwable -> Lbd
            boolean r0 = r0 instanceof java.lang.Number     // Catch: java.lang.Throwable -> Lbd
            if (r0 != 0) goto L1e
            monitor-exit(r9)
            return r8
        L1e:
            com.onesignal.inAppMessages.internal.Trigger$OSTriggerKind r0 = r18.getKind()     // Catch: java.lang.Throwable -> Lbd
            int[] r2 = com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController.WhenMappings.$EnumSwitchMapping$0     // Catch: java.lang.Throwable -> Lbd
            int r0 = r0.ordinal()     // Catch: java.lang.Throwable -> Lbd
            r0 = r2[r0]     // Catch: java.lang.Throwable -> Lbd
            r10 = 1
            if (r0 == r10) goto L54
            r2 = 2
            if (r0 == r2) goto L33
            r13 = 0
            goto L62
        L33:
            com.onesignal.inAppMessages.internal.state.InAppStateService r0 = r7._state     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r0 = r0.getInAppMessageIdShowing()     // Catch: java.lang.Throwable -> Lbd
            if (r0 == 0) goto L3d
            monitor-exit(r9)
            return r8
        L3d:
            com.onesignal.inAppMessages.internal.state.InAppStateService r0 = r7._state     // Catch: java.lang.Throwable -> Lbd
            java.lang.Long r0 = r0.getLastTimeInAppDismissed()     // Catch: java.lang.Throwable -> Lbd
            if (r0 != 0) goto L49
            r2 = 999999(0xf423f, double:4.94065E-318)
            goto L61
        L49:
            com.onesignal.core.internal.time.ITime r2 = r7._time     // Catch: java.lang.Throwable -> Lbd
            long r2 = r2.getCurrentTimeMillis()     // Catch: java.lang.Throwable -> Lbd
            long r4 = r0.longValue()     // Catch: java.lang.Throwable -> Lbd
            goto L60
        L54:
            com.onesignal.core.internal.time.ITime r0 = r7._time     // Catch: java.lang.Throwable -> Lbd
            long r2 = r0.getCurrentTimeMillis()     // Catch: java.lang.Throwable -> Lbd
            com.onesignal.session.internal.session.ISessionService r0 = r7._session     // Catch: java.lang.Throwable -> Lbd
            long r4 = r0.getStartTime()     // Catch: java.lang.Throwable -> Lbd
        L60:
            long r2 = r2 - r4
        L61:
            r13 = r2
        L62:
            java.lang.String r0 = r18.getTriggerId()     // Catch: java.lang.Throwable -> Lbd
            java.lang.Object r2 = r18.getValue()     // Catch: java.lang.Throwable -> Lbd
            java.lang.Number r2 = (java.lang.Number) r2     // Catch: java.lang.Throwable -> Lbd
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch: java.lang.Throwable -> Lbd
            double r2 = r2.doubleValue()     // Catch: java.lang.Throwable -> Lbd
            r4 = 1000(0x3e8, float:1.401E-42)
            double r4 = (double) r4     // Catch: java.lang.Throwable -> Lbd
            double r2 = r2 * r4
            long r4 = (long) r2     // Catch: java.lang.Throwable -> Lbd
            double r2 = (double) r4     // Catch: java.lang.Throwable -> Lbd
            double r11 = (double) r13     // Catch: java.lang.Throwable -> Lbd
            com.onesignal.inAppMessages.internal.Trigger$OSTriggerOperator r6 = r18.getOperatorType()     // Catch: java.lang.Throwable -> Lbd
            r1 = r17
            r15 = r4
            r4 = r11
            boolean r1 = r1.evaluateTimeIntervalWithOperator(r2, r4, r6)     // Catch: java.lang.Throwable -> Lbd
            if (r1 == 0) goto L96
            com.onesignal.common.events.EventProducer<com.onesignal.inAppMessages.internal.triggers.ITriggerHandler> r1 = r7.events     // Catch: java.lang.Throwable -> Lbd
            com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController$dynamicTriggerShouldFire$1$1 r2 = new com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController$dynamicTriggerShouldFire$1$1     // Catch: java.lang.Throwable -> Lbd
            r2.<init>()     // Catch: java.lang.Throwable -> Lbd
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch: java.lang.Throwable -> Lbd
            r1.fire(r2)     // Catch: java.lang.Throwable -> Lbd
            monitor-exit(r9)
            return r10
        L96:
            long r4 = r15 - r13
            r1 = 0
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 > 0) goto La0
            monitor-exit(r9)
            return r8
        La0:
            java.util.List<java.lang.String> r1 = r7.scheduledMessages     // Catch: java.lang.Throwable -> Lbd
            boolean r1 = r1.contains(r0)     // Catch: java.lang.Throwable -> Lbd
            if (r1 == 0) goto Laa
            monitor-exit(r9)
            return r8
        Laa:
            com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerTimer r1 = com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerTimer.INSTANCE     // Catch: java.lang.Throwable -> Lbd
            com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController$dynamicTriggerShouldFire$1$2 r2 = new com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController$dynamicTriggerShouldFire$1$2     // Catch: java.lang.Throwable -> Lbd
            r2.<init>()     // Catch: java.lang.Throwable -> Lbd
            java.util.TimerTask r2 = (java.util.TimerTask) r2     // Catch: java.lang.Throwable -> Lbd
            r1.scheduleTrigger(r2, r0, r4)     // Catch: java.lang.Throwable -> Lbd
            java.util.List<java.lang.String> r1 = r7.scheduledMessages     // Catch: java.lang.Throwable -> Lbd
            r1.add(r0)     // Catch: java.lang.Throwable -> Lbd
            monitor-exit(r9)
            return r8
        Lbd:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController.dynamicTriggerShouldFire(com.onesignal.inAppMessages.internal.Trigger):boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    private final boolean evaluateTimeIntervalWithOperator(double timeInterval, double currentTimeInterval, Trigger.OSTriggerOperator operator) {
        switch (WhenMappings.$EnumSwitchMapping$1[operator.ordinal()]) {
            case 1:
                if (currentTimeInterval < timeInterval) {
                    return true;
                }
                return false;
            case 2:
                if (currentTimeInterval <= timeInterval || roughlyEqual(timeInterval, currentTimeInterval)) {
                    return true;
                }
                return false;
            case 3:
                if (currentTimeInterval >= timeInterval) {
                    return true;
                }
                return false;
            case 4:
                if (currentTimeInterval >= timeInterval || roughlyEqual(timeInterval, currentTimeInterval)) {
                    return true;
                }
                return false;
            case 5:
                return roughlyEqual(timeInterval, currentTimeInterval);
            case 6:
                if (!roughlyEqual(timeInterval, currentTimeInterval)) {
                    return true;
                }
                return false;
            default:
                Logging.error$default("Attempted to apply an invalid operator on a time-based in-app-message trigger: " + operator, null, 2, null);
                return false;
        }
    }

    private final boolean roughlyEqual(double left, double right) {
        return Math.abs(left - right) < REQUIRED_ACCURACY;
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(ITriggerHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.events.subscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(ITriggerHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.events.unsubscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.events.getHasSubscribers();
    }
}
