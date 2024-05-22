package com.onesignal.inAppMessages.internal;

import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.inAppMessages.BuildConfig;
import com.onesignal.inAppMessages.internal.display.impl.WebViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: InAppMessageContent.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\b\u0010\u0018\u0000 )2\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u001a\u0010&\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001c¨\u0006*"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "contentHtml", "", "getContentHtml", "()Ljava/lang/String;", "setContentHtml", "(Ljava/lang/String;)V", "displayDuration", "", "getDisplayDuration", "()Ljava/lang/Double;", "setDisplayDuration", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", WebViewManager.IAM_DISPLAY_LOCATION_KEY, "Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "getDisplayLocation", "()Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "setDisplayLocation", "(Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;)V", "isFullBleed", "", "()Z", "setFullBleed", "(Z)V", "pageHeight", "", "getPageHeight", "()I", "setPageHeight", "(I)V", "useHeightMargin", "getUseHeightMargin", "setUseHeightMargin", "useWidthMargin", "getUseWidthMargin", "setUseWidthMargin", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public class InAppMessageContent {
    public static final String DISPLAY_DURATION = "display_duration";
    public static final String HTML = "html";
    public static final String REMOVE_HEIGHT_MARGIN = "remove_height_margin";
    public static final String REMOVE_WIDTH_MARGIN = "remove_width_margin";
    public static final String STYLES = "styles";
    private String contentHtml;
    private Double displayDuration;
    private WebViewManager.Position displayLocation;
    private boolean isFullBleed;
    private int pageHeight;
    private boolean useHeightMargin;
    private boolean useWidthMargin;

    public InAppMessageContent(JSONObject jsonObject) {
        Boolean safeBool;
        Boolean safeBool2;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        this.useHeightMargin = true;
        this.useWidthMargin = true;
        this.contentHtml = JSONObjectExtensionsKt.safeString(jsonObject, HTML);
        this.displayDuration = JSONObjectExtensionsKt.safeDouble(jsonObject, DISPLAY_DURATION);
        JSONObject safeJSONObject = JSONObjectExtensionsKt.safeJSONObject(jsonObject, STYLES);
        boolean z = false;
        this.useHeightMargin = !((safeJSONObject == null || (safeBool2 = JSONObjectExtensionsKt.safeBool(safeJSONObject, REMOVE_HEIGHT_MARGIN)) == null) ? false : safeBool2.booleanValue());
        if (safeJSONObject != null && (safeBool = JSONObjectExtensionsKt.safeBool(safeJSONObject, REMOVE_WIDTH_MARGIN)) != null) {
            z = safeBool.booleanValue();
        }
        this.useWidthMargin = !z;
        this.isFullBleed = !this.useHeightMargin;
    }

    public final String getContentHtml() {
        return this.contentHtml;
    }

    public final void setContentHtml(String str) {
        this.contentHtml = str;
    }

    public final boolean getUseHeightMargin() {
        return this.useHeightMargin;
    }

    public final void setUseHeightMargin(boolean z) {
        this.useHeightMargin = z;
    }

    public final boolean getUseWidthMargin() {
        return this.useWidthMargin;
    }

    public final void setUseWidthMargin(boolean z) {
        this.useWidthMargin = z;
    }

    /* renamed from: isFullBleed, reason: from getter */
    public final boolean getIsFullBleed() {
        return this.isFullBleed;
    }

    public final void setFullBleed(boolean z) {
        this.isFullBleed = z;
    }

    public final WebViewManager.Position getDisplayLocation() {
        return this.displayLocation;
    }

    public final void setDisplayLocation(WebViewManager.Position position) {
        this.displayLocation = position;
    }

    public final Double getDisplayDuration() {
        return this.displayDuration;
    }

    public final void setDisplayDuration(Double d) {
        this.displayDuration = d;
    }

    public final int getPageHeight() {
        return this.pageHeight;
    }

    public final void setPageHeight(int i) {
        this.pageHeight = i;
    }
}
