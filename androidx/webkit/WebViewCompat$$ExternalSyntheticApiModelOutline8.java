package androidx.webkit;

import android.app.ApplicationExitInfo;
import android.app.job.JobInfo;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.icu.util.ULocale;
import android.net.Uri;
import android.webkit.SafeBrowsingResponse;
import android.webkit.ServiceWorkerWebSettings;
import android.webkit.TracingConfig;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class WebViewCompat$$ExternalSyntheticApiModelOutline8 {
    public static /* bridge */ /* synthetic */ ApplicationExitInfo m(Object obj) {
        return (ApplicationExitInfo) obj;
    }

    public static /* synthetic */ JobInfo.TriggerContentUri m(Uri uri, int i) {
        return new JobInfo.TriggerContentUri(uri, i);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ImageDecoder.Source m209m(Object obj) {
        return (ImageDecoder.Source) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AnimatedImageDrawable m210m(Object obj) {
        return (AnimatedImageDrawable) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ ULocale.Builder m212m() {
        return new ULocale.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ULocale m215m(Object obj) {
        return (ULocale) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ SafeBrowsingResponse m218m(Object obj) {
        return (SafeBrowsingResponse) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ServiceWorkerWebSettings m220m(Object obj) {
        return (ServiceWorkerWebSettings) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ TracingConfig.Builder m221m() {
        return new TracingConfig.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ android.webkit.WebViewRenderProcess m223m(Object obj) {
        return (android.webkit.WebViewRenderProcess) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m226m() {
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m231m(Object obj) {
        return obj instanceof AnimatedImageDrawable;
    }
}
