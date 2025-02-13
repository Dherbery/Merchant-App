package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.Collection;

/* loaded from: classes3.dex */
public abstract class JsonDeserializer<T> {
    public abstract T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException;

    public JsonDeserializer<?> getDelegatee() {
        return null;
    }

    public Collection<Object> getKnownPropertyNames() {
        return null;
    }

    @Deprecated
    public T getNullValue() {
        return null;
    }

    public ObjectIdReader getObjectIdReader() {
        return null;
    }

    public Class<?> handledType() {
        return null;
    }

    public boolean isCachable() {
        return false;
    }

    public JsonDeserializer<T> unwrappingDeserializer(NameTransformer nameTransformer) {
        return this;
    }

    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, T t) throws IOException, JsonProcessingException {
        throw new UnsupportedOperationException("Can not update object of type " + t.getClass().getName() + " (by deserializer of type " + getClass().getName() + ")");
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    public JsonDeserializer<?> replaceDelegatee(JsonDeserializer<?> jsonDeserializer) {
        throw new UnsupportedOperationException();
    }

    public T getNullValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return getNullValue();
    }

    public T getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return getEmptyValue();
    }

    public SettableBeanProperty findBackReference(String str) {
        throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': type: value deserializer of type " + getClass().getName() + " does not support them");
    }

    @Deprecated
    public T getEmptyValue() {
        return getNullValue();
    }

    /* loaded from: classes3.dex */
    public static abstract class None extends JsonDeserializer<Object> {
        private None() {
        }
    }
}
