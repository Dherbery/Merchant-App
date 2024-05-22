package com.onesignal.core.internal.operations.impl;

import com.onesignal.common.modeling.IModelStore;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.ExecutionResult;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.operations.impl.states.NewRecordsState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ThreadPoolDispatcherKt;

/* compiled from: OperationRepo.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0002@AB3\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ \u0010!\u001a\u00020\u001a\"\b\b\u0000\u0010\"*\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\"0%H\u0016J#\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0018\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001aH\u0016J!\u0010.\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001aH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010/J!\u00100\u001a\u00020'2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0004H\u0080@ø\u0001\u0000¢\u0006\u0004\b2\u00103J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\u0006\u00105\u001a\u00020\u001dH\u0002J\u001d\u00106\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00042\u0006\u00107\u001a\u00020\u0012H\u0000¢\u0006\u0002\b8J \u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u001aH\u0002J\u0011\u0010<\u001a\u00020'H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020'H\u0016J\u0011\u0010?\u001a\u00020'H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010=R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Lcom/onesignal/core/internal/operations/impl/OperationRepo;", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "Lcom/onesignal/core/internal/startup/IStartableService;", "executors", "", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_operationModelStore", "Lcom/onesignal/core/internal/operations/impl/OperationModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "_newRecordState", "Lcom/onesignal/user/internal/operations/impl/states/NewRecordsState;", "(Ljava/util/List;Lcom/onesignal/core/internal/operations/impl/OperationModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/time/ITime;Lcom/onesignal/user/internal/operations/impl/states/NewRecordsState;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "enqueueIntoBucket", "", "executeBucket", "getExecuteBucket", "()I", "executorsMap", "", "", "paused", "", "queue", "", "Lcom/onesignal/core/internal/operations/impl/OperationRepo$OperationQueueItem;", "waiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "Lcom/onesignal/core/internal/operations/impl/OperationRepo$LoopWaiterMessage;", "containsInstanceOf", "T", "Lcom/onesignal/core/internal/operations/Operation;", "type", "Lkotlin/reflect/KClass;", "delayBeforeNextExecution", "", "retries", "retryAfterSeconds", "(ILjava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueue", "operation", "flush", "enqueueAndWait", "(Lcom/onesignal/core/internal/operations/Operation;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeOperations", "ops", "executeOperations$com_onesignal_core", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGroupableOperations", "startingOp", "getNextOps", "bucketFilter", "getNextOps$com_onesignal_core", "internalEnqueue", "queueItem", "addToStore", "processQueueForever", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "waitForNewOperationAndExecutionInterval", "LoopWaiterMessage", "OperationQueueItem", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OperationRepo implements IOperationRepo, IStartableService {
    private final ConfigModelStore _configModelStore;
    private final NewRecordsState _newRecordState;
    private final OperationModelStore _operationModelStore;
    private final ITime _time;
    private CoroutineScope coroutineScope;
    private int enqueueIntoBucket;
    private final Map<String, IOperationExecutor> executorsMap;
    private boolean paused;
    private final List<OperationQueueItem> queue;
    private final WaiterWithValue<LoopWaiterMessage> waiter;

    /* compiled from: OperationRepo.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ExecutionResult.values().length];
            iArr[ExecutionResult.SUCCESS.ordinal()] = 1;
            iArr[ExecutionResult.FAIL_UNAUTHORIZED.ordinal()] = 2;
            iArr[ExecutionResult.FAIL_NORETRY.ordinal()] = 3;
            iArr[ExecutionResult.FAIL_CONFLICT.ordinal()] = 4;
            iArr[ExecutionResult.SUCCESS_STARTING_ONLY.ordinal()] = 5;
            iArr[ExecutionResult.FAIL_RETRY.ordinal()] = 6;
            iArr[ExecutionResult.FAIL_PAUSE_OPREPO.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public OperationRepo(List<? extends IOperationExecutor> executors, OperationModelStore _operationModelStore, ConfigModelStore _configModelStore, ITime _time, NewRecordsState _newRecordState) {
        Intrinsics.checkNotNullParameter(executors, "executors");
        Intrinsics.checkNotNullParameter(_operationModelStore, "_operationModelStore");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_time, "_time");
        Intrinsics.checkNotNullParameter(_newRecordState, "_newRecordState");
        this._operationModelStore = _operationModelStore;
        this._configModelStore = _configModelStore;
        this._time = _time;
        this._newRecordState = _newRecordState;
        this.queue = new ArrayList();
        this.waiter = new WaiterWithValue<>();
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(ThreadPoolDispatcherKt.newSingleThreadContext("OpRepo"));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (IOperationExecutor iOperationExecutor : executors) {
            Iterator<String> it = iOperationExecutor.getOperations().iterator();
            while (it.hasNext()) {
                linkedHashMap.put(it.next(), iOperationExecutor);
            }
        }
        this.executorsMap = linkedHashMap;
        Iterator<Operation> it2 = this._operationModelStore.list().iterator();
        while (it2.hasNext()) {
            internalEnqueue(new OperationQueueItem(it2.next(), null, this.enqueueIntoBucket, 0, 10, null), false, false);
        }
    }

    /* compiled from: OperationRepo.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/onesignal/core/internal/operations/impl/OperationRepo$OperationQueueItem;", "", "operation", "Lcom/onesignal/core/internal/operations/Operation;", "waiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "", "bucket", "", "retries", "(Lcom/onesignal/core/internal/operations/Operation;Lcom/onesignal/common/threading/WaiterWithValue;II)V", "getBucket", "()I", "getOperation", "()Lcom/onesignal/core/internal/operations/Operation;", "getRetries", "setRetries", "(I)V", "getWaiter", "()Lcom/onesignal/common/threading/WaiterWithValue;", "toString", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OperationQueueItem {
        private final int bucket;
        private final Operation operation;
        private int retries;
        private final WaiterWithValue<Boolean> waiter;

        public OperationQueueItem(Operation operation, WaiterWithValue<Boolean> waiterWithValue, int i, int i2) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.operation = operation;
            this.waiter = waiterWithValue;
            this.bucket = i;
            this.retries = i2;
        }

        public /* synthetic */ OperationQueueItem(Operation operation, WaiterWithValue waiterWithValue, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(operation, (i3 & 2) != 0 ? null : waiterWithValue, i, (i3 & 8) != 0 ? 0 : i2);
        }

        public final Operation getOperation() {
            return this.operation;
        }

        public final WaiterWithValue<Boolean> getWaiter() {
            return this.waiter;
        }

        public final int getBucket() {
            return this.bucket;
        }

        public final int getRetries() {
            return this.retries;
        }

        public final void setRetries(int i) {
            this.retries = i;
        }

        public String toString() {
            return "bucket:" + this.bucket + ", retries:" + this.retries + ", operation:" + this.operation + '\n';
        }
    }

    /* compiled from: OperationRepo.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/onesignal/core/internal/operations/impl/OperationRepo$LoopWaiterMessage;", "", "force", "", "previousWaitedTime", "", "(ZJ)V", "getForce", "()Z", "getPreviousWaitedTime", "()J", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class LoopWaiterMessage {
        private final boolean force;
        private final long previousWaitedTime;

        public LoopWaiterMessage(boolean z, long j) {
            this.force = z;
            this.previousWaitedTime = j;
        }

        public /* synthetic */ LoopWaiterMessage(boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? 0L : j);
        }

        public final boolean getForce() {
            return this.force;
        }

        public final long getPreviousWaitedTime() {
            return this.previousWaitedTime;
        }
    }

    private final int getExecuteBucket() {
        int i = this.enqueueIntoBucket;
        if (i == 0) {
            return 0;
        }
        return i - 1;
    }

    @Override // com.onesignal.core.internal.operations.IOperationRepo
    public <T extends Operation> boolean containsInstanceOf(KClass<T> type) {
        boolean z;
        Intrinsics.checkNotNullParameter(type, "type");
        synchronized (this.queue) {
            List<OperationQueueItem> list = this.queue;
            z = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (type.isInstance(((OperationQueueItem) it.next()).getOperation())) {
                        z = true;
                        break;
                    }
                }
            }
        }
        return z;
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this.paused = false;
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new OperationRepo$start$1(this, null), 3, null);
    }

    @Override // com.onesignal.core.internal.operations.IOperationRepo
    public void enqueue(Operation operation, boolean flush) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Logging.log(LogLevel.DEBUG, "OperationRepo.enqueue(operation: " + operation + ", flush: " + flush + ')');
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        operation.setId(uuid);
        internalEnqueue(new OperationQueueItem(operation, null, this.enqueueIntoBucket, 0, 10, null), flush, true);
    }

    @Override // com.onesignal.core.internal.operations.IOperationRepo
    public Object enqueueAndWait(Operation operation, boolean z, Continuation<? super Boolean> continuation) {
        Logging.log(LogLevel.DEBUG, "OperationRepo.enqueueAndWait(operation: " + operation + ", force: " + z + ')');
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        operation.setId(uuid);
        WaiterWithValue waiterWithValue = new WaiterWithValue();
        internalEnqueue(new OperationQueueItem(operation, waiterWithValue, this.enqueueIntoBucket, 0, 8, null), z, true);
        return waiterWithValue.waitForWake(continuation);
    }

    private final void internalEnqueue(OperationQueueItem queueItem, boolean flush, boolean addToStore) {
        synchronized (this.queue) {
            this.queue.add(queueItem);
            if (addToStore) {
                IModelStore.DefaultImpls.add$default(this._operationModelStore, queueItem.getOperation(), null, 2, null);
            }
            Unit unit = Unit.INSTANCE;
        }
        this.waiter.wake(new LoopWaiterMessage(flush, 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00b3 -> B:14:0x006c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00be -> B:13:0x00c1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processQueueForever(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.onesignal.core.internal.operations.impl.OperationRepo$processQueueForever$1
            if (r0 == 0) goto L14
            r0 = r11
            com.onesignal.core.internal.operations.impl.OperationRepo$processQueueForever$1 r0 = (com.onesignal.core.internal.operations.impl.OperationRepo$processQueueForever$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.onesignal.core.internal.operations.impl.OperationRepo$processQueueForever$1 r0 = new com.onesignal.core.internal.operations.impl.OperationRepo$processQueueForever$1
            r0.<init>(r10, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L58
            if (r2 == r6) goto L50
            if (r2 == r5) goto L48
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r2 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r2 = (com.onesignal.core.internal.operations.impl.OperationRepo) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lc1
        L38:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L40:
            java.lang.Object r2 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r2 = (com.onesignal.core.internal.operations.impl.OperationRepo) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L6c
        L48:
            java.lang.Object r2 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r2 = (com.onesignal.core.internal.operations.impl.OperationRepo) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L9f
        L50:
            java.lang.Object r2 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r2 = (com.onesignal.core.internal.operations.impl.OperationRepo) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L67
        L58:
            kotlin.ResultKt.throwOnFailure(r11)
            r0.L$0 = r10
            r0.label = r6
            java.lang.Object r11 = r10.waitForNewOperationAndExecutionInterval(r0)
            if (r11 != r1) goto L66
            return r1
        L66:
            r2 = r10
        L67:
            int r11 = r2.enqueueIntoBucket
            int r11 = r11 + r6
            r2.enqueueIntoBucket = r11
        L6c:
            boolean r11 = r2.paused
            r7 = 0
            if (r11 == 0) goto L79
            java.lang.String r11 = "OperationRepo is paused"
            com.onesignal.debug.internal.logging.Logging.debug$default(r11, r7, r5, r7)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L79:
            int r11 = r2.getExecuteBucket()
            java.util.List r11 = r2.getNextOps$com_onesignal_core(r11)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "processQueueForever:ops:\n"
            r8.<init>(r9)
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r8, r7, r5, r7)
            if (r11 == 0) goto Lb6
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r11 = r2.executeOperations$com_onesignal_core(r11, r0)
            if (r11 != r1) goto L9f
            return r1
        L9f:
            com.onesignal.core.internal.config.ConfigModelStore r11 = r2._configModelStore
            com.onesignal.common.modeling.Model r11 = r11.getModel()
            com.onesignal.core.internal.config.ConfigModel r11 = (com.onesignal.core.internal.config.ConfigModel) r11
            long r7 = r11.getOpRepoPostWakeDelay()
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r7, r0)
            if (r11 != r1) goto L6c
            return r1
        Lb6:
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r11 = r2.waitForNewOperationAndExecutionInterval(r0)
            if (r11 != r1) goto Lc1
            return r1
        Lc1:
            int r11 = r2.enqueueIntoBucket
            int r11 = r11 + r6
            r2.enqueueIntoBucket = r11
            goto L6c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.operations.impl.OperationRepo.processQueueForever(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x009f -> B:11:0x00a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object waitForNewOperationAndExecutionInterval(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$1
            if (r0 == 0) goto L14
            r0 = r12
            com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$1 r0 = (com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$1 r0 = new com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$1
            r0.<init>(r11, r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r5 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r5 = (com.onesignal.core.internal.operations.impl.OperationRepo) r5
            kotlin.ResultKt.throwOnFailure(r12)
            goto La2
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L3d:
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r5 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r6 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r6 = (com.onesignal.core.internal.operations.impl.OperationRepo) r6
            kotlin.ResultKt.throwOnFailure(r12)
            goto L68
        L4d:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            com.onesignal.common.threading.WaiterWithValue<com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage> r12 = r11.waiter
            r0.L$0 = r11
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r4
            java.lang.Object r12 = r12.waitForWake(r0)
            if (r12 != r1) goto L66
            return r1
        L66:
            r6 = r11
            r5 = r2
        L68:
            r2.element = r12
            com.onesignal.core.internal.config.ConfigModelStore r12 = r6._configModelStore
            com.onesignal.common.modeling.Model r12 = r12.getModel()
            com.onesignal.core.internal.config.ConfigModel r12 = (com.onesignal.core.internal.config.ConfigModel) r12
            long r7 = r12.getOpRepoExecutionInterval()
            T r12 = r5.element
            com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage r12 = (com.onesignal.core.internal.operations.impl.OperationRepo.LoopWaiterMessage) r12
            long r9 = r12.getPreviousWaitedTime()
            long r7 = r7 - r9
            r2 = r5
            r5 = r6
        L81:
            T r12 = r2.element
            com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage r12 = (com.onesignal.core.internal.operations.impl.OperationRepo.LoopWaiterMessage) r12
            boolean r12 = r12.getForce()
            if (r12 != 0) goto Lb6
            com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1 r12 = new com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1
            r6 = 0
            r12.<init>(r2, r5, r6)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r0.L$0 = r5
            r0.L$1 = r2
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r12 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r7, r12, r0)
            if (r12 != r1) goto La2
            return r1
        La2:
            if (r12 != 0) goto La6
            r12 = r4
            goto La7
        La6:
            r12 = 0
        La7:
            if (r12 != 0) goto Lb6
            com.onesignal.core.internal.config.ConfigModelStore r12 = r5._configModelStore
            com.onesignal.common.modeling.Model r12 = r12.getModel()
            com.onesignal.core.internal.config.ConfigModel r12 = (com.onesignal.core.internal.config.ConfigModel) r12
            long r7 = r12.getOpRepoExecutionInterval()
            goto L81
        Lb6:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.operations.impl.OperationRepo.waitForNewOperationAndExecutionInterval(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|(1:(1:(5:10|11|12|13|14)(2:34|35))(4:36|37|38|39))(4:191|192|193|(5:195|(2:198|196)|199|200|(1:202)(1:203))(2:204|205))|40|41|(9:43|(2:46|44)|47|48|108|58|(2:61|59)|62|63)|68|69))|208|6|(0)(0)|40|41|(0)|68|69|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x03a1, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:69:0x0177. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01bc A[Catch: all -> 0x03a1, TryCatch #1 {all -> 0x03a1, blocks: (B:41:0x00c7, B:43:0x00e7, B:44:0x00ee, B:46:0x00f4, B:48:0x0106, B:49:0x0108, B:57:0x012b, B:58:0x012c, B:59:0x013a, B:61:0x0140, B:63:0x014c, B:66:0x0164, B:67:0x0165, B:68:0x0166, B:69:0x0177, B:71:0x0323, B:73:0x0329, B:74:0x032b, B:82:0x0384, B:86:0x0387, B:87:0x0388, B:88:0x0389, B:91:0x017c, B:92:0x0194, B:100:0x01b6, B:104:0x01ba, B:105:0x01bb, B:106:0x01bc, B:107:0x01d2, B:120:0x020a, B:124:0x020e, B:125:0x020f, B:126:0x0210, B:128:0x0225, B:129:0x022e, B:130:0x0230, B:148:0x027a, B:152:0x027e, B:153:0x027f, B:154:0x0280, B:155:0x029c, B:157:0x02a2, B:159:0x02b9, B:160:0x02c0, B:162:0x02c6, B:165:0x02d2, B:170:0x02dc, B:171:0x02e3, B:173:0x02e9, B:175:0x0300, B:176:0x0307, B:178:0x030d, B:181:0x0319, B:51:0x0109, B:52:0x0111, B:54:0x0117, B:56:0x0129, B:76:0x032c, B:77:0x033a, B:79:0x0340, B:81:0x0382, B:94:0x0195, B:95:0x01a2, B:97:0x01a8, B:99:0x01b4, B:132:0x0231, B:133:0x023f, B:135:0x0245, B:137:0x0253, B:142:0x0258, B:143:0x0266, B:145:0x026c, B:147:0x0278, B:109:0x01d3, B:110:0x01e0, B:112:0x01e6, B:114:0x01fc, B:116:0x0202, B:119:0x0208), top: B:40:0x00c7, inners: #2, #4, #5, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0210 A[Catch: all -> 0x03a1, TryCatch #1 {all -> 0x03a1, blocks: (B:41:0x00c7, B:43:0x00e7, B:44:0x00ee, B:46:0x00f4, B:48:0x0106, B:49:0x0108, B:57:0x012b, B:58:0x012c, B:59:0x013a, B:61:0x0140, B:63:0x014c, B:66:0x0164, B:67:0x0165, B:68:0x0166, B:69:0x0177, B:71:0x0323, B:73:0x0329, B:74:0x032b, B:82:0x0384, B:86:0x0387, B:87:0x0388, B:88:0x0389, B:91:0x017c, B:92:0x0194, B:100:0x01b6, B:104:0x01ba, B:105:0x01bb, B:106:0x01bc, B:107:0x01d2, B:120:0x020a, B:124:0x020e, B:125:0x020f, B:126:0x0210, B:128:0x0225, B:129:0x022e, B:130:0x0230, B:148:0x027a, B:152:0x027e, B:153:0x027f, B:154:0x0280, B:155:0x029c, B:157:0x02a2, B:159:0x02b9, B:160:0x02c0, B:162:0x02c6, B:165:0x02d2, B:170:0x02dc, B:171:0x02e3, B:173:0x02e9, B:175:0x0300, B:176:0x0307, B:178:0x030d, B:181:0x0319, B:51:0x0109, B:52:0x0111, B:54:0x0117, B:56:0x0129, B:76:0x032c, B:77:0x033a, B:79:0x0340, B:81:0x0382, B:94:0x0195, B:95:0x01a2, B:97:0x01a8, B:99:0x01b4, B:132:0x0231, B:133:0x023f, B:135:0x0245, B:137:0x0253, B:142:0x0258, B:143:0x0266, B:145:0x026c, B:147:0x0278, B:109:0x01d3, B:110:0x01e0, B:112:0x01e6, B:114:0x01fc, B:116:0x0202, B:119:0x0208), top: B:40:0x00c7, inners: #2, #4, #5, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0280 A[Catch: all -> 0x03a1, TryCatch #1 {all -> 0x03a1, blocks: (B:41:0x00c7, B:43:0x00e7, B:44:0x00ee, B:46:0x00f4, B:48:0x0106, B:49:0x0108, B:57:0x012b, B:58:0x012c, B:59:0x013a, B:61:0x0140, B:63:0x014c, B:66:0x0164, B:67:0x0165, B:68:0x0166, B:69:0x0177, B:71:0x0323, B:73:0x0329, B:74:0x032b, B:82:0x0384, B:86:0x0387, B:87:0x0388, B:88:0x0389, B:91:0x017c, B:92:0x0194, B:100:0x01b6, B:104:0x01ba, B:105:0x01bb, B:106:0x01bc, B:107:0x01d2, B:120:0x020a, B:124:0x020e, B:125:0x020f, B:126:0x0210, B:128:0x0225, B:129:0x022e, B:130:0x0230, B:148:0x027a, B:152:0x027e, B:153:0x027f, B:154:0x0280, B:155:0x029c, B:157:0x02a2, B:159:0x02b9, B:160:0x02c0, B:162:0x02c6, B:165:0x02d2, B:170:0x02dc, B:171:0x02e3, B:173:0x02e9, B:175:0x0300, B:176:0x0307, B:178:0x030d, B:181:0x0319, B:51:0x0109, B:52:0x0111, B:54:0x0117, B:56:0x0129, B:76:0x032c, B:77:0x033a, B:79:0x0340, B:81:0x0382, B:94:0x0195, B:95:0x01a2, B:97:0x01a8, B:99:0x01b4, B:132:0x0231, B:133:0x023f, B:135:0x0245, B:137:0x0253, B:142:0x0258, B:143:0x0266, B:145:0x026c, B:147:0x0278, B:109:0x01d3, B:110:0x01e0, B:112:0x01e6, B:114:0x01fc, B:116:0x0202, B:119:0x0208), top: B:40:0x00c7, inners: #2, #4, #5, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02dc A[Catch: all -> 0x03a1, TryCatch #1 {all -> 0x03a1, blocks: (B:41:0x00c7, B:43:0x00e7, B:44:0x00ee, B:46:0x00f4, B:48:0x0106, B:49:0x0108, B:57:0x012b, B:58:0x012c, B:59:0x013a, B:61:0x0140, B:63:0x014c, B:66:0x0164, B:67:0x0165, B:68:0x0166, B:69:0x0177, B:71:0x0323, B:73:0x0329, B:74:0x032b, B:82:0x0384, B:86:0x0387, B:87:0x0388, B:88:0x0389, B:91:0x017c, B:92:0x0194, B:100:0x01b6, B:104:0x01ba, B:105:0x01bb, B:106:0x01bc, B:107:0x01d2, B:120:0x020a, B:124:0x020e, B:125:0x020f, B:126:0x0210, B:128:0x0225, B:129:0x022e, B:130:0x0230, B:148:0x027a, B:152:0x027e, B:153:0x027f, B:154:0x0280, B:155:0x029c, B:157:0x02a2, B:159:0x02b9, B:160:0x02c0, B:162:0x02c6, B:165:0x02d2, B:170:0x02dc, B:171:0x02e3, B:173:0x02e9, B:175:0x0300, B:176:0x0307, B:178:0x030d, B:181:0x0319, B:51:0x0109, B:52:0x0111, B:54:0x0117, B:56:0x0129, B:76:0x032c, B:77:0x033a, B:79:0x0340, B:81:0x0382, B:94:0x0195, B:95:0x01a2, B:97:0x01a8, B:99:0x01b4, B:132:0x0231, B:133:0x023f, B:135:0x0245, B:137:0x0253, B:142:0x0258, B:143:0x0266, B:145:0x026c, B:147:0x0278, B:109:0x01d3, B:110:0x01e0, B:112:0x01e6, B:114:0x01fc, B:116:0x0202, B:119:0x0208), top: B:40:0x00c7, inners: #2, #4, #5, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x03df A[LOOP:0: B:19:0x03d9->B:21:0x03df, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e7 A[Catch: all -> 0x03a1, TryCatch #1 {all -> 0x03a1, blocks: (B:41:0x00c7, B:43:0x00e7, B:44:0x00ee, B:46:0x00f4, B:48:0x0106, B:49:0x0108, B:57:0x012b, B:58:0x012c, B:59:0x013a, B:61:0x0140, B:63:0x014c, B:66:0x0164, B:67:0x0165, B:68:0x0166, B:69:0x0177, B:71:0x0323, B:73:0x0329, B:74:0x032b, B:82:0x0384, B:86:0x0387, B:87:0x0388, B:88:0x0389, B:91:0x017c, B:92:0x0194, B:100:0x01b6, B:104:0x01ba, B:105:0x01bb, B:106:0x01bc, B:107:0x01d2, B:120:0x020a, B:124:0x020e, B:125:0x020f, B:126:0x0210, B:128:0x0225, B:129:0x022e, B:130:0x0230, B:148:0x027a, B:152:0x027e, B:153:0x027f, B:154:0x0280, B:155:0x029c, B:157:0x02a2, B:159:0x02b9, B:160:0x02c0, B:162:0x02c6, B:165:0x02d2, B:170:0x02dc, B:171:0x02e3, B:173:0x02e9, B:175:0x0300, B:176:0x0307, B:178:0x030d, B:181:0x0319, B:51:0x0109, B:52:0x0111, B:54:0x0117, B:56:0x0129, B:76:0x032c, B:77:0x033a, B:79:0x0340, B:81:0x0382, B:94:0x0195, B:95:0x01a2, B:97:0x01a8, B:99:0x01b4, B:132:0x0231, B:133:0x023f, B:135:0x0245, B:137:0x0253, B:142:0x0258, B:143:0x0266, B:145:0x026c, B:147:0x0278, B:109:0x01d3, B:110:0x01e0, B:112:0x01e6, B:114:0x01fc, B:116:0x0202, B:119:0x0208), top: B:40:0x00c7, inners: #2, #4, #5, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0329 A[Catch: all -> 0x03a1, TryCatch #1 {all -> 0x03a1, blocks: (B:41:0x00c7, B:43:0x00e7, B:44:0x00ee, B:46:0x00f4, B:48:0x0106, B:49:0x0108, B:57:0x012b, B:58:0x012c, B:59:0x013a, B:61:0x0140, B:63:0x014c, B:66:0x0164, B:67:0x0165, B:68:0x0166, B:69:0x0177, B:71:0x0323, B:73:0x0329, B:74:0x032b, B:82:0x0384, B:86:0x0387, B:87:0x0388, B:88:0x0389, B:91:0x017c, B:92:0x0194, B:100:0x01b6, B:104:0x01ba, B:105:0x01bb, B:106:0x01bc, B:107:0x01d2, B:120:0x020a, B:124:0x020e, B:125:0x020f, B:126:0x0210, B:128:0x0225, B:129:0x022e, B:130:0x0230, B:148:0x027a, B:152:0x027e, B:153:0x027f, B:154:0x0280, B:155:0x029c, B:157:0x02a2, B:159:0x02b9, B:160:0x02c0, B:162:0x02c6, B:165:0x02d2, B:170:0x02dc, B:171:0x02e3, B:173:0x02e9, B:175:0x0300, B:176:0x0307, B:178:0x030d, B:181:0x0319, B:51:0x0109, B:52:0x0111, B:54:0x0117, B:56:0x0129, B:76:0x032c, B:77:0x033a, B:79:0x0340, B:81:0x0382, B:94:0x0195, B:95:0x01a2, B:97:0x01a8, B:99:0x01b4, B:132:0x0231, B:133:0x023f, B:135:0x0245, B:137:0x0253, B:142:0x0258, B:143:0x0266, B:145:0x026c, B:147:0x0278, B:109:0x01d3, B:110:0x01e0, B:112:0x01e6, B:114:0x01fc, B:116:0x0202, B:119:0x0208), top: B:40:0x00c7, inners: #2, #4, #5, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x017c A[Catch: all -> 0x03a1, TryCatch #1 {all -> 0x03a1, blocks: (B:41:0x00c7, B:43:0x00e7, B:44:0x00ee, B:46:0x00f4, B:48:0x0106, B:49:0x0108, B:57:0x012b, B:58:0x012c, B:59:0x013a, B:61:0x0140, B:63:0x014c, B:66:0x0164, B:67:0x0165, B:68:0x0166, B:69:0x0177, B:71:0x0323, B:73:0x0329, B:74:0x032b, B:82:0x0384, B:86:0x0387, B:87:0x0388, B:88:0x0389, B:91:0x017c, B:92:0x0194, B:100:0x01b6, B:104:0x01ba, B:105:0x01bb, B:106:0x01bc, B:107:0x01d2, B:120:0x020a, B:124:0x020e, B:125:0x020f, B:126:0x0210, B:128:0x0225, B:129:0x022e, B:130:0x0230, B:148:0x027a, B:152:0x027e, B:153:0x027f, B:154:0x0280, B:155:0x029c, B:157:0x02a2, B:159:0x02b9, B:160:0x02c0, B:162:0x02c6, B:165:0x02d2, B:170:0x02dc, B:171:0x02e3, B:173:0x02e9, B:175:0x0300, B:176:0x0307, B:178:0x030d, B:181:0x0319, B:51:0x0109, B:52:0x0111, B:54:0x0117, B:56:0x0129, B:76:0x032c, B:77:0x033a, B:79:0x0340, B:81:0x0382, B:94:0x0195, B:95:0x01a2, B:97:0x01a8, B:99:0x01b4, B:132:0x0231, B:133:0x023f, B:135:0x0245, B:137:0x0253, B:142:0x0258, B:143:0x0266, B:145:0x026c, B:147:0x0278, B:109:0x01d3, B:110:0x01e0, B:112:0x01e6, B:114:0x01fc, B:116:0x0202, B:119:0x0208), top: B:40:0x00c7, inners: #2, #4, #5, #6, #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object executeOperations$com_onesignal_core(java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem> r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            Method dump skipped, instructions count: 1068
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.operations.impl.OperationRepo.executeOperations$com_onesignal_core(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object delayBeforeNextExecution(int i, Integer num, Continuation<? super Unit> continuation) {
        Logging.debug$default("retryAfterSeconds: " + num, null, 2, null);
        long max = Math.max(i * this._configModelStore.getModel().getOpRepoDefaultFailRetryBackoff(), (num != null ? num.intValue() : 0L) * 1000);
        if (max < 1) {
            return Unit.INSTANCE;
        }
        Logging.error$default("Operations being delay for: " + max + " ms", null, 2, null);
        Object delay = DelayKt.delay(max, continuation);
        return delay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delay : Unit.INSTANCE;
    }

    public final List<OperationQueueItem> getNextOps$com_onesignal_core(int bucketFilter) {
        List<OperationQueueItem> list;
        Object obj;
        synchronized (this.queue) {
            Iterator<T> it = this.queue.iterator();
            while (true) {
                list = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                OperationQueueItem operationQueueItem = (OperationQueueItem) obj;
                if (operationQueueItem.getOperation().getCanStartExecute() && this._newRecordState.canAccess(operationQueueItem.getOperation().getApplyToRecordId()) && operationQueueItem.getBucket() <= bucketFilter) {
                    break;
                }
            }
            OperationQueueItem operationQueueItem2 = (OperationQueueItem) obj;
            if (operationQueueItem2 != null) {
                this.queue.remove(operationQueueItem2);
                list = getGroupableOperations(operationQueueItem2);
            }
        }
        return list;
    }

    private final List<OperationQueueItem> getGroupableOperations(OperationQueueItem startingOp) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(startingOp);
        if (startingOp.getOperation().getGroupComparisonType() == GroupComparisonType.NONE) {
            return arrayList;
        }
        String createComparisonKey = startingOp.getOperation().getGroupComparisonType() == GroupComparisonType.CREATE ? startingOp.getOperation().getCreateComparisonKey() : startingOp.getOperation().getModifyComparisonKey();
        if (!this.queue.isEmpty()) {
            for (OperationQueueItem operationQueueItem : CollectionsKt.toList(this.queue)) {
                String createComparisonKey2 = startingOp.getOperation().getGroupComparisonType() == GroupComparisonType.CREATE ? operationQueueItem.getOperation().getCreateComparisonKey() : operationQueueItem.getOperation().getModifyComparisonKey();
                if (Intrinsics.areEqual(createComparisonKey2, "") && Intrinsics.areEqual(createComparisonKey, "")) {
                    throw new Exception("Both comparison keys can not be blank!");
                }
                if (Intrinsics.areEqual(createComparisonKey2, createComparisonKey)) {
                    this.queue.remove(operationQueueItem);
                    arrayList.add(operationQueueItem);
                }
            }
        }
        return arrayList;
    }
}
