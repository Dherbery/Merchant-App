package com.onesignal.session.internal.influence;

import com.onesignal.core.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* compiled from: InfluenceType.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/onesignal/session/internal/influence/InfluenceType;", "", "(Ljava/lang/String;I)V", "isAttributed", "", "isDirect", "isDisabled", "isIndirect", "isUnattributed", "DIRECT", "INDIRECT", "UNATTRIBUTED", "DISABLED", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public enum InfluenceType {
    DIRECT,
    INDIRECT,
    UNATTRIBUTED,
    DISABLED;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final InfluenceType fromString(String str) {
        return INSTANCE.fromString(str);
    }

    public final boolean isAttributed() {
        return isDirect() || isIndirect();
    }

    public final boolean isDirect() {
        return this == DIRECT;
    }

    public final boolean isIndirect() {
        return this == INDIRECT;
    }

    public final boolean isUnattributed() {
        return this == UNATTRIBUTED;
    }

    public final boolean isDisabled() {
        return this == DISABLED;
    }

    /* compiled from: InfluenceType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/onesignal/session/internal/influence/InfluenceType$Companion;", "", "()V", "fromString", "Lcom/onesignal/session/internal/influence/InfluenceType;", "value", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final InfluenceType fromString(String value) {
            InfluenceType influenceType;
            if (value != null) {
                InfluenceType[] values = InfluenceType.values();
                int length = values.length - 1;
                if (length >= 0) {
                    while (true) {
                        int i = length - 1;
                        influenceType = values[length];
                        if (StringsKt.equals(influenceType.name(), value, true)) {
                            break;
                        }
                        if (i < 0) {
                            break;
                        }
                        length = i;
                    }
                }
                influenceType = null;
                if (influenceType != null) {
                    return influenceType;
                }
            }
            return InfluenceType.UNATTRIBUTED;
        }
    }
}
