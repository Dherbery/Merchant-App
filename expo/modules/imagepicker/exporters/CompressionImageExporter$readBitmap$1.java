package expo.modules.imagepicker.exporters;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompressionImageExporter.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.imagepicker.exporters.CompressionImageExporter", f = "CompressionImageExporter.kt", i = {}, l = {52}, m = "readBitmap", n = {}, s = {})
/* loaded from: classes5.dex */
public final class CompressionImageExporter$readBitmap$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CompressionImageExporter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompressionImageExporter$readBitmap$1(CompressionImageExporter compressionImageExporter, Continuation<? super CompressionImageExporter$readBitmap$1> continuation) {
        super(continuation);
        this.this$0 = compressionImageExporter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readBitmap;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readBitmap = this.this$0.readBitmap(null, this);
        return readBitmap;
    }
}
