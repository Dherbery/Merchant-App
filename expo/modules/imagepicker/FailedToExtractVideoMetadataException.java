package expo.modules.imagepicker;

import android.net.Uri;
import expo.modules.kotlin.exception.CodedException;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ImagePickerExceptions.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/imagepicker/FailedToExtractVideoMetadataException;", "Lexpo/modules/kotlin/exception/CodedException;", "file", "Ljava/io/File;", "cause", "", "(Ljava/io/File;Ljava/lang/Throwable;)V", "expo-image-picker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FailedToExtractVideoMetadataException extends CodedException {
    public FailedToExtractVideoMetadataException() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ FailedToExtractVideoMetadataException(File file, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : file, (i & 2) != 0 ? null : th);
    }

    public FailedToExtractVideoMetadataException(File file, Throwable th) {
        super("Failed to extract metadata from video file '" + ((file == null || (r3 = Uri.fromFile(file)) == null || (r3 = r3.toString()) == null) ? "" : r3) + "'", th);
        Uri fromFile;
        String uri;
    }
}
