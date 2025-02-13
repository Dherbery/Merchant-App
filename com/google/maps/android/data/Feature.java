package com.google.maps.android.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* loaded from: classes5.dex */
public class Feature extends Observable {
    private Geometry mGeometry;
    protected String mId;
    private final Map<String, String> mProperties;

    public Feature(Geometry geometry, String str, Map<String, String> map) {
        this.mGeometry = geometry;
        this.mId = str;
        if (map == null) {
            this.mProperties = new HashMap();
        } else {
            this.mProperties = map;
        }
    }

    public Iterable<String> getPropertyKeys() {
        return this.mProperties.keySet();
    }

    public Iterable getProperties() {
        return this.mProperties.entrySet();
    }

    public String getProperty(String str) {
        return this.mProperties.get(str);
    }

    public String getId() {
        return this.mId;
    }

    public boolean hasProperty(String str) {
        return this.mProperties.containsKey(str);
    }

    public Geometry getGeometry() {
        return this.mGeometry;
    }

    public boolean hasProperties() {
        return this.mProperties.size() > 0;
    }

    public boolean hasGeometry() {
        return this.mGeometry != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String setProperty(String str, String str2) {
        return this.mProperties.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String removeProperty(String str) {
        return this.mProperties.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setGeometry(Geometry geometry) {
        this.mGeometry = geometry;
    }
}
