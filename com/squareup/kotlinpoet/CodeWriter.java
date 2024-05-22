package com.squareup.kotlinpoet;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.onesignal.notifications.internal.bundle.impl.NotificationBundleProcessor;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CodeWriter.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u0001Bg\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010)\u001a\u00020*H\u0016J\u0018\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u0012J\u001c\u0010.\u001a\u00020*2\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u00020\u0012J\"\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00122\b\b\u0002\u00107\u001a\u00020\u0012J\u000e\u00103\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0006J+\u00103\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u00062\u0016\u00109\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010;0:\"\u0004\u0018\u00010;¢\u0006\u0002\u0010<J\u000e\u0010=\u001a\u00020*2\u0006\u00104\u001a\u000205J\u001e\u0010>\u001a\u00020*2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@002\b\b\u0002\u0010A\u001a\u00020\u0006J\b\u0010B\u001a\u00020*H\u0002J1\u0010C\u001a\u00020*2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0017\u0010D\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020*0E¢\u0006\u0002\bFH\u0086\bø\u0001\u0000J\u000e\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u000205J\u001a\u0010I\u001a\u00020*2\b\u0010J\u001a\u0004\u0018\u00010;2\u0006\u00106\u001a\u00020\u0012H\u0002J$\u0010K\u001a\u00020*2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020N0M2\u000e\b\u0002\u0010O\u001a\b\u0012\u0004\u0012\u00020N0MJ\u0018\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u0006H\u0002J\u0014\u0010S\u001a\u00020*2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020U00J\u0014\u0010V\u001a\u00020*2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020U00J\u0010\u0010W\u001a\u00020*2\u0006\u0010X\u001a\u00020\rH\u0002J\u0010\u0010Y\u001a\u00020*2\u0006\u0010Z\u001a\u00020\u000bH\u0002J\u0010\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010[\u001a\u00020\u000fJ\u0010\u0010\\\u001a\u00020\u00122\u0006\u0010]\u001a\u00020\u0006H\u0002J\u000e\u0010^\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u000bJ\u000e\u0010^\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\rJ\u0006\u0010_\u001a\u00020\u0000J\u0006\u0010`\u001a\u00020\u0000J\u000e\u0010a\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010b\u001a\u00020\u00002\u0006\u0010c\u001a\u00020(J\u0012\u0010d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010]\u001a\u00020\u0006H\u0002J$\u0010e\u001a\u00020\u00122\f\u0010L\u001a\b\u0012\u0004\u0012\u00020N0M2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020N0MH\u0002J\u0018\u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020\u0006H\u0002J\u0012\u0010h\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\bJ\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\bJ\u0010\u0010j\u001a\u00020\u00002\b\b\u0002\u0010[\u001a\u00020\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006k"}, d2 = {"Lcom/squareup/kotlinpoet/CodeWriter;", "Ljava/io/Closeable;", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "indent", "", "memberImports", "", "Lcom/squareup/kotlinpoet/Import;", "importedTypes", "Lcom/squareup/kotlinpoet/ClassName;", "importedMembers", "Lcom/squareup/kotlinpoet/MemberName;", "columnLimit", "", "(Ljava/lang/Appendable;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;I)V", "comment", "", "importableMembers", "", "importableTypes", "getImportedMembers", "()Ljava/util/Map;", "getImportedTypes", "indentLevel", "kdoc", "memberImportNames", "", "Lcom/squareup/kotlinpoet/LineWrapper;", "packageName", "referencedNames", "statementLine", "getStatementLine", "()I", "setStatementLine", "(I)V", "trailingNewline", "typeSpecStack", "", "Lcom/squareup/kotlinpoet/TypeSpec;", "close", "", "emit", "s", "nonWrapping", "emitAnnotations", "annotations", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "inline", "emitCode", "codeBlock", "Lcom/squareup/kotlinpoet/CodeBlock;", "isConstantContext", "ensureTrailingNewline", "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/CodeWriter;", "emitComment", "emitContextReceivers", "contextReceivers", "Lcom/squareup/kotlinpoet/TypeName;", "suffix", "emitIndentation", "emitInto", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "emitKdoc", "kdocCodeBlock", "emitLiteral", NotificationBundleProcessor.PUSH_MINIFIED_BUTTONS_LIST, "emitModifiers", "modifiers", "", "Lcom/squareup/kotlinpoet/KModifier;", "implicitModifiers", "emitStaticImportMember", "canonical", "part", "emitTypeVariables", "typeVariables", "Lcom/squareup/kotlinpoet/TypeVariableName;", "emitWhereBlock", "importableMember", "memberName", "importableType", "className", "levels", "isMethodNameUsedInCurrentContext", "simpleName", "lookupName", "popPackage", "popType", "pushPackage", "pushType", "type", "resolve", "shouldEmitPublicModifier", "stackClassName", "stackDepth", "suggestedMemberImports", "suggestedTypeImports", "unindent", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class CodeWriter implements Closeable {
    private boolean comment;
    private final Map<String, MemberName> importableMembers;
    private final Map<String, ClassName> importableTypes;
    private final Map<String, MemberName> importedMembers;
    private final Map<String, ClassName> importedTypes;
    private final String indent;
    private int indentLevel;
    private boolean kdoc;
    private final Set<String> memberImportNames;
    private final Map<String, Import> memberImports;
    private LineWrapper out;
    private String packageName;
    private final Set<String> referencedNames;
    private int statementLine;
    private boolean trailingNewline;
    private final List<TypeSpec> typeSpecStack;

    public CodeWriter(Appendable out, String indent, Map<String, Import> memberImports, Map<String, ClassName> importedTypes, Map<String, MemberName> importedMembers, int i) {
        String str;
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(indent, "indent");
        Intrinsics.checkNotNullParameter(memberImports, "memberImports");
        Intrinsics.checkNotNullParameter(importedTypes, "importedTypes");
        Intrinsics.checkNotNullParameter(importedMembers, "importedMembers");
        this.indent = indent;
        this.memberImports = memberImports;
        this.importedTypes = importedTypes;
        this.importedMembers = importedMembers;
        this.out = new LineWrapper(out, indent, i);
        str = CodeWriterKt.NO_PACKAGE;
        this.packageName = str;
        this.typeSpecStack = new ArrayList();
        this.memberImportNames = new LinkedHashSet();
        this.importableTypes = new LinkedHashMap();
        this.importableMembers = new LinkedHashMap();
        this.referencedNames = new LinkedHashSet();
        this.statementLine = -1;
        Iterator<Map.Entry<String, Import>> it = memberImports.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) key, '.', 0, false, 6, (Object) null);
            if (lastIndexOf$default >= 0) {
                Set<String> set = this.memberImportNames;
                String substring = key.substring(0, lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                set.add(substring);
            }
        }
    }

    public /* synthetic */ CodeWriter(Appendable appendable, String str, Map map, Map map2, Map map3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(appendable, (i2 & 2) != 0 ? FileSpecKt.DEFAULT_INDENT : str, (i2 & 4) != 0 ? MapsKt.emptyMap() : map, (i2 & 8) != 0 ? MapsKt.emptyMap() : map2, (i2 & 16) != 0 ? MapsKt.emptyMap() : map3, (i2 & 32) != 0 ? 100 : i);
    }

    public final Map<String, ClassName> getImportedTypes() {
        return this.importedTypes;
    }

    public final Map<String, MemberName> getImportedMembers() {
        return this.importedMembers;
    }

    public final int getStatementLine() {
        return this.statementLine;
    }

    public final void setStatementLine(int i) {
        this.statementLine = i;
    }

    public static /* synthetic */ CodeWriter indent$default(CodeWriter codeWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return codeWriter.indent(i);
    }

    public final CodeWriter indent(int levels) {
        this.indentLevel += levels;
        return this;
    }

    public static /* synthetic */ CodeWriter unindent$default(CodeWriter codeWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return codeWriter.unindent(i);
    }

    public final CodeWriter unindent(int levels) {
        int i = this.indentLevel;
        if (!(i - levels >= 0)) {
            throw new IllegalArgumentException(("cannot unindent " + levels + " from " + this.indentLevel).toString());
        }
        this.indentLevel = i - levels;
        return this;
    }

    public final CodeWriter pushPackage(String packageName) {
        String str;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        String str2 = this.packageName;
        str = CodeWriterKt.NO_PACKAGE;
        if (!(str2 == str)) {
            throw new IllegalStateException(("package already set: " + this.packageName).toString());
        }
        this.packageName = packageName;
        return this;
    }

    public final CodeWriter popPackage() {
        String str;
        String str2;
        String str3 = this.packageName;
        str = CodeWriterKt.NO_PACKAGE;
        if (str3 != str) {
            str2 = CodeWriterKt.NO_PACKAGE;
            this.packageName = str2;
            return this;
        }
        throw new IllegalStateException(("package already set: " + this.packageName).toString());
    }

    public final CodeWriter pushType(TypeSpec type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.typeSpecStack.add(type);
        return this;
    }

    public final CodeWriter popType() {
        this.typeSpecStack.remove(r0.size() - 1);
        return this;
    }

    public final void emitComment(CodeBlock codeBlock) {
        Intrinsics.checkNotNullParameter(codeBlock, "codeBlock");
        this.trailingNewline = true;
        this.comment = true;
        try {
            emitCode$default(this, codeBlock, false, false, 6, null);
            emit$default(this, "\n", false, 2, null);
        } finally {
            this.comment = false;
        }
    }

    public final void emitKdoc(CodeBlock kdocCodeBlock) {
        Intrinsics.checkNotNullParameter(kdocCodeBlock, "kdocCodeBlock");
        if (kdocCodeBlock.isEmpty()) {
            return;
        }
        emit$default(this, "/**\n", false, 2, null);
        this.kdoc = true;
        try {
            emitCode$default(this, kdocCodeBlock, false, true, 2, null);
            this.kdoc = false;
            emit$default(this, " */\n", false, 2, null);
        } catch (Throwable th) {
            this.kdoc = false;
            throw th;
        }
    }

    public final void emitAnnotations(List<AnnotationSpec> annotations, boolean inline) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Iterator<AnnotationSpec> it = annotations.iterator();
        while (it.hasNext()) {
            AnnotationSpec.emit$kotlinpoet$default(it.next(), this, inline, false, 4, null);
            emit$default(this, inline ? MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR : "\n", false, 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void emitModifiers$default(CodeWriter codeWriter, Set set, Set set2, int i, Object obj) {
        if ((i & 2) != 0) {
            set2 = SetsKt.emptySet();
        }
        codeWriter.emitModifiers(set, set2);
    }

    public final void emitModifiers(Set<? extends KModifier> modifiers, Set<? extends KModifier> implicitModifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        Intrinsics.checkNotNullParameter(implicitModifiers, "implicitModifiers");
        if (shouldEmitPublicModifier(modifiers, implicitModifiers)) {
            emit$default(this, KModifier.PUBLIC.getKeyword(), false, 2, null);
            emit$default(this, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, false, 2, null);
        }
        Set<? extends KModifier> set = modifiers;
        KModifier[] values = KModifier.values();
        LinkedHashSet<KModifier> linkedHashSet = new LinkedHashSet();
        for (KModifier kModifier : values) {
            if (set.contains(kModifier)) {
                linkedHashSet.add(kModifier);
            }
        }
        for (KModifier kModifier2 : linkedHashSet) {
            if (!implicitModifiers.contains(kModifier2)) {
                emit$default(this, kModifier2.getKeyword(), false, 2, null);
                emit$default(this, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, false, 2, null);
            }
        }
    }

    public static /* synthetic */ void emitContextReceivers$default(CodeWriter codeWriter, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        codeWriter.emitContextReceivers(list, str);
    }

    public final void emitContextReceivers(List<? extends TypeName> contextReceivers, String suffix) {
        Intrinsics.checkNotNullParameter(contextReceivers, "contextReceivers");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!contextReceivers.isEmpty()) {
            List<? extends TypeName> list = contextReceivers;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(CodeBlock.INSTANCE.of("%T", (TypeName) it.next()));
            }
            emitCode$default(this, CodeBlocks.joinToCode$default(arrayList, null, "context(", ")", 1, null), false, false, 6, null);
            emit$default(this, suffix, false, 2, null);
        }
    }

    public final void emitTypeVariables(List<TypeVariableName> typeVariables) {
        Intrinsics.checkNotNullParameter(typeVariables, "typeVariables");
        if (typeVariables.isEmpty()) {
            return;
        }
        emit$default(this, "<", false, 2, null);
        int i = 0;
        for (Object obj : typeVariables) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TypeVariableName typeVariableName = (TypeVariableName) obj;
            if (i > 0) {
                emit$default(this, ", ", false, 2, null);
            }
            if (typeVariableName.getVariance() != null) {
                emit$default(this, typeVariableName.getVariance().getKeyword() + ' ', false, 2, null);
            }
            if (typeVariableName.getIsReified()) {
                emit$default(this, "reified ", false, 2, null);
            }
            emitCode("%L", typeVariableName.getName());
            if (typeVariableName.getBounds().size() == 1 && !Intrinsics.areEqual(typeVariableName.getBounds().get(0), CodeWriterKt.getNULLABLE_ANY())) {
                emitCode(" : %T", typeVariableName.getBounds().get(0));
            }
            i = i2;
        }
        emit$default(this, ">", false, 2, null);
    }

    public final void emitWhereBlock(List<TypeVariableName> typeVariables) {
        Intrinsics.checkNotNullParameter(typeVariables, "typeVariables");
        if (typeVariables.isEmpty()) {
            return;
        }
        boolean z = true;
        for (TypeVariableName typeVariableName : typeVariables) {
            if (typeVariableName.getBounds().size() > 1) {
                for (TypeName typeName : typeVariableName.getBounds()) {
                    emitCode(!z ? ", " : " where ");
                    emitCode("%L : %T", typeVariableName.getName(), typeName);
                    z = false;
                }
            }
        }
    }

    public final CodeWriter emitCode(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        return emitCode$default(this, CodeBlock.INSTANCE.of(s, new Object[0]), false, false, 6, null);
    }

    public final CodeWriter emitCode(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        return emitCode$default(this, CodeBlock.INSTANCE.of(format, Arrays.copyOf(args, args.length)), false, false, 6, null);
    }

    public static /* synthetic */ CodeWriter emitCode$default(CodeWriter codeWriter, CodeBlock codeBlock, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return codeWriter.emitCode(codeBlock, z, z2);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:105:0x0055. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0247 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x001a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0244  */
    /* JADX WARN: Type inference failed for: r6v12, types: [com.squareup.kotlinpoet.TypeName] */
    /* JADX WARN: Type inference failed for: r6v14, types: [com.squareup.kotlinpoet.TypeName] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.squareup.kotlinpoet.CodeWriter emitCode(com.squareup.kotlinpoet.CodeBlock r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.kotlinpoet.CodeWriter.emitCode(com.squareup.kotlinpoet.CodeBlock, boolean, boolean):com.squareup.kotlinpoet.CodeWriter");
    }

    private final boolean emitStaticImportMember(String canonical, String part) {
        String extractMemberName;
        String extractMemberName2;
        String substring = part.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        if ((substring.length() == 0) || !Character.isJavaIdentifierStart(substring.charAt(0))) {
            return false;
        }
        Map<String, Import> map = this.memberImports;
        StringBuilder sb = new StringBuilder();
        sb.append(canonical);
        sb.append('.');
        extractMemberName = CodeWriterKt.extractMemberName(substring);
        sb.append(extractMemberName);
        Import r11 = map.get(sb.toString());
        if (r11 == null) {
            return false;
        }
        if (r11.getAlias() != null) {
            extractMemberName2 = CodeWriterKt.extractMemberName(substring);
            emit$default(this, StringsKt.replaceFirst$default(substring, extractMemberName2, r11.getAlias(), false, 4, (Object) null), false, 2, null);
        } else {
            emit$default(this, substring, false, 2, null);
        }
        return true;
    }

    private final void emitLiteral(Object r12, boolean isConstantContext) {
        if (r12 instanceof TypeSpec) {
            TypeSpec.emit$kotlinpoet$default((TypeSpec) r12, this, null, null, false, 12, null);
            return;
        }
        if (r12 instanceof AnnotationSpec) {
            ((AnnotationSpec) r12).emit$kotlinpoet(this, true, isConstantContext);
            return;
        }
        if (r12 instanceof PropertySpec) {
            PropertySpec.emit$kotlinpoet$default((PropertySpec) r12, this, SetsKt.emptySet(), false, false, false, false, 60, null);
            return;
        }
        if (r12 instanceof FunSpec) {
            ((FunSpec) r12).emit$kotlinpoet(this, null, SetsKt.setOf(KModifier.PUBLIC), true);
            return;
        }
        if (r12 instanceof TypeAliasSpec) {
            ((TypeAliasSpec) r12).emit$kotlinpoet(this);
        } else if (r12 instanceof CodeBlock) {
            emitCode$default(this, (CodeBlock) r12, isConstantContext, false, 4, null);
        } else {
            emit$default(this, String.valueOf(r12), false, 2, null);
        }
    }

    public final String lookupName(ClassName className) {
        Intrinsics.checkNotNullParameter(className, "className");
        ClassName className2 = className;
        boolean z = false;
        while (className2 != null) {
            Import r2 = this.memberImports.get(className2.getCanonicalName());
            String alias = r2 != null ? r2.getAlias() : null;
            ClassName resolve = resolve(alias == null ? className2.getSimpleName() : alias);
            boolean z2 = resolve != null;
            if (Intrinsics.areEqual(resolve, className2.copy(false, CollectionsKt.emptyList()))) {
                if (alias != null) {
                    return alias;
                }
                int size = className2.getSimpleNames().size() - 1;
                this.referencedNames.add(className.topLevelClassName().getSimpleName());
                return CollectionsKt.joinToString$default(className.getSimpleNames().subList(size, className.getSimpleNames().size()), ".", null, null, 0, null, null, 62, null);
            }
            className2 = className2.enclosingClassName();
            z = z2;
        }
        if (z) {
            return className.getCanonicalName();
        }
        if (Intrinsics.areEqual(this.packageName, className.getPackageName())) {
            this.referencedNames.add(className.topLevelClassName().getSimpleName());
            return CollectionsKt.joinToString$default(className.getSimpleNames(), ".", null, null, 0, null, null, 62, null);
        }
        if (!this.kdoc) {
            importableType(className);
        }
        return className.getCanonicalName();
    }

    public final String lookupName(MemberName memberName) {
        String simpleName;
        Intrinsics.checkNotNullParameter(memberName, "memberName");
        Import r0 = this.memberImports.get(memberName.getCanonicalName());
        if (r0 == null || (simpleName = r0.getAlias()) == null) {
            simpleName = memberName.getSimpleName();
        }
        MemberName memberName2 = this.importedMembers.get(simpleName);
        if (Intrinsics.areEqual(memberName2, memberName)) {
            return simpleName;
        }
        if (memberName2 != null && memberName.getEnclosingClassName() != null) {
            return lookupName(memberName.getEnclosingClassName()) + '.' + simpleName;
        }
        if (Intrinsics.areEqual(this.packageName, memberName.getPackageName()) && memberName.getEnclosingClassName() == null) {
            this.referencedNames.add(memberName.getSimpleName());
            return memberName.getSimpleName();
        }
        if (!this.kdoc && (memberName.isExtension() || !isMethodNameUsedInCurrentContext(memberName.getSimpleName()))) {
            importableMember(memberName);
        }
        return memberName.getCanonicalName();
    }

    private final boolean isMethodNameUsedInCurrentContext(String simpleName) {
        boolean z;
        for (TypeSpec typeSpec : CollectionsKt.reversed(this.typeSpecStack)) {
            List<FunSpec> funSpecs = typeSpec.getFunSpecs();
            if (!(funSpecs instanceof Collection) || !funSpecs.isEmpty()) {
                Iterator<T> it = funSpecs.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((FunSpec) it.next()).getName(), simpleName)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
            if (!typeSpec.getModifiers().contains(KModifier.INNER)) {
                break;
            }
        }
        return false;
    }

    private final void importableType(ClassName className) {
        String simpleName;
        ClassName className2 = className.topLevelClassName();
        Import r3 = this.memberImports.get(className.getCanonicalName());
        if (r3 == null || (simpleName = r3.getAlias()) == null) {
            simpleName = className2.getSimpleName();
        }
        if (this.importableMembers.containsKey(simpleName)) {
            return;
        }
        this.importableTypes.putIfAbsent(simpleName, className2);
    }

    private final void importableMember(MemberName memberName) {
        String simpleName;
        Object putIfAbsent;
        if (memberName.getPackageName().length() > 0) {
            Import r0 = this.memberImports.get(memberName.getCanonicalName());
            if (r0 == null || (simpleName = r0.getAlias()) == null) {
                simpleName = memberName.getSimpleName();
            }
            if (this.importableTypes.containsKey(simpleName)) {
                return;
            }
            putIfAbsent = this.importableMembers.putIfAbsent(simpleName, memberName);
            if (((MemberName) putIfAbsent) == null || memberName.getEnclosingClassName() == null) {
                return;
            }
            importableType(memberName.getEnclosingClassName());
        }
    }

    private final ClassName resolve(String simpleName) {
        int size = this.typeSpecStack.size() - 1;
        if (size >= 0) {
            while (true) {
                int i = size - 1;
                if (this.typeSpecStack.get(size).getNestedTypesSimpleNames$kotlinpoet().contains(simpleName)) {
                    return stackClassName(size, simpleName);
                }
                if (i < 0) {
                    break;
                }
                size = i;
            }
        }
        if (this.typeSpecStack.size() > 0) {
            TypeSpec typeSpec = this.typeSpecStack.get(0);
            if (Intrinsics.areEqual(typeSpec.getName(), simpleName)) {
                return new ClassName(this.packageName, simpleName);
            }
            if (typeSpec.getIsEnum() && typeSpec.getEnumConstants().keySet().contains(simpleName)) {
                String str = this.packageName;
                String name = typeSpec.getName();
                Intrinsics.checkNotNull(name);
                return new ClassName(str, name).nestedClass(simpleName);
            }
        }
        ClassName className = this.importedTypes.get(simpleName);
        if (className != null) {
            return className;
        }
        return null;
    }

    private final ClassName stackClassName(int stackDepth, String simpleName) {
        String str = this.packageName;
        String name = this.typeSpecStack.get(0).getName();
        Intrinsics.checkNotNull(name);
        ClassName className = new ClassName(str, name);
        int i = 1;
        if (1 <= stackDepth) {
            while (true) {
                String name2 = this.typeSpecStack.get(i).getName();
                Intrinsics.checkNotNull(name2);
                className = className.nestedClass(name2);
                if (i == stackDepth) {
                    break;
                }
                i++;
            }
        }
        return className.nestedClass(simpleName);
    }

    public static /* synthetic */ CodeWriter emit$default(CodeWriter codeWriter, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return codeWriter.emit(str, z);
    }

    public final CodeWriter emit(String s, boolean nonWrapping) {
        Intrinsics.checkNotNullParameter(s, "s");
        boolean z = true;
        for (String str : StringsKt.split$default((CharSequence) s, new char[]{'\n'}, false, 0, 6, (Object) null)) {
            if (!z) {
                if ((this.kdoc || this.comment) && this.trailingNewline) {
                    emitIndentation();
                    this.out.appendNonWrapping(this.kdoc ? " *" : "//");
                }
                this.out.newline();
                this.trailingNewline = true;
                int i = this.statementLine;
                if (i != -1) {
                    if (i == 0) {
                        indent(2);
                    }
                    this.statementLine++;
                }
            }
            if (!(str.length() == 0)) {
                if (this.trailingNewline) {
                    emitIndentation();
                    if (this.kdoc) {
                        this.out.appendNonWrapping(" * ");
                    } else if (this.comment) {
                        this.out.appendNonWrapping("// ");
                    }
                }
                if (nonWrapping) {
                    this.out.appendNonWrapping(str);
                } else {
                    LineWrapper lineWrapper = this.out;
                    boolean z2 = this.kdoc;
                    lineWrapper.append(str, z2 ? this.indentLevel : 2 + this.indentLevel, z2 ? " * " : "");
                }
                this.trailingNewline = false;
            }
            z = false;
        }
        return this;
    }

    private final void emitIndentation() {
        int i = this.indentLevel;
        for (int i2 = 0; i2 < i; i2++) {
            this.out.appendNonWrapping(this.indent);
        }
    }

    private final boolean shouldEmitPublicModifier(Set<? extends KModifier> modifiers, Set<? extends KModifier> implicitModifiers) {
        if (modifiers.contains(KModifier.PUBLIC)) {
            return true;
        }
        if (implicitModifiers.contains(KModifier.PUBLIC)) {
            return !UtilKt.containsAnyOf(modifiers, KModifier.PRIVATE, KModifier.INTERNAL, KModifier.PROTECTED);
        }
        return false;
    }

    public final Map<String, ClassName> suggestedTypeImports() {
        Map<String, ClassName> map = this.importableTypes;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ClassName> entry : map.entrySet()) {
            if (!this.referencedNames.contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public final Map<String, MemberName> suggestedMemberImports() {
        Map<String, MemberName> map = this.importableMembers;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, MemberName> entry : map.entrySet()) {
            if (!this.referencedNames.contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public final void emitInto(Appendable out, Function1<? super CodeWriter, Unit> action) {
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(action, "action");
        LineWrapper lineWrapper = new LineWrapper(out, FileSpecKt.DEFAULT_INDENT, Integer.MAX_VALUE);
        try {
            LineWrapper lineWrapper2 = this.out;
            this.out = lineWrapper;
            action.invoke(this);
            this.out = lineWrapper2;
            Unit unit = Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(lineWrapper, null);
            InlineMarker.finallyEnd(1);
        } finally {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
    }
}
