package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class StdScalarDeserializer<T> extends StdDeserializer<T> {
    protected static final int FEATURES_ACCEPT_ARRAYS = DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS.getMask() | DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT.getMask();
    private static final long serialVersionUID = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    public StdScalarDeserializer(Class<?> cls) {
        super(cls);
    }

    protected StdScalarDeserializer(JavaType javaType) {
        super(javaType);
    }

    protected StdScalarDeserializer(StdScalarDeserializer<?> stdScalarDeserializer) {
        super(stdScalarDeserializer);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromScalar(jsonParser, deserializationContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T _deserializeFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken;
        if (deserializationContext.hasSomeOfFeatures(FEATURES_ACCEPT_ARRAYS)) {
            currentToken = jsonParser.nextToken();
            if (currentToken == JsonToken.END_ARRAY && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
                return getNullValue(deserializationContext);
            }
            if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                T deserialize = deserialize(jsonParser, deserializationContext);
                if (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    handleMissingEndArrayForSingle(jsonParser, deserializationContext);
                }
                return deserialize;
            }
        } else {
            currentToken = jsonParser.getCurrentToken();
        }
        return (T) deserializationContext.handleUnexpectedToken(this._valueClass, currentToken, jsonParser, null, new Object[0]);
    }
}
