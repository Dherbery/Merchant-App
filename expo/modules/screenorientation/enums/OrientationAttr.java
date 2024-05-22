package expo.modules.screenorientation.enums;

import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.kotlin.types.Enumerable;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrientationAttr.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001c"}, d2 = {"Lexpo/modules/screenorientation/enums/OrientationAttr;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "toOrientationLock", "Lexpo/modules/screenorientation/enums/OrientationLock;", "toOrientationLock$expo_screen_orientation_release", "Behind", "Landscape", "Portrait", "FullSensor", "Unspecified", "Locked", "FullUser", "NoSensor", "ReverseLandscape", "ReversePortrait", "Sensor", "SensorPortrait", "SensorLandscape", "User", "UserPortrait", "UserLandscape", "Companion", "expo-screen-orientation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum OrientationAttr implements Enumerable {
    Behind(3),
    Landscape(0),
    Portrait(1),
    FullSensor(10),
    Unspecified(-1),
    Locked(14),
    FullUser(13),
    NoSensor(5),
    ReverseLandscape(8),
    ReversePortrait(9),
    Sensor(4),
    SensorPortrait(7),
    SensorLandscape(6),
    User(2),
    UserPortrait(12),
    UserLandscape(11);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    OrientationAttr(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public final OrientationLock toOrientationLock$expo_screen_orientation_release() {
        try {
            for (OrientationLock orientationLock : OrientationLock.values()) {
                if (Intrinsics.areEqual(orientationLock.name(), name())) {
                    return orientationLock;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (NoSuchElementException unused) {
            return OrientationLock.Other;
        }
    }

    /* compiled from: OrientationAttr.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/screenorientation/enums/OrientationAttr$Companion;", "", "()V", "fromInt", "Lexpo/modules/screenorientation/enums/OrientationAttr;", "value", "", "expo-screen-orientation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OrientationAttr fromInt(int value) throws InvalidArgumentException {
            try {
                for (OrientationAttr orientationAttr : OrientationAttr.values()) {
                    if (orientationAttr.getValue() == value) {
                        return orientationAttr;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            } catch (NoSuchElementException unused) {
                throw new InvalidArgumentException("Platform orientation " + value + " is not a valid Android orientation attr");
            }
        }
    }
}
