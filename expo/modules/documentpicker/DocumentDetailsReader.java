package expo.modules.documentpicker;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DocumentDetailsReader.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lexpo/modules/documentpicker/DocumentDetailsReader;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "read", "Lexpo/modules/documentpicker/DocumentDetails;", "uri", "Landroid/net/Uri;", "expo-document-picker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DocumentDetailsReader {
    private final Context context;

    public DocumentDetailsReader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final DocumentDetails read(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Cursor query = this.context.getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            return null;
        }
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            cursor2.moveToFirst();
            String name = cursor2.getString(cursor2.getColumnIndex("_display_name"));
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            int columnIndex = cursor2.getColumnIndex("_size");
            Integer valueOf = !cursor2.isNull(columnIndex) ? Integer.valueOf(cursor2.getInt(columnIndex)) : null;
            String type = this.context.getContentResolver().getType(uri);
            Intrinsics.checkNotNullExpressionValue(name, "name");
            DocumentDetails documentDetails = new DocumentDetails(name, uri2, valueOf, type);
            CloseableKt.closeFinally(cursor, null);
            return documentDetails;
        } finally {
        }
    }
}
