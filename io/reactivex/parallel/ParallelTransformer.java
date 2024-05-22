package io.reactivex.parallel;

/* loaded from: classes6.dex */
public interface ParallelTransformer<Upstream, Downstream> {
    ParallelFlowable<Downstream> apply(ParallelFlowable<Upstream> parallelFlowable);
}
