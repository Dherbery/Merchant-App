package com.onesignal.core.internal.permissions.impl;

import android.app.Activity;
import android.content.Intent;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.R;
import com.onesignal.core.activities.PermissionsActivity;
import com.onesignal.core.internal.application.IActivityLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.permissions.IRequestPermissionService;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestPermissionService.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\bJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\tH\u0016J0\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030!H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0006\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\""}, d2 = {"Lcom/onesignal/core/internal/permissions/impl/RequestPermissionService;", "Landroid/app/Activity;", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService;", "_application", "Lcom/onesignal/core/internal/application/IApplicationService;", "(Lcom/onesignal/core/internal/application/IApplicationService;)V", "callbackMap", "Ljava/util/HashMap;", "", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService$PermissionCallback;", "Lkotlin/collections/HashMap;", "fallbackToSettings", "", "getFallbackToSettings", "()Z", "setFallbackToSettings", "(Z)V", "shouldShowRequestPermissionRationaleBeforeRequest", "getShouldShowRequestPermissionRationaleBeforeRequest", "setShouldShowRequestPermissionRationaleBeforeRequest", "waiting", "getWaiting", "setWaiting", "getCallback", "permissionType", "registerAsCallback", "", "callback", "startPrompt", "fallbackCondition", "permissionRequestType", "androidPermissionString", "callbackClass", "Ljava/lang/Class;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RequestPermissionService extends Activity implements IRequestPermissionService {
    private final IApplicationService _application;
    private final HashMap<String, IRequestPermissionService.PermissionCallback> callbackMap;
    private boolean fallbackToSettings;
    private boolean shouldShowRequestPermissionRationaleBeforeRequest;
    private boolean waiting;

    public RequestPermissionService(IApplicationService _application) {
        Intrinsics.checkNotNullParameter(_application, "_application");
        this._application = _application;
        this.callbackMap = new HashMap<>();
    }

    public final boolean getWaiting() {
        return this.waiting;
    }

    public final void setWaiting(boolean z) {
        this.waiting = z;
    }

    public final boolean getFallbackToSettings() {
        return this.fallbackToSettings;
    }

    public final void setFallbackToSettings(boolean z) {
        this.fallbackToSettings = z;
    }

    public final boolean getShouldShowRequestPermissionRationaleBeforeRequest() {
        return this.shouldShowRequestPermissionRationaleBeforeRequest;
    }

    public final void setShouldShowRequestPermissionRationaleBeforeRequest(boolean z) {
        this.shouldShowRequestPermissionRationaleBeforeRequest = z;
    }

    @Override // com.onesignal.core.internal.permissions.IRequestPermissionService
    public void registerAsCallback(String permissionType, IRequestPermissionService.PermissionCallback callback) {
        Intrinsics.checkNotNullParameter(permissionType, "permissionType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbackMap.put(permissionType, callback);
    }

    public final IRequestPermissionService.PermissionCallback getCallback(String permissionType) {
        Intrinsics.checkNotNullParameter(permissionType, "permissionType");
        return this.callbackMap.get(permissionType);
    }

    @Override // com.onesignal.core.internal.permissions.IRequestPermissionService
    public void startPrompt(boolean fallbackCondition, final String permissionRequestType, final String androidPermissionString, final Class<?> callbackClass) {
        Intrinsics.checkNotNullParameter(callbackClass, "callbackClass");
        if (this.waiting) {
            return;
        }
        this.fallbackToSettings = fallbackCondition;
        this._application.addActivityLifecycleHandler(new IActivityLifecycleHandler() { // from class: com.onesignal.core.internal.permissions.impl.RequestPermissionService$startPrompt$1
            @Override // com.onesignal.core.internal.application.IActivityLifecycleHandler
            public void onActivityStopped(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // com.onesignal.core.internal.application.IActivityLifecycleHandler
            public void onActivityAvailable(Activity activity) {
                IApplicationService iApplicationService;
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (Intrinsics.areEqual(activity.getClass(), PermissionsActivity.class)) {
                    iApplicationService = RequestPermissionService.this._application;
                    iApplicationService.removeActivityLifecycleHandler(this);
                    return;
                }
                Intent intent = new Intent(activity, (Class<?>) PermissionsActivity.class);
                intent.setFlags(131072);
                intent.putExtra(PermissionsActivity.INTENT_EXTRA_PERMISSION_TYPE, permissionRequestType).putExtra(PermissionsActivity.INTENT_EXTRA_ANDROID_PERMISSION_STRING, androidPermissionString).putExtra(PermissionsActivity.INTENT_EXTRA_CALLBACK_CLASS, callbackClass.getName());
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.onesignal_fade_in, R.anim.onesignal_fade_out);
            }
        });
    }
}
