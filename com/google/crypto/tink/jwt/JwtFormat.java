package com.google.crypto.tink.jwt;

import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonObject;
import io.jsonwebtoken.JwsHeader;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Optional;

/* loaded from: classes5.dex */
final class JwtFormat {
    static boolean isValidUrlsafeBase64Char(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == '-' || c == '_');
    }

    /* loaded from: classes5.dex */
    static class Parts {
        String header;
        String payload;
        byte[] signatureOrMac;
        String unsignedCompact;

        Parts(String unsignedCompact, byte[] signatureOrMac, String header, String payload) {
            this.unsignedCompact = unsignedCompact;
            this.signatureOrMac = signatureOrMac;
            this.header = header;
            this.payload = payload;
        }
    }

    private JwtFormat() {
    }

    static void validateUtf8(byte[] data) throws JwtInvalidException {
        try {
            Util.UTF_8.newDecoder().decode(ByteBuffer.wrap(data));
        } catch (CharacterCodingException e) {
            throw new JwtInvalidException(e.getMessage());
        }
    }

    static byte[] strictUrlSafeDecode(String encodedData) throws JwtInvalidException {
        for (int i = 0; i < encodedData.length(); i++) {
            if (!isValidUrlsafeBase64Char(encodedData.charAt(i))) {
                throw new JwtInvalidException("invalid encoding");
            }
        }
        try {
            return Base64.urlSafeDecode(encodedData);
        } catch (IllegalArgumentException e) {
            throw new JwtInvalidException("invalid encoding: " + e);
        }
    }

    private static void validateAlgorithm(String algo) throws InvalidAlgorithmParameterException {
        algo.hashCode();
        char c = 65535;
        switch (algo.hashCode()) {
            case 66245349:
                if (algo.equals("ES256")) {
                    c = 0;
                    break;
                }
                break;
            case 66246401:
                if (algo.equals("ES384")) {
                    c = 1;
                    break;
                }
                break;
            case 66248104:
                if (algo.equals("ES512")) {
                    c = 2;
                    break;
                }
                break;
            case 69015912:
                if (algo.equals("HS256")) {
                    c = 3;
                    break;
                }
                break;
            case 69016964:
                if (algo.equals("HS384")) {
                    c = 4;
                    break;
                }
                break;
            case 69018667:
                if (algo.equals("HS512")) {
                    c = 5;
                    break;
                }
                break;
            case 76404080:
                if (algo.equals("PS256")) {
                    c = 6;
                    break;
                }
                break;
            case 76405132:
                if (algo.equals("PS384")) {
                    c = 7;
                    break;
                }
                break;
            case 76406835:
                if (algo.equals("PS512")) {
                    c = '\b';
                    break;
                }
                break;
            case 78251122:
                if (algo.equals("RS256")) {
                    c = '\t';
                    break;
                }
                break;
            case 78252174:
                if (algo.equals("RS384")) {
                    c = '\n';
                    break;
                }
                break;
            case 78253877:
                if (algo.equals("RS512")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 11:
                return;
            default:
                throw new InvalidAlgorithmParameterException("invalid algorithm: " + algo);
        }
    }

    static String createHeader(String algorithm, Optional<String> typeHeader, Optional<String> kid) throws InvalidAlgorithmParameterException {
        boolean isPresent;
        boolean isPresent2;
        Object obj;
        Object obj2;
        validateAlgorithm(algorithm);
        JsonObject jsonObject = new JsonObject();
        isPresent = kid.isPresent();
        if (isPresent) {
            obj2 = kid.get();
            jsonObject.addProperty(JwsHeader.KEY_ID, (String) obj2);
        }
        jsonObject.addProperty(JwsHeader.ALGORITHM, algorithm);
        isPresent2 = typeHeader.isPresent();
        if (isPresent2) {
            obj = typeHeader.get();
            jsonObject.addProperty("typ", (String) obj);
        }
        return Base64.urlSafeEncode(jsonObject.toString().getBytes(Util.UTF_8));
    }

    private static void validateKidInHeader(String expectedKid, JsonObject parsedHeader) throws JwtInvalidException {
        if (!getStringHeader(parsedHeader, JwsHeader.KEY_ID).equals(expectedKid)) {
            throw new JwtInvalidException("invalid kid in header");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void validateHeader(String expectedAlgorithm, Optional<String> tinkKid, Optional<String> customKid, JsonObject parsedHeader) throws InvalidAlgorithmParameterException, JwtInvalidException {
        boolean isPresent;
        boolean isPresent2;
        boolean isPresent3;
        Object obj;
        Object obj2;
        boolean isPresent4;
        validateAlgorithm(expectedAlgorithm);
        String stringHeader = getStringHeader(parsedHeader, JwsHeader.ALGORITHM);
        if (!stringHeader.equals(expectedAlgorithm)) {
            throw new InvalidAlgorithmParameterException(String.format("invalid algorithm; expected %s, got %s", expectedAlgorithm, stringHeader));
        }
        if (parsedHeader.has(JwsHeader.CRITICAL)) {
            throw new JwtInvalidException("all tokens with crit headers are rejected");
        }
        isPresent = tinkKid.isPresent();
        if (isPresent) {
            isPresent4 = customKid.isPresent();
            if (isPresent4) {
                throw new JwtInvalidException("custom_kid can only be set for RAW keys.");
            }
        }
        boolean has = parsedHeader.has(JwsHeader.KEY_ID);
        isPresent2 = tinkKid.isPresent();
        if (isPresent2) {
            if (!has) {
                throw new JwtInvalidException("missing kid in header");
            }
            obj2 = tinkKid.get();
            validateKidInHeader((String) obj2, parsedHeader);
        }
        isPresent3 = customKid.isPresent();
        if (isPresent3 && has) {
            obj = customKid.get();
            validateKidInHeader((String) obj, parsedHeader);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Optional<String> getTypeHeader(JsonObject header) throws JwtInvalidException {
        Optional<String> empty;
        Optional<String> of;
        if (header.has("typ")) {
            of = Optional.of(getStringHeader(header, "typ"));
            return of;
        }
        empty = Optional.empty();
        return empty;
    }

    private static String getStringHeader(JsonObject header, String name) throws JwtInvalidException {
        if (!header.has(name)) {
            throw new JwtInvalidException("header " + name + " does not exist");
        }
        if (!header.get(name).isJsonPrimitive() || !header.get(name).getAsJsonPrimitive().isString()) {
            throw new JwtInvalidException("header " + name + " is not a string");
        }
        return header.get(name).getAsString();
    }

    static String decodeHeader(String headerStr) throws JwtInvalidException {
        byte[] strictUrlSafeDecode = strictUrlSafeDecode(headerStr);
        validateUtf8(strictUrlSafeDecode);
        return new String(strictUrlSafeDecode, Util.UTF_8);
    }

    static String encodePayload(String jsonPayload) {
        return Base64.urlSafeEncode(jsonPayload.getBytes(Util.UTF_8));
    }

    static String decodePayload(String payloadStr) throws JwtInvalidException {
        byte[] strictUrlSafeDecode = strictUrlSafeDecode(payloadStr);
        validateUtf8(strictUrlSafeDecode);
        return new String(strictUrlSafeDecode, Util.UTF_8);
    }

    static String encodeSignature(byte[] signature) {
        return Base64.urlSafeEncode(signature);
    }

    static byte[] decodeSignature(String signatureStr) throws JwtInvalidException {
        return strictUrlSafeDecode(signatureStr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Optional<String> getKid(int keyId, OutputPrefixType prefix) throws JwtInvalidException {
        Optional<String> of;
        Optional<String> empty;
        if (prefix == OutputPrefixType.RAW) {
            empty = Optional.empty();
            return empty;
        }
        if (prefix == OutputPrefixType.TINK) {
            of = Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(keyId).array()));
            return of;
        }
        throw new JwtInvalidException("unsupported output prefix type");
    }

    static Optional<Integer> getKeyId(String kid) {
        Optional<Integer> of;
        Optional<Integer> empty;
        byte[] urlSafeDecode = Base64.urlSafeDecode(kid);
        if (urlSafeDecode.length != 4) {
            empty = Optional.empty();
            return empty;
        }
        of = Optional.of(Integer.valueOf(ByteBuffer.wrap(urlSafeDecode).getInt()));
        return of;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Parts splitSignedCompact(String signedCompact) throws JwtInvalidException {
        validateASCII(signedCompact);
        int lastIndexOf = signedCompact.lastIndexOf(46);
        if (lastIndexOf < 0) {
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        String substring = signedCompact.substring(0, lastIndexOf);
        byte[] decodeSignature = decodeSignature(signedCompact.substring(lastIndexOf + 1));
        int indexOf = substring.indexOf(46);
        if (indexOf < 0) {
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        String substring2 = substring.substring(0, indexOf);
        String substring3 = substring.substring(indexOf + 1);
        if (substring3.indexOf(46) > 0) {
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        return new Parts(substring, decodeSignature, decodeHeader(substring2), decodePayload(substring3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String createUnsignedCompact(String algorithm, Optional<String> kid, RawJwt rawJwt) throws InvalidAlgorithmParameterException, JwtInvalidException {
        String jsonPayload = rawJwt.getJsonPayload();
        return createHeader(algorithm, rawJwt.hasTypeHeader() ? Optional.of(rawJwt.getTypeHeader()) : Optional.empty(), kid) + "." + encodePayload(jsonPayload);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String createSignedCompact(String unsignedCompact, byte[] signature) {
        return unsignedCompact + "." + encodeSignature(signature);
    }

    static void validateASCII(String data) throws JwtInvalidException {
        for (int i = 0; i < data.length(); i++) {
            if ((data.charAt(i) & 128) > 0) {
                throw new JwtInvalidException("Non ascii character");
            }
        }
    }
}
