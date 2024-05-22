package com.revenuecat.purchases.utils;

import android.content.Context;
import coil.ImageLoader;
import coil.disk.DiskCache;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoilImageDownloader.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"MAX_CACHE_SIZE_BYTES", "", "PAYWALL_IMAGE_CACHE_FOLDER", "", "getRevenueCatUIImageLoader", "Lcoil/ImageLoader;", "Landroid/content/Context;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class CoilImageDownloaderKt {
    private static final long MAX_CACHE_SIZE_BYTES = 26214400;
    private static final String PAYWALL_IMAGE_CACHE_FOLDER = "revenuecatui_cache";

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageLoader getRevenueCatUIImageLoader(final Context context) {
        return new ImageLoader.Builder(context).diskCache(new Function0<DiskCache>() { // from class: com.revenuecat.purchases.utils.CoilImageDownloaderKt$getRevenueCatUIImageLoader$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DiskCache invoke() {
                DiskCache.Builder builder = new DiskCache.Builder();
                File cacheDir = context.getCacheDir();
                Intrinsics.checkNotNullExpressionValue(cacheDir, "cacheDir");
                return builder.directory(FilesKt.resolve(cacheDir, "revenuecatui_cache")).maxSizeBytes(26214400L).build();
            }
        }).build();
    }
}
