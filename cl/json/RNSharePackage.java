package cl.json;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class RNSharePackage extends TurboReactPackage {
    @Override // com.facebook.react.TurboReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(RNShareImpl.NAME)) {
            return new RNShare(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.TurboReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: cl.json.RNSharePackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return RNSharePackage.lambda$getReactModuleInfoProvider$0();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$getReactModuleInfoProvider$0() {
        HashMap hashMap = new HashMap();
        hashMap.put(RNShareImpl.NAME, new ReactModuleInfo(RNShareImpl.NAME, RNShareImpl.NAME, false, false, true, false, false));
        return hashMap;
    }
}
