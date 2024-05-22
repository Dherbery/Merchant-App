package com.google.android.gms.internal.maps;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes4.dex */
public final class zzax extends zzau {
    private final zzaz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzax(zzaz zzazVar, int i) {
        super(zzazVar.size(), i);
        this.zza = zzazVar;
    }

    @Override // com.google.android.gms.internal.maps.zzau
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
