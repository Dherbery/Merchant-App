package com.revenuecat.purchases.paywalls.events;

import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.utils.EventsFileHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: PaywallEventsManager.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ \u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0010J\u0010\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8B@BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEventsManager;", "", "fileHelper", "Lcom/revenuecat/purchases/utils/EventsFileHelper;", "Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "paywallEventsDispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "(Lcom/revenuecat/purchases/utils/EventsFileHelper;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/Backend;)V", "<set-?>", "", "flushInProgress", "enqueue", "", "delay", "Lcom/revenuecat/purchases/common/Delay;", "command", "Lkotlin/Function0;", "flushEvents", "getEventsToSync", "", "track", NotificationCompat.CATEGORY_EVENT, "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PaywallEventsManager {
    private static final long FLUSH_COUNT = 50;
    public static final String PAYWALL_EVENTS_FILE_PATH = "RevenueCat/paywall_event_store/paywall_event_store.jsonl";
    private final Backend backend;
    private final EventsFileHelper<PaywallStoredEvent> fileHelper;
    private boolean flushInProgress;
    private final IdentityManager identityManager;
    private final Dispatcher paywallEventsDispatcher;

    public PaywallEventsManager(EventsFileHelper<PaywallStoredEvent> fileHelper, IdentityManager identityManager, Dispatcher paywallEventsDispatcher, Backend backend) {
        Intrinsics.checkNotNullParameter(fileHelper, "fileHelper");
        Intrinsics.checkNotNullParameter(identityManager, "identityManager");
        Intrinsics.checkNotNullParameter(paywallEventsDispatcher, "paywallEventsDispatcher");
        Intrinsics.checkNotNullParameter(backend, "backend");
        this.fileHelper = fileHelper;
        this.identityManager = identityManager;
        this.paywallEventsDispatcher = paywallEventsDispatcher;
        this.backend = backend;
    }

    public final synchronized void track(final PaywallEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        enqueue$default(this, null, new Function0<Unit>() { // from class: com.revenuecat.purchases.paywalls.events.PaywallEventsManager$track$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                EventsFileHelper eventsFileHelper;
                IdentityManager identityManager;
                LogUtilsKt.debugLog("Tracking paywall event: " + PaywallEvent.this);
                eventsFileHelper = this.fileHelper;
                PaywallEvent paywallEvent = PaywallEvent.this;
                identityManager = this.identityManager;
                eventsFileHelper.appendEvent(new PaywallStoredEvent(paywallEvent, identityManager.getCurrentAppUserID()));
            }
        }, 1, null);
    }

    public final synchronized void flushEvents() {
        enqueue$default(this, null, new Function0<Unit>() { // from class: com.revenuecat.purchases.paywalls.events.PaywallEventsManager$flushEvents$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z;
                final List eventsToSync;
                Backend backend;
                z = PaywallEventsManager.this.flushInProgress;
                if (!z) {
                    PaywallEventsManager.this.flushInProgress = true;
                    eventsToSync = PaywallEventsManager.this.getEventsToSync();
                    List filterNotNull = CollectionsKt.filterNotNull(eventsToSync);
                    int size = filterNotNull.size();
                    if (filterNotNull.isEmpty()) {
                        LogUtilsKt.verboseLog("No paywall events to sync.");
                        PaywallEventsManager.this.flushInProgress = false;
                        return;
                    }
                    LogUtilsKt.verboseLog("Paywall event flush: posting " + size + " events.");
                    backend = PaywallEventsManager.this.backend;
                    List list = filterNotNull;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((PaywallStoredEvent) it.next()).toPaywallBackendEvent());
                    }
                    PaywallEventRequest paywallEventRequest = new PaywallEventRequest(arrayList);
                    final PaywallEventsManager paywallEventsManager = PaywallEventsManager.this;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.revenuecat.purchases.paywalls.events.PaywallEventsManager$flushEvents$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            LogUtilsKt.verboseLog("Paywall event flush: success.");
                            PaywallEventsManager paywallEventsManager2 = PaywallEventsManager.this;
                            final PaywallEventsManager paywallEventsManager3 = PaywallEventsManager.this;
                            final List<PaywallStoredEvent> list2 = eventsToSync;
                            PaywallEventsManager.enqueue$default(paywallEventsManager2, null, new Function0<Unit>() { // from class: com.revenuecat.purchases.paywalls.events.PaywallEventsManager.flushEvents.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    EventsFileHelper eventsFileHelper;
                                    eventsFileHelper = PaywallEventsManager.this.fileHelper;
                                    eventsFileHelper.clear(list2.size());
                                    PaywallEventsManager.this.flushInProgress = false;
                                }
                            }, 1, null);
                        }
                    };
                    final PaywallEventsManager paywallEventsManager2 = PaywallEventsManager.this;
                    backend.postPaywallEvents(paywallEventRequest, function0, new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.paywalls.events.PaywallEventsManager$flushEvents$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, Boolean bool) {
                            invoke(purchasesError, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PurchasesError error, final boolean z2) {
                            Intrinsics.checkNotNullParameter(error, "error");
                            LogUtilsKt.errorLog$default("Paywall event flush error: " + error + '.', null, 2, null);
                            PaywallEventsManager paywallEventsManager3 = PaywallEventsManager.this;
                            final PaywallEventsManager paywallEventsManager4 = PaywallEventsManager.this;
                            final List<PaywallStoredEvent> list2 = eventsToSync;
                            PaywallEventsManager.enqueue$default(paywallEventsManager3, null, new Function0<Unit>() { // from class: com.revenuecat.purchases.paywalls.events.PaywallEventsManager.flushEvents.1.3.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    EventsFileHelper eventsFileHelper;
                                    if (z2) {
                                        eventsFileHelper = paywallEventsManager4.fileHelper;
                                        eventsFileHelper.clear(list2.size());
                                    }
                                    paywallEventsManager4.flushInProgress = false;
                                }
                            }, 1, null);
                        }
                    });
                    return;
                }
                LogUtilsKt.debugLog("Flush already in progress.");
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List, T] */
    public final List<PaywallStoredEvent> getEventsToSync() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = CollectionsKt.emptyList();
        this.fileHelper.readFile(new Function1<Stream<PaywallStoredEvent>, Unit>() { // from class: com.revenuecat.purchases.paywalls.events.PaywallEventsManager$getEventsToSync$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Stream<PaywallStoredEvent> stream) {
                invoke2(PathTreeWalk$$ExternalSyntheticApiModelOutline0.m2563m((Object) stream));
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.Object] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Stream<PaywallStoredEvent> stream) {
                Stream limit;
                Collector list;
                ?? collect;
                Intrinsics.checkNotNullParameter(stream, "stream");
                Ref.ObjectRef<List<PaywallStoredEvent>> objectRef2 = objectRef;
                limit = stream.limit(50L);
                list = Collectors.toList();
                collect = limit.collect(list);
                Intrinsics.checkNotNullExpressionValue(collect, "stream.limit(FLUSH_COUNT…lect(Collectors.toList())");
                objectRef2.element = collect;
            }
        });
        return (List) objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void enqueue$default(PaywallEventsManager paywallEventsManager, Delay delay, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            delay = Delay.NONE;
        }
        paywallEventsManager.enqueue(delay, function0);
    }

    private final void enqueue(Delay delay, final Function0<Unit> command) {
        this.paywallEventsDispatcher.enqueue(new Runnable() { // from class: com.revenuecat.purchases.paywalls.events.PaywallEventsManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PaywallEventsManager.enqueue$lambda$0(Function0.this);
            }
        }, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$0(Function0 command) {
        Intrinsics.checkNotNullParameter(command, "$command");
        command.invoke();
    }
}
