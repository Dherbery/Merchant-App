package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Comparator;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzct implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzdb zzdbVar = (zzdb) obj;
        zzdb zzdbVar2 = (zzdb) obj2;
        zzcw it = zzdbVar.iterator();
        zzcw it2 = zzdbVar2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compareTo = Integer.valueOf(it.zza() & 255).compareTo(Integer.valueOf(it2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzdbVar.zzd()).compareTo(Integer.valueOf(zzdbVar2.zzd()));
    }
}
