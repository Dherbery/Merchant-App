package com.google.maps.android.data.kml;

import com.facebook.react.uimanager.ViewProps;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.data.Geometry;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class KmlFeatureParser {
    private static final int ALTITUDE_INDEX = 2;
    private static final String BOUNDARY_REGEX = "outerBoundaryIs|innerBoundaryIs";
    private static final String COMPASS_REGEX = "north|south|east|west";
    private static final String EXTENDED_DATA = "ExtendedData";
    private static final String GEOMETRY_REGEX = "Point|LineString|Polygon|MultiGeometry|Track|MultiTrack";
    private static final int LATITUDE_INDEX = 1;
    private static final String LAT_LNG_ALT_SEPARATOR = ",";
    private static final int LONGITUDE_INDEX = 0;
    private static final String PROPERTY_REGEX = "name|description|drawOrder|visibility|open|address|phoneNumber";
    private static final String STYLE_TAG = "Style";
    private static final String STYLE_URL_TAG = "styleUrl";

    KmlFeatureParser() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class LatLngAlt {
        public final Double altitude;
        public final LatLng latLng;

        LatLngAlt(LatLng latLng, Double d) {
            this.latLng = latLng;
            this.altitude = d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KmlPlacemark createPlacemark(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        HashMap hashMap = new HashMap();
        int eventType = xmlPullParser.getEventType();
        Geometry geometry = null;
        String str = null;
        KmlStyle kmlStyle = null;
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("Placemark")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals(STYLE_URL_TAG)) {
                        str = xmlPullParser.nextText();
                    } else if (xmlPullParser.getName().matches(GEOMETRY_REGEX)) {
                        geometry = createGeometry(xmlPullParser, xmlPullParser.getName());
                    } else if (xmlPullParser.getName().matches(PROPERTY_REGEX)) {
                        hashMap.put(xmlPullParser.getName(), xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals(EXTENDED_DATA)) {
                        hashMap.putAll(setExtendedDataProperties(xmlPullParser));
                    } else if (xmlPullParser.getName().equals(STYLE_TAG)) {
                        kmlStyle = KmlStyleParser.createStyle(xmlPullParser);
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return new KmlPlacemark(geometry, str, kmlStyle, hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KmlGroundOverlay createGroundOverlay(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int eventType = xmlPullParser.getEventType();
        String str = null;
        float f = 0.0f;
        int i = 1;
        float f2 = 0.0f;
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("GroundOverlay")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("Icon")) {
                        str = getImageUrl(xmlPullParser);
                    } else if (xmlPullParser.getName().equals("drawOrder")) {
                        f2 = Float.parseFloat(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals("visibility")) {
                        i = Integer.parseInt(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals(EXTENDED_DATA)) {
                        hashMap.putAll(setExtendedDataProperties(xmlPullParser));
                    } else if (xmlPullParser.getName().equals(ViewProps.ROTATION)) {
                        f = getRotation(xmlPullParser);
                    } else if (xmlPullParser.getName().matches(PROPERTY_REGEX) || xmlPullParser.getName().equals("color")) {
                        hashMap.put(xmlPullParser.getName(), xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().matches(COMPASS_REGEX)) {
                        hashMap2.put(xmlPullParser.getName(), Double.valueOf(Double.parseDouble(xmlPullParser.nextText())));
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return new KmlGroundOverlay(str, createLatLngBounds((Double) hashMap2.get("north"), (Double) hashMap2.get("south"), (Double) hashMap2.get("east"), (Double) hashMap2.get("west")), f2, i, hashMap, f);
            }
        }
    }

    private static float getRotation(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        return -Float.parseFloat(xmlPullParser.nextText());
    }

    private static String getImageUrl(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("Icon")) {
                return null;
            }
            if (eventType == 2 && xmlPullParser.getName().equals("href")) {
                return xmlPullParser.nextText();
            }
            eventType = xmlPullParser.next();
        }
    }

    private static Geometry createGeometry(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals(str)) {
                return null;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("Point")) {
                    return createPoint(xmlPullParser);
                }
                if (xmlPullParser.getName().equals("LineString")) {
                    return createLineString(xmlPullParser);
                }
                if (xmlPullParser.getName().equals("Track")) {
                    return createTrack(xmlPullParser);
                }
                if (xmlPullParser.getName().equals(KmlPolygon.GEOMETRY_TYPE)) {
                    return createPolygon(xmlPullParser);
                }
                if (xmlPullParser.getName().equals("MultiGeometry")) {
                    return createMultiGeometry(xmlPullParser);
                }
                if (xmlPullParser.getName().equals("MultiTrack")) {
                    return createMultiTrack(xmlPullParser);
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    private static HashMap<String, String> setExtendedDataProperties(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        int eventType = xmlPullParser.getEventType();
        String str = null;
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals(EXTENDED_DATA)) {
                return hashMap;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("Data")) {
                    str = xmlPullParser.getAttributeValue(null, "name");
                } else if (xmlPullParser.getName().equals("value") && str != null) {
                    hashMap.put(str, xmlPullParser.nextText());
                    str = null;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    private static KmlPoint createPoint(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        LatLngAlt latLngAlt = null;
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("Point")) {
                if (eventType == 2 && xmlPullParser.getName().equals("coordinates")) {
                    latLngAlt = convertToLatLngAlt(xmlPullParser.nextText());
                }
                eventType = xmlPullParser.next();
            } else {
                return new KmlPoint(latLngAlt.latLng, latLngAlt.altitude);
            }
        }
    }

    private static KmlLineString createLineString(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("LineString")) {
                if (eventType == 2 && xmlPullParser.getName().equals("coordinates")) {
                    for (LatLngAlt latLngAlt : convertToLatLngAltArray(xmlPullParser.nextText())) {
                        arrayList.add(latLngAlt.latLng);
                        if (latLngAlt.altitude != null) {
                            arrayList2.add(latLngAlt.altitude);
                        }
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return new KmlLineString(arrayList, arrayList2);
            }
        }
    }

    private static KmlTrack createTrack(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        HashMap hashMap = new HashMap();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("Track")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("coord")) {
                        LatLngAlt convertToLatLngAlt = convertToLatLngAlt(xmlPullParser.nextText(), MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        arrayList.add(convertToLatLngAlt.latLng);
                        if (convertToLatLngAlt.altitude != null) {
                            arrayList2.add(convertToLatLngAlt.altitude);
                        }
                    } else if (xmlPullParser.getName().equals("when")) {
                        try {
                            arrayList3.add(Long.valueOf(simpleDateFormat.parse(xmlPullParser.nextText()).getTime()));
                        } catch (ParseException e) {
                            throw new XmlPullParserException("Invalid date", xmlPullParser, e);
                        }
                    } else if (xmlPullParser.getName().equals(EXTENDED_DATA)) {
                        hashMap.putAll(setExtendedDataProperties(xmlPullParser));
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return new KmlTrack(arrayList, arrayList2, arrayList3, hashMap);
            }
        }
    }

    private static KmlPolygon createPolygon(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList<LatLng> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        boolean z = false;
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals(KmlPolygon.GEOMETRY_TYPE)) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().matches(BOUNDARY_REGEX)) {
                        z = xmlPullParser.getName().equals("outerBoundaryIs");
                    } else if (xmlPullParser.getName().equals("coordinates")) {
                        if (z) {
                            arrayList = convertToLatLngArray(xmlPullParser.nextText());
                        } else {
                            arrayList2.add(convertToLatLngArray(xmlPullParser.nextText()));
                        }
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return new KmlPolygon(arrayList, arrayList2);
            }
        }
    }

    private static KmlMultiGeometry createMultiGeometry(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        int next = xmlPullParser.next();
        while (true) {
            if (next != 3 || !xmlPullParser.getName().equals("MultiGeometry")) {
                if (next == 2 && xmlPullParser.getName().matches(GEOMETRY_REGEX)) {
                    arrayList.add(createGeometry(xmlPullParser, xmlPullParser.getName()));
                }
                next = xmlPullParser.next();
            } else {
                return new KmlMultiGeometry(arrayList);
            }
        }
    }

    private static KmlMultiTrack createMultiTrack(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        int next = xmlPullParser.next();
        while (true) {
            if (next != 3 || !xmlPullParser.getName().equals("MultiTrack")) {
                if (next == 2 && xmlPullParser.getName().matches("Track")) {
                    arrayList.add(createTrack(xmlPullParser));
                }
                next = xmlPullParser.next();
            } else {
                return new KmlMultiTrack(arrayList);
            }
        }
    }

    private static ArrayList<LatLng> convertToLatLngArray(String str) {
        ArrayList<LatLngAlt> convertToLatLngAltArray = convertToLatLngAltArray(str);
        ArrayList<LatLng> arrayList = new ArrayList<>();
        Iterator<LatLngAlt> it = convertToLatLngAltArray.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().latLng);
        }
        return arrayList;
    }

    private static ArrayList<LatLngAlt> convertToLatLngAltArray(String str) {
        ArrayList<LatLngAlt> arrayList = new ArrayList<>();
        for (String str2 : str.trim().split("(\\s+)")) {
            arrayList.add(convertToLatLngAlt(str2));
        }
        return arrayList;
    }

    private static LatLngAlt convertToLatLngAlt(String str) {
        return convertToLatLngAlt(str, ",");
    }

    private static LatLngAlt convertToLatLngAlt(String str, String str2) {
        String[] split = str.split(str2);
        if (split.length < 2) {
            throw new IllegalArgumentException("Wrong coordinate, latitude and longitude must be set");
        }
        return new LatLngAlt(new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[0])), split.length > 2 ? Double.valueOf(Double.parseDouble(split[2])) : null);
    }

    private static LatLngBounds createLatLngBounds(Double d, Double d2, Double d3, Double d4) {
        return new LatLngBounds(new LatLng(d2.doubleValue(), d4.doubleValue()), new LatLng(d.doubleValue(), d3.doubleValue()));
    }
}
