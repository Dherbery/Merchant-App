package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdx;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public class zzdx<MessageType extends zzed<MessageType, BuilderType>, BuilderType extends zzdx<MessageType, BuilderType>> extends zzcj<MessageType, BuilderType> {
    protected zzed zza;
    private final zzed zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdx(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzX()) {
            this.zza = messagetype.zzJ();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzfx.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp
    public final /* bridge */ /* synthetic */ zzfo zzab() {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp
    public final boolean zzac() {
        return zzed.zzW(this.zza, false);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcj
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzdx clone() {
        zzdx zzdxVar = (zzdx) this.zzb.zzg(5, null, null);
        zzdxVar.zza = zzk();
        return zzdxVar;
    }

    public final zzdx zzg(zzed zzedVar) {
        if (!this.zzb.equals(zzedVar)) {
            if (!this.zza.zzX()) {
                zzn();
            }
            zza(this.zza, zzedVar);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn
    /* renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final MessageType zzj() {
        MessageType zzk = zzk();
        if (zzk.zzac()) {
            return zzk;
        }
        throw new zzgx(zzk);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn
    /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public MessageType zzk() {
        if (!this.zza.zzX()) {
            return (MessageType) this.zza;
        }
        this.zza.zzS();
        return (MessageType) this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzm() {
        if (this.zza.zzX()) {
            return;
        }
        zzn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzn() {
        zzed zzJ = this.zzb.zzJ();
        zza(zzJ, this.zza);
        this.zza = zzJ;
    }
}
