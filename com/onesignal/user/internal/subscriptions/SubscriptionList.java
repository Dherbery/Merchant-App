package com.onesignal.user.internal.subscriptions;

import com.onesignal.core.BuildConfig;
import com.onesignal.inAppMessages.internal.prompt.InAppMessagePromptTypes;
import com.onesignal.user.subscriptions.IEmailSubscription;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.onesignal.user.subscriptions.ISmsSubscription;
import com.onesignal.user.subscriptions.ISubscription;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionList.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "", "collection", "", "Lcom/onesignal/user/subscriptions/ISubscription;", "_fallbackPushSub", "Lcom/onesignal/user/subscriptions/IPushSubscription;", "(Ljava/util/List;Lcom/onesignal/user/subscriptions/IPushSubscription;)V", "getCollection", "()Ljava/util/List;", "emails", "Lcom/onesignal/user/subscriptions/IEmailSubscription;", "getEmails", InAppMessagePromptTypes.PUSH_PROMPT_KEY, "getPush", "()Lcom/onesignal/user/subscriptions/IPushSubscription;", "smss", "Lcom/onesignal/user/subscriptions/ISmsSubscription;", "getSmss", "getByEmail", "email", "", "getBySMS", "sms", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionList {
    private final IPushSubscription _fallbackPushSub;
    private final List<ISubscription> collection;

    /* JADX WARN: Multi-variable type inference failed */
    public SubscriptionList(List<? extends ISubscription> collection, IPushSubscription _fallbackPushSub) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(_fallbackPushSub, "_fallbackPushSub");
        this.collection = collection;
        this._fallbackPushSub = _fallbackPushSub;
    }

    public final List<ISubscription> getCollection() {
        return this.collection;
    }

    public final IPushSubscription getPush() {
        List<ISubscription> list = this.collection;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof IPushSubscription) {
                arrayList.add(obj);
            }
        }
        IPushSubscription iPushSubscription = (IPushSubscription) CollectionsKt.firstOrNull((List) arrayList);
        return iPushSubscription == null ? this._fallbackPushSub : iPushSubscription;
    }

    public final List<IEmailSubscription> getEmails() {
        List<ISubscription> list = this.collection;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof IEmailSubscription) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List<ISmsSubscription> getSmss() {
        List<ISubscription> list = this.collection;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof ISmsSubscription) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final IEmailSubscription getByEmail(String email) {
        Object obj;
        Intrinsics.checkNotNullParameter(email, "email");
        Iterator<T> it = getEmails().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((IEmailSubscription) obj).getEmail(), email)) {
                break;
            }
        }
        return (IEmailSubscription) obj;
    }

    public final ISmsSubscription getBySMS(String sms) {
        Object obj;
        Intrinsics.checkNotNullParameter(sms, "sms");
        Iterator<T> it = getSmss().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ISmsSubscription) obj).getNumber(), sms)) {
                break;
            }
        }
        return (ISmsSubscription) obj;
    }
}
