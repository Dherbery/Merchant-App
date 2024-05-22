package com.mrousavy.camera.frameprocessor;

import android.hardware.HardwareBuffer;
import android.media.Image;
import android.os.Build;
import com.mrousavy.camera.core.FrameInvalidError;
import com.mrousavy.camera.core.HardwareBuffersNotAvailableError;
import com.mrousavy.camera.types.Orientation;
import com.mrousavy.camera.types.PixelFormat;

/* loaded from: classes5.dex */
public class Frame {
    private final Image image;
    private final boolean isMirrored;
    private final Orientation orientation;
    private int refCount = 0;
    private final long timestamp;

    public Frame(Image image, long j, Orientation orientation, boolean z) {
        this.image = image;
        this.timestamp = j;
        this.orientation = orientation;
        this.isMirrored = z;
    }

    private void assertIsValid() throws FrameInvalidError {
        if (!getIsImageValid(this.image)) {
            throw new FrameInvalidError();
        }
    }

    private synchronized boolean getIsImageValid(Image image) {
        if (this.refCount <= 0) {
            return false;
        }
        try {
            image.getFormat();
            return true;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public synchronized Image getImage() {
        return this.image;
    }

    public synchronized int getWidth() throws FrameInvalidError {
        assertIsValid();
        return this.image.getWidth();
    }

    public synchronized int getHeight() throws FrameInvalidError {
        assertIsValid();
        return this.image.getHeight();
    }

    public synchronized boolean getIsValid() throws FrameInvalidError {
        assertIsValid();
        return getIsImageValid(this.image);
    }

    public synchronized boolean getIsMirrored() throws FrameInvalidError {
        assertIsValid();
        return this.isMirrored;
    }

    public synchronized long getTimestamp() throws FrameInvalidError {
        assertIsValid();
        return this.timestamp;
    }

    public synchronized Orientation getOrientation() throws FrameInvalidError {
        assertIsValid();
        return this.orientation;
    }

    public synchronized PixelFormat getPixelFormat() throws FrameInvalidError {
        assertIsValid();
        return PixelFormat.INSTANCE.fromImageFormat(this.image.getFormat());
    }

    public synchronized int getPlanesCount() throws FrameInvalidError {
        assertIsValid();
        return this.image.getPlanes().length;
    }

    public synchronized int getBytesPerRow() throws FrameInvalidError {
        assertIsValid();
        return this.image.getPlanes()[0].getRowStride();
    }

    private Object getHardwareBufferBoxed() throws HardwareBuffersNotAvailableError, FrameInvalidError {
        return getHardwareBuffer();
    }

    public synchronized HardwareBuffer getHardwareBuffer() throws HardwareBuffersNotAvailableError, FrameInvalidError {
        HardwareBuffer hardwareBuffer;
        if (Build.VERSION.SDK_INT < 28) {
            throw new HardwareBuffersNotAvailableError();
        }
        assertIsValid();
        hardwareBuffer = this.image.getHardwareBuffer();
        return hardwareBuffer;
    }

    public synchronized void incrementRefCount() {
        this.refCount++;
    }

    public synchronized void decrementRefCount() {
        int i = this.refCount - 1;
        this.refCount = i;
        if (i <= 0) {
            close();
        }
    }

    private synchronized void close() {
        this.image.close();
    }
}
