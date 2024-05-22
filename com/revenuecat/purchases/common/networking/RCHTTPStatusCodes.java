package com.revenuecat.purchases.common.networking;

import kotlin.Metadata;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* compiled from: RCHTTPStatusCodes.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/common/networking/RCHTTPStatusCodes;", "", "()V", "BAD_REQUEST", "", DebugCoroutineInfoImplKt.CREATED, "ERROR", "NOT_FOUND", "NOT_MODIFIED", "SUCCESS", "UNSUCCESSFUL", "isServerError", "", "statusCode", "isSuccessful", "isSynced", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RCHTTPStatusCodes {
    public static final int BAD_REQUEST = 400;
    public static final int CREATED = 201;
    public static final int ERROR = 500;
    public static final RCHTTPStatusCodes INSTANCE = new RCHTTPStatusCodes();
    public static final int NOT_FOUND = 404;
    public static final int NOT_MODIFIED = 304;
    public static final int SUCCESS = 200;
    public static final int UNSUCCESSFUL = 300;

    public final boolean isServerError(int statusCode) {
        return statusCode >= 500;
    }

    public final boolean isSuccessful(int statusCode) {
        return statusCode < 400;
    }

    private RCHTTPStatusCodes() {
    }

    public final boolean isSynced(int statusCode) {
        return isSuccessful(statusCode) || !(isServerError(statusCode) || statusCode == 404);
    }
}
