package com.onesignal;

import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* compiled from: Continue.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005H\u0007J2\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/onesignal/Continue;", "", "()V", "none", "Lkotlin/coroutines/Continuation;", "R", "with", "onFinished", "Ljava/util/function/Consumer;", "Lcom/onesignal/ContinueResult;", "context", "Lkotlin/coroutines/CoroutineContext;", com.onesignal.core.BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class Continue {
    public static final Continue INSTANCE = new Continue();

    @JvmStatic
    public static final <R> Continuation<R> with(Consumer<ContinueResult<R>> onFinished) {
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        return with$default(onFinished, null, 2, null);
    }

    private Continue() {
    }

    public static /* synthetic */ Continuation with$default(Consumer consumer, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        return with(consumer, coroutineContext);
    }

    @JvmStatic
    public static final <R> Continuation<R> with(final Consumer<ContinueResult<R>> onFinished, final CoroutineContext context) {
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        Intrinsics.checkNotNullParameter(context, "context");
        return new Continuation<R>() { // from class: com.onesignal.Continue$with$1
            @Override // kotlin.coroutines.Continuation
            /* renamed from: getContext, reason: from getter */
            public CoroutineContext get$context() {
                return CoroutineContext.this;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object result) {
                onFinished.accept(new ContinueResult(Result.m1325isSuccessimpl(result), Result.m1324isFailureimpl(result) ? null : result, Result.m1321exceptionOrNullimpl(result)));
            }
        };
    }

    @JvmStatic
    public static final <R> Continuation<R> none() {
        return new Continuation<R>() { // from class: com.onesignal.Continue$none$1
            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object result) {
            }

            @Override // kotlin.coroutines.Continuation
            /* renamed from: getContext */
            public CoroutineContext get$context() {
                return Dispatchers.getMain();
            }
        };
    }
}
