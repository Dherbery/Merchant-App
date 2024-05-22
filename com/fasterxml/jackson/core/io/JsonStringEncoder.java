package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.lang.ref.SoftReference;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public final class JsonStringEncoder {
    private static final int SURR1_FIRST = 55296;
    private static final int SURR1_LAST = 56319;
    private static final int SURR2_FIRST = 56320;
    private static final int SURR2_LAST = 57343;
    protected ByteArrayBuilder _bytes;
    protected final char[] _qbuf;
    protected TextBuffer _text;
    private static final char[] HC = CharTypes.copyHexChars();
    private static final byte[] HB = CharTypes.copyHexBytes();
    protected static final ThreadLocal<SoftReference<JsonStringEncoder>> _threadEncoder = new ThreadLocal<>();

    public JsonStringEncoder() {
        this._qbuf = r0;
        char[] cArr = {'\\', 0, '0', '0'};
    }

    public static JsonStringEncoder getInstance() {
        ThreadLocal<SoftReference<JsonStringEncoder>> threadLocal = _threadEncoder;
        SoftReference<JsonStringEncoder> softReference = threadLocal.get();
        JsonStringEncoder jsonStringEncoder = softReference == null ? null : softReference.get();
        if (jsonStringEncoder != null) {
            return jsonStringEncoder;
        }
        JsonStringEncoder jsonStringEncoder2 = new JsonStringEncoder();
        threadLocal.set(new SoftReference<>(jsonStringEncoder2));
        return jsonStringEncoder2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        r8 = r6 + 1;
        r6 = r12.charAt(r6);
        r9 = r2[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        if (r9 >= 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        r6 = _appendNumeric(r6, r11._qbuf);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        r9 = r7 + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
    
        if (r9 <= r1.length) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
    
        r9 = r1.length - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
    
        if (r9 <= 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        java.lang.System.arraycopy(r11._qbuf, 0, r1, r7, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
    
        r1 = r0.finishCurrentSegment();
        r6 = r6 - r9;
        java.lang.System.arraycopy(r11._qbuf, r9, r1, 0, r6);
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        java.lang.System.arraycopy(r11._qbuf, 0, r1, r7, r6);
        r7 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        r6 = _appendNamed(r9, r11._qbuf);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public char[] quoteAsString(java.lang.String r12) {
        /*
            r11 = this;
            com.fasterxml.jackson.core.util.TextBuffer r0 = r11._text
            if (r0 != 0) goto Lc
            com.fasterxml.jackson.core.util.TextBuffer r0 = new com.fasterxml.jackson.core.util.TextBuffer
            r1 = 0
            r0.<init>(r1)
            r11._text = r0
        Lc:
            char[] r1 = r0.emptyAndGetCurrentSegment()
            int[] r2 = com.fasterxml.jackson.core.io.CharTypes.get7BitOutputEscapes()
            int r3 = r2.length
            int r4 = r12.length()
            r5 = 0
            r6 = r5
            r7 = r6
        L1c:
            if (r6 >= r4) goto L75
        L1e:
            char r8 = r12.charAt(r6)
            if (r8 >= r3) goto L61
            r9 = r2[r8]
            if (r9 == 0) goto L61
            int r8 = r6 + 1
            char r6 = r12.charAt(r6)
            r9 = r2[r6]
            if (r9 >= 0) goto L39
            char[] r9 = r11._qbuf
            int r6 = r11._appendNumeric(r6, r9)
            goto L3f
        L39:
            char[] r6 = r11._qbuf
            int r6 = r11._appendNamed(r9, r6)
        L3f:
            int r9 = r7 + r6
            int r10 = r1.length
            if (r9 <= r10) goto L59
            int r9 = r1.length
            int r9 = r9 - r7
            if (r9 <= 0) goto L4d
            char[] r10 = r11._qbuf
            java.lang.System.arraycopy(r10, r5, r1, r7, r9)
        L4d:
            char[] r1 = r0.finishCurrentSegment()
            int r6 = r6 - r9
            char[] r7 = r11._qbuf
            java.lang.System.arraycopy(r7, r9, r1, r5, r6)
            r7 = r6
            goto L5f
        L59:
            char[] r10 = r11._qbuf
            java.lang.System.arraycopy(r10, r5, r1, r7, r6)
            r7 = r9
        L5f:
            r6 = r8
            goto L1c
        L61:
            int r9 = r1.length
            if (r7 < r9) goto L69
            char[] r1 = r0.finishCurrentSegment()
            r7 = r5
        L69:
            int r9 = r7 + 1
            r1[r7] = r8
            int r6 = r6 + 1
            if (r6 < r4) goto L73
            r7 = r9
            goto L75
        L73:
            r7 = r9
            goto L1e
        L75:
            r0.setCurrentLength(r7)
            char[] r12 = r0.contentsAsArray()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.JsonStringEncoder.quoteAsString(java.lang.String):char[]");
    }

    public void quoteAsString(CharSequence charSequence, StringBuilder sb) {
        int[] iArr = CharTypes.get7BitOutputEscapes();
        int length = iArr.length;
        int length2 = charSequence.length();
        int i = 0;
        while (i < length2) {
            do {
                char charAt = charSequence.charAt(i);
                if (charAt >= length || iArr[charAt] == 0) {
                    sb.append(charAt);
                    i++;
                } else {
                    int i2 = i + 1;
                    char charAt2 = charSequence.charAt(i);
                    int i3 = iArr[charAt2];
                    sb.append(this._qbuf, 0, i3 < 0 ? _appendNumeric(charAt2, this._qbuf) : _appendNamed(i3, this._qbuf));
                    i = i2;
                }
            } while (i < length2);
            return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        if (r5 < r2.length) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        r2 = r0.finishCurrentSegment();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        r7 = r4 + 1;
        r4 = r11.charAt(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
    
        if (r4 > 127) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
    
        if (r4 > 2047) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
    
        r6 = r5 + 1;
        r2[r5] = (byte) ((r4 >> 6) | 192);
        r4 = (r4 & '?') | 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
    
        r5 = r4;
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f6, code lost:
    
        if (r6 < r2.length) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f8, code lost:
    
        r2 = r0.finishCurrentSegment();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fd, code lost:
    
        r2[r6] = (byte) r5;
        r5 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0074, code lost:
    
        if (r4 < 55296) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0079, code lost:
    
        if (r4 <= 57343) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007f, code lost:
    
        if (r4 <= 56319) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0081, code lost:
    
        _illegal(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0084, code lost:
    
        if (r7 < r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0086, code lost:
    
        _illegal(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0089, code lost:
    
        r6 = r7 + 1;
        r4 = _convert(r4, r11.charAt(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0096, code lost:
    
        if (r4 <= 1114111) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0098, code lost:
    
        _illegal(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009b, code lost:
    
        r7 = r5 + 1;
        r2[r5] = (byte) ((r4 >> 18) | com.google.android.exoplayer2.extractor.ts.PsExtractor.VIDEO_STREAM_MASK);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a5, code lost:
    
        if (r7 < r2.length) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a7, code lost:
    
        r2 = r0.finishCurrentSegment();
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ac, code lost:
    
        r5 = r7 + 1;
        r2[r7] = (byte) (((r4 >> 12) & 63) | 128);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b8, code lost:
    
        if (r5 < r2.length) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ba, code lost:
    
        r2 = r0.finishCurrentSegment();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00bf, code lost:
    
        r7 = r5 + 1;
        r2[r5] = (byte) (((r4 >> 6) & 63) | 128);
        r5 = (r4 & 63) | 128;
        r4 = r6;
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d2, code lost:
    
        r6 = r5 + 1;
        r2[r5] = (byte) ((r4 >> '\f') | 224);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00dc, code lost:
    
        if (r6 < r2.length) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00de, code lost:
    
        r2 = r0.finishCurrentSegment();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e3, code lost:
    
        r2[r6] = (byte) (((r4 >> 6) & 63) | 128);
        r4 = (r4 & '?') | 128;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0050, code lost:
    
        r5 = _appendByte(r4, r6[r4], r0, r5);
        r2 = r0.getCurrentSegment();
        r4 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] quoteAsUTF8(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.JsonStringEncoder.quoteAsUTF8(java.lang.String):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00dc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] encodeAsUTF8(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.JsonStringEncoder.encodeAsUTF8(java.lang.String):byte[]");
    }

    private int _appendNumeric(int i, char[] cArr) {
        cArr[1] = AbstractJsonLexerKt.UNICODE_ESC;
        char[] cArr2 = HC;
        cArr[4] = cArr2[i >> 4];
        cArr[5] = cArr2[i & 15];
        return 6;
    }

    private int _appendNamed(int i, char[] cArr) {
        cArr[1] = (char) i;
        return 2;
    }

    private int _appendByte(int i, int i2, ByteArrayBuilder byteArrayBuilder, int i3) {
        byteArrayBuilder.setCurrentSegmentLength(i3);
        byteArrayBuilder.append(92);
        if (i2 < 0) {
            byteArrayBuilder.append(117);
            if (i > 255) {
                int i4 = i >> 8;
                byte[] bArr = HB;
                byteArrayBuilder.append(bArr[i4 >> 4]);
                byteArrayBuilder.append(bArr[i4 & 15]);
                i &= 255;
            } else {
                byteArrayBuilder.append(48);
                byteArrayBuilder.append(48);
            }
            byte[] bArr2 = HB;
            byteArrayBuilder.append(bArr2[i >> 4]);
            byteArrayBuilder.append(bArr2[i & 15]);
        } else {
            byteArrayBuilder.append((byte) i2);
        }
        return byteArrayBuilder.getCurrentSegmentLength();
    }

    private static int _convert(int i, int i2) {
        if (i2 >= 56320 && i2 <= 57343) {
            return ((i - 55296) << 10) + 65536 + (i2 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
    }

    private static void _illegal(int i) {
        throw new IllegalArgumentException(UTF8Writer.illegalSurrogateDesc(i));
    }
}
