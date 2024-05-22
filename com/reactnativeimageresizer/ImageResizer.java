package com.reactnativeimageresizer;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imagepipeline.common.RotationOptions;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;

/* loaded from: classes5.dex */
public class ImageResizer {
    private static final String[] EXIF_TO_COPY_ROTATED = {ExifInterface.TAG_APERTURE_VALUE, ExifInterface.TAG_MAX_APERTURE_VALUE, ExifInterface.TAG_METERING_MODE, ExifInterface.TAG_ARTIST, ExifInterface.TAG_BITS_PER_SAMPLE, ExifInterface.TAG_COMPRESSION, ExifInterface.TAG_BODY_SERIAL_NUMBER, ExifInterface.TAG_BRIGHTNESS_VALUE, ExifInterface.TAG_CONTRAST, "CameraOwnerName", ExifInterface.TAG_COLOR_SPACE, ExifInterface.TAG_COPYRIGHT, ExifInterface.TAG_DATETIME, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_DATETIME_ORIGINAL, ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION, ExifInterface.TAG_DIGITAL_ZOOM_RATIO, ExifInterface.TAG_EXIF_VERSION, ExifInterface.TAG_EXPOSURE_BIAS_VALUE, ExifInterface.TAG_EXPOSURE_INDEX, ExifInterface.TAG_EXPOSURE_MODE, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_EXPOSURE_PROGRAM, ExifInterface.TAG_FLASH, ExifInterface.TAG_FLASH_ENERGY, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM, ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION, ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION, ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, ExifInterface.TAG_PLANAR_CONFIGURATION, ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_GAIN_CONTROL, ExifInterface.TAG_GAMMA, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_AREA_INFORMATION, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_DOP, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_STATUS, ExifInterface.TAG_GPS_DEST_BEARING, ExifInterface.TAG_GPS_DEST_BEARING_REF, ExifInterface.TAG_GPS_DEST_DISTANCE, ExifInterface.TAG_GPS_DEST_DISTANCE_REF, ExifInterface.TAG_GPS_DEST_LATITUDE, ExifInterface.TAG_GPS_DEST_LATITUDE_REF, ExifInterface.TAG_GPS_DEST_LONGITUDE, ExifInterface.TAG_GPS_DEST_LONGITUDE_REF, ExifInterface.TAG_GPS_DIFFERENTIAL, ExifInterface.TAG_GPS_IMG_DIRECTION, ExifInterface.TAG_GPS_IMG_DIRECTION_REF, ExifInterface.TAG_GPS_MAP_DATUM, ExifInterface.TAG_GPS_MEASURE_MODE, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_SATELLITES, ExifInterface.TAG_GPS_SPEED, ExifInterface.TAG_GPS_SPEED_REF, ExifInterface.TAG_GPS_STATUS, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_GPS_TRACK, ExifInterface.TAG_GPS_TRACK_REF, ExifInterface.TAG_GPS_VERSION_ID, ExifInterface.TAG_IMAGE_DESCRIPTION, ExifInterface.TAG_IMAGE_UNIQUE_ID, ExifInterface.TAG_ISO_SPEED, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ExifInterface.TAG_LENS_MAKE, ExifInterface.TAG_LENS_MODEL, ExifInterface.TAG_LENS_SERIAL_NUMBER, ExifInterface.TAG_LENS_SPECIFICATION, ExifInterface.TAG_LIGHT_SOURCE, ExifInterface.TAG_MAKE, ExifInterface.TAG_MAKER_NOTE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SATURATION, ExifInterface.TAG_SHARPNESS, ExifInterface.TAG_SHUTTER_SPEED_VALUE, ExifInterface.TAG_SOFTWARE, ExifInterface.TAG_SUBJECT_DISTANCE, ExifInterface.TAG_SUBJECT_DISTANCE_RANGE, ExifInterface.TAG_SUBJECT_LOCATION, ExifInterface.TAG_USER_COMMENT, ExifInterface.TAG_WHITE_BALANCE};
    private static final String IMAGE_JPEG = "image/jpeg";
    private static final String IMAGE_PNG = "image/png";
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_DATA = "data";
    private static final String SCHEME_FILE = "file";
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";

