package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzey extends zzei implements RunnableFuture {

    @CheckForNull
    private volatile zzeu zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzey(zzup zzupVar) {
        this.zzb = new zzex(this, zzupVar);
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzeu zzeuVar = this.zzb;
        if (zzeuVar != null) {
            zzeuVar.run();
        }
        this.zzb = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec
    @CheckForNull
    public final String zze() {
        zzeu zzeuVar = this.zzb;
        if (zzeuVar == null) {
            return super.zze();
        }
        return "task=[" + zzeuVar.toString() + "]";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec
    protected final void zzk() {
        zzeu zzeuVar;
        if (zzn() && (zzeuVar = this.zzb) != null) {
            zzeuVar.zze();
        }
        this.zzb = null;
    }
}
