package com.squareup.kotlinpoet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeWriter.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\fH\u0000\u001a%\u0010\u0006\u001a\u00020\u00012\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\fH\u0080\bø\u0001\u0000\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"NO_PACKAGE", "", "NULLABLE_ANY", "Lcom/squareup/kotlinpoet/TypeName;", "getNULLABLE_ANY", "()Lcom/squareup/kotlinpoet/TypeName;", "buildCodeString", "codeWriter", "Lcom/squareup/kotlinpoet/CodeWriter;", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "extractMemberName", "part", "kotlinpoet"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class CodeWriterKt {
    private static final String NO_PACKAGE = new String();
    private static final TypeName NULLABLE_ANY = TypeName.copy$default(TypeNames.ANY, true, null, 2, null);

    public static final TypeName getNULLABLE_ANY() {
        return NULLABLE_ANY;
    }

    public static final String extractMemberName(String str) {
        if (!Character.isJavaIdentifierStart(str.charAt(0))) {
            throw new IllegalArgumentException(("not an identifier: " + str).toString());
        }
        int length = str.length();
        if (1 <= length) {
            int i = 1;
            while (true) {
                String substring = str.substring(0, i);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                if (!UtilKt.isIdentifier(substring)) {
                    String substring2 = str.substring(0, i - 1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    return substring2;
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return str;
    }

    public static final String buildCodeString(Function1<? super CodeWriter, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
        try {
            builderAction.invoke(codeWriter);
            Unit unit = Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(codeWriter, null);
            InlineMarker.finallyEnd(1);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
            return sb2;
        } finally {
        }
    }

    public static final String buildCodeString(CodeWriter codeWriter, Function1<? super CodeWriter, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(codeWriter, "codeWriter");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder();
        LineWrapper lineWrapper = new LineWrapper(sb, FileSpecKt.DEFAULT_INDENT, Integer.MAX_VALUE);
        try {
            LineWrapper lineWrapper2 = codeWriter.out;
            codeWriter.out = lineWrapper;
            builderAction.invoke(codeWriter);
            codeWriter.out = lineWrapper2;
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(lineWrapper, null);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
            return sb2;
        } finally {
        }
    }
}
