package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.utils.serializers.OptionalURLSerializer;
import java.net.URL;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: PaywallData.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.Configuration.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes5.dex */
public final class PaywallData$Configuration$$serializer implements GeneratedSerializer<PaywallData.Configuration> {
    public static final PaywallData$Configuration$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PaywallData$Configuration$$serializer paywallData$Configuration$$serializer = new PaywallData$Configuration$$serializer();
        INSTANCE = paywallData$Configuration$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.Configuration", paywallData$Configuration$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("packages", false);
        pluginGeneratedSerialDescriptor.addElement("default_package", true);
        pluginGeneratedSerialDescriptor.addElement("images_webp", true);
        pluginGeneratedSerialDescriptor.addElement("images", true);
        pluginGeneratedSerialDescriptor.addElement("blurred_background_image", true);
        pluginGeneratedSerialDescriptor.addElement("display_restore_purchases", true);
        pluginGeneratedSerialDescriptor.addElement("tos_url", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_url", true);
        pluginGeneratedSerialDescriptor.addElement("colors", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$Configuration$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{new ArrayListSerializer(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallData$Configuration$Images$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallData$Configuration$Images$$serializer.INSTANCE), BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(OptionalURLSerializer.INSTANCE), BuiltinSerializersKt.getNullable(OptionalURLSerializer.INSTANCE), PaywallData$Configuration$ColorInformation$$serializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0082. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallData.Configuration deserialize(Decoder decoder) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        boolean z;
        int i;
        boolean z2;
        Object obj7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i2 = 7;
        int i3 = 6;
        if (beginStructure.decodeSequentially()) {
            obj7 = beginStructure.decodeSerializableElement(descriptor2, 0, new ArrayListSerializer(StringSerializer.INSTANCE), null);
            Object decodeNullableSerializableElement = beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            obj6 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, PaywallData$Configuration$Images$$serializer.INSTANCE, null);
            Object decodeNullableSerializableElement2 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, PaywallData$Configuration$Images$$serializer.INSTANCE, null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(descriptor2, 4);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(descriptor2, 5);
            obj5 = beginStructure.decodeNullableSerializableElement(descriptor2, 6, OptionalURLSerializer.INSTANCE, null);
            obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 7, OptionalURLSerializer.INSTANCE, null);
            obj4 = beginStructure.decodeSerializableElement(descriptor2, 8, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, null);
            z2 = decodeBooleanElement2;
            obj2 = decodeNullableSerializableElement;
            obj = decodeNullableSerializableElement2;
            i = 511;
            z = decodeBooleanElement;
        } else {
            boolean z3 = true;
            boolean z4 = false;
            int i4 = 0;
            Object obj8 = null;
            Object obj9 = null;
            Object obj10 = null;
            obj = null;
            Object obj11 = null;
            obj2 = null;
            Object obj12 = null;
            boolean z5 = false;
            while (z3) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z3 = false;
                        i3 = 6;
                    case 0:
                        obj11 = beginStructure.decodeSerializableElement(descriptor2, 0, new ArrayListSerializer(StringSerializer.INSTANCE), obj11);
                        i4 |= 1;
                        i2 = 7;
                        i3 = 6;
                    case 1:
                        obj2 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, obj2);
                        i4 |= 2;
                        i2 = 7;
                        i3 = 6;
                    case 2:
                        obj12 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, PaywallData$Configuration$Images$$serializer.INSTANCE, obj12);
                        i4 |= 4;
                        i2 = 7;
                        i3 = 6;
                    case 3:
                        obj = beginStructure.decodeNullableSerializableElement(descriptor2, 3, PaywallData$Configuration$Images$$serializer.INSTANCE, obj);
                        i4 |= 8;
                        i2 = 7;
                        i3 = 6;
                    case 4:
                        i4 |= 16;
                        z5 = beginStructure.decodeBooleanElement(descriptor2, 4);
                    case 5:
                        z4 = beginStructure.decodeBooleanElement(descriptor2, 5);
                        i4 |= 32;
                    case 6:
                        obj10 = beginStructure.decodeNullableSerializableElement(descriptor2, i3, OptionalURLSerializer.INSTANCE, obj10);
                        i4 |= 64;
                    case 7:
                        obj8 = beginStructure.decodeNullableSerializableElement(descriptor2, i2, OptionalURLSerializer.INSTANCE, obj8);
                        i4 |= 128;
                    case 8:
                        obj9 = beginStructure.decodeSerializableElement(descriptor2, 8, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, obj9);
                        i4 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            obj3 = obj8;
            obj4 = obj9;
            obj5 = obj10;
            obj6 = obj12;
            z = z5;
            i = i4;
            z2 = z4;
            obj7 = obj11;
        }
        beginStructure.endStructure(descriptor2);
        return new PaywallData.Configuration(i, (List) obj7, (String) obj2, (PaywallData.Configuration.Images) obj6, (PaywallData.Configuration.Images) obj, z, z2, (URL) obj5, (URL) obj3, (PaywallData.Configuration.ColorInformation) obj4, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallData.Configuration value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PaywallData.Configuration.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
