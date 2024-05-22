package com.polidea.rxandroidble2.internal.util;

import android.util.Pair;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class CharacteristicNotificationId extends Pair<UUID, Integer> {
    public CharacteristicNotificationId(UUID uuid, Integer num) {
        super(uuid, num);
    }

    @Override // android.util.Pair
    public String toString() {
        return "CharacteristicNotificationId{UUID=" + ((UUID) this.first).toString() + ", instanceId=" + ((Integer) this.second).toString() + AbstractJsonLexerKt.END_OBJ;
    }
}
