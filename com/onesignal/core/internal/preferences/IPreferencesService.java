package com.onesignal.core.internal.preferences;

import com.onesignal.core.BuildConfig;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: IPreferencesService.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\bJ+\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJ+\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000eJ&\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J2\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H&J'\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0015J'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u0017J'\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u0019J\"\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H&J(\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H&¨\u0006\u001c"}, d2 = {"Lcom/onesignal/core/internal/preferences/IPreferencesService;", "", "getBool", "", ProductResponseJsonKeys.STORE, "", SubscriberAttributeKt.JSON_NAME_KEY, "defValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "getInt", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "getLong", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "getString", "getStringSet", "", "saveBool", "", "value", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "saveInt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "saveLong", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "saveString", "saveStringSet", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IPreferencesService {
    Boolean getBool(String store, String key, Boolean defValue);

    Integer getInt(String store, String key, Integer defValue);

    Long getLong(String store, String key, Long defValue);

    String getString(String store, String key, String defValue);

    Set<String> getStringSet(String store, String key, Set<String> defValue);

    void saveBool(String store, String key, Boolean value);

    void saveInt(String store, String key, Integer value);

    void saveLong(String store, String key, Long value);

    void saveString(String store, String key, String value);

    void saveStringSet(String store, String key, Set<String> value);

    /* compiled from: IPreferencesService.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ String getString$default(IPreferencesService iPreferencesService, String str, String str2, String str3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            return iPreferencesService.getString(str, str2, str3);
        }

        public static /* synthetic */ Boolean getBool$default(IPreferencesService iPreferencesService, String str, String str2, Boolean bool, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBool");
            }
            if ((i & 4) != 0) {
                bool = null;
            }
            return iPreferencesService.getBool(str, str2, bool);
        }

        public static /* synthetic */ Integer getInt$default(IPreferencesService iPreferencesService, String str, String str2, Integer num, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInt");
            }
            if ((i & 4) != 0) {
                num = null;
            }
            return iPreferencesService.getInt(str, str2, num);
        }

        public static /* synthetic */ Long getLong$default(IPreferencesService iPreferencesService, String str, String str2, Long l, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLong");
            }
            if ((i & 4) != 0) {
                l = null;
            }
            return iPreferencesService.getLong(str, str2, l);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Set getStringSet$default(IPreferencesService iPreferencesService, String str, String str2, Set set, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getStringSet");
            }
            if ((i & 4) != 0) {
                set = null;
            }
            return iPreferencesService.getStringSet(str, str2, set);
        }
    }
}
