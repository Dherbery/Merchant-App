package com.amazon.device.simplesignin;

import com.amazon.device.simplesignin.model.response.GetUserAndLinksResponse;
import com.amazon.device.simplesignin.model.response.LinkUserAccountResponse;
import com.amazon.device.simplesignin.model.response.ShowLoginSelectionResponse;
import com.amazon.device.simplesignin.model.response.UnlinkUserAccountResponse;

/* loaded from: classes.dex */
public interface ISimpleSignInResponseHandler {
    void onGetUserAndLinksResponse(GetUserAndLinksResponse getUserAndLinksResponse);

    void onLinkUserAccountResponse(LinkUserAccountResponse linkUserAccountResponse);

    void onShowLoginSelectionResponse(ShowLoginSelectionResponse showLoginSelectionResponse);

    void onUnlinkUserAccountResponse(UnlinkUserAccountResponse unlinkUserAccountResponse);
}
