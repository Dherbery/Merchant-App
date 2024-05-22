package com.squareup.kotlinpoet;

import com.amazon.a.a.n.a.a.g;
import com.onesignal.notifications.internal.bundle.impl.NotificationBundleProcessor;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: CodeBlock.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0002\"#B%\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\r\u0010\r\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u001d\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0015\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\r\u0010\u001d\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001eJ\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u00002\u0006\u0010 \u001a\u00020\u0000H\u0000¢\u0006\u0002\b!R\u001c\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006$"}, d2 = {"Lcom/squareup/kotlinpoet/CodeBlock;", "", "formatParts", "", "", "args", "(Ljava/util/List;Ljava/util/List;)V", "getArgs$kotlinpoet", "()Ljava/util/List;", "getFormatParts$kotlinpoet", "equals", "", "other", "hasStatements", "hasStatements$kotlinpoet", "hashCode", "", "isEmpty", "isNotEmpty", "replaceAll", "oldValue", "newValue", "replaceAll$kotlinpoet", "toBuilder", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "toString", "codeWriter", "Lcom/squareup/kotlinpoet/CodeWriter;", "toString$kotlinpoet", "trim", "trim$kotlinpoet", "withoutPrefix", "prefix", "withoutPrefix$kotlinpoet", "Builder", "Companion", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class CodeBlock {
    private static final int ARG_NAME = 1;
    private static final int TYPE_NAME = 2;
    private final List<Object> args;
    private final List<String> formatParts;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex NAMED_ARGUMENT = new Regex("%([\\w_]+):([\\w]).*");
    private static final Regex LOWERCASE = new Regex("[a-z]+[\\w_]*");
    private static final Set<String> NO_ARG_PLACEHOLDERS = SetsKt.setOf((Object[]) new String[]{"⇥", "⇤", "«", "»"});
    private static final CodeBlock EMPTY = new CodeBlock(CollectionsKt.emptyList(), CollectionsKt.emptyList());

    public /* synthetic */ CodeBlock(List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2);
    }

    @JvmStatic
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    @JvmStatic
    public static final CodeBlock of(String str, Object... objArr) {
        return INSTANCE.of(str, objArr);
    }

    private CodeBlock(List<String> list, List<? extends Object> list2) {
        this.formatParts = list;
        this.args = list2;
    }

    public final List<String> getFormatParts$kotlinpoet() {
        return this.formatParts;
    }

    public final List<Object> getArgs$kotlinpoet() {
        return this.args;
    }

    public final boolean isEmpty() {
        return this.formatParts.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    public final CodeBlock withoutPrefix$kotlinpoet(CodeBlock prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (this.formatParts.size() < prefix.formatParts.size() || this.args.size() < prefix.args.size()) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        String str = null;
        for (Object obj : prefix.formatParts) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str2 = (String) obj;
            if (!Intrinsics.areEqual(this.formatParts.get(i), str2)) {
                if (i != prefix.formatParts.size() - 1 || !StringsKt.startsWith$default(this.formatParts.get(i), str2, false, 2, (Object) null)) {
                    return null;
                }
                str = this.formatParts.get(i).substring(str2.length());
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
            }
            if (StringsKt.startsWith$default(str2, "%", false, 2, (Object) null) && !INSTANCE.isMultiCharNoArgPlaceholder$kotlinpoet(str2.charAt(1))) {
                if (!Intrinsics.areEqual(this.args.get(i2), prefix.args.get(i2))) {
                    return null;
                }
                i2++;
            }
            i = i3;
        }
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(str);
        }
        int size = this.formatParts.size();
        for (int size2 = prefix.formatParts.size(); size2 < size; size2++) {
            arrayList.add(this.formatParts.get(size2));
        }
        ArrayList arrayList2 = new ArrayList();
        int size3 = this.args.size();
        for (int size4 = prefix.args.size(); size4 < size3; size4++) {
            arrayList2.add(this.args.get(size4));
        }
        return new CodeBlock(arrayList, arrayList2);
    }

    public final CodeBlock trim$kotlinpoet() {
        int size = this.formatParts.size();
        int i = 0;
        while (i < size && NO_ARG_PLACEHOLDERS.contains(this.formatParts.get(i))) {
            i++;
        }
        while (i < size && NO_ARG_PLACEHOLDERS.contains(this.formatParts.get(size - 1))) {
            size--;
        }
        return (i > 0 || size < this.formatParts.size()) ? new CodeBlock(this.formatParts.subList(i, size), this.args) : this;
    }

    public final CodeBlock replaceAll$kotlinpoet(String oldValue, String newValue) {
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        List<String> list = this.formatParts;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.replace$default((String) it.next(), oldValue, newValue, false, 4, (Object) null));
        }
        return new CodeBlock(arrayList, this.args);
    }

    public final boolean hasStatements$kotlinpoet() {
        List<String> list = this.formatParts;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (StringsKt.contains$default((CharSequence) it.next(), (CharSequence) "«", false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && Intrinsics.areEqual(getClass(), other.getClass())) {
            return Intrinsics.areEqual(toString(), other.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final String toString$kotlinpoet(CodeWriter codeWriter) {
        Intrinsics.checkNotNullParameter(codeWriter, "codeWriter");
        return CodeWriterKt.buildCodeString(codeWriter, new Function1<CodeWriter, Unit>() { // from class: com.squareup.kotlinpoet.CodeBlock$toString$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CodeWriter codeWriter2) {
                invoke2(codeWriter2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CodeWriter buildCodeString) {
                Intrinsics.checkNotNullParameter(buildCodeString, "$this$buildCodeString");
                CodeWriter.emitCode$default(buildCodeString, CodeBlock.this, false, false, 6, null);
            }
        });
    }

    public final Builder toBuilder() {
        Builder builder = new Builder();
        CollectionsKt.addAll(builder.getFormatParts$kotlinpoet(), this.formatParts);
        builder.getArgs$kotlinpoet().addAll(this.args);
        return builder;
    }

    /* compiled from: CodeBlock.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ+\u0010\n\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\b2\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000fJ\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J \u0010\u0015\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\b2\u0010\u0010\u0016\u001a\f\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u00030\u0017J+\u0010\u0018\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\b2\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J+\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\b2\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000fJ\u0006\u0010!\u001a\u00020\fJ\u0006\u0010\"\u001a\u00020\u0000J\u0006\u0010#\u001a\u00020\u0000J\u0006\u0010$\u001a\u00020\u0000J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020&J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0001H\u0002J+\u0010)\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\b2\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000fJ\u0006\u0010*\u001a\u00020\u0000J\f\u0010+\u001a\u00020\b*\u00020\bH\u0002R\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006¨\u0006,"}, d2 = {"Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "", "()V", "args", "", "getArgs$kotlinpoet", "()Ljava/util/List;", "formatParts", "", "getFormatParts$kotlinpoet", "add", "codeBlock", "Lcom/squareup/kotlinpoet/CodeBlock;", "format", "", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "addArgument", "", "c", "", "arg", "addNamed", "arguments", "", "addStatement", "argToLiteral", NotificationBundleProcessor.PUSH_MINIFIED_BUTTONS_LIST, "argToName", "argToString", "argToType", "Lcom/squareup/kotlinpoet/TypeName;", "beginControlFlow", "controlFlow", "build", "clear", "endControlFlow", "indent", "isEmpty", "", "isNotEmpty", "logDeprecationWarning", "nextControlFlow", "unindent", "withOpeningBrace", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder {
        private final List<String> formatParts = new ArrayList();
        private final List<Object> args = new ArrayList();

        private final Object argToLiteral(Object o) {
            return o;
        }

        public final List<String> getFormatParts$kotlinpoet() {
            return this.formatParts;
        }

        public final List<Object> getArgs$kotlinpoet() {
            return this.args;
        }

        public final boolean isEmpty() {
            return this.formatParts.isEmpty();
        }

        public final boolean isNotEmpty() {
            return !isEmpty();
        }

        /* JADX WARN: Code restructure failed: missing block: B:55:0x0198, code lost:
        
            return r12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.squareup.kotlinpoet.CodeBlock.Builder addNamed(java.lang.String r13, java.util.Map<java.lang.String, ?> r14) {
            /*
                Method dump skipped, instructions count: 409
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.kotlinpoet.CodeBlock.Builder.addNamed(java.lang.String, java.util.Map):com.squareup.kotlinpoet.CodeBlock$Builder");
        }

        public final Builder add(String format, Object... args) {
            boolean z;
            int i;
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            int[] iArr = new int[args.length];
            int i2 = 0;
            boolean z2 = false;
            int i3 = 0;
            boolean z3 = false;
            while (true) {
                if (i2 >= format.length()) {
                    if (z2) {
                        if (!(i3 >= args.length)) {
                            throw new IllegalArgumentException(("unused arguments: expected " + i3 + ", received " + args.length).toString());
                        }
                    }
                    if (z3) {
                        ArrayList arrayList = new ArrayList();
                        int length = args.length;
                        for (int i4 = 0; i4 < length; i4++) {
                            if (iArr[i4] == 0) {
                                arrayList.add("%" + (i4 + 1));
                            }
                        }
                        String str = arrayList.size() == 1 ? "" : "s";
                        if (!arrayList.isEmpty()) {
                            throw new IllegalArgumentException(("unused argument" + str + ": " + CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null)).toString());
                        }
                    }
                    return this;
                }
                if (CodeBlock.INSTANCE.isSingleCharNoArgPlaceholder$kotlinpoet(format.charAt(i2))) {
                    this.formatParts.add(String.valueOf(format.charAt(i2)));
                    i2++;
                } else if (format.charAt(i2) != '%') {
                    int nextPotentialPlaceholderPosition$kotlinpoet = CodeBlock.INSTANCE.nextPotentialPlaceholderPosition$kotlinpoet(format, i2 + 1);
                    if (nextPotentialPlaceholderPosition$kotlinpoet == -1) {
                        nextPotentialPlaceholderPosition$kotlinpoet = format.length();
                    }
                    List<String> list = this.formatParts;
                    String substring = format.substring(i2, nextPotentialPlaceholderPosition$kotlinpoet);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    list.add(substring);
                    i2 = nextPotentialPlaceholderPosition$kotlinpoet;
                } else {
                    int i5 = i2 + 1;
                    int i6 = i5;
                    while (true) {
                        if (!(i6 < format.length())) {
                            throw new IllegalArgumentException(("dangling format characters in '" + format + '\'').toString());
                        }
                        int i7 = i6 + 1;
                        char charAt = format.charAt(i6);
                        if ('0' <= charAt && charAt < ':') {
                            i6 = i7;
                        } else {
                            int i8 = i7 - 1;
                            if (CodeBlock.INSTANCE.isMultiCharNoArgPlaceholder$kotlinpoet(charAt)) {
                                if (!(i5 == i8)) {
                                    throw new IllegalArgumentException("%% may not have an index".toString());
                                }
                                this.formatParts.add("%" + charAt);
                                i2 = i7;
                            } else {
                                if (i5 < i8) {
                                    String substring2 = format.substring(i5, i8);
                                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                                    int parseInt = Integer.parseInt(substring2) - 1;
                                    if (!(args.length == 0)) {
                                        int length2 = parseInt % args.length;
                                        iArr[length2] = iArr[length2] + 1;
                                    }
                                    z = true;
                                    i = i3;
                                    i3 = parseInt;
                                } else {
                                    z = z3;
                                    i = i3 + 1;
                                    z2 = true;
                                }
                                if (!(i3 >= 0 && i3 < args.length)) {
                                    StringBuilder sb = new StringBuilder("index ");
                                    sb.append(i3 + 1);
                                    sb.append(" for '");
                                    String substring3 = format.substring(i5 - 1, i8 + 1);
                                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                                    sb.append(substring3);
                                    sb.append("' not in range (received ");
                                    sb.append(args.length);
                                    sb.append(" arguments)");
                                    throw new IllegalArgumentException(sb.toString().toString());
                                }
                                if (z && z2) {
                                    r11 = false;
                                }
                                if (!r11) {
                                    throw new IllegalArgumentException("cannot mix indexed and positional parameters".toString());
                                }
                                addArgument(format, charAt, args[i3]);
                                this.formatParts.add("%" + charAt);
                                i3 = i;
                                i2 = i7;
                                z3 = z;
                            }
                        }
                    }
                }
            }
        }

        private final void addArgument(String format, char c, Object arg) {
            if (c == 'N') {
                this.args.add(UtilKt.escapeIfNecessary$default(argToName(arg), false, 1, null));
                return;
            }
            if (c == 'L') {
                this.args.add(argToLiteral(arg));
                return;
            }
            if (c == 'S') {
                this.args.add(argToString(arg));
                return;
            }
            if (c == 'P') {
                List<Object> list = this.args;
                if (!(arg instanceof CodeBlock)) {
                    arg = argToString(arg);
                }
                list.add(arg);
                return;
            }
            if (c == 'T') {
                this.args.add(argToType(arg));
            } else {
                if (c == 'M') {
                    this.args.add(arg);
                    return;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format2 = String.format("invalid format string: '%s'", Arrays.copyOf(new Object[]{format}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                throw new IllegalArgumentException(format2);
            }
        }

        private final String argToName(Object o) {
            if (o instanceof CharSequence) {
                return o.toString();
            }
            if (o instanceof ParameterSpec) {
                return ((ParameterSpec) o).getName();
            }
            if (o instanceof PropertySpec) {
                return ((PropertySpec) o).getName();
            }
            if (o instanceof FunSpec) {
                return ((FunSpec) o).getName();
            }
            if (o instanceof TypeSpec) {
                String name = ((TypeSpec) o).getName();
                Intrinsics.checkNotNull(name);
                return name;
            }
            if (o instanceof MemberName) {
                return ((MemberName) o).getSimpleName();
            }
            throw new IllegalArgumentException("expected name but was " + o);
        }

        private final String argToString(Object o) {
            if (o != null) {
                return o.toString();
            }
            return null;
        }

        private final void logDeprecationWarning(Object o) {
            System.out.println((Object) ("Deprecation warning: converting " + o + " to TypeName. Conversion of TypeMirror and TypeElement is deprecated in KotlinPoet, use kotlin-metadata APIs instead."));
        }

        private final TypeName argToType(Object o) {
            if (o instanceof TypeName) {
                return (TypeName) o;
            }
            if (o instanceof TypeMirror) {
                logDeprecationWarning(o);
                return TypeNames.get((TypeMirror) o);
            }
            if (o instanceof Element) {
                logDeprecationWarning(o);
                TypeMirror asType = ((Element) o).asType();
                Intrinsics.checkNotNullExpressionValue(asType, "o.asType()");
                return TypeNames.get(asType);
            }
            if (o instanceof Type) {
                return TypeNames.get((Type) o);
            }
            if (o instanceof KClass) {
                return TypeNames.get((KClass<?>) o);
            }
            throw new IllegalArgumentException("expected type but was " + o);
        }

        public final Builder beginControlFlow(String controlFlow, Object... args) {
            Intrinsics.checkNotNullParameter(controlFlow, "controlFlow");
            Intrinsics.checkNotNullParameter(args, "args");
            add(withOpeningBrace(controlFlow), Arrays.copyOf(args, args.length));
            indent();
            return this;
        }

        private final String withOpeningBrace(String str) {
            int length = str.length();
            do {
                length--;
                if (-1 >= length) {
                    break;
                }
                if (str.charAt(length) == '{') {
                    return str + '\n';
                }
            } while (str.charAt(length) != '}');
            return str + "·{\n";
        }

        public final Builder nextControlFlow(String controlFlow, Object... args) {
            Intrinsics.checkNotNullParameter(controlFlow, "controlFlow");
            Intrinsics.checkNotNullParameter(args, "args");
            unindent();
            add("}·" + controlFlow + "·{\n", Arrays.copyOf(args, args.length));
            indent();
            return this;
        }

        public final Builder endControlFlow() {
            unindent();
            add("}\n", new Object[0]);
            return this;
        }

        public final Builder addStatement(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            add("«", new Object[0]);
            add(format, Arrays.copyOf(args, args.length));
            add("\n»", new Object[0]);
            return this;
        }

        public final Builder add(CodeBlock codeBlock) {
            Intrinsics.checkNotNullParameter(codeBlock, "codeBlock");
            CollectionsKt.addAll(this.formatParts, codeBlock.getFormatParts$kotlinpoet());
            this.args.addAll(codeBlock.getArgs$kotlinpoet());
            return this;
        }

        public final Builder indent() {
            this.formatParts.add("⇥");
            return this;
        }

        public final Builder unindent() {
            this.formatParts.add("⇤");
            return this;
        }

        public final Builder clear() {
            this.formatParts.clear();
            this.args.clear();
            return this;
        }

        public final CodeBlock build() {
            return new CodeBlock(UtilKt.toImmutableList(this.formatParts), UtilKt.toImmutableList(this.args), null);
        }
    }

    /* compiled from: CodeBlock.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0007J-\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u000e2\u0016\u0010\u001e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001f\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u0004*\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0004H\u0000¢\u0006\u0002\b#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\u00020\u0011*\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u00020\u0011*\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u0011*\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014¨\u0006$"}, d2 = {"Lcom/squareup/kotlinpoet/CodeBlock$Companion;", "", "()V", "ARG_NAME", "", g.a, "Lcom/squareup/kotlinpoet/CodeBlock;", "getEMPTY$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock;", "LOWERCASE", "Lkotlin/text/Regex;", "NAMED_ARGUMENT", "NO_ARG_PLACEHOLDERS", "", "", "TYPE_NAME", "isMultiCharNoArgPlaceholder", "", "", "isMultiCharNoArgPlaceholder$kotlinpoet", "(C)Z", "isPlaceholder", "isPlaceholder$kotlinpoet", "(Ljava/lang/String;)Z", "isSingleCharNoArgPlaceholder", "isSingleCharNoArgPlaceholder$kotlinpoet", "builder", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "of", "format", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/CodeBlock;", "nextPotentialPlaceholderPosition", "startIndex", "nextPotentialPlaceholderPosition$kotlinpoet", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isMultiCharNoArgPlaceholder$kotlinpoet(char c) {
            return c == '%';
        }

        private Companion() {
        }

        public final CodeBlock getEMPTY$kotlinpoet() {
            return CodeBlock.EMPTY;
        }

        @JvmStatic
        public final CodeBlock of(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            return new Builder().add(format, Arrays.copyOf(args, args.length)).build();
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }

        public final boolean isSingleCharNoArgPlaceholder$kotlinpoet(char c) {
            boolean isOneOf;
            isOneOf = UtilKt.isOneOf(Character.valueOf(c), (char) 8677, (char) 8676, (r16 & 4) != 0 ? null : (char) 171, (r16 & 8) != 0 ? null : (char) 187, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? null : null);
            return isOneOf;
        }

        public final boolean isPlaceholder$kotlinpoet(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            if (str.length() == 1 && isSingleCharNoArgPlaceholder$kotlinpoet(StringsKt.first(str))) {
                return true;
            }
            return str.length() == 2 && isMultiCharNoArgPlaceholder$kotlinpoet(StringsKt.first(str));
        }

        public final int nextPotentialPlaceholderPosition$kotlinpoet(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return StringsKt.indexOfAny$default((CharSequence) str, new char[]{'%', 171, 187, 8677, 8676}, i, false, 4, (Object) null);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
        try {
            CodeWriter.emitCode$default(codeWriter, this, false, false, 6, null);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(codeWriter, null);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
            return sb2;
        } finally {
        }
    }
}
