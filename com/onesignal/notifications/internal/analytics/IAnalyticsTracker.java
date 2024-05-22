package com.onesignal.notifications.internal.analytics;

import com.google.firebase.messaging.Constants;
import com.onesignal.notifications.BuildConfig;
import kotlin.Metadata;

/* compiled from: IAnalyticsTracker.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\t"}, d2 = {"Lcom/onesignal/notifications/internal/analytics/IAnalyticsTracker;", "", "trackInfluenceOpenEvent", "", "trackOpenedEvent", "notificationId", "", Constants.ScionAnalytics.PARAM_CAMPAIGN, "trackReceivedEvent", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IAnalyticsTracker {
    void trackInfluenceOpenEvent();

    void trackOpenedEvent(String notificationId, String campaign);

    void trackReceivedEvent(String notificationId, String campaign);
}
