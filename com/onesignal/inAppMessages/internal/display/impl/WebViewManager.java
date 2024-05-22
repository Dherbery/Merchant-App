package com.onesignal.inAppMessages.internal.display.impl;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.common.ViewUtils;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IActivityLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.BuildConfig;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageClickResult;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import com.onesignal.inAppMessages.internal.InAppMessagePage;
import com.onesignal.inAppMessages.internal.display.impl.InAppMessageView;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WebViewManager.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0001\u0018\u0000 <2\u00020\u0001:\u0003<=>B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020 H\u0002J\u0011\u0010!\u001a\u00020\u001eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0010J\u0011\u0010%\u001a\u00020\u001eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\"J\b\u0010&\u001a\u00020\u001eH\u0002J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010(\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010+\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010,\u001a\u00020-H\u0002J\u0016\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005J\u0012\u00100\u001a\u00020\u001e2\b\u00101\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u00102\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J)\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u0010H\u0087@ø\u0001\u0000¢\u0006\u0002\u00107J\u001b\u00108\u001a\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010:J\u0011\u0010;\u001a\u00020\u001eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\"R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager;", "Lcom/onesignal/core/internal/application/IActivityLifecycleHandler;", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "activity", "Landroid/app/Activity;", "messageContent", "Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "_lifecycle", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_promptFactory", "Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Landroid/app/Activity;Lcom/onesignal/inAppMessages/internal/InAppMessageContent;Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;)V", "closing", "", "currentActivityName", "", "dismissFired", "lastPageHeight", "", "Ljava/lang/Integer;", "messageView", "Lcom/onesignal/inAppMessages/internal/display/impl/InAppMessageView;", "messageViewMutex", "Lkotlinx/coroutines/sync/Mutex;", "webView", "Lcom/onesignal/inAppMessages/internal/display/impl/OSWebView;", "backgroundDismissAndAwaitNextMessage", "", "blurryRenderingWebViewForKitKatWorkAround", "Landroid/webkit/WebView;", "calculateHeightAndShowWebViewAfterNewActivity", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createNewInAppMessageView", WebViewManager.IAM_DRAG_TO_DISMISS_DISABLED_KEY, "dismissAndAwaitNextMessage", "enableWebViewRemoteDebugging", "getWebViewMaxSizeX", "getWebViewMaxSizeY", "onActivityAvailable", "onActivityStopped", "pageRectToViewHeight", "jsonObject", "Lorg/json/JSONObject;", "setContentSafeAreaInsets", UriUtil.LOCAL_CONTENT_SCHEME, "setMessageView", "view", "setWebViewToMaxSize", "setupWebView", "currentActivity", "base64Message", "isFullScreen", "(Landroid/app/Activity;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showMessageView", "newHeight", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSafeAreaInsets", "Companion", "OSJavaScriptInterface", "Position", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class WebViewManager implements IActivityLifecycleHandler {
    public static final String EVENT_TYPE_ACTION_TAKEN = "action_taken";
    public static final String EVENT_TYPE_KEY = "type";
    public static final String EVENT_TYPE_PAGE_CHANGE = "page_change";
    public static final String EVENT_TYPE_RENDERING_COMPLETE = "rendering_complete";
    public static final String EVENT_TYPE_RESIZE = "resize";
    public static final String GET_PAGE_META_DATA_JS_FUNCTION = "getPageMetaData()";
    public static final String IAM_DISPLAY_LOCATION_KEY = "displayLocation";
    public static final String IAM_DRAG_TO_DISMISS_DISABLED_KEY = "dragToDismissDisabled";
    public static final String IAM_PAGE_META_DATA_KEY = "pageMetaData";
    public static final String JS_OBJ_NAME = "OSAndroid";
    public static final String SAFE_AREA_JS_OBJECT = "{\n   top: %d,\n   bottom: %d,\n   right: %d,\n   left: %d,\n}";
    public static final String SET_SAFE_AREA_INSETS_JS_FUNCTION = "setSafeAreaInsets(%s)";
    public static final String SET_SAFE_AREA_INSETS_SCRIPT = "\n\n<script>\n    setSafeAreaInsets(%s);\n</script>";
    private final IApplicationService _applicationService;
    private final IInAppLifecycleService _lifecycle;
    private final IInAppMessagePromptFactory _promptFactory;
    private Activity activity;
    private boolean closing;
    private String currentActivityName;
    private boolean dismissFired;
    private Integer lastPageHeight;
    private final InAppMessage message;
    private final InAppMessageContent messageContent;
    private InAppMessageView messageView;
    private final Mutex messageViewMutex;
    private OSWebView webView;
    private static final int MARGIN_PX_SIZE = ViewUtils.INSTANCE.dpToPx(24);

    private final void blurryRenderingWebViewForKitKatWorkAround(WebView webView) {
    }

    public WebViewManager(InAppMessage message, Activity activity, InAppMessageContent messageContent, IInAppLifecycleService _lifecycle, IApplicationService _applicationService, IInAppMessagePromptFactory _promptFactory) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(messageContent, "messageContent");
        Intrinsics.checkNotNullParameter(_lifecycle, "_lifecycle");
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_promptFactory, "_promptFactory");
        this.message = message;
        this.activity = activity;
        this.messageContent = messageContent;
        this._lifecycle = _lifecycle;
        this._applicationService = _applicationService;
        this._promptFactory = _promptFactory;
        this.messageViewMutex = MutexKt.Mutex$default(false, 1, null);
    }

    /* compiled from: WebViewManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "", "(Ljava/lang/String;I)V", "isBanner", "", "()Z", "TOP_BANNER", "BOTTOM_BANNER", "CENTER_MODAL", "FULL_SCREEN", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public enum Position {
        TOP_BANNER,
        BOTTOM_BANNER,
        CENTER_MODAL,
        FULL_SCREEN;

        /* compiled from: WebViewManager.kt */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Position.values().length];
                iArr[Position.TOP_BANNER.ordinal()] = 1;
                iArr[Position.BOTTOM_BANNER.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final boolean isBanner() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            return i == 1 || i == 2;
        }
    }

    /* compiled from: WebViewManager.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¨\u0006\u0012"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$OSJavaScriptInterface;", "", "(Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager;)V", "getDisplayLocation", "Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "jsonObject", "Lorg/json/JSONObject;", "getDragToDismissDisabled", "", "getPageHeightData", "", "handleActionTaken", "", "handlePageChange", "handleRenderComplete", "postMessage", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public final class OSJavaScriptInterface {
        public OSJavaScriptInterface() {
        }

        @JavascriptInterface
        public final void postMessage(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            try {
                Logging.debug$default("OSJavaScriptInterface:postMessage: " + message, null, 2, null);
                JSONObject jSONObject = new JSONObject(message);
                String string = jSONObject.getString("type");
                if (string != null) {
                    switch (string.hashCode()) {
                        case -1484226720:
                            if (string.equals(WebViewManager.EVENT_TYPE_PAGE_CHANGE)) {
                                handlePageChange(jSONObject);
                                return;
                            }
                            return;
                        case -934437708:
                            string.equals(WebViewManager.EVENT_TYPE_RESIZE);
                            return;
                        case 42998156:
                            if (string.equals(WebViewManager.EVENT_TYPE_RENDERING_COMPLETE)) {
                                handleRenderComplete(jSONObject);
                                return;
                            }
                            return;
                        case 1851145598:
                            if (string.equals(WebViewManager.EVENT_TYPE_ACTION_TAKEN)) {
                                InAppMessageView inAppMessageView = WebViewManager.this.messageView;
                                boolean z = false;
                                if (inAppMessageView != null && !inAppMessageView.getIsDragging()) {
                                    z = true;
                                }
                                if (z) {
                                    handleActionTaken(jSONObject);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private final void handleRenderComplete(JSONObject jsonObject) {
            Position displayLocation = getDisplayLocation(jsonObject);
            int pageHeightData = displayLocation == Position.FULL_SCREEN ? -1 : getPageHeightData(jsonObject);
            boolean dragToDismissDisabled = getDragToDismissDisabled(jsonObject);
            WebViewManager.this.messageContent.setDisplayLocation(displayLocation);
            WebViewManager.this.messageContent.setPageHeight(pageHeightData);
            WebViewManager.this.createNewInAppMessageView(dragToDismissDisabled);
        }

        private final int getPageHeightData(JSONObject jsonObject) {
            try {
                WebViewManager webViewManager = WebViewManager.this;
                Activity activity = webViewManager.activity;
                JSONObject jSONObject = jsonObject.getJSONObject(WebViewManager.IAM_PAGE_META_DATA_KEY);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.getJSONObject(IAM_PAGE_META_DATA_KEY)");
                return webViewManager.pageRectToViewHeight(activity, jSONObject);
            } catch (JSONException unused) {
                return -1;
            }
        }

        private final Position getDisplayLocation(JSONObject jsonObject) {
            Position position = Position.FULL_SCREEN;
            try {
                if (!jsonObject.has(WebViewManager.IAM_DISPLAY_LOCATION_KEY) || Intrinsics.areEqual(jsonObject.get(WebViewManager.IAM_DISPLAY_LOCATION_KEY), "")) {
                    return position;
                }
                String optString = jsonObject.optString(WebViewManager.IAM_DISPLAY_LOCATION_KEY, "FULL_SCREEN");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\n  …                        )");
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                String upperCase = optString.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                return Position.valueOf(upperCase);
            } catch (JSONException e) {
                e.printStackTrace();
                return position;
            }
        }

        private final boolean getDragToDismissDisabled(JSONObject jsonObject) {
            try {
                return jsonObject.getBoolean(WebViewManager.IAM_DRAG_TO_DISMISS_DISABLED_KEY);
            } catch (JSONException unused) {
                return false;
            }
        }

        private final void handleActionTaken(JSONObject jsonObject) throws JSONException {
            JSONObject body = jsonObject.getJSONObject(TtmlNode.TAG_BODY);
            Intrinsics.checkNotNullExpressionValue(body, "body");
            String safeString = JSONObjectExtensionsKt.safeString(body, "id");
            WebViewManager.this.closing = body.getBoolean("close");
            if (WebViewManager.this.message.getIsPreview()) {
                WebViewManager.this._lifecycle.messageActionOccurredOnPreview(WebViewManager.this.message, new InAppMessageClickResult(body, WebViewManager.this._promptFactory));
            } else if (safeString != null) {
                WebViewManager.this._lifecycle.messageActionOccurredOnMessage(WebViewManager.this.message, new InAppMessageClickResult(body, WebViewManager.this._promptFactory));
            }
            if (WebViewManager.this.closing) {
                WebViewManager.this.backgroundDismissAndAwaitNextMessage();
            }
        }

        private final void handlePageChange(JSONObject jsonObject) throws JSONException {
            WebViewManager.this._lifecycle.messagePageChanged(WebViewManager.this.message, new InAppMessagePage(jsonObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int pageRectToViewHeight(Activity activity, JSONObject jsonObject) {
        try {
            int dpToPx = ViewUtils.INSTANCE.dpToPx(jsonObject.getJSONObject("rect").getInt("height"));
            Logging.debug$default("getPageHeightData:pxHeight: " + dpToPx, null, 2, null);
            int webViewMaxSizeY = getWebViewMaxSizeY(activity);
            if (dpToPx <= webViewMaxSizeY) {
                return dpToPx;
            }
            Logging.debug$default("getPageHeightData:pxHeight is over screen max: " + webViewMaxSizeY, null, 2, null);
            return webViewMaxSizeY;
        } catch (JSONException e) {
            Logging.error("pageRectToViewHeight could not get page height", e);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateSafeAreaInsets(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebViewManager$updateSafeAreaInsets$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object calculateHeightAndShowWebViewAfterNewActivity(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1
            if (r0 == 0) goto L14
            r0 = r8
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1
            r0.<init>(r7, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 1
            r5 = 2
            if (r2 == 0) goto L48
            if (r2 == r4) goto L44
            if (r2 == r5) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r0 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L9e
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3c:
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r2 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L85
        L44:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6f
        L48:
            kotlin.ResultKt.throwOnFailure(r8)
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r8 = r7.messageView
            if (r8 != 0) goto L52
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L52:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$Position r8 = r8.getDisplayPosition()
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$Position r2 = com.onesignal.inAppMessages.internal.display.impl.WebViewManager.Position.FULL_SCREEN
            r6 = 0
            if (r8 != r2) goto L72
            com.onesignal.inAppMessages.internal.InAppMessageContent r8 = r7.messageContent
            boolean r8 = r8.getIsFullBleed()
            if (r8 != 0) goto L72
            r0.label = r4
            java.lang.Object r8 = r7.showMessageView(r6, r0)
            if (r8 != r1) goto L6f
            return r1
        L6f:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L72:
            java.lang.String r8 = "In app message new activity, calculate height and show "
            com.onesignal.debug.internal.logging.Logging.debug$default(r8, r6, r5, r6)
            com.onesignal.core.internal.application.IApplicationService r8 = r7._applicationService
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = r8.waitUntilActivityReady(r0)
            if (r8 != r1) goto L84
            return r1
        L84:
            r2 = r7
        L85:
            android.app.Activity r8 = r2.activity
            r2.setWebViewToMaxSize(r8)
            com.onesignal.inAppMessages.internal.InAppMessageContent r8 = r2.messageContent
            boolean r8 = r8.getIsFullBleed()
            if (r8 == 0) goto L9f
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r2.updateSafeAreaInsets(r0)
            if (r8 != r1) goto L9d
            return r1
        L9d:
            r0 = r2
        L9e:
            r2 = r0
        L9f:
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r8 = r2.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$$ExternalSyntheticLambda0 r0 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager$$ExternalSyntheticLambda0
            r0.<init>()
            java.lang.String r1 = "getPageMetaData()"
            r8.evaluateJavascript(r1, r0)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.WebViewManager.calculateHeightAndShowWebViewAfterNewActivity(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeightAndShowWebViewAfterNewActivity$lambda-0, reason: not valid java name */
    public static final void m1025calculateHeightAndShowWebViewAfterNewActivity$lambda0(WebViewManager this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            ThreadUtilsKt.suspendifyOnThread$default(0, new WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1(this$0, this$0.pageRectToViewHeight(this$0.activity, new JSONObject(str)), null), 1, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.onesignal.core.internal.application.IActivityLifecycleHandler
    public void onActivityAvailable(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String str = this.currentActivityName;
        this.activity = activity;
        this.currentActivityName = activity.getLocalClassName();
        Logging.debug$default("In app message activity available currentActivityName: " + this.currentActivityName + " lastActivityName: " + str, null, 2, null);
        ThreadUtilsKt.suspendifyOnMain(new WebViewManager$onActivityAvailable$1(str, this, null));
    }

    @Override // com.onesignal.core.internal.application.IActivityLifecycleHandler
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logging.debug$default(StringsKt.trimIndent("\n            In app message activity stopped, cleaning views, currentActivityName: " + this.currentActivityName + "\n            activity: " + this.activity + "\n            messageView: " + this.messageView + "\n            "), null, 2, null);
        if (this.messageView == null || !Intrinsics.areEqual(activity.getLocalClassName(), this.currentActivityName)) {
            return;
        }
        InAppMessageView inAppMessageView = this.messageView;
        Intrinsics.checkNotNull(inAppMessageView);
        inAppMessageView.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e8 A[Catch: all -> 0x005d, TryCatch #0 {all -> 0x005d, blocks: (B:14:0x0036, B:15:0x00f7, B:22:0x004b, B:23:0x00e4, B:25:0x00e8, B:30:0x0058, B:31:0x00cf, B:33:0x00d3, B:37:0x0087, B:39:0x008b, B:42:0x0096, B:44:0x00a9, B:46:0x00b5, B:48:0x00bb), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d3 A[Catch: all -> 0x005d, TryCatch #0 {all -> 0x005d, blocks: (B:14:0x0036, B:15:0x00f7, B:22:0x004b, B:23:0x00e4, B:25:0x00e8, B:30:0x0058, B:31:0x00cf, B:33:0x00d3, B:37:0x0087, B:39:0x008b, B:42:0x0096, B:44:0x00a9, B:46:0x00b5, B:48:0x00bb), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008b A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #0 {all -> 0x005d, blocks: (B:14:0x0036, B:15:0x00f7, B:22:0x004b, B:23:0x00e4, B:25:0x00e8, B:30:0x0058, B:31:0x00cf, B:33:0x00d3, B:37:0x0087, B:39:0x008b, B:42:0x0096, B:44:0x00a9, B:46:0x00b5, B:48:0x00bb), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0096 A[Catch: all -> 0x005d, TRY_ENTER, TryCatch #0 {all -> 0x005d, blocks: (B:14:0x0036, B:15:0x00f7, B:22:0x004b, B:23:0x00e4, B:25:0x00e8, B:30:0x0058, B:31:0x00cf, B:33:0x00d3, B:37:0x0087, B:39:0x008b, B:42:0x0096, B:44:0x00a9, B:46:0x00b5, B:48:0x00bb), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object showMessageView(java.lang.Integer r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.WebViewManager.showMessageView(java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setupWebView(android.app.Activity r7, java.lang.String r8, boolean r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.onesignal.inAppMessages.internal.display.impl.WebViewManager$setupWebView$1
            if (r0 == 0) goto L14
            r0 = r10
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$setupWebView$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager$setupWebView$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$setupWebView$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager$setupWebView$1
            r0.<init>(r6, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.L$2
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r7 = r0.L$1
            android.app.Activity r7 = (android.app.Activity) r7
            java.lang.Object r9 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r9 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lc0
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            kotlin.ResultKt.throwOnFailure(r10)
            r6.enableWebViewRemoteDebugging()
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r10 = new com.onesignal.inAppMessages.internal.display.impl.OSWebView
            r2 = r7
            android.content.Context r2 = (android.content.Context) r2
            r10.<init>(r2)
            r6.webView = r10
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r2 = 2
            r10.setOverScrollMode(r2)
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r10 = r6.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r2 = 0
            r10.setVerticalScrollBarEnabled(r2)
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r10 = r6.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r10.setHorizontalScrollBarEnabled(r2)
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r10 = r6.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            android.webkit.WebSettings r10 = r10.getSettings()
            r10.setJavaScriptEnabled(r3)
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r10 = r6.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$OSJavaScriptInterface r4 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager$OSJavaScriptInterface
            r4.<init>()
            java.lang.String r5 = "OSAndroid"
            r10.addJavascriptInterface(r4, r5)
            if (r9 == 0) goto L9d
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r9 = r6.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            r10 = 3074(0xc02, float:4.308E-42)
            r9.setSystemUiVisibility(r10)
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 30
            if (r9 < r10) goto L9d
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r9 = r6.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            r9.setFitsSystemWindows(r2)
        L9d:
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r9 = r6.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            android.webkit.WebView r9 = (android.webkit.WebView) r9
            r6.blurryRenderingWebViewForKitKatWorkAround(r9)
            com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService r9 = r6._lifecycle
            com.onesignal.inAppMessages.internal.InAppMessage r10 = r6.message
            r9.messageWillDisplay(r10)
            com.onesignal.core.internal.application.IApplicationService r9 = r6._applicationService
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r9 = r9.waitUntilActivityReady(r0)
            if (r9 != r1) goto Lbf
            return r1
        Lbf:
            r9 = r6
        Lc0:
            r9.setWebViewToMaxSize(r7)
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r7 = r9.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.String r9 = "text/html; charset=utf-8"
            java.lang.String r10 = "base64"
            r7.loadData(r8, r9, r10)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.WebViewManager.setupWebView(android.app.Activity, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void setWebViewToMaxSize(Activity activity) {
        OSWebView oSWebView = this.webView;
        Intrinsics.checkNotNull(oSWebView);
        oSWebView.layout(0, 0, getWebViewMaxSizeX(activity), getWebViewMaxSizeY(activity));
    }

    private final void setMessageView(InAppMessageView view) {
        this.messageView = view;
    }

    public final void createNewInAppMessageView(boolean dragToDismissDisabled) {
        this.lastPageHeight = Integer.valueOf(this.messageContent.getPageHeight());
        boolean manifestMetaBoolean = AndroidUtils.INSTANCE.getManifestMetaBoolean(this._applicationService.getAppContext(), "com.onesignal.inAppMessageHideGrayOverlay");
        OSWebView oSWebView = this.webView;
        Intrinsics.checkNotNull(oSWebView);
        setMessageView(new InAppMessageView(oSWebView, this.messageContent, dragToDismissDisabled, manifestMetaBoolean));
        InAppMessageView inAppMessageView = this.messageView;
        Intrinsics.checkNotNull(inAppMessageView);
        inAppMessageView.setMessageController(new InAppMessageView.InAppMessageViewListener() { // from class: com.onesignal.inAppMessages.internal.display.impl.WebViewManager$createNewInAppMessageView$1
            @Override // com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.InAppMessageViewListener
            public void onMessageWasDisplayed() {
                WebViewManager.this._lifecycle.messageWasDisplayed(WebViewManager.this.message);
            }

            @Override // com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.InAppMessageViewListener
            public void onMessageWillDismiss() {
                WebViewManager.this._lifecycle.messageWillDismiss(WebViewManager.this.message);
            }

            @Override // com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.InAppMessageViewListener
            public void onMessageWasDismissed() {
                IApplicationService iApplicationService;
                WebViewManager.this._lifecycle.messageWasDismissed(WebViewManager.this.message);
                iApplicationService = WebViewManager.this._applicationService;
                iApplicationService.removeActivityLifecycleHandler(this);
            }
        });
        this._applicationService.addActivityLifecycleHandler(this);
    }

    private final int getWebViewMaxSizeX(Activity activity) {
        if (this.messageContent.getIsFullBleed()) {
            return ViewUtils.INSTANCE.getFullbleedWindowWidth(activity);
        }
        return ViewUtils.INSTANCE.getWindowWidth(activity) - (MARGIN_PX_SIZE * 2);
    }

    private final int getWebViewMaxSizeY(Activity activity) {
        return ViewUtils.INSTANCE.getWindowHeight(activity) - (this.messageContent.getIsFullBleed() ? 0 : MARGIN_PX_SIZE * 2);
    }

    public final void backgroundDismissAndAwaitNextMessage() {
        ThreadUtilsKt.suspendifyOnThread$default(0, new WebViewManager$backgroundDismissAndAwaitNextMessage$1(this, null), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object dismissAndAwaitNextMessage(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.onesignal.inAppMessages.internal.display.impl.WebViewManager$dismissAndAwaitNextMessage$1
            if (r0 == 0) goto L14
            r0 = r6
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$dismissAndAwaitNextMessage$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager$dismissAndAwaitNextMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$dismissAndAwaitNextMessage$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager$dismissAndAwaitNextMessage$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L57
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r6 = r5.messageView
            if (r6 == 0) goto L61
            boolean r2 = r5.dismissFired
            if (r2 == 0) goto L42
            goto L61
        L42:
            r5.dismissFired = r3
            com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService r2 = r5._lifecycle
            com.onesignal.inAppMessages.internal.InAppMessage r4 = r5.message
            r2.messageWillDismiss(r4)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.dismissAndAwaitNextMessage(r0)
            if (r6 != r1) goto L56
            return r1
        L56:
            r0 = r5
        L57:
            r6 = 0
            r0.dismissFired = r6
            r6 = 0
            r0.setMessageView(r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L61:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.WebViewManager.dismissAndAwaitNextMessage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setContentSafeAreaInsets(InAppMessageContent content, Activity activity) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(activity, "activity");
        String contentHtml = content.getContentHtml();
        int[] cutoutAndStatusBarInsets = ViewUtils.INSTANCE.getCutoutAndStatusBarInsets(activity);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(SAFE_AREA_JS_OBJECT, Arrays.copyOf(new Object[]{Integer.valueOf(cutoutAndStatusBarInsets[0]), Integer.valueOf(cutoutAndStatusBarInsets[1]), Integer.valueOf(cutoutAndStatusBarInsets[2]), Integer.valueOf(cutoutAndStatusBarInsets[3])}, 4));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format(SET_SAFE_AREA_INSETS_SCRIPT, Arrays.copyOf(new Object[]{format}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        content.setContentHtml(contentHtml + format2);
    }

    private final void enableWebViewRemoteDebugging() {
        if (Logging.atLogLevel(LogLevel.DEBUG)) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }
}
