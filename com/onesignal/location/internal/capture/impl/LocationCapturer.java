package com.onesignal.location.internal.capture.impl;

import android.location.Location;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.BuildConfig;
import com.onesignal.location.internal.capture.ILocationCapturer;
import com.onesignal.location.internal.common.LocationPoint;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.ILocationUpdatedHandler;
import com.onesignal.location.internal.preferences.ILocationPreferencesService;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationCapturer.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/onesignal/location/internal/capture/impl/LocationCapturer;", "Lcom/onesignal/location/internal/controller/ILocationUpdatedHandler;", "Lcom/onesignal/location/internal/capture/ILocationCapturer;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "_prefs", "Lcom/onesignal/location/internal/preferences/ILocationPreferencesService;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "_controller", "Lcom/onesignal/location/internal/controller/ILocationController;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/time/ITime;Lcom/onesignal/location/internal/preferences/ILocationPreferencesService;Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/location/internal/controller/ILocationController;)V", "locationCoarse", "", "getLocationCoarse", "()Z", "setLocationCoarse", "(Z)V", "capture", "", "location", "Landroid/location/Location;", "captureLastLocation", "onLocationChanged", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class LocationCapturer implements ILocationUpdatedHandler, ILocationCapturer {
    private final IApplicationService _applicationService;
    private final ILocationController _controller;
    private final ILocationPreferencesService _prefs;
    private final PropertiesModelStore _propertiesModelStore;
    private final ITime _time;
    private boolean locationCoarse;

    public LocationCapturer(IApplicationService _applicationService, ITime _time, ILocationPreferencesService _prefs, PropertiesModelStore _propertiesModelStore, ILocationController _controller) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_time, "_time");
        Intrinsics.checkNotNullParameter(_prefs, "_prefs");
        Intrinsics.checkNotNullParameter(_propertiesModelStore, "_propertiesModelStore");
        Intrinsics.checkNotNullParameter(_controller, "_controller");
        this._applicationService = _applicationService;
        this._time = _time;
        this._prefs = _prefs;
        this._propertiesModelStore = _propertiesModelStore;
        this._controller = _controller;
        _controller.subscribe(this);
    }

    @Override // com.onesignal.location.internal.capture.ILocationCapturer
    public boolean getLocationCoarse() {
        return this.locationCoarse;
    }

    @Override // com.onesignal.location.internal.capture.ILocationCapturer
    public void setLocationCoarse(boolean z) {
        this.locationCoarse = z;
    }

    @Override // com.onesignal.location.internal.capture.ILocationCapturer
    public void captureLastLocation() {
        Location lastLocation = this._controller.getLastLocation();
        if (lastLocation != null) {
            capture(lastLocation);
        } else {
            this._prefs.setLastLocationTime(this._time.getCurrentTimeMillis());
        }
    }

    @Override // com.onesignal.location.internal.controller.ILocationUpdatedHandler
    public void onLocationChanged(Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        Logging.debug$default("LocationController fireCompleteForLocation with location: " + location, null, 2, null);
        capture(location);
    }

    private final void capture(Location location) {
        LocationPoint locationPoint = new LocationPoint();
        locationPoint.setAccuracy(Float.valueOf(location.getAccuracy()));
        locationPoint.setBg(Boolean.valueOf(!this._applicationService.isInForeground()));
        locationPoint.setType(getLocationCoarse() ? 0 : 1);
        locationPoint.setTimeStamp(Long.valueOf(location.getTime()));
        if (getLocationCoarse()) {
            locationPoint.setLat(Double.valueOf(new BigDecimal(location.getLatitude()).setScale(7, RoundingMode.HALF_UP).doubleValue()));
            locationPoint.setLog(Double.valueOf(new BigDecimal(location.getLongitude()).setScale(7, RoundingMode.HALF_UP).doubleValue()));
        } else {
            locationPoint.setLat(Double.valueOf(location.getLatitude()));
            locationPoint.setLog(Double.valueOf(location.getLongitude()));
        }
        PropertiesModel model = this._propertiesModelStore.getModel();
        model.setLocationLongitude(locationPoint.getLog());
        model.setLocationLatitude(locationPoint.getLat());
        model.setLocationAccuracy(locationPoint.getAccuracy());
        model.setLocationBackground(locationPoint.getBg());
        model.setLocationType(locationPoint.getType());
        model.setLocationTimestamp(locationPoint.getTimeStamp());
        this._prefs.setLastLocationTime(this._time.getCurrentTimeMillis());
    }
}
