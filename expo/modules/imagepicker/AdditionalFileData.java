package expo.modules.imagepicker;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MediaHandler.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lexpo/modules/imagepicker/AdditionalFileData;", "", "fileName", "", "filesize", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "getFileName", "()Ljava/lang/String;", "getFilesize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lexpo/modules/imagepicker/AdditionalFileData;", "equals", "", "other", "hashCode", "", "toString", "expo-image-picker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AdditionalFileData {
    private final String fileName;
    private final Long filesize;

    public static /* synthetic */ AdditionalFileData copy$default(AdditionalFileData additionalFileData, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = additionalFileData.fileName;
        }
        if ((i & 2) != 0) {
            l = additionalFileData.filesize;
        }
        return additionalFileData.copy(str, l);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getFilesize() {
        return this.filesize;
    }

    public final AdditionalFileData copy(String fileName, Long filesize) {
        return new AdditionalFileData(fileName, filesize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdditionalFileData)) {
            return false;
        }
        AdditionalFileData additionalFileData = (AdditionalFileData) other;
        return Intrinsics.areEqual(this.fileName, additionalFileData.fileName) && Intrinsics.areEqual(this.filesize, additionalFileData.filesize);
    }

    public int hashCode() {
        String str = this.fileName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.filesize;
        return hashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "AdditionalFileData(fileName=" + this.fileName + ", filesize=" + this.filesize + ")";
    }

    public AdditionalFileData(String str, Long l) {
        this.fileName = str;
        this.filesize = l;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Long getFilesize() {
        return this.filesize;
    }
}
