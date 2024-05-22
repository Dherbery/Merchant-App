package com.onesignal.inAppMessages.internal.backend;

import com.facebook.common.util.UriUtil;
import com.onesignal.inAppMessages.BuildConfig;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import kotlin.Metadata;

/* compiled from: IInAppBackendService.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/onesignal/inAppMessages/internal/backend/GetIAMDataResponse;", "", UriUtil.LOCAL_CONTENT_SCHEME, "Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "shouldRetry", "", "(Lcom/onesignal/inAppMessages/internal/InAppMessageContent;Z)V", "getContent", "()Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "getShouldRetry", "()Z", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class GetIAMDataResponse {
    private final InAppMessageContent content;
    private final boolean shouldRetry;

    public GetIAMDataResponse(InAppMessageContent inAppMessageContent, boolean z) {
        this.content = inAppMessageContent;
        this.shouldRetry = z;
    }

    public final InAppMessageContent getContent() {
        return this.content;
    }

    public final boolean getShouldRetry() {
        return this.shouldRetry;
    }
}
