package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzni implements ObjectEncoder {
    static final zzni zza = new zzni();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("numSamples");
        zzfc zzfcVar = new zzfc();
        zzfcVar.zza(1);
        zzb = builder.withProperty(zzfcVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("errorCode");
        zzfc zzfcVar2 = new zzfc();
        zzfcVar2.zza(2);
        zzc = builder2.withProperty(zzfcVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("metricResults");
        zzfc zzfcVar3 = new zzfc();
        zzfcVar3.zza(3);
        zzd = builder3.withProperty(zzfcVar3.zzb()).build();
    }

    private zzni() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
