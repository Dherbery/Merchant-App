package expo.modules.av;

import androidx.core.os.EnvironmentCompat;
import expo.modules.core.Promise;
import kotlin.Metadata;

/* compiled from: AVModule.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0003j\u0002`\u0004H\u0002*\f\b\u0002\u0010\u0005\"\u00020\u00032\u00020\u0003*\f\b\u0002\u0010\u0006\"\u00020\u00012\u00020\u0001¨\u0006\u0007"}, d2 = {"toLegacyPromise", "Lexpo/modules/core/Promise;", "Lexpo/modules/av/LegacyPromise;", "Lexpo/modules/kotlin/Promise;", "Lexpo/modules/av/KotlinPromise;", "KotlinPromise", "LegacyPromise", "expo-av_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AVModuleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Promise toLegacyPromise(final expo.modules.kotlin.Promise promise) {
        return new Promise() { // from class: expo.modules.av.AVModuleKt$toLegacyPromise$1
            @Override // expo.modules.core.Promise
            public /* synthetic */ void reject(String str, String str2) {
                reject(str, str2, null);
            }

            @Override // expo.modules.core.Promise
            public /* synthetic */ void reject(String str, Throwable th) {
                reject(str, th.getMessage(), th);
            }

            @Override // expo.modules.core.Promise
            public /* synthetic */ void reject(Throwable th) {
                Promise.CC.$default$reject(this, th);
            }

            @Override // expo.modules.core.Promise
            public void resolve(Object value) {
                expo.modules.kotlin.Promise.this.resolve(value);
            }

            @Override // expo.modules.core.Promise
            public void reject(String c, String m, Throwable e) {
                expo.modules.kotlin.Promise promise2 = expo.modules.kotlin.Promise.this;
                if (c == null) {
                    c = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                promise2.reject(c, m, e);
            }
        };
    }
}
