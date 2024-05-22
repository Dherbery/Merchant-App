package com.onesignal.notifications.internal.data.impl;

import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.data.INotificationQueryHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationQueryHelper.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/onesignal/notifications/internal/data/impl/NotificationQueryHelper;", "Lcom/onesignal/notifications/internal/data/INotificationQueryHelper;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/time/ITime;)V", "recentUninteractedWithNotificationsWhere", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationQueryHelper implements INotificationQueryHelper {
    private final ConfigModelStore _configModelStore;
    private final ITime _time;

    public NotificationQueryHelper(ConfigModelStore _configModelStore, ITime _time) {
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_time, "_time");
        this._configModelStore = _configModelStore;
        this._time = _time;
    }

    @Override // com.onesignal.notifications.internal.data.INotificationQueryHelper
    public StringBuilder recentUninteractedWithNotificationsWhere() {
        long currentTimeMillis = this._time.getCurrentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder("created_time > " + (currentTimeMillis - 604800) + " AND dismissed = 0 AND opened = 0 AND is_summary = 0");
        if (this._configModelStore.getModel().getRestoreTTLFilter()) {
            sb.append(" AND expire_time > " + currentTimeMillis);
        }
        return sb;
    }
}
