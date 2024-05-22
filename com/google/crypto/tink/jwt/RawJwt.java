package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import io.jsonwebtoken.Claims;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Immutable
/* loaded from: classes5.dex */
public final class RawJwt {
    private static final long MAX_TIMESTAMP_VALUE = 253402300799L;
    private final JsonObject payload;
    private final Optional<String> typeHeader;

    private RawJwt(Builder builder) {
        if (!builder.payload.has(Claims.EXPIRATION) && !builder.withoutExpiration) {
            throw new IllegalArgumentException("neither setExpiration() nor withoutExpiration() was called");
        }
        if (builder.payload.has(Claims.EXPIRATION) && builder.withoutExpiration) {
            throw new IllegalArgumentException("setExpiration() and withoutExpiration() must not be called together");
        }
        this.typeHeader = builder.typeHeader;
        this.payload = builder.payload.deepCopy();
    }

    private RawJwt(Optional<String> typeHeader, String jsonPayload) throws JwtInvalidException {
        this.typeHeader = typeHeader;
        this.payload = JsonUtil.parseJson(jsonPayload);
        validateStringClaim(Claims.ISSUER);
        validateStringClaim(Claims.SUBJECT);
        validateStringClaim(Claims.ID);
        validateTimestampClaim(Claims.EXPIRATION);
        validateTimestampClaim(Claims.NOT_BEFORE);
        validateTimestampClaim(Claims.ISSUED_AT);
        validateAudienceClaim();
    }

    private void validateStringClaim(String name) throws JwtInvalidException {
        if (this.payload.has(name)) {
            if (this.payload.get(name).isJsonPrimitive() && this.payload.get(name).getAsJsonPrimitive().isString()) {
                return;
            }
            throw new JwtInvalidException("invalid JWT payload: claim " + name + " is not a string.");
        }
    }

    private void validateTimestampClaim(String name) throws JwtInvalidException {
        if (this.payload.has(name)) {
            if (!this.payload.get(name).isJsonPrimitive() || !this.payload.get(name).getAsJsonPrimitive().isNumber()) {
                throw new JwtInvalidException("invalid JWT payload: claim " + name + " is not a number.");
            }
            double asDouble = this.payload.get(name).getAsJsonPrimitive().getAsDouble();
            if (asDouble > 2.53402300799E11d || asDouble < 0.0d) {
                throw new JwtInvalidException("invalid JWT payload: claim " + name + " has an invalid timestamp");
            }
        }
    }

