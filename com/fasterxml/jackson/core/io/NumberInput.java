package com.fasterxml.jackson.core.io;

import java.math.BigDecimal;

/* loaded from: classes3.dex */
public final class NumberInput {
    static final long L_BILLION = 1000000000;
    public static final String NASTY_SMALL_DOUBLE = "2.2250738585072012e-308";
    static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);

    public static int parseInt(char[] cArr, int i, int i2) {
        int i3 = cArr[i] - '0';
        if (i2 > 4) {
            int i4 = ((i3 * 10) + (cArr[r5] - '0')) * 10;
            int i5 = (i4 + (cArr[r5] - '0')) * 10;
            int i6 = (i5 + (cArr[r5] - '0')) * 10;
            i = i + 1 + 1 + 1 + 1;
            i3 = i6 + (cArr[i] - '0');
            i2 -= 4;
            if (i2 > 4) {
                int i7 = ((i3 * 10) + (cArr[r5] - '0')) * 10;
                int i8 = (i7 + (cArr[r5] - '0')) * 10;
                int i9 = i + 1 + 1 + 1;
                return ((i8 + (cArr[i9] - '0')) * 10) + (cArr[i9 + 1] - '0');
            }
        }
        if (i2 <= 1) {
            return i3;
        }
        int i10 = i + 1;
        int i11 = (i3 * 10) + (cArr[i10] - '0');
        if (i2 <= 2) {
            return i11;
        }
        int i12 = i10 + 1;
        int i13 = (i11 * 10) + (cArr[i12] - '0');
        return i2 > 3 ? (i13 * 10) + (cArr[i12 + 1] - '0') : i13;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0072, code lost:
    
        return java.lang.Integer.parseInt(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int parseInt(java.lang.String r8) {
        /*
            r0 = 0
            char r1 = r8.charAt(r0)
            int r2 = r8.length()
            r3 = 45
            r4 = 1
            if (r1 != r3) goto Lf
            r0 = r4
        Lf:
            r3 = 10
            if (r0 == 0) goto L23
            if (r2 == r4) goto L1e
            if (r2 <= r3) goto L18
            goto L1e
        L18:
            char r1 = r8.charAt(r4)
            r4 = 2
            goto L2c
        L1e:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L23:
            r5 = 9
            if (r2 <= r5) goto L2c
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L2c:
            r5 = 57
            if (r1 > r5) goto L81
            r6 = 48
            if (r1 >= r6) goto L35
            goto L81
        L35:
            int r1 = r1 - r6
            if (r4 >= r2) goto L7d
            int r7 = r4 + 1
            char r4 = r8.charAt(r4)
            if (r4 > r5) goto L78
            if (r4 >= r6) goto L43
            goto L78
        L43:
            int r1 = r1 * 10
            int r4 = r4 - r6
            int r1 = r1 + r4
            if (r7 >= r2) goto L7d
            int r4 = r7 + 1
            char r7 = r8.charAt(r7)
            if (r7 > r5) goto L73
            if (r7 >= r6) goto L54
            goto L73
        L54:
            int r1 = r1 * 10
            int r7 = r7 - r6
            int r1 = r1 + r7
            if (r4 >= r2) goto L7d
        L5a:
            int r7 = r4 + 1
            char r4 = r8.charAt(r4)
            if (r4 > r5) goto L6e
            if (r4 >= r6) goto L65
            goto L6e
        L65:
            int r1 = r1 * r3
            int r4 = r4 + (-48)
            int r1 = r1 + r4
            if (r7 < r2) goto L6c
            goto L7d
        L6c:
            r4 = r7
            goto L5a
        L6e:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L73:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L78:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L7d:
            if (r0 == 0) goto L80
            int r1 = -r1
        L80:
            return r1
        L81:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.NumberInput.parseInt(java.lang.String):int");
    }

    public static long parseLong(char[] cArr, int i, int i2) {
        int i3 = i2 - 9;
        return (parseInt(cArr, i, i3) * 1000000000) + parseInt(cArr, i + i3, 9);
    }

    public static long parseLong(String str) {
        if (str.length() <= 9) {
            return parseInt(str);
        }
        return Long.parseLong(str);
    }

    public static boolean inLongRange(char[] cArr, int i, int i2, boolean z) {
        String str = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str.length();
        if (i2 < length) {
            return true;
        }
        if (i2 > length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            int charAt = cArr[i + i3] - str.charAt(i3);
            if (charAt != 0) {
                return charAt < 0;
            }
        }
        return true;
    }

    public static boolean inLongRange(String str, boolean z) {
        String str2 = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int charAt = str.charAt(i) - str2.charAt(i);
            if (charAt != 0) {
                return charAt < 0;
            }
        }
        return true;
    }

    public static int parseAsInt(String str, int i) {
        String trim;
        int length;
        if (str == null || (length = (trim = str.trim()).length()) == 0) {
            return i;
        }
        int i2 = 0;
        if (length > 0) {
            char charAt = trim.charAt(0);
            if (charAt == '+') {
                trim = trim.substring(1);
                length = trim.length();
            } else if (charAt == '-') {
                i2 = 1;
            }
        }
        while (i2 < length) {
            char charAt2 = trim.charAt(i2);
            if (charAt2 > '9' || charAt2 < '0') {
                try {
                    return (int) parseDouble(trim);
                } catch (NumberFormatException unused) {
                    return i;
                }
            }
            i2++;
        }
        try {
            return Integer.parseInt(trim);
        } catch (NumberFormatException unused2) {
            return i;
        }
    }

    public static long parseAsLong(String str, long j) {
        String trim;
        int length;
        if (str == null || (length = (trim = str.trim()).length()) == 0) {
            return j;
        }
        int i = 0;
        if (length > 0) {
            char charAt = trim.charAt(0);
            if (charAt == '+') {
                trim = trim.substring(1);
                length = trim.length();
            } else if (charAt == '-') {
                i = 1;
            }
        }
        while (i < length) {
            char charAt2 = trim.charAt(i);
            if (charAt2 > '9' || charAt2 < '0') {
                try {
                    return (long) parseDouble(trim);
                } catch (NumberFormatException unused) {
                    return j;
                }
            }
            i++;
        }
        try {
            return Long.parseLong(trim);
        } catch (NumberFormatException unused2) {
            return j;
        }
    }

    public static double parseAsDouble(String str, double d) {
        if (str == null) {
            return d;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return d;
        }
        try {
            return parseDouble(trim);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static double parseDouble(String str) throws NumberFormatException {
        if (NASTY_SMALL_DOUBLE.equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    public static BigDecimal parseBigDecimal(String str) throws NumberFormatException {
        try {
            return new BigDecimal(str);
        } catch (NumberFormatException unused) {
            throw _badBD(str);
        }
    }

    public static BigDecimal parseBigDecimal(char[] cArr) throws NumberFormatException {
        return parseBigDecimal(cArr, 0, cArr.length);
    }

    public static BigDecimal parseBigDecimal(char[] cArr, int i, int i2) throws NumberFormatException {
        try {
            return new BigDecimal(cArr, i, i2);
        } catch (NumberFormatException unused) {
            throw _badBD(new String(cArr, i, i2));
        }
    }

    private static NumberFormatException _badBD(String str) {
        return new NumberFormatException("Value \"" + str + "\" can not be represented as BigDecimal");
    }
}
