package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzms implements ObjectEncoder {
    static final zzms zza = new zzms();
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
    private static final FieldDescriptor zzl;
    private static final FieldDescriptor zzm;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("deviceInfo");
        zzfc zzfcVar = new zzfc();
        zzfcVar.zza(1);
        zzb = builder.withProperty(zzfcVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("nnapiInfo");
        zzfc zzfcVar2 = new zzfc();
        zzfcVar2.zza(2);
        zzc = builder2.withProperty(zzfcVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("gpuInfo");
        zzfc zzfcVar3 = new zzfc();
        zzfcVar3.zza(3);
        zzd = builder3.withProperty(zzfcVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("pipelineIdentifier");
        zzfc zzfcVar4 = new zzfc();
        zzfcVar4.zza(4);
        zze = builder4.withProperty(zzfcVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("acceptedConfigurations");
        zzfc zzfcVar5 = new zzfc();
        zzfcVar5.zza(5);
        zzf = builder5.withProperty(zzfcVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("action");
        zzfc zzfcVar6 = new zzfc();
        zzfcVar6.zza(6);
        zzg = builder6.withProperty(zzfcVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("status");
        zzfc zzfcVar7 = new zzfc();
        zzfcVar7.zza(7);
        zzh = builder7.withProperty(zzfcVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("customErrors");
        zzfc zzfcVar8 = new zzfc();
        zzfcVar8.zza(8);
        zzi = builder8.withProperty(zzfcVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("benchmarkStatus");
        zzfc zzfcVar9 = new zzfc();
        zzfcVar9.zza(9);
        zzj = builder9.withProperty(zzfcVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("validationTestResult");
        zzfc zzfcVar10 = new zzfc();
        zzfcVar10.zza(10);
        zzk = builder10.withProperty(zzfcVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("timestampUs");
        zzfc zzfcVar11 = new zzfc();
        zzfcVar11.zza(11);
        zzl = builder11.withProperty(zzfcVar11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("elapsedUs");
        zzfc zzfcVar12 = new zzfc();
        zzfcVar12.zza(12);
        zzm = builder12.withProperty(zzfcVar12.zzb()).build();
    }

    private zzms() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
