package com.revenuecat.purchases.paywalls;

import android.graphics.Color;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: PaywallColor.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\tHÆ\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallColor;", "", "stringRepresentation", "", "(Ljava/lang/String;)V", "colorInt", "", "(I)V", "underlyingColor", "Landroid/graphics/Color;", "(Ljava/lang/String;Landroid/graphics/Color;)V", "getColorInt", "()I", "getStringRepresentation", "()Ljava/lang/String;", "getUnderlyingColor", "()Landroid/graphics/Color;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Serializer", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaywallColor {
    private final int colorInt;
    private final String stringRepresentation;
    private final Color underlyingColor;

    public static /* synthetic */ PaywallColor copy$default(PaywallColor paywallColor, String str, Color color, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paywallColor.stringRepresentation;
        }
        if ((i & 2) != 0) {
            color = paywallColor.underlyingColor;
        }
        return paywallColor.copy(str, color);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStringRepresentation() {
        return this.stringRepresentation;
    }

    /* renamed from: component2, reason: from getter */
    public final Color getUnderlyingColor() {
        return this.underlyingColor;
    }

    public final PaywallColor copy(String stringRepresentation, Color underlyingColor) {
        Intrinsics.checkNotNullParameter(stringRepresentation, "stringRepresentation");
        return new PaywallColor(stringRepresentation, underlyingColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaywallColor)) {
            return false;
        }
        PaywallColor paywallColor = (PaywallColor) other;
        return Intrinsics.areEqual(this.stringRepresentation, paywallColor.stringRepresentation) && Intrinsics.areEqual(this.underlyingColor, paywallColor.underlyingColor);
    }

    public int hashCode() {
        int hashCode = this.stringRepresentation.hashCode() * 31;
        Color color = this.underlyingColor;
        return hashCode + (color == null ? 0 : color.hashCode());
    }

    public String toString() {
        return "PaywallColor(stringRepresentation=" + this.stringRepresentation + ", underlyingColor=" + this.underlyingColor + ')';
    }

    public PaywallColor(String stringRepresentation, Color color) {
        Intrinsics.checkNotNullParameter(stringRepresentation, "stringRepresentation");
        this.stringRepresentation = stringRepresentation;
        this.underlyingColor = color;
        this.colorInt = Color.parseColor(stringRepresentation);
    }

    public final String getStringRepresentation() {
        return this.stringRepresentation;
    }

    public final Color getUnderlyingColor() {
        return this.underlyingColor;
    }

    public final int getColorInt() {
        return this.colorInt;
    }

    /* compiled from: PaywallColor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallColor$Serializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallColor;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Serializer implements KSerializer<PaywallColor> {
        public static final Serializer INSTANCE = new Serializer();
        private static final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("PaywallColor", PrimitiveKind.STRING.INSTANCE);

        private Serializer() {
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public PaywallColor deserialize(Decoder decoder) {
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            return new PaywallColor(decoder.decodeString());
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder, PaywallColor value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            encoder.encodeString(value.toString());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallColor(String stringRepresentation) {
        this(stringRepresentation, Build.VERSION.SDK_INT >= 26 ? Color.valueOf(Color.parseColor(stringRepresentation)) : null);
        Intrinsics.checkNotNullParameter(stringRepresentation, "stringRepresentation");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PaywallColor(int r6) {
        /*
            r5 = this;
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.util.Locale r0 = java.util.Locale.US
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 16777215(0xffffff, float:2.3509886E-38)
            r3 = r3 & r6
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = 0
            r2[r4] = r3
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r2, r1)
            java.lang.String r2 = "#%06X"
            java.lang.String r0 = java.lang.String.format(r0, r2, r1)
            java.lang.String r1 = "format(locale, format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L2c
            android.graphics.Color r6 = androidx.core.graphics.ColorKt$$ExternalSyntheticApiModelOutline0.m48m(r6)
            goto L2d
        L2c:
            r6 = 0
        L2d:
            r5.<init>(r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.PaywallColor.<init>(int):void");
    }
}
