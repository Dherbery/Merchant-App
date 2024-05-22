package com.revenuecat.purchases.paywalls;

import com.facebook.common.util.UriUtil;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.utils.LocaleExtensionsKt;
import com.revenuecat.purchases.utils.serializers.OptionalURLSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: PaywallData.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0004>?@AB[\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010B;\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u0011J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fHÀ\u0003¢\u0006\u0002\b,J\u0012\u0010-\u001a\u0004\u0018\u00010\r2\u0006\u0010.\u001a\u00020\u001aH\u0007JG\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r0\u00192\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001a05H\u0007J\t\u00106\u001a\u00020\u0005HÖ\u0001J!\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=HÇ\u0001R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r0\u00198CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r0\u00198G¢\u0006\u0006\u001a\u0004\b!\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010&¨\u0006B"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData;", "", "seen1", "", "templateName", "", "config", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "assetBaseURL", "Ljava/net/URL;", "revision", "localization", "", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;Ljava/net/URL;ILjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;Ljava/net/URL;ILjava/util/Map;)V", "getAssetBaseURL$annotations", "()V", "getAssetBaseURL", "()Ljava/net/URL;", "getConfig", "()Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "fallbackLocalizedConfiguration", "Lkotlin/Pair;", "Ljava/util/Locale;", "getFallbackLocalizedConfiguration", "()Lkotlin/Pair;", "getLocalization$purchases_defaultsRelease$annotations", "getLocalization$purchases_defaultsRelease", "()Ljava/util/Map;", "localizedConfiguration", "getLocalizedConfiguration", "getRevision", "()I", "getTemplateName$annotations", "getTemplateName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component5$purchases_defaultsRelease", "configForLocale", "requiredLocale", "copy", "equals", "", "other", "hashCode", "locales", "", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "Configuration", "LocalizedConfiguration", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class PaywallData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final URL assetBaseURL;
    private final Configuration config;
    private final Map<String, LocalizedConfiguration> localization;
    private final int revision;
    private final String templateName;

    public static /* synthetic */ PaywallData copy$default(PaywallData paywallData, String str, Configuration configuration, URL url, int i, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paywallData.templateName;
        }
        if ((i2 & 2) != 0) {
            configuration = paywallData.config;
        }
        Configuration configuration2 = configuration;
        if ((i2 & 4) != 0) {
            url = paywallData.assetBaseURL;
        }
        URL url2 = url;
        if ((i2 & 8) != 0) {
            i = paywallData.revision;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            map = paywallData.localization;
        }
        return paywallData.copy(str, configuration2, url2, i3, map);
    }

    @SerialName("asset_base_url")
    @Serializable(with = URLSerializer.class)
    public static /* synthetic */ void getAssetBaseURL$annotations() {
    }

    @SerialName("localized_strings")
    public static /* synthetic */ void getLocalization$purchases_defaultsRelease$annotations() {
    }

    @SerialName("template_name")
    public static /* synthetic */ void getTemplateName$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getTemplateName() {
        return this.templateName;
    }

    /* renamed from: component2, reason: from getter */
    public final Configuration getConfig() {
        return this.config;
    }

    /* renamed from: component3, reason: from getter */
    public final URL getAssetBaseURL() {
        return this.assetBaseURL;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    public final Map<String, LocalizedConfiguration> component5$purchases_defaultsRelease() {
        return this.localization;
    }

    public final PaywallData copy(String templateName, Configuration config, URL assetBaseURL, int revision, Map<String, LocalizedConfiguration> localization) {
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(assetBaseURL, "assetBaseURL");
        Intrinsics.checkNotNullParameter(localization, "localization");
        return new PaywallData(templateName, config, assetBaseURL, revision, localization);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaywallData)) {
            return false;
        }
        PaywallData paywallData = (PaywallData) other;
        return Intrinsics.areEqual(this.templateName, paywallData.templateName) && Intrinsics.areEqual(this.config, paywallData.config) && Intrinsics.areEqual(this.assetBaseURL, paywallData.assetBaseURL) && this.revision == paywallData.revision && Intrinsics.areEqual(this.localization, paywallData.localization);
    }

    public int hashCode() {
        return (((((((this.templateName.hashCode() * 31) + this.config.hashCode()) * 31) + this.assetBaseURL.hashCode()) * 31) + this.revision) * 31) + this.localization.hashCode();
    }

    public String toString() {
        return "PaywallData(templateName=" + this.templateName + ", config=" + this.config + ", assetBaseURL=" + this.assetBaseURL + ", revision=" + this.revision + ", localization=" + this.localization + ')';
    }

    /* compiled from: PaywallData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PaywallData> serializer() {
            return PaywallData$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PaywallData(int i, @SerialName("template_name") String str, Configuration configuration, @SerialName("asset_base_url") @Serializable(with = URLSerializer.class) URL url, int i2, @SerialName("localized_strings") Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (23 != (i & 23)) {
            PluginExceptionsKt.throwMissingFieldException(i, 23, PaywallData$$serializer.INSTANCE.getDescriptor());
        }
        this.templateName = str;
        this.config = configuration;
        this.assetBaseURL = url;
        if ((i & 8) == 0) {
            this.revision = 0;
        } else {
            this.revision = i2;
        }
        this.localization = map;
    }

    public PaywallData(String templateName, Configuration config, URL assetBaseURL, int i, Map<String, LocalizedConfiguration> localization) {
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(assetBaseURL, "assetBaseURL");
        Intrinsics.checkNotNullParameter(localization, "localization");
        this.templateName = templateName;
        this.config = config;
        this.assetBaseURL = assetBaseURL;
        this.revision = i;
        this.localization = localization;
    }

    @JvmStatic
    public static final void write$Self(PaywallData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.templateName);
        output.encodeSerializableElement(serialDesc, 1, PaywallData$Configuration$$serializer.INSTANCE, self.config);
        output.encodeSerializableElement(serialDesc, 2, URLSerializer.INSTANCE, self.assetBaseURL);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.revision != 0) {
            output.encodeIntElement(serialDesc, 3, self.revision);
        }
        output.encodeSerializableElement(serialDesc, 4, new LinkedHashMapSerializer(StringSerializer.INSTANCE, PaywallData$LocalizedConfiguration$$serializer.INSTANCE), self.localization);
    }

    public /* synthetic */ PaywallData(String str, Configuration configuration, URL url, int i, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, configuration, url, (i2 & 8) != 0 ? 0 : i, map);
    }

    public final String getTemplateName() {
        return this.templateName;
    }

    public final Configuration getConfig() {
        return this.config;
    }

    public final URL getAssetBaseURL() {
        return this.assetBaseURL;
    }

    public final int getRevision() {
        return this.revision;
    }

    public final Map<String, LocalizedConfiguration> getLocalization$purchases_defaultsRelease() {
        return this.localization;
    }

    public final Pair<Locale, LocalizedConfiguration> getLocalizedConfiguration() {
        return localizedConfiguration(LocaleExtensionsKt.getDefaultLocales());
    }

    public final Pair<Locale, LocalizedConfiguration> localizedConfiguration(List<Locale> locales) {
        Intrinsics.checkNotNullParameter(locales, "locales");
        Iterator<Locale> it = locales.iterator();
        while (it.hasNext()) {
            Locale convertToCorrectlyFormattedLocale = LocaleExtensionsKt.convertToCorrectlyFormattedLocale(it.next());
            LocalizedConfiguration configForLocale = configForLocale(convertToCorrectlyFormattedLocale);
            if (configForLocale != null) {
                return TuplesKt.to(convertToCorrectlyFormattedLocale, configForLocale);
            }
        }
        return getFallbackLocalizedConfiguration();
    }

    private final Pair<Locale, LocalizedConfiguration> getFallbackLocalizedConfiguration() {
        Map.Entry entry = (Map.Entry) CollectionsKt.first(this.localization.entrySet());
        return TuplesKt.to(LocaleExtensionsKt.toLocale((String) entry.getKey()), entry.getValue());
    }

    public final LocalizedConfiguration configForLocale(Locale requiredLocale) {
        Object obj;
        Intrinsics.checkNotNullParameter(requiredLocale, "requiredLocale");
        LocalizedConfiguration localizedConfiguration = this.localization.get(requiredLocale.toString());
        if (localizedConfiguration != null) {
            return localizedConfiguration;
        }
        Iterator<T> it = this.localization.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (LocaleExtensionsKt.sharedLanguageCodeWith(requiredLocale, LocaleExtensionsKt.toLocale((String) ((Map.Entry) obj).getKey()))) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            return (LocalizedConfiguration) entry.getValue();
        }
        return null;
    }

    /* compiled from: PaywallData.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 L2\u00020\u0001:\u0005IJKLMB]\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010B\u0085\u0001\b\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017Bk\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0018J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b5J\u0010\u00106\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b7J\t\u00108\u001a\u00020\u000bHÆ\u0003J\t\u00109\u001a\u00020\u000bHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003Js\u0010=\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010>\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0012HÖ\u0001J\t\u0010A\u001a\u00020\u0004HÖ\u0001J!\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HHÇ\u0001R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u001c\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010%R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010%R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001a\u001a\u0004\b+\u0010,R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u001a\u001a\u0004\b.\u0010/R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001a\u001a\u0004\b1\u0010/¨\u0006N"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "", "packageIds", "", "", "defaultPackage", "images", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;", "colors", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "blurredBackgroundImage", "", "displayRestorePurchases", "termsOfServiceURL", "Ljava/net/URL;", "privacyURL", "(Ljava/util/List;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;ZZLjava/net/URL;Ljava/net/URL;)V", "seen1", "", "imagesWebp", "legacyImages", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;ZZLjava/net/URL;Ljava/net/URL;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;ZZLjava/net/URL;Ljava/net/URL;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;)V", "getBlurredBackgroundImage$annotations", "()V", "getBlurredBackgroundImage", "()Z", "getColors", "()Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "getDefaultPackage$annotations", "getDefaultPackage", "()Ljava/lang/String;", "getDisplayRestorePurchases$annotations", "getDisplayRestorePurchases", "getImages", "()Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;", "getImagesWebp$purchases_defaultsRelease$annotations", "getImagesWebp$purchases_defaultsRelease", "getLegacyImages$purchases_defaultsRelease$annotations", "getLegacyImages$purchases_defaultsRelease", "getPackageIds$annotations", "getPackageIds", "()Ljava/util/List;", "getPrivacyURL$annotations", "getPrivacyURL", "()Ljava/net/URL;", "getTermsOfServiceURL$annotations", "getTermsOfServiceURL", "component1", "component2", "component3", "component3$purchases_defaultsRelease", "component4", "component4$purchases_defaultsRelease", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "ColorInformation", "Colors", "Companion", "Images", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* loaded from: classes5.dex */
    public static final /* data */ class Configuration {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean blurredBackgroundImage;
        private final ColorInformation colors;
        private final String defaultPackage;
        private final boolean displayRestorePurchases;
        private final Images imagesWebp;
        private final Images legacyImages;
        private final List<String> packageIds;
        private final URL privacyURL;
        private final URL termsOfServiceURL;

        @SerialName("blurred_background_image")
        public static /* synthetic */ void getBlurredBackgroundImage$annotations() {
        }

        @SerialName("default_package")
        public static /* synthetic */ void getDefaultPackage$annotations() {
        }

        @SerialName("display_restore_purchases")
        public static /* synthetic */ void getDisplayRestorePurchases$annotations() {
        }

        @SerialName("images_webp")
        public static /* synthetic */ void getImagesWebp$purchases_defaultsRelease$annotations() {
        }

        @SerialName("images")
        public static /* synthetic */ void getLegacyImages$purchases_defaultsRelease$annotations() {
        }

        @SerialName("packages")
        public static /* synthetic */ void getPackageIds$annotations() {
        }

        @SerialName("privacy_url")
        @Serializable(with = OptionalURLSerializer.class)
        public static /* synthetic */ void getPrivacyURL$annotations() {
        }

        @SerialName("tos_url")
        @Serializable(with = OptionalURLSerializer.class)
        public static /* synthetic */ void getTermsOfServiceURL$annotations() {
        }

        public final List<String> component1() {
            return this.packageIds;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDefaultPackage() {
            return this.defaultPackage;
        }

        /* renamed from: component3$purchases_defaultsRelease, reason: from getter */
        public final Images getImagesWebp() {
            return this.imagesWebp;
        }

        /* renamed from: component4$purchases_defaultsRelease, reason: from getter */
        public final Images getLegacyImages() {
            return this.legacyImages;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getBlurredBackgroundImage() {
            return this.blurredBackgroundImage;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getDisplayRestorePurchases() {
            return this.displayRestorePurchases;
        }

        /* renamed from: component7, reason: from getter */
        public final URL getTermsOfServiceURL() {
            return this.termsOfServiceURL;
        }

        /* renamed from: component8, reason: from getter */
        public final URL getPrivacyURL() {
            return this.privacyURL;
        }

        /* renamed from: component9, reason: from getter */
        public final ColorInformation getColors() {
            return this.colors;
        }

        public final Configuration copy(List<String> packageIds, String defaultPackage, Images imagesWebp, Images legacyImages, boolean blurredBackgroundImage, boolean displayRestorePurchases, URL termsOfServiceURL, URL privacyURL, ColorInformation colors) {
            Intrinsics.checkNotNullParameter(packageIds, "packageIds");
            Intrinsics.checkNotNullParameter(colors, "colors");
            return new Configuration(packageIds, defaultPackage, imagesWebp, legacyImages, blurredBackgroundImage, displayRestorePurchases, termsOfServiceURL, privacyURL, colors);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) other;
            return Intrinsics.areEqual(this.packageIds, configuration.packageIds) && Intrinsics.areEqual(this.defaultPackage, configuration.defaultPackage) && Intrinsics.areEqual(this.imagesWebp, configuration.imagesWebp) && Intrinsics.areEqual(this.legacyImages, configuration.legacyImages) && this.blurredBackgroundImage == configuration.blurredBackgroundImage && this.displayRestorePurchases == configuration.displayRestorePurchases && Intrinsics.areEqual(this.termsOfServiceURL, configuration.termsOfServiceURL) && Intrinsics.areEqual(this.privacyURL, configuration.privacyURL) && Intrinsics.areEqual(this.colors, configuration.colors);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.packageIds.hashCode() * 31;
            String str = this.defaultPackage;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Images images = this.imagesWebp;
            int hashCode3 = (hashCode2 + (images == null ? 0 : images.hashCode())) * 31;
            Images images2 = this.legacyImages;
            int hashCode4 = (hashCode3 + (images2 == null ? 0 : images2.hashCode())) * 31;
            boolean z = this.blurredBackgroundImage;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode4 + i) * 31;
            boolean z2 = this.displayRestorePurchases;
            int i3 = (i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
            URL url = this.termsOfServiceURL;
            int hashCode5 = (i3 + (url == null ? 0 : url.hashCode())) * 31;
            URL url2 = this.privacyURL;
            return ((hashCode5 + (url2 != null ? url2.hashCode() : 0)) * 31) + this.colors.hashCode();
        }

        public String toString() {
            return "Configuration(packageIds=" + this.packageIds + ", defaultPackage=" + this.defaultPackage + ", imagesWebp=" + this.imagesWebp + ", legacyImages=" + this.legacyImages + ", blurredBackgroundImage=" + this.blurredBackgroundImage + ", displayRestorePurchases=" + this.displayRestorePurchases + ", termsOfServiceURL=" + this.termsOfServiceURL + ", privacyURL=" + this.privacyURL + ", colors=" + this.colors + ')';
        }

        /* compiled from: PaywallData.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Configuration> serializer() {
                return PaywallData$Configuration$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Configuration(int i, @SerialName("packages") List list, @SerialName("default_package") String str, @SerialName("images_webp") Images images, @SerialName("images") Images images2, @SerialName("blurred_background_image") boolean z, @SerialName("display_restore_purchases") boolean z2, @SerialName("tos_url") @Serializable(with = OptionalURLSerializer.class) URL url, @SerialName("privacy_url") @Serializable(with = OptionalURLSerializer.class) URL url2, ColorInformation colorInformation, SerializationConstructorMarker serializationConstructorMarker) {
            if (257 != (i & 257)) {
                PluginExceptionsKt.throwMissingFieldException(i, 257, PaywallData$Configuration$$serializer.INSTANCE.getDescriptor());
            }
            this.packageIds = list;
            if ((i & 2) == 0) {
                this.defaultPackage = null;
            } else {
                this.defaultPackage = str;
            }
            if ((i & 4) == 0) {
                this.imagesWebp = null;
            } else {
                this.imagesWebp = images;
            }
            if ((i & 8) == 0) {
                this.legacyImages = null;
            } else {
                this.legacyImages = images2;
            }
            if ((i & 16) == 0) {
                this.blurredBackgroundImage = false;
            } else {
                this.blurredBackgroundImage = z;
            }
            if ((i & 32) == 0) {
                this.displayRestorePurchases = true;
            } else {
                this.displayRestorePurchases = z2;
            }
            if ((i & 64) == 0) {
                this.termsOfServiceURL = null;
            } else {
                this.termsOfServiceURL = url;
            }
            if ((i & 128) == 0) {
                this.privacyURL = null;
            } else {
                this.privacyURL = url2;
            }
            this.colors = colorInformation;
        }

        public Configuration(List<String> packageIds, String str, Images images, Images images2, boolean z, boolean z2, URL url, URL url2, ColorInformation colors) {
            Intrinsics.checkNotNullParameter(packageIds, "packageIds");
            Intrinsics.checkNotNullParameter(colors, "colors");
            this.packageIds = packageIds;
            this.defaultPackage = str;
            this.imagesWebp = images;
            this.legacyImages = images2;
            this.blurredBackgroundImage = z;
            this.displayRestorePurchases = z2;
            this.termsOfServiceURL = url;
            this.privacyURL = url2;
            this.colors = colors;
        }

        @JvmStatic
        public static final void write$Self(Configuration self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            output.encodeSerializableElement(serialDesc, 0, new ArrayListSerializer(StringSerializer.INSTANCE), self.packageIds);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.defaultPackage != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.defaultPackage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.imagesWebp != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, PaywallData$Configuration$Images$$serializer.INSTANCE, self.imagesWebp);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.legacyImages != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, PaywallData$Configuration$Images$$serializer.INSTANCE, self.legacyImages);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.blurredBackgroundImage) {
                output.encodeBooleanElement(serialDesc, 4, self.blurredBackgroundImage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || !self.displayRestorePurchases) {
                output.encodeBooleanElement(serialDesc, 5, self.displayRestorePurchases);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.termsOfServiceURL != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, OptionalURLSerializer.INSTANCE, self.termsOfServiceURL);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.privacyURL != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, OptionalURLSerializer.INSTANCE, self.privacyURL);
            }
            output.encodeSerializableElement(serialDesc, 8, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, self.colors);
        }

        public /* synthetic */ Configuration(List list, String str, Images images, Images images2, boolean z, boolean z2, URL url, URL url2, ColorInformation colorInformation, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : images, (i & 8) != 0 ? null : images2, (i & 16) != 0 ? false : z, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? null : url, (i & 128) != 0 ? null : url2, colorInformation);
        }

        public final List<String> getPackageIds() {
            return this.packageIds;
        }

        public final String getDefaultPackage() {
            return this.defaultPackage;
        }

        public final Images getImagesWebp$purchases_defaultsRelease() {
            return this.imagesWebp;
        }

        public final Images getLegacyImages$purchases_defaultsRelease() {
            return this.legacyImages;
        }

        public final boolean getBlurredBackgroundImage() {
            return this.blurredBackgroundImage;
        }

        public final boolean getDisplayRestorePurchases() {
            return this.displayRestorePurchases;
        }

        public final URL getTermsOfServiceURL() {
            return this.termsOfServiceURL;
        }

        public final URL getPrivacyURL() {
            return this.privacyURL;
        }

        public final ColorInformation getColors() {
            return this.colors;
        }

        public /* synthetic */ Configuration(List list, String str, Images images, ColorInformation colorInformation, boolean z, boolean z2, URL url, URL url2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? null : str, images, colorInformation, (i & 16) != 0 ? false : z, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? null : url, (i & 128) != 0 ? null : url2);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Configuration(List<String> packageIds, String str, Images images, ColorInformation colors, boolean z, boolean z2, URL url, URL url2) {
            this(packageIds, str, images, (Images) null, z, z2, url, url2, colors, 8, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(packageIds, "packageIds");
            Intrinsics.checkNotNullParameter(images, "images");
            Intrinsics.checkNotNullParameter(colors, "colors");
        }

        public final Images getImages() {
            String header;
            String background;
            String icon;
            Images images = this.imagesWebp;
            String str = null;
            if (images == null || (header = images.getHeader()) == null) {
                Images images2 = this.legacyImages;
                header = images2 != null ? images2.getHeader() : null;
            }
            Images images3 = this.imagesWebp;
            if (images3 == null || (background = images3.getBackground()) == null) {
                Images images4 = this.legacyImages;
                background = images4 != null ? images4.getBackground() : null;
            }
            Images images5 = this.imagesWebp;
            if (images5 == null || (icon = images5.getIcon()) == null) {
                Images images6 = this.legacyImages;
                if (images6 != null) {
                    str = images6.getIcon();
                }
            } else {
                str = icon;
            }
            return new Images(header, background, str);
        }

        /* compiled from: PaywallData.kt */
        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B=\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J!\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'HÇ\u0001R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013¨\u0006*"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;", "", "seen1", "", "header", "", AppStateModule.APP_STATE_BACKGROUND, "icon", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", TtmlNode.COMBINE_ALL, "", "getAll$purchases_defaultsRelease", "()Ljava/util/List;", "getBackground$annotations", "()V", "getBackground", "()Ljava/lang/String;", "getHeader$annotations", "getHeader", "getIcon$annotations", "getIcon", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @Serializable
        /* loaded from: classes5.dex */
        public static final /* data */ class Images {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String background;
            private final String header;
            private final String icon;

            public Images() {
                this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Images copy$default(Images images, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = images.header;
                }
                if ((i & 2) != 0) {
                    str2 = images.background;
                }
                if ((i & 4) != 0) {
                    str3 = images.icon;
                }
                return images.copy(str, str2, str3);
            }

            @Serializable(with = EmptyStringToNullSerializer.class)
            public static /* synthetic */ void getBackground$annotations() {
            }

            @Serializable(with = EmptyStringToNullSerializer.class)
            public static /* synthetic */ void getHeader$annotations() {
            }

            @Serializable(with = EmptyStringToNullSerializer.class)
            public static /* synthetic */ void getIcon$annotations() {
            }

            /* renamed from: component1, reason: from getter */
            public final String getHeader() {
                return this.header;
            }

            /* renamed from: component2, reason: from getter */
            public final String getBackground() {
                return this.background;
            }

            /* renamed from: component3, reason: from getter */
            public final String getIcon() {
                return this.icon;
            }

            public final Images copy(String header, String background, String icon) {
                return new Images(header, background, icon);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Images)) {
                    return false;
                }
                Images images = (Images) other;
                return Intrinsics.areEqual(this.header, images.header) && Intrinsics.areEqual(this.background, images.background) && Intrinsics.areEqual(this.icon, images.icon);
            }

            public int hashCode() {
                String str = this.header;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.background;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.icon;
                return hashCode2 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "Images(header=" + this.header + ", background=" + this.background + ", icon=" + this.icon + ')';
            }

            /* compiled from: PaywallData.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes5.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Images> serializer() {
                    return PaywallData$Configuration$Images$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ Images(int i, @Serializable(with = EmptyStringToNullSerializer.class) String str, @Serializable(with = EmptyStringToNullSerializer.class) String str2, @Serializable(with = EmptyStringToNullSerializer.class) String str3, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 0) != 0) {
                    PluginExceptionsKt.throwMissingFieldException(i, 0, PaywallData$Configuration$Images$$serializer.INSTANCE.getDescriptor());
                }
                if ((i & 1) == 0) {
                    this.header = null;
                } else {
                    this.header = str;
                }
                if ((i & 2) == 0) {
                    this.background = null;
                } else {
                    this.background = str2;
                }
                if ((i & 4) == 0) {
                    this.icon = null;
                } else {
                    this.icon = str3;
                }
            }

            public Images(String str, String str2, String str3) {
                this.header = str;
                this.background = str2;
                this.icon = str3;
            }

            @JvmStatic
            public static final void write$Self(Images self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Intrinsics.checkNotNullParameter(self, "self");
                Intrinsics.checkNotNullParameter(output, "output");
                Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.header != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, EmptyStringToNullSerializer.INSTANCE, self.header);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.background != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, EmptyStringToNullSerializer.INSTANCE, self.background);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.icon != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, EmptyStringToNullSerializer.INSTANCE, self.icon);
                }
            }

            public /* synthetic */ Images(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            public final String getHeader() {
                return this.header;
            }

            public final String getBackground() {
                return this.background;
            }

            public final String getIcon() {
                return this.icon;
            }

            public final List<String> getAll$purchases_defaultsRelease() {
                return CollectionsKt.listOfNotNull((Object[]) new String[]{this.header, this.background, this.icon});
            }
        }

        /* compiled from: PaywallData.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J!\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dHÇ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006 "}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "", "seen1", "", "light", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "dark", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;)V", "getDark", "()Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "getLight", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @Serializable
        /* loaded from: classes5.dex */
        public static final /* data */ class ColorInformation {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final Colors dark;
            private final Colors light;

            public static /* synthetic */ ColorInformation copy$default(ColorInformation colorInformation, Colors colors, Colors colors2, int i, Object obj) {
                if ((i & 1) != 0) {
                    colors = colorInformation.light;
                }
                if ((i & 2) != 0) {
                    colors2 = colorInformation.dark;
                }
                return colorInformation.copy(colors, colors2);
            }

            /* renamed from: component1, reason: from getter */
            public final Colors getLight() {
                return this.light;
            }

            /* renamed from: component2, reason: from getter */
            public final Colors getDark() {
                return this.dark;
            }

            public final ColorInformation copy(Colors light, Colors dark) {
                Intrinsics.checkNotNullParameter(light, "light");
                return new ColorInformation(light, dark);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ColorInformation)) {
                    return false;
                }
                ColorInformation colorInformation = (ColorInformation) other;
                return Intrinsics.areEqual(this.light, colorInformation.light) && Intrinsics.areEqual(this.dark, colorInformation.dark);
            }

            public int hashCode() {
                int hashCode = this.light.hashCode() * 31;
                Colors colors = this.dark;
                return hashCode + (colors == null ? 0 : colors.hashCode());
            }

            public String toString() {
                return "ColorInformation(light=" + this.light + ", dark=" + this.dark + ')';
            }

            /* compiled from: PaywallData.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes5.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<ColorInformation> serializer() {
                    return PaywallData$Configuration$ColorInformation$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ ColorInformation(int i, Colors colors, Colors colors2, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE.getDescriptor());
                }
                this.light = colors;
                if ((i & 2) == 0) {
                    this.dark = null;
                } else {
                    this.dark = colors2;
                }
            }

            public ColorInformation(Colors light, Colors colors) {
                Intrinsics.checkNotNullParameter(light, "light");
                this.light = light;
                this.dark = colors;
            }

            @JvmStatic
            public static final void write$Self(ColorInformation self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Intrinsics.checkNotNullParameter(self, "self");
                Intrinsics.checkNotNullParameter(output, "output");
                Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
                output.encodeSerializableElement(serialDesc, 0, PaywallData$Configuration$Colors$$serializer.INSTANCE, self.light);
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.dark != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, PaywallData$Configuration$Colors$$serializer.INSTANCE, self.dark);
                }
            }

            public /* synthetic */ ColorInformation(Colors colors, Colors colors2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(colors, (i & 2) != 0 ? null : colors2);
            }

            public final Colors getLight() {
                return this.light;
            }

            public final Colors getDark() {
                return this.dark;
            }
        }

        /* compiled from: PaywallData.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 B2\u00020\u0001:\u0002ABB\u0091\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011Bm\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0012J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jy\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001J!\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@HÇ\u0001R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0014\u001a\u0004\b(\u0010\u0016¨\u0006C"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "", "seen1", "", AppStateModule.APP_STATE_BACKGROUND, "Lcom/revenuecat/purchases/paywalls/PaywallColor;", "text1", "text2", "text3", "callToActionBackground", "callToActionForeground", "callToActionSecondaryBackground", "accent1", "accent2", "accent3", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;)V", "getAccent1$annotations", "()V", "getAccent1", "()Lcom/revenuecat/purchases/paywalls/PaywallColor;", "getAccent2$annotations", "getAccent2", "getAccent3$annotations", "getAccent3", "getBackground$annotations", "getBackground", "getCallToActionBackground$annotations", "getCallToActionBackground", "getCallToActionForeground$annotations", "getCallToActionForeground", "getCallToActionSecondaryBackground$annotations", "getCallToActionSecondaryBackground", "getText1$annotations", "getText1", "getText2$annotations", "getText2", "getText3$annotations", "getText3", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @Serializable
        /* loaded from: classes5.dex */
        public static final /* data */ class Colors {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final PaywallColor accent1;
            private final PaywallColor accent2;
            private final PaywallColor accent3;
            private final PaywallColor background;
            private final PaywallColor callToActionBackground;
            private final PaywallColor callToActionForeground;
            private final PaywallColor callToActionSecondaryBackground;
            private final PaywallColor text1;
            private final PaywallColor text2;
            private final PaywallColor text3;

            @SerialName("accent_1")
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getAccent1$annotations() {
            }

            @SerialName("accent_2")
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getAccent2$annotations() {
            }

            @SerialName("accent_3")
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getAccent3$annotations() {
            }

            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getBackground$annotations() {
            }

            @SerialName("call_to_action_background")
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getCallToActionBackground$annotations() {
            }

            @SerialName("call_to_action_foreground")
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getCallToActionForeground$annotations() {
            }

            @SerialName("call_to_action_secondary_background")
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getCallToActionSecondaryBackground$annotations() {
            }

            @SerialName("text_1")
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getText1$annotations() {
            }

            @SerialName("text_2")
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getText2$annotations() {
            }

            @SerialName("text_3")
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getText3$annotations() {
            }

            /* renamed from: component1, reason: from getter */
            public final PaywallColor getBackground() {
                return this.background;
            }

            /* renamed from: component10, reason: from getter */
            public final PaywallColor getAccent3() {
                return this.accent3;
            }

            /* renamed from: component2, reason: from getter */
            public final PaywallColor getText1() {
                return this.text1;
            }

            /* renamed from: component3, reason: from getter */
            public final PaywallColor getText2() {
                return this.text2;
            }

            /* renamed from: component4, reason: from getter */
            public final PaywallColor getText3() {
                return this.text3;
            }

            /* renamed from: component5, reason: from getter */
            public final PaywallColor getCallToActionBackground() {
                return this.callToActionBackground;
            }

            /* renamed from: component6, reason: from getter */
            public final PaywallColor getCallToActionForeground() {
                return this.callToActionForeground;
            }

            /* renamed from: component7, reason: from getter */
            public final PaywallColor getCallToActionSecondaryBackground() {
                return this.callToActionSecondaryBackground;
            }

            /* renamed from: component8, reason: from getter */
            public final PaywallColor getAccent1() {
                return this.accent1;
            }

            /* renamed from: component9, reason: from getter */
            public final PaywallColor getAccent2() {
                return this.accent2;
            }

            public final Colors copy(PaywallColor background, PaywallColor text1, PaywallColor text2, PaywallColor text3, PaywallColor callToActionBackground, PaywallColor callToActionForeground, PaywallColor callToActionSecondaryBackground, PaywallColor accent1, PaywallColor accent2, PaywallColor accent3) {
                Intrinsics.checkNotNullParameter(background, "background");
                Intrinsics.checkNotNullParameter(text1, "text1");
                Intrinsics.checkNotNullParameter(callToActionBackground, "callToActionBackground");
                Intrinsics.checkNotNullParameter(callToActionForeground, "callToActionForeground");
                return new Colors(background, text1, text2, text3, callToActionBackground, callToActionForeground, callToActionSecondaryBackground, accent1, accent2, accent3);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Colors)) {
                    return false;
                }
                Colors colors = (Colors) other;
                return Intrinsics.areEqual(this.background, colors.background) && Intrinsics.areEqual(this.text1, colors.text1) && Intrinsics.areEqual(this.text2, colors.text2) && Intrinsics.areEqual(this.text3, colors.text3) && Intrinsics.areEqual(this.callToActionBackground, colors.callToActionBackground) && Intrinsics.areEqual(this.callToActionForeground, colors.callToActionForeground) && Intrinsics.areEqual(this.callToActionSecondaryBackground, colors.callToActionSecondaryBackground) && Intrinsics.areEqual(this.accent1, colors.accent1) && Intrinsics.areEqual(this.accent2, colors.accent2) && Intrinsics.areEqual(this.accent3, colors.accent3);
            }

            public int hashCode() {
                int hashCode = ((this.background.hashCode() * 31) + this.text1.hashCode()) * 31;
                PaywallColor paywallColor = this.text2;
                int hashCode2 = (hashCode + (paywallColor == null ? 0 : paywallColor.hashCode())) * 31;
                PaywallColor paywallColor2 = this.text3;
                int hashCode3 = (((((hashCode2 + (paywallColor2 == null ? 0 : paywallColor2.hashCode())) * 31) + this.callToActionBackground.hashCode()) * 31) + this.callToActionForeground.hashCode()) * 31;
                PaywallColor paywallColor3 = this.callToActionSecondaryBackground;
                int hashCode4 = (hashCode3 + (paywallColor3 == null ? 0 : paywallColor3.hashCode())) * 31;
                PaywallColor paywallColor4 = this.accent1;
                int hashCode5 = (hashCode4 + (paywallColor4 == null ? 0 : paywallColor4.hashCode())) * 31;
                PaywallColor paywallColor5 = this.accent2;
                int hashCode6 = (hashCode5 + (paywallColor5 == null ? 0 : paywallColor5.hashCode())) * 31;
                PaywallColor paywallColor6 = this.accent3;
                return hashCode6 + (paywallColor6 != null ? paywallColor6.hashCode() : 0);
            }

            public String toString() {
                return "Colors(background=" + this.background + ", text1=" + this.text1 + ", text2=" + this.text2 + ", text3=" + this.text3 + ", callToActionBackground=" + this.callToActionBackground + ", callToActionForeground=" + this.callToActionForeground + ", callToActionSecondaryBackground=" + this.callToActionSecondaryBackground + ", accent1=" + this.accent1 + ", accent2=" + this.accent2 + ", accent3=" + this.accent3 + ')';
            }

            /* compiled from: PaywallData.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes5.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Colors> serializer() {
                    return PaywallData$Configuration$Colors$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ Colors(int i, @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor, @SerialName("text_1") @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor2, @SerialName("text_2") @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor3, @SerialName("text_3") @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor4, @SerialName("call_to_action_background") @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor5, @SerialName("call_to_action_foreground") @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor6, @SerialName("call_to_action_secondary_background") @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor7, @SerialName("accent_1") @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor8, @SerialName("accent_2") @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor9, @SerialName("accent_3") @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor10, SerializationConstructorMarker serializationConstructorMarker) {
                if (51 != (i & 51)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 51, PaywallData$Configuration$Colors$$serializer.INSTANCE.getDescriptor());
                }
                this.background = paywallColor;
                this.text1 = paywallColor2;
                if ((i & 4) == 0) {
                    this.text2 = null;
                } else {
                    this.text2 = paywallColor3;
                }
                if ((i & 8) == 0) {
                    this.text3 = null;
                } else {
                    this.text3 = paywallColor4;
                }
                this.callToActionBackground = paywallColor5;
                this.callToActionForeground = paywallColor6;
                if ((i & 64) == 0) {
                    this.callToActionSecondaryBackground = null;
                } else {
                    this.callToActionSecondaryBackground = paywallColor7;
                }
                if ((i & 128) == 0) {
                    this.accent1 = null;
                } else {
                    this.accent1 = paywallColor8;
                }
                if ((i & 256) == 0) {
                    this.accent2 = null;
                } else {
                    this.accent2 = paywallColor9;
                }
                if ((i & 512) == 0) {
                    this.accent3 = null;
                } else {
                    this.accent3 = paywallColor10;
                }
            }

            public Colors(PaywallColor background, PaywallColor text1, PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor callToActionBackground, PaywallColor callToActionForeground, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, PaywallColor paywallColor6) {
                Intrinsics.checkNotNullParameter(background, "background");
                Intrinsics.checkNotNullParameter(text1, "text1");
                Intrinsics.checkNotNullParameter(callToActionBackground, "callToActionBackground");
                Intrinsics.checkNotNullParameter(callToActionForeground, "callToActionForeground");
                this.background = background;
                this.text1 = text1;
                this.text2 = paywallColor;
                this.text3 = paywallColor2;
                this.callToActionBackground = callToActionBackground;
                this.callToActionForeground = callToActionForeground;
                this.callToActionSecondaryBackground = paywallColor3;
                this.accent1 = paywallColor4;
                this.accent2 = paywallColor5;
                this.accent3 = paywallColor6;
            }

            @JvmStatic
            public static final void write$Self(Colors self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Intrinsics.checkNotNullParameter(self, "self");
                Intrinsics.checkNotNullParameter(output, "output");
                Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
                output.encodeSerializableElement(serialDesc, 0, PaywallColor.Serializer.INSTANCE, self.background);
                output.encodeSerializableElement(serialDesc, 1, PaywallColor.Serializer.INSTANCE, self.text1);
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.text2 != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, PaywallColor.Serializer.INSTANCE, self.text2);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.text3 != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, PaywallColor.Serializer.INSTANCE, self.text3);
                }
                output.encodeSerializableElement(serialDesc, 4, PaywallColor.Serializer.INSTANCE, self.callToActionBackground);
                output.encodeSerializableElement(serialDesc, 5, PaywallColor.Serializer.INSTANCE, self.callToActionForeground);
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.callToActionSecondaryBackground != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, PaywallColor.Serializer.INSTANCE, self.callToActionSecondaryBackground);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.accent1 != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, PaywallColor.Serializer.INSTANCE, self.accent1);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.accent2 != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, PaywallColor.Serializer.INSTANCE, self.accent2);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.accent3 != null) {
                    output.encodeNullableSerializableElement(serialDesc, 9, PaywallColor.Serializer.INSTANCE, self.accent3);
                }
            }

            public /* synthetic */ Colors(PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, PaywallColor paywallColor6, PaywallColor paywallColor7, PaywallColor paywallColor8, PaywallColor paywallColor9, PaywallColor paywallColor10, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(paywallColor, paywallColor2, (i & 4) != 0 ? null : paywallColor3, (i & 8) != 0 ? null : paywallColor4, paywallColor5, paywallColor6, (i & 64) != 0 ? null : paywallColor7, (i & 128) != 0 ? null : paywallColor8, (i & 256) != 0 ? null : paywallColor9, (i & 512) != 0 ? null : paywallColor10);
            }

            public final PaywallColor getBackground() {
                return this.background;
            }

            public final PaywallColor getText1() {
                return this.text1;
            }

            public final PaywallColor getText2() {
                return this.text2;
            }

            public final PaywallColor getText3() {
                return this.text3;
            }

            public final PaywallColor getCallToActionBackground() {
                return this.callToActionBackground;
            }

            public final PaywallColor getCallToActionForeground() {
                return this.callToActionForeground;
            }

            public final PaywallColor getCallToActionSecondaryBackground() {
                return this.callToActionSecondaryBackground;
            }

            public final PaywallColor getAccent1() {
                return this.accent1;
            }

            public final PaywallColor getAccent2() {
                return this.accent2;
            }

            public final PaywallColor getAccent3() {
                return this.accent3;
            }
        }
    }

    /* compiled from: PaywallData.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 B2\u00020\u0001:\u0003ABCB\u0093\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013By\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\u0010\u0014J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0081\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001J!\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@HÇ\u0001R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018¨\u0006D"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "", "seen1", "", "title", "", "subtitle", "callToAction", "callToActionWithIntroOffer", "callToActionWithMultipleIntroOffers", "offerDetails", "offerDetailsWithIntroOffer", "offerDetailsWithMultipleIntroOffers", "offerName", "features", "", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCallToAction$annotations", "()V", "getCallToAction", "()Ljava/lang/String;", "getCallToActionWithIntroOffer$annotations", "getCallToActionWithIntroOffer", "getCallToActionWithMultipleIntroOffers$annotations", "getCallToActionWithMultipleIntroOffers", "getFeatures", "()Ljava/util/List;", "getOfferDetails$annotations", "getOfferDetails", "getOfferDetailsWithIntroOffer$annotations", "getOfferDetailsWithIntroOffer", "getOfferDetailsWithMultipleIntroOffers$annotations", "getOfferDetailsWithMultipleIntroOffers", "getOfferName$annotations", "getOfferName", "getSubtitle$annotations", "getSubtitle", "getTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "Feature", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* loaded from: classes5.dex */
    public static final /* data */ class LocalizedConfiguration {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String callToAction;
        private final String callToActionWithIntroOffer;
        private final String callToActionWithMultipleIntroOffers;
        private final List<Feature> features;
        private final String offerDetails;
        private final String offerDetailsWithIntroOffer;
        private final String offerDetailsWithMultipleIntroOffers;
        private final String offerName;
        private final String subtitle;
        private final String title;

        @SerialName("call_to_action")
        public static /* synthetic */ void getCallToAction$annotations() {
        }

        @SerialName("call_to_action_with_intro_offer")
        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getCallToActionWithIntroOffer$annotations() {
        }

        @SerialName("call_to_action_with_multiple_intro_offers")
        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getCallToActionWithMultipleIntroOffers$annotations() {
        }

        @SerialName("offer_details")
        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getOfferDetails$annotations() {
        }

        @SerialName("offer_details_with_intro_offer")
        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getOfferDetailsWithIntroOffer$annotations() {
        }

        @SerialName("offer_details_with_multiple_intro_offers")
        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getOfferDetailsWithMultipleIntroOffers$annotations() {
        }

        @SerialName("offer_name")
        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getOfferName$annotations() {
        }

        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getSubtitle$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final List<Feature> component10() {
            return this.features;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSubtitle() {
            return this.subtitle;
        }

        /* renamed from: component3, reason: from getter */
        public final String getCallToAction() {
            return this.callToAction;
        }

        /* renamed from: component4, reason: from getter */
        public final String getCallToActionWithIntroOffer() {
            return this.callToActionWithIntroOffer;
        }

        /* renamed from: component5, reason: from getter */
        public final String getCallToActionWithMultipleIntroOffers() {
            return this.callToActionWithMultipleIntroOffers;
        }

        /* renamed from: component6, reason: from getter */
        public final String getOfferDetails() {
            return this.offerDetails;
        }

        /* renamed from: component7, reason: from getter */
        public final String getOfferDetailsWithIntroOffer() {
            return this.offerDetailsWithIntroOffer;
        }

        /* renamed from: component8, reason: from getter */
        public final String getOfferDetailsWithMultipleIntroOffers() {
            return this.offerDetailsWithMultipleIntroOffers;
        }

        /* renamed from: component9, reason: from getter */
        public final String getOfferName() {
            return this.offerName;
        }

        public final LocalizedConfiguration copy(String title, String subtitle, String callToAction, String callToActionWithIntroOffer, String callToActionWithMultipleIntroOffers, String offerDetails, String offerDetailsWithIntroOffer, String offerDetailsWithMultipleIntroOffers, String offerName, List<Feature> features) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(callToAction, "callToAction");
            Intrinsics.checkNotNullParameter(features, "features");
            return new LocalizedConfiguration(title, subtitle, callToAction, callToActionWithIntroOffer, callToActionWithMultipleIntroOffers, offerDetails, offerDetailsWithIntroOffer, offerDetailsWithMultipleIntroOffers, offerName, features);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LocalizedConfiguration)) {
                return false;
            }
            LocalizedConfiguration localizedConfiguration = (LocalizedConfiguration) other;
            return Intrinsics.areEqual(this.title, localizedConfiguration.title) && Intrinsics.areEqual(this.subtitle, localizedConfiguration.subtitle) && Intrinsics.areEqual(this.callToAction, localizedConfiguration.callToAction) && Intrinsics.areEqual(this.callToActionWithIntroOffer, localizedConfiguration.callToActionWithIntroOffer) && Intrinsics.areEqual(this.callToActionWithMultipleIntroOffers, localizedConfiguration.callToActionWithMultipleIntroOffers) && Intrinsics.areEqual(this.offerDetails, localizedConfiguration.offerDetails) && Intrinsics.areEqual(this.offerDetailsWithIntroOffer, localizedConfiguration.offerDetailsWithIntroOffer) && Intrinsics.areEqual(this.offerDetailsWithMultipleIntroOffers, localizedConfiguration.offerDetailsWithMultipleIntroOffers) && Intrinsics.areEqual(this.offerName, localizedConfiguration.offerName) && Intrinsics.areEqual(this.features, localizedConfiguration.features);
        }

        public int hashCode() {
            int hashCode = this.title.hashCode() * 31;
            String str = this.subtitle;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.callToAction.hashCode()) * 31;
            String str2 = this.callToActionWithIntroOffer;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.callToActionWithMultipleIntroOffers;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.offerDetails;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.offerDetailsWithIntroOffer;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.offerDetailsWithMultipleIntroOffers;
            int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.offerName;
            return ((hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.features.hashCode();
        }

        public String toString() {
            return "LocalizedConfiguration(title=" + this.title + ", subtitle=" + this.subtitle + ", callToAction=" + this.callToAction + ", callToActionWithIntroOffer=" + this.callToActionWithIntroOffer + ", callToActionWithMultipleIntroOffers=" + this.callToActionWithMultipleIntroOffers + ", offerDetails=" + this.offerDetails + ", offerDetailsWithIntroOffer=" + this.offerDetailsWithIntroOffer + ", offerDetailsWithMultipleIntroOffers=" + this.offerDetailsWithMultipleIntroOffers + ", offerName=" + this.offerName + ", features=" + this.features + ')';
        }

        /* compiled from: PaywallData.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<LocalizedConfiguration> serializer() {
                return PaywallData$LocalizedConfiguration$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ LocalizedConfiguration(int i, String str, @Serializable(with = EmptyStringToNullSerializer.class) String str2, @SerialName("call_to_action") String str3, @SerialName("call_to_action_with_intro_offer") @Serializable(with = EmptyStringToNullSerializer.class) String str4, @SerialName("call_to_action_with_multiple_intro_offers") @Serializable(with = EmptyStringToNullSerializer.class) String str5, @SerialName("offer_details") @Serializable(with = EmptyStringToNullSerializer.class) String str6, @SerialName("offer_details_with_intro_offer") @Serializable(with = EmptyStringToNullSerializer.class) String str7, @SerialName("offer_details_with_multiple_intro_offers") @Serializable(with = EmptyStringToNullSerializer.class) String str8, @SerialName("offer_name") @Serializable(with = EmptyStringToNullSerializer.class) String str9, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (5 != (i & 5)) {
                PluginExceptionsKt.throwMissingFieldException(i, 5, PaywallData$LocalizedConfiguration$$serializer.INSTANCE.getDescriptor());
            }
            this.title = str;
            if ((i & 2) == 0) {
                this.subtitle = null;
            } else {
                this.subtitle = str2;
            }
            this.callToAction = str3;
            if ((i & 8) == 0) {
                this.callToActionWithIntroOffer = null;
            } else {
                this.callToActionWithIntroOffer = str4;
            }
            if ((i & 16) == 0) {
                this.callToActionWithMultipleIntroOffers = null;
            } else {
                this.callToActionWithMultipleIntroOffers = str5;
            }
            if ((i & 32) == 0) {
                this.offerDetails = null;
            } else {
                this.offerDetails = str6;
            }
            if ((i & 64) == 0) {
                this.offerDetailsWithIntroOffer = null;
            } else {
                this.offerDetailsWithIntroOffer = str7;
            }
            if ((i & 128) == 0) {
                this.offerDetailsWithMultipleIntroOffers = null;
            } else {
                this.offerDetailsWithMultipleIntroOffers = str8;
            }
            if ((i & 256) == 0) {
                this.offerName = null;
            } else {
                this.offerName = str9;
            }
            if ((i & 512) == 0) {
                this.features = CollectionsKt.emptyList();
            } else {
                this.features = list;
            }
        }

        public LocalizedConfiguration(String title, String str, String callToAction, String str2, String str3, String str4, String str5, String str6, String str7, List<Feature> features) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(callToAction, "callToAction");
            Intrinsics.checkNotNullParameter(features, "features");
            this.title = title;
            this.subtitle = str;
            this.callToAction = callToAction;
            this.callToActionWithIntroOffer = str2;
            this.callToActionWithMultipleIntroOffers = str3;
            this.offerDetails = str4;
            this.offerDetailsWithIntroOffer = str5;
            this.offerDetailsWithMultipleIntroOffers = str6;
            this.offerName = str7;
            this.features = features;
        }

        @JvmStatic
        public static final void write$Self(LocalizedConfiguration self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            output.encodeStringElement(serialDesc, 0, self.title);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.subtitle != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, EmptyStringToNullSerializer.INSTANCE, self.subtitle);
            }
            output.encodeStringElement(serialDesc, 2, self.callToAction);
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.callToActionWithIntroOffer != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, EmptyStringToNullSerializer.INSTANCE, self.callToActionWithIntroOffer);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.callToActionWithMultipleIntroOffers != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, EmptyStringToNullSerializer.INSTANCE, self.callToActionWithMultipleIntroOffers);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.offerDetails != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, EmptyStringToNullSerializer.INSTANCE, self.offerDetails);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.offerDetailsWithIntroOffer != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, EmptyStringToNullSerializer.INSTANCE, self.offerDetailsWithIntroOffer);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.offerDetailsWithMultipleIntroOffers != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, EmptyStringToNullSerializer.INSTANCE, self.offerDetailsWithMultipleIntroOffers);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.offerName != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, EmptyStringToNullSerializer.INSTANCE, self.offerName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.features, CollectionsKt.emptyList())) {
                output.encodeSerializableElement(serialDesc, 9, new ArrayListSerializer(PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE), self.features);
            }
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final String getCallToAction() {
            return this.callToAction;
        }

        public final String getCallToActionWithIntroOffer() {
            return this.callToActionWithIntroOffer;
        }

        public final String getCallToActionWithMultipleIntroOffers() {
            return this.callToActionWithMultipleIntroOffers;
        }

        public final String getOfferDetails() {
            return this.offerDetails;
        }

        public final String getOfferDetailsWithIntroOffer() {
            return this.offerDetailsWithIntroOffer;
        }

        public final String getOfferDetailsWithMultipleIntroOffers() {
            return this.offerDetailsWithMultipleIntroOffers;
        }

        public final String getOfferName() {
            return this.offerName;
        }

        public /* synthetic */ LocalizedConfiguration(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<Feature> getFeatures() {
            return this.features;
        }

        /* compiled from: PaywallData.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B9\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÇ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006$"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature;", "", "seen1", "", "title", "", UriUtil.LOCAL_CONTENT_SCHEME, "iconID", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getIconID$annotations", "()V", "getIconID", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @Serializable
        /* loaded from: classes5.dex */
        public static final /* data */ class Feature {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String content;
            private final String iconID;
            private final String title;

            public static /* synthetic */ Feature copy$default(Feature feature, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = feature.title;
                }
                if ((i & 2) != 0) {
                    str2 = feature.content;
                }
                if ((i & 4) != 0) {
                    str3 = feature.iconID;
                }
                return feature.copy(str, str2, str3);
            }

            @SerialName("icon_id")
            public static /* synthetic */ void getIconID$annotations() {
            }

            /* renamed from: component1, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            /* renamed from: component2, reason: from getter */
            public final String getContent() {
                return this.content;
            }

            /* renamed from: component3, reason: from getter */
            public final String getIconID() {
                return this.iconID;
            }

            public final Feature copy(String title, String content, String iconID) {
                Intrinsics.checkNotNullParameter(title, "title");
                return new Feature(title, content, iconID);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Feature)) {
                    return false;
                }
                Feature feature = (Feature) other;
                return Intrinsics.areEqual(this.title, feature.title) && Intrinsics.areEqual(this.content, feature.content) && Intrinsics.areEqual(this.iconID, feature.iconID);
            }

            public int hashCode() {
                int hashCode = this.title.hashCode() * 31;
                String str = this.content;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.iconID;
                return hashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "Feature(title=" + this.title + ", content=" + this.content + ", iconID=" + this.iconID + ')';
            }

            /* compiled from: PaywallData.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes5.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Feature> serializer() {
                    return PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ Feature(int i, String str, String str2, @SerialName("icon_id") String str3, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE.getDescriptor());
                }
                this.title = str;
                if ((i & 2) == 0) {
                    this.content = null;
                } else {
                    this.content = str2;
                }
                if ((i & 4) == 0) {
                    this.iconID = null;
                } else {
                    this.iconID = str3;
                }
            }

            public Feature(String title, String str, String str2) {
                Intrinsics.checkNotNullParameter(title, "title");
                this.title = title;
                this.content = str;
                this.iconID = str2;
            }

            @JvmStatic
            public static final void write$Self(Feature self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Intrinsics.checkNotNullParameter(self, "self");
                Intrinsics.checkNotNullParameter(output, "output");
                Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
                output.encodeStringElement(serialDesc, 0, self.title);
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.content != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.content);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.iconID != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.iconID);
                }
            }

            public /* synthetic */ Feature(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getContent() {
                return this.content;
            }

            public final String getIconID() {
                return this.iconID;
            }
        }
    }
}
