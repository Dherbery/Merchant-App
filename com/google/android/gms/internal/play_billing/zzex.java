package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzet;
import com.google.android.gms.internal.play_billing.zzex;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public abstract class zzex<MessageType extends zzex<MessageType, BuilderType>, BuilderType extends zzet<MessageType, BuilderType>> extends zzdg<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzhe zzc = zzhe.zzc();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzex zzh(Class cls) {
        Map map = zzb;
        zzex zzexVar = (zzex) map.get(cls);
        if (zzexVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzexVar = (zzex) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzexVar == null) {
            zzexVar = (zzex) ((zzex) zzhn.zze(cls)).zzu(6, null, null);
            if (zzexVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzexVar);
        }
        return zzexVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzex zzj(zzex zzexVar, byte[] bArr, zzej zzejVar) throws zzff {
        zzex zzw = zzw(zzexVar, bArr, 0, bArr.length, zzejVar);
        if (zzw == null || zzw.zzs()) {
            return zzw;
        }
        zzff zza = new zzhc(zzw).zza();
        zza.zzf(zzw);
        throw zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzl(Method method, Object obj, Object... objArr) {
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
    public static Object zzm(zzgc zzgcVar, String str, Object[] objArr) {
        return new zzgl(zzgcVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzp(Class cls, zzex zzexVar) {
        zzexVar.zzo();
        zzb.put(cls, zzexVar);
    }

    private final int zzv(zzgm zzgmVar) {
        return zzgk.zza().zzb(getClass()).zza(this);
    }

    private static zzex zzw(zzex zzexVar, byte[] bArr, int i, int i2, zzej zzejVar) throws zzff {
        zzex zzi = zzexVar.zzi();
        try {
            zzgm zzb2 = zzgk.zza().zzb(zzi.getClass());
            zzb2.zzh(zzi, bArr, 0, i2, new zzdj(zzejVar));
            zzb2.zzf(zzi);
            return zzi;
        } catch (zzff e) {
            e.zzf(zzi);
            throw e;
        } catch (zzhc e2) {
            zzff zza = e2.zza();
            zza.zzf(zzi);
            throw zza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzff) {
                throw ((zzff) e3.getCause());
            }
            zzff zzffVar = new zzff(e3);
            zzffVar.zzf(zzi);
            throw zzffVar;
        } catch (IndexOutOfBoundsException unused) {
            zzff zzg = zzff.zzg();
            zzg.zzf(zzi);
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
        return zzgk.zza().zzb(getClass()).zzj(this, (zzex) obj);
    }

    public final int hashCode() {
        if (zzt()) {
            return zzd();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzd = zzd();
        this.zza = zzd;
        return zzd;
    }

    public final String toString() {
        return zzge.zza(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzdg
    public final int zza(zzgm zzgmVar) {
        if (zzt()) {
            int zza = zzgmVar.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zza2 = zzgmVar.zza(this);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }

    final int zzd() {
        return zzgk.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgd
    public final /* synthetic */ zzgc zzf() {
        return (zzex) zzu(6, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzet zzg() {
        return (zzet) zzu(5, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzex zzi() {
        return (zzex) zzu(4, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgc
    public final /* synthetic */ zzgb zzk() {
        return (zzet) zzu(5, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzn() {
        zzgk.zza().zzb(getClass()).zzf(this);
        zzo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzo() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzq(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgc
    public final void zzr(zzee zzeeVar) throws IOException {
        zzgk.zza().zzb(getClass()).zzi(this, zzef.zza(zzeeVar));
    }

    public final boolean zzs() {
        Boolean bool = Boolean.TRUE;
        byte byteValue = ((Byte) zzu(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzgk.zza().zzb(getClass()).zzk(this);
        zzu(2, true != zzk ? null : this, null);
        return zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzt() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzu(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.play_billing.zzgc
    public final int zze() {
        int i;
        if (zzt()) {
            i = zzv(null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zzd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = zzv(null);
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
