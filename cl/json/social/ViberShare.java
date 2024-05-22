package cl.json.social;

import android.content.ActivityNotFoundException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes.dex */
public class ViberShare extends SingleShareIntent {
    private static final String PACKAGE = "com.viber.voip";
    private static final String PLAY_STORE_LINK = "market://details?id=com.viber.voip";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cl.json.social.ShareIntent
    public String getDefaultWebLink() {
        return null;
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

    public ViberShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        openIntentChooser();
    }
}
