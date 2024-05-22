package com.google.crypto.tink.jwt;

import com.amazon.a.a.o.b.f;
import com.google.errorprone.annotations.Immutable;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Immutable
/* loaded from: classes5.dex */
public final class JwtValidator {
    private static final Duration MAX_CLOCK_SKEW;
    private final boolean allowMissingExpiration;
    private final Clock clock;
    private final Duration clockSkew;
    private final boolean expectIssuedInThePast;
    private final Optional<String> expectedAudience;
    private final Optional<String> expectedIssuer;
    private final Optional<String> expectedTypeHeader;
    private final boolean ignoreAudiences;
    private final boolean ignoreIssuer;
    private final boolean ignoreTypeHeader;

    static {
        Duration ofMinutes;
        ofMinutes = Duration.ofMinutes(10L);
        MAX_CLOCK_SKEW = ofMinutes;
    }

    private JwtValidator(Builder builder) {
        this.expectedTypeHeader = builder.expectedTypeHeader;
        this.ignoreTypeHeader = builder.ignoreTypeHeader;
        this.expectedIssuer = builder.expectedIssuer;
        this.ignoreIssuer = builder.ignoreIssuer;
        this.expectedAudience = builder.expectedAudience;
        this.ignoreAudiences = builder.ignoreAudiences;
        this.allowMissingExpiration = builder.allowMissingExpiration;
        this.expectIssuedInThePast = builder.expectIssuedInThePast;
        this.clock = builder.clock;
        this.clockSkew = builder.clockSkew;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        private boolean allowMissingExpiration;
        private Clock clock;
        private Duration clockSkew;
        private boolean expectIssuedInThePast;
        private Optional<String> expectedAudience;
        private Optional<String> expectedIssuer;
        private Optional<String> expectedTypeHeader;
        private boolean ignoreAudiences;
        private boolean ignoreIssuer;
        private boolean ignoreTypeHeader;

        private Builder() {
            Clock systemUTC;
            Duration duration;
            Optional<String> empty;
            Optional<String> empty2;
            Optional<String> empty3;
            systemUTC = Clock.systemUTC();
            this.clock = systemUTC;
            duration = Duration.ZERO;
            this.clockSkew = duration;
            empty = Optional.empty();
            this.expectedTypeHeader = empty;
            this.ignoreTypeHeader = false;
            empty2 = Optional.empty();
            this.expectedIssuer = empty2;
            this.ignoreIssuer = false;
            empty3 = Optional.empty();
            this.expectedAudience = empty3;
            this.ignoreAudiences = false;
            this.allowMissingExpiration = false;
            this.expectIssuedInThePast = false;
        }

        public Builder expectTypeHeader(String value) {
            Optional<String> of;
            if (value == null) {
                throw new NullPointerException("typ header cannot be null");
            }
            of = Optional.of(value);
            this.expectedTypeHeader = of;
            return this;
        }

        public Builder ignoreTypeHeader() {
            this.ignoreTypeHeader = true;
            return this;
        }

        public Builder expectIssuer(String value) {
            Optional<String> of;
            if (value == null) {
                throw new NullPointerException("issuer cannot be null");
            }
            of = Optional.of(value);
            this.expectedIssuer = of;
            return this;
        }

        public Builder ignoreIssuer() {
            this.ignoreIssuer = true;
            return this;
        }

        public Builder expectAudience(String value) {
            Optional<String> of;
            if (value == null) {
                throw new NullPointerException("audience cannot be null");
            }
            of = Optional.of(value);
            this.expectedAudience = of;
            return this;
        }

        public Builder ignoreAudiences() {
            this.ignoreAudiences = true;
            return this;
        }

        public Builder expectIssuedInThePast() {
            this.expectIssuedInThePast = true;
            return this;
        }

        public Builder setClock(Clock clock) {
            if (clock == null) {
                throw new NullPointerException("clock cannot be null");
            }
            this.clock = clock;
            return this;
        }

        public Builder setClockSkew(Duration clockSkew) {
            int compareTo;
            compareTo = clockSkew.compareTo(JwtValidator.MAX_CLOCK_SKEW);
            if (compareTo > 0) {
                throw new IllegalArgumentException("Clock skew too large, max is 10 minutes");
            }
            this.clockSkew = clockSkew;
            return this;
        }

        public Builder allowMissingExpiration() {
            this.allowMissingExpiration = true;
            return this;
        }

        public JwtValidator build() {
            boolean isPresent;
            boolean isPresent2;
            boolean isPresent3;
            if (this.ignoreTypeHeader) {
                isPresent3 = this.expectedTypeHeader.isPresent();
                if (isPresent3) {
                    throw new IllegalArgumentException("ignoreTypeHeader() and expectedTypeHeader() cannot be used together.");
                }
            }
            if (this.ignoreIssuer) {
                isPresent2 = this.expectedIssuer.isPresent();
                if (isPresent2) {
                    throw new IllegalArgumentException("ignoreIssuer() and expectedIssuer() cannot be used together.");
                }
            }
            if (this.ignoreAudiences) {
                isPresent = this.expectedAudience.isPresent();
                if (isPresent) {
                    throw new IllegalArgumentException("ignoreAudiences() and expectedAudience() cannot be used together.");
                }
            }
            return new JwtValidator(this);
        }
    }

