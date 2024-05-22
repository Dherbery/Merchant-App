package expo.modules.location;

import kotlin.Metadata;

/* compiled from: LocationHelpers.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/location/AppForegroundedSingleton;", "", "()V", "isForegrounded", "", "()Z", "setForegrounded", "(Z)V", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AppForegroundedSingleton {
    public static final AppForegroundedSingleton INSTANCE = new AppForegroundedSingleton();
    private static boolean isForegrounded;

    private AppForegroundedSingleton() {
    }

    public final boolean isForegrounded() {
        return isForegrounded;
    }

    public final void setForegrounded(boolean z) {
        isForegrounded = z;
    }
}
