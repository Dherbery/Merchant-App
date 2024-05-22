package com.facebook.react.defaults;

import android.app.Application;
import android.content.Context;
import com.facebook.react.JSEngineResolutionAlgorithm;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.defaults.DefaultTurboModuleManagerDelegate;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultReactNativeHost.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/facebook/react/defaults/DefaultReactNativeHost;", "Lcom/facebook/react/ReactNativeHost;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "(Landroid/app/Application;)V", "isHermesEnabled", "", "()Ljava/lang/Boolean;", "isNewArchEnabled", "()Z", "getJSEngineResolutionAlgorithm", "Lcom/facebook/react/JSEngineResolutionAlgorithm;", "getJSIModulePackage", "Lcom/facebook/react/bridge/JSIModulePackage;", "getReactPackageTurboModuleManagerDelegateBuilder", "Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "toReactHost", "Lcom/facebook/react/ReactHost;", "context", "Landroid/content/Context;", "ReactAndroid_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DefaultReactNativeHost extends ReactNativeHost {
    protected Boolean isHermesEnabled() {
        return null;
    }

    /* renamed from: isNewArchEnabled */
    protected boolean getIsNewArchEnabled() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultReactNativeHost(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    @Override // com.facebook.react.ReactNativeHost
    protected ReactPackageTurboModuleManagerDelegate.Builder getReactPackageTurboModuleManagerDelegateBuilder() {
        if (getIsNewArchEnabled()) {
            return new DefaultTurboModuleManagerDelegate.Builder();
        }
        return null;
    }

    @Override // com.facebook.react.ReactNativeHost
    protected JSIModulePackage getJSIModulePackage() {
        if (getIsNewArchEnabled()) {
            return new DefaultJSIModulePackage(this);
        }
        return null;
    }

    @Override // com.facebook.react.ReactNativeHost
    protected JSEngineResolutionAlgorithm getJSEngineResolutionAlgorithm() {
        Boolean isHermesEnabled = isHermesEnabled();
        if (Intrinsics.areEqual((Object) isHermesEnabled, (Object) true)) {
            return JSEngineResolutionAlgorithm.HERMES;
        }
        if (Intrinsics.areEqual((Object) isHermesEnabled, (Object) false)) {
            return JSEngineResolutionAlgorithm.JSC;
        }
        if (isHermesEnabled == null) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final ReactHost toReactHost(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        List<ReactPackage> packages = getPackages();
        Intrinsics.checkNotNullExpressionValue(packages, "packages");
        String jsMainModuleName = getJSMainModuleName();
        Intrinsics.checkNotNullExpressionValue(jsMainModuleName, "jsMainModuleName");
        String bundleAssetName = getBundleAssetName();
        if (bundleAssetName == null) {
            bundleAssetName = "index";
        }
        Boolean isHermesEnabled = isHermesEnabled();
        return DefaultReactHost.getDefaultReactHost(context, packages, jsMainModuleName, bundleAssetName, isHermesEnabled != null ? isHermesEnabled.booleanValue() : true);
    }
}
