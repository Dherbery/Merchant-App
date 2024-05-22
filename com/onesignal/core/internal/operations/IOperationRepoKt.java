package com.onesignal.core.internal.operations;

import com.onesignal.core.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: IOperationRepo.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"containsInstanceOf", "", "T", "Lcom/onesignal/core/internal/operations/Operation;", "Lcom/onesignal/core/internal/operations/IOperationRepo;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class IOperationRepoKt {
    public static final /* synthetic */ <T extends Operation> boolean containsInstanceOf(IOperationRepo iOperationRepo) {
        Intrinsics.checkNotNullParameter(iOperationRepo, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return iOperationRepo.containsInstanceOf(Reflection.getOrCreateKotlinClass(Operation.class));
    }
}
