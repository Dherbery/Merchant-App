package com.amazon.a.a.o.b;

import android.app.Application;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: DataAuthenticationKeyLoaderV2.java */
/* loaded from: classes.dex */
public class c implements b {
    private static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("DataAuthenticationKeyLoaderV2");
    private static final String b = "kiwi";
    private static final int c = 0;

    @com.amazon.a.a.k.a
    private Application d;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c e;

    @Override // com.amazon.a.a.o.b.b
    public PublicKey a() throws com.amazon.a.a.o.b.a.a {
        if (com.amazon.a.a.o.c.a) {
            a.a("Loading data authentication key...");
        }
        PublicKey b2 = b();
        if (b2 != null) {
            return b2;
        }
        PublicKey c2 = c();
        a(c2);
        return c2;
    }

    private PublicKey b() {
        if (com.amazon.a.a.o.c.a) {
            a.a("Checking KiwiDataStore for key...");
        }
        PublicKey publicKey = (PublicKey) this.e.a(com.amazon.a.a.m.c.a);
        if (com.amazon.a.a.o.c.a) {
            com.amazon.a.a.o.c cVar = a;
            StringBuilder sb = new StringBuilder("Key was cached: ");
            sb.append(publicKey != null);
            cVar.a(sb.toString());
        }
        return publicKey;
    }

    private PublicKey c() throws com.amazon.a.a.o.b.a.a {
        if (com.amazon.a.a.o.c.a) {
            a.a("Loading authentication key from apk...");
        }
        CertPath d = d();
        if (!a(d)) {
            throw com.amazon.a.a.o.b.a.a.e();
        }
        d(d);
        return b(d);
    }

    private CertPath d() throws com.amazon.a.a.o.b.a.a {
        JarFile e = e();
        return a(e, a(e));
    }

    private JarFile e() throws com.amazon.a.a.o.b.a.a {
        String packageCodePath = this.d.getPackageCodePath();
        if (com.amazon.a.a.o.c.a) {
            a.a("Opening apk: " + packageCodePath);
        }
        try {
            return new JarFile(packageCodePath, false);
        } catch (IOException e) {
            throw com.amazon.a.a.o.b.a.a.a((Throwable) e);
        }
    }

    private JarEntry a(JarFile jarFile) throws com.amazon.a.a.o.b.a.a {
        if (com.amazon.a.a.o.c.a) {
            a.a("Searching for cert in apk");
        }
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry nextElement = entries.nextElement();
            if (!nextElement.isDirectory() && nextElement.getName().equals(b)) {
                return nextElement;
            }
        }
        throw com.amazon.a.a.o.b.a.a.d();
    }

    private CertPath a(JarFile jarFile, JarEntry jarEntry) throws com.amazon.a.a.o.b.a.a {
        try {
            if (com.amazon.a.a.o.c.a) {
                a.a("Extracting cert from entry: " + jarEntry.getName());
            }
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            if (com.amazon.a.a.o.c.a) {
                a.a("Generating certificates from entry input stream");
            }
            return certificateFactory.generateCertPath(a(certificateFactory.generateCertificates(jarFile.getInputStream(jarEntry))));
        } catch (Exception e) {
            throw com.amazon.a.a.o.b.a.a.a((Throwable) e);
        }
    }

    public List<? extends Certificate> a(Collection<? extends Certificate> collection) {
        return new ArrayList(collection);
    }

    private boolean a(CertPath certPath) {
        if (certPath == null || certPath.getCertificates().size() <= 0) {
            return false;
        }
        Certificate certificate = certPath.getCertificates().get(0);
        if (!(certificate instanceof X509Certificate)) {
            return false;
        }
        String name = ((X509Certificate) certificate).getSubjectX500Principal().getName();
        if (com.amazon.a.a.o.c.a) {
            a.a("Kiwi Cert Details: " + name);
        }
        return name.contains("O=Amazon.com\\, Inc.") && name.contains("C=US") && name.contains("ST=Washington") && name.contains("L=Seattle");
    }

    private PublicKey b(CertPath certPath) {
        return c(certPath).getPublicKey();
    }

    private X509Certificate c(CertPath certPath) {
        return (X509Certificate) certPath.getCertificates().get(0);
    }

    private void d(CertPath certPath) throws com.amazon.a.a.o.b.a.a {
        if (!f().a(certPath)) {
            throw com.amazon.a.a.o.b.a.a.f();
        }
    }

    private a f() throws com.amazon.a.a.o.b.a.a {
        try {
            return new a();
        } catch (GeneralSecurityException e) {
            throw com.amazon.a.a.o.b.a.a.b((Throwable) e);
        }
    }

    private void a(PublicKey publicKey) {
        if (com.amazon.a.a.o.c.a) {
            a.a("Placing auth key into storage");
        }
        this.e.a(com.amazon.a.a.m.c.a, (String) publicKey);
    }
}
