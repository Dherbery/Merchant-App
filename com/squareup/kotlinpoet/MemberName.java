package com.squareup.kotlinpoet;

import com.amazon.a.a.o.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* compiled from: MemberName.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bB\u001f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB\u0017\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J?\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0015\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&J\u0013\u0010'\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020\u0003H\u0016R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014¨\u0006/"}, d2 = {"Lcom/squareup/kotlinpoet/MemberName;", "", "packageName", "", "simpleName", "(Ljava/lang/String;Ljava/lang/String;)V", "isExtension", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "enclosingClassName", "Lcom/squareup/kotlinpoet/ClassName;", "(Lcom/squareup/kotlinpoet/ClassName;Ljava/lang/String;)V", "(Lcom/squareup/kotlinpoet/ClassName;Ljava/lang/String;Z)V", "operator", "Lcom/squareup/kotlinpoet/KOperator;", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/KOperator;)V", "(Lcom/squareup/kotlinpoet/ClassName;Lcom/squareup/kotlinpoet/KOperator;)V", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/ClassName;Ljava/lang/String;Lcom/squareup/kotlinpoet/KOperator;Z)V", "canonicalName", "getCanonicalName", "()Ljava/lang/String;", "getEnclosingClassName", "()Lcom/squareup/kotlinpoet/ClassName;", "()Z", "getOperator", "()Lcom/squareup/kotlinpoet/KOperator;", "getPackageName", "getSimpleName", "component1", "component2", "component3", "component4", "component5", "copy", "emit", "", "out", "Lcom/squareup/kotlinpoet/CodeWriter;", "emit$kotlinpoet", "equals", "other", "hashCode", "", "reference", "Lcom/squareup/kotlinpoet/CodeBlock;", "toString", "Companion", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MemberName {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String canonicalName;
    private final ClassName enclosingClassName;
    private final boolean isExtension;
    private final KOperator operator;
    private final String packageName;
    private final String simpleName;

    public static /* synthetic */ MemberName copy$default(MemberName memberName, String str, ClassName className, String str2, KOperator kOperator, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = memberName.packageName;
        }
        if ((i & 2) != 0) {
            className = memberName.enclosingClassName;
        }
        ClassName className2 = className;
        if ((i & 4) != 0) {
            str2 = memberName.simpleName;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            kOperator = memberName.operator;
        }
        KOperator kOperator2 = kOperator;
        if ((i & 16) != 0) {
            z = memberName.isExtension;
        }
        return memberName.copy(str, className2, str3, kOperator2, z);
    }

    @JvmStatic
    public static final MemberName get(Class<?> cls, String str) {
        return INSTANCE.get(cls, str);
    }

    @JvmStatic
    public static final MemberName get(KClass<?> kClass, String str) {
        return INSTANCE.get(kClass, str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final ClassName getEnclosingClassName() {
        return this.enclosingClassName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSimpleName() {
        return this.simpleName;
    }

    /* renamed from: component4, reason: from getter */
    public final KOperator getOperator() {
        return this.operator;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsExtension() {
        return this.isExtension;
    }

    public final MemberName copy(String packageName, ClassName enclosingClassName, String simpleName, KOperator operator, boolean isExtension) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(simpleName, "simpleName");
        return new MemberName(packageName, enclosingClassName, simpleName, operator, isExtension);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberName)) {
            return false;
        }
        MemberName memberName = (MemberName) other;
        return Intrinsics.areEqual(this.packageName, memberName.packageName) && Intrinsics.areEqual(this.enclosingClassName, memberName.enclosingClassName) && Intrinsics.areEqual(this.simpleName, memberName.simpleName) && this.operator == memberName.operator && this.isExtension == memberName.isExtension;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.packageName.hashCode() * 31;
        ClassName className = this.enclosingClassName;
        int hashCode2 = (((hashCode + (className == null ? 0 : className.hashCode())) * 31) + this.simpleName.hashCode()) * 31;
        KOperator kOperator = this.operator;
        int hashCode3 = (hashCode2 + (kOperator != null ? kOperator.hashCode() : 0)) * 31;
        boolean z = this.isExtension;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode3 + i;
    }

    public MemberName(String packageName, ClassName className, String simpleName, KOperator kOperator, boolean z) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(simpleName, "simpleName");
        this.packageName = packageName;
        this.enclosingClassName = className;
        this.simpleName = simpleName;
        this.operator = kOperator;
        this.isExtension = z;
        StringBuilder sb = new StringBuilder();
        if (className != null) {
            sb.append(className.getCanonicalName());
            sb.append('.');
        } else if (!StringsKt.isBlank(packageName)) {
            sb.append(packageName);
            sb.append('.');
        }
        sb.append(simpleName);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        this.canonicalName = sb2;
    }

    public /* synthetic */ MemberName(String str, ClassName className, String str2, KOperator kOperator, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, className, str2, (i & 8) != 0 ? null : kOperator, (i & 16) != 0 ? false : z);
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final ClassName getEnclosingClassName() {
        return this.enclosingClassName;
    }

    public final String getSimpleName() {
        return this.simpleName;
    }

    public final KOperator getOperator() {
        return this.operator;
    }

    public final boolean isExtension() {
        return this.isExtension;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MemberName(String packageName, String simpleName) {
        this(packageName, null, simpleName, null, false, 24, null);
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(simpleName, "simpleName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MemberName(String packageName, String simpleName, boolean z) {
        this(packageName, null, simpleName, null, z);
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(simpleName, "simpleName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MemberName(ClassName enclosingClassName, String simpleName) {
        this(enclosingClassName.getPackageName(), enclosingClassName, simpleName, null, false, 24, null);
        Intrinsics.checkNotNullParameter(enclosingClassName, "enclosingClassName");
        Intrinsics.checkNotNullParameter(simpleName, "simpleName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MemberName(ClassName enclosingClassName, String simpleName, boolean z) {
        this(enclosingClassName.getPackageName(), enclosingClassName, simpleName, null, z);
        Intrinsics.checkNotNullParameter(enclosingClassName, "enclosingClassName");
        Intrinsics.checkNotNullParameter(simpleName, "simpleName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MemberName(String packageName, KOperator operator) {
        this(packageName, null, operator.getFunctionName(), operator, false, 16, null);
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(operator, "operator");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MemberName(ClassName enclosingClassName, KOperator operator) {
        this(enclosingClassName.getPackageName(), enclosingClassName, operator.getFunctionName(), operator, false, 16, null);
        Intrinsics.checkNotNullParameter(enclosingClassName, "enclosingClassName");
        Intrinsics.checkNotNullParameter(operator, "operator");
    }

    public final String getCanonicalName() {
        return this.canonicalName;
    }

    public final CodeBlock reference() {
        return this.enclosingClassName == null ? CodeBlock.INSTANCE.of("::%M", this) : CodeBlock.INSTANCE.of("%T::%N", this.enclosingClassName, this.simpleName);
    }

    public final void emit$kotlinpoet(CodeWriter out) {
        Intrinsics.checkNotNullParameter(out, "out");
        if (this.operator == null) {
            CodeWriter.emit$default(out, UtilKt.escapeSegmentsIfNecessary$default(out.lookupName(this), (char) 0, 1, null), false, 2, null);
        } else {
            out.lookupName(this);
            CodeWriter.emit$default(out, this.operator.getOperator(), false, 2, null);
        }
    }

    public String toString() {
        return this.canonicalName;
    }

    /* compiled from: MemberName.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\bJ\u001d\u0010\u0003\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\tJ\u001d\u0010\u0003\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/squareup/kotlinpoet/MemberName$Companion;", "", "()V", "member", "Lcom/squareup/kotlinpoet/MemberName;", "Lcom/squareup/kotlinpoet/ClassName;", "simpleName", "", "Ljava/lang/Class;", b.ar, "Lkotlin/reflect/KClass;", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final /* synthetic */ MemberName member(ClassName className, String simpleName) {
            Intrinsics.checkNotNullParameter(className, "<this>");
            Intrinsics.checkNotNullParameter(simpleName, "simpleName");
            return new MemberName(className, simpleName);
        }

        @JvmStatic
        public final MemberName get(KClass<?> kClass, String simpleName) {
            Intrinsics.checkNotNullParameter(kClass, "<this>");
            Intrinsics.checkNotNullParameter(simpleName, "simpleName");
            return new MemberName(ClassNames.get(kClass), simpleName);
        }

        @JvmStatic
        public final MemberName get(Class<?> cls, String simpleName) {
            Intrinsics.checkNotNullParameter(cls, "<this>");
            Intrinsics.checkNotNullParameter(simpleName, "simpleName");
            return new MemberName(ClassNames.get(cls), simpleName);
        }
    }
}
