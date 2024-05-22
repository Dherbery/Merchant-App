package expo.modules.imagepicker;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.codec.language.bm.Rule;

/* compiled from: ImagePickerOptions.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0080\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lexpo/modules/imagepicker/MediaTypes;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toCameraIntentAction", "toFileExtension", "toMimeType", "IMAGES", "VIDEOS", Rule.ALL, "Companion", "expo-image-picker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum MediaTypes implements Enumerable {
    IMAGES("Images"),
    VIDEOS("Videos"),
    ALL("All");


    @Deprecated
    public static final String AllMimeType = "*/*";
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String ImageAllMimeType = "image/*";

    @Deprecated
    public static final String VideoAllMimeType = "video/*";
    private final String value;

    /* compiled from: ImagePickerOptions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaTypes.values().length];
            try {
                iArr[MediaTypes.IMAGES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaTypes.VIDEOS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaTypes.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    MediaTypes(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final String toMimeType() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return ImageAllMimeType;
        }
        if (i == 2) {
            return VideoAllMimeType;
        }
        if (i == 3) {
            return AllMimeType;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String toFileExtension() {
        return WhenMappings.$EnumSwitchMapping$0[ordinal()] == 2 ? ".mp4" : ".jpeg";
    }

    public final String toCameraIntentAction() {
        return WhenMappings.$EnumSwitchMapping$0[ordinal()] == 2 ? "android.media.action.VIDEO_CAPTURE" : "android.media.action.IMAGE_CAPTURE";
    }

    /* compiled from: ImagePickerOptions.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lexpo/modules/imagepicker/MediaTypes$Companion;", "", "()V", "AllMimeType", "", "ImageAllMimeType", "VideoAllMimeType", "expo-image-picker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
