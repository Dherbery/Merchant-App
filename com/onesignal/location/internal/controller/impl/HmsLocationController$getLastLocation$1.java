package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.onesignal.common.threading.Waiter;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: HmsLocationController.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.location.internal.controller.impl.HmsLocationController$getLastLocation$1", f = "HmsLocationController.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class HmsLocationController$getLastLocation$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ FusedLocationProviderClient $locationClient;
    final /* synthetic */ Ref.ObjectRef<Location> $retVal;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HmsLocationController$getLastLocation$1(FusedLocationProviderClient fusedLocationProviderClient, Ref.ObjectRef<Location> objectRef, Continuation<? super HmsLocationController$getLastLocation$1> continuation) {
        super(1, continuation);
        this.$locationClient = fusedLocationProviderClient;
        this.$retVal = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new HmsLocationController$getLastLocation$1(this.$locationClient, this.$retVal, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((HmsLocationController$getLastLocation$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.onesignal.common.threading.Waiter, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new Waiter();
            Task lastLocation = this.$locationClient.getLastLocation();
            final Ref.ObjectRef<Location> objectRef2 = this.$retVal;
            lastLocation.addOnSuccessListener(new OnSuccessListener() { // from class: com.onesignal.location.internal.controller.impl.HmsLocationController$getLastLocation$1$$ExternalSyntheticLambda0
                public final void onSuccess(Object obj2) {
                    HmsLocationController$getLastLocation$1.m1026invokeSuspend$lambda0(Ref.ObjectRef.this, objectRef2, (Location) obj2);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.onesignal.location.internal.controller.impl.HmsLocationController$getLastLocation$1$$ExternalSyntheticLambda1
                public final void onFailure(Exception exc) {
                    HmsLocationController$getLastLocation$1.m1027invokeSuspend$lambda1(Ref.ObjectRef.this, exc);
                }
            });
            this.label = 1;
            if (((Waiter) objectRef.element).waitForWake(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: invokeSuspend$lambda-0, reason: not valid java name */
    public static final void m1026invokeSuspend$lambda0(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Location location) {
        Logging.warn$default("Huawei LocationServices getLastLocation returned location: " + location, null, 2, null);
        if (location == 0) {
            ((Waiter) objectRef.element).wake();
        } else {
            objectRef2.element = location;
            ((Waiter) objectRef.element).wake();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: invokeSuspend$lambda-1, reason: not valid java name */
    public static final void m1027invokeSuspend$lambda1(Ref.ObjectRef objectRef, Exception exc) {
        Logging.error("Huawei LocationServices getLastLocation failed!", exc);
        ((Waiter) objectRef.element).wake();
    }
}
