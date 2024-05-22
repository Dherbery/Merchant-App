package com.mrousavy.camera.types;

import kotlin.Metadata;

/* compiled from: DeviceType.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/types/DeviceType;", "", "Lcom/mrousavy/camera/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "ULTRA_WIDE_ANGLE", "WIDE_ANGLE", "TELEPHOTO", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum DeviceType implements JSUnionValue {
    ULTRA_WIDE_ANGLE("ultra-wide-angle-camera"),
    WIDE_ANGLE("wide-angle-camera"),
    TELEPHOTO("telephoto-camera");

    private final String unionValue;

    DeviceType(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }
}
