package expo.modules.kotlin.jni;

import androidx.core.os.EnvironmentCompat;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.util.JSStackTrace;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.PromiseAlreadySettledException;
import expo.modules.kotlin.types.JSTypeConverter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PromiseImpl.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016H\u0082\bJ$\u0010\u0017\u001a\u00020\u00142\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nJ$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lexpo/modules/kotlin/jni/PromiseImpl;", "Lexpo/modules/kotlin/Promise;", "resolveBlock", "Lexpo/modules/kotlin/jni/JavaCallback;", "rejectBlock", "(Lexpo/modules/kotlin/jni/JavaCallback;Lexpo/modules/kotlin/jni/JavaCallback;)V", "appContextHolder", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/AppContext;", "fullFunctionName", "", "getRejectBlock$expo_modules_core_release", "()Lexpo/modules/kotlin/jni/JavaCallback;", "getResolveBlock$expo_modules_core_release", "<set-?>", "", "wasSettled", "getWasSettled$expo_modules_core_release", "()Z", "checkIfWasSettled", "", TtmlNode.TAG_BODY, "Lkotlin/Function0;", "decorateWithDebugInformation", "moduleName", "functionName", "reject", "code", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "cause", "", "resolve", "value", "", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromiseImpl implements Promise {
    private WeakReference<AppContext> appContextHolder;
    private String fullFunctionName;
    private final JavaCallback rejectBlock;
    private final JavaCallback resolveBlock;
    private boolean wasSettled;

    public PromiseImpl(JavaCallback resolveBlock, JavaCallback rejectBlock) {
        Intrinsics.checkNotNullParameter(resolveBlock, "resolveBlock");
        Intrinsics.checkNotNullParameter(rejectBlock, "rejectBlock");
        this.resolveBlock = resolveBlock;
        this.rejectBlock = rejectBlock;
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(CodedException codedException) {
        Promise.DefaultImpls.reject(this, codedException);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve() {
        Promise.DefaultImpls.resolve(this);
    }

    /* renamed from: getResolveBlock$expo_modules_core_release, reason: from getter */
    public final JavaCallback getResolveBlock() {
        return this.resolveBlock;
    }

    /* renamed from: getRejectBlock$expo_modules_core_release, reason: from getter */
    public final JavaCallback getRejectBlock() {
        return this.rejectBlock;
    }

    /* renamed from: getWasSettled$expo_modules_core_release, reason: from getter */
    public final boolean getWasSettled() {
        return this.wasSettled;
    }

    private final void checkIfWasSettled(Function0<Unit> body) {
        if (this.wasSettled) {
            String str = this.fullFunctionName;
            if (str == null) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
            WeakReference<AppContext> weakReference = this.appContextHolder;
            if (weakReference == null) {
                throw promiseAlreadySettledException;
            }
            AppContext appContext = weakReference.get();
            if (appContext != null) {
                appContext.getErrorManager();
                throw promiseAlreadySettledException;
            }
            throw promiseAlreadySettledException;
        }
        body.invoke();
        this.wasSettled = true;
    }

    public final void decorateWithDebugInformation(WeakReference<AppContext> appContextHolder, String moduleName, String functionName) {
        Intrinsics.checkNotNullParameter(appContextHolder, "appContextHolder");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        this.appContextHolder = appContextHolder;
        this.fullFunctionName = moduleName + "." + functionName;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Object value) {
        if (!this.wasSettled) {
            this.resolveBlock.invoke(JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, value, null, 2, null));
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null) {
            throw promiseAlreadySettledException;
        }
        AppContext appContext = weakReference.get();
        if (appContext != null) {
            appContext.getErrorManager();
            throw promiseAlreadySettledException;
        }
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(String code, String message, Throwable cause) {
        Intrinsics.checkNotNullParameter(code, "code");
        if (!this.wasSettled) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("code", code);
            if (message != null) {
                writableNativeMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, message);
            } else if (cause != null) {
                writableNativeMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, cause.getMessage());
            } else {
                writableNativeMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "Error not specified.");
            }
            writableNativeMap.putNull("userInfo");
            if (cause != null) {
                StackTraceElement[] stackTrace = cause.getStackTrace();
                Intrinsics.checkNotNullExpressionValue(stackTrace, "cause.stackTrace");
                WritableNativeArray writableNativeArray = new WritableNativeArray();
                for (int i = 0; i < stackTrace.length && i < 50; i++) {
                    StackTraceElement stackTraceElement = stackTrace[i];
                    WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                    writableNativeMap2.putString("class", stackTraceElement.getClassName());
                    writableNativeMap2.putString("file", stackTraceElement.getFileName());
                    writableNativeMap2.putInt("lineNumber", stackTraceElement.getLineNumber());
                    writableNativeMap2.putString(JSStackTrace.METHOD_NAME_KEY, stackTraceElement.getMethodName());
                    writableNativeArray.pushMap(writableNativeMap2);
                }
                writableNativeMap.putArray("nativeStackAndroid", writableNativeArray);
            } else {
                writableNativeMap.putArray("nativeStackAndroid", new WritableNativeArray());
            }
            this.rejectBlock.invoke((Object) writableNativeMap);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null) {
            throw promiseAlreadySettledException;
        }
        AppContext appContext = weakReference.get();
        if (appContext != null) {
            appContext.getErrorManager();
            throw promiseAlreadySettledException;
        }
        throw promiseAlreadySettledException;
    }
}
