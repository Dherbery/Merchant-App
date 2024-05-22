package com.squareup.kotlinpoet.ksp;

import com.google.devtools.ksp.processing.CodeGenerator;
import com.google.devtools.ksp.processing.Dependencies;
import com.google.devtools.ksp.symbol.KSFile;
import com.squareup.kotlinpoet.FileSpec;
import com.squareup.kotlinpoet.FunSpec;
import com.squareup.kotlinpoet.PropertySpec;
import com.squareup.kotlinpoet.Taggable;
import com.squareup.kotlinpoet.TypeAliasSpec;
import com.squareup.kotlinpoet.TypeSpec;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: originatingKSFiles.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\tH\u0002\u001a\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b*\u0006\u0012\u0002\b\u00030\fH\u0002\u001a\"\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013\u001a\u0010\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\u000f\u001a\u0010\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\u0014\u001a\u0010\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\u0015\u001a\u0010\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\u0016\u001a\u0010\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\u0017\u001a\u001a\u0010\u0018\u001a\u00020\u0019*\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e\u001a*\u0010\u0018\u001a\u00020\u0019*\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¨\u0006\u001d"}, d2 = {"addOriginatingKSFile", "Lcom/squareup/kotlinpoet/FunSpec$Builder;", "ksFile", "Lcom/google/devtools/ksp/symbol/KSFile;", "Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "Lcom/squareup/kotlinpoet/TypeAliasSpec$Builder;", "Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "getKSFilesTag", "", "Lcom/squareup/kotlinpoet/Taggable;", "getOrCreateKSFilesTag", "", "Lcom/squareup/kotlinpoet/Taggable$Builder;", "kspDependencies", "Lcom/google/devtools/ksp/processing/Dependencies;", "Lcom/squareup/kotlinpoet/FileSpec;", "aggregating", "", "originatingKSFiles", "", "Lcom/squareup/kotlinpoet/FunSpec;", "Lcom/squareup/kotlinpoet/PropertySpec;", "Lcom/squareup/kotlinpoet/TypeAliasSpec;", "Lcom/squareup/kotlinpoet/TypeSpec;", "writeTo", "", "codeGenerator", "Lcom/google/devtools/ksp/processing/CodeGenerator;", "dependencies", "ksp"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OriginatingKSFilesKt {
    public static final List<KSFile> originatingKSFiles(TypeSpec typeSpec) {
        Intrinsics.checkNotNullParameter(typeSpec, "<this>");
        return getKSFilesTag(typeSpec);
    }

    public static final List<KSFile> originatingKSFiles(FunSpec funSpec) {
        Intrinsics.checkNotNullParameter(funSpec, "<this>");
        return getKSFilesTag(funSpec);
    }

    public static final List<KSFile> originatingKSFiles(PropertySpec propertySpec) {
        Intrinsics.checkNotNullParameter(propertySpec, "<this>");
        return getKSFilesTag(propertySpec);
    }

    public static final List<KSFile> originatingKSFiles(TypeAliasSpec typeAliasSpec) {
        Intrinsics.checkNotNullParameter(typeAliasSpec, "<this>");
        return getKSFilesTag(typeAliasSpec);
    }

    public static final List<KSFile> originatingKSFiles(FileSpec fileSpec) {
        List<KSFile> originatingKSFiles;
        Intrinsics.checkNotNullParameter(fileSpec, "<this>");
        List<Object> members = fileSpec.getMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : members) {
            if (obj instanceof FunSpec) {
                originatingKSFiles = originatingKSFiles((FunSpec) obj);
            } else if (obj instanceof PropertySpec) {
                originatingKSFiles = originatingKSFiles((PropertySpec) obj);
            } else if (obj instanceof TypeSpec) {
                originatingKSFiles = originatingKSFiles((TypeSpec) obj);
            } else {
                originatingKSFiles = obj instanceof TypeAliasSpec ? originatingKSFiles((TypeAliasSpec) obj) : CollectionsKt.emptyList();
            }
            CollectionsKt.addAll(arrayList, originatingKSFiles);
        }
        return CollectionsKt.distinct(arrayList);
    }

    public static final TypeAliasSpec.Builder addOriginatingKSFile(TypeAliasSpec.Builder builder, KSFile ksFile) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(ksFile, "ksFile");
        getOrCreateKSFilesTag(builder).add(ksFile);
        return builder;
    }

    public static final PropertySpec.Builder addOriginatingKSFile(PropertySpec.Builder builder, KSFile ksFile) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(ksFile, "ksFile");
        getOrCreateKSFilesTag(builder).add(ksFile);
        return builder;
    }

    public static final FunSpec.Builder addOriginatingKSFile(FunSpec.Builder builder, KSFile ksFile) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(ksFile, "ksFile");
        getOrCreateKSFilesTag(builder).add(ksFile);
        return builder;
    }

    public static final TypeSpec.Builder addOriginatingKSFile(TypeSpec.Builder builder, KSFile ksFile) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(ksFile, "ksFile");
        getOrCreateKSFilesTag(builder).add(ksFile);
        return builder;
    }

    public static /* synthetic */ void writeTo$default(FileSpec fileSpec, CodeGenerator codeGenerator, boolean z, Iterable iterable, int i, Object obj) {
        if ((i & 4) != 0) {
            iterable = originatingKSFiles(fileSpec);
        }
        writeTo(fileSpec, codeGenerator, z, iterable);
    }

    public static final void writeTo(FileSpec fileSpec, CodeGenerator codeGenerator, boolean z, Iterable<? extends KSFile> originatingKSFiles) {
        Intrinsics.checkNotNullParameter(fileSpec, "<this>");
        Intrinsics.checkNotNullParameter(codeGenerator, "codeGenerator");
        Intrinsics.checkNotNullParameter(originatingKSFiles, "originatingKSFiles");
        writeTo(fileSpec, codeGenerator, kspDependencies(fileSpec, z, originatingKSFiles));
    }

    public static final void writeTo(FileSpec fileSpec, CodeGenerator codeGenerator, Dependencies dependencies) {
        Intrinsics.checkNotNullParameter(fileSpec, "<this>");
        Intrinsics.checkNotNullParameter(codeGenerator, "codeGenerator");
        Intrinsics.checkNotNullParameter(dependencies, "dependencies");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(CodeGenerator.createNewFile$default(codeGenerator, dependencies, fileSpec.getPackageName(), fileSpec.getName(), null, 8, null), StandardCharsets.UTF_8);
        try {
            fileSpec.writeTo(outputStreamWriter);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStreamWriter, null);
        } finally {
        }
    }

    public static /* synthetic */ Dependencies kspDependencies$default(FileSpec fileSpec, boolean z, Iterable iterable, int i, Object obj) {
        if ((i & 2) != 0) {
            iterable = originatingKSFiles(fileSpec);
        }
        return kspDependencies(fileSpec, z, iterable);
    }

    public static final Dependencies kspDependencies(FileSpec fileSpec, boolean z, Iterable<? extends KSFile> originatingKSFiles) {
        Intrinsics.checkNotNullParameter(fileSpec, "<this>");
        Intrinsics.checkNotNullParameter(originatingKSFiles, "originatingKSFiles");
        Object[] array = CollectionsKt.toList(originatingKSFiles).toArray(new KSFile[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        KSFile[] kSFileArr = (KSFile[]) array;
        return new Dependencies(z, (KSFile[]) Arrays.copyOf(kSFileArr, kSFileArr.length));
    }

    private static final List<KSFile> getOrCreateKSFilesTag(Taggable.Builder<?> builder) {
        Map<KClass<?>, Object> tags = builder.getTags();
        KClass<?> orCreateKotlinClass = Reflection.getOrCreateKotlinClass(OriginatingKSFiles.class);
        Object obj = tags.get(orCreateKotlinClass);
        if (obj == null) {
            obj = new MutableOriginatingKSFilesImpl(null, 1, null);
            tags.put(orCreateKotlinClass, obj);
        }
        return ((MutableOriginatingKSFiles) obj).getFiles();
    }

    private static final List<KSFile> getKSFilesTag(Taggable taggable) {
        OriginatingKSFiles originatingKSFiles = (OriginatingKSFiles) taggable.tag(Reflection.getOrCreateKotlinClass(OriginatingKSFiles.class));
        List<KSFile> files = originatingKSFiles != null ? originatingKSFiles.getFiles() : null;
        return files == null ? CollectionsKt.emptyList() : files;
    }
}
