package com.squareup.kotlinpoet.ksp;

import com.amazon.a.a.n.a.a.g;
import com.amazon.a.a.o.b;
import com.squareup.kotlinpoet.TypeVariableName;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeParameterResolver.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0004H¦\u0002R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/squareup/kotlinpoet/ksp/TypeParameterResolver;", "", "parametersMap", "", "", "Lcom/squareup/kotlinpoet/TypeVariableName;", "getParametersMap", "()Ljava/util/Map;", b.ar, "index", "Companion", "ksp"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface TypeParameterResolver {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    TypeVariableName get(String index);

    Map<String, TypeVariableName> getParametersMap();

    /* compiled from: TypeParameterResolver.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/squareup/kotlinpoet/ksp/TypeParameterResolver$Companion;", "", "()V", g.a, "Lcom/squareup/kotlinpoet/ksp/TypeParameterResolver;", "getEMPTY", "()Lcom/squareup/kotlinpoet/ksp/TypeParameterResolver;", "ksp"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final TypeParameterResolver EMPTY = new TypeParameterResolver() { // from class: com.squareup.kotlinpoet.ksp.TypeParameterResolver$Companion$EMPTY$1
            private final Map<String, TypeVariableName> parametersMap = MapsKt.emptyMap();

            @Override // com.squareup.kotlinpoet.ksp.TypeParameterResolver
            public Map<String, TypeVariableName> getParametersMap() {
                return this.parametersMap;
            }

            @Override // com.squareup.kotlinpoet.ksp.TypeParameterResolver
            public TypeVariableName get(String index) {
                Intrinsics.checkNotNullParameter(index, "index");
                throw new NoSuchElementException("No TypeParameter found for index " + index);
            }
        };

        private Companion() {
        }

        public final TypeParameterResolver getEMPTY() {
            return EMPTY;
        }
    }
}
