package com.google.android.exoplayer2.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaParser;
import android.media.MediaParser$InputReader;
import android.security.NetworkSecurityPolicy;
import dalvik.system.DelegateLastClassLoader;
import java.util.Locale;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class Util$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ ComponentName m(Context context, Intent intent) {
        return context.startForegroundService(intent);
    }

    public static /* synthetic */ MediaCodec.CryptoInfo.Pattern m(int i, int i2) {
        return new MediaCodec.CryptoInfo.Pattern(i, i2);
    }

    public static /* bridge */ /* synthetic */ MediaDrm.PlaybackComponent m(Object obj) {
        return (MediaDrm.PlaybackComponent) obj;
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ MediaParser$InputReader m795m(Object obj) {
        return (MediaParser$InputReader) obj;
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ MediaParser.SeekPoint m796m(Object obj) {
        return (MediaParser.SeekPoint) obj;
    }

    public static /* synthetic */ DelegateLastClassLoader m(String str, ClassLoader classLoader) {
        return new DelegateLastClassLoader(str, classLoader);
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ Locale.Category m798m() {
        return Locale.Category.DISPLAY;
    }

    public static /* bridge */ /* synthetic */ Locale m(Locale.Category category) {
        return Locale.getDefault(category);
    }

    /* renamed from: m */
    public static /* synthetic */ void m800m() {
    }

    public static /* bridge */ /* synthetic */ void m(MediaCodec.CryptoInfo.Pattern pattern, int i, int i2) {
        pattern.set(i, i2);
    }

    public static /* bridge */ /* synthetic */ void m(MediaCodec.CryptoInfo cryptoInfo, MediaCodec.CryptoInfo.Pattern pattern) {
        cryptoInfo.setPattern(pattern);
    }

    public static /* bridge */ /* synthetic */ boolean m(NetworkSecurityPolicy networkSecurityPolicy, String str) {
        return networkSecurityPolicy.isCleartextTrafficPermitted(str);
    }

    public static /* synthetic */ void m$1() {
    }

    public static /* synthetic */ void m$2() {
    }
}
