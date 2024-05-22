package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
public final class zzbc extends zzau {
    static final zzau zza = new zzbc(null, new Object[0], 0);
    final transient Object[] zzb;

    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzbc(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    public static zzbc zzg(int i, Object[] objArr, zzat zzatVar) {
        int i2;
        short[] sArr;
        char c;
        char c2;
        byte[] bArr;
        int i3 = i;
        Object[] objArr2 = objArr;
        if (i3 == 0) {
            return (zzbc) zza;
        }
        Object obj = null;
        int i4 = 1;
        if (i3 == 1) {
            Object obj2 = objArr2[0];
            obj2.getClass();
            Object obj3 = objArr2[1];
            obj3.getClass();
            zzai.zza(obj2, obj3);
            return new zzbc(null, objArr2, 1);
        }
        zzaf.zzb(i3, objArr2.length >> 1, "index");
        int max = Math.max(i3, 2);
        if (max < 751619276) {
            i2 = Integer.highestOneBit(max - 1);
            do {
                i2 += i2;
            } while (i2 * 0.7d < max);
        } else {
            i2 = 1073741824;
            if (max >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i3 == 1) {
            Object obj4 = objArr2[0];
            obj4.getClass();
            Object obj5 = objArr2[1];
            obj5.getClass();
            zzai.zza(obj4, obj5);
            c = 1;
            c2 = 2;
        } else {
            int i5 = i2 - 1;
            char c3 = 65535;
            if (i2 <= 128) {
                byte[] bArr2 = new byte[i2];
                Arrays.fill(bArr2, (byte) -1);
                int i6 = 0;
                int i7 = 0;
                while (i6 < i3) {
                    int i8 = i7 + i7;
                    int i9 = i6 + i6;
                    Object obj6 = objArr2[i9];
                    obj6.getClass();
                    Object obj7 = objArr2[i9 ^ i4];
                    obj7.getClass();
                    zzai.zza(obj6, obj7);
                    int zza2 = zzak.zza(obj6.hashCode());
                    while (true) {
                        int i10 = zza2 & i5;
                        int i11 = bArr2[i10] & 255;
                        if (i11 != 255) {
                            if (obj6.equals(objArr2[i11])) {
                                int i12 = i11 ^ 1;
                                Object obj8 = objArr2[i12];
                                obj8.getClass();
                                zzas zzasVar = new zzas(obj6, obj7, obj8);
                                objArr2[i12] = obj7;
                                obj = zzasVar;
                                break;
                            }
                            zza2 = i10 + 1;
                        } else {
                            bArr2[i10] = (byte) i8;
                            if (i7 < i6) {
                                objArr2[i8] = obj6;
                                objArr2[i8 ^ 1] = obj7;
                            }
                            i7++;
                        }
                    }
                    i6++;
                    i4 = 1;
                }
                if (i7 == i3) {
                    bArr = bArr2;
                } else {
                    bArr = new Object[]{bArr2, Integer.valueOf(i7), obj};
                    c2 = 2;
                    c = 1;
                    obj = bArr;
                }
            } else if (i2 <= 32768) {
                sArr = new short[i2];
                Arrays.fill(sArr, (short) -1);
                int i13 = 0;
                for (int i14 = 0; i14 < i3; i14++) {
                    int i15 = i13 + i13;
                    int i16 = i14 + i14;
                    Object obj9 = objArr2[i16];
                    obj9.getClass();
                    Object obj10 = objArr2[i16 ^ 1];
                    obj10.getClass();
                    zzai.zza(obj9, obj10);
                    int zza3 = zzak.zza(obj9.hashCode());
                    while (true) {
                        int i17 = zza3 & i5;
                        char c4 = (char) sArr[i17];
                        if (c4 != 65535) {
                            if (obj9.equals(objArr2[c4])) {
                                int i18 = c4 ^ 1;
                                Object obj11 = objArr2[i18];
                                obj11.getClass();
                                zzas zzasVar2 = new zzas(obj9, obj10, obj11);
                                objArr2[i18] = obj10;
                                obj = zzasVar2;
                                break;
                            }
                            zza3 = i17 + 1;
                        } else {
                            sArr[i17] = (short) i15;
                            if (i13 < i14) {
                                objArr2[i15] = obj9;
                                objArr2[i15 ^ 1] = obj10;
                            }
                            i13++;
                        }
                    }
                }
                if (i13 != i3) {
                    c2 = 2;
                    obj = new Object[]{sArr, Integer.valueOf(i13), obj};
                    c = 1;
                }
                bArr = sArr;
            } else {
                int i19 = 1;
                sArr = new int[i2];
                Arrays.fill((int[]) sArr, -1);
                int i20 = 0;
                int i21 = 0;
                while (i20 < i3) {
                    int i22 = i21 + i21;
                    int i23 = i20 + i20;
                    Object obj12 = objArr2[i23];
                    obj12.getClass();
                    Object obj13 = objArr2[i23 ^ i19];
                    obj13.getClass();
                    zzai.zza(obj12, obj13);
                    int zza4 = zzak.zza(obj12.hashCode());
                    while (true) {
                        int i24 = zza4 & i5;
                        ?? r15 = sArr[i24];
                        if (r15 != c3) {
                            if (obj12.equals(objArr2[r15])) {
                                int i25 = r15 ^ 1;
                                Object obj14 = objArr2[i25];
                                obj14.getClass();
                                zzas zzasVar3 = new zzas(obj12, obj13, obj14);
                                objArr2[i25] = obj13;
                                obj = zzasVar3;
                                break;
                            }
                            zza4 = i24 + 1;
                            c3 = 65535;
                        } else {
                            sArr[i24] = i22;
                            if (i21 < i20) {
                                objArr2[i22] = obj12;
                                objArr2[i22 ^ 1] = obj13;
                            }
                            i21++;
                        }
                    }
                    i20++;
                    i19 = 1;
                    c3 = 65535;
                }
                if (i21 != i3) {
                    c = 1;
                    c2 = 2;
                    obj = new Object[]{sArr, Integer.valueOf(i21), obj};
                }
                bArr = sArr;
            }
            c2 = 2;
            c = 1;
            obj = bArr;
        }
        boolean z = obj instanceof Object[];
        Object obj15 = obj;
        if (z) {
            Object[] objArr3 = (Object[]) obj;
            zzas zzasVar4 = (zzas) objArr3[c2];
            if (zzatVar != null) {
                zzatVar.zzc = zzasVar4;
                Object obj16 = objArr3[0];
                int intValue = ((Integer) objArr3[c]).intValue();
                objArr2 = Arrays.copyOf(objArr2, intValue + intValue);
                obj15 = obj16;
                i3 = intValue;
            } else {
                throw zzasVar4.zza();
            }
        }
        return new zzbc(obj15, objArr2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x009f A[RETURN] */
    @Override // com.google.android.gms.internal.mlkit_common.zzau, java.util.Map
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.zzc
            java.lang.Object[] r1 = r9.zzb
            int r2 = r9.zzd
            r3 = 0
            if (r10 != 0) goto Lc
        L9:
            r10 = r3
            goto L9c
        Lc:
            r4 = 1
            if (r2 != r4) goto L22
            r0 = 0
            r0 = r1[r0]
            r0.getClass()
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L9
            r10 = r1[r4]
            r10.getClass()
            goto L9c
        L22:
            if (r0 != 0) goto L25
            goto L9
        L25:
            boolean r2 = r0 instanceof byte[]
            r5 = -1
            if (r2 == 0) goto L51
            r2 = r0
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            int r6 = r0 + (-1)
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.mlkit_common.zzak.zza(r0)
        L38:
            r0 = r0 & r6
            r5 = r2[r0]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L41
            goto L9
        L41:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L4e
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L9c
        L4e:
            int r0 = r0 + 1
            goto L38
        L51:
            boolean r2 = r0 instanceof short[]
            if (r2 == 0) goto L7d
            r2 = r0
            short[] r2 = (short[]) r2
            int r0 = r2.length
            int r6 = r0 + (-1)
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.mlkit_common.zzak.zza(r0)
        L63:
            r0 = r0 & r6
            short r5 = r2[r0]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L6d
            goto L9
        L6d:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L7a
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L9c
        L7a:
            int r0 = r0 + 1
            goto L63
        L7d:
            int[] r0 = (int[]) r0
            int r2 = r0.length
            int r2 = r2 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.mlkit_common.zzak.zza(r6)
        L89:
            r6 = r6 & r2
            r7 = r0[r6]
            if (r7 != r5) goto L90
            goto L9
        L90:
            r8 = r1[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto La0
            r10 = r7 ^ 1
            r10 = r1[r10]
        L9c:
            if (r10 != 0) goto L9f
            return r3
        L9f:
            return r10
        La0:
            int r6 = r6 + 1
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzbc.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzau
    final zzan zza() {
        return new zzbb(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzau
    final zzav zzd() {
        return new zzaz(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzau
    final zzav zze() {
        return new zzba(this, new zzbb(this.zzb, 0, this.zzd));
    }
}
