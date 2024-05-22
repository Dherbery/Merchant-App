package com.mrousavy.camera;

import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: CameraView+Focus.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"focus", "", "Lcom/mrousavy/camera/CameraView;", "pointMap", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/mrousavy/camera/CameraView;Lcom/facebook/react/bridge/ReadableMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraView_FocusKt {
    public static final Object focus(CameraView cameraView, ReadableMap readableMap, Continuation<? super Unit> continuation) {
        Object focus = cameraView.getCameraSession().focus(readableMap.getInt("x"), readableMap.getInt("y"), continuation);
        return focus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? focus : Unit.INSTANCE;
    }
}
