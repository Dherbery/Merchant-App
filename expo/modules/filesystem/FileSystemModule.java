package expo.modules.filesystem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.documentfile.provider.DocumentFile;
import androidx.tracing.Trace;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.android.gms.common.internal.ImagesContract;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import com.revenuecat.purchases.common.Constants;
import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.filesystem.FileSystemModule;
import expo.modules.interfaces.filesystem.FilePermissionModuleInterface;
import expo.modules.interfaces.filesystem.Permission;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.CookieHandler;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Okio__JvmOkioKt;
import okio.Source;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/* compiled from: FileSystemModule.kt */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0005VWXYZB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J(\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020&H\u0017J\u001b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001aH\u0002J\u0018\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u000202H\u0002J \u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0012H\u0002J\u0010\u00104\u001a\u00020-2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u00105\u001a\u0002062\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u00107\u001a\u0002082\u0006\u00100\u001a\u00020\u0016H\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u000208H\u0002J\u0012\u0010<\u001a\u0004\u0018\u00010=2\u0006\u00100\u001a\u00020\u0016H\u0002J\u0010\u0010>\u001a\u00020?2\u0006\u00100\u001a\u00020\u0016H\u0002J\u0010\u0010@\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010A\u001a\u0002082\u0006\u00100\u001a\u00020\u0016H\u0002J\u0012\u0010B\u001a\u0002082\b\u0010C\u001a\u0004\u0018\u00010\u0012H\u0003J\u0010\u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u0012H\u0002J\u001a\u0010F\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010\u0012H\u0002J\u0016\u0010I\u001a\b\u0012\u0004\u0012\u0002020G2\u0006\u00100\u001a\u00020\u0016H\u0002J\u0018\u0010J\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010G2\u0006\u00100\u001a\u00020\u0016H\u0002J \u0010K\u001a\u00020-2\u0006\u0010L\u001a\u00020=2\u0006\u0010M\u001a\u00020\u001a2\u0006\u0010N\u001a\u00020\u0015H\u0002J\u0010\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0002J\f\u0010S\u001a\u00020-*\u00020\u0016H\u0002J\f\u0010T\u001a\u00020-*\u00020\u0016H\u0002J\f\u0010U\u001a\u00020\u001a*\u00020\u0016H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\u00020\u0015*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006["}, d2 = {"Lexpo/modules/filesystem/FileSystemModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "client", "Lokhttp3/OkHttpClient;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dirPermissionsRequest", "Lexpo/modules/kotlin/Promise;", "moduleCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "okHttpClient", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "taskHandlers", "", "", "Lexpo/modules/filesystem/FileSystemModule$TaskHandler;", "isSAFUri", "", "Landroid/net/Uri;", "(Landroid/net/Uri;)Z", "contentUriFromFile", "file", "Ljava/io/File;", "createRequestBody", "Lokhttp3/RequestBody;", "options", "Lexpo/modules/filesystem/FileSystemUploadOptions;", "decorator", "Lexpo/modules/filesystem/RequestBodyDecorator;", "createUploadRequest", "Lokhttp3/Request;", ImagesContract.URL, "fileUriString", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "downloadResumableTask", "", OutcomeEventsTable.COLUMN_NAME_PARAMS, "Lexpo/modules/filesystem/FileSystemModule$DownloadResumableTaskParams;", "(Lexpo/modules/filesystem/FileSystemModule$DownloadResumableTaskParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureDirExists", "", "dir", "ensurePermission", "uri", "permission", "Lexpo/modules/interfaces/filesystem/Permission;", "errorMsg", "forceDelete", "getFileSize", "", "getInputStream", "Ljava/io/InputStream;", "getInputStreamBytes", "", "inputStream", "getNearestSAFFile", "Landroidx/documentfile/provider/DocumentFile;", "getOutputStream", "Ljava/io/OutputStream;", "md5", "openAssetInputStream", "openResourceInputStream", "resourceName", "parseFileUri", "uriStr", "permissionsForPath", "Ljava/util/EnumSet;", ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, "permissionsForSAFUri", "permissionsForUri", "transformFilesFromSAF", "documentFile", "outputDir", "copy", "translateHeaders", "Landroid/os/Bundle;", "headers", "Lokhttp3/Headers;", "checkIfFileDirExists", "checkIfFileExists", "toFile", "DownloadResumableTaskParams", "DownloadTaskHandler", "ProgressListener", "ProgressResponseBody", "TaskHandler", "expo-file-system_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public class FileSystemModule extends Module {
    private OkHttpClient client;
    private Promise dirPermissionsRequest;
    private final Map<String, TaskHandler> taskHandlers = new HashMap();
    private final CoroutineScope moduleCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());

    /* compiled from: FileSystemModule.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lexpo/modules/filesystem/FileSystemModule$ProgressListener;", "", "update", "", "bytesRead", "", "contentLength", "done", "", "expo-file-system_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface ProgressListener {
        void update(long bytesRead, long contentLength, boolean done);
    }

    /* compiled from: FileSystemModule.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileSystemUploadType.values().length];
            try {
                iArr[FileSystemUploadType.BINARY_CONTENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileSystemUploadType.MULTIPART.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.AppContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        FileSystemModule fileSystemModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (fileSystemModule.getClass() + ".ModuleDefinition"));
        try {
            final ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(fileSystemModule);
            moduleDefinitionBuilder.Name("ExponentFileSystem");
            moduleDefinitionBuilder.Constants(TuplesKt.to("documentDirectory", Uri.fromFile(getContext().getFilesDir()).toString() + "/"), TuplesKt.to("cacheDirectory", Uri.fromFile(getContext().getCacheDir()).toString() + "/"), TuplesKt.to("bundleDirectory", "asset:///"));
            moduleDefinitionBuilder.Events("expo-file-system.downloadProgress", "expo-file-system.uploadProgress");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$OnCreate$1
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
                    try {
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        File filesDir = fileSystemModule2.getContext().getFilesDir();
                        Intrinsics.checkNotNullExpressionValue(filesDir, "context.filesDir");
                        fileSystemModule2.ensureDirExists(filesDir);
                        FileSystemModule fileSystemModule3 = FileSystemModule.this;
                        File cacheDir = fileSystemModule3.getContext().getCacheDir();
                        Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
                        fileSystemModule3.ensureDirExists(cacheDir);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getInfoAsync", InfoOptions.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getInfoAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$2
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:40:0x0141 A[Catch: FileNotFoundException -> 0x0185, TryCatch #0 {FileNotFoundException -> 0x0185, blocks: (B:29:0x00fe, B:31:0x0104, B:36:0x0113, B:38:0x0119, B:40:0x0141, B:42:0x0169, B:45:0x017f, B:46:0x0184, B:47:0x0128, B:50:0x012f, B:51:0x0139), top: B:28:0x00fe }] */
                /* JADX WARN: Removed duplicated region for block: B:45:0x017f A[Catch: FileNotFoundException -> 0x0185, TryCatch #0 {FileNotFoundException -> 0x0185, blocks: (B:29:0x00fe, B:31:0x0104, B:36:0x0113, B:38:0x0119, B:40:0x0141, B:42:0x0169, B:45:0x017f, B:46:0x0184, B:47:0x0128, B:50:0x012f, B:51:0x0139), top: B:28:0x00fe }] */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke2(java.lang.Object[] r14, expo.modules.kotlin.Promise r15) {
                    /*
                        Method dump skipped, instructions count: 407
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$2.invoke2(java.lang.Object[], expo.modules.kotlin.Promise):void");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getInfoAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(InfoOptions.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(InfoOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$5
                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:43:0x0141 A[Catch: FileNotFoundException -> 0x0186, TryCatch #0 {FileNotFoundException -> 0x0186, blocks: (B:32:0x00fe, B:34:0x0104, B:39:0x0113, B:41:0x0119, B:43:0x0141, B:45:0x0169, B:48:0x0180, B:49:0x0185, B:50:0x0128, B:53:0x012f, B:54:0x0139), top: B:31:0x00fe }] */
                /* JADX WARN: Removed duplicated region for block: B:48:0x0180 A[Catch: FileNotFoundException -> 0x0186, TryCatch #0 {FileNotFoundException -> 0x0186, blocks: (B:32:0x00fe, B:34:0x0104, B:39:0x0113, B:41:0x0119, B:43:0x0141, B:45:0x0169, B:48:0x0180, B:49:0x0185, B:50:0x0128, B:53:0x012f, B:54:0x0139), top: B:31:0x00fe }] */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invoke(java.lang.Object[] r15) {
                    /*
                        Method dump skipped, instructions count: 418
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$5.invoke(java.lang.Object[]):java.lang.Object");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("readAsStringAsync", ReadingOptions.class == Promise.class ? new AsyncFunctionWithPromiseComponent("readAsStringAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$7
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    String slashifyFilePath;
                    boolean isSAFUri;
                    InputStream openResourceInputStream;
                    InputStream openAssetInputStream;
                    File file;
                    InputStream inputStream;
                    byte[] inputStreamBytes;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        String str = (String) obj;
                        ReadingOptions readingOptions = (ReadingOptions) promise;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str);
                        Uri uri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        fileSystemModule2.ensurePermission(uri, Permission.READ);
                        if (readingOptions.getEncoding() == EncodingType.BASE64) {
                            inputStream = FileSystemModule.this.getInputStream(uri);
                            InputStream inputStream2 = inputStream;
                            try {
                                InputStream inputStream3 = inputStream2;
                                if (readingOptions.getLength() == null || readingOptions.getPosition() == null) {
                                    inputStreamBytes = FileSystemModule.this.getInputStreamBytes(inputStream3);
                                    Base64.encodeToString(inputStreamBytes, 2);
                                } else {
                                    byte[] bArr = new byte[readingOptions.getLength().intValue()];
                                    inputStream3.skip(readingOptions.getPosition().intValue());
                                    Base64.encodeToString(bArr, 0, inputStream3.read(bArr, 0, readingOptions.getLength().intValue()), 2);
                                }
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(inputStream2, null);
                                return;
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    CloseableKt.closeFinally(inputStream2, th);
                                    throw th2;
                                }
                            }
                        }
                        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
                            file = FileSystemModule.this.toFile(uri);
                            IOUtils.toString(new FileInputStream(file));
                            return;
                        }
                        if (Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_ASSET_SCHEME)) {
                            openAssetInputStream = FileSystemModule.this.openAssetInputStream(uri);
                            IOUtils.toString(openAssetInputStream);
                            return;
                        }
                        if (uri.getScheme() == null) {
                            openResourceInputStream = FileSystemModule.this.openResourceInputStream(str);
                            IOUtils.toString(openResourceInputStream);
                            return;
                        }
                        isSAFUri = FileSystemModule.this.isSAFUri(uri);
                        if (isSAFUri) {
                            IOUtils.toString(FileSystemModule.this.getContext().getContentResolver().openInputStream(uri));
                            return;
                        }
                        throw new IOException("Unsupported scheme for location '" + uri + "'.");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("readAsStringAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadingOptions.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadingOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$10
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String slashifyFilePath;
                    boolean isSAFUri;
                    InputStream openResourceInputStream;
                    InputStream openAssetInputStream;
                    File file;
                    InputStream inputStream;
                    byte[] inputStreamBytes;
                    String encodeToString;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        ReadingOptions readingOptions = (ReadingOptions) obj2;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str);
                        Uri uri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        fileSystemModule2.ensurePermission(uri, Permission.READ);
                        if (readingOptions.getEncoding() == EncodingType.BASE64) {
                            inputStream = FileSystemModule.this.getInputStream(uri);
                            InputStream inputStream2 = inputStream;
                            try {
                                InputStream inputStream3 = inputStream2;
                                if (readingOptions.getLength() == null || readingOptions.getPosition() == null) {
                                    inputStreamBytes = FileSystemModule.this.getInputStreamBytes(inputStream3);
                                    encodeToString = Base64.encodeToString(inputStreamBytes, 2);
                                } else {
                                    byte[] bArr = new byte[readingOptions.getLength().intValue()];
                                    inputStream3.skip(readingOptions.getPosition().intValue());
                                    encodeToString = Base64.encodeToString(bArr, 0, inputStream3.read(bArr, 0, readingOptions.getLength().intValue()), 2);
                                }
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(inputStream2, null);
                                return encodeToString;
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    CloseableKt.closeFinally(inputStream2, th);
                                    throw th2;
                                }
                            }
                        }
                        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
                            file = FileSystemModule.this.toFile(uri);
                            return IOUtils.toString(new FileInputStream(file));
                        }
                        if (Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_ASSET_SCHEME)) {
                            openAssetInputStream = FileSystemModule.this.openAssetInputStream(uri);
                            return IOUtils.toString(openAssetInputStream);
                        }
                        if (uri.getScheme() == null) {
                            openResourceInputStream = FileSystemModule.this.openResourceInputStream(str);
                            return IOUtils.toString(openResourceInputStream);
                        }
                        isSAFUri = FileSystemModule.this.isSAFUri(uri);
                        if (isSAFUri) {
                            return IOUtils.toString(FileSystemModule.this.getContext().getContentResolver().openInputStream(uri));
                        }
                        throw new IOException("Unsupported scheme for location '" + uri + "'.");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.filesystem.ReadingOptions");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("writeAsStringAsync", WritingOptions.class == Promise.class ? new AsyncFunctionWithPromiseComponent("writeAsStringAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$13
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    String slashifyFilePath;
                    OutputStream outputStream;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = args[1];
                    if (obj2 != null) {
                        String str2 = (String) obj2;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str);
                        Uri uri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        fileSystemModule2.ensurePermission(uri, Permission.WRITE);
                        EncodingType encoding = ((WritingOptions) promise).getEncoding();
                        outputStream = FileSystemModule.this.getOutputStream(uri);
                        OutputStreamWriter outputStreamWriter = outputStream;
                        try {
                            OutputStream outputStream2 = outputStreamWriter;
                            if (encoding == EncodingType.BASE64) {
                                outputStream2.write(Base64.decode(str2, 0));
                            } else {
                                outputStreamWriter = new OutputStreamWriter(outputStream2);
                                try {
                                    outputStreamWriter.write(str2);
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(outputStreamWriter, null);
                                } finally {
                                }
                            }
                            Unit unit2 = Unit.INSTANCE;
                            CloseableKt.closeFinally(outputStreamWriter, null);
                        } finally {
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("writeAsStringAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(WritingOptions.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(WritingOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$17
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String slashifyFilePath;
                    OutputStream outputStream;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str2 = (String) obj2;
                    Object obj3 = it[2];
                    if (obj3 != null) {
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str);
                        Uri uri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        fileSystemModule2.ensurePermission(uri, Permission.WRITE);
                        EncodingType encoding = ((WritingOptions) obj3).getEncoding();
                        outputStream = FileSystemModule.this.getOutputStream(uri);
                        OutputStreamWriter outputStreamWriter = outputStream;
                        try {
                            OutputStream outputStream2 = outputStreamWriter;
                            if (encoding == EncodingType.BASE64) {
                                outputStream2.write(Base64.decode(str2, 0));
                            } else {
                                outputStreamWriter = new OutputStreamWriter(outputStream2);
                                try {
                                    outputStreamWriter.write(str2);
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(outputStreamWriter, null);
                                } finally {
                                }
                            }
                            Unit unit2 = Unit.INSTANCE;
                            CloseableKt.closeFinally(outputStreamWriter, null);
                            return Unit.INSTANCE;
                        } finally {
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.filesystem.WritingOptions");
                    }
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("deleteAsync", DeletingOptions.class == Promise.class ? new AsyncFunctionWithPromiseComponent("deleteAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$19
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    String slashifyFilePath;
                    boolean isSAFUri;
                    DocumentFile nearestSAFFile;
                    File file;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        DeletingOptions deletingOptions = (DeletingOptions) promise;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath((String) obj);
                        Uri uri = Uri.parse(slashifyFilePath);
                        Uri appendedUri = Uri.withAppendedPath(uri, "..");
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(appendedUri, "appendedUri");
                        fileSystemModule2.ensurePermission(appendedUri, Permission.WRITE, "Location '" + uri + "' isn't deletable.");
                        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
                            FileSystemModule fileSystemModule3 = FileSystemModule.this;
                            Intrinsics.checkNotNullExpressionValue(uri, "uri");
                            file = fileSystemModule3.toFile(uri);
                            if (file.exists()) {
                                if (Build.VERSION.SDK_INT < 26) {
                                    FileSystemModule.this.forceDelete(file);
                                    return;
                                } else {
                                    FileUtils.forceDelete(file);
                                    return;
                                }
                            }
                            if (!deletingOptions.getIdempotent()) {
                                throw new FileSystemFileNotFoundException(uri);
                            }
                            return;
                        }
                        FileSystemModule fileSystemModule4 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        isSAFUri = fileSystemModule4.isSAFUri(uri);
                        if (isSAFUri) {
                            nearestSAFFile = FileSystemModule.this.getNearestSAFFile(uri);
                            if (nearestSAFFile != null && nearestSAFFile.exists()) {
                                nearestSAFFile.delete();
                                return;
                            } else {
                                if (!deletingOptions.getIdempotent()) {
                                    throw new FileSystemFileNotFoundException(uri);
                                }
                                return;
                            }
                        }
                        throw new IOException("Unsupported scheme for location '" + uri + "'.");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("deleteAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DeletingOptions.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(DeletingOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$22
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String slashifyFilePath;
                    boolean isSAFUri;
                    DocumentFile nearestSAFFile;
                    File file;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        DeletingOptions deletingOptions = (DeletingOptions) obj2;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str);
                        Uri uri = Uri.parse(slashifyFilePath);
                        Uri appendedUri = Uri.withAppendedPath(uri, "..");
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(appendedUri, "appendedUri");
                        fileSystemModule2.ensurePermission(appendedUri, Permission.WRITE, "Location '" + uri + "' isn't deletable.");
                        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
                            FileSystemModule fileSystemModule3 = FileSystemModule.this;
                            Intrinsics.checkNotNullExpressionValue(uri, "uri");
                            file = fileSystemModule3.toFile(uri);
                            if (file.exists()) {
                                if (Build.VERSION.SDK_INT < 26) {
                                    FileSystemModule.this.forceDelete(file);
                                } else {
                                    FileUtils.forceDelete(file);
                                }
                            } else if (!deletingOptions.getIdempotent()) {
                                throw new FileSystemFileNotFoundException(uri);
                            }
                        } else {
                            FileSystemModule fileSystemModule4 = FileSystemModule.this;
                            Intrinsics.checkNotNullExpressionValue(uri, "uri");
                            isSAFUri = fileSystemModule4.isSAFUri(uri);
                            if (isSAFUri) {
                                nearestSAFFile = FileSystemModule.this.getNearestSAFFile(uri);
                                if (nearestSAFFile != null && nearestSAFFile.exists()) {
                                    nearestSAFFile.delete();
                                } else if (!deletingOptions.getIdempotent()) {
                                    throw new FileSystemFileNotFoundException(uri);
                                }
                            } else {
                                throw new IOException("Unsupported scheme for location '" + uri + "'.");
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.filesystem.DeletingOptions");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("moveAsync", RelocatingOptions.class == Promise.class ? new AsyncFunctionWithPromiseComponent("moveAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$23
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    String slashifyFilePath;
                    String slashifyFilePath2;
                    boolean isSAFUri;
                    DocumentFile nearestSAFFile;
                    File file;
                    File file2;
                    File file3;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    RelocatingOptions relocatingOptions = (RelocatingOptions) promise;
                    slashifyFilePath = FileSystemModuleKt.slashifyFilePath(relocatingOptions.getFrom());
                    Uri fromUri = Uri.parse(slashifyFilePath);
                    FileSystemModule fileSystemModule2 = FileSystemModule.this;
                    Uri withAppendedPath = Uri.withAppendedPath(fromUri, "..");
                    Intrinsics.checkNotNullExpressionValue(withAppendedPath, "withAppendedPath(fromUri, \"..\")");
                    fileSystemModule2.ensurePermission(withAppendedPath, Permission.WRITE, "Location '" + fromUri + "' isn't movable.");
                    slashifyFilePath2 = FileSystemModuleKt.slashifyFilePath(relocatingOptions.getTo());
                    Uri toUri = Uri.parse(slashifyFilePath2);
                    FileSystemModule fileSystemModule3 = FileSystemModule.this;
                    Intrinsics.checkNotNullExpressionValue(toUri, "toUri");
                    fileSystemModule3.ensurePermission(toUri, Permission.WRITE);
                    if (Intrinsics.areEqual(fromUri.getScheme(), "file")) {
                        FileSystemModule fileSystemModule4 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(fromUri, "fromUri");
                        file2 = fileSystemModule4.toFile(fromUri);
                        file3 = FileSystemModule.this.toFile(toUri);
                        if (!file2.renameTo(file3)) {
                            throw new FileSystemCannotMoveFileException(fromUri, toUri);
                        }
                        return;
                    }
                    FileSystemModule fileSystemModule5 = FileSystemModule.this;
                    Intrinsics.checkNotNullExpressionValue(fromUri, "fromUri");
                    isSAFUri = fileSystemModule5.isSAFUri(fromUri);
                    if (isSAFUri) {
                        nearestSAFFile = FileSystemModule.this.getNearestSAFFile(fromUri);
                        if (nearestSAFFile != null && nearestSAFFile.exists()) {
                            file = FileSystemModule.this.toFile(toUri);
                            FileSystemModule.this.transformFilesFromSAF(nearestSAFFile, file, false);
                            return;
                        }
                        throw new FileSystemCannotMoveFileException(fromUri, toUri);
                    }
                    throw new IOException("Unsupported scheme for location '" + fromUri + "'.");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("moveAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(RelocatingOptions.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(RelocatingOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$25
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String slashifyFilePath;
                    String slashifyFilePath2;
                    boolean isSAFUri;
                    DocumentFile nearestSAFFile;
                    File file;
                    File file2;
                    File file3;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        RelocatingOptions relocatingOptions = (RelocatingOptions) obj;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(relocatingOptions.getFrom());
                        Uri fromUri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Uri withAppendedPath = Uri.withAppendedPath(fromUri, "..");
                        Intrinsics.checkNotNullExpressionValue(withAppendedPath, "withAppendedPath(fromUri, \"..\")");
                        fileSystemModule2.ensurePermission(withAppendedPath, Permission.WRITE, "Location '" + fromUri + "' isn't movable.");
                        slashifyFilePath2 = FileSystemModuleKt.slashifyFilePath(relocatingOptions.getTo());
                        Uri toUri = Uri.parse(slashifyFilePath2);
                        FileSystemModule fileSystemModule3 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(toUri, "toUri");
                        fileSystemModule3.ensurePermission(toUri, Permission.WRITE);
                        if (Intrinsics.areEqual(fromUri.getScheme(), "file")) {
                            FileSystemModule fileSystemModule4 = FileSystemModule.this;
                            Intrinsics.checkNotNullExpressionValue(fromUri, "fromUri");
                            file2 = fileSystemModule4.toFile(fromUri);
                            file3 = FileSystemModule.this.toFile(toUri);
                            if (!file2.renameTo(file3)) {
                                throw new FileSystemCannotMoveFileException(fromUri, toUri);
                            }
                        } else {
                            FileSystemModule fileSystemModule5 = FileSystemModule.this;
                            Intrinsics.checkNotNullExpressionValue(fromUri, "fromUri");
                            isSAFUri = fileSystemModule5.isSAFUri(fromUri);
                            if (isSAFUri) {
                                nearestSAFFile = FileSystemModule.this.getNearestSAFFile(fromUri);
                                if (nearestSAFFile != null && nearestSAFFile.exists()) {
                                    file = FileSystemModule.this.toFile(toUri);
                                    FileSystemModule.this.transformFilesFromSAF(nearestSAFFile, file, false);
                                } else {
                                    throw new FileSystemCannotMoveFileException(fromUri, toUri);
                                }
                            } else {
                                throw new IOException("Unsupported scheme for location '" + fromUri + "'.");
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.filesystem.RelocatingOptions");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("copyAsync", RelocatingOptions.class == Promise.class ? new AsyncFunctionWithPromiseComponent("copyAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$26
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    String slashifyFilePath;
                    String slashifyFilePath2;
                    boolean isSAFUri;
                    InputStream openResourceInputStream;
                    File file;
                    InputStream openAssetInputStream;
                    File file2;
                    File file3;
                    DocumentFile nearestSAFFile;
                    File file4;
                    File file5;
                    File file6;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    RelocatingOptions relocatingOptions = (RelocatingOptions) promise;
                    slashifyFilePath = FileSystemModuleKt.slashifyFilePath(relocatingOptions.getFrom());
                    Uri fromUri = Uri.parse(slashifyFilePath);
                    FileSystemModule fileSystemModule2 = FileSystemModule.this;
                    Intrinsics.checkNotNullExpressionValue(fromUri, "fromUri");
                    fileSystemModule2.ensurePermission(fromUri, Permission.READ, "Location '" + fromUri + "' isn't readable.");
                    slashifyFilePath2 = FileSystemModuleKt.slashifyFilePath(relocatingOptions.getTo());
                    Uri toUri = Uri.parse(slashifyFilePath2);
                    FileSystemModule fileSystemModule3 = FileSystemModule.this;
                    Intrinsics.checkNotNullExpressionValue(toUri, "toUri");
                    fileSystemModule3.ensurePermission(toUri, Permission.WRITE);
                    if (Intrinsics.areEqual(fromUri.getScheme(), "file")) {
                        file5 = FileSystemModule.this.toFile(fromUri);
                        file6 = FileSystemModule.this.toFile(toUri);
                        if (file5.isDirectory()) {
                            FileUtils.copyDirectory(file5, file6);
                            return;
                        } else {
                            FileUtils.copyFile(file5, file6);
                            return;
                        }
                    }
                    isSAFUri = FileSystemModule.this.isSAFUri(fromUri);
                    if (isSAFUri) {
                        nearestSAFFile = FileSystemModule.this.getNearestSAFFile(fromUri);
                        if (nearestSAFFile != null && nearestSAFFile.exists()) {
                            file4 = FileSystemModule.this.toFile(toUri);
                            FileSystemModule.this.transformFilesFromSAF(nearestSAFFile, file4, true);
                            return;
                        }
                        throw new FileSystemCopyFailedException(fromUri);
                    }
                    if (Intrinsics.areEqual(fromUri.getScheme(), UriUtil.LOCAL_CONTENT_SCHEME)) {
                        InputStream openInputStream = FileSystemModule.this.getContext().getContentResolver().openInputStream(fromUri);
                        file3 = FileSystemModule.this.toFile(toUri);
                        IOUtils.copy(openInputStream, new FileOutputStream(file3));
                    } else if (Intrinsics.areEqual(fromUri.getScheme(), UriUtil.LOCAL_ASSET_SCHEME)) {
                        openAssetInputStream = FileSystemModule.this.openAssetInputStream(fromUri);
                        file2 = FileSystemModule.this.toFile(toUri);
                        IOUtils.copy(openAssetInputStream, new FileOutputStream(file2));
                    } else if (fromUri.getScheme() == null) {
                        openResourceInputStream = FileSystemModule.this.openResourceInputStream(relocatingOptions.getFrom());
                        file = FileSystemModule.this.toFile(toUri);
                        IOUtils.copy(openResourceInputStream, new FileOutputStream(file));
                    } else {
                        throw new IOException("Unsupported scheme for location '" + fromUri + "'.");
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("copyAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(RelocatingOptions.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$27
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(RelocatingOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$28
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String slashifyFilePath;
                    String slashifyFilePath2;
                    boolean isSAFUri;
                    InputStream openResourceInputStream;
                    File file;
                    InputStream openAssetInputStream;
                    File file2;
                    File file3;
                    DocumentFile nearestSAFFile;
                    File file4;
                    File file5;
                    File file6;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        RelocatingOptions relocatingOptions = (RelocatingOptions) obj;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(relocatingOptions.getFrom());
                        Uri fromUri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(fromUri, "fromUri");
                        fileSystemModule2.ensurePermission(fromUri, Permission.READ, "Location '" + fromUri + "' isn't readable.");
                        slashifyFilePath2 = FileSystemModuleKt.slashifyFilePath(relocatingOptions.getTo());
                        Uri toUri = Uri.parse(slashifyFilePath2);
                        FileSystemModule fileSystemModule3 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(toUri, "toUri");
                        fileSystemModule3.ensurePermission(toUri, Permission.WRITE);
                        if (Intrinsics.areEqual(fromUri.getScheme(), "file")) {
                            file5 = FileSystemModule.this.toFile(fromUri);
                            file6 = FileSystemModule.this.toFile(toUri);
                            if (file5.isDirectory()) {
                                FileUtils.copyDirectory(file5, file6);
                            } else {
                                FileUtils.copyFile(file5, file6);
                            }
                            return Unit.INSTANCE;
                        }
                        isSAFUri = FileSystemModule.this.isSAFUri(fromUri);
                        if (isSAFUri) {
                            nearestSAFFile = FileSystemModule.this.getNearestSAFFile(fromUri);
                            if (nearestSAFFile != null && nearestSAFFile.exists()) {
                                file4 = FileSystemModule.this.toFile(toUri);
                                FileSystemModule.this.transformFilesFromSAF(nearestSAFFile, file4, true);
                                return Unit.INSTANCE;
                            }
                            throw new FileSystemCopyFailedException(fromUri);
                        }
                        if (Intrinsics.areEqual(fromUri.getScheme(), UriUtil.LOCAL_CONTENT_SCHEME)) {
                            InputStream openInputStream = FileSystemModule.this.getContext().getContentResolver().openInputStream(fromUri);
                            file3 = FileSystemModule.this.toFile(toUri);
                            return Integer.valueOf(IOUtils.copy(openInputStream, new FileOutputStream(file3)));
                        }
                        if (Intrinsics.areEqual(fromUri.getScheme(), UriUtil.LOCAL_ASSET_SCHEME)) {
                            openAssetInputStream = FileSystemModule.this.openAssetInputStream(fromUri);
                            file2 = FileSystemModule.this.toFile(toUri);
                            return Integer.valueOf(IOUtils.copy(openAssetInputStream, new FileOutputStream(file2)));
                        }
                        if (fromUri.getScheme() == null) {
                            openResourceInputStream = FileSystemModule.this.openResourceInputStream(relocatingOptions.getFrom());
                            file = FileSystemModule.this.toFile(toUri);
                            return Integer.valueOf(IOUtils.copy(openResourceInputStream, new FileOutputStream(file)));
                        }
                        throw new IOException("Unsupported scheme for location '" + fromUri + "'.");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.filesystem.RelocatingOptions");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("makeDirectoryAsync", MakeDirectoryOptions.class == Promise.class ? new AsyncFunctionWithPromiseComponent("makeDirectoryAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$29
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$30
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    String slashifyFilePath;
                    File file;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        MakeDirectoryOptions makeDirectoryOptions = (MakeDirectoryOptions) promise;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath((String) obj);
                        Uri uri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        fileSystemModule2.ensurePermission(uri, Permission.WRITE);
                        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
                            file = FileSystemModule.this.toFile(uri);
                            boolean isDirectory = file.isDirectory();
                            boolean intermediates = makeDirectoryOptions.getIntermediates();
                            if (intermediates ? file.mkdirs() : file.mkdir()) {
                                return;
                            }
                            if (!intermediates || !isDirectory) {
                                throw new FileSystemCannotCreateDirectoryException(uri);
                            }
                            return;
                        }
                        throw new IOException("Unsupported scheme for location '" + uri + "'.");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("makeDirectoryAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$31
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(MakeDirectoryOptions.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$32
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(MakeDirectoryOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$33
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String slashifyFilePath;
                    File file;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        MakeDirectoryOptions makeDirectoryOptions = (MakeDirectoryOptions) obj2;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str);
                        Uri uri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        fileSystemModule2.ensurePermission(uri, Permission.WRITE);
                        if (!Intrinsics.areEqual(uri.getScheme(), "file")) {
                            throw new IOException("Unsupported scheme for location '" + uri + "'.");
                        }
                        file = FileSystemModule.this.toFile(uri);
                        boolean isDirectory = file.isDirectory();
                        boolean intermediates = makeDirectoryOptions.getIntermediates();
                        if (!(intermediates ? file.mkdirs() : file.mkdir()) && (!intermediates || !isDirectory)) {
                            throw new FileSystemCannotCreateDirectoryException(uri);
                        }
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.filesystem.MakeDirectoryOptions");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("readDirectoryAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("readDirectoryAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$34
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    String slashifyFilePath;
                    boolean isSAFUri;
                    File file;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    slashifyFilePath = FileSystemModuleKt.slashifyFilePath((String) promise);
                    Uri uri = Uri.parse(slashifyFilePath);
                    FileSystemModule fileSystemModule2 = FileSystemModule.this;
                    Intrinsics.checkNotNullExpressionValue(uri, "uri");
                    fileSystemModule2.ensurePermission(uri, Permission.READ);
                    if (Intrinsics.areEqual(uri.getScheme(), "file")) {
                        file = FileSystemModule.this.toFile(uri);
                        File[] listFiles = file.listFiles();
                        if (listFiles == null) {
                            throw new FileSystemCannotReadDirectoryException(uri);
                        }
                        ArrayList arrayList = new ArrayList(listFiles.length);
                        int length = listFiles.length;
                        for (int i = 0; i < length; i++) {
                            File file2 = listFiles[i];
                            arrayList.add(file2 != null ? file2.getName() : null);
                        }
                        return;
                    }
                    isSAFUri = FileSystemModule.this.isSAFUri(uri);
                    if (isSAFUri) {
                        throw new FileSystemUnsupportedSchemeException();
                    }
                    throw new IOException("Unsupported scheme for location '" + uri + "'.");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("readDirectoryAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$35
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$36
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String slashifyFilePath;
                    boolean isSAFUri;
                    File file;
                    Intrinsics.checkNotNullParameter(it, "it");
                    slashifyFilePath = FileSystemModuleKt.slashifyFilePath((String) it[0]);
                    Uri uri = Uri.parse(slashifyFilePath);
                    FileSystemModule fileSystemModule2 = FileSystemModule.this;
                    Intrinsics.checkNotNullExpressionValue(uri, "uri");
                    fileSystemModule2.ensurePermission(uri, Permission.READ);
                    if (Intrinsics.areEqual(uri.getScheme(), "file")) {
                        file = FileSystemModule.this.toFile(uri);
                        File[] listFiles = file.listFiles();
                        if (listFiles == null) {
                            throw new FileSystemCannotReadDirectoryException(uri);
                        }
                        ArrayList arrayList = new ArrayList(listFiles.length);
                        int length = listFiles.length;
                        for (int i = 0; i < length; i++) {
                            File file2 = listFiles[i];
                            arrayList.add(file2 != null ? file2.getName() : null);
                        }
                        return arrayList;
                    }
                    isSAFUri = FileSystemModule.this.isSAFUri(uri);
                    if (isSAFUri) {
                        throw new FileSystemUnsupportedSchemeException();
                    }
                    throw new IOException("Unsupported scheme for location '" + uri + "'.");
                }
            }));
            AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("getTotalDiskCapacityAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
                    return Double.valueOf(RangesKt.coerceAtMost(BigInteger.valueOf(statFs.getBlockCountLong()).multiply(BigInteger.valueOf(statFs.getBlockSizeLong())).doubleValue(), Math.pow(2.0d, 53.0d) - 1));
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getTotalDiskCapacityAsync", asyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionComponent;
            AsyncFunctionComponent asyncFunctionComponent3 = new AsyncFunctionComponent("getFreeDiskStorageAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunctionWithoutArgs$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
                    return Double.valueOf(RangesKt.coerceAtMost(BigInteger.valueOf(statFs.getAvailableBlocksLong()).multiply(BigInteger.valueOf(statFs.getBlockSizeLong())).doubleValue(), Math.pow(2.0d, 53.0d) - 1));
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getFreeDiskStorageAsync", asyncFunctionComponent3);
            AsyncFunctionComponent asyncFunctionComponent4 = asyncFunctionComponent3;
            moduleDefinitionBuilder.getAsyncFunctions().put("getContentUriAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getContentUriAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$37
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    String slashifyFilePath;
                    File file;
                    Uri contentUriFromFile;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) promise;
                    slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str);
                    Uri fileUri = Uri.parse(slashifyFilePath);
                    FileSystemModule fileSystemModule2 = FileSystemModule.this;
                    Intrinsics.checkNotNullExpressionValue(fileUri, "fileUri");
                    fileSystemModule2.ensurePermission(fileUri, Permission.WRITE);
                    FileSystemModule.this.ensurePermission(fileUri, Permission.READ);
                    FileSystemModule.this.checkIfFileDirExists(fileUri);
                    if (Intrinsics.areEqual(fileUri.getScheme(), "file")) {
                        file = FileSystemModule.this.toFile(fileUri);
                        contentUriFromFile = FileSystemModule.this.contentUriFromFile(file);
                        contentUriFromFile.toString();
                        return;
                    }
                    throw new FileSystemUnreadableDirectoryException(str);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getContentUriAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$38
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$39
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String slashifyFilePath;
                    File file;
                    Uri contentUriFromFile;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        String str = (String) obj;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str);
                        Uri fileUri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(fileUri, "fileUri");
                        fileSystemModule2.ensurePermission(fileUri, Permission.WRITE);
                        FileSystemModule.this.ensurePermission(fileUri, Permission.READ);
                        FileSystemModule.this.checkIfFileDirExists(fileUri);
                        if (Intrinsics.areEqual(fileUri.getScheme(), "file")) {
                            file = FileSystemModule.this.toFile(fileUri);
                            contentUriFromFile = FileSystemModule.this.contentUriFromFile(file);
                            return contentUriFromFile.toString();
                        }
                        throw new FileSystemUnreadableDirectoryException(str);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("readSAFDirectoryAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("readSAFDirectoryAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$40
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    String slashifyFilePath;
                    boolean isSAFUri;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    slashifyFilePath = FileSystemModuleKt.slashifyFilePath((String) promise);
                    Uri uri = Uri.parse(slashifyFilePath);
                    FileSystemModule fileSystemModule2 = FileSystemModule.this;
                    Intrinsics.checkNotNullExpressionValue(uri, "uri");
                    fileSystemModule2.ensurePermission(uri, Permission.READ);
                    isSAFUri = FileSystemModule.this.isSAFUri(uri);
                    if (isSAFUri) {
                        DocumentFile fromTreeUri = DocumentFile.fromTreeUri(FileSystemModule.this.getContext(), uri);
                        if (fromTreeUri == null || !fromTreeUri.exists() || !fromTreeUri.isDirectory()) {
                            throw new FileSystemCannotReadDirectoryException(uri);
                        }
                        DocumentFile[] listFiles = fromTreeUri.listFiles();
                        Intrinsics.checkNotNullExpressionValue(listFiles, "file.listFiles()");
                        ArrayList arrayList = new ArrayList(listFiles.length);
                        for (DocumentFile documentFile : listFiles) {
                            arrayList.add(documentFile.getUri().toString());
                        }
                        return;
                    }
                    throw new IOException("The URI '" + uri + "' is not a Storage Access Framework URI. Try using FileSystem.readDirectoryAsync instead.");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("readSAFDirectoryAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$41
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$42
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String slashifyFilePath;
                    boolean isSAFUri;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath((String) obj);
                        Uri uri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        fileSystemModule2.ensurePermission(uri, Permission.READ);
                        isSAFUri = FileSystemModule.this.isSAFUri(uri);
                        if (isSAFUri) {
                            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(FileSystemModule.this.getContext(), uri);
                            if (fromTreeUri == null || !fromTreeUri.exists() || !fromTreeUri.isDirectory()) {
                                throw new FileSystemCannotReadDirectoryException(uri);
                            }
                            DocumentFile[] listFiles = fromTreeUri.listFiles();
                            Intrinsics.checkNotNullExpressionValue(listFiles, "file.listFiles()");
                            ArrayList arrayList = new ArrayList(listFiles.length);
                            for (DocumentFile documentFile : listFiles) {
                                arrayList.add(documentFile.getUri().toString());
                            }
                            return arrayList;
                        }
                        throw new IOException("The URI '" + uri + "' is not a Storage Access Framework URI. Try using FileSystem.readDirectoryAsync instead.");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("makeSAFDirectoryAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("makeSAFDirectoryAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$43
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$44
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    String slashifyFilePath;
                    boolean isSAFUri;
                    DocumentFile nearestSAFFile;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        String str = (String) promise;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath((String) obj);
                        Uri uri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        fileSystemModule2.ensurePermission(uri, Permission.WRITE);
                        isSAFUri = FileSystemModule.this.isSAFUri(uri);
                        if (isSAFUri) {
                            nearestSAFFile = FileSystemModule.this.getNearestSAFFile(uri);
                            if (nearestSAFFile != null && !nearestSAFFile.isDirectory()) {
                                throw new FileSystemCannotCreateDirectoryException(uri);
                            }
                            DocumentFile createDirectory = nearestSAFFile != null ? nearestSAFFile.createDirectory(str) : null;
                            if (createDirectory == null) {
                                throw new FileSystemCannotCreateDirectoryException(null);
                            }
                            Intrinsics.checkNotNullExpressionValue(createDirectory, "dirName.let { dir?.creat…eDirectoryException(null)");
                            createDirectory.getUri().toString();
                            return;
                        }
                        throw new IOException("The URI '" + uri + "' is not a Storage Access Framework URI. Try using FileSystem.makeDirectoryAsync instead.");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("makeSAFDirectoryAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$45
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$46
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$47
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String slashifyFilePath;
                    boolean isSAFUri;
                    DocumentFile nearestSAFFile;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        String str2 = (String) obj2;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str);
                        Uri uri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        fileSystemModule2.ensurePermission(uri, Permission.WRITE);
                        isSAFUri = FileSystemModule.this.isSAFUri(uri);
                        if (isSAFUri) {
                            nearestSAFFile = FileSystemModule.this.getNearestSAFFile(uri);
                            if (nearestSAFFile != null && !nearestSAFFile.isDirectory()) {
                                throw new FileSystemCannotCreateDirectoryException(uri);
                            }
                            DocumentFile createDirectory = nearestSAFFile != null ? nearestSAFFile.createDirectory(str2) : null;
                            if (createDirectory == null) {
                                throw new FileSystemCannotCreateDirectoryException(null);
                            }
                            Intrinsics.checkNotNullExpressionValue(createDirectory, "dirName.let { dir?.creat…eDirectoryException(null)");
                            return createDirectory.getUri().toString();
                        }
                        throw new IOException("The URI '" + uri + "' is not a Storage Access Framework URI. Try using FileSystem.makeDirectoryAsync instead.");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("createSAFFileAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("createSAFFileAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$48
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$49
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$50
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    String slashifyFilePath;
                    boolean isSAFUri;
                    DocumentFile nearestSAFFile;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = args[1];
                    if (obj2 != null) {
                        String str2 = (String) obj2;
                        String str3 = (String) promise;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str);
                        Uri uri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        fileSystemModule2.ensurePermission(uri, Permission.WRITE);
                        isSAFUri = FileSystemModule.this.isSAFUri(uri);
                        if (isSAFUri) {
                            nearestSAFFile = FileSystemModule.this.getNearestSAFFile(uri);
                            if (nearestSAFFile == null || !nearestSAFFile.isDirectory()) {
                                throw new FileSystemCannotCreateFileException(uri);
                            }
                            DocumentFile createFile = nearestSAFFile.createFile(str3, str2);
                            if (createFile == null) {
                                throw new FileSystemCannotCreateFileException(null);
                            }
                            Intrinsics.checkNotNullExpressionValue(createFile, "dir.createFile(mimeType,…CreateFileException(null)");
                            createFile.getUri().toString();
                            return;
                        }
                        throw new IOException("The URI '" + uri + "' is not a Storage Access Framework URI.");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("createSAFFileAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$51
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$52
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$53
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$54
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String slashifyFilePath;
                    boolean isSAFUri;
                    DocumentFile nearestSAFFile;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str2 = (String) obj2;
                    Object obj3 = it[2];
                    if (obj3 != null) {
                        String str3 = (String) obj3;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str);
                        Uri uri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        fileSystemModule2.ensurePermission(uri, Permission.WRITE);
                        isSAFUri = FileSystemModule.this.isSAFUri(uri);
                        if (isSAFUri) {
                            nearestSAFFile = FileSystemModule.this.getNearestSAFFile(uri);
                            if (nearestSAFFile == null || !nearestSAFFile.isDirectory()) {
                                throw new FileSystemCannotCreateFileException(uri);
                            }
                            DocumentFile createFile = nearestSAFFile.createFile(str3, str2);
                            if (createFile == null) {
                                throw new FileSystemCannotCreateFileException(null);
                            }
                            Intrinsics.checkNotNullExpressionValue(createFile, "dir.createFile(mimeType,…CreateFileException(null)");
                            return createFile.getUri().toString();
                        }
                        throw new IOException("The URI '" + uri + "' is not a Storage Access Framework URI.");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("requestDirectoryPermissionsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("requestDirectoryPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$55
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$56
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Promise promise2;
                    String slashifyFilePath;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) args[0];
                    Activity currentActivity = FileSystemModule.this.getAppContext().getCurrentActivity();
                    if (currentActivity != null) {
                        promise2 = FileSystemModule.this.dirPermissionsRequest;
                        if (promise2 != null) {
                            throw new FileSystemPendingPermissionsRequestException();
                        }
                        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                        if (Build.VERSION.SDK_INT >= 26 && str != null) {
                            slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str);
                            Uri parse = Uri.parse(slashifyFilePath);
                            if (parse != null) {
                                intent.putExtra("android.provider.extra.INITIAL_URI", parse);
                            }
                        }
                        FileSystemModule.this.dirPermissionsRequest = promise;
                        currentActivity.startActivityForResult(intent, 5394);
                        return;
                    }
                    throw new Exceptions.MissingActivity();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("requestDirectoryPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$57
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$58
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$59
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Promise promise;
                    String slashifyFilePath;
                    Intrinsics.checkNotNullParameter(it, "it");
                    String str = (String) it[0];
                    Object obj = it[1];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    Promise promise2 = (Promise) obj;
                    Activity currentActivity = FileSystemModule.this.getAppContext().getCurrentActivity();
                    if (currentActivity != null) {
                        promise = FileSystemModule.this.dirPermissionsRequest;
                        if (promise != null) {
                            throw new FileSystemPendingPermissionsRequestException();
                        }
                        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                        if (Build.VERSION.SDK_INT >= 26 && str != null) {
                            slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str);
                            Uri parse = Uri.parse(slashifyFilePath);
                            if (parse != null) {
                                intent.putExtra("android.provider.extra.INITIAL_URI", parse);
                            }
                        }
                        FileSystemModule.this.dirPermissionsRequest = promise2;
                        currentActivity.startActivityForResult(intent, 5394);
                        return Unit.INSTANCE;
                    }
                    throw new Exceptions.MissingActivity();
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("uploadAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("uploadAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$60
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$61
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemUploadOptions.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$62
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(FileSystemUploadOptions.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$63
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Request createUploadRequest;
                    OkHttpClient okHttpClient;
                    Unit unit;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = args[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str2 = (String) obj2;
                    Object obj3 = args[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.filesystem.FileSystemUploadOptions");
                    }
                    createUploadRequest = FileSystemModule.this.createUploadRequest(str, str2, (FileSystemUploadOptions) obj3, FileSystemModule$definition$1$17$request$1.INSTANCE);
                    okHttpClient = FileSystemModule.this.getOkHttpClient();
                    if (okHttpClient != null) {
                        okHttpClient.newCall(createUploadRequest).enqueue(new FileSystemModule$definition$1$17$1$1(promise, FileSystemModule.this));
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        promise.reject(new FileSystemOkHttpNullException());
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("uploadAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$64
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$65
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemUploadOptions.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$66
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(FileSystemUploadOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$67
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$68
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Request createUploadRequest;
                    OkHttpClient okHttpClient;
                    Unit unit;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str2 = (String) obj2;
                    Object obj3 = it[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.filesystem.FileSystemUploadOptions");
                    }
                    FileSystemUploadOptions fileSystemUploadOptions = (FileSystemUploadOptions) obj3;
                    Object obj4 = it[3];
                    if (obj4 != null) {
                        Promise promise = (Promise) obj4;
                        createUploadRequest = FileSystemModule.this.createUploadRequest(str, str2, fileSystemUploadOptions, FileSystemModule$definition$1$17$request$1.INSTANCE);
                        okHttpClient = FileSystemModule.this.getOkHttpClient();
                        if (okHttpClient != null) {
                            okHttpClient.newCall(createUploadRequest).enqueue(new FileSystemModule$definition$1$17$1$1(promise, FileSystemModule.this));
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            promise.reject(new FileSystemOkHttpNullException());
                        }
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("uploadTaskStartAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("uploadTaskStartAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$69
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$70
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$71
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemUploadOptions.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$72
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(FileSystemUploadOptions.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$73
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Request createUploadRequest;
                    OkHttpClient okHttpClient;
                    Map map;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = args[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str2 = (String) obj2;
                    Object obj3 = args[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str3 = (String) obj3;
                    Object obj4 = args[3];
                    if (obj4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.filesystem.FileSystemUploadOptions");
                    }
                    FileSystemModule$definition$1$18$progressListener$1 fileSystemModule$definition$1$18$progressListener$1 = new FileSystemModule$definition$1$18$progressListener$1(str3, FileSystemModule.this);
                    createUploadRequest = FileSystemModule.this.createUploadRequest(str, str2, (FileSystemUploadOptions) obj4, new FileSystemModule$definition$1$18$request$1(fileSystemModule$definition$1$18$progressListener$1));
                    okHttpClient = FileSystemModule.this.getOkHttpClient();
                    Intrinsics.checkNotNull(okHttpClient);
                    Call newCall = okHttpClient.newCall(createUploadRequest);
                    map = FileSystemModule.this.taskHandlers;
                    map.put(str3, new FileSystemModule.TaskHandler(newCall));
                    newCall.enqueue(new FileSystemModule$definition$1$18$1(promise, FileSystemModule.this));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("uploadTaskStartAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$74
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$75
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$76
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemUploadOptions.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$77
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(FileSystemUploadOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$78
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$79
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Request createUploadRequest;
                    OkHttpClient okHttpClient;
                    Map map;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str2 = (String) obj2;
                    Object obj3 = it[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str3 = (String) obj3;
                    Object obj4 = it[3];
                    if (obj4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.filesystem.FileSystemUploadOptions");
                    }
                    FileSystemUploadOptions fileSystemUploadOptions = (FileSystemUploadOptions) obj4;
                    Object obj5 = it[4];
                    if (obj5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    createUploadRequest = FileSystemModule.this.createUploadRequest(str, str2, fileSystemUploadOptions, new FileSystemModule$definition$1$18$request$1(new FileSystemModule$definition$1$18$progressListener$1(str3, FileSystemModule.this)));
                    okHttpClient = FileSystemModule.this.getOkHttpClient();
                    Intrinsics.checkNotNull(okHttpClient);
                    Call newCall = okHttpClient.newCall(createUploadRequest);
                    map = FileSystemModule.this.taskHandlers;
                    map.put(str3, new FileSystemModule.TaskHandler(newCall));
                    newCall.enqueue(new FileSystemModule$definition$1$18$1((Promise) obj5, FileSystemModule.this));
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("downloadAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("downloadAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$80
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$81
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DownloadOptions.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$82
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(DownloadOptions.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$83
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    String slashifyFilePath;
                    OkHttpClient okHttpClient;
                    Call newCall;
                    File file;
                    String md5;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    String str2 = (String) args[1];
                    Object obj2 = args[2];
                    if (obj2 != null) {
                        DownloadOptions downloadOptions = (DownloadOptions) obj2;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str2);
                        Uri uri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        fileSystemModule2.ensurePermission(uri, Permission.WRITE);
                        FileSystemModule.this.checkIfFileDirExists(uri);
                        Unit unit = null;
                        unit = null;
                        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                            Context context = FileSystemModule.this.getContext();
                            InputStream openRawResource = context.getResources().openRawResource(context.getResources().getIdentifier(str, "raw", context.getPackageName()));
                            Intrinsics.checkNotNullExpressionValue(openRawResource, "context.resources.openRawResource(resourceId)");
                            BufferedSource buffer = Okio.buffer(Okio.source(openRawResource));
                            file = FileSystemModule.this.toFile(uri);
                            file.delete();
                            BufferedSink buffer2 = Okio.buffer(Okio__JvmOkioKt.sink$default(file, false, 1, null));
                            buffer2.writeAll(buffer);
                            buffer2.close();
                            Bundle bundle = new Bundle();
                            bundle.putString("uri", Uri.fromFile(file).toString());
                            Boolean valueOf = Boolean.valueOf(downloadOptions.getMd5());
                            Boolean bool = valueOf.booleanValue() ? valueOf : null;
                            if (bool != null) {
                                bool.booleanValue();
                                md5 = FileSystemModule.this.md5(file);
                                bundle.putString("md5", md5);
                            }
                            promise.resolve(bundle);
                            return;
                        }
                        if (Intrinsics.areEqual("file", uri.getScheme())) {
                            Request.Builder url = new Request.Builder().url(str);
                            if (downloadOptions.getHeaders() != null) {
                                for (Map.Entry<String, String> entry : downloadOptions.getHeaders().entrySet()) {
                                    url.addHeader(entry.getKey(), entry.getValue());
                                }
                            }
                            okHttpClient = FileSystemModule.this.getOkHttpClient();
                            if (okHttpClient != null && (newCall = okHttpClient.newCall(url.build())) != null) {
                                newCall.enqueue(new FileSystemModule$definition$1$19$4(promise, FileSystemModule.this, uri, downloadOptions));
                                unit = Unit.INSTANCE;
                            }
                            if (unit == null) {
                                promise.reject(new FileSystemOkHttpNullException());
                                return;
                            }
                            return;
                        }
                        throw new IOException("Unsupported scheme for location '" + uri + "'.");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.filesystem.DownloadOptions");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("downloadAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$84
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$85
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DownloadOptions.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$86
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(DownloadOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$87
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$88
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String slashifyFilePath;
                    OkHttpClient okHttpClient;
                    Call newCall;
                    File file;
                    String md5;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    String str2 = (String) it[1];
                    Object obj2 = it[2];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.filesystem.DownloadOptions");
                    }
                    DownloadOptions downloadOptions = (DownloadOptions) obj2;
                    Object obj3 = it[3];
                    if (obj3 != null) {
                        Promise promise = (Promise) obj3;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str2);
                        Uri uri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        fileSystemModule2.ensurePermission(uri, Permission.WRITE);
                        FileSystemModule.this.checkIfFileDirExists(uri);
                        Unit unit = null;
                        unit = null;
                        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                            Context context = FileSystemModule.this.getContext();
                            InputStream openRawResource = context.getResources().openRawResource(context.getResources().getIdentifier(str, "raw", context.getPackageName()));
                            Intrinsics.checkNotNullExpressionValue(openRawResource, "context.resources.openRawResource(resourceId)");
                            BufferedSource buffer = Okio.buffer(Okio.source(openRawResource));
                            file = FileSystemModule.this.toFile(uri);
                            file.delete();
                            BufferedSink buffer2 = Okio.buffer(Okio__JvmOkioKt.sink$default(file, false, 1, null));
                            buffer2.writeAll(buffer);
                            buffer2.close();
                            Bundle bundle = new Bundle();
                            bundle.putString("uri", Uri.fromFile(file).toString());
                            Boolean valueOf = Boolean.valueOf(downloadOptions.getMd5());
                            Boolean bool = valueOf.booleanValue() ? valueOf : null;
                            if (bool != null) {
                                bool.booleanValue();
                                md5 = FileSystemModule.this.md5(file);
                                bundle.putString("md5", md5);
                            }
                            promise.resolve(bundle);
                        } else if (Intrinsics.areEqual("file", uri.getScheme())) {
                            Request.Builder url = new Request.Builder().url(str);
                            if (downloadOptions.getHeaders() != null) {
                                for (Map.Entry<String, String> entry : downloadOptions.getHeaders().entrySet()) {
                                    url.addHeader(entry.getKey(), entry.getValue());
                                }
                            }
                            okHttpClient = FileSystemModule.this.getOkHttpClient();
                            if (okHttpClient != null && (newCall = okHttpClient.newCall(url.build())) != null) {
                                newCall.enqueue(new FileSystemModule$definition$1$19$4(promise, FileSystemModule.this, uri, downloadOptions));
                                unit = Unit.INSTANCE;
                            }
                            if (unit == null) {
                                promise.reject(new FileSystemOkHttpNullException());
                            }
                        } else {
                            throw new IOException("Unsupported scheme for location '" + uri + "'.");
                        }
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("networkTaskCancelAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("networkTaskCancelAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$89
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Map map;
                    Call call;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    map = FileSystemModule.this.taskHandlers;
                    FileSystemModule.TaskHandler taskHandler = (FileSystemModule.TaskHandler) map.get((String) promise);
                    if (taskHandler == null || (call = taskHandler.getCall()) == null) {
                        return;
                    }
                    call.cancel();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("networkTaskCancelAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$90
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$91
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Map map;
                    Call call;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        map = FileSystemModule.this.taskHandlers;
                        FileSystemModule.TaskHandler taskHandler = (FileSystemModule.TaskHandler) map.get((String) obj);
                        if (taskHandler == null || (call = taskHandler.getCall()) == null) {
                            return null;
                        }
                        call.cancel();
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("downloadResumableStartAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("downloadResumableStartAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$92
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$93
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$94
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DownloadOptions.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$95
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(DownloadOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$96
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$97
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    String slashifyFilePath;
                    OkHttpClient okHttpClient;
                    Map map;
                    File file;
                    CoroutineScope coroutineScope;
                    OkHttpClient.Builder newBuilder;
                    OkHttpClient.Builder addInterceptor;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = args[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str2 = (String) obj2;
                    Object obj3 = args[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str3 = (String) obj3;
                    Object obj4 = args[3];
                    if (obj4 != null) {
                        DownloadOptions downloadOptions = (DownloadOptions) obj4;
                        String str4 = (String) args[4];
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str2);
                        Uri fileUri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(fileUri, "fileUri");
                        fileSystemModule2.checkIfFileDirExists(fileUri);
                        if (!Intrinsics.areEqual(fileUri.getScheme(), "file")) {
                            throw new IOException("Unsupported scheme for location '" + fileUri + "'.");
                        }
                        FileSystemModule$definition$1$21$progressListener$1 fileSystemModule$definition$1$21$progressListener$1 = new FileSystemModule$definition$1$21$progressListener$1(str4, str3, FileSystemModule.this);
                        okHttpClient = FileSystemModule.this.getOkHttpClient();
                        OkHttpClient build = (okHttpClient == null || (newBuilder = okHttpClient.newBuilder()) == null || (addInterceptor = newBuilder.addInterceptor(new FileSystemModule$definition$lambda$48$lambda$42$$inlined$addInterceptor$1(fileSystemModule$definition$1$21$progressListener$1))) == null) ? null : addInterceptor.build();
                        if (build == null) {
                            promise.reject(new FileSystemOkHttpNullException());
                            return;
                        }
                        Request.Builder builder = new Request.Builder();
                        if (str4 != null) {
                            builder.addHeader("Range", "bytes=" + str4 + "-");
                        }
                        if (downloadOptions.getHeaders() != null) {
                            for (Map.Entry<String, String> entry : downloadOptions.getHeaders().entrySet()) {
                                builder.addHeader(entry.getKey(), entry.getValue());
                            }
                        }
                        Call newCall = build.newCall(builder.url(str).build());
                        map = FileSystemModule.this.taskHandlers;
                        map.put(str3, new FileSystemModule.DownloadTaskHandler(fileUri, newCall));
                        file = FileSystemModule.this.toFile(fileUri);
                        FileSystemModule.DownloadResumableTaskParams downloadResumableTaskParams = new FileSystemModule.DownloadResumableTaskParams(downloadOptions, newCall, file, str4 != null, promise);
                        coroutineScope = FileSystemModule.this.moduleCoroutineScope;
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new FileSystemModule$definition$1$21$3(FileSystemModule.this, downloadResumableTaskParams, null), 3, null);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.filesystem.DownloadOptions");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("downloadResumableStartAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$98
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$99
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$100
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DownloadOptions.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$101
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(DownloadOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$102
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$103
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$104
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String slashifyFilePath;
                    OkHttpClient okHttpClient;
                    Map map;
                    File file;
                    CoroutineScope coroutineScope;
                    OkHttpClient.Builder newBuilder;
                    OkHttpClient.Builder addInterceptor;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str2 = (String) obj2;
                    Object obj3 = it[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str3 = (String) obj3;
                    Object obj4 = it[3];
                    if (obj4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.filesystem.DownloadOptions");
                    }
                    DownloadOptions downloadOptions = (DownloadOptions) obj4;
                    String str4 = (String) it[4];
                    Object obj5 = it[5];
                    if (obj5 != null) {
                        Promise promise = (Promise) obj5;
                        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(str2);
                        Uri fileUri = Uri.parse(slashifyFilePath);
                        FileSystemModule fileSystemModule2 = FileSystemModule.this;
                        Intrinsics.checkNotNullExpressionValue(fileUri, "fileUri");
                        fileSystemModule2.checkIfFileDirExists(fileUri);
                        if (!Intrinsics.areEqual(fileUri.getScheme(), "file")) {
                            throw new IOException("Unsupported scheme for location '" + fileUri + "'.");
                        }
                        FileSystemModule$definition$1$21$progressListener$1 fileSystemModule$definition$1$21$progressListener$1 = new FileSystemModule$definition$1$21$progressListener$1(str4, str3, FileSystemModule.this);
                        okHttpClient = FileSystemModule.this.getOkHttpClient();
                        OkHttpClient build = (okHttpClient == null || (newBuilder = okHttpClient.newBuilder()) == null || (addInterceptor = newBuilder.addInterceptor(new FileSystemModule$definition$lambda$48$lambda$42$$inlined$addInterceptor$1(fileSystemModule$definition$1$21$progressListener$1))) == null) ? null : addInterceptor.build();
                        if (build == null) {
                            promise.reject(new FileSystemOkHttpNullException());
                        } else {
                            Request.Builder builder = new Request.Builder();
                            if (str4 != null) {
                                builder.addHeader("Range", "bytes=" + str4 + "-");
                            }
                            if (downloadOptions.getHeaders() != null) {
                                for (Map.Entry<String, String> entry : downloadOptions.getHeaders().entrySet()) {
                                    builder.addHeader(entry.getKey(), entry.getValue());
                                }
                            }
                            Call newCall = build.newCall(builder.url(str).build());
                            map = FileSystemModule.this.taskHandlers;
                            map.put(str3, new FileSystemModule.DownloadTaskHandler(fileUri, newCall));
                            file = FileSystemModule.this.toFile(fileUri);
                            FileSystemModule.DownloadResumableTaskParams downloadResumableTaskParams = new FileSystemModule.DownloadResumableTaskParams(downloadOptions, newCall, file, str4 != null, promise);
                            coroutineScope = FileSystemModule.this.moduleCoroutineScope;
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new FileSystemModule$definition$1$21$3(FileSystemModule.this, downloadResumableTaskParams, null), 3, null);
                        }
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("downloadResumablePauseAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("downloadResumablePauseAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$105
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Map map;
                    Map map2;
                    File file;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) promise;
                    map = FileSystemModule.this.taskHandlers;
                    FileSystemModule.TaskHandler taskHandler = (FileSystemModule.TaskHandler) map.get(str);
                    if (taskHandler == null) {
                        throw new IOException("No download object available");
                    }
                    if (!(taskHandler instanceof FileSystemModule.DownloadTaskHandler)) {
                        throw new FileSystemCannotFindTaskException();
                    }
                    taskHandler.getCall().cancel();
                    map2 = FileSystemModule.this.taskHandlers;
                    map2.remove(str);
                    file = FileSystemModule.this.toFile(((FileSystemModule.DownloadTaskHandler) taskHandler).getFileUri());
                    new Bundle().putString("resumeData", String.valueOf(file.length()));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("downloadResumablePauseAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$106
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$107
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Map map;
                    Map map2;
                    File file;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        String str = (String) obj;
                        map = FileSystemModule.this.taskHandlers;
                        FileSystemModule.TaskHandler taskHandler = (FileSystemModule.TaskHandler) map.get(str);
                        if (taskHandler == null) {
                            throw new IOException("No download object available");
                        }
                        if (!(taskHandler instanceof FileSystemModule.DownloadTaskHandler)) {
                            throw new FileSystemCannotFindTaskException();
                        }
                        taskHandler.getCall().cancel();
                        map2 = FileSystemModule.this.taskHandlers;
                        map2.remove(str);
                        file = FileSystemModule.this.toFile(((FileSystemModule.DownloadTaskHandler) taskHandler).getFileUri());
                        Bundle bundle = new Bundle();
                        bundle.putString("resumeData", String.valueOf(file.length()));
                        return bundle;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new Function2<Activity, OnActivityResultPayload, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$OnActivityResult$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Activity activity, OnActivityResultPayload onActivityResultPayload) {
                    invoke2(activity, onActivityResultPayload);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Activity sender, OnActivityResultPayload payload) {
                    Promise promise;
                    Promise promise2;
                    Intrinsics.checkNotNullParameter(sender, "sender");
                    Intrinsics.checkNotNullParameter(payload, "payload");
                    int requestCode = payload.getRequestCode();
                    int resultCode = payload.getResultCode();
                    Intent data = payload.getData();
                    if (requestCode == 5394) {
                        promise = FileSystemModule.this.dirPermissionsRequest;
                        if (promise != null) {
                            Activity currentActivity = FileSystemModule.this.getAppContext().getCurrentActivity();
                            if (currentActivity == null) {
                                throw new Exceptions.MissingActivity();
                            }
                            Bundle bundle = new Bundle();
                            if (resultCode == -1 && data != null) {
                                Uri data2 = data.getData();
                                int flags = data.getFlags() & 3;
                                if (data2 != null) {
                                    currentActivity.getContentResolver().takePersistableUriPermission(data2, flags);
                                }
                                bundle.putBoolean(PermissionsResponse.GRANTED_KEY, true);
                                bundle.putString("directoryUri", String.valueOf(data2));
                            } else {
                                bundle.putBoolean(PermissionsResponse.GRANTED_KEY, false);
                            }
                            promise2 = FileSystemModule.this.dirPermissionsRequest;
                            if (promise2 != null) {
                                promise2.resolve(bundle);
                            }
                            FileSystemModule.this.dirPermissionsRequest = null;
                        }
                    }
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$OnDestroy$1
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
                    String str;
                    CoroutineScope coroutineScope;
                    try {
                        coroutineScope = FileSystemModule.this.moduleCoroutineScope;
                        CoroutineScopeKt.cancel(coroutineScope, new ModuleDestroyedException(null, 1, null));
                    } catch (IllegalStateException unused) {
                        str = FileSystemModuleKt.TAG;
                        Log.e(str, "The scope does not have a job in it");
                    }
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    private final void checkIfFileExists(Uri uri) throws IOException {
        File file = toFile(uri);
        if (file.exists()) {
            return;
        }
        throw new IOException("Directory for '" + file.getPath() + "' doesn't exist.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkIfFileDirExists(Uri uri) throws IOException {
        File file = toFile(uri);
        File parentFile = file.getParentFile();
        if (parentFile == null || !parentFile.exists()) {
            throw new IOException("Directory for '" + file.getPath() + "' doesn't exist. Please make sure directory '" + file.getParent() + "' exists before calling downloadAsync.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureDirExists(File dir) throws IOException {
        if (dir.isDirectory() || dir.mkdirs()) {
            return;
        }
        throw new IOException("Couldn't create directory '" + dir + "'");
    }

    private final EnumSet<Permission> permissionsForPath(String path) {
        FilePermissionModuleInterface filePermission = getAppContext().getFilePermission();
        if (filePermission != null) {
            return filePermission.getPathPermissions(getContext(), path);
        }
        return null;
    }

    private final EnumSet<Permission> permissionsForUri(Uri uri) {
        if (isSAFUri(uri)) {
            return permissionsForSAFUri(uri);
        }
        if (!Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_CONTENT_SCHEME) && !Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_ASSET_SCHEME)) {
            return Intrinsics.areEqual(uri.getScheme(), "file") ? permissionsForPath(uri.getPath()) : uri.getScheme() == null ? EnumSet.of(Permission.READ) : EnumSet.noneOf(Permission.class);
        }
        return EnumSet.of(Permission.READ);
    }

    private final EnumSet<Permission> permissionsForSAFUri(Uri uri) {
        DocumentFile nearestSAFFile = getNearestSAFFile(uri);
        EnumSet<Permission> noneOf = EnumSet.noneOf(Permission.class);
        if (nearestSAFFile != null) {
            if (nearestSAFFile.canRead()) {
                noneOf.add(Permission.READ);
            }
            if (nearestSAFFile.canWrite()) {
                noneOf.add(Permission.WRITE);
            }
        }
        Intrinsics.checkNotNullExpressionValue(noneOf, "noneOf(Permission::class…)\n        }\n      }\n    }");
        return noneOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensurePermission(Uri uri, Permission permission, String errorMsg) throws IOException {
        EnumSet<Permission> permissionsForUri = permissionsForUri(uri);
        boolean z = false;
        if (permissionsForUri != null && permissionsForUri.contains(permission)) {
            z = true;
        }
        if (!z) {
            throw new IOException(errorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensurePermission(Uri uri, Permission permission) throws IOException {
        if (permission == Permission.READ) {
            ensurePermission(uri, permission, "Location '" + uri + "' isn't readable.");
        }
        if (permission == Permission.WRITE) {
            ensurePermission(uri, permission, "Location '" + uri + "' isn't writable.");
        }
        ensurePermission(uri, permission, "Location '" + uri + "' doesn't have permission '" + permission.name() + "'.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InputStream openAssetInputStream(Uri uri) throws IOException {
        String path = uri.getPath();
        if (path == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        Intrinsics.checkNotNullExpressionValue(path, "requireNotNull(uri.path)");
        String substring = path.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        InputStream open = getContext().getAssets().open(substring);
        Intrinsics.checkNotNullExpressionValue(open, "context.assets.open(asset)");
        return open;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InputStream openResourceInputStream(String resourceName) throws IOException {
        int identifier = getContext().getResources().getIdentifier(resourceName, "raw", getContext().getPackageName());
        if (identifier == 0 && (identifier = getContext().getResources().getIdentifier(resourceName, "drawable", getContext().getPackageName())) == 0) {
            throw new FileNotFoundException("No resource found with the name '" + resourceName + "'");
        }
        InputStream openRawResource = getContext().getResources().openRawResource(identifier);
        Intrinsics.checkNotNullExpressionValue(openRawResource, "context.resources.openRawResource(resourceId)");
        return openRawResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void transformFilesFromSAF(DocumentFile documentFile, File outputDir, boolean copy) throws IOException {
        File file;
        if (!documentFile.exists()) {
            return;
        }
        if (!outputDir.isDirectory()) {
            File parentFile = outputDir.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("Couldn't create folder in output dir.");
            }
        } else if (!outputDir.exists() && !outputDir.mkdirs()) {
            throw new IOException("Couldn't create folder in output dir.");
        }
        if (documentFile.isDirectory()) {
            DocumentFile[] listFiles = documentFile.listFiles();
            Intrinsics.checkNotNullExpressionValue(listFiles, "documentFile.listFiles()");
            for (DocumentFile file2 : listFiles) {
                Intrinsics.checkNotNullExpressionValue(file2, "file");
                transformFilesFromSAF(file2, outputDir, copy);
            }
            if (copy) {
                return;
            }
            documentFile.delete();
            return;
        }
        String name = documentFile.getName();
        if (name == null) {
            return;
        }
        if (outputDir.isDirectory()) {
            file = new File(outputDir.getPath(), name);
        } else {
            file = new File(outputDir.getPath());
        }
        FileOutputStream openInputStream = getContext().getContentResolver().openInputStream(documentFile.getUri());
        try {
            InputStream inputStream = openInputStream;
            openInputStream = new FileOutputStream(file);
            try {
                IOUtils.copy(inputStream, openInputStream);
                CloseableKt.closeFinally(openInputStream, null);
                CloseableKt.closeFinally(openInputStream, null);
                if (copy) {
                    return;
                }
                documentFile.delete();
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Uri contentUriFromFile(File file) {
        Activity currentActivity = getAppContext().getCurrentActivity();
        if (currentActivity == null) {
            throw new Exceptions.MissingActivity();
        }
        Uri uriForFile = FileProvider.getUriForFile(currentActivity.getApplication(), currentActivity.getApplication().getPackageName() + ".FileSystemFileProvider", file);
        Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(\n      cur…ovider\",\n      file\n    )");
        return uriForFile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Request createUploadRequest(String url, String fileUriString, FileSystemUploadOptions options, RequestBodyDecorator decorator) throws IOException {
        String slashifyFilePath;
        slashifyFilePath = FileSystemModuleKt.slashifyFilePath(fileUriString);
        Uri fileUri = Uri.parse(slashifyFilePath);
        Intrinsics.checkNotNullExpressionValue(fileUri, "fileUri");
        ensurePermission(fileUri, Permission.READ);
        checkIfFileExists(fileUri);
        Request.Builder url2 = new Request.Builder().url(url);
        Map<String, String> headers = options.getHeaders();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                url2.addHeader(entry.getKey(), entry.getValue());
            }
        }
        return url2.method(options.getHttpMethod().getValue(), createRequestBody(options, decorator, toFile(fileUri))).build();
    }

    private final RequestBody createRequestBody(FileSystemUploadOptions options, RequestBodyDecorator decorator, File file) {
        int i = WhenMappings.$EnumSwitchMapping$0[options.getUploadType().ordinal()];
        if (i == 1) {
            return decorator.decorate(RequestBody.INSTANCE.create(file, (MediaType) null));
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        MultipartBody.Builder type = new MultipartBody.Builder(null, 1, null).setType(MultipartBody.FORM);
        Map<String, String> parameters = options.getParameters();
        if (parameters != null) {
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                type.addFormDataPart(entry.getKey(), entry.getValue().toString());
            }
        }
        String mimeType = options.getMimeType();
        if (mimeType == null) {
            mimeType = URLConnection.guessContentTypeFromName(file.getName());
            Intrinsics.checkNotNullExpressionValue(mimeType, "guessContentTypeFromName(file.name)");
        }
        String fieldName = options.getFieldName();
        if (fieldName == null) {
            fieldName = file.getName();
        }
        Intrinsics.checkNotNullExpressionValue(fieldName, "fieldName");
        type.addFormDataPart(fieldName, file.getName(), decorator.decorate(RequestBody.INSTANCE.create(file, MediaType.INSTANCE.parse(mimeType))));
        return type.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileSystemModule.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lexpo/modules/filesystem/FileSystemModule$DownloadResumableTaskParams;", "", "options", "Lexpo/modules/filesystem/DownloadOptions;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "file", "Ljava/io/File;", "isResume", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Lexpo/modules/filesystem/DownloadOptions;Lokhttp3/Call;Ljava/io/File;ZLexpo/modules/kotlin/Promise;)V", "getCall", "()Lokhttp3/Call;", "getFile", "()Ljava/io/File;", "()Z", "getOptions", "()Lexpo/modules/filesystem/DownloadOptions;", "getPromise", "()Lexpo/modules/kotlin/Promise;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "expo-file-system_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class DownloadResumableTaskParams {
        private final Call call;
        private final File file;
        private final boolean isResume;
        private final DownloadOptions options;
        private final Promise promise;

        public static /* synthetic */ DownloadResumableTaskParams copy$default(DownloadResumableTaskParams downloadResumableTaskParams, DownloadOptions downloadOptions, Call call, File file, boolean z, Promise promise, int i, Object obj) {
            if ((i & 1) != 0) {
                downloadOptions = downloadResumableTaskParams.options;
            }
            if ((i & 2) != 0) {
                call = downloadResumableTaskParams.call;
            }
            Call call2 = call;
            if ((i & 4) != 0) {
                file = downloadResumableTaskParams.file;
            }
            File file2 = file;
            if ((i & 8) != 0) {
                z = downloadResumableTaskParams.isResume;
            }
            boolean z2 = z;
            if ((i & 16) != 0) {
                promise = downloadResumableTaskParams.promise;
            }
            return downloadResumableTaskParams.copy(downloadOptions, call2, file2, z2, promise);
        }

        /* renamed from: component1, reason: from getter */
        public final DownloadOptions getOptions() {
            return this.options;
        }

        /* renamed from: component2, reason: from getter */
        public final Call getCall() {
            return this.call;
        }

        /* renamed from: component3, reason: from getter */
        public final File getFile() {
            return this.file;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsResume() {
            return this.isResume;
        }

        /* renamed from: component5, reason: from getter */
        public final Promise getPromise() {
            return this.promise;
        }

        public final DownloadResumableTaskParams copy(DownloadOptions options, Call call, File file, boolean isResume, Promise promise) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(promise, "promise");
            return new DownloadResumableTaskParams(options, call, file, isResume, promise);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DownloadResumableTaskParams)) {
                return false;
            }
            DownloadResumableTaskParams downloadResumableTaskParams = (DownloadResumableTaskParams) other;
            return Intrinsics.areEqual(this.options, downloadResumableTaskParams.options) && Intrinsics.areEqual(this.call, downloadResumableTaskParams.call) && Intrinsics.areEqual(this.file, downloadResumableTaskParams.file) && this.isResume == downloadResumableTaskParams.isResume && Intrinsics.areEqual(this.promise, downloadResumableTaskParams.promise);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.options.hashCode() * 31) + this.call.hashCode()) * 31) + this.file.hashCode()) * 31;
            boolean z = this.isResume;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((hashCode + i) * 31) + this.promise.hashCode();
        }

        public String toString() {
            return "DownloadResumableTaskParams(options=" + this.options + ", call=" + this.call + ", file=" + this.file + ", isResume=" + this.isResume + ", promise=" + this.promise + ")";
        }

        public DownloadResumableTaskParams(DownloadOptions options, Call call, File file, boolean z, Promise promise) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(promise, "promise");
            this.options = options;
            this.call = call;
            this.file = file;
            this.isResume = z;
            this.promise = promise;
        }

        public final DownloadOptions getOptions() {
            return this.options;
        }

        public final Call getCall() {
            return this.call;
        }

        public final File getFile() {
            return this.file;
        }

        public final boolean isResume() {
            return this.isResume;
        }

        public final Promise getPromise() {
            return this.promise;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadResumableTask(DownloadResumableTaskParams downloadResumableTaskParams, Continuation continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FileSystemModule$downloadResumableTask$2(downloadResumableTaskParams, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileSystemModule.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/filesystem/FileSystemModule$TaskHandler;", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "(Lokhttp3/Call;)V", "getCall", "()Lokhttp3/Call;", "expo-file-system_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static class TaskHandler {
        private final Call call;

        public TaskHandler(Call call) {
            Intrinsics.checkNotNullParameter(call, "call");
            this.call = call;
        }

        public final Call getCall() {
            return this.call;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileSystemModule.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lexpo/modules/filesystem/FileSystemModule$DownloadTaskHandler;", "Lexpo/modules/filesystem/FileSystemModule$TaskHandler;", "fileUri", "Landroid/net/Uri;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "(Landroid/net/Uri;Lokhttp3/Call;)V", "getFileUri", "()Landroid/net/Uri;", "expo-file-system_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DownloadTaskHandler extends TaskHandler {
        private final Uri fileUri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadTaskHandler(Uri fileUri, Call call) {
            super(call);
            Intrinsics.checkNotNullParameter(fileUri, "fileUri");
            Intrinsics.checkNotNullParameter(call, "call");
            this.fileUri = fileUri;
        }

        public final Uri getFileUri() {
            return this.fileUri;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileSystemModule.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/filesystem/FileSystemModule$ProgressResponseBody;", "Lokhttp3/ResponseBody;", "responseBody", "progressListener", "Lexpo/modules/filesystem/FileSystemModule$ProgressListener;", "(Lokhttp3/ResponseBody;Lexpo/modules/filesystem/FileSystemModule$ProgressListener;)V", "bufferedSource", "Lokio/BufferedSource;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "source", "Lokio/Source;", "expo-file-system_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ProgressResponseBody extends ResponseBody {
        private BufferedSource bufferedSource;
        private final ProgressListener progressListener;
        private final ResponseBody responseBody;

        public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
            Intrinsics.checkNotNullParameter(progressListener, "progressListener");
            this.responseBody = responseBody;
            this.progressListener = progressListener;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentType */
        public MediaType get$contentType() {
            ResponseBody responseBody = this.responseBody;
            if (responseBody != null) {
                return responseBody.get$contentType();
            }
            return null;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentLength */
        public long getContentLength() {
            ResponseBody responseBody = this.responseBody;
            if (responseBody != null) {
                return responseBody.getContentLength();
            }
            return -1L;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: source */
        public BufferedSource getSource() {
            BufferedSource bufferedSource = this.bufferedSource;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            ResponseBody responseBody = this.responseBody;
            Intrinsics.checkNotNull(responseBody);
            return Okio.buffer(source(responseBody.getSource()));
        }

        private final Source source(final Source source) {
            return new ForwardingSource(source) { // from class: expo.modules.filesystem.FileSystemModule$ProgressResponseBody$source$1
                private long totalBytesRead;

                public final long getTotalBytesRead() {
                    return this.totalBytesRead;
                }

                public final void setTotalBytesRead(long j) {
                    this.totalBytesRead = j;
                }

                @Override // okio.ForwardingSource, okio.Source
                public long read(Buffer sink, long byteCount) throws IOException {
                    FileSystemModule.ProgressListener progressListener;
                    ResponseBody responseBody;
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    long read = super.read(sink, byteCount);
                    this.totalBytesRead += read != -1 ? read : 0L;
                    progressListener = this.progressListener;
                    long j = this.totalBytesRead;
                    responseBody = this.responseBody;
                    progressListener.update(j, responseBody != null ? responseBody.getContentLength() : -1L, read == -1);
                    return read;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized OkHttpClient getOkHttpClient() {
        Object obj;
        if (this.client == null) {
            OkHttpClient.Builder writeTimeout = new OkHttpClient.Builder().connectTimeout(60L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).writeTimeout(60L, TimeUnit.SECONDS);
            try {
                obj = getAppContext().getLegacyModuleRegistry().getModule(CookieHandler.class);
            } catch (Exception unused) {
                obj = null;
            }
            CookieHandler cookieHandler = (CookieHandler) obj;
            if (cookieHandler == null) {
                throw new CookieHandlerNotFoundException();
            }
            writeTimeout.cookieJar(new JavaNetCookieJar(cookieHandler));
            this.client = writeTimeout.build();
        }
        return this.client;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String md5(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            char[] encodeHex = Hex.encodeHex(DigestUtils.md5(fileInputStream));
            Intrinsics.checkNotNullExpressionValue(encodeHex, "encodeHex(md5bytes)");
            String str = new String(encodeHex);
            CloseableKt.closeFinally(fileInputStream, null);
            return str;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("Failed to list contents of " + file);
            }
            IOException e = null;
            for (File f : listFiles) {
                try {
                    Intrinsics.checkNotNullExpressionValue(f, "f");
                    forceDelete(f);
                } catch (IOException e2) {
                    e = e2;
                }
            }
            if (e != null) {
                throw e;
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
        if (file.delete()) {
            return;
        }
        throw new IOException("Unable to delete file: " + file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getFileSize(File file) {
        Object obj;
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0L;
        }
        ArrayList arrayList = new ArrayList(listFiles.length);
        for (File it : listFiles) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(Long.valueOf(getFileSize(it)));
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            Object next = it2.next();
            while (it2.hasNext()) {
                next = Long.valueOf(((Number) next).longValue() + ((Number) it2.next()).longValue());
            }
            obj = next;
        } else {
            obj = null;
        }
        Long l = (Long) obj;
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InputStream getInputStream(Uri uri) throws IOException {
        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
            return new FileInputStream(toFile(uri));
        }
        if (Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_ASSET_SCHEME)) {
            return openAssetInputStream(uri);
        }
        if (isSAFUri(uri)) {
            InputStream openInputStream = getContext().getContentResolver().openInputStream(uri);
            Intrinsics.checkNotNull(openInputStream);
            return openInputStream;
        }
        throw new IOException("Unsupported scheme for location '" + uri + "'.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OutputStream getOutputStream(Uri uri) throws IOException {
        FileOutputStream openOutputStream;
        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
            openOutputStream = new FileOutputStream(toFile(uri));
        } else {
            if (!isSAFUri(uri)) {
                throw new IOException("Unsupported scheme for location '" + uri + "'.");
            }
            openOutputStream = getContext().getContentResolver().openOutputStream(uri);
            Intrinsics.checkNotNull(openOutputStream);
        }
        Intrinsics.checkNotNullExpressionValue(openOutputStream, "when {\n    uri.scheme ==…or location '$uri'.\")\n  }");
        return openOutputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DocumentFile getNearestSAFFile(Uri uri) {
        DocumentFile fromSingleUri = DocumentFile.fromSingleUri(getContext(), uri);
        return (fromSingleUri == null || !fromSingleUri.isFile()) ? DocumentFile.fromTreeUri(getContext(), uri) : fromSingleUri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File toFile(Uri uri) {
        if (uri.getPath() != null) {
            String path = uri.getPath();
            Intrinsics.checkNotNull(path);
            return new File(path);
        }
        throw new IOException("Invalid Uri: " + uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSAFUri(Uri uri) {
        if (!Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_CONTENT_SCHEME)) {
            return false;
        }
        String host = uri.getHost();
        return host != null ? StringsKt.startsWith$default(host, "com.android.externalstorage", false, 2, (Object) null) : false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String parseFileUri(String uriStr) {
        String substring = uriStr.substring(StringsKt.indexOf$default((CharSequence) uriStr, AbstractJsonLexerKt.COLON, 0, false, 6, (Object) null) + 3);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] getInputStreamBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "byteBuffer.toByteArray()");
        return byteArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle translateHeaders(Headers headers) {
        Bundle bundle = new Bundle();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            if (bundle.containsKey(name)) {
                bundle.putString(name, bundle.getString(name) + ", " + headers.value(i));
            } else {
                bundle.putString(name, headers.value(i));
            }
        }
        return bundle;
    }
}
