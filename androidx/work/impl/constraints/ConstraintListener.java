package androidx.work.impl.constraints;

import kotlin.Metadata;

/* compiled from: ConstraintListener.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H'¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/work/impl/constraints/ConstraintListener;", "T", "", "onConstraintChanged", "", "newValue", "(Ljava/lang/Object;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public interface ConstraintListener<T> {
    void onConstraintChanged(T newValue);
}
