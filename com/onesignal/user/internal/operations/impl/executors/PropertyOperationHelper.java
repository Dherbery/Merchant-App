package com.onesignal.user.internal.operations.impl.executors;

import com.amplitude.api.Constants;
import com.onesignal.core.BuildConfig;
import com.onesignal.user.internal.backend.PropertiesObject;
import com.onesignal.user.internal.operations.DeleteTagOperation;
import com.onesignal.user.internal.operations.SetPropertyOperation;
import com.onesignal.user.internal.operations.SetTagOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PropertyOperationHelper.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/PropertyOperationHelper;", "", "()V", "createPropertiesFromOperation", "Lcom/onesignal/user/internal/backend/PropertiesObject;", "operation", "Lcom/onesignal/user/internal/operations/DeleteTagOperation;", "propertiesObject", "Lcom/onesignal/user/internal/operations/SetPropertyOperation;", "Lcom/onesignal/user/internal/operations/SetTagOperation;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PropertyOperationHelper {
    public static final PropertyOperationHelper INSTANCE = new PropertyOperationHelper();

    private PropertyOperationHelper() {
    }

    public final PropertiesObject createPropertiesFromOperation(SetTagOperation operation, PropertiesObject propertiesObject) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(propertiesObject, "propertiesObject");
        Map<String, String> tags = propertiesObject.getTags();
        LinkedHashMap mutableMap = tags != null ? MapsKt.toMutableMap(tags) : null;
        if (mutableMap == null) {
            mutableMap = new LinkedHashMap();
        }
        Map map = mutableMap;
        map.put(operation.getKey(), operation.getValue());
        return new PropertiesObject(map, propertiesObject.getLanguage(), propertiesObject.getTimezoneId(), propertiesObject.getCountry(), propertiesObject.getLatitude(), propertiesObject.getLongitude());
    }

    public final PropertiesObject createPropertiesFromOperation(DeleteTagOperation operation, PropertiesObject propertiesObject) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(propertiesObject, "propertiesObject");
        Map<String, String> tags = propertiesObject.getTags();
        LinkedHashMap mutableMap = tags != null ? MapsKt.toMutableMap(tags) : null;
        if (mutableMap == null) {
            mutableMap = new LinkedHashMap();
        }
        Map map = mutableMap;
        map.put(operation.getKey(), null);
        return new PropertiesObject(map, propertiesObject.getLanguage(), propertiesObject.getTimezoneId(), propertiesObject.getCountry(), propertiesObject.getLatitude(), propertiesObject.getLongitude());
    }

    public final PropertiesObject createPropertiesFromOperation(SetPropertyOperation operation, PropertiesObject propertiesObject) {
        String obj;
        String obj2;
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(propertiesObject, "propertiesObject");
        String property = operation.getProperty();
        Double d = null;
        r4 = null;
        Double d2 = null;
        d = null;
        if (Intrinsics.areEqual(property, Constants.AMP_TRACKING_OPTION_LANGUAGE)) {
            Map<String, String> tags = propertiesObject.getTags();
            Object value = operation.getValue();
            return new PropertiesObject(tags, value != null ? value.toString() : null, propertiesObject.getTimezoneId(), propertiesObject.getCountry(), propertiesObject.getLatitude(), propertiesObject.getLongitude());
        }
        if (Intrinsics.areEqual(property, "timezone")) {
            Map<String, String> tags2 = propertiesObject.getTags();
            String language = propertiesObject.getLanguage();
            Object value2 = operation.getValue();
            return new PropertiesObject(tags2, language, value2 != null ? value2.toString() : null, propertiesObject.getCountry(), propertiesObject.getLatitude(), propertiesObject.getLongitude());
        }
        if (Intrinsics.areEqual(property, Constants.AMP_TRACKING_OPTION_COUNTRY)) {
            Map<String, String> tags3 = propertiesObject.getTags();
            String language2 = propertiesObject.getLanguage();
            String timezoneId = propertiesObject.getTimezoneId();
            Object value3 = operation.getValue();
            return new PropertiesObject(tags3, language2, timezoneId, value3 != null ? value3.toString() : null, propertiesObject.getLatitude(), propertiesObject.getLongitude());
        }
        if (Intrinsics.areEqual(property, "locationLatitude")) {
            Map<String, String> tags4 = propertiesObject.getTags();
            String language3 = propertiesObject.getLanguage();
            String timezoneId2 = propertiesObject.getTimezoneId();
            String country = propertiesObject.getCountry();
            Object value4 = operation.getValue();
            if (value4 != null && (obj2 = value4.toString()) != null) {
                d2 = Double.valueOf(Double.parseDouble(obj2));
            }
            return new PropertiesObject(tags4, language3, timezoneId2, country, d2, propertiesObject.getLongitude());
        }
        if (Intrinsics.areEqual(property, "locationLongitude")) {
            Map<String, String> tags5 = propertiesObject.getTags();
            String language4 = propertiesObject.getLanguage();
            String timezoneId3 = propertiesObject.getTimezoneId();
            String country2 = propertiesObject.getCountry();
            Double latitude = propertiesObject.getLatitude();
            Object value5 = operation.getValue();
            if (value5 != null && (obj = value5.toString()) != null) {
                d = Double.valueOf(Double.parseDouble(obj));
            }
            return new PropertiesObject(tags5, language4, timezoneId3, country2, latitude, d);
        }
        return new PropertiesObject(propertiesObject.getTags(), propertiesObject.getLanguage(), propertiesObject.getTimezoneId(), propertiesObject.getCountry(), propertiesObject.getLatitude(), propertiesObject.getLongitude());
    }
}