    private void validateTypeHeader(RawJwt target) throws JwtInvalidException {
        boolean isPresent;
        Object obj;
        Object obj2;
        Object obj3;
        isPresent = this.expectedTypeHeader.isPresent();
        if (isPresent) {
            if (!target.hasTypeHeader()) {
                obj = this.expectedTypeHeader.get();
                throw new JwtInvalidException(String.format("invalid JWT; missing expected type header %s.", obj));
            }
            String typeHeader = target.getTypeHeader();
            obj2 = this.expectedTypeHeader.get();
            if (typeHeader.equals(obj2)) {
                return;
            }
            obj3 = this.expectedTypeHeader.get();
            throw new JwtInvalidException(String.format("invalid JWT; expected type header %s, but got %s", obj3, target.getTypeHeader()));
        }
        if (target.hasTypeHeader() && !this.ignoreTypeHeader) {
            throw new JwtInvalidException("invalid JWT; token has type header set, but validator not.");
        }
    }

    private void validateIssuer(RawJwt target) throws JwtInvalidException {
        boolean isPresent;
        Object obj;
        Object obj2;
        Object obj3;
        isPresent = this.expectedIssuer.isPresent();
        if (isPresent) {
            if (!target.hasIssuer()) {
                obj = this.expectedIssuer.get();
                throw new JwtInvalidException(String.format("invalid JWT; missing expected issuer %s.", obj));
            }
            String issuer = target.getIssuer();
            obj2 = this.expectedIssuer.get();
            if (issuer.equals(obj2)) {
                return;
            }
            obj3 = this.expectedIssuer.get();
            throw new JwtInvalidException(String.format("invalid JWT; expected issuer %s, but got %s", obj3, target.getIssuer()));
        }
        if (target.hasIssuer() && !this.ignoreIssuer) {
            throw new JwtInvalidException("invalid JWT; token has issuer set, but validator not.");
        }
    }

