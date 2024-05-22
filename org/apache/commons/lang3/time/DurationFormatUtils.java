package org.apache.commons.lang3.time;

import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes6.dex */
public class DurationFormatUtils {
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'";
    static final Object y = "y";
    static final Object M = "M";
    static final Object d = "d";
    static final Object H = "H";
    static final Object m = "m";
    static final Object s = "s";
    static final Object S = ExifInterface.LATITUDE_SOUTH;

    public static String formatDurationHMS(long j) {
        return formatDuration(j, "H:mm:ss.SSS");
    }

    public static String formatDurationISO(long j) {
        return formatDuration(j, ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static String formatDuration(long j, String str) {
        return formatDuration(j, str, true);
    }

    public static String formatDuration(long j, String str, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        Token[] lexx = lexx(str);
        if (Token.containsTokenWithValue(lexx, d)) {
            int i5 = (int) (j / DateUtils.MILLIS_PER_DAY);
            j -= i5 * DateUtils.MILLIS_PER_DAY;
            i = i5;
        } else {
            i = 0;
        }
        if (Token.containsTokenWithValue(lexx, H)) {
            int i6 = (int) (j / DateUtils.MILLIS_PER_HOUR);
            j -= i6 * DateUtils.MILLIS_PER_HOUR;
            i2 = i6;
        } else {
            i2 = 0;
        }
        if (Token.containsTokenWithValue(lexx, m)) {
            int i7 = (int) (j / 60000);
            j -= i7 * 60000;
            i3 = i7;
        } else {
            i3 = 0;
        }
        if (Token.containsTokenWithValue(lexx, s)) {
            int i8 = (int) (j / 1000);
            j -= i8 * 1000;
            i4 = i8;
        } else {
            i4 = 0;
        }
        return format(lexx, 0, 0, i, i2, i3, i4, Token.containsTokenWithValue(lexx, S) ? (int) j : 0, z);
    }

    public static String formatDurationWords(long j, boolean z, boolean z2) {
        String formatDuration = formatDuration(j, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z) {
            formatDuration = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + formatDuration;
            String replaceOnce = StringUtils.replaceOnce(formatDuration, " 0 days", "");
            if (replaceOnce.length() != formatDuration.length()) {
                String replaceOnce2 = StringUtils.replaceOnce(replaceOnce, " 0 hours", "");
                if (replaceOnce2.length() != replaceOnce.length()) {
                    formatDuration = StringUtils.replaceOnce(replaceOnce2, " 0 minutes", "");
                    if (formatDuration.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
                    }
                } else {
                    formatDuration = replaceOnce;
                }
            }
            if (formatDuration.length() != 0) {
                formatDuration = formatDuration.substring(1);
            }
        }
        if (z2) {
            String replaceOnce3 = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
            if (replaceOnce3.length() != formatDuration.length()) {
                formatDuration = StringUtils.replaceOnce(replaceOnce3, " 0 minutes", "");
                if (formatDuration.length() != replaceOnce3.length()) {
                    String replaceOnce4 = StringUtils.replaceOnce(formatDuration, " 0 hours", "");
                    if (replaceOnce4.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(replaceOnce4, " 0 days", "");
                    }
                } else {
                    formatDuration = replaceOnce3;
                }
            }
        }
        return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + formatDuration, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriodISO(long j, long j2) {
        return formatPeriod(j, j2, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault());
    }

    public static String formatPeriod(long j, long j2, String str) {
        return formatPeriod(j, j2, str, true, TimeZone.getDefault());
    }

    public static String formatPeriod(long j, long j2, String str, boolean z, TimeZone timeZone) {
        int i;
        int i2;
        int i3;
        Token[] lexx = lexx(str);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(j));
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTime(new Date(j2));
        int i4 = calendar2.get(14) - calendar.get(14);
        int i5 = calendar2.get(13) - calendar.get(13);
        int i6 = calendar2.get(12) - calendar.get(12);
        int i7 = calendar2.get(11) - calendar.get(11);
        int i8 = calendar2.get(5) - calendar.get(5);
        int i9 = calendar2.get(2) - calendar.get(2);
        int i10 = calendar2.get(1) - calendar.get(1);
        while (i4 < 0) {
            i4 += 1000;
            i5--;
        }
        while (i5 < 0) {
            i5 += 60;
            i6--;
        }
        while (i6 < 0) {
            i6 += 60;
            i7--;
        }
        while (i7 < 0) {
            i7 += 24;
            i8--;
        }
        int i11 = 0;
        if (Token.containsTokenWithValue(lexx, M)) {
            while (i8 < 0) {
                i8 += calendar.getActualMaximum(5);
                i9--;
                calendar.add(2, 1);
            }
            while (i9 < 0) {
                i9 += 12;
                i10--;
            }
            if (!Token.containsTokenWithValue(lexx, y) && i10 != 0) {
                while (i10 != 0) {
                    i9 += i10 * 12;
                    i10 = 0;
                }
            }
            i = i9;
        } else {
            if (!Token.containsTokenWithValue(lexx, y)) {
                int i12 = calendar2.get(1);
                if (i9 < 0) {
                    i12--;
                }
                while (calendar.get(1) != i12) {
                    int actualMaximum = i8 + (calendar.getActualMaximum(6) - calendar.get(6));
                    if ((calendar instanceof GregorianCalendar) && calendar.get(2) == 1 && calendar.get(5) == 29) {
                        actualMaximum++;
                    }
                    calendar.add(1, 1);
                    i8 = actualMaximum + calendar.get(6);
                }
                i10 = 0;
            }
            while (calendar.get(2) != calendar2.get(2)) {
                i8 += calendar.getActualMaximum(5);
                calendar.add(2, 1);
            }
            i = 0;
            while (i8 < 0) {
                i8 += calendar.getActualMaximum(5);
                i--;
                calendar.add(2, 1);
            }
        }
        int i13 = i10;
        if (Token.containsTokenWithValue(lexx, d)) {
            i2 = i8;
        } else {
            i7 += i8 * 24;
            i2 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, H)) {
            i6 += i7 * 60;
            i7 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, m)) {
            i5 += i6 * 60;
            i6 = 0;
        }
        if (Token.containsTokenWithValue(lexx, s)) {
            i3 = i4;
            i11 = i5;
        } else {
            i3 = i4 + (i5 * 1000);
        }
        return format(lexx, i13, i, i2, i7, i6, i11, i3, z);
    }

