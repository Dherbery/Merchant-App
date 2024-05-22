package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzet;
import com.google.android.gms.internal.play_billing.zzex;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public class zzet<MessageType extends zzex<MessageType, BuilderType>, BuilderType extends zzet<MessageType, BuilderType>> extends zzdf<MessageType, BuilderType> {
    protected zzex zza;
    private final zzex zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzet(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzt()) {
            this.zza = messagetype.zzi();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    @Override // com.google.android.gms.internal.play_billing.zzdf
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzet clone() {
        zzet zzetVar = (zzet) this.zzb.zzu(5, null, null);
        zzetVar.zza = zze();
        return zzetVar;
    }

    public final MessageType zzc() {
        MessageType zze = zze();
        if (zze.zzs()) {
            return zze;
        }
        throw new zzhc(zze);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgb
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public MessageType zze() {
        if (!this.zza.zzt()) {
            return (MessageType) this.zza;
        }
        this.zza.zzn();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgd
    public final /* bridge */ /* synthetic */ zzgc zzf() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzg() {
        if (this.zza.zzt()) {
            return;
        }
        zzh();
    }

    protected void zzh() {
        zzex zzi = this.zzb.zzi();
        zzgk.zza().zzb(zzi.getClass()).zzg(zzi, this.zza);
        this.zza = zzi;
    }
}
