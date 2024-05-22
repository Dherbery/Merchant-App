package com.onesignal.inAppMessages.internal.backend.impl;

import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.BuildConfig;
import com.onesignal.inAppMessages.internal.InAppMessagePage;
import com.onesignal.inAppMessages.internal.backend.IInAppBackendService;
import com.onesignal.inAppMessages.internal.hydrators.InAppHydrator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InAppBackendService.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J$\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0002J)\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\"\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002JE\u0010!\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u000e2\u0006\u0010#\u001a\u00020$H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010%J3\u0010&\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010'J=\u0010(\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/onesignal/inAppMessages/internal/backend/impl/InAppBackendService;", "Lcom/onesignal/inAppMessages/internal/backend/IInAppBackendService;", "_httpClient", "Lcom/onesignal/core/internal/http/IHttpClient;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_hydrator", "Lcom/onesignal/inAppMessages/internal/hydrators/InAppHydrator;", "(Lcom/onesignal/core/internal/http/IHttpClient;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/inAppMessages/internal/hydrators/InAppHydrator;)V", "htmlNetworkRequestAttemptCount", "", "getIAMData", "Lcom/onesignal/inAppMessages/internal/backend/GetIAMDataResponse;", "appId", "", "messageId", "variantId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIAMPreviewData", "Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "previewUUID", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "htmlPathForMessage", "listInAppMessages", "", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "subscriptionId", "printHttpErrorForInAppMessageRequest", "", "requestType", "statusCode", "response", "printHttpSuccessForInAppMessageRequest", "sendIAMClick", "clickId", "isFirstClick", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendIAMImpression", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendIAMPageImpression", InAppMessagePage.PAGE_ID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppBackendService implements IInAppBackendService {
    private final IDeviceService _deviceService;
    private final IHttpClient _httpClient;
    private final InAppHydrator _hydrator;
    private int htmlNetworkRequestAttemptCount;

    public InAppBackendService(IHttpClient _httpClient, IDeviceService _deviceService, InAppHydrator _hydrator) {
        Intrinsics.checkNotNullParameter(_httpClient, "_httpClient");
        Intrinsics.checkNotNullParameter(_deviceService, "_deviceService");
        Intrinsics.checkNotNullParameter(_hydrator, "_hydrator");
        this._httpClient = _httpClient;
        this._deviceService = _deviceService;
        this._hydrator = _hydrator;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0090 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object listInAppMessages(java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super java.util.List<com.onesignal.inAppMessages.internal.InAppMessage>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$listInAppMessages$1
            if (r0 == 0) goto L14
            r0 = r10
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$listInAppMessages$1 r0 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$listInAppMessages$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$listInAppMessages$1 r0 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$listInAppMessages$1
            r0.<init>(r7, r10)
        L19:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r8 = r4.L$0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService r8 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L67
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r10)
            com.onesignal.core.internal.http.IHttpClient r1 = r7._httpClient
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r3 = "apps/"
            r10.<init>(r3)
            r10.append(r8)
            java.lang.String r8 = "/subscriptions/"
            r10.append(r8)
            r10.append(r9)
            java.lang.String r8 = "/iams"
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r3 = 0
            r5 = 2
            r6 = 0
            r4.L$0 = r7
            r4.label = r2
            r2 = r8
            java.lang.Object r10 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.get$default(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L66
            return r0
        L66:
            r8 = r7
        L67:
            com.onesignal.core.internal.http.HttpResponse r10 = (com.onesignal.core.internal.http.HttpResponse) r10
            boolean r9 = r10.isSuccess()
            if (r9 == 0) goto L90
            org.json.JSONObject r9 = new org.json.JSONObject
            java.lang.String r10 = r10.getPayload()
            r9.<init>(r10)
            java.lang.String r10 = "in_app_messages"
            boolean r0 = r9.has(r10)
            if (r0 == 0) goto L90
            org.json.JSONArray r9 = r9.getJSONArray(r10)
            com.onesignal.inAppMessages.internal.hydrators.InAppHydrator r8 = r8._hydrator
            java.lang.String r10 = "iamMessagesAsJSON"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.util.List r8 = r8.hydrateIAMMessages(r9)
            return r8
        L90:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.listInAppMessages(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getIAMData(java.lang.String r7, java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMData$1
            if (r0 == 0) goto L14
            r0 = r10
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMData$1 r0 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMData$1 r0 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMData$1
            r0.<init>(r6, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r7 = r0.L$0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService r7 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L55
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.String r7 = r6.htmlPathForMessage(r8, r9, r7)
            if (r7 != 0) goto L47
            com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse r7 = new com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse
            r7.<init>(r3, r5)
            return r7
        L47:
            com.onesignal.core.internal.http.IHttpClient r8 = r6._httpClient
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r10 = r8.get(r7, r3, r0)
            if (r10 != r1) goto L54
            return r1
        L54:
            r7 = r6
        L55:
            com.onesignal.core.internal.http.HttpResponse r10 = (com.onesignal.core.internal.http.HttpResponse) r10
            boolean r8 = r10.isSuccess()
            if (r8 == 0) goto L77
            r7.htmlNetworkRequestAttemptCount = r5
            org.json.JSONObject r8 = new org.json.JSONObject
            java.lang.String r9 = r10.getPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            r8.<init>(r9)
            com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse r9 = new com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse
            com.onesignal.inAppMessages.internal.hydrators.InAppHydrator r7 = r7._hydrator
            com.onesignal.inAppMessages.internal.InAppMessageContent r7 = r7.hydrateIAMMessageContent(r8)
            r9.<init>(r7, r5)
            return r9
        L77:
            int r8 = r10.getStatusCode()
            java.lang.String r9 = r10.getPayload()
            java.lang.String r0 = "html"
            r7.printHttpErrorForInAppMessageRequest(r0, r8, r9)
            com.onesignal.common.NetworkUtils r8 = com.onesignal.common.NetworkUtils.INSTANCE
            int r9 = r10.getStatusCode()
            com.onesignal.common.NetworkUtils$ResponseStatusType r8 = r8.getResponseStatusType(r9)
            com.onesignal.common.NetworkUtils$ResponseStatusType r9 = com.onesignal.common.NetworkUtils.ResponseStatusType.RETRYABLE
            if (r8 != r9) goto La8
            int r8 = r7.htmlNetworkRequestAttemptCount
            com.onesignal.common.NetworkUtils r9 = com.onesignal.common.NetworkUtils.INSTANCE
            int r9 = r9.getMaxNetworkRequestAttemptCount()
            if (r8 < r9) goto L9d
            goto La8
        L9d:
            int r8 = r7.htmlNetworkRequestAttemptCount
            int r8 = r8 + r4
            r7.htmlNetworkRequestAttemptCount = r8
            com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse r7 = new com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse
            r7.<init>(r3, r4)
            goto Laf
        La8:
            r7.htmlNetworkRequestAttemptCount = r5
            com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse r7 = new com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse
            r7.<init>(r3, r5)
        Laf:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.getIAMData(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getIAMPreviewData(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.onesignal.inAppMessages.internal.InAppMessageContent> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMPreviewData$1
            if (r0 == 0) goto L14
            r0 = r8
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMPreviewData$1 r0 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMPreviewData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMPreviewData$1 r0 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMPreviewData$1
            r0.<init>(r5, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r6 = r0.L$0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService r6 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5e
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r2 = "in_app_messages/device_preview?preview_id="
            r8.<init>(r2)
            r8.append(r7)
            java.lang.String r7 = "&app_id="
            r8.append(r7)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            com.onesignal.core.internal.http.IHttpClient r7 = r5._httpClient
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r8 = r7.get(r6, r3, r0)
            if (r8 != r1) goto L5d
            return r1
        L5d:
            r6 = r5
        L5e:
            com.onesignal.core.internal.http.HttpResponse r8 = (com.onesignal.core.internal.http.HttpResponse) r8
            boolean r7 = r8.isSuccess()
            if (r7 == 0) goto L79
            org.json.JSONObject r7 = new org.json.JSONObject
            java.lang.String r8 = r8.getPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r7.<init>(r8)
            com.onesignal.inAppMessages.internal.hydrators.InAppHydrator r6 = r6._hydrator
            com.onesignal.inAppMessages.internal.InAppMessageContent r3 = r6.hydrateIAMMessageContent(r7)
            goto L89
        L79:
            int r7 = r8.getStatusCode()
            java.lang.String r8 = r8.getPayload()
            java.lang.String r0 = "html"
            r6.printHttpErrorForInAppMessageRequest(r0, r7, r8)
            r6 = r3
            com.onesignal.inAppMessages.internal.InAppMessageContent r6 = (com.onesignal.inAppMessages.internal.InAppMessageContent) r6
        L89:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.getIAMPreviewData(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object sendIAMClick(final java.lang.String r13, final java.lang.String r14, final java.lang.String r15, java.lang.String r16, final java.lang.String r17, final boolean r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            r12 = this;
            r7 = r12
            r0 = r19
            boolean r1 = r0 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMClick$1
            if (r1 == 0) goto L17
            r1 = r0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMClick$1 r1 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMClick$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L17
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1c
        L17:
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMClick$1 r1 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMClick$1
            r1.<init>(r12, r0)
        L1c:
            r8 = r1
            java.lang.Object r0 = r8.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r10 = 1
            if (r1 == 0) goto L3a
            if (r1 != r10) goto L32
            java.lang.Object r1 = r8.L$0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService r1 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L70
        L32:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3a:
            kotlin.ResultKt.throwOnFailure(r0)
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMClick$json$1 r11 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMClick$json$1
            r0 = r11
            r1 = r13
            r2 = r12
            r3 = r14
            r4 = r17
            r5 = r15
            r6 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6)
            org.json.JSONObject r11 = (org.json.JSONObject) r11
            com.onesignal.core.internal.http.IHttpClient r0 = r7._httpClient
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "in_app_messages/"
            r1.<init>(r2)
            r2 = r16
            r1.append(r2)
            java.lang.String r2 = "/click"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r8.L$0 = r7
            r8.label = r10
            java.lang.Object r0 = r0.post(r1, r11, r8)
            if (r0 != r9) goto L6f
            return r9
        L6f:
            r1 = r7
        L70:
            com.onesignal.core.internal.http.HttpResponse r0 = (com.onesignal.core.internal.http.HttpResponse) r0
            boolean r2 = r0.isSuccess()
            java.lang.String r3 = "engagement"
            if (r2 == 0) goto L87
            java.lang.String r0 = r0.getPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1.printHttpSuccessForInAppMessageRequest(r3, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L87:
            int r2 = r0.getStatusCode()
            java.lang.String r4 = r0.getPayload()
            r1.printHttpErrorForInAppMessageRequest(r3, r2, r4)
            com.onesignal.common.exceptions.BackendException r1 = new com.onesignal.common.exceptions.BackendException
            int r2 = r0.getStatusCode()
            java.lang.String r3 = r0.getPayload()
            java.lang.Integer r0 = r0.getRetryAfterSeconds()
            r1.<init>(r2, r3, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMClick(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object sendIAMPageImpression(final java.lang.String r12, final java.lang.String r13, final java.lang.String r14, java.lang.String r15, final java.lang.String r16, kotlin.coroutines.Continuation<? super kotlin.Unit> r17) {
        /*
            r11 = this;
            r6 = r11
            r0 = r17
            boolean r1 = r0 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMPageImpression$1
            if (r1 == 0) goto L17
            r1 = r0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMPageImpression$1 r1 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMPageImpression$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L17
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1c
        L17:
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMPageImpression$1 r1 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMPageImpression$1
            r1.<init>(r11, r0)
        L1c:
            r7 = r1
            java.lang.Object r0 = r7.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r9 = 1
            if (r1 == 0) goto L3a
            if (r1 != r9) goto L32
            java.lang.Object r1 = r7.L$0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService r1 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L6d
        L32:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3a:
            kotlin.ResultKt.throwOnFailure(r0)
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMPageImpression$json$1 r10 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMPageImpression$json$1
            r0 = r10
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r11
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5)
            org.json.JSONObject r10 = (org.json.JSONObject) r10
            com.onesignal.core.internal.http.IHttpClient r0 = r6._httpClient
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "in_app_messages/"
            r1.<init>(r2)
            r2 = r15
            r1.append(r15)
            java.lang.String r2 = "/pageImpression"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r7.L$0 = r6
            r7.label = r9
            java.lang.Object r0 = r0.post(r1, r10, r7)
            if (r0 != r8) goto L6c
            return r8
        L6c:
            r1 = r6
        L6d:
            com.onesignal.core.internal.http.HttpResponse r0 = (com.onesignal.core.internal.http.HttpResponse) r0
            boolean r2 = r0.isSuccess()
            java.lang.String r3 = "page impression"
            if (r2 == 0) goto L84
            java.lang.String r0 = r0.getPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1.printHttpSuccessForInAppMessageRequest(r3, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L84:
            int r2 = r0.getStatusCode()
            java.lang.String r4 = r0.getPayload()
            r1.printHttpErrorForInAppMessageRequest(r3, r2, r4)
            com.onesignal.common.exceptions.BackendException r1 = new com.onesignal.common.exceptions.BackendException
            int r2 = r0.getStatusCode()
            java.lang.String r3 = r0.getPayload()
            java.lang.Integer r0 = r0.getRetryAfterSeconds()
            r1.<init>(r2, r3, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMPageImpression(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object sendIAMImpression(final java.lang.String r5, final java.lang.String r6, final java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMImpression$1
            if (r0 == 0) goto L14
            r0 = r9
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMImpression$1 r0 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMImpression$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMImpression$1 r0 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMImpression$1
            r0.<init>(r4, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService r5 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto L61
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMImpression$json$1 r9 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMImpression$json$1
            r9.<init>(r5, r6, r7, r4)
            org.json.JSONObject r9 = (org.json.JSONObject) r9
            com.onesignal.core.internal.http.IHttpClient r5 = r4._httpClient
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "in_app_messages/"
            r6.<init>(r7)
            r6.append(r8)
            java.lang.String r7 = "/impression"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r9 = r5.post(r6, r9, r0)
            if (r9 != r1) goto L60
            return r1
        L60:
            r5 = r4
        L61:
            com.onesignal.core.internal.http.HttpResponse r9 = (com.onesignal.core.internal.http.HttpResponse) r9
            boolean r6 = r9.isSuccess()
            java.lang.String r7 = "impression"
            if (r6 == 0) goto L78
            java.lang.String r6 = r9.getPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r5.printHttpSuccessForInAppMessageRequest(r7, r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L78:
            int r6 = r9.getStatusCode()
            java.lang.String r8 = r9.getPayload()
            r5.printHttpErrorForInAppMessageRequest(r7, r6, r8)
            com.onesignal.common.exceptions.BackendException r5 = new com.onesignal.common.exceptions.BackendException
            int r6 = r9.getStatusCode()
            java.lang.String r7 = r9.getPayload()
            java.lang.Integer r8 = r9.getRetryAfterSeconds()
            r5.<init>(r6, r7, r8)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMImpression(java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String htmlPathForMessage(String messageId, String variantId, String appId) {
        if (variantId == null) {
            Logging.error$default("Unable to find a variant for in-app message " + messageId, null, 2, null);
            return null;
        }
        return "in_app_messages/" + messageId + "/variants/" + variantId + "/html?app_id=" + appId;
    }

    private final void printHttpSuccessForInAppMessageRequest(String requestType, String response) {
        Logging.debug$default("Successful post for in-app message " + requestType + " request: " + response, null, 2, null);
    }

    private final void printHttpErrorForInAppMessageRequest(String requestType, int statusCode, String response) {
        Logging.error$default("Encountered a " + statusCode + " error while attempting in-app message " + requestType + " request: " + response, null, 2, null);
    }
}
