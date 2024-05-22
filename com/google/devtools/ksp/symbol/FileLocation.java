package com.google.devtools.ksp.symbol;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Location.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/google/devtools/ksp/symbol/FileLocation;", "Lcom/google/devtools/ksp/symbol/Location;", "filePath", "", "lineNumber", "", "(Ljava/lang/String;I)V", "getFilePath", "()Ljava/lang/String;", "getLineNumber", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "api"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FileLocation extends Location {
    private final String filePath;
    private final int lineNumber;

    public static /* synthetic */ FileLocation copy$default(FileLocation fileLocation, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = fileLocation.filePath;
        }
        if ((i2 & 2) != 0) {
            i = fileLocation.lineNumber;
        }
        return fileLocation.copy(str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLineNumber() {
        return this.lineNumber;
    }

    public final FileLocation copy(String filePath, int lineNumber) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new FileLocation(filePath, lineNumber);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileLocation)) {
            return false;
        }
        FileLocation fileLocation = (FileLocation) other;
        return Intrinsics.areEqual(this.filePath, fileLocation.filePath) && this.lineNumber == fileLocation.lineNumber;
    }

    public int hashCode() {
        return (this.filePath.hashCode() * 31) + this.lineNumber;
    }

    public String toString() {
        return "FileLocation(filePath=" + this.filePath + ", lineNumber=" + this.lineNumber + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileLocation(String filePath, int i) {
        super(null);
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.filePath = filePath;
        this.lineNumber = i;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }
}
