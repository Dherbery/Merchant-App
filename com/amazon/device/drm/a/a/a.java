package com.amazon.device.drm.a.a;

import android.app.Application;
import android.os.RemoteException;
import com.amazon.a.a.h.c;
import com.amazon.a.a.n.a.a.f;
import com.amazon.a.a.n.a.a.i;
import com.amazon.a.a.n.a.h;
import com.amazon.a.b.g;
import com.amazon.d.a.j;
import com.amazon.device.drm.LicensingService;
import com.amazon.device.drm.model.LicenseResponse;
import com.bleplx.adapter.utils.Constants;

/* compiled from: GetLicenseCommand.java */
/* loaded from: classes.dex */
public class a extends h {
    private static final String c = "a";
    private static final String d = "get_license";
    private static final String e = "1.0";

    @com.amazon.a.a.k.a
    c b;

    @com.amazon.a.a.k.a
    private Application f;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.o.b.b g;

    @Override // com.amazon.a.a.n.a.a
    protected boolean f() {
        return false;
    }

    public a(com.amazon.device.drm.a.b.b bVar) {
        super(bVar, d, "1.0", bVar.d().toString(), LicensingService.SDK_VERSION);
        b(false);
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws RemoteException, com.amazon.a.a.d.b {
        String str = c;
        com.amazon.device.drm.a.e.b.a(str, "onResult: result = " + jVar);
        try {
            g gVar = new g(jVar.b());
            if (!a(gVar, a(gVar))) {
                return false;
            }
            com.amazon.device.drm.a.e.b.a(str, "License Verification was successful");
            this.b.a(new com.amazon.a.b.b.a());
            a(LicenseResponse.RequestStatus.LICENSED);
            return true;
        } catch (Exception unused) {
            com.amazon.device.drm.a.e.b.a(c, "License not returned by Appstore");
            a(LicenseResponse.RequestStatus.NOT_LICENSED);
            return false;
        }
    }

    private void a(LicenseResponse.RequestStatus requestStatus) {
        com.amazon.device.drm.a.b.b bVar = (com.amazon.device.drm.a.b.b) j();
        bVar.a().a(new com.amazon.device.drm.a.c.a().a(bVar.d()).a(requestStatus).a());
    }

    private boolean a(g gVar, com.amazon.a.b.b bVar) {
        if (bVar == null) {
            return false;
        }
        try {
            com.amazon.device.drm.a.e.a.a(gVar, bVar, this.f);
            return true;
        } catch (com.amazon.a.b.a.a e2) {
            if (e2.d().a(com.amazon.a.b.h.EXPIRATION)) {
                com.amazon.device.drm.a.e.b.a(c, "License has expired");
                this.b.a(a((com.amazon.a.a.d.b) e2));
                a(LicenseResponse.RequestStatus.EXPIRED);
            } else {
                com.amazon.device.drm.a.e.b.a(c, "License Verification failed" + e2.d());
                this.b.a(a((com.amazon.a.a.d.b) e2));
                a(LicenseResponse.RequestStatus.ERROR_VERIFICATION);
            }
            return false;
        }
    }

    private com.amazon.a.b.b a(g gVar) {
        try {
            return com.amazon.device.drm.a.e.a.a(gVar, this.g.a());
        } catch (com.amazon.a.a.o.b.a.a e2) {
            com.amazon.device.drm.a.e.b.a(c, "Unable to load the public key from the apk");
            a(LicenseResponse.RequestStatus.ERROR_INVALID_LICENSING_KEYS);
            this.b.a(a((com.amazon.a.a.d.b) e2));
            return null;
        } catch (com.amazon.a.a.o.b.a.b e3) {
            com.amazon.device.drm.a.e.b.a(c, "Unable to parse the license returned by Appstore Client");
            a(LicenseResponse.RequestStatus.ERROR_VERIFICATION);
            this.b.a(a((com.amazon.a.a.d.b) e3));
            return null;
        } catch (com.amazon.a.a.o.b.a.c e4) {
            com.amazon.device.drm.a.e.b.a(c, "Unable to decode the license with the public key provided by the developer");
            a(LicenseResponse.RequestStatus.ERROR_INVALID_LICENSING_KEYS);
            this.b.a(a((com.amazon.a.a.d.b) e4));
            return null;
        } catch (Exception unused) {
            com.amazon.device.drm.a.e.b.a(c, "Content License returned from Appstore is not in proper format");
            a(LicenseResponse.RequestStatus.ERROR_VERIFICATION);
            return null;
        }
    }

    @Override // com.amazon.a.a.n.a.h
    protected void b(com.amazon.d.a.h hVar) {
        String str;
        try {
            str = hVar.g();
        } catch (Exception unused) {
            str = Constants.BluetoothState.UNKNOWN;
        }
        try {
            com.amazon.a.a.n.a.g valueOf = com.amazon.a.a.n.a.g.valueOf(str);
            switch (AnonymousClass1.a[valueOf.ordinal()]) {
                case 1:
                    com.amazon.device.drm.a.e.b.a(c, String.format("License has expired: %s", valueOf.name()));
                    a(LicenseResponse.RequestStatus.EXPIRED);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    com.amazon.device.drm.a.e.b.a(c, String.format("Customer is not licensed to use the Application: %s", valueOf.name()));
                    a(LicenseResponse.RequestStatus.NOT_LICENSED);
                    return;
                case 10:
                case 11:
                    com.amazon.device.drm.a.e.b.a(c, String.format("Unable to verify Device info: %s", valueOf.name()));
                    a(LicenseResponse.RequestStatus.ERROR_VERIFICATION);
                    return;
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                    com.amazon.device.drm.a.e.b.a(c, String.format("Unable to verify Application metadata: %s", valueOf.name()));
                    a(LicenseResponse.RequestStatus.ERROR_VERIFICATION);
                    return;
                default:
                    com.amazon.device.drm.a.e.b.a(c, "No valid failure reason found. Defaulting to UNKNOWN_ERROR");
                    a(LicenseResponse.RequestStatus.UNKNOWN_ERROR);
                    return;
            }
        } catch (Exception unused2) {
            com.amazon.device.drm.a.e.b.a(c, "Unknown Reason of failure" + str);
            this.b.a(a((com.amazon.a.a.d.b) new i(d)));
        }
    }

    /* compiled from: GetLicenseCommand.java */
    /* renamed from: com.amazon.device.drm.a.a.a$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.amazon.a.a.n.a.g.values().length];
            a = iArr;
            try {
                iArr[com.amazon.a.a.n.a.g.CLA_LICENSE_EXPIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.amazon.a.a.n.a.g.SLA_NO_LICENSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.amazon.a.a.n.a.g.CLA_NOT_ENTITLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.amazon.a.a.n.a.g.CLA_NOT_LOGGED_IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.amazon.a.a.n.a.g.SLA_NO_CUSTOMER_ID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.amazon.a.a.n.a.g.CLA_LICENSE_INVALID.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.amazon.a.a.n.a.g.CLA_NO_VALID_LICENSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.amazon.a.a.n.a.g.VLA_NOT_LOGGED_IN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[com.amazon.a.a.n.a.g.VLIA_NOT_LOGGED_IN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[com.amazon.a.a.n.a.g.CLA_NO_DEVICE_ID.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[com.amazon.a.a.n.a.g.SLA_NO_DEVICE_ID.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[com.amazon.a.a.n.a.g.CLA_NO_CONTENT_ID.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[com.amazon.a.a.n.a.g.CSA_INVALID_CHECKSUM.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[com.amazon.a.a.n.a.g.CSA_INVALID_SIGNATURE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[com.amazon.a.a.n.a.g.CSA_NO_CONTENT_METADATA.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[com.amazon.a.a.n.a.g.CSA_CONTENT_MD_PKG_NAME_MISMATCH.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[com.amazon.a.a.n.a.g.CLA_NULL_LOCKER_RESPONSE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.amazon.a.a.n.a.h
    protected void c(com.amazon.a.a.d.b bVar) {
        char c2;
        String a = bVar.a();
        if (f.a.equals(a)) {
            String b = bVar.b();
            switch (b.hashCode()) {
                case -1023164887:
                    if (b.equals("INVALID_CONTENT_ID")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 375605247:
                    if (b.equals("NO_INTERNET")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 433141802:
                    if (b.equals("UNKNOWN")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2056521148:
                    if (b.equals("INTERNAL_SERVICE_ERROR")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                com.amazon.device.drm.a.e.b.a(c, "Unable to verify Application metadata");
                a(LicenseResponse.RequestStatus.ERROR_VERIFICATION);
                return;
            } else {
                com.amazon.device.drm.a.e.b.a(c, "No valid failure reason found. Defaulting to UNKNOWN_ERROR");
                a(LicenseResponse.RequestStatus.UNKNOWN_ERROR);
                return;
            }
        }
        if (com.amazon.a.a.n.a.a.a.a.equals(a)) {
            com.amazon.device.drm.a.e.b.a(c, "AuthToken verification failed");
            a(LicenseResponse.RequestStatus.ERROR_VERIFICATION);
        } else if (com.amazon.a.a.o.b.a.a.a.equals(a)) {
            com.amazon.device.drm.a.e.b.a(c, "Unable to load the public key from the apk");
            a(LicenseResponse.RequestStatus.ERROR_INVALID_LICENSING_KEYS);
        }
    }
}
