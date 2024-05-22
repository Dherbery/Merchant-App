package com.mrousavy.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.mrousavy.camera.core.CameraError;
import com.mrousavy.camera.core.CameraErrorKt;
import com.mrousavy.camera.core.CodeScannerFrame;
import com.mrousavy.camera.core.UnknownCameraError;
import com.mrousavy.camera.types.CameraCodeScannedEvent;
import com.mrousavy.camera.types.CameraErrorEvent;
import com.mrousavy.camera.types.CameraInitializedEvent;
import com.mrousavy.camera.types.CameraStartedEvent;
import com.mrousavy.camera.types.CameraStoppedEvent;
import com.mrousavy.camera.types.CameraViewReadyEvent;
import com.mrousavy.camera.types.CodeType;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraView+Events.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a \u0010\u0004\u001a\u00020\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u0010\f\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\r\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u000e\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u000f\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u0010\u001a\u00020\u0005*\u00020\u0006\u001a\u0018\u0010\u0011\u001a\u00020\u0005*\u00020\u00062\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002¨\u0006\u0014"}, d2 = {"errorToMap", "Lcom/facebook/react/bridge/WritableMap;", "error", "", "invokeOnCodeScanned", "", "Lcom/mrousavy/camera/CameraView;", "barcodes", "", "Lcom/google/mlkit/vision/barcode/common/Barcode;", "scannerFrame", "Lcom/mrousavy/camera/core/CodeScannerFrame;", "invokeOnError", "invokeOnInitialized", "invokeOnStarted", "invokeOnStopped", "invokeOnViewReady", "sendEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/facebook/react/uimanager/events/Event;", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraView_EventsKt {
    public static final void invokeOnInitialized(CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Log.i("CameraView", "invokeOnInitialized()");
        sendEvent(cameraView, new CameraInitializedEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnStarted(CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Log.i("CameraView", "invokeOnStarted()");
        sendEvent(cameraView, new CameraStartedEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnStopped(CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Log.i("CameraView", "invokeOnStopped()");
        sendEvent(cameraView, new CameraStoppedEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnError(CameraView cameraView, Throwable error) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(error, "error");
        Log.e("CameraView", "invokeOnError(...):");
        error.printStackTrace();
        UnknownCameraError unknownCameraError = error instanceof CameraError ? (CameraError) error : new UnknownCameraError(error);
        WritableMap data = Arguments.createMap();
        data.putString("code", CameraErrorKt.getCode(unknownCameraError));
        data.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, unknownCameraError.getMessage());
        Throwable cause = unknownCameraError.getCause();
        if (cause != null) {
            data.putMap("cause", errorToMap(cause));
        }
        int surfaceId = UIManagerHelper.getSurfaceId(cameraView);
        int id = cameraView.getId();
        Intrinsics.checkNotNullExpressionValue(data, "data");
        sendEvent(cameraView, new CameraErrorEvent(surfaceId, id, data));
    }

    public static final void invokeOnViewReady(CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        sendEvent(cameraView, new CameraViewReadyEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnCodeScanned(CameraView cameraView, List<? extends Barcode> barcodes, CodeScannerFrame scannerFrame) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(barcodes, "barcodes");
        Intrinsics.checkNotNullParameter(scannerFrame, "scannerFrame");
        WritableArray createArray = Arguments.createArray();
        for (Barcode barcode : barcodes) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("type", CodeType.INSTANCE.fromBarcodeType(barcode.getFormat()).getUnionValue());
            createMap.putString("value", barcode.getRawValue());
            Rect boundingBox = barcode.getBoundingBox();
            if (boundingBox != null) {
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putInt("x", boundingBox.left);
                createMap2.putInt("y", boundingBox.top);
                createMap2.putInt("width", boundingBox.right - boundingBox.left);
                createMap2.putInt("height", boundingBox.bottom - boundingBox.top);
                createMap.putMap("frame", createMap2);
            }
            Point[] points = barcode.getCornerPoints();
            if (points != null) {
                WritableArray createArray2 = Arguments.createArray();
                Intrinsics.checkNotNullExpressionValue(points, "points");
                for (Point point : points) {
                    WritableMap createMap3 = Arguments.createMap();
                    createMap3.putInt("x", point.x);
                    createMap3.putInt("y", point.y);
                    createArray2.pushMap(createMap3);
                }
                createMap.putArray("corners", createArray2);
            }
            createArray.pushMap(createMap);
        }
        WritableMap data = Arguments.createMap();
        data.putArray("codes", createArray);
        WritableMap createMap4 = Arguments.createMap();
        createMap4.putInt("width", scannerFrame.getWidth());
        createMap4.putInt("height", scannerFrame.getHeight());
        data.putMap("frame", createMap4);
        int surfaceId = UIManagerHelper.getSurfaceId(cameraView);
        int id = cameraView.getId();
        Intrinsics.checkNotNullExpressionValue(data, "data");
        sendEvent(cameraView, new CameraCodeScannedEvent(surfaceId, id, data));
    }

    private static final void sendEvent(CameraView cameraView, Event<?> event) {
        Context context = cameraView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, cameraView.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(event);
        }
    }

    private static final WritableMap errorToMap(Throwable th) {
        WritableMap map = Arguments.createMap();
        map.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, th.getMessage());
        map.putString("stacktrace", ExceptionsKt.stackTraceToString(th));
        Throwable cause = th.getCause();
        if (cause != null) {
            map.putMap("cause", errorToMap(cause));
        }
        Intrinsics.checkNotNullExpressionValue(map, "map");
        return map;
    }
}
