package com.facebook.react.views.scroll;

import android.content.Context;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.views.view.ReactViewGroup;

/* loaded from: classes3.dex */
public class ReactHorizontalScrollContainerView extends ReactViewGroup {
    private int mLayoutDirection;

    public ReactHorizontalScrollContainerView(Context context) {
        super(context);
        this.mLayoutDirection = I18nUtil.getInstance().isRTL(context) ? 1 : 0;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, com.facebook.react.uimanager.ReactClippingViewGroup
    public void setRemoveClippedSubviews(boolean z) {
        if (this.mLayoutDirection == 1) {
            super.setRemoveClippedSubviews(false);
        } else {
            super.setRemoveClippedSubviews(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mLayoutDirection == 1) {
            setLeftTopRightBottom(0, i2, (i3 - i) + 0, i4);
        }
    }
}
