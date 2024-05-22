package org.apache.commons.lang3.time;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes6.dex */
abstract class FormatCache<F extends Format> {
    static final int NONE = -1;
    private final ConcurrentMap<MultipartKey, F> cInstanceCache = new ConcurrentHashMap(7);
    private final ConcurrentMap<MultipartKey, String> cDateTimeInstanceCache = new ConcurrentHashMap(7);

    protected abstract F createInstance(String str, TimeZone timeZone, Locale locale);

    public F getInstance() {
        return getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    public F getInstance(String str, TimeZone timeZone, Locale locale) {
        if (str == null) {
            throw new NullPointerException("pattern must not be null");
        }
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        MultipartKey multipartKey = new MultipartKey(str, timeZone, locale);
        F f = this.cInstanceCache.get(multipartKey);
        if (f != null) {
            return f;
        }
        F createInstance = createInstance(str, timeZone, locale);
        F putIfAbsent = this.cInstanceCache.putIfAbsent(multipartKey, createInstance);
        return putIfAbsent != null ? putIfAbsent : createInstance;
    }

    public F getDateTimeInstance(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        DateFormat dateTimeInstance;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        MultipartKey multipartKey = new MultipartKey(num, num2, locale);
        String str = this.cDateTimeInstanceCache.get(multipartKey);
        if (str == null) {
            try {
                if (num == null) {
                    dateTimeInstance = DateFormat.getTimeInstance(num2.intValue(), locale);
                } else if (num2 == null) {
                    dateTimeInstance = DateFormat.getDateInstance(num.intValue(), locale);
                } else {
                    dateTimeInstance = DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale);
                }
                String pattern = ((SimpleDateFormat) dateTimeInstance).toPattern();
                String putIfAbsent = this.cDateTimeInstanceCache.putIfAbsent(multipartKey, pattern);
                str = putIfAbsent != null ? putIfAbsent : pattern;
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("No date time pattern for locale: " + locale);
            }
        }
        return getInstance(str, timeZone, locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class MultipartKey {
        private int hashCode;
        private final Object[] keys;

        public MultipartKey(Object... objArr) {
            this.keys = objArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MultipartKey) {
                return Arrays.equals(this.keys, ((MultipartKey) obj).keys);
            }
            return false;
        }

        public int hashCode() {
            if (this.hashCode == 0) {
                int i = 0;
                for (Object obj : this.keys) {
                    if (obj != null) {
                        i = (i * 7) + obj.hashCode();
                    }
                }
                this.hashCode = i;
            }
            return this.hashCode;
        }
    }
}
