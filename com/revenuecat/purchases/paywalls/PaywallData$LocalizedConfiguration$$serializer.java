package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.paywalls.PaywallData;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: PaywallData.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.LocalizedConfiguration.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes5.dex */
public final class PaywallData$LocalizedConfiguration$$serializer implements GeneratedSerializer<PaywallData.LocalizedConfiguration> {
    public static final PaywallData$LocalizedConfiguration$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PaywallData$LocalizedConfiguration$$serializer paywallData$LocalizedConfiguration$$serializer = new PaywallData$LocalizedConfiguration$$serializer();
        INSTANCE = paywallData$LocalizedConfiguration$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.LocalizedConfiguration", paywallData$LocalizedConfiguration$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("title", false);
        pluginGeneratedSerialDescriptor.addElement("subtitle", true);
        pluginGeneratedSerialDescriptor.addElement("call_to_action", false);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_with_intro_offer", true);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_with_multiple_intro_offers", true);
        pluginGeneratedSerialDescriptor.addElement("offer_details", true);
        pluginGeneratedSerialDescriptor.addElement("offer_details_with_intro_offer", true);
        pluginGeneratedSerialDescriptor.addElement("offer_details_with_multiple_intro_offers", true);
        pluginGeneratedSerialDescriptor.addElement("offer_name", true);
        pluginGeneratedSerialDescriptor.addElement("features", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$LocalizedConfiguration$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), new ArrayListSerializer(PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x008e. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallData.LocalizedConfiguration deserialize(Decoder decoder) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        String str;
        String str2;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i2 = 9;
        String str3 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 0);
            Object decodeNullableSerializableElement = beginStructure.decodeNullableSerializableElement(descriptor2, 1, EmptyStringToNullSerializer.INSTANCE, null);
            String decodeStringElement2 = beginStructure.decodeStringElement(descriptor2, 2);
            Object decodeNullableSerializableElement2 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, EmptyStringToNullSerializer.INSTANCE, null);
            Object decodeNullableSerializableElement3 = beginStructure.decodeNullableSerializableElement(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, null);
            Object decodeNullableSerializableElement4 = beginStructure.decodeNullableSerializableElement(descriptor2, 5, EmptyStringToNullSerializer.INSTANCE, null);
            obj7 = beginStructure.decodeNullableSerializableElement(descriptor2, 6, EmptyStringToNullSerializer.INSTANCE, null);
            obj8 = beginStructure.decodeNullableSerializableElement(descriptor2, 7, EmptyStringToNullSerializer.INSTANCE, null);
            obj6 = beginStructure.decodeNullableSerializableElement(descriptor2, 8, EmptyStringToNullSerializer.INSTANCE, null);
            obj5 = beginStructure.decodeSerializableElement(descriptor2, 9, new ArrayListSerializer(PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE), null);
            obj4 = decodeNullableSerializableElement;
            obj2 = decodeNullableSerializableElement3;
            str2 = decodeStringElement2;
            obj = decodeNullableSerializableElement4;
            i = 1023;
            obj3 = decodeNullableSerializableElement2;
            str = decodeStringElement;
        } else {
            boolean z = true;
            int i3 = 0;
            Object obj9 = null;
            Object obj10 = null;
            Object obj11 = null;
            Object obj12 = null;
            obj = null;
            obj2 = null;
            obj3 = null;
            obj4 = null;
            String str4 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 9;
                    case 0:
                        str3 = beginStructure.decodeStringElement(descriptor2, 0);
                        i3 |= 1;
                        i2 = 9;
                    case 1:
                        obj4 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, EmptyStringToNullSerializer.INSTANCE, obj4);
                        i3 |= 2;
                        i2 = 9;
                    case 2:
                        str4 = beginStructure.decodeStringElement(descriptor2, 2);
                        i3 |= 4;
                        i2 = 9;
                    case 3:
                        obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, EmptyStringToNullSerializer.INSTANCE, obj3);
                        i3 |= 8;
                        i2 = 9;
                    case 4:
                        obj2 = beginStructure.decodeNullableSerializableElement(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, obj2);
                        i3 |= 16;
                        i2 = 9;
                    case 5:
                        obj = beginStructure.decodeNullableSerializableElement(descriptor2, 5, EmptyStringToNullSerializer.INSTANCE, obj);
                        i3 |= 32;
                        i2 = 9;
                    case 6:
                        obj11 = beginStructure.decodeNullableSerializableElement(descriptor2, 6, EmptyStringToNullSerializer.INSTANCE, obj11);
                        i3 |= 64;
                        i2 = 9;
                    case 7:
                        obj12 = beginStructure.decodeNullableSerializableElement(descriptor2, 7, EmptyStringToNullSerializer.INSTANCE, obj12);
                        i3 |= 128;
                        i2 = 9;
                    case 8:
                        obj10 = beginStructure.decodeNullableSerializableElement(descriptor2, 8, EmptyStringToNullSerializer.INSTANCE, obj10);
                        i3 |= 256;
                    case 9:
                        obj9 = beginStructure.decodeSerializableElement(descriptor2, i2, new ArrayListSerializer(PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE), obj9);
                        i3 |= 512;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            obj5 = obj9;
            obj6 = obj10;
            obj7 = obj11;
            obj8 = obj12;
            str = str3;
            str2 = str4;
            i = i3;
        }
        beginStructure.endStructure(descriptor2);
        return new PaywallData.LocalizedConfiguration(i, str, (String) obj4, str2, (String) obj3, (String) obj2, (String) obj, (String) obj7, (String) obj8, (String) obj6, (List) obj5, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallData.LocalizedConfiguration value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PaywallData.LocalizedConfiguration.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
