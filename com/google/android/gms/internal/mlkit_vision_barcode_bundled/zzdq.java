package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzdq extends zzdp {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    public final int zza(Map.Entry entry) {
        return ((zzea) entry.getKey()).zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    public final zzdt zzb(Object obj) {
        return ((zzdz) obj).zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    public final zzdt zzc(Object obj) {
        return ((zzdz) obj).zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    public final Object zzd(zzdo zzdoVar, zzfo zzfoVar, int i) {
        return zzdoVar.zzb(zzfoVar, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    public final void zze(Object obj) {
        ((zzdz) obj).zza.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    public final void zzf(zzhq zzhqVar, Map.Entry entry) throws IOException {
        zzea zzeaVar = (zzea) entry.getKey();
        zzho zzhoVar = zzho.DOUBLE;
        switch (zzeaVar.zzb) {
            case DOUBLE:
                zzhqVar.zzf(zzeaVar.zza, ((Double) entry.getValue()).doubleValue());
                return;
            case FLOAT:
                zzhqVar.zzo(zzeaVar.zza, ((Float) entry.getValue()).floatValue());
                return;
            case INT64:
                zzhqVar.zzt(zzeaVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case UINT64:
                zzhqVar.zzK(zzeaVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case INT32:
                zzhqVar.zzr(zzeaVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case FIXED64:
                zzhqVar.zzm(zzeaVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case FIXED32:
                zzhqVar.zzk(zzeaVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case BOOL:
                zzhqVar.zzb(zzeaVar.zza, ((Boolean) entry.getValue()).booleanValue());
                return;
            case STRING:
                zzhqVar.zzG(zzeaVar.zza, (String) entry.getValue());
                return;
            case GROUP:
                zzhqVar.zzq(zzeaVar.zza, entry.getValue(), zzfx.zza().zzb(entry.getValue().getClass()));
                return;
            case MESSAGE:
                zzhqVar.zzv(zzeaVar.zza, entry.getValue(), zzfx.zza().zzb(entry.getValue().getClass()));
                return;
            case BYTES:
                zzhqVar.zzd(zzeaVar.zza, (zzdb) entry.getValue());
                return;
            case UINT32:
                zzhqVar.zzI(zzeaVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case ENUM:
                zzhqVar.zzr(zzeaVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case SFIXED32:
                zzhqVar.zzx(zzeaVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case SFIXED64:
                zzhqVar.zzz(zzeaVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case SINT32:
                zzhqVar.zzB(zzeaVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case SINT64:
                zzhqVar.zzD(zzeaVar.zza, ((Long) entry.getValue()).longValue());
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    public final boolean zzg(zzfo zzfoVar) {
        return zzfoVar instanceof zzdz;
    }
}
