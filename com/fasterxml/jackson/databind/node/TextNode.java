package com.fasterxml.jackson.databind.node;

import com.amazon.a.a.o.b;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/* loaded from: classes3.dex */
public class TextNode extends ValueNode {
    static final TextNode EMPTY_STRING_NODE = new TextNode("");
    protected final String _value;

    public TextNode(String str) {
        this._value = str;
    }

    public static TextNode valueOf(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return EMPTY_STRING_NODE;
        }
        return new TextNode(str);
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNodeType getNodeType() {
        return JsonNodeType.STRING;
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode, com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.core.TreeNode
    public JsonToken asToken() {
        return JsonToken.VALUE_STRING;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public String textValue() {
        return this._value;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        if (r6 >= 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        _reportInvalidBase64(r12, r4, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        if (r5 < r2) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        _reportBase64EOF();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        r4 = r5 + 1;
        r5 = r1.charAt(r5);
        r7 = r12.decodeBase64Char(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
    
        if (r7 >= 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        _reportInvalidBase64(r12, r5, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        r5 = (r6 << 6) | r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        if (r4 < r2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
    
        if (r12.usesPadding() != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        _reportBase64EOF();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
    
        r0.append(r5 >> 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        r6 = r4 + 1;
        r4 = r1.charAt(r4);
        r7 = r12.decodeBase64Char(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        if (r7 >= 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0098, code lost:
    
        r4 = (r5 << 6) | r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009b, code lost:
    
        if (r6 < r2) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a1, code lost:
    
        if (r12.usesPadding() != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a9, code lost:
    
        _reportBase64EOF();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a3, code lost:
    
        r0.appendTwoBytes(r4 >> 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ac, code lost:
    
        r5 = r6 + 1;
        r6 = r1.charAt(r6);
        r7 = r12.decodeBase64Char(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
    
        if (r7 >= 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b8, code lost:
    
        if (r7 == (-2)) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ba, code lost:
    
        _reportInvalidBase64(r12, r6, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bd, code lost:
    
        r0.appendTwoBytes(r4 >> 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c9, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c3, code lost:
    
        r0.appendThreeBytes((r4 << 6) | r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0061, code lost:
    
        if (r7 == (-2)) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0063, code lost:
    
        _reportInvalidBase64(r12, r4, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0066, code lost:
    
        if (r6 < r2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0068, code lost:
    
        _reportBase64EOF();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x006b, code lost:
    
        r4 = r6 + 1;
        r6 = r1.charAt(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0075, code lost:
    
        if (r12.usesPaddingChar(r6) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0077, code lost:
    
        _reportInvalidBase64(r12, r6, 3, "expected padding character '" + r12.getPaddingChar() + "'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0091, code lost:
    
        r0.append(r5 >> 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        r6 = r12.decodeBase64Char(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] getBinaryValue(com.fasterxml.jackson.core.Base64Variant r12) throws java.io.IOException {
        /*
            r11 = this;
            com.fasterxml.jackson.core.util.ByteArrayBuilder r0 = new com.fasterxml.jackson.core.util.ByteArrayBuilder
            r1 = 100
            r0.<init>(r1)
            java.lang.String r1 = r11._value
            int r2 = r1.length()
            r3 = 0
            r4 = r3
        Lf:
            if (r4 >= r2) goto Lcf
        L11:
            int r5 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r5 < r2) goto L1b
            goto Lcf
        L1b:
            r6 = 32
            if (r4 <= r6) goto Lcc
            int r6 = r12.decodeBase64Char(r4)
            if (r6 >= 0) goto L28
            r11._reportInvalidBase64(r12, r4, r3)
        L28:
            if (r5 < r2) goto L2d
            r11._reportBase64EOF()
        L2d:
            int r4 = r5 + 1
            char r5 = r1.charAt(r5)
            int r7 = r12.decodeBase64Char(r5)
            if (r7 >= 0) goto L3d
            r8 = 1
            r11._reportInvalidBase64(r12, r5, r8)
        L3d:
            int r5 = r6 << 6
            r5 = r5 | r7
            if (r4 < r2) goto L52
            boolean r6 = r12.usesPadding()
            if (r6 != 0) goto L4f
            int r12 = r5 >> 4
            r0.append(r12)
            goto Lcf
        L4f:
            r11._reportBase64EOF()
        L52:
            int r6 = r4 + 1
            char r4 = r1.charAt(r4)
            int r7 = r12.decodeBase64Char(r4)
            r8 = 3
            r9 = -2
            r10 = 2
            if (r7 >= 0) goto L98
            if (r7 == r9) goto L66
            r11._reportInvalidBase64(r12, r4, r10)
        L66:
            if (r6 < r2) goto L6b
            r11._reportBase64EOF()
        L6b:
            int r4 = r6 + 1
            char r6 = r1.charAt(r6)
            boolean r7 = r12.usesPaddingChar(r6)
            if (r7 != 0) goto L91
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "expected padding character '"
            r7.<init>(r9)
            char r9 = r12.getPaddingChar()
            r7.append(r9)
            java.lang.String r9 = "'"
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r11._reportInvalidBase64(r12, r6, r8, r7)
        L91:
            int r5 = r5 >> 4
            r0.append(r5)
            goto Lf
        L98:
            int r4 = r5 << 6
            r4 = r4 | r7
            if (r6 < r2) goto Lac
            boolean r5 = r12.usesPadding()
            if (r5 != 0) goto La9
            int r12 = r4 >> 2
            r0.appendTwoBytes(r12)
            goto Lcf
        La9:
            r11._reportBase64EOF()
        Lac:
            int r5 = r6 + 1
            char r6 = r1.charAt(r6)
            int r7 = r12.decodeBase64Char(r6)
            if (r7 >= 0) goto Lc3
            if (r7 == r9) goto Lbd
            r11._reportInvalidBase64(r12, r6, r8)
        Lbd:
            int r4 = r4 >> 2
            r0.appendTwoBytes(r4)
            goto Lc9
        Lc3:
            int r4 = r4 << 6
            r4 = r4 | r7
            r0.appendThreeBytes(r4)
        Lc9:
            r4 = r5
            goto Lf
        Lcc:
            r4 = r5
            goto L11
        Lcf:
            byte[] r12 = r0.toByteArray()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.node.TextNode.getBinaryValue(com.fasterxml.jackson.core.Base64Variant):byte[]");
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public byte[] binaryValue() throws IOException {
        return getBinaryValue(Base64Variants.getDefaultVariant());
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public String asText() {
        return this._value;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public String asText(String str) {
        String str2 = this._value;
        return str2 == null ? str : str2;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean asBoolean(boolean z) {
        String str = this._value;
        if (str == null) {
            return z;
        }
        String trim = str.trim();
        if (b.ac.equals(trim)) {
            return true;
        }
        if ("false".equals(trim)) {
            return false;
        }
        return z;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public int asInt(int i) {
        return NumberInput.parseAsInt(this._value, i);
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public long asLong(long j) {
        return NumberInput.parseAsLong(this._value, j);
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public double asDouble(double d) {
        return NumberInput.parseAsDouble(this._value, d);
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.databind.JsonSerializable
    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String str = this._value;
        if (str == null) {
            jsonGenerator.writeNull();
        } else {
            jsonGenerator.writeString(str);
        }
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof TextNode)) {
            return ((TextNode) obj)._value.equals(this._value);
        }
        return false;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode
    public int hashCode() {
        return this._value.hashCode();
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode, com.fasterxml.jackson.databind.JsonNode
    public String toString() {
        int length = this._value.length();
        StringBuilder sb = new StringBuilder(length + 2 + (length >> 4));
        appendQuoted(sb, this._value);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void appendQuoted(StringBuilder sb, String str) {
        sb.append('\"');
        CharTypes.appendQuoted(sb, str);
        sb.append('\"');
    }

    protected void _reportInvalidBase64(Base64Variant base64Variant, char c, int i) throws JsonParseException {
        _reportInvalidBase64(base64Variant, c, i, null);
    }

    protected void _reportInvalidBase64(Base64Variant base64Variant, char c, int i, String str) throws JsonParseException {
        String str2;
        if (c <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units";
        } else if (base64Variant.usesPaddingChar(c)) {
            str2 = "Unexpected padding character ('" + base64Variant.getPaddingChar() + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c) || Character.isISOControl(c)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw new JsonParseException((JsonParser) null, str2, JsonLocation.NA);
    }

    protected void _reportBase64EOF() throws JsonParseException {
        throw new JsonParseException((JsonParser) null, "Unexpected end-of-String when base64 content");
    }
}
