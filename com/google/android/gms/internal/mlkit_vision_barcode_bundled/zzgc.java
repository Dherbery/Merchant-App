package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzgc {
    private final ArrayDeque zza = new ArrayDeque();

    private zzgc() {
    }

    public static /* bridge */ /* synthetic */ zzdb zza(zzgc zzgcVar, zzdb zzdbVar, zzdb zzdbVar2) {
        zzgcVar.zzb(zzdbVar);
        zzgcVar.zzb(zzdbVar2);
        zzdb zzdbVar3 = (zzdb) zzgcVar.zza.pop();
        while (!zzgcVar.zza.isEmpty()) {
            zzdbVar3 = new zzgg((zzdb) zzgcVar.zza.pop(), zzdbVar3);
        }
        return zzdbVar3;
    }

    private final void zzb(zzdb zzdbVar) {
        zzdb zzdbVar2;
        zzdb zzdbVar3;
        if (zzdbVar.zzh()) {
            int zzc = zzc(zzdbVar.zzd());
            int zzc2 = zzgg.zzc(zzc + 1);
            if (this.zza.isEmpty() || ((zzdb) this.zza.peek()).zzd() >= zzc2) {
                this.zza.push(zzdbVar);
                return;
            }
            int zzc3 = zzgg.zzc(zzc);
            zzdb zzdbVar4 = (zzdb) this.zza.pop();
            while (true) {
                if (this.zza.isEmpty() || ((zzdb) this.zza.peek()).zzd() >= zzc3) {
                    break;
                } else {
                    zzdbVar4 = new zzgg((zzdb) this.zza.pop(), zzdbVar4);
                }
            }
            zzgg zzggVar = new zzgg(zzdbVar4, zzdbVar);
            while (!this.zza.isEmpty()) {
                if (((zzdb) this.zza.peek()).zzd() >= zzgg.zzc(zzc(zzggVar.zzd()) + 1)) {
                    break;
                } else {
                    zzggVar = new zzgg((zzdb) this.zza.pop(), zzggVar);
                }
            }
            this.zza.push(zzggVar);
            return;
        }
        if (!(zzdbVar instanceof zzgg)) {
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(String.valueOf(zzdbVar.getClass()))));
        }
        zzgg zzggVar2 = (zzgg) zzdbVar;
        zzdbVar2 = zzggVar2.zzd;
        zzb(zzdbVar2);
        zzdbVar3 = zzggVar2.zze;
        zzb(zzdbVar3);
    }

    private static final int zzc(int i) {
        int binarySearch = Arrays.binarySearch(zzgg.zza, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    public /* synthetic */ zzgc(zzgb zzgbVar) {
    }
}
