package expo.modules.kotlin.functions;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: FunctionBuilder.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0010\u001a\u00020\u00062\u0010\b\u0004\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0013J,\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0004\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0012H\u0086\bø\u0001\u0000JI\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\u00140\u0016H\u0086\bø\u0001\u0000Jf\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u0001\"\u0006\b\u0002\u0010\u0019\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u000328\b\u0004\u0010\u0011\u001a2\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\u0019¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00140\u001aH\u0086\bø\u0001\u0000J\u0083\u0001\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u0001\"\u0006\b\u0002\u0010\u0019\u0018\u0001\"\u0006\b\u0003\u0010\u001c\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032M\b\u0004\u0010\u0011\u001aG\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\u0019¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u0002H\u00140\u001dH\u0086\bø\u0001\u0000J \u0001\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u0001\"\u0006\b\u0002\u0010\u0019\u0018\u0001\"\u0006\b\u0003\u0010\u001c\u0018\u0001\"\u0006\b\u0004\u0010\u001f\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032b\b\u0004\u0010\u0011\u001a\\\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\u0019¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\u0004\u0012\u0002H\u00140 H\u0086\bø\u0001\u0000J½\u0001\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u0001\"\u0006\b\u0002\u0010\u0019\u0018\u0001\"\u0006\b\u0003\u0010\u001c\u0018\u0001\"\u0006\b\u0004\u0010\u001f\u0018\u0001\"\u0006\b\u0005\u0010\"\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032w\b\u0004\u0010\u0011\u001aq\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\u0019¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0004\u0012\u0002H\u00140#H\u0086\bø\u0001\u0000JÜ\u0001\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u0001\"\u0006\b\u0002\u0010\u0019\u0018\u0001\"\u0006\b\u0003\u0010\u001c\u0018\u0001\"\u0006\b\u0004\u0010\u001f\u0018\u0001\"\u0006\b\u0005\u0010\"\u0018\u0001\"\u0006\b\u0006\u0010%\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u008d\u0001\b\u0004\u0010\u0011\u001a\u0086\u0001\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\u0019¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b('\u0012\u0004\u0012\u0002H\u00140&H\u0086\bø\u0001\u0000Jù\u0001\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u0001\"\u0006\b\u0002\u0010\u0019\u0018\u0001\"\u0006\b\u0003\u0010\u001c\u0018\u0001\"\u0006\b\u0004\u0010\u001f\u0018\u0001\"\u0006\b\u0005\u0010\"\u0018\u0001\"\u0006\b\u0006\u0010%\u0018\u0001\"\u0006\b\u0007\u0010(\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032¢\u0001\b\u0004\u0010\u0011\u001a\u009b\u0001\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\u0019¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(*\u0012\u0004\u0012\u0002H\u00140)H\u0086\bø\u0001\u0000J\u0096\u0002\u0010\u0010\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0015\u0018\u0001\"\u0006\b\u0002\u0010\u0019\u0018\u0001\"\u0006\b\u0003\u0010\u001c\u0018\u0001\"\u0006\b\u0004\u0010\u001f\u0018\u0001\"\u0006\b\u0005\u0010\"\u0018\u0001\"\u0006\b\u0006\u0010%\u0018\u0001\"\u0006\b\u0007\u0010(\u0018\u0001\"\u0006\b\b\u0010+\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032·\u0001\b\u0004\u0010\u0011\u001a°\u0001\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\u0019¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(*\u0012\u0013\u0012\u0011H+¢\u0006\f\b\u0017\u0012\b\b\u0002\u0012\u0004\b\b(-\u0012\u0004\u0012\u0002H\u00140,H\u0086\bø\u0001\u0000J\r\u0010.\u001a\u00020\u0006H\u0000¢\u0006\u0002\b/R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00060"}, d2 = {"Lexpo/modules/kotlin/functions/FunctionBuilder;", "", "name", "", "(Ljava/lang/String;)V", "functionComponent", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getFunctionComponent$annotations", "()V", "getFunctionComponent", "()Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "setFunctionComponent", "(Lexpo/modules/kotlin/functions/SyncFunctionComponent;)V", "getName$annotations", "getName", "()Ljava/lang/String;", "Body", TtmlNode.TAG_BODY, "Lkotlin/Function0;", "BodyWithoutArgs", "R", "P0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "build", "build$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FunctionBuilder {
    private SyncFunctionComponent functionComponent;
    private final String name;

    public static /* synthetic */ void getFunctionComponent$annotations() {
    }

    public static /* synthetic */ void getName$annotations() {
    }

    public FunctionBuilder(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    public final SyncFunctionComponent getFunctionComponent() {
        return this.functionComponent;
    }

    public final void setFunctionComponent(SyncFunctionComponent syncFunctionComponent) {
        this.functionComponent = syncFunctionComponent;
    }

    public final SyncFunctionComponent BodyWithoutArgs(final Function0<? extends Object> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(getName(), new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        });
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R> SyncFunctionComponent Body(String name, final Function0<? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        });
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> SyncFunctionComponent Body(String name, final Function1<? super P0, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$5 functionBuilder$Body$5 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$5
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, functionBuilder$Body$5))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<P0, R> function1 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                return function1.invoke(obj);
            }
        });
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1> SyncFunctionComponent Body(String name, final Function2<? super P0, ? super P1, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$8 functionBuilder$Body$8 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$8
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$9 functionBuilder$Body$9 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$9
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, functionBuilder$Body$8)), new AnyType(new LazyKType(orCreateKotlinClass2, false, functionBuilder$Body$9))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function2<P0, P1, R> function2 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                return function2.invoke(obj, obj2);
            }
        });
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> SyncFunctionComponent Body(String name, final Function3<? super P0, ? super P1, ? super P2, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$12 functionBuilder$Body$12 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$12
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$13 functionBuilder$Body$13 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$13
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$14 functionBuilder$Body$14 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$14
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P2");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, functionBuilder$Body$12)), new AnyType(new LazyKType(orCreateKotlinClass2, false, functionBuilder$Body$13)), new AnyType(new LazyKType(orCreateKotlinClass3, false, functionBuilder$Body$14))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function3<P0, P1, P2, R> function3 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                Object obj3 = it[2];
                Intrinsics.reifiedOperationMarker(1, "P2");
                return function3.invoke(obj, obj2, obj3);
            }
        });
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> SyncFunctionComponent Body(String name, final Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$17 functionBuilder$Body$17 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$17
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$18 functionBuilder$Body$18 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$18
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$19 functionBuilder$Body$19 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$19
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P2");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$20 functionBuilder$Body$20 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$20
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P3");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, functionBuilder$Body$17)), new AnyType(new LazyKType(orCreateKotlinClass2, false, functionBuilder$Body$18)), new AnyType(new LazyKType(orCreateKotlinClass3, false, functionBuilder$Body$19)), new AnyType(new LazyKType(orCreateKotlinClass4, false, functionBuilder$Body$20))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$21
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function4<P0, P1, P2, P3, R> function4 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                Object obj3 = it[2];
                Intrinsics.reifiedOperationMarker(1, "P2");
                Object obj4 = it[3];
                Intrinsics.reifiedOperationMarker(1, "P3");
                return function4.invoke(obj, obj2, obj3, obj4);
            }
        });
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> SyncFunctionComponent Body(String name, final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$23 functionBuilder$Body$23 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$23
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$24 functionBuilder$Body$24 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$24
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$25 functionBuilder$Body$25 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$25
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P2");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$26 functionBuilder$Body$26 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$26
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P3");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$27 functionBuilder$Body$27 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$27
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P4");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, functionBuilder$Body$23)), new AnyType(new LazyKType(orCreateKotlinClass2, false, functionBuilder$Body$24)), new AnyType(new LazyKType(orCreateKotlinClass3, false, functionBuilder$Body$25)), new AnyType(new LazyKType(orCreateKotlinClass4, false, functionBuilder$Body$26)), new AnyType(new LazyKType(orCreateKotlinClass5, false, functionBuilder$Body$27))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$28
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function5<P0, P1, P2, P3, P4, R> function5 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                Object obj3 = it[2];
                Intrinsics.reifiedOperationMarker(1, "P2");
                Object obj4 = it[3];
                Intrinsics.reifiedOperationMarker(1, "P3");
                Object obj5 = it[4];
                Intrinsics.reifiedOperationMarker(1, "P4");
                return function5.invoke(obj, obj2, obj3, obj4, obj5);
            }
        });
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> SyncFunctionComponent Body(String name, final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$30 functionBuilder$Body$30 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$30
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$31 functionBuilder$Body$31 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$31
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$32 functionBuilder$Body$32 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$32
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P2");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$33 functionBuilder$Body$33 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$33
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P3");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$34 functionBuilder$Body$34 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$34
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P4");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$35 functionBuilder$Body$35 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$35
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P5");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, functionBuilder$Body$30)), new AnyType(new LazyKType(orCreateKotlinClass2, false, functionBuilder$Body$31)), new AnyType(new LazyKType(orCreateKotlinClass3, false, functionBuilder$Body$32)), new AnyType(new LazyKType(orCreateKotlinClass4, false, functionBuilder$Body$33)), new AnyType(new LazyKType(orCreateKotlinClass5, false, functionBuilder$Body$34)), new AnyType(new LazyKType(orCreateKotlinClass6, false, functionBuilder$Body$35))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$36
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function6<P0, P1, P2, P3, P4, P5, R> function6 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                Object obj3 = it[2];
                Intrinsics.reifiedOperationMarker(1, "P2");
                Object obj4 = it[3];
                Intrinsics.reifiedOperationMarker(1, "P3");
                Object obj5 = it[4];
                Intrinsics.reifiedOperationMarker(1, "P4");
                Object obj6 = it[5];
                Intrinsics.reifiedOperationMarker(1, "P5");
                return function6.invoke(obj, obj2, obj3, obj4, obj5, obj6);
            }
        });
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> SyncFunctionComponent Body(String name, final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$38 functionBuilder$Body$38 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$38
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$39 functionBuilder$Body$39 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$39
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$40 functionBuilder$Body$40 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$40
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P2");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$41 functionBuilder$Body$41 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$41
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P3");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$42 functionBuilder$Body$42 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$42
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P4");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$43 functionBuilder$Body$43 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$43
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P5");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$44 functionBuilder$Body$44 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$44
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P6");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, functionBuilder$Body$38)), new AnyType(new LazyKType(orCreateKotlinClass2, false, functionBuilder$Body$39)), new AnyType(new LazyKType(orCreateKotlinClass3, false, functionBuilder$Body$40)), new AnyType(new LazyKType(orCreateKotlinClass4, false, functionBuilder$Body$41)), new AnyType(new LazyKType(orCreateKotlinClass5, false, functionBuilder$Body$42)), new AnyType(new LazyKType(orCreateKotlinClass6, false, functionBuilder$Body$43)), new AnyType(new LazyKType(orCreateKotlinClass7, false, functionBuilder$Body$44))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$45
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function7<P0, P1, P2, P3, P4, P5, P6, R> function7 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                Object obj3 = it[2];
                Intrinsics.reifiedOperationMarker(1, "P2");
                Object obj4 = it[3];
                Intrinsics.reifiedOperationMarker(1, "P3");
                Object obj5 = it[4];
                Intrinsics.reifiedOperationMarker(1, "P4");
                Object obj6 = it[5];
                Intrinsics.reifiedOperationMarker(1, "P5");
                Object obj7 = it[6];
                Intrinsics.reifiedOperationMarker(1, "P6");
                return function7.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7);
            }
        });
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> SyncFunctionComponent Body(String name, final Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$47 functionBuilder$Body$47 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$47
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$48 functionBuilder$Body$48 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$48
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$49 functionBuilder$Body$49 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$49
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P2");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$50 functionBuilder$Body$50 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$50
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P3");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$51 functionBuilder$Body$51 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$51
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P4");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$52 functionBuilder$Body$52 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$52
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P5");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$53 functionBuilder$Body$53 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$53
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P6");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        Intrinsics.needClassReification();
        FunctionBuilder$Body$54 functionBuilder$Body$54 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$54
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P7");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, functionBuilder$Body$47)), new AnyType(new LazyKType(orCreateKotlinClass2, false, functionBuilder$Body$48)), new AnyType(new LazyKType(orCreateKotlinClass3, false, functionBuilder$Body$49)), new AnyType(new LazyKType(orCreateKotlinClass4, false, functionBuilder$Body$50)), new AnyType(new LazyKType(orCreateKotlinClass5, false, functionBuilder$Body$51)), new AnyType(new LazyKType(orCreateKotlinClass6, false, functionBuilder$Body$52)), new AnyType(new LazyKType(orCreateKotlinClass7, false, functionBuilder$Body$53)), new AnyType(new LazyKType(orCreateKotlinClass8, false, functionBuilder$Body$54))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.FunctionBuilder$Body$55
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function8<P0, P1, P2, P3, P4, P5, P6, P7, R> function8 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                Object obj3 = it[2];
                Intrinsics.reifiedOperationMarker(1, "P2");
                Object obj4 = it[3];
                Intrinsics.reifiedOperationMarker(1, "P3");
                Object obj5 = it[4];
                Intrinsics.reifiedOperationMarker(1, "P4");
                Object obj6 = it[5];
                Intrinsics.reifiedOperationMarker(1, "P5");
                Object obj7 = it[6];
                Intrinsics.reifiedOperationMarker(1, "P6");
                Object obj8 = it[7];
                Intrinsics.reifiedOperationMarker(1, "P7");
                return function8.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
            }
        });
        setFunctionComponent(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final SyncFunctionComponent build$expo_modules_core_release() {
        SyncFunctionComponent syncFunctionComponent = this.functionComponent;
        if (syncFunctionComponent != null) {
            return syncFunctionComponent;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
