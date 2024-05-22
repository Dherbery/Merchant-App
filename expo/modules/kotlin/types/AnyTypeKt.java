package expo.modules.kotlin.types;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: AnyType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0005"}, d2 = {"toAnyType", "Lexpo/modules/kotlin/types/AnyType;", "T", "Lkotlin/Function0;", "Lkotlin/reflect/KType;", "expo-modules-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnyTypeKt {
    public static final /* synthetic */ <T> AnyType toAnyType(Function0<? extends KType> function0) {
        Intrinsics.checkNotNullParameter(function0, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "T");
        return new AnyType(new LazyKType(orCreateKotlinClass, false, function0));
    }
}
