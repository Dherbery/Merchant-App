package com.onesignal.core.internal.application.impl;

import com.google.mlkit.common.MlKitException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApplicationService.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.core.internal.application.impl.ApplicationService", f = "ApplicationService.kt", i = {}, l = {MlKitException.LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE}, m = "waitUntilActivityReady", n = {}, s = {})
/* loaded from: classes5.dex */
public final class ApplicationService$waitUntilActivityReady$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ApplicationService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationService$waitUntilActivityReady$1(ApplicationService applicationService, Continuation<? super ApplicationService$waitUntilActivityReady$1> continuation) {
        super(continuation);
        this.this$0 = applicationService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.waitUntilActivityReady(this);
    }
}
