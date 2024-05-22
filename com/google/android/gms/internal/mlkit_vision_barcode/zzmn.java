package com.google.android.gms.internal.mlkit_vision_barcode;

import com.amazon.a.a.o.b;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzmn implements ObjectEncoder {
    static final zzmn zza = new zzmn();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("languageOption");
        zzfc zzfcVar = new zzfc();
        zzfcVar.zza(3);
        zzb = builder.withProperty(zzfcVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("isUsingLegacyApi");
        zzfc zzfcVar2 = new zzfc();
        zzfcVar2.zza(4);
        zzc = builder2.withProperty(zzfcVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder(b.I);
        zzfc zzfcVar3 = new zzfc();
        zzfcVar3.zza(5);
        zzd = builder3.withProperty(zzfcVar3.zzb()).build();
    }

    private zzmn() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
