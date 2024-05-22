package com.onesignal.notifications.receivers;

import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.services.ADMMessageHandler;
import com.onesignal.notifications.services.ADMMessageHandlerJob;
import kotlin.Metadata;

/* compiled from: ADMMessageReceiver.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/onesignal/notifications/receivers/ADMMessageReceiver;", "Lcom/amazon/device/messaging/ADMMessageReceiver;", "()V", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ADMMessageReceiver extends com.amazon.device.messaging.ADMMessageReceiver {
    private static final int JOB_ID = 123891;

    public ADMMessageReceiver() {
        super(ADMMessageHandler.class);
        boolean z;
        try {
            Class.forName("com.amazon.device.messaging.ADMMessageHandlerJobBase");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        if (z) {
            registerJobServiceClass(ADMMessageHandlerJob.class, JOB_ID);
        }
        Logging.debug$default("ADM latest available: " + z, null, 2, null);
    }
}
