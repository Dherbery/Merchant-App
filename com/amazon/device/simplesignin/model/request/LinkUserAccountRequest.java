package com.amazon.device.simplesignin.model.request;

import com.amazon.device.simplesignin.model.AccountLinkType;
import com.amazon.device.simplesignin.model.Token;

/* loaded from: classes.dex */
public class LinkUserAccountRequest {
    private AccountLinkType accountLinkType;
    private String identityProviderName;
    private String linkSigningKey;
    private Token linkToken;
    private String partnerUserId;
    private String userLoginName;

    public void setAccountLinkType(AccountLinkType accountLinkType) {
        this.accountLinkType = accountLinkType;
    }

    public void setIdentityProviderName(String str) {
        this.identityProviderName = str;
    }

    public void setLinkSigningKey(String str) {
        this.linkSigningKey = str;
    }

    public void setLinkToken(Token token) {
        this.linkToken = token;
    }

    public void setPartnerUserId(String str) {
        this.partnerUserId = str;
    }

    public void setUserLoginName(String str) {
        this.userLoginName = str;
    }

    public String getPartnerUserId() {
        return this.partnerUserId;
    }

    public String getIdentityProviderName() {
        return this.identityProviderName;
    }

    public String getUserLoginName() {
        return this.userLoginName;
    }

    public Token getLinkToken() {
        return this.linkToken;
    }

    public String getLinkSigningKey() {
        return this.linkSigningKey;
    }

    public AccountLinkType getAccountLinkType() {
        return this.accountLinkType;
    }
}
