package com.squareup.kotlinpoet;

import com.amazon.a.a.o.b;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.squareup.kotlinpoet.ParameterizedTypeName;
import com.squareup.kotlinpoet.TypeName;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.TypeVisitor;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.SimpleTypeVisitor7;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: TypeName.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 22\u00020\u0001:\u00012B%\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J<\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0004\u0012\u00020\u00190\u0017H&J\u0015\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH ¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001fH\u0000¢\u0006\u0002\b$J\u0015\u0010%\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001fH\u0000¢\u0006\u0002\b&J\u0013\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010)\u001a\u00020*H\u0016J(\u0010+\u001a\u0004\u0018\u0001H,\"\b\b\u0000\u0010,*\u00020\u00192\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.H\u0096\u0001¢\u0006\u0002\u0010/J(\u0010+\u001a\u0004\u0018\u0001H,\"\b\b\u0000\u0010,*\u00020\u00192\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0\u0018H\u0096\u0001¢\u0006\u0002\u00100J\b\u00101\u001a\u00020\rH\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0004\u0012\u00020\u00190\u00178VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0001\u0006345678¨\u00069"}, d2 = {"Lcom/squareup/kotlinpoet/TypeName;", "Lcom/squareup/kotlinpoet/Taggable;", "isNullable", "", "annotations", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "tagMap", "Lcom/squareup/kotlinpoet/TagMap;", "(ZLjava/util/List;Lcom/squareup/kotlinpoet/TagMap;)V", "getAnnotations", "()Ljava/util/List;", "cachedString", "", "getCachedString", "()Ljava/lang/String;", "cachedString$delegate", "Lkotlin/Lazy;", "isAnnotated", "()Z", "getTagMap$kotlinpoet", "()Lcom/squareup/kotlinpoet/TagMap;", "tags", "", "Lkotlin/reflect/KClass;", "", "getTags", "()Ljava/util/Map;", "copy", "nullable", "emit", "Lcom/squareup/kotlinpoet/CodeWriter;", "out", "emit$kotlinpoet", "emitAnnotations", "", "emitAnnotations$kotlinpoet", "emitNullable", "emitNullable$kotlinpoet", "equals", "other", "hashCode", "", "tag", "T", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", "Companion", "Lcom/squareup/kotlinpoet/ClassName;", "Lcom/squareup/kotlinpoet/Dynamic;", "Lcom/squareup/kotlinpoet/LambdaTypeName;", "Lcom/squareup/kotlinpoet/ParameterizedTypeName;", "Lcom/squareup/kotlinpoet/TypeVariableName;", "Lcom/squareup/kotlinpoet/WildcardTypeName;", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public abstract class TypeName implements Taggable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<AnnotationSpec> annotations;

    /* renamed from: cachedString$delegate, reason: from kotlin metadata */
    private final Lazy cachedString;
    private final boolean isNullable;
    private final TagMap tagMap;

    public /* synthetic */ TypeName(boolean z, List list, TagMap tagMap, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, list, tagMap);
    }

    public abstract TypeName copy(boolean nullable, List<AnnotationSpec> annotations, Map<KClass<?>, ? extends Object> tags);

    public abstract CodeWriter emit$kotlinpoet(CodeWriter out);

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

    private TypeName(boolean z, List<AnnotationSpec> list, TagMap tagMap) {
        this.isNullable = z;
        this.tagMap = tagMap;
        this.annotations = UtilKt.toImmutableList(list);
        this.cachedString = LazyKt.lazy(new Function0<String>() { // from class: com.squareup.kotlinpoet.TypeName$cachedString$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                TypeName typeName = TypeName.this;
                StringBuilder sb = new StringBuilder();
                CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
                try {
                    CodeWriter codeWriter2 = codeWriter;
                    typeName.emitAnnotations$kotlinpoet(codeWriter2);
                    typeName.emit$kotlinpoet(codeWriter2);
                    if (typeName.getIsNullable()) {
                        CodeWriter.emit$default(codeWriter2, "?", false, 2, null);
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(codeWriter, null);
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
                    return sb2;
                } finally {
                }
            }
        });
    }

    /* renamed from: isNullable, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    /* renamed from: getTagMap$kotlinpoet, reason: from getter */
    public final TagMap getTagMap() {
        return this.tagMap;
    }

    public final List<AnnotationSpec> getAnnotations() {
        return this.annotations;
    }

    private final String getCachedString() {
        return (String) this.cachedString.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TypeName copy$default(TypeName typeName, boolean z, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i & 1) != 0) {
            z = typeName.isNullable;
        }
        if ((i & 2) != 0) {
            list = CollectionsKt.toList(typeName.annotations);
        }
        return typeName.copy(z, list);
    }

    public final TypeName copy(boolean nullable, List<AnnotationSpec> annotations) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        return copy(nullable, annotations, getTags());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TypeName copy$default(TypeName typeName, boolean z, List list, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i & 1) != 0) {
            z = typeName.isNullable;
        }
        if ((i & 2) != 0) {
            list = CollectionsKt.toList(typeName.annotations);
        }
        if ((i & 4) != 0) {
            map = typeName.getTags();
        }
        return typeName.copy(z, list, map);
    }

    public final boolean isAnnotated() {
        return !this.annotations.isEmpty();
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
        return getCachedString();
    }

    public final void emitAnnotations$kotlinpoet(CodeWriter out) {
        Intrinsics.checkNotNullParameter(out, "out");
        Iterator<AnnotationSpec> it = this.annotations.iterator();
        while (it.hasNext()) {
            AnnotationSpec.emit$kotlinpoet$default(it.next(), out, true, false, 4, null);
            CodeWriter.emit$default(out, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, false, 2, null);
        }
    }

    public final void emitNullable$kotlinpoet(CodeWriter out) {
        Intrinsics.checkNotNullParameter(out, "out");
        if (this.isNullable) {
            CodeWriter.emit$default(out, "?", false, 2, null);
        }
    }

    /* compiled from: TypeName.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0002\b\nJ)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000eH\u0000¢\u0006\u0002\b\n¨\u0006\u0010"}, d2 = {"Lcom/squareup/kotlinpoet/TypeName$Companion;", "", "()V", b.ar, "Lcom/squareup/kotlinpoet/TypeName;", "type", "Ljava/lang/reflect/Type;", "map", "", "Lcom/squareup/kotlinpoet/TypeVariableName;", "get$kotlinpoet", "mirror", "Ljavax/lang/model/type/TypeMirror;", "typeVariables", "", "Ljavax/lang/model/element/TypeParameterElement;", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TypeName get$kotlinpoet(TypeMirror mirror, final Map<TypeParameterElement, TypeVariableName> typeVariables) {
            Intrinsics.checkNotNullParameter(mirror, "mirror");
            Intrinsics.checkNotNullParameter(typeVariables, "typeVariables");
            Object accept = mirror.accept(new SimpleTypeVisitor7<TypeName, Void>() { // from class: com.squareup.kotlinpoet.TypeName$Companion$get$1

                /* compiled from: TypeName.kt */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes5.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[TypeKind.values().length];
                        iArr[TypeKind.BOOLEAN.ordinal()] = 1;
                        iArr[TypeKind.BYTE.ordinal()] = 2;
                        iArr[TypeKind.SHORT.ordinal()] = 3;
                        iArr[TypeKind.INT.ordinal()] = 4;
                        iArr[TypeKind.LONG.ordinal()] = 5;
                        iArr[TypeKind.CHAR.ordinal()] = 6;
                        iArr[TypeKind.FLOAT.ordinal()] = 7;
                        iArr[TypeKind.DOUBLE.ordinal()] = 8;
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                public TypeName visitPrimitive(PrimitiveType t, Void p) {
                    Intrinsics.checkNotNullParameter(t, "t");
                    TypeKind kind = t.getKind();
                    switch (kind == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
                        case 1:
                            return TypeNames.BOOLEAN;
                        case 2:
                            return TypeNames.BYTE;
                        case 3:
                            return TypeNames.SHORT;
                        case 4:
                            return TypeNames.INT;
                        case 5:
                            return TypeNames.LONG;
                        case 6:
                            return TypeNames.CHAR;
                        case 7:
                            return TypeNames.FLOAT;
                        case 8:
                            return TypeNames.DOUBLE;
                        default:
                            throw new AssertionError();
                    }
                }

                public TypeName visitDeclared(DeclaredType t, Void p) {
                    Intrinsics.checkNotNullParameter(t, "t");
                    TypeElement asElement = t.asElement();
                    Intrinsics.checkNotNull(asElement, "null cannot be cast to non-null type javax.lang.model.element.TypeElement");
                    ClassName className = ClassNames.get(asElement);
                    TypeMirror enclosingType = t.getEnclosingType();
                    TypeName typeName = null;
                    if (enclosingType.getKind() != TypeKind.NONE && !t.asElement().getModifiers().contains(Modifier.STATIC)) {
                        typeName = (TypeName) enclosingType.accept((TypeVisitor) this, (Object) null);
                    }
                    if (t.getTypeArguments().isEmpty() && !(typeName instanceof ParameterizedTypeName)) {
                        return className;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (TypeMirror typeArgument : t.getTypeArguments()) {
                        TypeName.Companion companion = TypeName.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(typeArgument, "typeArgument");
                        arrayList.add(companion.get$kotlinpoet(typeArgument, typeVariables));
                    }
                    if (typeName instanceof ParameterizedTypeName) {
                        return ((ParameterizedTypeName) typeName).nestedClass(className.getSimpleName(), arrayList);
                    }
                    return new ParameterizedTypeName(null, className, arrayList, false, null, null, 56, null);
                }

                public TypeName visitError(ErrorType t, Void p) {
                    Intrinsics.checkNotNullParameter(t, "t");
                    return visitDeclared((DeclaredType) t, p);
                }

                public ParameterizedTypeName visitArray(ArrayType t, Void p) {
                    Intrinsics.checkNotNullParameter(t, "t");
                    ParameterizedTypeName.Companion companion = ParameterizedTypeName.Companion;
                    ClassName className = TypeNames.ARRAY;
                    TypeName.Companion companion2 = TypeName.INSTANCE;
                    TypeMirror componentType = t.getComponentType();
                    Intrinsics.checkNotNullExpressionValue(componentType, "t.componentType");
                    return companion.get(className, companion2.get$kotlinpoet(componentType, typeVariables));
                }

                public TypeName visitTypeVariable(TypeVariable t, Void p) {
                    Intrinsics.checkNotNullParameter(t, "t");
                    return TypeVariableName.Companion.get$kotlinpoet(t, MapsKt.toMutableMap(typeVariables));
                }

                public TypeName visitWildcard(WildcardType t, Void p) {
                    Intrinsics.checkNotNullParameter(t, "t");
                    return WildcardTypeName.Companion.get$kotlinpoet(t, typeVariables);
                }

                public TypeName visitNoType(NoType t, Void p) {
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (t.getKind() == TypeKind.VOID) {
                        return TypeNames.UNIT;
                    }
                    Object visitUnknown = super.visitUnknown((TypeMirror) t, p);
                    Intrinsics.checkNotNullExpressionValue(visitUnknown, "super.visitUnknown(t, p)");
                    return (TypeName) visitUnknown;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                public TypeName defaultAction(TypeMirror e, Void p) {
                    StringBuilder sb = new StringBuilder("Unexpected type mirror: ");
                    Intrinsics.checkNotNull(e);
                    sb.append(e);
                    throw new IllegalArgumentException(sb.toString());
                }
            }, (Object) null);
            Intrinsics.checkNotNullExpressionValue(accept, "typeVariables: Map<TypeP…  },\n        null\n      )");
            return (TypeName) accept;
        }

        public final TypeName get$kotlinpoet(Type type, Map<Type, TypeVariableName> map) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(map, "map");
            if (type instanceof Class) {
                if (type == Void.TYPE) {
                    return TypeNames.UNIT;
                }
                if (type == Boolean.TYPE) {
                    return TypeNames.BOOLEAN;
                }
                if (type == Byte.TYPE) {
                    return TypeNames.BYTE;
                }
                if (type == Short.TYPE) {
                    return TypeNames.SHORT;
                }
                if (type == Integer.TYPE) {
                    return TypeNames.INT;
                }
                if (type == Long.TYPE) {
                    return TypeNames.LONG;
                }
                if (type == Character.TYPE) {
                    return TypeNames.CHAR;
                }
                if (type == Float.TYPE) {
                    return TypeNames.FLOAT;
                }
                if (type == Double.TYPE) {
                    return TypeNames.DOUBLE;
                }
                Class cls = (Class) type;
                if (!cls.isArray()) {
                    return ClassNames.get((Class<?>) cls);
                }
                ParameterizedTypeName.Companion companion = ParameterizedTypeName.Companion;
                ClassName className = TypeNames.ARRAY;
                Class<?> componentType = cls.getComponentType();
                Intrinsics.checkNotNullExpressionValue(componentType, "type.componentType");
                return companion.get(className, get$kotlinpoet(componentType, map));
            }
            if (type instanceof ParameterizedType) {
                return ParameterizedTypeName.Companion.get$kotlinpoet((ParameterizedType) type, map);
            }
            if (type instanceof java.lang.reflect.WildcardType) {
                return WildcardTypeName.Companion.get$kotlinpoet((java.lang.reflect.WildcardType) type, map);
            }
            if (type instanceof java.lang.reflect.TypeVariable) {
                return TypeVariableName.Companion.get$kotlinpoet((java.lang.reflect.TypeVariable<?>) type, map);
            }
            if (!(type instanceof GenericArrayType)) {
                throw new IllegalArgumentException("unexpected type: " + type);
            }
            ParameterizedTypeName.Companion companion2 = ParameterizedTypeName.Companion;
            ClassName className2 = TypeNames.ARRAY;
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            Intrinsics.checkNotNullExpressionValue(genericComponentType, "type.genericComponentType");
            return companion2.get(className2, get$kotlinpoet(genericComponentType, map));
        }
    }
}
