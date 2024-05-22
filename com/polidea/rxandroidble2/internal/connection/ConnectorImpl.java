package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.ConnectionSetup;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.connection.ConnectionComponent;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public class ConnectorImpl implements Connector {
    final Scheduler callbacksScheduler;
    private final ClientOperationQueue clientOperationQueue;
    final ConnectionComponent.Builder connectionComponentBuilder;

    @Inject
    public ConnectorImpl(ClientOperationQueue clientOperationQueue, ConnectionComponent.Builder builder, @Named("bluetooth_callbacks") Scheduler scheduler) {
        this.clientOperationQueue = clientOperationQueue;
        this.connectionComponentBuilder = builder;
        this.callbacksScheduler = scheduler;
    }

    @Override // com.polidea.rxandroidble2.internal.connection.Connector
    public Observable<RxBleConnection> prepareConnection(final ConnectionSetup connectionSetup) {
        return Observable.defer(new Callable() { // from class: com.polidea.rxandroidble2.internal.connection.ConnectorImpl$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ConnectorImpl.this.m1049x897ec21e(connectionSetup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$prepareConnection$2$com-polidea-rxandroidble2-internal-connection-ConnectorImpl, reason: not valid java name */
    public /* synthetic */ ObservableSource m1049x897ec21e(ConnectionSetup connectionSetup) throws Exception {
        ConnectionComponent build = this.connectionComponentBuilder.autoConnect(connectionSetup.autoConnect).suppressOperationChecks(connectionSetup.suppressOperationCheck).operationTimeout(connectionSetup.operationTimeout).build();
        final Set<ConnectionSubscriptionWatcher> connectionSubscriptionWatchers = build.connectionSubscriptionWatchers();
        return obtainRxBleConnection(build).mergeWith(observeDisconnections(build)).delaySubscription(enqueueConnectOperation(build)).doOnSubscribe(new Consumer() { // from class: com.polidea.rxandroidble2.internal.connection.ConnectorImpl$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ConnectorImpl.lambda$prepareConnection$0(connectionSubscriptionWatchers, (Disposable) obj);
            }
        }).doFinally(new Action() { // from class: com.polidea.rxandroidble2.internal.connection.ConnectorImpl$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Action
            public final void run() {
                ConnectorImpl.lambda$prepareConnection$1(connectionSubscriptionWatchers);
            }
        }).subscribeOn(this.callbacksScheduler).unsubscribeOn(this.callbacksScheduler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$prepareConnection$0(Set set, Disposable disposable) throws Exception {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ConnectionSubscriptionWatcher) it.next()).onConnectionSubscribed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$prepareConnection$1(Set set) throws Exception {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ConnectionSubscriptionWatcher) it.next()).onConnectionUnsubscribed();
        }
    }

    static Observable<RxBleConnection> obtainRxBleConnection(final ConnectionComponent connectionComponent) {
        Objects.requireNonNull(connectionComponent);
        return Observable.fromCallable(new Callable() { // from class: com.polidea.rxandroidble2.internal.connection.ConnectorImpl$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ConnectionComponent.this.rxBleConnection();
            }
        });
    }

    static Observable<RxBleConnection> observeDisconnections(ConnectionComponent connectionComponent) {
        return connectionComponent.gattCallback().observeDisconnect();
    }

    Observable<BluetoothGatt> enqueueConnectOperation(ConnectionComponent connectionComponent) {
        return this.clientOperationQueue.queue(connectionComponent.connectOperation());
    }
}
