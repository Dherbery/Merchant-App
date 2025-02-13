package com.google.android.gms.internal.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zao extends ContextCompat {
    @ResultIgnorabilityUnspecified
    @Deprecated
    public static Intent zaa(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        Intent registerReceiver;
        if (zan.zaa()) {
            registerReceiver = context.registerReceiver(broadcastReceiver, intentFilter, true != zan.zaa() ? 0 : 2);
            return registerReceiver;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter);
    }
}
