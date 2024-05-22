package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Arrays;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzaw {
    private final String zza;
    private final zzau zzb;
    private zzau zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaw(String str, zzav zzavVar) {
        zzau zzauVar = new zzau(null);
        this.zzb = zzauVar;
        this.zzc = zzauVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        zzau zzauVar = this.zzb.zzb;
        String str = "";
        while (zzauVar != null) {
            Object obj = zzauVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r3.length() - 1);
            }
            zzauVar = zzauVar.zzb;
            str = ", ";
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    public final zzaw zza(@CheckForNull Object obj) {
        zzau zzauVar = new zzau(null);
        this.zzc.zzb = zzauVar;
        this.zzc = zzauVar;
        zzauVar.zza = obj;
        return this;
    }
}
