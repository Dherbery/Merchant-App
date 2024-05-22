package com.onesignal.user.internal.backend.impl;

import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.user.internal.backend.IIdentityBackendService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdentityBackendService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J1\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\fJI\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/onesignal/user/internal/backend/impl/IdentityBackendService;", "Lcom/onesignal/user/internal/backend/IIdentityBackendService;", "_httpClient", "Lcom/onesignal/core/internal/http/IHttpClient;", "(Lcom/onesignal/core/internal/http/IHttpClient;)V", "deleteAlias", "", "appId", "", "aliasLabel", "aliasValue", "aliasLabelToDelete", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAlias", "", "identities", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class IdentityBackendService implements IIdentityBackendService {
    private final IHttpClient _httpClient;

    public IdentityBackendService(IHttpClient _httpClient) {
        Intrinsics.checkNotNullParameter(_httpClient, "_httpClient");
        this._httpClient = _httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.onesignal.user.internal.backend.IIdentityBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object setAlias(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.String>> r11) {
        /*
            r6 = this;
            boolean r0 = r11 instanceof com.onesignal.user.internal.backend.impl.IdentityBackendService$setAlias$1
            if (r0 == 0) goto L14
            r0 = r11
            com.onesignal.user.internal.backend.impl.IdentityBackendService$setAlias$1 r0 = (com.onesignal.user.internal.backend.impl.IdentityBackendService$setAlias$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.onesignal.user.internal.backend.impl.IdentityBackendService$setAlias$1 r0 = new com.onesignal.user.internal.backend.impl.IdentityBackendService$setAlias$1
            r0.<init>(r6, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "identity"
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            kotlin.ResultKt.throwOnFailure(r11)
            goto L7c
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            kotlin.ResultKt.throwOnFailure(r11)
            org.json.JSONObject r11 = new org.json.JSONObject
            r11.<init>()
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            org.json.JSONObject r10 = com.onesignal.common.JSONObjectExtensionsKt.putMap(r2, r10)
            org.json.JSONObject r10 = r11.put(r3, r10)
            com.onesignal.core.internal.http.IHttpClient r11 = r6._httpClient
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "apps/"
            r2.<init>(r5)
            r2.append(r7)
            java.lang.String r7 = "/users/by/"
            r2.append(r7)
            r2.append(r8)
            r7 = 47
            r2.append(r7)
            r2.append(r9)
            java.lang.String r7 = "/identity"
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            java.lang.String r8 = "requestJSONObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r8)
            r0.label = r4
            java.lang.Object r11 = r11.patch(r7, r10, r0)
            if (r11 != r1) goto L7c
            return r1
        L7c:
            com.onesignal.core.internal.http.HttpResponse r11 = (com.onesignal.core.internal.http.HttpResponse) r11
            boolean r7 = r11.isSuccess()
            if (r7 == 0) goto Ld3
            org.json.JSONObject r7 = new org.json.JSONObject
            java.lang.String r8 = r11.getPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r7.<init>(r8)
            org.json.JSONObject r7 = r7.getJSONObject(r3)
            java.lang.String r8 = "responseJSON.getJSONObject(\"identity\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            java.util.Map r7 = com.onesignal.common.JSONObjectExtensionsKt.toMap(r7)
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            int r9 = r7.size()
            int r9 = kotlin.collections.MapsKt.mapCapacity(r9)
            r8.<init>(r9)
            java.util.Map r8 = (java.util.Map) r8
            java.util.Set r7 = r7.entrySet()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        Lb6:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto Ld2
            java.lang.Object r9 = r7.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r10 = r9.getKey()
            java.lang.Object r9 = r9.getValue()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r8.put(r10, r9)
            goto Lb6
        Ld2:
            return r8
        Ld3:
            com.onesignal.common.exceptions.BackendException r7 = new com.onesignal.common.exceptions.BackendException
            int r8 = r11.getStatusCode()
            java.lang.String r9 = r11.getPayload()
            java.lang.Integer r10 = r11.getRetryAfterSeconds()
            r7.<init>(r8, r9, r10)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.IdentityBackendService.setAlias(java.lang.String, java.lang.String, java.lang.String, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.onesignal.user.internal.backend.IIdentityBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object deleteAlias(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof com.onesignal.user.internal.backend.impl.IdentityBackendService$deleteAlias$1
            if (r0 == 0) goto L14
            r0 = r10
            com.onesignal.user.internal.backend.impl.IdentityBackendService$deleteAlias$1 r0 = (com.onesignal.user.internal.backend.impl.IdentityBackendService$deleteAlias$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.onesignal.user.internal.backend.impl.IdentityBackendService$deleteAlias$1 r0 = new com.onesignal.user.internal.backend.impl.IdentityBackendService$deleteAlias$1
            r0.<init>(r5, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L66
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.ResultKt.throwOnFailure(r10)
            com.onesignal.core.internal.http.IHttpClient r10 = r5._httpClient
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "apps/"
            r2.<init>(r4)
            r2.append(r6)
            java.lang.String r6 = "/users/by/"
            r2.append(r6)
            r2.append(r7)
            r6 = 47
            r2.append(r6)
            r2.append(r8)
            java.lang.String r6 = "/identity/"
            r2.append(r6)
            r2.append(r9)
            java.lang.String r6 = r2.toString()
            r0.label = r3
            java.lang.Object r10 = r10.delete(r6, r0)
            if (r10 != r1) goto L66
            return r1
        L66:
            com.onesignal.core.internal.http.HttpResponse r10 = (com.onesignal.core.internal.http.HttpResponse) r10
            boolean r6 = r10.isSuccess()
            if (r6 == 0) goto L71
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L71:
            com.onesignal.common.exceptions.BackendException r6 = new com.onesignal.common.exceptions.BackendException
            int r7 = r10.getStatusCode()
            java.lang.String r8 = r10.getPayload()
            java.lang.Integer r9 = r10.getRetryAfterSeconds()
            r6.<init>(r7, r8, r9)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.IdentityBackendService.deleteAlias(java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
