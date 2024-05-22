package kotlinx.serialization.internal;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

/* compiled from: Caching.kt */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\f\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B3\u0012,\u0010\u0003\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004¢\u0006\u0002\u0010\nJB\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0002¢\u0006\u0002\u0010\u0015R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR4\u0010\u0003\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/internal/ClassValueParametrizedCache;", "T", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "compute", "Lkotlin/Function2;", "Lkotlin/reflect/KClass;", "", "", "Lkotlin/reflect/KType;", "Lkotlinx/serialization/KSerializer;", "(Lkotlin/jvm/functions/Function2;)V", "classValue", "kotlinx/serialization/internal/ClassValueParametrizedCache$initClassValue$1", "Lkotlinx/serialization/internal/ClassValueParametrizedCache$initClassValue$1;", b.ar, "Lkotlin/Result;", SubscriberAttributeKt.JSON_NAME_KEY, "types", "get-gIAlu-s", "(Lkotlin/reflect/KClass;Ljava/util/List;)Ljava/lang/Object;", "initClassValue", "()Lkotlinx/serialization/internal/ClassValueParametrizedCache$initClassValue$1;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
final class ClassValueParametrizedCache<T> implements ParametrizedSerializerCache<T> {
    private final ClassValueParametrizedCache$initClassValue$1 classValue;
    private final Function2<KClass<Object>, List<? extends KType>, KSerializer<T>> compute;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassValueParametrizedCache(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.compute = compute;
        this.classValue = initClassValue();
    }

    private final ClassValueParametrizedCache$initClassValue$1 initClassValue() {
        return new ClassValue<ParametrizedCacheEntry<T>>() { // from class: kotlinx.serialization.internal.ClassValueParametrizedCache$initClassValue$1
            @Override // java.lang.ClassValue
            public /* bridge */ /* synthetic */ Object computeValue(Class cls) {
                return computeValue((Class<?>) cls);
            }

            @Override // java.lang.ClassValue
            protected ParametrizedCacheEntry<T> computeValue(Class<?> type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return new ParametrizedCacheEntry<>();
            }
        };
    }

    @Override // kotlinx.serialization.internal.ParametrizedSerializerCache
    /* renamed from: get-gIAlu-s, reason: not valid java name */
    public Object mo2941getgIAlus(KClass<Object> key, List<? extends KType> types) {
        Object obj;
        Object m1318constructorimpl;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(types, "types");
        obj = get(JvmClassMappingKt.getJavaClass((KClass) key));
        ConcurrentHashMap concurrentHashMap = ((ParametrizedCacheEntry) obj).serializers;
        Object obj2 = concurrentHashMap.get(types);
        if (obj2 == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m1318constructorimpl = Result.m1318constructorimpl(this.compute.invoke(key, types));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m1318constructorimpl = Result.m1318constructorimpl(ResultKt.createFailure(th));
            }
            Result m1317boximpl = Result.m1317boximpl(m1318constructorimpl);
            Object putIfAbsent = concurrentHashMap.putIfAbsent(types, m1317boximpl);
            obj2 = putIfAbsent == null ? m1317boximpl : putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(obj2, "serializers.getOrPut(typ… { producer() }\n        }");
        return ((Result) obj2).getValue();
    }
}
