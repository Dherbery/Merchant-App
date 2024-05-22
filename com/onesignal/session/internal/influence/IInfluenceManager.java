package com.onesignal.session.internal.influence;

import com.onesignal.core.BuildConfig;
import java.util.List;
import kotlin.Metadata;

/* compiled from: IInfluenceManager.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/onesignal/session/internal/influence/IInfluenceManager;", "", "influences", "", "Lcom/onesignal/session/internal/influence/Influence;", "getInfluences", "()Ljava/util/List;", "onDirectInfluenceFromIAM", "", "messageId", "", "onDirectInfluenceFromNotification", "notificationId", "onInAppMessageDismissed", "onInAppMessageDisplayed", "onNotificationReceived", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IInfluenceManager {
    List<Influence> getInfluences();

    void onDirectInfluenceFromIAM(String messageId);

    void onDirectInfluenceFromNotification(String notificationId);

    void onInAppMessageDismissed();

    void onInAppMessageDisplayed(String messageId);

    void onNotificationReceived(String notificationId);
}
