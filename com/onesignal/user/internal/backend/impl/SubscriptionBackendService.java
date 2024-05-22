package com.onesignal.user.internal.backend.impl;

import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.user.internal.backend.ISubscriptionBackendService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionBackendService.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J3\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J-\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J1\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J)\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/onesignal/user/internal/backend/impl/SubscriptionBackendService;", "Lcom/onesignal/user/internal/backend/ISubscriptionBackendService;", "_httpClient", "Lcom/onesignal/core/internal/http/IHttpClient;", "(Lcom/onesignal/core/internal/http/IHttpClient;)V", "createSubscription", "", "appId", "aliasLabel", "aliasValue", "subscription", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/onesignal/user/internal/backend/SubscriptionObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSubscription", "", "subscriptionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIdentityFromSubscription", "", "transferSubscription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSubscription", "(Ljava/lang/String;Ljava/lang/String;Lcom/onesignal/user/internal/backend/SubscriptionObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionBackendService implements ISubscriptionBackendService {
    private final IHttpClient _httpClient;

    public SubscriptionBackendService(IHttpClient _httpClient) {
        Intrinsics.checkNotNullParameter(_httpClient, "_httpClient");
        this._httpClient = _httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.onesignal.user.internal.backend.ISubscriptionBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object createSubscription(java.lang.String r8, java.lang.String r9, java.lang.String r10, com.onesignal.user.internal.backend.SubscriptionObject r11, kotlin.coroutines.Continuation<? super java.lang.String> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.onesignal.user.internal.backend.impl.SubscriptionBackendService$createSubscription$1
            if (r0 == 0) goto L14
            r0 = r12
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$createSubscription$1 r0 = (com.onesignal.user.internal.backend.impl.SubscriptionBackendService$createSubscription$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$createSubscription$1 r0 = new com.onesignal.user.internal.backend.impl.SubscriptionBackendService$createSubscription$1
            r0.<init>(r7, r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "subscription"
            r4 = 1
            java.lang.String r5 = "id"
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            kotlin.ResultKt.throwOnFailure(r12)
            goto L7e
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r12)
            com.onesignal.user.internal.backend.impl.JSONConverter r12 = com.onesignal.user.internal.backend.impl.JSONConverter.INSTANCE
            org.json.JSONObject r11 = r12.convertToJSON(r11)
            r11.remove(r5)
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            org.json.JSONObject r11 = r12.put(r3, r11)
            com.onesignal.core.internal.http.IHttpClient r12 = r7._httpClient
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r6 = "apps/"
            r2.<init>(r6)
            r2.append(r8)
            java.lang.String r8 = "/users/by/"
            r2.append(r8)
            r2.append(r9)
            r8 = 47
            r2.append(r8)
            r2.append(r10)
            java.lang.String r8 = "/subscriptions"
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            java.lang.String r9 = "requestJSON"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r9)
            r0.label = r4
            java.lang.Object r12 = r12.post(r8, r11, r0)
            if (r12 != r1) goto L7e
            return r1
        L7e:
            com.onesignal.core.internal.http.HttpResponse r12 = (com.onesignal.core.internal.http.HttpResponse) r12
            boolean r8 = r12.isSuccess()
            if (r8 == 0) goto La6
            org.json.JSONObject r8 = new org.json.JSONObject
            java.lang.String r9 = r12.getPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            r8.<init>(r9)
            org.json.JSONObject r8 = com.onesignal.common.JSONObjectExtensionsKt.safeJSONObject(r8, r3)
            if (r8 == 0) goto La4
            boolean r9 = r8.has(r5)
            if (r9 != 0) goto L9f
            goto La4
        L9f:
            java.lang.String r8 = r8.getString(r5)
            return r8
        La4:
            r8 = 0
            return r8
        La6:
            com.onesignal.common.exceptions.BackendException r8 = new com.onesignal.common.exceptions.BackendException
            int r9 = r12.getStatusCode()
            java.lang.String r10 = r12.getPayload()
            java.lang.Integer r11 = r12.getRetryAfterSeconds()
            r8.<init>(r9, r10, r11)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.SubscriptionBackendService.createSubscription(java.lang.String, java.lang.String, java.lang.String, com.onesignal.user.internal.backend.SubscriptionObject, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.onesignal.user.internal.backend.ISubscriptionBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object updateSubscription(java.lang.String r6, java.lang.String r7, com.onesignal.user.internal.backend.SubscriptionObject r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.onesignal.user.internal.backend.impl.SubscriptionBackendService$updateSubscription$1
            if (r0 == 0) goto L14
            r0 = r9
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$updateSubscription$1 r0 = (com.onesignal.user.internal.backend.impl.SubscriptionBackendService$updateSubscription$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$updateSubscription$1 r0 = new com.onesignal.user.internal.backend.impl.SubscriptionBackendService$updateSubscription$1
            r0.<init>(r5, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L6c
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.ResultKt.throwOnFailure(r9)
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            com.onesignal.user.internal.backend.impl.JSONConverter r2 = com.onesignal.user.internal.backend.impl.JSONConverter.INSTANCE
            org.json.JSONObject r8 = r2.convertToJSON(r8)
            java.lang.String r2 = "subscription"
            org.json.JSONObject r8 = r9.put(r2, r8)
            com.onesignal.core.internal.http.IHttpClient r9 = r5._httpClient
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "apps/"
            r2.<init>(r4)
            r2.append(r6)
            java.lang.String r6 = "/subscriptions/"
            r2.append(r6)
            r2.append(r7)
            java.lang.String r6 = r2.toString()
            java.lang.String r7 = "requestJSON"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            r0.label = r3
            java.lang.Object r9 = r9.patch(r6, r8, r0)
            if (r9 != r1) goto L6c
            return r1
        L6c:
            com.onesignal.core.internal.http.HttpResponse r9 = (com.onesignal.core.internal.http.HttpResponse) r9
            boolean r6 = r9.isSuccess()
            if (r6 == 0) goto L77
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L77:
            com.onesignal.common.exceptions.BackendException r6 = new com.onesignal.common.exceptions.BackendException
            int r7 = r9.getStatusCode()
            java.lang.String r8 = r9.getPayload()
            java.lang.Integer r9 = r9.getRetryAfterSeconds()
            r6.<init>(r7, r8, r9)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.SubscriptionBackendService.updateSubscription(java.lang.String, java.lang.String, com.onesignal.user.internal.backend.SubscriptionObject, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.onesignal.user.internal.backend.ISubscriptionBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object deleteSubscription(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.onesignal.user.internal.backend.impl.SubscriptionBackendService$deleteSubscription$1
            if (r0 == 0) goto L14
            r0 = r8
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$deleteSubscription$1 r0 = (com.onesignal.user.internal.backend.impl.SubscriptionBackendService$deleteSubscription$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$deleteSubscription$1 r0 = new com.onesignal.user.internal.backend.impl.SubscriptionBackendService$deleteSubscription$1
            r0.<init>(r5, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L56
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
            com.onesignal.core.internal.http.IHttpClient r8 = r5._httpClient
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "apps/"
            r2.<init>(r4)
            r2.append(r6)
            java.lang.String r6 = "/subscriptions/"
            r2.append(r6)
            r2.append(r7)
            java.lang.String r6 = r2.toString()
            r0.label = r3
            java.lang.Object r8 = r8.delete(r6, r0)
            if (r8 != r1) goto L56
            return r1
        L56:
            com.onesignal.core.internal.http.HttpResponse r8 = (com.onesignal.core.internal.http.HttpResponse) r8
            boolean r6 = r8.isSuccess()
            if (r6 == 0) goto L61
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L61:
            com.onesignal.common.exceptions.BackendException r6 = new com.onesignal.common.exceptions.BackendException
            int r7 = r8.getStatusCode()
            java.lang.String r0 = r8.getPayload()
            java.lang.Integer r8 = r8.getRetryAfterSeconds()
            r6.<init>(r7, r0, r8)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.SubscriptionBackendService.deleteSubscription(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.onesignal.user.internal.backend.ISubscriptionBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object transferSubscription(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.onesignal.user.internal.backend.impl.SubscriptionBackendService$transferSubscription$1
            if (r0 == 0) goto L14
            r0 = r9
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$transferSubscription$1 r0 = (com.onesignal.user.internal.backend.impl.SubscriptionBackendService$transferSubscription$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$transferSubscription$1 r0 = new com.onesignal.user.internal.backend.impl.SubscriptionBackendService$transferSubscription$1
            r0.<init>(r4, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L74
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r9)
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            org.json.JSONObject r7 = r2.put(r7, r8)
            java.lang.String r8 = "identity"
            org.json.JSONObject r7 = r9.put(r8, r7)
            com.onesignal.core.internal.http.IHttpClient r8 = r4._httpClient
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r2 = "apps/"
            r9.<init>(r2)
            r9.append(r5)
            java.lang.String r5 = "/subscriptions/"
            r9.append(r5)
            r9.append(r6)
            java.lang.String r5 = "/owner"
            r9.append(r5)
            java.lang.String r5 = r9.toString()
            java.lang.String r6 = "requestJSON"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            r0.label = r3
            java.lang.Object r9 = r8.patch(r5, r7, r0)
            if (r9 != r1) goto L74
            return r1
        L74:
            com.onesignal.core.internal.http.HttpResponse r9 = (com.onesignal.core.internal.http.HttpResponse) r9
            boolean r5 = r9.isSuccess()
            if (r5 == 0) goto L7f
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L7f:
            com.onesignal.common.exceptions.BackendException r5 = new com.onesignal.common.exceptions.BackendException
            int r6 = r9.getStatusCode()
            java.lang.String r7 = r9.getPayload()
            java.lang.Integer r8 = r9.getRetryAfterSeconds()
            r5.<init>(r6, r7, r8)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.SubscriptionBackendService.transferSubscription(java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.onesignal.user.internal.backend.ISubscriptionBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getIdentityFromSubscription(java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.String>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.onesignal.user.internal.backend.impl.SubscriptionBackendService$getIdentityFromSubscription$1
            if (r0 == 0) goto L14
            r0 = r10
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$getIdentityFromSubscription$1 r0 = (com.onesignal.user.internal.backend.impl.SubscriptionBackendService$getIdentityFromSubscription$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$getIdentityFromSubscription$1 r0 = new com.onesignal.user.internal.backend.impl.SubscriptionBackendService$getIdentityFromSubscription$1
            r0.<init>(r7, r10)
        L19:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.throwOnFailure(r10)
            goto L60
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            kotlin.ResultKt.throwOnFailure(r10)
            com.onesignal.core.internal.http.IHttpClient r1 = r7._httpClient
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r3 = "apps/"
            r10.<init>(r3)
            r10.append(r8)
            java.lang.String r8 = "/subscriptions/"
            r10.append(r8)
            r10.append(r9)
            java.lang.String r8 = "/user/identity"
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r2
            r2 = r8
            java.lang.Object r10 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.get$default(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L60
            return r0
        L60:
            com.onesignal.core.internal.http.HttpResponse r10 = (com.onesignal.core.internal.http.HttpResponse) r10
            boolean r8 = r10.isSuccess()
            if (r8 == 0) goto Lbc
            org.json.JSONObject r8 = new org.json.JSONObject
            java.lang.String r9 = r10.getPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            r8.<init>(r9)
            java.lang.String r9 = "identity"
            org.json.JSONObject r8 = com.onesignal.common.JSONObjectExtensionsKt.safeJSONObject(r8, r9)
            if (r8 == 0) goto Lb7
            java.util.Map r8 = com.onesignal.common.JSONObjectExtensionsKt.toMap(r8)
            if (r8 == 0) goto Lb7
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            int r10 = r8.size()
            int r10 = kotlin.collections.MapsKt.mapCapacity(r10)
            r9.<init>(r10)
            java.util.Map r9 = (java.util.Map) r9
            java.util.Set r8 = r8.entrySet()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L9b:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto Lbb
            java.lang.Object r10 = r8.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r0 = r10.getKey()
            java.lang.Object r10 = r10.getValue()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r9.put(r0, r10)
            goto L9b
        Lb7:
            java.util.Map r9 = kotlin.collections.MapsKt.emptyMap()
        Lbb:
            return r9
        Lbc:
            com.onesignal.common.exceptions.BackendException r8 = new com.onesignal.common.exceptions.BackendException
            int r9 = r10.getStatusCode()
            java.lang.String r0 = r10.getPayload()
            java.lang.Integer r10 = r10.getRetryAfterSeconds()
            r8.<init>(r9, r0, r10)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.SubscriptionBackendService.getIdentityFromSubscription(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
