package io.nlopez.smartlocation.geofencing.utils;

import io.nlopez.smartlocation.geofencing.model.GeofenceModel;

/* loaded from: classes.dex */
public class TransitionGeofence {
    private GeofenceModel geofenceModel;
    private int transitionType;

    public TransitionGeofence(GeofenceModel geofenceModel, int i) {
        this.geofenceModel = geofenceModel;
        this.transitionType = i;
    }

    public GeofenceModel getGeofenceModel() {
        return this.geofenceModel;
    }

    public int getTransitionType() {
        return this.transitionType;
    }
}
