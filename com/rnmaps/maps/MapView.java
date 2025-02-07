package com.rnmaps.maps;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.location.Location;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.content.PermissionChecker;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.IndoorLevel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.maps.android.collections.CircleManager;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Renderer;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlLayer;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.onesignal.location.internal.common.LocationConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class MapView extends com.google.android.gms.maps.MapView implements GoogleMap.InfoWindowAdapter, GoogleMap.OnMarkerDragListener, OnMapReadyCallback, GoogleMap.OnPoiClickListener, GoogleMap.OnIndoorStateChangeListener {
    private static final String[] PERMISSIONS = {LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING, LocationConstants.ANDROID_COARSE_LOCATION_PERMISSION_STRING};
    private final ViewAttacherGroup attacherGroup;
    int baseBottomMapPadding;
    int baseLeftMapPadding;
    private final int baseMapPadding;
    int baseRightMapPadding;
    int baseTopMapPadding;
    private LatLngBounds boundsToMove;
    private boolean cacheEnabled;
    private ImageView cacheImageView;
    private ReadableMap camera;
    private LatLngBounds cameraLastIdleBounds;
    private int cameraMoveReason;
    private CameraUpdate cameraToSet;
    private CircleManager.Collection circleCollection;
    private final ThemedReactContext context;
    private String customMapStyleString;
    private boolean destroyed;
    private final EventDispatcher eventDispatcher;
    private final List<MapFeature> features;
    private final FusedLocationSource fusedLocationSource;
    private final GestureDetectorCompat gestureDetector;
    private final Map<TileOverlay, MapGradientPolyline> gradientPolylineMap;
    private GroundOverlayManager.Collection groundOverlayCollection;
    private GroundOverlayManager groundOverlayManager;
    private boolean handlePanDrag;
    private final Map<TileOverlay, MapHeatmap> heatmapMap;
    private ReadableMap initialCamera;
    private boolean initialCameraSet;
    private ReadableMap initialRegion;
    private boolean initialRegionSet;
    private Boolean isMapLoaded;
    private LifecycleEventListener lifecycleListener;
    private Integer loadingBackgroundColor;
    private Integer loadingIndicatorColor;
    private final MapManager manager;
    public GoogleMap map;
    private RelativeLayout mapLoadingLayout;
    private ProgressBar mapLoadingProgressBar;
    private MarkerManager.Collection markerCollection;
    private MarkerManager markerManager;
    private final Map<Marker, MapMarker> markerMap;
    private final Runnable measureAndLayout;
    private boolean moveOnMarkerPress;
    private final Map<GroundOverlay, MapOverlay> overlayMap;
    private boolean paused;
    private PolygonManager.Collection polygonCollection;
    private PolygonManager polygonManager;
    private final Map<Polygon, MapPolygon> polygonMap;
    private PolylineManager.Collection polylineCollection;
    private PolylineManager polylineManager;
    private final Map<Polyline, MapPolyline> polylineMap;
    private ReadableMap region;
    private boolean showUserLocation;
    private LatLng tapLocation;

    private static boolean contextHasBug(Context context) {
        return context == null || context.getResources() == null || context.getResources().getConfiguration() == null;
    }

    private static Context getNonBuggyContext(ThemedReactContext themedReactContext, ReactApplicationContext reactApplicationContext) {
        if (!contextHasBug(reactApplicationContext.getCurrentActivity())) {
            return reactApplicationContext.getCurrentActivity();
        }
        if (!contextHasBug(themedReactContext)) {
            return themedReactContext;
        }
        if (contextHasBug(themedReactContext.getCurrentActivity())) {
            return !contextHasBug(themedReactContext.getApplicationContext()) ? themedReactContext.getApplicationContext() : themedReactContext;
        }
        return themedReactContext.getCurrentActivity();
    }

    public MapView(ThemedReactContext themedReactContext, ReactApplicationContext reactApplicationContext, MapManager mapManager, GoogleMapOptions googleMapOptions) {
        super(getNonBuggyContext(themedReactContext, reactApplicationContext), googleMapOptions);
        this.isMapLoaded = false;
        this.loadingBackgroundColor = null;
        this.loadingIndicatorColor = null;
        this.baseMapPadding = 50;
        this.showUserLocation = false;
        this.handlePanDrag = false;
        this.moveOnMarkerPress = true;
        this.cacheEnabled = false;
        this.initialRegionSet = false;
        this.initialCameraSet = false;
        this.cameraMoveReason = 0;
        this.features = new ArrayList();
        this.markerMap = new HashMap();
        this.polylineMap = new HashMap();
        this.polygonMap = new HashMap();
        this.overlayMap = new HashMap();
        this.heatmapMap = new HashMap();
        this.gradientPolylineMap = new HashMap();
        this.paused = false;
        this.destroyed = false;
        this.measureAndLayout = new Runnable() { // from class: com.rnmaps.maps.MapView.17
            @Override // java.lang.Runnable
            public void run() {
                MapView mapView = MapView.this;
                mapView.measure(View.MeasureSpec.makeMeasureSpec(mapView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(MapView.this.getHeight(), 1073741824));
                MapView mapView2 = MapView.this;
                mapView2.layout(mapView2.getLeft(), MapView.this.getTop(), MapView.this.getRight(), MapView.this.getBottom());
            }
        };
        this.manager = mapManager;
        this.context = themedReactContext;
        super.onCreate(null);
        super.onResume();
        super.getMapAsync(this);
        this.fusedLocationSource = new FusedLocationSource(themedReactContext);
        this.gestureDetector = new GestureDetectorCompat(themedReactContext, new GestureDetector.SimpleOnGestureListener() { // from class: com.rnmaps.maps.MapView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (!MapView.this.handlePanDrag) {
                    return false;
                }
                MapView.this.onPanDrag(motionEvent2);
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                MapView.this.onDoublePress(motionEvent);
                return false;
            }
        });
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.rnmaps.maps.MapView.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (MapView.this.paused) {
                    return;
                }
                MapView.this.cacheView();
            }
        });
        this.eventDispatcher = ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        ViewAttacherGroup viewAttacherGroup = new ViewAttacherGroup(themedReactContext);
        this.attacherGroup = viewAttacherGroup;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
        layoutParams.width = 0;
        layoutParams.height = 0;
        layoutParams.leftMargin = 99999999;
        layoutParams.topMargin = 99999999;
        viewAttacherGroup.setLayoutParams(layoutParams);
        addView(viewAttacherGroup);
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(final GoogleMap googleMap) {
        if (this.destroyed) {
            return;
        }
        this.map = googleMap;
        MarkerManager markerManager = new MarkerManager(googleMap);
        this.markerManager = markerManager;
        this.markerCollection = markerManager.newCollection();
        PolylineManager polylineManager = new PolylineManager(googleMap);
        this.polylineManager = polylineManager;
        this.polylineCollection = polylineManager.newCollection();
        PolygonManager polygonManager = new PolygonManager(googleMap);
        this.polygonManager = polygonManager;
        this.polygonCollection = polygonManager.newCollection();
        this.circleCollection = new CircleManager(googleMap).newCollection();
        GroundOverlayManager groundOverlayManager = new GroundOverlayManager(googleMap);
        this.groundOverlayManager = groundOverlayManager;
        this.groundOverlayCollection = groundOverlayManager.newCollection();
        this.markerCollection.setInfoWindowAdapter(this);
        this.markerCollection.setOnMarkerDragListener(this);
        this.map.setOnPoiClickListener(this);
        this.map.setOnIndoorStateChangeListener(this);
        applyBridgedProps();
        this.manager.pushEvent(this.context, this, "onMapReady", new WritableNativeMap());
        googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() { // from class: com.rnmaps.maps.MapView.3
            @Override // com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener
            public void onMyLocationChange(Location location) {
                WritableMap writableNativeMap = new WritableNativeMap();
                WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                writableNativeMap2.putDouble("latitude", location.getLatitude());
                writableNativeMap2.putDouble("longitude", location.getLongitude());
                writableNativeMap2.putDouble("altitude", location.getAltitude());
                writableNativeMap2.putDouble("timestamp", location.getTime());
                writableNativeMap2.putDouble("accuracy", location.getAccuracy());
                writableNativeMap2.putDouble("speed", location.getSpeed());
                writableNativeMap2.putDouble("heading", location.getBearing());
                writableNativeMap2.putBoolean("isFromMockProvider", location.isFromMockProvider());
                writableNativeMap.putMap("coordinate", writableNativeMap2);
                MapView.this.manager.pushEvent(MapView.this.context, this, "onUserLocationChange", writableNativeMap);
            }
        });
        this.markerCollection.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { // from class: com.rnmaps.maps.MapView.4
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public boolean onMarkerClick(Marker marker) {
                MapMarker markerMap = MapView.this.getMarkerMap(marker);
                WritableMap makeClickEventData = MapView.this.makeClickEventData(marker.getPosition());
                makeClickEventData.putString("action", "marker-press");
                makeClickEventData.putString("id", markerMap.getIdentifier());
                MapView.this.manager.pushEvent(MapView.this.context, this, "onMarkerPress", makeClickEventData);
                WritableMap makeClickEventData2 = MapView.this.makeClickEventData(marker.getPosition());
                makeClickEventData2.putString("action", "marker-press");
                makeClickEventData2.putString("id", markerMap.getIdentifier());
                MapView.this.manager.pushEvent(MapView.this.context, markerMap, "onPress", makeClickEventData2);
                if (this.moveOnMarkerPress) {
                    return false;
                }
                marker.showInfoWindow();
                return true;
            }
        });
        this.polygonCollection.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() { // from class: com.rnmaps.maps.MapView.5
            @Override // com.google.android.gms.maps.GoogleMap.OnPolygonClickListener
            public void onPolygonClick(Polygon polygon) {
                MapView mapView = MapView.this;
                WritableMap makeClickEventData = mapView.makeClickEventData(mapView.tapLocation);
                makeClickEventData.putString("action", "polygon-press");
                MapView.this.manager.pushEvent(MapView.this.context, (View) MapView.this.polygonMap.get(polygon), "onPress", makeClickEventData);
            }
        });
        this.polylineCollection.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() { // from class: com.rnmaps.maps.MapView.6
            @Override // com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
            public void onPolylineClick(Polyline polyline) {
                MapView mapView = MapView.this;
                WritableMap makeClickEventData = mapView.makeClickEventData(mapView.tapLocation);
                makeClickEventData.putString("action", "polyline-press");
                MapView.this.manager.pushEvent(MapView.this.context, (View) MapView.this.polylineMap.get(polyline), "onPress", makeClickEventData);
            }
        });
        this.markerCollection.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() { // from class: com.rnmaps.maps.MapView.7
            @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
            public void onInfoWindowClick(Marker marker) {
                WritableMap makeClickEventData = MapView.this.makeClickEventData(marker.getPosition());
                makeClickEventData.putString("action", "callout-press");
                MapView.this.manager.pushEvent(MapView.this.context, this, "onCalloutPress", makeClickEventData);
                WritableMap makeClickEventData2 = MapView.this.makeClickEventData(marker.getPosition());
                makeClickEventData2.putString("action", "callout-press");
                MapMarker markerMap = MapView.this.getMarkerMap(marker);
                MapView.this.manager.pushEvent(MapView.this.context, markerMap, "onCalloutPress", makeClickEventData2);
                WritableMap makeClickEventData3 = MapView.this.makeClickEventData(marker.getPosition());
                makeClickEventData3.putString("action", "callout-press");
                MapCallout calloutView = markerMap.getCalloutView();
                if (calloutView != null) {
                    MapView.this.manager.pushEvent(MapView.this.context, calloutView, "onPress", makeClickEventData3);
                }
            }
        });
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() { // from class: com.rnmaps.maps.MapView.8
            @Override // com.google.android.gms.maps.GoogleMap.OnMapClickListener
            public void onMapClick(LatLng latLng) {
                WritableMap makeClickEventData = MapView.this.makeClickEventData(latLng);
                makeClickEventData.putString("action", "press");
                MapView.this.manager.pushEvent(MapView.this.context, this, "onPress", makeClickEventData);
            }
        });
        googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() { // from class: com.rnmaps.maps.MapView.9
            @Override // com.google.android.gms.maps.GoogleMap.OnMapLongClickListener
            public void onMapLongClick(LatLng latLng) {
                MapView.this.makeClickEventData(latLng).putString("action", "long-press");
                MapView.this.manager.pushEvent(MapView.this.context, this, "onLongPress", MapView.this.makeClickEventData(latLng));
            }
        });
        this.groundOverlayCollection.setOnGroundOverlayClickListener(new GoogleMap.OnGroundOverlayClickListener() { // from class: com.rnmaps.maps.MapView.10
            @Override // com.google.android.gms.maps.GoogleMap.OnGroundOverlayClickListener
            public void onGroundOverlayClick(GroundOverlay groundOverlay) {
                WritableMap makeClickEventData = MapView.this.makeClickEventData(groundOverlay.getPosition());
                makeClickEventData.putString("action", "overlay-press");
                MapView.this.manager.pushEvent(MapView.this.context, (View) MapView.this.overlayMap.get(groundOverlay), "onPress", makeClickEventData);
            }
        });
        googleMap.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() { // from class: com.rnmaps.maps.MapView.11
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
            public void onCameraMoveStarted(int i) {
                MapView.this.cameraMoveReason = i;
            }
        });
        googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() { // from class: com.rnmaps.maps.MapView.12
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
            public void onCameraMove() {
                LatLngBounds latLngBounds = googleMap.getProjection().getVisibleRegion().latLngBounds;
                MapView.this.cameraLastIdleBounds = null;
                MapView.this.eventDispatcher.dispatchEvent(new RegionChangeEvent(MapView.this.getId(), latLngBounds, true, 1 == MapView.this.cameraMoveReason));
            }
        });
        googleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() { // from class: com.rnmaps.maps.MapView.13
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
            public void onCameraIdle() {
                LatLngBounds latLngBounds = googleMap.getProjection().getVisibleRegion().latLngBounds;
                if (MapView.this.cameraMoveReason != 0) {
                    if (MapView.this.cameraLastIdleBounds == null || LatLngBoundsUtils.BoundsAreDifferent(latLngBounds, MapView.this.cameraLastIdleBounds)) {
                        MapView.this.cameraLastIdleBounds = latLngBounds;
                        MapView.this.eventDispatcher.dispatchEvent(new RegionChangeEvent(MapView.this.getId(), latLngBounds, false, 1 == MapView.this.cameraMoveReason));
                    }
                }
            }
        });
        googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() { // from class: com.rnmaps.maps.MapView.14
            @Override // com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback
            public void onMapLoaded() {
                MapView.this.isMapLoaded = true;
                MapView.this.manager.pushEvent(MapView.this.context, this, "onMapLoaded", new WritableNativeMap());
                MapView.this.cacheView();
            }
        });
        LifecycleEventListener lifecycleEventListener = new LifecycleEventListener() { // from class: com.rnmaps.maps.MapView.15
            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostResume() {
                GoogleMap googleMap2;
                if (MapView.this.hasPermissions() && (googleMap2 = googleMap) != null) {
                    googleMap2.setMyLocationEnabled(MapView.this.showUserLocation);
                    googleMap.setLocationSource(MapView.this.fusedLocationSource);
                }
                synchronized (MapView.this) {
                    if (!MapView.this.destroyed) {
                        MapView.this.onResume();
                    }
                    MapView.this.paused = false;
                }
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostPause() {
                GoogleMap googleMap2;
                if (MapView.this.hasPermissions() && (googleMap2 = googleMap) != null) {
                    googleMap2.setMyLocationEnabled(false);
                }
                synchronized (MapView.this) {
                    if (!MapView.this.destroyed) {
                        MapView.this.onPause();
                    }
                    MapView.this.paused = true;
                }
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostDestroy() {
                MapView.this.doDestroy();
            }
        };
        this.lifecycleListener = lifecycleEventListener;
        this.context.addLifecycleEventListener(lifecycleEventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasPermissions() {
        Context context = getContext();
        String[] strArr = PERMISSIONS;
        return PermissionChecker.checkSelfPermission(context, strArr[0]) == 0 || PermissionChecker.checkSelfPermission(getContext(), strArr[1]) == 0;
    }

    public synchronized void doDestroy() {
        ThemedReactContext themedReactContext;
        if (this.destroyed) {
            return;
        }
        this.destroyed = true;
        LifecycleEventListener lifecycleEventListener = this.lifecycleListener;
        if (lifecycleEventListener != null && (themedReactContext = this.context) != null) {
            themedReactContext.removeLifecycleEventListener(lifecycleEventListener);
            this.lifecycleListener = null;
        }
        if (!this.paused) {
            onPause();
            this.paused = true;
        }
        onDestroy();
    }

    public void setInitialRegion(ReadableMap readableMap) {
        this.initialRegion = readableMap;
        if (this.initialRegionSet || this.map == null) {
            return;
        }
        moveToRegion(readableMap);
        this.initialRegionSet = true;
    }

    public void setInitialCamera(ReadableMap readableMap) {
        this.initialCamera = readableMap;
        if (this.initialCameraSet || this.map == null) {
            return;
        }
        moveToCamera(readableMap);
        this.initialCameraSet = true;
    }

    private void applyBridgedProps() {
        ReadableMap readableMap = this.initialRegion;
        if (readableMap != null) {
            moveToRegion(readableMap);
            this.initialRegionSet = true;
        } else {
            ReadableMap readableMap2 = this.initialCamera;
            if (readableMap2 != null) {
                moveToCamera(readableMap2);
                this.initialCameraSet = true;
            } else {
                ReadableMap readableMap3 = this.region;
                if (readableMap3 != null) {
                    moveToRegion(readableMap3);
                } else {
                    moveToCamera(this.camera);
                }
            }
        }
        if (this.customMapStyleString != null) {
            this.map.setMapStyle(new MapStyleOptions(this.customMapStyleString));
        }
    }

    private void moveToRegion(ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        double d = readableMap.getDouble("longitude");
        double d2 = readableMap.getDouble("latitude");
        double d3 = readableMap.getDouble("longitudeDelta");
        double d4 = readableMap.getDouble("latitudeDelta") / 2.0d;
        double d5 = d3 / 2.0d;
        LatLngBounds latLngBounds = new LatLngBounds(new LatLng(d2 - d4, d - d5), new LatLng(d4 + d2, d5 + d));
        if (super.getHeight() <= 0 || super.getWidth() <= 0) {
            this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d2, d), 10.0f));
            this.boundsToMove = latLngBounds;
        } else {
            this.map.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 0));
            this.boundsToMove = null;
        }
    }

    public void setRegion(ReadableMap readableMap) {
        this.region = readableMap;
        if (readableMap == null || this.map == null) {
            return;
        }
        moveToRegion(readableMap);
    }

    public void setCamera(ReadableMap readableMap) {
        this.camera = readableMap;
        if (readableMap == null || this.map == null) {
            return;
        }
        moveToCamera(readableMap);
    }

    public void moveToCamera(ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        CameraPosition.Builder builder = new CameraPosition.Builder();
        ReadableMap map = readableMap.getMap(TtmlNode.CENTER);
        if (map != null) {
            builder.target(new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        builder.tilt((float) readableMap.getDouble("pitch"));
        builder.bearing((float) readableMap.getDouble("heading"));
        builder.zoom((float) readableMap.getDouble("zoom"));
        CameraUpdate newCameraPosition = CameraUpdateFactory.newCameraPosition(builder.build());
        if (super.getHeight() <= 0 || super.getWidth() <= 0) {
            this.cameraToSet = newCameraPosition;
        } else {
            this.map.moveCamera(newCameraPosition);
            this.cameraToSet = null;
        }
    }

    public void setMapStyle(String str) {
        this.customMapStyleString = str;
        GoogleMap googleMap = this.map;
        if (googleMap == null || str == null) {
            return;
        }
        googleMap.setMapStyle(new MapStyleOptions(str));
    }

    public void setShowsUserLocation(boolean z) {
        this.showUserLocation = z;
        if (hasPermissions()) {
            this.map.setLocationSource(this.fusedLocationSource);
            this.map.setMyLocationEnabled(z);
        }
    }

    public void setUserLocationPriority(int i) {
        this.fusedLocationSource.setPriority(i);
    }

    public void setUserLocationUpdateInterval(int i) {
        this.fusedLocationSource.setInterval(i);
    }

    public void setUserLocationFastestInterval(int i) {
        this.fusedLocationSource.setFastestInterval(i);
    }

    public void setShowsMyLocationButton(boolean z) {
        if (hasPermissions() || !z) {
            this.map.getUiSettings().setMyLocationButtonEnabled(z);
        }
    }

    public void setToolbarEnabled(boolean z) {
        if (hasPermissions() || !z) {
            this.map.getUiSettings().setMapToolbarEnabled(z);
        }
    }

    public void setCacheEnabled(boolean z) {
        this.cacheEnabled = z;
        cacheView();
    }

    public void enableMapLoading(boolean z) {
        if (!z || this.isMapLoaded.booleanValue()) {
            return;
        }
        getMapLoadingLayoutView().setVisibility(0);
    }

    public void setMoveOnMarkerPress(boolean z) {
        this.moveOnMarkerPress = z;
    }

    public void setLoadingBackgroundColor(Integer num) {
        this.loadingBackgroundColor = num;
        RelativeLayout relativeLayout = this.mapLoadingLayout;
        if (relativeLayout != null) {
            if (num == null) {
                relativeLayout.setBackgroundColor(-1);
            } else {
                relativeLayout.setBackgroundColor(num.intValue());
            }
        }
    }

    public void setLoadingIndicatorColor(Integer num) {
        this.loadingIndicatorColor = num;
        if (this.mapLoadingProgressBar != null) {
            if (num == null) {
                Integer.valueOf(Color.parseColor("#606060"));
            }
            ColorStateList valueOf = ColorStateList.valueOf(num.intValue());
            ColorStateList valueOf2 = ColorStateList.valueOf(num.intValue());
            ColorStateList valueOf3 = ColorStateList.valueOf(num.intValue());
            this.mapLoadingProgressBar.setProgressTintList(valueOf);
            this.mapLoadingProgressBar.setSecondaryProgressTintList(valueOf2);
            this.mapLoadingProgressBar.setIndeterminateTintList(valueOf3);
        }
    }

    public void setHandlePanDrag(boolean z) {
        this.handlePanDrag = z;
    }

    public void addFeature(View view, int i) {
        if (view instanceof MapMarker) {
            MapMarker mapMarker = (MapMarker) view;
            mapMarker.addToMap(this.markerCollection);
            this.features.add(i, mapMarker);
            int visibility = mapMarker.getVisibility();
            mapMarker.setVisibility(4);
            ViewGroup viewGroup = (ViewGroup) mapMarker.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(mapMarker);
            }
            this.attacherGroup.addView(mapMarker);
            mapMarker.setVisibility(visibility);
            this.markerMap.put((Marker) mapMarker.getFeature(), mapMarker);
            return;
        }
        if (view instanceof MapPolyline) {
            MapPolyline mapPolyline = (MapPolyline) view;
            mapPolyline.addToMap(this.polylineCollection);
            this.features.add(i, mapPolyline);
            this.polylineMap.put((Polyline) mapPolyline.getFeature(), mapPolyline);
            return;
        }
        if (view instanceof MapGradientPolyline) {
            MapGradientPolyline mapGradientPolyline = (MapGradientPolyline) view;
            mapGradientPolyline.addToMap(this.map);
            this.features.add(i, mapGradientPolyline);
            this.gradientPolylineMap.put((TileOverlay) mapGradientPolyline.getFeature(), mapGradientPolyline);
            return;
        }
        if (view instanceof MapPolygon) {
            MapPolygon mapPolygon = (MapPolygon) view;
            mapPolygon.addToMap(this.polygonCollection);
            this.features.add(i, mapPolygon);
            this.polygonMap.put((Polygon) mapPolygon.getFeature(), mapPolygon);
            return;
        }
        if (view instanceof MapCircle) {
            MapCircle mapCircle = (MapCircle) view;
            mapCircle.addToMap(this.circleCollection);
            this.features.add(i, mapCircle);
            return;
        }
        if (view instanceof MapUrlTile) {
            MapUrlTile mapUrlTile = (MapUrlTile) view;
            mapUrlTile.addToMap(this.map);
            this.features.add(i, mapUrlTile);
            return;
        }
        if (view instanceof MapWMSTile) {
            MapWMSTile mapWMSTile = (MapWMSTile) view;
            mapWMSTile.addToMap(this.map);
            this.features.add(i, mapWMSTile);
            return;
        }
        if (view instanceof MapLocalTile) {
            MapLocalTile mapLocalTile = (MapLocalTile) view;
            mapLocalTile.addToMap(this.map);
            this.features.add(i, mapLocalTile);
            return;
        }
        if (view instanceof MapOverlay) {
            MapOverlay mapOverlay = (MapOverlay) view;
            mapOverlay.addToMap(this.groundOverlayCollection);
            this.features.add(i, mapOverlay);
            this.overlayMap.put((GroundOverlay) mapOverlay.getFeature(), mapOverlay);
            return;
        }
        if (view instanceof MapHeatmap) {
            MapHeatmap mapHeatmap = (MapHeatmap) view;
            mapHeatmap.addToMap(this.map);
            this.features.add(i, mapHeatmap);
            this.heatmapMap.put((TileOverlay) mapHeatmap.getFeature(), mapHeatmap);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                addFeature(viewGroup2.getChildAt(i2), i);
            }
            return;
        }
        addView(view, i);
    }

    public int getFeatureCount() {
        return this.features.size();
    }

    public View getFeatureAt(int i) {
        return this.features.get(i);
    }

    public void removeFeatureAt(int i) {
        MapFeature remove = this.features.remove(i);
        if (remove instanceof MapMarker) {
            this.markerMap.remove(remove.getFeature());
            remove.removeFromMap(this.markerCollection);
            return;
        }
        if (remove instanceof MapHeatmap) {
            this.heatmapMap.remove(remove.getFeature());
            remove.removeFromMap(this.map);
            return;
        }
        if (remove instanceof MapCircle) {
            remove.removeFromMap(this.circleCollection);
            return;
        }
        if (remove instanceof MapOverlay) {
            remove.removeFromMap(this.groundOverlayCollection);
            return;
        }
        if (remove instanceof MapPolygon) {
            remove.removeFromMap(this.polygonCollection);
        } else if (remove instanceof MapPolyline) {
            remove.removeFromMap(this.polylineCollection);
        } else {
            remove.removeFromMap(this.map);
        }
    }

    public WritableMap makeClickEventData(LatLng latLng) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putDouble("latitude", latLng.latitude);
        writableNativeMap2.putDouble("longitude", latLng.longitude);
        writableNativeMap.putMap("coordinate", writableNativeMap2);
        Point screenLocation = this.map.getProjection().toScreenLocation(latLng);
        WritableNativeMap writableNativeMap3 = new WritableNativeMap();
        writableNativeMap3.putDouble("x", screenLocation.x);
        writableNativeMap3.putDouble("y", screenLocation.y);
        writableNativeMap.putMap(ViewProps.POSITION, writableNativeMap3);
        return writableNativeMap;
    }

    public void updateExtraData(Object obj) {
        if (this.boundsToMove != null) {
            HashMap hashMap = (HashMap) obj;
            int intValue = hashMap.get("width") == null ? 0 : ((Float) hashMap.get("width")).intValue();
            int intValue2 = hashMap.get("height") == null ? 0 : ((Float) hashMap.get("height")).intValue();
            if (intValue <= 0 || intValue2 <= 0) {
                this.map.moveCamera(CameraUpdateFactory.newLatLngBounds(this.boundsToMove, 0));
            } else {
                this.map.moveCamera(CameraUpdateFactory.newLatLngBounds(this.boundsToMove, intValue, intValue2, 0));
            }
            this.boundsToMove = null;
            this.cameraToSet = null;
            return;
        }
        CameraUpdate cameraUpdate = this.cameraToSet;
        if (cameraUpdate != null) {
            this.map.moveCamera(cameraUpdate);
            this.cameraToSet = null;
        }
    }

    public void animateToCamera(ReadableMap readableMap, int i) {
        if (this.map == null) {
            return;
        }
        CameraPosition.Builder builder = new CameraPosition.Builder(this.map.getCameraPosition());
        if (readableMap.hasKey("zoom")) {
            builder.zoom((float) readableMap.getDouble("zoom"));
        }
        if (readableMap.hasKey("heading")) {
            builder.bearing((float) readableMap.getDouble("heading"));
        }
        if (readableMap.hasKey("pitch")) {
            builder.tilt((float) readableMap.getDouble("pitch"));
        }
        if (readableMap.hasKey(TtmlNode.CENTER)) {
            ReadableMap map = readableMap.getMap(TtmlNode.CENTER);
            builder.target(new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        CameraUpdate newCameraPosition = CameraUpdateFactory.newCameraPosition(builder.build());
        if (i <= 0) {
            this.map.moveCamera(newCameraPosition);
        } else {
            this.map.animateCamera(newCameraPosition, i, null);
        }
    }

    public void animateToRegion(LatLngBounds latLngBounds, int i) {
        GoogleMap googleMap = this.map;
        if (googleMap == null) {
            return;
        }
        if (i <= 0) {
            googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 0));
        } else {
            googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 0), i, null);
        }
    }

    public void fitToElements(ReadableMap readableMap, boolean z) {
        if (this.map == null) {
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        boolean z2 = false;
        for (MapFeature mapFeature : this.features) {
            if (mapFeature instanceof MapMarker) {
                builder.include(((Marker) mapFeature.getFeature()).getPosition());
                z2 = true;
            }
        }
        if (z2) {
            CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(builder.build(), 50);
            if (readableMap != null) {
                this.map.setPadding(readableMap.getInt("left"), readableMap.getInt(ViewProps.TOP), readableMap.getInt("right"), readableMap.getInt(ViewProps.BOTTOM));
            }
            if (z) {
                this.map.animateCamera(newLatLngBounds);
            } else {
                this.map.moveCamera(newLatLngBounds);
            }
        }
    }

    public void fitToSuppliedMarkers(ReadableArray readableArray, ReadableMap readableMap, boolean z) {
        if (this.map == null) {
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        String[] strArr = new String[readableArray.size()];
        boolean z2 = false;
        for (int i = 0; i < readableArray.size(); i++) {
            strArr[i] = readableArray.getString(i);
        }
        List asList = Arrays.asList(strArr);
        for (MapFeature mapFeature : this.features) {
            if (mapFeature instanceof MapMarker) {
                String identifier = ((MapMarker) mapFeature).getIdentifier();
                Marker marker = (Marker) mapFeature.getFeature();
                if (asList.contains(identifier)) {
                    builder.include(marker.getPosition());
                    z2 = true;
                }
            }
        }
        if (z2) {
            CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(builder.build(), 50);
            if (readableMap != null) {
                this.map.setPadding(readableMap.getInt("left"), readableMap.getInt(ViewProps.TOP), readableMap.getInt("right"), readableMap.getInt(ViewProps.BOTTOM));
            }
            if (z) {
                this.map.animateCamera(newLatLngBounds);
            } else {
                this.map.moveCamera(newLatLngBounds);
            }
        }
    }

    public void applyBaseMapPadding(int i, int i2, int i3, int i4) {
        this.map.setPadding(i, i2, i3, i4);
        this.baseLeftMapPadding = i;
        this.baseRightMapPadding = i3;
        this.baseTopMapPadding = i2;
        this.baseBottomMapPadding = i4;
    }

    public void fitToCoordinates(ReadableArray readableArray, ReadableMap readableMap, boolean z) {
        if (this.map == null) {
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            builder.include(new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(builder.build(), 50);
        if (readableMap != null) {
            appendMapPadding(readableMap.getInt("left"), readableMap.getInt(ViewProps.TOP), readableMap.getInt("right"), readableMap.getInt(ViewProps.BOTTOM));
        }
        if (z) {
            this.map.animateCamera(newLatLngBounds);
        } else {
            this.map.moveCamera(newLatLngBounds);
        }
        this.map.setPadding(this.baseLeftMapPadding, this.baseTopMapPadding, this.baseRightMapPadding, this.baseBottomMapPadding);
    }

    private void appendMapPadding(int i, int i2, int i3, int i4) {
        double d = getResources().getDisplayMetrics().density;
        this.map.setPadding(((int) (i * d)) + this.baseLeftMapPadding, ((int) (i2 * d)) + this.baseTopMapPadding, ((int) (i3 * d)) + this.baseRightMapPadding, ((int) (i4 * d)) + this.baseBottomMapPadding);
    }

    public double[][] getMapBoundaries() {
        LatLngBounds latLngBounds = this.map.getProjection().getVisibleRegion().latLngBounds;
        LatLng latLng = latLngBounds.northeast;
        LatLng latLng2 = latLngBounds.southwest;
        return new double[][]{new double[]{latLng.longitude, latLng.latitude}, new double[]{latLng2.longitude, latLng2.latitude}};
    }

    public void setMapBoundaries(ReadableMap readableMap, ReadableMap readableMap2) {
        if (this.map == null) {
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(new LatLng(readableMap.getDouble("latitude"), readableMap.getDouble("longitude")));
        builder.include(new LatLng(readableMap2.getDouble("latitude"), readableMap2.getDouble("longitude")));
        this.map.setLatLngBoundsForCameraTarget(builder.build());
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View getInfoWindow(Marker marker) {
        return getMarkerMap(marker).getCallout();
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View getInfoContents(Marker marker) {
        return getMarkerMap(marker).getInfoContents();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.gestureDetector.onTouchEvent(motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            this.tapLocation = googleMap.getProjection().fromScreenLocation(new Point(x, y));
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean z = false;
        if (actionMasked == 0) {
            ViewParent parent = getParent();
            GoogleMap googleMap2 = this.map;
            if (googleMap2 != null && googleMap2.getUiSettings().isScrollGesturesEnabled()) {
                z = true;
            }
            parent.requestDisallowInterceptTouchEvent(z);
        } else if (actionMasked == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDragStart(Marker marker) {
        this.manager.pushEvent(this.context, this, "onMarkerDragStart", makeClickEventData(marker.getPosition()));
        this.manager.pushEvent(this.context, getMarkerMap(marker), "onDragStart", makeClickEventData(marker.getPosition()));
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDrag(Marker marker) {
        this.manager.pushEvent(this.context, this, "onMarkerDrag", makeClickEventData(marker.getPosition()));
        this.manager.pushEvent(this.context, getMarkerMap(marker), "onDrag", makeClickEventData(marker.getPosition()));
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDragEnd(Marker marker) {
        this.manager.pushEvent(this.context, this, "onMarkerDragEnd", makeClickEventData(marker.getPosition()));
        this.manager.pushEvent(this.context, getMarkerMap(marker), "onDragEnd", makeClickEventData(marker.getPosition()));
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnPoiClickListener
    public void onPoiClick(PointOfInterest pointOfInterest) {
        WritableMap makeClickEventData = makeClickEventData(pointOfInterest.latLng);
        makeClickEventData.putString("placeId", pointOfInterest.placeId);
        makeClickEventData.putString("name", pointOfInterest.name);
        this.manager.pushEvent(this.context, this, "onPoiClick", makeClickEventData);
    }

    private ProgressBar getMapLoadingProgressBar() {
        if (this.mapLoadingProgressBar == null) {
            ProgressBar progressBar = new ProgressBar(getContext());
            this.mapLoadingProgressBar = progressBar;
            progressBar.setIndeterminate(true);
        }
        Integer num = this.loadingIndicatorColor;
        if (num != null) {
            setLoadingIndicatorColor(num);
        }
        return this.mapLoadingProgressBar;
    }

    private RelativeLayout getMapLoadingLayoutView() {
        if (this.mapLoadingLayout == null) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            this.mapLoadingLayout = relativeLayout;
            relativeLayout.setBackgroundColor(-3355444);
            addView(this.mapLoadingLayout, new ViewGroup.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.mapLoadingLayout.addView(getMapLoadingProgressBar(), layoutParams);
            this.mapLoadingLayout.setVisibility(4);
        }
        setLoadingBackgroundColor(this.loadingBackgroundColor);
        return this.mapLoadingLayout;
    }

    private ImageView getCacheImageView() {
        if (this.cacheImageView == null) {
            ImageView imageView = new ImageView(getContext());
            this.cacheImageView = imageView;
            addView(imageView, new ViewGroup.LayoutParams(-1, -1));
            this.cacheImageView.setVisibility(4);
        }
        return this.cacheImageView;
    }

    private void removeCacheImageView() {
        ImageView imageView = this.cacheImageView;
        if (imageView != null) {
            ((ViewGroup) imageView.getParent()).removeView(this.cacheImageView);
            this.cacheImageView = null;
        }
    }

    private void removeMapLoadingProgressBar() {
        ProgressBar progressBar = this.mapLoadingProgressBar;
        if (progressBar != null) {
            ((ViewGroup) progressBar.getParent()).removeView(this.mapLoadingProgressBar);
            this.mapLoadingProgressBar = null;
        }
    }

    private void removeMapLoadingLayoutView() {
        removeMapLoadingProgressBar();
        RelativeLayout relativeLayout = this.mapLoadingLayout;
        if (relativeLayout != null) {
            ((ViewGroup) relativeLayout.getParent()).removeView(this.mapLoadingLayout);
            this.mapLoadingLayout = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cacheView() {
        if (this.cacheEnabled) {
            final ImageView cacheImageView = getCacheImageView();
            final RelativeLayout mapLoadingLayoutView = getMapLoadingLayoutView();
            cacheImageView.setVisibility(4);
            mapLoadingLayoutView.setVisibility(0);
            if (this.isMapLoaded.booleanValue()) {
                this.map.snapshot(new GoogleMap.SnapshotReadyCallback() { // from class: com.rnmaps.maps.MapView.16
                    @Override // com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
                    public void onSnapshotReady(Bitmap bitmap) {
                        cacheImageView.setImageBitmap(bitmap);
                        cacheImageView.setVisibility(0);
                        mapLoadingLayoutView.setVisibility(4);
                    }
                });
                return;
            }
            return;
        }
        removeCacheImageView();
        if (this.isMapLoaded.booleanValue()) {
            removeMapLoadingLayoutView();
        }
    }

    public void onPanDrag(MotionEvent motionEvent) {
        this.manager.pushEvent(this.context, this, "onPanDrag", makeClickEventData(this.map.getProjection().fromScreenLocation(new Point((int) motionEvent.getX(), (int) motionEvent.getY()))));
    }

    public void onDoublePress(MotionEvent motionEvent) {
        if (this.map == null) {
            return;
        }
        this.manager.pushEvent(this.context, this, "onDoublePress", makeClickEventData(this.map.getProjection().fromScreenLocation(new Point((int) motionEvent.getX(), (int) motionEvent.getY()))));
    }

    public void setKmlSrc(String str) {
        String str2 = "name";
        try {
            InputStream inputStream = new FileUtil(this.context).execute(str).get();
            if (inputStream == null) {
                return;
            }
            KmlLayer kmlLayer = new KmlLayer(this.map, inputStream, this.context, this.markerManager, this.polygonManager, this.polylineManager, this.groundOverlayManager, (Renderer.ImagesCache) null);
            kmlLayer.addLayerToMap();
            WritableMap writableNativeMap = new WritableNativeMap();
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            if (kmlLayer.getContainers() == null) {
                this.manager.pushEvent(this.context, this, "onKmlReady", writableNativeMap);
                return;
            }
            KmlContainer next = kmlLayer.getContainers().iterator().next();
            if (next != null && next.getContainers() != null) {
                if (next.getContainers().iterator().hasNext()) {
                    next = next.getContainers().iterator().next();
                }
                int i = 0;
                for (KmlPlacemark kmlPlacemark : next.getPlacemarks()) {
                    MarkerOptions markerOptions = new MarkerOptions();
                    if (kmlPlacemark.getInlineStyle() != null) {
                        markerOptions = kmlPlacemark.getMarkerOptions();
                    } else {
                        markerOptions.icon(BitmapDescriptorFactory.defaultMarker());
                    }
                    LatLng latLng = (LatLng) kmlPlacemark.getGeometry().getGeometryObject();
                    String property = kmlPlacemark.hasProperty(str2) ? kmlPlacemark.getProperty(str2) : "";
                    String property2 = kmlPlacemark.hasProperty(b.c) ? kmlPlacemark.getProperty(b.c) : "";
                    markerOptions.position(latLng);
                    markerOptions.title(property);
                    markerOptions.snippet(property2);
                    String str3 = str2;
                    MapMarker mapMarker = new MapMarker(this.context, markerOptions, this.manager.getMarkerManager());
                    if (kmlPlacemark.getInlineStyle() != null && kmlPlacemark.getInlineStyle().getIconUrl() != null) {
                        mapMarker.setImage(kmlPlacemark.getInlineStyle().getIconUrl());
                    } else if (next.getStyle(kmlPlacemark.getStyleId()) != null) {
                        mapMarker.setImage(next.getStyle(kmlPlacemark.getStyleId()).getIconUrl());
                    }
                    String str4 = property + " - " + i;
                    mapMarker.setIdentifier(str4);
                    int i2 = i + 1;
                    addFeature(mapMarker, i);
                    WritableMap makeClickEventData = makeClickEventData(latLng);
                    makeClickEventData.putString("id", str4);
                    makeClickEventData.putString("title", property);
                    makeClickEventData.putString(b.c, property2);
                    writableNativeArray.pushMap(makeClickEventData);
                    i = i2;
                    str2 = str3;
                }
                writableNativeMap.putArray("markers", writableNativeArray);
                this.manager.pushEvent(this.context, this, "onKmlReady", writableNativeMap);
                return;
            }
            this.manager.pushEvent(this.context, this, "onKmlReady", writableNativeMap);
        } catch (IOException | InterruptedException | ExecutionException | XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnIndoorStateChangeListener
    public void onIndoorBuildingFocused() {
        IndoorBuilding focusedBuilding = this.map.getFocusedBuilding();
        int i = 0;
        if (focusedBuilding != null) {
            List<IndoorLevel> levels = focusedBuilding.getLevels();
            WritableArray createArray = Arguments.createArray();
            for (IndoorLevel indoorLevel : levels) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("index", i);
                createMap.putString("name", indoorLevel.getName());
                createMap.putString("shortName", indoorLevel.getShortName());
                createArray.pushMap(createMap);
                i++;
            }
            WritableMap createMap2 = Arguments.createMap();
            WritableMap createMap3 = Arguments.createMap();
            createMap3.putArray("levels", createArray);
            createMap3.putInt("activeLevelIndex", focusedBuilding.getActiveLevelIndex());
            createMap3.putBoolean("underground", focusedBuilding.isUnderground());
            createMap2.putMap("IndoorBuilding", createMap3);
            this.manager.pushEvent(this.context, this, "onIndoorBuildingFocused", createMap2);
            return;
        }
        WritableMap createMap4 = Arguments.createMap();
        WritableArray createArray2 = Arguments.createArray();
        WritableMap createMap5 = Arguments.createMap();
        createMap5.putArray("levels", createArray2);
        createMap5.putInt("activeLevelIndex", 0);
        createMap5.putBoolean("underground", false);
        createMap4.putMap("IndoorBuilding", createMap5);
        this.manager.pushEvent(this.context, this, "onIndoorBuildingFocused", createMap4);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnIndoorStateChangeListener
    public void onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
        int activeLevelIndex;
        if (indoorBuilding != null && (activeLevelIndex = indoorBuilding.getActiveLevelIndex()) >= 0 && activeLevelIndex < indoorBuilding.getLevels().size()) {
            IndoorLevel indoorLevel = indoorBuilding.getLevels().get(activeLevelIndex);
            WritableMap createMap = Arguments.createMap();
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("activeLevelIndex", activeLevelIndex);
            createMap2.putString("name", indoorLevel.getName());
            createMap2.putString("shortName", indoorLevel.getShortName());
            createMap.putMap("IndoorLevel", createMap2);
            this.manager.pushEvent(this.context, this, "onIndoorLevelActivated", createMap);
        }
    }

    public void setIndoorActiveLevelIndex(int i) {
        IndoorLevel indoorLevel;
        IndoorBuilding focusedBuilding = this.map.getFocusedBuilding();
        if (focusedBuilding == null || i < 0 || i >= focusedBuilding.getLevels().size() || (indoorLevel = focusedBuilding.getLevels().get(i)) == null) {
            return;
        }
        indoorLevel.activate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MapMarker getMarkerMap(Marker marker) {
        MapMarker mapMarker = this.markerMap.get(marker);
        if (mapMarker != null) {
            return mapMarker;
        }
        for (Map.Entry<Marker, MapMarker> entry : this.markerMap.entrySet()) {
            if (entry.getKey().getPosition().equals(marker.getPosition()) && entry.getKey().getTitle().equals(marker.getTitle())) {
                return entry.getValue();
            }
        }
        return mapMarker;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }
}
