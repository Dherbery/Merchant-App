package expo.modules.filesystem;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import expo.modules.kotlin.Promise;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Okio__JvmOkioKt;

/* compiled from: FileSystemModule.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"expo/modules/filesystem/FileSystemModule$definition$1$19$4", "Lokhttp3/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "expo-file-system_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FileSystemModule$definition$1$19$4 implements Callback {
    final /* synthetic */ DownloadOptions $options;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ Uri $uri;
    final /* synthetic */ FileSystemModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileSystemModule$definition$1$19$4(Promise promise, FileSystemModule fileSystemModule, Uri uri, DownloadOptions downloadOptions) {
        this.$promise = promise;
        this.this$0 = fileSystemModule;
        this.$uri = uri;
        this.$options = downloadOptions;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e) {
        String str;
        String TAG;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        str = FileSystemModuleKt.TAG;
        Log.e(str, String.valueOf(e.getMessage()));
        Promise promise = this.$promise;
        TAG = FileSystemModuleKt.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        promise.reject(TAG, e.getMessage(), e);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) throws IOException {
        File file;
        Bundle translateHeaders;
        String md5;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        FileSystemModule fileSystemModule = this.this$0;
        Uri uri = this.$uri;
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        file = fileSystemModule.toFile(uri);
        file.delete();
        BufferedSink buffer = Okio.buffer(Okio__JvmOkioKt.sink$default(file, false, 1, null));
        ResponseBody body = response.body();
        Intrinsics.checkNotNull(body);
        buffer.writeAll(body.getSource());
        buffer.close();
        Bundle bundle = new Bundle();
        FileSystemModule fileSystemModule2 = this.this$0;
        DownloadOptions downloadOptions = this.$options;
        bundle.putString("uri", Uri.fromFile(file).toString());
        bundle.putInt("status", response.code());
        translateHeaders = fileSystemModule2.translateHeaders(response.headers());
        bundle.putBundle("headers", translateHeaders);
        if (downloadOptions.getMd5()) {
            md5 = fileSystemModule2.md5(file);
            bundle.putString("md5", md5);
        }
        response.close();
        this.$promise.resolve(bundle);
    }
}
