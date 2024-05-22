package com.revenuecat.purchases;

import android.os.Parcelable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* compiled from: ProrationMode.kt */
@Deprecated(message = "Replaced with ReplacementMode", replaceWith = @ReplaceWith(expression = "ReplacementMode", imports = {}))
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ProrationMode;", "Landroid/os/Parcelable;", "name", "", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface ProrationMode extends Parcelable {

    /* compiled from: ProrationMode.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getName$annotations() {
        }
    }

    String getName();
}
