package com.onesignal.notifications.internal.lifecycle.impl;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.events.CallbackProducer;
import com.onesignal.common.events.EventProducer;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationReceivedEvent;
import com.onesignal.notifications.INotificationServiceExtension;
import com.onesignal.notifications.INotificationWillDisplayEvent;
import com.onesignal.notifications.internal.NotificationClickEvent;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleEventHandler;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* compiled from: NotificationLifecycleService.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J!\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\"H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0016J)\u0010-\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/H\u0096@ø\u0001\u0000¢\u0006\u0002\u00100J\u0019\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u000203H\u0096@ø\u0001\u0000¢\u0006\u0002\u00104J\u0010\u00105\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u00106\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u00107\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0012\u00108\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016J\u000e\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020;R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006<"}, d2 = {"Lcom/onesignal/notifications/internal/lifecycle/impl/NotificationLifecycleService;", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/time/ITime;)V", "extOpenedCallback", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/notifications/INotificationClickListener;", "extRemoteReceivedCallback", "Lcom/onesignal/common/events/CallbackProducer;", "Lcom/onesignal/notifications/INotificationServiceExtension;", "extWillShowInForegroundCallback", "Lcom/onesignal/notifications/INotificationLifecycleListener;", "intLifecycleCallback", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleCallback;", "intLifecycleHandler", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleEventHandler;", "unprocessedOpenedNotifs", "Lkotlin/collections/ArrayDeque;", "Lorg/json/JSONArray;", "addExternalClickListener", "", "callback", "addExternalForegroundLifecycleListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addInternalNotificationLifecycleEventHandler", "handler", "canOpenNotification", "", "activity", "Landroid/app/Activity;", "data", "Lorg/json/JSONObject;", "(Landroid/app/Activity;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canReceiveNotification", "jsonPayload", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "externalNotificationWillShowInForeground", "willDisplayEvent", "Lcom/onesignal/notifications/INotificationWillDisplayEvent;", "externalRemoteNotificationReceived", "notificationReceivedEvent", "Lcom/onesignal/notifications/INotificationReceivedEvent;", "notificationOpened", "notificationId", "", "(Landroid/app/Activity;Lorg/json/JSONArray;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notificationReceived", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeExternalClickListener", "removeExternalForegroundLifecycleListener", "removeInternalNotificationLifecycleEventHandler", "setInternalNotificationLifecycleCallback", "setupNotificationServiceExtension", "context", "Landroid/content/Context;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationLifecycleService implements INotificationLifecycleService {
    private final ITime _time;
    private final EventProducer<INotificationClickListener> extOpenedCallback;
    private final CallbackProducer<INotificationServiceExtension> extRemoteReceivedCallback;
    private final EventProducer<INotificationLifecycleListener> extWillShowInForegroundCallback;
    private final CallbackProducer<INotificationLifecycleCallback> intLifecycleCallback;
    private final EventProducer<INotificationLifecycleEventHandler> intLifecycleHandler;
    private final ArrayDeque<JSONArray> unprocessedOpenedNotifs;

    public NotificationLifecycleService(IApplicationService applicationService, ITime _time) {
        Intrinsics.checkNotNullParameter(applicationService, "applicationService");
        Intrinsics.checkNotNullParameter(_time, "_time");
        this._time = _time;
        this.intLifecycleHandler = new EventProducer<>();
        this.intLifecycleCallback = new CallbackProducer<>();
        this.extRemoteReceivedCallback = new CallbackProducer<>();
        this.extWillShowInForegroundCallback = new EventProducer<>();
        this.extOpenedCallback = new EventProducer<>();
        this.unprocessedOpenedNotifs = new ArrayDeque<>();
        setupNotificationServiceExtension(applicationService.getAppContext());
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void addInternalNotificationLifecycleEventHandler(INotificationLifecycleEventHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.intLifecycleHandler.subscribe(handler);
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void removeInternalNotificationLifecycleEventHandler(INotificationLifecycleEventHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.intLifecycleHandler.unsubscribe(handler);
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void setInternalNotificationLifecycleCallback(INotificationLifecycleCallback callback) {
        this.intLifecycleCallback.set(callback);
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void addExternalForegroundLifecycleListener(INotificationLifecycleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.extWillShowInForegroundCallback.subscribe(listener);
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void removeExternalForegroundLifecycleListener(INotificationLifecycleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.extWillShowInForegroundCallback.unsubscribe(listener);
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void addExternalClickListener(INotificationClickListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.extOpenedCallback.subscribe(callback);
        if (this.extOpenedCallback.getHasSubscribers() && CollectionsKt.any(this.unprocessedOpenedNotifs)) {
            Iterator it = this.unprocessedOpenedNotifs.iterator();
            while (it.hasNext()) {
                final NotificationClickEvent generateNotificationOpenedResult$com_onesignal_notifications = NotificationHelper.INSTANCE.generateNotificationOpenedResult$com_onesignal_notifications((JSONArray) it.next(), this._time);
                this.extOpenedCallback.fireOnMain(new Function1<INotificationClickListener, Unit>() { // from class: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$addExternalClickListener$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(INotificationClickListener iNotificationClickListener) {
                        invoke2(iNotificationClickListener);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(INotificationClickListener it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        it2.onClick(NotificationClickEvent.this);
                    }
                });
            }
        }
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void removeExternalClickListener(INotificationClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.extOpenedCallback.unsubscribe(listener);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object canReceiveNotification(org.json.JSONObject r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$1
            if (r0 == 0) goto L14
            r0 = r8
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$1 r0 = (com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$1 r0 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$1
            r0.<init>(r6, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$BooleanRef r7 = (kotlin.jvm.internal.Ref.BooleanRef) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L56
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            r8.element = r3
            com.onesignal.common.events.CallbackProducer<com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback> r2 = r6.intLifecycleCallback
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$2 r4 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$2
            r5 = 0
            r4.<init>(r8, r7, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = r2.suspendingFire(r4, r0)
            if (r7 != r1) goto L55
            return r1
        L55:
            r7 = r8
        L56:
            boolean r7 = r7.element
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canReceiveNotification(org.json.JSONObject, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public Object notificationReceived(NotificationGenerationJob notificationGenerationJob, Continuation<? super Unit> continuation) {
        Object suspendingFire = this.intLifecycleHandler.suspendingFire(new NotificationLifecycleService$notificationReceived$2(notificationGenerationJob, null), continuation);
        return suspendingFire == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? suspendingFire : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object canOpenNotification(android.app.Activity r7, org.json.JSONObject r8, kotlin.coroutines.Continuation<? super java.lang.Boolean> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$1
            if (r0 == 0) goto L14
            r0 = r9
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$1 r0 = (com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$1 r0 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$1
            r0.<init>(r6, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$BooleanRef r7 = (kotlin.jvm.internal.Ref.BooleanRef) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5c
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.jvm.internal.Ref$BooleanRef r9 = new kotlin.jvm.internal.Ref$BooleanRef
            r9.<init>()
            com.onesignal.common.events.EventProducer<com.onesignal.notifications.INotificationClickListener> r2 = r6.extOpenedCallback
            boolean r2 = r2.getHasSubscribers()
            r9.element = r2
            com.onesignal.common.events.CallbackProducer<com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback> r2 = r6.intLifecycleCallback
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$2 r4 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$2
            r5 = 0
            r4.<init>(r9, r7, r8, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r7 = r2.suspendingFire(r4, r0)
            if (r7 != r1) goto L5b
            return r1
        L5b:
            r7 = r9
        L5c:
            boolean r7 = r7.element
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canOpenNotification(android.app.Activity, org.json.JSONObject, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object notificationOpened(android.app.Activity r6, org.json.JSONArray r7, java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$1
            if (r0 == 0) goto L14
            r0 = r9
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$1 r0 = (com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$1 r0 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$1
            r0.<init>(r5, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.L$1
            r7 = r6
            org.json.JSONArray r7 = (org.json.JSONArray) r7
            java.lang.Object r6 = r0.L$0
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService r6 = (com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L56
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.ResultKt.throwOnFailure(r9)
            com.onesignal.common.events.EventProducer<com.onesignal.notifications.internal.lifecycle.INotificationLifecycleEventHandler> r9 = r5.intLifecycleHandler
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$2 r2 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$2
            r4 = 0
            r2.<init>(r6, r7, r8, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.L$0 = r5
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r6 = r9.suspendingFire(r2, r0)
            if (r6 != r1) goto L55
            return r1
        L55:
            r6 = r5
        L56:
            com.onesignal.common.events.EventProducer<com.onesignal.notifications.INotificationClickListener> r8 = r6.extOpenedCallback
            boolean r8 = r8.getHasSubscribers()
            if (r8 == 0) goto L73
            com.onesignal.notifications.internal.common.NotificationHelper r8 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
            com.onesignal.core.internal.time.ITime r9 = r6._time
            com.onesignal.notifications.internal.NotificationClickEvent r7 = r8.generateNotificationOpenedResult$com_onesignal_notifications(r7, r9)
            com.onesignal.common.events.EventProducer<com.onesignal.notifications.INotificationClickListener> r6 = r6.extOpenedCallback
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$3 r8 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$3
            r8.<init>()
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r6.fireOnMain(r8)
            goto L78
        L73:
            kotlin.collections.ArrayDeque<org.json.JSONArray> r6 = r6.unprocessedOpenedNotifs
            r6.add(r7)
        L78:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.notificationOpened(android.app.Activity, org.json.JSONArray, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void externalRemoteNotificationReceived(final INotificationReceivedEvent notificationReceivedEvent) {
        Intrinsics.checkNotNullParameter(notificationReceivedEvent, "notificationReceivedEvent");
        this.extRemoteReceivedCallback.fire(new Function1<INotificationServiceExtension, Unit>() { // from class: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$externalRemoteNotificationReceived$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(INotificationServiceExtension iNotificationServiceExtension) {
                invoke2(iNotificationServiceExtension);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(INotificationServiceExtension it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onNotificationReceived(INotificationReceivedEvent.this);
            }
        });
    }

    @Override // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void externalNotificationWillShowInForeground(final INotificationWillDisplayEvent willDisplayEvent) {
        Intrinsics.checkNotNullParameter(willDisplayEvent, "willDisplayEvent");
        this.extWillShowInForegroundCallback.fire(new Function1<INotificationLifecycleListener, Unit>() { // from class: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$externalNotificationWillShowInForeground$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(INotificationLifecycleListener iNotificationLifecycleListener) {
                invoke2(iNotificationLifecycleListener);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(INotificationLifecycleListener it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onWillDisplay(INotificationWillDisplayEvent.this);
            }
        });
    }

    public final void setupNotificationServiceExtension(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String manifestMeta = AndroidUtils.INSTANCE.getManifestMeta(context, NotificationConstants.EXTENSION_SERVICE_META_DATA_TAG_NAME);
        if (manifestMeta == null) {
            Logging.verbose$default("No class found, not setting up OSRemoteNotificationReceivedHandler", null, 2, null);
            return;
        }
        Logging.verbose$default("Found class: " + manifestMeta + ", attempting to call constructor", null, 2, null);
        try {
            Object newInstance = Class.forName(manifestMeta).newInstance();
            if (!(newInstance instanceof INotificationServiceExtension) || this.extRemoteReceivedCallback.getHasCallback()) {
                return;
            }
            this.extRemoteReceivedCallback.set(newInstance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
    }
}
