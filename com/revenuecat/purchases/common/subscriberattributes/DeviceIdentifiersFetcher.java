package com.revenuecat.purchases.common.subscriberattributes;

import android.app.Application;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: DeviceIdentifiersFetcher.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J?\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052-\u0010\u0006\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00030\u0007H&¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;", "", "getDeviceIdentifiers", "", "applicationContext", "Landroid/app/Application;", "completion", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "deviceIdentifiers", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface DeviceIdentifiersFetcher {
    void getDeviceIdentifiers(Application applicationContext, Function1<? super Map<String, String>, Unit> completion);
}
