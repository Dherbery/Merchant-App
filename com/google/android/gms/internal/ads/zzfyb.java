package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public abstract class zzfyb extends zzgce {

    @CheckForNull
    private Object zza;
    private int zzb = 2;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zzfxe.zzi(this.zzb != 4);
        int i = this.zzb;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 == 0) {
            return true;
        }
        if (i2 != 2) {
            this.zzb = 4;
            this.zza = zza();
            if (this.zzb != 3) {
                this.zzb = 1;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.zzb = 2;
            Object obj = this.zza;
            this.zza = null;
            return obj;
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    protected abstract Object zza();

    /* JADX INFO: Access modifiers changed from: protected */
    @CheckForNull
    public final Object zzb() {
        this.zzb = 3;
        return null;
    }
}
