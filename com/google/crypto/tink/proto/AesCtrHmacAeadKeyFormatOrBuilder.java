package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes5.dex */
public interface AesCtrHmacAeadKeyFormatOrBuilder extends MessageLiteOrBuilder {
    AesCtrKeyFormat getAesCtrKeyFormat();

    HmacKeyFormat getHmacKeyFormat();

    boolean hasAesCtrKeyFormat();

    boolean hasHmacKeyFormat();
}
