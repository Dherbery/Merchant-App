package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
public final class zzaw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] zza(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (objArr[i2] == null) {
                throw new NullPointerException("at index " + i2);
            }
        }
        return objArr;
    }
}
