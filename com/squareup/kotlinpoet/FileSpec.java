package com.squareup.kotlinpoet;

import androidx.webkit.ProxyConfig;
import com.amazon.a.a.o.b;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.squareup.kotlinpoet.AnnotationSpec;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.Taggable;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardLocation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;

/* compiled from: FileSpec.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 H2\u00020\u0001:\u0002GHB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001aH\u0002J\u0013\u00100\u001a\u00020\u001a2\b\u00101\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u00102\u001a\u000203H\u0016J(\u00104\u001a\u0004\u0018\u0001H5\"\b\b\u0000\u00105*\u00020 2\f\u00106\u001a\b\u0012\u0004\u0012\u0002H507H\u0096\u0001¢\u0006\u0002\u00108J(\u00104\u001a\u0004\u0018\u0001H5\"\b\b\u0000\u00105*\u00020 2\f\u00106\u001a\b\u0012\u0004\u0012\u0002H50(H\u0096\u0001¢\u0006\u0002\u00109J\u001c\u0010:\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020\u0014H\u0007J\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u00020\u0014H\u0016J\u000e\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020@J\u000e\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020AJ\u000e\u0010>\u001a\u00020,2\u0006\u0010B\u001a\u00020CJ\u0012\u0010>\u001a\u00020,2\n\u0010D\u001a\u00060Ej\u0002`FR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001bR\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000bR\u0011\u0010\"\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010'\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030(\u0012\u0004\u0012\u00020 0\u001d8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006I"}, d2 = {"Lcom/squareup/kotlinpoet/FileSpec;", "Lcom/squareup/kotlinpoet/Taggable;", "builder", "Lcom/squareup/kotlinpoet/FileSpec$Builder;", "tagMap", "Lcom/squareup/kotlinpoet/TagMap;", "(Lcom/squareup/kotlinpoet/FileSpec$Builder;Lcom/squareup/kotlinpoet/TagMap;)V", "annotations", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "getAnnotations", "()Ljava/util/List;", TtmlNode.TAG_BODY, "Lcom/squareup/kotlinpoet/CodeBlock;", "getBody", "()Lcom/squareup/kotlinpoet/CodeBlock;", "comment", "getComment", "defaultImports", "", "", "getDefaultImports", "()Ljava/util/Set;", "extension", "indent", "isScript", "", "()Z", "memberImports", "", "Lcom/squareup/kotlinpoet/Import;", "members", "", "getMembers", "name", "getName", "()Ljava/lang/String;", "packageName", "getPackageName", "tags", "Lkotlin/reflect/KClass;", "getTags", "()Ljava/util/Map;", "emit", "", "codeWriter", "Lcom/squareup/kotlinpoet/CodeWriter;", "collectingImports", "equals", "other", "hashCode", "", "tag", "T", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toBuilder", "toJavaFileObject", "Ljavax/tools/JavaFileObject;", "toString", "writeTo", "directory", "Ljava/io/File;", "Ljava/nio/file/Path;", "filer", "Ljavax/annotation/processing/Filer;", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "Builder", "Companion", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class FileSpec implements Taggable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<AnnotationSpec> annotations;
    private final CodeBlock body;
    private final CodeBlock comment;
    private final Set<String> defaultImports;
    private final String extension;
    private final String indent;
    private final boolean isScript;
    private final Map<String, Import> memberImports;
    private final List<Object> members;
    private final String name;
    private final String packageName;
    private final TagMap tagMap;

    @JvmStatic
    public static final Builder builder(String str, String str2) {
        return INSTANCE.builder(str, str2);
    }

    @JvmStatic
    public static final FileSpec get(String str, TypeSpec typeSpec) {
        return INSTANCE.get(str, typeSpec);
    }

    @JvmStatic
    public static final Builder scriptBuilder(String str, String str2) {
        return INSTANCE.scriptBuilder(str, str2);
    }

    @Override // com.squareup.kotlinpoet.Taggable
    public Map<KClass<?>, Object> getTags() {
        return this.tagMap.getTags();
    }

    @Override // com.squareup.kotlinpoet.Taggable
    public <T> T tag(Class<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (T) this.tagMap.tag(type);
    }

    @Override // com.squareup.kotlinpoet.Taggable
    public <T> T tag(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (T) this.tagMap.tag(type);
    }

    public final Builder toBuilder() {
        return toBuilder$default(this, null, null, 3, null);
    }

    public final Builder toBuilder(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return toBuilder$default(this, packageName, null, 2, null);
    }

    private FileSpec(Builder builder, TagMap tagMap) {
        this.tagMap = tagMap;
        this.annotations = UtilKt.toImmutableList(builder.getAnnotations());
        this.comment = builder.getComment().build();
        this.packageName = builder.getPackageName();
        this.name = builder.getName();
        this.members = CollectionsKt.toList(builder.getMembers());
        this.defaultImports = CollectionsKt.toSet(builder.getDefaultImports());
        this.body = builder.getBody().build();
        this.isScript = builder.getIsScript();
        TreeSet<Import> memberImports$kotlinpoet = builder.getMemberImports$kotlinpoet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(memberImports$kotlinpoet, 10)), 16));
        for (Object obj : memberImports$kotlinpoet) {
            linkedHashMap.put(((Import) obj).getQualifiedName(), obj);
        }
        this.memberImports = linkedHashMap;
        this.indent = builder.getIndent();
        this.extension = this.isScript ? "kts" : "kt";
    }

    /* synthetic */ FileSpec(Builder builder, TagMap tagMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, (i & 2) != 0 ? TaggableKt.buildTagMap(builder) : tagMap);
    }

    public final List<AnnotationSpec> getAnnotations() {
        return this.annotations;
    }

    public final CodeBlock getComment() {
        return this.comment;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Object> getMembers() {
        return this.members;
    }

    public final Set<String> getDefaultImports() {
        return this.defaultImports;
    }

    public final CodeBlock getBody() {
        return this.body;
    }

    /* renamed from: isScript, reason: from getter */
    public final boolean getIsScript() {
        return this.isScript;
    }

    public final void writeTo(Appendable out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        CodeWriter codeWriter = new CodeWriter(NullAppendable.INSTANCE, this.indent, this.memberImports, null, null, Integer.MAX_VALUE, 24, null);
        emit(codeWriter, true);
        Map<String, ClassName> suggestedTypeImports = codeWriter.suggestedTypeImports();
        Map<String, MemberName> suggestedMemberImports = codeWriter.suggestedMemberImports();
        codeWriter.close();
        CodeWriter codeWriter2 = new CodeWriter(out, this.indent, this.memberImports, suggestedTypeImports, suggestedMemberImports, 0, 32, null);
        emit(codeWriter2, false);
        codeWriter2.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeTo(java.nio.file.Path r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.kotlinpoet.FileSpec.writeTo(java.nio.file.Path):void");
    }

    public final void writeTo(File directory) throws IOException {
        Path path;
        Intrinsics.checkNotNullParameter(directory, "directory");
        path = directory.toPath();
        Intrinsics.checkNotNullExpressionValue(path, "directory.toPath()");
        writeTo(path);
    }

    public final void writeTo(Filer filer) throws IOException {
        Intrinsics.checkNotNullParameter(filer, "filer");
        Sequence filter = SequencesKt.filter(CollectionsKt.asSequence(this.members), new Function1<Object, Boolean>() { // from class: com.squareup.kotlinpoet.FileSpec$writeTo$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(obj instanceof OriginatingElementsHolder);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Set set = SequencesKt.toSet(SequencesKt.flatMap(filter, new Function1<OriginatingElementsHolder, Sequence<? extends Element>>() { // from class: com.squareup.kotlinpoet.FileSpec$writeTo$originatingElements$1
            @Override // kotlin.jvm.functions.Function1
            public final Sequence<Element> invoke(OriginatingElementsHolder it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return CollectionsKt.asSequence(it.getOriginatingElements());
            }
        }));
        JavaFileManager.Location location = StandardLocation.SOURCE_OUTPUT;
        String str = this.packageName;
        String str2 = this.name + '.' + this.extension;
        Object[] array = set.toArray(new Element[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Element[] elementArr = (Element[]) array;
        FileObject createResource = filer.createResource(location, str, str2, (Element[]) Arrays.copyOf(elementArr, elementArr.length));
        try {
            Writer openWriter = createResource.openWriter();
            try {
                Writer writer = openWriter;
                Intrinsics.checkNotNullExpressionValue(writer, "writer");
                writeTo(writer);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(openWriter, null);
            } finally {
            }
        } catch (Exception e) {
            try {
                createResource.delete();
            } catch (Exception unused) {
            }
            throw e;
        }
    }

    private final void emit(CodeWriter codeWriter, boolean collectingImports) {
        if (this.comment.isNotEmpty()) {
            codeWriter.emitComment(this.comment);
        }
        if (!this.annotations.isEmpty()) {
            codeWriter.emitAnnotations(this.annotations, false);
            CodeWriter.emit$default(codeWriter, "\n", false, 2, null);
        }
        codeWriter.pushPackage(this.packageName);
        String escapeSegmentsIfNecessary$default = UtilKt.escapeSegmentsIfNecessary$default(this.packageName, (char) 0, 1, null);
        if (escapeSegmentsIfNecessary$default.length() > 0) {
            codeWriter.emitCode("package·%L\n", escapeSegmentsIfNecessary$default);
            CodeWriter.emit$default(codeWriter, "\n", false, 2, null);
        }
        Collection<ClassName> values = codeWriter.getImportedTypes().values();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(((ClassName) it.next()).getCanonicalName());
        }
        ArrayList arrayList2 = arrayList;
        Collection<MemberName> values2 = codeWriter.getImportedMembers().values();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(values2, 10));
        Iterator<T> it2 = values2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((MemberName) it2.next()).getCanonicalName());
        }
        ArrayList arrayList4 = arrayList3;
        Function1<String, Boolean> function1 = new Function1<String, Boolean>() { // from class: com.squareup.kotlinpoet.FileSpec$emit$isDefaultImport$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String it3) {
                Intrinsics.checkNotNullParameter(it3, "it");
                return false;
            }
        };
        if (!collectingImports && (!this.defaultImports.isEmpty())) {
            Set<String> set = this.defaultImports;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            Iterator<T> it3 = set.iterator();
            while (it3.hasNext()) {
                arrayList5.add(UtilKt.escapeSegmentsIfNecessary$default((String) it3.next(), (char) 0, 1, null));
            }
            final ArrayList arrayList6 = arrayList5;
            function1 = new Function1<String, Boolean>() { // from class: com.squareup.kotlinpoet.FileSpec$emit$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String importName) {
                    Intrinsics.checkNotNullParameter(importName, "importName");
                    return Boolean.valueOf(arrayList6.contains(StringsKt.substringBeforeLast$default(importName, ".", (String) null, 2, (Object) null)));
                }
            };
        }
        Collection<Import> values3 = this.memberImports.values();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        for (Object obj : values3) {
            if (((Import) obj).getAlias() != null) {
                arrayList7.add(obj);
            } else {
                arrayList8.add(obj);
            }
        }
        Pair pair = new Pair(arrayList7, arrayList8);
        List list = (List) pair.component1();
        SortedSet sortedSet = SequencesKt.toSortedSet(SequencesKt.filterNot(SequencesKt.plus(SequencesKt.map(SequencesKt.filterNot(CollectionsKt.asSequence(CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList4)), new Function1<String, Boolean>() { // from class: com.squareup.kotlinpoet.FileSpec$emit$imports$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String it4) {
                Map map;
                Intrinsics.checkNotNullParameter(it4, "it");
                map = FileSpec.this.memberImports;
                return Boolean.valueOf(map.keySet().contains(it4));
            }
        }), new Function1<String, String>() { // from class: com.squareup.kotlinpoet.FileSpec$emit$imports$2
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it4) {
                Intrinsics.checkNotNullParameter(it4, "it");
                return UtilKt.escapeSegmentsIfNecessary$default(it4, (char) 0, 1, null);
            }
        }), SequencesKt.map(CollectionsKt.asSequence((List) pair.component2()), new Function1<Import, String>() { // from class: com.squareup.kotlinpoet.FileSpec$emit$imports$3
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Import it4) {
                Intrinsics.checkNotNullParameter(it4, "it");
                return it4.getImportString();
            }
        })), function1));
        List list2 = list;
        ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it4 = list2.iterator();
        while (it4.hasNext()) {
            arrayList9.add(((Import) it4.next()).getImportString());
        }
        Set plus = SetsKt.plus((Set) sortedSet, (Iterable) CollectionsKt.toSortedSet(arrayList9));
        if (!plus.isEmpty()) {
            Iterator it5 = plus.iterator();
            while (it5.hasNext()) {
                codeWriter.emitCode("import·%L", (String) it5.next());
                CodeWriter.emit$default(codeWriter, "\n", false, 2, null);
            }
            CodeWriter.emit$default(codeWriter, "\n", false, 2, null);
        }
        if (this.isScript) {
            CodeWriter.emitCode$default(codeWriter, this.body, false, false, 6, null);
        } else {
            int i = 0;
            for (Object obj2 : this.members) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (i > 0) {
                    CodeWriter.emit$default(codeWriter, "\n", false, 2, null);
                }
                if (obj2 instanceof TypeSpec) {
                    TypeSpec.emit$kotlinpoet$default((TypeSpec) obj2, codeWriter, null, null, false, 12, null);
                } else if (obj2 instanceof FunSpec) {
                    ((FunSpec) obj2).emit$kotlinpoet(codeWriter, null, SetsKt.setOf(KModifier.PUBLIC), true);
                } else if (obj2 instanceof PropertySpec) {
                    PropertySpec.emit$kotlinpoet$default((PropertySpec) obj2, codeWriter, SetsKt.setOf(KModifier.PUBLIC), false, false, false, false, 60, null);
                } else {
                    if (!(obj2 instanceof TypeAliasSpec)) {
                        throw new AssertionError();
                    }
                    ((TypeAliasSpec) obj2).emit$kotlinpoet(codeWriter);
                }
                i = i2;
            }
        }
        codeWriter.popPackage();
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        writeTo(sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final JavaFileObject toJavaFileObject() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.packageName.length() == 0) {
            str = this.name;
        } else {
            str = StringsKt.replace$default(this.packageName, '.', IOUtils.DIR_SEPARATOR_UNIX, false, 4, (Object) null) + IOUtils.DIR_SEPARATOR_UNIX + this.name;
        }
        sb.append(str);
        sb.append('.');
        sb.append(this.extension);
        final URI create = URI.create(sb.toString());
        final JavaFileObject.Kind kind = JavaFileObject.Kind.SOURCE;
        return new SimpleJavaFileObject(create, kind) { // from class: com.squareup.kotlinpoet.FileSpec$toJavaFileObject$1
            private final long lastModified = System.currentTimeMillis();

            public String getCharContent(boolean ignoreEncodingErrors) {
                return this.toString();
            }

            public InputStream openInputStream() {
                String charContent = getCharContent(true);
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                byte[] bytes = charContent.getBytes(UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                return new ByteArrayInputStream(bytes);
            }

            public long getLastModified() {
                return this.lastModified;
            }
        };
    }

    public static /* synthetic */ Builder toBuilder$default(FileSpec fileSpec, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileSpec.packageName;
        }
        if ((i & 2) != 0) {
            str2 = fileSpec.name;
        }
        return fileSpec.toBuilder(str, str2);
    }

    public final Builder toBuilder(String packageName, String name) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(name, "name");
        Builder builder = new Builder(packageName, name, this.isScript);
        builder.getAnnotations().addAll(this.annotations);
        builder.getComment().add(this.comment);
        builder.getMembers().addAll(this.members);
        builder.setIndent$kotlinpoet(this.indent);
        builder.getMemberImports$kotlinpoet().addAll(this.memberImports.values());
        builder.getDefaultImports().addAll(this.defaultImports);
        builder.getTags().putAll(this.tagMap.getTags());
        builder.getBody().add(this.body);
        return builder;
    }

    /* compiled from: FileSpec.kt */
    @Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0003J\u001e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00103\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0003J\u0016\u0010/\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00102\u001a\u00020\u0003J\u001a\u0010/\u001a\u00020\u00002\n\u00105\u001a\u0006\u0012\u0002\b\u0003062\u0006\u00102\u001a\u00020\u0003J\u001a\u0010/\u001a\u00020\u00002\n\u00105\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u00102\u001a\u00020\u0003J\u000e\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u00020\nJ\u000e\u00107\u001a\u00020\u00002\u0006\u00109\u001a\u000201J\u0012\u00107\u001a\u00020\u00002\n\u00109\u001a\u0006\u0012\u0002\b\u000306J\u0012\u00107\u001a\u00020\u00002\n\u00109\u001a\u0006\u0012\u0002\b\u00030,J'\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u00032\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0=\"\u00020&¢\u0006\u0002\u0010>J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020AJ+\u0010?\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u00032\u0016\u0010<\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010&0=\"\u0004\u0018\u00010&¢\u0006\u0002\u0010>J)\u0010B\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u00032\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0=\"\u00020&H\u0007¢\u0006\u0002\u0010>J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J'\u0010D\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u00032\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0=\"\u00020&¢\u0006\u0002\u0010>J\u000e\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020GJ'\u0010H\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0012\u0010I\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030=\"\u00020\u0003¢\u0006\u0002\u0010JJ\u001c\u0010H\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030KJ\u000e\u0010H\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0019J+\u0010H\u001a\u00020\u00002\n\u00105\u001a\u0006\u0012\u0002\b\u0003062\u0012\u0010I\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030=\"\u00020\u0003¢\u0006\u0002\u0010MJ \u0010H\u001a\u00020\u00002\n\u00105\u001a\u0006\u0012\u0002\b\u0003062\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030KJ\u0012\u0010H\u001a\u00020\u00002\n\u0010N\u001a\u0006\u0012\u0002\b\u00030OJ'\u0010H\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010I\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030=\"\u00020\u0003¢\u0006\u0002\u0010PJ\u001c\u0010H\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030KJ+\u0010H\u001a\u00020\u00002\n\u00105\u001a\u0006\u0012\u0002\b\u00030,2\u0012\u0010I\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030=\"\u00020\u0003¢\u0006\u0002\u0010QJ \u0010H\u001a\u00020\u00002\n\u00105\u001a\u0006\u0012\u0002\b\u00030,2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030KJ\u001a\u0010R\u001a\u00020\u00002\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u0006J \u0010U\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u00032\u0010\u0010<\u001a\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030VJ\u000e\u0010W\u001a\u00020\u00002\u0006\u0010X\u001a\u00020YJ'\u0010Z\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u00032\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0=\"\u00020&¢\u0006\u0002\u0010>J\u000e\u0010[\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020]J\u000e\u0010^\u001a\u00020\u00002\u0006\u0010_\u001a\u00020`J'\u0010a\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u00032\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0=\"\u00020&¢\u0006\u0002\u0010>J\u0006\u0010c\u001a\u00020dJ\u0006\u0010e\u001a\u00020\u0000J\u0006\u0010f\u001a\u00020\u0000J\u0006\u0010g\u001a\u00020\u0000J\u0006\u0010h\u001a\u00020\u0000J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0003J'\u0010i\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u00032\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0=\"\u00020&¢\u0006\u0002\u0010>R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\fR\u001a\u0010\u001b\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010 R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\"X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR$\u0010*\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030,\u0012\u0004\u0012\u00020&0+X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006j"}, d2 = {"Lcom/squareup/kotlinpoet/FileSpec$Builder;", "Lcom/squareup/kotlinpoet/Taggable$Builder;", "packageName", "", "name", "isScript", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "annotations", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "getAnnotations", "()Ljava/util/List;", TtmlNode.TAG_BODY, "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "getBody$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "comment", "getComment$kotlinpoet", "defaultImports", "", "getDefaultImports", "()Ljava/util/Set;", "imports", "", "Lcom/squareup/kotlinpoet/Import;", "getImports", "indent", "getIndent$kotlinpoet", "()Ljava/lang/String;", "setIndent$kotlinpoet", "(Ljava/lang/String;)V", "()Z", "memberImports", "Ljava/util/TreeSet;", "getMemberImports$kotlinpoet", "()Ljava/util/TreeSet;", "members", "", "getMembers", "getName", "getPackageName", "tags", "", "Lkotlin/reflect/KClass;", "getTags", "()Ljava/util/Map;", "addAliasedImport", "className", "Lcom/squareup/kotlinpoet/ClassName;", "as", "memberName", "Lcom/squareup/kotlinpoet/MemberName;", "class", "Ljava/lang/Class;", "addAnnotation", "annotationSpec", "annotation", "addBodyComment", "format", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/FileSpec$Builder;", "addCode", "codeBlock", "Lcom/squareup/kotlinpoet/CodeBlock;", "addComment", "addDefaultPackageImport", "addFileComment", "addFunction", "funSpec", "Lcom/squareup/kotlinpoet/FunSpec;", "addImport", "names", "(Lcom/squareup/kotlinpoet/ClassName;[Ljava/lang/String;)Lcom/squareup/kotlinpoet/FileSpec$Builder;", "", "import", "(Ljava/lang/Class;[Ljava/lang/String;)Lcom/squareup/kotlinpoet/FileSpec$Builder;", "constant", "", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/squareup/kotlinpoet/FileSpec$Builder;", "(Lkotlin/reflect/KClass;[Ljava/lang/String;)Lcom/squareup/kotlinpoet/FileSpec$Builder;", "addKotlinDefaultImports", "includeJvm", "includeJs", "addNamedCode", "", "addProperty", "propertySpec", "Lcom/squareup/kotlinpoet/PropertySpec;", "addStatement", "addType", "typeSpec", "Lcom/squareup/kotlinpoet/TypeSpec;", "addTypeAlias", "typeAliasSpec", "Lcom/squareup/kotlinpoet/TypeAliasSpec;", "beginControlFlow", "controlFlow", "build", "Lcom/squareup/kotlinpoet/FileSpec;", "clearBody", "clearComment", "clearImports", "endControlFlow", "nextControlFlow", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder implements Taggable.Builder<Builder> {
        private final List<AnnotationSpec> annotations;
        private final CodeBlock.Builder body;
        private final CodeBlock.Builder comment;
        private final Set<String> defaultImports;
        private String indent;
        private final boolean isScript;
        private final TreeSet<Import> memberImports;
        private final List<Object> members;
        private final String name;
        private final String packageName;
        private final Map<KClass<?>, Object> tags;

        /* compiled from: FileSpec.kt */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnnotationSpec.UseSiteTarget.values().length];
                iArr[AnnotationSpec.UseSiteTarget.FILE.ordinal()] = 1;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public Builder(String packageName, String name, boolean z) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(name, "name");
            this.packageName = packageName;
            this.name = name;
            this.isScript = z;
            this.comment = CodeBlock.INSTANCE.builder();
            this.memberImports = SetsKt.sortedSetOf(new Import[0]);
            this.indent = FileSpecKt.DEFAULT_INDENT;
            this.tags = new LinkedHashMap();
            this.defaultImports = new LinkedHashSet();
            this.members = new ArrayList();
            this.annotations = new ArrayList();
            this.body = CodeBlock.INSTANCE.builder();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public Builder tag(Class<?> cls, Object obj) {
            return (Builder) Taggable.Builder.DefaultImpls.tag(this, cls, obj);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public Builder tag(KClass<?> kClass, Object obj) {
            return (Builder) Taggable.Builder.DefaultImpls.tag(this, kClass, obj);
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public /* bridge */ /* synthetic */ Builder tag(Class cls, Object obj) {
            return tag((Class<?>) cls, obj);
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public /* bridge */ /* synthetic */ Builder tag(KClass kClass, Object obj) {
            return tag((KClass<?>) kClass, obj);
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final String getName() {
            return this.name;
        }

        /* renamed from: isScript, reason: from getter */
        public final boolean getIsScript() {
            return this.isScript;
        }

        /* renamed from: getComment$kotlinpoet, reason: from getter */
        public final CodeBlock.Builder getComment() {
            return this.comment;
        }

        public final TreeSet<Import> getMemberImports$kotlinpoet() {
            return this.memberImports;
        }

        /* renamed from: getIndent$kotlinpoet, reason: from getter */
        public final String getIndent() {
            return this.indent;
        }

        public final void setIndent$kotlinpoet(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.indent = str;
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public Map<KClass<?>, Object> getTags() {
            return this.tags;
        }

        public final Set<String> getDefaultImports() {
            return this.defaultImports;
        }

        public final List<Import> getImports() {
            return CollectionsKt.toList(this.memberImports);
        }

        public final List<Object> getMembers() {
            return this.members;
        }

        public final List<AnnotationSpec> getAnnotations() {
            return this.annotations;
        }

        /* renamed from: getBody$kotlinpoet, reason: from getter */
        public final CodeBlock.Builder getBody() {
            return this.body;
        }

        public final Builder addAnnotation(AnnotationSpec annotationSpec) {
            Intrinsics.checkNotNullParameter(annotationSpec, "annotationSpec");
            AnnotationSpec.UseSiteTarget useSiteTarget = annotationSpec.getUseSiteTarget();
            int i = useSiteTarget == null ? -1 : WhenMappings.$EnumSwitchMapping$0[useSiteTarget.ordinal()];
            if (i == -1) {
                annotationSpec = annotationSpec.toBuilder().useSiteTarget(AnnotationSpec.UseSiteTarget.FILE).build();
            } else if (i != 1) {
                throw new IllegalStateException(("Use-site target " + annotationSpec.getUseSiteTarget() + " not supported for file annotations.").toString());
            }
            this.annotations.add(annotationSpec);
            return this;
        }

        public final Builder addAnnotation(ClassName annotation) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            return addAnnotation(AnnotationSpec.INSTANCE.builder(annotation).build());
        }

        public final Builder addAnnotation(Class<?> annotation) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            return addAnnotation(ClassNames.get(annotation));
        }

        public final Builder addAnnotation(KClass<?> annotation) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            return addAnnotation(ClassNames.get(annotation));
        }

        public final Builder addFileComment(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            this.comment.add(StringsKt.replace$default(format, ' ', Typography.middleDot, false, 4, (Object) null), Arrays.copyOf(args, args.length));
            return this;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use addFileComment() instead.", replaceWith = @ReplaceWith(expression = "addFileComment(format, args)", imports = {}))
        public final Builder addComment(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            return addFileComment(format, Arrays.copyOf(args, args.length));
        }

        public final Builder clearComment() {
            this.comment.clear();
            return this;
        }

        public final Builder addType(TypeSpec typeSpec) {
            Intrinsics.checkNotNullParameter(typeSpec, "typeSpec");
            if (this.isScript) {
                this.body.add("%L", typeSpec);
            } else {
                this.members.add(typeSpec);
            }
            return this;
        }

        public final Builder addFunction(FunSpec funSpec) {
            Intrinsics.checkNotNullParameter(funSpec, "funSpec");
            if (!((funSpec.isConstructor() || funSpec.isAccessor()) ? false : true)) {
                throw new IllegalArgumentException(("cannot add " + funSpec.getName() + " to file " + this.name).toString());
            }
            if (this.isScript) {
                this.body.add("%L", funSpec);
            } else {
                this.members.add(funSpec);
            }
            return this;
        }

        public final Builder addProperty(PropertySpec propertySpec) {
            Intrinsics.checkNotNullParameter(propertySpec, "propertySpec");
            if (this.isScript) {
                this.body.add("%L", propertySpec);
            } else {
                this.members.add(propertySpec);
            }
            return this;
        }

        public final Builder addTypeAlias(TypeAliasSpec typeAliasSpec) {
            Intrinsics.checkNotNullParameter(typeAliasSpec, "typeAliasSpec");
            if (this.isScript) {
                this.body.add("%L", typeAliasSpec);
            } else {
                this.members.add(typeAliasSpec);
            }
            return this;
        }

        public final Builder addImport(Enum<?> constant) {
            Intrinsics.checkNotNullParameter(constant, "constant");
            Class<?> declaringClass = constant.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "constant as java.lang.Enum<*>).declaringClass");
            return addImport(ClassNames.get(declaringClass), constant.name());
        }

        public final Builder addImport(Class<?> r3, String... names) {
            Intrinsics.checkNotNullParameter(r3, "class");
            Intrinsics.checkNotNullParameter(names, "names");
            if (!(!(names.length == 0))) {
                throw new IllegalArgumentException("names array is empty".toString());
            }
            addImport(ClassNames.get(r3), ArraysKt.toList(names));
            return this;
        }

        public final Builder addImport(KClass<?> r3, String... names) {
            Intrinsics.checkNotNullParameter(r3, "class");
            Intrinsics.checkNotNullParameter(names, "names");
            if (!(!(names.length == 0))) {
                throw new IllegalArgumentException("names array is empty".toString());
            }
            addImport(ClassNames.get(r3), ArraysKt.toList(names));
            return this;
        }

        public final Builder addImport(ClassName className, String... names) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(names, "names");
            if (!(!(names.length == 0))) {
                throw new IllegalArgumentException("names array is empty".toString());
            }
            addImport(className, ArraysKt.toList(names));
            return this;
        }

        public final Builder addImport(Class<?> r2, Iterable<String> names) {
            Intrinsics.checkNotNullParameter(r2, "class");
            Intrinsics.checkNotNullParameter(names, "names");
            return addImport(ClassNames.get(r2), names);
        }

        public final Builder addImport(KClass<?> r2, Iterable<String> names) {
            Intrinsics.checkNotNullParameter(r2, "class");
            Intrinsics.checkNotNullParameter(names, "names");
            return addImport(ClassNames.get(r2), names);
        }

        public final Builder addImport(ClassName className, Iterable<String> names) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(names, "names");
            if (!(!CollectionsKt.contains(names, ProxyConfig.MATCH_ALL_SCHEMES))) {
                throw new IllegalArgumentException("Wildcard imports are not allowed".toString());
            }
            for (String str : names) {
                this.memberImports.add(new Import(className.getCanonicalName() + '.' + str, null, 2, null));
            }
            return this;
        }

        public final Builder addImport(String packageName, String... names) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(names, "names");
            if (!(!(names.length == 0))) {
                throw new IllegalArgumentException("names array is empty".toString());
            }
            addImport(packageName, ArraysKt.toList(names));
            return this;
        }

        public final Builder addImport(String packageName, Iterable<String> names) {
            Import r3;
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(names, "names");
            if (!(!CollectionsKt.contains(names, ProxyConfig.MATCH_ALL_SCHEMES))) {
                throw new IllegalArgumentException("Wildcard imports are not allowed".toString());
            }
            for (String str : names) {
                TreeSet<Import> treeSet = this.memberImports;
                if (packageName.length() > 0) {
                    r3 = new Import(packageName + '.' + str, null, 2, null);
                } else {
                    r3 = new Import(str, null, 2, null);
                }
                treeSet.add(r3);
            }
            return this;
        }

        public final Builder addImport(Import r2) {
            Intrinsics.checkNotNullParameter(r2, "import");
            this.memberImports.add(r2);
            return this;
        }

        public final Builder clearImports() {
            this.memberImports.clear();
            return this;
        }

        public final Builder addAliasedImport(Class<?> r2, String as) {
            Intrinsics.checkNotNullParameter(r2, "class");
            Intrinsics.checkNotNullParameter(as, "as");
            return addAliasedImport(ClassNames.get(r2), as);
        }

        public final Builder addAliasedImport(KClass<?> r2, String as) {
            Intrinsics.checkNotNullParameter(r2, "class");
            Intrinsics.checkNotNullParameter(as, "as");
            return addAliasedImport(ClassNames.get(r2), as);
        }

        public final Builder addAliasedImport(ClassName className, String as) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(as, "as");
            this.memberImports.add(new Import(className.getCanonicalName(), as));
            return this;
        }

        public final Builder addAliasedImport(ClassName className, String memberName, String as) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(memberName, "memberName");
            Intrinsics.checkNotNullParameter(as, "as");
            this.memberImports.add(new Import(className.getCanonicalName() + '.' + memberName, as));
            return this;
        }

        public final Builder addAliasedImport(MemberName memberName, String as) {
            Intrinsics.checkNotNullParameter(memberName, "memberName");
            Intrinsics.checkNotNullParameter(as, "as");
            this.memberImports.add(new Import(memberName.getCanonicalName(), as));
            return this;
        }

        public final Builder addDefaultPackageImport(String packageName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            this.defaultImports.add(packageName);
            return this;
        }

        public static /* synthetic */ Builder addKotlinDefaultImports$default(Builder builder, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            return builder.addKotlinDefaultImports(z, z2);
        }

        public final Builder addKotlinDefaultImports(boolean includeJvm, boolean includeJs) {
            Set set;
            Set set2;
            Set set3;
            Set<String> set4 = this.defaultImports;
            set = FileSpecKt.KOTLIN_DEFAULT_IMPORTS;
            CollectionsKt.addAll(set4, set);
            if (includeJvm) {
                Set<String> set5 = this.defaultImports;
                set3 = FileSpecKt.KOTLIN_DEFAULT_JVM_IMPORTS;
                CollectionsKt.addAll(set5, set3);
            }
            if (includeJs) {
                Set<String> set6 = this.defaultImports;
                set2 = FileSpecKt.KOTLIN_DEFAULT_JS_IMPORTS;
                CollectionsKt.addAll(set6, set2);
            }
            return this;
        }

        public final Builder indent(String indent) {
            Intrinsics.checkNotNullParameter(indent, "indent");
            this.indent = indent;
            return this;
        }

        public final Builder addCode(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            if (!this.isScript) {
                throw new IllegalStateException("addCode() is only allowed in script files".toString());
            }
            this.body.add(format, Arrays.copyOf(args, args.length));
            return this;
        }

        public final Builder addNamedCode(String format, Map<String, ?> args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            if (!this.isScript) {
                throw new IllegalStateException("addNamedCode() is only allowed in script files".toString());
            }
            this.body.addNamed(format, args);
            return this;
        }

        public final Builder addCode(CodeBlock codeBlock) {
            Intrinsics.checkNotNullParameter(codeBlock, "codeBlock");
            if (!this.isScript) {
                throw new IllegalStateException("addCode() is only allowed in script files".toString());
            }
            this.body.add(codeBlock);
            return this;
        }

        public final Builder addBodyComment(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            if (!this.isScript) {
                throw new IllegalStateException("addBodyComment() is only allowed in script files".toString());
            }
            this.body.add("//·" + StringsKt.replace$default(format, ' ', Typography.middleDot, false, 4, (Object) null) + '\n', Arrays.copyOf(args, args.length));
            return this;
        }

        public final Builder beginControlFlow(String controlFlow, Object... args) {
            Intrinsics.checkNotNullParameter(controlFlow, "controlFlow");
            Intrinsics.checkNotNullParameter(args, "args");
            if (!this.isScript) {
                throw new IllegalStateException("beginControlFlow() is only allowed in script files".toString());
            }
            this.body.beginControlFlow(controlFlow, Arrays.copyOf(args, args.length));
            return this;
        }

        public final Builder nextControlFlow(String controlFlow, Object... args) {
            Intrinsics.checkNotNullParameter(controlFlow, "controlFlow");
            Intrinsics.checkNotNullParameter(args, "args");
            if (!this.isScript) {
                throw new IllegalStateException("nextControlFlow() is only allowed in script files".toString());
            }
            this.body.nextControlFlow(controlFlow, Arrays.copyOf(args, args.length));
            return this;
        }

        public final Builder endControlFlow() {
            if (!this.isScript) {
                throw new IllegalStateException("endControlFlow() is only allowed in script files".toString());
            }
            this.body.endControlFlow();
            return this;
        }

        public final Builder addStatement(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            if (!this.isScript) {
                throw new IllegalStateException("addStatement() is only allowed in script files".toString());
            }
            this.body.addStatement(format, Arrays.copyOf(args, args.length));
            return this;
        }

        public final Builder clearBody() {
            if (!this.isScript) {
                throw new IllegalStateException("clearBody() is only allowed in script files".toString());
            }
            this.body.clear();
            return this;
        }

        public final FileSpec build() {
            for (AnnotationSpec annotationSpec : this.annotations) {
                if (annotationSpec.getUseSiteTarget() != AnnotationSpec.UseSiteTarget.FILE) {
                    throw new IllegalStateException(("Use-site target " + annotationSpec.getUseSiteTarget() + " not supported for file annotations.").toString());
                }
            }
            return new FileSpec(this, null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: FileSpec.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Lcom/squareup/kotlinpoet/FileSpec$Companion;", "", "()V", "builder", "Lcom/squareup/kotlinpoet/FileSpec$Builder;", "packageName", "", "fileName", b.ar, "Lcom/squareup/kotlinpoet/FileSpec;", "typeSpec", "Lcom/squareup/kotlinpoet/TypeSpec;", "scriptBuilder", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FileSpec get(String packageName, TypeSpec typeSpec) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(typeSpec, "typeSpec");
            String name = typeSpec.getName();
            if (name == null) {
                throw new IllegalArgumentException("file name required but type has no name");
            }
            return builder(packageName, name).addType(typeSpec).build();
        }

        @JvmStatic
        public final Builder builder(String packageName, String fileName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return new Builder(packageName, fileName, false);
        }

        public static /* synthetic */ Builder scriptBuilder$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "";
            }
            return companion.scriptBuilder(str, str2);
        }

        @JvmStatic
        public final Builder scriptBuilder(String fileName, String packageName) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            return new Builder(packageName, fileName, true);
        }
    }
}
