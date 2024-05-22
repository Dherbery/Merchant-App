package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.internal.controller.impl.GmsLocationController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GmsLocationController.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.location.internal.controller.impl.GmsLocationController$start$2$1$2", f = "GmsLocationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class GmsLocationController$start$2$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<GmsLocationController> $self;
    final /* synthetic */ Ref.BooleanRef $wasSuccessful;
    int label;
    final /* synthetic */ GmsLocationController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GmsLocationController$start$2$1$2(Ref.ObjectRef<GmsLocationController> objectRef, GmsLocationController gmsLocationController, Ref.BooleanRef booleanRef, Continuation<? super GmsLocationController$start$2$1$2> continuation) {
        super(2, continuation);
        this.$self = objectRef;
        this.this$0 = gmsLocationController;
        this.$wasSuccessful = booleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GmsLocationController$start$2$1$2(this.$self, this.this$0, this.$wasSuccessful, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GmsLocationController$start$2$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IApplicationService iApplicationService;
        GmsLocationController.LocationHandlerThread locationHandlerThread;
        Location location;
        IApplicationService iApplicationService2;
        IFusedLocationApiWrapper iFusedLocationApiWrapper;
        IFusedLocationApiWrapper iFusedLocationApiWrapper2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        GmsLocationController.GoogleApiClientListener googleApiClientListener = new GmsLocationController.GoogleApiClientListener(this.$self.element);
        iApplicationService = this.this$0._applicationService;
        GoogleApiClient.Builder addOnConnectionFailedListener = new GoogleApiClient.Builder(iApplicationService.getAppContext()).addApi(LocationServices.API).addConnectionCallbacks(googleApiClientListener).addOnConnectionFailedListener(googleApiClientListener);
        locationHandlerThread = this.this$0.locationHandlerThread;
        GoogleApiClient googleApiClient = addOnConnectionFailedListener.setHandler(locationHandlerThread.getMHandler()).build();
        Intrinsics.checkNotNullExpressionValue(googleApiClient, "googleApiClient");
        GoogleApiClientCompatProxy googleApiClientCompatProxy = new GoogleApiClientCompatProxy(googleApiClient);
        ConnectionResult blockingConnect = googleApiClientCompatProxy.blockingConnect();
        boolean z = false;
        if (blockingConnect != null && blockingConnect.isSuccess()) {
            z = true;
        }
        if (z) {
            location = this.this$0.lastLocation;
            if (location == null) {
                iFusedLocationApiWrapper2 = this.this$0._fusedLocationApiWrapper;
                Location lastLocation = iFusedLocationApiWrapper2.getLastLocation(googleApiClient);
                if (lastLocation != null) {
                    this.this$0.setLocationAndFire(lastLocation);
                }
            }
            GmsLocationController gmsLocationController = this.$self.element;
            iApplicationService2 = this.this$0._applicationService;
            GmsLocationController gmsLocationController2 = this.$self.element;
            GoogleApiClient realInstance = googleApiClientCompatProxy.getRealInstance();
            iFusedLocationApiWrapper = this.this$0._fusedLocationApiWrapper;
            gmsLocationController.locationUpdateListener = new GmsLocationController.LocationUpdateListener(iApplicationService2, gmsLocationController2, realInstance, iFusedLocationApiWrapper);
            this.$self.element.googleApiClient = googleApiClientCompatProxy;
            this.$wasSuccessful.element = true;
        } else {
            StringBuilder sb = new StringBuilder("GMSLocationController connection to GoogleApiService failed: (");
            sb.append(blockingConnect != null ? Boxing.boxInt(blockingConnect.getErrorCode()) : null);
            sb.append(") ");
            sb.append(blockingConnect != null ? blockingConnect.getErrorMessage() : null);
            Logging.debug$default(sb.toString(), null, 2, null);
        }
        return Unit.INSTANCE;
    }
}
