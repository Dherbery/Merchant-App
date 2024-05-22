package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public class zzdt extends zzds {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdt(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdw) || zzd() != ((zzdw) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zzdt) {
            zzdt zzdtVar = (zzdt) obj;
            int zzk = zzk();
            int zzk2 = zzdtVar.zzk();
            if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
                return false;
            }
            int zzd = zzd();
            if (zzd > zzdtVar.zzd()) {
                throw new IllegalArgumentException("Length too large: " + zzd + zzd());
            }
            if (zzd <= zzdtVar.zzd()) {
                if (zzdtVar instanceof zzdt) {
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzdtVar.zza;
                    zzdtVar.zzc();
                    int i = 0;
                    int i2 = 0;
                    while (i < zzd) {
                        if (bArr[i] != bArr2[i2]) {
                            return false;
                        }
                        i++;
                        i2++;
                    }
                    return true;
                }
                return zzdtVar.zzf(0, zzd).equals(zzf(0, zzd));
            }
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzdtVar.zzd());
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    public byte zza(int i) {
        return this.zza[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzdw
    public byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    protected final int zze(int i, int i2, int i3) {
        return zzfd.zzb(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    public final zzdw zzf(int i, int i2) {
        int zzj = zzj(0, i2, zzd());
        return zzj == 0 ? zzdw.zzb : new zzdq(this.zza, 0, zzj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzdw
    public final void zzh(zzdm zzdmVar) throws IOException {
        ((zzeb) zzdmVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    public final boolean zzi() {
        return zzhs.zze(this.zza, 0, zzd());
    }
}
