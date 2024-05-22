package com.onesignal.location.internal;

import com.onesignal.core.BuildConfig;
import com.onesignal.location.ILocationManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: MisconfiguredLocationManager.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\t\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/onesignal/location/internal/MisconfiguredLocationManager;", "Lcom/onesignal/location/ILocationManager;", "()V", "value", "", "isShared", "()Z", "setShared", "(Z)V", "requestPermission", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class MisconfiguredLocationManager implements ILocationManager {
    private static final Exception EXCEPTION = new Exception("Must include gradle module com.onesignal:Location in order to use this functionality!");

    @Override // com.onesignal.location.ILocationManager
    public boolean isShared() {
        throw EXCEPTION;
    }

    @Override // com.onesignal.location.ILocationManager
    public void setShared(boolean z) {
        throw EXCEPTION;
    }

    @Override // com.onesignal.location.ILocationManager
    public Object requestPermission(Continuation<? super Boolean> continuation) {
        throw EXCEPTION;
    }
}
