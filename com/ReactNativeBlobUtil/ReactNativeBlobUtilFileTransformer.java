package com.ReactNativeBlobUtil;

/* loaded from: classes.dex */
public class ReactNativeBlobUtilFileTransformer {
    public static FileTransformer sharedFileTransformer;

    /* loaded from: classes.dex */
    public interface FileTransformer {
        byte[] onReadFile(byte[] bArr);

        byte[] onWriteFile(byte[] bArr);
    }
}
