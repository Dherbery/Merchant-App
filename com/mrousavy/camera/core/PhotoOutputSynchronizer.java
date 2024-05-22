package com.mrousavy.camera.core;

import android.media.Image;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: PhotoOutputSynchronizer.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000f\u001a\u00020\u0005H\u0082\u0002J\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007R6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/mrousavy/camera/core/PhotoOutputSynchronizer;", "", "()V", "photoOutputQueue", "Ljava/util/HashMap;", "", "Lkotlinx/coroutines/CompletableDeferred;", "Landroid/media/Image;", "Lkotlin/collections/HashMap;", "await", "timestamp", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "", b.ar, SubscriberAttributeKt.JSON_NAME_KEY, "set", "image", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PhotoOutputSynchronizer {
    private final HashMap<Long, CompletableDeferred<Image>> photoOutputQueue = new HashMap<>();

    private final CompletableDeferred<Image> get(long key) {
        if (!this.photoOutputQueue.containsKey(Long.valueOf(key))) {
            this.photoOutputQueue.put(Long.valueOf(key), CompletableDeferredKt.CompletableDeferred$default(null, 1, null));
        }
        CompletableDeferred<Image> completableDeferred = this.photoOutputQueue.get(Long.valueOf(key));
        Intrinsics.checkNotNull(completableDeferred);
        return completableDeferred;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object await(long r5, kotlin.coroutines.Continuation<? super android.media.Image> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.mrousavy.camera.core.PhotoOutputSynchronizer$await$1
            if (r0 == 0) goto L14
            r0 = r7
            com.mrousavy.camera.core.PhotoOutputSynchronizer$await$1 r0 = (com.mrousavy.camera.core.PhotoOutputSynchronizer$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.mrousavy.camera.core.PhotoOutputSynchronizer$await$1 r0 = new com.mrousavy.camera.core.PhotoOutputSynchronizer$await$1
            r0.<init>(r4, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            long r5 = r0.J$0
            java.lang.Object r0 = r0.L$0
            com.mrousavy.camera.core.PhotoOutputSynchronizer r0 = (com.mrousavy.camera.core.PhotoOutputSynchronizer) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4d
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CompletableDeferred r7 = r4.get(r5)
            r0.L$0 = r4
            r0.J$0 = r5
            r0.label = r3
            java.lang.Object r7 = r7.await(r0)
            if (r7 != r1) goto L4c
            return r1
        L4c:
            r0 = r4
        L4d:
            android.media.Image r7 = (android.media.Image) r7
            java.util.HashMap<java.lang.Long, kotlinx.coroutines.CompletableDeferred<android.media.Image>> r0 = r0.photoOutputQueue
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            r0.remove(r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.PhotoOutputSynchronizer.await(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void set(long timestamp, Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        get(timestamp).complete(image);
    }

    public final void clear() {
        Iterator<Map.Entry<Long, CompletableDeferred<Image>>> it = this.photoOutputQueue.entrySet().iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next().getValue(), (CancellationException) null, 1, (Object) null);
        }
        this.photoOutputQueue.clear();
    }
}
