package com.mrousavy.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: FpsGraphView.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/mrousavy/camera/FpsGraphView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "graph", "Lcom/mrousavy/camera/FpsGraphView$Graph;", "textView", "Landroid/widget/TextView;", "onTick", "", "Graph", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FpsGraphView extends FrameLayout {
    private final Graph graph;
    private final TextView textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FpsGraphView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        TextView textView = new TextView(context);
        this.textView = textView;
        Graph graph = new Graph(context);
        this.graph = graph;
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        textView.setText("0 FPS");
        graph.setCallback(new Graph.Callback() { // from class: com.mrousavy.camera.FpsGraphView.1
            @Override // com.mrousavy.camera.FpsGraphView.Graph.Callback
            public void onAverageFpsChanged(int averageFps) {
                FpsGraphView.this.textView.setText(averageFps + " FPS");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(300, 150);
        layoutParams.setMargins(15, 150, 0, 0);
        layoutParams.gravity = 51;
        FrameLayout.LayoutParams layoutParams2 = layoutParams;
        addView(graph, layoutParams2);
        addView(textView, layoutParams2);
    }

    public final void onTick() {
        this.graph.onTick();
    }

    /* compiled from: FpsGraphView.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001dB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0015\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0006\u0010\u001b\u001a\u00020\u0018J\b\u0010\u001c\u001a\u00020\u0018H\u0016R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0007j\b\u0012\u0004\u0012\u00020\u0014`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/mrousavy/camera/FpsGraphView$Graph;", "Landroid/view/View;", "Ljava/lang/Runnable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bars", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "callback", "Lcom/mrousavy/camera/FpsGraphView$Graph$Callback;", "getCallback", "()Lcom/mrousavy/camera/FpsGraphView$Graph$Callback;", "setCallback", "(Lcom/mrousavy/camera/FpsGraphView$Graph$Callback;)V", "maxBars", "paint", "Landroid/graphics/Paint;", "ticks", "", "getAverageFps", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTick", "run", "Callback", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Graph extends View implements Runnable {
        private final ArrayList<Integer> bars;
        private Callback callback;
        private final int maxBars;
        private final Paint paint;
        private final ArrayList<Double> ticks;

        /* compiled from: FpsGraphView.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/mrousavy/camera/FpsGraphView$Graph$Callback;", "", "onAverageFpsChanged", "", "averageFps", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public interface Callback {
            void onAverageFpsChanged(int averageFps);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Graph(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            this.maxBars = 30;
            this.ticks = new ArrayList<>();
            this.bars = new ArrayList<>();
            Paint paint = new Paint();
            paint.setColor(SupportMenu.CATEGORY_MASK);
            paint.setStrokeWidth(5.0f);
            paint.setStyle(Paint.Style.FILL);
            this.paint = paint;
            post(this);
        }

        public final Callback getCallback() {
            return this.callback;
        }

        public final void setCallback(Callback callback) {
            this.callback = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            int averageFps = getAverageFps(this.ticks);
            this.ticks.clear();
            this.bars.add(Integer.valueOf(averageFps));
            if (this.bars.size() > this.maxBars) {
                this.bars.remove(0);
            }
            invalidate();
            postDelayed(this, 1000L);
            Callback callback = this.callback;
            if (callback != null) {
                callback.onAverageFpsChanged(averageFps);
            }
        }

        private final int getAverageFps(List<Double> ticks) {
            if (ticks.isEmpty()) {
                return 0;
            }
            if (ticks.size() < 2) {
                return 1;
            }
            return MathKt.roundToInt(1000.0d / ((((Number) CollectionsKt.last((List) ticks)).doubleValue() - ((Number) CollectionsKt.first((List) ticks)).doubleValue()) / (ticks.size() - 1)));
        }

        public final void onTick() {
            this.ticks.add(Double.valueOf(System.currentTimeMillis()));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            super.onDraw(canvas);
            if (this.bars.size() < 2) {
                return;
            }
            float max = Math.max(((Number) CollectionsKt.maxOrThrow((Iterable<Double>) this.bars)).intValue(), 60.0f);
            float width = getWidth();
            int i = this.maxBars;
            float f = width / i;
            if (i < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (((Integer) CollectionsKt.getOrNull(this.bars, i2)) != null) {
                    canvas.drawRect(i2 * f, getHeight() - ((r4.intValue() / max) * getHeight()), (i2 + 1) * f, getHeight(), this.paint);
                }
                if (i2 == i) {
                    return;
                } else {
                    i2++;
                }
            }
        }
    }
}
