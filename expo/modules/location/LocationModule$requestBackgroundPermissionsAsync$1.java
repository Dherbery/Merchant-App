package expo.modules.location;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocationModule.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.location.LocationModule", f = "LocationModule.kt", i = {}, l = {355, 358}, m = "requestBackgroundPermissionsAsync", n = {}, s = {})
/* loaded from: classes5.dex */
public final class LocationModule$requestBackgroundPermissionsAsync$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocationModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationModule$requestBackgroundPermissionsAsync$1(LocationModule locationModule, Continuation<? super LocationModule$requestBackgroundPermissionsAsync$1> continuation) {
        super(continuation);
        this.this$0 = locationModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object requestBackgroundPermissionsAsync;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        requestBackgroundPermissionsAsync = this.this$0.requestBackgroundPermissionsAsync(this);
        return requestBackgroundPermissionsAsync;
    }
}
