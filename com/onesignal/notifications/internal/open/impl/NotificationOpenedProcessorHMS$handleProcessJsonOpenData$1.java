package com.onesignal.notifications.internal.open.impl;

import com.facebook.soloader.Elf64_Ehdr;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationOpenedProcessorHMS.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS", f = "NotificationOpenedProcessorHMS.kt", i = {0, 0, 0}, l = {Elf64_Ehdr.e_shstrndx, 66}, m = "handleProcessJsonOpenData", n = {"this", "activity", "jsonData"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes5.dex */
public final class NotificationOpenedProcessorHMS$handleProcessJsonOpenData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationOpenedProcessorHMS this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationOpenedProcessorHMS$handleProcessJsonOpenData$1(NotificationOpenedProcessorHMS notificationOpenedProcessorHMS, Continuation<? super NotificationOpenedProcessorHMS$handleProcessJsonOpenData$1> continuation) {
        super(continuation);
        this.this$0 = notificationOpenedProcessorHMS;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object handleProcessJsonOpenData;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleProcessJsonOpenData = this.this$0.handleProcessJsonOpenData(null, null, this);
        return handleProcessJsonOpenData;
    }
}
