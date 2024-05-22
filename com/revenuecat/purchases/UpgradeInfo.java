package com.revenuecat.purchases;

import com.amazon.a.a.o.b;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpgradeInfo.kt */
@Deprecated(message = "Use .oldProductId() and .googleProrationMode() in PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "PurchaseParams.Builder.oldProductId() and PurchaseParams.Builder.googleProrationMode()", imports = {}))
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/UpgradeInfo;", "", "oldSku", "", b.l, "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getOldSku", "()Ljava/lang/String;", "getProrationMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/revenuecat/purchases/UpgradeInfo;", "equals", "", "other", "hashCode", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UpgradeInfo {
    private final String oldSku;
    private final Integer prorationMode;

    public static /* synthetic */ UpgradeInfo copy$default(UpgradeInfo upgradeInfo, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = upgradeInfo.oldSku;
        }
        if ((i & 2) != 0) {
            num = upgradeInfo.prorationMode;
        }
        return upgradeInfo.copy(str, num);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOldSku() {
        return this.oldSku;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getProrationMode() {
        return this.prorationMode;
    }

    public final UpgradeInfo copy(String oldSku, Integer prorationMode) {
        Intrinsics.checkNotNullParameter(oldSku, "oldSku");
        return new UpgradeInfo(oldSku, prorationMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpgradeInfo)) {
            return false;
        }
        UpgradeInfo upgradeInfo = (UpgradeInfo) other;
        return Intrinsics.areEqual(this.oldSku, upgradeInfo.oldSku) && Intrinsics.areEqual(this.prorationMode, upgradeInfo.prorationMode);
    }

    public int hashCode() {
        int hashCode = this.oldSku.hashCode() * 31;
        Integer num = this.prorationMode;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "UpgradeInfo(oldSku=" + this.oldSku + ", prorationMode=" + this.prorationMode + ')';
    }

    public UpgradeInfo(String oldSku, Integer num) {
        Intrinsics.checkNotNullParameter(oldSku, "oldSku");
        this.oldSku = oldSku;
        this.prorationMode = num;
    }

    public /* synthetic */ UpgradeInfo(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : num);
    }

    public final String getOldSku() {
        return this.oldSku;
    }

    public final Integer getProrationMode() {
        return this.prorationMode;
    }
}
