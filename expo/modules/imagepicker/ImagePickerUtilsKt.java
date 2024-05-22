package expo.modules.imagepicker;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import androidx.core.net.UriKt;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import expo.modules.core.utilities.FileUtilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.InterruptibleKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: ImagePickerUtils.kt */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a)\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0002H\u0000\u001a\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020\u001eH\u0000\u001a\u0012\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"*\u00020#H\u0000\u001a\u000e\u0010$\u001a\u0004\u0018\u00010\u0018*\u00020\u0002H\u0000\u001a\f\u0010%\u001a\u00020&*\u00020\u0010H\u0000\u001a\f\u0010%\u001a\u00020&*\u00020\u0018H\u0000\u001a\u0014\u0010'\u001a\u00020\u0002*\u00020\u00102\u0006\u0010(\u001a\u00020)H\u0000\u001a\f\u0010*\u001a\u00020\u0018*\u00020&H\u0000\u001a\f\u0010*\u001a\u00020\u0018*\u00020\u0018H\u0000\u001a\u0014\u0010+\u001a\u00020,*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"isDownloadsProviderUri", "", "Landroid/net/Uri;", "(Landroid/net/Uri;)Z", "isMediaProviderUri", "isMediaStoreAssetUri", "items", "", "Landroid/content/ClipData$Item;", "Landroid/content/ClipData;", "getItems", "(Landroid/content/ClipData;)Ljava/lang/Iterable;", "copyExifData", "", "sourceUri", "targetFile", "Ljava/io/File;", "contentResolver", "Landroid/content/ContentResolver;", "(Landroid/net/Uri;Ljava/io/File;Landroid/content/ContentResolver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyFile", "createOutputFile", "cacheDir", "extension", "", "getType", "uri", "getTypeFromFileUrl", ImagesContract.URL, "extractInt", "", "Landroid/media/MediaMetadataRetriever;", SubscriberAttributeKt.JSON_NAME_KEY, "getAllDataUris", "", "Landroid/content/Intent;", "getMediaStoreAssetId", "toBitmapCompressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "toContentUri", "context", "Landroid/content/Context;", "toImageFileExtension", "toMediaType", "Lexpo/modules/imagepicker/MediaType;", "expo-image-picker_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImagePickerUtilsKt {

    /* compiled from: ImagePickerUtils.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Bitmap.CompressFormat.JPEG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final File createOutputFile(File cacheDir, String extension) {
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        Intrinsics.checkNotNullParameter(extension, "extension");
        String filePath = FileUtilities.generateOutputPath(cacheDir, ImagePickerConstants.CACHE_DIR_NAME, extension);
        try {
            File file = new File(filePath);
            file.createNewFile();
            return file;
        } catch (IOException e) {
            Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
            throw new FailedToCreateFileException(filePath, e);
        }
    }

    public static final String getType(ContentResolver contentResolver, Uri uri) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String type = contentResolver.getType(uri);
        if (type == null) {
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            type = getTypeFromFileUrl(uri2);
        }
        if (type != null) {
            return type;
        }
        throw new FailedToDeduceTypeException();
    }

    private static final String getTypeFromFileUrl(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public static final Uri toContentUri(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".ImagePickerFileProvider", file);
            Intrinsics.checkNotNullExpressionValue(uriForFile, "{\n    FileProvider.getUr…rFileProvider\", this)\n  }");
            return uriForFile;
        } catch (Exception unused) {
            Uri fromFile = Uri.fromFile(file);
            Intrinsics.checkNotNullExpressionValue(fromFile, "{\n    Uri.fromFile(this)\n  }");
            return fromFile;
        }
    }

    public static final Bitmap.CompressFormat toBitmapCompressFormat(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return StringsKt.endsWith(FilesKt.getExtension(file), "png", true) ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    public static final String toImageFileExtension(Bitmap.CompressFormat compressFormat) {
        Intrinsics.checkNotNullParameter(compressFormat, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[compressFormat.ordinal()];
        if (i == 1) {
            return ".png";
        }
        if (i == 2) {
            return ".jpeg";
        }
        throw new RuntimeException("Compress format not supported '" + compressFormat.name() + "'");
    }

    public static final String toImageFileExtension(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.endsWith(str, "png", true)) {
            return ".png";
        }
        if (StringsKt.endsWith(str, "gif", true)) {
            return ".gif";
        }
        if (StringsKt.endsWith(str, "bmp", true)) {
            return ".bmp";
        }
        if (!StringsKt.endsWith(str, "jpeg", true)) {
            Log.w(ImagePickerConstants.TAG, "Image file " + str + " is of unsupported type. Falling back to JPEG instead.");
        }
        return ".jpeg";
    }

    public static final MediaType toMediaType(Uri uri, ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        String type = getType(contentResolver, uri);
        if (StringsKt.contains$default((CharSequence) type, (CharSequence) "image/", false, 2, (Object) null)) {
            return MediaType.IMAGE;
        }
        if (StringsKt.contains$default((CharSequence) type, (CharSequence) "video/", false, 2, (Object) null)) {
            return MediaType.VIDEO;
        }
        throw new FailedToDeduceTypeException();
    }

    public static final Bitmap.CompressFormat toBitmapCompressFormat(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.endsWith(str, "png", true) || StringsKt.endsWith(str, "gif", true) || StringsKt.endsWith(str, "bmp", true)) {
            return Bitmap.CompressFormat.PNG;
        }
        if (!StringsKt.endsWith(str, "jpeg", true)) {
            Log.w(ImagePickerConstants.TAG, "Image file " + str + " is of unsupported type. Falling back to JPEG instead.");
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public static final int extractInt(MediaMetadataRetriever mediaMetadataRetriever, int i) {
        Intrinsics.checkNotNullParameter(mediaMetadataRetriever, "<this>");
        String extractMetadata = mediaMetadataRetriever.extractMetadata(i);
        if (extractMetadata != null) {
            return Integer.parseInt(extractMetadata);
        }
        throw new FailedToExtractVideoMetadataException(null, null, 3, null);
    }

    public static final Iterable<ClipData.Item> getItems(ClipData clipData) {
        Intrinsics.checkNotNullParameter(clipData, "<this>");
        return new ImagePickerUtilsKt$items$1(clipData);
    }

    public static final List<Uri> getAllDataUris(Intent intent) {
        Iterable<ClipData.Item> items;
        Intrinsics.checkNotNullParameter(intent, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Uri data = intent.getData();
        if (data != null) {
            linkedHashSet.add(data);
        }
        ClipData clipData = intent.getClipData();
        if (clipData != null && (items = getItems(clipData)) != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            Iterator<ClipData.Item> it = items.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getUri());
            }
            linkedHashSet.addAll(arrayList);
        }
        return CollectionsKt.toList(linkedHashSet);
    }

    public static final Object copyFile(final Uri uri, final File file, final ContentResolver contentResolver, Continuation<? super Unit> continuation) {
        Object runInterruptible$default = InterruptibleKt.runInterruptible$default(null, new Function0<Unit>() { // from class: expo.modules.imagepicker.ImagePickerUtilsKt$copyFile$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (uri.compareTo(Uri.fromFile(file)) == 0) {
                    return;
                }
                try {
                    InputStream openInputStream = contentResolver.openInputStream(uri);
                    if (openInputStream != null) {
                        FileOutputStream fileOutputStream = openInputStream;
                        try {
                            InputStream inputStream = fileOutputStream;
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
                                CloseableKt.closeFinally(fileOutputStream, null);
                                CloseableKt.closeFinally(fileOutputStream, null);
                            } finally {
                            }
                        } finally {
                        }
                    } else {
                        throw new FailedToReadFileException(UriKt.toFile(uri), null, 2, null);
                    }
                } catch (FileNotFoundException e) {
                    throw new FailedToWriteFileException(file, e);
                }
            }
        }, continuation, 1, null);
        return runInterruptible$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? runInterruptible$default : Unit.INSTANCE;
    }

    public static final Object copyExifData(final Uri uri, final File file, final ContentResolver contentResolver, Continuation<? super Unit> continuation) {
        Object runInterruptible$default = InterruptibleKt.runInterruptible$default(null, new Function0<Unit>() { // from class: expo.modules.imagepicker.ImagePickerUtilsKt$copyExifData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Unit unit;
                if (uri.compareTo(Uri.fromFile(file)) == 0) {
                    return;
                }
                List listOf = CollectionsKt.listOf((Object[]) new String[]{ExifInterface.TAG_IMAGE_LENGTH, ExifInterface.TAG_IMAGE_WIDTH, ExifInterface.TAG_PIXEL_X_DIMENSION, ExifInterface.TAG_PIXEL_Y_DIMENSION, ExifInterface.TAG_ORIENTATION});
                try {
                    InputStream openInputStream = contentResolver.openInputStream(uri);
                    if (openInputStream != null) {
                        InputStream inputStream = openInputStream;
                        File file2 = file;
                        try {
                            ExifInterface exifInterface = new ExifInterface(inputStream);
                            ExifInterface exifInterface2 = new ExifInterface(file2);
                            Iterable<Pair<String, String>> exif_tags = ImagePickerConstants.INSTANCE.getEXIF_TAGS();
                            ArrayList arrayList = new ArrayList();
                            for (Pair<String, String> pair : exif_tags) {
                                if (true ^ listOf.contains(pair.component2())) {
                                    arrayList.add(pair);
                                }
                            }
                            ArrayList arrayList2 = arrayList;
                            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                String str = (String) ((Pair) it.next()).component2();
                                arrayList3.add(TuplesKt.to(str, exifInterface.getAttribute(str)));
                            }
                            ArrayList<Pair> arrayList4 = new ArrayList();
                            for (Object obj : arrayList3) {
                                if (((String) ((Pair) obj).component2()) != null) {
                                    arrayList4.add(obj);
                                }
                            }
                            for (Pair pair2 : arrayList4) {
                                exifInterface2.setAttribute((String) pair2.component1(), (String) pair2.component2());
                            }
                            try {
                                exifInterface2.saveAttributes();
                                Unit unit2 = Unit.INSTANCE;
                                CloseableKt.closeFinally(inputStream, null);
                                unit = Unit.INSTANCE;
                            } catch (IOException e) {
                                throw new FailedToWriteExifDataToFileException(file2, e);
                            }
                        } finally {
                        }
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        throw new FailedToReadFileException(UriKt.toFile(uri), null, 2, null);
                    }
                } catch (FileNotFoundException e2) {
                    throw new FailedToWriteFileException(file, e2);
                }
            }
        }, continuation, 1, null);
        return runInterruptible$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? runInterruptible$default : Unit.INSTANCE;
    }

    public static final boolean isMediaProviderUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual(uri.getAuthority(), "com.android.providers.media.documents");
    }

    public static final boolean isDownloadsProviderUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual(uri.getAuthority(), "com.android.providers.downloads.documents");
    }

    public static final boolean isMediaStoreAssetUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        if (!isMediaProviderUri(uri)) {
            if (!isDownloadsProviderUri(uri)) {
                return false;
            }
            String documentId = DocumentsContract.getDocumentId(uri);
            Intrinsics.checkNotNullExpressionValue(documentId, "getDocumentId(this)");
            if (!StringsKt.startsWith$default(documentId, "msf:", false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    public static final String getMediaStoreAssetId(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        if (!isMediaStoreAssetUri(uri)) {
            return null;
        }
        String rawId = DocumentsContract.getDocumentId(uri);
        Intrinsics.checkNotNullExpressionValue(rawId, "rawId");
        String str = rawId;
        return StringsKt.contains$default((CharSequence) str, AbstractJsonLexerKt.COLON, false, 2, (Object) null) ? (String) StringsKt.split$default((CharSequence) str, new char[]{AbstractJsonLexerKt.COLON}, false, 0, 6, (Object) null).get(1) : rawId;
    }
}
