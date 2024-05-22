package expo.modules.crypto;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: DigestAlgorithm.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lexpo/modules/crypto/DigestAlgorithm;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", MessageDigestAlgorithms.MD5, "SHA1", "SHA256", "SHA384", "SHA512", "expo-crypto_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum DigestAlgorithm implements Enumerable {
    MD5(MessageDigestAlgorithms.MD5),
    SHA1(MessageDigestAlgorithms.SHA_1),
    SHA256(MessageDigestAlgorithms.SHA_256),
    SHA384(MessageDigestAlgorithms.SHA_384),
    SHA512(MessageDigestAlgorithms.SHA_512);

    private final String value;

    DigestAlgorithm(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
