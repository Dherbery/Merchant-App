package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.common.NetworkUtils;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.backend.ISubscriptionBackendService;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.operations.CreateSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteSubscriptionOperation;
import com.onesignal.user.internal.operations.TransferSubscriptionOperation;
import com.onesignal.user.internal.operations.UpdateSubscriptionOperation;
import com.onesignal.user.internal.operations.impl.states.NewRecordsState;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionOperationExecutor.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J'\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0019\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J\u001f\u0010$\u001a\u00020\u001b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0019\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)J'\u0010*\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020+2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010,R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/SubscriptionOperationExecutor;", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_subscriptionBackend", "Lcom/onesignal/user/internal/backend/ISubscriptionBackendService;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_subscriptionModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_buildUserService", "Lcom/onesignal/user/internal/builduser/IRebuildUserService;", "_newRecordState", "Lcom/onesignal/user/internal/operations/impl/states/NewRecordsState;", "(Lcom/onesignal/user/internal/backend/ISubscriptionBackendService;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/builduser/IRebuildUserService;Lcom/onesignal/user/internal/operations/impl/states/NewRecordsState;)V", "operations", "", "", "getOperations", "()Ljava/util/List;", "convert", "Lcom/onesignal/user/internal/backend/SubscriptionObjectType;", "subscriptionType", "Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "createSubscription", "Lcom/onesignal/core/internal/operations/ExecutionResponse;", "createOperation", "Lcom/onesignal/user/internal/operations/CreateSubscriptionOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "(Lcom/onesignal/user/internal/operations/CreateSubscriptionOperation;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSubscription", "op", "Lcom/onesignal/user/internal/operations/DeleteSubscriptionOperation;", "(Lcom/onesignal/user/internal/operations/DeleteSubscriptionOperation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transferSubscription", "startingOperation", "Lcom/onesignal/user/internal/operations/TransferSubscriptionOperation;", "(Lcom/onesignal/user/internal/operations/TransferSubscriptionOperation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSubscription", "Lcom/onesignal/user/internal/operations/UpdateSubscriptionOperation;", "(Lcom/onesignal/user/internal/operations/UpdateSubscriptionOperation;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionOperationExecutor implements IOperationExecutor {
    public static final String CREATE_SUBSCRIPTION = "create-subscription";
    public static final String DELETE_SUBSCRIPTION = "delete-subscription";
    public static final String TRANSFER_SUBSCRIPTION = "transfer-subscription";
    public static final String UPDATE_SUBSCRIPTION = "update-subscription";
    private final IApplicationService _applicationService;
    private final IRebuildUserService _buildUserService;
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final NewRecordsState _newRecordState;
    private final ISubscriptionBackendService _subscriptionBackend;
    private final SubscriptionModelStore _subscriptionModelStore;

    /* compiled from: SubscriptionOperationExecutor.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[NetworkUtils.ResponseStatusType.values().length];
            iArr[NetworkUtils.ResponseStatusType.RETRYABLE.ordinal()] = 1;
            iArr[NetworkUtils.ResponseStatusType.CONFLICT.ordinal()] = 2;
            iArr[NetworkUtils.ResponseStatusType.INVALID.ordinal()] = 3;
            iArr[NetworkUtils.ResponseStatusType.UNAUTHORIZED.ordinal()] = 4;
            iArr[NetworkUtils.ResponseStatusType.MISSING.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SubscriptionType.values().length];
            iArr2[SubscriptionType.SMS.ordinal()] = 1;
            iArr2[SubscriptionType.EMAIL.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public SubscriptionOperationExecutor(ISubscriptionBackendService _subscriptionBackend, IDeviceService _deviceService, IApplicationService _applicationService, SubscriptionModelStore _subscriptionModelStore, ConfigModelStore _configModelStore, IRebuildUserService _buildUserService, NewRecordsState _newRecordState) {
        Intrinsics.checkNotNullParameter(_subscriptionBackend, "_subscriptionBackend");
        Intrinsics.checkNotNullParameter(_deviceService, "_deviceService");
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_subscriptionModelStore, "_subscriptionModelStore");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_buildUserService, "_buildUserService");
        Intrinsics.checkNotNullParameter(_newRecordState, "_newRecordState");
        this._subscriptionBackend = _subscriptionBackend;
        this._deviceService = _deviceService;
        this._applicationService = _applicationService;
        this._subscriptionModelStore = _subscriptionModelStore;
        this._configModelStore = _configModelStore;
        this._buildUserService = _buildUserService;
        this._newRecordState = _newRecordState;
    }

    @Override // com.onesignal.core.internal.operations.IOperationExecutor
    public List<String> getOperations() {
        return CollectionsKt.listOf((Object[]) new String[]{CREATE_SUBSCRIPTION, UPDATE_SUBSCRIPTION, DELETE_SUBSCRIPTION, TRANSFER_SUBSCRIPTION});
    }

    @Override // com.onesignal.core.internal.operations.IOperationExecutor
    public Object execute(List<? extends Operation> list, Continuation<? super ExecutionResponse> continuation) {
        Logging.log(LogLevel.DEBUG, "SubscriptionOperationExecutor(operations: " + list + ')');
        Operation operation = (Operation) CollectionsKt.first((List) list);
        if (operation instanceof CreateSubscriptionOperation) {
            return createSubscription((CreateSubscriptionOperation) operation, list, continuation);
        }
        List<? extends Operation> list2 = list;
        boolean z = false;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((Operation) it.next()) instanceof DeleteSubscriptionOperation) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            if (list.size() > 1) {
                throw new Exception("Only supports one operation! Attempted operations:\n" + list);
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                if (obj instanceof DeleteSubscriptionOperation) {
                    arrayList.add(obj);
                }
            }
            return deleteSubscription((DeleteSubscriptionOperation) CollectionsKt.first((List) arrayList), continuation);
        }
        if (operation instanceof UpdateSubscriptionOperation) {
            return updateSubscription((UpdateSubscriptionOperation) operation, list, continuation);
        }
        if (operation instanceof TransferSubscriptionOperation) {
            if (list.size() > 1) {
                throw new Exception("TransferSubscriptionOperation only supports one operation! Attempted operations:\n" + list);
            }
            return transferSubscription((TransferSubscriptionOperation) operation, continuation);
        }
        throw new Exception("Unrecognized operation: " + operation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x013a A[Catch: BackendException -> 0x01a4, TryCatch #1 {BackendException -> 0x01a4, blocks: (B:14:0x0136, B:16:0x013a, B:19:0x014a, B:21:0x0158, B:22:0x0168, B:24:0x017e, B:25:0x0189), top: B:13:0x0136 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x014a A[Catch: BackendException -> 0x01a4, TryCatch #1 {BackendException -> 0x01a4, blocks: (B:14:0x0136, B:16:0x013a, B:19:0x014a, B:21:0x0158, B:22:0x0168, B:24:0x017e, B:25:0x0189), top: B:13:0x0136 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object createSubscription(com.onesignal.user.internal.operations.CreateSubscriptionOperation r25, java.util.List<? extends com.onesignal.core.internal.operations.Operation> r26, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r27) {
        /*
            Method dump skipped, instructions count: 600
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.createSubscription(com.onesignal.user.internal.operations.CreateSubscriptionOperation, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateSubscription(com.onesignal.user.internal.operations.UpdateSubscriptionOperation r21, java.util.List<? extends com.onesignal.core.internal.operations.Operation> r22, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r23) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.updateSubscription(com.onesignal.user.internal.operations.UpdateSubscriptionOperation, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object transferSubscription(com.onesignal.user.internal.operations.TransferSubscriptionOperation r18, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            boolean r2 = r0 instanceof com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$transferSubscription$1
            if (r2 == 0) goto L18
            r2 = r0
            com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$transferSubscription$1 r2 = (com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$transferSubscription$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L1d
        L18:
            com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$transferSubscription$1 r2 = new com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$transferSubscription$1
            r2.<init>(r1, r0)
        L1d:
            r8 = r2
            java.lang.Object r0 = r8.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r8.label
            r9 = 1
            if (r3 == 0) goto L39
            if (r3 != r9) goto L31
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            goto L55
        L2f:
            r0 = move-exception
            goto L64
        L31:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L39:
            kotlin.ResultKt.throwOnFailure(r0)
            com.onesignal.user.internal.backend.ISubscriptionBackendService r3 = r1._subscriptionBackend     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            java.lang.String r4 = r18.getAppId()     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            java.lang.String r5 = r18.getSubscriptionId()     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            java.lang.String r6 = "onesignal_id"
            java.lang.String r7 = r18.getOnesignalId()     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            r8.label = r9     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            java.lang.Object r0 = r3.transferSubscription(r4, r5, r6, r7, r8)     // Catch: com.onesignal.common.exceptions.BackendException -> L2f
            if (r0 != r2) goto L55
            return r2
        L55:
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r4 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 14
            r9 = 0
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r0
        L64:
            com.onesignal.common.NetworkUtils r2 = com.onesignal.common.NetworkUtils.INSTANCE
            int r3 = r0.getStatusCode()
            com.onesignal.common.NetworkUtils$ResponseStatusType r2 = r2.getResponseStatusType(r3)
            int[] r3 = com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r3[r2]
            if (r2 != r9) goto L8a
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r11 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r12 = 0
            r13 = 0
            java.lang.Integer r14 = r0.getRetryAfterSeconds()
            r15 = 6
            r16 = 0
            r10 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)
            goto L98
        L8a:
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r4 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_NORETRY
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 14
            r9 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9)
        L98:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.transferSubscription(com.onesignal.user.internal.operations.TransferSubscriptionOperation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final SubscriptionObjectType convert(SubscriptionType subscriptionType) {
        int i = WhenMappings.$EnumSwitchMapping$1[subscriptionType.ordinal()];
        if (i == 1) {
            return SubscriptionObjectType.SMS;
        }
        if (i == 2) {
            return SubscriptionObjectType.EMAIL;
        }
        return SubscriptionObjectType.INSTANCE.fromDeviceType(this._deviceService.getDeviceType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deleteSubscription(com.onesignal.user.internal.operations.DeleteSubscriptionOperation r21, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r22) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.deleteSubscription(com.onesignal.user.internal.operations.DeleteSubscriptionOperation, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
