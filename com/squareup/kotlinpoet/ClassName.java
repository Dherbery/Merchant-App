package com.squareup.kotlinpoet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* compiled from: ClassName.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001.B+\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0007\"\u00020\u0004¢\u0006\u0002\u0010\bB\u000f\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0007\"\u00020\u0004¢\u0006\u0002\u0010\nB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\u0010\fBI\b\u0000\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b\u0012\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0000H\u0096\u0002J\u0006\u0010!\u001a\u00020\"J6\u0010#\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0016\u0010\u0012\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0016J\u0015\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0010¢\u0006\u0002\b'J\b\u0010(\u001a\u0004\u0018\u00010\u0000J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0004J\u0006\u0010,\u001a\u00020\u0004J\u0006\u0010-\u001a\u00020\u0000R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006/"}, d2 = {"Lcom/squareup/kotlinpoet/ClassName;", "Lcom/squareup/kotlinpoet/TypeName;", "", "packageName", "", "simpleName", "simpleNames", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "(Ljava/lang/String;)V", "(Ljava/lang/String;[Ljava/lang/String;)V", "", "(Ljava/lang/String;Ljava/util/List;)V", "names", "nullable", "", "annotations", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "tags", "", "Lkotlin/reflect/KClass;", "", "(Ljava/util/List;ZLjava/util/List;Ljava/util/Map;)V", "canonicalName", "getCanonicalName", "()Ljava/lang/String;", "getPackageName", "getSimpleName", "getSimpleNames", "()Ljava/util/List;", "compareTo", "", "other", "constructorReference", "Lcom/squareup/kotlinpoet/CodeBlock;", "copy", "emit", "Lcom/squareup/kotlinpoet/CodeWriter;", "out", "emit$kotlinpoet", "enclosingClassName", "nestedClass", "name", "peerClass", "reflectionName", "topLevelClassName", "Companion", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassName extends TypeName implements Comparable<ClassName> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String canonicalName;
    private final List<String> names;

    @JvmStatic
    public static final ClassName bestGuess(String str) {
        return INSTANCE.bestGuess(str);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public /* bridge */ /* synthetic */ TypeName copy(boolean z, List list, Map map) {
        return copy(z, (List<AnnotationSpec>) list, (Map<KClass<?>, ? extends Object>) map);
    }

    public /* synthetic */ ClassName(List list, boolean z, List list2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? false : z, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? MapsKt.emptyMap() : map);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassName(List<String> names, boolean z, List<AnnotationSpec> annotations, Map<KClass<?>, ? extends Object> tags) {
        super(z, annotations, new TagMap(tags), null);
        String joinToString$default;
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.names = UtilKt.toImmutableList(names);
        if (names.get(0).length() == 0) {
            joinToString$default = CollectionsKt.joinToString$default(names.subList(1, names.size()), ".", null, null, 0, null, null, 62, null);
        } else {
            joinToString$default = CollectionsKt.joinToString$default(names, ".", null, null, 0, null, null, 62, null);
        }
        this.canonicalName = joinToString$default;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ClassName(java.lang.String r8, java.lang.String r9, java.lang.String... r10) {
        /*
            r7 = this;
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "simpleName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "simpleNames"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlin.jvm.internal.SpreadBuilder r0 = new kotlin.jvm.internal.SpreadBuilder
            r1 = 3
            r0.<init>(r1)
            r0.add(r8)
            r0.add(r9)
            r0.addSpread(r10)
            int r8 = r0.size()
            java.lang.String[] r8 = new java.lang.String[r8]
            java.lang.Object[] r8 = r0.toArray(r8)
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r8)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 14
            r6 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.kotlinpoet.ClassName.<init>(java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Simple names must not be empty. Did you forget an argument?", replaceWith = @ReplaceWith(expression = "ClassName(packageName, TODO())", imports = {}))
    public ClassName(String packageName) {
        this(packageName, (List<String>) CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(packageName, "packageName");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ClassName(java.lang.String r8, java.lang.String... r9) {
        /*
            r7 = this;
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "simpleNames"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.jvm.internal.SpreadBuilder r0 = new kotlin.jvm.internal.SpreadBuilder
            r1 = 2
            r0.<init>(r1)
            r0.add(r8)
            r0.addSpread(r9)
            int r8 = r0.size()
            java.lang.String[] r8 = new java.lang.String[r8]
            java.lang.Object[] r8 = r0.toArray(r8)
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r8)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 14
            r6 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            int r8 = r9.length
            r0 = 0
            r1 = 1
            if (r8 != 0) goto L35
            r8 = r1
            goto L36
        L35:
            r8 = r0
        L36:
            r8 = r8 ^ r1
            if (r8 == 0) goto L75
            int r8 = r9.length
            r2 = r0
        L3b:
            if (r2 >= r8) goto L50
            r3 = r9[r2]
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L49
            r3 = r1
            goto L4a
        L49:
            r3 = r0
        L4a:
            if (r3 == 0) goto L4d
            goto L51
        L4d:
            int r2 = r2 + 1
            goto L3b
        L50:
            r0 = r1
        L51:
            if (r0 == 0) goto L54
            return
        L54:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "simpleNames must not contain empty items: "
            r8.<init>(r0)
            java.lang.String r9 = java.util.Arrays.toString(r9)
            java.lang.String r0 = "toString(this)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        L75:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "simpleNames must not be empty"
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.kotlinpoet.ClassName.<init>(java.lang.String, java.lang.String[]):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ClassName(java.lang.String r8, java.util.List<java.lang.String> r9) {
        /*
            r7 = this;
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "simpleNames"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String[] r8 = new java.lang.String[]{r8}
            java.util.List r1 = kotlin.collections.CollectionsKt.mutableListOf(r8)
            r8 = r9
            java.util.Collection r8 = (java.util.Collection) r8
            r1.addAll(r8)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 14
            r6 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            boolean r8 = r8.isEmpty()
            r0 = 1
            r8 = r8 ^ r0
            if (r8 == 0) goto L75
            r8 = r9
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            boolean r1 = r8 instanceof java.util.Collection
            if (r1 == 0) goto L3b
            r1 = r8
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L3b
            goto L5a
        L3b:
            java.util.Iterator r8 = r8.iterator()
        L3f:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L5a
            java.lang.Object r1 = r8.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            r2 = 0
            if (r1 != 0) goto L56
            r1 = r0
            goto L57
        L56:
            r1 = r2
        L57:
            if (r1 == 0) goto L3f
            r0 = r2
        L5a:
            if (r0 == 0) goto L5d
            return
        L5d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "simpleNames must not contain empty items: "
            r8.<init>(r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        L75:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "simpleNames must not be empty"
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.kotlinpoet.ClassName.<init>(java.lang.String, java.util.List):void");
    }

    public final String getCanonicalName() {
        return this.canonicalName;
    }

    public final String getPackageName() {
        return this.names.get(0);
    }

    public final String getSimpleName() {
        return this.names.get(r0.size() - 1);
    }

    public final List<String> getSimpleNames() {
        List<String> list = this.names;
        return list.subList(1, list.size());
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public ClassName copy(boolean nullable, List<AnnotationSpec> annotations, Map<KClass<?>, ? extends Object> tags) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new ClassName(this.names, nullable, annotations, tags);
    }

    public final ClassName enclosingClassName() {
        if (this.names.size() == 2) {
            return null;
        }
        return new ClassName(this.names.subList(0, r1.size() - 1), false, null, null, 14, null);
    }

    public final ClassName topLevelClassName() {
        return new ClassName(this.names.subList(0, 2), false, null, null, 14, null);
    }

    public final String reflectionName() {
        if (this.names.size() == 2) {
            if (getPackageName().length() == 0) {
                return this.names.get(1);
            }
            return getPackageName() + '.' + this.names.get(1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(topLevelClassName().canonicalName);
        for (String str : getSimpleNames().subList(1, getSimpleNames().size())) {
            sb.append('$');
            sb.append(str);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final CodeBlock constructorReference() {
        ClassName enclosingClassName = enclosingClassName();
        return enclosingClassName != null ? CodeBlock.INSTANCE.of("%T::%N", enclosingClassName, getSimpleName()) : CodeBlock.INSTANCE.of("::%T", this);
    }

    public final ClassName nestedClass(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ClassName(CollectionsKt.plus((Collection<? extends String>) this.names, name), false, null, null, 14, null);
    }

    public final ClassName peerClass(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List mutableList = CollectionsKt.toMutableList((Collection) this.names);
        mutableList.set(mutableList.size() - 1, name);
        return new ClassName(mutableList, false, null, null, 14, null);
    }

    @Override // java.lang.Comparable
    public int compareTo(ClassName other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.canonicalName.compareTo(other.canonicalName);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public CodeWriter emit$kotlinpoet(CodeWriter out) {
        Intrinsics.checkNotNullParameter(out, "out");
        return CodeWriter.emit$default(out, UtilKt.escapeSegmentsIfNecessary$default(out.lookupName(this), (char) 0, 1, null), false, 2, null);
    }

    /* compiled from: ClassName.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/squareup/kotlinpoet/ClassName$Companion;", "", "()V", "bestGuess", "Lcom/squareup/kotlinpoet/ClassName;", "classNameString", "", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ClassName bestGuess(String classNameString) {
            boolean z;
            String str;
            Intrinsics.checkNotNullParameter(classNameString, "classNameString");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            do {
                z = true;
                if (i < classNameString.length() && Character.isLowerCase(classNameString.codePointAt(i))) {
                    i = StringsKt.indexOf$default((CharSequence) classNameString, '.', i, false, 4, (Object) null) + 1;
                    if (i == 0) {
                        z = false;
                    }
                } else {
                    ArrayList arrayList2 = arrayList;
                    if (i != 0) {
                        str = classNameString.substring(0, i - 1);
                        Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
                    } else {
                        str = "";
                    }
                    arrayList2.add(str);
                    String substring = classNameString.substring(i);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    for (String str2 : StringsKt.split$default((CharSequence) substring, new char[]{'.'}, false, 0, 6, (Object) null)) {
                        if (!((str2.length() > 0) && Character.isUpperCase(str2.codePointAt(0)))) {
                            throw new IllegalArgumentException(("couldn't make a guess for " + classNameString).toString());
                        }
                        arrayList2.add(str2);
                    }
                    if (!(arrayList.size() >= 2)) {
                        throw new IllegalArgumentException(("couldn't make a guess for " + classNameString).toString());
                    }
                    return new ClassName(arrayList, false, null, null, 14, null);
                }
            } while (z);
            throw new IllegalArgumentException(("couldn't make a guess for " + classNameString).toString());
        }
    }
}
