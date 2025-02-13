package com.google.android.gms.internal.play_billing;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public final class zzdq extends zzdt {
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdq(byte[] bArr, int i, int i2) {
        super(bArr);
        zzj(0, i2, bArr.length);
        this.zzc = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzdt, com.google.android.gms.internal.play_billing.zzdw
    public final byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.play_billing.zzdt
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdt, com.google.android.gms.internal.play_billing.zzdw
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdt, com.google.android.gms.internal.play_billing.zzdw
    public final byte zza(int i) {
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }
}