    static String format(Token[] tokenArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        int i8 = i7;
        boolean z2 = false;
        for (Token token : tokenArr) {
            Object value = token.getValue();
            int count = token.getCount();
            if (value instanceof StringBuffer) {
                stringBuffer.append(value.toString());
            } else {
                if (value == y) {
                    String num = Integer.toString(i);
                    if (z) {
                        num = StringUtils.leftPad(num, count, '0');
                    }
                    stringBuffer.append(num);
                } else if (value == M) {
                    String num2 = Integer.toString(i2);
                    if (z) {
                        num2 = StringUtils.leftPad(num2, count, '0');
                    }
                    stringBuffer.append(num2);
                } else if (value == d) {
                    String num3 = Integer.toString(i3);
                    if (z) {
                        num3 = StringUtils.leftPad(num3, count, '0');
                    }
                    stringBuffer.append(num3);
                } else if (value == H) {
                    String num4 = Integer.toString(i4);
                    if (z) {
                        num4 = StringUtils.leftPad(num4, count, '0');
                    }
                    stringBuffer.append(num4);
                } else if (value == m) {
                    String num5 = Integer.toString(i5);
                    if (z) {
                        num5 = StringUtils.leftPad(num5, count, '0');
                    }
                    stringBuffer.append(num5);
                } else if (value == s) {
                    String num6 = Integer.toString(i6);
                    if (z) {
                        num6 = StringUtils.leftPad(num6, count, '0');
                    }
                    stringBuffer.append(num6);
                    z2 = true;
                } else if (value == S) {
                    if (z2) {
                        i8 += 1000;
                        String num7 = Integer.toString(i8);
                        if (z) {
                            num7 = StringUtils.leftPad(num7, count, '0');
                        }
                        stringBuffer.append(num7.substring(1));
                    } else {
                        String num8 = Integer.toString(i8);
                        if (z) {
                            num8 = StringUtils.leftPad(num8, count, '0');
                        }
                        stringBuffer.append(num8);
                    }
                }
                z2 = false;
            }
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0093 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static org.apache.commons.lang3.time.DurationFormatUtils.Token[] lexx(java.lang.String r10) {
        /*
            char[] r10 = r10.toCharArray()
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r10.length
            r0.<init>(r1)
            int r1 = r10.length
            r2 = 0
            r3 = 0
            r4 = r2
            r5 = r4
            r6 = r3
            r7 = r6
        L11:
            if (r4 >= r1) goto L97
            char r8 = r10[r4]
            r9 = 39
            if (r5 == 0) goto L20
            if (r8 == r9) goto L20
            r6.append(r8)
            goto L93
        L20:
            if (r8 == r9) goto L66
            r9 = 72
            if (r8 == r9) goto L63
            r9 = 77
            if (r8 == r9) goto L60
            r9 = 83
            if (r8 == r9) goto L5d
            r9 = 100
            if (r8 == r9) goto L5a
            r9 = 109(0x6d, float:1.53E-43)
            if (r8 == r9) goto L57
            r9 = 115(0x73, float:1.61E-43)
            if (r8 == r9) goto L54
            r9 = 121(0x79, float:1.7E-43)
            if (r8 == r9) goto L51
            if (r6 != 0) goto L4d
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            org.apache.commons.lang3.time.DurationFormatUtils$Token r9 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r9.<init>(r6)
            r0.add(r9)
        L4d:
            r6.append(r8)
            goto L7a
        L51:
            java.lang.Object r8 = org.apache.commons.lang3.time.DurationFormatUtils.y
            goto L7b
        L54:
            java.lang.Object r8 = org.apache.commons.lang3.time.DurationFormatUtils.s
            goto L7b
        L57:
            java.lang.Object r8 = org.apache.commons.lang3.time.DurationFormatUtils.m
            goto L7b
        L5a:
            java.lang.Object r8 = org.apache.commons.lang3.time.DurationFormatUtils.d
            goto L7b
        L5d:
            java.lang.Object r8 = org.apache.commons.lang3.time.DurationFormatUtils.S
            goto L7b
        L60:
            java.lang.Object r8 = org.apache.commons.lang3.time.DurationFormatUtils.M
            goto L7b
        L63:
            java.lang.Object r8 = org.apache.commons.lang3.time.DurationFormatUtils.H
            goto L7b
        L66:
            if (r5 == 0) goto L6c
            r5 = r2
            r6 = r3
            r8 = r6
            goto L7b
        L6c:
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            org.apache.commons.lang3.time.DurationFormatUtils$Token r5 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r5.<init>(r6)
            r0.add(r5)
            r5 = 1
        L7a:
            r8 = r3
        L7b:
            if (r8 == 0) goto L93
            if (r7 == 0) goto L89
            java.lang.Object r6 = r7.getValue()
            if (r6 != r8) goto L89
            r7.increment()
            goto L92
        L89:
            org.apache.commons.lang3.time.DurationFormatUtils$Token r6 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r6.<init>(r8)
            r0.add(r6)
            r7 = r6
        L92:
            r6 = r3
        L93:
            int r4 = r4 + 1
            goto L11
        L97:
            int r10 = r0.size()
            org.apache.commons.lang3.time.DurationFormatUtils$Token[] r10 = new org.apache.commons.lang3.time.DurationFormatUtils.Token[r10]
            java.lang.Object[] r10 = r0.toArray(r10)
            org.apache.commons.lang3.time.DurationFormatUtils$Token[] r10 = (org.apache.commons.lang3.time.DurationFormatUtils.Token[]) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DurationFormatUtils.lexx(java.lang.String):org.apache.commons.lang3.time.DurationFormatUtils$Token[]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Token {
        private int count;
        private final Object value;

        static boolean containsTokenWithValue(Token[] tokenArr, Object obj) {
            for (Token token : tokenArr) {
                if (token.getValue() == obj) {
                    return true;
                }
            }
            return false;
        }

        Token(Object obj) {
            this.value = obj;
            this.count = 1;
        }

        Token(Object obj, int i) {
            this.value = obj;
            this.count = i;
        }

        void increment() {
            this.count++;
        }

        int getCount() {
            return this.count;
        }

        Object getValue() {
            return this.value;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.value.getClass() != token.value.getClass() || this.count != token.count) {
                return false;
            }
            Object obj2 = this.value;
            if (obj2 instanceof StringBuffer) {
                return obj2.toString().equals(token.value.toString());
            }
            if (obj2 instanceof Number) {
                return obj2.equals(token.value);
            }
            return obj2 == token.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }
    }
}
