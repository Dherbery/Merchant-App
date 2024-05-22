package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzey extends zzfc {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzey() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzey(zzex zzexVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfc
    public final void zza(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzhi.zzf(obj, j);
        if (list instanceof zzew) {
            unmodifiableList = ((zzew) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if (!(list instanceof zzfw) || !(list instanceof zzel)) {
                unmodifiableList = Collections.unmodifiableList(list);
            } else {
                zzel zzelVar = (zzel) list;
                if (zzelVar.zzc()) {
                    zzelVar.zzb();
                    return;
                }
                return;
            }
        }
        zzhi.zzs(obj, j, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfc
    public final void zzb(Object obj, Object obj2, long j) {
        zzev zzevVar;
        List list = (List) zzhi.zzf(obj2, j);
        int size = list.size();
        List list2 = (List) zzhi.zzf(obj, j);
        if (list2.isEmpty()) {
            if (list2 instanceof zzew) {
                list2 = new zzev(size);
            } else if (!(list2 instanceof zzfw) || !(list2 instanceof zzel)) {
                list2 = new ArrayList(size);
            } else {
                list2 = ((zzel) list2).zzd(size);
            }
            zzhi.zzs(obj, j, list2);
        } else {
            if (zza.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList = new ArrayList(list2.size() + size);
                arrayList.addAll(list2);
                zzhi.zzs(obj, j, arrayList);
                zzevVar = arrayList;
            } else if (list2 instanceof zzhd) {
                zzev zzevVar2 = new zzev(list2.size() + size);
                zzevVar2.addAll(zzevVar2.size(), (zzhd) list2);
                zzhi.zzs(obj, j, zzevVar2);
                zzevVar = zzevVar2;
            } else if ((list2 instanceof zzfw) && (list2 instanceof zzel)) {
                zzel zzelVar = (zzel) list2;
                if (!zzelVar.zzc()) {
                    list2 = zzelVar.zzd(list2.size() + size);
                    zzhi.zzs(obj, j, list2);
                }
            }
            list2 = zzevVar;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        zzhi.zzs(obj, j, list);
    }
}
