package com.google.mlkit.vision.barcode.internal;

import android.os.SystemClock;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzfs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzft;
import com.google.android.gms.internal.mlkit_vision_barcode.zzfv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzol;
import com.google.android.gms.internal.mlkit_vision_barcode.zzop;
import com.google.android.gms.internal.mlkit_vision_barcode.zzoq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzow;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpx;
import com.google.android.gms.internal.mlkit_vision_barcode.zztm;
import com.google.android.gms.internal.mlkit_vision_barcode.zztw;
import com.google.android.gms.internal.mlkit_vision_barcode.zztx;
import com.google.android.gms.internal.mlkit_vision_barcode.zztz;
import com.google.android.gms.internal.mlkit_vision_barcode.zzua;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.BitmapInStreamingChecker;
import com.google.mlkit.vision.common.internal.ImageUtils;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes5.dex */
public final class zzk extends MLTask {
    private final BarcodeScannerOptions zzc;
    private final zzl zzd;
    private final zztx zze;
    private final zztz zzf;
    private final BitmapInStreamingChecker zzg = new BitmapInStreamingChecker();
    private boolean zzh;
    private static final ImageUtils zzb = ImageUtils.getInstance();
    static boolean zza = true;

    public zzk(MlKitContext mlKitContext, BarcodeScannerOptions barcodeScannerOptions, zzl zzlVar, zztx zztxVar) {
        Preconditions.checkNotNull(mlKitContext, "MlKitContext can not be null");
        Preconditions.checkNotNull(barcodeScannerOptions, "BarcodeScannerOptions can not be null");
        this.zzc = barcodeScannerOptions;
        this.zzd = zzlVar;
        this.zze = zztxVar;
        this.zzf = zztz.zza(mlKitContext.getApplicationContext());
    }

    private final void zzf(final zzpj zzpjVar, long j, final InputImage inputImage, List list) {
        final zzcs zzcsVar = new zzcs();
        final zzcs zzcsVar2 = new zzcs();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Barcode barcode = (Barcode) it.next();
                zzcsVar.zzd(zzb.zza(barcode.getFormat()));
                zzcsVar2.zzd(zzb.zzb(barcode.getValueType()));
            }
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zze.zzf(new zztw() { // from class: com.google.mlkit.vision.barcode.internal.zzi
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztw
            public final zztm zza() {
                return zzk.this.zzc(elapsedRealtime, zzpjVar, zzcsVar, zzcsVar2, inputImage);
            }
        }, zzpk.ON_DEVICE_BARCODE_DETECT);
        zzft zzftVar = new zzft();
        zzftVar.zze(zzpjVar);
        zzftVar.zzf(Boolean.valueOf(zza));
        zzftVar.zzg(zzb.zzc(this.zzc));
        zzftVar.zzc(zzcsVar.zzf());
        zzftVar.zzd(zzcsVar2.zzf());
        final zzfv zzh = zzftVar.zzh();
        final zzj zzjVar = new zzj(this);
        final zztx zztxVar = this.zze;
        final zzpk zzpkVar = zzpk.AGGREGATED_ON_DEVICE_BARCODE_DETECTION;
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zztu
            @Override // java.lang.Runnable
            public final void run() {
                zztx.this.zzh(zzpkVar, zzh, elapsedRealtime, zzjVar);
            }
        });
        long currentTimeMillis = System.currentTimeMillis();
        this.zzf.zzc(true != this.zzh ? 24301 : 24302, zzpjVar.zza(), currentTimeMillis - elapsedRealtime, currentTimeMillis);
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final synchronized void load() throws MlKitException {
        this.zzh = this.zzd.zzc();
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final synchronized void release() {
        this.zzd.zzb();
        zza = true;
        zztx zztxVar = this.zze;
        zzpl zzplVar = new zzpl();
        zzplVar.zze(this.zzh ? zzpi.TYPE_THICK : zzpi.TYPE_THIN);
        zzpx zzpxVar = new zzpx();
        zzpxVar.zzi(zzb.zzc(this.zzc));
        zzplVar.zzg(zzpxVar.zzj());
        zztxVar.zzd(zzua.zzf(zzplVar), zzpk.ON_DEVICE_BARCODE_CLOSE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zztm zzc(long j, zzpj zzpjVar, zzcs zzcsVar, zzcs zzcsVar2, InputImage inputImage) {
        zzoq zzoqVar;
        zzpx zzpxVar = new zzpx();
        zzow zzowVar = new zzow();
        zzowVar.zzc(Long.valueOf(j));
        zzowVar.zzd(zzpjVar);
        zzowVar.zze(Boolean.valueOf(zza));
        zzowVar.zza(true);
        zzowVar.zzb(true);
        zzpxVar.zzh(zzowVar.zzf());
        zzpxVar.zzi(zzb.zzc(this.zzc));
        zzpxVar.zze(zzcsVar.zzf());
        zzpxVar.zzf(zzcsVar2.zzf());
        int format = inputImage.getFormat();
        int mobileVisionImageSize = zzb.getMobileVisionImageSize(inputImage);
        zzop zzopVar = new zzop();
        if (format == -1) {
            zzoqVar = zzoq.BITMAP;
        } else if (format == 35) {
            zzoqVar = zzoq.YUV_420_888;
        } else if (format == 842094169) {
            zzoqVar = zzoq.YV12;
        } else if (format == 16) {
            zzoqVar = zzoq.NV16;
        } else if (format == 17) {
            zzoqVar = zzoq.NV21;
        } else {
            zzoqVar = zzoq.UNKNOWN_FORMAT;
        }
        zzopVar.zza(zzoqVar);
        zzopVar.zzb(Integer.valueOf(mobileVisionImageSize));
        zzpxVar.zzg(zzopVar.zzd());
        zzpl zzplVar = new zzpl();
        zzplVar.zze(this.zzh ? zzpi.TYPE_THICK : zzpi.TYPE_THIN);
        zzplVar.zzg(zzpxVar.zzj());
        return zzua.zzf(zzplVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zztm zzd(zzfv zzfvVar, int i, zzol zzolVar) {
        zzpl zzplVar = new zzpl();
        zzplVar.zze(this.zzh ? zzpi.TYPE_THICK : zzpi.TYPE_THIN);
        zzfs zzfsVar = new zzfs();
        zzfsVar.zza(Integer.valueOf(i));
        zzfsVar.zzc(zzfvVar);
        zzfsVar.zzb(zzolVar);
        zzplVar.zzd(zzfsVar.zze());
        return zzua.zzf(zzplVar);
    }

    @Override // com.google.mlkit.common.sdkinternal.MLTask
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final synchronized List run(InputImage inputImage) throws MlKitException {
        zzpj zzpjVar;
        List zza2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.zzg.check(inputImage);
        try {
            zza2 = this.zzd.zza(inputImage);
            zzf(zzpj.NO_ERROR, elapsedRealtime, inputImage, zza2);
            zza = false;
        } catch (MlKitException e) {
            if (e.getErrorCode() == 14) {
                zzpjVar = zzpj.MODEL_NOT_DOWNLOADED;
            } else {
                zzpjVar = zzpj.UNKNOWN_ERROR;
            }
            zzf(zzpjVar, elapsedRealtime, inputImage, null);
            throw e;
        }
        return zza2;
    }
}
