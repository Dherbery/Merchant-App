package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.StreamingAead;
import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: classes5.dex */
public final class StreamingAeadFactory {
    public static StreamingAead getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        StreamingAeadWrapper.register();
        return (StreamingAead) keysetHandle.getPrimitive(StreamingAead.class);
    }

    private StreamingAeadFactory() {
    }
}
