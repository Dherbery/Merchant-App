package expo.modules.sensors;

import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import expo.modules.core.ModuleRegistry;
import expo.modules.interfaces.sensors.SensorServiceInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: SensorProxy.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\nH\u0000\u001aI\u0010\r\u001a\u00020\f\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u000f*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2#\b\u0004\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0011H\u0080\bø\u0001\u0000\u001a \u0010\u0017\u001a\u0002H\u000e\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u000f*\u0004\u0018\u00010\u0018H\u0080\b¢\u0006\u0002\u0010\u0019*B\b\u0000\u0010\u001a\"\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00010\u00112\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00010\u0011*\u0018\b\u0000\u0010\u001c\"\b\u0012\u0004\u0012\u00020\u000f0\n2\b\u0012\u0004\u0012\u00020\u000f0\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"UseSensorProxy", "", "Lexpo/modules/kotlin/modules/ModuleDefinitionBuilder;", "module", "Lexpo/modules/kotlin/modules/Module;", "sensorType", "", "eventName", "", "listenerDecorator", "Lkotlin/Function0;", "sensorProxyGetter", "Lexpo/modules/sensors/SensorProxy;", "createSensorProxy", "T", "Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "eventMapper", "Lkotlin/Function1;", "Landroid/hardware/SensorEvent;", "Lkotlin/ParameterName;", "name", "sensorEvent", "Landroid/os/Bundle;", "getServiceInterface", "Lexpo/modules/kotlin/AppContext;", "(Lexpo/modules/kotlin/AppContext;)Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "OnNewEvent", NotificationCompat.CATEGORY_EVENT, "SensorServiceFactory", "expo-sensors_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SensorProxyKt {
    public static /* synthetic */ void UseSensorProxy$default(ModuleDefinitionBuilder moduleDefinitionBuilder, Module module, int i, String str, Function0 function0, Function0 function02, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function0 = null;
        }
        UseSensorProxy(moduleDefinitionBuilder, module, i, str, function0, function02);
    }

    public static final void UseSensorProxy(ModuleDefinitionBuilder moduleDefinitionBuilder, final Module module, final int i, String eventName, final Function0<Unit> function0, final Function0<SensorProxy> sensorProxyGetter) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(moduleDefinitionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(sensorProxyGetter, "sensorProxyGetter");
        moduleDefinitionBuilder.Events(eventName);
        ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
        moduleDefinitionBuilder2.getAsyncFunctions().put("startObserving", new AsyncFunctionComponent("startObserving", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$OnStartObserving$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function0 function02 = Function0.this;
                if (function02 != null) {
                    function02.invoke();
                }
                ((SensorProxy) sensorProxyGetter.invoke()).startObserving();
                return Unit.INSTANCE;
            }
        }));
        moduleDefinitionBuilder2.getAsyncFunctions().put("stopObserving", new AsyncFunctionComponent("stopObserving", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$OnStopObserving$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function0 function02 = Function0.this;
                if (function02 != null) {
                    function02.invoke();
                }
                ((SensorProxy) sensorProxyGetter.invoke()).stopObserving();
                return Unit.INSTANCE;
            }
        }));
        moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_FOREGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_FOREGROUND, new Function0<Unit>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$OnActivityEntersForeground$1
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
                ((SensorProxy) Function0.this.invoke()).onHostResume();
            }
        }));
        moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_BACKGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_BACKGROUND, new Function0<Unit>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$OnActivityEntersBackground$1
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
                ((SensorProxy) Function0.this.invoke()).onHostPause();
            }
        }));
        moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_DESTROYS, new BasicEventListener(EventName.ACTIVITY_DESTROYS, new Function0<Unit>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$OnActivityDestroys$1
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
                ((SensorProxy) Function0.this.invoke()).onHostDestroy();
            }
        }));
        moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$OnDestroy$1
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
                ((SensorProxy) Function0.this.invoke()).onHostDestroy();
            }
        }));
        if (Integer.class == Promise.class) {
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent("setUpdateInterval", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$1
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    ((SensorProxy) Function0.this.invoke()).setUpdateInterval(((Integer) promise).intValue());
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
        } else {
            asyncFunctionComponent = new AsyncFunctionComponent("setUpdateInterval", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    ((SensorProxy) Function0.this.invoke()).setUpdateInterval(((Integer) obj).intValue());
                    return Unit.INSTANCE;
                }
            });
        }
        moduleDefinitionBuilder2.getAsyncFunctions().put("setUpdateInterval", asyncFunctionComponent);
        moduleDefinitionBuilder2.getAsyncFunctions().put("isAvailableAsync", new AsyncFunctionComponent("isAvailableAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$AsyncFunctionWithoutArgs$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Context reactContext = Module.this.getAppContext().getReactContext();
                Object systemService = reactContext != null ? reactContext.getSystemService("sensor") : null;
                SensorManager sensorManager = systemService instanceof SensorManager ? (SensorManager) systemService : null;
                return Boolean.valueOf((sensorManager != null ? sensorManager.getDefaultSensor(i) : null) != null);
            }
        }));
    }

    public static final /* synthetic */ <T extends SensorServiceInterface> SensorProxy createSensorProxy(Module module, final String eventName, final Function1<? super SensorEvent, Bundle> eventMapper) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        final WeakReference weakReference = new WeakReference(module);
        Intrinsics.needClassReification();
        return new SensorProxy(new Function0<T>() { // from class: expo.modules.sensors.SensorProxyKt$createSensorProxy$serviceFactory$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            public final SensorServiceInterface invoke() {
                Module module2 = weakReference.get();
                Object obj = null;
                AppContext appContext = module2 != null ? module2.getAppContext() : null;
                if (appContext != null) {
                    try {
                        ModuleRegistry legacyModuleRegistry = appContext.getLegacyModuleRegistry();
                        Intrinsics.reifiedOperationMarker(4, "T");
                        obj = legacyModuleRegistry.getModule(Object.class);
                    } catch (Exception unused) {
                    }
                    SensorServiceInterface sensorServiceInterface = (SensorServiceInterface) obj;
                    if (sensorServiceInterface != null) {
                        return sensorServiceInterface;
                    }
                }
                Intrinsics.reifiedOperationMarker(4, "T");
                throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(SensorServiceInterface.class));
            }
        }, new Function1<SensorEvent, Unit>() { // from class: expo.modules.sensors.SensorProxyKt$createSensorProxy$onNewEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SensorEvent sensorEvent) {
                invoke2(sensorEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SensorEvent sensorEvent) {
                Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
                Module module2 = weakReference.get();
                if (module2 != null) {
                    module2.sendEvent(eventName, eventMapper.invoke(sensorEvent));
                }
            }
        });
    }

    public static final /* synthetic */ <T extends SensorServiceInterface> T getServiceInterface(AppContext appContext) {
        Object obj;
        if (appContext != null) {
            try {
                ModuleRegistry legacyModuleRegistry = appContext.getLegacyModuleRegistry();
                Intrinsics.reifiedOperationMarker(4, "T");
                obj = legacyModuleRegistry.getModule(Object.class);
            } catch (Exception unused) {
                obj = null;
            }
            T t = (T) obj;
            if (t != null) {
                return t;
            }
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(SensorServiceInterface.class));
    }
}
