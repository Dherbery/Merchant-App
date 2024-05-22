package com.google.android.gms.internal.mlkit_vision_barcode;

import com.amazon.a.a.o.b;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzjh implements ObjectEncoder {
    static final zzjh zza = new zzjh();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;
    private static final FieldDescriptor zzk;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(b.I);
        zzfc zzfcVar = new zzfc();
        zzfcVar.zza(1);
        zzb = builder.withProperty(zzfcVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("osBuild");
        zzfc zzfcVar2 = new zzfc();
        zzfcVar2.zza(2);
        zzc = builder2.withProperty(zzfcVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("brand");
        zzfc zzfcVar3 = new zzfc();
        zzfcVar3.zza(3);
        zzd = builder3.withProperty(zzfcVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("device");
        zzfc zzfcVar4 = new zzfc();
        zzfcVar4.zza(4);
        zze = builder4.withProperty(zzfcVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("hardware");
        zzfc zzfcVar5 = new zzfc();
        zzfcVar5.zza(5);
        zzf = builder5.withProperty(zzfcVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("manufacturer");
        zzfc zzfcVar6 = new zzfc();
        zzfcVar6.zza(6);
        zzg = builder6.withProperty(zzfcVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("model");
        zzfc zzfcVar7 = new zzfc();
        zzfcVar7.zza(7);
        zzh = builder7.withProperty(zzfcVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("product");
        zzfc zzfcVar8 = new zzfc();
        zzfcVar8.zza(8);
        zzi = builder8.withProperty(zzfcVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("soc");
        zzfc zzfcVar9 = new zzfc();
        zzfcVar9.zza(9);
        zzj = builder9.withProperty(zzfcVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("socMetaBuildId");
        zzfc zzfcVar10 = new zzfc();
        zzfcVar10.zza(10);
        zzk = builder10.withProperty(zzfcVar10.zzb()).build();
    }

    private zzjh() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
