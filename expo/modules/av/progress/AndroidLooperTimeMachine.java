package expo.modules.av.progress;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidLooperTimeMachine.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lexpo/modules/av/progress/AndroidLooperTimeMachine;", "Lexpo/modules/av/progress/TimeMachine;", "()V", "time", "", "getTime", "()J", "scheduleAt", "", "intervalMillis", "callback", "Lkotlin/Function0;", "Lexpo/modules/av/progress/TimeMachineTick;", "expo-av_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AndroidLooperTimeMachine implements TimeMachine {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleAt$lambda$0(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // expo.modules.av.progress.TimeMachine
    public void scheduleAt(long intervalMillis, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        new Handler().postDelayed(new Runnable() { // from class: expo.modules.av.progress.AndroidLooperTimeMachine$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AndroidLooperTimeMachine.scheduleAt$lambda$0(Function0.this);
            }
        }, intervalMillis);
    }

    @Override // expo.modules.av.progress.TimeMachine
    public long getTime() {
        return System.currentTimeMillis();
    }
}
