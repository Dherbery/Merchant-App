package com.onesignal.notifications.internal.backend.impl;

import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.backend.INotificationBackendService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationBackendService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J1\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/onesignal/notifications/internal/backend/impl/NotificationBackendService;", "Lcom/onesignal/notifications/internal/backend/INotificationBackendService;", "_httpClient", "Lcom/onesignal/core/internal/http/IHttpClient;", "(Lcom/onesignal/core/internal/http/IHttpClient;)V", "updateNotificationAsOpened", "", "appId", "", "notificationId", "subscriptionId", "deviceType", "Lcom/onesignal/core/internal/device/IDeviceService$DeviceType;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/onesignal/core/internal/device/IDeviceService$DeviceType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotificationAsReceived", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationBackendService implements INotificationBackendService {
    private final IHttpClient _httpClient;

    public NotificationBackendService(IHttpClient _httpClient) {
        Intrinsics.checkNotNullParameter(_httpClient, "_httpClient");
        this._httpClient = _httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.onesignal.notifications.internal.backend.INotificationBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object updateNotificationAsReceived(java.lang.String r5, java.lang.String r6, java.lang.String r7, com.onesignal.core.internal.device.IDeviceService.DeviceType r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsReceived$1
            if (r0 == 0) goto L14
            r0 = r9
            com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsReceived$1 r0 = (com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsReceived$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsReceived$1 r0 = new com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsReceived$1
            r0.<init>(r4, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L73
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r9)
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            java.lang.String r2 = "app_id"
            org.json.JSONObject r5 = r9.put(r2, r5)
            java.lang.String r9 = "player_id"
            org.json.JSONObject r5 = r5.put(r9, r7)
            java.lang.String r7 = "device_type"
            int r8 = r8.getValue()
            org.json.JSONObject r5 = r5.put(r7, r8)
            java.lang.String r7 = "JSONObject()\n           …_type\", deviceType.value)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            com.onesignal.core.internal.http.IHttpClient r7 = r4._httpClient
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "notifications/"
            r8.<init>(r9)
            r8.append(r6)
            java.lang.String r6 = "/report_received"
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r0.label = r3
            java.lang.Object r9 = r7.put(r6, r5, r0)
            if (r9 != r1) goto L73
            return r1
        L73:
            com.onesignal.core.internal.http.HttpResponse r9 = (com.onesignal.core.internal.http.HttpResponse) r9
            boolean r5 = r9.isSuccess()
            if (r5 == 0) goto L7e
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L7e:
            com.onesignal.common.exceptions.BackendException r5 = new com.onesignal.common.exceptions.BackendException
            int r6 = r9.getStatusCode()
            java.lang.String r7 = r9.getPayload()
            java.lang.Integer r8 = r9.getRetryAfterSeconds()
            r5.<init>(r6, r7, r8)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.backend.impl.NotificationBackendService.updateNotificationAsReceived(java.lang.String, java.lang.String, java.lang.String, com.onesignal.core.internal.device.IDeviceService$DeviceType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.onesignal.notifications.internal.backend.INotificationBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object updateNotificationAsOpened(java.lang.String r5, java.lang.String r6, java.lang.String r7, com.onesignal.core.internal.device.IDeviceService.DeviceType r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsOpened$1
            if (r0 == 0) goto L14
            r0 = r9
            com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsOpened$1 r0 = (com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsOpened$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsOpened$1 r0 = new com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsOpened$1
            r0.<init>(r4, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L6b
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r9)
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            java.lang.String r2 = "app_id"
            r9.put(r2, r5)
            java.lang.String r5 = "player_id"
            r9.put(r5, r7)
            java.lang.String r5 = "opened"
            r9.put(r5, r3)
            java.lang.String r5 = "device_type"
            int r7 = r8.getValue()
            r9.put(r5, r7)
            com.onesignal.core.internal.http.IHttpClient r5 = r4._httpClient
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "notifications/"
            r7.<init>(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r0.label = r3
            java.lang.Object r9 = r5.put(r6, r9, r0)
            if (r9 != r1) goto L6b
            return r1
        L6b:
            com.onesignal.core.internal.http.HttpResponse r9 = (com.onesignal.core.internal.http.HttpResponse) r9
            boolean r5 = r9.isSuccess()
            if (r5 == 0) goto L76
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L76:
            com.onesignal.common.exceptions.BackendException r5 = new com.onesignal.common.exceptions.BackendException
            int r6 = r9.getStatusCode()
            java.lang.String r7 = r9.getPayload()
            java.lang.Integer r8 = r9.getRetryAfterSeconds()
            r5.<init>(r6, r7, r8)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.backend.impl.NotificationBackendService.updateNotificationAsOpened(java.lang.String, java.lang.String, java.lang.String, com.onesignal.core.internal.device.IDeviceService$DeviceType, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
