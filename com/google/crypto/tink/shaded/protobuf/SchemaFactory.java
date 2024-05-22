package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes5.dex */
public interface SchemaFactory {
    <T> Schema<T> createSchema(Class<T> messageType);
}
