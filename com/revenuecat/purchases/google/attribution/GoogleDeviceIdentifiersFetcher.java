package com.revenuecat.purchases.google.attribution;

import android.app.Application;
import android.provider.Settings;
import com.amazon.a.a.o.b;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleDeviceIdentifiersFetcher.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\b\u001a\u00020\tH\u0003J?\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2-\u0010\u000e\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/google/attribution/GoogleDeviceIdentifiersFetcher;", "Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "(Lcom/revenuecat/purchases/common/Dispatcher;)V", "noPermissionAdvertisingIdValue", "", "getAdvertisingID", "applicationContext", "Landroid/app/Application;", "getAndroidID", "kotlin.jvm.PlatformType", "getDeviceIdentifiers", "", "completion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "deviceIdentifiers", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class GoogleDeviceIdentifiersFetcher implements DeviceIdentifiersFetcher {
    private final Dispatcher dispatcher;
    private final String noPermissionAdvertisingIdValue;

    public GoogleDeviceIdentifiersFetcher(Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.noPermissionAdvertisingIdValue = "00000000-0000-0000-0000-000000000000";
    }

    @Override // com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher
    public void getDeviceIdentifiers(final Application applicationContext, final Function1<? super Map<String, String>, Unit> completion) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(completion, "completion");
        Dispatcher.enqueue$default(this.dispatcher, new Runnable() { // from class: com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GoogleDeviceIdentifiersFetcher.getDeviceIdentifiers$lambda$0(GoogleDeviceIdentifiersFetcher.this, applicationContext, completion);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDeviceIdentifiers$lambda$0(GoogleDeviceIdentifiersFetcher this$0, Application applicationContext, Function1 completion) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(applicationContext, "$applicationContext");
        Intrinsics.checkNotNullParameter(completion, "$completion");
        completion.invoke(MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to(SubscriberAttributeKey.DeviceIdentifiers.GPSAdID.INSTANCE.getBackendKey(), this$0.getAdvertisingID(applicationContext)), TuplesKt.to(SubscriberAttributeKey.DeviceIdentifiers.AndroidID.INSTANCE.getBackendKey(), this$0.getAndroidID(applicationContext)), TuplesKt.to(SubscriberAttributeKey.DeviceIdentifiers.IP.INSTANCE.getBackendKey(), b.ac))));
    }

    private final String getAndroidID(Application applicationContext) {
        return Settings.Secure.getString(applicationContext.getContentResolver(), "android_id");
    }

    private final String getAdvertisingID(Application applicationContext) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(applicationContext);
            if (!advertisingIdInfo.isLimitAdTrackingEnabled()) {
                if (Intrinsics.areEqual(advertisingIdInfo.getId(), this.noPermissionAdvertisingIdValue)) {
                    LogWrapperKt.log(LogIntent.WARNING, AttributionStrings.GOOGLE_PLAY_ADVERTISING_ID_NOT_AVAILABLE);
                } else {
                    return advertisingIdInfo.getId();
                }
            }
        } catch (GooglePlayServicesNotAvailableException e) {
            LogIntent logIntent = LogIntent.GOOGLE_ERROR;
            String format = String.format(AttributionStrings.GOOGLE_PLAY_SERVICES_NOT_INSTALLED_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e.getLocalizedMessage()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
        } catch (GooglePlayServicesRepairableException e2) {
            LogIntent logIntent2 = LogIntent.GOOGLE_ERROR;
            String format2 = String.format(AttributionStrings.GOOGLE_PLAY_SERVICES_REPAIRABLE_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e2.getLocalizedMessage()}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
            LogWrapperKt.log(logIntent2, format2);
        } catch (IOException e3) {
            LogIntent logIntent3 = LogIntent.GOOGLE_ERROR;
            String format3 = String.format(AttributionStrings.IO_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e3.getLocalizedMessage()}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
            LogWrapperKt.log(logIntent3, format3);
        } catch (NullPointerException e4) {
            LogIntent logIntent4 = LogIntent.GOOGLE_ERROR;
            String format4 = String.format(AttributionStrings.NULL_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e4.getLocalizedMessage()}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "format(this, *args)");
            LogWrapperKt.log(logIntent4, format4);
        } catch (TimeoutException e5) {
            LogIntent logIntent5 = LogIntent.GOOGLE_ERROR;
            String format5 = String.format(AttributionStrings.TIMEOUT_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e5.getLocalizedMessage()}, 1));
            Intrinsics.checkNotNullExpressionValue(format5, "format(this, *args)");
            LogWrapperKt.log(logIntent5, format5);
        }
        return null;
    }
}
