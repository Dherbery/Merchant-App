package com.onesignal.inAppMessages.internal.triggers;

import com.onesignal.inAppMessages.BuildConfig;
import kotlin.Metadata;

/* compiled from: ITriggerHandler.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/ITriggerHandler;", "", "onTriggerChanged", "", "newTriggerKey", "", "onTriggerCompleted", "triggerId", "onTriggerConditionChanged", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface ITriggerHandler {
    void onTriggerChanged(String newTriggerKey);

    void onTriggerCompleted(String triggerId);

    void onTriggerConditionChanged();
}
