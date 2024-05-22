package expo.modules.documentpicker;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.tracing.Trace;
import expo.modules.core.utilities.FileUtilities;
import expo.modules.imagepicker.MediaTypes;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

/* compiled from: DocumentPickerModule.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lexpo/modules/documentpicker/DocumentPickerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "copyToCacheDirectory", "", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "pendingPromise", "Lexpo/modules/kotlin/Promise;", "copyDocumentToCacheDirectory", "", "documentUri", "Landroid/net/Uri;", "name", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "handleMultipleSelection", "", "intent", "Landroid/content/Intent;", "handleSingleSelection", "readDocumentDetails", "Lexpo/modules/documentpicker/DocumentInfo;", "uri", "expo-document-picker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DocumentPickerModule extends Module {
    private boolean copyToCacheDirectory = true;
    private Promise pendingPromise;

    private final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getCurrentActivity() {
        Activity currentActivity = getAppContext().getCurrentActivity();
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new Exceptions.MissingActivity();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        DocumentPickerModule documentPickerModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (documentPickerModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(documentPickerModule);
            moduleDefinitionBuilder.Name("ExpoDocumentPicker");
            moduleDefinitionBuilder.getAsyncFunctions().put("getDocumentAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getDocumentAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DocumentPickerOptions.class), false, new Function0<KType>() { // from class: expo.modules.documentpicker.DocumentPickerModule$definition$lambda$3$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(DocumentPickerOptions.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.documentpicker.DocumentPickerModule$definition$lambda$3$$inlined$AsyncFunction$2
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Promise promise2;
                    String str;
                    Activity currentActivity;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        DocumentPickerOptions documentPickerOptions = (DocumentPickerOptions) obj;
                        promise2 = DocumentPickerModule.this.pendingPromise;
                        if (promise2 == null) {
                            DocumentPickerModule.this.pendingPromise = promise;
                            DocumentPickerModule.this.copyToCacheDirectory = documentPickerOptions.getCopyToCacheDirectory();
                            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                            intent.addCategory("android.intent.category.OPENABLE");
                            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", documentPickerOptions.getMultiple());
                            if (documentPickerOptions.getType().size() > 1) {
                                intent.putExtra("android.intent.extra.MIME_TYPES", (String[]) documentPickerOptions.getType().toArray(new String[0]));
                                str = MediaTypes.AllMimeType;
                            } else {
                                str = documentPickerOptions.getType().get(0);
                            }
                            intent.setType(str);
                            currentActivity = DocumentPickerModule.this.getCurrentActivity();
                            currentActivity.startActivityForResult(intent, 4137);
                            return;
                        }
                        throw new PickingInProgressException();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.documentpicker.DocumentPickerOptions");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getDocumentAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DocumentPickerOptions.class), false, new Function0<KType>() { // from class: expo.modules.documentpicker.DocumentPickerModule$definition$lambda$3$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(DocumentPickerOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.documentpicker.DocumentPickerModule$definition$lambda$3$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.documentpicker.DocumentPickerModule$definition$lambda$3$$inlined$AsyncFunction$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Promise promise;
                    String str;
                    Activity currentActivity;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.documentpicker.DocumentPickerOptions");
                    }
                    DocumentPickerOptions documentPickerOptions = (DocumentPickerOptions) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        Promise promise2 = (Promise) obj2;
                        promise = DocumentPickerModule.this.pendingPromise;
                        if (promise == null) {
                            DocumentPickerModule.this.pendingPromise = promise2;
                            DocumentPickerModule.this.copyToCacheDirectory = documentPickerOptions.getCopyToCacheDirectory();
                            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                            intent.addCategory("android.intent.category.OPENABLE");
                            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", documentPickerOptions.getMultiple());
                            if (documentPickerOptions.getType().size() > 1) {
                                intent.putExtra("android.intent.extra.MIME_TYPES", (String[]) documentPickerOptions.getType().toArray(new String[0]));
                                str = MediaTypes.AllMimeType;
                            } else {
                                str = documentPickerOptions.getType().get(0);
                            }
                            intent.setType(str);
                            currentActivity = DocumentPickerModule.this.getCurrentActivity();
                            currentActivity.startActivityForResult(intent, 4137);
                            return Unit.INSTANCE;
                        }
                        throw new PickingInProgressException();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new Function2<Activity, OnActivityResultPayload, Unit>() { // from class: expo.modules.documentpicker.DocumentPickerModule$definition$lambda$3$$inlined$OnActivityResult$1
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
                    ClipData clipData;
                    Intrinsics.checkNotNullParameter(sender, "sender");
                    Intrinsics.checkNotNullParameter(payload, "payload");
                    int requestCode = payload.getRequestCode();
                    int resultCode = payload.getResultCode();
                    Intent data = payload.getData();
                    if (requestCode == 4137) {
                        promise = DocumentPickerModule.this.pendingPromise;
                        if (promise == null) {
                            return;
                        }
                        promise2 = DocumentPickerModule.this.pendingPromise;
                        Intrinsics.checkNotNull(promise2);
                        if (resultCode == -1) {
                            if (data != null) {
                                try {
                                    clipData = data.getClipData();
                                } catch (CodedException e) {
                                    promise2.resolve(e);
                                }
                            } else {
                                clipData = null;
                            }
                            if (clipData != null) {
                                DocumentPickerModule.this.handleMultipleSelection(data);
                            } else {
                                DocumentPickerModule.this.handleSingleSelection(data);
                            }
                        } else {
                            promise2.resolve(new DocumentPickerResult(true, null, 2, null));
                        }
                        DocumentPickerModule.this.pendingPromise = null;
                    }
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    private final String copyDocumentToCacheDirectory(Uri documentUri, String name) {
        File file = new File(FileUtilities.generateOutputPath(getContext().getCacheDir(), "DocumentPicker", FilenameUtils.getExtension(name)));
        try {
            FileOutputStream openInputStream = getContext().getContentResolver().openInputStream(documentUri);
            try {
                InputStream inputStream = openInputStream;
                openInputStream = new FileOutputStream(file);
                try {
                    IOUtils.copy(inputStream, openInputStream);
                    CloseableKt.closeFinally(openInputStream, null);
                    CloseableKt.closeFinally(openInputStream, null);
                    return Uri.fromFile(file).toString();
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSingleSelection(Intent intent) {
        Uri data;
        Unit unit = null;
        if (intent != null && (data = intent.getData()) != null) {
            DocumentPickerResult documentPickerResult = new DocumentPickerResult(false, CollectionsKt.listOf(readDocumentDetails(data)), 1, null);
            Promise promise = this.pendingPromise;
            if (promise != null) {
                promise.resolve(documentPickerResult);
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            throw new FailedToReadDocumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMultipleSelection(Intent intent) {
        ClipData clipData;
        ClipData.Item itemAt;
        ClipData clipData2;
        int itemCount = (intent == null || (clipData2 = intent.getClipData()) == null) ? 0 : clipData2.getItemCount();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            Uri uri = null;
            if (i >= itemCount) {
                Promise promise = this.pendingPromise;
                if (promise != null) {
                    promise.resolve(new DocumentPickerResult(false, arrayList, 1, null));
                    return;
                }
                return;
            }
            if (intent != null && (clipData = intent.getClipData()) != null && (itemAt = clipData.getItemAt(i)) != null) {
                uri = itemAt.getUri();
            }
            if (uri == null) {
                throw new FailedToReadDocumentException();
            }
            arrayList.add(readDocumentDetails(uri));
            i++;
        }
    }

    private final DocumentInfo readDocumentDetails(Uri uri) {
        String copyDocumentToCacheDirectory;
        DocumentDetails read = new DocumentDetailsReader(getContext()).read(uri);
        if (this.copyToCacheDirectory && read != null && ((copyDocumentToCacheDirectory = copyDocumentToCacheDirectory(uri, read.getName())) == null || (read = DocumentDetails.copy$default(read, null, copyDocumentToCacheDirectory, null, null, 13, null)) == null)) {
            throw new FailedToCopyToCacheException();
        }
        if (read != null) {
            return new DocumentInfo(read.getUri(), read.getName(), read.getMimeType(), read.getSize());
        }
        throw new FailedToReadDocumentException();
    }
}
