package com.squareup.kotlinpoet;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: Taggable.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\rJ'\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0016¢\u0006\u0002\u0010\u000bJ'\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004H&¢\u0006\u0002\u0010\fR$\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/squareup/kotlinpoet/Taggable;", "", "tags", "", "Lkotlin/reflect/KClass;", "getTags", "()Ljava/util/Map;", "tag", "T", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "Builder", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface Taggable {
    Map<KClass<?>, Object> getTags();

    <T> T tag(Class<T> type);

    <T> T tag(KClass<T> type);

    /* compiled from: Taggable.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static Map<KClass<?>, Object> getTags(Taggable taggable) {
            return MapsKt.emptyMap();
        }

        public static <T> T tag(Taggable taggable, Class<T> type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return (T) taggable.tag(JvmClassMappingKt.getKotlinClass(type));
        }
    }

    /* compiled from: Taggable.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0010\b\u0000\u0010\u0001 \u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002J#\u0010\b\u001a\u00028\u00002\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u000bJ#\u0010\b\u001a\u00028\u00002\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\fR\"\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/squareup/kotlinpoet/Taggable$Builder;", "T", "", "tags", "", "Lkotlin/reflect/KClass;", "getTags", "()Ljava/util/Map;", "tag", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;Ljava/lang/Object;)Lcom/squareup/kotlinpoet/Taggable$Builder;", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lcom/squareup/kotlinpoet/Taggable$Builder;", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Builder<T extends Builder<? extends T>> {
        Map<KClass<?>, Object> getTags();

        T tag(Class<?> type, Object tag);

        T tag(KClass<?> type, Object tag);

        /* compiled from: Taggable.kt */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class DefaultImpls {
            public static <T extends Builder<? extends T>> T tag(Builder<? extends T> builder, Class<?> type, Object obj) {
                Intrinsics.checkNotNullParameter(type, "type");
                return builder.tag(JvmClassMappingKt.getKotlinClass(type), obj);
            }

            public static <T extends Builder<? extends T>> T tag(Builder<? extends T> builder, KClass<?> type, Object obj) {
                Intrinsics.checkNotNullParameter(type, "type");
                if (obj == null) {
                    builder.getTags().remove(type);
                } else {
                    builder.getTags().put(type, obj);
                }
                Intrinsics.checkNotNull(builder, "null cannot be cast to non-null type T of com.squareup.kotlinpoet.Taggable.Builder");
                return builder;
            }
        }
    }
}
