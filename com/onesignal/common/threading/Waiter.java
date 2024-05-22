package com.onesignal.common.threading;

import com.onesignal.core.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* compiled from: Waiter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bR\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/onesignal/common/threading/Waiter;", "", "()V", "channel", "Lkotlinx/coroutines/channels/Channel;", "waitForWake", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wake", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class Waiter {
    private final Channel<Object> channel = ChannelKt.Channel$default(-1, null, null, 6, null);

    public final Object waitForWake(Continuation<Object> continuation) {
        return this.channel.receive(continuation);
    }

    public final void wake() {
        Object obj = this.channel.mo2872trySendJP2dKIU(null);
        if (ChannelResult.m2891isFailureimpl(obj)) {
            throw new Exception("Waiter.wait failed", ChannelResult.m2886exceptionOrNullimpl(obj));
        }
    }
}
