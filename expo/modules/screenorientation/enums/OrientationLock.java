package expo.modules.screenorientation.enums;

import com.bleplx.adapter.utils.Constants;
import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.kotlin.types.Enumerable;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrientationLock.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nJ\r\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lexpo/modules/screenorientation/enums/OrientationLock;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "toOrientationAttr", "Lexpo/modules/screenorientation/enums/OrientationAttr;", "toOrientationAttr$expo_screen_orientation_release", "toPlatformInt", "toPlatformInt$expo_screen_orientation_release", "Unspecified", "FullSensor", "SensorPortrait", "Portrait", "ReversePortrait", "SensorLandscape", "ReverseLandscape", "Landscape", "Other", Constants.BluetoothState.UNKNOWN, "Companion", "expo-screen-orientation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum OrientationLock implements Enumerable {
    Unspecified(0),
    FullSensor(1),
    SensorPortrait(2),
    Portrait(3),
    ReversePortrait(4),
    SensorLandscape(5),
    ReverseLandscape(6),
    Landscape(7),
    Other(8),
    Unknown(9);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    OrientationLock(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public final OrientationAttr toOrientationAttr$expo_screen_orientation_release() throws InvalidArgumentException {
        try {
            for (OrientationAttr orientationAttr : OrientationAttr.values()) {
                if (Intrinsics.areEqual(orientationAttr.name(), name())) {
                    return orientationAttr;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (NoSuchElementException unused) {
            throw new InvalidArgumentException("OrientationLock " + this + " is not mappable to a native Android orientation attr");
        }
    }

    public final int toPlatformInt$expo_screen_orientation_release() throws InvalidArgumentException {
        return toOrientationAttr$expo_screen_orientation_release().getValue();
    }

    /* compiled from: OrientationLock.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lexpo/modules/screenorientation/enums/OrientationLock$Companion;", "", "()V", "fromPlatformInt", "Lexpo/modules/screenorientation/enums/OrientationLock;", "value", "", "supportsOrientationLock", "", "expo-screen-orientation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OrientationLock fromPlatformInt(int value) throws InvalidArgumentException {
            return OrientationAttr.INSTANCE.fromInt(value).toOrientationLock$expo_screen_orientation_release();
        }

        public final boolean supportsOrientationLock(int value) {
            boolean z;
            OrientationLock[] values = OrientationLock.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                }
                if (values[i].getValue() == value) {
                    z = true;
                    break;
                }
                i++;
            }
            return (!z || value == OrientationLock.Other.getValue() || value == OrientationLock.Unknown.getValue()) ? false : true;
        }
    }
}
