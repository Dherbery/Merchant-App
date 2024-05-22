package expo.modules.kotlin.sharedobjects;

import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.JavaScriptWeakObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharedObjectRegistry.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u0004H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\tH\u0000¢\u0006\u0002\b\u001fJ\u0017\u0010 \u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b!J\u001f\u0010 \u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u0004H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0003\u001a\u00020\u0004X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R9\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000b0\u0007X\u0080\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Lexpo/modules/kotlin/sharedobjects/SharedObjectRegistry;", "", "()V", "currentId", "Lexpo/modules/kotlin/sharedobjects/SharedObjectId;", "I", "pairs", "", "Lkotlin/Pair;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "Lexpo/modules/kotlin/jni/JavaScriptWeakObject;", "Lexpo/modules/kotlin/sharedobjects/SharedObjectPair;", "getPairs$expo_modules_core_release", "()Ljava/util/Map;", "setPairs$expo_modules_core_release", "(Ljava/util/Map;)V", "add", "native", "js", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "add-5WKnsLU$expo_modules_core_release", "(Lexpo/modules/kotlin/sharedobjects/SharedObject;Lexpo/modules/kotlin/jni/JavaScriptObject;)I", "delete", "", "id", "delete-kyJHjyY$expo_modules_core_release", "(I)V", "pullNextId", "pullNextId-HSeVr_g", "()I", "toJavaScriptObject", "toJavaScriptObject$expo_modules_core_release", "toNativeObject", "toNativeObject$expo_modules_core_release", "toNativeObject-kyJHjyY$expo_modules_core_release", "(I)Lexpo/modules/kotlin/sharedobjects/SharedObject;", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SharedObjectRegistry {
    private int currentId = SharedObjectId.m1275constructorimpl(1);
    private Map<SharedObjectId, Pair<SharedObject, JavaScriptWeakObject>> pairs = new LinkedHashMap();

    public final Map<SharedObjectId, Pair<SharedObject, JavaScriptWeakObject>> getPairs$expo_modules_core_release() {
        return this.pairs;
    }

    public final void setPairs$expo_modules_core_release(Map<SharedObjectId, Pair<SharedObject, JavaScriptWeakObject>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.pairs = map;
    }

    /* renamed from: pullNextId-HSeVr_g, reason: not valid java name */
    private final int m1283pullNextIdHSeVr_g() {
        int i;
        synchronized (this) {
            i = this.currentId;
            this.currentId = SharedObjectId.m1275constructorimpl(i + 1);
        }
        return i;
    }

    /* renamed from: add-5WKnsLU$expo_modules_core_release, reason: not valid java name */
    public final int m1284add5WKnsLU$expo_modules_core_release(SharedObject r8, JavaScriptObject js) {
        Intrinsics.checkNotNullParameter(r8, "native");
        Intrinsics.checkNotNullParameter(js, "js");
        final int m1283pullNextIdHSeVr_g = m1283pullNextIdHSeVr_g();
        r8.m1273setSharedObjectIdkyJHjyY$expo_modules_core_release(m1283pullNextIdHSeVr_g);
        JavaScriptObject.defineProperty$default(js, SharedObjectRegistryKt.sharedObjectIdPropertyName, m1283pullNextIdHSeVr_g, (List) null, 4, (Object) null);
        js.defineDeallocator$expo_modules_core_release(new Function0<Unit>() { // from class: expo.modules.kotlin.sharedobjects.SharedObjectRegistry$add$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SharedObjectRegistry.this.m1285deletekyJHjyY$expo_modules_core_release(m1283pullNextIdHSeVr_g);
            }
        });
        JavaScriptWeakObject createWeak = js.createWeak();
        synchronized (this) {
            this.pairs.put(SharedObjectId.m1274boximpl(m1283pullNextIdHSeVr_g), TuplesKt.to(r8, createWeak));
            Unit unit = Unit.INSTANCE;
        }
        return m1283pullNextIdHSeVr_g;
    }

    /* renamed from: delete-kyJHjyY$expo_modules_core_release, reason: not valid java name */
    public final void m1285deletekyJHjyY$expo_modules_core_release(int id) {
        Pair<SharedObject, JavaScriptWeakObject> remove;
        synchronized (this) {
            remove = this.pairs.remove(SharedObjectId.m1274boximpl(id));
        }
        if (remove != null) {
            SharedObject component1 = remove.component1();
            remove.component2();
            component1.m1273setSharedObjectIdkyJHjyY$expo_modules_core_release(SharedObjectId.m1275constructorimpl(0));
            component1.deallocate();
        }
    }

    /* renamed from: toNativeObject-kyJHjyY$expo_modules_core_release, reason: not valid java name */
    public final SharedObject m1286toNativeObjectkyJHjyY$expo_modules_core_release(int id) {
        SharedObject first;
        synchronized (this) {
            Pair<SharedObject, JavaScriptWeakObject> pair = this.pairs.get(SharedObjectId.m1274boximpl(id));
            first = pair != null ? pair.getFirst() : null;
        }
        return first;
    }

    public final SharedObject toNativeObject$expo_modules_core_release(JavaScriptObject js) {
        Intrinsics.checkNotNullParameter(js, "js");
        if (!js.hasProperty(SharedObjectRegistryKt.sharedObjectIdPropertyName)) {
            return null;
        }
        Pair<SharedObject, JavaScriptWeakObject> pair = this.pairs.get(SharedObjectId.m1274boximpl(SharedObjectId.m1275constructorimpl(js.getProperty(SharedObjectRegistryKt.sharedObjectIdPropertyName).getInt())));
        if (pair != null) {
            return pair.getFirst();
        }
        return null;
    }

    public final JavaScriptObject toJavaScriptObject$expo_modules_core_release(SharedObject r2) {
        JavaScriptObject lock;
        JavaScriptWeakObject second;
        Intrinsics.checkNotNullParameter(r2, "native");
        synchronized (this) {
            Pair<SharedObject, JavaScriptWeakObject> pair = this.pairs.get(SharedObjectId.m1274boximpl(r2.getSharedObjectId()));
            lock = (pair == null || (second = pair.getSecond()) == null) ? null : second.lock();
        }
        return lock;
    }
}
