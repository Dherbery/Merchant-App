package expo.modules.kotlin.sharedobjects;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.exception.InvalidSharedObjectException;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.kotlin.types.NullAwareTypeConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* compiled from: SharedObjectTypeConverter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lexpo/modules/kotlin/sharedobjects/SharedObjectTypeConverter;", "T", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "Lexpo/modules/kotlin/types/NullAwareTypeConverter;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "convertNonOptional", "value", "", "context", "Lexpo/modules/kotlin/AppContext;", "(Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;)Lexpo/modules/kotlin/sharedobjects/SharedObject;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SharedObjectTypeConverter<T extends SharedObject> extends NullAwareTypeConverter<T> {
    private final KType type;

    @Override // expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public final KType getType() {
        return this.type;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedObjectTypeConverter(KType type) {
        super(type.getIsMarkedNullable());
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    @Override // expo.modules.kotlin.types.NullAwareTypeConverter
    public T convertNonOptional(Object value, AppContext context) {
        int intValue;
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof Dynamic) {
            intValue = ((Dynamic) value).asInt();
        } else {
            intValue = ((Integer) value).intValue();
        }
        int m1275constructorimpl = SharedObjectId.m1275constructorimpl(intValue);
        if (context != null) {
            T t = (T) SharedObjectId.m1280toNativeObjectimpl(m1275constructorimpl, context);
            if (t != null) {
                return t;
            }
            throw new InvalidSharedObjectException(this.type);
        }
        throw new Exceptions.AppContextLost();
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    /* renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return new ExpectedType(CppType.SHARED_OBJECT_ID, CppType.INT);
    }
}
