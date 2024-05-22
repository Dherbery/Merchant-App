package com.revenuecat.purchases.common.diagnostics;

import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.common.DateProvider;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DiagnosticsEntry.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00072\u00020\u0001:\u0004\u0007\b\t\nB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry;", "Lcom/revenuecat/purchases/utils/Event;", "diagnosticType", "", "(Ljava/lang/String;)V", "getDiagnosticType", "()Ljava/lang/String;", "Companion", "Counter", "Event", "Histogram", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry$Counter;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry$Event;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry$Histogram;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public abstract class DiagnosticsEntry implements com.revenuecat.purchases.utils.Event {
    private static final String TYPE_KEY = "type";
    private static final int VERSION = 1;
    private static final String VERSION_KEY = "version";
    private final String diagnosticType;

    public /* synthetic */ DiagnosticsEntry(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private DiagnosticsEntry(String str) {
        this.diagnosticType = str;
    }

    public final String getDiagnosticType() {
        return this.diagnosticType;
    }

    /* compiled from: DiagnosticsEntry.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\u000bHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0006H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry$Event;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry;", "name", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEventName;", Event.PROPERTIES_KEY, "", "", "", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "dateTime", "Ljava/util/Date;", "(Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEventName;Ljava/util/Map;Lcom/revenuecat/purchases/common/DateProvider;Ljava/util/Date;)V", "getDateProvider", "()Lcom/revenuecat/purchases/common/DateProvider;", "getDateTime", "()Ljava/util/Date;", "getName", "()Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEventName;", "getProperties", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Event extends DiagnosticsEntry {
        private static final Companion Companion = new Companion(null);

        @Deprecated
        public static final String NAME_KEY = "name";

        @Deprecated
        public static final String PROPERTIES_KEY = "properties";

        @Deprecated
        public static final String TIMESTAMP_KEY = "timestamp";
        private final DateProvider dateProvider;
        private final Date dateTime;
        private final DiagnosticsEventName name;
        private final Map<String, Object> properties;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Event copy$default(Event event, DiagnosticsEventName diagnosticsEventName, Map map, DateProvider dateProvider, Date date, int i, Object obj) {
            if ((i & 1) != 0) {
                diagnosticsEventName = event.name;
            }
            if ((i & 2) != 0) {
                map = event.properties;
            }
            if ((i & 4) != 0) {
                dateProvider = event.dateProvider;
            }
            if ((i & 8) != 0) {
                date = event.dateTime;
            }
            return event.copy(diagnosticsEventName, map, dateProvider, date);
        }

        /* renamed from: component1, reason: from getter */
        public final DiagnosticsEventName getName() {
            return this.name;
        }

        public final Map<String, Object> component2() {
            return this.properties;
        }

        /* renamed from: component3, reason: from getter */
        public final DateProvider getDateProvider() {
            return this.dateProvider;
        }

        /* renamed from: component4, reason: from getter */
        public final Date getDateTime() {
            return this.dateTime;
        }

        public final Event copy(DiagnosticsEventName name, Map<String, ? extends Object> properties, DateProvider dateProvider, Date dateTime) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(properties, "properties");
            Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
            Intrinsics.checkNotNullParameter(dateTime, "dateTime");
            return new Event(name, properties, dateProvider, dateTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Event)) {
                return false;
            }
            Event event = (Event) other;
            return this.name == event.name && Intrinsics.areEqual(this.properties, event.properties) && Intrinsics.areEqual(this.dateProvider, event.dateProvider) && Intrinsics.areEqual(this.dateTime, event.dateTime);
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.properties.hashCode()) * 31) + this.dateProvider.hashCode()) * 31) + this.dateTime.hashCode();
        }

        public final DiagnosticsEventName getName() {
            return this.name;
        }

        public final Map<String, Object> getProperties() {
            return this.properties;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ Event(com.revenuecat.purchases.common.diagnostics.DiagnosticsEventName r1, java.util.Map r2, com.revenuecat.purchases.common.DateProvider r3, java.util.Date r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
            /*
                r0 = this;
                r6 = r5 & 4
                if (r6 == 0) goto Lb
                com.revenuecat.purchases.common.DefaultDateProvider r3 = new com.revenuecat.purchases.common.DefaultDateProvider
                r3.<init>()
                com.revenuecat.purchases.common.DateProvider r3 = (com.revenuecat.purchases.common.DateProvider) r3
            Lb:
                r5 = r5 & 8
                if (r5 == 0) goto L13
                java.util.Date r4 = r3.getNow()
            L13:
                r0.<init>(r1, r2, r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry.Event.<init>(com.revenuecat.purchases.common.diagnostics.DiagnosticsEventName, java.util.Map, com.revenuecat.purchases.common.DateProvider, java.util.Date, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final DateProvider getDateProvider() {
            return this.dateProvider;
        }

        public final Date getDateTime() {
            return this.dateTime;
        }

        /* compiled from: DiagnosticsEntry.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry$Event$Companion;", "", "()V", "NAME_KEY", "", "PROPERTIES_KEY", "TIMESTAMP_KEY", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Event(DiagnosticsEventName name, Map<String, ? extends Object> properties, DateProvider dateProvider, Date dateTime) {
            super(NotificationCompat.CATEGORY_EVENT, null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(properties, "properties");
            Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
            Intrinsics.checkNotNullParameter(dateTime, "dateTime");
            this.name = name;
            this.properties = properties;
            this.dateProvider = dateProvider;
            this.dateTime = dateTime;
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            String jSONObject = toJSONObject().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toJSONObject().toString()");
            return jSONObject;
        }

        private final JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", 1);
            jSONObject.put("type", getDiagnosticType());
            String lowerCase = this.name.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            jSONObject.put("name", lowerCase);
            jSONObject.put(PROPERTIES_KEY, new JSONObject(this.properties));
            jSONObject.put("timestamp", this.dateTime.getTime());
            return jSONObject;
        }
    }

    /* compiled from: DiagnosticsEntry.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry$Counter;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry;", "name", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsCounterName;", "tags", "", "", "value", "", "(Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsCounterName;Ljava/util/Map;I)V", "getName", "()Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsCounterName;", "getTags", "()Ljava/util/Map;", "getValue", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toJSONObject", "Lorg/json/JSONObject;", "toString", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Counter extends DiagnosticsEntry {
        private static final Companion Companion = new Companion(null);

        @Deprecated
        public static final String NAME_KEY = "name";

        @Deprecated
        public static final String TAGS_KEY = "tags";

        @Deprecated
        public static final String VALUE_KEY = "value";
        private final DiagnosticsCounterName name;
        private final Map<String, String> tags;
        private final int value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Counter copy$default(Counter counter, DiagnosticsCounterName diagnosticsCounterName, Map map, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                diagnosticsCounterName = counter.name;
            }
            if ((i2 & 2) != 0) {
                map = counter.tags;
            }
            if ((i2 & 4) != 0) {
                i = counter.value;
            }
            return counter.copy(diagnosticsCounterName, map, i);
        }

        /* renamed from: component1, reason: from getter */
        public final DiagnosticsCounterName getName() {
            return this.name;
        }

        public final Map<String, String> component2() {
            return this.tags;
        }

        /* renamed from: component3, reason: from getter */
        public final int getValue() {
            return this.value;
        }

        public final Counter copy(DiagnosticsCounterName name, Map<String, String> tags, int value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(tags, "tags");
            return new Counter(name, tags, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Counter)) {
                return false;
            }
            Counter counter = (Counter) other;
            return this.name == counter.name && Intrinsics.areEqual(this.tags, counter.tags) && this.value == counter.value;
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + this.tags.hashCode()) * 31) + this.value;
        }

        public final DiagnosticsCounterName getName() {
            return this.name;
        }

        public final Map<String, String> getTags() {
            return this.tags;
        }

        public final int getValue() {
            return this.value;
        }

        /* compiled from: DiagnosticsEntry.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry$Counter$Companion;", "", "()V", "NAME_KEY", "", "TAGS_KEY", "VALUE_KEY", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Counter(DiagnosticsCounterName name, Map<String, String> tags, int i) {
            super("counter", null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(tags, "tags");
            this.name = name;
            this.tags = tags;
            this.value = i;
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            String jSONObject = toJSONObject().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toJSONObject().toString()");
            return jSONObject;
        }

        private final JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", 1);
            jSONObject.put("type", getDiagnosticType());
            String lowerCase = this.name.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            jSONObject.put("name", lowerCase);
            jSONObject.put("tags", new JSONObject(this.tags));
            jSONObject.put("value", this.value);
            return jSONObject;
        }
    }

    /* compiled from: DiagnosticsEntry.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry$Histogram;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry;", "name", "", "tags", "", Histogram.VALUES_KEY, "", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getTags", "()Ljava/util/Map;", "getValues", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Histogram extends DiagnosticsEntry {
        private static final Companion Companion = new Companion(null);

        @Deprecated
        public static final String NAME_KEY = "name";

        @Deprecated
        public static final String TAGS_KEY = "tags";

        @Deprecated
        public static final String VALUES_KEY = "values";
        private final String name;
        private final Map<String, String> tags;
        private final List<Double> values;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Histogram copy$default(Histogram histogram, String str, Map map, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = histogram.name;
            }
            if ((i & 2) != 0) {
                map = histogram.tags;
            }
            if ((i & 4) != 0) {
                list = histogram.values;
            }
            return histogram.copy(str, map, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Map<String, String> component2() {
            return this.tags;
        }

        public final List<Double> component3() {
            return this.values;
        }

        public final Histogram copy(String name, Map<String, String> tags, List<Double> values) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Intrinsics.checkNotNullParameter(values, "values");
            return new Histogram(name, tags, values);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Histogram)) {
                return false;
            }
            Histogram histogram = (Histogram) other;
            return Intrinsics.areEqual(this.name, histogram.name) && Intrinsics.areEqual(this.tags, histogram.tags) && Intrinsics.areEqual(this.values, histogram.values);
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + this.tags.hashCode()) * 31) + this.values.hashCode();
        }

        public final String getName() {
            return this.name;
        }

        public final Map<String, String> getTags() {
            return this.tags;
        }

        public final List<Double> getValues() {
            return this.values;
        }

        /* compiled from: DiagnosticsEntry.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry$Histogram$Companion;", "", "()V", "NAME_KEY", "", "TAGS_KEY", "VALUES_KEY", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Histogram(String name, Map<String, String> tags, List<Double> values) {
            super("histogram", null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Intrinsics.checkNotNullParameter(values, "values");
            this.name = name;
            this.tags = tags;
            this.values = values;
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            String jSONObject = toJSONObject().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toJSONObject().toString()");
            return jSONObject;
        }

        private final JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", 1);
            jSONObject.put("type", getDiagnosticType());
            String lowerCase = this.name.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            jSONObject.put("name", lowerCase);
            jSONObject.put("tags", new JSONObject(this.tags));
            jSONObject.put(VALUES_KEY, new JSONArray((Collection) this.values));
            return jSONObject;
        }
    }
}
