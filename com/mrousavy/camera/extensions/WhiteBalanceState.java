package com.mrousavy.camera.extensions;

import com.bleplx.adapter.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CameraCaptureSession+setRepeatingRequestAndWaitForPrecapture.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/mrousavy/camera/extensions/WhiteBalanceState;", "", "Lcom/mrousavy/camera/extensions/AutoState;", "(Ljava/lang/String;I)V", "isCompleted", "", "()Z", "isPassivelyFocused", Constants.BluetoothState.UNKNOWN, "Inactive", "Locked", "Searching", "Converged", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum WhiteBalanceState implements AutoState {
    Unknown,
    Inactive,
    Locked,
    Searching,
    Converged;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Override // com.mrousavy.camera.extensions.AutoState
    public boolean isCompleted() {
        return this == Converged;
    }

    @Override // com.mrousavy.camera.extensions.AutoState
    public boolean isPassivelyFocused() {
        return this == Converged;
    }

    /* compiled from: CameraCaptureSession+setRepeatingRequestAndWaitForPrecapture.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/extensions/WhiteBalanceState$Companion;", "", "()V", "fromAWBState", "Lcom/mrousavy/camera/extensions/WhiteBalanceState;", "awbState", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WhiteBalanceState fromAWBState(int awbState) {
            if (awbState == 0) {
                return WhiteBalanceState.Inactive;
            }
            if (awbState == 1) {
                return WhiteBalanceState.Searching;
            }
            if (awbState == 2) {
                return WhiteBalanceState.Converged;
            }
            if (awbState == 3) {
                return WhiteBalanceState.Locked;
            }
            return WhiteBalanceState.Unknown;
        }
    }
}
