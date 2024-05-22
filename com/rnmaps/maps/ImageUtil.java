package com.rnmaps.maps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.amazon.a.a.o.b.f;
import java.io.ByteArrayOutputStream;

/* loaded from: classes5.dex */
public class ImageUtil {
    public static Bitmap convert(String str) throws IllegalArgumentException {
        byte[] decode = Base64.decode(str.substring(str.indexOf(f.a) + 1), 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static String convert(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }
}
