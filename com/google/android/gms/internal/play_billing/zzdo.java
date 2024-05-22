package com.google.android.gms.internal.play_billing;

import java.util.Comparator;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
final class zzdo implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzdw zzdwVar = (zzdw) obj;
        zzdw zzdwVar2 = (zzdw) obj2;
        zzdn zzdnVar = new zzdn(zzdwVar);
        zzdn zzdnVar2 = new zzdn(zzdwVar2);
        while (zzdnVar.hasNext() && zzdnVar2.hasNext()) {
            int compareTo = Integer.valueOf(zzdnVar.zza() & 255).compareTo(Integer.valueOf(zzdnVar2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzdwVar.zzd()).compareTo(Integer.valueOf(zzdwVar2.zzd()));
    }
}
