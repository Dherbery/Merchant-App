package com.onesignal.common.events;

import com.google.firebase.messaging.Constants;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: EventProducer.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\rJ\u001a\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\rJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J5\u0010\u0014\u001a\u00020\u000b2\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J5\u0010\u0019\u001a\u00020\u000b2\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/onesignal/common/events/EventProducer;", "THandler", "Lcom/onesignal/common/events/IEventNotifier;", "()V", "hasSubscribers", "", "getHasSubscribers", "()Z", "subscribers", "", "fire", "", "callback", "Lkotlin/Function1;", "fireOnMain", "subscribe", "handler", "(Ljava/lang/Object;)V", "subscribeAll", Constants.MessagePayloadKeys.FROM, "suspendingFire", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendingFireOnMain", "unsubscribe", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public class EventProducer<THandler> implements IEventNotifier<THandler> {
    private final List<THandler> subscribers;

    public EventProducer() {
        List<THandler> synchronizedList = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(mutableListOf())");
        this.subscribers = synchronizedList;
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return CollectionsKt.any(this.subscribers);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(THandler handler) {
        synchronized (this.subscribers) {
            this.subscribers.add(handler);
        }
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(THandler handler) {
        synchronized (this.subscribers) {
            this.subscribers.remove(handler);
        }
    }

    public final void subscribeAll(EventProducer<THandler> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        synchronized (this.subscribers) {
            Iterator<THandler> it = from.subscribers.iterator();
            while (it.hasNext()) {
                subscribe(it.next());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void fire(Function1<? super THandler, Unit> callback) {
        List list;
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this.subscribers) {
            list = CollectionsKt.toList(this.subscribers);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            callback.invoke((Object) it.next());
        }
    }

    public final void fireOnMain(Function1<? super THandler, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadUtilsKt.suspendifyOnMain(new EventProducer$fireOnMain$1(this, callback, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object suspendingFire(kotlin.jvm.functions.Function2<? super THandler, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.onesignal.common.events.EventProducer$suspendingFire$1
            if (r0 == 0) goto L14
            r0 = r7
            com.onesignal.common.events.EventProducer$suspendingFire$1 r0 = (com.onesignal.common.events.EventProducer$suspendingFire$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.onesignal.common.events.EventProducer$suspendingFire$1 r0 = new com.onesignal.common.events.EventProducer$suspendingFire$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.L$1
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r2
            goto L51
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.List<THandler> r7 = r5.subscribers
            monitor-enter(r7)
            java.util.List<THandler> r2 = r5.subscribers     // Catch: java.lang.Throwable -> L6b
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch: java.lang.Throwable -> L6b
            java.util.List r2 = kotlin.collections.CollectionsKt.toList(r2)     // Catch: java.lang.Throwable -> L6b
            monitor-exit(r7)
            java.util.Iterator r7 = r2.iterator()
            r4 = r7
            r7 = r6
            r6 = r4
        L51:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L68
            java.lang.Object r2 = r6.next()
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r2 = r7.invoke(r2, r0)
            if (r2 != r1) goto L51
            return r1
        L68:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L6b:
            r6 = move-exception
            monitor-exit(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.common.events.EventProducer.suspendingFire(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object suspendingFireOnMain(Function2<? super THandler, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new EventProducer$suspendingFireOnMain$2(this, function2, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
