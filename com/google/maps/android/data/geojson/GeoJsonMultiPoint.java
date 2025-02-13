package com.google.maps.android.data.geojson;

import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.MultiGeometry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class GeoJsonMultiPoint extends MultiGeometry {
    public GeoJsonMultiPoint(List<GeoJsonPoint> list) {
        super(list);
        setGeometryType("MultiPoint");
    }

    public String getType() {
        return getGeometryType();
    }

    public List<GeoJsonPoint> getPoints() {
        List geometryObject = getGeometryObject();
        ArrayList arrayList = new ArrayList();
        Iterator it = geometryObject.iterator();
        while (it.hasNext()) {
            arrayList.add((GeoJsonPoint) ((Geometry) it.next()));
        }
        return arrayList;
    }
}
