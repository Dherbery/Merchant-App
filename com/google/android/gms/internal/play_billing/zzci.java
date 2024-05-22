package com.google.android.gms.internal.play_billing;

import java.util.Set;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
final class zzci extends zzby {
    private final zzbd zza;
    private final Level zzb;
    private final Set zzc;
    private final zzbq zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzci(String str, @NullableDecl String str2, boolean z, zzbd zzbdVar, boolean z2, boolean z3) {
        super(str2);
        Set set;
        zzbq zzbqVar;
        Level level = Level.ALL;
        set = zzck.zza;
        zzbqVar = zzck.zzb;
        this.zza = zzbdVar;
        this.zzb = level;
        this.zzc = set;
        this.zzd = zzbqVar;
    }
}
