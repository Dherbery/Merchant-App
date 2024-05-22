package com.onesignal.core.internal.startup;

import com.onesignal.core.BuildConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StartupService.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/onesignal/core/internal/startup/StartupService;", "", "_bootstrapServices", "", "Lcom/onesignal/core/internal/startup/IBootstrapService;", "_startableServices", "Lcom/onesignal/core/internal/startup/IStartableService;", "(Ljava/util/List;Ljava/util/List;)V", "bootstrap", "", "start", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class StartupService {
    private final List<IBootstrapService> _bootstrapServices;
    private final List<IStartableService> _startableServices;

    /* JADX WARN: Multi-variable type inference failed */
    public StartupService(List<? extends IBootstrapService> _bootstrapServices, List<? extends IStartableService> _startableServices) {
        Intrinsics.checkNotNullParameter(_bootstrapServices, "_bootstrapServices");
        Intrinsics.checkNotNullParameter(_startableServices, "_startableServices");
        this._bootstrapServices = _bootstrapServices;
        this._startableServices = _startableServices;
    }

    public final void bootstrap() {
        Iterator<IBootstrapService> it = this._bootstrapServices.iterator();
        while (it.hasNext()) {
            it.next().bootstrap();
        }
    }

    public final void start() {
        Iterator<IStartableService> it = this._startableServices.iterator();
        while (it.hasNext()) {
            it.next().start();
        }
    }
}
