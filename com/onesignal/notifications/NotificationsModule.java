package com.onesignal.notifications;

import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.IServiceProvider;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.INotificationActivityOpener;
import com.onesignal.notifications.internal.NotificationsManager;
import com.onesignal.notifications.internal.analytics.IAnalyticsTracker;
import com.onesignal.notifications.internal.analytics.impl.FirebaseAnalyticsTracker;
import com.onesignal.notifications.internal.analytics.impl.NoAnalyticsTracker;
import com.onesignal.notifications.internal.backend.INotificationBackendService;
import com.onesignal.notifications.internal.backend.impl.NotificationBackendService;
import com.onesignal.notifications.internal.badges.IBadgeCountUpdater;
import com.onesignal.notifications.internal.badges.impl.BadgeCountUpdater;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import com.onesignal.notifications.internal.bundle.impl.NotificationBundleProcessor;
import com.onesignal.notifications.internal.channels.INotificationChannelManager;
import com.onesignal.notifications.internal.channels.impl.NotificationChannelManager;
import com.onesignal.notifications.internal.data.INotificationQueryHelper;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.data.impl.NotificationQueryHelper;
import com.onesignal.notifications.internal.data.impl.NotificationRepository;
import com.onesignal.notifications.internal.display.INotificationDisplayBuilder;
import com.onesignal.notifications.internal.display.INotificationDisplayer;
import com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer;
import com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder;
import com.onesignal.notifications.internal.display.impl.NotificationDisplayer;
import com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer;
import com.onesignal.notifications.internal.generation.INotificationGenerationProcessor;
import com.onesignal.notifications.internal.generation.INotificationGenerationWorkManager;
import com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor;
import com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService;
import com.onesignal.notifications.internal.limiting.INotificationLimitManager;
import com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager;
import com.onesignal.notifications.internal.listeners.DeviceRegistrationListener;
import com.onesignal.notifications.internal.listeners.NotificationListener;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessor;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessorHMS;
import com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor;
import com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS;
import com.onesignal.notifications.internal.permissions.INotificationPermissionController;
import com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController;
import com.onesignal.notifications.internal.pushtoken.IPushTokenManager;
import com.onesignal.notifications.internal.pushtoken.PushTokenManager;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptWorkManager;
import com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor;
import com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt;
import com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorADM;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorNone;
import com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor;
import com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager;
import com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor;
import com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationsModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/onesignal/notifications/NotificationsModule;", "Lcom/onesignal/common/modules/IModule;", "()V", "register", "", "builder", "Lcom/onesignal/common/services/ServiceBuilder;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationsModule implements IModule {
    @Override // com.onesignal.common.modules.IModule
    public void register(ServiceBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.register(NotificationBackendService.class).provides(INotificationBackendService.class);
        builder.register(NotificationRestoreWorkManager.class).provides(INotificationRestoreWorkManager.class);
        builder.register(NotificationQueryHelper.class).provides(INotificationQueryHelper.class);
        builder.register(BadgeCountUpdater.class).provides(IBadgeCountUpdater.class);
        builder.register(NotificationRepository.class).provides(INotificationRepository.class);
        builder.register(NotificationGenerationWorkManager.class).provides(INotificationGenerationWorkManager.class);
        builder.register(NotificationBundleProcessor.class).provides(INotificationBundleProcessor.class);
        builder.register(NotificationChannelManager.class).provides(INotificationChannelManager.class);
        builder.register(NotificationLimitManager.class).provides(INotificationLimitManager.class);
        builder.register(NotificationDisplayer.class).provides(INotificationDisplayer.class);
        builder.register(SummaryNotificationDisplayer.class).provides(ISummaryNotificationDisplayer.class);
        builder.register(NotificationDisplayBuilder.class).provides(INotificationDisplayBuilder.class);
        builder.register(NotificationGenerationProcessor.class).provides(INotificationGenerationProcessor.class);
        builder.register(NotificationRestoreProcessor.class).provides(INotificationRestoreProcessor.class);
        builder.register(NotificationSummaryManager.class).provides(INotificationSummaryManager.class);
        builder.register(NotificationOpenedProcessor.class).provides(INotificationOpenedProcessor.class);
        builder.register(NotificationOpenedProcessorHMS.class).provides(INotificationOpenedProcessorHMS.class);
        builder.register(NotificationPermissionController.class).provides(INotificationPermissionController.class);
        builder.register(NotificationLifecycleService.class).provides(INotificationLifecycleService.class);
        builder.register((Function1) new Function1<IServiceProvider, IAnalyticsTracker>() { // from class: com.onesignal.notifications.NotificationsModule$register$1
            @Override // kotlin.jvm.functions.Function1
            public final IAnalyticsTracker invoke(IServiceProvider it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (FirebaseAnalyticsTracker.INSTANCE.canTrack()) {
                    return new FirebaseAnalyticsTracker((IApplicationService) it.getService(IApplicationService.class), (ConfigModelStore) it.getService(ConfigModelStore.class), (ITime) it.getService(ITime.class));
                }
                return new NoAnalyticsTracker();
            }
        }).provides(IAnalyticsTracker.class);
        builder.register((Function1) new Function1<IServiceProvider, Object>() { // from class: com.onesignal.notifications.NotificationsModule$register$2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(IServiceProvider it) {
                Object pushRegistratorHMS;
                Intrinsics.checkNotNullParameter(it, "it");
                IDeviceService iDeviceService = (IDeviceService) it.getService(IDeviceService.class);
                if (iDeviceService.isFireOSDeviceType()) {
                    return new PushRegistratorADM((IApplicationService) it.getService(IApplicationService.class));
                }
                if (iDeviceService.isAndroidDeviceType()) {
                    if (iDeviceService.getHasFCMLibrary()) {
                        pushRegistratorHMS = new PushRegistratorFCM((ConfigModelStore) it.getService(ConfigModelStore.class), (IApplicationService) it.getService(IApplicationService.class), (GooglePlayServicesUpgradePrompt) it.getService(GooglePlayServicesUpgradePrompt.class), iDeviceService);
                    } else {
                        return new PushRegistratorNone();
                    }
                } else {
                    pushRegistratorHMS = new PushRegistratorHMS(iDeviceService, (IApplicationService) it.getService(IApplicationService.class));
                }
                return pushRegistratorHMS;
            }
        }).provides(IPushRegistrator.class).provides(IPushRegistratorCallback.class);
        builder.register(GooglePlayServicesUpgradePrompt.class).provides(GooglePlayServicesUpgradePrompt.class);
        builder.register(PushTokenManager.class).provides(IPushTokenManager.class);
        builder.register(ReceiveReceiptWorkManager.class).provides(IReceiveReceiptWorkManager.class);
        builder.register(ReceiveReceiptProcessor.class).provides(IReceiveReceiptProcessor.class);
        builder.register(DeviceRegistrationListener.class).provides(IStartableService.class);
        builder.register(NotificationListener.class).provides(IStartableService.class);
        builder.register(NotificationsManager.class).provides(INotificationsManager.class).provides(INotificationActivityOpener.class);
    }
}
