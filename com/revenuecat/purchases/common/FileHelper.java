package com.revenuecat.purchases.common;

import android.content.Context;
import com.revenuecat.purchases.utils.FileExtensionsKt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: FileHelper.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00060\u0014H\u0002J*\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\u00060\u0014H\u0007J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/common/FileHelper;", "", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appendToFile", "", "filePath", "", "contentToAppend", "deleteFile", "", "fileIsEmpty", "fileSizeInKB", "", "getFileInFilesDir", "Ljava/io/File;", "getFilesDir", "openBufferedReader", "contentBlock", "Lkotlin/Function1;", "Ljava/io/BufferedReader;", "readFilePerLines", "streamBlock", "Ljava/util/stream/Stream;", "removeFirstLinesFromFile", "numberOfLinesToRemove", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class FileHelper {
    private final Context applicationContext;

    public FileHelper(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
    }

    public final double fileSizeInKB(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return FileExtensionsKt.getSizeInKB(getFileInFilesDir(filePath));
    }

    public final void appendToFile(String filePath, String contentToAppend) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(contentToAppend, "contentToAppend");
        File fileInFilesDir = getFileInFilesDir(filePath);
        File parentFile = fileInFilesDir.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(fileInFilesDir, true);
        FileOutputStream fileOutputStream2 = fileOutputStream;
        try {
            FileOutputStream fileOutputStream3 = fileOutputStream2;
            byte[] bytes = contentToAppend.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream2, null);
        } finally {
        }
    }

    public final boolean deleteFile(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return getFileInFilesDir(filePath).delete();
    }

    public final void readFilePerLines(String filePath, final Function1<? super Stream<String>, Unit> streamBlock) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(streamBlock, "streamBlock");
        openBufferedReader(filePath, new Function1<BufferedReader, Unit>() { // from class: com.revenuecat.purchases.common.FileHelper$readFilePerLines$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BufferedReader bufferedReader) {
                invoke2(bufferedReader);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BufferedReader bufferedReader) {
                Stream<String> lines;
                Intrinsics.checkNotNullParameter(bufferedReader, "bufferedReader");
                Function1<Stream<String>, Unit> function1 = streamBlock;
                lines = bufferedReader.lines();
                Intrinsics.checkNotNullExpressionValue(lines, "bufferedReader.lines()");
                function1.invoke(lines);
            }
        });
    }

    public final void removeFirstLinesFromFile(String filePath, int numberOfLinesToRemove) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        StringBuilder sb = new StringBuilder();
        readFilePerLines(filePath, new FileHelper$removeFirstLinesFromFile$1(numberOfLinesToRemove, sb));
        deleteFile(filePath);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "textToAppend.toString()");
        appendToFile(filePath, sb2);
    }

    public final boolean fileIsEmpty(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        File fileInFilesDir = getFileInFilesDir(filePath);
        return !fileInFilesDir.exists() || fileInFilesDir.length() == 0;
    }

    private final void openBufferedReader(String filePath, Function1<? super BufferedReader, Unit> contentBlock) {
        BufferedReader fileInputStream = new FileInputStream(getFileInFilesDir(filePath));
        try {
            fileInputStream = new InputStreamReader(fileInputStream);
            try {
                fileInputStream = new BufferedReader(fileInputStream);
                try {
                    contentBlock.invoke(fileInputStream);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    Unit unit3 = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    private final File getFileInFilesDir(String filePath) {
        return new File(getFilesDir(), filePath);
    }

    private final File getFilesDir() {
        File filesDir = this.applicationContext.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "applicationContext.filesDir");
        return filesDir;
    }
}
