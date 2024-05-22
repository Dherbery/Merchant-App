package com.revenuecat.purchases.paywalls;

import com.facebook.react.modules.appstate.AppStateModule;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.paywalls.PaywallData;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: PaywallData.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.Configuration.Colors.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes5.dex */
public final class PaywallData$Configuration$Colors$$serializer implements GeneratedSerializer<PaywallData.Configuration.Colors> {
    public static final PaywallData$Configuration$Colors$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PaywallData$Configuration$Colors$$serializer paywallData$Configuration$Colors$$serializer = new PaywallData$Configuration$Colors$$serializer();
        INSTANCE = paywallData$Configuration$Colors$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.Configuration.Colors", paywallData$Configuration$Colors$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement(AppStateModule.APP_STATE_BACKGROUND, false);
        pluginGeneratedSerialDescriptor.addElement("text_1", false);
        pluginGeneratedSerialDescriptor.addElement("text_2", true);
        pluginGeneratedSerialDescriptor.addElement("text_3", true);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_background", false);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_foreground", false);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_secondary_background", true);
        pluginGeneratedSerialDescriptor.addElement("accent_1", true);
        pluginGeneratedSerialDescriptor.addElement("accent_2", true);
        pluginGeneratedSerialDescriptor.addElement("accent_3", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$Configuration$Colors$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{PaywallColor.Serializer.INSTANCE, PaywallColor.Serializer.INSTANCE, BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), PaywallColor.Serializer.INSTANCE, PaywallColor.Serializer.INSTANCE, BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0089. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallData.Configuration.Colors deserialize(Decoder decoder) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        int i;
        Object obj10;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i2 = 9;
        Object obj11 = null;
        if (beginStructure.decodeSequentially()) {
            obj10 = beginStructure.decodeSerializableElement(descriptor2, 0, PaywallColor.Serializer.INSTANCE, null);
            obj8 = beginStructure.decodeSerializableElement(descriptor2, 1, PaywallColor.Serializer.INSTANCE, null);
            obj9 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, PaywallColor.Serializer.INSTANCE, null);
            obj7 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, PaywallColor.Serializer.INSTANCE, null);
            obj6 = beginStructure.decodeSerializableElement(descriptor2, 4, PaywallColor.Serializer.INSTANCE, null);
            obj5 = beginStructure.decodeSerializableElement(descriptor2, 5, PaywallColor.Serializer.INSTANCE, null);
            obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 6, PaywallColor.Serializer.INSTANCE, null);
            obj4 = beginStructure.decodeNullableSerializableElement(descriptor2, 7, PaywallColor.Serializer.INSTANCE, null);
            obj2 = beginStructure.decodeNullableSerializableElement(descriptor2, 8, PaywallColor.Serializer.INSTANCE, null);
            obj = beginStructure.decodeNullableSerializableElement(descriptor2, 9, PaywallColor.Serializer.INSTANCE, null);
            i = 1023;
        } else {
            boolean z = true;
            int i3 = 0;
            Object obj12 = null;
            Object obj13 = null;
            Object obj14 = null;
            Object obj15 = null;
            Object obj16 = null;
            Object obj17 = null;
            Object obj18 = null;
            Object obj19 = null;
            Object obj20 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 9;
                    case 0:
                        obj11 = beginStructure.decodeSerializableElement(descriptor2, 0, PaywallColor.Serializer.INSTANCE, obj11);
                        i3 |= 1;
                        i2 = 9;
                    case 1:
                        obj19 = beginStructure.decodeSerializableElement(descriptor2, 1, PaywallColor.Serializer.INSTANCE, obj19);
                        i3 |= 2;
                        i2 = 9;
                    case 2:
                        obj20 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, PaywallColor.Serializer.INSTANCE, obj20);
                        i3 |= 4;
                        i2 = 9;
                    case 3:
                        obj18 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, PaywallColor.Serializer.INSTANCE, obj18);
                        i3 |= 8;
                        i2 = 9;
                    case 4:
                        obj17 = beginStructure.decodeSerializableElement(descriptor2, 4, PaywallColor.Serializer.INSTANCE, obj17);
                        i3 |= 16;
                        i2 = 9;
                    case 5:
                        obj16 = beginStructure.decodeSerializableElement(descriptor2, 5, PaywallColor.Serializer.INSTANCE, obj16);
                        i3 |= 32;
                        i2 = 9;
                    case 6:
                        obj14 = beginStructure.decodeNullableSerializableElement(descriptor2, 6, PaywallColor.Serializer.INSTANCE, obj14);
                        i3 |= 64;
                        i2 = 9;
                    case 7:
                        obj15 = beginStructure.decodeNullableSerializableElement(descriptor2, 7, PaywallColor.Serializer.INSTANCE, obj15);
                        i3 |= 128;
                        i2 = 9;
                    case 8:
                        obj13 = beginStructure.decodeNullableSerializableElement(descriptor2, 8, PaywallColor.Serializer.INSTANCE, obj13);
                        i3 |= 256;
                    case 9:
                        obj12 = beginStructure.decodeNullableSerializableElement(descriptor2, i2, PaywallColor.Serializer.INSTANCE, obj12);
                        i3 |= 512;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            obj = obj12;
            obj2 = obj13;
            obj3 = obj14;
            obj4 = obj15;
            obj5 = obj16;
            obj6 = obj17;
            obj7 = obj18;
            obj8 = obj19;
            obj9 = obj20;
            Object obj21 = obj11;
            i = i3;
            obj10 = obj21;
        }
        beginStructure.endStructure(descriptor2);
        return new PaywallData.Configuration.Colors(i, (PaywallColor) obj10, (PaywallColor) obj8, (PaywallColor) obj9, (PaywallColor) obj7, (PaywallColor) obj6, (PaywallColor) obj5, (PaywallColor) obj3, (PaywallColor) obj4, (PaywallColor) obj2, (PaywallColor) obj, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallData.Configuration.Colors value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PaywallData.Configuration.Colors.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
