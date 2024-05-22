package com.squareup.kotlinpoet;

import com.amazon.a.a.o.b;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: LambdaTypeName.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B{\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0001\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\u0010\u0011JD\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\b\b\u0002\u0010\u001c\u001a\u00020\t2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00100\u000eJ6\u0010\u001b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0016J\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0010¢\u0006\u0002\b R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006\""}, d2 = {"Lcom/squareup/kotlinpoet/LambdaTypeName;", "Lcom/squareup/kotlinpoet/TypeName;", "receiver", "contextReceivers", "", "parameters", "Lcom/squareup/kotlinpoet/ParameterSpec;", "returnType", "nullable", "", "isSuspending", "annotations", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "tags", "", "Lkotlin/reflect/KClass;", "", "(Lcom/squareup/kotlinpoet/TypeName;Ljava/util/List;Ljava/util/List;Lcom/squareup/kotlinpoet/TypeName;ZZLjava/util/List;Ljava/util/Map;)V", "getContextReceivers$annotations", "()V", "getContextReceivers", "()Ljava/util/List;", "()Z", "getParameters", "getReceiver", "()Lcom/squareup/kotlinpoet/TypeName;", "getReturnType", "copy", "suspending", "emit", "Lcom/squareup/kotlinpoet/CodeWriter;", "out", "emit$kotlinpoet", "Companion", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class LambdaTypeName extends TypeName {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<TypeName> contextReceivers;
    private final boolean isSuspending;
    private final List<ParameterSpec> parameters;
    private final TypeName receiver;
    private final TypeName returnType;

    @JvmStatic
    public static final LambdaTypeName get(TypeName typeName, List<ParameterSpec> list, TypeName typeName2) {
        return INSTANCE.get(typeName, list, typeName2);
    }

    @JvmStatic
    public static final LambdaTypeName get(TypeName typeName, List<ParameterSpec> list, TypeName typeName2, List<? extends TypeName> list2) {
        return INSTANCE.get(typeName, list, typeName2, list2);
    }

    @JvmStatic
    public static final LambdaTypeName get(TypeName typeName, ParameterSpec[] parameterSpecArr, TypeName typeName2) {
        return INSTANCE.get(typeName, parameterSpecArr, typeName2);
    }

    @JvmStatic
    public static final LambdaTypeName get(TypeName typeName, TypeName[] typeNameArr, TypeName typeName2) {
        return INSTANCE.get(typeName, typeNameArr, typeName2);
    }

    public static /* synthetic */ void getContextReceivers$annotations() {
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public /* bridge */ /* synthetic */ TypeName copy(boolean z, List list, Map map) {
        return copy(z, (List<AnnotationSpec>) list, (Map<KClass<?>, ? extends Object>) map);
    }

    public final TypeName getReceiver() {
        return this.receiver;
    }

    /* synthetic */ LambdaTypeName(TypeName typeName, List list, List list2, TypeName typeName2, boolean z, boolean z2, List list3, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : typeName, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? TypeNames.UNIT : typeName2, (i & 16) != 0 ? false : z, (i & 32) == 0 ? z2 : false, (i & 64) != 0 ? CollectionsKt.emptyList() : list3, (i & 128) != 0 ? MapsKt.emptyMap() : map);
    }

    public final List<TypeName> getContextReceivers() {
        return this.contextReceivers;
    }

    public final TypeName getReturnType() {
        return this.returnType;
    }

    /* renamed from: isSuspending, reason: from getter */
    public final boolean getIsSuspending() {
        return this.isSuspending;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LambdaTypeName(TypeName typeName, List<? extends TypeName> list, List<ParameterSpec> list2, TypeName typeName2, boolean z, boolean z2, List<AnnotationSpec> list3, Map<KClass<?>, ? extends Object> map) {
        super(z, list3, new TagMap(map), null);
        this.receiver = typeName;
        this.contextReceivers = list;
        this.returnType = typeName2;
        this.isSuspending = z2;
        this.parameters = UtilKt.toImmutableList(list2);
        for (ParameterSpec parameterSpec : list2) {
            if (!parameterSpec.getAnnotations().isEmpty()) {
                throw new IllegalArgumentException("Parameters with annotations are not allowed".toString());
            }
            if (!parameterSpec.getModifiers().isEmpty()) {
                throw new IllegalArgumentException("Parameters with modifiers are not allowed".toString());
            }
            if (!(parameterSpec.getDefaultValue() == null)) {
                throw new IllegalArgumentException("Parameters with default values are not allowed".toString());
            }
        }
    }

    public final List<ParameterSpec> getParameters() {
        return this.parameters;
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public LambdaTypeName copy(boolean nullable, List<AnnotationSpec> annotations, Map<KClass<?>, ? extends Object> tags) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return copy(nullable, annotations, this.isSuspending, tags);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LambdaTypeName copy$default(LambdaTypeName lambdaTypeName, boolean z, List list, boolean z2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z = lambdaTypeName.getIsNullable();
        }
        if ((i & 2) != 0) {
            list = CollectionsKt.toList(lambdaTypeName.getAnnotations());
        }
        if ((i & 4) != 0) {
            z2 = lambdaTypeName.isSuspending;
        }
        if ((i & 8) != 0) {
            map = MapsKt.toMap(lambdaTypeName.getTags());
        }
        return lambdaTypeName.copy(z, list, z2, map);
    }

    public final LambdaTypeName copy(boolean nullable, List<AnnotationSpec> annotations, boolean suspending, Map<KClass<?>, ? extends Object> tags) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new LambdaTypeName(this.receiver, this.contextReceivers, this.parameters, this.returnType, nullable, suspending, annotations, tags);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public CodeWriter emit$kotlinpoet(CodeWriter out) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.emitContextReceivers(this.contextReceivers, "·");
        if (getIsNullable()) {
            CodeWriter.emit$default(out, "(", false, 2, null);
        }
        if (this.isSuspending) {
            CodeWriter.emit$default(out, "suspend·", false, 2, null);
        }
        TypeName typeName = this.receiver;
        if (typeName != null) {
            if (typeName.isAnnotated()) {
                out.emitCode("(%T).", typeName);
            } else {
                out.emitCode("%T.", typeName);
            }
        }
        ParameterSpecKt.emit$default(this.parameters, out, false, null, 6, null);
        Object obj = this.returnType;
        out.emitCode(obj instanceof LambdaTypeName ? "·->·(%T)" : "·->·%T", obj);
        if (getIsNullable()) {
            CodeWriter.emit$default(out, ")", false, 2, null);
        }
        return out;
    }

    /* compiled from: LambdaTypeName.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u000bJ7\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\b\"\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\fJ,\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\n\u001a\u00020\u0006H\u0007J<\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\n\u001a\u00020\u00062\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0007¨\u0006\u000f"}, d2 = {"Lcom/squareup/kotlinpoet/LambdaTypeName$Companion;", "", "()V", b.ar, "Lcom/squareup/kotlinpoet/LambdaTypeName;", "receiver", "Lcom/squareup/kotlinpoet/TypeName;", "parameters", "", "Lcom/squareup/kotlinpoet/ParameterSpec;", "returnType", "(Lcom/squareup/kotlinpoet/TypeName;[Lcom/squareup/kotlinpoet/ParameterSpec;Lcom/squareup/kotlinpoet/TypeName;)Lcom/squareup/kotlinpoet/LambdaTypeName;", "(Lcom/squareup/kotlinpoet/TypeName;[Lcom/squareup/kotlinpoet/TypeName;Lcom/squareup/kotlinpoet/TypeName;)Lcom/squareup/kotlinpoet/LambdaTypeName;", "", "contextReceivers", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LambdaTypeName get$default(Companion companion, TypeName typeName, List list, TypeName typeName2, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                typeName = null;
            }
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            if ((i & 8) != 0) {
                list2 = CollectionsKt.emptyList();
            }
            return companion.get(typeName, list, typeName2, list2);
        }

        @JvmStatic
        public final LambdaTypeName get(TypeName receiver, List<ParameterSpec> parameters, TypeName returnType, List<? extends TypeName> contextReceivers) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            Intrinsics.checkNotNullParameter(contextReceivers, "contextReceivers");
            return new LambdaTypeName(receiver, contextReceivers, parameters, returnType, false, false, null, null, PsExtractor.VIDEO_STREAM_MASK, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LambdaTypeName get$default(Companion companion, TypeName typeName, List list, TypeName typeName2, int i, Object obj) {
            if ((i & 1) != 0) {
                typeName = null;
            }
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            return companion.get(typeName, (List<ParameterSpec>) list, typeName2);
        }

        @JvmStatic
        public final LambdaTypeName get(TypeName receiver, List<ParameterSpec> parameters, TypeName returnType) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            return new LambdaTypeName(receiver, CollectionsKt.emptyList(), parameters, returnType, false, false, null, null, PsExtractor.VIDEO_STREAM_MASK, null);
        }

        @JvmStatic
        public final LambdaTypeName get(TypeName receiver, TypeName[] parameters, TypeName returnType) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            List emptyList = CollectionsKt.emptyList();
            List list = ArraysKt.toList(parameters);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ParameterSpec.INSTANCE.unnamed((TypeName) it.next()));
            }
            return new LambdaTypeName(receiver, emptyList, arrayList, returnType, false, false, null, null, PsExtractor.VIDEO_STREAM_MASK, null);
        }

        @JvmStatic
        public final LambdaTypeName get(TypeName receiver, ParameterSpec[] parameters, TypeName returnType) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            return new LambdaTypeName(receiver, CollectionsKt.emptyList(), ArraysKt.toList(parameters), returnType, false, false, null, null, PsExtractor.VIDEO_STREAM_MASK, null);
        }

        public static /* synthetic */ LambdaTypeName get$default(Companion companion, TypeName typeName, TypeName[] typeNameArr, TypeName typeName2, int i, Object obj) {
            if ((i & 1) != 0) {
                typeName = null;
            }
            if ((i & 2) != 0) {
                typeNameArr = new TypeName[0];
            }
            return companion.get(typeName, typeNameArr, typeName2);
        }

        public static /* synthetic */ LambdaTypeName get$default(Companion companion, TypeName typeName, ParameterSpec[] parameterSpecArr, TypeName typeName2, int i, Object obj) {
            if ((i & 1) != 0) {
                typeName = null;
            }
            if ((i & 2) != 0) {
                parameterSpecArr = new ParameterSpec[0];
            }
            return companion.get(typeName, parameterSpecArr, typeName2);
        }
    }
}
