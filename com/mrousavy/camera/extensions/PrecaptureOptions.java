package com.mrousavy.camera.extensions;

import android.graphics.Point;
import com.mrousavy.camera.types.Flash;
import expo.modules.kotlin.types.LazyKType$$ExternalSyntheticBackport0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraCaptureSession+precapture.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J\t\u0010\u001b\u001a\u00020\fHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/mrousavy/camera/extensions/PrecaptureOptions;", "", "modes", "", "Lcom/mrousavy/camera/extensions/PrecaptureTrigger;", "flash", "Lcom/mrousavy/camera/types/Flash;", "pointsOfInterest", "Landroid/graphics/Point;", "skipIfPassivelyFocused", "", "timeoutMs", "", "(Ljava/util/List;Lcom/mrousavy/camera/types/Flash;Ljava/util/List;ZJ)V", "getFlash", "()Lcom/mrousavy/camera/types/Flash;", "getModes", "()Ljava/util/List;", "getPointsOfInterest", "getSkipIfPassivelyFocused", "()Z", "getTimeoutMs", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PrecaptureOptions {
    private final Flash flash;
    private final List<PrecaptureTrigger> modes;
    private final List<Point> pointsOfInterest;
    private final boolean skipIfPassivelyFocused;
    private final long timeoutMs;

    public static /* synthetic */ PrecaptureOptions copy$default(PrecaptureOptions precaptureOptions, List list, Flash flash, List list2, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = precaptureOptions.modes;
        }
        if ((i & 2) != 0) {
            flash = precaptureOptions.flash;
        }
        Flash flash2 = flash;
        if ((i & 4) != 0) {
            list2 = precaptureOptions.pointsOfInterest;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            z = precaptureOptions.skipIfPassivelyFocused;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            j = precaptureOptions.timeoutMs;
        }
        return precaptureOptions.copy(list, flash2, list3, z2, j);
    }

    public final List<PrecaptureTrigger> component1() {
        return this.modes;
    }

    /* renamed from: component2, reason: from getter */
    public final Flash getFlash() {
        return this.flash;
    }

    public final List<Point> component3() {
        return this.pointsOfInterest;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getSkipIfPassivelyFocused() {
        return this.skipIfPassivelyFocused;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    public final PrecaptureOptions copy(List<? extends PrecaptureTrigger> modes, Flash flash, List<? extends Point> pointsOfInterest, boolean skipIfPassivelyFocused, long timeoutMs) {
        Intrinsics.checkNotNullParameter(modes, "modes");
        Intrinsics.checkNotNullParameter(flash, "flash");
        Intrinsics.checkNotNullParameter(pointsOfInterest, "pointsOfInterest");
        return new PrecaptureOptions(modes, flash, pointsOfInterest, skipIfPassivelyFocused, timeoutMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrecaptureOptions)) {
            return false;
        }
        PrecaptureOptions precaptureOptions = (PrecaptureOptions) other;
        return Intrinsics.areEqual(this.modes, precaptureOptions.modes) && this.flash == precaptureOptions.flash && Intrinsics.areEqual(this.pointsOfInterest, precaptureOptions.pointsOfInterest) && this.skipIfPassivelyFocused == precaptureOptions.skipIfPassivelyFocused && this.timeoutMs == precaptureOptions.timeoutMs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.modes.hashCode() * 31) + this.flash.hashCode()) * 31) + this.pointsOfInterest.hashCode()) * 31;
        boolean z = this.skipIfPassivelyFocused;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + LazyKType$$ExternalSyntheticBackport0.m(this.timeoutMs);
    }

    public String toString() {
        return "PrecaptureOptions(modes=" + this.modes + ", flash=" + this.flash + ", pointsOfInterest=" + this.pointsOfInterest + ", skipIfPassivelyFocused=" + this.skipIfPassivelyFocused + ", timeoutMs=" + this.timeoutMs + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PrecaptureOptions(List<? extends PrecaptureTrigger> modes, Flash flash, List<? extends Point> pointsOfInterest, boolean z, long j) {
        Intrinsics.checkNotNullParameter(modes, "modes");
        Intrinsics.checkNotNullParameter(flash, "flash");
        Intrinsics.checkNotNullParameter(pointsOfInterest, "pointsOfInterest");
        this.modes = modes;
        this.flash = flash;
        this.pointsOfInterest = pointsOfInterest;
        this.skipIfPassivelyFocused = z;
        this.timeoutMs = j;
    }

    public final List<PrecaptureTrigger> getModes() {
        return this.modes;
    }

    public /* synthetic */ PrecaptureOptions(List list, Flash flash, List list2, boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? Flash.OFF : flash, list2, z, j);
    }

    public final Flash getFlash() {
        return this.flash;
    }

    public final List<Point> getPointsOfInterest() {
        return this.pointsOfInterest;
    }

    public final boolean getSkipIfPassivelyFocused() {
        return this.skipIfPassivelyFocused;
    }

    public final long getTimeoutMs() {
        return this.timeoutMs;
    }
}
