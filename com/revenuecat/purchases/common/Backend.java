package com.revenuecat.purchases.common;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.a.a.o.b;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.models.GoogleProrationMode;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.events.PaywallEventRequest;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.utils.JsonElementExtensionsKt;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Backend.kt */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 z2\u00020\u0001:\u0001zB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010H\u001a\u00020\u0013J\u0006\u0010I\u001a\u00020\u0013J\u0018\u0010J\u001a\u0002082\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u0015H\u0002JS\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020!2\u0006\u0010P\u001a\u00020\u00162\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112'\u0010R\u001a#\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u0014JS\u0010S\u001a\u00020\u00132\u0006\u0010O\u001a\u00020!2\u0006\u0010P\u001a\u00020\u00162\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00130\u00112'\u0010R\u001a#\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u0014J.\u0010T\u001a\u00020\u00132\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u00130\u00112\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u0011JD\u0010W\u001a\u00020\u00132\u0006\u0010O\u001a\u00020!2\u0006\u0010X\u001a\u00020!2\u0018\u0010U\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u00142\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u0011JB\u0010Y\u001a\u00020\u00132\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020#0 2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00130\u00112\u0018\u0010V\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u0014JV\u0010[\u001a\u00020\u00132\u0006\u0010\\\u001a\u00020]2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00130026\u0010V\u001a2\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(^\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u00130\u0014H\u0007Jé\u0001\u0010`\u001a\u00020\u00132\u0006\u0010a\u001a\u00020!2\u0006\u0010O\u001a\u00020!2\u0006\u0010b\u001a\u00020\u00162\u0006\u0010c\u001a\u00020\u00162 \u0010d\u001a\u001c\u0012\u0004\u0012\u00020!\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\u00010e0e2\u0006\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010!2\u0006\u0010j\u001a\u00020k2\b\u0010l\u001a\u0004\u0018\u00010m2+\u0010Q\u001a'\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u00130\u0014j\u0002`62B\u0010R\u001a>\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u001108¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(9\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u001307j\u0002`:Jl\u0010n\u001a\u00020\u0013\"\u0004\b\u0000\u0010o\"\u0004\b\u0001\u0010p* \u0012\u0004\u0012\u00020\u000e\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002Ho\u0012\u0004\u0012\u0002Hp0\u00100\u000f0\r2\u0006\u0010q\u001a\u00020r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010s\u001a\u00020\u000e2\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u0002Ho\u0012\u0004\u0012\u0002Hp0\u00102\b\b\u0002\u0010u\u001a\u00020vH\u0002Jw\u0010w\u001a\u00020\u0013\"\u0004\b\u0000\u0010x\"\u0004\b\u0001\u0010o\"\u0004\b\u0002\u0010p* \u0012\u0004\u0012\u0002Hx\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002Ho\u0012\u0004\u0012\u0002Hp0\u00100\u000f0\r2\u0006\u0010q\u001a\u00020r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010s\u001a\u0002Hx2\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u0002Ho\u0012\u0004\u0012\u0002Hp0\u00102\b\b\u0002\u0010u\u001a\u00020vH\u0002¢\u0006\u0002\u0010yR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000RÄ\u0001\u0010\u001b\u001aQ\u0012\u0004\u0012\u00020\u000e\u0012G\u0012E\u0012A\u0012?\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011\u0012%\u0012#\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`\u001a0\u000f0\r2U\u0010\f\u001aQ\u0012\u0004\u0012\u00020\u000e\u0012G\u0012E\u0012A\u0012?\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011\u0012%\u0012#\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`\u001a0\u000f0\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fRº\u0001\u0010%\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u00128\u00126\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`$0\u000f0\r2P\u0010\f\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u00128\u00126\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`$0\u000f0\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000Rº\u0001\u0010)\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u00128\u00126\u00122\u00120\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u00110\u0010j\u0002`(0\u000f0\r2P\u0010\f\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u00128\u00126\u00122\u00120\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u00110\u0010j\u0002`(0\u000f0\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fRÄ\u0001\u0010-\u001aQ\u0012\u0004\u0012\u00020\u000e\u0012G\u0012E\u0012A\u0012?\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00130\u0011\u0012%\u0012#\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`,0\u000f0\r2U\u0010\f\u001aQ\u0012\u0004\u0012\u00020\u000e\u0012G\u0012E\u0012A\u0012?\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00130\u0011\u0012%\u0012#\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`,0\u000f0\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR®\u0001\u00102\u001aF\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u00122\u00120\u0012,\u0012*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001300\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`10\u000f0\r2J\u0010\f\u001aF\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u00122\u00120\u0012,\u0012*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001300\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u00140\u0010j\u0002`10\u000f0\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010\u001fRÃ\u0002\u0010<\u001a\u008f\u0001\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u0012{\u0012y\u0012u\u0012s\u0012)\u0012'\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u00130\u0014j\u0002`6\u0012@\u0012>\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u001108¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(9\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u001307j\u0002`:0\u0010j\u0002`;0\u000f0\r2\u0094\u0001\u0010\f\u001a\u008f\u0001\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020!0 j\u0002`\"\u0012{\u0012y\u0012u\u0012s\u0012)\u0012'\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u00130\u0014j\u0002`6\u0012@\u0012>\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u001108¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(9\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u001307j\u0002`:0\u0010j\u0002`;0\u000f0\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001d\"\u0004\b>\u0010\u001fR\u009a\u0001\u0010A\u001a<\u0012\u0004\u0012\u00020!\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u00110\u0010j\u0002`@0\u000f0\r2@\u0010\f\u001a<\u0012\u0004\u0012\u00020!\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u00110\u0010j\u0002`@0\u000f0\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001d\"\u0004\bC\u0010\u001fR\u0011\u0010D\u001a\u00020E8F¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006{"}, d2 = {"Lcom/revenuecat/purchases/common/Backend;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "eventsDispatcher", "httpClient", "Lcom/revenuecat/purchases/common/HTTPClient;", "backendHelper", "Lcom/revenuecat/purchases/common/BackendHelper;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/HTTPClient;Lcom/revenuecat/purchases/common/BackendHelper;)V", "<set-?>", "", "Lcom/revenuecat/purchases/common/BackgroundAwareCallbackCacheKey;", "", "Lkotlin/Pair;", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/PurchasesError;", "", "Lkotlin/ParameterName;", "name", "isServerError", "Lcom/revenuecat/purchases/common/CustomerInfoCallback;", "callbacks", "getCallbacks", "()Ljava/util/Map;", "setCallbacks", "(Ljava/util/Map;)V", "", "", "Lcom/revenuecat/purchases/common/CallbackCacheKey;", "Lorg/json/JSONObject;", "Lcom/revenuecat/purchases/common/DiagnosticsCallback;", "diagnosticsCallbacks", "getDiagnosticsCallbacks", "setDiagnosticsCallbacks", "Lcom/revenuecat/purchases/common/IdentifyCallback;", "identifyCallbacks", "getIdentifyCallbacks", "setIdentifyCallbacks", "Lcom/revenuecat/purchases/common/OfferingsCallback;", "offeringsCallbacks", "getOfferingsCallbacks", "setOfferingsCallbacks", "Lkotlin/Function0;", "Lcom/revenuecat/purchases/common/PaywallEventsCallback;", "paywallEventsCallbacks", "getPaywallEventsCallbacks", "setPaywallEventsCallbacks", TtmlNode.TAG_BODY, "Lcom/revenuecat/purchases/common/PostReceiptDataSuccessCallback;", "Lkotlin/Function3;", "Lcom/revenuecat/purchases/common/PostReceiptErrorHandlingBehavior;", "postReceiptErrorHandlingBehavior", "Lcom/revenuecat/purchases/common/PostReceiptDataErrorCallback;", "Lcom/revenuecat/purchases/common/PostReceiptCallback;", "postReceiptCallbacks", "getPostReceiptCallbacks", "setPostReceiptCallbacks", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "Lcom/revenuecat/purchases/common/ProductEntitlementCallback;", "productEntitlementCallbacks", "getProductEntitlementCallbacks", "setProductEntitlementCallbacks", "verificationMode", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "getVerificationMode", "()Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "clearCaches", "close", "determinePostReceiptErrorHandlingBehavior", "responseCode", "", "purchasesError", "getCustomerInfo", "appUserID", "appInBackground", "onSuccess", "onError", "getOfferings", "getProductEntitlementMapping", "onSuccessHandler", "onErrorHandler", "logIn", "newAppUserID", "postDiagnostics", "diagnosticsList", "postPaywallEvents", "paywallEventRequest", "Lcom/revenuecat/purchases/paywalls/events/PaywallEventRequest;", "error", "shouldMarkAsSynced", "postReceiptData", "purchaseToken", "isRestore", "observerMode", "subscriberAttributes", "", "receiptInfo", "Lcom/revenuecat/purchases/common/ReceiptInfo;", "storeAppUserID", b.m, "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "paywallPostReceiptData", "Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "addBackgroundAwareCallback", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, NotificationCompat.CATEGORY_CALL, "Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "cacheKey", "functions", "delay", "Lcom/revenuecat/purchases/common/Delay;", "addCallback", "K", "(Ljava/util/Map;Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;Lcom/revenuecat/purchases/common/Dispatcher;Ljava/lang/Object;Lkotlin/Pair;Lcom/revenuecat/purchases/common/Delay;)V", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class Backend {

    @Deprecated
    public static final String APP_USER_ID = "app_user_id";
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String FETCH_TOKEN = "fetch_token";

    @Deprecated
    public static final String NEW_APP_USER_ID = "new_app_user_id";
    private final AppConfig appConfig;
    private final BackendHelper backendHelper;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>>> callbacks;
    private volatile Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> diagnosticsCallbacks;
    private final Dispatcher dispatcher;
    private final Dispatcher eventsDispatcher;
    private final HTTPClient httpClient;
    private volatile Map<List<String>, List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>>> identifyCallbacks;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> offeringsCallbacks;
    private volatile Map<List<String>, List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>>> paywallEventsCallbacks;
    private volatile Map<List<String>, List<Pair<Function2<CustomerInfo, JSONObject, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>>> postReceiptCallbacks;
    private volatile Map<String, List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>>> productEntitlementCallbacks;

    public Backend(AppConfig appConfig, Dispatcher dispatcher, Dispatcher eventsDispatcher, HTTPClient httpClient, BackendHelper backendHelper) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(eventsDispatcher, "eventsDispatcher");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(backendHelper, "backendHelper");
        this.appConfig = appConfig;
        this.dispatcher = dispatcher;
        this.eventsDispatcher = eventsDispatcher;
        this.httpClient = httpClient;
        this.backendHelper = backendHelper;
        this.callbacks = new LinkedHashMap();
        this.postReceiptCallbacks = new LinkedHashMap();
        this.offeringsCallbacks = new LinkedHashMap();
        this.identifyCallbacks = new LinkedHashMap();
        this.diagnosticsCallbacks = new LinkedHashMap();
        this.paywallEventsCallbacks = new LinkedHashMap();
        this.productEntitlementCallbacks = new LinkedHashMap();
    }

    /* compiled from: Backend.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/Backend$Companion;", "", "()V", "APP_USER_ID", "", "FETCH_TOKEN", "NEW_APP_USER_ID", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final SignatureVerificationMode getVerificationMode() {
        return this.httpClient.getSigningManager().getSignatureVerificationMode();
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>>> getCallbacks() {
        return this.callbacks;
    }

    public final synchronized void setCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.callbacks = map;
    }

    public final synchronized Map<List<String>, List<Pair<Function2<CustomerInfo, JSONObject, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>>> getPostReceiptCallbacks() {
        return this.postReceiptCallbacks;
    }

    public final synchronized void setPostReceiptCallbacks(Map<List<String>, List<Pair<Function2<CustomerInfo, JSONObject, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.postReceiptCallbacks = map;
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> getOfferingsCallbacks() {
        return this.offeringsCallbacks;
    }

    public final synchronized void setOfferingsCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.offeringsCallbacks = map;
    }

    public final synchronized Map<List<String>, List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>>> getIdentifyCallbacks() {
        return this.identifyCallbacks;
    }

    public final synchronized void setIdentifyCallbacks(Map<List<String>, List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.identifyCallbacks = map;
    }

    public final synchronized Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> getDiagnosticsCallbacks() {
        return this.diagnosticsCallbacks;
    }

    public final synchronized void setDiagnosticsCallbacks(Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.diagnosticsCallbacks = map;
    }

    public final synchronized Map<List<String>, List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>>> getPaywallEventsCallbacks() {
        return this.paywallEventsCallbacks;
    }

    public final synchronized void setPaywallEventsCallbacks(Map<List<String>, List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.paywallEventsCallbacks = map;
    }

    public final synchronized Map<String, List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>>> getProductEntitlementCallbacks() {
        return this.productEntitlementCallbacks;
    }

    public final synchronized void setProductEntitlementCallbacks(Map<String, List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.productEntitlementCallbacks = map;
    }

    public final void close() {
        this.dispatcher.close();
    }

    public final void getCustomerInfo(String appUserID, boolean appInBackground, Function1<? super CustomerInfo, Unit> onSuccess, Function2<? super PurchasesError, ? super Boolean, Unit> onError) {
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey;
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.GetCustomerInfo getCustomerInfo = new Endpoint.GetCustomerInfo(appUserID);
        String path = getCustomerInfo.getPath();
        synchronized (this) {
            if (this.postReceiptCallbacks.isEmpty()) {
                backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(path), appInBackground);
            } else {
                backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.plus((Collection<? extends String>) CollectionsKt.listOf(path), String.valueOf(this.callbacks.size())), appInBackground);
            }
            backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
        }
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getCustomerInfo$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                HTTPClient hTTPClient;
                AppConfig appConfig;
                BackendHelper backendHelper;
                hTTPClient = Backend.this.httpClient;
                appConfig = Backend.this.appConfig;
                URL baseURL = appConfig.getBaseURL();
                Endpoint.GetCustomerInfo getCustomerInfo2 = getCustomerInfo;
                backendHelper = Backend.this.backendHelper;
                return HTTPClient.performRequest$default(hTTPClient, baseURL, getCustomerInfo2, null, null, backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, 32, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>> remove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = Backend.this;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey3 = backgroundAwareCallbackCacheKey2;
                synchronized (backend) {
                    remove = backend.getCallbacks().remove(backgroundAwareCallbackCacheKey3);
                }
                if (remove != null) {
                    Iterator<T> it = remove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function2 function2 = (Function2) pair.component2();
                        try {
                            if (BackendHelperKt.isSuccessful(result)) {
                                function1.invoke(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result));
                            } else {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                                LogUtilsKt.errorLog(purchasesError);
                                function2.invoke(purchasesError, Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode())));
                            }
                        } catch (JSONException e) {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e);
                            LogUtilsKt.errorLog(purchasesError2);
                            function2.invoke(purchasesError2, false);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>> remove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = Backend.this;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey3 = backgroundAwareCallbackCacheKey2;
                synchronized (backend) {
                    remove = backend.getCallbacks().remove(backgroundAwareCallbackCacheKey3);
                }
                if (remove != null) {
                    Iterator<T> it = remove.iterator();
                    while (it.hasNext()) {
                        ((Function2) ((Pair) it.next()).component2()).invoke(error, false);
                    }
                }
            }
        };
        synchronized (this) {
            addBackgroundAwareCallback(this.callbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey2, TuplesKt.to(onSuccess, onError), appInBackground ? Delay.DEFAULT : Delay.NONE);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void postReceiptData(String purchaseToken, String appUserID, boolean isRestore, boolean observerMode, Map<String, ? extends Map<String, ? extends Object>> subscriberAttributes, ReceiptInfo receiptInfo, String storeAppUserID, String marketplace, PostReceiptInitiationSource initiationSource, PaywallPostReceiptData paywallPostReceiptData, Function2<? super CustomerInfo, ? super JSONObject, Unit> onSuccess, Function3<? super PurchasesError, ? super PostReceiptErrorHandlingBehavior, ? super JSONObject, Unit> onError) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Price price;
        GoogleProrationMode asGoogleProrationMode$purchases_defaultsRelease;
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Map<String, ? extends Map<String, ? extends Object>> subscriberAttributes2 = subscriberAttributes;
        Intrinsics.checkNotNullParameter(subscriberAttributes2, "subscriberAttributes");
        Intrinsics.checkNotNullParameter(receiptInfo, "receiptInfo");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final List listOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{purchaseToken, appUserID, String.valueOf(isRestore), String.valueOf(observerMode), subscriberAttributes.toString(), receiptInfo.toString(), storeAppUserID});
        Pair[] pairArr = new Pair[16];
        pairArr[0] = TuplesKt.to(FETCH_TOKEN, purchaseToken);
        pairArr[1] = TuplesKt.to("product_ids", receiptInfo.getProductIDs());
        List<PlatformProductId> platformProductIds$purchases_defaultsRelease = receiptInfo.getPlatformProductIds$purchases_defaultsRelease();
        if (platformProductIds$purchases_defaultsRelease != null) {
            List<PlatformProductId> list = platformProductIds$purchases_defaultsRelease;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList3.add(((PlatformProductId) it.next()).getAsMap());
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        pairArr[2] = TuplesKt.to("platform_product_ids", arrayList);
        pairArr[3] = TuplesKt.to(APP_USER_ID, appUserID);
        pairArr[4] = TuplesKt.to("is_restore", Boolean.valueOf(isRestore));
        PresentedOfferingContext presentedOfferingContext = receiptInfo.getPresentedOfferingContext();
        pairArr[5] = TuplesKt.to("presented_offering_identifier", presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null);
        pairArr[6] = TuplesKt.to("observer_mode", Boolean.valueOf(observerMode));
        pairArr[7] = TuplesKt.to(b.x, receiptInfo.getPrice());
        pairArr[8] = TuplesKt.to(b.a, receiptInfo.getCurrency());
        if (subscriberAttributes.isEmpty() || this.appConfig.getCustomEntitlementComputation()) {
            subscriberAttributes2 = null;
        }
        pairArr[9] = TuplesKt.to("attributes", subscriberAttributes2);
        pairArr[10] = TuplesKt.to("normal_duration", receiptInfo.getDuration());
        pairArr[11] = TuplesKt.to("store_user_id", storeAppUserID);
        List<PricingPhase> pricingPhases = receiptInfo.getPricingPhases();
        if (pricingPhases != null) {
            List<PricingPhase> list2 = pricingPhases;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList4.add(BackendKt.toMap((PricingPhase) it2.next()));
            }
            arrayList2 = arrayList4;
        } else {
            arrayList2 = null;
        }
        pairArr[12] = TuplesKt.to("pricing_phases", arrayList2);
        ReplacementMode replacementMode = receiptInfo.getReplacementMode();
        GoogleReplacementMode googleReplacementMode = replacementMode instanceof GoogleReplacementMode ? (GoogleReplacementMode) replacementMode : null;
        pairArr[13] = TuplesKt.to("proration_mode", (googleReplacementMode == null || (asGoogleProrationMode$purchases_defaultsRelease = googleReplacementMode.getAsGoogleProrationMode$purchases_defaultsRelease()) == null) ? null : asGoogleProrationMode$purchases_defaultsRelease.name());
        pairArr[14] = TuplesKt.to("initiation_source", initiationSource.getPostReceiptFieldValue());
        pairArr[15] = TuplesKt.to("paywall", paywallPostReceiptData != null ? paywallPostReceiptData.toMap() : null);
        final Map filterNotNullValues = MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(pairArr));
        final List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(APP_USER_ID, appUserID), TuplesKt.to(FETCH_TOKEN, purchaseToken)});
        Pair[] pairArr2 = new Pair[2];
        StoreProduct storeProduct = receiptInfo.getStoreProduct();
        pairArr2[0] = TuplesKt.to("price_string", (storeProduct == null || (price = storeProduct.getPrice()) == null) ? null : price.getFormatted());
        pairArr2[1] = TuplesKt.to(b.m, marketplace);
        final Map filterNotNullValues2 = MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(pairArr2));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postReceiptData$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                HTTPClient hTTPClient;
                AppConfig appConfig;
                BackendHelper backendHelper;
                hTTPClient = Backend.this.httpClient;
                appConfig = Backend.this.appConfig;
                URL baseURL = appConfig.getBaseURL();
                Endpoint.PostReceipt postReceipt = Endpoint.PostReceipt.INSTANCE;
                Map<String, Object> map = filterNotNullValues;
                List<Pair<String, String>> list3 = listOf;
                backendHelper = Backend.this.backendHelper;
                return HTTPClient.performRequest$default(hTTPClient, baseURL, postReceipt, map, list3, MapsKt.plus(backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), filterNotNullValues2), false, 32, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function2<CustomerInfo, JSONObject, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>> remove;
                PostReceiptErrorHandlingBehavior determinePostReceiptErrorHandlingBehavior;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = Backend.this;
                List<String> list3 = listOfNotNull;
                synchronized (backend) {
                    remove = backend.getPostReceiptCallbacks().remove(list3);
                }
                if (remove != null) {
                    Backend backend2 = Backend.this;
                    Iterator<T> it3 = remove.iterator();
                    while (it3.hasNext()) {
                        Pair pair = (Pair) it3.next();
                        Function2 function2 = (Function2) pair.component1();
                        Function3 function3 = (Function3) pair.component2();
                        try {
                            if (BackendHelperKt.isSuccessful(result)) {
                                function2.invoke(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result), result.getBody());
                            } else {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                                LogUtilsKt.errorLog(purchasesError);
                                determinePostReceiptErrorHandlingBehavior = backend2.determinePostReceiptErrorHandlingBehavior(result.getResponseCode(), purchasesError);
                                function3.invoke(purchasesError, determinePostReceiptErrorHandlingBehavior, result.getBody());
                            }
                        } catch (JSONException e) {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e);
                            LogUtilsKt.errorLog(purchasesError2);
                            function3.invoke(purchasesError2, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function2<CustomerInfo, JSONObject, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>> remove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = Backend.this;
                List<String> list3 = listOfNotNull;
                synchronized (backend) {
                    remove = backend.getPostReceiptCallbacks().remove(list3);
                }
                if (remove != null) {
                    Iterator<T> it3 = remove.iterator();
                    while (it3.hasNext()) {
                        ((Function3) ((Pair) it3.next()).component2()).invoke(error, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
                    }
                }
            }
        };
        synchronized (this) {
            addCallback$default(this, this.postReceiptCallbacks, asyncCall, this.dispatcher, listOfNotNull, TuplesKt.to(onSuccess, onError), null, 16, null);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void getOfferings(String appUserID, boolean appInBackground, Function1<? super JSONObject, Unit> onSuccess, Function2<? super PurchasesError, ? super Boolean, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.GetOfferings getOfferings = new Endpoint.GetOfferings(appUserID);
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(getOfferings.getPath()), appInBackground);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getOfferings$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                HTTPClient hTTPClient;
                AppConfig appConfig;
                BackendHelper backendHelper;
                hTTPClient = Backend.this.httpClient;
                appConfig = Backend.this.appConfig;
                URL baseURL = appConfig.getBaseURL();
                Endpoint.GetOfferings getOfferings2 = getOfferings;
                backendHelper = Backend.this.backendHelper;
                return HTTPClient.performRequest$default(hTTPClient, baseURL, getOfferings2, null, null, backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, 32, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>> remove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = Backend.this;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    remove = backend.getOfferingsCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (remove != null) {
                    Iterator<T> it = remove.iterator();
                    while (it.hasNext()) {
                        ((Function2) ((Pair) it.next()).component2()).invoke(error, false);
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>> remove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = Backend.this;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    remove = backend.getOfferingsCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (remove != null) {
                    Iterator<T> it = remove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function2 function2 = (Function2) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function1.invoke(result.getBody());
                            } catch (JSONException e) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError);
                                function2.invoke(purchasesError, false);
                            }
                        } else {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError2);
                            function2.invoke(purchasesError2, Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode())));
                        }
                    }
                }
            }
        };
        synchronized (this) {
            addBackgroundAwareCallback(this.offeringsCallbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey, TuplesKt.to(onSuccess, onError), appInBackground ? Delay.DEFAULT : Delay.NONE);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void logIn(final String appUserID, final String newAppUserID, Function2<? super CustomerInfo, ? super Boolean, Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final List listOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{appUserID, newAppUserID});
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$logIn$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                HTTPClient hTTPClient;
                AppConfig appConfig;
                BackendHelper backendHelper;
                Map mapOf = MapsKt.mapOf(TuplesKt.to(Backend.APP_USER_ID, appUserID), TuplesKt.to(Backend.NEW_APP_USER_ID, newAppUserID));
                List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(Backend.APP_USER_ID, appUserID), TuplesKt.to(Backend.NEW_APP_USER_ID, newAppUserID)});
                hTTPClient = this.httpClient;
                appConfig = this.appConfig;
                URL baseURL = appConfig.getBaseURL();
                Endpoint.LogIn logIn = Endpoint.LogIn.INSTANCE;
                backendHelper = this.backendHelper;
                return HTTPClient.performRequest$default(hTTPClient, baseURL, logIn, mapOf, listOf, backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, 32, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>> remove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this;
                List<String> list = listOfNotNull;
                synchronized (backend) {
                    remove = backend.getIdentifyCallbacks().remove(list);
                }
                if (remove != null) {
                    Iterator<T> it = remove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>> remove;
                Intrinsics.checkNotNullParameter(result, "result");
                if (BackendHelperKt.isSuccessful(result)) {
                    Backend backend = this;
                    List<String> list = listOfNotNull;
                    synchronized (backend) {
                        remove = backend.getIdentifyCallbacks().remove(list);
                    }
                    if (remove != null) {
                        Iterator<T> it = remove.iterator();
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            Function2 function2 = (Function2) pair.component1();
                            Function1 function1 = (Function1) pair.component2();
                            boolean z = result.getResponseCode() == 201;
                            if (result.getBody().length() > 0) {
                                function2.invoke(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result), Boolean.valueOf(z));
                            } else {
                                PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnknownError, null, 2, null);
                                LogUtilsKt.errorLog(purchasesError);
                                function1.invoke(purchasesError);
                            }
                        }
                        return;
                    }
                    return;
                }
                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(result);
                LogUtilsKt.errorLog(purchasesError2);
                onError(purchasesError2);
            }
        };
        synchronized (this) {
            addCallback$default(this, this.identifyCallbacks, asyncCall, this.dispatcher, listOfNotNull, TuplesKt.to(onSuccessHandler, onErrorHandler), null, 16, null);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void postDiagnostics(List<? extends JSONObject> diagnosticsList, Function1<? super JSONObject, Unit> onSuccessHandler, Function2<? super PurchasesError, ? super Boolean, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(diagnosticsList, "diagnosticsList");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        List<? extends JSONObject> list = diagnosticsList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((JSONObject) it.next()).hashCode()));
        }
        final ArrayList arrayList2 = arrayList;
        final Map mapOf = MapsKt.mapOf(TuplesKt.to("entries", new JSONArray((Collection) diagnosticsList)));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postDiagnostics$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                HTTPClient hTTPClient;
                BackendHelper backendHelper;
                hTTPClient = Backend.this.httpClient;
                URL diagnosticsURL = AppConfig.INSTANCE.getDiagnosticsURL();
                Endpoint.PostDiagnostics postDiagnostics = Endpoint.PostDiagnostics.INSTANCE;
                Map<String, JSONArray> map = mapOf;
                backendHelper = Backend.this.backendHelper;
                return HTTPClient.performRequest$default(hTTPClient, diagnosticsURL, postDiagnostics, map, null, backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, 32, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>> remove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = Backend.this;
                List<String> list2 = arrayList2;
                synchronized (backend) {
                    remove = backend.getDiagnosticsCallbacks().remove(list2);
                }
                if (remove != null) {
                    Iterator<T> it2 = remove.iterator();
                    while (it2.hasNext()) {
                        ((Function2) ((Pair) it2.next()).component2()).invoke(error, Boolean.valueOf(error.getCode() == PurchasesErrorCode.NetworkError));
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>> remove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = Backend.this;
                List<String> list2 = arrayList2;
                synchronized (backend) {
                    remove = backend.getDiagnosticsCallbacks().remove(list2);
                }
                if (remove != null) {
                    Iterator<T> it2 = remove.iterator();
                    while (it2.hasNext()) {
                        Pair pair = (Pair) it2.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function2 function2 = (Function2) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            function1.invoke(result.getBody());
                        } else {
                            PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                            function2.invoke(purchasesError, Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode()) || purchasesError.getCode() == PurchasesErrorCode.NetworkError));
                        }
                    }
                }
            }
        };
        synchronized (this) {
            addCallback(this.diagnosticsCallbacks, asyncCall, this.eventsDispatcher, arrayList2, TuplesKt.to(onSuccessHandler, onErrorHandler), Delay.LONG);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void postPaywallEvents(final PaywallEventRequest paywallEventRequest, Function0<Unit> onSuccessHandler, Function2<? super PurchasesError, ? super Boolean, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(paywallEventRequest, "paywallEventRequest");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        Json json = PaywallEventRequest.INSTANCE.getJson();
        KSerializer<Object> serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(PaywallEventRequest.class));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        final Map<String, Object> asMap = JsonElementExtensionsKt.asMap(json.encodeToJsonElement(serializer, paywallEventRequest));
        if (asMap == null) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnknownError, "Error encoding paywall event request");
            LogUtilsKt.errorLog(purchasesError);
            onErrorHandler.invoke(purchasesError, true);
        } else {
            Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postPaywallEvents$call$1
                @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
                public HTTPResult call() {
                    HTTPClient hTTPClient;
                    BackendHelper backendHelper;
                    hTTPClient = Backend.this.httpClient;
                    URL paywallEventsURL = AppConfig.INSTANCE.getPaywallEventsURL();
                    Endpoint.PostPaywallEvents postPaywallEvents = Endpoint.PostPaywallEvents.INSTANCE;
                    Map<String, Object> map = asMap;
                    backendHelper = Backend.this.backendHelper;
                    return HTTPClient.performRequest$default(hTTPClient, paywallEventsURL, postPaywallEvents, map, null, backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, 32, null);
                }

                @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
                public void onError(PurchasesError error) {
                    List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>> remove;
                    Intrinsics.checkNotNullParameter(error, "error");
                    Backend backend = Backend.this;
                    PaywallEventRequest paywallEventRequest2 = paywallEventRequest;
                    synchronized (backend) {
                        remove = backend.getPaywallEventsCallbacks().remove(paywallEventRequest2.getCacheKey());
                    }
                    if (remove != null) {
                        Iterator<T> it = remove.iterator();
                        while (it.hasNext()) {
                            ((Function2) ((Pair) it.next()).component2()).invoke(error, true);
                        }
                    }
                }

                @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
                public void onCompletion(HTTPResult result) {
                    List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>> remove;
                    Intrinsics.checkNotNullParameter(result, "result");
                    Backend backend = Backend.this;
                    PaywallEventRequest paywallEventRequest2 = paywallEventRequest;
                    synchronized (backend) {
                        remove = backend.getPaywallEventsCallbacks().remove(paywallEventRequest2.getCacheKey());
                    }
                    if (remove != null) {
                        Iterator<T> it = remove.iterator();
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            Function0 function0 = (Function0) pair.component1();
                            Function2 function2 = (Function2) pair.component2();
                            if (BackendHelperKt.isSuccessful(result)) {
                                function0.invoke();
                            } else {
                                function2.invoke(ErrorsKt.toPurchasesError(result), Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isSynced(result.getResponseCode())));
                            }
                        }
                    }
                }
            };
            synchronized (this) {
                addCallback(this.paywallEventsCallbacks, asyncCall, this.eventsDispatcher, paywallEventRequest.getCacheKey(), TuplesKt.to(onSuccessHandler, onErrorHandler), Delay.LONG);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void getProductEntitlementMapping(Function1<? super ProductEntitlementMapping, Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final Endpoint.GetProductEntitlementMapping getProductEntitlementMapping = Endpoint.GetProductEntitlementMapping.INSTANCE;
        final String path = getProductEntitlementMapping.getPath();
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getProductEntitlementMapping$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                HTTPClient hTTPClient;
                AppConfig appConfig;
                BackendHelper backendHelper;
                hTTPClient = Backend.this.httpClient;
                appConfig = Backend.this.appConfig;
                URL baseURL = appConfig.getBaseURL();
                Endpoint.GetProductEntitlementMapping getProductEntitlementMapping2 = getProductEntitlementMapping;
                backendHelper = Backend.this.backendHelper;
                return HTTPClient.performRequest$default(hTTPClient, baseURL, getProductEntitlementMapping2, null, null, backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, 32, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>> remove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = Backend.this;
                String str = path;
                synchronized (backend) {
                    remove = backend.getProductEntitlementCallbacks().remove(str);
                }
                if (remove != null) {
                    Iterator<T> it = remove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>> remove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = Backend.this;
                String str = path;
                synchronized (backend) {
                    remove = backend.getProductEntitlementCallbacks().remove(str);
                }
                if (remove != null) {
                    Iterator<T> it = remove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function1 function12 = (Function1) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function1.invoke(ProductEntitlementMapping.INSTANCE.fromJson(result.getBody()));
                            } catch (JSONException e) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            }
                        } else {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError2);
                            function12.invoke(purchasesError2);
                        }
                    }
                }
            }
        };
        synchronized (this) {
            addCallback(this.productEntitlementCallbacks, asyncCall, this.dispatcher, path, TuplesKt.to(onSuccessHandler, onErrorHandler), Delay.LONG);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearCaches() {
        this.httpClient.clearCaches();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PostReceiptErrorHandlingBehavior determinePostReceiptErrorHandlingBehavior(int responseCode, PurchasesError purchasesError) {
        if (RCHTTPStatusCodes.INSTANCE.isServerError(responseCode)) {
            return PostReceiptErrorHandlingBehavior.SHOULD_USE_OFFLINE_ENTITLEMENTS_AND_NOT_CONSUME;
        }
        if (purchasesError.getCode() == PurchasesErrorCode.UnsupportedError) {
            return PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME;
        }
        return PostReceiptErrorHandlingBehavior.SHOULD_BE_CONSUMED;
    }

    static /* synthetic */ void addBackgroundAwareCallback$default(Backend backend, Map map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, Pair pair, Delay delay, int i, Object obj) {
        if ((i & 16) != 0) {
            delay = Delay.NONE;
        }
        backend.addBackgroundAwareCallback(map, asyncCall, dispatcher, backgroundAwareCallbackCacheKey, pair, delay);
    }

    private final synchronized <S, E> void addBackgroundAwareCallback(Map<BackgroundAwareCallbackCacheKey, List<Pair<S, E>>> map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, Pair<? extends S, ? extends E> pair, Delay delay) {
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2;
        BackgroundAwareCallbackCacheKey copy$default = BackgroundAwareCallbackCacheKey.copy$default(backgroundAwareCallbackCacheKey, null, false, 1, null);
        boolean containsKey = map.containsKey(copy$default);
        if (backgroundAwareCallbackCacheKey.getAppInBackground() && containsKey) {
            String format = String.format(NetworkStrings.SAME_CALL_SCHEDULED_WITHOUT_JITTER, Arrays.copyOf(new Object[]{copy$default}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogUtilsKt.debugLog(format);
            backgroundAwareCallbackCacheKey2 = copy$default;
        } else {
            backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
        }
        addCallback(map, asyncCall, dispatcher, backgroundAwareCallbackCacheKey2, pair, delay);
        BackgroundAwareCallbackCacheKey copy$default2 = BackgroundAwareCallbackCacheKey.copy$default(backgroundAwareCallbackCacheKey, null, true, 1, null);
        boolean containsKey2 = map.containsKey(copy$default);
        if (!backgroundAwareCallbackCacheKey.getAppInBackground() && containsKey2) {
            String format2 = String.format(NetworkStrings.SAME_CALL_SCHEDULED_WITH_JITTER, Arrays.copyOf(new Object[]{copy$default}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
            LogUtilsKt.debugLog(format2);
            List<Pair<S, E>> remove = map.remove(copy$default2);
            if (remove != null) {
                List<Pair<S, E>> list = remove.isEmpty() ^ true ? remove : null;
                if (list != null) {
                    if (map.containsKey(backgroundAwareCallbackCacheKey)) {
                        List<Pair<S, E>> list2 = map.get(backgroundAwareCallbackCacheKey);
                        if (list2 != null) {
                            list2.addAll(list);
                        }
                    } else {
                        map.put(backgroundAwareCallbackCacheKey, list);
                    }
                }
            }
        }
    }

    static /* synthetic */ void addCallback$default(Backend backend, Map map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, Object obj, Pair pair, Delay delay, int i, Object obj2) {
        if ((i & 16) != 0) {
            delay = Delay.NONE;
        }
        backend.addCallback(map, asyncCall, dispatcher, obj, pair, delay);
    }

    private final <K, S, E> void addCallback(Map<K, List<Pair<S, E>>> map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, K k, Pair<? extends S, ? extends E> pair, Delay delay) {
        if (!map.containsKey(k)) {
            map.put(k, CollectionsKt.mutableListOf(pair));
            this.backendHelper.enqueue(asyncCall, dispatcher, delay);
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(NetworkStrings.SAME_CALL_ALREADY_IN_PROGRESS, Arrays.copyOf(new Object[]{k}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        LogUtilsKt.debugLog(format);
        List<Pair<S, E>> list = map.get(k);
        Intrinsics.checkNotNull(list);
        list.add(pair);
    }
}
