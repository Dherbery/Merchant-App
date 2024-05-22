package com.mrousavy.camera.extensions;

import kotlin.Metadata;

/* compiled from: RecordingSession+getRecommendedBitRate.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/mrousavy/camera/extensions/RecommendedProfile;", "", "bitRate", "", "codec", "bitDepth", "fps", "(IIII)V", "getBitDepth", "()I", "getBitRate", "getCodec", "getFps", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RecommendedProfile {
    private final int bitDepth;
    private final int bitRate;
    private final int codec;
    private final int fps;

    public static /* synthetic */ RecommendedProfile copy$default(RecommendedProfile recommendedProfile, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = recommendedProfile.bitRate;
        }
        if ((i5 & 2) != 0) {
            i2 = recommendedProfile.codec;
        }
        if ((i5 & 4) != 0) {
            i3 = recommendedProfile.bitDepth;
        }
        if ((i5 & 8) != 0) {
            i4 = recommendedProfile.fps;
        }
        return recommendedProfile.copy(i, i2, i3, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getBitRate() {
        return this.bitRate;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCodec() {
        return this.codec;
    }

    /* renamed from: component3, reason: from getter */
    public final int getBitDepth() {
        return this.bitDepth;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFps() {
        return this.fps;
    }

    public final RecommendedProfile copy(int bitRate, int codec, int bitDepth, int fps) {
        return new RecommendedProfile(bitRate, codec, bitDepth, fps);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommendedProfile)) {
            return false;
        }
        RecommendedProfile recommendedProfile = (RecommendedProfile) other;
        return this.bitRate == recommendedProfile.bitRate && this.codec == recommendedProfile.codec && this.bitDepth == recommendedProfile.bitDepth && this.fps == recommendedProfile.fps;
    }

    public int hashCode() {
        return (((((this.bitRate * 31) + this.codec) * 31) + this.bitDepth) * 31) + this.fps;
    }

    public String toString() {
        return "RecommendedProfile(bitRate=" + this.bitRate + ", codec=" + this.codec + ", bitDepth=" + this.bitDepth + ", fps=" + this.fps + ")";
    }

    public RecommendedProfile(int i, int i2, int i3, int i4) {
        this.bitRate = i;
        this.codec = i2;
        this.bitDepth = i3;
        this.fps = i4;
    }

    public final int getBitRate() {
        return this.bitRate;
    }

    public final int getCodec() {
        return this.codec;
    }

    public final int getBitDepth() {
        return this.bitDepth;
    }

    public final int getFps() {
        return this.fps;
    }
}
