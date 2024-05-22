package com.amazon.a.a.o.b;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidator;
import java.security.cert.CertificateEncodingException;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* compiled from: CertVerifier.java */
/* loaded from: classes.dex */
public class a {
    private static final String b = "PKIX";
    private final PKIXParameters c;
    private final CertPathValidator d;
    private final Set<TrustAnchor> e;
    private static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("CertVerifier");
    private static final byte[][] f = {new byte[]{-123, 55, Ascii.FS, -90, -27, 80, Ascii.DC4, Base64.padSymbol, -50, 40, 3, 71, Ascii.ESC, -34, 58, 9, -24, -8, 119, Ascii.SI}, new byte[]{-95, -37, 99, -109, -111, 111, Ascii.ETB, -28, Ascii.CAN, 85, 9, SignedBytes.MAX_POWER_OF_TWO, 4, Ascii.NAK, -57, 2, SignedBytes.MAX_POWER_OF_TWO, -80, -82, 107}, new byte[]{78, -74, -43, 120, 73, -101, Ascii.FS, -49, 95, 88, Ascii.RS, -83, 86, -66, Base64.padSymbol, -101, 103, 68, -91, -27}, new byte[]{19, 45, Ascii.CR, 69, 83, 75, 105, -105, -51, -78, -43, -61, 57, -30, 85, 118, 96, -101, 92, -58}, new byte[]{34, -43, -40, -33, -113, 2, 49, -47, -115, -9, -99, -73, -49, -118, 45, 100, -55, Utf8.REPLACEMENT_BYTE, 108, 58}, new byte[]{97, -17, 67, -41, Byte.MAX_VALUE, -54, -44, 97, 81, -68, -104, -32, -61, 89, Ascii.DC2, -81, -97, -21, 99, 17}, new byte[]{-77, -22, -60, 71, 118, -55, -56, Ascii.FS, -22, -14, -99, -107, -74, -52, -96, 8, Ascii.ESC, 103, -20, -99}, new byte[]{-112, -82, -94, 105, -123, -1, Ascii.DC4, Byte.MIN_VALUE, 76, 67, 73, 82, -20, -23, 96, -124, 119, -81, 85, 111}, new byte[]{32, 66, -123, -36, -9, -21, 118, 65, -107, 87, -114, 19, 107, -44, -73, -47, -23, -114, 70, -91}, new byte[]{54, 121, -54, 53, 102, -121, 114, 48, 77, 48, -91, -5, -121, 59, Ascii.SI, -89, 123, -73, Ascii.CR, 84}, new byte[]{-56, -20, -116, -121, -110, 105, -53, 75, -85, 57, -23, -115, 126, 87, 103, -13, Ascii.DC4, -107, 115, -99}, new byte[]{81, Byte.MAX_VALUE, 97, Ascii.RS, 41, -111, 107, 83, -126, -5, 114, -25, 68, -39, -115, -61, -52, 83, 109, 100}, new byte[]{SignedBytes.MAX_POWER_OF_TWO, -77, 49, -96, -23, -65, -24, 85, -68, 57, -109, -54, 112, 79, 78, -62, 81, -44, Ascii.GS, -113}};
    private static final byte[][] g = {new byte[]{-111, -58, -42, -18, 62, -118, -56, 99, -124, -27, 72, -62, -103, 41, 92, 117, 108, -127, 123, -127}, new byte[]{-32, -85, 5, -108, 32, 114, 84, -109, 5, 96, 98, 2, 54, 112, -9, -51, 46, -4, 102, 102}, new byte[]{-97, -83, -111, -90, -50, 106, -58, -59, 0, 71, -60, 78, -55, -44, -91, Ascii.CR, -110, -40, 73, 121}, new byte[]{-86, -37, -68, 34, 35, -113, -60, 1, -95, 39, -69, 56, -35, -12, Ascii.GS, -37, 8, -98, -16, Ascii.DC2}, new byte[]{-15, -117, 83, -115, Ascii.ESC, -23, 3, -74, -90, -16, 86, 67, 91, Ascii.ETB, Ascii.NAK, -119, -54, -13, 107, -14}};

    private static boolean a(byte[][] bArr, byte[] bArr2) {
        for (byte[] bArr3 : bArr) {
            if (Arrays.equals(bArr3, bArr2)) {
                return true;
            }
        }
        return false;
    }

    public a() throws GeneralSecurityException {
        X509Certificate[] acceptedIssuers;
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        this.e = new HashSet();
        for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
            if ((trustManager instanceof X509TrustManager) && (acceptedIssuers = ((X509TrustManager) trustManager).getAcceptedIssuers()) != null) {
                int i = 0;
                for (X509Certificate x509Certificate : acceptedIssuers) {
                    if (a(x509Certificate)) {
                        if (com.amazon.a.a.o.c.a) {
                            a.a("Trusted Cert: " + x509Certificate.getSubjectX500Principal().getName());
                        }
                        this.e.add(new TrustAnchor(x509Certificate, null));
                        i++;
                    }
                }
                if (com.amazon.a.a.o.c.a) {
                    a.a(String.format("loaded %d certs\n", Integer.valueOf(i)));
                }
            }
        }
        if (this.e.isEmpty()) {
            a.b("TrustManager did not return valid accepted issuers, likely 3P custom TrustManager implementation issue.");
        }
        PKIXParameters pKIXParameters = new PKIXParameters(this.e);
        this.c = pKIXParameters;
        pKIXParameters.setRevocationEnabled(false);
        this.d = CertPathValidator.getInstance(b);
    }

    static boolean a(X509Certificate x509Certificate) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded());
            if (!a(f, digest)) {
                if (!a(g, digest)) {
                    return false;
                }
            }
            return true;
        } catch (NoSuchAlgorithmException e) {
            a.b("Signature algorithm unrecognized", e);
            return false;
        } catch (CertificateEncodingException e2) {
            a.b("Cant get fingerprint", e2);
            return false;
        }
    }

    public boolean a(CertPath certPath) {
        try {
            Date notBefore = ((X509Certificate) certPath.getCertificates().get(0)).getNotBefore();
            a.a("Verifying CertPath with " + notBefore);
            this.c.setDate(notBefore);
            this.d.validate(certPath, this.c);
            return true;
        } catch (Exception e) {
            if (!com.amazon.a.a.o.c.a) {
                return false;
            }
            a.b("Failed to verify cert path: " + e, e);
            return false;
        }
    }
}
