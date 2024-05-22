package com.reactnativecommunity.asyncstorage;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import javax.annotation.Nullable;

/* loaded from: classes5.dex */
public class AsyncStorageErrorUtil {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static WritableMap getError(@Nullable String str, String str2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, str2);
        if (str != null) {
            createMap.putString(SubscriberAttributeKt.JSON_NAME_KEY, str);
        }
        return createMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WritableMap getInvalidKeyError(@Nullable String str) {
        return getError(str, "Invalid key");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WritableMap getInvalidValueError(@Nullable String str) {
        return getError(str, "Invalid Value");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WritableMap getDBError(@Nullable String str) {
        return getError(str, "Database Error");
    }
}
