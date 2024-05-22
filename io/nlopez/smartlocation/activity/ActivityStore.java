package io.nlopez.smartlocation.activity;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.location.DetectedActivity;
import io.nlopez.smartlocation.common.Store;

/* loaded from: classes.dex */
public class ActivityStore implements Store<DetectedActivity> {
    private static final String ACTIVITY_ID = "ACTIVITY";
    private static final String CONFIDENCE_ID = "CONFIDENCE";
    private static final String PREFERENCES_FILE = "ACTIVITY_STORE";
    private static final String PREFIX_ID = ActivityStore.class.getCanonicalName() + ".KEY";
    private SharedPreferences preferences;

    public ActivityStore(Context context) {
        this.preferences = context.getSharedPreferences(PREFERENCES_FILE, 0);
    }

    public void setPreferences(SharedPreferences sharedPreferences) {
        this.preferences = sharedPreferences;
    }

    @Override // io.nlopez.smartlocation.common.Store
    public void put(String str, DetectedActivity detectedActivity) {
        SharedPreferences.Editor edit = this.preferences.edit();
        edit.putInt(getFieldKey(str, ACTIVITY_ID), detectedActivity.getType());
        edit.putInt(getFieldKey(str, CONFIDENCE_ID), detectedActivity.getConfidence());
        edit.apply();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.nlopez.smartlocation.common.Store
    public DetectedActivity get(String str) {
        SharedPreferences sharedPreferences = this.preferences;
        if (sharedPreferences != null && sharedPreferences.contains(getFieldKey(str, ACTIVITY_ID)) && this.preferences.contains(getFieldKey(str, CONFIDENCE_ID))) {
            return new DetectedActivity(this.preferences.getInt(getFieldKey(str, ACTIVITY_ID), 4), this.preferences.getInt(getFieldKey(str, CONFIDENCE_ID), 0));
        }
        return null;
    }

    @Override // io.nlopez.smartlocation.common.Store
    public void remove(String str) {
        SharedPreferences.Editor edit = this.preferences.edit();
        edit.remove(getFieldKey(str, ACTIVITY_ID));
        edit.remove(getFieldKey(str, CONFIDENCE_ID));
        edit.apply();
    }

    private String getFieldKey(String str, String str2) {
        return PREFIX_ID + "_" + str + "_" + str2;
    }
}
