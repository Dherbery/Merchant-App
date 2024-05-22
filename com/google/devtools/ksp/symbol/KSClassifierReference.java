package com.google.devtools.ksp.symbol;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KSClassifierReference.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J5\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\t2\u0006\u0010\n\u001a\u0002H\u0007H\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/google/devtools/ksp/symbol/KSClassifierReference;", "Lcom/google/devtools/ksp/symbol/KSReferenceElement;", "qualifier", "getQualifier", "()Lcom/google/devtools/ksp/symbol/KSClassifierReference;", "accept", "R", "D", "visitor", "Lcom/google/devtools/ksp/symbol/KSVisitor;", "data", "(Lcom/google/devtools/ksp/symbol/KSVisitor;Ljava/lang/Object;)Ljava/lang/Object;", "referencedName", "", "api"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface KSClassifierReference extends KSReferenceElement {
    @Override // com.google.devtools.ksp.symbol.KSNode
    <D, R> R accept(KSVisitor<D, R> visitor, D data);

    KSClassifierReference getQualifier();

    String referencedName();

    /* compiled from: KSClassifierReference.kt */
    /* renamed from: com.google.devtools.ksp.symbol.KSClassifierReference$-CC, reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
        public static Object $default$accept(KSClassifierReference _this, KSVisitor visitor, Object obj) {
            Intrinsics.checkNotNullParameter(visitor, "visitor");
            return visitor.visitClassifierReference(_this, obj);
        }
    }

    /* compiled from: KSClassifierReference.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <D, R> R accept(KSClassifierReference kSClassifierReference, KSVisitor<D, R> visitor, D d) {
            Intrinsics.checkNotNullParameter(visitor, "visitor");
            return (R) CC.$default$accept(kSClassifierReference, visitor, d);
        }
    }
}
