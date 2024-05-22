package com.revenuecat.purchases.google.usecase;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: BillingClientUseCase.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public /* synthetic */ class BillingClientUseCase$processResult$1<T> extends FunctionReferenceImpl implements Function1<T, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingClientUseCase$processResult$1(Object obj) {
        super(1, obj, BillingClientUseCase.class, "onOk", "onOk(Ljava/lang/Object;)V", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2((BillingClientUseCase$processResult$1<T>) obj);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(T t) {
        ((BillingClientUseCase) this.receiver).onOk(t);
    }
}
