package com.google.crypto.tink.shaded.protobuf;

@CheckReturnValue
/* loaded from: classes5.dex */
final class MapFieldSchemas {
    private static final MapFieldSchema FULL_SCHEMA = loadSchemaForFullRuntime();
    private static final MapFieldSchema LITE_SCHEMA = new MapFieldSchemaLite();

    MapFieldSchemas() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MapFieldSchema full() {
        return FULL_SCHEMA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MapFieldSchema lite() {
        return LITE_SCHEMA;
    }

    private static MapFieldSchema loadSchemaForFullRuntime() {
        try {
            return (MapFieldSchema) Class.forName("com.google.crypto.tink.shaded.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
