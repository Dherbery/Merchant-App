package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;

/* compiled from: JsonNodeDeserializer.java */
/* loaded from: classes3.dex */
abstract class BaseNodeDeserializer<T extends JsonNode> extends StdDeserializer<T> {
    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public boolean isCachable() {
        return true;
    }

    public BaseNodeDeserializer(Class<T> cls) {
        super((Class<?>) cls);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    @Deprecated
    protected void _reportProblem(JsonParser jsonParser, String str) throws JsonMappingException {
        throw JsonMappingException.from(jsonParser, str);
    }

    protected void _handleDuplicateField(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, String str, ObjectNode objectNode, JsonNode jsonNode, JsonNode jsonNode2) throws JsonProcessingException {
        if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
            deserializationContext.reportMappingException("Duplicate field '%s' for ObjectNode: not allowed when FAIL_ON_READING_DUP_TREE_KEY enabled", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ObjectNode deserializeObject(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        String currentName;
        JsonNode deserializeObject;
        ObjectNode objectNode = jsonNodeFactory.objectNode();
        if (jsonParser.isExpectedStartObjectToken()) {
            currentName = jsonParser.nextFieldName();
        } else {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.END_OBJECT) {
                return objectNode;
            }
            if (currentToken != JsonToken.FIELD_NAME) {
                return (ObjectNode) deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
            }
            currentName = jsonParser.getCurrentName();
        }
        String str = currentName;
        while (str != null) {
            JsonToken nextToken = jsonParser.nextToken();
            if (nextToken == null) {
                throw deserializationContext.mappingException("Unexpected end-of-input when binding data into ObjectNode");
            }
            int id = nextToken.id();
            if (id == 1) {
                deserializeObject = deserializeObject(jsonParser, deserializationContext, jsonNodeFactory);
            } else if (id == 3) {
                deserializeObject = deserializeArray(jsonParser, deserializationContext, jsonNodeFactory);
            } else if (id == 6) {
                deserializeObject = jsonNodeFactory.textNode(jsonParser.getText());
            } else if (id == 7) {
                deserializeObject = _fromInt(jsonParser, deserializationContext, jsonNodeFactory);
            } else {
                switch (id) {
                    case 9:
                        deserializeObject = jsonNodeFactory.booleanNode(true);
                        break;
                    case 10:
                        deserializeObject = jsonNodeFactory.booleanNode(false);
                        break;
                    case 11:
                        deserializeObject = jsonNodeFactory.nullNode();
                        break;
                    case 12:
                        deserializeObject = _fromEmbedded(jsonParser, deserializationContext, jsonNodeFactory);
                        break;
                    default:
                        deserializeObject = deserializeAny(jsonParser, deserializationContext, jsonNodeFactory);
                        break;
                }
            }
            JsonNode jsonNode = deserializeObject;
            JsonNode replace = objectNode.replace(str, jsonNode);
            if (replace != null) {
                _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, str, objectNode, replace, jsonNode);
            }
            str = jsonParser.nextFieldName();
        }
        return objectNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.fasterxml.jackson.databind.node.ArrayNode deserializeArray(com.fasterxml.jackson.core.JsonParser r3, com.fasterxml.jackson.databind.DeserializationContext r4, com.fasterxml.jackson.databind.node.JsonNodeFactory r5) throws java.io.IOException {
        /*
            r2 = this;
            com.fasterxml.jackson.databind.node.ArrayNode r0 = r5.arrayNode()
        L4:
            com.fasterxml.jackson.core.JsonToken r1 = r3.nextToken()
            int r1 = r1.id()
            switch(r1) {
                case 1: goto L56;
                case 2: goto Lf;
                case 3: goto L4e;
                case 4: goto L4d;
                case 5: goto Lf;
                case 6: goto L41;
                case 7: goto L39;
                case 8: goto Lf;
                case 9: goto L30;
                case 10: goto L27;
                case 11: goto L1f;
                case 12: goto L17;
                default: goto Lf;
            }
        Lf:
            com.fasterxml.jackson.databind.JsonNode r1 = r2.deserializeAny(r3, r4, r5)
            r0.add(r1)
            goto L4
        L17:
            com.fasterxml.jackson.databind.JsonNode r1 = r2._fromEmbedded(r3, r4, r5)
            r0.add(r1)
            goto L4
        L1f:
            com.fasterxml.jackson.databind.node.NullNode r1 = r5.nullNode()
            r0.add(r1)
            goto L4
        L27:
            r1 = 0
            com.fasterxml.jackson.databind.node.BooleanNode r1 = r5.booleanNode(r1)
            r0.add(r1)
            goto L4
        L30:
            r1 = 1
            com.fasterxml.jackson.databind.node.BooleanNode r1 = r5.booleanNode(r1)
            r0.add(r1)
            goto L4
        L39:
            com.fasterxml.jackson.databind.JsonNode r1 = r2._fromInt(r3, r4, r5)
            r0.add(r1)
            goto L4
        L41:
            java.lang.String r1 = r3.getText()
            com.fasterxml.jackson.databind.node.TextNode r1 = r5.textNode(r1)
            r0.add(r1)
            goto L4
        L4d:
            return r0
        L4e:
            com.fasterxml.jackson.databind.node.ArrayNode r1 = r2.deserializeArray(r3, r4, r5)
            r0.add(r1)
            goto L4
        L56:
            com.fasterxml.jackson.databind.node.ObjectNode r1 = r2.deserializeObject(r3, r4, r5)
            r0.add(r1)
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer.deserializeArray(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.node.JsonNodeFactory):com.fasterxml.jackson.databind.node.ArrayNode");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonNode deserializeAny(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        switch (jsonParser.getCurrentTokenId()) {
            case 1:
            case 2:
            case 5:
                return deserializeObject(jsonParser, deserializationContext, jsonNodeFactory);
            case 3:
                return deserializeArray(jsonParser, deserializationContext, jsonNodeFactory);
            case 4:
            default:
                return (JsonNode) deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
            case 6:
                return jsonNodeFactory.textNode(jsonParser.getText());
            case 7:
                return _fromInt(jsonParser, deserializationContext, jsonNodeFactory);
            case 8:
                return _fromFloat(jsonParser, deserializationContext, jsonNodeFactory);
            case 9:
                return jsonNodeFactory.booleanNode(true);
            case 10:
                return jsonNodeFactory.booleanNode(false);
            case 11:
                return jsonNodeFactory.nullNode();
            case 12:
                return _fromEmbedded(jsonParser, deserializationContext, jsonNodeFactory);
        }
    }

    protected final JsonNode _fromInt(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        JsonParser.NumberType numberType;
        int deserializationFeatures = deserializationContext.getDeserializationFeatures();
        if ((F_MASK_INT_COERCIONS & deserializationFeatures) != 0) {
            if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(deserializationFeatures)) {
                numberType = JsonParser.NumberType.BIG_INTEGER;
            } else if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(deserializationFeatures)) {
                numberType = JsonParser.NumberType.LONG;
            } else {
                numberType = jsonParser.getNumberType();
            }
        } else {
            numberType = jsonParser.getNumberType();
        }
        if (numberType == JsonParser.NumberType.INT) {
            return jsonNodeFactory.numberNode(jsonParser.getIntValue());
        }
        if (numberType == JsonParser.NumberType.LONG) {
            return jsonNodeFactory.numberNode(jsonParser.getLongValue());
        }
        return jsonNodeFactory.numberNode(jsonParser.getBigIntegerValue());
    }

    protected final JsonNode _fromFloat(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        JsonParser.NumberType numberType = jsonParser.getNumberType();
        if (numberType == JsonParser.NumberType.BIG_DECIMAL) {
            return jsonNodeFactory.numberNode(jsonParser.getDecimalValue());
        }
        if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
            double doubleValue = jsonParser.getDoubleValue();
            if (Double.isInfinite(doubleValue) || Double.isNaN(doubleValue)) {
                return jsonNodeFactory.numberNode(doubleValue);
            }
            return jsonNodeFactory.numberNode(jsonParser.getDecimalValue());
        }
        if (numberType == JsonParser.NumberType.FLOAT) {
            return jsonNodeFactory.numberNode(jsonParser.getFloatValue());
        }
        return jsonNodeFactory.numberNode(jsonParser.getDoubleValue());
    }

    protected final JsonNode _fromEmbedded(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        Object embeddedObject = jsonParser.getEmbeddedObject();
        if (embeddedObject == null) {
            return jsonNodeFactory.nullNode();
        }
        if (embeddedObject.getClass() == byte[].class) {
            return jsonNodeFactory.binaryNode((byte[]) embeddedObject);
        }
        if (embeddedObject instanceof RawValue) {
            return jsonNodeFactory.rawValueNode((RawValue) embeddedObject);
        }
        if (embeddedObject instanceof JsonNode) {
            return (JsonNode) embeddedObject;
        }
        return jsonNodeFactory.pojoNode(embeddedObject);
    }
}
