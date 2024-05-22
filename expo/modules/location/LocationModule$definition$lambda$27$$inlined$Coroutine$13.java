package expo.modules.location;

import android.content.Context;
import com.google.android.gms.location.LocationRequest;
import expo.modules.location.LocationHelpers;
import expo.modules.location.records.LocationOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AsyncFunctionBuilder.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002H\u008a@¨\u0006\u0005"}, d2 = {"R", "Lkotlinx/coroutines/CoroutineScope;", "", "", "it", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$1", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "expo.modules.location.LocationModule$definition$lambda$27$$inlined$Coroutine$13", f = "LocationModule.kt", i = {0}, l = {179}, m = "invokeSuspend", n = {"locationRequest"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class LocationModule$definition$lambda$27$$inlined$Coroutine$13 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LocationModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationModule$definition$lambda$27$$inlined$Coroutine$13(Continuation continuation, LocationModule locationModule) {
        super(3, continuation);
        this.this$0 = locationModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        return new LocationModule$definition$lambda$27$$inlined$Coroutine$13(continuation, this.this$0).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context context;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LocationModule$definition$lambda$27$$inlined$Coroutine$13 locationModule$definition$lambda$27$$inlined$Coroutine$13 = this;
            LocationHelpers.Companion companion = LocationHelpers.INSTANCE;
            context = this.this$0.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            if (companion.hasNetworkProviderEnabled(context)) {
                return null;
            }
            LocationRequest prepareLocationRequest$expo_location_release = LocationHelpers.INSTANCE.prepareLocationRequest$expo_location_release(new LocationOptions(0, null, false, null, 15, null));
            this.L$0 = prepareLocationRequest$expo_location_release;
            this.L$1 = this;
            this.label = 1;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(locationModule$definition$lambda$27$$inlined$Coroutine$13));
            final SafeContinuation safeContinuation2 = safeContinuation;
            this.this$0.addPendingLocationRequest(prepareLocationRequest$expo_location_release, new LocationActivityResultListener() { // from class: expo.modules.location.LocationModule$definition$1$16$1$1
                @Override // expo.modules.location.LocationActivityResultListener
                public void onResult(int resultCode) {
                    if (resultCode == -1) {
                        Continuation<String> continuation = safeContinuation2;
                        Result.Companion companion2 = Result.INSTANCE;
                        continuation.resumeWith(Result.m1318constructorimpl(null));
                    } else {
                        Continuation<String> continuation2 = safeContinuation2;
                        Result.Companion companion3 = Result.INSTANCE;
                        continuation2.resumeWith(Result.m1318constructorimpl(ResultKt.createFailure(new LocationSettingsUnsatisfiedException())));
                    }
                }
            });
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(locationModule$definition$lambda$27$$inlined$Coroutine$13);
            }
            if (orThrow == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = orThrow;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
