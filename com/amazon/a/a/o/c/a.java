package com.amazon.a.a.o.c;

import com.amazon.a.a.o.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* compiled from: Serializer.java */
/* loaded from: classes.dex */
public class a {
    private static final c a = new c("Serializer");

    public static String a(Serializable serializable) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        if (serializable == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (IOException e) {
            e = e;
            objectOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.amazon.a.a.o.a.a(objectOutputStream2);
            throw th;
        }
        try {
            try {
                objectOutputStream.writeObject(serializable);
                String a2 = com.amazon.c.a.a.c.a(byteArrayOutputStream.toByteArray());
                com.amazon.a.a.o.a.a(objectOutputStream);
                return a2;
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                com.amazon.a.a.o.a.a(objectOutputStream2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            if (c.b) {
                a.b("Could not serialize object: " + serializable, e);
            }
            com.amazon.a.a.o.a.a(objectOutputStream);
            return null;
        }
    }

    public static <T> T a(String str) {
        ObjectInputStream objectInputStream;
        Object obj;
        InputStream inputStream = (T) null;
        if (str != null && str.length() != 0) {
            try {
                try {
                    try {
                        objectInputStream = new ObjectInputStream(new ByteArrayInputStream(com.amazon.c.a.a.c.c(str.getBytes())));
                    } catch (Exception e) {
                        e = e;
                        objectInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        com.amazon.a.a.o.a.a(inputStream);
                        throw th;
                    }
                    try {
                        obj = (T) objectInputStream.readObject();
                    } catch (Exception e2) {
                        e = e2;
                        obj = inputStream;
                        if (c.b) {
                            a.b("Could not read object from string: " + str, e);
                            obj = inputStream;
                        }
                        com.amazon.a.a.o.a.a(objectInputStream);
                        return (T) obj;
                    }
                    com.amazon.a.a.o.a.a(objectInputStream);
                    return (T) obj;
                } catch (IOException e3) {
                    if (c.b) {
                        a.b("Could not decode string", e3);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = (T) objectInputStream;
            }
        }
        return null;
    }
}
