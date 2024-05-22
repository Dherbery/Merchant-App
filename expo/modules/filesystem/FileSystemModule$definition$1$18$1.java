package expo.modules.filesystem;

import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import expo.modules.kotlin.Promise;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: FileSystemModule.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"expo/modules/filesystem/FileSystemModule$definition$1$18$1", "Lokhttp3/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "expo-file-system_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FileSystemModule$definition$1$18$1 implements Callback {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ FileSystemModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileSystemModule$definition$1$18$1(Promise promise, FileSystemModule fileSystemModule) {
        this.$promise = promise;
        this.this$0 = fileSystemModule;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e) {
        String str;
        String TAG;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        if (!call.getCanceled()) {
            str = FileSystemModuleKt.TAG;
            Log.e(str, String.valueOf(e.getMessage()));
            Promise promise = this.$promise;
            TAG = FileSystemModuleKt.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            promise.reject(TAG, e.getMessage(), e);
            return;
        }
        this.$promise.resolve(null);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        Bundle translateHeaders;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        Bundle bundle = new Bundle();
        ResponseBody body = response.body();
        FileSystemModule fileSystemModule = this.this$0;
        bundle.putString(TtmlNode.TAG_BODY, body != null ? body.string() : null);
        bundle.putInt("status", response.code());
        translateHeaders = fileSystemModule.translateHeaders(response.headers());
        bundle.putBundle("headers", translateHeaders);
        response.close();
        this.$promise.resolve(bundle);
    }
}
