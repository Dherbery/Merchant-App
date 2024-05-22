package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
final class zzfo extends zzfq {
    private zzfo() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfo(zzfn zzfnVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzfq
    public final void zza(Object obj, long j) {
        ((zzfc) zzhn.zzf(obj, j)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzfq
    public final void zzb(Object obj, Object obj2, long j) {
        zzfc zzfcVar = (zzfc) zzhn.zzf(obj, j);
        zzfc zzfcVar2 = (zzfc) zzhn.zzf(obj2, j);
        int size = zzfcVar.size();
        int size2 = zzfcVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzfcVar.zzc()) {
                zzfcVar = zzfcVar.zzd(size2 + size);
            }
            zzfcVar.addAll(zzfcVar2);
        }
        if (size > 0) {
            zzfcVar2 = zzfcVar;
        }
        zzhn.zzs(obj, j, zzfcVar2);
    }
}
