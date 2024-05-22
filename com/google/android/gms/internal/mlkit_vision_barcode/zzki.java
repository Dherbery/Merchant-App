package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzki implements ObjectEncoder {
    static final zzki zza = new zzki();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("options");
        zzfc zzfcVar = new zzfc();
        zzfcVar.zza(1);
        zzb = builder.withProperty(zzfcVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("roughDownloadDurationMs");
        zzfc zzfcVar2 = new zzfc();
        zzfcVar2.zza(2);
        zzc = builder2.withProperty(zzfcVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("errorCode");
        zzfc zzfcVar3 = new zzfc();
        zzfcVar3.zza(3);
        zzd = builder3.withProperty(zzfcVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("exactDownloadDurationMs");
        zzfc zzfcVar4 = new zzfc();
        zzfcVar4.zza(4);
        zze = builder4.withProperty(zzfcVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("downloadStatus");
        zzfc zzfcVar5 = new zzfc();
        zzfcVar5.zza(5);
        zzf = builder5.withProperty(zzfcVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("downloadFailureStatus");
        zzfc zzfcVar6 = new zzfc();
        zzfcVar6.zza(6);
        zzg = builder6.withProperty(zzfcVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("mddDownloadErrorCodes");
        zzfc zzfcVar7 = new zzfc();
        zzfcVar7.zza(7);
        zzh = builder7.withProperty(zzfcVar7.zzb()).build();
    }

    private zzki() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
