package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes5.dex */
public interface HmacParamsOrBuilder extends MessageLiteOrBuilder {
    HashType getHash();

    int getHashValue();

    int getTagSize();
}
