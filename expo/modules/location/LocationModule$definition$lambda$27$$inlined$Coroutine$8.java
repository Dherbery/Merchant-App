package expo.modules.location;

import expo.modules.location.records.LocationLastKnownOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AsyncFunctionBuilder.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001*\u00020\u00022\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003H\u008a@¨\u0006\u0006"}, d2 = {"R", "P0", "Lkotlinx/coroutines/CoroutineScope;", "", "", "it", "expo/modules/kotlin/functions/AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$2", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "expo.modules.location.LocationModule$definition$lambda$27$$inlined$Coroutine$8", f = "LocationModule.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class LocationModule$definition$lambda$27$$inlined$Coroutine$8 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LocationModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationModule$definition$lambda$27$$inlined$Coroutine$8(Continuation continuation, LocationModule locationModule) {
        super(3, continuation);
        this.this$0 = locationModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        LocationModule$definition$lambda$27$$inlined$Coroutine$8 locationModule$definition$lambda$27$$inlined$Coroutine$8 = new LocationModule$definition$lambda$27$$inlined$Coroutine$8(continuation, this.this$0);
        locationModule$definition$lambda$27$$inlined$Coroutine$8.L$0 = objArr;
        return locationModule$definition$lambda$27$$inlined$Coroutine$8.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = ((Object[]) this.L$0)[0];
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type expo.modules.location.records.LocationLastKnownOptions");
            }
            LocationModule locationModule = this.this$0;
            this.label = 1;
            obj = locationModule.getLastKnownPositionAsync((LocationLastKnownOptions) obj2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
