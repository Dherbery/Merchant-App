package com.revenuecat.purchases.common.verification;

import android.util.Base64;
import com.amazon.a.a.o.b.f;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.utils.Result;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: SigningManager.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000b\u001a\u00020\u0007J,\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u001a\u0010\u000f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0011\u0018\u00010\u0010J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eJJ\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SigningManager;", "", "signatureVerificationMode", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "apiKey", "", "(Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;Lcom/revenuecat/purchases/common/AppConfig;Ljava/lang/String;)V", "getSignatureVerificationMode", "()Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "createRandomNonce", "getPostParamsForSigningHeaderIfNeeded", "endpoint", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "postFieldsToSign", "", "Lkotlin/Pair;", "shouldVerifyEndpoint", "", "verifyResponse", "Lcom/revenuecat/purchases/VerificationResult;", "urlPath", "signatureString", "nonce", TtmlNode.TAG_BODY, "requestTime", "eTag", "postFieldsToSignHeader", "Companion", "Parameters", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class SigningManager {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int NONCE_BYTES_SIZE = 12;

    @Deprecated
    public static final String POST_PARAMS_ALGORITHM = "sha256";

    @Deprecated
    public static final byte POST_PARAMS_SEPARATOR = 0;
    private final String apiKey;
    private final AppConfig appConfig;
    private final SignatureVerificationMode signatureVerificationMode;

    public SigningManager(SignatureVerificationMode signatureVerificationMode, AppConfig appConfig, String apiKey) {
        Intrinsics.checkNotNullParameter(signatureVerificationMode, "signatureVerificationMode");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        this.signatureVerificationMode = signatureVerificationMode;
        this.appConfig = appConfig;
        this.apiKey = apiKey;
    }

    public final SignatureVerificationMode getSignatureVerificationMode() {
        return this.signatureVerificationMode;
    }

    /* compiled from: SigningManager.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SigningManager$Companion;", "", "()V", "NONCE_BYTES_SIZE", "", "POST_PARAMS_ALGORITHM", "", "POST_PARAMS_SEPARATOR", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SigningManager.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003Ja\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006'"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SigningManager$Parameters;", "", "salt", "", "apiKey", "", "nonce", "urlPath", "postParamsHashHeader", "requestTime", "eTag", TtmlNode.TAG_BODY, "([BLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "getBody", "getETag", "getNonce", "getPostParamsHashHeader", "getRequestTime", "getSalt", "()[B", "getUrlPath", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toSignatureToVerify", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Parameters {
        private final String apiKey;
        private final String body;
        private final String eTag;
        private final String nonce;
        private final String postParamsHashHeader;
        private final String requestTime;
        private final byte[] salt;
        private final String urlPath;

        /* renamed from: component1, reason: from getter */
        public final byte[] getSalt() {
            return this.salt;
        }

        /* renamed from: component2, reason: from getter */
        public final String getApiKey() {
            return this.apiKey;
        }

        /* renamed from: component3, reason: from getter */
        public final String getNonce() {
            return this.nonce;
        }

        /* renamed from: component4, reason: from getter */
        public final String getUrlPath() {
            return this.urlPath;
        }

        /* renamed from: component5, reason: from getter */
        public final String getPostParamsHashHeader() {
            return this.postParamsHashHeader;
        }

        /* renamed from: component6, reason: from getter */
        public final String getRequestTime() {
            return this.requestTime;
        }

        /* renamed from: component7, reason: from getter */
        public final String getETag() {
            return this.eTag;
        }

        /* renamed from: component8, reason: from getter */
        public final String getBody() {
            return this.body;
        }

        public final Parameters copy(byte[] salt, String apiKey, String nonce, String urlPath, String postParamsHashHeader, String requestTime, String eTag, String body) {
            Intrinsics.checkNotNullParameter(salt, "salt");
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            Intrinsics.checkNotNullParameter(urlPath, "urlPath");
            Intrinsics.checkNotNullParameter(requestTime, "requestTime");
            return new Parameters(salt, apiKey, nonce, urlPath, postParamsHashHeader, requestTime, eTag, body);
        }

        public String toString() {
            return "Parameters(salt=" + Arrays.toString(this.salt) + ", apiKey=" + this.apiKey + ", nonce=" + this.nonce + ", urlPath=" + this.urlPath + ", postParamsHashHeader=" + this.postParamsHashHeader + ", requestTime=" + this.requestTime + ", eTag=" + this.eTag + ", body=" + this.body + ')';
        }

        public Parameters(byte[] salt, String apiKey, String str, String urlPath, String str2, String requestTime, String str3, String str4) {
            Intrinsics.checkNotNullParameter(salt, "salt");
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            Intrinsics.checkNotNullParameter(urlPath, "urlPath");
            Intrinsics.checkNotNullParameter(requestTime, "requestTime");
            this.salt = salt;
            this.apiKey = apiKey;
            this.nonce = str;
            this.urlPath = urlPath;
            this.postParamsHashHeader = str2;
            this.requestTime = requestTime;
            this.eTag = str3;
            this.body = str4;
        }

        public final byte[] getSalt() {
            return this.salt;
        }

        public final String getApiKey() {
            return this.apiKey;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final String getUrlPath() {
            return this.urlPath;
        }

        public final String getPostParamsHashHeader() {
            return this.postParamsHashHeader;
        }

        public final String getRequestTime() {
            return this.requestTime;
        }

        public final String getETag() {
            return this.eTag;
        }

        public final String getBody() {
            return this.body;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.revenuecat.purchases.common.verification.SigningManager.Parameters");
            Parameters parameters = (Parameters) other;
            return Arrays.equals(this.salt, parameters.salt) && Intrinsics.areEqual(this.apiKey, parameters.apiKey) && Intrinsics.areEqual(this.nonce, parameters.nonce) && Intrinsics.areEqual(this.urlPath, parameters.urlPath) && Intrinsics.areEqual(this.postParamsHashHeader, parameters.postParamsHashHeader) && Intrinsics.areEqual(this.requestTime, parameters.requestTime) && Intrinsics.areEqual(this.eTag, parameters.eTag) && Intrinsics.areEqual(this.body, parameters.body);
        }

        public int hashCode() {
            int hashCode = ((Arrays.hashCode(this.salt) * 31) + this.apiKey.hashCode()) * 31;
            String str = this.nonce;
            int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.urlPath.hashCode()) * 31;
            String str2 = this.postParamsHashHeader;
            int hashCode3 = (((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.requestTime.hashCode()) * 31;
            String str3 = this.eTag;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.body;
            return hashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0066, code lost:
        
            if (r1 == null) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x007b, code lost:
        
            if (r1 == null) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
        
            if (r1 == null) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final byte[] toSignatureToVerify() {
            /*
                r5 = this;
                byte[] r0 = r5.salt
                java.lang.String r1 = r5.apiKey
                java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
                byte[] r1 = r1.getBytes(r2)
                java.lang.String r2 = "this as java.lang.String).getBytes(charset)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                byte[] r0 = kotlin.collections.ArraysKt.plus(r0, r1)
                java.lang.String r1 = r5.nonce
                r3 = 0
                if (r1 == 0) goto L1d
                byte[] r1 = android.util.Base64.decode(r1, r3)
                goto L1e
            L1d:
                r1 = 0
            L1e:
                if (r1 != 0) goto L22
                byte[] r1 = new byte[r3]
            L22:
                byte[] r0 = kotlin.collections.ArraysKt.plus(r0, r1)
                java.lang.String r1 = r5.urlPath
                java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8
                byte[] r1 = r1.getBytes(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                byte[] r0 = kotlin.collections.ArraysKt.plus(r0, r1)
                java.lang.String r1 = r5.postParamsHashHeader
                if (r1 == 0) goto L44
                java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8
                byte[] r1 = r1.getBytes(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                if (r1 != 0) goto L46
            L44:
                byte[] r1 = new byte[r3]
            L46:
                byte[] r0 = kotlin.collections.ArraysKt.plus(r0, r1)
                java.lang.String r1 = r5.requestTime
                java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8
                byte[] r1 = r1.getBytes(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                byte[] r0 = kotlin.collections.ArraysKt.plus(r0, r1)
                java.lang.String r1 = r5.eTag
                if (r1 == 0) goto L68
                java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8
                byte[] r1 = r1.getBytes(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                if (r1 != 0) goto L6a
            L68:
                byte[] r1 = new byte[r3]
            L6a:
                byte[] r0 = kotlin.collections.ArraysKt.plus(r0, r1)
                java.lang.String r1 = r5.body
                if (r1 == 0) goto L7d
                java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8
                byte[] r1 = r1.getBytes(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                if (r1 != 0) goto L7f
            L7d:
                byte[] r1 = new byte[r3]
            L7f:
                byte[] r0 = kotlin.collections.ArraysKt.plus(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.verification.SigningManager.Parameters.toSignatureToVerify():byte[]");
        }
    }

    public final boolean shouldVerifyEndpoint(Endpoint endpoint) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        return endpoint.getSupportsSignatureVerification() && this.signatureVerificationMode.getShouldVerify();
    }

    public final String createRandomNonce() {
        byte[] bArr = new byte[12];
        new SecureRandom().nextBytes(bArr);
        byte[] encode = Base64.encode(bArr, 0);
        Intrinsics.checkNotNullExpressionValue(encode, "encode(bytes, Base64.DEFAULT)");
        return StringsKt.trim((CharSequence) new String(encode, Charsets.UTF_8)).toString();
    }

    public final String getPostParamsForSigningHeaderIfNeeded(Endpoint endpoint, List<Pair<String, String>> postFieldsToSign) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        List<Pair<String, String>> list = postFieldsToSign;
        if ((list == null || list.isEmpty()) || !shouldVerifyEndpoint(endpoint)) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        List<Pair<String, String>> list2 = postFieldsToSign;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i = 0;
        for (Object obj : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            if (i > 0) {
                messageDigest.update((byte) 0);
            }
            byte[] bytes = ((String) pair.getSecond()).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            arrayList.add(Unit.INSTANCE);
            i = i2;
        }
        byte[] digest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "sha256Digest.digest()");
        String str = "";
        for (byte b : digest) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            sb.append(format);
            str = sb.toString();
        }
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{CollectionsKt.joinToString$default(list2, f.a, null, null, 0, null, new Function1<Pair<? extends String, ? extends String>, CharSequence>() { // from class: com.revenuecat.purchases.common.verification.SigningManager$getPostParamsForSigningHeaderIfNeeded$header$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Pair<String, String> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getFirst();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Pair<? extends String, ? extends String> pair2) {
                return invoke2((Pair<String, String>) pair2);
            }
        }, 30, null), POST_PARAMS_ALGORITHM, str}), Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, null, null, 0, null, null, 62, null);
    }

    public final VerificationResult verifyResponse(String urlPath, String signatureString, String nonce, String body, String requestTime, String eTag, String postFieldsToSignHeader) {
        Intrinsics.checkNotNullParameter(urlPath, "urlPath");
        if (this.appConfig.getForceSigningErrors()) {
            LogUtilsKt.warnLog("Forcing signing error for request with path: " + urlPath);
            return VerificationResult.FAILED;
        }
        IntermediateSignatureHelper intermediateSignatureHelper = this.signatureVerificationMode.getIntermediateSignatureHelper();
        if (intermediateSignatureHelper == null) {
            return VerificationResult.NOT_REQUESTED;
        }
        if (signatureString == null) {
            String format = String.format(NetworkStrings.VERIFICATION_MISSING_SIGNATURE, Arrays.copyOf(new Object[]{urlPath}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogUtilsKt.errorLog$default(format, null, 2, null);
            return VerificationResult.FAILED;
        }
        if (requestTime == null) {
            String format2 = String.format(NetworkStrings.VERIFICATION_MISSING_REQUEST_TIME, Arrays.copyOf(new Object[]{urlPath}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
            LogUtilsKt.errorLog$default(format2, null, 2, null);
            return VerificationResult.FAILED;
        }
        if (body == null && eTag == null) {
            String format3 = String.format(NetworkStrings.VERIFICATION_MISSING_BODY_OR_ETAG, Arrays.copyOf(new Object[]{urlPath}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
            LogUtilsKt.errorLog$default(format3, null, 2, null);
            return VerificationResult.FAILED;
        }
        try {
            Signature fromString$purchases_defaultsRelease = Signature.INSTANCE.fromString$purchases_defaultsRelease(signatureString);
            Result<SignatureVerifier, PurchasesError> createIntermediateKeyVerifierIfVerified = intermediateSignatureHelper.createIntermediateKeyVerifierIfVerified(fromString$purchases_defaultsRelease);
            if (createIntermediateKeyVerifierIfVerified instanceof Result.Error) {
                String format4 = String.format(NetworkStrings.VERIFICATION_INTERMEDIATE_KEY_FAILED, Arrays.copyOf(new Object[]{urlPath, ((PurchasesError) ((Result.Error) createIntermediateKeyVerifierIfVerified).getValue()).getUnderlyingErrorMessage()}, 2));
                Intrinsics.checkNotNullExpressionValue(format4, "format(this, *args)");
                LogUtilsKt.errorLog$default(format4, null, 2, null);
                return VerificationResult.FAILED;
            }
            if (createIntermediateKeyVerifierIfVerified instanceof Result.Success) {
                if (((SignatureVerifier) ((Result.Success) createIntermediateKeyVerifierIfVerified).getValue()).verify(fromString$purchases_defaultsRelease.getPayload(), new Parameters(fromString$purchases_defaultsRelease.getSalt(), this.apiKey, nonce, urlPath, postFieldsToSignHeader, requestTime, eTag, body).toSignatureToVerify())) {
                    String format5 = String.format(NetworkStrings.VERIFICATION_SUCCESS, Arrays.copyOf(new Object[]{urlPath}, 1));
                    Intrinsics.checkNotNullExpressionValue(format5, "format(this, *args)");
                    LogUtilsKt.verboseLog(format5);
                    return VerificationResult.VERIFIED;
                }
                String format6 = String.format(NetworkStrings.VERIFICATION_ERROR, Arrays.copyOf(new Object[]{urlPath}, 1));
                Intrinsics.checkNotNullExpressionValue(format6, "format(this, *args)");
                LogUtilsKt.errorLog$default(format6, null, 2, null);
                return VerificationResult.FAILED;
            }
            throw new NoWhenBranchMatchedException();
        } catch (InvalidSignatureSizeException e) {
            String format7 = String.format(NetworkStrings.VERIFICATION_INVALID_SIZE, Arrays.copyOf(new Object[]{urlPath, e.getMessage()}, 2));
            Intrinsics.checkNotNullExpressionValue(format7, "format(this, *args)");
            LogUtilsKt.errorLog$default(format7, null, 2, null);
            return VerificationResult.FAILED;
        }
    }
}
