package com.mrousavy.camera;

import androidx.core.content.ContextCompat;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.mrousavy.camera.core.CameraError;
import com.mrousavy.camera.core.CameraErrorKt;
import com.mrousavy.camera.core.MicrophonePermissionError;
import com.mrousavy.camera.core.RecordingSession;
import com.mrousavy.camera.types.RecordVideoOptions;
import com.mrousavy.camera.utils.CallbackPromiseKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraView+RecordVideo.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a%\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"pauseRecording", "", "Lcom/mrousavy/camera/CameraView;", "(Lcom/mrousavy/camera/CameraView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resumeRecording", "startRecording", "options", "Lcom/mrousavy/camera/types/RecordVideoOptions;", "onRecordCallback", "Lcom/facebook/react/bridge/Callback;", "(Lcom/mrousavy/camera/CameraView;Lcom/mrousavy/camera/types/RecordVideoOptions;Lcom/facebook/react/bridge/Callback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopRecording", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraView_RecordVideoKt {
    public static final Object startRecording(CameraView cameraView, RecordVideoOptions recordVideoOptions, final Callback callback, Continuation<? super Unit> continuation) {
        if (cameraView.getAudio() && ContextCompat.checkSelfPermission(cameraView.getContext(), "android.permission.RECORD_AUDIO") != 0) {
            throw new MicrophonePermissionError();
        }
        Object startRecording = cameraView.getCameraSession().startRecording(cameraView.getAudio(), recordVideoOptions, new Function1<RecordingSession.Video, Unit>() { // from class: com.mrousavy.camera.CameraView_RecordVideoKt$startRecording$callback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecordingSession.Video video) {
                invoke2(video);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RecordingSession.Video video) {
                Intrinsics.checkNotNullParameter(video, "video");
                WritableMap createMap = Arguments.createMap();
                createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, video.getPath());
                createMap.putDouble("duration", video.getDurationMs() / 1000.0d);
                createMap.putInt("width", video.getSize().getWidth());
                createMap.putInt("height", video.getSize().getHeight());
                Callback.this.invoke(createMap, null);
            }
        }, new Function1<CameraError, Unit>() { // from class: com.mrousavy.camera.CameraView_RecordVideoKt$startRecording$onError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CameraError cameraError) {
                invoke2(cameraError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CameraError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Callback.this.invoke(null, CallbackPromiseKt.makeErrorMap$default(CameraErrorKt.getCode(error), error.getMessage(), null, null, 12, null));
            }
        }, continuation);
        return startRecording == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? startRecording : Unit.INSTANCE;
    }

    public static final Object pauseRecording(CameraView cameraView, Continuation<? super Unit> continuation) {
        Object pauseRecording = cameraView.getCameraSession().pauseRecording(continuation);
        return pauseRecording == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? pauseRecording : Unit.INSTANCE;
    }

    public static final Object resumeRecording(CameraView cameraView, Continuation<? super Unit> continuation) {
        Object resumeRecording = cameraView.getCameraSession().resumeRecording(continuation);
        return resumeRecording == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? resumeRecording : Unit.INSTANCE;
    }

    public static final Object stopRecording(CameraView cameraView, Continuation<? super Unit> continuation) {
        Object stopRecording = cameraView.getCameraSession().stopRecording(continuation);
        return stopRecording == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? stopRecording : Unit.INSTANCE;
    }
}
