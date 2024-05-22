package com.amazon.a.a.i;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import com.amazon.a.a.i.c;
import com.facebook.common.util.UriUtil;

/* compiled from: SimplePrompt.java */
/* loaded from: classes.dex */
public abstract class h extends b {
    private static final com.amazon.a.a.o.c b = new com.amazon.a.a.o.c("SimplePrompt");
    private static final String e = "OK";
    protected final c c;
    protected final a d;

    /* compiled from: SimplePrompt.java */
    /* loaded from: classes.dex */
    public enum a {
        LEGACY,
        EXTENDED
    }

    protected abstract void i();

    public h(c cVar) {
        this(cVar, a.LEGACY);
    }

    public h(c cVar, a aVar) {
        com.amazon.a.a.o.a.a.a((Object) cVar, UriUtil.LOCAL_CONTENT_SCHEME);
        this.c = cVar;
        this.d = aVar;
        b.a("created SimplePrompt with mode " + aVar);
    }

    @Override // com.amazon.a.a.i.b
    protected boolean b(Activity activity) {
        return this.c.h();
    }

    @Override // com.amazon.a.a.i.b
    public final Dialog d(Activity activity) {
        if (this.d == a.LEGACY) {
            return e(activity);
        }
        return f(activity);
    }

    private final Dialog e(Activity activity) {
        b.a("Legacy mode dialog, legacy title = " + this.c.e() + ", extended title = " + this.c.f());
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(this.c.f()).setMessage(this.c.d()).setCancelable(false).setNeutralButton(e, new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.i.h.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (h.this.k()) {
                    h.this.i();
                }
            }
        });
        return builder.create();
    }

    private final Dialog f(Activity activity) {
        com.amazon.a.a.o.c cVar = b;
        cVar.a("doCreate() called to create extended dialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(this.c.f()).setMessage(this.c.d()).setCancelable(false);
        a(builder);
        cVar.a("doCreate() returning");
        return builder.create();
    }

    private void a(AlertDialog.Builder builder) {
        String[] b2 = this.c.b();
        if (b2.length < 1 || b2.length > 2) {
            b.b("Unexpected button count: " + b2.length);
            return;
        }
        boolean[] a2 = a(this.c.c());
        int i = -1;
        int i2 = 0;
        for (int i3 = 0; i3 < a2.length; i3++) {
            if (a2[i3]) {
                i2++;
                i = i3;
            }
        }
        if (i2 == 1) {
            b.a("single button dialog");
            a(builder, b2[i], i);
        } else {
            b.a("two button dialog");
            builder.setNegativeButton(b2[0], new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.i.h.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (h.this.k()) {
                        h.this.a(0);
                    }
                }
            });
            builder.setPositiveButton(b2[1], new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.i.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (h.this.k()) {
                        h.this.a(1);
                    }
                }
            });
        }
    }

    private void a(AlertDialog.Builder builder, String str, final int i) {
        builder.setNeutralButton(str, new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.i.h.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (h.this.k()) {
                    h.this.a(i);
                }
            }
        });
    }

    private boolean[] a(c.a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            boolean a2 = a(aVarArr[i]);
            zArr[i] = a2;
            if (!a2) {
                b.a("filterActions() filtering item " + i);
            }
        }
        return zArr;
    }

    @Override // com.amazon.a.a.i.b
    protected void a(d dVar) {
        i();
    }

    protected void a(int i) {
        b.b("extended doAction from base class called, this should never happen.");
        i();
    }

    protected boolean a(c.a aVar) {
        return aVar == c.a.DEFAULT;
    }
}
