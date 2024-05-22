package com.onesignal.inAppMessages.internal.common;

import com.amplitude.api.DeviceInfo;
import com.facebook.hermes.intl.Constants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.inAppMessages.BuildConfig;
import com.onesignal.inAppMessages.internal.InAppMessage;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InAppHelper.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/onesignal/inAppMessages/internal/common/InAppHelper;", "", "()V", "PREFERRED_VARIANT_ORDER", "", "", "variantIdForMessage", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppHelper {
    public static final InAppHelper INSTANCE = new InAppHelper();
    private static final List<String> PREFERRED_VARIANT_ORDER = CollectionsKt.listOf((Object[]) new String[]{DeviceInfo.OS_NAME, "app", TtmlNode.COMBINE_ALL});

    private InAppHelper() {
    }

    public final String variantIdForMessage(InAppMessage message, ILanguageContext languageContext) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(languageContext, "languageContext");
        String language = languageContext.getLanguage();
        for (String str : PREFERRED_VARIANT_ORDER) {
            if (message.getVariants().containsKey(str)) {
                Map<String, String> map = message.getVariants().get(str);
                Intrinsics.checkNotNull(map);
                Map<String, String> map2 = map;
                if (!map2.containsKey(language)) {
                    language = Constants.COLLATION_DEFAULT;
                }
                return map2.get(language);
            }
        }
        return null;
    }
}
