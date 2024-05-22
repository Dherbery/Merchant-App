package expo.modules.location.records;

import android.location.Address;
import androidx.autofill.HintConstants;
import com.amplitude.api.Constants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationResults.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b5\b\u0000\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B{\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R&\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R&\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R$\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R&\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R&\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\u0015\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R&\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b,\u0010\u0015\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R&\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b/\u0010\u0015\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R&\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b2\u0010\u0015\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R&\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b5\u0010\u0015\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R&\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u0010\u0015\u001a\u0004\b9\u0010\u0017\"\u0004\b:\u0010\u0019¨\u0006<"}, d2 = {"Lexpo/modules/location/records/ReverseGeocodeResponse;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "address", "Landroid/location/Address;", "(Landroid/location/Address;)V", Constants.AMP_TRACKING_OPTION_CITY, "", "district", "streetNumber", "street", "region", "subregion", Constants.AMP_TRACKING_OPTION_COUNTRY, HintConstants.AUTOFILL_HINT_POSTAL_CODE, "name", "isoCountryCode", "timezone", "formattedAddress", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCity$annotations", "()V", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "getCountry$annotations", "getCountry", "setCountry", "getDistrict$annotations", "getDistrict", "setDistrict", "getFormattedAddress$annotations", "getFormattedAddress", "setFormattedAddress", "getIsoCountryCode$annotations", "getIsoCountryCode", "setIsoCountryCode", "getName$annotations", "getName", "setName", "getPostalCode$annotations", "getPostalCode", "setPostalCode", "getRegion$annotations", "getRegion", "setRegion", "getStreet$annotations", "getStreet", "setStreet", "getStreetNumber$annotations", "getStreetNumber", "setStreetNumber", "getSubregion$annotations", "getSubregion", "setSubregion", "getTimezone$annotations", "getTimezone", "setTimezone", "Companion", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReverseGeocodeResponse implements Record, Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String city;
    private String country;
    private String district;
    private String formattedAddress;
    private String isoCountryCode;
    private String name;
    private String postalCode;
    private String region;
    private String street;
    private String streetNumber;
    private String subregion;
    private String timezone;

    @Field
    public static /* synthetic */ void getCity$annotations() {
    }

    @Field
    public static /* synthetic */ void getCountry$annotations() {
    }

    @Field
    public static /* synthetic */ void getDistrict$annotations() {
    }

    @Field
    public static /* synthetic */ void getFormattedAddress$annotations() {
    }

    @Field
    public static /* synthetic */ void getIsoCountryCode$annotations() {
    }

    @Field
    public static /* synthetic */ void getName$annotations() {
    }

    @Field
    public static /* synthetic */ void getPostalCode$annotations() {
    }

    @Field
    public static /* synthetic */ void getRegion$annotations() {
    }

    @Field
    public static /* synthetic */ void getStreet$annotations() {
    }

    @Field
    public static /* synthetic */ void getStreetNumber$annotations() {
    }

    @Field
    public static /* synthetic */ void getSubregion$annotations() {
    }

    @Field
    public static /* synthetic */ void getTimezone$annotations() {
    }

    public ReverseGeocodeResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String isoCountryCode, String str10, String str11) {
        Intrinsics.checkNotNullParameter(isoCountryCode, "isoCountryCode");
        this.city = str;
        this.district = str2;
        this.streetNumber = str3;
        this.street = str4;
        this.region = str5;
        this.subregion = str6;
        this.country = str7;
        this.postalCode = str8;
        this.name = str9;
        this.isoCountryCode = isoCountryCode;
        this.timezone = str10;
        this.formattedAddress = str11;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final String getDistrict() {
        return this.district;
    }

    public final void setDistrict(String str) {
        this.district = str;
    }

    public final String getStreetNumber() {
        return this.streetNumber;
    }

    public final void setStreetNumber(String str) {
        this.streetNumber = str;
    }

    public final String getStreet() {
        return this.street;
    }

    public final void setStreet(String str) {
        this.street = str;
    }

    public final String getRegion() {
        return this.region;
    }

    public final void setRegion(String str) {
        this.region = str;
    }

    public final String getSubregion() {
        return this.subregion;
    }

    public final void setSubregion(String str) {
        this.subregion = str;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public final void setPostalCode(String str) {
        this.postalCode = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getIsoCountryCode() {
        return this.isoCountryCode;
    }

    public final void setIsoCountryCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isoCountryCode = str;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final void setTimezone(String str) {
        this.timezone = str;
    }

    public final String getFormattedAddress() {
        return this.formattedAddress;
    }

    public final void setFormattedAddress(String str) {
        this.formattedAddress = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ReverseGeocodeResponse(android.location.Address r15) {
        /*
            r14 = this;
            java.lang.String r0 = "address"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r2 = r15.getLocality()
            java.lang.String r3 = r15.getSubLocality()
            java.lang.String r4 = r15.getSubThoroughfare()
            java.lang.String r5 = r15.getThoroughfare()
            java.lang.String r6 = r15.getAdminArea()
            java.lang.String r7 = r15.getSubAdminArea()
            java.lang.String r8 = r15.getCountryName()
            java.lang.String r9 = r15.getPostalCode()
            java.lang.String r10 = r15.getFeatureName()
            java.lang.String r11 = r15.getCountryCode()
            java.lang.String r0 = "address.countryCode"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            r12 = 0
            expo.modules.location.records.ReverseGeocodeResponse$Companion r0 = expo.modules.location.records.ReverseGeocodeResponse.INSTANCE
            java.lang.String r13 = r0.constructFormattedAddress(r15)
            r1 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.records.ReverseGeocodeResponse.<init>(android.location.Address):void");
    }

    /* compiled from: LocationResults.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/location/records/ReverseGeocodeResponse$Companion;", "", "()V", "constructFormattedAddress", "", "address", "Landroid/location/Address;", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String constructFormattedAddress(Address address) {
            Intrinsics.checkNotNullParameter(address, "address");
            if (address.getMaxAddressLineIndex() == -1) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            int maxAddressLineIndex = address.getMaxAddressLineIndex();
            if (maxAddressLineIndex >= 0) {
                int i = 0;
                while (true) {
                    sb.append(address.getAddressLine(i));
                    if (i < address.getMaxAddressLineIndex()) {
                        sb.append(", ");
                    }
                    if (i == maxAddressLineIndex) {
                        break;
                    }
                    i++;
                }
            }
            return sb.toString();
        }
    }
}
