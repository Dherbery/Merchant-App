package expo.modules.imagepicker;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaHandler.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.imagepicker.MediaHandler", f = "MediaHandler.kt", i = {0, 0, 0}, l = {93}, m = "handleVideo", n = {"this", "sourceUri", "outputFile"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes5.dex */
public final class MediaHandler$handleVideo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaHandler$handleVideo$1(MediaHandler mediaHandler, Continuation<? super MediaHandler$handleVideo$1> continuation) {
        super(continuation);
        this.this$0 = mediaHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object handleVideo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleVideo = this.this$0.handleVideo(null, this);
        return handleVideo;
    }
}
