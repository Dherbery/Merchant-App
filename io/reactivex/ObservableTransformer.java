package io.reactivex;

/* loaded from: classes4.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    /* renamed from: apply */
    ObservableSource<Downstream> apply2(Observable<Upstream> observable);
}
