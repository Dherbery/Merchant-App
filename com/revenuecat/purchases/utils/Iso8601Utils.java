package com.revenuecat.purchases.utils;

import com.revenuecat.purchases.common.Constants;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public final class Iso8601Utils {
    private static final String GMT_ID = "GMT";
    private static final TimeZone TIMEZONE_Z = TimeZone.getTimeZone(GMT_ID);

    public static String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TIMEZONE_Z, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(24);
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(AbstractJsonLexerKt.COLON);
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(AbstractJsonLexerKt.COLON);
        padInt(sb, gregorianCalendar.get(13), 2);
        sb.append('.');
        padInt(sb, gregorianCalendar.get(14), 3);
        sb.append('Z');
        return sb.toString();
    }

    public static Date parse(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        TimeZone timeZone;
        char charAt;
        try {
            int parseInt = parseInt(str, 0, 4);
            int i5 = checkOffset(str, 4, '-') ? 5 : 4;
            int i6 = i5 + 2;
            int parseInt2 = parseInt(str, i5, i6);
            if (checkOffset(str, i6, '-')) {
                i6++;
            }
            int i7 = i6 + 2;
            int parseInt3 = parseInt(str, i6, i7);
            boolean checkOffset = checkOffset(str, i7, 'T');
            if (!checkOffset && str.length() <= i7) {
                return new GregorianCalendar(parseInt, parseInt2 - 1, parseInt3).getTime();
            }
            if (checkOffset) {
                int i8 = i7 + 1;
                int i9 = i8 + 2;
                int parseInt4 = parseInt(str, i8, i9);
                if (checkOffset(str, i9, AbstractJsonLexerKt.COLON)) {
                    i9++;
                }
                int i10 = i9 + 2;
                i4 = parseInt(str, i9, i10);
                if (checkOffset(str, i10, AbstractJsonLexerKt.COLON)) {
                    i10++;
                }
                if (str.length() <= i10 || (charAt = str.charAt(i10)) == 'Z' || charAt == '+' || charAt == '-') {
                    i = parseInt4;
                    i7 = i10;
                    i2 = 0;
                    i3 = 0;
                } else {
                    int i11 = i10 + 2;
                    i3 = parseInt(str, i10, i11);
                    if (i3 > 59 && i3 < 63) {
                        i3 = 59;
                    }
                    if (checkOffset(str, i11, '.')) {
                        int i12 = i11 + 1;
                        int indexOfNonDigit = indexOfNonDigit(str, i12 + 1);
                        int min = Math.min(indexOfNonDigit, i12 + 3);
                        int parseInt5 = parseInt(str, i12, min);
                        double d = 3 - (min - i12);
                        i = parseInt4;
                        i2 = (int) (Math.pow(10.0d, d) * parseInt5);
                        i7 = indexOfNonDigit;
                        i3 = i3;
                    } else {
                        i = parseInt4;
                        i7 = i11;
                        i2 = 0;
                    }
                }
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
            }
            if (str.length() <= i7) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char charAt2 = str.charAt(i7);
            if (charAt2 == 'Z') {
                timeZone = TIMEZONE_Z;
            } else {
                if (charAt2 != '+' && charAt2 != '-') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                }
                String substring = str.substring(i7);
                if (!"+0000".equals(substring) && !"+00:00".equals(substring)) {
                    String str2 = GMT_ID + substring;
                    TimeZone timeZone2 = TimeZone.getTimeZone(str2);
                    String id = timeZone2.getID();
                    if (!id.equals(str2) && !id.replace(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, "").equals(str2)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str2 + " given, resolves to " + timeZone2.getID());
                    }
                    timeZone = timeZone2;
                }
                timeZone = TIMEZONE_Z;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, parseInt);
            gregorianCalendar.set(2, parseInt2 - 1);
            gregorianCalendar.set(5, parseInt3);
            gregorianCalendar.set(11, i);
            gregorianCalendar.set(12, i4);
            gregorianCalendar.set(13, i3);
            gregorianCalendar.set(14, i2);
            return gregorianCalendar.getTime();
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            throw new SerializationException("Not an RFC 3339 date: " + str, e);
        }
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -digit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - digit2;
            i4 = i5;
        }
        return -i3;
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
