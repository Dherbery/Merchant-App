package com.revenuecat.purchases.common;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: errors.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "", "keyName", "", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "(Ljava/lang/String;Ljava/lang/String;)V", "getKeyName", "()Ljava/lang/String;", "getMessage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SubscriberAttributeError {
    private final String keyName;
    private final String message;

    public static /* synthetic */ SubscriberAttributeError copy$default(SubscriberAttributeError subscriberAttributeError, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subscriberAttributeError.keyName;
        }
        if ((i & 2) != 0) {
            str2 = subscriberAttributeError.message;
        }
        return subscriberAttributeError.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKeyName() {
        return this.keyName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final SubscriberAttributeError copy(String keyName, String message) {
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        Intrinsics.checkNotNullParameter(message, "message");
        return new SubscriberAttributeError(keyName, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriberAttributeError)) {
            return false;
        }
        SubscriberAttributeError subscriberAttributeError = (SubscriberAttributeError) other;
        return Intrinsics.areEqual(this.keyName, subscriberAttributeError.keyName) && Intrinsics.areEqual(this.message, subscriberAttributeError.message);
    }

    public int hashCode() {
        return (this.keyName.hashCode() * 31) + this.message.hashCode();
    }

    public String toString() {
        return "SubscriberAttributeError(keyName=" + this.keyName + ", message=" + this.message + ')';
    }

    public SubscriberAttributeError(String keyName, String message) {
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        Intrinsics.checkNotNullParameter(message, "message");
        this.keyName = keyName;
        this.message = message;
    }

    public final String getKeyName() {
        return this.keyName;
    }

    public final String getMessage() {
        return this.message;
    }
}
