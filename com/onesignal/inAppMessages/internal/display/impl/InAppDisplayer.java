package com.onesignal.inAppMessages.internal.display.impl;

import com.facebook.common.util.UriUtil;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.BuildConfig;
import com.onesignal.inAppMessages.internal.backend.IInAppBackendService;
import com.onesignal.inAppMessages.internal.display.IInAppDisplayer;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory;
import com.onesignal.session.internal.influence.IInfluenceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InAppDisplayer.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 (2\u00020\u0001:\u0001(BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ)\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J!\u0010&\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/InAppDisplayer;", "Lcom/onesignal/inAppMessages/internal/display/IInAppDisplayer;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_lifecycle", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;", "_promptFactory", "Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;", "_backend", "Lcom/onesignal/inAppMessages/internal/backend/IInAppBackendService;", "_influenceManager", "Lcom/onesignal/session/internal/influence/IInfluenceManager;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;Lcom/onesignal/inAppMessages/internal/backend/IInAppBackendService;Lcom/onesignal/session/internal/influence/IInfluenceManager;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/language/ILanguageContext;Lcom/onesignal/core/internal/time/ITime;)V", "lastInstance", "Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager;", "dismissCurrentInAppMessage", "", "displayMessage", "", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayPreviewMessage", "previewUUID", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initInAppMessage", "currentActivity", "Landroid/app/Activity;", UriUtil.LOCAL_CONTENT_SCHEME, "Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "(Landroid/app/Activity;Lcom/onesignal/inAppMessages/internal/InAppMessage;Lcom/onesignal/inAppMessages/internal/InAppMessageContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showMessageContent", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lcom/onesignal/inAppMessages/internal/InAppMessageContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppDisplayer implements IInAppDisplayer {
    private static final int IN_APP_MESSAGE_INIT_DELAY = 200;
    private final IApplicationService _applicationService;
    private final IInAppBackendService _backend;
    private final ConfigModelStore _configModelStore;
    private final IInfluenceManager _influenceManager;
    private final ILanguageContext _languageContext;
    private final IInAppLifecycleService _lifecycle;
    private final IInAppMessagePromptFactory _promptFactory;
    private final ITime _time;
    private WebViewManager lastInstance;

    public InAppDisplayer(IApplicationService _applicationService, IInAppLifecycleService _lifecycle, IInAppMessagePromptFactory _promptFactory, IInAppBackendService _backend, IInfluenceManager _influenceManager, ConfigModelStore _configModelStore, ILanguageContext _languageContext, ITime _time) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_lifecycle, "_lifecycle");
        Intrinsics.checkNotNullParameter(_promptFactory, "_promptFactory");
        Intrinsics.checkNotNullParameter(_backend, "_backend");
        Intrinsics.checkNotNullParameter(_influenceManager, "_influenceManager");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_languageContext, "_languageContext");
        Intrinsics.checkNotNullParameter(_time, "_time");
        this._applicationService = _applicationService;
        this._lifecycle = _lifecycle;
        this._promptFactory = _promptFactory;
        this._backend = _backend;
        this._influenceManager = _influenceManager;
        this._configModelStore = _configModelStore;
        this._languageContext = _languageContext;
        this._time = _time;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.onesignal.inAppMessages.internal.display.IInAppDisplayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object displayMessage(com.onesignal.inAppMessages.internal.InAppMessage r10, kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayMessage$1
            if (r0 == 0) goto L14
            r0 = r11
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayMessage$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayMessage$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayMessage$1
            r0.<init>(r9, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r11)
            goto La8
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            java.lang.Object r10 = r0.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r10 = (com.onesignal.inAppMessages.internal.InAppMessage) r10
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L6d
        L42:
            kotlin.ResultKt.throwOnFailure(r11)
            com.onesignal.inAppMessages.internal.backend.IInAppBackendService r11 = r9._backend
            com.onesignal.core.internal.config.ConfigModelStore r2 = r9._configModelStore
            com.onesignal.common.modeling.Model r2 = r2.getModel()
            com.onesignal.core.internal.config.ConfigModel r2 = (com.onesignal.core.internal.config.ConfigModel) r2
            java.lang.String r2 = r2.getAppId()
            java.lang.String r5 = r10.getMessageId()
            com.onesignal.inAppMessages.internal.common.InAppHelper r6 = com.onesignal.inAppMessages.internal.common.InAppHelper.INSTANCE
            com.onesignal.core.internal.language.ILanguageContext r7 = r9._languageContext
            java.lang.String r6 = r6.variantIdForMessage(r10, r7)
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r4
            java.lang.Object r11 = r11.getIAMData(r2, r5, r6, r0)
            if (r11 != r1) goto L6c
            return r1
        L6c:
            r2 = r9
        L6d:
            com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse r11 = (com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse) r11
            com.onesignal.inAppMessages.internal.InAppMessageContent r5 = r11.getContent()
            r6 = 0
            if (r5 == 0) goto Lad
            com.onesignal.inAppMessages.internal.InAppMessageContent r5 = r11.getContent()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            java.lang.Double r5 = r5.getDisplayDuration()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            double r7 = r5.doubleValue()
            r10.setDisplayDuration(r7)
            com.onesignal.session.internal.influence.IInfluenceManager r5 = r2._influenceManager
            java.lang.String r7 = r10.getMessageId()
            r5.onInAppMessageDisplayed(r7)
            com.onesignal.inAppMessages.internal.InAppMessageContent r11 = r11.getContent()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r10 = r2.showMessageContent(r10, r11, r0)
            if (r10 != r1) goto La8
            return r1
        La8:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r10
        Lad:
            boolean r10 = r11.getShouldRetry()
            if (r10 == 0) goto Lb7
            r10 = r6
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            goto Lbc
        Lb7:
            r10 = 0
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
        Lbc:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.displayMessage(com.onesignal.inAppMessages.internal.InAppMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.onesignal.inAppMessages.internal.display.IInAppDisplayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object displayPreviewMessage(java.lang.String r9, kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayPreviewMessage$1
            if (r0 == 0) goto L14
            r0 = r10
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayPreviewMessage$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayPreviewMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayPreviewMessage$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayPreviewMessage$1
            r0.<init>(r8, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L8c
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            java.lang.Object r9 = r0.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r9 = (com.onesignal.inAppMessages.internal.InAppMessage) r9
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L6a
        L41:
            kotlin.ResultKt.throwOnFailure(r10)
            com.onesignal.inAppMessages.internal.InAppMessage r10 = new com.onesignal.inAppMessages.internal.InAppMessage
            com.onesignal.core.internal.time.ITime r2 = r8._time
            r10.<init>(r4, r2)
            com.onesignal.inAppMessages.internal.backend.IInAppBackendService r2 = r8._backend
            com.onesignal.core.internal.config.ConfigModelStore r5 = r8._configModelStore
            com.onesignal.common.modeling.Model r5 = r5.getModel()
            com.onesignal.core.internal.config.ConfigModel r5 = (com.onesignal.core.internal.config.ConfigModel) r5
            java.lang.String r5 = r5.getAppId()
            r0.L$0 = r8
            r0.L$1 = r10
            r0.label = r4
            java.lang.Object r9 = r2.getIAMPreviewData(r5, r9, r0)
            if (r9 != r1) goto L66
            return r1
        L66:
            r2 = r8
            r7 = r10
            r10 = r9
            r9 = r7
        L6a:
            com.onesignal.inAppMessages.internal.InAppMessageContent r10 = (com.onesignal.inAppMessages.internal.InAppMessageContent) r10
            if (r10 != 0) goto L70
            r4 = 0
            goto L8c
        L70:
            java.lang.Double r5 = r10.getDisplayDuration()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            double r5 = r5.doubleValue()
            r9.setDisplayDuration(r5)
            r5 = 0
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r9 = r2.showMessageContent(r9, r10, r0)
            if (r9 != r1) goto L8c
            return r1
        L8c:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.displayPreviewMessage(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object showMessageContent(com.onesignal.inAppMessages.internal.InAppMessage r11, com.onesignal.inAppMessages.internal.InAppMessageContent r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.showMessageContent(com.onesignal.inAppMessages.internal.InAppMessage, com.onesignal.inAppMessages.internal.InAppMessageContent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.onesignal.inAppMessages.internal.display.IInAppDisplayer
    public void dismissCurrentInAppMessage() {
        Logging.debug$default("WebViewManager IAM dismissAndAwaitNextMessage lastInstance: " + this.lastInstance, null, 2, null);
        WebViewManager webViewManager = this.lastInstance;
        if (webViewManager != null) {
            Intrinsics.checkNotNull(webViewManager);
            webViewManager.backgroundDismissAndAwaitNextMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|(1:(1:10)(2:14|15))(5:16|17|(1:19)(1:23)|20|(1:22))|11|12))|26|6|7|(0)(0)|11|12) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a2, code lost:
    
        com.onesignal.debug.internal.logging.Logging.error("Catch on initInAppMessage: ", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initInAppMessage(android.app.Activity r18, com.onesignal.inAppMessages.internal.InAppMessage r19, com.onesignal.inAppMessages.internal.InAppMessageContent r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r17 = this;
            r1 = r17
            r0 = r21
            boolean r2 = r0 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$1
            if (r2 == 0) goto L18
            r2 = r0
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$1 r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L1d
        L18:
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$1 r2 = new com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$1
            r2.<init>(r1, r0)
        L1d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L3a
            if (r4 != r5) goto L32
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: java.io.UnsupportedEncodingException -> L2f
            goto La9
        L2f:
            r0 = move-exception
            goto La2
        L32:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L3a:
            kotlin.ResultKt.throwOnFailure(r0)
            java.lang.String r0 = r20.getContentHtml()     // Catch: java.io.UnsupportedEncodingException -> L2f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.io.UnsupportedEncodingException -> L2f
            java.lang.String r4 = "UTF-8"
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)     // Catch: java.io.UnsupportedEncodingException -> L2f
            java.lang.String r6 = "forName(charsetName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)     // Catch: java.io.UnsupportedEncodingException -> L2f
            byte[] r0 = r0.getBytes(r4)     // Catch: java.io.UnsupportedEncodingException -> L2f
            java.lang.String r4 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch: java.io.UnsupportedEncodingException -> L2f
            r4 = 2
            java.lang.String r9 = android.util.Base64.encodeToString(r0, r4)     // Catch: java.io.UnsupportedEncodingException -> L2f
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r7 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager     // Catch: java.io.UnsupportedEncodingException -> L2f
            com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService r14 = r1._lifecycle     // Catch: java.io.UnsupportedEncodingException -> L2f
            com.onesignal.core.internal.application.IApplicationService r15 = r1._applicationService     // Catch: java.io.UnsupportedEncodingException -> L2f
            com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory r0 = r1._promptFactory     // Catch: java.io.UnsupportedEncodingException -> L2f
            r10 = r7
            r11 = r19
            r12 = r18
            r13 = r20
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch: java.io.UnsupportedEncodingException -> L2f
            r1.lastInstance = r7     // Catch: java.io.UnsupportedEncodingException -> L2f
            boolean r0 = r20.getIsFullBleed()     // Catch: java.io.UnsupportedEncodingException -> L2f
            if (r0 == 0) goto L81
            r0 = r18
            r4 = r20
            r7.setContentSafeAreaInsets(r4, r0)     // Catch: java.io.UnsupportedEncodingException -> L2f
            goto L85
        L81:
            r0 = r18
            r4 = r20
        L85:
            kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.io.UnsupportedEncodingException -> L2f
            r12 = r6
            kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12     // Catch: java.io.UnsupportedEncodingException -> L2f
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$2 r13 = new com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$2     // Catch: java.io.UnsupportedEncodingException -> L2f
            r11 = 0
            r6 = r13
            r8 = r18
            r10 = r20
            r6.<init>(r7, r8, r9, r10, r11)     // Catch: java.io.UnsupportedEncodingException -> L2f
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13     // Catch: java.io.UnsupportedEncodingException -> L2f
            r2.label = r5     // Catch: java.io.UnsupportedEncodingException -> L2f
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r12, r13, r2)     // Catch: java.io.UnsupportedEncodingException -> L2f
            if (r0 != r3) goto La9
            return r3
        La2:
            java.lang.String r2 = "Catch on initInAppMessage: "
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            com.onesignal.debug.internal.logging.Logging.error(r2, r0)
        La9:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.initInAppMessage(android.app.Activity, com.onesignal.inAppMessages.internal.InAppMessage, com.onesignal.inAppMessages.internal.InAppMessageContent, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
