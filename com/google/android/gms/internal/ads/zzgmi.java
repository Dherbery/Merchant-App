package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
abstract class zzgmi {
    int[] zza;
    private final int zzb;

    public zzgmi(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.zza = zzgme.zzd(bArr);
        this.zzb = i;
    }

    abstract int zza();

    abstract int[] zzb(int[] iArr, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ByteBuffer zzc(byte[] bArr, int i) {
        int[] zzb = zzb(zzgme.zzd(bArr), i);
        int[] iArr = (int[]) zzb.clone();
        zzgme.zzc(iArr);
        for (int i2 = 0; i2 < 16; i2++) {
            zzb[i2] = zzb[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zzb, 0, 16);
        return order;
    }

    public final byte[] zzd(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        if (bArr.length != zza()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + zza());
        }
        int remaining = byteBuffer.remaining();
        int i = remaining / 64;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i2 < i3) {
                ByteBuffer zzc = zzc(bArr, this.zzb + i2);
                if (i2 == i3 - 1) {
                    zzgwp.zza(allocate, byteBuffer, zzc, remaining % 64);
                } else {
                    zzgwp.zza(allocate, byteBuffer, zzc, 64);
                }
                i2++;
            } else {
                return allocate.array();
            }
        }
    }
}
