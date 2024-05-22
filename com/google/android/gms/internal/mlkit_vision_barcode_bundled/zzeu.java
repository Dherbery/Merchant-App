package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public class zzeu {
    private static final zzdo zzb = zzdo.zza;
    protected volatile zzfo zza;
    private volatile zzdb zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeu)) {
            return false;
        }
        zzeu zzeuVar = (zzeu) obj;
        zzfo zzfoVar = this.zza;
        zzfo zzfoVar2 = zzeuVar.zza;
        if (zzfoVar == null && zzfoVar2 == null) {
            return zzb().equals(zzeuVar.zzb());
        }
        if (zzfoVar != null && zzfoVar2 != null) {
            return zzfoVar.equals(zzfoVar2);
        }
        if (zzfoVar != null) {
            zzeuVar.zzd(zzfoVar.zzab());
            return zzfoVar.equals(zzeuVar.zza);
        }
        zzd(zzfoVar2.zzab());
        return this.zza.equals(zzfoVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzcy) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzE();
        }
        return 0;
    }

    public final zzdb zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzdb.zzb;
            } else {
                this.zzc = this.zza.zzC();
            }
            return this.zzc;
        }
    }

    public final zzfo zzc(zzfo zzfoVar) {
        zzfo zzfoVar2 = this.zza;
        this.zzc = null;
        this.zza = zzfoVar;
        return zzfoVar2;
    }

    protected final void zzd(zzfo zzfoVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zzfoVar;
                    this.zzc = zzdb.zzb;
                } catch (zzeo unused) {
                    this.zza = zzfoVar;
                    this.zzc = zzdb.zzb;
                }
            }
        }
    }
}
