package com.google.devtools.ksp;

import com.google.devtools.ksp.processing.Resolver;
import com.google.devtools.ksp.symbol.ClassKind;
import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSAnnotation;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSDeclaration;
import com.google.devtools.ksp.symbol.KSFile;
import com.google.devtools.ksp.symbol.KSFunctionDeclaration;
import com.google.devtools.ksp.symbol.KSName;
import com.google.devtools.ksp.symbol.KSNode;
import com.google.devtools.ksp.symbol.KSPropertyDeclaration;
import com.google.devtools.ksp.symbol.KSPropertyGetter;
import com.google.devtools.ksp.symbol.KSPropertySetter;
import com.google.devtools.ksp.symbol.KSType;
import com.google.devtools.ksp.symbol.KSTypeAlias;
import com.google.devtools.ksp.symbol.KSTypeArgument;
import com.google.devtools.ksp.symbol.KSTypeParameter;
import com.google.devtools.ksp.symbol.KSTypeReference;
import com.google.devtools.ksp.symbol.KSValueArgument;
import com.google.devtools.ksp.symbol.Modifier;
import com.google.devtools.ksp.symbol.Origin;
import com.google.devtools.ksp.symbol.Visibility;
import com.google.devtools.ksp.visitor.KSValidateVisitor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: utils.kt */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0003\u001a$\u0010\u0015\u001a\u00020\u0011*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0003\u001a\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0011H\u0002\u001a(\u0010\u001b\u001a\u0012\u0012\u0002\b\u0003 \u001c*\b\u0012\u0002\b\u0003\u0018\u00010\u00140\u0014*\u00020\n2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0003\u001a4\u0010\u001d\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u001c*\b\u0012\u0002\b\u0003\u0018\u00010\u00140\u00140\b*\b\u0012\u0004\u0012\u00020\n0\b2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0003\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020\u0011H\u0002\u001a%\u0010 \u001a\u0002H!\"\u0004\b\u0000\u0010!*\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0\u0014H\u0002¢\u0006\u0002\u0010#\u001a\f\u0010$\u001a\u00020%*\u00020\u0011H\u0002\u001a\f\u0010&\u001a\u00020'*\u00020\u0011H\u0002\u001a\f\u0010(\u001a\u00020)*\u00020\u0011H\u0002\u001a\f\u0010*\u001a\u0004\u0018\u00010+*\u00020,\u001a\u0018\u0010-\u001a\u00020.*\u00020\u00122\n\u0010/\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0003\u001a\n\u00100\u001a\u00020+*\u000201\u001a\u0010\u00102\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020+\u001a*\u00104\u001a\b\u0012\u0004\u0012\u0002H!03\"\b\b\u0000\u0010!*\u000205*\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u0002H!08H\u0007\u001a\u0017\u00109\u001a\u0004\u0018\u00010+\"\u0006\b\u0000\u0010!\u0018\u0001*\u00020:H\u0086\b\u001a\u0014\u00109\u001a\u0004\u0018\u00010+*\u00020:2\u0006\u0010;\u001a\u00020\u0001\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020=03*\u00020+\u001a\u0010\u0010>\u001a\b\u0012\u0004\u0012\u00020=03*\u00020+\u001a\u0010\u0010?\u001a\b\u0012\u0004\u0012\u00020@03*\u00020+\u001a\"\u0010A\u001a\b\u0012\u0004\u0012\u00020=03*\u00020:2\u0006\u0010;\u001a\u00020\u00012\b\b\u0002\u0010B\u001a\u00020C\u001a\u0016\u0010D\u001a\u0004\u0018\u00010+*\u00020:2\u0006\u0010;\u001a\u00020EH\u0007\u001a\u0016\u0010D\u001a\u0004\u0018\u00010+*\u00020:2\u0006\u0010;\u001a\u00020\u0001H\u0007\u001a\u0016\u0010F\u001a\u0004\u0018\u00010+*\u00020:2\u0006\u0010;\u001a\u00020EH\u0007\u001a\u0016\u0010F\u001a\u0004\u0018\u00010+*\u00020:2\u0006\u0010;\u001a\u00020\u0001H\u0007\u001a\u001e\u0010G\u001a\u0004\u0018\u00010@*\u00020:2\u0006\u0010;\u001a\u00020\u00012\b\b\u0002\u0010B\u001a\u00020C\u001a\n\u0010H\u001a\u00020I*\u00020,\u001a\n\u0010J\u001a\u00020C*\u00020+\u001a\n\u0010J\u001a\u00020C*\u00020@\u001a$\u0010K\u001a\u00020C\"\b\b\u0000\u0010!*\u000205*\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u0002H!08H\u0007\u001a\n\u0010L\u001a\u00020C*\u00020=\u001a\n\u0010M\u001a\u00020C*\u00020N\u001a\n\u0010O\u001a\u00020C*\u00020,\u001a\n\u0010P\u001a\u00020C*\u00020,\u001a\n\u0010Q\u001a\u00020C*\u00020,\u001a\n\u0010R\u001a\u00020C*\u00020,\u001a\n\u0010S\u001a\u00020C*\u00020,\u001a\n\u0010T\u001a\u00020C*\u00020,\u001a\n\u0010U\u001a\u00020C*\u00020,\u001a\u0012\u0010V\u001a\u00020C*\u00020,2\u0006\u0010W\u001a\u00020,\u001a)\u0010X\u001a\u0002H!\"\b\b\u0000\u0010!*\u000205*\u00020\u00122\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002H!0\u0014H\u0003¢\u0006\u0002\u0010Z\u001a9\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\\*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110^H\u0002¢\u0006\u0002\u0010_\u001a(\u0010`\u001a\u00020C*\u00020\u00042\u001c\b\u0002\u0010a\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020C0b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0017\u0010\r\u001a\u0004\u0018\u00010\n*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006c"}, d2 = {"ExceptionMessage", "", "containingFile", "Lcom/google/devtools/ksp/symbol/KSFile;", "Lcom/google/devtools/ksp/symbol/KSNode;", "getContainingFile", "(Lcom/google/devtools/ksp/symbol/KSNode;)Lcom/google/devtools/ksp/symbol/KSFile;", "innerArguments", "", "Lcom/google/devtools/ksp/symbol/KSTypeArgument;", "Lcom/google/devtools/ksp/symbol/KSType;", "getInnerArguments", "(Lcom/google/devtools/ksp/symbol/KSType;)Ljava/util/List;", "outerType", "getOuterType", "(Lcom/google/devtools/ksp/symbol/KSType;)Lcom/google/devtools/ksp/symbol/KSType;", "asAnnotation", "", "Lcom/google/devtools/ksp/symbol/KSAnnotation;", "annotationInterface", "Ljava/lang/Class;", "asArray", "method", "Ljava/lang/reflect/Method;", "proxyClass", "asByte", "", "asClass", "kotlin.jvm.PlatformType", "asClasses", "asDouble", "", "asEnum", "T", "returnType", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "asFloat", "", "asLong", "", "asShort", "", "closestClassDeclaration", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "Lcom/google/devtools/ksp/symbol/KSDeclaration;", "createInvocationHandler", "Ljava/lang/reflect/InvocationHandler;", "clazz", "findActualType", "Lcom/google/devtools/ksp/symbol/KSTypeAlias;", "getAllSuperTypes", "Lkotlin/sequences/Sequence;", "getAnnotationsByType", "", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "annotationKClass", "Lkotlin/reflect/KClass;", "getClassDeclarationByName", "Lcom/google/devtools/ksp/processing/Resolver;", "name", "getConstructors", "Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;", "getDeclaredFunctions", "getDeclaredProperties", "Lcom/google/devtools/ksp/symbol/KSPropertyDeclaration;", "getFunctionDeclarationsByName", "includeTopLevel", "", "getJavaClassByName", "Lcom/google/devtools/ksp/symbol/KSName;", "getKotlinClassByName", "getPropertyDeclarationByName", "getVisibility", "Lcom/google/devtools/ksp/symbol/Visibility;", "isAbstract", "isAnnotationPresent", "isConstructor", "isDefault", "Lcom/google/devtools/ksp/symbol/KSValueArgument;", "isInternal", "isJavaPackagePrivate", "isLocal", "isOpen", "isPrivate", "isProtected", "isPublic", "isVisibleFrom", "other", "toAnnotation", "annotationClass", "(Lcom/google/devtools/ksp/symbol/KSAnnotation;Ljava/lang/Class;)Ljava/lang/annotation/Annotation;", "toArray", "", "valueProvider", "Lkotlin/Function1;", "(Ljava/util/List;Ljava/lang/reflect/Method;Lkotlin/jvm/functions/Function1;)[Ljava/lang/Object;", "validate", "predicate", "Lkotlin/Function2;", "api"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UtilsKt {
    public static final String ExceptionMessage = "please file a bug at https://github.com/google/ksp/issues/new";

    public static final /* synthetic */ <T> KSClassDeclaration getClassDeclarationByName(Resolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        String qualifiedName = Reflection.getOrCreateKotlinClass(Object.class).getQualifiedName();
        if (qualifiedName != null) {
            return resolver.getClassDeclarationByName(resolver.getKSNameFromString(qualifiedName));
        }
        return null;
    }

    public static final KSClassDeclaration getClassDeclarationByName(Resolver resolver, String name) {
        Intrinsics.checkNotNullParameter(resolver, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return resolver.getClassDeclarationByName(resolver.getKSNameFromString(name));
    }

    public static /* synthetic */ Sequence getFunctionDeclarationsByName$default(Resolver resolver, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return getFunctionDeclarationsByName(resolver, str, z);
    }

    public static final Sequence<KSFunctionDeclaration> getFunctionDeclarationsByName(Resolver resolver, String name, boolean z) {
        Intrinsics.checkNotNullParameter(resolver, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return resolver.getFunctionDeclarationsByName(resolver.getKSNameFromString(name), z);
    }

    public static /* synthetic */ KSPropertyDeclaration getPropertyDeclarationByName$default(Resolver resolver, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return getPropertyDeclarationByName(resolver, str, z);
    }

    public static final KSPropertyDeclaration getPropertyDeclarationByName(Resolver resolver, String name, boolean z) {
        Intrinsics.checkNotNullParameter(resolver, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return resolver.getPropertyDeclarationByName(resolver.getKSNameFromString(name), z);
    }

    public static final KSFile getContainingFile(KSNode kSNode) {
        Intrinsics.checkNotNullParameter(kSNode, "<this>");
        KSNode parent = kSNode.getParent();
        while (parent != null && !(parent instanceof KSFile)) {
            parent = parent.getParent();
        }
        if (parent instanceof KSFile) {
            return (KSFile) parent;
        }
        return null;
    }

    public static final Sequence<KSFunctionDeclaration> getDeclaredFunctions(KSClassDeclaration kSClassDeclaration) {
        Intrinsics.checkNotNullParameter(kSClassDeclaration, "<this>");
        Sequence<KSFunctionDeclaration> filter = SequencesKt.filter(kSClassDeclaration.getDeclarations(), new Function1<Object, Boolean>() { // from class: com.google.devtools.ksp.UtilsKt$getDeclaredFunctions$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(obj instanceof KSFunctionDeclaration);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        return filter;
    }

    public static final Sequence<KSPropertyDeclaration> getDeclaredProperties(KSClassDeclaration kSClassDeclaration) {
        Intrinsics.checkNotNullParameter(kSClassDeclaration, "<this>");
        Sequence<KSPropertyDeclaration> filter = SequencesKt.filter(kSClassDeclaration.getDeclarations(), new Function1<Object, Boolean>() { // from class: com.google.devtools.ksp.UtilsKt$getDeclaredProperties$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(obj instanceof KSPropertyDeclaration);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        return filter;
    }

    public static final Sequence<KSFunctionDeclaration> getConstructors(KSClassDeclaration kSClassDeclaration) {
        Intrinsics.checkNotNullParameter(kSClassDeclaration, "<this>");
        return SequencesKt.filter(getDeclaredFunctions(kSClassDeclaration), new Function1<KSFunctionDeclaration, Boolean>() { // from class: com.google.devtools.ksp.UtilsKt$getConstructors$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(KSFunctionDeclaration it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(UtilsKt.isConstructor(it));
            }
        });
    }

    public static final boolean isLocal(KSDeclaration kSDeclaration) {
        Intrinsics.checkNotNullParameter(kSDeclaration, "<this>");
        return (kSDeclaration.getParentDeclaration() == null || (kSDeclaration.getParentDeclaration() instanceof KSClassDeclaration)) ? false : true;
    }

    public static /* synthetic */ boolean validate$default(KSNode kSNode, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = new Function2<KSNode, KSNode, Boolean>() { // from class: com.google.devtools.ksp.UtilsKt$validate$1
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(KSNode kSNode2, KSNode kSNode3) {
                    Intrinsics.checkNotNullParameter(kSNode3, "<anonymous parameter 1>");
                    return true;
                }
            };
        }
        return validate(kSNode, function2);
    }

    public static final boolean validate(KSNode kSNode, Function2<? super KSNode, ? super KSNode, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(kSNode, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return ((Boolean) kSNode.accept(new KSValidateVisitor(predicate), null)).booleanValue();
    }

    public static final KSClassDeclaration findActualType(KSTypeAlias kSTypeAlias) {
        Intrinsics.checkNotNullParameter(kSTypeAlias, "<this>");
        KSDeclaration declaration = kSTypeAlias.getType().resolve().getDeclaration();
        if (declaration instanceof KSTypeAlias) {
            return findActualType((KSTypeAlias) declaration);
        }
        Intrinsics.checkNotNull(declaration, "null cannot be cast to non-null type com.google.devtools.ksp.symbol.KSClassDeclaration");
        return (KSClassDeclaration) declaration;
    }

    public static final Visibility getVisibility(KSDeclaration kSDeclaration) {
        KSPropertyDeclaration findOverridee;
        Visibility visibility;
        Intrinsics.checkNotNullParameter(kSDeclaration, "<this>");
        if (kSDeclaration.getModifiers().contains(Modifier.PUBLIC)) {
            return Visibility.PUBLIC;
        }
        if (kSDeclaration.getModifiers().contains(Modifier.OVERRIDE)) {
            if (kSDeclaration instanceof KSFunctionDeclaration) {
                KSDeclaration findOverridee2 = ((KSFunctionDeclaration) kSDeclaration).findOverridee();
                if (findOverridee2 != null) {
                    visibility = getVisibility(findOverridee2);
                }
                visibility = null;
            } else {
                if ((kSDeclaration instanceof KSPropertyDeclaration) && (findOverridee = ((KSPropertyDeclaration) kSDeclaration).findOverridee()) != null) {
                    visibility = getVisibility(findOverridee);
                }
                visibility = null;
            }
            return visibility == null ? Visibility.PUBLIC : visibility;
        }
        if (isLocal(kSDeclaration)) {
            return Visibility.LOCAL;
        }
        if (kSDeclaration.getModifiers().contains(Modifier.PRIVATE)) {
            return Visibility.PRIVATE;
        }
        if (kSDeclaration.getModifiers().contains(Modifier.PROTECTED) || kSDeclaration.getModifiers().contains(Modifier.OVERRIDE)) {
            return Visibility.PROTECTED;
        }
        return kSDeclaration.getModifiers().contains(Modifier.INTERNAL) ? Visibility.INTERNAL : (kSDeclaration.getOrigin() == Origin.JAVA || kSDeclaration.getOrigin() == Origin.JAVA_LIB) ? Visibility.JAVA_PACKAGE : Visibility.PUBLIC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Sequence<KSClassDeclaration> getAllSuperTypes$getTypesUpperBound(KSTypeParameter kSTypeParameter) {
        return SequencesKt.flatMap(kSTypeParameter.getBounds(), new Function1<KSTypeReference, Sequence<? extends KSClassDeclaration>>() { // from class: com.google.devtools.ksp.UtilsKt$getAllSuperTypes$getTypesUpperBound$1
            @Override // kotlin.jvm.functions.Function1
            public final Sequence<KSClassDeclaration> invoke(KSTypeReference it) {
                Sequence<KSClassDeclaration> allSuperTypes$getTypesUpperBound;
                Intrinsics.checkNotNullParameter(it, "it");
                KSDeclaration declaration = it.resolve().getDeclaration();
                if (declaration instanceof KSClassDeclaration) {
                    return SequencesKt.sequenceOf((KSClassDeclaration) declaration);
                }
                if (declaration instanceof KSTypeAlias) {
                    return SequencesKt.sequenceOf(UtilsKt.findActualType((KSTypeAlias) declaration));
                }
                if (declaration instanceof KSTypeParameter) {
                    allSuperTypes$getTypesUpperBound = UtilsKt.getAllSuperTypes$getTypesUpperBound((KSTypeParameter) declaration);
                    return allSuperTypes$getTypesUpperBound;
                }
                throw new IllegalStateException("unhandled type parameter bound, please file a bug at https://github.com/google/ksp/issues/new");
            }
        });
    }

    public static final Sequence<KSType> getAllSuperTypes(KSClassDeclaration kSClassDeclaration) {
        Intrinsics.checkNotNullParameter(kSClassDeclaration, "<this>");
        return SequencesKt.distinct(SequencesKt.plus(SequencesKt.map(kSClassDeclaration.getSuperTypes(), new Function1<KSTypeReference, KSType>() { // from class: com.google.devtools.ksp.UtilsKt$getAllSuperTypes$1
            @Override // kotlin.jvm.functions.Function1
            public final KSType invoke(KSTypeReference it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.resolve();
            }
        }), SequencesKt.flatMap(SequencesKt.mapNotNull(kSClassDeclaration.getSuperTypes(), new Function1<KSTypeReference, KSDeclaration>() { // from class: com.google.devtools.ksp.UtilsKt$getAllSuperTypes$2
            @Override // kotlin.jvm.functions.Function1
            public final KSDeclaration invoke(KSTypeReference it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.resolve().getDeclaration();
            }
        }), new Function1<KSDeclaration, Sequence<? extends KSType>>() { // from class: com.google.devtools.ksp.UtilsKt$getAllSuperTypes$3
            @Override // kotlin.jvm.functions.Function1
            public final Sequence<KSType> invoke(KSDeclaration it) {
                Sequence allSuperTypes$getTypesUpperBound;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it instanceof KSClassDeclaration) {
                    return UtilsKt.getAllSuperTypes((KSClassDeclaration) it);
                }
                if (it instanceof KSTypeAlias) {
                    return UtilsKt.getAllSuperTypes(UtilsKt.findActualType((KSTypeAlias) it));
                }
                if (it instanceof KSTypeParameter) {
                    allSuperTypes$getTypesUpperBound = UtilsKt.getAllSuperTypes$getTypesUpperBound((KSTypeParameter) it);
                    return SequencesKt.flatMap(allSuperTypes$getTypesUpperBound, new Function1<KSClassDeclaration, Sequence<? extends KSType>>() { // from class: com.google.devtools.ksp.UtilsKt$getAllSuperTypes$3.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Sequence<KSType> invoke(KSClassDeclaration it2) {
                            Intrinsics.checkNotNullParameter(it2, "it");
                            return UtilsKt.getAllSuperTypes(it2);
                        }
                    });
                }
                throw new IllegalStateException("unhandled super type kind, please file a bug at https://github.com/google/ksp/issues/new");
            }
        })));
    }

    public static final boolean isAbstract(KSClassDeclaration kSClassDeclaration) {
        Intrinsics.checkNotNullParameter(kSClassDeclaration, "<this>");
        return kSClassDeclaration.getClassKind() == ClassKind.INTERFACE || kSClassDeclaration.getModifiers().contains(Modifier.ABSTRACT);
    }

    public static final boolean isAbstract(KSPropertyDeclaration kSPropertyDeclaration) {
        Set<Modifier> modifiers;
        Set<Modifier> modifiers2;
        Intrinsics.checkNotNullParameter(kSPropertyDeclaration, "<this>");
        if (kSPropertyDeclaration.getModifiers().contains(Modifier.ABSTRACT)) {
            return true;
        }
        KSDeclaration parentDeclaration = kSPropertyDeclaration.getParentDeclaration();
        KSClassDeclaration kSClassDeclaration = parentDeclaration instanceof KSClassDeclaration ? (KSClassDeclaration) parentDeclaration : null;
        if (kSClassDeclaration == null || kSClassDeclaration.getClassKind() != ClassKind.INTERFACE) {
            return false;
        }
        KSPropertyGetter getter = kSPropertyDeclaration.getGetter();
        if ((getter == null || (modifiers2 = getter.getModifiers()) == null) ? true : modifiers2.contains(Modifier.ABSTRACT)) {
            KSPropertySetter setter = kSPropertyDeclaration.getSetter();
            if ((setter == null || (modifiers = setter.getModifiers()) == null) ? true : modifiers.contains(Modifier.ABSTRACT)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        if ((r0 != null ? r0.getClassKind() : null) != com.google.devtools.ksp.symbol.ClassKind.INTERFACE) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean isOpen(com.google.devtools.ksp.symbol.KSDeclaration r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = isLocal(r4)
            if (r0 != 0) goto L7f
            boolean r0 = r4 instanceof com.google.devtools.ksp.symbol.KSClassDeclaration
            r1 = 0
            if (r0 == 0) goto L14
            r2 = r4
            com.google.devtools.ksp.symbol.KSClassDeclaration r2 = (com.google.devtools.ksp.symbol.KSClassDeclaration) r2
            goto L15
        L14:
            r2 = r1
        L15:
            if (r2 == 0) goto L1c
            com.google.devtools.ksp.symbol.ClassKind r2 = r2.getClassKind()
            goto L1d
        L1c:
            r2 = r1
        L1d:
            com.google.devtools.ksp.symbol.ClassKind r3 = com.google.devtools.ksp.symbol.ClassKind.INTERFACE
            if (r2 == r3) goto L7d
            java.util.Set r2 = r4.getModifiers()
            com.google.devtools.ksp.symbol.Modifier r3 = com.google.devtools.ksp.symbol.Modifier.OVERRIDE
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L7d
            java.util.Set r2 = r4.getModifiers()
            com.google.devtools.ksp.symbol.Modifier r3 = com.google.devtools.ksp.symbol.Modifier.ABSTRACT
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L7d
            java.util.Set r2 = r4.getModifiers()
            com.google.devtools.ksp.symbol.Modifier r3 = com.google.devtools.ksp.symbol.Modifier.OPEN
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L7d
            java.util.Set r2 = r4.getModifiers()
            com.google.devtools.ksp.symbol.Modifier r3 = com.google.devtools.ksp.symbol.Modifier.SEALED
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L7d
            if (r0 != 0) goto L69
            com.google.devtools.ksp.symbol.KSDeclaration r0 = r4.getParentDeclaration()
            boolean r2 = r0 instanceof com.google.devtools.ksp.symbol.KSClassDeclaration
            if (r2 == 0) goto L5e
            com.google.devtools.ksp.symbol.KSClassDeclaration r0 = (com.google.devtools.ksp.symbol.KSClassDeclaration) r0
            goto L5f
        L5e:
            r0 = r1
        L5f:
            if (r0 == 0) goto L65
            com.google.devtools.ksp.symbol.ClassKind r1 = r0.getClassKind()
        L65:
            com.google.devtools.ksp.symbol.ClassKind r0 = com.google.devtools.ksp.symbol.ClassKind.INTERFACE
            if (r1 == r0) goto L7d
        L69:
            java.util.Set r0 = r4.getModifiers()
            com.google.devtools.ksp.symbol.Modifier r1 = com.google.devtools.ksp.symbol.Modifier.FINAL
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L7f
            com.google.devtools.ksp.symbol.Origin r4 = r4.getOrigin()
            com.google.devtools.ksp.symbol.Origin r0 = com.google.devtools.ksp.symbol.Origin.JAVA
            if (r4 != r0) goto L7f
        L7d:
            r4 = 1
            goto L80
        L7f:
            r4 = 0
        L80:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.devtools.ksp.UtilsKt.isOpen(com.google.devtools.ksp.symbol.KSDeclaration):boolean");
    }

    public static final boolean isPublic(KSDeclaration kSDeclaration) {
        Intrinsics.checkNotNullParameter(kSDeclaration, "<this>");
        return getVisibility(kSDeclaration) == Visibility.PUBLIC;
    }

    public static final boolean isProtected(KSDeclaration kSDeclaration) {
        Intrinsics.checkNotNullParameter(kSDeclaration, "<this>");
        return getVisibility(kSDeclaration) == Visibility.PROTECTED;
    }

    public static final boolean isInternal(KSDeclaration kSDeclaration) {
        Intrinsics.checkNotNullParameter(kSDeclaration, "<this>");
        return kSDeclaration.getModifiers().contains(Modifier.INTERNAL);
    }

    public static final boolean isPrivate(KSDeclaration kSDeclaration) {
        Intrinsics.checkNotNullParameter(kSDeclaration, "<this>");
        return kSDeclaration.getModifiers().contains(Modifier.PRIVATE);
    }

    public static final boolean isJavaPackagePrivate(KSDeclaration kSDeclaration) {
        Intrinsics.checkNotNullParameter(kSDeclaration, "<this>");
        return getVisibility(kSDeclaration) == Visibility.JAVA_PACKAGE;
    }

    public static final KSClassDeclaration closestClassDeclaration(KSDeclaration kSDeclaration) {
        Intrinsics.checkNotNullParameter(kSDeclaration, "<this>");
        if (kSDeclaration instanceof KSClassDeclaration) {
            return (KSClassDeclaration) kSDeclaration;
        }
        KSDeclaration parentDeclaration = kSDeclaration.getParentDeclaration();
        if (parentDeclaration != null) {
            return closestClassDeclaration(parentDeclaration);
        }
        return null;
    }

    private static final boolean isVisibleFrom$isSamePackage(KSDeclaration kSDeclaration, KSDeclaration kSDeclaration2) {
        return Intrinsics.areEqual(kSDeclaration.getPackageName(), kSDeclaration2.getPackageName());
    }

    private static final List<KSDeclaration> isVisibleFrom$parentDeclarationsForLocal(KSDeclaration kSDeclaration) {
        ArrayList arrayList = new ArrayList();
        KSDeclaration parentDeclaration = kSDeclaration.getParentDeclaration();
        Intrinsics.checkNotNull(parentDeclaration);
        while (isLocal(parentDeclaration)) {
            arrayList.add(parentDeclaration);
            parentDeclaration = parentDeclaration.getParentDeclaration();
            Intrinsics.checkNotNull(parentDeclaration);
        }
        arrayList.add(parentDeclaration);
        return arrayList;
    }

    private static final boolean isVisibleFrom$isVisibleInPrivate(KSDeclaration kSDeclaration, KSDeclaration kSDeclaration2) {
        return (isLocal(kSDeclaration2) && CollectionsKt.contains(isVisibleFrom$parentDeclarationsForLocal(kSDeclaration2), kSDeclaration.getParentDeclaration())) || Intrinsics.areEqual(kSDeclaration.getParentDeclaration(), kSDeclaration2.getParentDeclaration()) || Intrinsics.areEqual(kSDeclaration.getParentDeclaration(), kSDeclaration2) || (kSDeclaration.getParentDeclaration() == null && kSDeclaration2.getParentDeclaration() == null && Intrinsics.areEqual(kSDeclaration.getContainingFile(), kSDeclaration2.getContainingFile()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
    
        if (r3 != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean isVisibleFrom(com.google.devtools.ksp.symbol.KSDeclaration r3, com.google.devtools.ksp.symbol.KSDeclaration r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = isLocal(r3)
            if (r0 == 0) goto L1a
            java.util.List r3 = isVisibleFrom$parentDeclarationsForLocal(r3)
            boolean r3 = r3.contains(r4)
            goto L7e
        L1a:
            boolean r0 = isPrivate(r3)
            if (r0 == 0) goto L25
            boolean r3 = isVisibleFrom$isVisibleInPrivate(r3, r4)
            goto L7e
        L25:
            boolean r0 = isPublic(r3)
            r1 = 1
            if (r0 == 0) goto L2e
        L2c:
            r3 = r1
            goto L7e
        L2e:
            boolean r0 = isInternal(r3)
            if (r0 == 0) goto L41
            com.google.devtools.ksp.symbol.KSFile r0 = r4.getContainingFile()
            if (r0 == 0) goto L41
            com.google.devtools.ksp.symbol.KSFile r0 = r3.getContainingFile()
            if (r0 == 0) goto L41
            goto L2c
        L41:
            boolean r0 = isJavaPackagePrivate(r3)
            if (r0 == 0) goto L4c
            boolean r3 = isVisibleFrom$isSamePackage(r3, r4)
            goto L7e
        L4c:
            boolean r0 = isProtected(r3)
            r2 = 0
            if (r0 == 0) goto L7d
            boolean r0 = isVisibleFrom$isVisibleInPrivate(r3, r4)
            if (r0 != 0) goto L2c
            boolean r0 = isVisibleFrom$isSamePackage(r3, r4)
            if (r0 != 0) goto L2c
            com.google.devtools.ksp.symbol.KSClassDeclaration r4 = closestClassDeclaration(r4)
            if (r4 == 0) goto L79
            com.google.devtools.ksp.symbol.KSClassDeclaration r3 = closestClassDeclaration(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            com.google.devtools.ksp.symbol.KSType r3 = r3.asStarProjectedType()
            com.google.devtools.ksp.symbol.KSType r4 = r4.asStarProjectedType()
            boolean r3 = r3.isAssignableFrom(r4)
            goto L7a
        L79:
            r3 = r2
        L7a:
            if (r3 == 0) goto L7d
            goto L2c
        L7d:
            r3 = r2
        L7e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.devtools.ksp.UtilsKt.isVisibleFrom(com.google.devtools.ksp.symbol.KSDeclaration, com.google.devtools.ksp.symbol.KSDeclaration):boolean");
    }

    public static final boolean isConstructor(KSFunctionDeclaration kSFunctionDeclaration) {
        Intrinsics.checkNotNullParameter(kSFunctionDeclaration, "<this>");
        return Intrinsics.areEqual(kSFunctionDeclaration.getSimpleName().asString(), "<init>");
    }

    public static final KSType getOuterType(KSType kSType) {
        Intrinsics.checkNotNullParameter(kSType, "<this>");
        if (!kSType.getDeclaration().getModifiers().contains(Modifier.INNER)) {
            return null;
        }
        KSDeclaration parentDeclaration = kSType.getDeclaration().getParentDeclaration();
        KSClassDeclaration kSClassDeclaration = parentDeclaration instanceof KSClassDeclaration ? (KSClassDeclaration) parentDeclaration : null;
        if (kSClassDeclaration == null) {
            return null;
        }
        return kSClassDeclaration.asType(kSType.getArguments().subList(kSType.getDeclaration().getTypeParameters().size(), kSType.getArguments().size()));
    }

    public static final List<KSTypeArgument> getInnerArguments(KSType kSType) {
        Intrinsics.checkNotNullParameter(kSType, "<this>");
        return kSType.getArguments().subList(0, kSType.getDeclaration().getTypeParameters().size());
    }

    public static final KSClassDeclaration getKotlinClassByName(Resolver resolver, KSName name) {
        Intrinsics.checkNotNullParameter(resolver, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        KSName mapJavaNameToKotlin = resolver.mapJavaNameToKotlin(name);
        if (mapJavaNameToKotlin != null) {
            name = mapJavaNameToKotlin;
        }
        return resolver.getClassDeclarationByName(name);
    }

    public static final KSClassDeclaration getKotlinClassByName(Resolver resolver, String name) {
        Intrinsics.checkNotNullParameter(resolver, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return getKotlinClassByName(resolver, resolver.getKSNameFromString(name));
    }

    public static final KSClassDeclaration getJavaClassByName(Resolver resolver, KSName name) {
        Intrinsics.checkNotNullParameter(resolver, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        KSName mapKotlinNameToJava = resolver.mapKotlinNameToJava(name);
        if (mapKotlinNameToJava != null) {
            name = mapKotlinNameToJava;
        }
        return resolver.getClassDeclarationByName(name);
    }

    public static final KSClassDeclaration getJavaClassByName(Resolver resolver, String name) {
        Intrinsics.checkNotNullParameter(resolver, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return getJavaClassByName(resolver, resolver.getKSNameFromString(name));
    }

    public static final <T extends Annotation> Sequence<T> getAnnotationsByType(KSAnnotated kSAnnotated, final KClass<T> annotationKClass) {
        Intrinsics.checkNotNullParameter(kSAnnotated, "<this>");
        Intrinsics.checkNotNullParameter(annotationKClass, "annotationKClass");
        return SequencesKt.map(SequencesKt.filter(kSAnnotated.getAnnotations(), new Function1<KSAnnotation, Boolean>() { // from class: com.google.devtools.ksp.UtilsKt$getAnnotationsByType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(KSAnnotation it) {
                boolean z;
                Intrinsics.checkNotNullParameter(it, "it");
                if (Intrinsics.areEqual(it.getShortName().getShortName(), annotationKClass.getSimpleName())) {
                    KSName qualifiedName = it.getAnnotationType().resolve().getDeclaration().getQualifiedName();
                    if (Intrinsics.areEqual(qualifiedName != null ? qualifiedName.asString() : null, annotationKClass.getQualifiedName())) {
                        z = true;
                        return Boolean.valueOf(z);
                    }
                }
                z = false;
                return Boolean.valueOf(z);
            }
        }), new Function1<KSAnnotation, T>() { // from class: com.google.devtools.ksp.UtilsKt$getAnnotationsByType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Incorrect return type in method signature: (Lcom/google/devtools/ksp/symbol/KSAnnotation;)TT; */
            @Override // kotlin.jvm.functions.Function1
            public final Annotation invoke(KSAnnotation it) {
                Annotation annotation;
                Intrinsics.checkNotNullParameter(it, "it");
                annotation = UtilsKt.toAnnotation(it, JvmClassMappingKt.getJavaClass((KClass) annotationKClass));
                return annotation;
            }
        });
    }

    public static final <T extends Annotation> boolean isAnnotationPresent(KSAnnotated kSAnnotated, KClass<T> annotationKClass) {
        Intrinsics.checkNotNullParameter(kSAnnotated, "<this>");
        Intrinsics.checkNotNullParameter(annotationKClass, "annotationKClass");
        return SequencesKt.firstOrNull(getAnnotationsByType(kSAnnotated, annotationKClass)) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends Annotation> T toAnnotation(KSAnnotation kSAnnotation, Class<T> cls) {
        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, createInvocationHandler(kSAnnotation, cls));
        Intrinsics.checkNotNull(newProxyInstance, "null cannot be cast to non-null type T of com.google.devtools.ksp.UtilsKt.toAnnotation");
        return (T) newProxyInstance;
    }

    private static final InvocationHandler createInvocationHandler(final KSAnnotation kSAnnotation, final Class<?> cls) {
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(kSAnnotation.getArguments().size());
        return new InvocationHandler() { // from class: com.google.devtools.ksp.UtilsKt$$ExternalSyntheticLambda0
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object createInvocationHandler$lambda$8;
                createInvocationHandler$lambda$8 = UtilsKt.createInvocationHandler$lambda$8(KSAnnotation.this, cls, concurrentHashMap, obj, method, objArr);
                return createInvocationHandler$lambda$8;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createInvocationHandler$lambda$8(KSAnnotation this_createInvocationHandler, final Class clazz, ConcurrentHashMap cache, Object obj, final Method method, Object[] objArr) {
        Object putIfAbsent;
        Class<?> cls;
        boolean z;
        Method method2;
        Intrinsics.checkNotNullParameter(this_createInvocationHandler, "$this_createInvocationHandler");
        Intrinsics.checkNotNullParameter(clazz, "$clazz");
        Intrinsics.checkNotNullParameter(cache, "$cache");
        if (Intrinsics.areEqual(method.getName(), "toString")) {
            List<KSValueArgument> arguments = this_createInvocationHandler.getArguments();
            if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                Iterator<T> it = arguments.iterator();
                while (it.hasNext()) {
                    KSName name = ((KSValueArgument) it.next()).getName();
                    if (Intrinsics.areEqual(name != null ? name.asString() : null, "toString")) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(clazz.getCanonicalName());
                List<KSValueArgument> arguments2 = this_createInvocationHandler.getArguments();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments2, 10));
                Iterator<T> it2 = arguments2.iterator();
                while (it2.hasNext()) {
                    KSName name2 = ((KSValueArgument) it2.next()).getName();
                    String asString = name2 != null ? name2.asString() : null;
                    Method[] methods = obj.getClass().getMethods();
                    Intrinsics.checkNotNullExpressionValue(methods, "proxy.javaClass.methods");
                    Method[] methodArr = methods;
                    int length = methodArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            method2 = null;
                            break;
                        }
                        method2 = methodArr[i];
                        if (Intrinsics.areEqual(method2.getName(), asString)) {
                            break;
                        }
                        i++;
                    }
                    Method method3 = method2;
                    arrayList.add(asString + '=' + (method3 != null ? method3.invoke(obj, new Object[0]) : null));
                }
                sb.append(CollectionsKt.toList(arrayList));
                return sb.toString();
            }
        }
        for (KSValueArgument kSValueArgument : this_createInvocationHandler.getArguments()) {
            KSName name3 = kSValueArgument.getName();
            if (Intrinsics.areEqual(name3 != null ? name3.asString() : null, method.getName())) {
                final Object result = kSValueArgument.getValue();
                if (result == null) {
                    result = method.getDefaultValue();
                }
                if (result instanceof Proxy) {
                    return result;
                }
                if (result instanceof List) {
                    Function0<Object> function0 = new Function0<Object>() { // from class: com.google.devtools.ksp.UtilsKt$createInvocationHandler$1$value$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Object asArray;
                            Object result2 = result;
                            Intrinsics.checkNotNullExpressionValue(result2, "result");
                            Method method4 = method;
                            Intrinsics.checkNotNullExpressionValue(method4, "method");
                            asArray = UtilsKt.asArray((List) result2, method4, clazz);
                            return asArray;
                        }
                    };
                    ConcurrentHashMap concurrentHashMap = cache;
                    Pair pair = new Pair(method.getReturnType(), result);
                    Object obj2 = concurrentHashMap.get(pair);
                    if (obj2 != null) {
                        return obj2;
                    }
                    Object invoke = function0.invoke();
                    putIfAbsent = concurrentHashMap.putIfAbsent(pair, invoke);
                    if (putIfAbsent == null) {
                        return invoke;
                    }
                } else if (method.getReturnType().isEnum()) {
                    Function0<Object> function02 = new Function0<Object>() { // from class: com.google.devtools.ksp.UtilsKt$createInvocationHandler$1$value$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Object asEnum;
                            Object result2 = result;
                            Intrinsics.checkNotNullExpressionValue(result2, "result");
                            Class<?> returnType = method.getReturnType();
                            Intrinsics.checkNotNullExpressionValue(returnType, "method.returnType");
                            asEnum = UtilsKt.asEnum(result2, returnType);
                            return asEnum;
                        }
                    };
                    ConcurrentHashMap concurrentHashMap2 = cache;
                    Pair pair2 = new Pair(method.getReturnType(), result);
                    Object obj3 = concurrentHashMap2.get(pair2);
                    if (obj3 != null) {
                        return obj3;
                    }
                    Object invoke2 = function02.invoke();
                    putIfAbsent = concurrentHashMap2.putIfAbsent(pair2, invoke2);
                    if (putIfAbsent == null) {
                        return invoke2;
                    }
                } else if (method.getReturnType().isAnnotation()) {
                    Function0<Object> function03 = new Function0<Object>() { // from class: com.google.devtools.ksp.UtilsKt$createInvocationHandler$1$value$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Object asAnnotation;
                            Object obj4 = result;
                            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.google.devtools.ksp.symbol.KSAnnotation");
                            Class<?> returnType = method.getReturnType();
                            Intrinsics.checkNotNullExpressionValue(returnType, "method.returnType");
                            asAnnotation = UtilsKt.asAnnotation((KSAnnotation) obj4, returnType);
                            return asAnnotation;
                        }
                    };
                    ConcurrentHashMap concurrentHashMap3 = cache;
                    Pair pair3 = new Pair(method.getReturnType(), result);
                    Object obj4 = concurrentHashMap3.get(pair3);
                    if (obj4 != null) {
                        return obj4;
                    }
                    Object invoke3 = function03.invoke();
                    putIfAbsent = concurrentHashMap3.putIfAbsent(pair3, invoke3);
                    if (putIfAbsent == null) {
                        return invoke3;
                    }
                } else if (Intrinsics.areEqual(method.getReturnType().getName(), "java.lang.Class")) {
                    ConcurrentHashMap concurrentHashMap4 = cache;
                    Pair pair4 = new Pair(method.getReturnType(), result);
                    Object obj5 = concurrentHashMap4.get(pair4);
                    if (obj5 != null) {
                        return obj5;
                    }
                    if (!(result instanceof KSType)) {
                        Method[] methods2 = result.getClass().getMethods();
                        Intrinsics.checkNotNullExpressionValue(methods2, "result.javaClass.methods");
                        for (Method method4 : methods2) {
                            if (Intrinsics.areEqual(method4.getName(), "getCanonicalText")) {
                                Object invoke4 = method4.invoke(result, false);
                                Intrinsics.checkNotNull(invoke4, "null cannot be cast to non-null type kotlin.String");
                                cls = Class.forName((String) invoke4);
                            }
                        }
                        throw new NoSuchElementException("Array contains no element matching the predicate.");
                    }
                    Intrinsics.checkNotNullExpressionValue(result, "result");
                    cls = asClass((KSType) result, clazz);
                    putIfAbsent = concurrentHashMap4.putIfAbsent(pair4, cls);
                    if (putIfAbsent == null) {
                        return cls;
                    }
                } else if (Intrinsics.areEqual(method.getReturnType().getName(), "byte")) {
                    Function0<Byte> function04 = new Function0<Byte>() { // from class: com.google.devtools.ksp.UtilsKt$createInvocationHandler$1$value$4
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Byte invoke() {
                            byte asByte;
                            Object result2 = result;
                            Intrinsics.checkNotNullExpressionValue(result2, "result");
                            asByte = UtilsKt.asByte(result2);
                            return Byte.valueOf(asByte);
                        }
                    };
                    ConcurrentHashMap concurrentHashMap5 = cache;
                    Pair pair5 = new Pair(method.getReturnType(), result);
                    Object obj6 = concurrentHashMap5.get(pair5);
                    if (obj6 != null) {
                        return obj6;
                    }
                    Byte invoke5 = function04.invoke();
                    putIfAbsent = concurrentHashMap5.putIfAbsent(pair5, invoke5);
                    if (putIfAbsent == null) {
                        return invoke5;
                    }
                } else if (Intrinsics.areEqual(method.getReturnType().getName(), "short")) {
                    Function0<Short> function05 = new Function0<Short>() { // from class: com.google.devtools.ksp.UtilsKt$createInvocationHandler$1$value$5
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Short invoke() {
                            short asShort;
                            Object result2 = result;
                            Intrinsics.checkNotNullExpressionValue(result2, "result");
                            asShort = UtilsKt.asShort(result2);
                            return Short.valueOf(asShort);
                        }
                    };
                    ConcurrentHashMap concurrentHashMap6 = cache;
                    Pair pair6 = new Pair(method.getReturnType(), result);
                    Object obj7 = concurrentHashMap6.get(pair6);
                    if (obj7 != null) {
                        return obj7;
                    }
                    Short invoke6 = function05.invoke();
                    putIfAbsent = concurrentHashMap6.putIfAbsent(pair6, invoke6);
                    if (putIfAbsent == null) {
                        return invoke6;
                    }
                } else if (Intrinsics.areEqual(method.getReturnType().getName(), "long")) {
                    Function0<Long> function06 = new Function0<Long>() { // from class: com.google.devtools.ksp.UtilsKt$createInvocationHandler$1$value$6
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Long invoke() {
                            long asLong;
                            Object result2 = result;
                            Intrinsics.checkNotNullExpressionValue(result2, "result");
                            asLong = UtilsKt.asLong(result2);
                            return Long.valueOf(asLong);
                        }
                    };
                    ConcurrentHashMap concurrentHashMap7 = cache;
                    Pair pair7 = new Pair(method.getReturnType(), result);
                    Object obj8 = concurrentHashMap7.get(pair7);
                    if (obj8 != null) {
                        return obj8;
                    }
                    Long invoke7 = function06.invoke();
                    putIfAbsent = concurrentHashMap7.putIfAbsent(pair7, invoke7);
                    if (putIfAbsent == null) {
                        return invoke7;
                    }
                } else if (Intrinsics.areEqual(method.getReturnType().getName(), "float")) {
                    Function0<Float> function07 = new Function0<Float>() { // from class: com.google.devtools.ksp.UtilsKt$createInvocationHandler$1$value$7
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Float invoke() {
                            float asFloat;
                            Object result2 = result;
                            Intrinsics.checkNotNullExpressionValue(result2, "result");
                            asFloat = UtilsKt.asFloat(result2);
                            return Float.valueOf(asFloat);
                        }
                    };
                    ConcurrentHashMap concurrentHashMap8 = cache;
                    Pair pair8 = new Pair(method.getReturnType(), result);
                    Object obj9 = concurrentHashMap8.get(pair8);
                    if (obj9 != null) {
                        return obj9;
                    }
                    Float invoke8 = function07.invoke();
                    putIfAbsent = concurrentHashMap8.putIfAbsent(pair8, invoke8);
                    if (putIfAbsent == null) {
                        return invoke8;
                    }
                } else {
                    if (!Intrinsics.areEqual(method.getReturnType().getName(), "double")) {
                        return result;
                    }
                    Function0<Double> function08 = new Function0<Double>() { // from class: com.google.devtools.ksp.UtilsKt$createInvocationHandler$1$value$8
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Double invoke() {
                            double asDouble;
                            Object result2 = result;
                            Intrinsics.checkNotNullExpressionValue(result2, "result");
                            asDouble = UtilsKt.asDouble(result2);
                            return Double.valueOf(asDouble);
                        }
                    };
                    ConcurrentHashMap concurrentHashMap9 = cache;
                    Pair pair9 = new Pair(method.getReturnType(), result);
                    Object obj10 = concurrentHashMap9.get(pair9);
                    if (obj10 != null) {
                        return obj10;
                    }
                    Double invoke9 = function08.invoke();
                    putIfAbsent = concurrentHashMap9.putIfAbsent(pair9, invoke9);
                    if (putIfAbsent == null) {
                        return invoke9;
                    }
                }
                return putIfAbsent;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object asAnnotation(KSAnnotation kSAnnotation, Class<?> cls) {
        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, createInvocationHandler(kSAnnotation, cls));
        Intrinsics.checkNotNull(newProxyInstance, "null cannot be cast to non-null type java.lang.reflect.Proxy");
        return (Proxy) newProxyInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object asArray(List<?> list, final Method method, Class<?> cls) {
        String name = method.getReturnType().getComponentType().getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Double>");
                        return CollectionsKt.toDoubleArray(list);
                    }
                    break;
                case -530663260:
                    if (name.equals("java.lang.Class")) {
                        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<com.google.devtools.ksp.symbol.KSType>");
                        return asClasses(list, cls).toArray(new Class[0]);
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
                        return CollectionsKt.toIntArray(list);
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Byte>");
                        return CollectionsKt.toByteArray(list);
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Char>");
                        return CollectionsKt.toCharArray(list);
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Long>");
                        return CollectionsKt.toLongArray(list);
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Boolean>");
                        return CollectionsKt.toBooleanArray(list);
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
                        return CollectionsKt.toFloatArray(list);
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Short>");
                        return CollectionsKt.toShortArray(list);
                    }
                    break;
                case 1195259493:
                    if (name.equals("java.lang.String")) {
                        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                        return list.toArray(new String[0]);
                    }
                    break;
            }
        }
        if (method.getReturnType().getComponentType().isEnum()) {
            return toArray(list, method, new Function1<Object, Object>() { // from class: com.google.devtools.ksp.UtilsKt$asArray$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object result) {
                    Object asEnum;
                    Intrinsics.checkNotNullParameter(result, "result");
                    Class<?> componentType = method.getReturnType().getComponentType();
                    Intrinsics.checkNotNullExpressionValue(componentType, "method.returnType.componentType");
                    asEnum = UtilsKt.asEnum(result, componentType);
                    Intrinsics.checkNotNullExpressionValue(asEnum, "result.asEnum(method.returnType.componentType)");
                    return asEnum;
                }
            });
        }
        if (method.getReturnType().getComponentType().isAnnotation()) {
            return toArray(list, method, new Function1<Object, Object>() { // from class: com.google.devtools.ksp.UtilsKt$asArray$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object result) {
                    Object asAnnotation;
                    Intrinsics.checkNotNullParameter(result, "result");
                    Class<?> componentType = method.getReturnType().getComponentType();
                    Intrinsics.checkNotNullExpressionValue(componentType, "method.returnType.componentType");
                    asAnnotation = UtilsKt.asAnnotation((KSAnnotation) result, componentType);
                    return asAnnotation;
                }
            });
        }
        throw new IllegalStateException("Unable to process type " + method.getReturnType().getComponentType().getName());
    }

    private static final Object[] toArray(List<?> list, Method method, Function1<Object, ? extends Object> function1) {
        Object newInstance = Array.newInstance(method.getReturnType().getComponentType(), list.size());
        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) newInstance;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            objArr[i] = obj != null ? function1.invoke(obj) : null;
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T asEnum(Object obj, Class<T> cls) {
        String obj2;
        Method declaredMethod = cls.getDeclaredMethod("valueOf", String.class);
        Object[] objArr = new Object[1];
        if (obj instanceof KSType) {
            obj2 = ((KSType) obj).getDeclaration().getSimpleName().getShortName();
        } else {
            obj2 = obj.toString();
        }
        objArr[0] = obj2;
        return (T) declaredMethod.invoke(null, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte asByte(Object obj) {
        if (obj instanceof Integer) {
            return (byte) ((Number) obj).intValue();
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) obj).byteValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final short asShort(Object obj) {
        if (obj instanceof Integer) {
            return (short) ((Number) obj).intValue();
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) obj).shortValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long asLong(Object obj) {
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) obj).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float asFloat(Object obj) {
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) obj).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double asDouble(Object obj) {
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) obj).doubleValue();
    }

    private static final Class<?> asClass(KSType kSType, Class<?> cls) {
        try {
            KSName qualifiedName = kSType.getDeclaration().getQualifiedName();
            Intrinsics.checkNotNull(qualifiedName);
            return Class.forName(qualifiedName.asString(), true, cls.getClassLoader());
        } catch (Exception e) {
            throw new KSTypeNotPresentException(kSType, e);
        }
    }

    private static final List<Class<?>> asClasses(List<? extends KSType> list, Class<?> cls) {
        try {
            List<? extends KSType> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(asClass((KSType) it.next(), cls));
            }
            return arrayList;
        } catch (Exception e) {
            throw new KSTypesNotPresentException(list, e);
        }
    }

    public static final boolean isDefault(KSValueArgument kSValueArgument) {
        Intrinsics.checkNotNullParameter(kSValueArgument, "<this>");
        return kSValueArgument.getOrigin() == Origin.SYNTHETIC;
    }
}
