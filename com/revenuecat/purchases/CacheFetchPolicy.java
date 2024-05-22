package com.revenuecat.purchases;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CacheFetchPolicy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/CacheFetchPolicy;", "", "(Ljava/lang/String;I)V", "CACHE_ONLY", "FETCH_CURRENT", "NOT_STALE_CACHED_OR_CURRENT", "CACHED_OR_FETCHED", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public enum CacheFetchPolicy {
    CACHE_ONLY,
    FETCH_CURRENT,
    NOT_STALE_CACHED_OR_CURRENT,
    CACHED_OR_FETCHED;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: CacheFetchPolicy.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/CacheFetchPolicy$Companion;", "", "()V", Constants.COLLATION_DEFAULT, "Lcom/revenuecat/purchases/CacheFetchPolicy;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: default, reason: not valid java name */
        public final CacheFetchPolicy m1080default() {
            return CacheFetchPolicy.CACHED_OR_FETCHED;
        }
    }
}
