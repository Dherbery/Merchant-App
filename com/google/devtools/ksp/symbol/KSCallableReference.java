package com.google.devtools.ksp.symbol;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KSCallableReference.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u000e0\u00112\u0006\u0010\u0012\u001a\u0002H\u000fH\u0016¢\u0006\u0002\u0010\u0013R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/google/devtools/ksp/symbol/KSCallableReference;", "Lcom/google/devtools/ksp/symbol/KSReferenceElement;", "functionParameters", "", "Lcom/google/devtools/ksp/symbol/KSValueParameter;", "getFunctionParameters", "()Ljava/util/List;", "receiverType", "Lcom/google/devtools/ksp/symbol/KSTypeReference;", "getReceiverType", "()Lcom/google/devtools/ksp/symbol/KSTypeReference;", "returnType", "getReturnType", "accept", "R", "D", "visitor", "Lcom/google/devtools/ksp/symbol/KSVisitor;", "data", "(Lcom/google/devtools/ksp/symbol/KSVisitor;Ljava/lang/Object;)Ljava/lang/Object;", "api"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface KSCallableReference extends KSReferenceElement {
    @Override // com.google.devtools.ksp.symbol.KSNode
    <D, R> R accept(KSVisitor<D, R> visitor, D data);

    List<KSValueParameter> getFunctionParameters();

    KSTypeReference getReceiverType();

    KSTypeReference getReturnType();

    /* compiled from: KSCallableReference.kt */
    /* renamed from: com.google.devtools.ksp.symbol.KSCallableReference$-CC, reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
        public static Object $default$accept(KSCallableReference _this, KSVisitor visitor, Object obj) {
            Intrinsics.checkNotNullParameter(visitor, "visitor");
            return visitor.visitCallableReference(_this, obj);
        }
    }

    /* compiled from: KSCallableReference.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <D, R> R accept(KSCallableReference kSCallableReference, KSVisitor<D, R> visitor, D d) {
            Intrinsics.checkNotNullParameter(visitor, "visitor");
            return (R) CC.$default$accept(kSCallableReference, visitor, d);
        }
    }
}
