package expo.modules.imagepicker;

import com.facebook.imagepipeline.common.RotationOptions;
import expo.modules.kotlin.activityresult.AppContextActivityResultCaller;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ImagePickerModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lexpo/modules/kotlin/activityresult/AppContextActivityResultCaller;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "expo.modules.imagepicker.ImagePickerModule$definition$1$8", f = "ImagePickerModule.kt", i = {0, 1}, l = {86, RotationOptions.ROTATE_90, 94}, m = "invokeSuspend", n = {"$this$RegisterActivityContracts", "$this$RegisterActivityContracts"}, s = {"L$0", "L$0"})
/* loaded from: classes5.dex */
final class ImagePickerModule$definition$1$8 extends SuspendLambda implements Function2<AppContextActivityResultCaller, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ImagePickerModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePickerModule$definition$1$8(ImagePickerModule imagePickerModule, Continuation<? super ImagePickerModule$definition$1$8> continuation) {
        super(2, continuation);
        this.this$0 = imagePickerModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ImagePickerModule$definition$1$8 imagePickerModule$definition$1$8 = new ImagePickerModule$definition$1$8(this.this$0, continuation);
        imagePickerModule$definition$1$8.L$0 = obj;
        return imagePickerModule$definition$1$8;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AppContextActivityResultCaller appContextActivityResultCaller, Continuation<? super Unit> continuation) {
        return ((ImagePickerModule$definition$1$8) create(appContextActivityResultCaller, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00bf  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.ImagePickerModule$definition$1$8.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
