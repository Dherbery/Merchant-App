package com.revenuecat.purchases.hybridcommon.mappers;

/* loaded from: classes5.dex */
class PurchasesMath {
    PurchasesMath() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int addExact(int i, int i2) {
        int i3 = i + i2;
        if (((i ^ i3) & (i2 ^ i3)) >= 0) {
            return i3;
        }
        throw new ArithmeticException("integer overflow");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int multiplyExact(int i, int i2) {
        long j = i * i2;
        int i3 = (int) j;
        if (i3 == j) {
            return i3;
        }
        throw new ArithmeticException("integer overflow");
    }
}
