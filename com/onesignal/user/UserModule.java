package com.onesignal.user;

import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.startup.IBootstrapService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.user.internal.UserManager;
import com.onesignal.user.internal.backend.IIdentityBackendService;
import com.onesignal.user.internal.backend.ISubscriptionBackendService;
import com.onesignal.user.internal.backend.IUserBackendService;
import com.onesignal.user.internal.backend.impl.IdentityBackendService;
import com.onesignal.user.internal.backend.impl.SubscriptionBackendService;
import com.onesignal.user.internal.backend.impl.UserBackendService;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.builduser.impl.RebuildUserService;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.migrations.RecoverFromDroppedLoginBug;
import com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.listeners.IdentityModelStoreListener;
import com.onesignal.user.internal.operations.impl.listeners.PropertiesModelStoreListener;
import com.onesignal.user.internal.operations.impl.listeners.SubscriptionModelStoreListener;
import com.onesignal.user.internal.operations.impl.states.NewRecordsState;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.service.UserRefreshService;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.impl.SubscriptionManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/onesignal/user/UserModule;", "Lcom/onesignal/common/modules/IModule;", "()V", "register", "", "builder", "Lcom/onesignal/common/services/ServiceBuilder;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class UserModule implements IModule {
    @Override // com.onesignal.common.modules.IModule
    public void register(ServiceBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.register(PropertiesModelStore.class).provides(PropertiesModelStore.class);
        builder.register(PropertiesModelStoreListener.class).provides(IBootstrapService.class);
        builder.register(IdentityModelStore.class).provides(IdentityModelStore.class);
        builder.register(IdentityModelStoreListener.class).provides(IBootstrapService.class);
        builder.register(IdentityBackendService.class).provides(IIdentityBackendService.class);
        builder.register(IdentityOperationExecutor.class).provides(IdentityOperationExecutor.class).provides(IOperationExecutor.class);
        builder.register(SubscriptionModelStore.class).provides(SubscriptionModelStore.class);
        builder.register(SubscriptionModelStoreListener.class).provides(IBootstrapService.class);
        builder.register(SubscriptionBackendService.class).provides(ISubscriptionBackendService.class);
        builder.register(SubscriptionOperationExecutor.class).provides(SubscriptionOperationExecutor.class).provides(IOperationExecutor.class);
        builder.register(SubscriptionManager.class).provides(ISubscriptionManager.class);
        builder.register(RebuildUserService.class).provides(IRebuildUserService.class);
        builder.register(UserBackendService.class).provides(IUserBackendService.class);
        builder.register(UpdateUserOperationExecutor.class).provides(UpdateUserOperationExecutor.class).provides(IOperationExecutor.class);
        builder.register(LoginUserOperationExecutor.class).provides(IOperationExecutor.class);
        builder.register(LoginUserFromSubscriptionOperationExecutor.class).provides(IOperationExecutor.class);
        builder.register(RefreshUserOperationExecutor.class).provides(IOperationExecutor.class);
        builder.register(UserManager.class).provides(IUserManager.class);
        builder.register(UserRefreshService.class).provides(IStartableService.class);
        builder.register(RecoverFromDroppedLoginBug.class).provides(IStartableService.class);
        builder.register(NewRecordsState.class).provides(NewRecordsState.class);
    }
}
