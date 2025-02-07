package expo.modules.imagepicker.contracts;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import expo.modules.imagepicker.ImagePickerUtilsKt;
import expo.modules.imagepicker.MediaTypes;
import expo.modules.imagepicker.contracts.ImagePickerContractResult;
import expo.modules.kotlin.activityresult.AppContextActivityResultContract;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.providers.AppContextProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageLibraryContract.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\"\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lexpo/modules/imagepicker/contracts/ImageLibraryContract;", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "Lexpo/modules/imagepicker/contracts/ImageLibraryContractOptions;", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;", "appContextProvider", "Lexpo/modules/kotlin/providers/AppContextProvider;", "(Lexpo/modules/kotlin/providers/AppContextProvider;)V", "contentResolver", "Landroid/content/ContentResolver;", "getContentResolver", "()Landroid/content/ContentResolver;", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "expo-image-picker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageLibraryContract implements AppContextActivityResultContract<ImageLibraryContractOptions, ImagePickerContractResult> {
    private final AppContextProvider appContextProvider;

    /* compiled from: ImageLibraryContract.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaTypes.values().length];
            try {
                iArr[MediaTypes.VIDEOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaTypes.IMAGES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ImageLibraryContract(AppContextProvider appContextProvider) {
        Intrinsics.checkNotNullParameter(appContextProvider, "appContextProvider");
        this.appContextProvider = appContextProvider;
    }

    private final ContentResolver getContentResolver() {
        Context reactContext = this.appContextProvider.getAppContext().getReactContext();
        ContentResolver contentResolver = reactContext != null ? reactContext.getContentResolver() : null;
        if (contentResolver != null) {
            return contentResolver;
        }
        throw new Exceptions.ReactContextLost();
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public Intent createIntent(Context context, ImageLibraryContractOptions input) {
        ActivityResultContracts.PickVisualMedia.VideoOnly videoOnly;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        PickVisualMediaRequest.Builder builder = new PickVisualMediaRequest.Builder();
        int i = WhenMappings.$EnumSwitchMapping$0[input.getOptions().getMediaTypes().ordinal()];
        if (i == 1) {
            videoOnly = ActivityResultContracts.PickVisualMedia.VideoOnly.INSTANCE;
        } else if (i == 2) {
            videoOnly = ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE;
        } else {
            videoOnly = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        PickVisualMediaRequest build = builder.setMediaType(videoOnly).build();
        if (input.getOptions().getAllowsMultipleSelection()) {
            int selectionLimit = input.getOptions().getSelectionLimit();
            if (selectionLimit == 1) {
                return new ActivityResultContracts.PickVisualMedia().createIntent(context, build);
            }
            if (selectionLimit > 1) {
                return new ActivityResultContracts.PickMultipleVisualMedia(selectionLimit).createIntent(context, build);
            }
            if (selectionLimit == 0) {
                return new ActivityResultContracts.PickMultipleVisualMedia(0, 1, null).createIntent(context, build);
            }
        }
        return new ActivityResultContracts.PickVisualMedia().createIntent(context, build);
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public ImagePickerContractResult parseResult(ImageLibraryContractOptions input, int resultCode, Intent intent) {
        List<Uri> allDataUris;
        ImagePickerContractResult imagePickerContractResult;
        Intrinsics.checkNotNullParameter(input, "input");
        if (resultCode == 0) {
            return ImagePickerContractResult.Cancelled.INSTANCE;
        }
        if (intent != null) {
            ImagePickerContractResult imagePickerContractResult2 = null;
            Intent intent2 = resultCode == -1 ? intent : null;
            if (intent2 != null && (allDataUris = ImagePickerUtilsKt.getAllDataUris(intent2)) != null) {
                if (input.getOptions().getAllowsMultipleSelection()) {
                    List<Uri> list = allDataUris;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (Uri uri : list) {
                        arrayList.add(TuplesKt.to(ImagePickerUtilsKt.toMediaType(uri, getContentResolver()), uri));
                    }
                    imagePickerContractResult = new ImagePickerContractResult.Success(arrayList);
                } else if (intent.getData() != null) {
                    Uri uri2 = intent.getData();
                    if (uri2 != null) {
                        Intrinsics.checkNotNullExpressionValue(uri2, "uri");
                        imagePickerContractResult2 = new ImagePickerContractResult.Success(CollectionsKt.listOf(TuplesKt.to(ImagePickerUtilsKt.toMediaType(uri2, getContentResolver()), uri2)));
                    }
                    imagePickerContractResult = imagePickerContractResult2;
                } else {
                    Uri uri3 = (Uri) CollectionsKt.firstOrNull((List) allDataUris);
                    if (uri3 != null) {
                        imagePickerContractResult = new ImagePickerContractResult.Success(CollectionsKt.listOf(TuplesKt.to(ImagePickerUtilsKt.toMediaType(uri3, getContentResolver()), uri3)));
                    } else {
                        imagePickerContractResult = ImagePickerContractResult.Error.INSTANCE;
                    }
                }
                if (imagePickerContractResult != null) {
                    return imagePickerContractResult;
                }
            }
        }
        return ImagePickerContractResult.Error.INSTANCE;
    }
}
