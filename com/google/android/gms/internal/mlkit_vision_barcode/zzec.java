package com.google.android.gms.internal.mlkit_vision_barcode;

import com.amazon.a.a.o.b.f;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public abstract class zzec<V> extends zzez implements zzev<V> {
    static final boolean zza;
    private static final Logger zzb;
    private static final zza zzc;
    private static final Object zzd;

    @CheckForNull
    private volatile zzd listeners;

    @CheckForNull
    private volatile Object value;

    @CheckForNull
    private volatile zzj waiters;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
    /* loaded from: classes4.dex */
    public abstract class zza {
        /* synthetic */ zza(zzeb zzebVar) {
        }

        abstract zzd zza(zzec zzecVar, zzd zzdVar);

        abstract zzj zzb(zzec zzecVar, zzj zzjVar);

        abstract void zzc(zzj zzjVar, @CheckForNull zzj zzjVar2);

        abstract void zzd(zzj zzjVar, Thread thread);

        abstract boolean zze(zzec zzecVar, @CheckForNull zzd zzdVar, zzd zzdVar2);

        abstract boolean zzf(zzec zzecVar, @CheckForNull Object obj, Object obj2);

        abstract boolean zzg(zzec zzecVar, @CheckForNull zzj zzjVar, @CheckForNull zzj zzjVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
    /* loaded from: classes4.dex */
    public final class zzb {

        @CheckForNull
        static final zzb zza;

        @CheckForNull
        static final zzb zzb;
        final boolean zzc;

        @CheckForNull
        final Throwable zzd;

        static {
            if (zzec.zza) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zzb(false, null);
                zza = new zzb(true, null);
            }
        }

        zzb(boolean z, @CheckForNull Throwable th) {
            this.zzc = z;
            this.zzd = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
    /* loaded from: classes4.dex */
    public final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzec.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
    /* loaded from: classes4.dex */
    public final class zzd {
        static final zzd zza = new zzd();

        @CheckForNull
        zzd next;

        @CheckForNull
        final Runnable zzb;

        @CheckForNull
        final Executor zzc;

        zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
    /* loaded from: classes4.dex */
    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzj, Thread> zza;
        final AtomicReferenceFieldUpdater<zzj, zzj> zzb;
        final AtomicReferenceFieldUpdater<zzec, zzj> zzc;
        final AtomicReferenceFieldUpdater<zzec, zzd> zzd;
        final AtomicReferenceFieldUpdater<zzec, Object> zze;

        zze(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super(null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final zzd zza(zzec zzecVar, zzd zzdVar) {
            return this.zzd.getAndSet(zzecVar, zzdVar);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final zzj zzb(zzec zzecVar, zzj zzjVar) {
            return this.zzc.getAndSet(zzecVar, zzjVar);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final void zzc(zzj zzjVar, @CheckForNull zzj zzjVar2) {
            this.zzb.lazySet(zzjVar, zzjVar2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final void zzd(zzj zzjVar, Thread thread) {
            this.zza.lazySet(zzjVar, thread);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final boolean zze(zzec zzecVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            return zzed.zza(this.zzd, zzecVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final boolean zzf(zzec zzecVar, @CheckForNull Object obj, Object obj2) {
            return zzed.zza(this.zze, zzecVar, obj, obj2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final boolean zzg(zzec zzecVar, @CheckForNull zzj zzjVar, @CheckForNull zzj zzjVar2) {
            return zzed.zza(this.zzc, zzecVar, zzjVar, zzjVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
    /* loaded from: classes4.dex */
    public final class zzf<V> implements Runnable {
        final zzec<V> zza;
        final zzev<? extends V> zzb;

        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
    /* loaded from: classes4.dex */
    final class zzg extends zza {
        private zzg() {
            super(null);
        }

        /* synthetic */ zzg(zzee zzeeVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final zzd zza(zzec zzecVar, zzd zzdVar) {
            zzd zzdVar2;
            synchronized (zzecVar) {
                zzdVar2 = zzecVar.listeners;
                if (zzdVar2 != zzdVar) {
                    zzecVar.listeners = zzdVar;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final zzj zzb(zzec zzecVar, zzj zzjVar) {
            zzj zzjVar2;
            synchronized (zzecVar) {
                zzjVar2 = zzecVar.waiters;
                if (zzjVar2 != zzjVar) {
                    zzecVar.waiters = zzjVar;
                }
            }
            return zzjVar2;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final void zzc(zzj zzjVar, @CheckForNull zzj zzjVar2) {
            zzjVar.next = zzjVar2;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final void zzd(zzj zzjVar, Thread thread) {
            zzjVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final boolean zze(zzec zzecVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            synchronized (zzecVar) {
                if (zzecVar.listeners != zzdVar) {
                    return false;
                }
                zzecVar.listeners = zzdVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final boolean zzf(zzec zzecVar, @CheckForNull Object obj, Object obj2) {
            synchronized (zzecVar) {
                if (zzecVar.value != obj) {
                    return false;
                }
                zzecVar.value = obj2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final boolean zzg(zzec zzecVar, @CheckForNull zzj zzjVar, @CheckForNull zzj zzjVar2) {
            synchronized (zzecVar) {
                if (zzecVar.waiters != zzjVar) {
                    return false;
                }
                zzecVar.waiters = zzjVar2;
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
    /* loaded from: classes4.dex */
    public interface zzh<V> extends zzev<V> {
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
    /* loaded from: classes4.dex */
    final class zzi extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzec.zzi.1
                        @Override // java.security.PrivilegedExceptionAction
                        public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                if (Unsafe.class.isInstance(obj)) {
                                    return (Unsafe) Unsafe.class.cast(obj);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
                }
                try {
                    zzc = unsafe.objectFieldOffset(zzec.class.getDeclaredField("waiters"));
                    zzb = unsafe.objectFieldOffset(zzec.class.getDeclaredField("listeners"));
                    zzd = unsafe.objectFieldOffset(zzec.class.getDeclaredField("value"));
                    zze = unsafe.objectFieldOffset(zzj.class.getDeclaredField("thread"));
                    zzf = unsafe.objectFieldOffset(zzj.class.getDeclaredField("next"));
                    zza = unsafe;
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                } catch (RuntimeException e2) {
                    throw e2;
                }
            } catch (PrivilegedActionException e3) {
                throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
            }
        }

        private zzi() {
            super(null);
        }

        /* synthetic */ zzi(zzeg zzegVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final zzd zza(zzec zzecVar, zzd zzdVar) {
            zzd zzdVar2;
            do {
                zzdVar2 = zzecVar.listeners;
                if (zzdVar == zzdVar2) {
                    return zzdVar2;
                }
            } while (!zze(zzecVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final zzj zzb(zzec zzecVar, zzj zzjVar) {
            zzj zzjVar2;
            do {
                zzjVar2 = zzecVar.waiters;
                if (zzjVar == zzjVar2) {
                    return zzjVar2;
                }
            } while (!zzg(zzecVar, zzjVar2, zzjVar));
            return zzjVar2;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final void zzc(zzj zzjVar, @CheckForNull zzj zzjVar2) {
            zza.putObject(zzjVar, zzf, zzjVar2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final void zzd(zzj zzjVar, Thread thread) {
            zza.putObject(zzjVar, zze, thread);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final boolean zze(zzec zzecVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            return zzef.zza(zza, zzecVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final boolean zzf(zzec zzecVar, @CheckForNull Object obj, Object obj2) {
            return zzef.zza(zza, zzecVar, zzd, obj, obj2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
        final boolean zzg(zzec zzecVar, @CheckForNull zzj zzjVar, @CheckForNull zzj zzjVar2) {
            return zzef.zza(zza, zzecVar, zzc, zzjVar, zzjVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
    /* loaded from: classes4.dex */
    public final class zzj {
        static final zzj zza = new zzj(false);

        @CheckForNull
        volatile zzj next;

        @CheckForNull
        volatile Thread thread;

        zzj() {
            zzec.zzc.zzd(this, Thread.currentThread());
        }

        zzj(boolean z) {
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zzgVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        zza = z;
        zzb = Logger.getLogger(zzec.class.getName());
        byte b = 0;
        try {
            zzgVar = new zzi(null);
            th2 = null;
            th = null;
        } catch (Error | RuntimeException e) {
            try {
                th2 = e;
                zzgVar = new zze(AtomicReferenceFieldUpdater.newUpdater(zzj.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(zzj.class, zzj.class, "next"), AtomicReferenceFieldUpdater.newUpdater(zzec.class, zzj.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zzec.class, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zzec.class, Object.class, "value"));
                th = null;
            } catch (Error | RuntimeException e2) {
                th = e2;
                th2 = e;
                zzgVar = new zzg(b == true ? 1 : 0);
            }
        }
        zzc = zzgVar;
        if (th != null) {
            Logger logger = zzb;
            logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        zzd = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Object zzo(zzev zzevVar) {
        Throwable zzf2;
        if (zzevVar instanceof zzh) {
            Object obj = ((zzec) zzevVar).value;
            if (obj instanceof zzb) {
                zzb zzbVar = (zzb) obj;
                if (zzbVar.zzc) {
                    Throwable th = zzbVar.zzd;
                    if (th != null) {
                        obj = new zzb(false, th);
                    } else {
                        obj = zzb.zzb;
                    }
                }
            }
            obj.getClass();
            return obj;
        }
        if (!(zzevVar instanceof zzez) || (zzf2 = ((zzez) zzevVar).zzf()) == null) {
            boolean isCancelled = zzevVar.isCancelled();
            if ((!zza) & isCancelled) {
                zzb zzbVar2 = zzb.zzb;
                zzbVar2.getClass();
                return zzbVar2;
            }
            try {
                Object zzp = zzp(zzevVar);
                if (!isCancelled) {
                    return zzp == null ? zzd : zzp;
                }
                return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(zzevVar)));
            } catch (Error e) {
                e = e;
                return new zzc(e);
            } catch (CancellationException e2) {
                if (!isCancelled) {
                    return new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(String.valueOf(zzevVar))), e2));
                }
                return new zzb(false, e2);
            } catch (RuntimeException e3) {
                e = e3;
                return new zzc(e);
            } catch (ExecutionException e4) {
                if (isCancelled) {
                    return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(String.valueOf(zzevVar))), e4));
                }
                return new zzc(e4.getCause());
            }
        }
        return new zzc(zzf2);
    }

    private static Object zzp(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private final void zzq(StringBuilder sb) {
        try {
            Object zzp = zzp(this);
            sb.append("SUCCESS, result=[");
            if (zzp == null) {
                sb.append("null");
            } else if (zzp == this) {
                sb.append("this future");
            } else {
                sb.append(zzp.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(zzp)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    private final void zzr(StringBuilder sb) {
        String concat;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb.append(", setFuture=[");
            zzs(sb, ((zzf) obj).zzb);
            sb.append("]");
        } else {
            try {
                concat = zzbd.zza(zze());
            } catch (RuntimeException | StackOverflowError e) {
                concat = "Exception thrown from implementation: ".concat(String.valueOf(String.valueOf(e.getClass())));
            }
            if (concat != null) {
                sb.append(", info=[");
                sb.append(concat);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            zzq(sb);
        }
    }

    private final void zzs(StringBuilder sb, @CheckForNull Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (RuntimeException | StackOverflowError e) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        }
    }

    private static void zzt(zzec zzecVar, boolean z) {
        zzd zzdVar = null;
        while (true) {
            for (zzj zzb2 = zzc.zzb(zzecVar, zzj.zza); zzb2 != null; zzb2 = zzb2.next) {
                Thread thread = zzb2.thread;
                if (thread != null) {
                    zzb2.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            zzecVar.zzk();
            zzd zzdVar2 = zzdVar;
            zzd zza2 = zzc.zza(zzecVar, zzd.zza);
            zzd zzdVar3 = zzdVar2;
            while (zza2 != null) {
                zzd zzdVar4 = zza2.next;
                zza2.next = zzdVar3;
                zzdVar3 = zza2;
                zza2 = zzdVar4;
            }
            while (zzdVar3 != null) {
                zzdVar = zzdVar3.next;
                Runnable runnable = zzdVar3.zzb;
                runnable.getClass();
                if (runnable instanceof zzf) {
                    zzf zzfVar = (zzf) runnable;
                    zzecVar = zzfVar.zza;
                    if (zzecVar.value == zzfVar) {
                        if (zzc.zzf(zzecVar, zzfVar, zzo(zzfVar.zzb))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = zzdVar3.zzc;
                    executor.getClass();
                    zzu(runnable, executor);
                }
                zzdVar3 = zzdVar;
            }
            return;
        }
    }

    private static void zzu(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            zzb.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e);
        }
    }

    private final void zzv(zzj zzjVar) {
        zzjVar.thread = null;
        while (true) {
            zzj zzjVar2 = this.waiters;
            if (zzjVar2 != zzj.zza) {
                zzj zzjVar3 = null;
                while (zzjVar2 != null) {
                    zzj zzjVar4 = zzjVar2.next;
                    if (zzjVar2.thread != null) {
                        zzjVar3 = zzjVar2;
                    } else if (zzjVar3 != null) {
                        zzjVar3.next = zzjVar4;
                        if (zzjVar3.thread == null) {
                            break;
                        }
                    } else if (!zzc.zzg(this, zzjVar2, zzjVar4)) {
                        break;
                    }
                    zzjVar2 = zzjVar4;
                }
                return;
            }
            return;
        }
    }

    private static final Object zzw(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zzd) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return true;
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            boolean r1 = r0 instanceof com.google.android.gms.internal.mlkit_vision_barcode.zzec.zzf
            r2 = 0
            r3 = 1
            if (r0 != 0) goto La
            r4 = r3
            goto Lb
        La:
            r4 = r2
        Lb:
            r1 = r1 | r4
            if (r1 == 0) goto L5f
            boolean r1 = com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
            if (r1 == 0) goto L1f
            com.google.android.gms.internal.mlkit_vision_barcode.zzec$zzb r1 = new com.google.android.gms.internal.mlkit_vision_barcode.zzec$zzb
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r1.<init>(r8, r4)
            goto L29
        L1f:
            if (r8 == 0) goto L24
            com.google.android.gms.internal.mlkit_vision_barcode.zzec$zzb r1 = com.google.android.gms.internal.mlkit_vision_barcode.zzec.zzb.zza
            goto L26
        L24:
            com.google.android.gms.internal.mlkit_vision_barcode.zzec$zzb r1 = com.google.android.gms.internal.mlkit_vision_barcode.zzec.zzb.zzb
        L26:
            r1.getClass()
        L29:
            r4 = r7
            r5 = r2
        L2b:
            com.google.android.gms.internal.mlkit_vision_barcode.zzec$zza r6 = com.google.android.gms.internal.mlkit_vision_barcode.zzec.zzc
            boolean r6 = r6.zzf(r4, r0, r1)
            if (r6 == 0) goto L58
            zzt(r4, r8)
            boolean r4 = r0 instanceof com.google.android.gms.internal.mlkit_vision_barcode.zzec.zzf
            if (r4 == 0) goto L56
            com.google.android.gms.internal.mlkit_vision_barcode.zzec$zzf r0 = (com.google.android.gms.internal.mlkit_vision_barcode.zzec.zzf) r0
            com.google.android.gms.internal.mlkit_vision_barcode.zzev<? extends V> r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.android.gms.internal.mlkit_vision_barcode.zzec.zzh
            if (r4 == 0) goto L53
            r4 = r0
            com.google.android.gms.internal.mlkit_vision_barcode.zzec r4 = (com.google.android.gms.internal.mlkit_vision_barcode.zzec) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L4b
            r5 = r3
            goto L4c
        L4b:
            r5 = r2
        L4c:
            boolean r6 = r0 instanceof com.google.android.gms.internal.mlkit_vision_barcode.zzec.zzf
            r5 = r5 | r6
            if (r5 == 0) goto L56
            r5 = r3
            goto L2b
        L53:
            r0.cancel(r8)
        L56:
            r2 = r3
            goto L5f
        L58:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.android.gms.internal.mlkit_vision_barcode.zzec.zzf
            if (r6 != 0) goto L2b
            r2 = r5
        L5f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzec.cancel(boolean):boolean");
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof zzf))) {
                return zzw(obj2);
            }
            zzj zzjVar = this.waiters;
            if (zzjVar != zzj.zza) {
                zzj zzjVar2 = new zzj();
                do {
                    zza zzaVar = zzc;
                    zzaVar.zzc(zzjVar2, zzjVar);
                    if (zzaVar.zzg(this, zzjVar, zzjVar2)) {
                        do {
                            LockSupport.park(this);
                            if (Thread.interrupted()) {
                                zzv(zzjVar2);
                                throw new InterruptedException();
                            }
                            obj = this.value;
                        } while (!((obj != null) & (!(obj instanceof zzf))));
                        return zzw(obj);
                    }
                    zzjVar = this.waiters;
                } while (zzjVar != zzj.zza);
            }
            Object obj3 = this.value;
            obj3.getClass();
            return zzw(obj3);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof zzb;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (this.value != null) & (!(r0 instanceof zzf));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.value instanceof zzb) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzq(sb);
        } else {
            zzr(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    public String zze() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzez
    @CheckForNull
    public final Throwable zzf() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzev
    public final void zzj(Runnable runnable, Executor executor) {
        zzd zzdVar;
        if (executor != null) {
            if (!isDone() && (zzdVar = this.listeners) != zzd.zza) {
                zzd zzdVar2 = new zzd(runnable, executor);
                do {
                    zzdVar2.next = zzdVar;
                    if (zzc.zze(this, zzdVar, zzdVar2)) {
                        return;
                    } else {
                        zzdVar = this.listeners;
                    }
                } while (zzdVar != zzd.zza);
            }
            zzu(runnable, executor);
            return;
        }
        throw new NullPointerException("Executor was null.");
    }

    protected void zzk() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzl(Throwable th) {
        if (!zzc.zzf(this, null, new zzc(th))) {
            return false;
        }
        zzt(this, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzn() {
        Object obj = this.value;
        return (obj instanceof zzb) && ((zzb) obj).zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzm(zzev zzevVar) {
        zzevVar.getClass();
        Object obj = this.value;
        if (obj != null) {
            if (obj instanceof zzb) {
            }
            return false;
        }
        if (!zzc.zzf(this, null, zzo(zzevVar))) {
            return false;
        }
        zzt(this, false);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z = true;
            if ((obj != null) & (!(obj instanceof zzf))) {
                return zzw(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                zzj zzjVar = this.waiters;
                if (zzjVar != zzj.zza) {
                    zzj zzjVar2 = new zzj();
                    do {
                        zza zzaVar = zzc;
                        zzaVar.zzc(zzjVar2, zzjVar);
                        if (zzaVar.zzg(this, zzjVar, zzjVar2)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (Thread.interrupted()) {
                                    zzv(zzjVar2);
                                    throw new InterruptedException();
                                }
                                Object obj2 = this.value;
                                if (!((obj2 != null) & (!(obj2 instanceof zzf)))) {
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    return zzw(obj2);
                                }
                            } while (nanos >= 1000);
                            zzv(zzjVar2);
                        } else {
                            zzjVar = this.waiters;
                        }
                    } while (zzjVar != zzj.zza);
                }
                Object obj3 = this.value;
                obj3.getClass();
                return zzw(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.value;
                if (!((obj4 != null) & (!(obj4 instanceof zzf)))) {
                    if (!Thread.interrupted()) {
                        nanos = nanoTime - System.nanoTime();
                    } else {
                        throw new InterruptedException();
                    }
                } else {
                    return zzw(obj4);
                }
            }
            String zzecVar = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + timeUnit.toString().toLowerCase(Locale.ROOT);
            if (nanos + 1000 < 0) {
                String concat = str.concat(" (plus ");
                long j2 = -nanos;
                long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(convert);
                if (convert != 0 && nanos2 <= 1000) {
                    z = false;
                }
                if (convert > 0) {
                    String str2 = concat + convert + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + lowerCase;
                    if (z) {
                        str2 = str2.concat(f.a);
                    }
                    concat = str2.concat(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
                if (z) {
                    concat = concat + nanos2 + " nanoseconds ";
                }
                str = concat.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(str.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(str + " for " + zzecVar);
        }
        throw new InterruptedException();
    }
}
