package com.onesignal.inAppMessages.internal;

import com.onesignal.common.exceptions.BackendException;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.inAppMessages.internal.backend.IInAppBackendService;
import com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: InAppMessagesManager.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageWasDisplayed$2", f = "InAppMessagesManager.kt", i = {}, l = {560}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class InAppMessagesManager$onMessageWasDisplayed$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ InAppMessage $message;
    final /* synthetic */ String $variantId;
    int label;
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessagesManager$onMessageWasDisplayed$2(InAppMessagesManager inAppMessagesManager, String str, InAppMessage inAppMessage, Continuation<? super InAppMessagesManager$onMessageWasDisplayed$2> continuation) {
        super(1, continuation);
        this.this$0 = inAppMessagesManager;
        this.$variantId = str;
        this.$message = inAppMessage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new InAppMessagesManager$onMessageWasDisplayed$2(this.this$0, this.$variantId, this.$message, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((InAppMessagesManager$onMessageWasDisplayed$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Set set;
        IInAppBackendService iInAppBackendService;
        ConfigModelStore configModelStore;
        ISubscriptionManager iSubscriptionManager;
        IInAppPreferencesController iInAppPreferencesController;
        Set<String> set2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                iInAppBackendService = this.this$0._backend;
                configModelStore = this.this$0._configModelStore;
                String appId = configModelStore.getModel().getAppId();
                iSubscriptionManager = this.this$0._subscriptionManager;
                this.label = 1;
                if (iInAppBackendService.sendIAMImpression(appId, iSubscriptionManager.getSubscriptions().getPush().getId(), this.$variantId, this.$message.getMessageId(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            iInAppPreferencesController = this.this$0._prefs;
            set2 = this.this$0.impressionedMessages;
            iInAppPreferencesController.setImpressionesMessagesId(set2);
        } catch (BackendException unused) {
            set = this.this$0.impressionedMessages;
            set.remove(this.$message.getMessageId());
        }
        return Unit.INSTANCE;
    }
}
