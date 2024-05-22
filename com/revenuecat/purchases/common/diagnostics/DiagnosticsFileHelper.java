package com.revenuecat.purchases.common.diagnostics;

import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.utils.EventsFileHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DiagnosticsFileHelper.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;", "Lcom/revenuecat/purchases/utils/EventsFileHelper;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry;", "fileHelper", "Lcom/revenuecat/purchases/common/FileHelper;", "(Lcom/revenuecat/purchases/common/FileHelper;)V", "isDiagnosticsFileTooBig", "", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class DiagnosticsFileHelper extends EventsFileHelper<DiagnosticsEntry> {
    public static final int DIAGNOSTICS_FILE_LIMIT_IN_KB = 500;
    public static final String DIAGNOSTICS_FILE_PATH = "RevenueCat/diagnostics/diagnostic_entries.jsonl";
    private final FileHelper fileHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsFileHelper(FileHelper fileHelper) {
        super(fileHelper, DIAGNOSTICS_FILE_PATH, null);
        Intrinsics.checkNotNullParameter(fileHelper, "fileHelper");
        this.fileHelper = fileHelper;
    }

    public final synchronized boolean isDiagnosticsFileTooBig() {
        return this.fileHelper.fileSizeInKB(DIAGNOSTICS_FILE_PATH) > 500.0d;
    }
}
