package com.revenuecat.purchases.common;

import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.verification.SignatureVerificationException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import org.json.JSONException;

/* compiled from: Dispatcher.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/common/Dispatcher;", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "mainHandler", "Landroid/os/Handler;", "runningIntegrationTests", "", "(Ljava/util/concurrent/ExecutorService;Landroid/os/Handler;Z)V", "close", "", "enqueue", "command", "Ljava/lang/Runnable;", "delay", "Lcom/revenuecat/purchases/common/Delay;", "isClosed", "AsyncCall", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public class Dispatcher {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final double INTEGRATION_TEST_DELAY_PERCENTAGE = 0.01d;
    private final ExecutorService executorService;
    private final Handler mainHandler;
    private final boolean runningIntegrationTests;

    public Dispatcher(ExecutorService executorService, Handler handler, boolean z) {
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        this.executorService = executorService;
        this.mainHandler = handler;
        this.runningIntegrationTests = z;
    }

    public /* synthetic */ Dispatcher(ExecutorService executorService, Handler handler, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(executorService, (i & 2) != 0 ? new Handler(Looper.getMainLooper()) : handler, (i & 4) != 0 ? false : z);
    }

    /* compiled from: Dispatcher.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/common/Dispatcher$Companion;", "", "()V", "INTEGRATION_TEST_DELAY_PERCENTAGE", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: Dispatcher.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "Ljava/lang/Runnable;", "()V", NotificationCompat.CATEGORY_CALL, "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "onCompletion", "", "result", "onError", "error", "Lcom/revenuecat/purchases/PurchasesError;", "run", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class AsyncCall implements Runnable {
        public abstract HTTPResult call() throws JSONException, IOException;

        public void onCompletion(HTTPResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        public void onError(PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                onCompletion(call());
            } catch (SignatureVerificationException e) {
                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                LogUtilsKt.errorLog(purchasesError);
                onError(purchasesError);
            } catch (IOException e2) {
                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e2);
                LogUtilsKt.errorLog(purchasesError2);
                onError(purchasesError2);
            } catch (SecurityException e3) {
                PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(e3);
                LogUtilsKt.errorLog(purchasesError3);
                onError(purchasesError3);
            } catch (JSONException e4) {
                PurchasesError purchasesError4 = ErrorsKt.toPurchasesError(e4);
                LogUtilsKt.errorLog(purchasesError4);
                onError(purchasesError4);
            }
        }
    }

    public static /* synthetic */ void enqueue$default(Dispatcher dispatcher, Runnable runnable, Delay delay, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueue");
        }
        if ((i & 2) != 0) {
            delay = Delay.NONE;
        }
        dispatcher.enqueue(runnable, delay);
    }

    public void enqueue(final Runnable command, Delay delay) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(delay, "delay");
        synchronized (this.executorService) {
            if (!this.executorService.isShutdown()) {
                Runnable runnable = new Runnable() { // from class: com.revenuecat.purchases.common.Dispatcher$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Dispatcher.enqueue$lambda$2$lambda$1(command, this);
                    }
                };
                if (delay != Delay.NONE && (this.executorService instanceof ScheduledExecutorService)) {
                    long random = RangesKt.random(new LongRange(Duration.m2714getInWholeMillisecondsimpl(delay.getMinDelay()), Duration.m2714getInWholeMillisecondsimpl(delay.getMaxDelay())), Random.INSTANCE);
                    if (this.runningIntegrationTests) {
                        random = (long) (random * 0.01d);
                    }
                    ((ScheduledExecutorService) this.executorService).schedule(runnable, random, TimeUnit.MILLISECONDS);
                } else {
                    this.executorService.submit(runnable);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$2$lambda$1(Runnable command, Dispatcher this$0) {
        Intrinsics.checkNotNullParameter(command, "$command");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            command.run();
        } catch (Exception e) {
            LogUtilsKt.errorLog$default("Exception running command: " + e, null, 2, null);
            Handler handler = this$0.mainHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.revenuecat.purchases.common.Dispatcher$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Dispatcher.enqueue$lambda$2$lambda$1$lambda$0(e);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$2$lambda$1$lambda$0(Exception e) {
        Intrinsics.checkNotNullParameter(e, "$e");
        throw e;
    }

    public void close() {
        synchronized (this.executorService) {
            this.executorService.shutdownNow();
        }
    }

    public boolean isClosed() {
        boolean isShutdown;
        synchronized (this.executorService) {
            isShutdown = this.executorService.isShutdown();
        }
        return isShutdown;
    }
}
