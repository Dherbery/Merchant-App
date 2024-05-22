package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
final class zzatw implements Runnable {
    private zzatw() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzatw(zzatv zzatvVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzatx.zzc(MessageDigest.getInstance(MessageDigestAlgorithms.MD5));
            countDownLatch = zzatx.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzatx.zzb;
        } catch (Throwable th) {
            zzatx.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
