package com.amazon.a.a.n.c;

/* compiled from: AbstractTaskWorkflowAwareTask.java */
/* loaded from: classes.dex */
public abstract class a implements c {
    private b a;

    @Override // com.amazon.a.a.n.c.c
    public final void a(b bVar) {
        com.amazon.a.a.o.a.a.a((Object) bVar, "workflow");
        com.amazon.a.a.o.a.a.c(this.a, "workflow instance can only be set once");
        this.a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean m() {
        return this.a != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n() {
        com.amazon.a.a.o.a.a.a(m(), "task is no a workflow child");
        this.a.d();
    }
}
