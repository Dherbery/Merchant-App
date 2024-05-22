package expo.modules.av;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* compiled from: AVModule.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/av/AVManagerModuleNotFound;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-av_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
final class AVManagerModuleNotFound extends CodedException {
    public AVManagerModuleNotFound() {
        super("AVManagerInterface not found", null, 2, null);
    }
}
