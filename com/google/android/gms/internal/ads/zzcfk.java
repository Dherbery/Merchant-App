package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
final class zzcfk implements Runnable {
    final /* synthetic */ zzcfp zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcfk(zzcfp zzcfpVar) {
        this.zza = zzcfpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcfq zzcfqVar;
        zzcfq zzcfqVar2;
        zzcfp zzcfpVar = this.zza;
        zzcfqVar = zzcfpVar.zzq;
        if (zzcfqVar != null) {
            zzcfqVar2 = zzcfpVar.zzq;
            zzcfqVar2.zzh();
        }
    }
}
