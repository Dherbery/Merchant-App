package com.bleplx.adapter;

import android.content.Context;

/* loaded from: classes.dex */
public class BleAdapterFactory {
    private static BleAdapterCreator bleAdapterCreator = new BleAdapterCreator() { // from class: com.bleplx.adapter.BleAdapterFactory.1
        @Override // com.bleplx.adapter.BleAdapterCreator
        public BleAdapter createAdapter(Context context) {
            return new BleModule(context);
        }
    };

    public static BleAdapter getNewAdapter(Context context) {
        return bleAdapterCreator.createAdapter(context);
    }

    public static void setBleAdapterCreator(BleAdapterCreator bleAdapterCreator2) {
        bleAdapterCreator = bleAdapterCreator2;
    }
}
