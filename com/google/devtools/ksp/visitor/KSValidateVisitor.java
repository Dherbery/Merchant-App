package com.google.devtools.ksp.visitor;

import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSAnnotation;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSDeclaration;
import com.google.devtools.ksp.symbol.KSDeclarationContainer;
import com.google.devtools.ksp.symbol.KSFunctionDeclaration;
import com.google.devtools.ksp.symbol.KSNode;
import com.google.devtools.ksp.symbol.KSPropertyDeclaration;
import com.google.devtools.ksp.symbol.KSType;
import com.google.devtools.ksp.symbol.KSTypeArgument;
import com.google.devtools.ksp.symbol.KSTypeParameter;
import com.google.devtools.ksp.symbol.KSTypeReference;
import com.google.devtools.ksp.symbol.KSValueArgument;
import com.google.devtools.ksp.symbol.KSValueParameter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KSValidateVisitor.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0002J\u001f\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010!J\u001f\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010%J\u001f\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010)J\u001f\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010-J\u001f\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u0002002\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u00101J\u001f\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u0002042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u00105J\u001f\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u0002082\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u00109R\"\u0010\u0004\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/google/devtools/ksp/visitor/KSValidateVisitor;", "Lcom/google/devtools/ksp/visitor/KSDefaultVisitor;", "Lcom/google/devtools/ksp/symbol/KSNode;", "", "predicate", "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function2;)V", "defaultHandler", "node", "data", "(Lcom/google/devtools/ksp/symbol/KSNode;Lcom/google/devtools/ksp/symbol/KSNode;)Ljava/lang/Boolean;", "validateType", "type", "Lcom/google/devtools/ksp/symbol/KSType;", "visitAnnotated", "annotated", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "(Lcom/google/devtools/ksp/symbol/KSAnnotated;Lcom/google/devtools/ksp/symbol/KSNode;)Ljava/lang/Boolean;", "visitAnnotation", "annotation", "Lcom/google/devtools/ksp/symbol/KSAnnotation;", "(Lcom/google/devtools/ksp/symbol/KSAnnotation;Lcom/google/devtools/ksp/symbol/KSNode;)Ljava/lang/Boolean;", "visitClassDeclaration", "classDeclaration", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "(Lcom/google/devtools/ksp/symbol/KSClassDeclaration;Lcom/google/devtools/ksp/symbol/KSNode;)Ljava/lang/Boolean;", "visitDeclaration", "declaration", "Lcom/google/devtools/ksp/symbol/KSDeclaration;", "(Lcom/google/devtools/ksp/symbol/KSDeclaration;Lcom/google/devtools/ksp/symbol/KSNode;)Ljava/lang/Boolean;", "visitDeclarationContainer", "declarationContainer", "Lcom/google/devtools/ksp/symbol/KSDeclarationContainer;", "(Lcom/google/devtools/ksp/symbol/KSDeclarationContainer;Lcom/google/devtools/ksp/symbol/KSNode;)Ljava/lang/Boolean;", "visitFunctionDeclaration", "function", "Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;", "(Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;Lcom/google/devtools/ksp/symbol/KSNode;)Ljava/lang/Boolean;", "visitPropertyDeclaration", "property", "Lcom/google/devtools/ksp/symbol/KSPropertyDeclaration;", "(Lcom/google/devtools/ksp/symbol/KSPropertyDeclaration;Lcom/google/devtools/ksp/symbol/KSNode;)Ljava/lang/Boolean;", "visitTypeParameter", "typeParameter", "Lcom/google/devtools/ksp/symbol/KSTypeParameter;", "(Lcom/google/devtools/ksp/symbol/KSTypeParameter;Lcom/google/devtools/ksp/symbol/KSNode;)Ljava/lang/Boolean;", "visitTypeReference", "typeReference", "Lcom/google/devtools/ksp/symbol/KSTypeReference;", "(Lcom/google/devtools/ksp/symbol/KSTypeReference;Lcom/google/devtools/ksp/symbol/KSNode;)Ljava/lang/Boolean;", "visitValueArgument", "valueArgument", "Lcom/google/devtools/ksp/symbol/KSValueArgument;", "(Lcom/google/devtools/ksp/symbol/KSValueArgument;Lcom/google/devtools/ksp/symbol/KSNode;)Ljava/lang/Boolean;", "visitValueParameter", "valueParameter", "Lcom/google/devtools/ksp/symbol/KSValueParameter;", "(Lcom/google/devtools/ksp/symbol/KSValueParameter;Lcom/google/devtools/ksp/symbol/KSNode;)Ljava/lang/Boolean;", "api"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public class KSValidateVisitor extends KSDefaultVisitor<KSNode, Boolean> {
    private final Function2<KSNode, KSNode, Boolean> predicate;

    /* JADX WARN: Multi-variable type inference failed */
    public KSValidateVisitor(Function2<? super KSNode, ? super KSNode, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        this.predicate = predicate;
    }

    private final boolean validateType(KSType type) {
        boolean z;
        if (type.isError()) {
            return false;
        }
        List<KSTypeArgument> arguments = type.getArguments();
        if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
            Iterator<T> it = arguments.iterator();
            while (it.hasNext()) {
                KSTypeReference type2 = ((KSTypeArgument) it.next()).getType();
                if ((type2 == null || ((Boolean) type2.accept(this, null)).booleanValue()) ? false : true) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return !z;
    }

    @Override // com.google.devtools.ksp.visitor.KSEmptyVisitor
    public Boolean defaultHandler(KSNode node, KSNode data) {
        Intrinsics.checkNotNullParameter(node, "node");
        return true;
    }

    @Override // com.google.devtools.ksp.visitor.KSDefaultVisitor, com.google.devtools.ksp.visitor.KSEmptyVisitor, com.google.devtools.ksp.symbol.KSVisitor
    public Boolean visitDeclaration(KSDeclaration declaration, KSNode data) {
        Intrinsics.checkNotNullParameter(declaration, "declaration");
        boolean z = true;
        if (!this.predicate.invoke(data, declaration).booleanValue()) {
            return true;
        }
        List<KSTypeParameter> typeParameters = declaration.getTypeParameters();
        if (!(typeParameters instanceof Collection) || !typeParameters.isEmpty()) {
            Iterator<T> it = typeParameters.iterator();
            while (it.hasNext()) {
                if (!((Boolean) ((KSTypeParameter) it.next()).accept(this, declaration)).booleanValue()) {
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        return visitAnnotated((KSAnnotated) declaration, data);
    }

    @Override // com.google.devtools.ksp.visitor.KSDefaultVisitor, com.google.devtools.ksp.visitor.KSEmptyVisitor, com.google.devtools.ksp.symbol.KSVisitor
    public Boolean visitDeclarationContainer(KSDeclarationContainer declarationContainer, KSNode data) {
        boolean z;
        Intrinsics.checkNotNullParameter(declarationContainer, "declarationContainer");
        Iterator<KSDeclaration> it = declarationContainer.getDeclarations().iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            KSDeclaration next = it.next();
            if (this.predicate.invoke(declarationContainer, next).booleanValue() && !((Boolean) next.accept(this, declarationContainer)).booleanValue()) {
                z = false;
            }
            if (!z) {
                z = false;
                break;
            }
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.devtools.ksp.visitor.KSDefaultVisitor, com.google.devtools.ksp.visitor.KSEmptyVisitor, com.google.devtools.ksp.symbol.KSVisitor
    public Boolean visitTypeParameter(KSTypeParameter typeParameter, KSNode data) {
        boolean z;
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        boolean z2 = true;
        if (this.predicate.invoke(data, typeParameter).booleanValue()) {
            Iterator<KSTypeReference> it = typeParameter.getBounds().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (!((Boolean) it.next().accept(this, typeParameter)).booleanValue()) {
                    z = false;
                    break;
                }
            }
            if (!z) {
                z2 = false;
            }
        }
        return Boolean.valueOf(z2);
    }

    @Override // com.google.devtools.ksp.visitor.KSDefaultVisitor, com.google.devtools.ksp.visitor.KSEmptyVisitor, com.google.devtools.ksp.symbol.KSVisitor
    public Boolean visitAnnotated(KSAnnotated annotated, KSNode data) {
        boolean z;
        Intrinsics.checkNotNullParameter(annotated, "annotated");
        boolean z2 = true;
        if (this.predicate.invoke(data, annotated).booleanValue()) {
            Iterator<KSAnnotation> it = annotated.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (!((Boolean) it.next().accept(this, annotated)).booleanValue()) {
                    z = false;
                    break;
                }
            }
            if (!z) {
                z2 = false;
            }
        }
        return Boolean.valueOf(z2);
    }

    @Override // com.google.devtools.ksp.visitor.KSDefaultVisitor, com.google.devtools.ksp.visitor.KSEmptyVisitor, com.google.devtools.ksp.symbol.KSVisitor
    public Boolean visitAnnotation(KSAnnotation annotation, KSNode data) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        boolean z = true;
        if (!this.predicate.invoke(data, annotation).booleanValue()) {
            return true;
        }
        if (!((Boolean) annotation.getAnnotationType().accept(this, annotation)).booleanValue()) {
            return false;
        }
        List<KSValueArgument> arguments = annotation.getArguments();
        if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
            for (KSValueArgument kSValueArgument : arguments) {
                if (!((Boolean) kSValueArgument.accept(r2, kSValueArgument)).booleanValue()) {
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            return true;
        }
        return false;
    }

    @Override // com.google.devtools.ksp.visitor.KSDefaultVisitor, com.google.devtools.ksp.visitor.KSEmptyVisitor, com.google.devtools.ksp.symbol.KSVisitor
    public Boolean visitTypeReference(KSTypeReference typeReference, KSNode data) {
        Intrinsics.checkNotNullParameter(typeReference, "typeReference");
        return Boolean.valueOf(validateType(typeReference.resolve()));
    }

    @Override // com.google.devtools.ksp.visitor.KSDefaultVisitor, com.google.devtools.ksp.visitor.KSEmptyVisitor, com.google.devtools.ksp.symbol.KSVisitor
    public Boolean visitClassDeclaration(KSClassDeclaration classDeclaration, KSNode data) {
        Intrinsics.checkNotNullParameter(classDeclaration, "classDeclaration");
        boolean z = false;
        if (classDeclaration.asStarProjectedType().isError()) {
            return false;
        }
        Iterator<KSTypeReference> it = classDeclaration.getSuperTypes().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            if (!((Boolean) it.next().accept(this, classDeclaration)).booleanValue()) {
                break;
            }
        }
        if (!z || !visitDeclaration((KSDeclaration) classDeclaration, data).booleanValue() || !visitDeclarationContainer((KSDeclarationContainer) classDeclaration, data).booleanValue()) {
            return false;
        }
        return true;
    }

    @Override // com.google.devtools.ksp.visitor.KSDefaultVisitor, com.google.devtools.ksp.visitor.KSEmptyVisitor, com.google.devtools.ksp.symbol.KSVisitor
    public Boolean visitFunctionDeclaration(KSFunctionDeclaration function, KSNode data) {
        Intrinsics.checkNotNullParameter(function, "function");
        boolean z = false;
        if (function.getReturnType() != null) {
            Function2<KSNode, KSNode, Boolean> function2 = this.predicate;
            KSTypeReference returnType = function.getReturnType();
            Intrinsics.checkNotNull(returnType);
            if (function2.invoke(function, returnType).booleanValue()) {
                KSTypeReference returnType2 = function.getReturnType();
                Intrinsics.checkNotNull(returnType2);
                if (!((Boolean) returnType2.accept(this, data)).booleanValue()) {
                    return false;
                }
            }
        }
        List<KSValueParameter> parameters = function.getParameters();
        if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
            Iterator<T> it = parameters.iterator();
            while (it.hasNext()) {
                if (!((Boolean) ((KSValueParameter) it.next()).accept(this, function)).booleanValue()) {
                    break;
                }
            }
        }
        z = true;
        if (!z || !visitDeclaration((KSDeclaration) function, data).booleanValue()) {
            return false;
        }
        return true;
    }

    @Override // com.google.devtools.ksp.visitor.KSDefaultVisitor, com.google.devtools.ksp.visitor.KSEmptyVisitor, com.google.devtools.ksp.symbol.KSVisitor
    public Boolean visitPropertyDeclaration(KSPropertyDeclaration property, KSNode data) {
        Intrinsics.checkNotNullParameter(property, "property");
        if ((this.predicate.invoke(property, property.getType()).booleanValue() && !((Boolean) property.getType().accept(this, data)).booleanValue()) || !visitDeclaration((KSDeclaration) property, data).booleanValue()) {
            return false;
        }
        return true;
    }

    private static final boolean visitValueArgument$visitValue(KSValidateVisitor kSValidateVisitor, KSNode kSNode, Object obj) {
        if (obj instanceof KSType) {
            return kSValidateVisitor.validateType((KSType) obj);
        }
        if (obj instanceof KSAnnotation) {
            return kSValidateVisitor.visitAnnotation((KSAnnotation) obj, kSNode).booleanValue();
        }
        if (obj instanceof List) {
            Iterable iterable = (Iterable) obj;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    if (!visitValueArgument$visitValue(kSValidateVisitor, kSNode, it.next())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override // com.google.devtools.ksp.visitor.KSDefaultVisitor, com.google.devtools.ksp.visitor.KSEmptyVisitor, com.google.devtools.ksp.symbol.KSVisitor
    public Boolean visitValueArgument(KSValueArgument valueArgument, KSNode data) {
        Intrinsics.checkNotNullParameter(valueArgument, "valueArgument");
        return Boolean.valueOf(visitValueArgument$visitValue(this, data, valueArgument.getValue()));
    }

    @Override // com.google.devtools.ksp.visitor.KSDefaultVisitor, com.google.devtools.ksp.visitor.KSEmptyVisitor, com.google.devtools.ksp.symbol.KSVisitor
    public Boolean visitValueParameter(KSValueParameter valueParameter, KSNode data) {
        Intrinsics.checkNotNullParameter(valueParameter, "valueParameter");
        return (Boolean) valueParameter.getType().accept(this, valueParameter);
    }
}
