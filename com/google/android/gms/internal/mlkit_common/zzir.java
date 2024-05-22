package com.google.android.gms.internal.mlkit_common;

import com.amazon.a.a.o.b;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
final class zzir implements ObjectEncoder {
    static final zzir zza = new zzir();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("languageOption");
        zzbk zzbkVar = new zzbk();
        zzbkVar.zza(3);
        zzb = builder.withProperty(zzbkVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("isUsingLegacyApi");
        zzbk zzbkVar2 = new zzbk();
        zzbkVar2.zza(4);
        zzc = builder2.withProperty(zzbkVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder(b.I);
        zzbk zzbkVar3 = new zzbk();
        zzbkVar3.zza(5);
        zzd = builder3.withProperty(zzbkVar3.zzb()).build();
    }

    private zzir() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
