package expo.modules.imagepicker;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.soloader.Elf64_Ehdr;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaHandler.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.imagepicker.MediaHandler", f = "MediaHandler.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {53, 55, Elf64_Ehdr.e_shentsize}, m = "handleImage", n = {"this", "sourceUri", "options", "mimeType", "outputFile", "this", "sourceUri", "options", "mimeType", "outputFile", "exportedImage", "this", "sourceUri", "mimeType", "outputFile", "exportedImage", ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes5.dex */
public final class MediaHandler$handleImage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaHandler$handleImage$1(MediaHandler mediaHandler, Continuation<? super MediaHandler$handleImage$1> continuation) {
        super(continuation);
        this.this$0 = mediaHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object handleImage;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleImage = this.this$0.handleImage(null, null, this);
        return handleImage;
    }
}
