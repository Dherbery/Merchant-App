package expo.modules.imagepicker;

import com.facebook.imagepipeline.common.RotationOptions;
import expo.modules.imagepicker.contracts.CameraContractOptions;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AsyncFunctionBuilder.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001*\u00020\u00022\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003H\u008a@¨\u0006\u0006"}, d2 = {"R", "P0", "Lkotlinx/coroutines/CoroutineScope;", "", "", "it", "expo/modules/kotlin/functions/AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$2", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2", f = "ImagePickerModule.kt", i = {0}, l = {174, RotationOptions.ROTATE_180}, m = "invokeSuspend", n = {"options"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ImagePickerModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2(Continuation continuation, ImagePickerModule imagePickerModule) {
        super(3, continuation);
        this.this$0 = imagePickerModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2 imagePickerModule$definition$lambda$7$$inlined$Coroutine$2 = new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2(continuation, this.this$0);
        imagePickerModule$definition$lambda$7$$inlined$Coroutine$2.L$0 = objArr;
        return imagePickerModule$definition$lambda$7$$inlined$Coroutine$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ImagePickerOptions imagePickerOptions;
        Object ensureCameraPermissionsAreGranted;
        File cacheDirectory;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = ((Object[]) this.L$0)[0];
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
            }
            imagePickerOptions = (ImagePickerOptions) obj2;
            this.this$0.ensureTargetActivityIsAvailable(imagePickerOptions);
            ImagePickerModule imagePickerModule = this.this$0;
            this.L$0 = imagePickerOptions;
            this.label = 1;
            ensureCameraPermissionsAreGranted = imagePickerModule.ensureCameraPermissionsAreGranted(this);
            if (ensureCameraPermissionsAreGranted == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            imagePickerOptions = (ImagePickerOptions) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        cacheDirectory = this.this$0.getCacheDirectory();
        String uri = ImagePickerUtilsKt.toContentUri(ImagePickerUtilsKt.createOutputFile(cacheDirectory, imagePickerOptions.getMediaTypes().toFileExtension()), this.this$0.getContext()).toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uri.toString()");
        CameraContractOptions cameraContractOptions = imagePickerOptions.toCameraContractOptions(uri);
        ImagePickerModule imagePickerModule2 = this.this$0;
        ImagePickerModule$definition$1$5$1 imagePickerModule$definition$1$5$1 = new ImagePickerModule$definition$1$5$1(this.this$0, cameraContractOptions, null);
        this.L$0 = null;
        this.label = 2;
        obj = imagePickerModule2.launchContract(imagePickerModule$definition$1$5$1, imagePickerOptions, this);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }
}
