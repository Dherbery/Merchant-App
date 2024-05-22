package com.revenuecat.purchases.common.verification;

import kotlin.Metadata;

/* compiled from: SignatureVerifier.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SignatureVerifier;", "", "verify", "", "signatureToVerify", "", "messageToVerify", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface SignatureVerifier {
    boolean verify(byte[] signatureToVerify, byte[] messageToVerify);
}
