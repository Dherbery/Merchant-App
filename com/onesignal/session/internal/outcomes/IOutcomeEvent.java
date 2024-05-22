package com.onesignal.session.internal.outcomes;

import com.onesignal.core.BuildConfig;
import com.onesignal.session.internal.influence.InfluenceType;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import kotlin.Metadata;
import org.json.JSONArray;

/* compiled from: IOutcomeEvent.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/onesignal/session/internal/outcomes/IOutcomeEvent;", "", "name", "", "getName", "()Ljava/lang/String;", "notificationIds", "Lorg/json/JSONArray;", "getNotificationIds", "()Lorg/json/JSONArray;", OutcomeEventsTable.COLUMN_NAME_SESSION, "Lcom/onesignal/session/internal/influence/InfluenceType;", "getSession", "()Lcom/onesignal/session/internal/influence/InfluenceType;", "sessionTime", "", "getSessionTime", "()J", "timestamp", "getTimestamp", "weight", "", "getWeight", "()F", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IOutcomeEvent {
    String getName();

    JSONArray getNotificationIds();

    InfluenceType getSession();

    long getSessionTime();

    long getTimestamp();

    float getWeight();
}
