package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zztx {
    private static zzcv zza;
    private static final zzcx zzb = zzcx.zzc("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
    private final String zzc;
    private final String zzd;
    private final zztn zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zztx(Context context, final SharedPrefManager sharedPrefManager, zztn zztnVar, String str) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zztnVar;
        zzuj.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zztr
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zztx.this.zzb();
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzts
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SharedPrefManager.this.getMlSdkInstanceId();
            }
        });
        zzcx zzcxVar = zzb;
        this.zzj = zzcxVar.containsKey(str) ? DynamiteModule.getRemoteVersion(context, (String) zzcxVar.get(str)) : -1;
    }

    static long zza(List list, double d) {
        return ((Long) list.get(Math.max(((int) Math.ceil((d / 100.0d) * list.size())) - 1, 0))).longValue();
    }

    private static synchronized zzcv zzi() {
        synchronized (zztx.class) {
            zzcv zzcvVar = zza;
            if (zzcvVar != null) {
                return zzcvVar;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzcs zzcsVar = new zzcs();
            for (int i = 0; i < locales.size(); i++) {
                zzcsVar.zzd(CommonUtils.languageTagFromLocale(locales.get(i)));
            }
            zzcv zzf = zzcsVar.zzf();
            zza = zzf;
            return zzf;
        }
    }

    private final String zzj() {
        if (this.zzg.isSuccessful()) {
            return (String) this.zzg.getResult();
        }
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    private final boolean zzk(zzpk zzpkVar, long j, long j2) {
        return this.zzk.get(zzpkVar) == null || j - ((Long) this.zzk.get(zzpkVar)).longValue() > TimeUnit.SECONDS.toMillis(30L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzb() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zztm zztmVar, zzpk zzpkVar, String str) {
        String mlSdkInstanceId;
        zztmVar.zzb(zzpkVar);
        String zzd = zztmVar.zzd();
        zzsj zzsjVar = new zzsj();
        zzsjVar.zzb(this.zzc);
        zzsjVar.zzc(this.zzd);
        zzsjVar.zzh(zzi());
        zzsjVar.zzg(true);
        zzsjVar.zzl(zzd);
        zzsjVar.zzj(str);
        if (this.zzh.isSuccessful()) {
            mlSdkInstanceId = (String) this.zzh.getResult();
        } else {
            mlSdkInstanceId = this.zzf.getMlSdkInstanceId();
        }
        zzsjVar.zzi(mlSdkInstanceId);
        zzsjVar.zzd(10);
        zzsjVar.zzk(Integer.valueOf(this.zzj));
        zztmVar.zzc(zzsjVar);
        this.zze.zza(zztmVar);
    }

    public final void zzd(zztm zztmVar, zzpk zzpkVar) {
        zze(zztmVar, zzpkVar, zzj());
    }

    public final void zze(final zztm zztmVar, final zzpk zzpkVar, final String str) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zztt
            @Override // java.lang.Runnable
            public final void run() {
                zztx.this.zzc(zztmVar, zzpkVar, str);
            }
        });
    }

    public final void zzf(zztw zztwVar, zzpk zzpkVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzk(zzpkVar, elapsedRealtime, 30L)) {
            this.zzk.put(zzpkVar, Long.valueOf(elapsedRealtime));
            zze(zztwVar.zza(), zzpkVar, zzj());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzpk zzpkVar, com.google.mlkit.vision.barcode.internal.zzj zzjVar) {
        zzdb zzdbVar = (zzdb) this.zzl.get(zzpkVar);
        if (zzdbVar != null) {
            for (Object obj : zzdbVar.zzw()) {
                ArrayList arrayList = new ArrayList(zzdbVar.zze(obj));
                Collections.sort(arrayList);
                zzoj zzojVar = new zzoj();
                Iterator it = arrayList.iterator();
                long j = 0;
                while (it.hasNext()) {
                    j += ((Long) it.next()).longValue();
                }
                zzojVar.zza(Long.valueOf(j / arrayList.size()));
                zzojVar.zzc(Long.valueOf(zza(arrayList, 100.0d)));
                zzojVar.zzf(Long.valueOf(zza(arrayList, 75.0d)));
                zzojVar.zzd(Long.valueOf(zza(arrayList, 50.0d)));
                zzojVar.zzb(Long.valueOf(zza(arrayList, 25.0d)));
                zzojVar.zze(Long.valueOf(zza(arrayList, 0.0d)));
                zze(zzjVar.zza(obj, arrayList.size(), zzojVar.zzg()), zzpkVar, zzj());
            }
            this.zzl.remove(zzpkVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(final zzpk zzpkVar, Object obj, long j, final com.google.mlkit.vision.barcode.internal.zzj zzjVar) {
        if (!this.zzl.containsKey(zzpkVar)) {
            this.zzl.put(zzpkVar, zzbz.zzz());
        }
        ((zzdb) this.zzl.get(zzpkVar)).zzt(obj, Long.valueOf(j));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzk(zzpkVar, elapsedRealtime, 30L)) {
            this.zzk.put(zzpkVar, Long.valueOf(elapsedRealtime));
            MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zztv
                @Override // java.lang.Runnable
                public final void run() {
                    zztx.this.zzg(zzpkVar, zzjVar);
                }
            });
        }
    }
}
