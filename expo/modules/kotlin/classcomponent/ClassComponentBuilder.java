package expo.modules.kotlin.classcomponent;

import com.amazon.a.a.o.b;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import expo.modules.kotlin.ConcatIterator;
import expo.modules.kotlin.functions.AnyFunction;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis;
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis$get$1$1;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Metadata;
import kotlin.Unit;
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

/* compiled from: ClassComponentBuilder.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u0015\u001a\u00020\f2\u000e\b\u0004\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\bø\u0001\u0000J9\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u00012#\b\u0004\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\bø\u0001\u0000JV\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u000128\b\u0004\u0010\u0016\u001a2\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\bø\u0001\u0000Js\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u00012M\b\u0004\u0010\u0016\u001aG\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0004\u0012\u00028\u00000 H\u0086\bø\u0001\u0000J\u0090\u0001\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010\"\u0018\u00012b\b\u0004\u0010\u0016\u001a\\\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0004\u0012\u00028\u00000#H\u0086\bø\u0001\u0000J\u00ad\u0001\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010\"\u0018\u0001\"\u0006\b\u0005\u0010%\u0018\u00012w\b\u0004\u0010\u0016\u001aq\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b('\u0012\u0004\u0012\u00028\u00000&H\u0086\bø\u0001\u0000JÌ\u0001\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010\"\u0018\u0001\"\u0006\b\u0005\u0010%\u0018\u0001\"\u0006\b\u0006\u0010(\u0018\u00012\u008d\u0001\b\u0004\u0010\u0016\u001a\u0086\u0001\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(*\u0012\u0004\u0012\u00028\u00000)H\u0086\bø\u0001\u0000Jé\u0001\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010\"\u0018\u0001\"\u0006\b\u0005\u0010%\u0018\u0001\"\u0006\b\u0006\u0010(\u0018\u0001\"\u0006\b\u0007\u0010+\u0018\u00012¢\u0001\b\u0004\u0010\u0016\u001a\u009b\u0001\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(*\u0012\u0013\u0012\u0011H+¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(-\u0012\u0004\u0012\u00028\u00000,H\u0086\bø\u0001\u0000J\u0086\u0002\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010\"\u0018\u0001\"\u0006\b\u0005\u0010%\u0018\u0001\"\u0006\b\u0006\u0010(\u0018\u0001\"\u0006\b\u0007\u0010+\u0018\u0001\"\u0006\b\b\u0010.\u0018\u00012·\u0001\b\u0004\u0010\u0016\u001a°\u0001\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(*\u0012\u0013\u0012\u0011H+¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(-\u0012\u0013\u0012\u0011H.¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(0\u0012\u0004\u0012\u00028\u00000/H\u0086\bø\u0001\u0000J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00028\u0000022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016JE\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002\"\u0004\b\u0001\u001032\u0006\u0010\u0004\u001a\u00020\u00052#\b\u0004\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002H30\u0019H\u0086\bø\u0001\u0000J\u0006\u00105\u001a\u000206R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00067"}, d2 = {"Lexpo/modules/kotlin/classcomponent/ClassComponentBuilder;", "SharedObjectType", "", "Lexpo/modules/kotlin/objects/ObjectDefinitionBuilder;", "name", "", "ownerClass", "Lkotlin/reflect/KClass;", "ownerType", "Lkotlin/reflect/KType;", "(Ljava/lang/String;Lkotlin/reflect/KClass;Lkotlin/reflect/KType;)V", "constructor", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getConstructor", "()Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "setConstructor", "(Lexpo/modules/kotlin/functions/SyncFunctionComponent;)V", "getName", "()Ljava/lang/String;", "getOwnerType", "()Lkotlin/reflect/KType;", "Constructor", TtmlNode.TAG_BODY, "Lkotlin/Function0;", "P0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "Property", "Lexpo/modules/kotlin/objects/PropertyComponentBuilderWithThis;", "T", "owner", "buildClass", "Lexpo/modules/kotlin/classcomponent/ClassDefinitionData;", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassComponentBuilder<SharedObjectType> extends ObjectDefinitionBuilder {
    private SyncFunctionComponent constructor;
    private final String name;
    private final KClass<SharedObjectType> ownerClass;
    private final KType ownerType;

    public final String getName() {
        return this.name;
    }

    public final KType getOwnerType() {
        return this.ownerType;
    }

    public ClassComponentBuilder(String name, KClass<SharedObjectType> ownerClass, KType ownerType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(ownerClass, "ownerClass");
        Intrinsics.checkNotNullParameter(ownerType, "ownerType");
        this.name = name;
        this.ownerClass = ownerClass;
        this.ownerType = ownerType;
    }

    public final SyncFunctionComponent getConstructor() {
        return this.constructor;
    }

    public final void setConstructor(SyncFunctionComponent syncFunctionComponent) {
        this.constructor = syncFunctionComponent;
    }

    public final ClassDefinitionData buildClass() {
        ObjectDefinitionData buildObject = buildObject();
        ConcatIterator<AnyFunction> functions = buildObject.getFunctions();
        while (functions.hasNext()) {
            AnyFunction next = functions.next();
            next.setOwnerType(this.ownerType);
            next.setCanTakeOwner(true);
        }
        if ((this.ownerClass != Reflection.getOrCreateKotlinClass(Unit.class)) && this.constructor == null) {
            throw new IllegalArgumentException("constructor cannot be null");
        }
        SyncFunctionComponent syncFunctionComponent = this.constructor;
        if (syncFunctionComponent == null) {
            syncFunctionComponent = new SyncFunctionComponent("constructor", new AnyType[0], new Function1<Object[], Unit>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$buildClass$constructor$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr) {
                    invoke2(objArr);
                    return Unit.INSTANCE;
                }
            });
        }
        syncFunctionComponent.setCanTakeOwner(true);
        return new ClassDefinitionData(this.name, syncFunctionComponent, buildObject);
    }

    public final SyncFunctionComponent Constructor(final Function0<? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$1
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
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0> SyncFunctionComponent Constructor(final Function1<? super P0, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ClassComponentBuilder$Constructor$3 classComponentBuilder$Constructor$3 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$3
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, classComponentBuilder$Constructor$3))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<P0, SharedObjectType> function1 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                return function1.invoke(obj);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1> SyncFunctionComponent Constructor(final Function2<? super P0, ? super P1, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ClassComponentBuilder$Constructor$6 classComponentBuilder$Constructor$6 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$6
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
        ClassComponentBuilder$Constructor$7 classComponentBuilder$Constructor$7 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$7
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, classComponentBuilder$Constructor$6)), new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$7))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function2<P0, P1, SharedObjectType> function2 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                return function2.invoke(obj, obj2);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2> SyncFunctionComponent Constructor(final Function3<? super P0, ? super P1, ? super P2, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ClassComponentBuilder$Constructor$10 classComponentBuilder$Constructor$10 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$10
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
        ClassComponentBuilder$Constructor$11 classComponentBuilder$Constructor$11 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$11
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
        ClassComponentBuilder$Constructor$12 classComponentBuilder$Constructor$12 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$12
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P2");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, classComponentBuilder$Constructor$10)), new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$11)), new AnyType(new LazyKType(orCreateKotlinClass3, false, classComponentBuilder$Constructor$12))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function3<P0, P1, P2, SharedObjectType> function3 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                Object obj3 = it[2];
                Intrinsics.reifiedOperationMarker(1, "P2");
                return function3.invoke(obj, obj2, obj3);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3> SyncFunctionComponent Constructor(final Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ClassComponentBuilder$Constructor$15 classComponentBuilder$Constructor$15 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$15
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
        ClassComponentBuilder$Constructor$16 classComponentBuilder$Constructor$16 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$16
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
        ClassComponentBuilder$Constructor$17 classComponentBuilder$Constructor$17 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$17
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
        ClassComponentBuilder$Constructor$18 classComponentBuilder$Constructor$18 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$18
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P3");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, classComponentBuilder$Constructor$15)), new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$16)), new AnyType(new LazyKType(orCreateKotlinClass3, false, classComponentBuilder$Constructor$17)), new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$18))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$19
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function4<P0, P1, P2, P3, SharedObjectType> function4 = body;
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
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4> SyncFunctionComponent Constructor(final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ClassComponentBuilder$Constructor$21 classComponentBuilder$Constructor$21 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$21
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
        ClassComponentBuilder$Constructor$22 classComponentBuilder$Constructor$22 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$22
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
        ClassComponentBuilder$Constructor$23 classComponentBuilder$Constructor$23 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$23
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
        ClassComponentBuilder$Constructor$24 classComponentBuilder$Constructor$24 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$24
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
        ClassComponentBuilder$Constructor$25 classComponentBuilder$Constructor$25 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$25
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P4");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, classComponentBuilder$Constructor$21)), new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$22)), new AnyType(new LazyKType(orCreateKotlinClass3, false, classComponentBuilder$Constructor$23)), new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$24)), new AnyType(new LazyKType(orCreateKotlinClass5, false, classComponentBuilder$Constructor$25))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$26
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function5<P0, P1, P2, P3, P4, SharedObjectType> function5 = body;
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
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4, P5> SyncFunctionComponent Constructor(final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ClassComponentBuilder$Constructor$28 classComponentBuilder$Constructor$28 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$28
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
        ClassComponentBuilder$Constructor$29 classComponentBuilder$Constructor$29 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$29
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
        ClassComponentBuilder$Constructor$30 classComponentBuilder$Constructor$30 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$30
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
        ClassComponentBuilder$Constructor$31 classComponentBuilder$Constructor$31 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$31
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
        ClassComponentBuilder$Constructor$32 classComponentBuilder$Constructor$32 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$32
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
        ClassComponentBuilder$Constructor$33 classComponentBuilder$Constructor$33 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$33
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P5");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, classComponentBuilder$Constructor$28)), new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$29)), new AnyType(new LazyKType(orCreateKotlinClass3, false, classComponentBuilder$Constructor$30)), new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$31)), new AnyType(new LazyKType(orCreateKotlinClass5, false, classComponentBuilder$Constructor$32)), new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$Constructor$33))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$34
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function6<P0, P1, P2, P3, P4, P5, SharedObjectType> function6 = body;
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
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4, P5, P6> SyncFunctionComponent Constructor(final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ClassComponentBuilder$Constructor$36 classComponentBuilder$Constructor$36 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$36
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
        ClassComponentBuilder$Constructor$37 classComponentBuilder$Constructor$37 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$37
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
        ClassComponentBuilder$Constructor$38 classComponentBuilder$Constructor$38 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$38
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
        ClassComponentBuilder$Constructor$39 classComponentBuilder$Constructor$39 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$39
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
        ClassComponentBuilder$Constructor$40 classComponentBuilder$Constructor$40 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$40
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
        ClassComponentBuilder$Constructor$41 classComponentBuilder$Constructor$41 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$41
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
        ClassComponentBuilder$Constructor$42 classComponentBuilder$Constructor$42 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$42
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P6");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, classComponentBuilder$Constructor$36)), new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$37)), new AnyType(new LazyKType(orCreateKotlinClass3, false, classComponentBuilder$Constructor$38)), new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$39)), new AnyType(new LazyKType(orCreateKotlinClass5, false, classComponentBuilder$Constructor$40)), new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$Constructor$41)), new AnyType(new LazyKType(orCreateKotlinClass7, false, classComponentBuilder$Constructor$42))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$43
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function7<P0, P1, P2, P3, P4, P5, P6, SharedObjectType> function7 = body;
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
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4, P5, P6, P7> SyncFunctionComponent Constructor(final Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ClassComponentBuilder$Constructor$45 classComponentBuilder$Constructor$45 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$45
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
        ClassComponentBuilder$Constructor$46 classComponentBuilder$Constructor$46 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$46
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
        ClassComponentBuilder$Constructor$47 classComponentBuilder$Constructor$47 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$47
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
        ClassComponentBuilder$Constructor$48 classComponentBuilder$Constructor$48 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$48
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
        ClassComponentBuilder$Constructor$49 classComponentBuilder$Constructor$49 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$49
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
        ClassComponentBuilder$Constructor$50 classComponentBuilder$Constructor$50 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$50
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
        ClassComponentBuilder$Constructor$51 classComponentBuilder$Constructor$51 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$51
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
        ClassComponentBuilder$Constructor$52 classComponentBuilder$Constructor$52 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$52
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P7");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, classComponentBuilder$Constructor$45)), new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$46)), new AnyType(new LazyKType(orCreateKotlinClass3, false, classComponentBuilder$Constructor$47)), new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$48)), new AnyType(new LazyKType(orCreateKotlinClass5, false, classComponentBuilder$Constructor$49)), new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$Constructor$50)), new AnyType(new LazyKType(orCreateKotlinClass7, false, classComponentBuilder$Constructor$51)), new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$Constructor$52))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$53
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function8<P0, P1, P2, P3, P4, P5, P6, P7, SharedObjectType> function8 = body;
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
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final <T> PropertyComponentBuilderWithThis<SharedObjectType> Property(String name, Function1<? super SharedObjectType, ? extends T> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        PropertyComponentBuilderWithThis<SharedObjectType> propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis<>(getOwnerType(), name);
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(b.ar, new AnyType[]{new AnyType(propertyComponentBuilderWithThis.getThisType())}, new PropertyComponentBuilderWithThis$get$1$1(body));
        syncFunctionComponent.setOwnerType(propertyComponentBuilderWithThis.getThisType());
        syncFunctionComponent.setCanTakeOwner(true);
        propertyComponentBuilderWithThis.setGetter(syncFunctionComponent);
        getProperties().put(name, propertyComponentBuilderWithThis);
        return propertyComponentBuilderWithThis;
    }

    @Override // expo.modules.kotlin.objects.ObjectDefinitionBuilder
    public PropertyComponentBuilderWithThis<SharedObjectType> Property(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        PropertyComponentBuilderWithThis<SharedObjectType> propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis<>(this.ownerType, name);
        getProperties().put(name, propertyComponentBuilderWithThis);
        return propertyComponentBuilderWithThis;
    }
}
