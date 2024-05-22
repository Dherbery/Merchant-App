package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/* compiled from: IdentityStrings.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/strings/IdentityStrings;", "", "()V", "EMPTY_APP_USER_ID_WILL_BECOME_ANONYMOUS", "", "IDENTIFYING_APP_USER_ID", "INVALIDATING_CACHED_CUSTOMER_INFO", "LOGGING_IN", "LOG_IN_ERROR_MISSING_APP_USER_ID", "LOG_IN_SUCCESSFUL", "LOG_OUT_CALLED_ON_ANONYMOUS_USER", "LOG_OUT_SUCCESSFUL", "SETTING_NEW_ANON_ID", "SWITCHING_USER", "SWITCHING_USER_SAME_APP_USER_ID", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class IdentityStrings {
    public static final String EMPTY_APP_USER_ID_WILL_BECOME_ANONYMOUS = "Identifying with empty App User ID will be treated as anonymous.";
    public static final String IDENTIFYING_APP_USER_ID = "Identifying App User ID: %s";
    public static final IdentityStrings INSTANCE = new IdentityStrings();
    public static final String INVALIDATING_CACHED_CUSTOMER_INFO = "Detected unverified cached CustomerInfo but verification is enabled. Invalidating cache.";
    public static final String LOGGING_IN = "Logging in from %s -> %s";
    public static final String LOG_IN_ERROR_MISSING_APP_USER_ID = "Error logging in: appUserID can't be null, empty or blank";
    public static final String LOG_IN_SUCCESSFUL = "Logged in successfully as %s. Created: %s";
    public static final String LOG_OUT_CALLED_ON_ANONYMOUS_USER = "Called logOut but the current user is anonymous";
    public static final String LOG_OUT_SUCCESSFUL = "Logged out successfully";
    public static final String SETTING_NEW_ANON_ID = "Setting new anonymous App User ID - %s";
    public static final String SWITCHING_USER = "Switching to user %s.";
    public static final String SWITCHING_USER_SAME_APP_USER_ID = "switchUser called with the same appUserID as the current user %s. This has no effect.";

    private IdentityStrings() {
    }
}
