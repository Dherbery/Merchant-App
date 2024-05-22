package io.reactivex;

/* loaded from: classes4.dex */
public interface SingleTransformer<Upstream, Downstream> {
    /* renamed from: apply */
    SingleSource<Downstream> apply2(Single<Upstream> single);
}
