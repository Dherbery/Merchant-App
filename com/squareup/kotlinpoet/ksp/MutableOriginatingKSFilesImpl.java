package com.squareup.kotlinpoet.ksp;

import com.google.devtools.ksp.symbol.KSFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: originatingKSFiles.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/squareup/kotlinpoet/ksp/MutableOriginatingKSFilesImpl;", "Lcom/squareup/kotlinpoet/ksp/MutableOriginatingKSFiles;", "files", "", "Lcom/google/devtools/ksp/symbol/KSFile;", "(Ljava/util/List;)V", "getFiles", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ksp"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
final /* data */ class MutableOriginatingKSFilesImpl implements MutableOriginatingKSFiles {
    private final List<KSFile> files;

    public MutableOriginatingKSFilesImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MutableOriginatingKSFilesImpl copy$default(MutableOriginatingKSFilesImpl mutableOriginatingKSFilesImpl, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mutableOriginatingKSFilesImpl.getFiles();
        }
        return mutableOriginatingKSFilesImpl.copy(list);
    }

    public final List<KSFile> component1() {
        return getFiles();
    }

    public final MutableOriginatingKSFilesImpl copy(List<KSFile> files) {
        Intrinsics.checkNotNullParameter(files, "files");
        return new MutableOriginatingKSFilesImpl(files);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MutableOriginatingKSFilesImpl) && Intrinsics.areEqual(getFiles(), ((MutableOriginatingKSFilesImpl) other).getFiles());
    }

    public int hashCode() {
        return getFiles().hashCode();
    }

    public String toString() {
        return "MutableOriginatingKSFilesImpl(files=" + getFiles() + ')';
    }

    public MutableOriginatingKSFilesImpl(List<KSFile> files) {
        Intrinsics.checkNotNullParameter(files, "files");
        this.files = files;
    }

    public /* synthetic */ MutableOriginatingKSFilesImpl(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    @Override // com.squareup.kotlinpoet.ksp.MutableOriginatingKSFiles, com.squareup.kotlinpoet.ksp.OriginatingKSFiles
    public List<KSFile> getFiles() {
        return this.files;
    }
}