    private void validateAudienceClaim() throws JwtInvalidException {
        if (this.payload.has(Claims.AUDIENCE)) {
            if (!(this.payload.get(Claims.AUDIENCE).isJsonPrimitive() && this.payload.get(Claims.AUDIENCE).getAsJsonPrimitive().isString()) && getAudiences().size() < 1) {
                throw new JwtInvalidException("invalid JWT payload: claim aud is present but empty.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RawJwt fromJsonPayload(Optional<String> typeHeader, String jsonPayload) throws JwtInvalidException {
        return new RawJwt(typeHeader, jsonPayload);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        private final JsonObject payload;
        private Optional<String> typeHeader;
        private boolean withoutExpiration;

        private Builder() {
            Optional<String> empty;
            empty = Optional.empty();
            this.typeHeader = empty;
            this.withoutExpiration = false;
            this.payload = new JsonObject();
        }

        public Builder setTypeHeader(String value) {
            Optional<String> of;
            of = Optional.of(value);
            this.typeHeader = of;
            return this;
        }

        public Builder setIssuer(String value) {
            if (!JsonUtil.isValidString(value)) {
                throw new IllegalArgumentException();
            }
            this.payload.add(Claims.ISSUER, new JsonPrimitive(value));
            return this;
        }

        public Builder setSubject(String value) {
            if (!JsonUtil.isValidString(value)) {
                throw new IllegalArgumentException();
            }
            this.payload.add(Claims.SUBJECT, new JsonPrimitive(value));
            return this;
        }

        public Builder setAudience(String value) {
            if (this.payload.has(Claims.AUDIENCE) && this.payload.get(Claims.AUDIENCE).isJsonArray()) {
                throw new IllegalArgumentException("setAudience can't be used together with setAudiences or addAudience");
            }
            if (!JsonUtil.isValidString(value)) {
                throw new IllegalArgumentException("invalid string");
            }
            this.payload.add(Claims.AUDIENCE, new JsonPrimitive(value));
            return this;
        }

        public Builder setAudiences(List<String> values) {
            if (this.payload.has(Claims.AUDIENCE) && !this.payload.get(Claims.AUDIENCE).isJsonArray()) {
                throw new IllegalArgumentException("setAudiences can't be used together with setAudience");
            }
            if (values.isEmpty()) {
                throw new IllegalArgumentException("audiences must not be empty");
            }
            JsonArray jsonArray = new JsonArray();
            for (String str : values) {
                if (!JsonUtil.isValidString(str)) {
                    throw new IllegalArgumentException("invalid string");
                }
                jsonArray.add(str);
            }
            this.payload.add(Claims.AUDIENCE, jsonArray);
            return this;
        }

        public Builder addAudience(String value) {
            JsonArray jsonArray;
            if (!JsonUtil.isValidString(value)) {
                throw new IllegalArgumentException("invalid string");
            }
            if (this.payload.has(Claims.AUDIENCE)) {
                JsonElement jsonElement = this.payload.get(Claims.AUDIENCE);
                if (!jsonElement.isJsonArray()) {
                    throw new IllegalArgumentException("addAudience can't be used together with setAudience");
                }
                jsonArray = jsonElement.getAsJsonArray();
            } else {
                jsonArray = new JsonArray();
            }
            jsonArray.add(value);
            this.payload.add(Claims.AUDIENCE, jsonArray);
            return this;
        }

        public Builder setJwtId(String value) {
            if (!JsonUtil.isValidString(value)) {
                throw new IllegalArgumentException();
            }
            this.payload.add(Claims.ID, new JsonPrimitive(value));
            return this;
        }

        private void setTimestampClaim(String name, Instant value) {
            long epochSecond;
            epochSecond = value.getEpochSecond();
            if (epochSecond > RawJwt.MAX_TIMESTAMP_VALUE || epochSecond < 0) {
                throw new IllegalArgumentException("timestamp of claim " + name + " is out of range");
            }
            this.payload.add(name, new JsonPrimitive(Long.valueOf(epochSecond)));
        }

        public Builder setExpiration(Instant value) {
            setTimestampClaim(Claims.EXPIRATION, value);
            return this;
        }

        public Builder withoutExpiration() {
            this.withoutExpiration = true;
            return this;
        }

        public Builder setNotBefore(Instant value) {
            setTimestampClaim(Claims.NOT_BEFORE, value);
            return this;
        }

        public Builder setIssuedAt(Instant value) {
            setTimestampClaim(Claims.ISSUED_AT, value);
            return this;
        }

        public Builder addBooleanClaim(String name, boolean value) {
            JwtNames.validate(name);
            this.payload.add(name, new JsonPrimitive(Boolean.valueOf(value)));
            return this;
        }

        public Builder addNumberClaim(String name, double value) {
            JwtNames.validate(name);
            this.payload.add(name, new JsonPrimitive(Double.valueOf(value)));
            return this;
        }

        public Builder addStringClaim(String name, String value) {
            if (!JsonUtil.isValidString(value)) {
                throw new IllegalArgumentException();
            }
            JwtNames.validate(name);
            this.payload.add(name, new JsonPrimitive(value));
            return this;
        }

        public Builder addNullClaim(String name) {
            JwtNames.validate(name);
            this.payload.add(name, JsonNull.INSTANCE);
            return this;
        }

        public Builder addJsonObjectClaim(String name, String encodedJsonObject) throws JwtInvalidException {
            JwtNames.validate(name);
            this.payload.add(name, JsonUtil.parseJson(encodedJsonObject));
            return this;
        }

        public Builder addJsonArrayClaim(String name, String encodedJsonArray) throws JwtInvalidException {
            JwtNames.validate(name);
            this.payload.add(name, JsonUtil.parseJsonArray(encodedJsonArray));
            return this;
        }

        public RawJwt build() {
            return new RawJwt(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getJsonPayload() {
        return this.payload.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasBooleanClaim(String name) {
        JwtNames.validate(name);
        return this.payload.has(name) && this.payload.get(name).isJsonPrimitive() && this.payload.get(name).getAsJsonPrimitive().isBoolean();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Boolean getBooleanClaim(String name) throws JwtInvalidException {
        JwtNames.validate(name);
        if (!this.payload.has(name)) {
            throw new JwtInvalidException("claim " + name + " does not exist");
        }
        if (!this.payload.get(name).isJsonPrimitive() || !this.payload.get(name).getAsJsonPrimitive().isBoolean()) {
            throw new JwtInvalidException("claim " + name + " is not a boolean");
        }
        return Boolean.valueOf(this.payload.get(name).getAsBoolean());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasNumberClaim(String name) {
        JwtNames.validate(name);
        return this.payload.has(name) && this.payload.get(name).isJsonPrimitive() && this.payload.get(name).getAsJsonPrimitive().isNumber();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Double getNumberClaim(String name) throws JwtInvalidException {
        JwtNames.validate(name);
        if (!this.payload.has(name)) {
            throw new JwtInvalidException("claim " + name + " does not exist");
        }
        if (!this.payload.get(name).isJsonPrimitive() || !this.payload.get(name).getAsJsonPrimitive().isNumber()) {
            throw new JwtInvalidException("claim " + name + " is not a number");
        }
        return Double.valueOf(this.payload.get(name).getAsDouble());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasStringClaim(String name) {
        JwtNames.validate(name);
        return this.payload.has(name) && this.payload.get(name).isJsonPrimitive() && this.payload.get(name).getAsJsonPrimitive().isString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getStringClaim(String name) throws JwtInvalidException {
        JwtNames.validate(name);
        return getStringClaimInternal(name);
    }

    private String getStringClaimInternal(String name) throws JwtInvalidException {
        if (!this.payload.has(name)) {
            throw new JwtInvalidException("claim " + name + " does not exist");
        }
        if (!this.payload.get(name).isJsonPrimitive() || !this.payload.get(name).getAsJsonPrimitive().isString()) {
            throw new JwtInvalidException("claim " + name + " is not a string");
        }
        return this.payload.get(name).getAsString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isNullClaim(String name) {
        JwtNames.validate(name);
        try {
            return JsonNull.INSTANCE.equals(this.payload.get(name));
        } catch (JsonParseException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasJsonObjectClaim(String name) {
        JwtNames.validate(name);
        return this.payload.has(name) && this.payload.get(name).isJsonObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getJsonObjectClaim(String name) throws JwtInvalidException {
        JwtNames.validate(name);
        if (!this.payload.has(name)) {
            throw new JwtInvalidException("claim " + name + " does not exist");
        }
        if (!this.payload.get(name).isJsonObject()) {
            throw new JwtInvalidException("claim " + name + " is not a JSON object");
        }
        return this.payload.get(name).getAsJsonObject().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasJsonArrayClaim(String name) {
        JwtNames.validate(name);
        return this.payload.has(name) && this.payload.get(name).isJsonArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getJsonArrayClaim(String name) throws JwtInvalidException {
        JwtNames.validate(name);
        if (!this.payload.has(name)) {
            throw new JwtInvalidException("claim " + name + " does not exist");
        }
        if (!this.payload.get(name).isJsonArray()) {
            throw new JwtInvalidException("claim " + name + " is not a JSON array");
        }
        return this.payload.get(name).getAsJsonArray().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasTypeHeader() {
        boolean isPresent;
        isPresent = this.typeHeader.isPresent();
        return isPresent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getTypeHeader() throws JwtInvalidException {
        boolean isPresent;
        Object obj;
        isPresent = this.typeHeader.isPresent();
        if (!isPresent) {
            throw new JwtInvalidException("type header is not set");
        }
        obj = this.typeHeader.get();
        return (String) obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasIssuer() {
        return this.payload.has(Claims.ISSUER);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getIssuer() throws JwtInvalidException {
        return getStringClaimInternal(Claims.ISSUER);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasSubject() {
        return this.payload.has(Claims.SUBJECT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getSubject() throws JwtInvalidException {
        return getStringClaimInternal(Claims.SUBJECT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasJwtId() {
        return this.payload.has(Claims.ID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getJwtId() throws JwtInvalidException {
        return getStringClaimInternal(Claims.ID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasAudiences() {
        return this.payload.has(Claims.AUDIENCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> getAudiences() throws JwtInvalidException {
        if (!hasAudiences()) {
            throw new JwtInvalidException("claim aud does not exist");
        }
        JsonElement jsonElement = this.payload.get(Claims.AUDIENCE);
        if (jsonElement.isJsonPrimitive()) {
            if (!jsonElement.getAsJsonPrimitive().isString()) {
                throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", jsonElement));
            }
            return Collections.unmodifiableList(Arrays.asList(jsonElement.getAsString()));
        }
        if (!jsonElement.isJsonArray()) {
            throw new JwtInvalidException("claim aud is not a string or a JSON array");
        }
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        ArrayList arrayList = new ArrayList(asJsonArray.size());
        for (int i = 0; i < asJsonArray.size(); i++) {
            if (!asJsonArray.get(i).isJsonPrimitive() || !asJsonArray.get(i).getAsJsonPrimitive().isString()) {
                throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", asJsonArray.get(i)));
            }
            arrayList.add(asJsonArray.get(i).getAsString());
        }
        return Collections.unmodifiableList(arrayList);
    }

    private Instant getInstant(String name) throws JwtInvalidException {
        Instant ofEpochMilli;
        if (!this.payload.has(name)) {
            throw new JwtInvalidException("claim " + name + " does not exist");
        }
        if (!this.payload.get(name).isJsonPrimitive() || !this.payload.get(name).getAsJsonPrimitive().isNumber()) {
            throw new JwtInvalidException("claim " + name + " is not a timestamp");
        }
        try {
            ofEpochMilli = Instant.ofEpochMilli((long) (this.payload.get(name).getAsJsonPrimitive().getAsDouble() * 1000.0d));
            return ofEpochMilli;
        } catch (NumberFormatException e) {
            throw new JwtInvalidException("claim " + name + " is not a timestamp: " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasExpiration() {
        return this.payload.has(Claims.EXPIRATION);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Instant getExpiration() throws JwtInvalidException {
        return getInstant(Claims.EXPIRATION);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasNotBefore() {
        return this.payload.has(Claims.NOT_BEFORE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Instant getNotBefore() throws JwtInvalidException {
        return getInstant(Claims.NOT_BEFORE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasIssuedAt() {
        return this.payload.has(Claims.ISSUED_AT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Instant getIssuedAt() throws JwtInvalidException {
        return getInstant(Claims.ISSUED_AT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> customClaimNames() {
        HashSet hashSet = new HashSet();
        for (String str : this.payload.keySet()) {
            if (!JwtNames.isRegisteredName(str)) {
                hashSet.add(str);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public String toString() {
        boolean isPresent;
        Object obj;
        JsonObject jsonObject = new JsonObject();
        isPresent = this.typeHeader.isPresent();
        if (isPresent) {
            obj = this.typeHeader.get();
            jsonObject.add("typ", new JsonPrimitive((String) obj));
        }
        return jsonObject + "." + this.payload;
    }
}
