package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zztq implements zztn {
    final List zza;

    public zztq(Context context, zztp zztpVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zztpVar.zzc()) {
            arrayList.add(new zzuf(context, zztpVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztn
    public final void zza(zztm zztmVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zztn) it.next()).zza(zztmVar);
        }
    }
}
