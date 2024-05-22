package com.mrousavy.camera.types;

import com.facebook.hermes.intl.Constants;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import com.mrousavy.camera.types.JSUnionValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;

/* compiled from: VideoStabilizationMode.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/mrousavy/camera/types/VideoStabilizationMode;", "", "Lcom/mrousavy/camera/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "OFF", "STANDARD", "CINEMATIC", "CINEMATIC_EXTENDED", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum VideoStabilizationMode implements JSUnionValue {
    OFF(DebugKt.DEBUG_PROPERTY_VALUE_OFF),
    STANDARD(Constants.COLLATION_STANDARD),
    CINEMATIC("cinematic"),
    CINEMATIC_EXTENDED("cinematic-extended");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String unionValue;

    VideoStabilizationMode(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    /* compiled from: VideoStabilizationMode.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/types/VideoStabilizationMode$Companion;", "Lcom/mrousavy/camera/types/JSUnionValue$Companion;", "Lcom/mrousavy/camera/types/VideoStabilizationMode;", "()V", "fromDigitalVideoStabilizationMode", "stabiliazionMode", "", "fromOpticalVideoStabilizationMode", "fromUnionValue", "unionValue", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion implements JSUnionValue.Companion<VideoStabilizationMode> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.types.JSUnionValue.Companion
        public VideoStabilizationMode fromUnionValue(String unionValue) {
            if (unionValue != null) {
                switch (unionValue.hashCode()) {
                    case -1348796151:
                        if (unionValue.equals("cinematic-extended")) {
                            return VideoStabilizationMode.CINEMATIC_EXTENDED;
                        }
                        break;
                    case 109935:
                        if (unionValue.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                            return VideoStabilizationMode.OFF;
                        }
                        break;
                    case 3005871:
                        if (unionValue.equals("auto")) {
                            return VideoStabilizationMode.OFF;
                        }
                        break;
                    case 1312628413:
                        if (unionValue.equals(Constants.COLLATION_STANDARD)) {
                            return VideoStabilizationMode.STANDARD;
                        }
                        break;
                    case 1598495741:
                        if (unionValue.equals("cinematic")) {
                            return VideoStabilizationMode.CINEMATIC;
                        }
                        break;
                }
            }
            throw new InvalidTypeScriptUnionError("videoStabilizationMode", unionValue);
        }

        public final VideoStabilizationMode fromDigitalVideoStabilizationMode(int stabiliazionMode) {
            if (stabiliazionMode == 0) {
                return VideoStabilizationMode.OFF;
            }
            if (stabiliazionMode == 1) {
                return VideoStabilizationMode.STANDARD;
            }
            if (stabiliazionMode == 2) {
                return VideoStabilizationMode.CINEMATIC;
            }
            return VideoStabilizationMode.OFF;
        }

        public final VideoStabilizationMode fromOpticalVideoStabilizationMode(int stabiliazionMode) {
            if (stabiliazionMode == 0) {
                return VideoStabilizationMode.OFF;
            }
            if (stabiliazionMode == 1) {
                return VideoStabilizationMode.CINEMATIC_EXTENDED;
            }
            return VideoStabilizationMode.OFF;
        }
    }
}
