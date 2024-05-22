package com.polidea.rxandroidble2.internal.connection;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import com.polidea.rxandroidble2.internal.util.CharacteristicPropertiesParser;

/* loaded from: classes5.dex */
public final class ConnectionModule_ProvideCharacteristicPropertiesParserFactory implements Factory<CharacteristicPropertiesParser> {
    @Override // bleshadow.javax.inject.Provider
    public CharacteristicPropertiesParser get() {
        return provideCharacteristicPropertiesParser();
    }

    public static ConnectionModule_ProvideCharacteristicPropertiesParserFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CharacteristicPropertiesParser provideCharacteristicPropertiesParser() {
        return (CharacteristicPropertiesParser) Preconditions.checkNotNullFromProvides(ConnectionModule.provideCharacteristicPropertiesParser());
    }

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {
        private static final ConnectionModule_ProvideCharacteristicPropertiesParserFactory INSTANCE = new ConnectionModule_ProvideCharacteristicPropertiesParserFactory();

        private InstanceHolder() {
        }
    }
}
