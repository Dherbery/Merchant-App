package com.google.crypto.tink.prf;

import com.google.crypto.tink.Key;

/* loaded from: classes5.dex */
public abstract class PrfKey extends Key {
    @Override // com.google.crypto.tink.Key
    public abstract PrfParameters getParameters();
}
