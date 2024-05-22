package com.onesignal.core.internal.operations;

import com.onesignal.core.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.reflect.KClass;

/* compiled from: IOperationRepo.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H&J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0003H&J#\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/onesignal/core/internal/operations/IOperationRepo;", "", "containsInstanceOf", "", "T", "Lcom/onesignal/core/internal/operations/Operation;", "type", "Lkotlin/reflect/KClass;", "enqueue", "", "operation", "flush", "enqueueAndWait", "(Lcom/onesignal/core/internal/operations/Operation;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IOperationRepo {
    <T extends Operation> boolean containsInstanceOf(KClass<T> type);

    void enqueue(Operation operation, boolean flush);

    Object enqueueAndWait(Operation operation, boolean z, Continuation<? super Boolean> continuation);

    /* compiled from: IOperationRepo.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void enqueue$default(IOperationRepo iOperationRepo, Operation operation, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueue");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iOperationRepo.enqueue(operation, z);
        }

        public static /* synthetic */ Object enqueueAndWait$default(IOperationRepo iOperationRepo, Operation operation, boolean z, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueueAndWait");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            return iOperationRepo.enqueueAndWait(operation, z, continuation);
        }
    }
}