    private static Bitmap resizeImage(Bitmap bitmap, int i, int i2, String str, boolean z) {
        float min;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i2 <= 0 || i <= 0) {
            return null;
        }
        if (!str.equals("stretch")) {
            float f = width;
            float f2 = i / f;
            float f3 = height;
            float f4 = i2 / f3;
            if (str.equals("cover")) {
                min = Math.max(f2, f4);
            } else {
                min = Math.min(f2, f4);
            }
            if (z) {
                min = Math.min(min, 1.0f);
            }
            int round = Math.round(f * min);
            i2 = Math.round(f3 * min);
            i = round;
        } else if (z) {
            i = Math.min(width, i);
            i2 = Math.min(height, i2);
        }
        try {
            return Bitmap.createScaledBitmap(bitmap, i, i2, true);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static Bitmap rotateImage(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static File saveImage(Bitmap bitmap, File file, String str, Bitmap.CompressFormat compressFormat, int i) throws IOException {
        if (bitmap == null) {
            throw new IOException("The bitmap couldn't be resized");
        }
        File file2 = new File(file, str + "." + compressFormat.name());
        if (!file2.createNewFile()) {
            throw new IOException("The file already exists");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, i, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(byteArray);
        fileOutputStream.flush();
        fileOutputStream.close();
        return file2;
    }

    private static File getFileFromUri(Context context, Uri uri) {
        File file = new File(uri.getPath());
        if (file.exists()) {
            return file;
        }
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
            cursor.moveToFirst();
            File file2 = new File(cursor.getString(columnIndexOrThrow));
            if (cursor != null) {
                cursor.close();
            }
            return file2;
        } catch (Exception unused) {
            if (cursor == null) {
                return file;
            }
            cursor.close();
            return file;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033 A[Catch: Exception -> 0x0046, TryCatch #1 {Exception -> 0x0046, blocks: (B:14:0x002d, B:16:0x0033, B:18:0x003b, B:20:0x003e, B:23:0x0041), top: B:13:0x002d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean copyExif(android.content.Context r6, android.net.Uri r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "ImageResizer::copyExif"
            r1 = 0
            r2 = 0
            java.io.File r6 = getFileFromUri(r6, r7)     // Catch: java.lang.Exception -> L21
            boolean r7 = r6.exists()     // Catch: java.lang.Exception -> L21
            if (r7 != 0) goto Lf
            return r1
        Lf:
            androidx.exifinterface.media.ExifInterface r7 = new androidx.exifinterface.media.ExifInterface     // Catch: java.lang.Exception -> L21
            java.lang.String r6 = r6.getAbsolutePath()     // Catch: java.lang.Exception -> L21
            r7.<init>(r6)     // Catch: java.lang.Exception -> L21
            androidx.exifinterface.media.ExifInterface r6 = new androidx.exifinterface.media.ExifInterface     // Catch: java.lang.Exception -> L1f
            r6.<init>(r8)     // Catch: java.lang.Exception -> L1f
            r2 = r6
            goto L28
        L1f:
            r6 = move-exception
            goto L23
        L21:
            r6 = move-exception
            r7 = r2
        L23:
            java.lang.String r8 = "EXIF read failed"
            android.util.Log.e(r0, r8, r6)
        L28:
            if (r7 == 0) goto L4c
            if (r2 != 0) goto L2d
            goto L4c
        L2d:
            java.lang.String[] r6 = com.reactnativeimageresizer.ImageResizer.EXIF_TO_COPY_ROTATED     // Catch: java.lang.Exception -> L46
            int r8 = r6.length     // Catch: java.lang.Exception -> L46
            r3 = r1
        L31:
            if (r3 >= r8) goto L41
            r4 = r6[r3]     // Catch: java.lang.Exception -> L46
            java.lang.String r5 = r7.getAttribute(r4)     // Catch: java.lang.Exception -> L46
            if (r5 == 0) goto L3e
            r2.setAttribute(r4, r5)     // Catch: java.lang.Exception -> L46
        L3e:
            int r3 = r3 + 1
            goto L31
        L41:
            r2.saveAttributes()     // Catch: java.lang.Exception -> L46
            r6 = 1
            return r6
        L46:
            r6 = move-exception
            java.lang.String r7 = "EXIF copy failed"
            android.util.Log.e(r0, r7, r6)
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativeimageresizer.ImageResizer.copyExif(android.content.Context, android.net.Uri, java.lang.String):boolean");
    }

    public static int getOrientation(Context context, Uri uri) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                return getOrientation(new ExifInterface(context.getContentResolver().openInputStream(uri)));
            }
            File fileFromUri = getFileFromUri(context, uri);
            if (fileFromUri.exists()) {
                return getOrientation(new ExifInterface(fileFromUri.getAbsolutePath()));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getOrientation(ExifInterface exifInterface) {
        int attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 3) {
            return RotationOptions.ROTATE_180;
        }
        if (attributeInt == 6) {
            return 90;
        }
        if (attributeInt != 8) {
            return 0;
        }
        return RotationOptions.ROTATE_270;
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    private static Bitmap loadBitmap(Context context, Uri uri, BitmapFactory.Options options) throws IOException {
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equalsIgnoreCase("content")) {
            try {
                return BitmapFactory.decodeFile(uri.getPath(), options);
            } catch (Exception e) {
                e.printStackTrace();
                throw new IOException("Error decoding image file");
            }
        }
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        if (openInputStream == null) {
            return null;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, null, options);
        openInputStream.close();
        return decodeStream;
    }

    private static Bitmap loadBitmapFromFile(Context context, Uri uri, int i, int i2) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        loadBitmap(context, uri, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return loadBitmap(context, uri, options);
    }

    private static Bitmap loadBitmapFromURL(Uri uri, int i, int i2) throws IOException {
        InputStream inputStream = null;
        Bitmap decodeByteArray = null;
        inputStream = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
                httpURLConnection.connect();
                InputStream inputStream2 = httpURLConnection.getInputStream();
                if (inputStream2 != null) {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            try {
                                int read = inputStream2.read(bArr, 0, 1024);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            } catch (Throwable th) {
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        }
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
                        options.inSampleSize = calculateInSampleSize(options, i, i2);
                        options.inJustDecodeBounds = false;
                        decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
                    } catch (Exception e) {
                        e = e;
                        inputStream = inputStream2;
                        e.printStackTrace();
                        throw new IOException("Error fetching remote image file.");
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return decodeByteArray;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    private static Bitmap loadBitmapFromBase64(Uri uri) {
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        int indexOf = schemeSpecificPart.indexOf(44);
        if (indexOf != -1) {
            String lowerCase = schemeSpecificPart.substring(0, indexOf).replace('\\', IOUtils.DIR_SEPARATOR_UNIX).toLowerCase();
            boolean startsWith = lowerCase.startsWith("image/jpeg");
            boolean z = !startsWith && lowerCase.startsWith(IMAGE_PNG);
            if (startsWith || z) {
                byte[] decode = Base64.decode(schemeSpecificPart.substring(indexOf + 1), 0);
                return BitmapFactory.decodeByteArray(decode, 0, decode.length);
            }
        }
        return null;
    }

    public static Bitmap createResizedImage(Context context, Uri uri, int i, int i2, int i3, int i4, String str, boolean z) throws IOException {
        Bitmap loadBitmapFromFile;
        String scheme = uri.getScheme();
        if (scheme == null || scheme.equalsIgnoreCase("file") || scheme.equalsIgnoreCase("content")) {
            loadBitmapFromFile = loadBitmapFromFile(context, uri, i, i2);
        } else if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https")) {
            loadBitmapFromFile = loadBitmapFromURL(uri, i, i2);
        } else {
            loadBitmapFromFile = scheme.equalsIgnoreCase("data") ? loadBitmapFromBase64(uri) : null;
        }
        if (loadBitmapFromFile == null) {
            throw new IOException("Unable to load source image from path");
        }
        Bitmap rotateImage = rotateImage(loadBitmapFromFile, getOrientation(context, uri) + i4);
        if (rotateImage == null) {
            throw new IOException("Unable to rotate image. Most likely due to not enough memory.");
        }
        Bitmap resizeImage = resizeImage(rotateImage, i, i2, str, z);
        if (resizeImage == null) {
            throw new IOException("Unable to resize image. Most likely due to not enough memory.");
        }
        if (resizeImage != rotateImage) {
            rotateImage.recycle();
        }
        return resizeImage;
    }
}
