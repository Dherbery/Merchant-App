package expo.modules.av;

import android.content.Context;
import expo.modules.av.player.datasource.SharedCookiesDataSourceFactoryProvider;
import expo.modules.core.BasePackage;
import expo.modules.core.interfaces.InternalModule;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public class AVPackage extends BasePackage {
    @Override // expo.modules.core.BasePackage, expo.modules.core.interfaces.Package
    public List<InternalModule> createInternalModules(Context context) {
        return Arrays.asList(new AVManager(context), new SharedCookiesDataSourceFactoryProvider());
    }
}
