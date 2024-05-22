package com.mrousavy.camera.types;

import com.facebook.react.uimanager.ViewProps;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import com.mrousavy.camera.types.JSUnionValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResizeMode.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/types/ResizeMode;", "", "Lcom/mrousavy/camera/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "COVER", "CONTAIN", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum ResizeMode implements JSUnionValue {
    COVER("cover"),
    CONTAIN("contain");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String unionValue;

    ResizeMode(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    /* compiled from: ResizeMode.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/types/ResizeMode$Companion;", "Lcom/mrousavy/camera/types/JSUnionValue$Companion;", "Lcom/mrousavy/camera/types/ResizeMode;", "()V", "fromUnionValue", "unionValue", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion implements JSUnionValue.Companion<ResizeMode> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.types.JSUnionValue.Companion
        public ResizeMode fromUnionValue(String unionValue) {
            if (Intrinsics.areEqual(unionValue, "cover")) {
                return ResizeMode.COVER;
            }
            if (Intrinsics.areEqual(unionValue, "contain")) {
                return ResizeMode.CONTAIN;
            }
            throw new InvalidTypeScriptUnionError(ViewProps.RESIZE_MODE, unionValue);
        }
    }
}
