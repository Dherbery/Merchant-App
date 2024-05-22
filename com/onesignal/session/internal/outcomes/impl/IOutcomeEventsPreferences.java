package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.core.BuildConfig;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: IOutcomeEventsPreferences.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001R \u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsPreferences;", "", "unattributedUniqueOutcomeEventsSentByChannel", "", "", "getUnattributedUniqueOutcomeEventsSentByChannel", "()Ljava/util/Set;", "setUnattributedUniqueOutcomeEventsSentByChannel", "(Ljava/util/Set;)V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IOutcomeEventsPreferences {
    Set<String> getUnattributedUniqueOutcomeEventsSentByChannel();

    void setUnattributedUniqueOutcomeEventsSentByChannel(Set<String> set);
}
