package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
public final class zzpz {
    private static zzar zza;
    private static final zzau zzb = zzau.zzc("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
    private final String zzc;
    private final String zzd;
    private final zzpr zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzpz(Context context, final SharedPrefManager sharedPrefManager, zzpr zzprVar, String str) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzprVar;
        zzqn.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzpv
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzpz.this.zza();
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzpw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SharedPrefManager.this.getMlSdkInstanceId();
            }
        });
        zzau zzauVar = zzb;
        this.zzj = zzauVar.containsKey(str) ? DynamiteModule.getRemoteVersion(context, (String) zzauVar.get(str)) : -1;
    }

    private static synchronized zzar zzh() {
        synchronized (zzpz.class) {
            zzar zzarVar = zza;
            if (zzarVar != null) {
                return zzarVar;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzao zzaoVar = new zzao();
            for (int i = 0; i < locales.size(); i++) {
                zzaoVar.zzb(CommonUtils.languageTagFromLocale(locales.get(i)));
            }
            zzar zzc = zzaoVar.zzc();
            zza = zzc;
            return zzc;
        }
    }

    private final zzol zzi(String str, String str2) {
        String mlSdkInstanceId;
        zzol zzolVar = new zzol();
        zzolVar.zzb(this.zzc);
        zzolVar.zzc(this.zzd);
        zzolVar.zzh(zzh());
        zzolVar.zzg(true);
        zzolVar.zzl(str);
        zzolVar.zzj(str2);
        if (this.zzh.isSuccessful()) {
            mlSdkInstanceId = (String) this.zzh.getResult();
        } else {
            mlSdkInstanceId = this.zzf.getMlSdkInstanceId();
        }
        zzolVar.zzi(mlSdkInstanceId);
        zzolVar.zzd(10);
        zzolVar.zzk(Integer.valueOf(this.zzj));
        return zzolVar;
    }

    private final String zzj() {
        if (this.zzg.isSuccessful()) {
            return (String) this.zzg.getResult();
        }
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zza() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzpq zzpqVar, zzln zzlnVar, String str) {
        zzpqVar.zza(zzlnVar);
        zzpqVar.zzc(zzi(zzpqVar.zzd(), str));
        this.zze.zza(zzpqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzpq zzpqVar, zzqb zzqbVar, RemoteModel remoteModel) {
        zzpqVar.zza(zzln.MODEL_DOWNLOAD);
        zzpqVar.zzc(zzi(zzqbVar.zze(), zzj()));
        zzpqVar.zzb(zzql.zza(remoteModel, this.zzf, zzqbVar));
        this.zze.zza(zzpqVar);
    }

    public final void zzd(final zzpq zzpqVar, final zzln zzlnVar) {
        final String zzj = zzj();
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_common.zzpx
            @Override // java.lang.Runnable
            public final void run() {
                zzpz.this.zzb(zzpqVar, zzlnVar, zzj);
            }
        });
    }

    public final void zze(zzpq zzpqVar, RemoteModel remoteModel, boolean z, int i) {
        zzqa zzh = zzqb.zzh();
        zzh.zzf(false);
        zzh.zzd(remoteModel.getModelType());
        zzh.zza(zzls.FAILED);
        zzh.zzb(zzlm.DOWNLOAD_FAILED);
        zzh.zzc(i);
        zzg(zzpqVar, remoteModel, zzh.zzh());
    }

    public final void zzf(zzpq zzpqVar, RemoteModel remoteModel, zzlm zzlmVar, boolean z, ModelType modelType, zzls zzlsVar) {
        zzqa zzh = zzqb.zzh();
        zzh.zzf(z);
        zzh.zzd(modelType);
        zzh.zzb(zzlmVar);
        zzh.zza(zzlsVar);
        zzg(zzpqVar, remoteModel, zzh.zzh());
    }

    public final void zzg(final zzpq zzpqVar, final RemoteModel remoteModel, final zzqb zzqbVar) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_common.zzpy
            @Override // java.lang.Runnable
            public final void run() {
                zzpz.this.zzc(zzpqVar, zzqbVar, remoteModel);
            }
        });
    }
}
