package com.squareup.kotlinpoet;

import com.amazon.a.a.o.b;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.squareup.kotlinpoet.AnnotationSpec;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.OriginatingElementsHolder;
import com.squareup.kotlinpoet.Taggable;
import com.squareup.kotlinpoet.TypeSpec;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.Types;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.Strictfp;
import kotlin.jvm.Synchronized;
import kotlin.jvm.Throws;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: FunSpec.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 c2\u00020\u00012\u00020\u0002:\u0002bcB#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0002\u0010\bJ\u0016\u0010D\u001a\u00020\u001e2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\u0016\u0010F\u001a\u00020\u001e2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J7\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u00182\f\u0010E\u001a\b\u0012\u0004\u0012\u00020'0&2\b\b\u0002\u0010L\u001a\u00020\u001eH\u0000¢\u0006\u0002\bMJ\u001a\u0010N\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010O\u001a\u00020\u001eH\u0002J\u0013\u0010P\u001a\u00020\u001e2\b\u0010Q\u001a\u0004\u0018\u00010>H\u0096\u0002J\b\u0010R\u001a\u00020SH\u0016J\b\u0010T\u001a\u00020\u000fH\u0002J\u0017\u0010U\u001a\u0004\u0018\u0001002\u0006\u0010*\u001a\u00020\u0018H\u0000¢\u0006\u0002\bVJ\u0016\u0010W\u001a\u00020\u001e2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J(\u0010X\u001a\u0004\u0018\u0001HY\"\b\b\u0000\u0010Y*\u00020>2\f\u0010Z\u001a\b\u0012\u0004\u0012\u0002HY0[H\u0096\u0001¢\u0006\u0002\u0010\\J(\u0010X\u001a\u0004\u0018\u0001HY\"\b\b\u0000\u0010Y*\u00020>2\f\u0010Z\u001a\b\u0012\u0004\u0012\u0002HY0=H\u0096\u0001¢\u0006\u0002\u0010]J\u0012\u0010^\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\u0018H\u0007J\b\u0010_\u001a\u00020\u0018H\u0016J\u000e\u0010`\u001a\u0004\u0018\u00010\u000f*\u00020\u000fH\u0002J\f\u0010a\u001a\u00020\u000f*\u00020\u000fH\u0002R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\rR\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0011\u0010 \u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b \u0010\u001fR\u000e\u0010!\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0011R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0018\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010\rR\u0017\u0010/\u001a\b\u0012\u0004\u0012\u0002000\n¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\rR\u0011\u00102\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0011R\u0013\u00104\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u00107\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0011R\u0013\u00109\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b:\u00106R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010;\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030=\u0012\u0004\u0012\u00020>0<8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\n¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\r¨\u0006d"}, d2 = {"Lcom/squareup/kotlinpoet/FunSpec;", "Lcom/squareup/kotlinpoet/Taggable;", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder;", "builder", "Lcom/squareup/kotlinpoet/FunSpec$Builder;", "tagMap", "Lcom/squareup/kotlinpoet/TagMap;", "delegateOriginatingElementsHolder", "(Lcom/squareup/kotlinpoet/FunSpec$Builder;Lcom/squareup/kotlinpoet/TagMap;Lcom/squareup/kotlinpoet/OriginatingElementsHolder;)V", "annotations", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "getAnnotations", "()Ljava/util/List;", TtmlNode.TAG_BODY, "Lcom/squareup/kotlinpoet/CodeBlock;", "getBody", "()Lcom/squareup/kotlinpoet/CodeBlock;", "contextReceiverTypes", "Lcom/squareup/kotlinpoet/TypeName;", "getContextReceiverTypes$annotations", "()V", "getContextReceiverTypes", "delegateConstructor", "", "getDelegateConstructor", "()Ljava/lang/String;", "delegateConstructorArguments", "getDelegateConstructorArguments", "isAccessor", "", "()Z", "isConstructor", "isEmptySetter", "isExternalGetter", "kdoc", "getKdoc", "modifiers", "", "Lcom/squareup/kotlinpoet/KModifier;", "getModifiers", "()Ljava/util/Set;", "name", "getName", "originatingElements", "Ljavax/lang/model/element/Element;", "getOriginatingElements", "parameters", "Lcom/squareup/kotlinpoet/ParameterSpec;", "getParameters", "receiverKdoc", "getReceiverKdoc", "receiverType", "getReceiverType", "()Lcom/squareup/kotlinpoet/TypeName;", "returnKdoc", "getReturnKdoc", "returnType", "getReturnType", "tags", "", "Lkotlin/reflect/KClass;", "", "getTags", "()Ljava/util/Map;", "typeVariables", "Lcom/squareup/kotlinpoet/TypeVariableName;", "getTypeVariables", "canBodyBeOmitted", "implicitModifiers", "canNotHaveBody", "emit", "", "codeWriter", "Lcom/squareup/kotlinpoet/CodeWriter;", "enclosingName", "includeKdocTags", "emit$kotlinpoet", "emitSignature", "emitUnitReturnType", "equals", "other", "hashCode", "", "kdocWithTags", MediationConfiguration.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, "parameter$kotlinpoet", "shouldOmitBody", "tag", "T", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toBuilder", "toString", "asExpressionBody", "returnsWithoutLinebreak", "Builder", "Companion", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class FunSpec implements Taggable, OriginatingElementsHolder {
    private static final String CONSTRUCTOR = "constructor()";
    public static final String GETTER = "get()";
    public static final String SETTER = "set()";
    private final List<AnnotationSpec> annotations;
    private final CodeBlock body;
    private final List<TypeName> contextReceiverTypes;
    private final String delegateConstructor;
    private final List<CodeBlock> delegateConstructorArguments;
    private final OriginatingElementsHolder delegateOriginatingElementsHolder;
    private final boolean isEmptySetter;
    private final boolean isExternalGetter;
    private final CodeBlock kdoc;
    private final Set<KModifier> modifiers;
    private final String name;
    private final List<ParameterSpec> parameters;
    private final CodeBlock receiverKdoc;
    private final TypeName receiverType;
    private final CodeBlock returnKdoc;
    private final TypeName returnType;
    private final TagMap tagMap;
    private final List<TypeVariableName> typeVariables;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CodeBlock RETURN_EXPRESSION_BODY_PREFIX_SPACE = CodeBlock.INSTANCE.of("return ", new Object[0]);
    private static final CodeBlock RETURN_EXPRESSION_BODY_PREFIX_NBSP = CodeBlock.INSTANCE.of("return·", new Object[0]);
    private static final CodeBlock THROW_EXPRESSION_BODY_PREFIX_SPACE = CodeBlock.INSTANCE.of("throw ", new Object[0]);
    private static final CodeBlock THROW_EXPRESSION_BODY_PREFIX_NBSP = CodeBlock.INSTANCE.of("throw·", new Object[0]);

    @JvmStatic
    public static final Builder builder(String str) {
        return INSTANCE.builder(str);
    }

    @JvmStatic
    public static final Builder constructorBuilder() {
        return INSTANCE.constructorBuilder();
    }

    public static /* synthetic */ void getContextReceiverTypes$annotations() {
    }

    @JvmStatic
    public static final Builder getterBuilder() {
        return INSTANCE.getterBuilder();
    }

    @JvmStatic
    public static final Builder overriding(ExecutableElement executableElement) {
        return INSTANCE.overriding(executableElement);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Element APIs don't give complete information on Kotlin types. Consider using the kotlinpoet-metadata APIs instead.")
    @JvmStatic
    public static final Builder overriding(ExecutableElement executableElement, DeclaredType declaredType, Types types) {
        return INSTANCE.overriding(executableElement, declaredType, types);
    }

    @JvmStatic
    public static final Builder setterBuilder() {
        return INSTANCE.setterBuilder();
    }

    @Override // com.squareup.kotlinpoet.OriginatingElementsHolder
    public List<Element> getOriginatingElements() {
        return this.delegateOriginatingElementsHolder.getOriginatingElements();
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
        return toBuilder$default(this, null, 1, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0177, code lost:
    
        if (r12 != false) goto L146;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private FunSpec(com.squareup.kotlinpoet.FunSpec.Builder r12, com.squareup.kotlinpoet.TagMap r13, com.squareup.kotlinpoet.OriginatingElementsHolder r14) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.kotlinpoet.FunSpec.<init>(com.squareup.kotlinpoet.FunSpec$Builder, com.squareup.kotlinpoet.TagMap, com.squareup.kotlinpoet.OriginatingElementsHolder):void");
    }

    /* synthetic */ FunSpec(Builder builder, TagMap tagMap, OriginatingElements originatingElements, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, (i & 2) != 0 ? TaggableKt.buildTagMap(builder) : tagMap, (i & 4) != 0 ? OriginatingElementsHolderKt.buildOriginatingElements(builder) : originatingElements);
    }

    public final String getName() {
        return this.name;
    }

    public final CodeBlock getKdoc() {
        return this.kdoc;
    }

    public final CodeBlock getReturnKdoc() {
        return this.returnKdoc;
    }

    public final CodeBlock getReceiverKdoc() {
        return this.receiverKdoc;
    }

    public final List<AnnotationSpec> getAnnotations() {
        return this.annotations;
    }

    public final Set<KModifier> getModifiers() {
        return this.modifiers;
    }

    public final List<TypeVariableName> getTypeVariables() {
        return this.typeVariables;
    }

    public final TypeName getReceiverType() {
        return this.receiverType;
    }

    public final List<TypeName> getContextReceiverTypes() {
        return this.contextReceiverTypes;
    }

    public final TypeName getReturnType() {
        return this.returnType;
    }

    public final List<ParameterSpec> getParameters() {
        return this.parameters;
    }

    public final String getDelegateConstructor() {
        return this.delegateConstructor;
    }

    public final List<CodeBlock> getDelegateConstructorArguments() {
        return this.delegateConstructorArguments;
    }

    public final CodeBlock getBody() {
        return this.body;
    }

    public final ParameterSpec parameter$kotlinpoet(String name) {
        Object obj;
        Intrinsics.checkNotNullParameter(name, "name");
        Iterator<T> it = this.parameters.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ParameterSpec) obj).getName(), name)) {
                break;
            }
        }
        return (ParameterSpec) obj;
    }

    public static /* synthetic */ void emit$kotlinpoet$default(FunSpec funSpec, CodeWriter codeWriter, String str, Set set, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        funSpec.emit$kotlinpoet(codeWriter, str, set, z);
    }

    public final void emit$kotlinpoet(CodeWriter codeWriter, String enclosingName, Set<? extends KModifier> implicitModifiers, boolean includeKdocTags) {
        Intrinsics.checkNotNullParameter(codeWriter, "codeWriter");
        Intrinsics.checkNotNullParameter(implicitModifiers, "implicitModifiers");
        if (includeKdocTags) {
            codeWriter.emitKdoc(kdocWithTags());
        } else {
            codeWriter.emitKdoc(UtilKt.ensureEndsWithNewLine(this.kdoc));
        }
        codeWriter.emitContextReceivers(this.contextReceiverTypes, "\n");
        codeWriter.emitAnnotations(this.annotations, false);
        codeWriter.emitModifiers(this.modifiers, implicitModifiers);
        if (!isConstructor() && !INSTANCE.isAccessor$kotlinpoet(this.name)) {
            codeWriter.emitCode("fun·");
        }
        if (!this.typeVariables.isEmpty()) {
            codeWriter.emitTypeVariables(this.typeVariables);
            CodeWriter.emit$default(codeWriter, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, false, 2, null);
        }
        emitSignature(codeWriter, enclosingName);
        codeWriter.emitWhereBlock(this.typeVariables);
        if (shouldOmitBody(implicitModifiers)) {
            CodeWriter.emit$default(codeWriter, "\n", false, 2, null);
            return;
        }
        CodeBlock asExpressionBody = asExpressionBody(this.body);
        if (asExpressionBody != null) {
            CodeWriter.emitCode$default(codeWriter, CodeBlock.INSTANCE.of(" = %L", asExpressionBody), false, true, 2, null);
            return;
        }
        if (!this.isEmptySetter) {
            codeWriter.emitCode("·{\n");
            CodeWriter.indent$default(codeWriter, 0, 1, null);
            CodeWriter.emitCode$default(codeWriter, returnsWithoutLinebreak(this.body), false, true, 2, null);
            CodeWriter.unindent$default(codeWriter, 0, 1, null);
            CodeWriter.emit$default(codeWriter, "}\n", false, 2, null);
            return;
        }
        CodeWriter.emit$default(codeWriter, "\n", false, 2, null);
    }

    private final boolean shouldOmitBody(Set<? extends KModifier> implicitModifiers) {
        if (!canNotHaveBody(implicitModifiers)) {
            return canBodyBeOmitted(implicitModifiers) && this.body.isEmpty();
        }
        if (this.body.isEmpty()) {
            return true;
        }
        throw new IllegalStateException(("function " + this.name + " cannot have code").toString());
    }

    private final boolean canNotHaveBody(Set<? extends KModifier> implicitModifiers) {
        return this.modifiers.contains(KModifier.ABSTRACT) || SetsKt.plus((Set) this.modifiers, (Iterable) implicitModifiers).contains(KModifier.EXPECT);
    }

    private final boolean canBodyBeOmitted(Set<? extends KModifier> implicitModifiers) {
        return isConstructor() || SetsKt.plus((Set) this.modifiers, (Iterable) implicitModifiers).contains(KModifier.EXTERNAL) || this.modifiers.contains(KModifier.ABSTRACT);
    }

    private final void emitSignature(final CodeWriter codeWriter, String enclosingName) {
        if (isConstructor()) {
            codeWriter.emitCode("constructor", enclosingName);
        } else if (Intrinsics.areEqual(this.name, GETTER)) {
            codeWriter.emitCode(b.ar);
        } else if (Intrinsics.areEqual(this.name, SETTER)) {
            codeWriter.emitCode("set");
        } else {
            TypeName typeName = this.receiverType;
            if (typeName != null) {
                if (typeName instanceof LambdaTypeName) {
                    codeWriter.emitCode("(%T).", typeName);
                } else {
                    codeWriter.emitCode("%T.", typeName);
                }
            }
            codeWriter.emitCode("%N", this);
        }
        if (!this.isEmptySetter && !this.isExternalGetter) {
            ParameterSpecKt.emit$default(this.parameters, codeWriter, false, new Function1<ParameterSpec, Unit>() { // from class: com.squareup.kotlinpoet.FunSpec$emitSignature$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ParameterSpec parameterSpec) {
                    invoke2(parameterSpec);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ParameterSpec param) {
                    Intrinsics.checkNotNullParameter(param, "param");
                    ParameterSpec.emit$kotlinpoet$default(param, CodeWriter.this, !Intrinsics.areEqual(this.getName(), FunSpec.SETTER), false, false, 12, null);
                }
            }, 2, null);
        }
        TypeName typeName2 = this.returnType;
        if (typeName2 != null) {
            codeWriter.emitCode(": %T", typeName2);
        } else if (emitUnitReturnType()) {
            codeWriter.emitCode(": %T", TypeNames.UNIT);
        }
        if (this.delegateConstructor != null) {
            CodeWriter.emitCode$default(codeWriter, CodeBlocks.joinToCode$default(this.delegateConstructorArguments, null, " : " + this.delegateConstructor + '(', ")", 1, null), false, false, 6, null);
        }
    }

    public final boolean isConstructor() {
        return INSTANCE.isConstructor$kotlinpoet(this.name);
    }

    public final boolean isAccessor() {
        return INSTANCE.isAccessor$kotlinpoet(this.name);
    }

    private final CodeBlock kdocWithTags() {
        boolean z;
        CodeBlock.Builder builder = UtilKt.ensureEndsWithNewLine(this.kdoc).toBuilder();
        boolean isNotEmpty = builder.isNotEmpty();
        if (this.receiverKdoc.isNotEmpty()) {
            if (isNotEmpty) {
                builder.add("\n", new Object[0]);
                z = true;
            } else {
                z = false;
            }
            builder.add("@receiver %L", UtilKt.ensureEndsWithNewLine(this.receiverKdoc));
        } else {
            z = false;
        }
        int i = 0;
        for (Object obj : this.parameters) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ParameterSpec parameterSpec = (ParameterSpec) obj;
            if (parameterSpec.getKdoc().isNotEmpty()) {
                if (!z && i == 0 && isNotEmpty) {
                    builder.add("\n", new Object[0]);
                    z = true;
                }
                builder.add("@param %L %L", parameterSpec.getName(), UtilKt.ensureEndsWithNewLine(parameterSpec.getKdoc()));
            }
            i = i2;
        }
        if (this.returnKdoc.isNotEmpty()) {
            if (!z && isNotEmpty) {
                builder.add("\n", new Object[0]);
            }
            builder.add("@return %L", UtilKt.ensureEndsWithNewLine(this.returnKdoc));
        }
        return builder.build();
    }

    private final boolean emitUnitReturnType() {
        return (isConstructor() || Intrinsics.areEqual(this.name, GETTER) || Intrinsics.areEqual(this.name, SETTER) || asExpressionBody(this.body) != null) ? false : true;
    }

    private final CodeBlock asExpressionBody(CodeBlock codeBlock) {
        CodeBlock trim$kotlinpoet = codeBlock.trim$kotlinpoet();
        CodeBlock withoutPrefix$kotlinpoet = trim$kotlinpoet.withoutPrefix$kotlinpoet(RETURN_EXPRESSION_BODY_PREFIX_SPACE);
        if (withoutPrefix$kotlinpoet == null) {
            withoutPrefix$kotlinpoet = trim$kotlinpoet.withoutPrefix$kotlinpoet(RETURN_EXPRESSION_BODY_PREFIX_NBSP);
        }
        if (withoutPrefix$kotlinpoet != null) {
            return withoutPrefix$kotlinpoet;
        }
        if (trim$kotlinpoet.withoutPrefix$kotlinpoet(THROW_EXPRESSION_BODY_PREFIX_SPACE) == null && trim$kotlinpoet.withoutPrefix$kotlinpoet(THROW_EXPRESSION_BODY_PREFIX_NBSP) == null) {
            return null;
        }
        return trim$kotlinpoet;
    }

    private final CodeBlock returnsWithoutLinebreak(CodeBlock codeBlock) {
        CodeBlock build;
        String str = RETURN_EXPRESSION_BODY_PREFIX_SPACE.getFormatParts$kotlinpoet().get(0);
        String str2 = RETURN_EXPRESSION_BODY_PREFIX_NBSP.getFormatParts$kotlinpoet().get(0);
        int i = 0;
        CodeBlock.Builder builder = null;
        for (String str3 : codeBlock.getFormatParts$kotlinpoet()) {
            int i2 = i + 1;
            if (StringsKt.startsWith$default(str3, str, false, 2, (Object) null)) {
                if (builder == null) {
                    builder = codeBlock.toBuilder();
                }
                CodeBlock.Builder builder2 = builder;
                builder2.getFormatParts$kotlinpoet().set(i, StringsKt.replaceFirst$default(str3, str, str2, false, 4, (Object) null));
                i = i2;
                builder = builder2;
            } else {
                i = i2;
            }
        }
        return (builder == null || (build = builder.build()) == null) ? codeBlock : build;
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

    public static /* synthetic */ Builder toBuilder$default(FunSpec funSpec, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = funSpec.name;
        }
        return funSpec.toBuilder(str);
    }

    public final Builder toBuilder(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Builder builder = new Builder(name);
        builder.getKdoc().add(this.kdoc);
        builder.setReturnKdoc$kotlinpoet(this.returnKdoc);
        builder.setReceiverKdoc$kotlinpoet(this.receiverKdoc);
        CollectionsKt.addAll(builder.getAnnotations(), this.annotations);
        CollectionsKt.addAll(builder.getModifiers(), this.modifiers);
        CollectionsKt.addAll(builder.getTypeVariables(), this.typeVariables);
        builder.setReturnType$kotlinpoet(this.returnType);
        CollectionsKt.addAll(builder.getParameters(), this.parameters);
        builder.setDelegateConstructor$kotlinpoet(this.delegateConstructor);
        builder.setDelegateConstructorArguments$kotlinpoet(CollectionsKt.plus((Collection) builder.getDelegateConstructorArguments$kotlinpoet(), (Iterable) this.delegateConstructorArguments));
        builder.getBody().add(this.body);
        builder.setReceiverType$kotlinpoet(this.receiverType);
        builder.getTags().putAll(this.tagMap.getTags());
        CollectionsKt.addAll(builder.getOriginatingElements(), getOriginatingElements());
        return builder;
    }

    /* compiled from: FunSpec.kt */
    @Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\bJ\u000e\u0010A\u001a\u00020\u00002\u0006\u0010C\u001a\u00020DJ\u0012\u0010A\u001a\u00020\u00002\n\u0010C\u001a\u0006\u0012\u0002\b\u00030EJ\u0012\u0010A\u001a\u00020\u00002\n\u0010C\u001a\u0006\u0012\u0002\b\u00030:J\u0014\u0010F\u001a\u00020\u00002\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\b0HJ\u000e\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0018J+\u0010I\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\u00042\u0016\u0010L\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010;0M\"\u0004\u0018\u00010;¢\u0006\u0002\u0010NJ'\u0010O\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\u00042\u0012\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020;0M\"\u00020;¢\u0006\u0002\u0010NJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0018J'\u0010P\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\u00042\u0012\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020;0M\"\u00020;¢\u0006\u0002\u0010NJ\u001f\u0010R\u001a\u00020\u00002\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0M\"\u00020\u001f¢\u0006\u0002\u0010SJ\u0014\u0010R\u001a\u00020\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0HJ \u0010T\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\u00042\u0010\u0010L\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030UJ\u000e\u0010V\u001a\u00020\u00002\u0006\u0010W\u001a\u00020&J/\u0010V\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u00102\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0M\"\u00020\u001f¢\u0006\u0002\u0010YJ$\u0010V\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0HJ/\u0010V\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010X\u001a\u00020Z2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0M\"\u00020\u001f¢\u0006\u0002\u0010[J$\u0010V\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010X\u001a\u00020Z2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0HJ3\u0010V\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\n\u0010X\u001a\u0006\u0012\u0002\b\u00030:2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0M\"\u00020\u001f¢\u0006\u0002\u0010\\J(\u0010V\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\n\u0010X\u001a\u0006\u0012\u0002\b\u00030:2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0HJ\u0014\u0010]\u001a\u00020\u00002\f\u0010^\u001a\b\u0012\u0004\u0012\u00020&0HJ'\u0010_\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\u00042\u0012\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020;0M\"\u00020;¢\u0006\u0002\u0010NJ\u000e\u0010`\u001a\u00020\u00002\u0006\u0010a\u001a\u00020?J\u0014\u0010b\u001a\u00020\u00002\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0HJ'\u0010c\u001a\u00020\u00002\u0006\u0010d\u001a\u00020\u00042\u0012\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020;0M\"\u00020;¢\u0006\u0002\u0010NJ\u0006\u0010e\u001a\u00020fJ\u001e\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020\u00042\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J!\u0010j\u001a\u00020\u00002\u0014\b\u0002\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180M\"\u00020\u0018¢\u0006\u0002\u0010kJ\u001f\u0010j\u001a\u00020\u00002\u0012\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040M\"\u00020\u0004¢\u0006\u0002\u0010lJ\u0014\u0010j\u001a\u00020\u00002\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00180HJ\u0014\u0010j\u001a\u00020\u00002\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J!\u0010m\u001a\u00020\u00002\u0014\b\u0002\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180M\"\u00020\u0018¢\u0006\u0002\u0010kJ\u001f\u0010m\u001a\u00020\u00002\u0012\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040M\"\u00020\u0004¢\u0006\u0002\u0010lJ\u0014\u0010m\u001a\u00020\u00002\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00180HJ\u0014\u0010m\u001a\u00020\u00002\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u0006\u0010n\u001a\u00020\u0000J!\u0010o\u001a\u00020\u00002\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100M\"\u00020\u0010H\u0007¢\u0006\u0002\u0010pJ\u0016\u0010o\u001a\u00020\u00002\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00100HH\u0007J\u0006\u0010r\u001a\u00020\u0000J\u0014\u0010s\u001a\u00020h2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020t0HJ'\u0010u\u001a\u00020\u00002\u0006\u0010d\u001a\u00020\u00042\u0012\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020;0M\"\u00020;¢\u0006\u0002\u0010NJ\u001a\u0010v\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u0018H\u0007J\u001a\u0010v\u001a\u00020\u00002\u0006\u0010-\u001a\u00020Z2\b\b\u0002\u0010\u001c\u001a\u00020\u0018H\u0007J/\u0010v\u001a\u00020\u00002\u0006\u0010-\u001a\u00020Z2\u0006\u0010\u001c\u001a\u00020\u00042\u0012\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020;0M\"\u00020;¢\u0006\u0002\u0010wJ\u001e\u0010v\u001a\u00020\u00002\n\u0010-\u001a\u0006\u0012\u0002\b\u00030:2\b\b\u0002\u0010\u001c\u001a\u00020\u0018H\u0007J3\u0010v\u001a\u00020\u00002\n\u0010-\u001a\u0006\u0012\u0002\b\u00030:2\u0006\u0010\u001c\u001a\u00020\u00042\u0012\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020;0M\"\u00020;¢\u0006\u0002\u0010xJ\u001a\u0010y\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u0018H\u0007J\u001a\u0010y\u001a\u00020\u00002\u0006\u00105\u001a\u00020Z2\b\b\u0002\u0010\u001c\u001a\u00020\u0018H\u0007J/\u0010y\u001a\u00020\u00002\u0006\u00105\u001a\u00020Z2\u0006\u0010\u001c\u001a\u00020\u00042\u0012\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020;0M\"\u00020;¢\u0006\u0002\u0010wJ\u001e\u0010y\u001a\u00020\u00002\n\u00105\u001a\u0006\u0012\u0002\b\u00030:2\b\b\u0002\u0010\u001c\u001a\u00020\u0018H\u0007J3\u0010y\u001a\u00020\u00002\n\u00105\u001a\u0006\u0012\u0002\b\u00030:2\u0006\u0010\u001c\u001a\u00020\u00042\u0012\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020;0M\"\u00020;¢\u0006\u0002\u0010xR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0005R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000eR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\nR\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\nR\u001a\u0010(\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010*\"\u0004\b4\u0010,R\u001c\u00105\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R$\u00108\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030:\u0012\u0004\u0012\u00020;09X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0007¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\n¨\u0006z"}, d2 = {"Lcom/squareup/kotlinpoet/FunSpec$Builder;", "Lcom/squareup/kotlinpoet/Taggable$Builder;", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder$Builder;", "name", "", "(Ljava/lang/String;)V", "annotations", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "getAnnotations", "()Ljava/util/List;", TtmlNode.TAG_BODY, "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "getBody$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "contextReceiverTypes", "Lcom/squareup/kotlinpoet/TypeName;", "getContextReceiverTypes$kotlinpoet", "delegateConstructor", "getDelegateConstructor$kotlinpoet", "()Ljava/lang/String;", "setDelegateConstructor$kotlinpoet", "delegateConstructorArguments", "", "Lcom/squareup/kotlinpoet/CodeBlock;", "getDelegateConstructorArguments$kotlinpoet", "setDelegateConstructorArguments$kotlinpoet", "(Ljava/util/List;)V", "kdoc", "getKdoc$kotlinpoet", "modifiers", "Lcom/squareup/kotlinpoet/KModifier;", "getModifiers", "getName$kotlinpoet", "originatingElements", "Ljavax/lang/model/element/Element;", "getOriginatingElements", "parameters", "Lcom/squareup/kotlinpoet/ParameterSpec;", "getParameters", "receiverKdoc", "getReceiverKdoc$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock;", "setReceiverKdoc$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeBlock;)V", "receiverType", "getReceiverType$kotlinpoet", "()Lcom/squareup/kotlinpoet/TypeName;", "setReceiverType$kotlinpoet", "(Lcom/squareup/kotlinpoet/TypeName;)V", "returnKdoc", "getReturnKdoc$kotlinpoet", "setReturnKdoc$kotlinpoet", "returnType", "getReturnType$kotlinpoet", "setReturnType$kotlinpoet", "tags", "", "Lkotlin/reflect/KClass;", "", "getTags", "()Ljava/util/Map;", "typeVariables", "Lcom/squareup/kotlinpoet/TypeVariableName;", "getTypeVariables", "addAnnotation", "annotationSpec", "annotation", "Lcom/squareup/kotlinpoet/ClassName;", "Ljava/lang/Class;", "addAnnotations", "annotationSpecs", "", "addCode", "codeBlock", "format", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "addComment", "addKdoc", "block", "addModifiers", "([Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "addNamedCode", "", "addParameter", "parameterSpec", "type", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/TypeName;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "addParameters", "parameterSpecs", "addStatement", "addTypeVariable", "typeVariable", "addTypeVariables", "beginControlFlow", "controlFlow", "build", "Lcom/squareup/kotlinpoet/FunSpec;", "callConstructor", "", "constructor", "callSuperConstructor", "([Lcom/squareup/kotlinpoet/CodeBlock;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "([Ljava/lang/String;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "callThisConstructor", "clearBody", "contextReceivers", "([Lcom/squareup/kotlinpoet/TypeName;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "receiverTypes", "endControlFlow", "jvmModifiers", "Ljavax/lang/model/element/Modifier;", "nextControlFlow", "receiver", "(Ljava/lang/reflect/Type;Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "(Lkotlin/reflect/KClass;Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "returns", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder implements Taggable.Builder<Builder>, OriginatingElementsHolder.Builder<Builder> {
        private final List<AnnotationSpec> annotations;
        private final CodeBlock.Builder body;
        private final List<TypeName> contextReceiverTypes;
        private String delegateConstructor;
        private List<CodeBlock> delegateConstructorArguments;
        private final CodeBlock.Builder kdoc;
        private final List<KModifier> modifiers;
        private final String name;
        private final List<Element> originatingElements;
        private final List<ParameterSpec> parameters;
        private CodeBlock receiverKdoc;
        private TypeName receiverType;
        private CodeBlock returnKdoc;
        private TypeName returnType;
        private final Map<KClass<?>, Object> tags;
        private final List<TypeVariableName> typeVariables;

        /* compiled from: FunSpec.kt */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Modifier.values().length];
                iArr[Modifier.PUBLIC.ordinal()] = 1;
                iArr[Modifier.PROTECTED.ordinal()] = 2;
                iArr[Modifier.PRIVATE.ordinal()] = 3;
                iArr[Modifier.ABSTRACT.ordinal()] = 4;
                iArr[Modifier.FINAL.ordinal()] = 5;
                iArr[Modifier.NATIVE.ordinal()] = 6;
                iArr[Modifier.DEFAULT.ordinal()] = 7;
                iArr[Modifier.STATIC.ordinal()] = 8;
                iArr[Modifier.SYNCHRONIZED.ordinal()] = 9;
                iArr[Modifier.STRICTFP.ordinal()] = 10;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final Builder receiver(TypeName receiverType) {
            Intrinsics.checkNotNullParameter(receiverType, "receiverType");
            return receiver$default(this, receiverType, (CodeBlock) null, 2, (Object) null);
        }

        public final Builder receiver(Type receiverType) {
            Intrinsics.checkNotNullParameter(receiverType, "receiverType");
            return receiver$default(this, receiverType, (CodeBlock) null, 2, (Object) null);
        }

        public final Builder receiver(KClass<?> receiverType) {
            Intrinsics.checkNotNullParameter(receiverType, "receiverType");
            return receiver$default(this, receiverType, (CodeBlock) null, 2, (Object) null);
        }

        public final Builder returns(TypeName returnType) {
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            return returns$default(this, returnType, (CodeBlock) null, 2, (Object) null);
        }

        public final Builder returns(Type returnType) {
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            return returns$default(this, returnType, (CodeBlock) null, 2, (Object) null);
        }

        public final Builder returns(KClass<?> returnType) {
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            return returns$default(this, returnType, (CodeBlock) null, 2, (Object) null);
        }

        public Builder(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.kdoc = CodeBlock.INSTANCE.builder();
            this.returnKdoc = CodeBlock.INSTANCE.getEMPTY$kotlinpoet();
            this.receiverKdoc = CodeBlock.INSTANCE.getEMPTY$kotlinpoet();
            this.contextReceiverTypes = new ArrayList();
            this.delegateConstructorArguments = CollectionsKt.emptyList();
            this.body = CodeBlock.INSTANCE.builder();
            this.annotations = new ArrayList();
            this.modifiers = new ArrayList();
            this.typeVariables = new ArrayList();
            this.parameters = new ArrayList();
            this.tags = new LinkedHashMap();
            this.originatingElements = new ArrayList();
        }

        @Override // com.squareup.kotlinpoet.OriginatingElementsHolder.Builder
        public Builder addOriginatingElement(Element element) {
            return (Builder) OriginatingElementsHolder.Builder.DefaultImpls.addOriginatingElement(this, element);
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public Builder tag(Class<?> cls, Object obj) {
            return (Builder) Taggable.Builder.DefaultImpls.tag(this, cls, obj);
        }

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

        /* renamed from: getName$kotlinpoet, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: getKdoc$kotlinpoet, reason: from getter */
        public final CodeBlock.Builder getKdoc() {
            return this.kdoc;
        }

        /* renamed from: getReturnKdoc$kotlinpoet, reason: from getter */
        public final CodeBlock getReturnKdoc() {
            return this.returnKdoc;
        }

        public final void setReturnKdoc$kotlinpoet(CodeBlock codeBlock) {
            Intrinsics.checkNotNullParameter(codeBlock, "<set-?>");
            this.returnKdoc = codeBlock;
        }

        /* renamed from: getReceiverKdoc$kotlinpoet, reason: from getter */
        public final CodeBlock getReceiverKdoc() {
            return this.receiverKdoc;
        }

        public final void setReceiverKdoc$kotlinpoet(CodeBlock codeBlock) {
            Intrinsics.checkNotNullParameter(codeBlock, "<set-?>");
            this.receiverKdoc = codeBlock;
        }

        /* renamed from: getReceiverType$kotlinpoet, reason: from getter */
        public final TypeName getReceiverType() {
            return this.receiverType;
        }

        public final void setReceiverType$kotlinpoet(TypeName typeName) {
            this.receiverType = typeName;
        }

        public final List<TypeName> getContextReceiverTypes$kotlinpoet() {
            return this.contextReceiverTypes;
        }

        /* renamed from: getReturnType$kotlinpoet, reason: from getter */
        public final TypeName getReturnType() {
            return this.returnType;
        }

        public final void setReturnType$kotlinpoet(TypeName typeName) {
            this.returnType = typeName;
        }

        /* renamed from: getDelegateConstructor$kotlinpoet, reason: from getter */
        public final String getDelegateConstructor() {
            return this.delegateConstructor;
        }

        public final void setDelegateConstructor$kotlinpoet(String str) {
            this.delegateConstructor = str;
        }

        public final List<CodeBlock> getDelegateConstructorArguments$kotlinpoet() {
            return this.delegateConstructorArguments;
        }

        public final void setDelegateConstructorArguments$kotlinpoet(List<CodeBlock> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.delegateConstructorArguments = list;
        }

        /* renamed from: getBody$kotlinpoet, reason: from getter */
        public final CodeBlock.Builder getBody() {
            return this.body;
        }

        public final List<AnnotationSpec> getAnnotations() {
            return this.annotations;
        }

        public final List<KModifier> getModifiers() {
            return this.modifiers;
        }

        public final List<TypeVariableName> getTypeVariables() {
            return this.typeVariables;
        }

        public final List<ParameterSpec> getParameters() {
            return this.parameters;
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public Map<KClass<?>, Object> getTags() {
            return this.tags;
        }

        @Override // com.squareup.kotlinpoet.OriginatingElementsHolder.Builder
        public List<Element> getOriginatingElements() {
            return this.originatingElements;
        }

        public final Builder addKdoc(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            this.kdoc.add(format, Arrays.copyOf(args, args.length));
            return this;
        }

        public final Builder addKdoc(CodeBlock block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.kdoc.add(block);
            return this;
        }

        public final Builder addAnnotations(Iterable<AnnotationSpec> annotationSpecs) {
            Intrinsics.checkNotNullParameter(annotationSpecs, "annotationSpecs");
            CollectionsKt.addAll(this.annotations, annotationSpecs);
            return this;
        }

        public final Builder addAnnotation(AnnotationSpec annotationSpec) {
            Intrinsics.checkNotNullParameter(annotationSpec, "annotationSpec");
            this.annotations.add(annotationSpec);
            return this;
        }

        public final Builder addAnnotation(ClassName annotation) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            this.annotations.add(AnnotationSpec.INSTANCE.builder(annotation).build());
            return this;
        }

        public final Builder addAnnotation(Class<?> annotation) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            return addAnnotation(ClassNames.get(annotation));
        }

        public final Builder addAnnotation(KClass<?> annotation) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            return addAnnotation(ClassNames.get(annotation));
        }

        public final Builder addModifiers(KModifier... modifiers) {
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            CollectionsKt.addAll(this.modifiers, modifiers);
            return this;
        }

        public final Builder addModifiers(Iterable<? extends KModifier> modifiers) {
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            CollectionsKt.addAll(this.modifiers, modifiers);
            return this;
        }

        public final void jvmModifiers(Iterable<? extends Modifier> modifiers) {
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            KModifier kModifier = KModifier.INTERNAL;
            for (Modifier modifier : modifiers) {
                switch (WhenMappings.$EnumSwitchMapping$0[modifier.ordinal()]) {
                    case 1:
                        kModifier = KModifier.PUBLIC;
                        break;
                    case 2:
                        kModifier = KModifier.PROTECTED;
                        break;
                    case 3:
                        kModifier = KModifier.PRIVATE;
                        break;
                    case 4:
                        this.modifiers.add(KModifier.ABSTRACT);
                        break;
                    case 5:
                        this.modifiers.add(KModifier.FINAL);
                        break;
                    case 6:
                        this.modifiers.add(KModifier.EXTERNAL);
                        break;
                    case 7:
                        break;
                    case 8:
                        addAnnotation(Reflection.getOrCreateKotlinClass(JvmStatic.class));
                        break;
                    case 9:
                        addAnnotation(Reflection.getOrCreateKotlinClass(Synchronized.class));
                        break;
                    case 10:
                        addAnnotation(Reflection.getOrCreateKotlinClass(Strictfp.class));
                        break;
                    default:
                        throw new IllegalArgumentException("unexpected fun modifier " + modifier);
                }
            }
            this.modifiers.add(kModifier);
        }

        public final Builder addTypeVariables(Iterable<TypeVariableName> typeVariables) {
            Intrinsics.checkNotNullParameter(typeVariables, "typeVariables");
            CollectionsKt.addAll(this.typeVariables, typeVariables);
            return this;
        }

        public final Builder addTypeVariable(TypeVariableName typeVariable) {
            Intrinsics.checkNotNullParameter(typeVariable, "typeVariable");
            this.typeVariables.add(typeVariable);
            return this;
        }

        public final Builder contextReceivers(Iterable<? extends TypeName> receiverTypes) {
            Intrinsics.checkNotNullParameter(receiverTypes, "receiverTypes");
            if (!(!FunSpec.INSTANCE.isConstructor$kotlinpoet(this.name))) {
                throw new IllegalStateException("constructors cannot have context receivers".toString());
            }
            if (!(!FunSpec.INSTANCE.isAccessor$kotlinpoet(this.name))) {
                throw new IllegalStateException((this.name + " cannot have context receivers").toString());
            }
            CollectionsKt.addAll(this.contextReceiverTypes, receiverTypes);
            return this;
        }

        public final Builder contextReceivers(TypeName... receiverType) {
            Intrinsics.checkNotNullParameter(receiverType, "receiverType");
            return contextReceivers(ArraysKt.toList(receiverType));
        }

        public static /* synthetic */ Builder receiver$default(Builder builder, TypeName typeName, CodeBlock codeBlock, int i, Object obj) {
            if ((i & 2) != 0) {
                codeBlock = CodeBlock.INSTANCE.getEMPTY$kotlinpoet();
            }
            return builder.receiver(typeName, codeBlock);
        }

        public final Builder receiver(TypeName receiverType, CodeBlock kdoc) {
            Intrinsics.checkNotNullParameter(receiverType, "receiverType");
            Intrinsics.checkNotNullParameter(kdoc, "kdoc");
            if (!(!FunSpec.INSTANCE.isConstructor$kotlinpoet(this.name))) {
                throw new IllegalStateException((this.name + " cannot have receiver type").toString());
            }
            this.receiverType = receiverType;
            this.receiverKdoc = kdoc;
            return this;
        }

        public static /* synthetic */ Builder receiver$default(Builder builder, Type type, CodeBlock codeBlock, int i, Object obj) {
            if ((i & 2) != 0) {
                codeBlock = CodeBlock.INSTANCE.getEMPTY$kotlinpoet();
            }
            return builder.receiver(type, codeBlock);
        }

        public final Builder receiver(Type receiverType, CodeBlock kdoc) {
            Intrinsics.checkNotNullParameter(receiverType, "receiverType");
            Intrinsics.checkNotNullParameter(kdoc, "kdoc");
            return receiver(TypeNames.get(receiverType), kdoc);
        }

        public final Builder receiver(Type receiverType, String kdoc, Object... args) {
            Intrinsics.checkNotNullParameter(receiverType, "receiverType");
            Intrinsics.checkNotNullParameter(kdoc, "kdoc");
            Intrinsics.checkNotNullParameter(args, "args");
            return receiver(receiverType, CodeBlock.INSTANCE.of(kdoc, args));
        }

        public static /* synthetic */ Builder receiver$default(Builder builder, KClass kClass, CodeBlock codeBlock, int i, Object obj) {
            if ((i & 2) != 0) {
                codeBlock = CodeBlock.INSTANCE.getEMPTY$kotlinpoet();
            }
            return builder.receiver((KClass<?>) kClass, codeBlock);
        }

        public final Builder receiver(KClass<?> receiverType, CodeBlock kdoc) {
            Intrinsics.checkNotNullParameter(receiverType, "receiverType");
            Intrinsics.checkNotNullParameter(kdoc, "kdoc");
            return receiver(TypeNames.get(receiverType), kdoc);
        }

        public final Builder receiver(KClass<?> receiverType, String kdoc, Object... args) {
            Intrinsics.checkNotNullParameter(receiverType, "receiverType");
            Intrinsics.checkNotNullParameter(kdoc, "kdoc");
            Intrinsics.checkNotNullParameter(args, "args");
            return receiver(receiverType, CodeBlock.INSTANCE.of(kdoc, args));
        }

        public static /* synthetic */ Builder returns$default(Builder builder, TypeName typeName, CodeBlock codeBlock, int i, Object obj) {
            if ((i & 2) != 0) {
                codeBlock = CodeBlock.INSTANCE.getEMPTY$kotlinpoet();
            }
            return builder.returns(typeName, codeBlock);
        }

        public final Builder returns(TypeName returnType, CodeBlock kdoc) {
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            Intrinsics.checkNotNullParameter(kdoc, "kdoc");
            if (!((FunSpec.INSTANCE.isConstructor$kotlinpoet(this.name) || FunSpec.INSTANCE.isAccessor$kotlinpoet(this.name)) ? false : true)) {
                throw new IllegalStateException((this.name + " cannot have a return type").toString());
            }
            this.returnType = returnType;
            this.returnKdoc = kdoc;
            return this;
        }

        public static /* synthetic */ Builder returns$default(Builder builder, Type type, CodeBlock codeBlock, int i, Object obj) {
            if ((i & 2) != 0) {
                codeBlock = CodeBlock.INSTANCE.getEMPTY$kotlinpoet();
            }
            return builder.returns(type, codeBlock);
        }

        public final Builder returns(Type returnType, CodeBlock kdoc) {
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            Intrinsics.checkNotNullParameter(kdoc, "kdoc");
            return returns(TypeNames.get(returnType), kdoc);
        }

        public final Builder returns(Type returnType, String kdoc, Object... args) {
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            Intrinsics.checkNotNullParameter(kdoc, "kdoc");
            Intrinsics.checkNotNullParameter(args, "args");
            return returns(TypeNames.get(returnType), CodeBlock.INSTANCE.of(kdoc, args));
        }

        public static /* synthetic */ Builder returns$default(Builder builder, KClass kClass, CodeBlock codeBlock, int i, Object obj) {
            if ((i & 2) != 0) {
                codeBlock = CodeBlock.INSTANCE.getEMPTY$kotlinpoet();
            }
            return builder.returns((KClass<?>) kClass, codeBlock);
        }

        public final Builder returns(KClass<?> returnType, CodeBlock kdoc) {
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            Intrinsics.checkNotNullParameter(kdoc, "kdoc");
            return returns(TypeNames.get(returnType), kdoc);
        }

        public final Builder returns(KClass<?> returnType, String kdoc, Object... args) {
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            Intrinsics.checkNotNullParameter(kdoc, "kdoc");
            Intrinsics.checkNotNullParameter(args, "args");
            return returns(TypeNames.get(returnType), CodeBlock.INSTANCE.of(kdoc, args));
        }

        public final Builder addParameters(Iterable<ParameterSpec> parameterSpecs) {
            Intrinsics.checkNotNullParameter(parameterSpecs, "parameterSpecs");
            Iterator<ParameterSpec> it = parameterSpecs.iterator();
            while (it.hasNext()) {
                addParameter(it.next());
            }
            return this;
        }

        public final Builder addParameter(ParameterSpec parameterSpec) {
            Intrinsics.checkNotNullParameter(parameterSpec, "parameterSpec");
            this.parameters.add(parameterSpec);
            return this;
        }

        public final Builder callThisConstructor(List<CodeBlock> args) {
            Intrinsics.checkNotNullParameter(args, "args");
            callConstructor("this", args);
            return this;
        }

        public final Builder callThisConstructor(Iterable<CodeBlock> args) {
            Intrinsics.checkNotNullParameter(args, "args");
            callConstructor("this", CollectionsKt.toList(args));
            return this;
        }

        public final Builder callThisConstructor(String... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            ArrayList arrayList = new ArrayList(args.length);
            for (String str : args) {
                arrayList.add(CodeBlock.INSTANCE.of(str, new Object[0]));
            }
            callConstructor("this", arrayList);
            return this;
        }

        public final Builder callThisConstructor(CodeBlock... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            callConstructor("this", ArraysKt.toList(args));
            return this;
        }

        public final Builder callSuperConstructor(Iterable<CodeBlock> args) {
            Intrinsics.checkNotNullParameter(args, "args");
            callConstructor("super", CollectionsKt.toList(args));
            return this;
        }

        public final Builder callSuperConstructor(List<CodeBlock> args) {
            Intrinsics.checkNotNullParameter(args, "args");
            callConstructor("super", args);
            return this;
        }

        public final Builder callSuperConstructor(String... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            ArrayList arrayList = new ArrayList(args.length);
            for (String str : args) {
                arrayList.add(CodeBlock.INSTANCE.of(str, new Object[0]));
            }
            callConstructor("super", arrayList);
            return this;
        }

        public final Builder callSuperConstructor(CodeBlock... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            callConstructor("super", ArraysKt.toList(args));
            return this;
        }

        private final void callConstructor(String constructor, List<CodeBlock> args) {
            if (!FunSpec.INSTANCE.isConstructor$kotlinpoet(this.name)) {
                throw new IllegalStateException("only constructors can delegate to other constructors!".toString());
            }
            this.delegateConstructor = constructor;
            this.delegateConstructorArguments = args;
        }

        public final Builder addParameter(String name, TypeName type, KModifier... modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return addParameter(ParameterSpec.INSTANCE.builder(name, type, (KModifier[]) Arrays.copyOf(modifiers, modifiers.length)).build());
        }

        public final Builder addParameter(String name, Type type, KModifier... modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return addParameter(name, TypeNames.get(type), (KModifier[]) Arrays.copyOf(modifiers, modifiers.length));
        }

        public final Builder addParameter(String name, KClass<?> type, KModifier... modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return addParameter(name, TypeNames.get(type), (KModifier[]) Arrays.copyOf(modifiers, modifiers.length));
        }

        public final Builder addParameter(String name, TypeName type, Iterable<? extends KModifier> modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return addParameter(ParameterSpec.INSTANCE.builder(name, type, modifiers).build());
        }

        public final Builder addParameter(String name, Type type, Iterable<? extends KModifier> modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return addParameter(name, TypeNames.get(type), modifiers);
        }

        public final Builder addParameter(String name, KClass<?> type, Iterable<? extends KModifier> modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return addParameter(name, TypeNames.get(type), modifiers);
        }

        public final Builder addCode(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            this.body.add(format, Arrays.copyOf(args, args.length));
            return this;
        }

        public final Builder addNamedCode(String format, Map<String, ?> args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            this.body.addNamed(format, args);
            return this;
        }

        public final Builder addCode(CodeBlock codeBlock) {
            Intrinsics.checkNotNullParameter(codeBlock, "codeBlock");
            this.body.add(codeBlock);
            return this;
        }

        public final Builder addComment(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            this.body.add("//·" + StringsKt.replace$default(format, ' ', Typography.middleDot, false, 4, (Object) null) + '\n', Arrays.copyOf(args, args.length));
            return this;
        }

        public final Builder beginControlFlow(String controlFlow, Object... args) {
            Intrinsics.checkNotNullParameter(controlFlow, "controlFlow");
            Intrinsics.checkNotNullParameter(args, "args");
            this.body.beginControlFlow(controlFlow, Arrays.copyOf(args, args.length));
            return this;
        }

        public final Builder nextControlFlow(String controlFlow, Object... args) {
            Intrinsics.checkNotNullParameter(controlFlow, "controlFlow");
            Intrinsics.checkNotNullParameter(args, "args");
            this.body.nextControlFlow(controlFlow, Arrays.copyOf(args, args.length));
            return this;
        }

        public final Builder endControlFlow() {
            this.body.endControlFlow();
            return this;
        }

        public final Builder addStatement(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            this.body.addStatement(format, Arrays.copyOf(args, args.length));
            return this;
        }

        public final Builder clearBody() {
            this.body.clear();
            return this;
        }

        public final FunSpec build() {
            if (!(this.typeVariables.isEmpty() || !FunSpec.INSTANCE.isAccessor$kotlinpoet(this.name))) {
                throw new IllegalStateException((this.name + " cannot have type variables").toString());
            }
            if (!((Intrinsics.areEqual(this.name, FunSpec.GETTER) && (this.parameters.isEmpty() ^ true)) ? false : true)) {
                throw new IllegalStateException((this.name + " cannot have parameters").toString());
            }
            if (!(!Intrinsics.areEqual(this.name, FunSpec.SETTER) || this.parameters.size() <= 1)) {
                throw new IllegalStateException((this.name + " can have at most one parameter").toString());
            }
            return new FunSpec(this, null, null, 6, null);
        }

        public static /* synthetic */ Builder callThisConstructor$default(Builder builder, CodeBlock[] codeBlockArr, int i, Object obj) {
            if ((i & 1) != 0) {
                codeBlockArr = new CodeBlock[0];
            }
            return builder.callThisConstructor(codeBlockArr);
        }

        public static /* synthetic */ Builder callSuperConstructor$default(Builder builder, CodeBlock[] codeBlockArr, int i, Object obj) {
            if ((i & 1) != 0) {
                codeBlockArr = new CodeBlock[0];
            }
            return builder.callSuperConstructor(codeBlockArr);
        }
    }

    /* compiled from: FunSpec.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\b\u0010\u0015\u001a\u00020\u0013H\u0007J\b\u0010\u0016\u001a\u00020\u0013H\u0007J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J \u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\u00020\r*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\r*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/squareup/kotlinpoet/FunSpec$Companion;", "", "()V", "CONSTRUCTOR", "", "GETTER", "RETURN_EXPRESSION_BODY_PREFIX_NBSP", "Lcom/squareup/kotlinpoet/CodeBlock;", "RETURN_EXPRESSION_BODY_PREFIX_SPACE", "SETTER", "THROW_EXPRESSION_BODY_PREFIX_NBSP", "THROW_EXPRESSION_BODY_PREFIX_SPACE", "isAccessor", "", "isAccessor$kotlinpoet", "(Ljava/lang/String;)Z", "isConstructor", "isConstructor$kotlinpoet", "builder", "Lcom/squareup/kotlinpoet/FunSpec$Builder;", "name", "constructorBuilder", "getterBuilder", "overriding", "method", "Ljavax/lang/model/element/ExecutableElement;", "enclosing", "Ljavax/lang/model/type/DeclaredType;", "types", "Ljavax/lang/model/util/Types;", "setterBuilder", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isConstructor$kotlinpoet(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return Intrinsics.areEqual(str, FunSpec.CONSTRUCTOR);
        }

        public final boolean isAccessor$kotlinpoet(String str) {
            boolean isOneOf;
            Intrinsics.checkNotNullParameter(str, "<this>");
            isOneOf = UtilKt.isOneOf(str, FunSpec.GETTER, FunSpec.SETTER, (r16 & 4) != 0 ? null : null, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? null : null);
            return isOneOf;
        }

        @JvmStatic
        public final Builder builder(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Builder(name);
        }

        @JvmStatic
        public final Builder constructorBuilder() {
            return new Builder(FunSpec.CONSTRUCTOR);
        }

        @JvmStatic
        public final Builder getterBuilder() {
            return new Builder(FunSpec.GETTER);
        }

        @JvmStatic
        public final Builder setterBuilder() {
            return new Builder(FunSpec.SETTER);
        }

        @JvmStatic
        public final Builder overriding(ExecutableElement method) {
            Intrinsics.checkNotNullParameter(method, "method");
            Set modifiers = method.getModifiers();
            Intrinsics.checkNotNullExpressionValue(modifiers, "method.modifiers");
            if (!((modifiers.contains(Modifier.PRIVATE) || modifiers.contains(Modifier.FINAL) || modifiers.contains(Modifier.STATIC)) ? false : true)) {
                throw new IllegalArgumentException(("cannot override method with modifiers: " + modifiers).toString());
            }
            Builder builder = builder(method.getSimpleName().toString());
            builder.addModifiers(KModifier.OVERRIDE);
            Set mutableSet = CollectionsKt.toMutableSet(modifiers);
            mutableSet.remove(Modifier.ABSTRACT);
            builder.jvmModifiers(mutableSet);
            List typeParameters = method.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "method.typeParameters");
            List list = typeParameters;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                TypeVariable asType = ((TypeParameterElement) it.next()).asType();
                Intrinsics.checkNotNull(asType, "null cannot be cast to non-null type javax.lang.model.type.TypeVariable");
                arrayList.add(asType);
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(TypeVariableNames.get((TypeVariable) it2.next()));
            }
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                builder.addTypeVariable((TypeVariableName) it3.next());
            }
            TypeMirror returnType = method.getReturnType();
            Intrinsics.checkNotNullExpressionValue(returnType, "method.returnType");
            Builder.returns$default(builder, TypeNames.get(returnType), (CodeBlock) null, 2, (Object) null);
            builder.addParameters(ParameterSpec.INSTANCE.parametersOf(method));
            if (method.isVarArgs()) {
                builder.getParameters().set(CollectionsKt.getLastIndex(builder.getParameters()), ParameterSpec.toBuilder$default((ParameterSpec) CollectionsKt.last((List) builder.getParameters()), null, null, 3, null).addModifiers(KModifier.VARARG).build());
            }
            Intrinsics.checkNotNullExpressionValue(method.getThrownTypes(), "method.thrownTypes");
            if (!r0.isEmpty()) {
                List thrownTypes = method.getThrownTypes();
                Intrinsics.checkNotNullExpressionValue(thrownTypes, "method.thrownTypes");
                String joinToString$default = CollectionsKt.joinToString$default(thrownTypes, null, null, null, 0, null, new Function1<TypeMirror, CharSequence>() { // from class: com.squareup.kotlinpoet.FunSpec$Companion$overriding$throwsValueString$1
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(TypeMirror typeMirror) {
                        return "%T::class";
                    }
                }, 31, null);
                AnnotationSpec.Builder builder2 = AnnotationSpec.INSTANCE.builder(Reflection.getOrCreateKotlinClass(Throws.class));
                List thrownTypes2 = method.getThrownTypes();
                Intrinsics.checkNotNullExpressionValue(thrownTypes2, "method.thrownTypes");
                Object[] array = thrownTypes2.toArray(new TypeMirror[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                TypeMirror[] typeMirrorArr = (TypeMirror[]) array;
                builder.addAnnotation(builder2.addMember(joinToString$default, Arrays.copyOf(typeMirrorArr, typeMirrorArr.length)).build());
            }
            return builder;
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Element APIs don't give complete information on Kotlin types. Consider using the kotlinpoet-metadata APIs instead.")
        @JvmStatic
        public final Builder overriding(ExecutableElement method, DeclaredType enclosing, Types types) {
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(enclosing, "enclosing");
            Intrinsics.checkNotNullParameter(types, "types");
            ExecutableType asMemberOf = types.asMemberOf(enclosing, (Element) method);
            Intrinsics.checkNotNull(asMemberOf, "null cannot be cast to non-null type javax.lang.model.type.ExecutableType");
            ExecutableType executableType = asMemberOf;
            List parameterTypes = executableType.getParameterTypes();
            TypeMirror resolvedReturnType = executableType.getReturnType();
            Builder overriding = overriding(method);
            Intrinsics.checkNotNullExpressionValue(resolvedReturnType, "resolvedReturnType");
            Builder.returns$default(overriding, TypeNames.get(resolvedReturnType), (CodeBlock) null, 2, (Object) null);
            int size = overriding.getParameters().size();
            for (int i = 0; i < size; i++) {
                ParameterSpec parameterSpec = overriding.getParameters().get(i);
                Object obj = parameterTypes.get(i);
                Intrinsics.checkNotNullExpressionValue(obj, "resolvedParameterTypes[i]");
                overriding.getParameters().set(i, parameterSpec.toBuilder(parameterSpec.getName(), TypeNames.get((TypeMirror) obj)).build());
            }
            return overriding;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
        try {
            emit$kotlinpoet(codeWriter, "Constructor", TypeSpec.Kind.implicitFunctionModifiers$kotlinpoet$default(TypeSpec.Kind.CLASS, null, 1, null), true);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(codeWriter, null);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
            return sb2;
        } finally {
        }
    }
}
