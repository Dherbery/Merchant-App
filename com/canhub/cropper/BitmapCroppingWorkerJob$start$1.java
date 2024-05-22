package com.canhub.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.canhub.cropper.BitmapCroppingWorkerJob;
import com.canhub.cropper.BitmapUtils;
import com.canhub.cropper.CropImageView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BitmapCroppingWorkerJob.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.canhub.cropper.BitmapCroppingWorkerJob$start$1", f = "BitmapCroppingWorkerJob.kt", i = {}, l = {77, 102}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class BitmapCroppingWorkerJob$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BitmapCroppingWorkerJob this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BitmapCroppingWorkerJob$start$1(BitmapCroppingWorkerJob bitmapCroppingWorkerJob, Continuation<? super BitmapCroppingWorkerJob$start$1> continuation) {
        super(2, continuation);
        this.this$0 = bitmapCroppingWorkerJob;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BitmapCroppingWorkerJob$start$1 bitmapCroppingWorkerJob$start$1 = new BitmapCroppingWorkerJob$start$1(this.this$0, continuation);
        bitmapCroppingWorkerJob$start$1.L$0 = obj;
        return bitmapCroppingWorkerJob$start$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BitmapCroppingWorkerJob$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object onPostExecute;
        Bitmap bitmap;
        Object onPostExecute2;
        Bitmap bitmap2;
        float[] fArr;
        int i;
        boolean z;
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        BitmapUtils.BitmapSampled cropBitmapObjectHandleOOM;
        int i4;
        int i5;
        CropImageView.RequestSizeOptions requestSizeOptions;
        Context context;
        float[] fArr2;
        int i6;
        int i7;
        int i8;
        boolean z4;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z5;
        boolean z6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i13 = this.label;
        try {
        } catch (Exception e) {
            this.label = 2;
            onPostExecute = this.this$0.onPostExecute(new BitmapCroppingWorkerJob.Result(e, false), this);
            if (onPostExecute == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i13 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                if (this.this$0.getUri() == null) {
                    bitmap = this.this$0.bitmap;
                    if (bitmap == null) {
                        this.label = 1;
                        onPostExecute2 = this.this$0.onPostExecute(new BitmapCroppingWorkerJob.Result((Bitmap) null, 1), this);
                        if (onPostExecute2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        BitmapUtils bitmapUtils = BitmapUtils.INSTANCE;
                        bitmap2 = this.this$0.bitmap;
                        fArr = this.this$0.cropPoints;
                        i = this.this$0.degreesRotated;
                        z = this.this$0.fixAspectRatio;
                        i2 = this.this$0.aspectRatioX;
                        i3 = this.this$0.aspectRatioY;
                        z2 = this.this$0.flipHorizontally;
                        z3 = this.this$0.flipVertically;
                        cropBitmapObjectHandleOOM = bitmapUtils.cropBitmapObjectHandleOOM(bitmap2, fArr, i, z, i2, i3, z2, z3);
                    }
                } else {
                    BitmapUtils bitmapUtils2 = BitmapUtils.INSTANCE;
                    context = this.this$0.context;
                    Uri uri = this.this$0.getUri();
                    fArr2 = this.this$0.cropPoints;
                    i6 = this.this$0.degreesRotated;
                    i7 = this.this$0.orgWidth;
                    i8 = this.this$0.orgHeight;
                    z4 = this.this$0.fixAspectRatio;
                    i9 = this.this$0.aspectRatioX;
                    i10 = this.this$0.aspectRatioY;
                    i11 = this.this$0.reqWidth;
                    i12 = this.this$0.reqHeight;
                    z5 = this.this$0.flipHorizontally;
                    z6 = this.this$0.flipVertically;
                    cropBitmapObjectHandleOOM = bitmapUtils2.cropBitmap(context, uri, fArr2, i6, i7, i8, z4, i9, i10, i11, i12, z5, z6);
                }
                BitmapUtils bitmapUtils3 = BitmapUtils.INSTANCE;
                Bitmap bitmap3 = cropBitmapObjectHandleOOM.getBitmap();
                i4 = this.this$0.reqWidth;
                i5 = this.this$0.reqHeight;
                requestSizeOptions = this.this$0.options;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new AnonymousClass1(this.this$0, bitmapUtils3.resizeBitmap(bitmap3, i4, i5, requestSizeOptions), cropBitmapObjectHandleOOM, null), 2, null);
            }
            return Unit.INSTANCE;
        }
        if (i13 != 1) {
            if (i13 == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapCroppingWorkerJob.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.canhub.cropper.BitmapCroppingWorkerJob$start$1$1", f = "BitmapCroppingWorkerJob.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.canhub.cropper.BitmapCroppingWorkerJob$start$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BitmapUtils.BitmapSampled $bitmapSampled;
        final /* synthetic */ Bitmap $resizedBitmap;
        int label;
        final /* synthetic */ BitmapCroppingWorkerJob this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BitmapCroppingWorkerJob bitmapCroppingWorkerJob, Bitmap bitmap, BitmapUtils.BitmapSampled bitmapSampled, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = bitmapCroppingWorkerJob;
            this.$resizedBitmap = bitmap;
            this.$bitmapSampled = bitmapSampled;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$resizedBitmap, this.$bitmapSampled, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Context context;
            Bitmap.CompressFormat compressFormat;
            int i;
            Uri uri;
            Object onPostExecute;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                BitmapUtils bitmapUtils = BitmapUtils.INSTANCE;
                context = this.this$0.context;
                Bitmap bitmap = this.$resizedBitmap;
                compressFormat = this.this$0.saveCompressFormat;
                i = this.this$0.saveCompressQuality;
                uri = this.this$0.customOutputUri;
                Uri writeBitmapToUri = bitmapUtils.writeBitmapToUri(context, bitmap, compressFormat, i, uri);
                this.$resizedBitmap.recycle();
                this.label = 1;
                onPostExecute = this.this$0.onPostExecute(new BitmapCroppingWorkerJob.Result(writeBitmapToUri, this.$bitmapSampled.getSampleSize()), this);
                if (onPostExecute == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
