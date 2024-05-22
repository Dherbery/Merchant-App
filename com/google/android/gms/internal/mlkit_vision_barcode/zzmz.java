package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzmz implements ObjectEncoder {
    static final zzmz zza = new zzmz();
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
    private static final FieldDescriptor zzn;
    private static final FieldDescriptor zzo;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("appId");
        zzfc zzfcVar = new zzfc();
        zzfcVar.zza(1);
        zzb = builder.withProperty(zzfcVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("appVersion");
        zzfc zzfcVar2 = new zzfc();
        zzfcVar2.zza(2);
        zzc = builder2.withProperty(zzfcVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zzfc zzfcVar3 = new zzfc();
        zzfcVar3.zza(3);
        zzd = builder3.withProperty(zzfcVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zzfc zzfcVar4 = new zzfc();
        zzfcVar4.zza(4);
        zze = builder4.withProperty(zzfcVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zzfc zzfcVar5 = new zzfc();
        zzfcVar5.zza(5);
        zzf = builder5.withProperty(zzfcVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zzfc zzfcVar6 = new zzfc();
        zzfcVar6.zza(6);
        zzg = builder6.withProperty(zzfcVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zzfc zzfcVar7 = new zzfc();
        zzfcVar7.zza(7);
        zzh = builder7.withProperty(zzfcVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zzfc zzfcVar8 = new zzfc();
        zzfcVar8.zza(8);
        zzi = builder8.withProperty(zzfcVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zzfc zzfcVar9 = new zzfc();
        zzfcVar9.zza(9);
        zzj = builder9.withProperty(zzfcVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zzfc zzfcVar10 = new zzfc();
        zzfcVar10.zza(10);
        zzk = builder10.withProperty(zzfcVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zzfc zzfcVar11 = new zzfc();
        zzfcVar11.zza(11);
        zzl = builder11.withProperty(zzfcVar11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zzfc zzfcVar12 = new zzfc();
        zzfcVar12.zza(12);
        zzm = builder12.withProperty(zzfcVar12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zzfc zzfcVar13 = new zzfc();
        zzfcVar13.zza(13);
        zzn = builder13.withProperty(zzfcVar13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("optionalModuleVersion");
        zzfc zzfcVar14 = new zzfc();
        zzfcVar14.zza(14);
        zzo = builder14.withProperty(zzfcVar14.zzb()).build();
    }

    private zzmz() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzsl zzslVar = (zzsl) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzslVar.zzg());
        objectEncoderContext2.add(zzc, zzslVar.zzh());
        objectEncoderContext2.add(zzd, (Object) null);
        objectEncoderContext2.add(zze, zzslVar.zzj());
        objectEncoderContext2.add(zzf, zzslVar.zzk());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, zzslVar.zza());
        objectEncoderContext2.add(zzj, zzslVar.zzi());
        objectEncoderContext2.add(zzk, zzslVar.zzb());
        objectEncoderContext2.add(zzl, zzslVar.zzd());
        objectEncoderContext2.add(zzm, zzslVar.zzc());
        objectEncoderContext2.add(zzn, zzslVar.zze());
        objectEncoderContext2.add(zzo, zzslVar.zzf());
    }
}
