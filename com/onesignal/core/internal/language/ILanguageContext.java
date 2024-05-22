package com.onesignal.core.internal.language;

import com.amplitude.api.Constants;
import com.onesignal.core.BuildConfig;
import kotlin.Metadata;

/* compiled from: ILanguageContext.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/onesignal/core/internal/language/ILanguageContext;", "", Constants.AMP_TRACKING_OPTION_LANGUAGE, "", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface ILanguageContext {
    String getLanguage();

    void setLanguage(String str);
}
