package com.mrousavy.camera.core;

import android.media.Image;
import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.mrousavy.camera.core.CameraConfiguration;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.types.CodeType;
import com.mrousavy.camera.types.Orientation;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: CodeScannerPipeline.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/mrousavy/camera/core/CodeScannerPipeline;", "Ljava/io/Closeable;", "size", "Landroid/util/Size;", "format", "", "configuration", "Lcom/mrousavy/camera/core/CameraConfiguration$CodeScanner;", "callback", "Lcom/mrousavy/camera/core/CameraSession$Callback;", "(Landroid/util/Size;ILcom/mrousavy/camera/core/CameraConfiguration$CodeScanner;Lcom/mrousavy/camera/core/CameraSession$Callback;)V", "getCallback", "()Lcom/mrousavy/camera/core/CameraSession$Callback;", "getConfiguration", "()Lcom/mrousavy/camera/core/CameraConfiguration$CodeScanner;", "getFormat", "()I", "imageReader", "Landroid/media/ImageReader;", "scanner", "Lcom/google/mlkit/vision/barcode/BarcodeScanner;", "getSize", "()Landroid/util/Size;", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "close", "", "toString", "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CodeScannerPipeline implements Closeable {
    private static final int MAX_IMAGES = 2;
    private final CameraSession.Callback callback;
    private final CameraConfiguration.CodeScanner configuration;
    private final int format;
    private final ImageReader imageReader;
    private final BarcodeScanner scanner;
    private final Size size;

    public CodeScannerPipeline(Size size, int i, CameraConfiguration.CodeScanner configuration, CameraSession.Callback callback) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.size = size;
        this.format = i;
        this.configuration = configuration;
        this.callback = callback;
        List<CodeType> codeTypes = configuration.getCodeTypes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(codeTypes, 10));
        Iterator<T> it = codeTypes.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((CodeType) it.next()).toBarcodeType()));
        }
        ArrayList arrayList2 = arrayList;
        BarcodeScannerOptions.Builder builder = new BarcodeScannerOptions.Builder();
        int intValue = ((Number) arrayList2.get(0)).intValue();
        int[] intArray = CollectionsKt.toIntArray(arrayList2);
        BarcodeScannerOptions build = builder.setBarcodeFormats(intValue, Arrays.copyOf(intArray, intArray.length)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n      .setBarc…ntArray())\n      .build()");
        BarcodeScanner client = BarcodeScanning.getClient(build);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(barcodeScannerOptions)");
        this.scanner = client;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        ImageReader newInstance = ImageReader.newInstance(this.size.getWidth(), this.size.getHeight(), this.format, 2);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(size.width, …ight, format, MAX_IMAGES)");
        this.imageReader = newInstance;
        newInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$$ExternalSyntheticLambda0
            @Override // android.media.ImageReader.OnImageAvailableListener
            public final void onImageAvailable(ImageReader imageReader) {
                CodeScannerPipeline._init_$lambda$4(Ref.BooleanRef.this, this, imageReader);
            }
        }, CameraQueues.INSTANCE.getVideoQueue().getHandler());
    }

    public final Size getSize() {
        return this.size;
    }

    public final int getFormat() {
        return this.format;
    }

    public final CameraConfiguration.CodeScanner getConfiguration() {
        return this.configuration;
    }

    public final CameraSession.Callback getCallback() {
        return this.callback;
    }

    public final Surface getSurface() {
        Surface surface = this.imageReader.getSurface();
        Intrinsics.checkNotNullExpressionValue(surface, "imageReader.surface");
        return surface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(final Ref.BooleanRef isBusy, final CodeScannerPipeline this$0, ImageReader imageReader) {
        Intrinsics.checkNotNullParameter(isBusy, "$isBusy");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Image acquireLatestImage = imageReader.acquireLatestImage();
        if (acquireLatestImage == null) {
            return;
        }
        if (isBusy.element) {
            acquireLatestImage.close();
            return;
        }
        isBusy.element = true;
        final InputImage fromMediaImage = InputImage.fromMediaImage(acquireLatestImage, Orientation.PORTRAIT.toDegrees());
        Intrinsics.checkNotNullExpressionValue(fromMediaImage, "fromMediaImage(image, Or…ion.PORTRAIT.toDegrees())");
        Task<List<Barcode>> process = this$0.scanner.process(fromMediaImage);
        final Function1<List<Barcode>, Unit> function1 = new Function1<List<Barcode>, Unit>() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<Barcode> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Barcode> barcodes) {
                Intrinsics.checkNotNullExpressionValue(barcodes, "barcodes");
                if (!barcodes.isEmpty()) {
                    CodeScannerPipeline.this.getCallback().onCodeScanned(barcodes, new CodeScannerFrame(fromMediaImage.getWidth(), fromMediaImage.getHeight()));
                }
            }
        };
        process.addOnSuccessListener(new OnSuccessListener() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                CodeScannerPipeline.lambda$4$lambda$1(Function1.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                CodeScannerPipeline.lambda$4$lambda$2(CodeScannerPipeline.this, exc);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                CodeScannerPipeline.lambda$4$lambda$3(acquireLatestImage, isBusy, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$4$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$4$lambda$2(CodeScannerPipeline this$0, Exception error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "error");
        this$0.callback.onError(error);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$4$lambda$3(Image image, Ref.BooleanRef isBusy, Task it) {
        Intrinsics.checkNotNullParameter(image, "$image");
        Intrinsics.checkNotNullParameter(isBusy, "$isBusy");
        Intrinsics.checkNotNullParameter(it, "it");
        image.close();
        isBusy.element = false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.imageReader.close();
        this.scanner.close();
    }

    public String toString() {
        String joinToString$default = CollectionsKt.joinToString$default(this.configuration.getCodeTypes(), ", ", null, null, 0, null, null, 62, null);
        return this.size.getWidth() + " x " + this.size.getHeight() + " CodeScanner for [" + joinToString$default + "] (" + this.format + ")";
    }
}
