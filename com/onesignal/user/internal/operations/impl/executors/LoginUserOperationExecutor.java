package com.onesignal.user.internal.operations.impl.executors;

import android.os.Build;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.DeviceUtils;
import com.onesignal.common.NetworkUtils;
import com.onesignal.common.OneSignalUtils;
import com.onesignal.common.RootToolsInternalMethods;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.ExecutionResult;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.backend.IUserBackendService;
import com.onesignal.user.internal.backend.SubscriptionObject;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.CreateSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteSubscriptionOperation;
import com.onesignal.user.internal.operations.LoginUserOperation;
import com.onesignal.user.internal.operations.TransferSubscriptionOperation;
import com.onesignal.user.internal.operations.UpdateSubscriptionOperation;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginUserOperationExecutor.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J0\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J0\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020 2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J0\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020!2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J0\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\"2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J'\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020'0\u0016H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u001f\u0010)\u001a\u00020$2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020'0\u0016H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010*J'\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020&2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020'0\u0016H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/LoginUserOperationExecutor;", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_identityOperationExecutor", "Lcom/onesignal/user/internal/operations/impl/executors/IdentityOperationExecutor;", "_application", "Lcom/onesignal/core/internal/application/IApplicationService;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_userBackend", "Lcom/onesignal/user/internal/backend/IUserBackendService;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "_subscriptionsModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "(Lcom/onesignal/user/internal/operations/impl/executors/IdentityOperationExecutor;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/user/internal/backend/IUserBackendService;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/language/ILanguageContext;)V", "operations", "", "", "getOperations", "()Ljava/util/List;", "createSubscriptionsFromOperation", "", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "operation", "Lcom/onesignal/user/internal/operations/CreateSubscriptionOperation;", "subscriptions", "Lcom/onesignal/user/internal/operations/DeleteSubscriptionOperation;", "Lcom/onesignal/user/internal/operations/TransferSubscriptionOperation;", "Lcom/onesignal/user/internal/operations/UpdateSubscriptionOperation;", "createUser", "Lcom/onesignal/core/internal/operations/ExecutionResponse;", "createUserOperation", "Lcom/onesignal/user/internal/operations/LoginUserOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "(Lcom/onesignal/user/internal/operations/LoginUserOperation;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginUser", "loginUserOp", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class LoginUserOperationExecutor implements IOperationExecutor {
    public static final String LOGIN_USER = "login-user";
    private final IApplicationService _application;
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final IdentityModelStore _identityModelStore;
    private final IdentityOperationExecutor _identityOperationExecutor;
    private final ILanguageContext _languageContext;
    private final PropertiesModelStore _propertiesModelStore;
    private final SubscriptionModelStore _subscriptionsModelStore;
    private final IUserBackendService _userBackend;

    /* compiled from: LoginUserOperationExecutor.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ExecutionResult.values().length];
            iArr[ExecutionResult.SUCCESS.ordinal()] = 1;
            iArr[ExecutionResult.FAIL_CONFLICT.ordinal()] = 2;
            iArr[ExecutionResult.FAIL_NORETRY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NetworkUtils.ResponseStatusType.values().length];
            iArr2[NetworkUtils.ResponseStatusType.RETRYABLE.ordinal()] = 1;
            iArr2[NetworkUtils.ResponseStatusType.UNAUTHORIZED.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[SubscriptionType.values().length];
            iArr3[SubscriptionType.SMS.ordinal()] = 1;
            iArr3[SubscriptionType.EMAIL.ordinal()] = 2;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public LoginUserOperationExecutor(IdentityOperationExecutor _identityOperationExecutor, IApplicationService _application, IDeviceService _deviceService, IUserBackendService _userBackend, IdentityModelStore _identityModelStore, PropertiesModelStore _propertiesModelStore, SubscriptionModelStore _subscriptionsModelStore, ConfigModelStore _configModelStore, ILanguageContext _languageContext) {
        Intrinsics.checkNotNullParameter(_identityOperationExecutor, "_identityOperationExecutor");
        Intrinsics.checkNotNullParameter(_application, "_application");
        Intrinsics.checkNotNullParameter(_deviceService, "_deviceService");
        Intrinsics.checkNotNullParameter(_userBackend, "_userBackend");
        Intrinsics.checkNotNullParameter(_identityModelStore, "_identityModelStore");
        Intrinsics.checkNotNullParameter(_propertiesModelStore, "_propertiesModelStore");
        Intrinsics.checkNotNullParameter(_subscriptionsModelStore, "_subscriptionsModelStore");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_languageContext, "_languageContext");
        this._identityOperationExecutor = _identityOperationExecutor;
        this._application = _application;
        this._deviceService = _deviceService;
        this._userBackend = _userBackend;
        this._identityModelStore = _identityModelStore;
        this._propertiesModelStore = _propertiesModelStore;
        this._subscriptionsModelStore = _subscriptionsModelStore;
        this._configModelStore = _configModelStore;
        this._languageContext = _languageContext;
    }

    @Override // com.onesignal.core.internal.operations.IOperationExecutor
    public List<String> getOperations() {
        return CollectionsKt.listOf(LOGIN_USER);
    }

    @Override // com.onesignal.core.internal.operations.IOperationExecutor
    public Object execute(List<? extends Operation> list, Continuation<? super ExecutionResponse> continuation) {
        Logging.debug$default("LoginUserOperationExecutor(operation: " + list + ')', null, 2, null);
        Operation operation = (Operation) CollectionsKt.first((List) list);
        if (operation instanceof LoginUserOperation) {
            return loginUser((LoginUserOperation) operation, CollectionsKt.drop(list, 1), continuation);
        }
        throw new Exception("Unrecognized operation: " + operation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loginUser(com.onesignal.user.internal.operations.LoginUserOperation r22, java.util.List<? extends com.onesignal.core.internal.operations.Operation> r23, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r24) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor.loginUser(com.onesignal.user.internal.operations.LoginUserOperation, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x016d A[Catch: BackendException -> 0x0040, TryCatch #0 {BackendException -> 0x0040, blocks: (B:11:0x003b, B:12:0x012f, B:14:0x016d, B:15:0x017e, B:17:0x018c, B:18:0x019d, B:20:0x01a4, B:22:0x01af, B:24:0x01e9, B:25:0x01f8, B:27:0x020e, B:29:0x0222, B:33:0x0226, B:35:0x022d, B:36:0x023f, B:40:0x023b, B:77:0x00dd, B:78:0x00fb, B:80:0x0101, B:82:0x0111), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x018c A[Catch: BackendException -> 0x0040, TryCatch #0 {BackendException -> 0x0040, blocks: (B:11:0x003b, B:12:0x012f, B:14:0x016d, B:15:0x017e, B:17:0x018c, B:18:0x019d, B:20:0x01a4, B:22:0x01af, B:24:0x01e9, B:25:0x01f8, B:27:0x020e, B:29:0x0222, B:33:0x0226, B:35:0x022d, B:36:0x023f, B:40:0x023b, B:77:0x00dd, B:78:0x00fb, B:80:0x0101, B:82:0x0111), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01e9 A[Catch: BackendException -> 0x0040, TryCatch #0 {BackendException -> 0x0040, blocks: (B:11:0x003b, B:12:0x012f, B:14:0x016d, B:15:0x017e, B:17:0x018c, B:18:0x019d, B:20:0x01a4, B:22:0x01af, B:24:0x01e9, B:25:0x01f8, B:27:0x020e, B:29:0x0222, B:33:0x0226, B:35:0x022d, B:36:0x023f, B:40:0x023b, B:77:0x00dd, B:78:0x00fb, B:80:0x0101, B:82:0x0111), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x020e A[Catch: BackendException -> 0x0040, TryCatch #0 {BackendException -> 0x0040, blocks: (B:11:0x003b, B:12:0x012f, B:14:0x016d, B:15:0x017e, B:17:0x018c, B:18:0x019d, B:20:0x01a4, B:22:0x01af, B:24:0x01e9, B:25:0x01f8, B:27:0x020e, B:29:0x0222, B:33:0x0226, B:35:0x022d, B:36:0x023f, B:40:0x023b, B:77:0x00dd, B:78:0x00fb, B:80:0x0101, B:82:0x0111), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0222 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x022d A[Catch: BackendException -> 0x0040, TryCatch #0 {BackendException -> 0x0040, blocks: (B:11:0x003b, B:12:0x012f, B:14:0x016d, B:15:0x017e, B:17:0x018c, B:18:0x019d, B:20:0x01a4, B:22:0x01af, B:24:0x01e9, B:25:0x01f8, B:27:0x020e, B:29:0x0222, B:33:0x0226, B:35:0x022d, B:36:0x023f, B:40:0x023b, B:77:0x00dd, B:78:0x00fb, B:80:0x0101, B:82:0x0111), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x023b A[Catch: BackendException -> 0x0040, TryCatch #0 {BackendException -> 0x0040, blocks: (B:11:0x003b, B:12:0x012f, B:14:0x016d, B:15:0x017e, B:17:0x018c, B:18:0x019d, B:20:0x01a4, B:22:0x01af, B:24:0x01e9, B:25:0x01f8, B:27:0x020e, B:29:0x0222, B:33:0x0226, B:35:0x022d, B:36:0x023f, B:40:0x023b, B:77:0x00dd, B:78:0x00fb, B:80:0x0101, B:82:0x0111), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object createUser(com.onesignal.user.internal.operations.LoginUserOperation r22, java.util.List<? extends com.onesignal.core.internal.operations.Operation> r23, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r24) {
        /*
            Method dump skipped, instructions count: 665
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor.createUser(com.onesignal.user.internal.operations.LoginUserOperation, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Map<String, SubscriptionObject> createSubscriptionsFromOperation(TransferSubscriptionOperation operation, Map<String, SubscriptionObject> subscriptions) {
        Map<String, SubscriptionObject> mutableMap = MapsKt.toMutableMap(subscriptions);
        if (mutableMap.containsKey(operation.getSubscriptionId())) {
            String subscriptionId = operation.getSubscriptionId();
            String subscriptionId2 = operation.getSubscriptionId();
            SubscriptionObject subscriptionObject = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject);
            SubscriptionObjectType type = subscriptionObject.getType();
            SubscriptionObject subscriptionObject2 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject2);
            String token = subscriptionObject2.getToken();
            SubscriptionObject subscriptionObject3 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject3);
            Boolean enabled = subscriptionObject3.getEnabled();
            SubscriptionObject subscriptionObject4 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject4);
            Integer notificationTypes = subscriptionObject4.getNotificationTypes();
            SubscriptionObject subscriptionObject5 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject5);
            String sdk = subscriptionObject5.getSdk();
            SubscriptionObject subscriptionObject6 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject6);
            String deviceModel = subscriptionObject6.getDeviceModel();
            SubscriptionObject subscriptionObject7 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject7);
            String deviceOS = subscriptionObject7.getDeviceOS();
            SubscriptionObject subscriptionObject8 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject8);
            Boolean rooted = subscriptionObject8.getRooted();
            SubscriptionObject subscriptionObject9 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject9);
            Integer netType = subscriptionObject9.getNetType();
            SubscriptionObject subscriptionObject10 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject10);
            String carrier = subscriptionObject10.getCarrier();
            SubscriptionObject subscriptionObject11 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject11);
            mutableMap.put(subscriptionId, new SubscriptionObject(subscriptionId2, type, token, enabled, notificationTypes, sdk, deviceModel, deviceOS, rooted, netType, carrier, subscriptionObject11.getAppVersion()));
        } else {
            mutableMap.put(operation.getSubscriptionId(), new SubscriptionObject(operation.getSubscriptionId(), null, null, null, null, null, null, null, null, null, null, null, 4094, null));
        }
        return mutableMap;
    }

    private final Map<String, SubscriptionObject> createSubscriptionsFromOperation(CreateSubscriptionOperation operation, Map<String, SubscriptionObject> subscriptions) {
        SubscriptionObjectType subscriptionObjectType;
        Map<String, SubscriptionObject> mutableMap = MapsKt.toMutableMap(subscriptions);
        int i = WhenMappings.$EnumSwitchMapping$2[operation.getType().ordinal()];
        if (i == 1) {
            subscriptionObjectType = SubscriptionObjectType.SMS;
        } else if (i == 2) {
            subscriptionObjectType = SubscriptionObjectType.EMAIL;
        } else {
            subscriptionObjectType = SubscriptionObjectType.INSTANCE.fromDeviceType(this._deviceService.getDeviceType());
        }
        mutableMap.put(operation.getSubscriptionId(), new SubscriptionObject(null, subscriptionObjectType, operation.getAddress(), Boolean.valueOf(operation.getEnabled()), Integer.valueOf(operation.getStatus().getValue()), OneSignalUtils.SDK_VERSION, Build.MODEL, Build.VERSION.RELEASE, Boolean.valueOf(RootToolsInternalMethods.INSTANCE.isRooted()), DeviceUtils.INSTANCE.getNetType(this._application.getAppContext()), DeviceUtils.INSTANCE.getCarrierName(this._application.getAppContext()), AndroidUtils.INSTANCE.getAppVersion(this._application.getAppContext())));
        return mutableMap;
    }

    private final Map<String, SubscriptionObject> createSubscriptionsFromOperation(UpdateSubscriptionOperation operation, Map<String, SubscriptionObject> subscriptions) {
        Map<String, SubscriptionObject> mutableMap = MapsKt.toMutableMap(subscriptions);
        if (mutableMap.containsKey(operation.getSubscriptionId())) {
            String subscriptionId = operation.getSubscriptionId();
            SubscriptionObject subscriptionObject = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject);
            String id = subscriptionObject.getId();
            SubscriptionObject subscriptionObject2 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject2);
            SubscriptionObjectType type = subscriptionObject2.getType();
            String address = operation.getAddress();
            Boolean valueOf = Boolean.valueOf(operation.getEnabled());
            Integer valueOf2 = Integer.valueOf(operation.getStatus().getValue());
            SubscriptionObject subscriptionObject3 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject3);
            String sdk = subscriptionObject3.getSdk();
            SubscriptionObject subscriptionObject4 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject4);
            String deviceModel = subscriptionObject4.getDeviceModel();
            SubscriptionObject subscriptionObject5 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject5);
            String deviceOS = subscriptionObject5.getDeviceOS();
            SubscriptionObject subscriptionObject6 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject6);
            Boolean rooted = subscriptionObject6.getRooted();
            SubscriptionObject subscriptionObject7 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject7);
            Integer netType = subscriptionObject7.getNetType();
            SubscriptionObject subscriptionObject8 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject8);
            String carrier = subscriptionObject8.getCarrier();
            SubscriptionObject subscriptionObject9 = subscriptions.get(operation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject9);
            mutableMap.put(subscriptionId, new SubscriptionObject(id, type, address, valueOf, valueOf2, sdk, deviceModel, deviceOS, rooted, netType, carrier, subscriptionObject9.getAppVersion()));
        }
        return mutableMap;
    }

    private final Map<String, SubscriptionObject> createSubscriptionsFromOperation(DeleteSubscriptionOperation operation, Map<String, SubscriptionObject> subscriptions) {
        Map<String, SubscriptionObject> mutableMap = MapsKt.toMutableMap(subscriptions);
        mutableMap.remove(operation.getSubscriptionId());
        return mutableMap;
    }
}
