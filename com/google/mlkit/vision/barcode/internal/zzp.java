package com.google.mlkit.vision.barcode.internal;

import android.content.Context;
import android.media.Image;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_barcode.zzah;
import com.google.android.gms.internal.mlkit_vision_barcode.zzaj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzal;
import com.google.android.gms.internal.mlkit_vision_barcode.zzan;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpj;
import com.google.android.gms.internal.mlkit_vision_barcode.zztx;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes5.dex */
final class zzp implements zzl {
    private boolean zza;
    private final Context zzb;
    private final zzah zzc;
    private final zztx zzd;
    private zzaj zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(Context context, BarcodeScannerOptions barcodeScannerOptions, zztx zztxVar) {
        zzah zzahVar = new zzah();
        this.zzc = zzahVar;
        this.zzb = context;
        zzahVar.zza = barcodeScannerOptions.zza();
        this.zzd = zztxVar;
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzl
    public final List zza(InputImage inputImage) throws MlKitException {
        zzu[] zzf;
        if (this.zze == null) {
            zzc();
        }
        zzaj zzajVar = this.zze;
        if (zzajVar != null) {
            zzaj zzajVar2 = (zzaj) Preconditions.checkNotNull(zzajVar);
            zzan zzanVar = new zzan(inputImage.getWidth(), inputImage.getHeight(), 0, 0L, CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees()));
            try {
                int format = inputImage.getFormat();
                if (format == -1) {
                    zzf = zzajVar2.zzf(ObjectWrapper.wrap(inputImage.getBitmapInternal()), zzanVar);
                } else if (format == 17) {
                    zzf = zzajVar2.zze(ObjectWrapper.wrap(inputImage.getByteBuffer()), zzanVar);
                } else if (format == 35) {
                    Image.Plane[] planeArr = (Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes());
                    zzanVar.zza = planeArr[0].getRowStride();
                    zzf = zzajVar2.zze(ObjectWrapper.wrap(planeArr[0].getBuffer()), zzanVar);
                } else if (format == 842094169) {
                    zzf = zzajVar2.zze(ObjectWrapper.wrap(ImageConvertUtils.getInstance().convertToNv21Buffer(inputImage, false)), zzanVar);
                } else {
                    throw new MlKitException("Unsupported image format: " + inputImage.getFormat(), 3);
                }
                ArrayList arrayList = new ArrayList();
                for (zzu zzuVar : zzf) {
                    arrayList.add(new Barcode(new zzo(zzuVar), inputImage.getCoordinatesMatrix()));
                }
                return arrayList;
            } catch (RemoteException e) {
                throw new MlKitException("Failed to detect with legacy barcode detector", 13, e);
            }
        }
        throw new MlKitException("Error initializing the legacy barcode scanner.", 14);
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzl
    public final void zzb() {
        zzaj zzajVar = this.zze;
        if (zzajVar != null) {
            try {
                zzajVar.zzd();
            } catch (RemoteException e) {
                Log.e("LegacyBarcodeScanner", "Failed to release legacy barcode detector.", e);
            }
            this.zze = null;
        }
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzl
    public final boolean zzc() throws MlKitException {
        if (this.zze != null) {
            return false;
        }
        try {
            zzaj zzd = zzal.zza(DynamiteModule.load(this.zzb, DynamiteModule.PREFER_REMOTE, OptionalModuleUtils.DEPRECATED_DYNAMITE_MODULE_ID).instantiate("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator")).zzd(ObjectWrapper.wrap(this.zzb), this.zzc);
            this.zze = zzd;
            if (zzd == null && !this.zza) {
                Log.d("LegacyBarcodeScanner", "Request optional module download.");
                OptionalModuleUtils.requestDownload(this.zzb, OptionalModuleUtils.BARCODE);
                this.zza = true;
                zzb.zze(this.zzd, zzpj.OPTIONAL_MODULE_NOT_AVAILABLE);
                throw new MlKitException("Waiting for the barcode module to be downloaded. Please wait.", 14);
            }
            zzb.zze(this.zzd, zzpj.NO_ERROR);
            return false;
        } catch (RemoteException e) {
            throw new MlKitException("Failed to create legacy barcode detector.", 13, e);
        } catch (DynamiteModule.LoadingException e2) {
            throw new MlKitException("Failed to load deprecated vision dynamite module.", 13, e2);
        }
    }
}
