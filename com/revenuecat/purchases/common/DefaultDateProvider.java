package com.revenuecat.purchases.common;

import java.util.Date;
import kotlin.Metadata;

/* compiled from: DateProvider.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/DefaultDateProvider;", "Lcom/revenuecat/purchases/common/DateProvider;", "()V", "now", "Ljava/util/Date;", "getNow", "()Ljava/util/Date;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class DefaultDateProvider implements DateProvider {
    @Override // com.revenuecat.purchases.common.DateProvider
    public Date getNow() {
        return new Date();
    }
}
