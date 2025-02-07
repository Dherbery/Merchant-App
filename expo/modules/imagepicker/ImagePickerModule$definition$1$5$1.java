package expo.modules.imagepicker;

import expo.modules.imagepicker.contracts.CameraContractOptions;
import expo.modules.imagepicker.contracts.ImagePickerContractResult;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImagePickerModule.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "expo.modules.imagepicker.ImagePickerModule$definition$1$5$1", f = "ImagePickerModule.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class ImagePickerModule$definition$1$5$1 extends SuspendLambda implements Function1<Continuation<? super ImagePickerContractResult>, Object> {
    final /* synthetic */ CameraContractOptions $contractOptions;
    int label;
    final /* synthetic */ ImagePickerModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePickerModule$definition$1$5$1(ImagePickerModule imagePickerModule, CameraContractOptions cameraContractOptions, Continuation<? super ImagePickerModule$definition$1$5$1> continuation) {
        super(1, continuation);
        this.this$0 = imagePickerModule;
        this.$contractOptions = cameraContractOptions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ImagePickerModule$definition$1$5$1(this.this$0, this.$contractOptions, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ImagePickerContractResult> continuation) {
        return ((ImagePickerModule$definition$1$5$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AppContextActivityResultLauncher appContextActivityResultLauncher;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            appContextActivityResultLauncher = this.this$0.cameraLauncher;
            if (appContextActivityResultLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cameraLauncher");
                appContextActivityResultLauncher = null;
            }
            this.label = 1;
            obj = appContextActivityResultLauncher.launch((AppContextActivityResultLauncher) this.$contractOptions, (Continuation) this);
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
