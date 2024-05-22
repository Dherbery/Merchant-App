package expo.modules.imagepicker;

import android.os.OperationCanceledException;
import expo.modules.imagepicker.contracts.ImagePickerContractResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ImagePickerModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult$Success;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "expo.modules.imagepicker.ImagePickerModule$launchPicker$2", f = "ImagePickerModule.kt", i = {}, l = {165}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class ImagePickerModule$launchPicker$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImagePickerContractResult.Success>, Object> {
    final /* synthetic */ Function1<Continuation<? super ImagePickerContractResult>, Object> $pickerLauncher;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ImagePickerModule$launchPicker$2(Function1<? super Continuation<? super ImagePickerContractResult>, ? extends Object> function1, Continuation<? super ImagePickerModule$launchPicker$2> continuation) {
        super(2, continuation);
        this.$pickerLauncher = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImagePickerModule$launchPicker$2(this.$pickerLauncher, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImagePickerContractResult.Success> continuation) {
        return ((ImagePickerModule$launchPicker$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super ImagePickerContractResult>, Object> function1 = this.$pickerLauncher;
            this.label = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ImagePickerContractResult imagePickerContractResult = (ImagePickerContractResult) obj;
        if (imagePickerContractResult instanceof ImagePickerContractResult.Success) {
            return (ImagePickerContractResult.Success) imagePickerContractResult;
        }
        if (imagePickerContractResult instanceof ImagePickerContractResult.Cancelled) {
            throw new OperationCanceledException();
        }
        if (imagePickerContractResult instanceof ImagePickerContractResult.Error) {
            throw new FailedToPickMediaException();
        }
        throw new NoWhenBranchMatchedException();
    }
}
