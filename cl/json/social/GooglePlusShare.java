package cl.json.social;

import android.content.ActivityNotFoundException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes.dex */
public class GooglePlusShare extends SingleShareIntent {
    private static final String DEFAULT_WEB_LINK = "https://plus.google.com/share?url={url}";
    private static final String PACKAGE = "com.google.android.apps.plus";
    private static final String PLAY_STORE_LINK = "market://details?id=com.google.android.apps.plus";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cl.json.social.ShareIntent
    public String getDefaultWebLink() {
        return DEFAULT_WEB_LINK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cl.json.social.ShareIntent
    public String getPackage() {
        return PACKAGE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cl.json.social.ShareIntent
    public String getPlayStoreLink() {
        return PLAY_STORE_LINK;
    }

    public GooglePlusShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        openIntentChooser();
    }
}
