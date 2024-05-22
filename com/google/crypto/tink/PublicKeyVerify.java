package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes5.dex */
public interface PublicKeyVerify {
    void verify(final byte[] signature, final byte[] data) throws GeneralSecurityException;
}
