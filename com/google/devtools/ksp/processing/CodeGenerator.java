package com.google.devtools.ksp.processing;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSFile;
import com.onesignal.session.internal.outcomes.impl.OutcomeConstants;
import java.io.File;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

/* compiled from: CodeGenerator.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH&J(\u0010\u0010\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH&J0\u0010\u0012\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH&J*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH&J\"\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/google/devtools/ksp/processing/CodeGenerator;", "", "generatedFile", "", "Ljava/io/File;", "getGeneratedFile", "()Ljava/util/Collection;", "associate", "", OutcomeConstants.OUTCOME_SOURCES, "", "Lcom/google/devtools/ksp/symbol/KSFile;", "packageName", "", "fileName", "extensionName", "associateByPath", ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, "associateWithClasses", "classes", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "createNewFile", "Ljava/io/OutputStream;", "dependencies", "Lcom/google/devtools/ksp/processing/Dependencies;", "createNewFileByPath", "api"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface CodeGenerator {
    void associate(List<? extends KSFile> sources, String packageName, String fileName, String extensionName);

    void associateByPath(List<? extends KSFile> sources, String path, String extensionName);

    void associateWithClasses(List<? extends KSClassDeclaration> classes, String packageName, String fileName, String extensionName);

    OutputStream createNewFile(Dependencies dependencies, String packageName, String fileName, String extensionName);

    OutputStream createNewFileByPath(Dependencies dependencies, String path, String extensionName);

    Collection<File> getGeneratedFile();

    /* compiled from: CodeGenerator.kt */
    /* renamed from: com.google.devtools.ksp.processing.CodeGenerator$-CC, reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ OutputStream createNewFile$default(CodeGenerator codeGenerator, Dependencies dependencies, String str, String str2, String str3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createNewFile");
            }
            if ((i & 8) != 0) {
                str3 = "kt";
            }
            return codeGenerator.createNewFile(dependencies, str, str2, str3);
        }

        public static /* synthetic */ OutputStream createNewFileByPath$default(CodeGenerator codeGenerator, Dependencies dependencies, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createNewFileByPath");
            }
            if ((i & 4) != 0) {
                str2 = "kt";
            }
            return codeGenerator.createNewFileByPath(dependencies, str, str2);
        }

        public static /* synthetic */ void associate$default(CodeGenerator codeGenerator, List list, String str, String str2, String str3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: associate");
            }
            if ((i & 8) != 0) {
                str3 = "kt";
            }
            codeGenerator.associate(list, str, str2, str3);
        }

        public static /* synthetic */ void associateByPath$default(CodeGenerator codeGenerator, List list, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: associateByPath");
            }
            if ((i & 4) != 0) {
                str2 = "kt";
            }
            codeGenerator.associateByPath(list, str, str2);
        }

        public static /* synthetic */ void associateWithClasses$default(CodeGenerator codeGenerator, List list, String str, String str2, String str3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: associateWithClasses");
            }
            if ((i & 8) != 0) {
                str3 = "kt";
            }
            codeGenerator.associateWithClasses(list, str, str2, str3);
        }
    }

    /* compiled from: CodeGenerator.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
    }
}
