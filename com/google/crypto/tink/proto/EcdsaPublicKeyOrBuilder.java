package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes5.dex */
public interface EcdsaPublicKeyOrBuilder extends MessageLiteOrBuilder {
    EcdsaParams getParams();

    int getVersion();

    ByteString getX();

    ByteString getY();

    boolean hasParams();
}
