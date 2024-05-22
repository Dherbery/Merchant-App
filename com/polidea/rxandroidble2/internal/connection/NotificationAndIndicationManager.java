package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.NotificationSetupMode;
import com.polidea.rxandroidble2.exceptions.BleCannotSetCharacteristicNotificationException;
import com.polidea.rxandroidble2.exceptions.BleConflictingNotificationAlreadySetException;
import com.polidea.rxandroidble2.internal.util.ActiveCharacteristicNotification;
import com.polidea.rxandroidble2.internal.util.CharacteristicChangedEvent;
import com.polidea.rxandroidble2.internal.util.CharacteristicNotificationId;
import com.polidea.rxandroidble2.internal.util.ObservableUtil;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.subjects.PublishSubject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
@ConnectionScope
/* loaded from: classes5.dex */
public class NotificationAndIndicationManager {
    static final UUID CLIENT_CHARACTERISTIC_CONFIG_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    final Map<CharacteristicNotificationId, ActiveCharacteristicNotification> activeNotificationObservableMap = new HashMap();
    final BluetoothGatt bluetoothGatt;
    final byte[] configDisable;
    final byte[] configEnableIndication;
    final byte[] configEnableNotification;
    final DescriptorWriter descriptorWriter;
    final RxBleGattCallback gattCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public NotificationAndIndicationManager(@Named("enable-notification-value") byte[] bArr, @Named("enable-indication-value") byte[] bArr2, @Named("disable-notification-value") byte[] bArr3, BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, DescriptorWriter descriptorWriter) {
        this.configEnableNotification = bArr;
        this.configEnableIndication = bArr2;
        this.configDisable = bArr3;
        this.bluetoothGatt = bluetoothGatt;
        this.gattCallback = rxBleGattCallback;
        this.descriptorWriter = descriptorWriter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Observable<Observable<byte[]>> setupServerInitiatedCharacteristicRead(final BluetoothGattCharacteristic bluetoothGattCharacteristic, final NotificationSetupMode notificationSetupMode, final boolean z) {
        return Observable.defer(new Callable() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NotificationAndIndicationManager.this.m1051xff447fe3(bluetoothGattCharacteristic, z, notificationSetupMode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setupServerInitiatedCharacteristicRead$2$com-polidea-rxandroidble2-internal-connection-NotificationAndIndicationManager, reason: not valid java name */
    public /* synthetic */ ObservableSource m1051xff447fe3(final BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, final NotificationSetupMode notificationSetupMode) throws Exception {
        synchronized (this.activeNotificationObservableMap) {
            final CharacteristicNotificationId characteristicNotificationId = new CharacteristicNotificationId(bluetoothGattCharacteristic.getUuid(), Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()));
            ActiveCharacteristicNotification activeCharacteristicNotification = this.activeNotificationObservableMap.get(characteristicNotificationId);
            boolean z2 = true;
            if (activeCharacteristicNotification != null) {
                if (activeCharacteristicNotification.isIndication == z) {
                    return activeCharacteristicNotification.notificationObservable;
                }
                UUID uuid = bluetoothGattCharacteristic.getUuid();
                if (z) {
                    z2 = false;
                }
                return Observable.error(new BleConflictingNotificationAlreadySetException(uuid, z2));
            }
            byte[] bArr = z ? this.configEnableIndication : this.configEnableNotification;
            final PublishSubject create = PublishSubject.create();
            Observable refCount = setCharacteristicNotification(this.bluetoothGatt, bluetoothGattCharacteristic, true).andThen(ObservableUtil.justOnNext(observeOnCharacteristicChangeCallbacks(this.gattCallback, characteristicNotificationId))).compose(setupModeTransformer(this.descriptorWriter, bluetoothGattCharacteristic, bArr, notificationSetupMode)).map(new Function() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda7
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Observable amb;
                    amb = Observable.amb(Arrays.asList(r0.cast(byte[].class), ((Observable) obj).takeUntil(PublishSubject.this)));
                    return amb;
                }
            }).doFinally(new Action() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda8
                @Override // io.reactivex.functions.Action
                public final void run() {
                    NotificationAndIndicationManager.this.m1050x21511a04(create, characteristicNotificationId, bluetoothGattCharacteristic, notificationSetupMode);
                }
            }).mergeWith(this.gattCallback.observeDisconnect()).replay(1).refCount();
            this.activeNotificationObservableMap.put(characteristicNotificationId, new ActiveCharacteristicNotification(refCount, z));
            return refCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setupServerInitiatedCharacteristicRead$1$com-polidea-rxandroidble2-internal-connection-NotificationAndIndicationManager, reason: not valid java name */
    public /* synthetic */ void m1050x21511a04(PublishSubject publishSubject, CharacteristicNotificationId characteristicNotificationId, BluetoothGattCharacteristic bluetoothGattCharacteristic, NotificationSetupMode notificationSetupMode) throws Exception {
        publishSubject.onComplete();
        synchronized (this.activeNotificationObservableMap) {
            this.activeNotificationObservableMap.remove(characteristicNotificationId);
        }
        setCharacteristicNotification(this.bluetoothGatt, bluetoothGattCharacteristic, false).compose(teardownModeTransformer(this.descriptorWriter, bluetoothGattCharacteristic, this.configDisable, notificationSetupMode)).subscribe(Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    static Completable setCharacteristicNotification(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final boolean z) {
        return Completable.fromAction(new Action() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Action
            public final void run() {
                NotificationAndIndicationManager.lambda$setCharacteristicNotification$3(bluetoothGatt, bluetoothGattCharacteristic, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setCharacteristicNotification$3(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) throws Exception {
        if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z)) {
            throw new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode;

        static {
            int[] iArr = new int[NotificationSetupMode.values().length];
            $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode = iArr;
            try {
                iArr[NotificationSetupMode.COMPAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode[NotificationSetupMode.QUICK_SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode[NotificationSetupMode.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static ObservableTransformer<Observable<byte[]>, Observable<byte[]>> setupModeTransformer(final DescriptorWriter descriptorWriter, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final byte[] bArr, final NotificationSetupMode notificationSetupMode) {
        return new ObservableTransformer() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableTransformer
            /* renamed from: apply */
            public final ObservableSource apply2(Observable observable) {
                return NotificationAndIndicationManager.lambda$setupModeTransformer$5(NotificationSetupMode.this, bluetoothGattCharacteristic, descriptorWriter, bArr, observable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$setupModeTransformer$5(NotificationSetupMode notificationSetupMode, BluetoothGattCharacteristic bluetoothGattCharacteristic, DescriptorWriter descriptorWriter, byte[] bArr, Observable observable) {
        int i = AnonymousClass1.$SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode[notificationSetupMode.ordinal()];
        if (i == 1) {
            return observable;
        }
        if (i == 2) {
            final Completable ignoreElements = writeClientCharacteristicConfig(bluetoothGattCharacteristic, descriptorWriter, bArr).toObservable().publish().autoConnect(2).ignoreElements();
            return observable.mergeWith(ignoreElements).map(new Function() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda9
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Observable mergeWith;
                    mergeWith = ((Observable) obj).mergeWith(Completable.this.onErrorComplete());
                    return mergeWith;
                }
            });
        }
        return writeClientCharacteristicConfig(bluetoothGattCharacteristic, descriptorWriter, bArr).andThen(observable);
    }

    static CompletableTransformer teardownModeTransformer(final DescriptorWriter descriptorWriter, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final byte[] bArr, final NotificationSetupMode notificationSetupMode) {
        return new CompletableTransformer() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda1
            @Override // io.reactivex.CompletableTransformer
            public final CompletableSource apply(Completable completable) {
                return NotificationAndIndicationManager.lambda$teardownModeTransformer$6(NotificationSetupMode.this, bluetoothGattCharacteristic, descriptorWriter, bArr, completable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ CompletableSource lambda$teardownModeTransformer$6(NotificationSetupMode notificationSetupMode, BluetoothGattCharacteristic bluetoothGattCharacteristic, DescriptorWriter descriptorWriter, byte[] bArr, Completable completable) {
        return notificationSetupMode == NotificationSetupMode.COMPAT ? completable : completable.andThen(writeClientCharacteristicConfig(bluetoothGattCharacteristic, descriptorWriter, bArr));
    }

    static Observable<byte[]> observeOnCharacteristicChangeCallbacks(RxBleGattCallback rxBleGattCallback, final CharacteristicNotificationId characteristicNotificationId) {
        return rxBleGattCallback.getOnCharacteristicChanged().filter(new Predicate() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean equals;
                equals = ((CharacteristicChangedEvent) obj).equals(CharacteristicNotificationId.this);
                return equals;
            }
        }).map(new Function() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                byte[] bArr;
                bArr = ((CharacteristicChangedEvent) obj).data;
                return bArr;
            }
        });
    }

    static Completable writeClientCharacteristicConfig(final BluetoothGattCharacteristic bluetoothGattCharacteristic, DescriptorWriter descriptorWriter, byte[] bArr) {
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_UUID);
        if (descriptor == null) {
            return Completable.error(new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 2, null));
        }
        return descriptorWriter.writeDescriptor(descriptor, bArr).onErrorResumeNext(new Function() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource error;
                error = Completable.error(new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 3, (Throwable) obj));
                return error;
            }
        });
    }
}
