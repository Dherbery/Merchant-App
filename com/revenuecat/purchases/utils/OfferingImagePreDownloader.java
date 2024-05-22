package com.revenuecat.purchases.utils;

import android.net.Uri;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.paywalls.PaywallData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OfferingImagePreDownloader.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/utils/OfferingImagePreDownloader;", "", "shouldPredownloadImages", "", "coilImageDownloader", "Lcom/revenuecat/purchases/utils/CoilImageDownloader;", "(ZLcom/revenuecat/purchases/utils/CoilImageDownloader;)V", "preDownloadOfferingImages", "", "offering", "Lcom/revenuecat/purchases/Offering;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OfferingImagePreDownloader {
    private final CoilImageDownloader coilImageDownloader;
    private final boolean shouldPredownloadImages;

    public OfferingImagePreDownloader(boolean z, CoilImageDownloader coilImageDownloader) {
        Intrinsics.checkNotNullParameter(coilImageDownloader, "coilImageDownloader");
        this.shouldPredownloadImages = z;
        this.coilImageDownloader = coilImageDownloader;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ OfferingImagePreDownloader(boolean r1, com.revenuecat.purchases.utils.CoilImageDownloader r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto Lc
            java.lang.String r1 = "com.revenuecat.purchases.ui.revenuecatui.PaywallKt"
            java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> Lb
            r1 = r4
            goto Lc
        Lb:
            r1 = 0
        Lc:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.utils.OfferingImagePreDownloader.<init>(boolean, com.revenuecat.purchases.utils.CoilImageDownloader, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final void preDownloadOfferingImages(Offering offering) {
        Intrinsics.checkNotNullParameter(offering, "offering");
        if (!this.shouldPredownloadImages) {
            LogUtilsKt.verboseLog("OfferingImagePreDownloader won't pre-download images");
            return;
        }
        LogUtilsKt.debugLog("OfferingImagePreDownloader: starting image download");
        PaywallData paywall = offering.getPaywall();
        if (paywall != null) {
            List<String> all$purchases_defaultsRelease = paywall.getConfig().getImages().getAll$purchases_defaultsRelease();
            ArrayList<Uri> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(all$purchases_defaultsRelease, 10));
            Iterator<T> it = all$purchases_defaultsRelease.iterator();
            while (it.hasNext()) {
                arrayList.add(Uri.parse(paywall.getAssetBaseURL().toString()).buildUpon().path((String) it.next()).build());
            }
            for (Uri it2 : arrayList) {
                LogUtilsKt.debugLog("Pre-downloading paywall image: " + it2);
                CoilImageDownloader coilImageDownloader = this.coilImageDownloader;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                coilImageDownloader.downloadImage(it2);
            }
        }
    }
}
