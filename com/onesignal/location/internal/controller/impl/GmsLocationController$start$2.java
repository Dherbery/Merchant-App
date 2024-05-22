package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.soloader.Elf64_Ehdr;
import com.onesignal.common.events.EventProducer;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.internal.controller.ILocationUpdatedHandler;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GmsLocationController.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.location.internal.controller.impl.GmsLocationController$start$2", f = "GmsLocationController.kt", i = {0, 1}, l = {ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, Elf64_Ehdr.e_shstrndx}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
/* loaded from: classes5.dex */
public final class GmsLocationController$start$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<GmsLocationController> $self;
    final /* synthetic */ Ref.BooleanRef $wasSuccessful;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ GmsLocationController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GmsLocationController$start$2(GmsLocationController gmsLocationController, Ref.BooleanRef booleanRef, Ref.ObjectRef<GmsLocationController> objectRef, Continuation<? super GmsLocationController$start$2> continuation) {
        super(2, continuation);
        this.this$0 = gmsLocationController;
        this.$wasSuccessful = booleanRef;
        this.$self = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GmsLocationController$start$2(this.this$0, this.$wasSuccessful, this.$self, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GmsLocationController$start$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        final GmsLocationController gmsLocationController;
        Ref.BooleanRef booleanRef;
        Ref.ObjectRef<GmsLocationController> objectRef;
        Mutex mutex2;
        Throwable th;
        GoogleApiClientCompatProxy googleApiClientCompatProxy;
        Location location;
        EventProducer eventProducer;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.this$0.startStopMutex;
                gmsLocationController = this.this$0;
                booleanRef = this.$wasSuccessful;
                objectRef = this.$self;
                this.L$0 = mutex;
                this.L$1 = gmsLocationController;
                this.L$2 = booleanRef;
                this.L$3 = objectRef;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) this.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th2) {
                            th = th2;
                            mutex2.unlock(null);
                            throw th;
                        }
                    } catch (TimeoutCancellationException unused) {
                        Logging.warn$default("Location permission exists but GoogleApiClient timed out. Maybe related to mismatch google-play aar versions.", null, 2, null);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    }
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                objectRef = (Ref.ObjectRef) this.L$3;
                booleanRef = (Ref.BooleanRef) this.L$2;
                gmsLocationController = (GmsLocationController) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
            }
            googleApiClientCompatProxy = gmsLocationController.googleApiClient;
            if (googleApiClientCompatProxy != null) {
                location = gmsLocationController.lastLocation;
                if (location != null) {
                    eventProducer = gmsLocationController.event;
                    eventProducer.fire(new Function1<ILocationUpdatedHandler, Unit>() { // from class: com.onesignal.location.internal.controller.impl.GmsLocationController$start$2$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ILocationUpdatedHandler iLocationUpdatedHandler) {
                            invoke2(iLocationUpdatedHandler);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ILocationUpdatedHandler it) {
                            Location location2;
                            Intrinsics.checkNotNullParameter(it, "it");
                            location2 = GmsLocationController.this.lastLocation;
                            Intrinsics.checkNotNull(location2);
                            it.onLocationChanged(location2);
                        }
                    });
                } else {
                    Location lastLocation = gmsLocationController.getLastLocation();
                    if (lastLocation != null) {
                        gmsLocationController.setLocationAndFire(lastLocation);
                    }
                }
                booleanRef.element = true;
            } else {
                try {
                    long api_fallback_time = GmsLocationController.INSTANCE.getAPI_FALLBACK_TIME();
                    GmsLocationController$start$2$1$2 gmsLocationController$start$2$1$2 = new GmsLocationController$start$2$1$2(objectRef, gmsLocationController, booleanRef, null);
                    this.L$0 = mutex;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 2;
                    if (TimeoutKt.withTimeout(api_fallback_time, gmsLocationController$start$2$1$2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (TimeoutCancellationException unused2) {
                    mutex2 = mutex;
                    Logging.warn$default("Location permission exists but GoogleApiClient timed out. Maybe related to mismatch google-play aar versions.", null, 2, null);
                    Unit unit22 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
            }
            mutex2 = mutex;
            Unit unit222 = Unit.INSTANCE;
            mutex2.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock(null);
            throw th;
        }
    }
}
