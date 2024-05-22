package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdx;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public abstract class zzed<MessageType extends zzed<MessageType, BuilderType>, BuilderType extends zzdx<MessageType, BuilderType>> extends zzck<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzgz zzc = zzgz.zzc();

    public static zzeb zzH(zzfo zzfoVar, Object obj, zzfo zzfoVar2, zzeg zzegVar, int i, zzho zzhoVar, Class cls) {
        return new zzeb(zzfoVar, obj, zzfoVar2, new zzea(null, i, zzhoVar, false, false), cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzed zzI(Class cls) {
        Map map = zza;
        zzed zzedVar = (zzed) map.get(cls);
        if (zzedVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzedVar = (zzed) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzedVar == null) {
            zzedVar = (zzed) ((zzed) zzhi.zze(cls)).zzg(6, null, null);
            if (zzedVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzedVar);
        }
        return zzedVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzed zzK(zzed zzedVar, byte[] bArr, zzdo zzdoVar) throws zzeo {
        zzed zze = zze(zzedVar, bArr, 0, bArr.length, zzdoVar);
        if (zze == null || zze.zzac()) {
            return zze;
        }
        zzeo zza2 = new zzgx(zze).zza();
        zza2.zzf(zze);
        throw zza2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzei zzL() {
        return zzdv.zze();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzei zzM(zzei zzeiVar) {
        int size = zzeiVar.size();
        return zzeiVar.zzd(size == 0 ? 10 : size + size);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzej zzN() {
        return zzee.zzf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzel zzO() {
        return zzfy.zze();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzel zzP(zzel zzelVar) {
        int size = zzelVar.size();
        return zzelVar.zzd(size == 0 ? 10 : size + size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzQ(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzR(zzfo zzfoVar, String str, Object[] objArr) {
        return new zzfz(zzfoVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzU(Class cls, zzed zzedVar) {
        zzedVar.zzT();
        zza.put(cls, zzedVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final boolean zzW(zzed zzedVar, boolean z) {
        byte byteValue = ((Byte) zzedVar.zzg(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzfx.zza().zzb(zzedVar.getClass()).zzk(zzedVar);
        if (z) {
            zzedVar.zzg(2, true != zzk ? null : zzedVar, null);
        }
        return zzk;
    }

    private final int zzc(zzgh zzghVar) {
        if (zzghVar == null) {
            return zzfx.zza().zzb(getClass()).zza(this);
        }
        return zzghVar.zza(this);
    }

    private static zzed zze(zzed zzedVar, byte[] bArr, int i, int i2, zzdo zzdoVar) throws zzeo {
        zzed zzJ = zzedVar.zzJ();
        try {
            zzgh zzb = zzfx.zza().zzb(zzJ.getClass());
            zzb.zzh(zzJ, bArr, 0, i2, new zzco(zzdoVar));
            zzb.zzf(zzJ);
            return zzJ;
        } catch (zzeo e) {
            e.zzf(zzJ);
            throw e;
        } catch (zzgx e2) {
            zzeo zza2 = e2.zza();
            zza2.zzf(zzJ);
            throw zza2;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzeo) {
                throw ((zzeo) e3.getCause());
            }
            zzeo zzeoVar = new zzeo(e3);
            zzeoVar.zzf(zzJ);
            throw zzeoVar;
        } catch (IndexOutOfBoundsException unused) {
            zzeo zzg = zzeo.zzg();
            zzg.zzf(zzJ);
            throw zzg;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzfx.zza().zzb(getClass()).zzj(this, (zzed) obj);
    }

    public final int hashCode() {
        if (zzX()) {
            return zzD();
        }
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int zzD = zzD();
        this.zzb = zzD;
        return zzD;
    }

    public final String toString() {
        return zzfq.zza(this, super.toString());
    }

    final int zzD() {
        return zzfx.zza().zzb(getClass()).zzb(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzdx zzF() {
        return (zzdx) zzg(5, null, null);
    }

    public final zzdx zzG() {
        zzdx zzdxVar = (zzdx) zzg(5, null, null);
        zzdxVar.zzg(this);
        return zzdxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzed zzJ() {
        return (zzed) zzg(4, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzS() {
        zzfx.zza().zzb(getClass()).zzf(this);
        zzT();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzT() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzV(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzX() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo
    public final /* synthetic */ zzfn zzY() {
        return (zzdx) zzg(5, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo
    public final /* synthetic */ zzfn zzZ() {
        zzdx zzdxVar = (zzdx) zzg(5, null, null);
        zzdxVar.zzg(this);
        return zzdxVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo
    public final void zzaa(zzdj zzdjVar) throws IOException {
        zzfx.zza().zzb(getClass()).zzi(this, zzdk.zza(zzdjVar));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp
    public final /* synthetic */ zzfo zzab() {
        return (zzed) zzg(6, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp
    public final boolean zzac() {
        Boolean bool = Boolean.TRUE;
        return zzW(this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzg(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzck
    final int zzB(zzgh zzghVar) {
        if (zzX()) {
            int zzc = zzc(zzghVar);
            if (zzc >= 0) {
                return zzc;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zzc);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zzc2 = zzc(zzghVar);
        if (zzc2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zzc2;
            return zzc2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zzc2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo
    public final int zzE() {
        int i;
        if (zzX()) {
            i = zzc(null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zzd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = zzc(null);
                if (i >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i);
                }
            }
        }
        return i;
    }
}
