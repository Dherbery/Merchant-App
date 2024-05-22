package expo.modules.imagepicker.contracts;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.core.os.BundleKt;
import com.canhub.cropper.CropImage;
import com.canhub.cropper.CropImageActivity;
import com.canhub.cropper.CropImageOptions;
import expo.modules.imagepicker.ImagePickerUtilsKt;
import expo.modules.imagepicker.MediaType;
import expo.modules.imagepicker.contracts.ImagePickerContractResult;
import expo.modules.kotlin.activityresult.AppContextActivityResultContract;
import expo.modules.kotlin.providers.AppContextProvider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* compiled from: CropImageContract.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/imagepicker/contracts/CropImageContract;", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "Lexpo/modules/imagepicker/contracts/CropImageContractOptions;", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;", "appContextProvider", "Lexpo/modules/kotlin/providers/AppContextProvider;", "(Lexpo/modules/kotlin/providers/AppContextProvider;)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "expo-image-picker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CropImageContract implements AppContextActivityResultContract<CropImageContractOptions, ImagePickerContractResult> {
    private final AppContextProvider appContextProvider;

    public CropImageContract(AppContextProvider appContextProvider) {
        Intrinsics.checkNotNullParameter(appContextProvider, "appContextProvider");
        this.appContextProvider = appContextProvider;
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public Intent createIntent(Context context, CropImageContractOptions input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        Intent intent = new Intent(context, (Class<?>) CropImageActivity.class);
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
        Bitmap.CompressFormat bitmapCompressFormat = ImagePickerUtilsKt.toBitmapCompressFormat(ImagePickerUtilsKt.getType(contentResolver, Uri.parse(input.getSourceUri())));
        Uri fromFile = Uri.fromFile(ImagePickerUtilsKt.createOutputFile(this.appContextProvider.getAppContext().getCacheDirectory(), ImagePickerUtilsKt.toImageFileExtension(bitmapCompressFormat)));
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(CropImage.CROP_IMAGE_EXTRA_SOURCE, Uri.parse(input.getSourceUri()));
        CropImageOptions cropImageOptions = new CropImageOptions();
        cropImageOptions.outputCompressFormat = bitmapCompressFormat;
        cropImageOptions.outputCompressQuality = (int) (input.getOptions().getQuality() * 100);
        cropImageOptions.customOutputUri = fromFile;
        Pair<Integer, Integer> aspect = input.getOptions().getAspect();
        if (aspect != null) {
            int intValue = aspect.component1().intValue();
            int intValue2 = aspect.component2().intValue();
            cropImageOptions.aspectRatioX = intValue;
            cropImageOptions.aspectRatioY = intValue2;
            cropImageOptions.fixAspectRatio = true;
            cropImageOptions.initialCropWindowPaddingRatio = 0.0f;
        }
        Unit unit = Unit.INSTANCE;
        pairArr[1] = TuplesKt.to(CropImage.CROP_IMAGE_EXTRA_OPTIONS, cropImageOptions);
        intent.putExtra(CropImage.CROP_IMAGE_EXTRA_BUNDLE, BundleKt.bundleOf(pairArr));
        return intent;
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public ImagePickerContractResult parseResult(CropImageContractOptions input, int resultCode, Intent intent) {
        CropImage.ActivityResult activityResult;
        Object parcelableExtra;
        Intrinsics.checkNotNullParameter(input, "input");
        if (Build.VERSION.SDK_INT >= 33) {
            if (intent != null) {
                parcelableExtra = intent.getParcelableExtra(CropImage.CROP_IMAGE_EXTRA_RESULT, CropImage.ActivityResult.class);
                activityResult = (CropImage.ActivityResult) parcelableExtra;
            }
            activityResult = null;
        } else {
            if (intent != null) {
                activityResult = (CropImage.ActivityResult) intent.getParcelableExtra(CropImage.CROP_IMAGE_EXTRA_RESULT);
            }
            activityResult = null;
        }
        if (resultCode == 0 || activityResult == null) {
            return ImagePickerContractResult.Cancelled.INSTANCE;
        }
        Uri uriContent = activityResult.getUriContent();
        if (uriContent == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        Context reactContext = this.appContextProvider.getAppContext().getReactContext();
        if (reactContext != null) {
            BuildersKt__BuildersKt.runBlocking$default(null, new CropImageContract$parseResult$1(input, uriContent, reactContext.getContentResolver(), null), 1, null);
            return new ImagePickerContractResult.Success(CollectionsKt.listOf(TuplesKt.to(MediaType.IMAGE, uriContent)));
        }
        throw new IllegalArgumentException("React Application Context is null".toString());
    }
}
