package com.reactnativelauncharguments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class LaunchArgumentsModule extends ReactContextBaseJavaModule {
    private static final long ACTIVITY_WAIT_INTERVAL = 100;
    private static final int ACTIVITY_WAIT_TRIES = 200;
    private static final String DETOX_LAUNCH_ARGS_KEY = "launchArgs";

    @ReactMethod
    public void foo() {
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "LaunchArguments";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaunchArgumentsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        waitForActivity();
        return new HashMap<String, Object>() { // from class: com.reactnativelauncharguments.LaunchArgumentsModule.1
            {
                put("value", LaunchArgumentsModule.this.parseIntentExtras());
            }
        };
    }

    private void waitForActivity() {
        for (int i = 0; i < 200 && !isActivityReady(); i++) {
            sleep(ACTIVITY_WAIT_INTERVAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> parseIntentExtras() {
        Intent intent;
        HashMap hashMap = new HashMap();
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || (intent = currentActivity.getIntent()) == null) {
            return hashMap;
        }
        parseDetoxExtras(hashMap, intent);
        parseADBArgsExtras(hashMap, intent);
        return hashMap;
    }

    private void parseDetoxExtras(Map<String, Object> map, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra(DETOX_LAUNCH_ARGS_KEY);
        if (bundleExtra != null) {
            for (String str : bundleExtra.keySet()) {
                map.put(str, bundleExtra.getString(str));
            }
        }
    }

    private void parseADBArgsExtras(Map<String, Object> map, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String str : extras.keySet()) {
                if (!DETOX_LAUNCH_ARGS_KEY.equals(str) && !"android.nfc.extra.NDEF_MESSAGES".equals(str)) {
                    if ((extras.get(str) instanceof Integer) || (extras.get(str) instanceof Double) || (extras.get(str) instanceof Boolean) || (extras.get(str) instanceof String)) {
                        map.put(str, extras.get(str));
                    } else {
                        map.put(str, extras.getString(str));
                    }
                }
            }
        }
    }

    private boolean isActivityReady() {
        return getReactApplicationContext().hasCurrentActivity();
    }

    private static void sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
