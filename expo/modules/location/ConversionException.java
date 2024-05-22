package expo.modules.location;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: LocationExceptions.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/location/ConversionException;", "Lexpo/modules/kotlin/exception/CodedException;", "fromClass", "Ljava/lang/Class;", "toClass", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)V", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConversionException extends CodedException {
    public /* synthetic */ ConversionException(Class cls, Class cls2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, cls2, (i & 4) != 0 ? "" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversionException(Class<?> fromClass, Class<?> toClass, String str) {
        super("Couldn't cast from " + Reflection.getOrCreateKotlinClass(fromClass.getClass()).getSimpleName() + " to " + toClass.getClass().getSimpleName() + ": " + str, null, 2, null);
        Intrinsics.checkNotNullParameter(fromClass, "fromClass");
        Intrinsics.checkNotNullParameter(toClass, "toClass");
    }
}
