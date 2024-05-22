package com.mrousavy.camera.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraCaptureSession+setRepeatingRequestAndWaitForPrecapture.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/mrousavy/camera/extensions/ResultState;", "", "focusState", "Lcom/mrousavy/camera/extensions/FocusState;", "exposureState", "Lcom/mrousavy/camera/extensions/ExposureState;", "whiteBalanceState", "Lcom/mrousavy/camera/extensions/WhiteBalanceState;", "(Lcom/mrousavy/camera/extensions/FocusState;Lcom/mrousavy/camera/extensions/ExposureState;Lcom/mrousavy/camera/extensions/WhiteBalanceState;)V", "getExposureState", "()Lcom/mrousavy/camera/extensions/ExposureState;", "getFocusState", "()Lcom/mrousavy/camera/extensions/FocusState;", "getWhiteBalanceState", "()Lcom/mrousavy/camera/extensions/WhiteBalanceState;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ResultState {
    private final ExposureState exposureState;
    private final FocusState focusState;
    private final WhiteBalanceState whiteBalanceState;

    public static /* synthetic */ ResultState copy$default(ResultState resultState, FocusState focusState, ExposureState exposureState, WhiteBalanceState whiteBalanceState, int i, Object obj) {
        if ((i & 1) != 0) {
            focusState = resultState.focusState;
        }
        if ((i & 2) != 0) {
            exposureState = resultState.exposureState;
        }
        if ((i & 4) != 0) {
            whiteBalanceState = resultState.whiteBalanceState;
        }
        return resultState.copy(focusState, exposureState, whiteBalanceState);
    }

    /* renamed from: component1, reason: from getter */
    public final FocusState getFocusState() {
        return this.focusState;
    }

    /* renamed from: component2, reason: from getter */
    public final ExposureState getExposureState() {
        return this.exposureState;
    }

    /* renamed from: component3, reason: from getter */
    public final WhiteBalanceState getWhiteBalanceState() {
        return this.whiteBalanceState;
    }

    public final ResultState copy(FocusState focusState, ExposureState exposureState, WhiteBalanceState whiteBalanceState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        Intrinsics.checkNotNullParameter(exposureState, "exposureState");
        Intrinsics.checkNotNullParameter(whiteBalanceState, "whiteBalanceState");
        return new ResultState(focusState, exposureState, whiteBalanceState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResultState)) {
            return false;
        }
        ResultState resultState = (ResultState) other;
        return this.focusState == resultState.focusState && this.exposureState == resultState.exposureState && this.whiteBalanceState == resultState.whiteBalanceState;
    }

    public int hashCode() {
        return (((this.focusState.hashCode() * 31) + this.exposureState.hashCode()) * 31) + this.whiteBalanceState.hashCode();
    }

    public String toString() {
        return "ResultState(focusState=" + this.focusState + ", exposureState=" + this.exposureState + ", whiteBalanceState=" + this.whiteBalanceState + ")";
    }

    public ResultState(FocusState focusState, ExposureState exposureState, WhiteBalanceState whiteBalanceState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        Intrinsics.checkNotNullParameter(exposureState, "exposureState");
        Intrinsics.checkNotNullParameter(whiteBalanceState, "whiteBalanceState");
        this.focusState = focusState;
        this.exposureState = exposureState;
        this.whiteBalanceState = whiteBalanceState;
    }

    public final ExposureState getExposureState() {
        return this.exposureState;
    }

    public final FocusState getFocusState() {
        return this.focusState;
    }

    public final WhiteBalanceState getWhiteBalanceState() {
        return this.whiteBalanceState;
    }
}
