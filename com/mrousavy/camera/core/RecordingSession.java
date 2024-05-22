package com.mrousavy.camera.core;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.core.os.EnvironmentCompat;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.common.statfs.StatFsHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.mrousavy.camera.extensions.RecordingSession_getRecommendedBitRateKt;
import com.mrousavy.camera.types.Orientation;
import com.mrousavy.camera.types.RecordVideoOptions;
import com.mrousavy.camera.utils.FileUtils;
import com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0;
import expo.modules.kotlin.types.LazyKType$$ExternalSyntheticBackport0;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecordingSession.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 42\u00020\u0001:\u000245B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0012\u0012!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0012¢\u0006\u0002\u0010\u001bJ\b\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020'H\u0002J\u0006\u0010/\u001a\u00020\u0017J\u0006\u00100\u001a\u00020\u0017J\u0006\u00101\u001a\u00020\u0017J\u0006\u00102\u001a\u00020\u0017J\b\u00103\u001a\u00020\u0005H\u0016R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u00066"}, d2 = {"Lcom/mrousavy/camera/core/RecordingSession;", "", "context", "Landroid/content/Context;", "cameraId", "", "size", "Landroid/util/Size;", "enableAudio", "", "fps", "", "hdr", "orientation", "Lcom/mrousavy/camera/types/Orientation;", "options", "Lcom/mrousavy/camera/types/RecordVideoOptions;", "callback", "Lkotlin/Function1;", "Lcom/mrousavy/camera/core/RecordingSession$Video;", "Lkotlin/ParameterName;", "name", "video", "", "onError", "Lcom/mrousavy/camera/core/CameraError;", "error", "(Landroid/content/Context;Ljava/lang/String;Landroid/util/Size;ZLjava/lang/Integer;ZLcom/mrousavy/camera/types/Orientation;Lcom/mrousavy/camera/types/RecordVideoOptions;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "bitRate", "getCameraId", "()Ljava/lang/String;", "Ljava/lang/Integer;", "outputFile", "Ljava/io/File;", "recorder", "Landroid/media/MediaRecorder;", "getSize", "()Landroid/util/Size;", "startTime", "", "Ljava/lang/Long;", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "getBitRate", "getMaxFileSize", "pause", "resume", "start", "stop", "toString", "Companion", "Video", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecordingSession {
    private static final int AUDIO_BIT_RATE = 705600;
    private static final int AUDIO_CHANNELS = 1;
    private static final int AUDIO_SAMPLING_RATE = 44100;
    private static final String TAG = "RecordingSession";
    private final int bitRate;
    private final Function1<Video, Unit> callback;
    private final String cameraId;
    private final boolean enableAudio;
    private final Integer fps;
    private final boolean hdr;
    private final Function1<CameraError, Unit> onError;
    private final RecordVideoOptions options;
    private final Orientation orientation;
    private final File outputFile;
    private final MediaRecorder recorder;
    private final Size size;
    private Long startTime;
    private final Surface surface;

    /* JADX WARN: Multi-variable type inference failed */
    public RecordingSession(Context context, String cameraId, Size size, boolean z, Integer num, boolean z2, Orientation orientation, RecordVideoOptions options, Function1<? super Video, Unit> callback, Function1<? super CameraError, Unit> onError) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.cameraId = cameraId;
        this.size = size;
        this.enableAudio = z;
        this.fps = num;
        this.hdr = z2;
        this.orientation = orientation;
        this.options = options;
        this.callback = callback;
        this.onError = onError;
        int bitRate = getBitRate();
        this.bitRate = bitRate;
        Surface createPersistentInputSurface = MediaCodec.createPersistentInputSurface();
        Intrinsics.checkNotNullExpressionValue(createPersistentInputSurface, "createPersistentInputSurface()");
        this.surface = createPersistentInputSurface;
        File createTempFile = FileUtils.INSTANCE.createTempFile(context, options.getFileType().toExtension());
        this.outputFile = createTempFile;
        Log.i(TAG, "Creating RecordingSession for " + createTempFile.getAbsolutePath());
        MediaRecorder m = Build.VERSION.SDK_INT >= 31 ? Downloader$$ExternalSyntheticApiModelOutline0.m(context) : new MediaRecorder();
        this.recorder = m;
        if (z) {
            m.setAudioSource(5);
        }
        m.setVideoSource(2);
        m.setOutputFormat(2);
        m.setOutputFile(createTempFile.getAbsolutePath());
        m.setVideoEncodingBitRate(bitRate);
        m.setVideoSize(size.getHeight(), size.getWidth());
        m.setMaxFileSize(getMaxFileSize());
        if (num != null) {
            m.setVideoFrameRate(num.intValue());
        }
        Log.i(TAG, "Using " + options.getVideoCodec() + " Video Codec at " + (bitRate / 1000000.0d) + " Mbps..");
        m.setVideoEncoder(options.getVideoCodec().toVideoEncoder());
        if (z) {
            Log.i(TAG, "Adding Audio Channel..");
            m.setAudioEncoder(3);
            m.setAudioEncodingBitRate(AUDIO_BIT_RATE);
            m.setAudioSamplingRate(AUDIO_SAMPLING_RATE);
            m.setAudioChannels(1);
        }
        m.setInputSurface(createPersistentInputSurface);
        m.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.mrousavy.camera.core.RecordingSession$$ExternalSyntheticLambda1
            @Override // android.media.MediaRecorder.OnErrorListener
            public final void onError(MediaRecorder mediaRecorder, int i, int i2) {
                RecordingSession._init_$lambda$0(RecordingSession.this, mediaRecorder, i, i2);
            }
        });
        m.setOnInfoListener(new MediaRecorder.OnInfoListener() { // from class: com.mrousavy.camera.core.RecordingSession$$ExternalSyntheticLambda2
            @Override // android.media.MediaRecorder.OnInfoListener
            public final void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
                RecordingSession._init_$lambda$1(RecordingSession.this, mediaRecorder, i, i2);
            }
        });
        Log.i(TAG, "Created " + this + "!");
    }

    public /* synthetic */ RecordingSession(Context context, String str, Size size, boolean z, Integer num, boolean z2, Orientation orientation, RecordVideoOptions recordVideoOptions, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, size, z, (i & 16) != 0 ? null : num, (i & 32) != 0 ? false : z2, orientation, recordVideoOptions, function1, function12);
    }

    public final String getCameraId() {
        return this.cameraId;
    }

    public final Size getSize() {
        return this.size;
    }

    /* compiled from: RecordingSession.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/mrousavy/camera/core/RecordingSession$Video;", "", ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, "", "durationMs", "", "size", "Landroid/util/Size;", "(Ljava/lang/String;JLandroid/util/Size;)V", "getDurationMs", "()J", "getPath", "()Ljava/lang/String;", "getSize", "()Landroid/util/Size;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Video {
        private final long durationMs;
        private final String path;
        private final Size size;

        public static /* synthetic */ Video copy$default(Video video, String str, long j, Size size, int i, Object obj) {
            if ((i & 1) != 0) {
                str = video.path;
            }
            if ((i & 2) != 0) {
                j = video.durationMs;
            }
            if ((i & 4) != 0) {
                size = video.size;
            }
            return video.copy(str, j, size);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        /* renamed from: component2, reason: from getter */
        public final long getDurationMs() {
            return this.durationMs;
        }

        /* renamed from: component3, reason: from getter */
        public final Size getSize() {
            return this.size;
        }

        public final Video copy(String path, long durationMs, Size size) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(size, "size");
            return new Video(path, durationMs, size);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Video)) {
                return false;
            }
            Video video = (Video) other;
            return Intrinsics.areEqual(this.path, video.path) && this.durationMs == video.durationMs && Intrinsics.areEqual(this.size, video.size);
        }

        public int hashCode() {
            return (((this.path.hashCode() * 31) + LazyKType$$ExternalSyntheticBackport0.m(this.durationMs)) * 31) + this.size.hashCode();
        }

        public String toString() {
            return "Video(path=" + this.path + ", durationMs=" + this.durationMs + ", size=" + this.size + ")";
        }

        public Video(String path, long j, Size size) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(size, "size");
            this.path = path;
            this.durationMs = j;
            this.size = size;
        }

        public final long getDurationMs() {
            return this.durationMs;
        }

        public final String getPath() {
            return this.path;
        }

        public final Size getSize() {
            return this.size;
        }
    }

    public final Surface getSurface() {
        return this.surface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(RecordingSession this$0, MediaRecorder mediaRecorder, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.e(TAG, "MediaRecorder Error: " + i + " (" + i2 + ")");
        this$0.stop();
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        if (i != 1 && i == 100) {
            str = "server-died";
        }
        this$0.onError.invoke(new RecorderError(str, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(RecordingSession this$0, MediaRecorder mediaRecorder, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.i(TAG, "MediaRecorder Info: " + i + " (" + i2 + ")");
        if (i == 801) {
            this$0.onError.invoke(new InsufficientStorageError());
        }
    }

    public final void start() {
        synchronized (this) {
            Log.i(TAG, "Starting RecordingSession..");
            this.recorder.prepare();
            this.recorder.start();
            this.startTime = Long.valueOf(System.currentTimeMillis());
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void stop() {
        synchronized (this) {
            Log.i(TAG, "Stopping RecordingSession..");
            try {
                this.recorder.stop();
                this.recorder.release();
            } catch (Error e) {
                Log.e(TAG, "Failed to stop MediaRecorder!", e);
            }
            long currentTimeMillis = System.currentTimeMillis();
            Long l = this.startTime;
            long longValue = currentTimeMillis - (l != null ? l.longValue() : currentTimeMillis);
            Function1<Video, Unit> function1 = this.callback;
            String absolutePath = this.outputFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "outputFile.absolutePath");
            function1.invoke(new Video(absolutePath, longValue, this.size));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void pause() {
        synchronized (this) {
            Log.i(TAG, "Pausing Recording Session..");
            this.recorder.pause();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void resume() {
        synchronized (this) {
            Log.i(TAG, "Resuming Recording Session..");
            this.recorder.resume();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final int getBitRate() {
        Integer num = this.fps;
        int recommendedBitRate = RecordingSession_getRecommendedBitRateKt.getRecommendedBitRate(this, num != null ? num.intValue() : 30, this.options.getVideoCodec(), this.hdr);
        Double videoBitRateOverride = this.options.getVideoBitRateOverride();
        if (videoBitRateOverride != null) {
            recommendedBitRate = (int) (videoBitRateOverride.doubleValue() * 1000000);
        }
        Double videoBitRateMultiplier = this.options.getVideoBitRateMultiplier();
        if (videoBitRateMultiplier != null) {
            return (int) (recommendedBitRate * videoBitRateMultiplier.doubleValue());
        }
        return recommendedBitRate;
    }

    private final long getMaxFileSize() {
        StatFsHelper statFsHelper = StatFsHelper.getInstance();
        Intrinsics.checkNotNullExpressionValue(statFsHelper, "getInstance()");
        long availableStorageSpace = statFsHelper.getAvailableStorageSpace(StatFsHelper.StorageType.INTERNAL);
        Log.i(TAG, "Maximum available storage space: " + (availableStorageSpace / 1000) + " kB");
        return availableStorageSpace;
    }

    public String toString() {
        String str = this.enableAudio ? "with audio" : "without audio";
        return this.size.getWidth() + " x " + this.size.getHeight() + " @ " + this.fps + " FPS " + this.options.getVideoCodec() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.options.getFileType() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.orientation + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + (this.bitRate / 1000000.0d) + " Mbps RecordingSession (" + str + ")";
    }
}
