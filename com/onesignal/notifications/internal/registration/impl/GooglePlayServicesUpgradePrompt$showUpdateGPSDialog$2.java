package com.onesignal.notifications.internal.registration.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GooglePlayServicesUpgradePrompt.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2", f = "GooglePlayServicesUpgradePrompt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GooglePlayServicesUpgradePrompt this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2(GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt, Continuation<? super GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2> continuation) {
        super(2, continuation);
        this.this$0 = googlePlayServicesUpgradePrompt;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IApplicationService iApplicationService;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        iApplicationService = this.this$0._applicationService;
        final Activity activity = iApplicationService.get_current();
        if (activity == null) {
            return Unit.INSTANCE;
        }
        Activity activity2 = activity;
        String resourceString = AndroidUtils.INSTANCE.getResourceString(activity2, "onesignal_gms_missing_alert_text", "To receive push notifications please press 'Update' to enable 'Google Play services'.");
        String resourceString2 = AndroidUtils.INSTANCE.getResourceString(activity2, "onesignal_gms_missing_alert_button_update", "Update");
        String resourceString3 = AndroidUtils.INSTANCE.getResourceString(activity2, "onesignal_gms_missing_alert_button_skip", "Skip");
        String resourceString4 = AndroidUtils.INSTANCE.getResourceString(activity2, "onesignal_gms_missing_alert_button_close", "Close");
        final GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt = this.this$0;
        final GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt2 = this.this$0;
        new AlertDialog.Builder(activity2).setMessage(resourceString).setPositiveButton(resourceString2, new DialogInterface.OnClickListener() { // from class: com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GooglePlayServicesUpgradePrompt.access$openPlayStoreToApp(GooglePlayServicesUpgradePrompt.this, activity);
            }
        }).setNegativeButton(resourceString3, new DialogInterface.OnClickListener() { // from class: com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2.m1040invokeSuspend$lambda1(GooglePlayServicesUpgradePrompt.this, dialogInterface, i);
            }
        }).setNeutralButton(resourceString4, (DialogInterface.OnClickListener) null).create().show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-1, reason: not valid java name */
    public static final void m1040invokeSuspend$lambda1(GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt, DialogInterface dialogInterface, int i) {
        ConfigModelStore configModelStore;
        configModelStore = googlePlayServicesUpgradePrompt._configModelStore;
        configModelStore.getModel().setUserRejectedGMSUpdate(true);
    }
}
