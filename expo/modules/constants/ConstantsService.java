package expo.modules.constants;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.amplitude.api.Constants;
import com.amplitude.api.DeviceInfo;
import com.google.android.exoplayer2.C;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.RegistryLifecycleListener;
import expo.modules.core.utilities.EmulatorUtilities;
import expo.modules.interfaces.constants.ConstantsInterface;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.IOUtils;

/* compiled from: ConstantsService.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0002\"#B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u0012\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001aH\u0016J\b\u0010!\u001a\u00020\u0007H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lexpo/modules/constants/ConstantsService;", "Lexpo/modules/core/interfaces/InternalModule;", "Lexpo/modules/interfaces/constants/ConstantsInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appConfig", "", "getAppConfig", "()Ljava/lang/String;", "exponentInstallationId", "Lexpo/modules/constants/ExponentInstallationId;", "sessionId", "statusBarHeightInternal", "", "getStatusBarHeightInternal", "()I", "setStatusBarHeightInternal", "(I)V", "getAppOwnership", "getAppScopeKey", "getConstants", "", "", "getDeviceName", "getExportedInterfaces", "", "Ljava/lang/Class;", "getIsDevice", "", "getOrCreateInstallationId", "getStatusBarHeight", "getSystemFonts", "getSystemVersion", "Companion", "ExecutionEnvironment", "expo-constants_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ConstantsService implements InternalModule, ConstantsInterface {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;
    private final ExponentInstallationId exponentInstallationId;
    private final String sessionId;
    private int statusBarHeightInternal;

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    public String getAppOwnership() {
        return "guest";
    }

    @Override // expo.modules.core.interfaces.RegistryLifecycleListener
    public /* synthetic */ void onCreate(ModuleRegistry moduleRegistry) {
        RegistryLifecycleListener.CC.$default$onCreate(this, moduleRegistry);
    }

    @Override // expo.modules.core.interfaces.RegistryLifecycleListener
    public /* synthetic */ void onDestroy() {
        RegistryLifecycleListener.CC.$default$onDestroy(this);
    }

    public ConstantsService(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Integer valueOf = Integer.valueOf(context.getResources().getIdentifier("status_bar_height", "dimen", DeviceInfo.OS_NAME));
        this.statusBarHeightInternal = (valueOf.intValue() > 0 ? valueOf : null) != null ? INSTANCE.convertPixelsToDp(context.getResources().getDimensionPixelSize(r0.intValue()), context) : 0;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.sessionId = uuid;
        this.exponentInstallationId = new ExponentInstallationId(context);
    }

    public final int getStatusBarHeightInternal() {
        return this.statusBarHeightInternal;
    }

    public final void setStatusBarHeightInternal(int i) {
        this.statusBarHeightInternal = i;
    }

    /* compiled from: ConstantsService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/constants/ConstantsService$ExecutionEnvironment;", "", "string", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getString", "()Ljava/lang/String;", "BARE", "STANDALONE", "STORE_CLIENT", "expo-constants_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum ExecutionEnvironment {
        BARE("bare"),
        STANDALONE("standalone"),
        STORE_CLIENT("storeClient");

        private final String string;

        ExecutionEnvironment(String str) {
            this.string = str;
        }

        public final String getString() {
            return this.string;
        }
    }

    @Override // expo.modules.core.interfaces.InternalModule
    public List<Class<?>> getExportedInterfaces() {
        return CollectionsKt.listOf(ConstantsInterface.class);
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    public Map<String, Object> getConstants() {
        String str;
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("sessionId", this.sessionId), TuplesKt.to("executionEnvironment", ExecutionEnvironment.BARE.getString()), TuplesKt.to("statusBarHeight", Integer.valueOf(this.statusBarHeightInternal)), TuplesKt.to("deviceName", getDeviceName()), TuplesKt.to("isDevice", Boolean.valueOf(getIsDevice())), TuplesKt.to("systemFonts", getSystemFonts()), TuplesKt.to("systemVersion", getSystemVersion()), TuplesKt.to("installationId", getOrCreateInstallationId()), TuplesKt.to("manifest", getAppConfig()), TuplesKt.to(Constants.AMP_TRACKING_OPTION_PLATFORM, MapsKt.mapOf(TuplesKt.to(DeviceInfo.OS_NAME, MapsKt.emptyMap()))));
        try {
            PackageInfo pInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
            mutableMapOf.put("nativeAppVersion", pInfo.versionName);
            Companion companion = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(pInfo, "pInfo");
            mutableMapOf.put("nativeBuildVersion", String.valueOf((int) companion.getLongVersionCode(pInfo)));
        } catch (PackageManager.NameNotFoundException e) {
            str = ConstantsServiceKt.TAG;
            Log.e(str, "Exception: ", e);
        }
        return mutableMapOf;
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    public String getAppScopeKey() {
        return this.context.getPackageName();
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    public String getDeviceName() {
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        return MODEL;
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    public boolean getIsDevice() {
        return !EmulatorUtilities.INSTANCE.isRunningOnEmulator();
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    /* renamed from: getStatusBarHeight, reason: from getter */
    public int getStatusBarHeightInternal() {
        return this.statusBarHeightInternal;
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    public String getSystemVersion() {
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        return RELEASE;
    }

    public String getOrCreateInstallationId() {
        return this.exponentInstallationId.getOrCreateUUID();
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    public List<String> getSystemFonts() {
        return CollectionsKt.listOf((Object[]) new String[]{"normal", "notoserif", C.SANS_SERIF_NAME, "sans-serif-light", "sans-serif-thin", "sans-serif-condensed", "sans-serif-medium", C.SERIF_NAME, "Roboto", "monospace"});
    }

    private final String getAppConfig() {
        String str;
        try {
            InputStream open = this.context.getAssets().open("app.config");
            try {
                String iOUtils = IOUtils.toString(open, StandardCharsets.UTF_8);
                CloseableKt.closeFinally(open, null);
                return iOUtils;
            } finally {
            }
        } catch (FileNotFoundException unused) {
            return null;
        } catch (Exception e) {
            str = ConstantsServiceKt.TAG;
            Log.e(str, "Error reading embedded app config", e);
            return null;
        }
    }

    /* compiled from: ConstantsService.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0010"}, d2 = {"Lexpo/modules/constants/ConstantsService$Companion;", "", "()V", "isRunningOnEmulator", "", "()Z", "convertPixelsToDp", "", "px", "", "context", "Landroid/content/Context;", "getLongVersionCode", "", "info", "Landroid/content/pm/PackageInfo;", "expo-constants_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int convertPixelsToDp(float px, Context context) {
            return (int) (px / (context.getResources().getDisplayMetrics().densityDpi / 160.0f));
        }

        private final boolean isRunningOnEmulator() {
            return EmulatorUtilities.INSTANCE.isRunningOnEmulator();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long getLongVersionCode(PackageInfo info) {
            long longVersionCode;
            if (Build.VERSION.SDK_INT >= 28) {
                longVersionCode = info.getLongVersionCode();
                return longVersionCode;
            }
            return info.versionCode;
        }
    }
}
