package com.google.crypto.tink.aead.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/* loaded from: classes5.dex */
final class ChaCha20Util {
    static final int BLOCK_SIZE_IN_BYTES = 64;
    static final int BLOCK_SIZE_IN_INTS = 16;
    static final int KEY_SIZE_IN_BYTES = 32;
    static final int KEY_SIZE_IN_INTS = 8;
    private static final int[] SIGMA = toIntArray(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    private static int rotateLeft(int x, int y) {
        return (x >>> (-y)) | (x << y);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSigmaAndKey(int[] state, final int[] key) {
        int[] iArr = SIGMA;
        System.arraycopy(iArr, 0, state, 0, iArr.length);
        System.arraycopy(key, 0, state, iArr.length, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void shuffleState(final int[] state) {
        for (int i = 0; i < 10; i++) {
            quarterRound(state, 0, 4, 8, 12);
            quarterRound(state, 1, 5, 9, 13);
            quarterRound(state, 2, 6, 10, 14);
            quarterRound(state, 3, 7, 11, 15);
            quarterRound(state, 0, 5, 10, 15);
            quarterRound(state, 1, 6, 11, 12);
            quarterRound(state, 2, 7, 8, 13);
            quarterRound(state, 3, 4, 9, 14);
        }
    }

    static void quarterRound(int[] x, int a, int b, int c, int d) {
        int i = x[a] + x[b];
        x[a] = i;
        int rotateLeft = rotateLeft(i ^ x[d], 16);
        x[d] = rotateLeft;
        int i2 = x[c] + rotateLeft;
        x[c] = i2;
        int rotateLeft2 = rotateLeft(x[b] ^ i2, 12);
        x[b] = rotateLeft2;
        int i3 = x[a] + rotateLeft2;
        x[a] = i3;
        int rotateLeft3 = rotateLeft(x[d] ^ i3, 8);
        x[d] = rotateLeft3;
        int i4 = x[c] + rotateLeft3;
        x[c] = i4;
        x[b] = rotateLeft(x[b] ^ i4, 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] toIntArray(final byte[] input) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(input).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    private ChaCha20Util() {
    }
}
