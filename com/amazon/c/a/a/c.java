package com.amazon.c.a.a;

import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.zip.GZIPOutputStream;
import okio.Utf8;

/* compiled from: Base64.java */
/* loaded from: classes.dex */
public class c {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 0;
    public static final int d = 2;
    public static final int e = 4;
    public static final int f = 8;
    public static final int g = 16;
    public static final int h = 32;
    static final /* synthetic */ boolean i = true;
    private static final int j = 76;
    private static final byte k = 61;
    private static final byte l = 10;
    private static final String m = "US-ASCII";
    private static final byte o = -1;
    private static final byte[] p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte n = -5;
    private static final byte[] q = {-9, -9, -9, -9, -9, -9, -9, -9, -9, n, n, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] r = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] s = {-9, -9, -9, -9, -9, -9, -9, -9, -9, n, n, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] t = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] u = {-9, -9, -9, -9, -9, -9, -9, -9, -9, n, n, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, Utf8.REPLACEMENT_BYTE, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private static final byte[] b(int i2) {
        if ((i2 & 16) == 16) {
            return r;
        }
        if ((i2 & 32) == 32) {
            return t;
        }
        return p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] c(int i2) {
        if ((i2 & 16) == 16) {
            return s;
        }
        if ((i2 & 32) == 32) {
            return u;
        }
        return q;
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, byte[] bArr2, int i2, int i3) {
        b(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] b2 = b(i5);
        int i6 = (i3 > 0 ? (bArr[i2] << Ascii.CAN) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << Ascii.CAN) >>> 16 : 0) | (i3 > 2 ? (bArr[i2 + 2] << Ascii.CAN) >>> 24 : 0);
        if (i3 == 1) {
            bArr2[i4] = b2[i6 >>> 18];
            bArr2[i4 + 1] = b2[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = 61;
            bArr2[i4 + 3] = 61;
            return bArr2;
        }
        if (i3 == 2) {
            bArr2[i4] = b2[i6 >>> 18];
            bArr2[i4 + 1] = b2[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = b2[(i6 >>> 6) & 63];
            bArr2[i4 + 3] = 61;
            return bArr2;
        }
        if (i3 != 3) {
            return bArr2;
        }
        bArr2[i4] = b2[i6 >>> 18];
        bArr2[i4 + 1] = b2[(i6 >>> 12) & 63];
        bArr2[i4 + 2] = b2[(i6 >>> 6) & 63];
        bArr2[i4 + 3] = b2[i6 & 63];
        return bArr2;
    }

    public static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            b(bArr2, bArr, min, 0);
            byteBuffer2.put(bArr2);
        }
    }

    public static void a(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            b(bArr2, bArr, min, 0);
            for (int i2 = 0; i2 < 4; i2++) {
                charBuffer.put((char) (bArr2[i2] & 255));
            }
        }
    }

    public static String a(Serializable serializable) throws IOException {
        return a(serializable, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v18, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static String a(Serializable serializable, int i2) throws IOException {
        ?? r6;
        ?? r1;
        b bVar;
        ObjectOutputStream objectOutputStream;
        if (serializable == null) {
            throw new NullPointerException("Cannot serialize a null object.");
        }
        ObjectOutputStream objectOutputStream2 = null;
        try {
            r1 = new ByteArrayOutputStream();
            try {
                bVar = new b(r1, i2 | 1);
                try {
                    if ((i2 & 2) != 0) {
                        r6 = new GZIPOutputStream(bVar);
                        try {
                            objectOutputStream2 = new ObjectOutputStream(r6);
                            r6 = r6;
                        } catch (IOException e2) {
                            e = e2;
                            objectOutputStream = objectOutputStream2;
                            objectOutputStream2 = r1;
                            r6 = r6;
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                ObjectOutputStream objectOutputStream3 = objectOutputStream;
                                r1 = objectOutputStream2;
                                objectOutputStream2 = objectOutputStream3;
                                try {
                                    objectOutputStream2.close();
                                } catch (Exception unused) {
                                }
                                try {
                                    r6.close();
                                } catch (Exception unused2) {
                                }
                                try {
                                    bVar.close();
                                } catch (Exception unused3) {
                                }
                                try {
                                    r1.close();
                                    throw th;
                                } catch (Exception unused4) {
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            objectOutputStream2.close();
                            r6.close();
                            bVar.close();
                            r1.close();
                            throw th;
                        }
                    } else {
                        objectOutputStream2 = new ObjectOutputStream(bVar);
                        r6 = 0;
                    }
                    objectOutputStream2.writeObject(serializable);
                    try {
                        objectOutputStream2.close();
                    } catch (Exception unused5) {
                    }
                    try {
                        r6.close();
                    } catch (Exception unused6) {
                    }
                    try {
                        bVar.close();
                    } catch (Exception unused7) {
                    }
                    try {
                        r1.close();
                    } catch (Exception unused8) {
                    }
                    try {
                        return new String(r1.toByteArray(), "US-ASCII");
                    } catch (UnsupportedEncodingException unused9) {
                        return new String(r1.toByteArray());
                    }
                } catch (IOException e3) {
                    e = e3;
                    ObjectOutputStream objectOutputStream4 = objectOutputStream2;
                    objectOutputStream2 = r1;
                    objectOutputStream = objectOutputStream4;
                    r6 = objectOutputStream4;
                } catch (Throwable th3) {
                    th = th3;
                    r6 = objectOutputStream2;
                }
            } catch (IOException e4) {
                e = e4;
                r6 = 0;
                bVar = null;
                objectOutputStream2 = r1;
                objectOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                r6 = 0;
                bVar = null;
            }
        } catch (IOException e5) {
            e = e5;
            r6 = 0;
            objectOutputStream = null;
            bVar = null;
        } catch (Throwable th5) {
            th = th5;
            r6 = 0;
            r1 = 0;
            bVar = null;
        }
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            str = a(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (!i) {
                throw new AssertionError(e2.getMessage());
            }
            str = null;
        }
        if (i || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i2) throws IOException {
        return a(bArr, 0, bArr.length, i2);
    }

    public static String a(byte[] bArr, int i2, int i3) {
        String str;
        try {
            str = a(bArr, i2, i3, 0);
        } catch (IOException e2) {
            if (!i) {
                throw new AssertionError(e2.getMessage());
            }
            str = null;
        }
        if (i || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i2, int i3, int i4) throws IOException {
        byte[] b2 = b(bArr, i2, i3, i4);
        try {
            return new String(b2, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(b2);
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            return b(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (i) {
                return null;
            }
            throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] b(byte[] bArr, int i2, int i3, int i4) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        b bVar;
        GZIPOutputStream gZIPOutputStream;
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i2);
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i3);
        }
        if (i2 + i3 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length)));
        }
        if ((i4 & 2) != 0) {
            GZIPOutputStream gZIPOutputStream2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bVar = new b(byteArrayOutputStream, i4 | 1);
                } catch (IOException e2) {
                    e = e2;
                    bVar = null;
                    gZIPOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    bVar = null;
                }
            } catch (IOException e3) {
                e = e3;
                bVar = null;
                gZIPOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = 0;
                bVar = null;
            }
            try {
                gZIPOutputStream = new GZIPOutputStream(bVar);
                try {
                    gZIPOutputStream.write(bArr, i2, i3);
                    gZIPOutputStream.close();
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception unused) {
                    }
                    try {
                        bVar.close();
                    } catch (Exception unused2) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused3) {
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (IOException e4) {
                    e = e4;
                    gZIPOutputStream2 = byteArrayOutputStream;
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = gZIPOutputStream2;
                        gZIPOutputStream2 = gZIPOutputStream;
                        try {
                            gZIPOutputStream2.close();
                        } catch (Exception unused4) {
                        }
                        try {
                            bVar.close();
                        } catch (Exception unused5) {
                        }
                        try {
                            byteArrayOutputStream.close();
                            throw th;
                        } catch (Exception unused6) {
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    gZIPOutputStream2 = gZIPOutputStream;
                    gZIPOutputStream2.close();
                    bVar.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                gZIPOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                gZIPOutputStream2.close();
                bVar.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } else {
            boolean z = (i4 & 8) != 0;
            int i5 = ((i3 / 3) * 4) + (i3 % 3 > 0 ? 4 : 0);
            if (z) {
                i5 += i5 / 76;
            }
            int i6 = i5;
            byte[] bArr2 = new byte[i6];
            int i7 = i3 - 2;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i8 < i7) {
                int i11 = i8;
                b(bArr, i8 + i2, 3, bArr2, i9, i4);
                int i12 = i10 + 4;
                if (!z || i12 < 76) {
                    i10 = i12;
                } else {
                    bArr2[i9 + 4] = 10;
                    i9++;
                    i10 = 0;
                }
                i8 = i11 + 3;
                i9 += 4;
            }
            int i13 = i8;
            if (i13 < i3) {
                b(bArr, i13 + i2, i3 - i13, bArr2, i9, i4);
                i9 += 4;
            }
            int i14 = i9;
            if (i14 > i6 - 1) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i14];
            System.arraycopy(bArr2, 0, bArr3, 0, i14);
            return bArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        }
        if (i2 < 0 || (i5 = i2 + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2)));
        }
        if (i3 < 0 || (i6 = i3 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i3)));
        }
        byte[] c2 = c(i4);
        byte b2 = bArr[i2 + 2];
        if (b2 == 61) {
            bArr2[i3] = (byte) ((((c2[bArr[i2 + 1]] & 255) << 12) | ((c2[bArr[i2]] & 255) << 18)) >>> 16);
            return 1;
        }
        byte b3 = bArr[i5];
        if (b3 == 61) {
            int i7 = ((c2[bArr[i2 + 1]] & 255) << 12) | ((c2[bArr[i2]] & 255) << 18) | ((c2[b2] & 255) << 6);
            bArr2[i3] = (byte) (i7 >>> 16);
            bArr2[i3 + 1] = (byte) (i7 >>> 8);
            return 2;
        }
        int i8 = ((c2[bArr[i2 + 1]] & 255) << 12) | ((c2[bArr[i2]] & 255) << 18) | ((c2[b2] & 255) << 6) | (c2[b3] & 255);
        bArr2[i3] = (byte) (i8 >> 16);
        bArr2[i3 + 1] = (byte) (i8 >> 8);
        bArr2[i6] = (byte) i8;
        return 3;
    }

    public static byte[] c(byte[] bArr) throws IOException {
        return c(bArr, 0, bArr.length, 0);
    }

    public static byte[] c(byte[] bArr, int i2, int i3, int i4) throws IOException {
        int i5;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        }
        if (i2 < 0 || (i5 = i2 + i3) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        if (i3 == 0) {
            return new byte[0];
        }
        if (i3 < 4) {
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i3);
        }
        byte[] c2 = c(i4);
        byte[] bArr2 = new byte[(i3 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i6 = 0;
        int i7 = 0;
        while (i2 < i5) {
            byte b2 = bArr[i2];
            byte b3 = c2[b2 & 255];
            if (b3 < -5) {
                throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i2] & 255), Integer.valueOf(i2)));
            }
            if (b3 >= -1) {
                int i8 = i6 + 1;
                bArr3[i6] = b2;
                if (i8 > 3) {
                    i7 += b(bArr3, 0, bArr2, i7, i4);
                    if (bArr[i2] == 61) {
                        break;
                    }
                    i6 = 0;
                } else {
                    i6 = i8;
                }
            }
            i2++;
        }
        byte[] bArr4 = new byte[i7];
        System.arraycopy(bArr2, 0, bArr4, 0, i7);
        return bArr4;
    }

    public static byte[] a(String str) throws IOException {
        return a(str, 0);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:39:0x0059
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static byte[] a(java.lang.String r5, int r6) throws java.io.IOException {
        /*
            if (r5 == 0) goto L8e
            java.lang.String r0 = "US-ASCII"
            byte[] r5 = r5.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L9
            goto Ld
        L9:
            byte[] r5 = r5.getBytes()
        Ld:
            int r0 = r5.length
            r1 = 0
            byte[] r5 = c(r5, r1, r0, r6)
            r0 = 4
            r6 = r6 & r0
            r2 = 1
            if (r6 == 0) goto L1a
            r6 = r2
            goto L1b
        L1a:
            r6 = r1
        L1b:
            if (r5 == 0) goto L8d
            int r3 = r5.length
            if (r3 < r0) goto L8d
            if (r6 != 0) goto L8d
            r6 = r5[r1]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r0 = r5[r2]
            int r0 = r0 << 8
            r2 = 65280(0xff00, float:9.1477E-41)
            r0 = r0 & r2
            r6 = r6 | r0
            r0 = 35615(0x8b1f, float:4.9907E-41)
            if (r0 != r6) goto L8d
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L78
            r2.<init>()     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L78
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6f
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6f
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
        L48:
            int r0 = r4.read(r6)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            if (r0 < 0) goto L52
            r2.write(r6, r1, r0)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            goto L48
        L52:
            byte[] r5 = r2.toByteArray()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r2.close()     // Catch: java.lang.Exception -> L59
        L59:
            r4.close()     // Catch: java.lang.Exception -> L5c
        L5c:
            r3.close()     // Catch: java.lang.Exception -> L8d
            goto L8d
        L60:
            r5 = move-exception
            goto L6d
        L62:
            r6 = move-exception
            goto L72
        L64:
            r5 = move-exception
            r4 = r0
            goto L6d
        L67:
            r6 = move-exception
            r4 = r0
            goto L72
        L6a:
            r5 = move-exception
            r3 = r0
            r4 = r3
        L6d:
            r0 = r2
            goto L83
        L6f:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L72:
            r0 = r2
            goto L7b
        L74:
            r5 = move-exception
            r3 = r0
            r4 = r3
            goto L83
        L78:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L7b:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L82
            r0.close()     // Catch: java.lang.Exception -> L59
            goto L59
        L82:
            r5 = move-exception
        L83:
            r0.close()     // Catch: java.lang.Exception -> L86
        L86:
            r4.close()     // Catch: java.lang.Exception -> L89
        L89:
            r3.close()     // Catch: java.lang.Exception -> L8c
        L8c:
            throw r5
        L8d:
            return r5
        L8e:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Input string was null."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.c.a.a.c.a(java.lang.String, int):byte[]");
    }

    public static void a(byte[] bArr, String str) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("Data to encode was null.");
        }
        b bVar = null;
        try {
            try {
                b bVar2 = new b(new FileOutputStream(str), 1);
                try {
                    bVar2.write(bArr);
                    try {
                        bVar2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    bVar = bVar2;
                    try {
                        bVar.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(String str, String str2) throws IOException {
        b bVar = null;
        try {
            try {
                b bVar2 = new b(new FileOutputStream(str2), 0);
                try {
                    bVar2.write(str.getBytes("US-ASCII"));
                    try {
                        bVar2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    bVar = bVar2;
                    try {
                        bVar.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            throw e3;
        }
    }

    public static byte[] b(String str) throws IOException {
        a aVar = null;
        try {
            try {
                File file = new File(str);
                if (file.length() > 2147483647L) {
                    throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
                }
                byte[] bArr = new byte[(int) file.length()];
                a aVar2 = new a(new BufferedInputStream(new FileInputStream(file)), 0);
                int i2 = 0;
                while (true) {
                    try {
                        int read = aVar2.read(bArr, i2, 4096);
                        if (read < 0) {
                            break;
                        }
                        i2 += read;
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        aVar = aVar2;
                        try {
                            aVar.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                try {
                    aVar2.close();
                } catch (Exception unused2) {
                }
                return bArr2;
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(String str) throws IOException {
        a aVar = null;
        try {
            try {
                File file = new File(str);
                byte[] bArr = new byte[Math.max((int) ((file.length() * 1.4d) + 1.0d), 40)];
                a aVar2 = new a(new BufferedInputStream(new FileInputStream(file)), 1);
                int i2 = 0;
                while (true) {
                    try {
                        int read = aVar2.read(bArr, i2, 4096);
                        if (read < 0) {
                            break;
                        }
                        i2 += read;
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        aVar = aVar2;
                        try {
                            aVar.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                String str2 = new String(bArr, 0, i2, "US-ASCII");
                try {
                    aVar2.close();
                } catch (Exception unused2) {
                }
                return str2;
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void b(String str, String str2) throws IOException {
        String c2 = c(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    bufferedOutputStream2.write(c2.getBytes("US-ASCII"));
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void c(String str, String str2) throws IOException {
        byte[] b2 = b(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    bufferedOutputStream2.write(b2);
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* compiled from: Base64.java */
    /* loaded from: classes.dex */
    public static class a extends FilterInputStream {
        private boolean a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private int f;
        private boolean g;
        private int h;
        private byte[] i;

        public a(InputStream inputStream) {
            this(inputStream, 0);
        }

        public a(InputStream inputStream, int i) {
            super(inputStream);
            this.h = i;
            this.g = (i & 8) > 0;
            boolean z = (i & 1) > 0;
            this.a = z;
            int i2 = z ? 4 : 3;
            this.d = i2;
            this.c = new byte[i2];
            this.b = -1;
            this.f = 0;
            this.i = c.c(i);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read;
            if (this.b < 0) {
                if (this.a) {
                    byte[] bArr = new byte[3];
                    int i = 0;
                    for (int i2 = 0; i2 < 3; i2++) {
                        int read2 = this.in.read();
                        if (read2 < 0) {
                            break;
                        }
                        bArr[i2] = (byte) read2;
                        i++;
                    }
                    if (i <= 0) {
                        return -1;
                    }
                    c.b(bArr, 0, i, this.c, 0, this.h);
                    this.b = 0;
                    this.e = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i3 = 0;
                    while (i3 < 4) {
                        do {
                            read = this.in.read();
                            if (read < 0) {
                                break;
                            }
                        } while (this.i[read & 127] <= -5);
                        if (read < 0) {
                            break;
                        }
                        bArr2[i3] = (byte) read;
                        i3++;
                    }
                    if (i3 != 4) {
                        if (i3 == 0) {
                            return -1;
                        }
                        throw new IOException("Improperly padded Base64 input.");
                    }
                    this.e = c.b(bArr2, 0, this.c, 0, this.h);
                    this.b = 0;
                }
            }
            int i4 = this.b;
            if (i4 >= 0) {
                if (i4 >= this.e) {
                    return -1;
                }
                if (this.a && this.g && this.f >= 76) {
                    this.f = 0;
                    return 10;
                }
                this.f++;
                byte[] bArr3 = this.c;
                int i5 = i4 + 1;
                this.b = i5;
                byte b = bArr3[i4];
                if (i5 >= this.d) {
                    this.b = -1;
                }
                return b & 255;
            }
            throw new IOException("Error in Base64 code reading stream.");
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                int read = read();
                if (read >= 0) {
                    bArr[i + i3] = (byte) read;
                    i3++;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }
    }

    /* compiled from: Base64.java */
    /* loaded from: classes.dex */
    public static class b extends FilterOutputStream {
        private boolean a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private boolean f;
        private byte[] g;
        private boolean h;
        private int i;
        private byte[] j;

        public b(OutputStream outputStream) {
            this(outputStream, 1);
        }

        public b(OutputStream outputStream, int i) {
            super(outputStream);
            this.f = (i & 8) != 0;
            boolean z = (i & 1) != 0;
            this.a = z;
            int i2 = z ? 3 : 4;
            this.d = i2;
            this.c = new byte[i2];
            this.b = 0;
            this.e = 0;
            this.h = false;
            this.g = new byte[4];
            this.i = i;
            this.j = c.c(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.h) {
                this.out.write(i);
                return;
            }
            if (this.a) {
                byte[] bArr = this.c;
                int i2 = this.b;
                int i3 = i2 + 1;
                this.b = i3;
                bArr[i2] = (byte) i;
                if (i3 >= this.d) {
                    this.out.write(c.b(this.g, this.c, this.d, this.i));
                    int i4 = this.e + 4;
                    this.e = i4;
                    if (this.f && i4 >= 76) {
                        this.out.write(10);
                        this.e = 0;
                    }
                    this.b = 0;
                    return;
                }
                return;
            }
            byte b = this.j[i & 127];
            if (b <= -5) {
                if (b != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
                return;
            }
            byte[] bArr2 = this.c;
            int i5 = this.b;
            int i6 = i5 + 1;
            this.b = i6;
            bArr2[i5] = (byte) i;
            if (i6 >= this.d) {
                this.out.write(this.g, 0, c.b(bArr2, 0, this.g, 0, this.i));
                this.b = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.h) {
                this.out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        public void a() throws IOException {
            if (this.b > 0) {
                if (this.a) {
                    this.out.write(c.b(this.g, this.c, this.b, this.i));
                    this.b = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a();
            super.close();
            this.c = null;
            this.out = null;
        }

        public void b() throws IOException {
            a();
            this.h = true;
        }

        public void c() {
            this.h = false;
        }
    }
}
