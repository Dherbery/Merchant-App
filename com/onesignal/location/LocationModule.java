package com.onesignal.location;

import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.IServiceProvider;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.location.internal.LocationManager;
import com.onesignal.location.internal.background.LocationBackgroundService;
import com.onesignal.location.internal.capture.ILocationCapturer;
import com.onesignal.location.internal.capture.impl.LocationCapturer;
import com.onesignal.location.internal.common.LocationUtils;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.impl.FusedLocationApiWrapperImpl;
import com.onesignal.location.internal.controller.impl.GmsLocationController;
import com.onesignal.location.internal.controller.impl.HmsLocationController;
import com.onesignal.location.internal.controller.impl.IFusedLocationApiWrapper;
import com.onesignal.location.internal.controller.impl.NullLocationController;
import com.onesignal.location.internal.permissions.LocationPermissionController;
import com.onesignal.location.internal.preferences.ILocationPreferencesService;
import com.onesignal.location.internal.preferences.impl.LocationPreferencesService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/onesignal/location/LocationModule;", "Lcom/onesignal/common/modules/IModule;", "()V", "register", "", "builder", "Lcom/onesignal/common/services/ServiceBuilder;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class LocationModule implements IModule {
    @Override // com.onesignal.common.modules.IModule
    public void register(ServiceBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.register(LocationPermissionController.class).provides(LocationPermissionController.class).provides(IStartableService.class);
        builder.register(FusedLocationApiWrapperImpl.class).provides(IFusedLocationApiWrapper.class);
        builder.register((Function1) new Function1<IServiceProvider, ILocationController>() { // from class: com.onesignal.location.LocationModule$register$1
            @Override // kotlin.jvm.functions.Function1
            public final ILocationController invoke(IServiceProvider it) {
                Intrinsics.checkNotNullParameter(it, "it");
                IDeviceService iDeviceService = (IDeviceService) it.getService(IDeviceService.class);
                if (iDeviceService.isAndroidDeviceType() && LocationUtils.INSTANCE.hasGMSLocationLibrary()) {
                    return new GmsLocationController((IApplicationService) it.getService(IApplicationService.class), (IFusedLocationApiWrapper) it.getService(IFusedLocationApiWrapper.class));
                }
                if (iDeviceService.isHuaweiDeviceType() && LocationUtils.INSTANCE.hasHMSLocationLibrary()) {
                    return new HmsLocationController((IApplicationService) it.getService(IApplicationService.class));
                }
                return new NullLocationController();
            }
        }).provides(ILocationController.class);
        builder.register(LocationPreferencesService.class).provides(ILocationPreferencesService.class);
        builder.register(LocationCapturer.class).provides(ILocationCapturer.class);
        builder.register(LocationBackgroundService.class).provides(IBackgroundService.class);
        builder.register(LocationManager.class).provides(ILocationManager.class).provides(IStartableService.class);
    }
}
