package com.reactnativeimageresizer;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes5.dex */
public class ImageResizerModule extends ImageResizerSpec {
    public static final String NAME = "ImageResizer";

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageResizerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* JADX WARN: Type inference failed for: r15v0, types: [com.reactnativeimageresizer.ImageResizerModule$1] */
    @Override // com.reactnativeimageresizer.ImageResizerSpec
    @ReactMethod
    public void createResizedImage(final String str, final double d, final double d2, final String str2, final double d3, String str3, boolean z, final Double d4, final String str4, final Boolean bool, final Promise promise) {
        final WritableMap createMap = Arguments.createMap();
        createMap.putString("mode", str3);
        createMap.putBoolean("onlyScaleDown", z);
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativeimageresizer.ImageResizerModule.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void... voidArr) {
                try {
                    promise.resolve(ImageResizerModule.this.createResizedImageWithExceptions(str, (int) d, (int) d2, str2, (int) d3, d4.intValue(), str4, bool.booleanValue(), createMap));
                } catch (IOException e) {
                    promise.reject(e);
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object createResizedImageWithExceptions(String str, int i, int i2, String str2, int i3, int i4, String str3, boolean z, ReadableMap readableMap) throws IOException {
        Bitmap.CompressFormat valueOf = Bitmap.CompressFormat.valueOf(str2);
        Uri parse = Uri.parse(str);
        Bitmap createResizedImage = ImageResizer.createResizedImage(getReactApplicationContext(), parse, i, i2, i3, i4, readableMap.getString("mode"), readableMap.getBoolean("onlyScaleDown"));
        if (createResizedImage == null) {
            throw new IOException("The image failed to be resized; invalid Bitmap result.");
        }
        File cacheDir = getReactApplicationContext().getCacheDir();
        if (str3 != null) {
            cacheDir = new File(str3);
        }
        File saveImage = ImageResizer.saveImage(createResizedImage, cacheDir, UUID.randomUUID().toString(), valueOf, i3);
        WritableMap createMap = Arguments.createMap();
        if (saveImage.isFile()) {
            createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, saveImage.getAbsolutePath());
            createMap.putString("uri", Uri.fromFile(saveImage).toString());
            createMap.putString("name", saveImage.getName());
            createMap.putDouble("size", saveImage.length());
            createMap.putDouble("width", createResizedImage.getWidth());
            createMap.putDouble("height", createResizedImage.getHeight());
            if (z) {
                try {
                    ImageResizer.copyExif(getReactApplicationContext(), parse, saveImage.getAbsolutePath());
                } catch (Exception e) {
                    Log.e("ImageResizer::createResizedImageWithExceptions", "EXIF copy failed", e);
                }
            }
            createResizedImage.recycle();
            return createMap;
        }
        throw new IOException("Error getting resized image path");
    }
}
