package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzepk extends com.google.android.gms.ads.internal.client.zzbt implements zzddn {
    private final Context zza;
    private final zzfcy zzb;
    private final String zzc;
    private final zzeqe zzd;
    private com.google.android.gms.ads.internal.client.zzq zze;
    private final zzfhf zzf;
    private final zzcei zzg;
    private final zzdwf zzh;
    private zzcuf zzi;

    public zzepk(Context context, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, zzfcy zzfcyVar, zzeqe zzeqeVar, zzcei zzceiVar, zzdwf zzdwfVar) {
        this.zza = context;
        this.zzb = zzfcyVar;
        this.zze = zzqVar;
        this.zzc = str;
        this.zzd = zzeqeVar;
        this.zzf = zzfcyVar.zzi();
        this.zzg = zzceiVar;
        this.zzh = zzdwfVar;
        zzfcyVar.zzp(this);
    }

    private final synchronized void zze(com.google.android.gms.ads.internal.client.zzq zzqVar) {
        this.zzf.zzr(zzqVar);
        this.zzf.zzw(this.zze.zzn);
    }

    private final synchronized boolean zzf(com.google.android.gms.ads.internal.client.zzl zzlVar) throws RemoteException {
        if (zzh()) {
            Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        if (!com.google.android.gms.ads.internal.util.zzt.zzG(this.zza) || zzlVar.zzs != null) {
            zzfie.zza(this.zza, zzlVar.zzf);
            return this.zzb.zzb(zzlVar, this.zzc, null, new zzepj(this));
        }
        zzcec.zzg("Failed to load the ad because app ID is missing.");
        zzeqe zzeqeVar = this.zzd;
        if (zzeqeVar != null) {
            zzeqeVar.zzbK(zzfij.zzd(4, null, null));
        }
        return false;
    }

    private final boolean zzh() {
        boolean z;
        if (((Boolean) zzbhy.zzf.zze()).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkG)).booleanValue()) {
                z = true;
                return this.zzg.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkH)).intValue() || !z;
            }
        }
        z = false;
        if (this.zzg.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkH)).intValue()) {
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzA() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        zzcuf zzcufVar = this.zzi;
        if (zzcufVar != null) {
            zzcufVar.zzg();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
    
        if (r3.zzg.zzc < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbgc.zzkI)).intValue()) goto L9;
     */
    @Override // com.google.android.gms.ads.internal.client.zzbu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzB() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbhm r0 = com.google.android.gms.internal.ads.zzbhy.zzh     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r0 = r0.zze()     // Catch: java.lang.Throwable -> L4c
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L4c
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L4c
            if (r0 == 0) goto L37
            com.google.android.gms.internal.ads.zzbfu r0 = com.google.android.gms.internal.ads.zzbgc.zzkC     // Catch: java.lang.Throwable -> L4c
            com.google.android.gms.internal.ads.zzbga r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r0 = r1.zza(r0)     // Catch: java.lang.Throwable -> L4c
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L4c
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L4c
            if (r0 == 0) goto L37
            com.google.android.gms.internal.ads.zzcei r0 = r3.zzg     // Catch: java.lang.Throwable -> L4c
            int r0 = r0.zzc     // Catch: java.lang.Throwable -> L4c
            com.google.android.gms.internal.ads.zzbfu r1 = com.google.android.gms.internal.ads.zzbgc.zzkI     // Catch: java.lang.Throwable -> L4c
            com.google.android.gms.internal.ads.zzbga r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r1 = r2.zza(r1)     // Catch: java.lang.Throwable -> L4c
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L4c
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L4c
            if (r0 >= r1) goto L3c
        L37:
            java.lang.String r0 = "resume must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch: java.lang.Throwable -> L4c
        L3c:
            com.google.android.gms.internal.ads.zzcuf r0 = r3.zzi     // Catch: java.lang.Throwable -> L4c
            if (r0 == 0) goto L4a
            com.google.android.gms.internal.ads.zzdbw r0 = r0.zzm()     // Catch: java.lang.Throwable -> L4c
            r1 = 0
            r0.zzc(r1)     // Catch: java.lang.Throwable -> L4c
            monitor-exit(r3)
            return
        L4a:
            monitor-exit(r3)
            return
        L4c:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepk.zzB():void");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzC(com.google.android.gms.ads.internal.client.zzbe zzbeVar) {
        if (zzh()) {
            Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        }
        this.zzb.zzo(zzbeVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzD(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
        if (zzh()) {
            Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        }
        this.zzd.zzj(zzbhVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzE(com.google.android.gms.ads.internal.client.zzby zzbyVar) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzF(com.google.android.gms.ads.internal.client.zzq zzqVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzf.zzr(zzqVar);
        this.zze = zzqVar;
        zzcuf zzcufVar = this.zzi;
        if (zzcufVar != null) {
            zzcufVar.zzh(this.zzb.zzd(), zzqVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzG(com.google.android.gms.ads.internal.client.zzcb zzcbVar) {
        if (zzh()) {
            Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        }
        this.zzd.zzm(zzcbVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzH(zzbam zzbamVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzI(com.google.android.gms.ads.internal.client.zzw zzwVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzJ(com.google.android.gms.ads.internal.client.zzci zzciVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzK(com.google.android.gms.ads.internal.client.zzdu zzduVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzL(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzM(zzbxc zzbxcVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzN(boolean z) {
        if (zzh()) {
            Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        }
        this.zzf.zzy(z);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzO(zzbha zzbhaVar) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzb.zzq(zzbhaVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzP(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        if (zzh()) {
            Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        }
        try {
            if (!zzdgVar.zzf()) {
                this.zzh.zze();
            }
        } catch (RemoteException e) {
            zzcec.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzd.zzl(zzdgVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzQ(zzbxf zzbxfVar, String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzR(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzS(zzcaa zzcaaVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzT(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzU(com.google.android.gms.ads.internal.client.zzfk zzfkVar) {
        if (zzh()) {
            Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        }
        this.zzf.zzF(zzfkVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzX() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized boolean zzY() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zzZ() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzddn
    public final synchronized void zza() {
        if (this.zzb.zzr()) {
            com.google.android.gms.ads.internal.client.zzq zzg = this.zzf.zzg();
            zzcuf zzcufVar = this.zzi;
            if (zzcufVar != null && zzcufVar.zzf() != null && this.zzf.zzO()) {
                zzg = zzfhn.zza(this.zza, Collections.singletonList(this.zzi.zzf()));
            }
            zze(zzg);
            try {
                zzf(this.zzf.zze());
                return;
            } catch (RemoteException unused) {
                zzcec.zzj("Failed to refresh the banner ad.");
                return;
            }
        }
        this.zzb.zzn();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized boolean zzaa(com.google.android.gms.ads.internal.client.zzl zzlVar) throws RemoteException {
        zze(this.zze);
        return zzf(zzlVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzab(com.google.android.gms.ads.internal.client.zzcf zzcfVar) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzf.zzQ(zzcfVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final Bundle zzd() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized com.google.android.gms.ads.internal.client.zzq zzg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzcuf zzcufVar = this.zzi;
        if (zzcufVar != null) {
            return zzfhn.zza(this.zza, Collections.singletonList(zzcufVar.zze()));
        }
        return this.zzf.zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzbh zzi() {
        return this.zzd.zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzcb zzj() {
        return this.zzd.zzi();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized com.google.android.gms.ads.internal.client.zzdn zzk() {
        zzcuf zzcufVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgN)).booleanValue() && (zzcufVar = this.zzi) != null) {
            return zzcufVar.zzl();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized com.google.android.gms.ads.internal.client.zzdq zzl() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        zzcuf zzcufVar = this.zzi;
        if (zzcufVar == null) {
            return null;
        }
        return zzcufVar.zzd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final IObjectWrapper zzn() {
        if (zzh()) {
            Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        }
        return ObjectWrapper.wrap(this.zzb.zzd());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized String zzr() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized String zzs() {
        zzcuf zzcufVar = this.zzi;
        if (zzcufVar == null || zzcufVar.zzl() == null) {
            return null;
        }
        return zzcufVar.zzl().zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized String zzt() {
        zzcuf zzcufVar = this.zzi;
        if (zzcufVar == null || zzcufVar.zzl() == null) {
            return null;
        }
        return zzcufVar.zzl().zzg();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
    
        if (r3.zzg.zzc < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbgc.zzkI)).intValue()) goto L9;
     */
    @Override // com.google.android.gms.ads.internal.client.zzbu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzx() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbhm r0 = com.google.android.gms.internal.ads.zzbhy.zze     // Catch: java.lang.Throwable -> L47
            java.lang.Object r0 = r0.zze()     // Catch: java.lang.Throwable -> L47
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L47
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L37
            com.google.android.gms.internal.ads.zzbfu r0 = com.google.android.gms.internal.ads.zzbgc.zzkD     // Catch: java.lang.Throwable -> L47
            com.google.android.gms.internal.ads.zzbga r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L47
            java.lang.Object r0 = r1.zza(r0)     // Catch: java.lang.Throwable -> L47
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L47
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L37
            com.google.android.gms.internal.ads.zzcei r0 = r3.zzg     // Catch: java.lang.Throwable -> L47
            int r0 = r0.zzc     // Catch: java.lang.Throwable -> L47
            com.google.android.gms.internal.ads.zzbfu r1 = com.google.android.gms.internal.ads.zzbgc.zzkI     // Catch: java.lang.Throwable -> L47
            com.google.android.gms.internal.ads.zzbga r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L47
            java.lang.Object r1 = r2.zza(r1)     // Catch: java.lang.Throwable -> L47
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L47
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L47
            if (r0 >= r1) goto L3c
        L37:
            java.lang.String r0 = "destroy must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch: java.lang.Throwable -> L47
        L3c:
            com.google.android.gms.internal.ads.zzcuf r0 = r3.zzi     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L45
            r0.zzb()     // Catch: java.lang.Throwable -> L47
            monitor-exit(r3)
            return
        L45:
            monitor-exit(r3)
            return
        L47:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepk.zzx():void");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzy(com.google.android.gms.ads.internal.client.zzl zzlVar, com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
    
        if (r3.zzg.zzc < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbgc.zzkI)).intValue()) goto L9;
     */
    @Override // com.google.android.gms.ads.internal.client.zzbu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzz() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbhm r0 = com.google.android.gms.internal.ads.zzbhy.zzg     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r0 = r0.zze()     // Catch: java.lang.Throwable -> L4c
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L4c
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L4c
            if (r0 == 0) goto L37
            com.google.android.gms.internal.ads.zzbfu r0 = com.google.android.gms.internal.ads.zzbgc.zzkE     // Catch: java.lang.Throwable -> L4c
            com.google.android.gms.internal.ads.zzbga r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r0 = r1.zza(r0)     // Catch: java.lang.Throwable -> L4c
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L4c
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L4c
            if (r0 == 0) goto L37
            com.google.android.gms.internal.ads.zzcei r0 = r3.zzg     // Catch: java.lang.Throwable -> L4c
            int r0 = r0.zzc     // Catch: java.lang.Throwable -> L4c
            com.google.android.gms.internal.ads.zzbfu r1 = com.google.android.gms.internal.ads.zzbgc.zzkI     // Catch: java.lang.Throwable -> L4c
            com.google.android.gms.internal.ads.zzbga r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r1 = r2.zza(r1)     // Catch: java.lang.Throwable -> L4c
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L4c
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L4c
            if (r0 >= r1) goto L3c
        L37:
            java.lang.String r0 = "pause must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch: java.lang.Throwable -> L4c
        L3c:
            com.google.android.gms.internal.ads.zzcuf r0 = r3.zzi     // Catch: java.lang.Throwable -> L4c
            if (r0 == 0) goto L4a
            com.google.android.gms.internal.ads.zzdbw r0 = r0.zzm()     // Catch: java.lang.Throwable -> L4c
            r1 = 0
            r0.zzb(r1)     // Catch: java.lang.Throwable -> L4c
            monitor-exit(r3)
            return
        L4a:
            monitor-exit(r3)
            return
        L4c:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepk.zzz():void");
    }
}
