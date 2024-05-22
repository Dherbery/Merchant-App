package com.google.devtools.ksp.processing;

import com.google.devtools.ksp.symbol.KSFile;
import com.onesignal.session.internal.outcomes.impl.OutcomeConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeGenerator.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0002\u0010\u0007B%\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/google/devtools/ksp/processing/Dependencies;", "", "aggregating", "", OutcomeConstants.OUTCOME_SOURCES, "", "Lcom/google/devtools/ksp/symbol/KSFile;", "(Z[Lcom/google/devtools/ksp/symbol/KSFile;)V", "isAllSources", "originatingFiles", "", "(ZZLjava/util/List;)V", "getAggregating", "()Z", "getOriginatingFiles", "()Ljava/util/List;", "Companion", "api"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Dependencies {
    private final boolean aggregating;
    private final boolean isAllSources;
    private final List<KSFile> originatingFiles;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Dependencies ALL_FILES = new Dependencies(true, true, CollectionsKt.emptyList());

    /* JADX WARN: Multi-variable type inference failed */
    private Dependencies(boolean z, boolean z2, List<? extends KSFile> list) {
        this.isAllSources = z;
        this.aggregating = z2;
        this.originatingFiles = list;
    }

    /* renamed from: isAllSources, reason: from getter */
    public final boolean getIsAllSources() {
        return this.isAllSources;
    }

    public final boolean getAggregating() {
        return this.aggregating;
    }

    public final List<KSFile> getOriginatingFiles() {
        return this.originatingFiles;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Dependencies(boolean z, KSFile... sources) {
        this(false, z, ArraysKt.toList(sources));
        Intrinsics.checkNotNullParameter(sources, "sources");
    }

    /* compiled from: CodeGenerator.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/devtools/ksp/processing/Dependencies$Companion;", "", "()V", "ALL_FILES", "Lcom/google/devtools/ksp/processing/Dependencies;", "getALL_FILES", "()Lcom/google/devtools/ksp/processing/Dependencies;", "api"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Dependencies getALL_FILES() {
            return Dependencies.ALL_FILES;
        }
    }
}
