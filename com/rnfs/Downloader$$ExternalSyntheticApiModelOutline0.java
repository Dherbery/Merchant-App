package com.rnfs;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.media.EncoderProfiles;
import android.media.MediaRecorder;
import android.view.Surface;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes5.dex */
public final /* synthetic */ class Downloader$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ Notification.Builder m(Context context, String str) {
        return new Notification.Builder(context, str);
    }

    public static /* synthetic */ NotificationChannel m(String str, CharSequence charSequence, int i) {
        return new NotificationChannel(str, charSequence, i);
    }

    public static /* synthetic */ SurfaceTexture m(boolean z) {
        return new SurfaceTexture(z);
    }

    public static /* synthetic */ Typeface.Builder m(AssetManager assetManager, String str) {
        return new Typeface.Builder(assetManager, str);
    }

    public static /* synthetic */ OutputConfiguration m(Surface surface) {
        return new OutputConfiguration(surface);
    }

    public static /* synthetic */ SessionConfiguration m(int i, List list, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
        return new SessionConfiguration(i, list, executor, stateCallback);
    }

    public static /* bridge */ /* synthetic */ EncoderProfiles.VideoProfile m(Object obj) {
        return (EncoderProfiles.VideoProfile) obj;
    }

    public static /* synthetic */ MediaRecorder m(Context context) {
        return new MediaRecorder(context);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m1110m() {
        return BasicFileAttributes.class;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m1114m() {
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m1119m$1() {
        return Path.class;
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m1120m$1() {
    }

    /* renamed from: m$2, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m1123m$2() {
        return LocalDate.class;
    }

    /* renamed from: m$2, reason: collision with other method in class */
    public static /* synthetic */ void m1124m$2() {
    }

    /* renamed from: m$3, reason: collision with other method in class */
    public static /* synthetic */ void m1125m$3() {
    }

    /* renamed from: m$4, reason: collision with other method in class */
    public static /* synthetic */ void m1126m$4() {
    }
}
