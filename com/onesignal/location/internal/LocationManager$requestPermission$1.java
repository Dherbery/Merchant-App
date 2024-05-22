package com.onesignal.location.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocationManager.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.location.internal.LocationManager", f = "LocationManager.kt", i = {0}, l = {79}, m = "requestPermission", n = {"result"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class LocationManager$requestPermission$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocationManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationManager$requestPermission$1(LocationManager locationManager, Continuation<? super LocationManager$requestPermission$1> continuation) {
        super(continuation);
        this.this$0 = locationManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.requestPermission(this);
    }
}
