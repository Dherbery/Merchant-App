package com.squareup.kotlinpoet.tags;

import com.squareup.kotlinpoet.TypeName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeAliasTag.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/squareup/kotlinpoet/tags/TypeAliasTag;", "", "abbreviatedType", "Lcom/squareup/kotlinpoet/TypeName;", "(Lcom/squareup/kotlinpoet/TypeName;)V", "getAbbreviatedType", "()Lcom/squareup/kotlinpoet/TypeName;", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class TypeAliasTag {
    private final TypeName abbreviatedType;

    public TypeAliasTag(TypeName abbreviatedType) {
        Intrinsics.checkNotNullParameter(abbreviatedType, "abbreviatedType");
        this.abbreviatedType = abbreviatedType;
    }

    public final TypeName getAbbreviatedType() {
        return this.abbreviatedType;
    }
}
