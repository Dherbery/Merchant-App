package com.revenuecat.purchases.paywalls.events;

import com.amplitude.api.Constants;
import com.revenuecat.purchases.common.Backend;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: PaywallBackendEvent.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/events/PaywallBackendEvent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallBackendEvent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes5.dex */
public final class PaywallBackendEvent$$serializer implements GeneratedSerializer<PaywallBackendEvent> {
    public static final PaywallBackendEvent$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PaywallBackendEvent$$serializer paywallBackendEvent$$serializer = new PaywallBackendEvent$$serializer();
        INSTANCE = paywallBackendEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.events.PaywallBackendEvent", paywallBackendEvent$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement(Constants.AMP_PLAN_VERSION, false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement(Backend.APP_USER_ID, false);
        pluginGeneratedSerialDescriptor.addElement("session_id", false);
        pluginGeneratedSerialDescriptor.addElement("offering_id", false);
        pluginGeneratedSerialDescriptor.addElement("paywall_revision", false);
        pluginGeneratedSerialDescriptor.addElement("timestamp", false);
        pluginGeneratedSerialDescriptor.addElement("display_mode", false);
        pluginGeneratedSerialDescriptor.addElement("dark_mode", false);
        pluginGeneratedSerialDescriptor.addElement(com.facebook.hermes.intl.Constants.LOCALE, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallBackendEvent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0088. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallBackendEvent deserialize(Decoder decoder) {
        String str;
        boolean z;
        String str2;
        int i;
        String str3;
        int i2;
        long j;
        int i3;
        String str4;
        String str5;
        String str6;
        String str7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i4 = 0;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 0);
            int decodeIntElement = beginStructure.decodeIntElement(descriptor2, 1);
            String decodeStringElement2 = beginStructure.decodeStringElement(descriptor2, 2);
            String decodeStringElement3 = beginStructure.decodeStringElement(descriptor2, 3);
            String decodeStringElement4 = beginStructure.decodeStringElement(descriptor2, 4);
            String decodeStringElement5 = beginStructure.decodeStringElement(descriptor2, 5);
            int decodeIntElement2 = beginStructure.decodeIntElement(descriptor2, 6);
            long decodeLongElement = beginStructure.decodeLongElement(descriptor2, 7);
            String decodeStringElement6 = beginStructure.decodeStringElement(descriptor2, 8);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(descriptor2, 9);
            str2 = decodeStringElement;
            str = beginStructure.decodeStringElement(descriptor2, 10);
            z = decodeBooleanElement;
            str3 = decodeStringElement6;
            i3 = decodeIntElement2;
            str5 = decodeStringElement5;
            str6 = decodeStringElement3;
            str7 = decodeStringElement4;
            str4 = decodeStringElement2;
            i2 = decodeIntElement;
            j = decodeLongElement;
            i = 2047;
        } else {
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            boolean z2 = true;
            int i5 = 0;
            int i6 = 0;
            long j2 = 0;
            String str14 = null;
            boolean z3 = false;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z2 = false;
                    case 0:
                        i4 |= 1;
                        str8 = beginStructure.decodeStringElement(descriptor2, 0);
                    case 1:
                        i6 = beginStructure.decodeIntElement(descriptor2, 1);
                        i4 |= 2;
                    case 2:
                        str13 = beginStructure.decodeStringElement(descriptor2, 2);
                        i4 |= 4;
                    case 3:
                        str11 = beginStructure.decodeStringElement(descriptor2, 3);
                        i4 |= 8;
                    case 4:
                        str12 = beginStructure.decodeStringElement(descriptor2, 4);
                        i4 |= 16;
                    case 5:
                        str10 = beginStructure.decodeStringElement(descriptor2, 5);
                        i4 |= 32;
                    case 6:
                        i5 = beginStructure.decodeIntElement(descriptor2, 6);
                        i4 |= 64;
                    case 7:
                        j2 = beginStructure.decodeLongElement(descriptor2, 7);
                        i4 |= 128;
                    case 8:
                        str9 = beginStructure.decodeStringElement(descriptor2, 8);
                        i4 |= 256;
                    case 9:
                        z3 = beginStructure.decodeBooleanElement(descriptor2, 9);
                        i4 |= 512;
                    case 10:
                        str14 = beginStructure.decodeStringElement(descriptor2, 10);
                        i4 |= 1024;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str14;
            z = z3;
            str2 = str8;
            i = i4;
            str3 = str9;
            i2 = i6;
            j = j2;
            String str15 = str13;
            i3 = i5;
            str4 = str15;
            String str16 = str12;
            str5 = str10;
            str6 = str11;
            str7 = str16;
        }
        beginStructure.endStructure(descriptor2);
        return new PaywallBackendEvent(i, str2, i2, str4, str6, str7, str5, i3, j, str3, z, str, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallBackendEvent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PaywallBackendEvent.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
