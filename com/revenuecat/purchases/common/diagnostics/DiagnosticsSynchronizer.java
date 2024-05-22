package com.revenuecat.purchases.common.diagnostics;

import android.content.Context;
import android.content.SharedPreferences;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogUtilsKt;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* compiled from: DiagnosticsSynchronizer.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\u0006\u0010\u001c\u001a\u00020\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsSynchronizer;", "", "context", "Landroid/content/Context;", "diagnosticsFileHelper", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;", "diagnosticsTracker", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "diagnosticsDispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "sharedPreferences", "Lkotlin/Lazy;", "Landroid/content/SharedPreferences;", "(Landroid/content/Context;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/Dispatcher;Lkotlin/Lazy;)V", "clearConsecutiveNumberOfErrors", "", "clearDiagnosticsFileIfTooBig", "enqueue", "command", "Lkotlin/Function0;", "getEventsToSync", "", "Lorg/json/JSONObject;", "increaseConsecutiveNumberOfErrors", "", "resetDiagnosticsStatus", "syncDiagnosticsFileIfNeeded", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class DiagnosticsSynchronizer {
    public static final String CONSECUTIVE_FAILURES_COUNT_KEY = "consecutive_failures_count";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long MAX_EVENTS_TO_SYNC_PER_REQUEST = 200;
    public static final int MAX_NUMBER_POST_RETRIES = 3;
    private final Backend backend;
    private final Dispatcher diagnosticsDispatcher;
    private final DiagnosticsFileHelper diagnosticsFileHelper;
    private final DiagnosticsTracker diagnosticsTracker;
    private final Lazy<SharedPreferences> sharedPreferences;

    /* JADX WARN: Multi-variable type inference failed */
    public DiagnosticsSynchronizer(Context context, DiagnosticsFileHelper diagnosticsFileHelper, DiagnosticsTracker diagnosticsTracker, Backend backend, Dispatcher diagnosticsDispatcher, Lazy<? extends SharedPreferences> sharedPreferences) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(diagnosticsFileHelper, "diagnosticsFileHelper");
        Intrinsics.checkNotNullParameter(diagnosticsTracker, "diagnosticsTracker");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(diagnosticsDispatcher, "diagnosticsDispatcher");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.diagnosticsFileHelper = diagnosticsFileHelper;
        this.diagnosticsTracker = diagnosticsTracker;
        this.backend = backend;
        this.diagnosticsDispatcher = diagnosticsDispatcher;
        this.sharedPreferences = sharedPreferences;
    }

    public /* synthetic */ DiagnosticsSynchronizer(final Context context, DiagnosticsFileHelper diagnosticsFileHelper, DiagnosticsTracker diagnosticsTracker, Backend backend, Dispatcher dispatcher, Lazy lazy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, diagnosticsFileHelper, diagnosticsTracker, backend, dispatcher, (i & 32) != 0 ? LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                return DiagnosticsSynchronizer.INSTANCE.initializeSharedPreferences(context);
            }
        }) : lazy);
    }

    /* compiled from: DiagnosticsSynchronizer.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsSynchronizer$Companion;", "", "()V", "CONSECUTIVE_FAILURES_COUNT_KEY", "", "getCONSECUTIVE_FAILURES_COUNT_KEY$annotations", "MAX_EVENTS_TO_SYNC_PER_REQUEST", "", "getMAX_EVENTS_TO_SYNC_PER_REQUEST$annotations", "MAX_NUMBER_POST_RETRIES", "", "getMAX_NUMBER_POST_RETRIES$annotations", "initializeSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCONSECUTIVE_FAILURES_COUNT_KEY$annotations() {
        }

        public static /* synthetic */ void getMAX_EVENTS_TO_SYNC_PER_REQUEST$annotations() {
        }

        public static /* synthetic */ void getMAX_NUMBER_POST_RETRIES$annotations() {
        }

        private Companion() {
        }

        public final SharedPreferences initializeSharedPreferences(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com_revenuecat_purchases_" + context.getPackageName() + "_preferences_diagnostics", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…DE_PRIVATE,\n            )");
            return sharedPreferences;
        }
    }

    public final void clearDiagnosticsFileIfTooBig() {
        enqueue(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer$clearDiagnosticsFileIfTooBig$1
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
                DiagnosticsFileHelper diagnosticsFileHelper;
                DiagnosticsTracker diagnosticsTracker;
                diagnosticsFileHelper = DiagnosticsSynchronizer.this.diagnosticsFileHelper;
                if (diagnosticsFileHelper.isDiagnosticsFileTooBig()) {
                    LogUtilsKt.verboseLog("Diagnostics file is too big. Deleting it.");
                    diagnosticsTracker = DiagnosticsSynchronizer.this.diagnosticsTracker;
                    DiagnosticsTracker.trackMaxEventsStoredLimitReached$default(diagnosticsTracker, false, 1, null);
                    DiagnosticsSynchronizer.this.resetDiagnosticsStatus();
                }
            }
        });
    }

    public final void syncDiagnosticsFileIfNeeded() {
        enqueue(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer$syncDiagnosticsFileIfNeeded$1
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
                List<? extends JSONObject> eventsToSync;
                Backend backend;
                try {
                    eventsToSync = DiagnosticsSynchronizer.this.getEventsToSync();
                    final int size = eventsToSync.size();
                    if (size != 0) {
                        backend = DiagnosticsSynchronizer.this.backend;
                        final DiagnosticsSynchronizer diagnosticsSynchronizer = DiagnosticsSynchronizer.this;
                        Function1<JSONObject, Unit> function1 = new Function1<JSONObject, Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer$syncDiagnosticsFileIfNeeded$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                                invoke2(jSONObject);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(JSONObject it) {
                                DiagnosticsFileHelper diagnosticsFileHelper;
                                Intrinsics.checkNotNullParameter(it, "it");
                                LogUtilsKt.verboseLog("Synced diagnostics file successfully.");
                                DiagnosticsSynchronizer.this.clearConsecutiveNumberOfErrors();
                                diagnosticsFileHelper = DiagnosticsSynchronizer.this.diagnosticsFileHelper;
                                diagnosticsFileHelper.clear(size);
                            }
                        };
                        final DiagnosticsSynchronizer diagnosticsSynchronizer2 = DiagnosticsSynchronizer.this;
                        backend.postDiagnostics(eventsToSync, function1, new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer$syncDiagnosticsFileIfNeeded$1.2
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, Boolean bool) {
                                invoke(purchasesError, bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(PurchasesError error, boolean z) {
                                int increaseConsecutiveNumberOfErrors;
                                Intrinsics.checkNotNullParameter(error, "error");
                                if (z) {
                                    LogUtilsKt.verboseLog("Error syncing diagnostics file: " + error + ". Will retry the next time the SDK is initialized");
                                    increaseConsecutiveNumberOfErrors = DiagnosticsSynchronizer.this.increaseConsecutiveNumberOfErrors();
                                    if (increaseConsecutiveNumberOfErrors >= 3) {
                                        LogUtilsKt.verboseLog("Error syncing diagnostics file: " + error + ". This was the final attempt (3). Deleting diagnostics file without posting.");
                                        DiagnosticsSynchronizer.this.resetDiagnosticsStatus();
                                        return;
                                    }
                                    return;
                                }
                                LogUtilsKt.verboseLog("Error syncing diagnostics file: " + error + ". Deleting diagnostics file without retrying.");
                                DiagnosticsSynchronizer.this.resetDiagnosticsStatus();
                            }
                        });
                        return;
                    }
                    LogUtilsKt.verboseLog("No diagnostics to sync.");
                } catch (Exception e) {
                    LogUtilsKt.verboseLog("Error syncing diagnostics file: " + e);
                    try {
                        DiagnosticsSynchronizer.this.resetDiagnosticsStatus();
                    } catch (IOException e2) {
                        LogUtilsKt.verboseLog("Error deleting diagnostics file: " + e2);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List, T] */
    public final List<JSONObject> getEventsToSync() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = CollectionsKt.emptyList();
        this.diagnosticsFileHelper.readFileAsJson(new Function1<Stream<JSONObject>, Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer$getEventsToSync$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Stream<JSONObject> stream) {
                invoke2(PathTreeWalk$$ExternalSyntheticApiModelOutline0.m2563m((Object) stream));
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.Object] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Stream<JSONObject> stream) {
                Stream limit;
                Collector list;
                ?? collect;
                Intrinsics.checkNotNullParameter(stream, "stream");
                Ref.ObjectRef<List<JSONObject>> objectRef2 = objectRef;
                limit = stream.limit(200L);
                list = Collectors.toList();
                collect = limit.collect(list);
                Intrinsics.checkNotNullExpressionValue(collect, "stream.limit(MAX_EVENTS_…lect(Collectors.toList())");
                objectRef2.element = collect;
            }
        });
        return (List) objectRef.element;
    }

    private final void enqueue(final Function0<Unit> command) {
        Dispatcher.enqueue$default(this.diagnosticsDispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DiagnosticsSynchronizer.enqueue$lambda$0(Function0.this);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$0(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearConsecutiveNumberOfErrors() {
        this.sharedPreferences.getValue().edit().remove(CONSECUTIVE_FAILURES_COUNT_KEY).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int increaseConsecutiveNumberOfErrors() {
        int i = this.sharedPreferences.getValue().getInt(CONSECUTIVE_FAILURES_COUNT_KEY, 0) + 1;
        this.sharedPreferences.getValue().edit().putInt(CONSECUTIVE_FAILURES_COUNT_KEY, i).apply();
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetDiagnosticsStatus() {
        clearConsecutiveNumberOfErrors();
        this.diagnosticsFileHelper.deleteFile();
    }
}
