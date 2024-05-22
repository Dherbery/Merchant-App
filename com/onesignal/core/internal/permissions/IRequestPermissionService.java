package com.onesignal.core.internal.permissions;

import com.onesignal.core.BuildConfig;
import kotlin.Metadata;

/* compiled from: IRequestPermissionService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J0\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH&¨\u0006\u0010"}, d2 = {"Lcom/onesignal/core/internal/permissions/IRequestPermissionService;", "", "registerAsCallback", "", "permissionType", "", "callback", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService$PermissionCallback;", "startPrompt", "fallbackCondition", "", "permissionRequestType", "androidPermissionString", "callbackClass", "Ljava/lang/Class;", "PermissionCallback", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IRequestPermissionService {

    /* compiled from: IRequestPermissionService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/onesignal/core/internal/permissions/IRequestPermissionService$PermissionCallback;", "", "onAccept", "", "onReject", "fallbackToSettings", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public interface PermissionCallback {
        void onAccept();

        void onReject(boolean fallbackToSettings);
    }

    void registerAsCallback(String permissionType, PermissionCallback callback);

    void startPrompt(boolean fallbackCondition, String permissionRequestType, String androidPermissionString, Class<?> callbackClass);
}
