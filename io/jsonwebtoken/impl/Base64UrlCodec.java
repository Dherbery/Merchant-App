package io.jsonwebtoken.impl;

import org.apache.commons.io.IOUtils;

/* loaded from: classes5.dex */
public class Base64UrlCodec extends AbstractTextCodec {
    @Override // io.jsonwebtoken.impl.TextCodec
    public String encode(byte[] bArr) {
        byte[] removePadding = removePadding(TextCodec.BASE64.encode(bArr).getBytes(US_ASCII));
        for (int i = 0; i < removePadding.length; i++) {
            byte b = removePadding[i];
            if (b == 43) {
                removePadding[i] = 45;
            } else if (b == 47) {
                removePadding[i] = 95;
            }
        }
        return new String(removePadding, US_ASCII);
    }

    protected byte[] removePadding(byte[] bArr) {
        int i = 0;
        for (int length = bArr.length - 1; length > 0 && bArr[length] == 61; length--) {
            i++;
        }
        if (i <= 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length - i];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length - i);
        return bArr2;
    }

    @Override // io.jsonwebtoken.impl.TextCodec
    public byte[] decode(String str) {
        char[] ensurePadding = ensurePadding(str.toCharArray());
        for (int i = 0; i < ensurePadding.length; i++) {
            char c = ensurePadding[i];
            if (c == '-') {
                ensurePadding[i] = '+';
            } else if (c == '_') {
                ensurePadding[i] = IOUtils.DIR_SEPARATOR_UNIX;
            }
        }
        return TextCodec.BASE64.decode(new String(ensurePadding));
    }

    protected char[] ensurePadding(char[] cArr) {
        int length = cArr.length % 4;
        int i = (length == 2 || length == 3) ? 4 - length : 0;
        if (i <= 0) {
            return cArr;
        }
        char[] cArr2 = new char[cArr.length + i];
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
        for (int i2 = 0; i2 < i; i2++) {
            cArr2[cArr.length + i2] = '=';
        }
        return cArr2;
    }
}
