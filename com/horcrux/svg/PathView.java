package com.horcrux.svg;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.ReactContext;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class PathView extends RenderableView {
    private Path mPath;

    public PathView(ReactContext reactContext) {
        super(reactContext);
        PathParser.mScale = this.mScale;
        this.mPath = new Path();
    }

    public void setD(String str) {
        this.mPath = PathParser.parse(str);
        this.elements = PathParser.elements;
        Iterator<PathElement> it = this.elements.iterator();
        while (it.hasNext()) {
            for (Point point : it.next().points) {
                point.x *= this.mScale;
                point.y *= this.mScale;
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public Path getPath(Canvas canvas, Paint paint) {
        return this.mPath;
    }
}
