package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HmsLocationController.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.location.internal.controller.impl.HmsLocationController$start$2", f = "HmsLocationController.kt", i = {0, 1}, l = {229, 81}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
/* loaded from: classes5.dex */
public final class HmsLocationController$start$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<HmsLocationController> $self;
    final /* synthetic */ Ref.BooleanRef $wasSuccessful;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ HmsLocationController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HmsLocationController$start$2(HmsLocationController hmsLocationController, Ref.BooleanRef booleanRef, Ref.ObjectRef<HmsLocationController> objectRef, Continuation<? super HmsLocationController$start$2> continuation) {
        super(2, continuation);
        this.this$0 = hmsLocationController;
        this.$wasSuccessful = booleanRef;
        this.$self = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HmsLocationController$start$2(this.this$0, this.$wasSuccessful, this.$self, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HmsLocationController$start$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0102 A[Catch: all -> 0x002a, TryCatch #2 {all -> 0x002a, blocks: (B:7:0x0025, B:8:0x00f6, B:10:0x0102, B:12:0x0128), top: B:6:0x0025 }] */
    /* JADX WARN: Type inference failed for: r7v5, types: [T, com.onesignal.common.threading.WaiterWithValue] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.location.internal.controller.impl.HmsLocationController$start$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: invokeSuspend$lambda-2$lambda-0, reason: not valid java name */
    public static final void m1028invokeSuspend$lambda2$lambda0(Ref.ObjectRef objectRef, HmsLocationController hmsLocationController, Location location) {
        Logging.warn$default("Huawei LocationServices getLastLocation returned location: " + location, null, 2, null);
        if (location != null) {
            hmsLocationController.lastLocation = location;
            ((WaiterWithValue) objectRef.element).wake(true);
        } else {
            ((WaiterWithValue) objectRef.element).wake(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: invokeSuspend$lambda-2$lambda-1, reason: not valid java name */
    public static final void m1029invokeSuspend$lambda2$lambda1(Ref.ObjectRef objectRef, Exception exc) {
        Logging.error("Huawei LocationServices getLastLocation failed!", exc);
        ((WaiterWithValue) objectRef.element).wake(false);
    }
}
