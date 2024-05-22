package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzfs implements zzgh {
    private final zzfo zza;
    private final zzgy zzb;
    private final boolean zzc;
    private final zzdp zzd;

    private zzfs(zzgy zzgyVar, zzdp zzdpVar, zzfo zzfoVar) {
        this.zzb = zzgyVar;
        this.zzc = zzdpVar.zzg(zzfoVar);
        this.zzd = zzdpVar;
        this.zza = zzfoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfs zzc(zzgy zzgyVar, zzdp zzdpVar, zzfo zzfoVar) {
        return new zzfs(zzgyVar, zzdpVar, zzfoVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final int zza(Object obj) {
        zzgy zzgyVar = this.zzb;
        int zzb = zzgyVar.zzb(zzgyVar.zzd(obj));
        return this.zzc ? zzb + this.zzd.zzb(obj).zzb() : zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zzb(obj).zza.hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final Object zze() {
        zzfo zzfoVar = this.zza;
        if (zzfoVar instanceof zzed) {
            return ((zzed) zzfoVar).zzJ();
        }
        return zzfoVar.zzY().zzk();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zze(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final void zzg(Object obj, Object obj2) {
        zzgj.zzC(this.zzb, obj, obj2);
        if (this.zzc) {
            zzgj.zzB(this.zzd, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bf A[EDGE_INSN: B:24:0x00bf->B:25:0x00bf BREAK  A[LOOP:1: B:10:0x0067->B:18:0x0067], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzco r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed r0 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed) r0
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgz r1 = r0.zzc
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgz r2 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgz.zzc()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgz r1 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgz.zzf()
            r0.zzc = r1
        L11:
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdz r11 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdz) r11
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdt r11 = r11.zzc()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Lca
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcp.zzj(r12, r13, r15)
            int r13 = r15.zza
            r3 = 11
            r5 = 2
            if (r13 == r3) goto L65
            r3 = r13 & 7
            if (r3 != r5) goto L60
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp r2 = r10.zzd
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdo r3 = r15.zzd
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo r5 = r10.zza
            int r6 = r13 >>> 3
            java.lang.Object r8 = r2.zzd(r3, r5, r6)
            if (r8 == 0) goto L55
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfx r13 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfx.zza()
            r2 = r8
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeb r2 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeb) r2
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo r3 = r2.zzc
            java.lang.Class r3 = r3.getClass()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh r13 = r13.zzb(r3)
            int r13 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcp.zzd(r13, r12, r4, r14, r15)
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzea r2 = r2.zzd
            java.lang.Object r3 = r15.zzc
            r11.zzi(r2, r3)
            goto L5e
        L55:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcp.zzi(r2, r3, r4, r5, r6, r7)
        L5e:
            r2 = r8
            goto L19
        L60:
            int r13 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcp.zzp(r13, r12, r4, r14, r15)
            goto L19
        L65:
            r13 = 0
            r3 = r0
        L67:
            if (r4 >= r14) goto Lbf
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcp.zzj(r12, r4, r15)
            int r6 = r15.zza
            int r7 = r6 >>> 3
            r8 = r6 & 7
            if (r7 == r5) goto La3
            r9 = 3
            if (r7 == r9) goto L79
            goto Lb6
        L79:
            if (r2 == 0) goto L98
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfx r6 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfx.zza()
            r7 = r2
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeb r7 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeb) r7
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo r8 = r7.zzc
            java.lang.Class r8 = r8.getClass()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh r6 = r6.zzb(r8)
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcp.zzd(r6, r12, r4, r14, r15)
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzea r6 = r7.zzd
            java.lang.Object r7 = r15.zzc
            r11.zzi(r6, r7)
            goto L67
        L98:
            if (r8 != r5) goto Lb6
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcp.zza(r12, r4, r15)
            java.lang.Object r3 = r15.zzc
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb r3 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb) r3
            goto L67
        La3:
            if (r8 != 0) goto Lb6
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcp.zzj(r12, r4, r15)
            int r13 = r15.zza
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp r2 = r10.zzd
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdo r6 = r15.zzd
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo r7 = r10.zza
            java.lang.Object r2 = r2.zzd(r6, r7, r13)
            goto L67
        Lb6:
            r7 = 12
            if (r6 == r7) goto Lbf
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcp.zzp(r6, r12, r4, r14, r15)
            goto L67
        Lbf:
            if (r3 == 0) goto Lc7
            int r13 = r13 << 3
            r13 = r13 | r5
            r1.zzj(r13, r3)
        Lc7:
            r13 = r4
            goto L19
        Lca:
            if (r13 != r14) goto Lcd
            return
        Lcd:
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo r11 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo.zze()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfs.zzh(java.lang.Object, byte[], int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzco):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final void zzi(Object obj, zzhq zzhqVar) throws IOException {
        Iterator zzf = this.zzd.zzb(obj).zzf();
        while (zzf.hasNext()) {
            Map.Entry entry = (Map.Entry) zzf.next();
            zzds zzdsVar = (zzds) entry.getKey();
            if (zzdsVar.zze() != zzhp.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzdsVar.zzg();
            zzdsVar.zzf();
            if (entry instanceof zzer) {
                zzhqVar.zzw(zzdsVar.zza(), ((zzer) entry).zza().zzb());
            } else {
                zzhqVar.zzw(zzdsVar.zza(), entry.getValue());
            }
        }
        zzgy zzgyVar = this.zzb;
        zzgyVar.zzi(zzgyVar.zzd(obj), zzhqVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzd(obj).equals(this.zzb.zzd(obj2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zzb(obj).equals(this.zzd.zzb(obj2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final boolean zzk(Object obj) {
        return this.zzd.zzb(obj).zzk();
    }
}
