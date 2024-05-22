package expo.modules.sensors.modules;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Choreographer;
import android.view.WindowManager;
import androidx.tracing.Trace;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.core.interfaces.services.EventEmitter;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.interfaces.sensors.SensorServiceInterface;
import expo.modules.interfaces.sensors.SensorServiceSubscriptionInterface;
import expo.modules.interfaces.sensors.services.AccelerometerServiceInterface;
import expo.modules.interfaces.sensors.services.GravitySensorServiceInterface;
import expo.modules.interfaces.sensors.services.GyroscopeServiceInterface;
import expo.modules.interfaces.sensors.services.LinearAccelerationSensorServiceInterface;
import expo.modules.interfaces.sensors.services.RotationVectorSensorServiceInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.sensors.ServiceNotFoundException;
import expo.modules.sensors.modules.DeviceMotionModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: DeviceMotionModule.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002/0B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020!H\u0016J\u0010\u0010,\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\u0005H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lexpo/modules/sensors/modules/DeviceMotionModule;", "Lexpo/modules/kotlin/modules/Module;", "Landroid/hardware/SensorEventListener2;", "()V", "accelerationEvent", "Landroid/hardware/SensorEvent;", "accelerationIncludingGravityEvent", "currentFrameCallback", "Lexpo/modules/sensors/modules/DeviceMotionModule$ScheduleDispatchFrameCallback;", "dispatchEventRunnable", "Lexpo/modules/sensors/modules/DeviceMotionModule$DispatchEventRunnable;", "eventEmitter", "Lexpo/modules/core/interfaces/services/EventEmitter;", "gravityEvent", "lastUpdate", "", "rotationEvent", "rotationMatrix", "", "rotationRateEvent", "rotationResult", "serviceSubscriptions", "", "Lexpo/modules/interfaces/sensors/SensorServiceSubscriptionInterface;", "uiManager", "Lexpo/modules/core/interfaces/services/UIManager;", "updateInterval", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "eventsToMap", "Landroid/os/Bundle;", "getOrientation", "", "getSensorKernelServices", "", "Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "appContext", "Lexpo/modules/kotlin/AppContext;", "onAccuracyChanged", "", "sensor", "Landroid/hardware/Sensor;", "accuracy", "onFlushCompleted", "onSensorChanged", "sensorEvent", "DispatchEventRunnable", "ScheduleDispatchFrameCallback", "expo-sensors_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceMotionModule extends Module implements SensorEventListener2 {
    private SensorEvent accelerationEvent;
    private SensorEvent accelerationIncludingGravityEvent;
    private EventEmitter eventEmitter;
    private SensorEvent gravityEvent;
    private long lastUpdate;
    private SensorEvent rotationEvent;
    private SensorEvent rotationRateEvent;
    private List<SensorServiceSubscriptionInterface> serviceSubscriptions;
    private UIManager uiManager;
    private float updateInterval = 0.016666668f;
    private final float[] rotationMatrix = new float[9];
    private final float[] rotationResult = new float[3];
    private final ScheduleDispatchFrameCallback currentFrameCallback = new ScheduleDispatchFrameCallback();
    private final DispatchEventRunnable dispatchEventRunnable = new DispatchEventRunnable();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener2
    public void onFlushCompleted(Sensor sensor) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        DeviceMotionModule deviceMotionModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (deviceMotionModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(deviceMotionModule);
            moduleDefinitionBuilder.Name("ExponentDeviceMotion");
            moduleDefinitionBuilder.Events("deviceMotionDidUpdate");
            moduleDefinitionBuilder.Constants(TuplesKt.to("Gravity", Float.valueOf(9.80665f)));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$6$$inlined$OnCreate$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Object obj;
                    DeviceMotionModule deviceMotionModule2 = DeviceMotionModule.this;
                    Object obj2 = null;
                    try {
                        obj = deviceMotionModule2.getAppContext().getLegacyModuleRegistry().getModule(UIManager.class);
                    } catch (Exception unused) {
                        obj = null;
                    }
                    Intrinsics.checkNotNull(obj);
                    deviceMotionModule2.uiManager = (UIManager) obj;
                    DeviceMotionModule deviceMotionModule3 = DeviceMotionModule.this;
                    try {
                        obj2 = deviceMotionModule3.getAppContext().getLegacyModuleRegistry().getModule(EventEmitter.class);
                    } catch (Exception unused2) {
                    }
                    Intrinsics.checkNotNull(obj2);
                    deviceMotionModule3.eventEmitter = (EventEmitter) obj2;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Float.class == Promise.class) {
                asyncFunctionComponent = new AsyncFunctionWithPromiseComponent("setUpdateInterval", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        DeviceMotionModule.this.updateInterval = ((Float) promise).floatValue();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent("setUpdateInterval", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Float.class), false, new Function0<KType>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Float.TYPE);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj != null) {
                            DeviceMotionModule.this.updateInterval = ((Float) obj).floatValue();
                            return Unit.INSTANCE;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                    }
                });
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("setUpdateInterval", asyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent3 = new AsyncFunctionComponent("startObserving", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$6$$inlined$OnStartObserving$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    List list;
                    List list2;
                    List sensorKernelServices;
                    List list3;
                    Intrinsics.checkNotNullParameter(it, "it");
                    list = DeviceMotionModule.this.serviceSubscriptions;
                    List list4 = null;
                    if (list == null) {
                        DeviceMotionModule.this.serviceSubscriptions = new ArrayList();
                        DeviceMotionModule deviceMotionModule2 = DeviceMotionModule.this;
                        sensorKernelServices = deviceMotionModule2.getSensorKernelServices(deviceMotionModule2.getAppContext());
                        Iterator it2 = sensorKernelServices.iterator();
                        while (it2.hasNext()) {
                            SensorServiceSubscriptionInterface subscription = ((SensorServiceInterface) it2.next()).createSubscriptionForListener(DeviceMotionModule.this);
                            subscription.setUpdateInterval(0L);
                            list3 = DeviceMotionModule.this.serviceSubscriptions;
                            if (list3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("serviceSubscriptions");
                                list3 = null;
                            }
                            Intrinsics.checkNotNullExpressionValue(subscription, "subscription");
                            list3.add(subscription);
                        }
                    }
                    list2 = DeviceMotionModule.this.serviceSubscriptions;
                    if (list2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("serviceSubscriptions");
                    } else {
                        list4 = list2;
                    }
                    Iterator it3 = list4.iterator();
                    while (it3.hasNext()) {
                        ((SensorServiceSubscriptionInterface) it3.next()).start();
                    }
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("startObserving", asyncFunctionComponent3);
            AsyncFunctionComponent asyncFunctionComponent4 = asyncFunctionComponent3;
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Promise.class == Promise.class) {
                asyncFunctionComponent2 = new AsyncFunctionWithPromiseComponent("stopObserving", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$4
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        UIManager uIManager = DeviceMotionModule.this.uiManager;
                        if (uIManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("uiManager");
                            uIManager = null;
                        }
                        uIManager.runOnUiQueueThread(new DeviceMotionModule$definition$1$4$1(DeviceMotionModule.this, promise));
                    }
                });
            } else {
                asyncFunctionComponent2 = new AsyncFunctionComponent("stopObserving", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj != null) {
                            Promise promise = (Promise) obj;
                            UIManager uIManager = DeviceMotionModule.this.uiManager;
                            if (uIManager == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("uiManager");
                                uIManager = null;
                            }
                            uIManager.runOnUiQueueThread(new DeviceMotionModule$definition$1$4$1(DeviceMotionModule.this, promise));
                            return Unit.INSTANCE;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                });
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("stopObserving", asyncFunctionComponent2);
            AsyncFunctionComponent asyncFunctionComponent5 = new AsyncFunctionComponent("isAvailableAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$6$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Context reactContext = DeviceMotionModule.this.getAppContext().getReactContext();
                    Object systemService = reactContext != null ? reactContext.getSystemService("sensor") : null;
                    SensorManager sensorManager = systemService instanceof SensorManager ? (SensorManager) systemService : null;
                    if (sensorManager == null) {
                        return false;
                    }
                    Iterator it2 = CollectionsKt.arrayListOf(4, 1, 10, 11, 9).iterator();
                    while (it2.hasNext()) {
                        Integer type = (Integer) it2.next();
                        Intrinsics.checkNotNullExpressionValue(type, "type");
                        if (sensorManager.getDefaultSensor(type.intValue()) == null) {
                            return false;
                        }
                    }
                    return true;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("isAvailableAsync", asyncFunctionComponent5);
            AsyncFunctionComponent asyncFunctionComponent6 = asyncFunctionComponent5;
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            this.accelerationIncludingGravityEvent = sensorEvent;
        } else if (type == 4) {
            this.rotationRateEvent = sensorEvent;
        } else {
            switch (type) {
                case 9:
                    this.gravityEvent = sensorEvent;
                    break;
                case 10:
                    this.accelerationEvent = sensorEvent;
                    break;
                case 11:
                    this.rotationEvent = sensorEvent;
                    break;
            }
        }
        this.currentFrameCallback.maybePostFromNonUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeviceMotionModule.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0006\u0010\r\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/sensors/modules/DeviceMotionModule$ScheduleDispatchFrameCallback;", "Landroid/view/Choreographer$FrameCallback;", "(Lexpo/modules/sensors/modules/DeviceMotionModule;)V", "mIsPosted", "", "mShouldStop", "doFrame", "", "frameTimeNanos", "", "maybePost", "maybePostFromNonUI", "post", "stop", "expo-sensors_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class ScheduleDispatchFrameCallback implements Choreographer.FrameCallback {
        private volatile boolean mIsPosted;
        private boolean mShouldStop;

        public ScheduleDispatchFrameCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            if (this.mShouldStop) {
                this.mIsPosted = false;
            } else {
                post();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (((float) (currentTimeMillis - DeviceMotionModule.this.lastUpdate)) > DeviceMotionModule.this.updateInterval) {
                UIManager uIManager = DeviceMotionModule.this.uiManager;
                if (uIManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiManager");
                    uIManager = null;
                }
                uIManager.runOnClientCodeQueueThread(DeviceMotionModule.this.dispatchEventRunnable);
                DeviceMotionModule.this.lastUpdate = currentTimeMillis;
            }
        }

        public final void stop() {
            this.mShouldStop = true;
        }

        public final void maybePost() {
            if (this.mIsPosted) {
                return;
            }
            this.mIsPosted = true;
            post();
        }

        private final void post() {
            Choreographer.getInstance().postFrameCallback(DeviceMotionModule.this.currentFrameCallback);
        }

        public final void maybePostFromNonUI() {
            if (this.mIsPosted) {
                return;
            }
            UIManager uIManager = DeviceMotionModule.this.uiManager;
            if (uIManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiManager");
                uIManager = null;
            }
            uIManager.runOnUiQueueThread(new Runnable() { // from class: expo.modules.sensors.modules.DeviceMotionModule$ScheduleDispatchFrameCallback$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceMotionModule.ScheduleDispatchFrameCallback.maybePostFromNonUI$lambda$0(DeviceMotionModule.ScheduleDispatchFrameCallback.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void maybePostFromNonUI$lambda$0(ScheduleDispatchFrameCallback this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.maybePost();
        }
    }

    /* compiled from: DeviceMotionModule.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lexpo/modules/sensors/modules/DeviceMotionModule$DispatchEventRunnable;", "Ljava/lang/Runnable;", "(Lexpo/modules/sensors/modules/DeviceMotionModule;)V", "run", "", "expo-sensors_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private final class DispatchEventRunnable implements Runnable {
        public DispatchEventRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EventEmitter eventEmitter = DeviceMotionModule.this.eventEmitter;
            if (eventEmitter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
                eventEmitter = null;
            }
            eventEmitter.emit("deviceMotionDidUpdate", DeviceMotionModule.this.eventsToMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle eventsToMap() {
        double d;
        Bundle bundle = new Bundle();
        if (this.accelerationEvent != null) {
            Bundle bundle2 = new Bundle();
            Intrinsics.checkNotNull(this.accelerationEvent);
            bundle2.putDouble("x", r8.values[0]);
            Intrinsics.checkNotNull(this.accelerationEvent);
            bundle2.putDouble("y", r8.values[1]);
            Intrinsics.checkNotNull(this.accelerationEvent);
            bundle2.putDouble("z", r8.values[2]);
            Unit unit = Unit.INSTANCE;
            bundle.putBundle("acceleration", bundle2);
            SensorEvent sensorEvent = this.accelerationEvent;
            Intrinsics.checkNotNull(sensorEvent);
            d = sensorEvent.timestamp;
        } else {
            d = 0.0d;
        }
        if (this.accelerationIncludingGravityEvent != null && this.gravityEvent != null) {
            Bundle bundle3 = new Bundle();
            SensorEvent sensorEvent2 = this.accelerationIncludingGravityEvent;
            Intrinsics.checkNotNull(sensorEvent2);
            float f = sensorEvent2.values[0];
            float f2 = 2;
            Intrinsics.checkNotNull(this.gravityEvent);
            bundle3.putDouble("x", f - (r10.values[0] * f2));
            SensorEvent sensorEvent3 = this.accelerationIncludingGravityEvent;
            Intrinsics.checkNotNull(sensorEvent3);
            float f3 = sensorEvent3.values[1];
            Intrinsics.checkNotNull(this.gravityEvent);
            bundle3.putDouble("y", f3 - (r8.values[1] * f2));
            SensorEvent sensorEvent4 = this.accelerationIncludingGravityEvent;
            Intrinsics.checkNotNull(sensorEvent4);
            float f4 = sensorEvent4.values[2];
            Intrinsics.checkNotNull(this.gravityEvent);
            bundle3.putDouble("z", f4 - (f2 * r4.values[2]));
            Unit unit2 = Unit.INSTANCE;
            bundle.putBundle("accelerationIncludingGravity", bundle3);
            SensorEvent sensorEvent5 = this.accelerationIncludingGravityEvent;
            Intrinsics.checkNotNull(sensorEvent5);
            d = sensorEvent5.timestamp;
        }
        if (this.rotationRateEvent != null) {
            Bundle bundle4 = new Bundle();
            Intrinsics.checkNotNull(this.rotationRateEvent);
            bundle4.putDouble("alpha", Math.toDegrees(r8.values[0]));
            Intrinsics.checkNotNull(this.rotationRateEvent);
            bundle4.putDouble("beta", Math.toDegrees(r8.values[1]));
            Intrinsics.checkNotNull(this.rotationRateEvent);
            bundle4.putDouble("gamma", Math.toDegrees(r8.values[2]));
            Unit unit3 = Unit.INSTANCE;
            bundle.putBundle("rotationRate", bundle4);
            SensorEvent sensorEvent6 = this.rotationRateEvent;
            Intrinsics.checkNotNull(sensorEvent6);
            d = sensorEvent6.timestamp;
        }
        SensorEvent sensorEvent7 = this.rotationEvent;
        if (sensorEvent7 != null) {
            float[] fArr = this.rotationMatrix;
            Intrinsics.checkNotNull(sensorEvent7);
            SensorManager.getRotationMatrixFromVector(fArr, sensorEvent7.values);
            SensorManager.getOrientation(this.rotationMatrix, this.rotationResult);
            Bundle bundle5 = new Bundle();
            bundle5.putDouble("alpha", -this.rotationResult[0]);
            bundle5.putDouble("beta", -this.rotationResult[1]);
            bundle5.putDouble("gamma", this.rotationResult[2]);
            Unit unit4 = Unit.INSTANCE;
            bundle.putBundle(ViewProps.ROTATION, bundle5);
            SensorEvent sensorEvent8 = this.rotationEvent;
            Intrinsics.checkNotNull(sensorEvent8);
            d = sensorEvent8.timestamp;
        }
        bundle.putDouble("interval", d);
        bundle.putInt("orientation", getOrientation());
        return bundle;
    }

    private final int getOrientation() {
        Context reactContext = getAppContext().getReactContext();
        Object systemService = reactContext != null ? reactContext.getSystemService("window") : null;
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null) {
            return 0;
        }
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (rotation != 1) {
            return rotation != 2 ? rotation != 3 ? 0 : -90 : RotationOptions.ROTATE_180;
        }
        return 90;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SensorServiceInterface> getSensorKernelServices(AppContext appContext) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        SensorServiceInterface[] sensorServiceInterfaceArr = new SensorServiceInterface[5];
        if (appContext != null) {
            Object obj5 = null;
            try {
                obj = appContext.getLegacyModuleRegistry().getModule(GyroscopeServiceInterface.class);
            } catch (Exception unused) {
                obj = null;
            }
            SensorServiceInterface sensorServiceInterface = (SensorServiceInterface) obj;
            if (sensorServiceInterface != null) {
                sensorServiceInterfaceArr[0] = sensorServiceInterface;
                if (appContext != null) {
                    try {
                        obj2 = appContext.getLegacyModuleRegistry().getModule(LinearAccelerationSensorServiceInterface.class);
                    } catch (Exception unused2) {
                        obj2 = null;
                    }
                    SensorServiceInterface sensorServiceInterface2 = (SensorServiceInterface) obj2;
                    if (sensorServiceInterface2 != null) {
                        sensorServiceInterfaceArr[1] = sensorServiceInterface2;
                        if (appContext != null) {
                            try {
                                obj3 = appContext.getLegacyModuleRegistry().getModule(AccelerometerServiceInterface.class);
                            } catch (Exception unused3) {
                                obj3 = null;
                            }
                            SensorServiceInterface sensorServiceInterface3 = (SensorServiceInterface) obj3;
                            if (sensorServiceInterface3 != null) {
                                sensorServiceInterfaceArr[2] = sensorServiceInterface3;
                                if (appContext != null) {
                                    try {
                                        obj4 = appContext.getLegacyModuleRegistry().getModule(RotationVectorSensorServiceInterface.class);
                                    } catch (Exception unused4) {
                                        obj4 = null;
                                    }
                                    SensorServiceInterface sensorServiceInterface4 = (SensorServiceInterface) obj4;
                                    if (sensorServiceInterface4 != null) {
                                        sensorServiceInterfaceArr[3] = sensorServiceInterface4;
                                        if (appContext != null) {
                                            try {
                                                obj5 = appContext.getLegacyModuleRegistry().getModule(GravitySensorServiceInterface.class);
                                            } catch (Exception unused5) {
                                            }
                                            SensorServiceInterface sensorServiceInterface5 = (SensorServiceInterface) obj5;
                                            if (sensorServiceInterface5 != null) {
                                                sensorServiceInterfaceArr[4] = sensorServiceInterface5;
                                                return CollectionsKt.arrayListOf(sensorServiceInterfaceArr);
                                            }
                                        }
                                        throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(GravitySensorServiceInterface.class));
                                    }
                                }
                                throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(RotationVectorSensorServiceInterface.class));
                            }
                        }
                        throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(AccelerometerServiceInterface.class));
                    }
                }
                throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(LinearAccelerationSensorServiceInterface.class));
            }
        }
        throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(GyroscopeServiceInterface.class));
    }
}
