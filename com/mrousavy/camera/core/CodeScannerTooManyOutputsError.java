package com.mrousavy.camera.core;

import kotlin.Metadata;

/* compiled from: CameraError.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mrousavy/camera/core/CodeScannerTooManyOutputsError;", "Lcom/mrousavy/camera/core/CameraError;", "()V", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CodeScannerTooManyOutputsError extends CameraError {
    public CodeScannerTooManyOutputsError() {
        super("code-scanner", "not-compatible-with-outputs", "CodeScanner can only be enabled when both video and frameProcessor are disabled! Use a Frame Processor Plugin for code scanning instead.", null, 8, null);
    }
}
