package com.onesignal.core.internal.application.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApplicationService.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.core.internal.application.impl.ApplicationService", f = "ApplicationService.kt", i = {0, 0, 1, 1, 2, 2}, l = {230, 261, 288}, m = "waitUntilSystemConditionsAvailable", n = {"this", "waitForActivityRetryCount", "this", "currentActivity", "this", "systemConditionHandler"}, s = {"L$0", "I$0", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes5.dex */
public final class ApplicationService$waitUntilSystemConditionsAvailable$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ApplicationService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationService$waitUntilSystemConditionsAvailable$1(ApplicationService applicationService, Continuation<? super ApplicationService$waitUntilSystemConditionsAvailable$1> continuation) {
        super(continuation);
        this.this$0 = applicationService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.waitUntilSystemConditionsAvailable(this);
    }
}
