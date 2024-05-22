package com.rnmaps.maps;

import android.view.View;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import java.util.Map;

/* loaded from: classes5.dex */
public class MapManager extends ViewGroupManager<MapView> {
    private static final String REACT_CLASS = "AIRMap";
    private final ReactApplicationContext appContext;
    private MapMarkerManager markerManager;
    private final Map<String, Integer> MAP_TYPES = MapBuilder.of(Constants.COLLATION_STANDARD, 1, "satellite", 2, "hybrid", 4, "terrain", 3, "none", 0);
    private final Map<String, Integer> MY_LOCATION_PRIORITY = MapBuilder.of("balanced", 102, "high", 100, "low", 104, "passive", 105);
    protected GoogleMapOptions googleMapOptions = new GoogleMapOptions();

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    public MapManager(ReactApplicationContext reactApplicationContext) {
        this.appContext = reactApplicationContext;
    }

    public MapMarkerManager getMarkerManager() {
        return this.markerManager;
    }

    public void setMarkerManager(MapMarkerManager mapMarkerManager) {
        this.markerManager = mapMarkerManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public MapView createViewInstance(ThemedReactContext themedReactContext) {
        return new MapView(themedReactContext, this.appContext, this, this.googleMapOptions);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public MapView createViewInstance(int i, ThemedReactContext themedReactContext, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        if (reactStylesDiffMap != null) {
            if (reactStylesDiffMap.getString("googleMapId") != null) {
                this.googleMapOptions.mapId(reactStylesDiffMap.getString("googleMapId"));
            }
            if (reactStylesDiffMap.hasKey("liteMode")) {
                this.googleMapOptions.liteMode(reactStylesDiffMap.getBoolean("liteMode", false));
            }
        }
        return (MapView) super.createViewInstance(i, themedReactContext, reactStylesDiffMap, stateWrapper);
    }

    private void emitMapError(ThemedReactContext themedReactContext, String str, String str2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, str);
        createMap.putString("type", str2);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) themedReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onError", createMap);
    }

    @ReactProp(name = "region")
    public void setRegion(MapView mapView, ReadableMap readableMap) {
        mapView.setRegion(readableMap);
    }

    @ReactProp(defaultBoolean = false, name = "liteMode")
    public void setLiteMode(MapView mapView, boolean z) {
        this.googleMapOptions.liteMode(z);
    }

    @ReactProp(name = "googleMapId")
    public void setGoogleMapId(MapView mapView, String str) {
        if (str != null) {
            this.googleMapOptions.mapId(str);
        }
    }

    @ReactProp(name = "initialRegion")
    public void setInitialRegion(MapView mapView, ReadableMap readableMap) {
        mapView.setInitialRegion(readableMap);
    }

    @ReactProp(name = "camera")
    public void setCamera(MapView mapView, ReadableMap readableMap) {
        mapView.setCamera(readableMap);
    }

    @ReactProp(name = "initialCamera")
    public void setInitialCamera(MapView mapView, ReadableMap readableMap) {
        mapView.setInitialCamera(readableMap);
    }

    @ReactProp(name = "mapType")
    public void setMapType(MapView mapView, String str) {
        mapView.map.setMapType(this.MAP_TYPES.get(str).intValue());
    }

    @ReactProp(name = "customMapStyleString")
    public void setMapStyle(MapView mapView, String str) {
        mapView.setMapStyle(str);
    }

