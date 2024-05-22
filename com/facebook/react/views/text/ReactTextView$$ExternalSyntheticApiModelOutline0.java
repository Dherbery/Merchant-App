package com.facebook.react.views.text;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.media.AudioFocusRequest;
import android.media.ExifInterface;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import java.io.FileDescriptor;
import java.nio.file.Path;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class ReactTextView$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ Intent m(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        return context.registerReceiver(broadcastReceiver, intentFilter, i);
    }

    public static /* synthetic */ BlendModeColorFilter m(int i, BlendMode blendMode) {
        return new BlendModeColorFilter(i, blendMode);
    }

    public static /* synthetic */ AudioFocusRequest.Builder m(int i) {
        return new AudioFocusRequest.Builder(i);
    }

    public static /* synthetic */ AudioFocusRequest.Builder m(AudioFocusRequest audioFocusRequest) {
        return new AudioFocusRequest.Builder(audioFocusRequest);
    }

    public static /* synthetic */ ExifInterface m(FileDescriptor fileDescriptor) {
        return new ExifInterface(fileDescriptor);
    }

    public static /* bridge */ /* synthetic */ MediaMetricsManager m(Object obj) {
        return (MediaMetricsManager) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ NetworkEvent.Builder m655m() {
        return new NetworkEvent.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ PlaybackErrorEvent.Builder m656m() {
        return new PlaybackErrorEvent.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ PlaybackMetrics.Builder m657m() {
        return new PlaybackMetrics.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ PlaybackMetrics.Builder m658m(Object obj) {
        return (PlaybackMetrics.Builder) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ PlaybackStateEvent.Builder m659m() {
        return new PlaybackStateEvent.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ TrackChangeEvent.Builder m660m(int i) {
        return new TrackChangeEvent.Builder(i);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m661m() {
        return Path.class;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Path m663m(Object obj) {
        return (Path) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m664m() {
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m667m$1() {
    }
}
