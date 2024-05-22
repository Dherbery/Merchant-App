package expo.modules.sms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Telephony;
import androidx.core.os.BundleKt;
import androidx.core.os.EnvironmentCompat;
import androidx.tracing.Trace;
import androidx.webkit.internal.AssetHelper;
import com.facebook.react.bridge.BaseJavaModule;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: SMSModule.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J.\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lexpo/modules/sms/SMSModule;", "Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/core/interfaces/LifecycleEventListener;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "pendingPromise", "Lexpo/modules/kotlin/Promise;", "smsComposerOpened", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "onHostDestroy", "", "onHostPause", "onHostResume", "sendSMSAsync", "addresses", "", "", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "options", "Lexpo/modules/sms/SMSOptions;", BaseJavaModule.METHOD_TYPE_PROMISE, "expo-sms_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SMSModule extends Module implements LifecycleEventListener {
    private Promise pendingPromise;
    private boolean smsComposerOpened;

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostPause() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    private final Activity getCurrentActivity() {
        ActivityProvider activityProvider = getAppContext().getActivityProvider();
        Activity currentActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new MissingCurrentActivityException();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        SMSModule sMSModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (sMSModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(sMSModule);
            moduleDefinitionBuilder.Name("ExpoSMS");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.sms.SMSModule$definition$lambda$4$$inlined$OnCreate$1
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
                    try {
                        obj = SMSModule.this.getAppContext().getLegacyModuleRegistry().getModule(UIManager.class);
                    } catch (Exception unused) {
                        obj = null;
                    }
                    UIManager uIManager = (UIManager) obj;
                    if (uIManager != null) {
                        uIManager.registerLifecycleEventListener(SMSModule.this);
                    }
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("sendSMSAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("sendSMSAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.sms.SMSModule$definition$lambda$4$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sms.SMSModule$definition$lambda$4$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SMSOptions.class), false, new Function0<KType>() { // from class: expo.modules.sms.SMSModule$definition$lambda$4$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SMSOptions.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sms.SMSModule$definition$lambda$4$$inlined$AsyncFunction$4
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                    }
                    List list = (List) obj;
                    Object obj2 = args[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj2;
                    Object obj3 = args[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.sms.SMSOptions");
                    }
                    SMSModule.this.sendSMSAsync(list, str, (SMSOptions) obj3, promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("sendSMSAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.sms.SMSModule$definition$lambda$4$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sms.SMSModule$definition$lambda$4$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SMSOptions.class), false, new Function0<KType>() { // from class: expo.modules.sms.SMSModule$definition$lambda$4$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SMSOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.sms.SMSModule$definition$lambda$4$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sms.SMSModule$definition$lambda$4$$inlined$AsyncFunction$9
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                    }
                    List list = (List) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj2;
                    Object obj3 = it[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.sms.SMSOptions");
                    }
                    SMSOptions sMSOptions = (SMSOptions) obj3;
                    Object obj4 = it[3];
                    if (obj4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    SMSModule.this.sendSMSAsync(list, str, sMSOptions, (Promise) obj4);
                    return Unit.INSTANCE;
                }
            }));
            AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("isAvailableAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.sms.SMSModule$definition$lambda$4$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Context context;
                    Intrinsics.checkNotNullParameter(it, "it");
                    context = SMSModule.this.getContext();
                    return Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.telephony"));
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("isAvailableAsync", asyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionComponent;
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.sms.SMSModule$definition$lambda$4$$inlined$OnDestroy$1
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
                    try {
                        obj = SMSModule.this.getAppContext().getLegacyModuleRegistry().getModule(UIManager.class);
                    } catch (Exception unused) {
                        obj = null;
                    }
                    UIManager uIManager = (UIManager) obj;
                    if (uIManager != null) {
                        uIManager.unregisterLifecycleEventListener(SMSModule.this);
                    }
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSMSAsync(List<String> addresses, String message, SMSOptions options, Promise promise) {
        Intent intent;
        if (!options.getAttachments().isEmpty()) {
            intent = new Intent("android.intent.action.SEND");
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            intent.putExtra("address", CollectionsKt.joinToString$default(addresses, ";", null, null, 0, null, null, 62, null));
            SMSAttachment sMSAttachment = options.getAttachments().get(0);
            intent.putExtra("android.intent.extra.STREAM", Uri.parse(sMSAttachment.getUri()));
            intent.setType(sMSAttachment.getMimeType());
            intent.addFlags(1);
        } else {
            intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("smsto:" + CollectionsKt.joinToString$default(addresses, ";", null, null, 0, null, null, 62, null)));
        }
        String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(getContext());
        if (defaultSmsPackage == null || intent.setPackage(defaultSmsPackage) == null) {
            throw new MissingSMSAppException();
        }
        intent.putExtra("exit_on_sent", true);
        intent.putExtra("compose_mode", true);
        intent.putExtra("sms_body", message);
        this.pendingPromise = promise;
        getCurrentActivity().startActivity(intent);
        this.smsComposerOpened = true;
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostResume() {
        Promise promise = this.pendingPromise;
        if (this.smsComposerOpened && promise != null) {
            promise.resolve(BundleKt.bundleOf(new Pair("result", EnvironmentCompat.MEDIA_UNKNOWN)));
            this.pendingPromise = null;
        }
        this.smsComposerOpened = false;
    }
}
