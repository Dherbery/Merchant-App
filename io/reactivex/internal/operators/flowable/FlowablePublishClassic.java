package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;

/* loaded from: classes6.dex */
public interface FlowablePublishClassic<T> {
    int publishBufferSize();

    Publisher<T> publishSource();
}