    private void validateAudiences(RawJwt target) throws JwtInvalidException {
        boolean isPresent;
        Object obj;
        Object obj2;
        isPresent = this.expectedAudience.isPresent();
        if (isPresent) {
            if (target.hasAudiences()) {
                List<String> audiences = target.getAudiences();
                obj2 = this.expectedAudience.get();
                if (audiences.contains(obj2)) {
                    return;
                }
            }
            obj = this.expectedAudience.get();
            throw new JwtInvalidException(String.format("invalid JWT; missing expected audience %s.", obj));
        }
        if (target.hasAudiences() && !this.ignoreAudiences) {
            throw new JwtInvalidException("invalid JWT; token has audience set, but validator not.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VerifiedJwt validate(RawJwt target) throws JwtInvalidException {
        validateTimestampClaims(target);
        validateTypeHeader(target);
        validateIssuer(target);
        validateAudiences(target);
        return new VerifiedJwt(target);
    }

    private void validateTimestampClaims(RawJwt target) throws JwtInvalidException {
        Instant instant;
        Instant plus;
        boolean isAfter;
        Instant plus2;
        boolean isAfter2;
        Instant minus;
        boolean isAfter3;
        instant = this.clock.instant();
        if (!target.hasExpiration() && !this.allowMissingExpiration) {
            throw new JwtInvalidException("token does not have an expiration set");
        }
        if (target.hasExpiration()) {
            Instant expiration = target.getExpiration();
            minus = instant.minus((TemporalAmount) this.clockSkew);
            isAfter3 = expiration.isAfter(minus);
            if (!isAfter3) {
                throw new JwtInvalidException("token has expired since " + target.getExpiration());
            }
        }
        if (target.hasNotBefore()) {
            Instant notBefore = target.getNotBefore();
            plus2 = instant.plus((TemporalAmount) this.clockSkew);
            isAfter2 = notBefore.isAfter(plus2);
            if (isAfter2) {
                throw new JwtInvalidException("token cannot be used before " + target.getNotBefore());
            }
        }
        if (this.expectIssuedInThePast) {
            if (!target.hasIssuedAt()) {
                throw new JwtInvalidException("token does not have an iat claim");
            }
            Instant issuedAt = target.getIssuedAt();
            plus = instant.plus((TemporalAmount) this.clockSkew);
            isAfter = issuedAt.isAfter(plus);
            if (isAfter) {
                throw new JwtInvalidException("token has a invalid iat claim in the future: " + target.getIssuedAt());
            }
        }
    }

    public String toString() {
        boolean isPresent;
        boolean isPresent2;
        boolean isPresent3;
        boolean isZero;
        Object obj;
        Object obj2;
        Object obj3;
        ArrayList<String> arrayList = new ArrayList();
        isPresent = this.expectedTypeHeader.isPresent();
        if (isPresent) {
            StringBuilder sb = new StringBuilder("expectedTypeHeader=");
            obj3 = this.expectedTypeHeader.get();
            sb.append((String) obj3);
            arrayList.add(sb.toString());
        }
        if (this.ignoreTypeHeader) {
            arrayList.add("ignoreTypeHeader");
        }
        isPresent2 = this.expectedIssuer.isPresent();
        if (isPresent2) {
            StringBuilder sb2 = new StringBuilder("expectedIssuer=");
            obj2 = this.expectedIssuer.get();
            sb2.append((String) obj2);
            arrayList.add(sb2.toString());
        }
        if (this.ignoreIssuer) {
            arrayList.add("ignoreIssuer");
        }
        isPresent3 = this.expectedAudience.isPresent();
        if (isPresent3) {
            StringBuilder sb3 = new StringBuilder("expectedAudience=");
            obj = this.expectedAudience.get();
            sb3.append((String) obj);
            arrayList.add(sb3.toString());
        }
        if (this.ignoreAudiences) {
            arrayList.add("ignoreAudiences");
        }
        if (this.allowMissingExpiration) {
            arrayList.add("allowMissingExpiration");
        }
        if (this.expectIssuedInThePast) {
            arrayList.add("expectIssuedInThePast");
        }
        isZero = this.clockSkew.isZero();
        if (!isZero) {
            arrayList.add("clockSkew=" + this.clockSkew);
        }
        StringBuilder sb4 = new StringBuilder("JwtValidator{");
        String str = "";
        for (String str2 : arrayList) {
            sb4.append(str);
            sb4.append(str2);
            str = f.a;
        }
        sb4.append("}");
        return sb4.toString();
    }
}
