package com.onesignal.core.internal.purchases.impl;

import android.content.Context;
import com.amazon.device.iap.PurchasingService;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.purchases.impl.TrackAmazonPurchase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TrackAmazonPurchase.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.core.internal.purchases.impl.TrackAmazonPurchase$setListener$1", f = "TrackAmazonPurchase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class TrackAmazonPurchase$setListener$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TrackAmazonPurchase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackAmazonPurchase$setListener$1(TrackAmazonPurchase trackAmazonPurchase, Continuation<? super TrackAmazonPurchase$setListener$1> continuation) {
        super(1, continuation);
        this.this$0 = trackAmazonPurchase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TrackAmazonPurchase$setListener$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TrackAmazonPurchase$setListener$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IApplicationService iApplicationService;
        TrackAmazonPurchase.OSPurchasingListener oSPurchasingListener;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        iApplicationService = this.this$0._applicationService;
        Context appContext = iApplicationService.getAppContext();
        oSPurchasingListener = this.this$0.osPurchasingListener;
        PurchasingService.registerListener(appContext, oSPurchasingListener);
        return Unit.INSTANCE;
    }
}
