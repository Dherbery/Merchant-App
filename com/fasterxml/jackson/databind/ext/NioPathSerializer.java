package com.fasterxml.jackson.databind.ext;

import com.facebook.react.views.text.ReactTextView$$ExternalSyntheticApiModelOutline0;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;

/* loaded from: classes3.dex */
public class NioPathSerializer extends StdScalarSerializer<Path> {
    private static final long serialVersionUID = 1;

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer
    public /* bridge */ /* synthetic */ void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        serialize(ReactTextView$$ExternalSyntheticApiModelOutline0.m663m(obj), jsonGenerator, serializerProvider);
    }

    public NioPathSerializer() {
        super(ReactTextView$$ExternalSyntheticApiModelOutline0.m661m());
    }

    public void serialize(Path path, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        URI uri;
        uri = path.toUri();
        jsonGenerator.writeString(uri.toString());
    }
}
