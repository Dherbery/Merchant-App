package com.revenuecat.purchases.utils;

import android.content.Context;
import android.net.Uri;
import coil.ImageLoader;
import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoilImageDownloader.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/utils/CoilImageDownloader;", "", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "downloadImage", "", "uri", "Landroid/net/Uri;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class CoilImageDownloader {
    private final Context applicationContext;

    public CoilImageDownloader(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
    }

    public final void downloadImage(Uri uri) {
        ImageLoader revenueCatUIImageLoader;
        Intrinsics.checkNotNullParameter(uri, "uri");
        ImageRequest build = new ImageRequest.Builder(this.applicationContext).data(uri).build();
        revenueCatUIImageLoader = CoilImageDownloaderKt.getRevenueCatUIImageLoader(this.applicationContext);
        revenueCatUIImageLoader.enqueue(build);
    }
}
