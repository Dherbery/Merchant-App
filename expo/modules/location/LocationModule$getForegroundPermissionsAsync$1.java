package expo.modules.location;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocationModule.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.location.LocationModule", f = "LocationModule.kt", i = {0, 1}, l = {330, 331}, m = "getForegroundPermissionsAsync", n = {"it", "locationPermission"}, s = {"L$0", "L$0"})
/* loaded from: classes5.dex */
public final class LocationModule$getForegroundPermissionsAsync$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocationModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationModule$getForegroundPermissionsAsync$1(LocationModule locationModule, Continuation<? super LocationModule$getForegroundPermissionsAsync$1> continuation) {
        super(continuation);
        this.this$0 = locationModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object foregroundPermissionsAsync;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        foregroundPermissionsAsync = this.this$0.getForegroundPermissionsAsync(this);
        return foregroundPermissionsAsync;
    }
}
