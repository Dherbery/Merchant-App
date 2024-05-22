package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
public final class zzpu implements zzpr {
    final List zza;

    public zzpu(Context context, zzpt zzptVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzptVar.zzc()) {
            arrayList.add(new zzqh(context, zzptVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpr
    public final void zza(zzpq zzpqVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzpr) it.next()).zza(zzpqVar);
        }
    }
}