    @ReactProp(name = "mapPadding")
    public void setMapPadding(MapView mapView, ReadableMap readableMap) {
        int i;
        int i2;
        int i3;
        double d = mapView.getResources().getDisplayMetrics().density;
        if (readableMap != null) {
            int i4 = readableMap.hasKey("left") ? (int) (readableMap.getDouble("left") * d) : 0;
            i2 = readableMap.hasKey(ViewProps.TOP) ? (int) (readableMap.getDouble(ViewProps.TOP) * d) : 0;
            i3 = readableMap.hasKey("right") ? (int) (readableMap.getDouble("right") * d) : 0;
            i = readableMap.hasKey(ViewProps.BOTTOM) ? (int) (readableMap.getDouble(ViewProps.BOTTOM) * d) : 0;
            r2 = i4;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        mapView.applyBaseMapPadding(r2, i2, i3, i);
        mapView.map.setPadding(r2, i2, i3, i);
    }

    @ReactProp(defaultBoolean = false, name = "showsUserLocation")
    public void setShowsUserLocation(MapView mapView, boolean z) {
        mapView.setShowsUserLocation(z);
    }

    @ReactProp(name = "userLocationPriority")
    public void setUserLocationPriority(MapView mapView, String str) {
        mapView.setUserLocationPriority(this.MY_LOCATION_PRIORITY.get(str).intValue());
    }

    @ReactProp(defaultInt = 5000, name = "userLocationUpdateInterval")
    public void setUserLocationUpdateInterval(MapView mapView, int i) {
        mapView.setUserLocationUpdateInterval(i);
    }

    @ReactProp(defaultInt = 5000, name = "userLocationFastestInterval")
    public void setUserLocationFastestInterval(MapView mapView, int i) {
        mapView.setUserLocationFastestInterval(i);
    }

    @ReactProp(defaultBoolean = true, name = "showsMyLocationButton")
    public void setShowsMyLocationButton(MapView mapView, boolean z) {
        mapView.setShowsMyLocationButton(z);
    }

    @ReactProp(defaultBoolean = true, name = "toolbarEnabled")
    public void setToolbarEnabled(MapView mapView, boolean z) {
        mapView.setToolbarEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "handlePanDrag")
    public void setHandlePanDrag(MapView mapView, boolean z) {
        mapView.setHandlePanDrag(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsTraffic")
    public void setShowTraffic(MapView mapView, boolean z) {
        mapView.map.setTrafficEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsBuildings")
    public void setShowBuildings(MapView mapView, boolean z) {
        mapView.map.setBuildingsEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsIndoors")
    public void setShowIndoors(MapView mapView, boolean z) {
        mapView.map.setIndoorEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsIndoorLevelPicker")
    public void setShowsIndoorLevelPicker(MapView mapView, boolean z) {
        mapView.map.getUiSettings().setIndoorLevelPickerEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsCompass")
    public void setShowsCompass(MapView mapView, boolean z) {
        mapView.map.getUiSettings().setCompassEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "scrollEnabled")
    public void setScrollEnabled(MapView mapView, boolean z) {
        mapView.map.getUiSettings().setScrollGesturesEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "zoomEnabled")
    public void setZoomEnabled(MapView mapView, boolean z) {
        mapView.map.getUiSettings().setZoomGesturesEnabled(z);
    }

    @ReactProp(defaultBoolean = true, name = "zoomControlEnabled")
    public void setZoomControlEnabled(MapView mapView, boolean z) {
        mapView.map.getUiSettings().setZoomControlsEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "rotateEnabled")
    public void setRotateEnabled(MapView mapView, boolean z) {
        mapView.map.getUiSettings().setRotateGesturesEnabled(z);
    }

    @ReactProp(defaultBoolean = true, name = "scrollDuringRotateOrZoomEnabled")
    public void setScrollDuringRotateOrZoomEnabled(MapView mapView, boolean z) {
        mapView.map.getUiSettings().setScrollGesturesEnabledDuringRotateOrZoom(z);
    }

    @ReactProp(defaultBoolean = false, name = "cacheEnabled")
    public void setCacheEnabled(MapView mapView, boolean z) {
        mapView.setCacheEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "loadingEnabled")
    public void setLoadingEnabled(MapView mapView, boolean z) {
        mapView.enableMapLoading(z);
    }

    @ReactProp(defaultBoolean = true, name = "moveOnMarkerPress")
    public void setMoveOnMarkerPress(MapView mapView, boolean z) {
        mapView.setMoveOnMarkerPress(z);
    }

    @ReactProp(customType = "Color", name = "loadingBackgroundColor")
    public void setLoadingBackgroundColor(MapView mapView, Integer num) {
        mapView.setLoadingBackgroundColor(num);
    }

    @ReactProp(customType = "Color", name = "loadingIndicatorColor")
    public void setLoadingIndicatorColor(MapView mapView, Integer num) {
        mapView.setLoadingIndicatorColor(num);
    }

    @ReactProp(defaultBoolean = false, name = "pitchEnabled")
    public void setPitchEnabled(MapView mapView, boolean z) {
        mapView.map.getUiSettings().setTiltGesturesEnabled(z);
    }

    @ReactProp(name = "minZoomLevel")
    public void setMinZoomLevel(MapView mapView, float f) {
        mapView.map.setMinZoomPreference(f);
    }

    @ReactProp(name = "maxZoomLevel")
    public void setMaxZoomLevel(MapView mapView, float f) {
        mapView.map.setMaxZoomPreference(f);
    }

    @ReactProp(name = "kmlSrc")
    public void setKmlSrc(MapView mapView, String str) {
        if (str != null) {
            mapView.setKmlSrc(str);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(MapView mapView, String str, ReadableArray readableArray) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1144095793:
                if (str.equals("fitToSuppliedMarkers")) {
                    c = 0;
                    break;
                }
                break;
            case -3054903:
                if (str.equals("setIndoorActiveLevelIndex")) {
                    c = 1;
                    break;
                }
                break;
            case 113646119:
                if (str.equals("setCamera")) {
                    c = 2;
                    break;
                }
                break;
            case 369162114:
                if (str.equals("setMapBoundaries")) {
                    c = 3;
                    break;
                }
                break;
            case 483577731:
                if (str.equals("fitToElements")) {
                    c = 4;
                    break;
                }
                break;
            case 1505195366:
                if (str.equals("animateCamera")) {
                    c = 5;
                    break;
                }
                break;
            case 1713586000:
                if (str.equals("animateToRegion")) {
                    c = 6;
                    break;
                }
                break;
            case 2141065199:
                if (str.equals("fitToCoordinates")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (readableArray == null) {
                    return;
                }
                mapView.fitToSuppliedMarkers(readableArray.getArray(0), readableArray.getMap(1), readableArray.getBoolean(2));
                return;
            case 1:
                if (readableArray == null) {
                    return;
                }
                mapView.setIndoorActiveLevelIndex(readableArray.getInt(0));
                return;
            case 2:
                if (readableArray == null) {
                    return;
                }
                mapView.animateToCamera(readableArray.getMap(0), 0);
                return;
            case 3:
                if (readableArray == null) {
                    return;
                }
                mapView.setMapBoundaries(readableArray.getMap(0), readableArray.getMap(1));
                return;
            case 4:
                if (readableArray == null) {
                    return;
                }
                mapView.fitToElements(readableArray.getMap(0), readableArray.getBoolean(1));
                return;
            case 5:
                if (readableArray == null) {
                    return;
                }
                mapView.animateToCamera(readableArray.getMap(0), readableArray.getInt(1));
                return;
            case 6:
                if (readableArray == null) {
                    return;
                }
                ReadableMap map = readableArray.getMap(0);
                int i = readableArray.getInt(1);
                double d = map.getDouble("longitude");
                double d2 = map.getDouble("latitude");
                double d3 = map.getDouble("longitudeDelta");
                double d4 = map.getDouble("latitudeDelta") / 2.0d;
                double d5 = d3 / 2.0d;
                mapView.animateToRegion(new LatLngBounds(new LatLng(d2 - d4, d - d5), new LatLng(d2 + d4, d + d5)), i);
                return;
            case 7:
                if (readableArray == null) {
                    return;
                }
                mapView.fitToCoordinates(readableArray.getArray(0), readableArray.getMap(1), readableArray.getBoolean(2));
                return;
            default:
                return;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        Map of = MapBuilder.of("onMapReady", MapBuilder.of("registrationName", "onMapReady"), "onPress", MapBuilder.of("registrationName", "onPress"), "onLongPress", MapBuilder.of("registrationName", "onLongPress"), "onMarkerPress", MapBuilder.of("registrationName", "onMarkerPress"), "onMarkerSelect", MapBuilder.of("registrationName", "onMarkerSelect"), "onMarkerDeselect", MapBuilder.of("registrationName", "onMarkerDeselect"), "onCalloutPress", MapBuilder.of("registrationName", "onCalloutPress"));
        of.putAll(MapBuilder.of("onUserLocationChange", MapBuilder.of("registrationName", "onUserLocationChange"), "onMarkerDragStart", MapBuilder.of("registrationName", "onMarkerDragStart"), "onMarkerDrag", MapBuilder.of("registrationName", "onMarkerDrag"), "onMarkerDragEnd", MapBuilder.of("registrationName", "onMarkerDragEnd"), "onPanDrag", MapBuilder.of("registrationName", "onPanDrag"), "onKmlReady", MapBuilder.of("registrationName", "onKmlReady"), "onPoiClick", MapBuilder.of("registrationName", "onPoiClick")));
        of.putAll(MapBuilder.of("onIndoorLevelActivated", MapBuilder.of("registrationName", "onIndoorLevelActivated"), "onIndoorBuildingFocused", MapBuilder.of("registrationName", "onIndoorBuildingFocused"), "onDoublePress", MapBuilder.of("registrationName", "onDoublePress"), "onMapLoaded", MapBuilder.of("registrationName", "onMapLoaded")));
        return of;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new SizeReportingShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(MapView mapView, View view, int i) {
        mapView.addFeature(view, i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(MapView mapView) {
        return mapView.getFeatureCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(MapView mapView, int i) {
        return mapView.getFeatureAt(i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(MapView mapView, int i) {
        mapView.removeFeatureAt(i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void updateExtraData(MapView mapView, Object obj) {
        mapView.updateExtraData(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pushEvent(ThemedReactContext themedReactContext, View view, String str, WritableMap writableMap) {
        ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(view.getId(), str, writableMap);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(MapView mapView) {
        mapView.doDestroy();
        super.onDropViewInstance((MapManager) mapView);
    }
}
