package com.facebook.react.viewmanagers;

import android.view.View;

/* loaded from: classes3.dex */
public interface ActivityIndicatorViewManagerInterface<T extends View> {
    void setAnimating(T t, boolean z);

    void setColor(T t, Integer num);

    void setHidesWhenStopped(T t, boolean z);

    void setSize(T t, String str);
}
