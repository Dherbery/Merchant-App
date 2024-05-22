package com.google.mlkit.vision.barcode.internal;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_barcode.zzux;
import com.google.android.gms.internal.mlkit_vision_barcode.zzuy;
import com.google.android.gms.internal.mlkit_vision_barcode.zzuz;
import com.google.android.gms.internal.mlkit_vision_barcode.zzva;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzve;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvg;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvh;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvj;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.barcode.common.internal.BarcodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes5.dex */
public final class zzm implements BarcodeSource {
    private final zzvj zza;

    public zzm(zzvj zzvjVar) {
        this.zza = zzvjVar;
    }

    private static Barcode.CalendarDateTime zza(zzuy zzuyVar) {
        if (zzuyVar == null) {
            return null;
        }
        return new Barcode.CalendarDateTime(zzuyVar.zzf(), zzuyVar.zzd(), zzuyVar.zza(), zzuyVar.zzb(), zzuyVar.zzc(), zzuyVar.zze(), zzuyVar.zzh(), zzuyVar.zzg());
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final Rect getBoundingBox() {
        Point[] zzo = this.zza.zzo();
        if (zzo == null) {
            return null;
        }
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        for (Point point : zzo) {
            i2 = Math.min(i2, point.x);
            i = Math.max(i, point.x);
            i3 = Math.min(i3, point.y);
            i4 = Math.max(i4, point.y);
        }
        return new Rect(i2, i3, i, i4);
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final Barcode.CalendarEvent getCalendarEvent() {
        zzuz zzc = this.zza.zzc();
        if (zzc != null) {
            return new Barcode.CalendarEvent(zzc.zzg(), zzc.zzc(), zzc.zzd(), zzc.zze(), zzc.zzf(), zza(zzc.zzb()), zza(zzc.zza()));
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final Barcode.ContactInfo getContactInfo() {
        List arrayList;
        zzva zzd = this.zza.zzd();
        if (zzd == null) {
            return null;
        }
        zzve zza = zzd.zza();
        Barcode.PersonName personName = zza != null ? new Barcode.PersonName(zza.zzb(), zza.zzf(), zza.zze(), zza.zza(), zza.zzd(), zza.zzc(), zza.zzg()) : null;
        String zzb = zzd.zzb();
        String zzc = zzd.zzc();
        zzvf[] zzf = zzd.zzf();
        ArrayList arrayList2 = new ArrayList();
        if (zzf != null) {
            for (zzvf zzvfVar : zzf) {
                if (zzvfVar != null) {
                    arrayList2.add(new Barcode.Phone(zzvfVar.zzb(), zzvfVar.zza()));
                }
            }
        }
        zzvc[] zze = zzd.zze();
        ArrayList arrayList3 = new ArrayList();
        if (zze != null) {
            for (zzvc zzvcVar : zze) {
                if (zzvcVar != null) {
                    arrayList3.add(new Barcode.Email(zzvcVar.zza(), zzvcVar.zzb(), zzvcVar.zzd(), zzvcVar.zzc()));
                }
            }
        }
        if (zzd.zzg() != null) {
            arrayList = Arrays.asList((String[]) Preconditions.checkNotNull(zzd.zzg()));
        } else {
            arrayList = new ArrayList();
        }
        List list = arrayList;
        zzux[] zzd2 = zzd.zzd();
        ArrayList arrayList4 = new ArrayList();
        if (zzd2 != null) {
            for (zzux zzuxVar : zzd2) {
                if (zzuxVar != null) {
                    arrayList4.add(new Barcode.Address(zzuxVar.zza(), zzuxVar.zzb()));
                }
            }
        }
        return new Barcode.ContactInfo(personName, zzb, zzc, arrayList2, arrayList3, list, arrayList4);
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final Point[] getCornerPoints() {
        return this.zza.zzo();
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final String getDisplayValue() {
        return this.zza.zzl();
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final Barcode.DriverLicense getDriverLicense() {
        zzvb zze = this.zza.zze();
        if (zze != null) {
            return new Barcode.DriverLicense(zze.zzf(), zze.zzh(), zze.zzn(), zze.zzl(), zze.zzi(), zze.zzc(), zze.zza(), zze.zzb(), zze.zzd(), zze.zzm(), zze.zzj(), zze.zzg(), zze.zze(), zze.zzk());
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final Barcode.Email getEmail() {
        zzvc zzf = this.zza.zzf();
        if (zzf == null) {
            return null;
        }
        return new Barcode.Email(zzf.zza(), zzf.zzb(), zzf.zzd(), zzf.zzc());
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final int getFormat() {
        return this.zza.zza();
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final Barcode.GeoPoint getGeoPoint() {
        zzvd zzg = this.zza.zzg();
        if (zzg != null) {
            return new Barcode.GeoPoint(zzg.zza(), zzg.zzb());
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final Barcode.Phone getPhone() {
        zzvf zzh = this.zza.zzh();
        if (zzh != null) {
            return new Barcode.Phone(zzh.zzb(), zzh.zza());
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final byte[] getRawBytes() {
        return this.zza.zzn();
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final String getRawValue() {
        return this.zza.zzm();
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final Barcode.Sms getSms() {
        zzvg zzi = this.zza.zzi();
        if (zzi != null) {
            return new Barcode.Sms(zzi.zza(), zzi.zzb());
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final Barcode.UrlBookmark getUrl() {
        zzvh zzj = this.zza.zzj();
        if (zzj != null) {
            return new Barcode.UrlBookmark(zzj.zza(), zzj.zzb());
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final int getValueType() {
        return this.zza.zzb();
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public final Barcode.WiFi getWifi() {
        zzvi zzk = this.zza.zzk();
        if (zzk != null) {
            return new Barcode.WiFi(zzk.zzc(), zzk.zzb(), zzk.zza());
        }
        return null;
    }
}
