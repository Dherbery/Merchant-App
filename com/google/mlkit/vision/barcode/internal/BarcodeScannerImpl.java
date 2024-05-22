package com.google.mlkit.vision.barcode.internal;

import android.graphics.Point;
import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.mlkit_vision_barcode.zzew;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpx;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpz;
import com.google.android.gms.internal.mlkit_vision_barcode.zztx;
import com.google.android.gms.internal.mlkit_vision_barcode.zzua;
import com.google.android.gms.internal.mlkit_vision_barcode.zzus;
import com.google.android.gms.internal.mlkit_vision_barcode.zzuv;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.ZoomSuggestionOptions;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes5.dex */
public class BarcodeScannerImpl extends MobileVisionBase<List<Barcode>> implements BarcodeScanner {
    public static final /* synthetic */ int zzc = 0;
    private static final BarcodeScannerOptions zzd = new BarcodeScannerOptions.Builder().build();

    @Nullable
    final zzus zzb;
    private final boolean zze;
    private final BarcodeScannerOptions zzf;
    private int zzg;
    private boolean zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BarcodeScannerImpl(BarcodeScannerOptions barcodeScannerOptions, zzk zzkVar, Executor executor, zztx zztxVar, MlKitContext mlKitContext) {
        super(zzkVar, executor);
        zzus zzd2;
        ZoomSuggestionOptions zzb = barcodeScannerOptions.zzb();
        if (zzb == null) {
            zzd2 = null;
        } else {
            zzd2 = zzus.zzd(mlKitContext.getApplicationContext(), mlKitContext.getApplicationContext().getPackageName());
            zzd2.zzo(new zzf(zzb), zzew.zza());
            if (zzb.zza() >= 1.0f) {
                zzd2.zzk(zzb.zza());
            }
            zzd2.zzm();
        }
        this.zzf = barcodeScannerOptions;
        boolean zzf = zzb.zzf();
        this.zze = zzf;
        zzpx zzpxVar = new zzpx();
        zzpxVar.zzi(zzb.zzc(barcodeScannerOptions));
        zzpz zzj = zzpxVar.zzj();
        zzpl zzplVar = new zzpl();
        zzplVar.zze(zzf ? zzpi.TYPE_THICK : zzpi.TYPE_THIN);
        zzplVar.zzg(zzj);
        zztxVar.zzd(zzua.zzg(zzplVar, 1), zzpk.ON_DEVICE_BARCODE_CREATE);
        this.zzb = zzd2;
    }

    private final Task zzf(Task task, final int i, final int i2) {
        return task.onSuccessTask(new SuccessContinuation() { // from class: com.google.mlkit.vision.barcode.internal.zze
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return BarcodeScannerImpl.this.zzd(i, i2, (List) obj);
            }
        });
    }

    @Override // com.google.mlkit.vision.common.internal.MobileVisionBase, java.io.Closeable, java.lang.AutoCloseable, com.google.mlkit.vision.barcode.BarcodeScanner
    public final synchronized void close() {
        zzus zzusVar = this.zzb;
        if (zzusVar != null) {
            zzusVar.zzn(this.zzh);
            this.zzb.zzj();
        }
        super.close();
    }

    @Override // com.google.mlkit.vision.interfaces.Detector
    public final int getDetectorType() {
        return 1;
    }

    @Override // com.google.android.gms.common.api.OptionalModuleApi
    public final Feature[] getOptionalFeatures() {
        return this.zze ? OptionalModuleUtils.EMPTY_FEATURES : new Feature[]{OptionalModuleUtils.FEATURE_BARCODE};
    }

    @Override // com.google.mlkit.vision.barcode.BarcodeScanner
    public final Task<List<Barcode>> process(MlImage mlImage) {
        return zzf(super.processBase(mlImage), mlImage.getWidth(), mlImage.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task zzd(int i, int i2, List list) throws Exception {
        if (this.zzb == null) {
            return Tasks.forResult(list);
        }
        boolean z = true;
        this.zzg++;
        List arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Barcode barcode = (Barcode) it.next();
            if (barcode.getFormat() == -1) {
                arrayList2.add(barcode);
            } else {
                arrayList.add(barcode);
            }
        }
        if (arrayList.isEmpty()) {
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Point[] cornerPoints = ((Barcode) arrayList2.get(i3)).getCornerPoints();
                if (cornerPoints != null) {
                    zzus zzusVar = this.zzb;
                    int i4 = this.zzg;
                    int i5 = i;
                    int i6 = i2;
                    int i7 = 0;
                    int i8 = 0;
                    for (Point point : Arrays.asList(cornerPoints)) {
                        i5 = Math.min(i5, point.x);
                        i6 = Math.min(i6, point.y);
                        i7 = Math.max(i7, point.x);
                        i8 = Math.max(i8, point.y);
                    }
                    float f = i;
                    float f2 = i2;
                    zzusVar.zzi(i4, zzuv.zzg((i5 + 0.0f) / f, (i6 + 0.0f) / f2, (i7 + 0.0f) / f, (i8 + 0.0f) / f2, 0.0f));
                }
                i3++;
                z = true;
            }
        } else {
            this.zzh = true;
        }
        if (z == this.zzf.zzd()) {
            arrayList = list;
        }
        return Tasks.forResult(arrayList);
    }

    @Override // com.google.mlkit.vision.barcode.BarcodeScanner
    public final Task<List<Barcode>> process(InputImage inputImage) {
        return zzf(super.processBase(inputImage), inputImage.getWidth(), inputImage.getHeight());
    }
}
