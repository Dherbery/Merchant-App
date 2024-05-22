package com.facebook.react.runtime;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
class BridgelessReactStateTracker {
    private static final String TAG = "BridgelessReact";
    private final boolean mShouldTrackStates;
    private final List<String> mStates = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: Access modifiers changed from: package-private */
    public BridgelessReactStateTracker(boolean z) {
        this.mShouldTrackStates = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enterState(String str) {
        FLog.w(TAG, str);
        if (this.mShouldTrackStates) {
            this.mStates.add(str);
        }
    }
}
