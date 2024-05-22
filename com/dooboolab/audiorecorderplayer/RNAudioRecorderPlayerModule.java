package com.dooboolab.audiorecorderplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.PermissionListener;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RNAudioRecorderPlayerModule.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001f\u001a\u00020\tH\u0016J+\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0#2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010+\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010,\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010-\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0018\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\u0006\u0010)\u001a\u00020*H\u0007J\"\u00101\u001a\u00020(2\u0006\u0010\u0003\u001a\u0002022\u0006\u00103\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u000105H\u0002J\u0018\u00106\u001a\u00020(2\u0006\u00107\u001a\u0002002\u0006\u0010)\u001a\u00020*H\u0007J\u0018\u00108\u001a\u00020(2\u0006\u00109\u001a\u0002002\u0006\u0010)\u001a\u00020*H\u0007J\"\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010)\u001a\u00020*H\u0007J*\u0010>\u001a\u00020(2\u0006\u0010;\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010=2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010A\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010B\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/dooboolab/audiorecorderplayer/RNAudioRecorderPlayerModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "Lcom/facebook/react/modules/core/PermissionListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "_meteringEnabled", "", "audioFileURL", "", "mTask", "Ljava/util/TimerTask;", "mTimer", "Ljava/util/Timer;", "mediaPlayer", "Landroid/media/MediaPlayer;", "mediaRecorder", "Landroid/media/MediaRecorder;", "pausedRecordTime", "", "recordHandler", "Landroid/os/Handler;", "getRecordHandler", "()Landroid/os/Handler;", "setRecordHandler", "(Landroid/os/Handler;)V", "recorderRunnable", "Ljava/lang/Runnable;", "subsDurationMillis", "", "totalPausedRecordTime", "getName", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)Z", "pausePlayer", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "pauseRecorder", "resumePlayer", "resumeRecorder", "seekToPlayer", "time", "", "sendEvent", "Lcom/facebook/react/bridge/ReactContext;", "eventName", OutcomeEventsTable.COLUMN_NAME_PARAMS, "Lcom/facebook/react/bridge/WritableMap;", "setSubscriptionDuration", "sec", "setVolume", "volume", "startPlayer", ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, "httpHeaders", "Lcom/facebook/react/bridge/ReadableMap;", "startRecorder", "audioSet", "meteringEnabled", "stopPlayer", "stopRecorder", "Companion", "react-native-audio-recorder-player_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RNAudioRecorderPlayerModule extends ReactContextBaseJavaModule implements PermissionListener {
    private boolean _meteringEnabled;
    private String audioFileURL;
    private TimerTask mTask;
    private Timer mTimer;
    private MediaPlayer mediaPlayer;
    private MediaRecorder mediaRecorder;
    private long pausedRecordTime;
    private final ReactApplicationContext reactContext;
    private Handler recordHandler;
    private Runnable recorderRunnable;
    private int subsDurationMillis;
    private long totalPausedRecordTime;
    private static String tag = "RNAudioRecorderPlayer";
    private static String defaultFileName = "sound.mp4";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNAudioRecorderPlayerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.audioFileURL = "";
        this.subsDurationMillis = 500;
        this.recordHandler = new Handler(Looper.getMainLooper());
    }

    public final Handler getRecordHandler() {
        return this.recordHandler;
    }

    public final void setRecordHandler(Handler handler) {
        this.recordHandler = handler;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return tag;
    }

    @ReactMethod
    public final void startRecorder(String path, ReadableMap audioSet, boolean meteringEnabled, Promise promise) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            if (Build.VERSION.SDK_INT < 29 && (ActivityCompat.checkSelfPermission(this.reactContext, "android.permission.RECORD_AUDIO") != 0 || ActivityCompat.checkSelfPermission(this.reactContext, "android.permission.WRITE_EXTERNAL_STORAGE") != 0)) {
                Activity currentActivity = getCurrentActivity();
                Intrinsics.checkNotNull(currentActivity);
                ActivityCompat.requestPermissions(currentActivity, new String[]{"android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
                promise.reject("No permission granted.", "Try again after adding permission.");
                return;
            }
            if (ActivityCompat.checkSelfPermission(this.reactContext, "android.permission.RECORD_AUDIO") != 0) {
                Activity currentActivity2 = getCurrentActivity();
                Intrinsics.checkNotNull(currentActivity2);
                ActivityCompat.requestPermissions(currentActivity2, new String[]{"android.permission.RECORD_AUDIO"}, 0);
                promise.reject("No permission granted.", "Try again after adding permission.");
                return;
            }
            if (Intrinsics.areEqual(path, "DEFAULT")) {
                path = this.reactContext.getCacheDir() + "/" + defaultFileName;
            }
            this.audioFileURL = path;
            this._meteringEnabled = meteringEnabled;
            if (this.mediaRecorder == null) {
                this.mediaRecorder = new MediaRecorder();
            }
            int i = OpusUtil.SAMPLE_RATE;
            if (audioSet != null) {
                MediaRecorder mediaRecorder = this.mediaRecorder;
                Intrinsics.checkNotNull(mediaRecorder);
                mediaRecorder.setAudioSource(audioSet.hasKey("AudioSourceAndroid") ? audioSet.getInt("AudioSourceAndroid") : 1);
                MediaRecorder mediaRecorder2 = this.mediaRecorder;
                Intrinsics.checkNotNull(mediaRecorder2);
                mediaRecorder2.setOutputFormat(audioSet.hasKey("OutputFormatAndroid") ? audioSet.getInt("OutputFormatAndroid") : 2);
                MediaRecorder mediaRecorder3 = this.mediaRecorder;
                Intrinsics.checkNotNull(mediaRecorder3);
                mediaRecorder3.setAudioEncoder(audioSet.hasKey("AudioEncoderAndroid") ? audioSet.getInt("AudioEncoderAndroid") : 3);
                MediaRecorder mediaRecorder4 = this.mediaRecorder;
                Intrinsics.checkNotNull(mediaRecorder4);
                if (audioSet.hasKey("AudioSamplingRateAndroid")) {
                    i = audioSet.getInt("AudioSamplingRateAndroid");
                }
                mediaRecorder4.setAudioSamplingRate(i);
                MediaRecorder mediaRecorder5 = this.mediaRecorder;
                Intrinsics.checkNotNull(mediaRecorder5);
                mediaRecorder5.setAudioEncodingBitRate(audioSet.hasKey("AudioEncodingBitRateAndroid") ? audioSet.getInt("AudioEncodingBitRateAndroid") : 128000);
                MediaRecorder mediaRecorder6 = this.mediaRecorder;
                Intrinsics.checkNotNull(mediaRecorder6);
                mediaRecorder6.setAudioChannels(audioSet.hasKey("AudioChannelsAndroid") ? audioSet.getInt("AudioChannelsAndroid") : 2);
            } else {
                MediaRecorder mediaRecorder7 = this.mediaRecorder;
                Intrinsics.checkNotNull(mediaRecorder7);
                mediaRecorder7.setAudioSource(1);
                MediaRecorder mediaRecorder8 = this.mediaRecorder;
                Intrinsics.checkNotNull(mediaRecorder8);
                mediaRecorder8.setOutputFormat(2);
                MediaRecorder mediaRecorder9 = this.mediaRecorder;
                Intrinsics.checkNotNull(mediaRecorder9);
                mediaRecorder9.setAudioEncoder(3);
                MediaRecorder mediaRecorder10 = this.mediaRecorder;
                Intrinsics.checkNotNull(mediaRecorder10);
                mediaRecorder10.setAudioEncodingBitRate(128000);
                MediaRecorder mediaRecorder11 = this.mediaRecorder;
                Intrinsics.checkNotNull(mediaRecorder11);
                mediaRecorder11.setAudioSamplingRate(OpusUtil.SAMPLE_RATE);
            }
            MediaRecorder mediaRecorder12 = this.mediaRecorder;
            Intrinsics.checkNotNull(mediaRecorder12);
            mediaRecorder12.setOutputFile(this.audioFileURL);
            try {
                MediaRecorder mediaRecorder13 = this.mediaRecorder;
                Intrinsics.checkNotNull(mediaRecorder13);
                mediaRecorder13.prepare();
                this.totalPausedRecordTime = 0L;
                MediaRecorder mediaRecorder14 = this.mediaRecorder;
                Intrinsics.checkNotNull(mediaRecorder14);
                mediaRecorder14.start();
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                Runnable runnable = new Runnable() { // from class: com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule$startRecorder$1
                    @Override // java.lang.Runnable
                    public void run() {
                        long j;
                        boolean z;
                        ReactApplicationContext reactApplicationContext;
                        int i2;
                        MediaRecorder mediaRecorder15;
                        int i3;
                        MediaRecorder mediaRecorder16;
                        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                        j = this.totalPausedRecordTime;
                        long j2 = elapsedRealtime2 - j;
                        WritableMap createMap = Arguments.createMap();
                        createMap.putDouble("currentPosition", j2);
                        z = this._meteringEnabled;
                        if (z) {
                            mediaRecorder15 = this.mediaRecorder;
                            if (mediaRecorder15 != null) {
                                mediaRecorder16 = this.mediaRecorder;
                                Intrinsics.checkNotNull(mediaRecorder16);
                                i3 = mediaRecorder16.getMaxAmplitude();
                            } else {
                                i3 = 0;
                            }
                            createMap.putInt("currentMetering", (int) (i3 > 0 ? 20 * Math.log10(i3 / 32767.0d) : -160.0d));
                        }
                        RNAudioRecorderPlayerModule rNAudioRecorderPlayerModule = this;
                        reactApplicationContext = rNAudioRecorderPlayerModule.reactContext;
                        rNAudioRecorderPlayerModule.sendEvent(reactApplicationContext, "rn-recordback", createMap);
                        Handler recordHandler = this.getRecordHandler();
                        Intrinsics.checkNotNull(recordHandler);
                        i2 = this.subsDurationMillis;
                        recordHandler.postDelayed(this, i2);
                    }
                };
                this.recorderRunnable = runnable;
                Intrinsics.checkNotNull(runnable, "null cannot be cast to non-null type java.lang.Runnable");
                runnable.run();
                promise.resolve("file:///" + this.audioFileURL);
            } catch (Exception e) {
                Log.e(tag, "Exception: ", e);
                promise.reject("startRecord", e.getMessage());
            }
        } catch (NullPointerException e2) {
            Log.w(tag, e2.toString());
            promise.reject("No permission granted.", "Try again after adding permission.");
        }
    }

    @ReactMethod
    public final void resumeRecorder(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        MediaRecorder mediaRecorder = this.mediaRecorder;
        if (mediaRecorder == null) {
            promise.reject("resumeReocrder", "Recorder is null.");
            return;
        }
        try {
            Intrinsics.checkNotNull(mediaRecorder);
            mediaRecorder.resume();
            this.totalPausedRecordTime += SystemClock.elapsedRealtime() - this.pausedRecordTime;
            Runnable runnable = this.recorderRunnable;
            if (runnable != null) {
                Handler handler = this.recordHandler;
                Intrinsics.checkNotNull(handler);
                handler.postDelayed(runnable, this.subsDurationMillis);
            }
            promise.resolve("Recorder resumed.");
        } catch (Exception e) {
            Log.e(tag, "Recorder resume: " + e.getMessage());
            promise.reject("resumeRecorder", e.getMessage());
        }
    }

    @ReactMethod
    public final void pauseRecorder(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        MediaRecorder mediaRecorder = this.mediaRecorder;
        if (mediaRecorder == null) {
            promise.reject("pauseRecorder", "Recorder is null.");
            return;
        }
        try {
            Intrinsics.checkNotNull(mediaRecorder);
            mediaRecorder.pause();
            this.pausedRecordTime = SystemClock.elapsedRealtime();
            Runnable runnable = this.recorderRunnable;
            if (runnable != null) {
                Handler handler = this.recordHandler;
                Intrinsics.checkNotNull(handler);
                handler.removeCallbacks(runnable);
            }
            promise.resolve("Recorder paused.");
        } catch (Exception e) {
            Log.e(tag, "pauseRecorder exception: " + e.getMessage());
            promise.reject("pauseRecorder", e.getMessage());
        }
    }

    @ReactMethod
    public final void stopRecorder(Promise promise) {
        Runnable runnable;
        Intrinsics.checkNotNullParameter(promise, "promise");
        Handler handler = this.recordHandler;
        if (handler != null && (runnable = this.recorderRunnable) != null) {
            Intrinsics.checkNotNull(handler);
            handler.removeCallbacks(runnable);
        }
        MediaRecorder mediaRecorder = this.mediaRecorder;
        if (mediaRecorder == null) {
            promise.reject("stopRecord", "recorder is null.");
            return;
        }
        try {
            Intrinsics.checkNotNull(mediaRecorder);
            mediaRecorder.stop();
            MediaRecorder mediaRecorder2 = this.mediaRecorder;
            Intrinsics.checkNotNull(mediaRecorder2);
            mediaRecorder2.reset();
            MediaRecorder mediaRecorder3 = this.mediaRecorder;
            Intrinsics.checkNotNull(mediaRecorder3);
            mediaRecorder3.release();
            this.mediaRecorder = null;
            promise.resolve("file:///" + this.audioFileURL);
        } catch (RuntimeException e) {
            String message = e.getMessage();
            if (message != null) {
                Log.d(tag, message);
            }
            promise.reject("stopRecord", e.getMessage());
        }
    }

    @ReactMethod
    public final void setVolume(double volume, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            promise.reject("setVolume", "player is null.");
            return;
        }
        float f = (float) volume;
        Intrinsics.checkNotNull(mediaPlayer);
        mediaPlayer.setVolume(f, f);
        promise.resolve("set volume");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if (r6.getCurrentPosition() > 1) goto L10;
     */
    @com.facebook.react.bridge.ReactMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void startPlayer(final java.lang.String r6, com.facebook.react.bridge.ReadableMap r7, final com.facebook.react.bridge.Promise r8) {
        /*
            r5 = this;
            java.lang.String r0 = "path"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            android.media.MediaPlayer r0 = r5.mediaPlayer
            java.lang.String r1 = "startPlay"
            if (r0 == 0) goto L42
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r6 = r0.isPlaying()
            if (r6 != 0) goto L26
            android.media.MediaPlayer r6 = r5.mediaPlayer
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            int r6 = r6.getCurrentPosition()
            r7 = 1
            if (r6 <= r7) goto L26
            goto L27
        L26:
            r7 = 0
        L27:
            if (r7 == 0) goto L37
            android.media.MediaPlayer r6 = r5.mediaPlayer
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r6.start()
            java.lang.String r6 = "player resumed."
            r8.resolve(r6)
            return
        L37:
            java.lang.String r6 = com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule.tag
            java.lang.String r7 = "Player is already running. Stop it first."
            android.util.Log.e(r6, r7)
            r8.reject(r1, r7)
            return
        L42:
            android.media.MediaPlayer r0 = new android.media.MediaPlayer
            r0.<init>()
            r5.mediaPlayer = r0
            java.lang.String r0 = "DEFAULT"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            if (r0 == 0) goto L76
            android.media.MediaPlayer r7 = r5.mediaPlayer     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            com.facebook.react.bridge.ReactApplicationContext r0 = r5.reactContext     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            java.io.File r0 = r0.getCacheDir()     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            java.lang.String r2 = com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule.defaultFileName     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            r3.<init>()     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            r3.append(r0)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            java.lang.String r0 = "/"
            r3.append(r0)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            r3.append(r2)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            java.lang.String r0 = r3.toString()     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            r7.setDataSource(r0)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            goto Lbf
        L76:
            if (r7 == 0) goto Lb7
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            r0.<init>()     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            java.util.Map r0 = (java.util.Map) r0     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            com.facebook.react.bridge.ReadableMapKeySetIterator r2 = r7.keySetIterator()     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            java.lang.String r3 = "httpHeaders.keySetIterator()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
        L88:
            boolean r3 = r2.hasNextKey()     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            if (r3 == 0) goto L9f
            java.lang.String r3 = r2.nextKey()     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            java.lang.String r4 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            java.lang.String r4 = r7.getString(r3)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            r0.put(r3, r4)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            goto L88
        L9f:
            android.media.MediaPlayer r7 = r5.mediaPlayer     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            android.app.Activity r2 = r5.getCurrentActivity()     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            android.net.Uri r3 = android.net.Uri.parse(r6)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            r7.setDataSource(r2, r3, r0)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            goto Lbf
        Lb7:
            android.media.MediaPlayer r7 = r5.mediaPlayer     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            r7.setDataSource(r6)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
        Lbf:
            android.media.MediaPlayer r7 = r5.mediaPlayer     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule$$ExternalSyntheticLambda2 r0 = new com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule$$ExternalSyntheticLambda2     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            r0.<init>()     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            r7.setOnPreparedListener(r0)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            android.media.MediaPlayer r6 = r5.mediaPlayer     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule$$ExternalSyntheticLambda3 r7 = new com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule$$ExternalSyntheticLambda3     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            r7.<init>()     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            r6.setOnCompletionListener(r7)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            android.media.MediaPlayer r6 = r5.mediaPlayer     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            r6.prepare()     // Catch: java.lang.NullPointerException -> Le2 java.io.IOException -> Lea
            goto Lf9
        Le2:
            java.lang.String r6 = com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule.tag
            java.lang.String r7 = "startPlay() null exception"
            android.util.Log.e(r6, r7)
            goto Lf9
        Lea:
            r6 = move-exception
            java.lang.String r7 = com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule.tag
            java.lang.String r0 = "startPlay() io exception"
            android.util.Log.e(r7, r0)
            java.lang.String r6 = r6.getMessage()
            r8.reject(r1, r6)
        Lf9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule.startPlayer(java.lang.String, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Promise):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startPlayer$lambda$4(final RNAudioRecorderPlayerModule this$0, String path, Promise promise, final MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Log.d(tag, "Mediaplayer prepared and start");
        mediaPlayer.start();
        this$0.mTask = new TimerTask() { // from class: com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerModule$startPlayer$1$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                String str;
                ReactApplicationContext reactApplicationContext;
                try {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("duration", mediaPlayer.getDuration());
                    createMap.putInt("currentPosition", mediaPlayer.getCurrentPosition());
                    RNAudioRecorderPlayerModule rNAudioRecorderPlayerModule = this$0;
                    reactApplicationContext = rNAudioRecorderPlayerModule.reactContext;
                    rNAudioRecorderPlayerModule.sendEvent(reactApplicationContext, "rn-playback", createMap);
                } catch (IllegalStateException e) {
                    str = RNAudioRecorderPlayerModule.tag;
                    Log.e(str, "Mediaplayer error: " + e.getMessage());
                }
            }
        };
        Timer timer = new Timer();
        this$0.mTimer = timer;
        Intrinsics.checkNotNull(timer);
        timer.schedule(this$0.mTask, 0L, this$0.subsDurationMillis);
        if (Intrinsics.areEqual(path, "DEFAULT")) {
            path = this$0.reactContext.getCacheDir() + "/" + defaultFileName;
        }
        promise.resolve(path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startPlayer$lambda$5(RNAudioRecorderPlayerModule this$0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("duration", mediaPlayer.getDuration());
        createMap.putInt("currentPosition", mediaPlayer.getCurrentPosition());
        this$0.sendEvent(this$0.reactContext, "rn-playback", createMap);
        Log.d(tag, "Plays completed.");
        Timer timer = this$0.mTimer;
        Intrinsics.checkNotNull(timer);
        timer.cancel();
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        this$0.mediaPlayer = null;
    }

    @ReactMethod
    public final void resumePlayer(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            promise.reject("resume", "Mediaplayer is null on resume.");
            return;
        }
        Intrinsics.checkNotNull(mediaPlayer);
        if (mediaPlayer.isPlaying()) {
            promise.reject("resume", "Mediaplayer is already running.");
            return;
        }
        try {
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer2);
            MediaPlayer mediaPlayer3 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer3);
            mediaPlayer2.seekTo(mediaPlayer3.getCurrentPosition());
            MediaPlayer mediaPlayer4 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer4);
            mediaPlayer4.start();
            promise.resolve("resume player");
        } catch (Exception e) {
            Log.e(tag, "Mediaplayer resume: " + e.getMessage());
            promise.reject("resume", e.getMessage());
        }
    }

    @ReactMethod
    public final void pausePlayer(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            promise.reject("pausePlay", "Mediaplayer is null on pause.");
            return;
        }
        try {
            Intrinsics.checkNotNull(mediaPlayer);
            mediaPlayer.pause();
            promise.resolve("pause player");
        } catch (Exception e) {
            Log.e(tag, "pausePlay exception: " + e.getMessage());
            promise.reject("pausePlay", e.getMessage());
        }
    }

    @ReactMethod
    public final void seekToPlayer(double time, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            promise.reject("seekTo", "Mediaplayer is null on seek.");
            return;
        }
        Intrinsics.checkNotNull(mediaPlayer);
        mediaPlayer.seekTo((int) time);
        promise.resolve("pause player");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendEvent(ReactContext reactContext, String eventName, WritableMap params) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(eventName, params);
    }

    @ReactMethod
    public final void stopPlayer(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Timer timer = this.mTimer;
        if (timer != null) {
            Intrinsics.checkNotNull(timer);
            timer.cancel();
        }
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            promise.resolve("Already stopped player");
            return;
        }
        try {
            Intrinsics.checkNotNull(mediaPlayer);
            mediaPlayer.stop();
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer2);
            mediaPlayer2.reset();
            MediaPlayer mediaPlayer3 = this.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer3);
            mediaPlayer3.release();
            this.mediaPlayer = null;
            promise.resolve("stopped player");
        } catch (Exception e) {
            Log.e(tag, "stopPlay exception: " + e.getMessage());
            promise.reject("stopPlay", e.getMessage());
        }
    }

    @ReactMethod
    public final void setSubscriptionDuration(double sec, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        int i = (int) (sec * 1000);
        this.subsDurationMillis = i;
        promise.resolve("setSubscriptionDuration: " + i);
    }

    @Override // com.facebook.react.modules.core.PermissionListener
    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        return requestCode == 200 && grantResults[0] == 0;
    }
}
