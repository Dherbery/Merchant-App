package expo.modules.imagepicker;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import expo.modules.kotlin.providers.AppContextProvider;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MediaHandler.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J!\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J5\u0010\u0019\u001a\u00020\u001a2\u0018\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00100\u001d0\u001c2\u0006\u0010\u0014\u001a\u00020\u0015H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lexpo/modules/imagepicker/MediaHandler;", "", "appContextProvider", "Lexpo/modules/kotlin/providers/AppContextProvider;", "(Lexpo/modules/kotlin/providers/AppContextProvider;)V", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "getAdditionalFileData", "Lexpo/modules/imagepicker/AdditionalFileData;", "uri", "Landroid/net/Uri;", "handleImage", "Lexpo/modules/imagepicker/ImagePickerAsset;", "sourceUri", "options", "Lexpo/modules/imagepicker/ImagePickerOptions;", "(Landroid/net/Uri;Lexpo/modules/imagepicker/ImagePickerOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleVideo", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readExtras", "Lexpo/modules/imagepicker/ImagePickerResponse;", "bareResult", "", "Lkotlin/Pair;", "Lexpo/modules/imagepicker/MediaType;", "readExtras$expo_image_picker_release", "(Ljava/util/List;Lexpo/modules/imagepicker/ImagePickerOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-image-picker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MediaHandler {
    private final AppContextProvider appContextProvider;

    /* compiled from: MediaHandler.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MediaHandler(AppContextProvider appContextProvider) {
        Intrinsics.checkNotNullParameter(appContextProvider, "appContextProvider");
        this.appContextProvider = appContextProvider;
    }

    private final Context getContext() {
        Context reactContext = this.appContextProvider.getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new IllegalArgumentException("React Application Context is null".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00b5 -> B:11:0x00b8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readExtras$expo_image_picker_release(java.util.List<? extends kotlin.Pair<? extends expo.modules.imagepicker.MediaType, ? extends android.net.Uri>> r10, expo.modules.imagepicker.ImagePickerOptions r11, kotlin.coroutines.Continuation<? super expo.modules.imagepicker.ImagePickerResponse> r12) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.MediaHandler.readExtras$expo_image_picker_release(java.util.List, expo.modules.imagepicker.ImagePickerOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final File getCacheDirectory() {
        return this.appContextProvider.getAppContext().getCacheDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handleImage(android.net.Uri r28, expo.modules.imagepicker.ImagePickerOptions r29, kotlin.coroutines.Continuation<? super expo.modules.imagepicker.ImagePickerAsset> r30) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.MediaHandler.handleImage(android.net.Uri, expo.modules.imagepicker.ImagePickerOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final AdditionalFileData getAdditionalFileData(Uri uri) {
        Cursor query = getContext().getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            return null;
        }
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            int columnIndex = cursor2.getColumnIndex("_display_name");
            int columnIndex2 = cursor2.getColumnIndex("_size");
            cursor2.moveToFirst();
            AdditionalFileData additionalFileData = new AdditionalFileData(cursor2.getString(columnIndex), Long.valueOf(cursor2.getLong(columnIndex2)));
            CloseableKt.closeFinally(cursor, null);
            return additionalFileData;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursor, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a8 A[Catch: FailedToExtractVideoMetadataException -> 0x00e2, TryCatch #0 {FailedToExtractVideoMetadataException -> 0x00e2, blocks: (B:12:0x0074, B:14:0x00a8, B:16:0x00b1, B:17:0x00b5), top: B:11:0x0074 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b1 A[Catch: FailedToExtractVideoMetadataException -> 0x00e2, TryCatch #0 {FailedToExtractVideoMetadataException -> 0x00e2, blocks: (B:12:0x0074, B:14:0x00a8, B:16:0x00b1, B:17:0x00b5), top: B:11:0x0074 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handleVideo(android.net.Uri r24, kotlin.coroutines.Continuation<? super expo.modules.imagepicker.ImagePickerAsset> r25) {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            r2 = r25
            boolean r3 = r2 instanceof expo.modules.imagepicker.MediaHandler$handleVideo$1
            if (r3 == 0) goto L1a
            r3 = r2
            expo.modules.imagepicker.MediaHandler$handleVideo$1 r3 = (expo.modules.imagepicker.MediaHandler$handleVideo$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L1a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L1f
        L1a:
            expo.modules.imagepicker.MediaHandler$handleVideo$1 r3 = new expo.modules.imagepicker.MediaHandler$handleVideo$1
            r3.<init>(r1, r2)
        L1f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            java.lang.String r6 = "context.contentResolver"
            r7 = 1
            if (r5 == 0) goto L48
            if (r5 != r7) goto L40
            java.lang.Object r0 = r3.L$2
            java.io.File r0 = (java.io.File) r0
            java.lang.Object r4 = r3.L$1
            android.net.Uri r4 = (android.net.Uri) r4
            java.lang.Object r3 = r3.L$0
            expo.modules.imagepicker.MediaHandler r3 = (expo.modules.imagepicker.MediaHandler) r3
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            r0 = r4
            goto L70
        L40:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L48:
            kotlin.ResultKt.throwOnFailure(r2)
            java.io.File r2 = r23.getCacheDirectory()
            java.lang.String r5 = ".mp4"
            java.io.File r2 = expo.modules.imagepicker.ImagePickerUtilsKt.createOutputFile(r2, r5)
            android.content.Context r5 = r23.getContext()
            android.content.ContentResolver r5 = r5.getContentResolver()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r3.L$0 = r1
            r3.L$1 = r0
            r3.L$2 = r2
            r3.label = r7
            java.lang.Object r3 = expo.modules.imagepicker.ImagePickerUtilsKt.copyFile(r0, r2, r5, r3)
            if (r3 != r4) goto L6f
            return r4
        L6f:
            r3 = r1
        L70:
            android.net.Uri r4 = android.net.Uri.fromFile(r2)
            android.media.MediaMetadataRetriever r5 = new android.media.MediaMetadataRetriever     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            r5.<init>()     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            android.content.Context r7 = r3.getContext()     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            r5.setDataSource(r7, r4)     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            expo.modules.imagepicker.AdditionalFileData r7 = r3.getAdditionalFileData(r0)     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            android.content.Context r3 = r3.getContext()     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            java.lang.String r16 = expo.modules.imagepicker.ImagePickerUtilsKt.getType(r3, r0)     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            expo.modules.imagepicker.MediaType r10 = expo.modules.imagepicker.MediaType.VIDEO     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            java.lang.String r11 = r4.toString()     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            r3 = 18
            int r12 = expo.modules.imagepicker.ImagePickerUtilsKt.extractInt(r5, r3)     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            r3 = 19
            int r13 = expo.modules.imagepicker.ImagePickerUtilsKt.extractInt(r5, r3)     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            r3 = 0
            if (r7 == 0) goto Lae
            java.lang.String r4 = r7.getFileName()     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            r14 = r4
            goto Laf
        Lae:
            r14 = r3
        Laf:
            if (r7 == 0) goto Lb5
            java.lang.Long r3 = r7.getFilesize()     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
        Lb5:
            r15 = r3
            r3 = 9
            int r3 = expo.modules.imagepicker.ImagePickerUtilsKt.extractInt(r5, r3)     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            r4 = 24
            int r4 = expo.modules.imagepicker.ImagePickerUtilsKt.extractInt(r5, r4)     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            java.lang.String r9 = expo.modules.imagepicker.ImagePickerUtilsKt.getMediaStoreAssetId(r0)     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            expo.modules.imagepicker.ImagePickerAsset r0 = new expo.modules.imagepicker.ImagePickerAsset     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            java.lang.String r5 = "toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r5)     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            r17 = 0
            r18 = 0
            java.lang.Integer r19 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            java.lang.Integer r20 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            r21 = 768(0x300, float:1.076E-42)
            r22 = 0
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)     // Catch: expo.modules.imagepicker.FailedToExtractVideoMetadataException -> Le2
            return r0
        Le2:
            r0 = move-exception
            expo.modules.imagepicker.FailedToExtractVideoMetadataException r3 = new expo.modules.imagepicker.FailedToExtractVideoMetadataException
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r3.<init>(r2, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.MediaHandler.handleVideo(android.net.Uri, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
