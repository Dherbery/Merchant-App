package com.revenuecat.purchases.subscriberattributes;

import android.app.Application;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: SubscriberAttributesManager.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u00016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\u00102\n\u0010\u0016\u001a\u00060\u0012j\u0002`\u00172\n\u0010\u0018\u001a\u00060\u0012j\u0002`\u0017JA\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142/\u0010\u001a\u001a+\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00100\u001bH\u0002J2\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\"\u0010\u001a\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020!0\u001cj\u0002`\"\u0012\u0004\u0012\u00020\u00100\u001bJ0\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020!0\u001c2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&J \u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0012J$\u0010,\u001a\u00020\u00102\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001c2\u0006\u0010\u0011\u001a\u00020\u0012J(\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u0002002\b\u0010+\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J$\u00101\u001a\u00020\u00102\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020!0\u001c2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J$\u00103\u001a\u00020\u00102\n\u00104\u001a\u00060\u0012j\u0002`\u00172\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u000105R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;", "", "deviceCache", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "backend", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;", "deviceIdentifiersFetcher", "Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;", "(Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;)V", "getBackend", "()Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;", "getDeviceCache", "()Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "obtainingDeviceIdentifiersObservable", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager$ObtainDeviceIdentifiersObservable;", "collectDeviceIdentifiers", "", "appUserID", "", "applicationContext", "Landroid/app/Application;", "copyUnsyncedSubscriberAttributes", "originalAppUserId", "Lcom/revenuecat/purchases/subscriberattributes/caching/AppUserID;", "newAppUserID", "getDeviceIdentifiers", "completion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "deviceIdentifiers", "getUnsyncedSubscriberAttributes", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "markAsSynced", "attributesToMarkAsSynced", "attributeErrors", "", "Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "setAttribute", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "value", "setAttributes", "attributesToSet", "setAttributionID", "attributionKey", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds;", "storeAttributesIfNeeded", "attributesAsObjects", "synchronizeSubscriberAttributesForAllUsers", "currentAppUserID", "Lkotlin/Function0;", "ObtainDeviceIdentifiersObservable", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriberAttributesManager {
    private final SubscriberAttributesPoster backend;
    private final SubscriberAttributesCache deviceCache;
    private final DeviceIdentifiersFetcher deviceIdentifiersFetcher;
    private final ObtainDeviceIdentifiersObservable obtainingDeviceIdentifiersObservable;

    public SubscriberAttributesManager(SubscriberAttributesCache deviceCache, SubscriberAttributesPoster backend, DeviceIdentifiersFetcher deviceIdentifiersFetcher) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(deviceIdentifiersFetcher, "deviceIdentifiersFetcher");
        this.deviceCache = deviceCache;
        this.backend = backend;
        this.deviceIdentifiersFetcher = deviceIdentifiersFetcher;
        this.obtainingDeviceIdentifiersObservable = new ObtainDeviceIdentifiersObservable();
    }

    public final SubscriberAttributesCache getDeviceCache() {
        return this.deviceCache;
    }

    public final SubscriberAttributesPoster getBackend() {
        return this.backend;
    }

    private final void storeAttributesIfNeeded(Map<String, SubscriberAttribute> attributesAsObjects, String appUserID) {
        Map<String, SubscriberAttribute> allStoredSubscriberAttributes = this.deviceCache.getAllStoredSubscriberAttributes(appUserID);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, SubscriberAttribute>> it = attributesAsObjects.entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, SubscriberAttribute> next = it.next();
            String key = next.getKey();
            SubscriberAttribute value = next.getValue();
            if (allStoredSubscriberAttributes.containsKey(key)) {
                SubscriberAttribute subscriberAttribute = allStoredSubscriberAttributes.get(key);
                if (Intrinsics.areEqual(subscriberAttribute != null ? subscriberAttribute.getValue() : null, value.getValue())) {
                    z = false;
                }
            }
            if (z) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        if (!linkedHashMap.isEmpty()) {
            this.deviceCache.setAttributes(appUserID, linkedHashMap);
        }
    }

    public final synchronized void setAttribute(SubscriberAttributeKey r2, String value, String appUserID) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        setAttributes(MapsKt.mapOf(TuplesKt.to(r2.getBackendKey(), value)), appUserID);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void synchronizeSubscriberAttributesForAllUsers$default(SubscriberAttributesManager subscriberAttributesManager, String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(str, function0);
    }

    public final void synchronizeSubscriberAttributesForAllUsers(final String currentAppUserID, final Function0<Unit> completion) {
        Intrinsics.checkNotNullParameter(currentAppUserID, "currentAppUserID");
        this.obtainingDeviceIdentifiersObservable.waitUntilIdle(new Function0<Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1
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
                Map<String, Map<String, SubscriberAttribute>> unsyncedSubscriberAttributes = SubscriberAttributesManager.this.getDeviceCache().getUnsyncedSubscriberAttributes();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, Map<String, SubscriberAttribute>> entry : unsyncedSubscriberAttributes.entrySet()) {
                    if (!StringsKt.isBlank(entry.getKey())) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                if (linkedHashMap2.isEmpty()) {
                    LogWrapperKt.log(LogIntent.DEBUG, AttributionStrings.NO_SUBSCRIBER_ATTRIBUTES_TO_SYNCHRONIZE);
                    Function0<Unit> function0 = completion;
                    if (function0 != null) {
                        function0.invoke();
                        return;
                    }
                    return;
                }
                final int size = linkedHashMap2.size();
                final Ref.IntRef intRef = new Ref.IntRef();
                final SubscriberAttributesManager subscriberAttributesManager = SubscriberAttributesManager.this;
                String str = currentAppUserID;
                final Function0<Unit> function02 = completion;
                for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                    final String str2 = (String) entry2.getKey();
                    final Map map = (Map) entry2.getValue();
                    final String str3 = str;
                    subscriberAttributesManager.getBackend().postSubscriberAttributes(BackendHelpersKt.toBackendMap(map), str2, new Function0<Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$1$1
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
                            SubscriberAttributesManager.this.markAsSynced(str2, map, CollectionsKt.emptyList());
                            LogIntent logIntent = LogIntent.RC_SUCCESS;
                            String format = String.format(AttributionStrings.ATTRIBUTES_SYNC_SUCCESS, Arrays.copyOf(new Object[]{str2}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                            LogWrapperKt.log(logIntent, format);
                            if (!Intrinsics.areEqual(str3, str2)) {
                                SubscriberAttributesManager.this.getDeviceCache().clearSubscriberAttributesIfSyncedForSubscriber(str2);
                            }
                            intRef.element++;
                            if (function02 == null || intRef.element != size) {
                                return;
                            }
                            function02.invoke();
                        }
                    }, new Function3<PurchasesError, Boolean, List<? extends SubscriberAttributeError>, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, Boolean bool, List<? extends SubscriberAttributeError> list) {
                            invoke(purchasesError, bool.booleanValue(), (List<SubscriberAttributeError>) list);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PurchasesError error, boolean z, List<SubscriberAttributeError> attributeErrors) {
                            Intrinsics.checkNotNullParameter(error, "error");
                            Intrinsics.checkNotNullParameter(attributeErrors, "attributeErrors");
                            if (z) {
                                SubscriberAttributesManager.this.markAsSynced(str2, map, attributeErrors);
                            }
                            LogIntent logIntent = LogIntent.RC_ERROR;
                            String format = String.format(AttributionStrings.ATTRIBUTES_SYNC_ERROR, Arrays.copyOf(new Object[]{str2, error}, 2));
                            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                            LogWrapperKt.log(logIntent, format);
                            intRef.element++;
                            if (function02 == null || intRef.element != size) {
                                return;
                            }
                            function02.invoke();
                        }
                    });
                    str = str;
                }
            }
        });
    }

    public final synchronized void copyUnsyncedSubscriberAttributes(String originalAppUserId, String newAppUserID) {
        Intrinsics.checkNotNullParameter(originalAppUserId, "originalAppUserId");
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        Map<String, SubscriberAttribute> unsyncedSubscriberAttributes = this.deviceCache.getUnsyncedSubscriberAttributes(originalAppUserId);
        if (unsyncedSubscriberAttributes.isEmpty()) {
            return;
        }
        String format = String.format(AttributionStrings.COPYING_ATTRIBUTES_FROM_TO_USER, Arrays.copyOf(new Object[]{originalAppUserId, newAppUserID}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogUtilsKt.infoLog(format);
        this.deviceCache.setAttributes(newAppUserID, unsyncedSubscriberAttributes);
        this.deviceCache.clearAllSubscriberAttributesFromUser(originalAppUserId);
    }

    public final synchronized void getUnsyncedSubscriberAttributes(final String appUserID, final Function1<? super Map<String, SubscriberAttribute>, Unit> completion) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(completion, "completion");
        this.obtainingDeviceIdentifiersObservable.waitUntilIdle(new Function0<Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$getUnsyncedSubscriberAttributes$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                completion.invoke(this.getDeviceCache().getUnsyncedSubscriberAttributes(appUserID));
            }
        });
    }

    public final synchronized void markAsSynced(String appUserID, Map<String, SubscriberAttribute> attributesToMarkAsSynced, List<SubscriberAttributeError> attributeErrors) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(attributesToMarkAsSynced, "attributesToMarkAsSynced");
        Intrinsics.checkNotNullParameter(attributeErrors, "attributeErrors");
        if (!attributeErrors.isEmpty()) {
            LogIntent logIntent = LogIntent.RC_ERROR;
            String format = String.format(AttributionStrings.SUBSCRIBER_ATTRIBUTES_ERROR, Arrays.copyOf(new Object[]{attributeErrors}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
        }
        if (attributesToMarkAsSynced.isEmpty()) {
            return;
        }
        LogIntent logIntent2 = LogIntent.INFO;
        StringBuilder sb = new StringBuilder();
        String format2 = String.format(AttributionStrings.MARKING_ATTRIBUTES_SYNCED, Arrays.copyOf(new Object[]{appUserID}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
        sb.append(format2);
        sb.append(CollectionsKt.joinToString$default(attributesToMarkAsSynced.values(), "\n", null, null, 0, null, null, 62, null));
        LogWrapperKt.log(logIntent2, sb.toString());
        Map<String, SubscriberAttribute> allStoredSubscriberAttributes = this.deviceCache.getAllStoredSubscriberAttributes(appUserID);
        Map<String, SubscriberAttribute> mutableMap = MapsKt.toMutableMap(allStoredSubscriberAttributes);
        for (Map.Entry<String, SubscriberAttribute> entry : attributesToMarkAsSynced.entrySet()) {
            String key = entry.getKey();
            SubscriberAttribute value = entry.getValue();
            SubscriberAttribute subscriberAttribute = allStoredSubscriberAttributes.get(key);
            if (subscriberAttribute != null) {
                if (subscriberAttribute.isSynced()) {
                    subscriberAttribute = null;
                }
                if (subscriberAttribute != null) {
                    if ((Intrinsics.areEqual(subscriberAttribute.getValue(), value.getValue()) ? subscriberAttribute : null) != null) {
                        mutableMap.put(key, SubscriberAttribute.copy$default(value, null, null, null, null, true, 15, null));
                    }
                }
            }
        }
        this.deviceCache.setAttributes(appUserID, mutableMap);
    }

    public final void collectDeviceIdentifiers(final String appUserID, Application applicationContext) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        getDeviceIdentifiers(applicationContext, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$collectDeviceIdentifiers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
                invoke2((Map<String, String>) map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, String> deviceIdentifiers) {
                Intrinsics.checkNotNullParameter(deviceIdentifiers, "deviceIdentifiers");
                SubscriberAttributesManager.this.setAttributes(deviceIdentifiers, appUserID);
            }
        });
    }

    public final void setAttributionID(final SubscriberAttributeKey.AttributionIds attributionKey, final String value, final String appUserID, Application applicationContext) {
        Intrinsics.checkNotNullParameter(attributionKey, "attributionKey");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        getDeviceIdentifiers(applicationContext, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$setAttributionID$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
                invoke2((Map<String, String>) map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, String> deviceIdentifiers) {
                Intrinsics.checkNotNullParameter(deviceIdentifiers, "deviceIdentifiers");
                this.setAttributes(MapsKt.plus(MapsKt.mapOf(TuplesKt.to(SubscriberAttributeKey.AttributionIds.this.getBackendKey(), value)), deviceIdentifiers), appUserID);
            }
        });
    }

    private final void getDeviceIdentifiers(Application applicationContext, final Function1<? super Map<String, String>, Unit> completion) {
        ObtainDeviceIdentifiersObservable obtainDeviceIdentifiersObservable = this.obtainingDeviceIdentifiersObservable;
        obtainDeviceIdentifiersObservable.setNumberOfProcesses(obtainDeviceIdentifiersObservable.getNumberOfProcesses() + 1);
        this.deviceIdentifiersFetcher.getDeviceIdentifiers(applicationContext, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$getDeviceIdentifiers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
                invoke2((Map<String, String>) map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, String> deviceIdentifiers) {
                SubscriberAttributesManager.ObtainDeviceIdentifiersObservable obtainDeviceIdentifiersObservable2;
                Intrinsics.checkNotNullParameter(deviceIdentifiers, "deviceIdentifiers");
                completion.invoke(deviceIdentifiers);
                obtainDeviceIdentifiersObservable2 = this.obtainingDeviceIdentifiersObservable;
                obtainDeviceIdentifiersObservable2.setNumberOfProcesses(obtainDeviceIdentifiersObservable2.getNumberOfProcesses() - 1);
            }
        });
    }

    /* compiled from: SubscriberAttributesManager.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R,\u0010\u0003\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u00078BX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager$ObtainDeviceIdentifiersObservable;", "Ljava/util/Observable;", "()V", "listeners", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "", "Lkotlin/collections/ArrayList;", "value", "", "numberOfProcesses", "getNumberOfProcesses", "()I", "setNumberOfProcesses", "(I)V", "waitUntilIdle", "completion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ObtainDeviceIdentifiersObservable extends Observable {
        private final ArrayList<Function0<Unit>> listeners = new ArrayList<>();
        private int numberOfProcesses;

        public ObtainDeviceIdentifiersObservable() {
            addObserver(new Observer() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$ObtainDeviceIdentifiersObservable$$ExternalSyntheticLambda0
                @Override // java.util.Observer
                public final void update(Observable observable, Object obj) {
                    SubscriberAttributesManager.ObtainDeviceIdentifiersObservable._init_$lambda$2(SubscriberAttributesManager.ObtainDeviceIdentifiersObservable.this, observable, obj);
                }
            });
        }

        public final synchronized int getNumberOfProcesses() {
            return this.numberOfProcesses;
        }

        public final synchronized void setNumberOfProcesses(int i) {
            if (this.numberOfProcesses == i) {
                return;
            }
            this.numberOfProcesses = i;
            setChanged();
            notifyObservers();
        }

        public static final void _init_$lambda$2(ObtainDeviceIdentifiersObservable this$0, Observable observable, Object obj) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNull(observable, "null cannot be cast to non-null type com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.ObtainDeviceIdentifiersObservable");
            if (((ObtainDeviceIdentifiersObservable) observable).numberOfProcesses == 0) {
                synchronized (this$0) {
                    Iterator<T> it = this$0.listeners.iterator();
                    while (it.hasNext()) {
                        ((Function0) it.next()).invoke();
                    }
                    this$0.listeners.clear();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final synchronized void waitUntilIdle(final Function0<Unit> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            if (this.numberOfProcesses == 0) {
                completion.invoke();
            } else {
                this.listeners.add(new Function0<Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$ObtainDeviceIdentifiersObservable$waitUntilIdle$1
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
                        completion.invoke();
                    }
                });
            }
        }
    }

    public final synchronized void setAttributes(Map<String, String> attributesToSet, String appUserID) {
        Intrinsics.checkNotNullParameter(attributesToSet, "attributesToSet");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        ArrayList arrayList = new ArrayList(attributesToSet.size());
        for (Map.Entry<String, String> entry : attributesToSet.entrySet()) {
            String key = entry.getKey();
            arrayList.add(TuplesKt.to(key, new SubscriberAttribute(key, entry.getValue(), (DateProvider) null, (Date) null, false, 28, (DefaultConstructorMarker) null)));
        }
        storeAttributesIfNeeded(MapsKt.toMap(arrayList), appUserID);
    }
}
