package com.onesignal.session.internal;

import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.BuildConfig;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.ISessionManager;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionManager.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/onesignal/session/internal/SessionManager;", "Lcom/onesignal/session/ISessionManager;", "_outcomeController", "Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;", "(Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;)V", "addOutcome", "", "name", "", "addOutcomeWithValue", "value", "", "addUniqueOutcome", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public class SessionManager implements ISessionManager {
    private final IOutcomeEventsController _outcomeController;

    public SessionManager(IOutcomeEventsController _outcomeController) {
        Intrinsics.checkNotNullParameter(_outcomeController, "_outcomeController");
        this._outcomeController = _outcomeController;
    }

    @Override // com.onesignal.session.ISessionManager
    public void addOutcome(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Logging.log(LogLevel.DEBUG, "sendOutcome(name: " + name + ')');
        ThreadUtilsKt.suspendifyOnThread$default(0, new SessionManager$addOutcome$1(this, name, null), 1, null);
    }

    @Override // com.onesignal.session.ISessionManager
    public void addUniqueOutcome(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Logging.log(LogLevel.DEBUG, "sendUniqueOutcome(name: " + name + ')');
        ThreadUtilsKt.suspendifyOnThread$default(0, new SessionManager$addUniqueOutcome$1(this, name, null), 1, null);
    }

    @Override // com.onesignal.session.ISessionManager
    public void addOutcomeWithValue(String name, float value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Logging.log(LogLevel.DEBUG, "sendOutcomeWithValue(name: " + name + ", value: " + value + ')');
        ThreadUtilsKt.suspendifyOnThread$default(0, new SessionManager$addOutcomeWithValue$1(this, name, value, null), 1, null);
    }
}
