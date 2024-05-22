package com.onesignal.inAppMessages.internal.display.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.core.widget.PopupWindowCompat;
import com.facebook.common.util.UriUtil;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.ViewUtils;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.common.threading.Waiter;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.BuildConfig;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout;
import com.onesignal.inAppMessages.internal.display.impl.InAppMessageView;
import com.onesignal.inAppMessages.internal.display.impl.WebViewManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: InAppMessageView.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 l2\u00020\u0001:\u0002lmB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010/J2\u00100\u001a\u0002012\u0006\u0010-\u001a\u00020.2\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u00142\b\u00105\u001a\u0004\u0018\u000106H\u0002J \u00107\u001a\u00020,2\u0006\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020;H\u0002J*\u0010<\u001a\u00020,2\u0006\u00108\u001a\u00020.2\u0006\u0010-\u001a\u00020.2\u0006\u0010:\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u000106H\u0002J \u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020\u00102\u0006\u00108\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002J \u0010@\u001a\u00020,2\u0006\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020;H\u0002J\u0011\u0010A\u001a\u00020,H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020,H\u0002J\u0010\u0010D\u001a\u00020;2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020IH\u0002J \u0010J\u001a\u00020K2\u0006\u0010$\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u0007H\u0002J\b\u0010M\u001a\u00020NH\u0002J\u0010\u0010O\u001a\u00020,2\u0006\u0010&\u001a\u00020'H\u0002J\u0019\u0010P\u001a\u00020,2\u0006\u0010\u000b\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010QJ\b\u0010R\u001a\u00020,H\u0002J\u0011\u0010S\u001a\u00020,H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010BJ\u0011\u0010T\u001a\u00020,H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010BJ\u0010\u0010U\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010V\u001a\u00020\u0014H\u0002J\u0006\u0010W\u001a\u00020,J\u0010\u0010X\u001a\u00020,2\u0006\u0010Y\u001a\u00020\u0005H\u0002J\u0010\u0010Z\u001a\u00020,2\b\u0010\"\u001a\u0004\u0018\u00010#J\"\u0010[\u001a\u00020,2\u0006\u0010H\u001a\u00020I2\b\u0010\\\u001a\u0004\u0018\u00010N2\u0006\u0010]\u001a\u00020KH\u0002J\u0010\u0010^\u001a\u00020,2\u0006\u0010H\u001a\u00020IH\u0002J\u000e\u0010_\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u0003J3\u0010`\u001a\u00020,2\u0006\u0010?\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020N2\b\u0010a\u001a\u0004\u0018\u00010N2\u0006\u0010b\u001a\u00020KH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010cJ\u001b\u0010d\u001a\u00020,2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010QJ\u0019\u0010e\u001a\u00020,2\u0006\u0010f\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010QJ\u0011\u0010g\u001a\u00020,H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010BJ\b\u0010h\u001a\u00020iH\u0016J\u0019\u0010j\u001a\u00020,2\u0006\u0010$\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010kR\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006n"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/InAppMessageView;", "", "webView", "Landroid/webkit/WebView;", "messageContent", "Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "disableDragDismiss", "", "hideGrayOverlay", "(Landroid/webkit/WebView;Lcom/onesignal/inAppMessages/internal/InAppMessageContent;ZZ)V", "cancelDismissTimer", "currentActivity", "Landroid/app/Activity;", "displayDuration", "", "displayPosition", "Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "getDisplayPosition", "()Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "displayYSize", "", "getDisplayYSize", "()I", "draggableRelativeLayout", "Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout;", "hasBackground", "isDismissTimerSet", "<set-?>", "isDragging", "()Z", "marginPxSizeBottom", "marginPxSizeLeft", "marginPxSizeRight", "marginPxSizeTop", "messageController", "Lcom/onesignal/inAppMessages/internal/display/impl/InAppMessageView$InAppMessageViewListener;", "pageHeight", "pageWidth", "parentRelativeLayout", "Landroid/widget/RelativeLayout;", "popupWindow", "Landroid/widget/PopupWindow;", "shouldDismissWhenActive", "animateAndDismissLayout", "", "backgroundView", "Landroid/view/View;", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateBackgroundColor", "Landroid/animation/ValueAnimator;", "duration", "startColor", "endColor", "animCallback", "Landroid/animation/Animator$AnimatorListener;", "animateBottom", "messageView", "height", "cardViewAnimCallback", "Landroid/view/animation/Animation$AnimationListener;", "animateCenter", "backgroundAnimCallback", "animateInAppMessage", WebViewManager.IAM_DISPLAY_LOCATION_KEY, "animateTop", "checkIfShouldDismiss", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanupViewsAfterDismiss", "createAnimationListener", "messageViewCardView", "Landroidx/cardview/widget/CardView;", "createCardView", "context", "Landroid/content/Context;", "createDraggableLayoutParams", "Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$Params;", "disableDragging", "createParentRelativeLayoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "createPopupWindow", "delayShowUntilAvailable", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dereferenceViews", "dismissAndAwaitNextMessage", "finishAfterDelay", "getHideDropShadow", "getOverlayColor", "removeAllViews", "setMarginsFromContent", UriUtil.LOCAL_CONTENT_SCHEME, "setMessageController", "setUpDraggableLayout", "relativeLayoutParams", "draggableParams", "setUpParentRelativeLayout", "setWebView", "showDraggableView", "draggableRelativeLayoutParams", "webViewLayoutParams", "(Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;Landroid/widget/RelativeLayout$LayoutParams;Landroid/widget/RelativeLayout$LayoutParams;Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showInAppMessageView", "showView", "activity", "startDismissTimerIfNeeded", "toString", "", "updateHeight", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "InAppMessageViewListener", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppMessageView {
    private static final int ACTIVITY_BACKGROUND_COLOR_EMPTY = 0;
    private static final int ACTIVITY_FINISH_AFTER_DISMISS_DELAY_MS = 600;
    private static final int ACTIVITY_INIT_DELAY = 200;
    private static final int IN_APP_BACKGROUND_ANIMATION_DURATION_MS = 400;
    private static final int IN_APP_BANNER_ANIMATION_DURATION_MS = 1000;
    private static final int IN_APP_CENTER_ANIMATION_DURATION_MS = 1000;
    private static final String IN_APP_MESSAGE_CARD_VIEW_TAG = "IN_APP_MESSAGE_CARD_VIEW_TAG";
    private boolean cancelDismissTimer;
    private Activity currentActivity;
    private final boolean disableDragDismiss;
    private final double displayDuration;
    private final WebViewManager.Position displayPosition;
    private DraggableRelativeLayout draggableRelativeLayout;
    private final boolean hasBackground;
    private final boolean hideGrayOverlay;
    private boolean isDismissTimerSet;
    private boolean isDragging;
    private int marginPxSizeBottom;
    private int marginPxSizeLeft;
    private int marginPxSizeRight;
    private int marginPxSizeTop;
    private final InAppMessageContent messageContent;
    private InAppMessageViewListener messageController;
    private int pageHeight;
    private final int pageWidth;
    private RelativeLayout parentRelativeLayout;
    private PopupWindow popupWindow;
    private boolean shouldDismissWhenActive;
    private WebView webView;
    private static final int ACTIVITY_BACKGROUND_COLOR_FULL = Color.parseColor("#BB000000");
    private static final int DRAG_THRESHOLD_PX_SIZE = ViewUtils.INSTANCE.dpToPx(4);

    /* compiled from: InAppMessageView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/InAppMessageView$InAppMessageViewListener;", "", "onMessageWasDismissed", "", "onMessageWasDisplayed", "onMessageWillDismiss", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public interface InAppMessageViewListener {
        void onMessageWasDismissed();

        void onMessageWasDisplayed();

        void onMessageWillDismiss();
    }

    /* compiled from: InAppMessageView.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WebViewManager.Position.values().length];
            iArr[WebViewManager.Position.TOP_BANNER.ordinal()] = 1;
            iArr[WebViewManager.Position.BOTTOM_BANNER.ordinal()] = 2;
            iArr[WebViewManager.Position.CENTER_MODAL.ordinal()] = 3;
            iArr[WebViewManager.Position.FULL_SCREEN.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public InAppMessageView(WebView webView, InAppMessageContent messageContent, boolean z, boolean z2) {
        double doubleValue;
        Intrinsics.checkNotNullParameter(messageContent, "messageContent");
        this.webView = webView;
        this.messageContent = messageContent;
        this.disableDragDismiss = z;
        this.hideGrayOverlay = z2;
        this.pageWidth = -1;
        this.pageHeight = messageContent.getPageHeight();
        this.marginPxSizeLeft = ViewUtils.INSTANCE.dpToPx(24);
        this.marginPxSizeRight = ViewUtils.INSTANCE.dpToPx(24);
        this.marginPxSizeTop = ViewUtils.INSTANCE.dpToPx(24);
        this.marginPxSizeBottom = ViewUtils.INSTANCE.dpToPx(24);
        WebViewManager.Position displayLocation = messageContent.getDisplayLocation();
        Intrinsics.checkNotNull(displayLocation);
        this.displayPosition = displayLocation;
        if (messageContent.getDisplayDuration() == null) {
            doubleValue = 0.0d;
        } else {
            Double displayDuration = messageContent.getDisplayDuration();
            Intrinsics.checkNotNull(displayDuration);
            doubleValue = displayDuration.doubleValue();
        }
        this.displayDuration = doubleValue;
        this.hasBackground = !displayLocation.isBanner();
        setMarginsFromContent(messageContent);
    }

    public final WebViewManager.Position getDisplayPosition() {
        return this.displayPosition;
    }

    /* renamed from: isDragging, reason: from getter */
    public final boolean getIsDragging() {
        return this.isDragging;
    }

    private final void setMarginsFromContent(InAppMessageContent content) {
        this.marginPxSizeTop = content.getUseHeightMargin() ? ViewUtils.INSTANCE.dpToPx(24) : 0;
        this.marginPxSizeBottom = content.getUseHeightMargin() ? ViewUtils.INSTANCE.dpToPx(24) : 0;
        this.marginPxSizeLeft = content.getUseWidthMargin() ? ViewUtils.INSTANCE.dpToPx(24) : 0;
        this.marginPxSizeRight = content.getUseWidthMargin() ? ViewUtils.INSTANCE.dpToPx(24) : 0;
    }

    public final void setWebView(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.webView = webView;
        Intrinsics.checkNotNull(webView);
        webView.setBackgroundColor(0);
    }

    public final void setMessageController(InAppMessageViewListener messageController) {
        this.messageController = messageController;
    }

    public final Object showView(Activity activity, Continuation<? super Unit> continuation) {
        Object delayShowUntilAvailable = delayShowUntilAvailable(activity, continuation);
        return delayShowUntilAvailable == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delayShowUntilAvailable : Unit.INSTANCE;
    }

    public final Object checkIfShouldDismiss(Continuation<? super Unit> continuation) {
        if (this.shouldDismissWhenActive) {
            this.shouldDismissWhenActive = false;
            Object finishAfterDelay = finishAfterDelay(continuation);
            return finishAfterDelay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? finishAfterDelay : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final Object updateHeight(int i, Continuation<? super Unit> continuation) {
        this.pageHeight = i;
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new InAppMessageView$updateHeight$2(this, i, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object showInAppMessageView(Activity activity, Continuation<? super Unit> continuation) {
        this.currentActivity = activity;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.pageHeight);
        layoutParams.addRule(13);
        RelativeLayout.LayoutParams createParentRelativeLayoutParams = this.hasBackground ? createParentRelativeLayoutParams() : null;
        WebViewManager.Position position = this.displayPosition;
        Object showDraggableView = showDraggableView(position, layoutParams, createParentRelativeLayoutParams, createDraggableLayoutParams(this.pageHeight, position, this.disableDragDismiss), continuation);
        return showDraggableView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? showDraggableView : Unit.INSTANCE;
    }

    private final int getDisplayYSize() {
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        Activity activity = this.currentActivity;
        Intrinsics.checkNotNull(activity);
        return viewUtils.getWindowHeight(activity);
    }

    private final RelativeLayout.LayoutParams createParentRelativeLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.pageWidth, -1);
        int i = WhenMappings.$EnumSwitchMapping$0[this.displayPosition.ordinal()];
        if (i == 1) {
            layoutParams.addRule(10);
            layoutParams.addRule(14);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(14);
        } else if (i == 3 || i == 4) {
            layoutParams.addRule(13);
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DraggableRelativeLayout.Params createDraggableLayoutParams(int pageHeight, WebViewManager.Position displayLocation, boolean disableDragging) {
        DraggableRelativeLayout.Params params = new DraggableRelativeLayout.Params();
        params.setMaxXPos(this.marginPxSizeRight);
        params.setMaxYPos(this.marginPxSizeTop);
        params.setDraggingDisabled(disableDragging);
        params.setMessageHeight(pageHeight);
        params.setHeight(getDisplayYSize());
        int i = WhenMappings.$EnumSwitchMapping$0[displayLocation.ordinal()];
        if (i == 1) {
            params.setDragThresholdY(this.marginPxSizeTop - DRAG_THRESHOLD_PX_SIZE);
        } else if (i == 2) {
            params.setPosY(getDisplayYSize() - pageHeight);
            params.setDragThresholdY(this.marginPxSizeBottom + DRAG_THRESHOLD_PX_SIZE);
        } else if (i == 3) {
            int displayYSize = (getDisplayYSize() / 2) - (pageHeight / 2);
            params.setDragThresholdY(DRAG_THRESHOLD_PX_SIZE + displayYSize);
            params.setMaxYPos(displayYSize);
            params.setPosY(displayYSize);
        } else if (i == 4) {
            int displayYSize2 = getDisplayYSize() - (this.marginPxSizeBottom + this.marginPxSizeTop);
            params.setMessageHeight(displayYSize2);
            int displayYSize3 = (getDisplayYSize() / 2) - (displayYSize2 / 2);
            params.setDragThresholdY(DRAG_THRESHOLD_PX_SIZE + displayYSize3);
            params.setMaxYPos(displayYSize3);
            params.setPosY(displayYSize3);
        }
        params.setDragDirection(displayLocation == WebViewManager.Position.TOP_BANNER ? 0 : 1);
        return params;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showDraggableView(WebViewManager.Position position, RelativeLayout.LayoutParams layoutParams, RelativeLayout.LayoutParams layoutParams2, DraggableRelativeLayout.Params params, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new InAppMessageView$showDraggableView$2(this, layoutParams, layoutParams2, params, position, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createPopupWindow(RelativeLayout parentRelativeLayout) {
        RelativeLayout relativeLayout = parentRelativeLayout;
        boolean z = this.hasBackground;
        PopupWindow popupWindow = new PopupWindow((View) relativeLayout, z ? -1 : this.pageWidth, z ? -1 : -2, false);
        this.popupWindow = popupWindow;
        Intrinsics.checkNotNull(popupWindow);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        PopupWindow popupWindow2 = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow2);
        int i = 1;
        popupWindow2.setTouchable(true);
        PopupWindow popupWindow3 = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow3);
        popupWindow3.setClippingEnabled(false);
        if (this.hasBackground) {
            i = 0;
        } else {
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.displayPosition.ordinal()];
            if (i2 == 1) {
                i = 49;
            } else if (i2 == 2) {
                i = 81;
            } else if (i2 != 3 && i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        int i3 = this.messageContent.getIsFullBleed() ? 1000 : 1003;
        PopupWindow popupWindow4 = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow4);
        PopupWindowCompat.setWindowLayoutType(popupWindow4, i3);
        PopupWindow popupWindow5 = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow5);
        Activity activity = this.currentActivity;
        Intrinsics.checkNotNull(activity);
        popupWindow5.showAtLocation(activity.getWindow().getDecorView().getRootView(), i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUpParentRelativeLayout(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.parentRelativeLayout = relativeLayout;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setBackgroundDrawable(new ColorDrawable(0));
        RelativeLayout relativeLayout2 = this.parentRelativeLayout;
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.setClipChildren(false);
        RelativeLayout relativeLayout3 = this.parentRelativeLayout;
        Intrinsics.checkNotNull(relativeLayout3);
        relativeLayout3.setClipToPadding(false);
        RelativeLayout relativeLayout4 = this.parentRelativeLayout;
        Intrinsics.checkNotNull(relativeLayout4);
        relativeLayout4.addView(this.draggableRelativeLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUpDraggableLayout(Context context, RelativeLayout.LayoutParams relativeLayoutParams, DraggableRelativeLayout.Params draggableParams) {
        DraggableRelativeLayout draggableRelativeLayout = new DraggableRelativeLayout(context);
        this.draggableRelativeLayout = draggableRelativeLayout;
        if (relativeLayoutParams != null) {
            Intrinsics.checkNotNull(draggableRelativeLayout);
            draggableRelativeLayout.setLayoutParams(relativeLayoutParams);
        }
        DraggableRelativeLayout draggableRelativeLayout2 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout2);
        draggableRelativeLayout2.setParams(draggableParams);
        DraggableRelativeLayout draggableRelativeLayout3 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout3);
        draggableRelativeLayout3.setListener(new DraggableRelativeLayout.DraggableListener() { // from class: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$setUpDraggableLayout$1
            @Override // com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout.DraggableListener
            public void onDismiss() {
                InAppMessageView.InAppMessageViewListener inAppMessageViewListener;
                InAppMessageView.InAppMessageViewListener inAppMessageViewListener2;
                inAppMessageViewListener = InAppMessageView.this.messageController;
                if (inAppMessageViewListener != null) {
                    inAppMessageViewListener2 = InAppMessageView.this.messageController;
                    Intrinsics.checkNotNull(inAppMessageViewListener2);
                    inAppMessageViewListener2.onMessageWillDismiss();
                }
                ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessageView$setUpDraggableLayout$1$onDismiss$1(InAppMessageView.this, null), 1, null);
            }

            @Override // com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout.DraggableListener
            public void onDragStart() {
                InAppMessageView.this.isDragging = true;
            }

            @Override // com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout.DraggableListener
            public void onDragEnd() {
                InAppMessageView.this.isDragging = false;
            }
        });
        WebView webView = this.webView;
        Intrinsics.checkNotNull(webView);
        if (webView.getParent() != null) {
            WebView webView2 = this.webView;
            Intrinsics.checkNotNull(webView2);
            ViewParent parent = webView2.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeAllViews();
        }
        CardView createCardView = createCardView(context);
        createCardView.setTag(IN_APP_MESSAGE_CARD_VIEW_TAG);
        createCardView.addView(this.webView);
        DraggableRelativeLayout draggableRelativeLayout4 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout4);
        draggableRelativeLayout4.setPadding(this.marginPxSizeLeft, this.marginPxSizeTop, this.marginPxSizeRight, this.marginPxSizeBottom);
        DraggableRelativeLayout draggableRelativeLayout5 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout5);
        draggableRelativeLayout5.setClipChildren(false);
        DraggableRelativeLayout draggableRelativeLayout6 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout6);
        draggableRelativeLayout6.setClipToPadding(false);
        DraggableRelativeLayout draggableRelativeLayout7 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout7);
        draggableRelativeLayout7.addView(createCardView);
    }

    private final CardView createCardView(Context context) {
        CardView cardView = new CardView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.displayPosition == WebViewManager.Position.FULL_SCREEN ? -1 : -2);
        layoutParams.addRule(13);
        cardView.setLayoutParams(layoutParams);
        if (Build.VERSION.SDK_INT == 23) {
            cardView.setCardElevation(0.0f);
        } else if (getHideDropShadow(context)) {
            cardView.setCardElevation(0.0f);
        } else {
            cardView.setCardElevation(ViewUtils.INSTANCE.dpToPx(5));
        }
        cardView.setRadius(ViewUtils.INSTANCE.dpToPx(8));
        cardView.setClipChildren(false);
        cardView.setClipToPadding(false);
        cardView.setPreventCornerOverlap(false);
        cardView.setCardBackgroundColor(0);
        return cardView;
    }

    private final boolean getHideDropShadow(Context context) {
        return AndroidUtils.INSTANCE.getManifestMetaBoolean(context, "com.onesignal.inAppMessageHideDropShadow");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object startDismissTimerIfNeeded(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$startDismissTimerIfNeeded$1
            if (r0 == 0) goto L14
            r0 = r11
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$startDismissTimerIfNeeded$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$startDismissTimerIfNeeded$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$startDismissTimerIfNeeded$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$startDismissTimerIfNeeded$1
            r0.<init>(r10, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L42
            if (r2 == r5) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r0 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L88
        L32:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L3a:
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L65
        L42:
            kotlin.ResultKt.throwOnFailure(r11)
            double r6 = r10.displayDuration
            r8 = 0
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 <= 0) goto L90
            boolean r11 = r10.isDismissTimerSet
            if (r11 == 0) goto L52
            goto L90
        L52:
            r10.isDismissTimerSet = r5
            long r6 = (long) r6
            r11 = 1000(0x3e8, float:1.401E-42)
            long r8 = (long) r11
            long r6 = r6 * r8
            r0.L$0 = r10
            r0.label = r5
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r6, r0)
            if (r11 != r1) goto L64
            return r1
        L64:
            r2 = r10
        L65:
            boolean r11 = r2.cancelDismissTimer
            if (r11 == 0) goto L6e
            r2.cancelDismissTimer = r3
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L6e:
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$InAppMessageViewListener r11 = r2.messageController
            if (r11 == 0) goto L78
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r11.onMessageWillDismiss()
        L78:
            android.app.Activity r11 = r2.currentActivity
            if (r11 == 0) goto L8b
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r11 = r2.dismissAndAwaitNextMessage(r0)
            if (r11 != r1) goto L87
            return r1
        L87:
            r0 = r2
        L88:
            r0.isDismissTimerSet = r3
            goto L8d
        L8b:
            r2.shouldDismissWhenActive = r5
        L8d:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L90:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.startDismissTimerIfNeeded(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object delayShowUntilAvailable(android.app.Activity r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$delayShowUntilAvailable$1
            if (r0 == 0) goto L14
            r0 = r8
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$delayShowUntilAvailable$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$delayShowUntilAvailable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$delayShowUntilAvailable$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$delayShowUntilAvailable$1
            r0.<init>(r6, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L48
            if (r2 == r5) goto L44
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            kotlin.ResultKt.throwOnFailure(r8)
            goto L81
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            java.lang.Object r7 = r0.L$1
            android.app.Activity r7 = (android.app.Activity) r7
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L73
        L44:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L60
        L48:
            kotlin.ResultKt.throwOnFailure(r8)
            com.onesignal.common.AndroidUtils r8 = com.onesignal.common.AndroidUtils.INSTANCE
            boolean r8 = r8.isActivityFullyReady(r7)
            if (r8 == 0) goto L63
            android.widget.RelativeLayout r8 = r6.parentRelativeLayout
            if (r8 != 0) goto L63
            r0.label = r5
            java.lang.Object r7 = r6.showInAppMessageView(r7, r0)
            if (r7 != r1) goto L60
            return r1
        L60:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L63:
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            r4 = 200(0xc8, double:9.9E-322)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r4, r0)
            if (r8 != r1) goto L72
            return r1
        L72:
            r2 = r6
        L73:
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r7 = r2.delayShowUntilAvailable(r7, r0)
            if (r7 != r1) goto L81
            return r1
        L81:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.delayShowUntilAvailable(android.app.Activity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object dismissAndAwaitNextMessage(Continuation<? super Unit> continuation) {
        DraggableRelativeLayout draggableRelativeLayout = this.draggableRelativeLayout;
        if (draggableRelativeLayout == null) {
            Logging.error$default("No host presenter to trigger dismiss animation, counting as dismissed already", null, 2, null);
            dereferenceViews();
            return Unit.INSTANCE;
        }
        Intrinsics.checkNotNull(draggableRelativeLayout);
        draggableRelativeLayout.dismiss();
        Object finishAfterDelay = finishAfterDelay(continuation);
        return finishAfterDelay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? finishAfterDelay : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object finishAfterDelay(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new InAppMessageView$finishAfterDelay$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanupViewsAfterDismiss() {
        removeAllViews();
        InAppMessageViewListener inAppMessageViewListener = this.messageController;
        if (inAppMessageViewListener != null) {
            inAppMessageViewListener.onMessageWasDismissed();
        }
    }

    public final void removeAllViews() {
        Logging.debug$default("InAppMessageView.removeAllViews()", null, 2, null);
        if (this.isDismissTimerSet) {
            this.cancelDismissTimer = true;
        }
        DraggableRelativeLayout draggableRelativeLayout = this.draggableRelativeLayout;
        if (draggableRelativeLayout != null) {
            Intrinsics.checkNotNull(draggableRelativeLayout);
            draggableRelativeLayout.removeAllViews();
        }
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            Intrinsics.checkNotNull(popupWindow);
            popupWindow.dismiss();
        }
        dereferenceViews();
    }

    private final void dereferenceViews() {
        this.parentRelativeLayout = null;
        this.draggableRelativeLayout = null;
        this.webView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateInAppMessage(WebViewManager.Position displayLocation, View messageView, View backgroundView) {
        Intrinsics.checkNotNull(messageView);
        CardView messageViewCardView = (CardView) messageView.findViewWithTag(IN_APP_MESSAGE_CARD_VIEW_TAG);
        Intrinsics.checkNotNullExpressionValue(messageViewCardView, "messageViewCardView");
        Animation.AnimationListener createAnimationListener = createAnimationListener(messageViewCardView);
        int i = WhenMappings.$EnumSwitchMapping$0[displayLocation.ordinal()];
        if (i == 1) {
            WebView webView = this.webView;
            Intrinsics.checkNotNull(webView);
            animateTop(messageViewCardView, webView.getHeight(), createAnimationListener);
        } else if (i == 2) {
            WebView webView2 = this.webView;
            Intrinsics.checkNotNull(webView2);
            animateBottom(messageViewCardView, webView2.getHeight(), createAnimationListener);
        } else if (i == 3 || i == 4) {
            animateCenter(messageView, backgroundView, createAnimationListener, null);
        }
    }

    private final Animation.AnimationListener createAnimationListener(final CardView messageViewCardView) {
        return new Animation.AnimationListener() { // from class: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$createAnimationListener$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                InAppMessageView.InAppMessageViewListener inAppMessageViewListener;
                InAppMessageView.InAppMessageViewListener inAppMessageViewListener2;
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (Build.VERSION.SDK_INT == 23) {
                    CardView.this.setCardElevation(ViewUtils.INSTANCE.dpToPx(5));
                }
                inAppMessageViewListener = this.messageController;
                if (inAppMessageViewListener != null) {
                    inAppMessageViewListener2 = this.messageController;
                    Intrinsics.checkNotNull(inAppMessageViewListener2);
                    inAppMessageViewListener2.onMessageWasDisplayed();
                }
            }
        };
    }

    private final void animateTop(View messageView, int height, Animation.AnimationListener cardViewAnimCallback) {
        OneSignalAnimate.INSTANCE.animateViewByTranslation(messageView, (-height) - this.marginPxSizeTop, 0.0f, 1000, new OneSignalBounceInterpolator(0.1d, 8.0d), cardViewAnimCallback).start();
    }

    private final void animateBottom(View messageView, int height, Animation.AnimationListener cardViewAnimCallback) {
        OneSignalAnimate.INSTANCE.animateViewByTranslation(messageView, height + this.marginPxSizeBottom, 0.0f, 1000, new OneSignalBounceInterpolator(0.1d, 8.0d), cardViewAnimCallback).start();
    }

    private final void animateCenter(View messageView, View backgroundView, Animation.AnimationListener cardViewAnimCallback, Animator.AnimatorListener backgroundAnimCallback) {
        Animation animateViewSmallToLarge = OneSignalAnimate.INSTANCE.animateViewSmallToLarge(messageView, 1000, new OneSignalBounceInterpolator(0.1d, 8.0d), cardViewAnimCallback);
        ValueAnimator animateBackgroundColor = animateBackgroundColor(backgroundView, 400, 0, getOverlayColor(), backgroundAnimCallback);
        animateViewSmallToLarge.start();
        animateBackgroundColor.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateAndDismissLayout(View view, Continuation<? super Unit> continuation) {
        final Waiter waiter = new Waiter();
        animateBackgroundColor(view, 400, getOverlayColor(), 0, new AnimatorListenerAdapter() { // from class: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$animateAndDismissLayout$animCallback$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                InAppMessageView.this.cleanupViewsAfterDismiss();
                waiter.wake();
            }
        }).start();
        Object waitForWake = waiter.waitForWake(continuation);
        return waitForWake == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? waitForWake : Unit.INSTANCE;
    }

    private final ValueAnimator animateBackgroundColor(View backgroundView, int duration, int startColor, int endColor, Animator.AnimatorListener animCallback) {
        return OneSignalAnimate.INSTANCE.animateViewColor(backgroundView, duration, startColor, endColor, animCallback);
    }

    public String toString() {
        return "InAppMessageView{currentActivity=" + this.currentActivity + ", pageWidth=" + this.pageWidth + ", pageHeight=" + this.pageHeight + ", displayDuration=" + this.displayDuration + ", hasBackground=" + this.hasBackground + ", shouldDismissWhenActive=" + this.shouldDismissWhenActive + ", isDragging=" + this.isDragging + ", disableDragDismiss=" + this.disableDragDismiss + ", displayLocation=" + this.displayPosition + ", webView=" + this.webView + AbstractJsonLexerKt.END_OBJ;
    }

    private final int getOverlayColor() {
        if (this.hideGrayOverlay) {
            return 0;
        }
        return ACTIVITY_BACKGROUND_COLOR_FULL;
    }
}
