package com.onesignal.core.internal.application.impl;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.Waiter;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.application.ActivityLifecycleHandlerBase;
import com.onesignal.core.internal.application.AppEntryAction;
import com.onesignal.core.internal.application.IActivityLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: ApplicationService.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000bH\u0016J\u0010\u0010)\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0012H\u0016J\u0016\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020'H\u0002J\b\u0010/\u001a\u00020'H\u0002J\u001a\u00100\u001a\u00020'2\u0006\u0010+\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00103\u001a\u00020'2\u0006\u0010+\u001a\u00020\bH\u0016J\u0010\u00104\u001a\u00020'2\u0006\u0010+\u001a\u00020\bH\u0016J\u0010\u00105\u001a\u00020'2\u0006\u0010+\u001a\u00020\bH\u0016J\u0018\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u000202H\u0016J\u0010\u00109\u001a\u00020'2\u0006\u0010+\u001a\u00020\bH\u0016J\u0010\u0010:\u001a\u00020'2\u0006\u0010+\u001a\u00020\bH\u0016J\b\u0010;\u001a\u00020'H\u0016J\u0018\u0010<\u001a\u00020'2\u0006\u0010=\u001a\u00020\r2\u0006\u0010+\u001a\u00020\bH\u0002J\u0010\u0010>\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000bH\u0016J\u0010\u0010?\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0012H\u0016J\u000e\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020\u0006J\u0011\u0010B\u001a\u00020 H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u0011\u0010D\u001a\u00020 H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010CR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\nX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006E"}, d2 = {"Lcom/onesignal/core/internal/application/impl/ApplicationService;", "Lcom/onesignal/core/internal/application/IApplicationService;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "()V", "_appContext", "Landroid/content/Context;", "_current", "Landroid/app/Activity;", "activityLifecycleNotifier", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/core/internal/application/IActivityLifecycleHandler;", "activityReferences", "", "appContext", "getAppContext", "()Landroid/content/Context;", "applicationLifecycleNotifier", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "value", "current", "getCurrent", "()Landroid/app/Activity;", "setCurrent", "(Landroid/app/Activity;)V", "entryState", "Lcom/onesignal/core/internal/application/AppEntryAction;", "getEntryState", "()Lcom/onesignal/core/internal/application/AppEntryAction;", "setEntryState", "(Lcom/onesignal/core/internal/application/AppEntryAction;)V", "isActivityChangingConfigurations", "", "isInForeground", "()Z", "nextResumeIsFirstActivity", "systemConditionNotifier", "Lcom/onesignal/core/internal/application/impl/ISystemConditionHandler;", "addActivityLifecycleHandler", "", "handler", "addApplicationLifecycleHandler", "decorViewReady", "activity", "runnable", "Ljava/lang/Runnable;", "handleFocus", "handleLostFocus", "onActivityCreated", "bundle", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "p0", "p1", "onActivityStarted", "onActivityStopped", "onGlobalLayout", "onOrientationChanged", "orientation", "removeActivityLifecycleHandler", "removeApplicationLifecycleHandler", "start", "context", "waitUntilActivityReady", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitUntilSystemConditionsAvailable", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ApplicationService implements IApplicationService, Application.ActivityLifecycleCallbacks, ViewTreeObserver.OnGlobalLayoutListener {
    private Context _appContext;
    private Activity _current;
    private int activityReferences;
    private boolean isActivityChangingConfigurations;
    private boolean nextResumeIsFirstActivity;
    private final EventProducer<IActivityLifecycleHandler> activityLifecycleNotifier = new EventProducer<>();
    private final EventProducer<IApplicationLifecycleHandler> applicationLifecycleNotifier = new EventProducer<>();
    private final EventProducer<ISystemConditionHandler> systemConditionNotifier = new EventProducer<>();
    private AppEntryAction entryState = AppEntryAction.APP_CLOSE;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public boolean isInForeground() {
        return getEntryState().isAppOpen() || getEntryState().isNotificationClick();
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public AppEntryAction getEntryState() {
        return this.entryState;
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public void setEntryState(AppEntryAction appEntryAction) {
        Intrinsics.checkNotNullParameter(appEntryAction, "<set-?>");
        this.entryState = appEntryAction;
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public Context getAppContext() {
        Context context = this._appContext;
        Intrinsics.checkNotNull(context);
        return context;
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    /* renamed from: getCurrent, reason: from getter */
    public Activity get_current() {
        return this._current;
    }

    public void setCurrent(final Activity activity) {
        this._current = activity;
        Logging.debug$default("ApplicationService: current activity=" + get_current(), null, 2, null);
        if (activity != null) {
            this.activityLifecycleNotifier.fire(new Function1<IActivityLifecycleHandler, Unit>() { // from class: com.onesignal.core.internal.application.impl.ApplicationService$current$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IActivityLifecycleHandler iActivityLifecycleHandler) {
                    invoke2(iActivityLifecycleHandler);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IActivityLifecycleHandler it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onActivityAvailable(activity);
                }
            });
            try {
                activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    public final void start(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this._appContext = context;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        Application application = (Application) applicationContext;
        application.registerActivityLifecycleCallbacks(this);
        application.registerComponentCallbacks(new ComponentCallbacks() { // from class: com.onesignal.core.internal.application.impl.ApplicationService$start$configuration$1
            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration newConfig) {
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                if (ApplicationService.this.get_current() != null) {
                    AndroidUtils androidUtils = AndroidUtils.INSTANCE;
                    Activity activity = ApplicationService.this.get_current();
                    Intrinsics.checkNotNull(activity);
                    if (androidUtils.hasConfigChangeFlag(activity, 128)) {
                        ApplicationService applicationService = ApplicationService.this;
                        int i = newConfig.orientation;
                        Activity activity2 = ApplicationService.this.get_current();
                        Intrinsics.checkNotNull(activity2);
                        applicationService.onOrientationChanged(i, activity2);
                    }
                }
            }
        });
        boolean z = context instanceof Activity;
        boolean z2 = get_current() == null;
        if (!z2 || z) {
            setEntryState(AppEntryAction.APP_OPEN);
            if (z2 && z) {
                setCurrent((Activity) context);
                this.activityReferences = 1;
                this.nextResumeIsFirstActivity = false;
            }
        } else {
            this.nextResumeIsFirstActivity = true;
            setEntryState(AppEntryAction.APP_CLOSE);
        }
        Logging.debug$default("ApplicationService.init: entryState=" + getEntryState(), null, 2, null);
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public void addApplicationLifecycleHandler(IApplicationLifecycleHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.applicationLifecycleNotifier.subscribe(handler);
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public void removeApplicationLifecycleHandler(IApplicationLifecycleHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.applicationLifecycleNotifier.unsubscribe(handler);
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public void addActivityLifecycleHandler(IActivityLifecycleHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.activityLifecycleNotifier.subscribe(handler);
        if (get_current() != null) {
            Activity activity = get_current();
            Intrinsics.checkNotNull(activity);
            handler.onActivityAvailable(activity);
        }
    }

    @Override // com.onesignal.core.internal.application.IApplicationService
    public void removeActivityLifecycleHandler(IActivityLifecycleHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.activityLifecycleNotifier.unsubscribe(handler);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityCreated(" + this.activityReferences + AbstractJsonLexerKt.COMMA + getEntryState() + "): " + activity, null, 2, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityStarted(" + this.activityReferences + AbstractJsonLexerKt.COMMA + getEntryState() + "): " + activity, null, 2, null);
        if (Intrinsics.areEqual(get_current(), activity)) {
            return;
        }
        setCurrent(activity);
        if ((!isInForeground() || this.nextResumeIsFirstActivity) && !this.isActivityChangingConfigurations) {
            this.activityReferences = 1;
            handleFocus();
        } else {
            this.activityReferences++;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityResumed(" + this.activityReferences + AbstractJsonLexerKt.COMMA + getEntryState() + "): " + activity, null, 2, null);
        if (!Intrinsics.areEqual(get_current(), activity)) {
            setCurrent(activity);
        }
        if ((!isInForeground() || this.nextResumeIsFirstActivity) && !this.isActivityChangingConfigurations) {
            this.activityReferences = 1;
            handleFocus();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityPaused(" + this.activityReferences + AbstractJsonLexerKt.COMMA + getEntryState() + "): " + activity, null, 2, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityStopped(" + this.activityReferences + AbstractJsonLexerKt.COMMA + getEntryState() + "): " + activity, null, 2, null);
        boolean isChangingConfigurations = activity.isChangingConfigurations();
        this.isActivityChangingConfigurations = isChangingConfigurations;
        if (!isChangingConfigurations) {
            int i = this.activityReferences - 1;
            this.activityReferences = i;
            if (i <= 0) {
                setCurrent(null);
                this.activityReferences = 0;
                handleLostFocus();
            }
        }
        this.activityLifecycleNotifier.fire(new Function1<IActivityLifecycleHandler, Unit>() { // from class: com.onesignal.core.internal.application.impl.ApplicationService$onActivityStopped$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IActivityLifecycleHandler iActivityLifecycleHandler) {
                invoke2(iActivityLifecycleHandler);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IActivityLifecycleHandler it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onActivityStopped(activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityDestroyed(" + this.activityReferences + AbstractJsonLexerKt.COMMA + getEntryState() + "): " + activity, null, 2, null);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.systemConditionNotifier.fire(new Function1<ISystemConditionHandler, Unit>() { // from class: com.onesignal.core.internal.application.impl.ApplicationService$onGlobalLayout$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ISystemConditionHandler iSystemConditionHandler) {
                invoke2(iSystemConditionHandler);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ISystemConditionHandler it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.systemConditionChanged();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0092 -> B:32:0x005e). Please report as a decompilation issue!!! */
    @Override // com.onesignal.core.internal.application.IApplicationService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object waitUntilSystemConditionsAvailable(kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.application.impl.ApplicationService.waitUntilSystemConditionsAvailable(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.onesignal.core.internal.application.IApplicationService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object waitUntilActivityReady(kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.onesignal.core.internal.application.impl.ApplicationService$waitUntilActivityReady$1
            if (r0 == 0) goto L14
            r0 = r6
            com.onesignal.core.internal.application.impl.ApplicationService$waitUntilActivityReady$1 r0 = (com.onesignal.core.internal.application.impl.ApplicationService$waitUntilActivityReady$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.onesignal.core.internal.application.impl.ApplicationService$waitUntilActivityReady$1 r0 = new com.onesignal.core.internal.application.impl.ApplicationService$waitUntilActivityReady$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L57
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            android.app.Activity r6 = r5.get_current()
            if (r6 != 0) goto L41
            r6 = 0
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r6
        L41:
            com.onesignal.common.threading.Waiter r2 = new com.onesignal.common.threading.Waiter
            r2.<init>()
            com.onesignal.core.internal.application.impl.ApplicationService$$ExternalSyntheticLambda1 r4 = new com.onesignal.core.internal.application.impl.ApplicationService$$ExternalSyntheticLambda1
            r4.<init>()
            r5.decorViewReady(r6, r4)
            r0.label = r3
            java.lang.Object r6 = r2.waitForWake(r0)
            if (r6 != r1) goto L57
            return r1
        L57:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.application.impl.ApplicationService.waitUntilActivityReady(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: waitUntilActivityReady$lambda-0, reason: not valid java name */
    public static final void m1007waitUntilActivityReady$lambda0(Waiter waiter) {
        Intrinsics.checkNotNullParameter(waiter, "$waiter");
        waiter.wake();
    }

    public final void decorViewReady(Activity activity, final Runnable runnable) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Objects.toString(runnable);
        activity.getWindow().getDecorView().post(new Runnable() { // from class: com.onesignal.core.internal.application.impl.ApplicationService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ApplicationService.m1006decorViewReady$lambda1(ApplicationService.this, runnable, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: decorViewReady$lambda-1, reason: not valid java name */
    public static final void m1006decorViewReady$lambda1(final ApplicationService self, final Runnable runnable, final ApplicationService this$0) {
        Intrinsics.checkNotNullParameter(self, "$self");
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        self.addActivityLifecycleHandler(new ActivityLifecycleHandlerBase() { // from class: com.onesignal.core.internal.application.impl.ApplicationService$decorViewReady$1$1
            @Override // com.onesignal.core.internal.application.ActivityLifecycleHandlerBase, com.onesignal.core.internal.application.IActivityLifecycleHandler
            public void onActivityAvailable(Activity currentActivity) {
                Intrinsics.checkNotNullParameter(currentActivity, "currentActivity");
                ApplicationService.this.removeActivityLifecycleHandler(this);
                if (AndroidUtils.INSTANCE.isActivityFullyReady(currentActivity)) {
                    runnable.run();
                } else {
                    this$0.decorViewReady(currentActivity, runnable);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onOrientationChanged(int orientation, final Activity activity) {
        if (orientation == 1) {
            Logging.debug$default("ApplicationService.onOrientationChanged: Configuration Orientation Change: PORTRAIT (" + orientation + ") on activity: " + activity, null, 2, null);
        } else if (orientation == 2) {
            Logging.debug$default("ApplicationService.onOrientationChanged: Configuration Orientation Change: LANDSCAPE (" + orientation + ") on activity: " + activity, null, 2, null);
        }
        handleLostFocus();
        this.activityLifecycleNotifier.fire(new Function1<IActivityLifecycleHandler, Unit>() { // from class: com.onesignal.core.internal.application.impl.ApplicationService$onOrientationChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IActivityLifecycleHandler iActivityLifecycleHandler) {
                invoke2(iActivityLifecycleHandler);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IActivityLifecycleHandler it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onActivityStopped(activity);
            }
        });
        this.activityLifecycleNotifier.fire(new Function1<IActivityLifecycleHandler, Unit>() { // from class: com.onesignal.core.internal.application.impl.ApplicationService$onOrientationChanged$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IActivityLifecycleHandler iActivityLifecycleHandler) {
                invoke2(iActivityLifecycleHandler);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IActivityLifecycleHandler it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onActivityAvailable(activity);
            }
        });
        activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        handleFocus();
    }

    private final void handleLostFocus() {
        if (isInForeground()) {
            Logging.debug$default("ApplicationService.handleLostFocus: application is now out of focus", null, 2, null);
            setEntryState(AppEntryAction.APP_CLOSE);
            this.applicationLifecycleNotifier.fire(new Function1<IApplicationLifecycleHandler, Unit>() { // from class: com.onesignal.core.internal.application.impl.ApplicationService$handleLostFocus$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IApplicationLifecycleHandler iApplicationLifecycleHandler) {
                    invoke2(iApplicationLifecycleHandler);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IApplicationLifecycleHandler it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onUnfocused();
                }
            });
            return;
        }
        Logging.debug$default("ApplicationService.handleLostFocus: application already out of focus", null, 2, null);
    }

    private final void handleFocus() {
        if (!isInForeground() || this.nextResumeIsFirstActivity) {
            Logging.debug$default("ApplicationService.handleFocus: application is now in focus, nextResumeIsFirstActivity=" + this.nextResumeIsFirstActivity, null, 2, null);
            this.nextResumeIsFirstActivity = false;
            if (getEntryState() != AppEntryAction.NOTIFICATION_CLICK) {
                setEntryState(AppEntryAction.APP_OPEN);
            }
            this.applicationLifecycleNotifier.fire(new Function1<IApplicationLifecycleHandler, Unit>() { // from class: com.onesignal.core.internal.application.impl.ApplicationService$handleFocus$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IApplicationLifecycleHandler iApplicationLifecycleHandler) {
                    invoke2(iApplicationLifecycleHandler);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IApplicationLifecycleHandler it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onFocus();
                }
            });
            return;
        }
        Logging.debug$default("ApplicationService.handleFocus: application never lost focus", null, 2, null);
    }
}
