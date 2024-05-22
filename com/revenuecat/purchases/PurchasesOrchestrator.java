package com.revenuecat.purchases;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.autofill.HintConstants;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.amazon.a.a.o.b;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer;
import com.revenuecat.purchases.common.offerings.OfferingsManager;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.PurchaseErrorCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import com.revenuecat.purchases.models.BillingFeature;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.paywalls.PaywallPresentedCache;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallEventsManager;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.ConfigureStrings;
import com.revenuecat.purchases.strings.CustomerInfoStrings;
import com.revenuecat.purchases.strings.IdentityStrings;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.utils.AndroidVersionUtilsKt;
import com.revenuecat.purchases.utils.CustomActivityLifecycleHandler;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: PurchasesOrchestrator.kt */
@Metadata(d1 = {"\u0000\u008a\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 æ\u00012\u00020\u00012\u00020\u0002:\u0002æ\u0001B·\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\u0006\u0010!\u001a\u00020\"\u0012\u0006\u0010#\u001a\u00020$\u0012\b\u0010%\u001a\u0004\u0018\u00010&\u0012\u0006\u0010'\u001a\u00020(\u0012\u0006\u0010)\u001a\u00020*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,¢\u0006\u0002\u0010-J\u0006\u0010X\u001a\u00020YJ\u0006\u0010Z\u001a\u00020YJ\u0016\u0010[\u001a\u00020Y2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0]H\u0002J\b\u0010^\u001a\u00020YH\u0002J\u000e\u0010_\u001a\b\u0012\u0004\u0012\u00020a0`H\u0002J\n\u0010b\u001a\u0004\u0018\u00010cH\u0002J\u0016\u0010d\u001a\u00020Y2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020hJ\u000e\u0010d\u001a\u00020Y2\u0006\u0010g\u001a\u00020hJ\u000e\u0010i\u001a\u00020Y2\u0006\u0010j\u001a\u00020kJJ\u0010l\u001a:\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020p\u0012\u0004\u0012\u00020Y0nj\u0002`q\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020Y0nj\u0002`s0m2\b\u0010t\u001a\u0004\u0018\u00010cH\u0002J(\u0010u\u001a\u00020Y2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00060`2\n\b\u0002\u0010w\u001a\u0004\u0018\u00010x2\u0006\u0010g\u001a\u00020yJ*\u0010z\u001a\u00020Y2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00060{2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020x0{2\u0006\u0010g\u001a\u00020yJ:\u0010z\u001a\u00020Y2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00060{2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020x0{2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020~0`2\u0006\u0010g\u001a\u00020yH\u0002J\u0013\u0010\u007f\u001a\u0004\u0018\u00010a2\u0007\u0010\u0080\u0001\u001a\u00020\u0006H\u0002JA\u0010\u0081\u0001\u001a:\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020p\u0012\u0004\u0012\u00020Y0nj\u0002`q\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020Y0nj\u0002`s0mH\u0002J\n\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\u0007\u0010\u0084\u0001\u001a\u00020YJ\u001d\u0010\u0085\u0001\u001a\u00020Y2\u0007\u0010\u0086\u0001\u001a\u00020\u00062\u000b\b\u0002\u0010g\u001a\u0005\u0018\u00010\u0087\u0001J\u0013\u0010\u0088\u0001\u001a\u00020Y2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010hJ\u0013\u0010\u0089\u0001\u001a\u00020Y2\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0016J\t\u0010\u008c\u0001\u001a\u00020YH\u0016J\t\u0010\u008d\u0001\u001a\u00020YH\u0016J\u0019\u0010\u008e\u0001\u001a\u00020Y2\b\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0006\u0010g\u001a\u00020aJ\u0007\u0010\u0091\u0001\u001a\u00020YJ`\u0010\u0092\u0001\u001a\u00020Y2\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u00062\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u00012\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0006\u00109\u001a\u00020\u00062\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010/2\u0007\u0010j\u001a\u00030\u009b\u0001H\u0002¢\u0006\u0003\u0010\u009c\u0001J\u000f\u0010\u009d\u0001\u001a\u00020Y2\u0006\u0010g\u001a\u00020hJ\u0012\u0010\u009e\u0001\u001a\u00020Y2\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010 \u0001\u001a\u00020Y2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010¢\u0001\u001a\u00020Y2\t\u0010£\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010¤\u0001\u001a\u00020Y2\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010¦\u0001\u001a\u00020Y2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u0006J\u001f\u0010¨\u0001\u001a\u00020Y2\u0016\u0010©\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060ª\u0001J\u0012\u0010«\u0001\u001a\u00020Y2\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u00ad\u0001\u001a\u00020Y2\t\u0010®\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010¯\u0001\u001a\u00020Y2\t\u0010°\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010±\u0001\u001a\u00020Y2\t\u0010²\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010³\u0001\u001a\u00020Y2\t\u0010´\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010µ\u0001\u001a\u00020Y2\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010·\u0001\u001a\u00020Y2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010¹\u0001\u001a\u00020Y2\t\u0010º\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010»\u0001\u001a\u00020Y2\t\u0010¼\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010½\u0001\u001a\u00020Y2\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010¿\u0001\u001a\u00020Y2\t\u0010À\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010Á\u0001\u001a\u00020Y2\t\u0010Â\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010Ã\u0001\u001a\u00020Y2\t\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010Å\u0001\u001a\u00020Y2\t\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010Ç\u0001\u001a\u00020Y2\t\u0010È\u0001\u001a\u0004\u0018\u00010\u0006J\u0012\u0010É\u0001\u001a\u00020/2\u0007\u0010Ê\u0001\u001a\u00020/H\u0002J!\u0010Ë\u0001\u001a\u00020Y2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u000e\u0010Ì\u0001\u001a\t\u0012\u0005\u0012\u00030Í\u00010`JD\u0010Î\u0001\u001a\u00020Y2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u00062\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u00012\u0006\u0010j\u001a\u00020cJT\u0010Ï\u0001\u001a\u00020Y2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u00062\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010/2\u0007\u0010Ð\u0001\u001a\u00020a¢\u0006\u0003\u0010Ñ\u0001J@\u0010Ò\u0001\u001a\u00020Y2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010/2\u0006\u0010j\u001a\u00020a¢\u0006\u0003\u0010Ó\u0001J\u0010\u0010Ô\u0001\u001a\u00020Y2\u0007\u0010\u0086\u0001\u001a\u00020\u0006J?\u0010Õ\u0001\u001a\u00020Y2\u0007\u0010Ö\u0001\u001a\u00020\u00062\u0007\u0010×\u0001\u001a\u00020\u00062\u0007\u0010Ø\u0001\u001a\u00020\u00062\t\u0010Ù\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010Ú\u0001\u001a\u0005\u0018\u00010Û\u0001¢\u0006\u0003\u0010Ü\u0001J\u0014\u0010Ý\u0001\u001a\u00020Y2\u000b\b\u0002\u0010j\u001a\u0005\u0018\u00010Þ\u0001J\t\u0010ß\u0001\u001a\u00020YH\u0002J\u0013\u0010à\u0001\u001a\u00020Y2\b\u0010á\u0001\u001a\u00030â\u0001H\u0007J\u001e\u0010ã\u0001\u001a\u00020Y2\u0006\u00109\u001a\u00020\u00062\u000b\b\u0002\u0010ä\u0001\u001a\u0004\u0018\u00010hH\u0002J\u0016\u0010[\u001a\u00020Y*\u00030\u009b\u00012\u0007\u0010å\u0001\u001a\u00020rH\u0002R$\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0011\u00109\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010<\u001a\u00020/2\u0006\u0010.\u001a\u00020/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b=\u00102\"\u0004\b>\u00104R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010?\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b?\u00102R\u001b\u0010@\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bB\u0010CR\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0019\u001a\u00020\u001a8\u0007¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010I\u001a\u00020H2\u0006\u0010.\u001a\u00020H8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020O8F¢\u0006\u0006\u001a\u0004\bP\u0010QR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010S\u001a\u0004\u0018\u00010R2\b\u0010.\u001a\u0004\u0018\u00010R8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006ç\u0001"}, d2 = {"Lcom/revenuecat/purchases/PurchasesOrchestrator;", "Lcom/revenuecat/purchases/LifecycleDelegate;", "Lcom/revenuecat/purchases/utils/CustomActivityLifecycleHandler;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "backingFieldAppUserID", "", "backend", "Lcom/revenuecat/purchases/common/Backend;", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "subscriberAttributesManager", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "customerInfoHelper", "Lcom/revenuecat/purchases/CustomerInfoHelper;", "customerInfoUpdateHandler", "Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;", "diagnosticsSynchronizer", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsSynchronizer;", "offlineEntitlementsManager", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "postReceiptHelper", "Lcom/revenuecat/purchases/PostReceiptHelper;", "postTransactionWithProductDetailsHelper", "Lcom/revenuecat/purchases/PostTransactionWithProductDetailsHelper;", "postPendingTransactionsHelper", "Lcom/revenuecat/purchases/PostPendingTransactionsHelper;", "syncPurchasesHelper", "Lcom/revenuecat/purchases/SyncPurchasesHelper;", "offeringsManager", "Lcom/revenuecat/purchases/common/offerings/OfferingsManager;", "paywallEventsManager", "Lcom/revenuecat/purchases/paywalls/events/PaywallEventsManager;", "paywallPresentedCache", "Lcom/revenuecat/purchases/paywalls/PaywallPresentedCache;", "purchasesStateCache", "Lcom/revenuecat/purchases/PurchasesStateCache;", "mainHandler", "Landroid/os/Handler;", "(Landroid/app/Application;Ljava/lang/String;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/CustomerInfoHelper;Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsSynchronizer;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;Lcom/revenuecat/purchases/PostReceiptHelper;Lcom/revenuecat/purchases/PostTransactionWithProductDetailsHelper;Lcom/revenuecat/purchases/PostPendingTransactionsHelper;Lcom/revenuecat/purchases/SyncPurchasesHelper;Lcom/revenuecat/purchases/common/offerings/OfferingsManager;Lcom/revenuecat/purchases/paywalls/events/PaywallEventsManager;Lcom/revenuecat/purchases/paywalls/PaywallPresentedCache;Lcom/revenuecat/purchases/PurchasesStateCache;Landroid/os/Handler;)V", "value", "", "allowSharingPlayStoreAccount", "getAllowSharingPlayStoreAccount", "()Z", "setAllowSharingPlayStoreAccount", "(Z)V", "getAppConfig", "()Lcom/revenuecat/purchases/common/AppConfig;", "setAppConfig", "(Lcom/revenuecat/purchases/common/AppConfig;)V", "appUserID", "getAppUserID", "()Ljava/lang/String;", "finishTransactions", "getFinishTransactions", "setFinishTransactions", "isAnonymous", "lifecycleHandler", "Lcom/revenuecat/purchases/AppLifecycleHandler;", "getLifecycleHandler", "()Lcom/revenuecat/purchases/AppLifecycleHandler;", "lifecycleHandler$delegate", "Lkotlin/Lazy;", "getOfflineEntitlementsManager", "()Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "Lcom/revenuecat/purchases/PurchasesState;", "state", "getState$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/PurchasesState;", "setState$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/PurchasesState;)V", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", "Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "updatedCustomerInfoListener", "getUpdatedCustomerInfoListener", "()Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "setUpdatedCustomerInfoListener", "(Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;)V", "close", "", "collectDeviceIdentifiers", "dispatch", "action", "Lkotlin/Function0;", "flushPaywallEvents", "getAndClearAllPurchaseCallbacks", "", "Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "getAndClearProductChangeCallback", "Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "getCustomerInfo", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "callback", "Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;", "getOfferings", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsCallback;", "getProductChangeCompletedCallbacks", "Landroid/util/Pair;", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/models/StoreTransaction;", "Lcom/revenuecat/purchases/CustomerInfo;", "Lcom/revenuecat/purchases/SuccessfulPurchaseCallback;", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/ErrorPurchaseCallback;", "productChangeListener", "getProducts", "productIds", "type", "Lcom/revenuecat/purchases/ProductType;", "Lcom/revenuecat/purchases/interfaces/GetStoreProductsCallback;", "getProductsOfTypes", "", "types", "collectedStoreProducts", "Lcom/revenuecat/purchases/models/StoreProduct;", "getPurchaseCallback", "productId", "getPurchaseCompletedCallbacks", "getPurchasesUpdatedListener", "Lcom/revenuecat/purchases/common/BillingAbstract$PurchasesUpdatedListener;", "invalidateCustomerInfoCache", "logIn", "newAppUserID", "Lcom/revenuecat/purchases/interfaces/LogInCallback;", "logOut", "onActivityStarted", "activity", "Landroid/app/Activity;", "onAppBackgrounded", "onAppForegrounded", "purchase", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams;", "removeUpdatedCustomerInfoListener", "replaceOldPurchaseWithNewProduct", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "oldProductId", "googleReplacementMode", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "isPersonalizedPrice", "Lcom/revenuecat/purchases/interfaces/PurchaseErrorCallback;", "(Lcom/revenuecat/purchases/models/PurchasingData;Ljava/lang/String;Lcom/revenuecat/purchases/models/GoogleReplacementMode;Landroid/app/Activity;Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Boolean;Lcom/revenuecat/purchases/interfaces/PurchaseErrorCallback;)V", "restorePurchases", "setAd", "ad", "setAdGroup", "adGroup", "setAdjustID", "adjustID", "setAirshipChannelID", "airshipChannelID", "setAppsflyerID", "appsflyerID", "setAttributes", "attributes", "", "setCampaign", Constants.ScionAnalytics.PARAM_CAMPAIGN, "setCleverTapID", "cleverTapID", "setCreative", "creative", "setDisplayName", "displayName", "setEmail", "email", "setFBAnonymousID", "fbAnonymousID", "setFirebaseAppInstanceID", "firebaseAppInstanceID", "setKeyword", "keyword", "setMediaSource", "mediaSource", "setMixpanelDistinctID", "mixpanelDistinctID", "setMparticleID", "mparticleID", "setOnesignalID", "onesignalID", "setOnesignalUserID", "onesignalUserID", "setPhoneNumber", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "setPushToken", "fcmToken", "shouldRefreshCustomerInfo", "firstTimeInForeground", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "startDeprecatedProductChange", "startProductChange", "purchaseCallback", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/String;Lcom/revenuecat/purchases/models/GoogleReplacementMode;Ljava/lang/Boolean;Lcom/revenuecat/purchases/interfaces/PurchaseCallback;)V", "startPurchase", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Boolean;Lcom/revenuecat/purchases/interfaces/PurchaseCallback;)V", "switchUser", "syncObserverModeAmazonPurchase", "productID", "receiptID", "amazonUserID", "isoCurrencyCode", b.x, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "syncPurchases", "Lcom/revenuecat/purchases/interfaces/SyncPurchasesCallback;", "synchronizeSubscriberAttributesIfNeeded", "track", "paywallEvent", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "updateAllCaches", "completion", "error", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PurchasesOrchestrator implements LifecycleDelegate, CustomActivityLifecycleHandler {
    public static final String frameworkVersion = "7.6.0";
    private static URL proxyURL;
    private AppConfig appConfig;
    private final Application application;
    private final Backend backend;
    private final BillingAbstract billing;
    private final CustomerInfoHelper customerInfoHelper;
    private final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    private final DeviceCache deviceCache;
    private final IdentityManager identityManager;

    /* renamed from: lifecycleHandler$delegate, reason: from kotlin metadata */
    private final Lazy lifecycleHandler;
    private final Handler mainHandler;
    private final OfferingsManager offeringsManager;
    private final OfflineEntitlementsManager offlineEntitlementsManager;
    private final PaywallEventsManager paywallEventsManager;
    private final PaywallPresentedCache paywallPresentedCache;
    private final PostPendingTransactionsHelper postPendingTransactionsHelper;
    private final PostReceiptHelper postReceiptHelper;
    private final PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper;
    private final PurchasesStateCache purchasesStateCache;
    private final SubscriberAttributesManager subscriberAttributesManager;
    private final SyncPurchasesHelper syncPurchasesHelper;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static PlatformInfo platformInfo = new PlatformInfo("native", null);

    public PurchasesOrchestrator(Application application, String str, Backend backend, BillingAbstract billing, DeviceCache deviceCache, IdentityManager identityManager, SubscriberAttributesManager subscriberAttributesManager, AppConfig appConfig, CustomerInfoHelper customerInfoHelper, CustomerInfoUpdateHandler customerInfoUpdateHandler, DiagnosticsSynchronizer diagnosticsSynchronizer, OfflineEntitlementsManager offlineEntitlementsManager, PostReceiptHelper postReceiptHelper, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, PostPendingTransactionsHelper postPendingTransactionsHelper, SyncPurchasesHelper syncPurchasesHelper, OfferingsManager offeringsManager, PaywallEventsManager paywallEventsManager, PaywallPresentedCache paywallPresentedCache, PurchasesStateCache purchasesStateCache, Handler handler) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(identityManager, "identityManager");
        Intrinsics.checkNotNullParameter(subscriberAttributesManager, "subscriberAttributesManager");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(customerInfoHelper, "customerInfoHelper");
        Intrinsics.checkNotNullParameter(customerInfoUpdateHandler, "customerInfoUpdateHandler");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(postReceiptHelper, "postReceiptHelper");
        Intrinsics.checkNotNullParameter(postTransactionWithProductDetailsHelper, "postTransactionWithProductDetailsHelper");
        Intrinsics.checkNotNullParameter(postPendingTransactionsHelper, "postPendingTransactionsHelper");
        Intrinsics.checkNotNullParameter(syncPurchasesHelper, "syncPurchasesHelper");
        Intrinsics.checkNotNullParameter(offeringsManager, "offeringsManager");
        Intrinsics.checkNotNullParameter(paywallPresentedCache, "paywallPresentedCache");
        Intrinsics.checkNotNullParameter(purchasesStateCache, "purchasesStateCache");
        this.application = application;
        this.backend = backend;
        this.billing = billing;
        this.deviceCache = deviceCache;
        this.identityManager = identityManager;
        this.subscriberAttributesManager = subscriberAttributesManager;
        this.appConfig = appConfig;
        this.customerInfoHelper = customerInfoHelper;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.postReceiptHelper = postReceiptHelper;
        this.postTransactionWithProductDetailsHelper = postTransactionWithProductDetailsHelper;
        this.postPendingTransactionsHelper = postPendingTransactionsHelper;
        this.syncPurchasesHelper = syncPurchasesHelper;
        this.offeringsManager = offeringsManager;
        this.paywallEventsManager = paywallEventsManager;
        this.paywallPresentedCache = paywallPresentedCache;
        this.purchasesStateCache = purchasesStateCache;
        this.mainHandler = handler;
        this.lifecycleHandler = LazyKt.lazy(new Function0<AppLifecycleHandler>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$lifecycleHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AppLifecycleHandler invoke() {
                return new AppLifecycleHandler(PurchasesOrchestrator.this);
            }
        });
        identityManager.configure(str);
        billing.setStateListener(new BillingAbstract.StateListener() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.1
            @Override // com.revenuecat.purchases.common.BillingAbstract.StateListener
            public void onConnected() {
                PostPendingTransactionsHelper.syncPendingPurchaseQueue$default(PurchasesOrchestrator.this.postPendingTransactionsHelper, PurchasesOrchestrator.this.getAllowSharingPlayStoreAccount(), null, null, 6, null);
                PurchasesOrchestrator.this.billing.getStorefront(new Function1<String, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$1$onConnected$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                        invoke2(str2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String countryCode) {
                        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
                        String format = String.format(BillingStrings.BILLING_COUNTRY_CODE, Arrays.copyOf(new Object[]{countryCode}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                        LogUtilsKt.debugLog(format);
                    }
                }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$1$onConnected$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                        invoke2(purchasesError);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PurchasesError error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        LogUtilsKt.errorLog(error);
                    }
                });
            }
        });
        billing.setPurchasesUpdatedListener(getPurchasesUpdatedListener());
        BillingAbstract.startConnectionOnMainThread$default(billing, 0L, 1, null);
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ProcessLifecycleOwner.get().getLifecycle().addObserver(PurchasesOrchestrator.this.getLifecycleHandler());
                PurchasesOrchestrator.this.application.registerActivityLifecycleCallbacks(PurchasesOrchestrator.this);
            }
        });
        if (!this.appConfig.getDangerousSettings().getAutoSyncPurchases()) {
            LogWrapperKt.log(LogIntent.WARNING, ConfigureStrings.AUTO_SYNC_PURCHASES_DISABLED);
        }
        if (AndroidVersionUtilsKt.isAndroidNOrNewer()) {
            if (diagnosticsSynchronizer != null) {
                diagnosticsSynchronizer.clearDiagnosticsFileIfTooBig();
            }
            if (diagnosticsSynchronizer != null) {
                diagnosticsSynchronizer.syncDiagnosticsFileIfNeeded();
            }
        }
    }

    @Override // com.revenuecat.purchases.utils.CustomActivityLifecycleHandler, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        CustomActivityLifecycleHandler.DefaultImpls.onActivityCreated(this, activity, bundle);
    }

    @Override // com.revenuecat.purchases.utils.CustomActivityLifecycleHandler, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        CustomActivityLifecycleHandler.DefaultImpls.onActivityDestroyed(this, activity);
    }

    @Override // com.revenuecat.purchases.utils.CustomActivityLifecycleHandler, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        CustomActivityLifecycleHandler.DefaultImpls.onActivityPaused(this, activity);
    }

    @Override // com.revenuecat.purchases.utils.CustomActivityLifecycleHandler, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        CustomActivityLifecycleHandler.DefaultImpls.onActivityResumed(this, activity);
    }

    @Override // com.revenuecat.purchases.utils.CustomActivityLifecycleHandler, android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        CustomActivityLifecycleHandler.DefaultImpls.onActivitySaveInstanceState(this, activity, bundle);
    }

    @Override // com.revenuecat.purchases.utils.CustomActivityLifecycleHandler, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        CustomActivityLifecycleHandler.DefaultImpls.onActivityStopped(this, activity);
    }

    public final AppConfig getAppConfig() {
        return this.appConfig;
    }

    public final void setAppConfig(AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(appConfig, "<set-?>");
        this.appConfig = appConfig;
    }

    public final OfflineEntitlementsManager getOfflineEntitlementsManager() {
        return this.offlineEntitlementsManager;
    }

    public /* synthetic */ PurchasesOrchestrator(Application application, String str, Backend backend, BillingAbstract billingAbstract, DeviceCache deviceCache, IdentityManager identityManager, SubscriberAttributesManager subscriberAttributesManager, AppConfig appConfig, CustomerInfoHelper customerInfoHelper, CustomerInfoUpdateHandler customerInfoUpdateHandler, DiagnosticsSynchronizer diagnosticsSynchronizer, OfflineEntitlementsManager offlineEntitlementsManager, PostReceiptHelper postReceiptHelper, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, PostPendingTransactionsHelper postPendingTransactionsHelper, SyncPurchasesHelper syncPurchasesHelper, OfferingsManager offeringsManager, PaywallEventsManager paywallEventsManager, PaywallPresentedCache paywallPresentedCache, PurchasesStateCache purchasesStateCache, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, str, backend, billingAbstract, deviceCache, identityManager, subscriberAttributesManager, appConfig, customerInfoHelper, customerInfoUpdateHandler, diagnosticsSynchronizer, offlineEntitlementsManager, postReceiptHelper, postTransactionWithProductDetailsHelper, postPendingTransactionsHelper, syncPurchasesHelper, offeringsManager, paywallEventsManager, paywallPresentedCache, purchasesStateCache, (i & 1048576) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }

    public final PurchasesState getState$purchases_defaultsRelease() {
        return this.purchasesStateCache.getPurchasesState();
    }

    public final void setState$purchases_defaultsRelease(PurchasesState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.purchasesStateCache.setPurchasesState(value);
    }

    public final synchronized boolean getFinishTransactions() {
        return this.appConfig.getFinishTransactions();
    }

    public final synchronized void setFinishTransactions(boolean z) {
        this.appConfig.setFinishTransactions(z);
    }

    public final synchronized String getAppUserID() {
        return this.identityManager.getCurrentAppUserID();
    }

    public final synchronized UpdatedCustomerInfoListener getUpdatedCustomerInfoListener() {
        return this.customerInfoUpdateHandler.getUpdatedCustomerInfoListener();
    }

    public final synchronized void setUpdatedCustomerInfoListener(UpdatedCustomerInfoListener updatedCustomerInfoListener) {
        this.customerInfoUpdateHandler.setUpdatedCustomerInfoListener(updatedCustomerInfoListener);
    }

    public final boolean isAnonymous() {
        return this.identityManager.currentUserIsAnonymous();
    }

    public final Store getStore() {
        return this.appConfig.getStore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppLifecycleHandler getLifecycleHandler() {
        return (AppLifecycleHandler) this.lifecycleHandler.getValue();
    }

    public final synchronized boolean getAllowSharingPlayStoreAccount() {
        Boolean allowSharingPlayStoreAccount;
        allowSharingPlayStoreAccount = getState$purchases_defaultsRelease().getAllowSharingPlayStoreAccount();
        return allowSharingPlayStoreAccount != null ? allowSharingPlayStoreAccount.booleanValue() : this.identityManager.currentUserIsAnonymous();
    }

    public final synchronized void setAllowSharingPlayStoreAccount(boolean z) {
        setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), Boolean.valueOf(z), null, null, false, false, 30, null));
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public void onAppBackgrounded() {
        synchronized (this) {
            setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, null, null, true, false, 23, null));
            Unit unit = Unit.INSTANCE;
        }
        LogWrapperKt.log(LogIntent.DEBUG, ConfigureStrings.APP_BACKGROUNDED);
        synchronizeSubscriberAttributesIfNeeded();
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public void onAppForegrounded() {
        boolean firstTimeInForeground;
        synchronized (this) {
            firstTimeInForeground = getState$purchases_defaultsRelease().getFirstTimeInForeground();
            setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, null, null, false, false, 7, null));
            Unit unit = Unit.INSTANCE;
        }
        LogWrapperKt.log(LogIntent.DEBUG, ConfigureStrings.APP_FOREGROUNDED);
        if (shouldRefreshCustomerInfo(firstTimeInForeground)) {
            LogWrapperKt.log(LogIntent.DEBUG, CustomerInfoStrings.CUSTOMERINFO_STALE_UPDATING_FOREGROUND);
            CustomerInfoHelper.retrieveCustomerInfo$default(this.customerInfoHelper, this.identityManager.getCurrentAppUserID(), CacheFetchPolicy.FETCH_CURRENT, false, getAllowSharingPlayStoreAccount(), null, 16, null);
        }
        this.offeringsManager.onAppForeground(this.identityManager.getCurrentAppUserID());
        PostPendingTransactionsHelper.syncPendingPurchaseQueue$default(this.postPendingTransactionsHelper, getAllowSharingPlayStoreAccount(), null, null, 6, null);
        synchronizeSubscriberAttributesIfNeeded();
        OfflineEntitlementsManager.updateProductEntitlementMappingCacheIfStale$default(this.offlineEntitlementsManager, null, 1, null);
        flushPaywallEvents();
    }

    @Override // com.revenuecat.purchases.utils.CustomActivityLifecycleHandler, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.appConfig.getShowInAppMessagesAutomatically()) {
            showInAppMessagesIfNeeded(activity, ArraysKt.toList(InAppMessageType.values()));
        }
    }

    public static /* synthetic */ void syncPurchases$default(PurchasesOrchestrator purchasesOrchestrator, SyncPurchasesCallback syncPurchasesCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            syncPurchasesCallback = null;
        }
        purchasesOrchestrator.syncPurchases(syncPurchasesCallback);
    }

    public final void syncPurchases(final SyncPurchasesCallback listener) {
        this.syncPurchasesHelper.syncPurchases(getAllowSharingPlayStoreAccount(), getState$purchases_defaultsRelease().getAppInBackground(), new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncPurchases$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                invoke2(customerInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CustomerInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SyncPurchasesCallback syncPurchasesCallback = SyncPurchasesCallback.this;
                if (syncPurchasesCallback != null) {
                    syncPurchasesCallback.onSuccess(it);
                }
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncPurchases$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SyncPurchasesCallback syncPurchasesCallback = SyncPurchasesCallback.this;
                if (syncPurchasesCallback != null) {
                    syncPurchasesCallback.onError(it);
                }
            }
        });
    }

    public final void syncObserverModeAmazonPurchase(String productID, final String receiptID, final String amazonUserID, final String isoCurrencyCode, final Double price) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(receiptID, "receiptID");
        Intrinsics.checkNotNullParameter(amazonUserID, "amazonUserID");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(PurchaseStrings.SYNCING_PURCHASE_STORE_USER_ID, Arrays.copyOf(new Object[]{receiptID, amazonUserID}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        Set<String> previouslySentHashedTokens = this.deviceCache.getPreviouslySentHashedTokens();
        if (!previouslySentHashedTokens.contains(UtilsKt.sha1(receiptID))) {
            previouslySentHashedTokens = null;
        }
        if (previouslySentHashedTokens != null) {
            LogIntent logIntent2 = LogIntent.DEBUG;
            String format2 = String.format(PurchaseStrings.SYNCING_PURCHASE_SKIPPING, Arrays.copyOf(new Object[]{receiptID, amazonUserID}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
            LogWrapperKt.log(logIntent2, format2);
            return;
        }
        final String currentAppUserID = this.identityManager.getCurrentAppUserID();
        this.billing.normalizePurchaseData(productID, receiptID, amazonUserID, new Function1<String, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncObserverModeAmazonPurchase$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String normalizedProductID) {
                Double d;
                PostReceiptHelper postReceiptHelper;
                Intrinsics.checkNotNullParameter(normalizedProductID, "normalizedProductID");
                List listOf = CollectionsKt.listOf(normalizedProductID);
                Double d2 = price;
                if (d2 != null) {
                    if (!(d2.doubleValue() == 0.0d)) {
                        d = d2;
                        String str = isoCurrencyCode;
                        ReceiptInfo receiptInfo = new ReceiptInfo(listOf, null, null, null, d, (str != null || StringsKt.isBlank(str)) ? null : str, null, 78, null);
                        postReceiptHelper = this.postReceiptHelper;
                        String str2 = receiptID;
                        String str3 = amazonUserID;
                        boolean allowSharingPlayStoreAccount = this.getAllowSharingPlayStoreAccount();
                        String str4 = currentAppUserID;
                        PostReceiptInitiationSource postReceiptInitiationSource = PostReceiptInitiationSource.RESTORE;
                        final String str5 = receiptID;
                        final String str6 = amazonUserID;
                        Function1<CustomerInfo, Unit> function1 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncObserverModeAmazonPurchase$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                                invoke2(customerInfo);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(CustomerInfo it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                String format3 = String.format(PurchaseStrings.PURCHASE_SYNCED_USER_ID, Arrays.copyOf(new Object[]{str5, str6}, 2));
                                Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
                                LogWrapperKt.log(LogIntent.PURCHASE, format3);
                            }
                        };
                        final String str7 = receiptID;
                        final String str8 = amazonUserID;
                        postReceiptHelper.postTokenWithoutConsuming(str2, str3, receiptInfo, allowSharingPlayStoreAccount, str4, null, postReceiptInitiationSource, function1, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncObserverModeAmazonPurchase$3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                                invoke2(purchasesError);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PurchasesError error) {
                                Intrinsics.checkNotNullParameter(error, "error");
                                String format3 = String.format(PurchaseStrings.SYNCING_PURCHASE_ERROR_DETAILS_USER_ID, Arrays.copyOf(new Object[]{str7, str8, error}, 3));
                                Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
                                LogWrapperKt.log(LogIntent.RC_ERROR, format3);
                            }
                        });
                    }
                }
                d = null;
                String str9 = isoCurrencyCode;
                ReceiptInfo receiptInfo2 = new ReceiptInfo(listOf, null, null, null, d, (str9 != null || StringsKt.isBlank(str9)) ? null : str9, null, 78, null);
                postReceiptHelper = this.postReceiptHelper;
                String str22 = receiptID;
                String str32 = amazonUserID;
                boolean allowSharingPlayStoreAccount2 = this.getAllowSharingPlayStoreAccount();
                String str42 = currentAppUserID;
                PostReceiptInitiationSource postReceiptInitiationSource2 = PostReceiptInitiationSource.RESTORE;
                final String str52 = receiptID;
                final String str62 = amazonUserID;
                Function1<CustomerInfo, Unit> function12 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncObserverModeAmazonPurchase$3.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                        invoke2(customerInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(CustomerInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        String format3 = String.format(PurchaseStrings.PURCHASE_SYNCED_USER_ID, Arrays.copyOf(new Object[]{str52, str62}, 2));
                        Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
                        LogWrapperKt.log(LogIntent.PURCHASE, format3);
                    }
                };
                final String str72 = receiptID;
                final String str82 = amazonUserID;
                postReceiptHelper.postTokenWithoutConsuming(str22, str32, receiptInfo2, allowSharingPlayStoreAccount2, str42, null, postReceiptInitiationSource2, function12, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncObserverModeAmazonPurchase$3.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                        invoke2(purchasesError);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PurchasesError error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        String format3 = String.format(PurchaseStrings.SYNCING_PURCHASE_ERROR_DETAILS_USER_ID, Arrays.copyOf(new Object[]{str72, str82, error}, 3));
                        Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
                        LogWrapperKt.log(LogIntent.RC_ERROR, format3);
                    }
                });
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncObserverModeAmazonPurchase$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                String format3 = String.format(PurchaseStrings.SYNCING_PURCHASE_ERROR_DETAILS_USER_ID, Arrays.copyOf(new Object[]{receiptID, amazonUserID, error}, 3));
                Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
                LogWrapperKt.log(LogIntent.RC_ERROR, format3);
            }
        });
    }

    public final void getOfferings(final ReceiveOfferingsCallback listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.offeringsManager.getOfferings(this.identityManager.getCurrentAppUserID(), getState$purchases_defaultsRelease().getAppInBackground(), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getOfferings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ReceiveOfferingsCallback.this.onError(it);
            }
        }, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getOfferings$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offerings offerings) {
                invoke2(offerings);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Offerings it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ReceiveOfferingsCallback.this.onReceived(it);
            }
        });
    }

    public static /* synthetic */ void getProducts$default(PurchasesOrchestrator purchasesOrchestrator, List list, ProductType productType, GetStoreProductsCallback getStoreProductsCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            productType = null;
        }
        purchasesOrchestrator.getProducts(list, productType, getStoreProductsCallback);
    }

    public final void getProducts(List<String> productIds, ProductType type, final GetStoreProductsCallback callback) {
        Set<? extends ProductType> of;
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (type == null || (of = SetsKt.setOf(type)) == null) {
            of = SetsKt.setOf((Object[]) new ProductType[]{ProductType.SUBS, ProductType.INAPP});
        }
        getProductsOfTypes(CollectionsKt.toSet(productIds), of, new GetStoreProductsCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProducts$1
            @Override // com.revenuecat.purchases.interfaces.GetStoreProductsCallback
            public void onReceived(List<? extends StoreProduct> storeProducts) {
                Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                GetStoreProductsCallback.this.onReceived(storeProducts);
            }

            @Override // com.revenuecat.purchases.interfaces.GetStoreProductsCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                GetStoreProductsCallback.this.onError(error);
            }
        });
    }

    public final void purchase(PurchaseParams purchaseParams, PurchaseCallback callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(purchaseParams, "purchaseParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String oldProductId = purchaseParams.getOldProductId();
        if (oldProductId != null) {
            startProductChange(purchaseParams.getActivity(), purchaseParams.getPurchasingData(), purchaseParams.getPresentedOfferingContext(), oldProductId, purchaseParams.getGoogleReplacementMode(), purchaseParams.getIsPersonalizedPrice(), callback);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            startPurchase(purchaseParams.getActivity(), purchaseParams.getPurchasingData(), purchaseParams.getPresentedOfferingContext(), purchaseParams.getIsPersonalizedPrice(), callback);
        }
    }

    public final void restorePurchases(final ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogWrapperKt.log(LogIntent.DEBUG, RestoreStrings.RESTORING_PURCHASE);
        if (!getAllowSharingPlayStoreAccount()) {
            LogWrapperKt.log(LogIntent.WARNING, RestoreStrings.SHARING_ACC_RESTORE_FALSE);
        }
        final String currentAppUserID = this.identityManager.getCurrentAppUserID();
        this.billing.queryAllPurchases(currentAppUserID, new Function1<List<? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreTransaction> list) {
                invoke2((List<StoreTransaction>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<StoreTransaction> allPurchases) {
                PostReceiptHelper postReceiptHelper;
                Intrinsics.checkNotNullParameter(allPurchases, "allPurchases");
                if (allPurchases.isEmpty()) {
                    PurchasesOrchestrator.this.getCustomerInfo(callback);
                    return;
                }
                final List<StoreTransaction> sortedWith = CollectionsKt.sortedWith(allPurchases, new Comparator() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$1$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((StoreTransaction) t).getPurchaseTime()), Long.valueOf(((StoreTransaction) t2).getPurchaseTime()));
                    }
                });
                final PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                String str = currentAppUserID;
                final ReceiveCustomerInfoCallback receiveCustomerInfoCallback = callback;
                for (final StoreTransaction storeTransaction : sortedWith) {
                    postReceiptHelper = purchasesOrchestrator.postReceiptHelper;
                    postReceiptHelper.postTransactionAndConsumeIfNeeded(storeTransaction, null, true, str, PostReceiptInitiationSource.RESTORE, new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$1$2$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction2, CustomerInfo customerInfo) {
                            invoke2(storeTransaction2, customerInfo);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(StoreTransaction storeTransaction2, final CustomerInfo info) {
                            Intrinsics.checkNotNullParameter(storeTransaction2, "<anonymous parameter 0>");
                            Intrinsics.checkNotNullParameter(info, "info");
                            LogIntent logIntent = LogIntent.DEBUG;
                            String format = String.format(RestoreStrings.PURCHASE_RESTORED, Arrays.copyOf(new Object[]{StoreTransaction.this}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                            LogWrapperKt.log(logIntent, format);
                            if (Intrinsics.areEqual(CollectionsKt.last((List) sortedWith), StoreTransaction.this)) {
                                PurchasesOrchestrator purchasesOrchestrator2 = purchasesOrchestrator;
                                final ReceiveCustomerInfoCallback receiveCustomerInfoCallback2 = receiveCustomerInfoCallback;
                                purchasesOrchestrator2.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$1$2$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        ReceiveCustomerInfoCallback.this.onReceived(info);
                                    }
                                });
                            }
                        }
                    }, new Function2<StoreTransaction, PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$1$2$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction2, PurchasesError purchasesError) {
                            invoke2(storeTransaction2, purchasesError);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(StoreTransaction storeTransaction2, final PurchasesError error) {
                            Intrinsics.checkNotNullParameter(storeTransaction2, "<anonymous parameter 0>");
                            Intrinsics.checkNotNullParameter(error, "error");
                            LogIntent logIntent = LogIntent.RC_ERROR;
                            String format = String.format(RestoreStrings.RESTORING_PURCHASE_ERROR, Arrays.copyOf(new Object[]{StoreTransaction.this, error}, 2));
                            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                            LogWrapperKt.log(logIntent, format);
                            if (Intrinsics.areEqual(CollectionsKt.last((List) sortedWith), StoreTransaction.this)) {
                                PurchasesOrchestrator purchasesOrchestrator2 = purchasesOrchestrator;
                                final ReceiveCustomerInfoCallback receiveCustomerInfoCallback2 = receiveCustomerInfoCallback;
                                purchasesOrchestrator2.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$1$2$1$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        ReceiveCustomerInfoCallback.this.onError(error);
                                    }
                                });
                            }
                        }
                    });
                }
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                final ReceiveCustomerInfoCallback receiveCustomerInfoCallback = callback;
                purchasesOrchestrator.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ReceiveCustomerInfoCallback.this.onError(error);
                    }
                });
            }
        });
    }

    public static /* synthetic */ void logIn$default(PurchasesOrchestrator purchasesOrchestrator, String str, LogInCallback logInCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            logInCallback = null;
        }
        purchasesOrchestrator.logIn(str, logInCallback);
    }

    public final void logIn(final String newAppUserID, final LogInCallback callback) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        Unit unit = null;
        if (Intrinsics.areEqual(currentAppUserID, newAppUserID)) {
            currentAppUserID = null;
        }
        if (currentAppUserID != null) {
            this.identityManager.logIn(newAppUserID, new Function2<CustomerInfo, Boolean, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$logIn$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo, Boolean bool) {
                    invoke(customerInfo, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final CustomerInfo customerInfo, final boolean z) {
                    OfferingsManager offeringsManager;
                    Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                    PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                    final LogInCallback logInCallback = callback;
                    final PurchasesOrchestrator purchasesOrchestrator2 = PurchasesOrchestrator.this;
                    purchasesOrchestrator.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$logIn$2$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            CustomerInfoUpdateHandler customerInfoUpdateHandler;
                            LogInCallback logInCallback2 = LogInCallback.this;
                            if (logInCallback2 != null) {
                                logInCallback2.onReceived(customerInfo, z);
                            }
                            customerInfoUpdateHandler = purchasesOrchestrator2.customerInfoUpdateHandler;
                            customerInfoUpdateHandler.notifyListeners(customerInfo);
                        }
                    });
                    offeringsManager = PurchasesOrchestrator.this.offeringsManager;
                    OfferingsManager.fetchAndCacheOfferings$default(offeringsManager, newAppUserID, PurchasesOrchestrator.this.getState$purchases_defaultsRelease().getAppInBackground(), null, null, 12, null);
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$logIn$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                    final LogInCallback logInCallback = callback;
                    purchasesOrchestrator.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$logIn$2$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            LogInCallback logInCallback2 = LogInCallback.this;
                            if (logInCallback2 != null) {
                                logInCallback2.onError(error);
                            }
                        }
                    });
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.customerInfoHelper.retrieveCustomerInfo(this.identityManager.getCurrentAppUserID(), CacheFetchPolicy.INSTANCE.m1080default(), getState$purchases_defaultsRelease().getAppInBackground(), getAllowSharingPlayStoreAccount(), ListenerConversionsCommonKt.receiveCustomerInfoCallback(new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$logIn$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                    invoke2(customerInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final CustomerInfo customerInfo) {
                    Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                    PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                    final LogInCallback logInCallback = callback;
                    purchasesOrchestrator.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$logIn$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            LogInCallback logInCallback2 = LogInCallback.this;
                            if (logInCallback2 != null) {
                                logInCallback2.onReceived(customerInfo, false);
                            }
                        }
                    });
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$logIn$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                    final LogInCallback logInCallback = callback;
                    purchasesOrchestrator.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$logIn$4.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            LogInCallback logInCallback2 = LogInCallback.this;
                            if (logInCallback2 != null) {
                                logInCallback2.onError(error);
                            }
                        }
                    });
                }
            }));
        }
    }

    public static /* synthetic */ void logOut$default(PurchasesOrchestrator purchasesOrchestrator, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchasesOrchestrator.logOut(receiveCustomerInfoCallback);
    }

    public final void logOut(final ReceiveCustomerInfoCallback callback) {
        this.identityManager.logOut(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$logOut$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError purchasesError) {
                IdentityManager identityManager;
                if (purchasesError != null) {
                    ReceiveCustomerInfoCallback receiveCustomerInfoCallback = ReceiveCustomerInfoCallback.this;
                    if (receiveCustomerInfoCallback != null) {
                        receiveCustomerInfoCallback.onError(purchasesError);
                        return;
                    }
                    return;
                }
                PurchasesOrchestrator purchasesOrchestrator = this;
                synchronized (purchasesOrchestrator) {
                    PurchasesState state$purchases_defaultsRelease = purchasesOrchestrator.getState$purchases_defaultsRelease();
                    Map emptyMap = Collections.emptyMap();
                    Intrinsics.checkNotNullExpressionValue(emptyMap, "emptyMap()");
                    purchasesOrchestrator.setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, null, emptyMap, null, false, false, 29, null));
                    Unit unit = Unit.INSTANCE;
                }
                PurchasesOrchestrator purchasesOrchestrator2 = this;
                identityManager = purchasesOrchestrator2.identityManager;
                purchasesOrchestrator2.updateAllCaches(identityManager.getCurrentAppUserID(), ReceiveCustomerInfoCallback.this);
            }
        });
    }

    public final void close() {
        synchronized (this) {
            PurchasesState state$purchases_defaultsRelease = getState$purchases_defaultsRelease();
            Map emptyMap = Collections.emptyMap();
            Intrinsics.checkNotNullExpressionValue(emptyMap, "emptyMap()");
            setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, null, emptyMap, null, false, false, 29, null));
            Unit unit = Unit.INSTANCE;
        }
        this.backend.close();
        this.billing.close();
        setUpdatedCustomerInfoListener(null);
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$close$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ProcessLifecycleOwner.get().getLifecycle().removeObserver(PurchasesOrchestrator.this.getLifecycleHandler());
            }
        });
    }

    public final void getCustomerInfo(ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        getCustomerInfo(CacheFetchPolicy.INSTANCE.m1080default(), callback);
    }

    public final void getCustomerInfo(CacheFetchPolicy fetchPolicy, ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.customerInfoHelper.retrieveCustomerInfo(this.identityManager.getCurrentAppUserID(), fetchPolicy, getState$purchases_defaultsRelease().getAppInBackground(), getAllowSharingPlayStoreAccount(), callback);
    }

    public final void removeUpdatedCustomerInfoListener() {
        setUpdatedCustomerInfoListener(null);
    }

    public final void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageTypes, "inAppMessageTypes");
        this.billing.showInAppMessagesIfNeeded(activity, inAppMessageTypes, new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$showInAppMessagesIfNeeded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PurchasesOrchestrator.syncPurchases$default(PurchasesOrchestrator.this, null, 1, null);
            }
        });
    }

    public final void invalidateCustomerInfoCache() {
        LogWrapperKt.log(LogIntent.DEBUG, CustomerInfoStrings.INVALIDATING_CUSTOMERINFO_CACHE);
        this.deviceCache.clearCustomerInfoCache(getAppUserID());
    }

    public final void getProductsOfTypes(Set<String> productIds, Set<? extends ProductType> types, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = new ArrayList();
        for (Object obj : types) {
            if (((ProductType) obj) != ProductType.UNKNOWN) {
                arrayList.add(obj);
            }
        }
        getProductsOfTypes(productIds, CollectionsKt.toSet(arrayList), CollectionsKt.emptyList(), callback);
    }

    public final void track(PaywallEvent paywallEvent) {
        PaywallEventsManager paywallEventsManager;
        Intrinsics.checkNotNullParameter(paywallEvent, "paywallEvent");
        this.paywallPresentedCache.receiveEvent(paywallEvent);
        if (!AndroidVersionUtilsKt.isAndroidNOrNewer() || (paywallEventsManager = this.paywallEventsManager) == null) {
            return;
        }
        paywallEventsManager.track(paywallEvent);
    }

    public final void setAttributes(Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAttributes"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttributes(attributes, getAppUserID());
    }

    public final void setEmail(String email) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setEmail"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.Email.INSTANCE, email, getAppUserID());
    }

    public final void setPhoneNumber(String phoneNumber) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setPhoneNumber"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.PhoneNumber.INSTANCE, phoneNumber, getAppUserID());
    }

    public final void setDisplayName(String displayName) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setDisplayName"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.DisplayName.INSTANCE, displayName, getAppUserID());
    }

    public final void setPushToken(String fcmToken) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setPushToken"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.FCMTokens.INSTANCE, fcmToken, getAppUserID());
    }

    public final void setMixpanelDistinctID(String mixpanelDistinctID) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setMixpanelDistinctID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.MixpanelDistinctId.INSTANCE, mixpanelDistinctID, getAppUserID());
    }

    public final void setOnesignalID(String onesignalID) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setOnesignalID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.OneSignal.INSTANCE, onesignalID, getAppUserID());
    }

    public final void setOnesignalUserID(String onesignalUserID) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setOnesignalUserID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.OneSignalUserId.INSTANCE, onesignalUserID, getAppUserID());
    }

    public final void setAirshipChannelID(String airshipChannelID) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAirshipChannelID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.Airship.INSTANCE, airshipChannelID, getAppUserID());
    }

    public final void setFirebaseAppInstanceID(String firebaseAppInstanceID) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setFirebaseAppInstanceID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.FirebaseAppInstanceId.INSTANCE, firebaseAppInstanceID, getAppUserID());
    }

    public final void collectDeviceIdentifiers() {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"collectDeviceIdentifiers"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.collectDeviceIdentifiers(getAppUserID(), this.application);
    }

    public final void setAdjustID(String adjustID) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAdjustID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Adjust.INSTANCE, adjustID, getAppUserID(), this.application);
    }

    public final void setAppsflyerID(String appsflyerID) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAppsflyerID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.AppsFlyer.INSTANCE, appsflyerID, getAppUserID(), this.application);
    }

    public final void setFBAnonymousID(String fbAnonymousID) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setFBAnonymousID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Facebook.INSTANCE, fbAnonymousID, getAppUserID(), this.application);
    }

    public final void setMparticleID(String mparticleID) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setMparticleID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Mparticle.INSTANCE, mparticleID, getAppUserID(), this.application);
    }

    public final void setCleverTapID(String cleverTapID) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setCleverTapID"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.CleverTap.INSTANCE, cleverTapID, getAppUserID(), this.application);
    }

    public final void setMediaSource(String mediaSource) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setMediaSource"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.MediaSource.INSTANCE, mediaSource, getAppUserID());
    }

    public final void setCampaign(String campaign) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setCampaign"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Campaign.INSTANCE, campaign, getAppUserID());
    }

    public final void setAdGroup(String adGroup) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAdGroup"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.AdGroup.INSTANCE, adGroup, getAppUserID());
    }

    public final void setAd(String ad) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAd"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Ad.INSTANCE, ad, getAppUserID());
    }

    public final void setKeyword(String keyword) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"seKeyword"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Keyword.INSTANCE, keyword, getAppUserID());
    }

    public final void setCreative(String creative) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setCreative"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Creative.INSTANCE, creative, getAppUserID());
    }

    public final void switchUser(String newAppUserID) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        if (Intrinsics.areEqual(this.identityManager.getCurrentAppUserID(), newAppUserID)) {
            String format = String.format(IdentityStrings.SWITCHING_USER_SAME_APP_USER_ID, Arrays.copyOf(new Object[]{newAppUserID}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogUtilsKt.warnLog(format);
        } else {
            this.identityManager.switchUser(newAppUserID);
            OfferingsManager.fetchAndCacheOfferings$default(this.offeringsManager, newAppUserID, getState$purchases_defaultsRelease().getAppInBackground(), null, null, 12, null);
        }
    }

    private final boolean shouldRefreshCustomerInfo(boolean firstTimeInForeground) {
        if (this.appConfig.getCustomEntitlementComputation()) {
            return false;
        }
        return firstTimeInForeground || this.deviceCache.isCustomerInfoCacheStale(getAppUserID(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getProductsOfTypes(final Set<String> productIds, Set<? extends ProductType> types, final List<? extends StoreProduct> collectedStoreProducts, final GetStoreProductsCallback callback) {
        final Set mutableSet = CollectionsKt.toMutableSet(types);
        ProductType productType = (ProductType) CollectionsKt.firstOrNull(mutableSet);
        Unit unit = null;
        if (productType != null) {
            mutableSet.remove(productType);
        } else {
            productType = null;
        }
        if (productType != null) {
            this.billing.queryProductDetailsAsync(productType, productIds, new Function1<List<? extends StoreProduct>, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductsOfTypes$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreProduct> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final List<? extends StoreProduct> storeProducts) {
                    Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                    PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                    final PurchasesOrchestrator purchasesOrchestrator2 = PurchasesOrchestrator.this;
                    final Set<String> set = productIds;
                    final Set<ProductType> set2 = mutableSet;
                    final List<StoreProduct> list = collectedStoreProducts;
                    final GetStoreProductsCallback getStoreProductsCallback = callback;
                    purchasesOrchestrator.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductsOfTypes$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            PurchasesOrchestrator.this.getProductsOfTypes(set, set2, CollectionsKt.plus((Collection) list, (Iterable) storeProducts), getStoreProductsCallback);
                        }
                    });
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductsOfTypes$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final PurchasesError it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                    final GetStoreProductsCallback getStoreProductsCallback = callback;
                    purchasesOrchestrator.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductsOfTypes$1$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            GetStoreProductsCallback.this.onError(it);
                        }
                    });
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            callback.onReceived(collectedStoreProducts);
        }
    }

    static /* synthetic */ void updateAllCaches$default(PurchasesOrchestrator purchasesOrchestrator, String str, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchasesOrchestrator.updateAllCaches(str, receiveCustomerInfoCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAllCaches(String appUserID, ReceiveCustomerInfoCallback completion) {
        boolean appInBackground = getState$purchases_defaultsRelease().getAppInBackground();
        this.customerInfoHelper.retrieveCustomerInfo(appUserID, CacheFetchPolicy.FETCH_CURRENT, appInBackground, getAllowSharingPlayStoreAccount(), completion);
        OfferingsManager.fetchAndCacheOfferings$default(this.offeringsManager, appUserID, appInBackground, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatch(final Function0<Unit> action) {
        if (!Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            Handler handler = this.mainHandler;
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PurchasesOrchestrator.dispatch$lambda$16(Function0.this);
                }
            });
            return;
        }
        action.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatch$lambda$16(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PurchaseCallback getPurchaseCallback(String productId) {
        PurchaseCallback purchaseCallback = getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId().get(productId);
        PurchasesState state$purchases_defaultsRelease = getState$purchases_defaultsRelease();
        Map<String, PurchaseCallback> purchaseCallbacksByProductId = getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, PurchaseCallback> entry : purchaseCallbacksByProductId.entrySet()) {
            if (!Intrinsics.areEqual(entry.getKey(), productId)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, null, linkedHashMap, null, false, false, 29, null));
        return purchaseCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProductChangeCallback getAndClearProductChangeCallback() {
        ProductChangeCallback deprecatedProductChangeCallback = getState$purchases_defaultsRelease().getDeprecatedProductChangeCallback();
        setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, null, null, false, false, 27, null));
        return deprecatedProductChangeCallback;
    }

    private final BillingAbstract.PurchasesUpdatedListener getPurchasesUpdatedListener() {
        return new BillingAbstract.PurchasesUpdatedListener() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getPurchasesUpdatedListener$1
            @Override // com.revenuecat.purchases.common.BillingAbstract.PurchasesUpdatedListener
            public void onPurchasesUpdated(List<StoreTransaction> purchases) {
                Pair purchaseCompletedCallbacks;
                PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper;
                ProductChangeCallback andClearProductChangeCallback;
                Intrinsics.checkNotNullParameter(purchases, "purchases");
                PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                synchronized (purchasesOrchestrator) {
                    if (purchasesOrchestrator.getState$purchases_defaultsRelease().getDeprecatedProductChangeCallback() != null) {
                        andClearProductChangeCallback = purchasesOrchestrator.getAndClearProductChangeCallback();
                        purchaseCompletedCallbacks = purchasesOrchestrator.getProductChangeCompletedCallbacks(andClearProductChangeCallback);
                    } else {
                        purchaseCompletedCallbacks = purchasesOrchestrator.getPurchaseCompletedCallbacks();
                    }
                    Unit unit = Unit.INSTANCE;
                }
                postTransactionWithProductDetailsHelper = PurchasesOrchestrator.this.postTransactionWithProductDetailsHelper;
                postTransactionWithProductDetailsHelper.postTransactions(purchases, PurchasesOrchestrator.this.getAllowSharingPlayStoreAccount(), PurchasesOrchestrator.this.getAppUserID(), PostReceiptInitiationSource.PURCHASE, (Function2) purchaseCompletedCallbacks.first, (Function2) purchaseCompletedCallbacks.second);
            }

            @Override // com.revenuecat.purchases.common.BillingAbstract.PurchasesUpdatedListener
            public void onPurchasesFailedToUpdate(PurchasesError purchasesError) {
                ProductChangeCallback andClearProductChangeCallback;
                Unit unit;
                List andClearAllPurchaseCallbacks;
                Intrinsics.checkNotNullParameter(purchasesError, "purchasesError");
                PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                synchronized (purchasesOrchestrator) {
                    andClearProductChangeCallback = purchasesOrchestrator.getAndClearProductChangeCallback();
                    if (andClearProductChangeCallback != null) {
                        purchasesOrchestrator.dispatch(andClearProductChangeCallback, purchasesError);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        andClearAllPurchaseCallbacks = purchasesOrchestrator.getAndClearAllPurchaseCallbacks();
                        Iterator it = andClearAllPurchaseCallbacks.iterator();
                        while (it.hasNext()) {
                            purchasesOrchestrator.dispatch((PurchaseCallback) it.next(), purchasesError);
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<PurchaseCallback> getAndClearAllPurchaseCallbacks() {
        List<PurchaseCallback> list;
        synchronized (this) {
            Map<String, PurchaseCallback> purchaseCallbacksByProductId = getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId();
            PurchasesState state$purchases_defaultsRelease = getState$purchases_defaultsRelease();
            Map emptyMap = Collections.emptyMap();
            Intrinsics.checkNotNullExpressionValue(emptyMap, "emptyMap()");
            setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, null, emptyMap, null, false, false, 29, null));
            list = CollectionsKt.toList(purchaseCallbacksByProductId.values());
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Function2<StoreTransaction, CustomerInfo, Unit>, Function2<StoreTransaction, PurchasesError, Unit>> getPurchaseCompletedCallbacks() {
        return new Pair<>(new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                invoke2(storeTransaction, customerInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final StoreTransaction storeTransaction, final CustomerInfo info) {
                final PurchaseCallback purchaseCallback;
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                Intrinsics.checkNotNullParameter(info, "info");
                purchaseCallback = PurchasesOrchestrator.this.getPurchaseCallback(storeTransaction.getProductIds().get(0));
                if (purchaseCallback != null) {
                    PurchasesOrchestrator.this.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            PurchaseCallback.this.onCompleted(storeTransaction, info);
                        }
                    });
                }
            }
        }, new Function2<StoreTransaction, PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getPurchaseCompletedCallbacks$onError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, PurchasesError purchasesError) {
                invoke2(storeTransaction, purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoreTransaction purchase, PurchasesError error) {
                PurchaseCallback purchaseCallback;
                Intrinsics.checkNotNullParameter(purchase, "purchase");
                Intrinsics.checkNotNullParameter(error, "error");
                purchaseCallback = PurchasesOrchestrator.this.getPurchaseCallback(purchase.getProductIds().get(0));
                if (purchaseCallback != null) {
                    PurchasesOrchestrator.this.dispatch(purchaseCallback, error);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Function2<StoreTransaction, CustomerInfo, Unit>, Function2<StoreTransaction, PurchasesError, Unit>> getProductChangeCompletedCallbacks(final ProductChangeCallback productChangeListener) {
        return new Pair<>(new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductChangeCompletedCallbacks$onSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                invoke2(storeTransaction, customerInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final StoreTransaction storeTransaction, final CustomerInfo info) {
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                Intrinsics.checkNotNullParameter(info, "info");
                final ProductChangeCallback productChangeCallback = ProductChangeCallback.this;
                if (productChangeCallback != null) {
                    this.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductChangeCompletedCallbacks$onSuccess$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ProductChangeCallback.this.onCompleted(storeTransaction, info);
                        }
                    });
                }
            }
        }, new Function2<StoreTransaction, PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductChangeCompletedCallbacks$onError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, PurchasesError purchasesError) {
                invoke2(storeTransaction, purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoreTransaction storeTransaction, PurchasesError error) {
                Intrinsics.checkNotNullParameter(storeTransaction, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(error, "error");
                ProductChangeCallback productChangeCallback = ProductChangeCallback.this;
                if (productChangeCallback != null) {
                    this.dispatch(productChangeCallback, error);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatch(final PurchaseErrorCallback purchaseErrorCallback, final PurchasesError purchasesError) {
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$dispatch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PurchaseErrorCallback purchaseErrorCallback2 = PurchaseErrorCallback.this;
                PurchasesError purchasesError2 = purchasesError;
                purchaseErrorCallback2.onError(purchasesError2, purchasesError2.getCode() == PurchasesErrorCode.PurchaseCancelledError);
            }
        });
    }

    public final void startPurchase(Activity activity, PurchasingData purchasingData, PresentedOfferingContext presentedOfferingContext, Boolean isPersonalizedPrice, PurchaseCallback listener) {
        String str;
        String str2;
        Unit unit;
        String offeringIdentifier;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(purchasingData, "purchasingData");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LogIntent logIntent = LogIntent.PURCHASE;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(purchasingData);
        sb.append(' ');
        if (presentedOfferingContext == null || (offeringIdentifier = presentedOfferingContext.getOfferingIdentifier()) == null) {
            str = null;
        } else {
            str = PurchaseStrings.OFFERING + offeringIdentifier;
        }
        sb.append(str);
        objArr[0] = sb.toString();
        String format = String.format(PurchaseStrings.PURCHASE_STARTED, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        synchronized (this) {
            if (!this.appConfig.getFinishTransactions()) {
                LogWrapperKt.log(LogIntent.WARNING, PurchaseStrings.PURCHASE_FINISH_TRANSACTION_FALSE);
            }
            if (getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId().containsKey(purchasingData.getProductId())) {
                str2 = null;
            } else {
                setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, MapsKt.plus(getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId(), MapsKt.mapOf(TuplesKt.to(purchasingData.getProductId(), listener))), null, false, false, 29, null));
                str2 = this.identityManager.getCurrentAppUserID();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        if (str2 != null) {
            this.billing.makePurchaseAsync(activity, str2, purchasingData, null, presentedOfferingContext, isPersonalizedPrice);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.OperationAlreadyInProgressError, null, 2, null);
            LogUtilsKt.errorLog(purchasesError);
            Unit unit3 = Unit.INSTANCE;
            dispatch(listener, purchasesError);
        }
    }

    public final void startProductChange(Activity activity, PurchasingData purchasingData, PresentedOfferingContext presentedOfferingContext, String oldProductId, GoogleReplacementMode googleReplacementMode, Boolean isPersonalizedPrice, PurchaseCallback purchaseCallback) {
        String str;
        String str2;
        Unit unit;
        String offeringIdentifier;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(purchasingData, "purchasingData");
        Intrinsics.checkNotNullParameter(oldProductId, "oldProductId");
        Intrinsics.checkNotNullParameter(googleReplacementMode, "googleReplacementMode");
        Intrinsics.checkNotNullParameter(purchaseCallback, "purchaseCallback");
        if (purchasingData.getProductType() != ProductType.SUBS) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PurchaseNotAllowedError, PurchaseStrings.UPGRADING_INVALID_TYPE);
            LogUtilsKt.errorLog(purchasesError);
            Unit unit2 = Unit.INSTANCE;
            dispatch(purchaseCallback, purchasesError);
            return;
        }
        LogIntent logIntent = LogIntent.PURCHASE;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(purchasingData);
        sb.append(' ');
        if (presentedOfferingContext == null || (offeringIdentifier = presentedOfferingContext.getOfferingIdentifier()) == null) {
            str = null;
        } else {
            str = PurchaseStrings.OFFERING + offeringIdentifier;
        }
        sb.append(str);
        sb.append(" oldProductId: ");
        sb.append(oldProductId);
        sb.append(" googleReplacementMode ");
        sb.append(googleReplacementMode);
        objArr[0] = sb.toString();
        String format = String.format(PurchaseStrings.PRODUCT_CHANGE_STARTED, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        synchronized (this) {
            if (!this.appConfig.getFinishTransactions()) {
                LogWrapperKt.log(LogIntent.WARNING, PurchaseStrings.PURCHASE_FINISH_TRANSACTION_FALSE);
            }
            if (getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId().containsKey(purchasingData.getProductId())) {
                str2 = null;
            } else {
                setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, MapsKt.plus(getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId(), MapsKt.mapOf(TuplesKt.to(purchasingData.getProductId(), purchaseCallback))), null, false, false, 29, null));
                str2 = this.identityManager.getCurrentAppUserID();
            }
            Unit unit3 = Unit.INSTANCE;
        }
        if (str2 != null) {
            replaceOldPurchaseWithNewProduct(purchasingData, oldProductId, googleReplacementMode, activity, str2, presentedOfferingContext, isPersonalizedPrice, purchaseCallback);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.OperationAlreadyInProgressError, null, 2, null);
            LogUtilsKt.errorLog(purchasesError2);
            Iterator<T> it = getAndClearAllPurchaseCallbacks().iterator();
            while (it.hasNext()) {
                dispatch((PurchaseCallback) it.next(), purchasesError2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final void startDeprecatedProductChange(Activity activity, PurchasingData purchasingData, PresentedOfferingContext presentedOfferingContext, String oldProductId, GoogleReplacementMode googleReplacementMode, ProductChangeCallback listener) {
        String str;
        String str2;
        ?? r0;
        String offeringIdentifier;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(purchasingData, "purchasingData");
        Intrinsics.checkNotNullParameter(oldProductId, "oldProductId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (purchasingData.getProductType() != ProductType.SUBS) {
            getAndClearProductChangeCallback();
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PurchaseNotAllowedError, PurchaseStrings.UPGRADING_INVALID_TYPE);
            LogUtilsKt.errorLog(purchasesError);
            Unit unit = Unit.INSTANCE;
            dispatch(listener, purchasesError);
            return;
        }
        LogIntent logIntent = LogIntent.PURCHASE;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(purchasingData);
        sb.append(' ');
        Unit unit2 = null;
        if (presentedOfferingContext == null || (offeringIdentifier = presentedOfferingContext.getOfferingIdentifier()) == null) {
            str = null;
        } else {
            str = PurchaseStrings.OFFERING + offeringIdentifier;
        }
        sb.append(str);
        sb.append(" oldProductId: ");
        sb.append(oldProductId);
        sb.append(" googleReplacementMode ");
        sb.append(googleReplacementMode);
        objArr[0] = sb.toString();
        String format = String.format(PurchaseStrings.PRODUCT_CHANGE_STARTED, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        synchronized (this) {
            if (!this.appConfig.getFinishTransactions()) {
                LogWrapperKt.log(LogIntent.WARNING, PurchaseStrings.PURCHASE_FINISH_TRANSACTION_FALSE);
            }
            if (getState$purchases_defaultsRelease().getDeprecatedProductChangeCallback() == null) {
                setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, null, listener, false, false, 27, null));
                str2 = this.identityManager.getCurrentAppUserID();
            } else {
                str2 = null;
            }
            Unit unit3 = Unit.INSTANCE;
        }
        if (str2 != null) {
            r0 = 0;
            replaceOldPurchaseWithNewProduct(purchasingData, oldProductId, googleReplacementMode, activity, str2, presentedOfferingContext, null, listener);
            unit2 = Unit.INSTANCE;
        } else {
            r0 = 0;
        }
        if (unit2 == null) {
            getAndClearProductChangeCallback();
            PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.OperationAlreadyInProgressError, r0, 2, r0);
            LogUtilsKt.errorLog(purchasesError2);
            Unit unit4 = Unit.INSTANCE;
            dispatch(listener, purchasesError2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, java.lang.String] */
    private final void replaceOldPurchaseWithNewProduct(final PurchasingData purchasingData, String oldProductId, final GoogleReplacementMode googleReplacementMode, final Activity activity, final String appUserID, final PresentedOfferingContext presentedOfferingContext, final Boolean isPersonalizedPrice, final PurchaseErrorCallback listener) {
        if (purchasingData.getProductType() != ProductType.SUBS) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PurchaseNotAllowedError, PurchaseStrings.UPGRADING_INVALID_TYPE);
            LogUtilsKt.errorLog(purchasesError);
            ProductChangeCallback andClearProductChangeCallback = getAndClearProductChangeCallback();
            if (andClearProductChangeCallback != null) {
                dispatch(andClearProductChangeCallback, purchasesError);
            }
            Iterator<T> it = getAndClearAllPurchaseCallbacks().iterator();
            while (it.hasNext()) {
                dispatch((PurchaseCallback) it.next(), purchasesError);
            }
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = oldProductId;
        if (StringsKt.contains$default((CharSequence) oldProductId, (CharSequence) com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
            objectRef.element = StringsKt.substringBefore$default(oldProductId, com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, (String) null, 2, (Object) null);
            LogUtilsKt.warnLog("Using incorrect oldProductId: " + oldProductId + ". The productId should not contain the basePlanId. Using productId: " + ((String) objectRef.element) + '.');
        }
        this.billing.findPurchaseInPurchaseHistory(appUserID, ProductType.SUBS, (String) objectRef.element, new Function1<StoreTransaction, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction) {
                invoke2(storeTransaction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoreTransaction purchaseRecord) {
                Intrinsics.checkNotNullParameter(purchaseRecord, "purchaseRecord");
                LogIntent logIntent = LogIntent.PURCHASE;
                String format = String.format(PurchaseStrings.FOUND_EXISTING_PURCHASE, Arrays.copyOf(new Object[]{objectRef.element}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogWrapperKt.log(logIntent, format);
                this.billing.makePurchaseAsync(activity, appUserID, purchasingData, new ReplaceProductInfo(purchaseRecord, googleReplacementMode), presentedOfferingContext, isPersonalizedPrice);
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError2) {
                invoke2(purchasesError2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                LogWrapperKt.log(LogIntent.GOOGLE_ERROR, error.toString());
                PurchasesOrchestrator.this.getAndClearProductChangeCallback();
                PurchasesOrchestrator.this.getAndClearAllPurchaseCallbacks();
                PurchasesOrchestrator.this.dispatch(listener, error);
            }
        });
    }

    private final void synchronizeSubscriberAttributesIfNeeded() {
        SubscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers$default(this.subscriberAttributesManager, getAppUserID(), null, 2, null);
    }

    private final void flushPaywallEvents() {
        PaywallEventsManager paywallEventsManager;
        if (!AndroidVersionUtilsKt.isAndroidNOrNewer() || (paywallEventsManager = this.paywallEventsManager) == null) {
            return;
        }
        paywallEventsManager.flushEvents();
    }

    /* compiled from: PurchasesOrchestrator.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040,R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006-"}, d2 = {"Lcom/revenuecat/purchases/PurchasesOrchestrator$Companion;", "", "()V", "value", "", "debugLogsEnabled", "getDebugLogsEnabled", "()Z", "setDebugLogsEnabled", "(Z)V", "frameworkVersion", "", "Lcom/revenuecat/purchases/LogHandler;", "logHandler", "getLogHandler", "()Lcom/revenuecat/purchases/LogHandler;", "setLogHandler", "(Lcom/revenuecat/purchases/LogHandler;)V", "Lcom/revenuecat/purchases/LogLevel;", "logLevel", "getLogLevel", "()Lcom/revenuecat/purchases/LogLevel;", "setLogLevel", "(Lcom/revenuecat/purchases/LogLevel;)V", "platformInfo", "Lcom/revenuecat/purchases/common/PlatformInfo;", "getPlatformInfo", "()Lcom/revenuecat/purchases/common/PlatformInfo;", "setPlatformInfo", "(Lcom/revenuecat/purchases/common/PlatformInfo;)V", "proxyURL", "Ljava/net/URL;", "getProxyURL", "()Ljava/net/URL;", "setProxyURL", "(Ljava/net/URL;)V", "canMakePayments", "", "context", "Landroid/content/Context;", "features", "", "Lcom/revenuecat/purchases/models/BillingFeature;", "callback", "Lcom/revenuecat/purchases/interfaces/Callback;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlatformInfo getPlatformInfo() {
            return PurchasesOrchestrator.platformInfo;
        }

        public final void setPlatformInfo(PlatformInfo platformInfo) {
            Intrinsics.checkNotNullParameter(platformInfo, "<set-?>");
            PurchasesOrchestrator.platformInfo = platformInfo;
        }

        public final boolean getDebugLogsEnabled() {
            return LogUtilsKt.getDebugLogsEnabled(getLogLevel());
        }

        public final void setDebugLogsEnabled(boolean z) {
            setLogLevel(LogUtilsKt.debugLogsEnabled(LogLevel.INSTANCE, z));
        }

        public final LogLevel getLogLevel() {
            return Config.INSTANCE.getLogLevel();
        }

        public final void setLogLevel(LogLevel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Config.INSTANCE.setLogLevel(value);
        }

        public final synchronized LogHandler getLogHandler() {
            return LogWrapperKt.getCurrentLogHandler();
        }

        public final synchronized void setLogHandler(LogHandler value) {
            Intrinsics.checkNotNullParameter(value, "value");
            LogWrapperKt.setCurrentLogHandler(value);
        }

        public final URL getProxyURL() {
            return PurchasesOrchestrator.proxyURL;
        }

        public final void setProxyURL(URL url) {
            PurchasesOrchestrator.proxyURL = url;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void canMakePayments$default(Companion companion, Context context, List list, Callback callback, int i, Object obj) {
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            companion.canMakePayments(context, list, callback);
        }

        public final void canMakePayments(Context context, List<? extends BillingFeature> features, Callback<Boolean> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(features, "features");
            Intrinsics.checkNotNullParameter(callback, "callback");
            BillingClient build = BillingClient.newBuilder(context).enablePendingPurchases().setListener(new PurchasesUpdatedListener() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$Companion$$ExternalSyntheticLambda0
                @Override // com.android.billingclient.api.PurchasesUpdatedListener
                public final void onPurchasesUpdated(BillingResult billingResult, List list) {
                    Intrinsics.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
                }
            }).build();
            build.startConnection(new PurchasesOrchestrator$Companion$canMakePayments$2$1(new Handler(context.getMainLooper()), callback, build, features));
        }
    }
}
