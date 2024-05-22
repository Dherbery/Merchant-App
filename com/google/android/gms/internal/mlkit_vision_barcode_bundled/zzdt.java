package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzdt {
    private static final zzdt zzb = new zzdt(true);
    final zzgu zza = new zzgk(16);
    private boolean zzc;
    private boolean zzd;

    private zzdt() {
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x002f. Please report as an issue. */
    public static int zza(zzds zzdsVar, Object obj) {
        int zzd;
        int zzy;
        zzho zzd2 = zzdsVar.zzd();
        int zza = zzdsVar.zza();
        zzdsVar.zzg();
        int i = zzdj.zzb;
        int zzy2 = zzdj.zzy(zza << 3);
        if (zzd2 == zzho.GROUP) {
            zzfo zzfoVar = (zzfo) obj;
            byte[] bArr = zzem.zzd;
            if (zzfoVar instanceof zzcl) {
                throw null;
            }
            zzy2 += zzy2;
        }
        zzhp zzhpVar = zzhp.INT;
        int i2 = 4;
        switch (zzd2) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                i2 = 8;
                return zzy2 + i2;
            case FLOAT:
                ((Float) obj).floatValue();
                return zzy2 + i2;
            case INT64:
                i2 = zzdj.zzz(((Long) obj).longValue());
                return zzy2 + i2;
            case UINT64:
                i2 = zzdj.zzz(((Long) obj).longValue());
                return zzy2 + i2;
            case INT32:
                i2 = zzdj.zzu(((Integer) obj).intValue());
                return zzy2 + i2;
            case FIXED64:
                ((Long) obj).longValue();
                i2 = 8;
                return zzy2 + i2;
            case FIXED32:
                ((Integer) obj).intValue();
                return zzy2 + i2;
            case BOOL:
                ((Boolean) obj).booleanValue();
                i2 = 1;
                return zzy2 + i2;
            case STRING:
                if (obj instanceof zzdb) {
                    zzd = ((zzdb) obj).zzd();
                    zzy = zzdj.zzy(zzd);
                    i2 = zzy + zzd;
                    return zzy2 + i2;
                }
                i2 = zzdj.zzx((String) obj);
                return zzy2 + i2;
            case GROUP:
                i2 = ((zzfo) obj).zzE();
                return zzy2 + i2;
            case MESSAGE:
                if (obj instanceof zzet) {
                    zzd = ((zzet) obj).zza();
                    zzy = zzdj.zzy(zzd);
                    i2 = zzy + zzd;
                    return zzy2 + i2;
                }
                i2 = zzdj.zzv((zzfo) obj);
                return zzy2 + i2;
            case BYTES:
                if (obj instanceof zzdb) {
                    zzd = ((zzdb) obj).zzd();
                    zzy = zzdj.zzy(zzd);
                } else {
                    zzd = ((byte[]) obj).length;
                    zzy = zzdj.zzy(zzd);
                }
                i2 = zzy + zzd;
                return zzy2 + i2;
            case UINT32:
                i2 = zzdj.zzy(((Integer) obj).intValue());
                return zzy2 + i2;
            case ENUM:
                if (obj instanceof zzef) {
                    i2 = zzdj.zzu(((zzef) obj).zza());
                } else {
                    i2 = zzdj.zzu(((Integer) obj).intValue());
                }
                return zzy2 + i2;
            case SFIXED32:
                ((Integer) obj).intValue();
                return zzy2 + i2;
            case SFIXED64:
                ((Long) obj).longValue();
                i2 = 8;
                return zzy2 + i2;
            case SINT32:
                int intValue = ((Integer) obj).intValue();
                i2 = zzdj.zzy((intValue >> 31) ^ (intValue + intValue));
                return zzy2 + i2;
            case SINT64:
                long longValue = ((Long) obj).longValue();
                i2 = zzdj.zzz((longValue >> 63) ^ (longValue + longValue));
                return zzy2 + i2;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static zzdt zzd() {
        return zzb;
    }

    private static Object zzl(Object obj) {
        if (obj instanceof zzft) {
            return ((zzft) obj).zzc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzm(Map.Entry entry) {
        zzfo zzj;
        zzds zzdsVar = (zzds) entry.getKey();
        Object value = entry.getValue();
        if (!(value instanceof zzet)) {
            zzdsVar.zzg();
            if (zzdsVar.zze() == zzhp.MESSAGE) {
                Object zze = zze(zzdsVar);
                if (zze == null) {
                    this.zza.put(zzdsVar, zzl(value));
                    return;
                }
                if (zze instanceof zzft) {
                    zzj = zzdsVar.zzc((zzft) zze, (zzft) value);
                } else {
                    zzfn zzZ = ((zzfo) zze).zzZ();
                    zzdsVar.zzb(zzZ, (zzfo) value);
                    zzj = zzZ.zzj();
                }
                this.zza.put(zzdsVar, zzj);
                return;
            }
            this.zza.put(zzdsVar, zzl(value));
            return;
        }
        throw null;
    }

    private static boolean zzn(Map.Entry entry) {
        zzds zzdsVar = (zzds) entry.getKey();
        if (zzdsVar.zze() != zzhp.MESSAGE) {
            return true;
        }
        zzdsVar.zzg();
        Object value = entry.getValue();
        if (value instanceof zzfp) {
            return ((zzfp) value).zzac();
        }
        if (value instanceof zzet) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzo(Map.Entry entry) {
        zzds zzdsVar = (zzds) entry.getKey();
        Object value = entry.getValue();
        if (zzdsVar.zze() != zzhp.MESSAGE) {
            return zza(zzdsVar, value);
        }
        zzdsVar.zzg();
        zzdsVar.zzf();
        if (value instanceof zzet) {
            int zzy = zzdj.zzy(((zzds) entry.getKey()).zza());
            int zza = ((zzet) value).zza();
            int zzy2 = zzdj.zzy(zza) + zza;
            int zzy3 = zzdj.zzy(24);
            int zzy4 = zzdj.zzy(16);
            int zzy5 = zzdj.zzy(8);
            return zzy5 + zzy5 + zzy4 + zzy + zzy3 + zzy2;
        }
        int zzy6 = zzdj.zzy(((zzds) entry.getKey()).zza());
        int zzy7 = zzdj.zzy(24) + zzdj.zzv((zzfo) value);
        int zzy8 = zzdj.zzy(16);
        int zzy9 = zzdj.zzy(8);
        return zzy9 + zzy9 + zzy8 + zzy6 + zzy7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdt) {
            return this.zza.equals(((zzdt) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzb() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
            i += zzo(this.zza.zzg(i2));
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            i += zzo((Map.Entry) it.next());
        }
        return i;
    }

    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzdt clone() {
        zzdt zzdtVar = new zzdt();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzdtVar.zzi((zzds) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzdtVar.zzi((zzds) entry.getKey(), entry.getValue());
        }
        zzdtVar.zzd = this.zzd;
        return zzdtVar;
    }

    public final Object zze(zzds zzdsVar) {
        Object obj = this.zza.get(zzdsVar);
        if (!(obj instanceof zzet)) {
            return obj;
        }
        throw null;
    }

    public final Iterator zzf() {
        return this.zzd ? new zzes(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            if (zzg.getValue() instanceof zzed) {
                ((zzed) zzg.getValue()).zzS();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzh(zzdt zzdtVar) {
        for (int i = 0; i < zzdtVar.zza.zzb(); i++) {
            zzm(zzdtVar.zza.zzg(i));
        }
        Iterator it = zzdtVar.zza.zzc().iterator();
        while (it.hasNext()) {
            zzm((Map.Entry) it.next());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        if ((r7 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzef) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
    
        if ((r7 instanceof byte[]) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        if (r0 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if ((r7 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzet) == false) goto L32;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0019. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds r6, java.lang.Object r7) {
        /*
            r5 = this;
            r6.zzg()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzho r0 = r6.zzd()
            byte[] r1 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzem.zzd
            r7.getClass()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzho r1 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzho.DOUBLE
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhp r1 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhp.INT
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhp r0 = r0.zza()
            int r0 = r0.ordinal()
            r1 = 1
            switch(r0) {
                case 0: goto L47;
                case 1: goto L44;
                case 2: goto L41;
                case 3: goto L3e;
                case 4: goto L3b;
                case 5: goto L38;
                case 6: goto L2f;
                case 7: goto L26;
                case 8: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L57
        L1d:
            boolean r0 = r7 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo
            if (r0 != 0) goto L4b
            boolean r0 = r7 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzet
            if (r0 == 0) goto L57
            goto L4b
        L26:
            boolean r0 = r7 instanceof java.lang.Integer
            if (r0 != 0) goto L4b
            boolean r0 = r7 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzef
            if (r0 == 0) goto L57
            goto L4b
        L2f:
            boolean r0 = r7 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
            if (r0 != 0) goto L4b
            boolean r0 = r7 instanceof byte[]
            if (r0 == 0) goto L57
            goto L4b
        L38:
            boolean r0 = r7 instanceof java.lang.String
            goto L49
        L3b:
            boolean r0 = r7 instanceof java.lang.Boolean
            goto L49
        L3e:
            boolean r0 = r7 instanceof java.lang.Double
            goto L49
        L41:
            boolean r0 = r7 instanceof java.lang.Float
            goto L49
        L44:
            boolean r0 = r7 instanceof java.lang.Long
            goto L49
        L47:
            boolean r0 = r7 instanceof java.lang.Integer
        L49:
            if (r0 == 0) goto L57
        L4b:
            boolean r0 = r7 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzet
            if (r0 == 0) goto L51
            r5.zzd = r1
        L51:
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgu r0 = r5.zza
            r0.put(r6, r7)
            return
        L57:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            int r3 = r6.zza()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = 0
            r2[r4] = r3
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzho r6 = r6.zzd()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhp r6 = r6.zza()
            r2[r1] = r6
            java.lang.Class r6 = r7.getClass()
            java.lang.String r6 = r6.getName()
            r7 = 2
            r2[r7] = r6
            java.lang.String r6 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r6 = java.lang.String.format(r6, r2)
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdt.zzi(com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds, java.lang.Object):void");
    }

    public final boolean zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        for (int i = 0; i < this.zza.zzb(); i++) {
            if (!zzn(this.zza.zzg(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            if (!zzn((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzdt(boolean z) {
        zzg();
        zzg();
    }
}
