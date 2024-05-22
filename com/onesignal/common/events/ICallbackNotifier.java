package com.onesignal.common.events;

import com.onesignal.core.BuildConfig;
import kotlin.Metadata;

/* compiled from: ICallbackNotifier.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\nR\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/onesignal/common/events/ICallbackNotifier;", "THandler", "", "hasCallback", "", "getHasCallback", "()Z", "set", "", "handler", "(Ljava/lang/Object;)V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface ICallbackNotifier<THandler> {
    boolean getHasCallback();

    void set(THandler handler);
}
