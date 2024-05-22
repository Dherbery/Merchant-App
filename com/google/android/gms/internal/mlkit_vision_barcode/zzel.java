package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzel implements Runnable {
    final Future zza;
    final zzek zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzel(Future future, zzek zzekVar) {
        this.zza = future;
        this.zzb = zzekVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable zza = zzfa.zza((zzez) this.zza);
        if (zza == null) {
            try {
                Future future = this.zza;
                boolean z = false;
                if (future.isDone()) {
                    while (true) {
                        try {
                            obj = future.get();
                            break;
                        } catch (InterruptedException unused) {
                            z = true;
                        } catch (Throwable th) {
                            if (z) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    this.zzb.zzb(obj);
                    return;
                }
                throw new IllegalStateException(zzbd.zzb("Future was expected to be done: %s", future));
            } catch (Error e) {
                e = e;
                this.zzb.zza(e);
                return;
            } catch (RuntimeException e2) {
                e = e2;
                this.zzb.zza(e);
                return;
            } catch (ExecutionException e3) {
                this.zzb.zza(e3.getCause());
                return;
            }
        }
        this.zzb.zza(zza);
    }

    public final String toString() {
        zzaw zza = zzax.zza(this);
        zza.zza(this.zzb);
        return zza.toString();
    }
}
