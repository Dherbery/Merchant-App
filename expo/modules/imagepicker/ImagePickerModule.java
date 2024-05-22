package expo.modules.imagepicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.tracing.Trace;
import expo.modules.core.errors.ModuleNotFoundException;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.imagepicker.contracts.CameraContractOptions;
import expo.modules.imagepicker.contracts.CropImageContractOptions;
import expo.modules.imagepicker.contracts.ImageLibraryContractOptions;
import expo.modules.imagepicker.contracts.ImagePickerContractResult;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.interfaces.permissions.PermissionsResponseListener;
import expo.modules.interfaces.permissions.PermissionsStatus;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;

/* compiled from: ImagePickerModule.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0011\u0010\u001d\u001a\u00020\u001eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0002J\u001b\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001a\u00020'H\u0002¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H\u0002J7\u0010+\u001a\u00020,2\u001c\u0010-\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0/\u0012\u0006\u0012\u0004\u0018\u00010,0.2\u0006\u0010!\u001a\u00020\"H\u0082@ø\u0001\u0000¢\u0006\u0002\u00100J/\u00101\u001a\u0002022\u001c\u0010-\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0/\u0012\u0006\u0012\u0004\u0018\u00010,0.H\u0082@ø\u0001\u0000¢\u0006\u0002\u00103R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lexpo/modules/imagepicker/ImagePickerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "cameraLauncher", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "Lexpo/modules/imagepicker/contracts/CameraContractOptions;", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "cropImageLauncher", "Lexpo/modules/imagepicker/contracts/CropImageContractOptions;", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "imageLibraryLauncher", "Lexpo/modules/imagepicker/contracts/ImageLibraryContractOptions;", "mediaHandler", "Lexpo/modules/imagepicker/MediaHandler;", "pendingMediaPickingResult", "Lexpo/modules/imagepicker/PendingMediaPickingResult;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "ensureCameraPermissionsAreGranted", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureTargetActivityIsAvailable", "options", "Lexpo/modules/imagepicker/ImagePickerOptions;", "getMediaLibraryPermissions", "", "", "writeOnly", "", "(Z)[Ljava/lang/String;", "handleResultUponActivityDestruction", "result", "launchContract", "", "pickerLauncher", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lexpo/modules/imagepicker/ImagePickerOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchPicker", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult$Success;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-image-picker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImagePickerModule extends Module {
    private AppContextActivityResultLauncher<CameraContractOptions, ImagePickerContractResult> cameraLauncher;
    private AppContextActivityResultLauncher<CropImageContractOptions, ImagePickerContractResult> cropImageLauncher;
    private AppContextActivityResultLauncher<ImageLibraryContractOptions, ImagePickerContractResult> imageLibraryLauncher;
    private final MediaHandler mediaHandler = new MediaHandler(this);
    private PendingMediaPickingResult pendingMediaPickingResult;

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        ImagePickerModule imagePickerModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (imagePickerModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(imagePickerModule);
            moduleDefinitionBuilder.Name(ImagePickerConstants.TAG);
            moduleDefinitionBuilder.getAsyncFunctions().put("requestMediaLibraryPermissionsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("requestMediaLibraryPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$2
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    String[] mediaLibraryPermissions;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    Permissions permissions = ImagePickerModule.this.getAppContext().getPermissions();
                    mediaLibraryPermissions = ImagePickerModule.this.getMediaLibraryPermissions(booleanValue);
                    Permissions.CC.askForPermissionsWithPermissionsManager(permissions, promise, (String[]) Arrays.copyOf(mediaLibraryPermissions, mediaLibraryPermissions.length));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("requestMediaLibraryPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String[] mediaLibraryPermissions;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    Boolean bool = (Boolean) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    boolean booleanValue = bool.booleanValue();
                    Permissions permissions = ImagePickerModule.this.getAppContext().getPermissions();
                    mediaLibraryPermissions = ImagePickerModule.this.getMediaLibraryPermissions(booleanValue);
                    Permissions.CC.askForPermissionsWithPermissionsManager(permissions, (Promise) obj2, (String[]) Arrays.copyOf(mediaLibraryPermissions, mediaLibraryPermissions.length));
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getMediaLibraryPermissionsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getMediaLibraryPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$7
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    String[] mediaLibraryPermissions;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    Permissions permissions = ImagePickerModule.this.getAppContext().getPermissions();
                    mediaLibraryPermissions = ImagePickerModule.this.getMediaLibraryPermissions(booleanValue);
                    Permissions.CC.getPermissionsWithPermissionsManager(permissions, promise, (String[]) Arrays.copyOf(mediaLibraryPermissions, mediaLibraryPermissions.length));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getMediaLibraryPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$10
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String[] mediaLibraryPermissions;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    Boolean bool = (Boolean) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    boolean booleanValue = bool.booleanValue();
                    Permissions permissions = ImagePickerModule.this.getAppContext().getPermissions();
                    mediaLibraryPermissions = ImagePickerModule.this.getMediaLibraryPermissions(booleanValue);
                    Permissions.CC.getPermissionsWithPermissionsManager(permissions, (Promise) obj2, (String[]) Arrays.copyOf(mediaLibraryPermissions, mediaLibraryPermissions.length));
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("requestCameraPermissionsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("requestCameraPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$11
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
                    Permissions.CC.askForPermissionsWithPermissionsManager(ImagePickerModule.this.getAppContext().getPermissions(), promise, "android.permission.CAMERA");
                }
            }) : new AsyncFunctionComponent("requestCameraPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$13
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    Permissions.CC.askForPermissionsWithPermissionsManager(ImagePickerModule.this.getAppContext().getPermissions(), (Promise) obj, "android.permission.CAMERA");
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getCameraPermissionsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getCameraPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$14
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
                    Permissions.CC.getPermissionsWithPermissionsManager(ImagePickerModule.this.getAppContext().getPermissions(), promise, "android.permission.CAMERA");
                }
            }) : new AsyncFunctionComponent("getCameraPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$16
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    Permissions.CC.getPermissionsWithPermissionsManager(ImagePickerModule.this.getAppContext().getPermissions(), (Promise) obj, "android.permission.CAMERA");
                    return Unit.INSTANCE;
                }
            }));
            AsyncFunctionBuilder AsyncFunction = moduleDefinitionBuilder.AsyncFunction("launchCameraAsync");
            AsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(AsyncFunction.getName(), new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ImagePickerOptions.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$Coroutine$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ImagePickerOptions.class);
                }
            }))}, new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2(null, this)));
            AsyncFunctionBuilder AsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("launchImageLibraryAsync");
            AsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(AsyncFunction2.getName(), new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ImagePickerOptions.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$Coroutine$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ImagePickerOptions.class);
                }
            }))}, new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$4(null, this)));
            AsyncFunctionBuilder AsyncFunction3 = moduleDefinitionBuilder.AsyncFunction("getPendingResultAsync");
            SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(AsyncFunction3.getName(), new AnyType[0], new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$5(null, this));
            AsyncFunction3.setAsyncFunctionComponent(suspendFunctionComponent);
            SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
            moduleDefinitionBuilder.RegisterActivityContracts(new ImagePickerModule$definition$1$8(this, null));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new IllegalArgumentException("React Application Context is null".toString());
    }

    private final Activity getCurrentActivity() {
        ActivityProvider activityProvider = getAppContext().getActivityProvider();
        Activity currentActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new MissingCurrentActivityException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getCacheDirectory() {
        return getAppContext().getCacheDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object launchContract(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super expo.modules.imagepicker.contracts.ImagePickerContractResult>, ? extends java.lang.Object> r9, expo.modules.imagepicker.ImagePickerOptions r10, kotlin.coroutines.Continuation<java.lang.Object> r11) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.ImagePickerModule.launchContract(kotlin.jvm.functions.Function1, expo.modules.imagepicker.ImagePickerOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleResultUponActivityDestruction(ImagePickerContractResult result, ImagePickerOptions options) {
        if (result instanceof ImagePickerContractResult.Success) {
            this.pendingMediaPickingResult = new PendingMediaPickingResult(((ImagePickerContractResult.Success) result).getData(), options);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object launchPicker(Function1<? super Continuation<? super ImagePickerContractResult>, ? extends Object> function1, Continuation<? super ImagePickerContractResult.Success> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ImagePickerModule$launchPicker$2(function1, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String[] getMediaLibraryPermissions(boolean writeOnly) {
        if (Build.VERSION.SDK_INT >= 33) {
            return (String[]) CollectionsKt.listOfNotNull((Object[]) new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"}).toArray(new String[0]);
        }
        String[] strArr = new String[2];
        strArr[0] = "android.permission.WRITE_EXTERNAL_STORAGE";
        strArr[1] = writeOnly ^ true ? "android.permission.READ_EXTERNAL_STORAGE" : null;
        return (String[]) CollectionsKt.listOfNotNull((Object[]) strArr).toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureTargetActivityIsAvailable(ImagePickerOptions options) {
        Intent intent = new Intent(options.getMediaTypes().toCameraIntentAction());
        if (intent.resolveActivity(getCurrentActivity().getApplication().getPackageManager()) == null) {
            throw new MissingActivityToHandleIntent(intent.getType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object ensureCameraPermissionsAreGranted(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        Permissions permissions = getAppContext().getPermissions();
        if (permissions == null) {
            throw new ModuleNotFoundException("Permissions");
        }
        PermissionsResponseListener permissionsResponseListener = new PermissionsResponseListener() { // from class: expo.modules.imagepicker.ImagePickerModule$ensureCameraPermissionsAreGranted$2$1
            @Override // expo.modules.interfaces.permissions.PermissionsResponseListener
            public final void onResult(Map<String, PermissionsResponse> map) {
                if (Build.VERSION.SDK_INT >= 33) {
                    PermissionsResponse permissionsResponse = map.get("android.permission.CAMERA");
                    if ((permissionsResponse != null ? permissionsResponse.getStatus() : null) == PermissionsStatus.GRANTED) {
                        CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m1318constructorimpl(Unit.INSTANCE));
                        return;
                    } else {
                        CancellableContinuation<Unit> cancellableContinuation2 = cancellableContinuationImpl2;
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation2.resumeWith(Result.m1318constructorimpl(ResultKt.createFailure(new UserRejectedPermissionsException())));
                        return;
                    }
                }
                PermissionsResponse permissionsResponse2 = map.get("android.permission.WRITE_EXTERNAL_STORAGE");
                if ((permissionsResponse2 != null ? permissionsResponse2.getStatus() : null) == PermissionsStatus.GRANTED) {
                    PermissionsResponse permissionsResponse3 = map.get("android.permission.CAMERA");
                    if ((permissionsResponse3 != null ? permissionsResponse3.getStatus() : null) == PermissionsStatus.GRANTED) {
                        CancellableContinuation<Unit> cancellableContinuation3 = cancellableContinuationImpl2;
                        Result.Companion companion3 = Result.INSTANCE;
                        cancellableContinuation3.resumeWith(Result.m1318constructorimpl(Unit.INSTANCE));
                        return;
                    }
                }
                CancellableContinuation<Unit> cancellableContinuation4 = cancellableContinuationImpl2;
                Result.Companion companion4 = Result.INSTANCE;
                cancellableContinuation4.resumeWith(Result.m1318constructorimpl(ResultKt.createFailure(new UserRejectedPermissionsException())));
            }
        };
        String[] strArr = new String[2];
        strArr[0] = Build.VERSION.SDK_INT < 33 ? "android.permission.WRITE_EXTERNAL_STORAGE" : null;
        strArr[1] = "android.permission.CAMERA";
        String[] strArr2 = (String[]) CollectionsKt.listOfNotNull((Object[]) strArr).toArray(new String[0]);
        permissions.askForPermissions(permissionsResponseListener, (String[]) Arrays.copyOf(strArr2, strArr2.length));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
