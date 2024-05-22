package com.squareup.kotlinpoet;

import com.squareup.kotlinpoet.AnnotationSpec;
import com.squareup.kotlinpoet.FileSpec;
import com.squareup.kotlinpoet.FunSpec;
import com.squareup.kotlinpoet.ParameterSpec;
import com.squareup.kotlinpoet.PropertySpec;
import com.squareup.kotlinpoet.Taggable;
import com.squareup.kotlinpoet.TypeAliasSpec;
import com.squareup.kotlinpoet.TypeSpec;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: Taggable.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0000\u001a(\u0010\u0003\u001a\u00020\u0004\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006*\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0005H\u0086\b¢\u0006\u0002\u0010\u0007\u001a(\u0010\u0003\u001a\u00020\b\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006*\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0005H\u0086\b¢\u0006\u0002\u0010\t\u001a(\u0010\u0003\u001a\u00020\n\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006*\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0005H\u0086\b¢\u0006\u0002\u0010\u000b\u001a(\u0010\u0003\u001a\u00020\f\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006*\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0005H\u0086\b¢\u0006\u0002\u0010\r\u001a(\u0010\u0003\u001a\u00020\u000e\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006*\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0005H\u0086\b¢\u0006\u0002\u0010\u000f\u001a \u0010\u0003\u001a\u0004\u0018\u0001H\u0005\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006*\u00020\u0010H\u0086\b¢\u0006\u0002\u0010\u0011\u001a(\u0010\u0003\u001a\u00020\u0012\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006*\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0005H\u0086\b¢\u0006\u0002\u0010\u0013\u001a(\u0010\u0003\u001a\u00020\u0014\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006*\u00020\u00142\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0005H\u0086\b¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"buildTagMap", "Lcom/squareup/kotlinpoet/TagMap;", "Lcom/squareup/kotlinpoet/Taggable$Builder;", "tag", "Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;", "T", "", "(Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;Ljava/lang/Object;)Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;", "Lcom/squareup/kotlinpoet/FileSpec$Builder;", "(Lcom/squareup/kotlinpoet/FileSpec$Builder;Ljava/lang/Object;)Lcom/squareup/kotlinpoet/FileSpec$Builder;", "Lcom/squareup/kotlinpoet/FunSpec$Builder;", "(Lcom/squareup/kotlinpoet/FunSpec$Builder;Ljava/lang/Object;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "(Lcom/squareup/kotlinpoet/ParameterSpec$Builder;Ljava/lang/Object;)Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "(Lcom/squareup/kotlinpoet/PropertySpec$Builder;Ljava/lang/Object;)Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "Lcom/squareup/kotlinpoet/Taggable;", "(Lcom/squareup/kotlinpoet/Taggable;)Ljava/lang/Object;", "Lcom/squareup/kotlinpoet/TypeAliasSpec$Builder;", "(Lcom/squareup/kotlinpoet/TypeAliasSpec$Builder;Ljava/lang/Object;)Lcom/squareup/kotlinpoet/TypeAliasSpec$Builder;", "Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "(Lcom/squareup/kotlinpoet/TypeSpec$Builder;Ljava/lang/Object;)Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "kotlinpoet"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class TaggableKt {
    public static final /* synthetic */ <T> T tag(Taggable taggable) {
        Intrinsics.checkNotNullParameter(taggable, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) taggable.tag(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public static final /* synthetic */ <T> AnnotationSpec.Builder tag(AnnotationSpec.Builder builder, T t) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (AnnotationSpec.Builder) builder.tag(Reflection.getOrCreateKotlinClass(Object.class), (Object) t);
    }

    public static final /* synthetic */ <T> FileSpec.Builder tag(FileSpec.Builder builder, T t) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (FileSpec.Builder) builder.tag(Reflection.getOrCreateKotlinClass(Object.class), (Object) t);
    }

    public static final /* synthetic */ <T> FunSpec.Builder tag(FunSpec.Builder builder, T t) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (FunSpec.Builder) builder.tag(Reflection.getOrCreateKotlinClass(Object.class), (Object) t);
    }

    public static final /* synthetic */ <T> ParameterSpec.Builder tag(ParameterSpec.Builder builder, T t) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (ParameterSpec.Builder) builder.tag(Reflection.getOrCreateKotlinClass(Object.class), (Object) t);
    }

    public static final /* synthetic */ <T> PropertySpec.Builder tag(PropertySpec.Builder builder, T t) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (PropertySpec.Builder) builder.tag(Reflection.getOrCreateKotlinClass(Object.class), (Object) t);
    }

    public static final /* synthetic */ <T> TypeAliasSpec.Builder tag(TypeAliasSpec.Builder builder, T t) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (TypeAliasSpec.Builder) builder.tag(Reflection.getOrCreateKotlinClass(Object.class), (Object) t);
    }

    public static final /* synthetic */ <T> TypeSpec.Builder tag(TypeSpec.Builder builder, T t) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (TypeSpec.Builder) builder.tag(Reflection.getOrCreateKotlinClass(Object.class), (Object) t);
    }

    public static final TagMap buildTagMap(Taggable.Builder<?> builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return new TagMap(new LinkedHashMap(builder.getTags()));
    }
}
