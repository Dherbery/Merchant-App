package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.vision.barcode.ZoomSuggestionOptions;
import com.google.mlkit.vision.barcode.internal.BarcodeScannerImpl;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzus {
    private static final GmsLogger zzf = new GmsLogger("AutoZoom");
    final zzuu zza;
    final zzbz zzb;

    @Nullable
    ScheduledFuture zzc;

    @Nullable
    String zzd;
    int zze;
    private final AtomicBoolean zzg;
    private final Object zzh;
    private final ScheduledExecutorService zzi;
    private final zzbf zzj;
    private final zztx zzk;
    private final String zzl;
    private Executor zzm;
    private float zzn;
    private float zzo;
    private long zzp;
    private long zzq;
    private boolean zzr;
    private com.google.mlkit.vision.barcode.internal.zzf zzs;

    private zzus(Context context, zzuu zzuuVar, String str) {
        zzg.zza();
        ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(2));
        zzbf zza = zzar.zza();
        zztx zztxVar = new zztx(context, new SharedPrefManager(context), new zztq(context, zztp.zzd("scanner-auto-zoom").zzd()), "scanner-auto-zoom");
        this.zzh = new Object();
        this.zza = zzuuVar;
        this.zzg = new AtomicBoolean(false);
        this.zzb = zzbz.zzz();
        this.zzi = unconfigurableScheduledExecutorService;
        this.zzj = zza;
        this.zzk = zztxVar;
        this.zzl = str;
        this.zze = 1;
        this.zzn = 1.0f;
        this.zzo = -1.0f;
        this.zzp = zza.zza();
    }

    public static zzus zzd(Context context, String str) {
        return new zzus(context, zzuu.zzb, str);
    }

    public static /* synthetic */ void zzf(zzus zzusVar) {
        ScheduledFuture scheduledFuture;
        synchronized (zzusVar.zzh) {
            if (zzusVar.zze == 2 && !zzusVar.zzg.get() && (scheduledFuture = zzusVar.zzc) != null && !scheduledFuture.isCancelled()) {
                if (zzusVar.zzn > 1.0f && zzusVar.zza() >= zzusVar.zza.zzi()) {
                    zzf.i("AutoZoom", "Reset zoom = 1");
                    zzusVar.zzl(1.0f, zzpk.SCANNER_AUTO_ZOOM_AUTO_RESET, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzg(zzus zzusVar, float f) {
        synchronized (zzusVar.zzh) {
            zzusVar.zzn = f;
            zzusVar.zzr(false);
        }
    }

    private final float zzp(float f) {
        float f2 = this.zzo;
        if (f < 1.0f) {
            f = 1.0f;
        }
        return (f2 <= 0.0f || f <= f2) ? f : f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzq(zzpk zzpkVar, float f, float f2, @Nullable zzuv zzuvVar) {
        long convert;
        if (this.zzd != null) {
            zzsb zzsbVar = new zzsb();
            zzsbVar.zza(this.zzl);
            String str = this.zzd;
            str.getClass();
            zzsbVar.zze(str);
            zzsbVar.zzf(Float.valueOf(f));
            zzsbVar.zzc(Float.valueOf(f2));
            synchronized (this.zzh) {
                convert = TimeUnit.MILLISECONDS.convert(this.zzj.zza() - this.zzq, TimeUnit.NANOSECONDS);
            }
            zzsbVar.zzb(Long.valueOf(convert));
            if (zzuvVar != null) {
                zzsc zzscVar = new zzsc();
                zzscVar.zzc(Float.valueOf(zzuvVar.zzc()));
                zzscVar.zze(Float.valueOf(zzuvVar.zze()));
                zzscVar.zzb(Float.valueOf(zzuvVar.zzb()));
                zzscVar.zzd(Float.valueOf(zzuvVar.zzd()));
                zzscVar.zza(Float.valueOf(0.0f));
                zzsbVar.zzd(zzscVar.zzf());
            }
            zztx zztxVar = this.zzk;
            zzpl zzplVar = new zzpl();
            zzplVar.zzi(zzsbVar.zzh());
            zztxVar.zzd(zzua.zzf(zzplVar), zzpkVar);
        }
    }

    private final void zzr(boolean z) {
        ScheduledFuture scheduledFuture;
        synchronized (this.zzh) {
            this.zzb.zzs();
            this.zzp = this.zzj.zza();
            if (z && (scheduledFuture = this.zzc) != null) {
                scheduledFuture.cancel(false);
                this.zzc = null;
            }
        }
    }

    public final long zza() {
        long convert;
        synchronized (this.zzh) {
            convert = TimeUnit.MILLISECONDS.convert(this.zzj.zza() - this.zzp, TimeUnit.NANOSECONDS);
        }
        return convert;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzev zzc(float f) throws Exception {
        com.google.mlkit.vision.barcode.internal.zzf zzfVar = this.zzs;
        float zzp = zzp(f);
        ZoomSuggestionOptions zoomSuggestionOptions = zzfVar.zza;
        int i = BarcodeScannerImpl.zzc;
        if (true != zoomSuggestionOptions.zzb().setZoom(zzp)) {
            zzp = 0.0f;
        }
        return zzem.zza(Float.valueOf(zzp));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x015d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00df A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(int r13, com.google.android.gms.internal.mlkit_vision_barcode.zzuv r14) {
        /*
            Method dump skipped, instructions count: 620
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzus.zzi(int, com.google.android.gms.internal.mlkit_vision_barcode.zzuv):void");
    }

    public final void zzj() {
        synchronized (this.zzh) {
            if (this.zze == 4) {
                return;
            }
            zzn(false);
            this.zzi.shutdown();
            this.zze = 4;
        }
    }

    public final void zzk(float f) {
        synchronized (this.zzh) {
            zzbc.zzc(f >= 1.0f);
            this.zzo = f;
        }
    }

    final void zzl(float f, zzpk zzpkVar, @Nullable zzuv zzuvVar) {
        synchronized (this.zzh) {
            if (this.zzm != null && this.zzs != null && this.zze == 2) {
                if (this.zzg.compareAndSet(false, true)) {
                    zzem.zzb(zzem.zzc(new zzup(this, f), this.zzm), new zzur(this, zzpkVar, this.zzn, zzuvVar, f), zzew.zza());
                }
            }
        }
    }

    public final void zzm() {
        synchronized (this.zzh) {
            int i = this.zze;
            if (i != 2 && i != 4) {
                zzr(true);
                this.zzc = this.zzi.scheduleWithFixedDelay(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzuq
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzus.zzf(zzus.this);
                    }
                }, 500L, 500L, TimeUnit.MILLISECONDS);
                if (this.zze == 1) {
                    this.zzd = UUID.randomUUID().toString();
                    this.zzq = this.zzj.zza();
                    this.zzr = false;
                    zzpk zzpkVar = zzpk.SCANNER_AUTO_ZOOM_START;
                    float f = this.zzn;
                    zzq(zzpkVar, f, f, null);
                } else {
                    zzpk zzpkVar2 = zzpk.SCANNER_AUTO_ZOOM_RESUME;
                    float f2 = this.zzn;
                    zzq(zzpkVar2, f2, f2, null);
                }
                this.zze = 2;
            }
        }
    }

    public final void zzn(boolean z) {
        synchronized (this.zzh) {
            int i = this.zze;
            if (i != 1 && i != 4) {
                zzr(true);
                if (z) {
                    if (!this.zzr) {
                        zzpk zzpkVar = zzpk.SCANNER_AUTO_ZOOM_FIRST_ATTEMPT;
                        float f = this.zzn;
                        zzq(zzpkVar, f, f, null);
                    }
                    zzpk zzpkVar2 = zzpk.SCANNER_AUTO_ZOOM_SCAN_SUCCESS;
                    float f2 = this.zzn;
                    zzq(zzpkVar2, f2, f2, null);
                } else {
                    zzpk zzpkVar3 = zzpk.SCANNER_AUTO_ZOOM_SCAN_FAILED;
                    float f3 = this.zzn;
                    zzq(zzpkVar3, f3, f3, null);
                }
                this.zzr = false;
                this.zze = 1;
                this.zzd = null;
            }
        }
    }

    public final void zzo(com.google.mlkit.vision.barcode.internal.zzf zzfVar, Executor executor) {
        this.zzs = zzfVar;
        this.zzm = executor;
    }
}
