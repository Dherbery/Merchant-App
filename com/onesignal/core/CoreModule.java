package com.onesignal.core;

import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.application.impl.ApplicationService;
import com.onesignal.core.internal.backend.IParamsBackendService;
import com.onesignal.core.internal.backend.impl.ParamsBackendService;
import com.onesignal.core.internal.background.IBackgroundManager;
import com.onesignal.core.internal.background.impl.BackgroundManager;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.config.impl.ConfigModelStoreListener;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.database.impl.DatabaseProvider;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.device.impl.DeviceService;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.core.internal.http.impl.HttpClient;
import com.onesignal.core.internal.http.impl.HttpConnectionFactory;
import com.onesignal.core.internal.http.impl.IHttpConnectionFactory;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.core.internal.language.impl.LanguageContext;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.impl.OperationModelStore;
import com.onesignal.core.internal.operations.impl.OperationRepo;
import com.onesignal.core.internal.permissions.IRequestPermissionService;
import com.onesignal.core.internal.permissions.impl.RequestPermissionService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.impl.PreferencesService;
import com.onesignal.core.internal.purchases.impl.TrackAmazonPurchase;
import com.onesignal.core.internal.purchases.impl.TrackGooglePurchase;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.startup.StartupService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.core.internal.time.impl.Time;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.onesignal.inAppMessages.internal.MisconfiguredIAMManager;
import com.onesignal.location.ILocationManager;
import com.onesignal.location.internal.MisconfiguredLocationManager;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.notifications.internal.MisconfiguredNotificationsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoreModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/onesignal/core/CoreModule;", "Lcom/onesignal/common/modules/IModule;", "()V", "register", "", "builder", "Lcom/onesignal/common/services/ServiceBuilder;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class CoreModule implements IModule {
    @Override // com.onesignal.common.modules.IModule
    public void register(ServiceBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.register(PreferencesService.class).provides(IPreferencesService.class).provides(IStartableService.class);
        builder.register(HttpConnectionFactory.class).provides(IHttpConnectionFactory.class);
        builder.register(HttpClient.class).provides(IHttpClient.class);
        builder.register(ApplicationService.class).provides(IApplicationService.class);
        builder.register(DeviceService.class).provides(IDeviceService.class);
        builder.register(Time.class).provides(ITime.class);
        builder.register(DatabaseProvider.class).provides(IDatabaseProvider.class);
        builder.register(StartupService.class).provides(StartupService.class);
        builder.register(ConfigModelStore.class).provides(ConfigModelStore.class);
        builder.register(ParamsBackendService.class).provides(IParamsBackendService.class);
        builder.register(ConfigModelStoreListener.class).provides(IStartableService.class);
        builder.register(OperationModelStore.class).provides(OperationModelStore.class);
        builder.register(OperationRepo.class).provides(IOperationRepo.class).provides(IStartableService.class);
        builder.register(RequestPermissionService.class).provides(RequestPermissionService.class).provides(IRequestPermissionService.class);
        builder.register(LanguageContext.class).provides(ILanguageContext.class);
        builder.register(BackgroundManager.class).provides(IBackgroundManager.class).provides(IStartableService.class);
        builder.register(TrackAmazonPurchase.class).provides(IStartableService.class);
        builder.register(TrackGooglePurchase.class).provides(IStartableService.class);
        builder.register(MisconfiguredNotificationsManager.class).provides(INotificationsManager.class);
        builder.register(MisconfiguredIAMManager.class).provides(IInAppMessagesManager.class);
        builder.register(MisconfiguredLocationManager.class).provides(ILocationManager.class);
    }
}
