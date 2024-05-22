package cl.json.social;

import android.content.ActivityNotFoundException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes.dex */
public class FacebookPagesManagerShare extends SingleShareIntent {
    private static final String DEFAULT_WEB_LINK = "https://www.facebook.com/sharer/sharer.php?u={url}";
    private static final String PACKAGE = "com.facebook.pages.app";

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
        return null;
    }

    public FacebookPagesManagerShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        openIntentChooser();
    }
}
