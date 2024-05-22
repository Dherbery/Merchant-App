package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;

/* compiled from: Platform.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aO\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0007\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0002¢\u0006\u0002\u0010\b\u001a\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0000\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001a$\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0000\u001aM\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00052\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0007\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0000¢\u0006\u0002\u0010\b\u001aM\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\f2\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0007\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0000¢\u0006\u0002\u0010\u0010\u001a\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a$\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a&\u0010\u0013\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0080\b¢\u0006\u0002\u0010\u0016\u001a\u0015\u0010\u0013\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0080\b\u001a$\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u0018\u0010\u0019\u001a\u00020\n*\u00020\u00032\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\fH\u0000\u001a\u001c\u0010\u001b\u001a\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u001c\u0010\u001c\u001a\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u0010\u0010\u001d\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\fH\u0000\u001a\u0010\u0010\u001f\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u0005H\u0000\u001aK\u0010 \u001a\b\u0012\u0004\u0012\u0002H!0\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010!*\u0004\u0018\u0001H\u0002*\u0012\u0012\u0004\u0012\u0002H!0\"j\b\u0012\u0004\u0012\u0002H!`#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020\fH\u0000¢\u0006\u0002\u0010%¨\u0006&"}, d2 = {"invokeSerializerOnCompanion", "Lkotlinx/serialization/KSerializer;", "T", "", "jClass", "Ljava/lang/Class;", "args", "", "(Ljava/lang/Class;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "isReferenceArray", "", "rootClass", "Lkotlin/reflect/KClass;", "companionOrNull", "compiledSerializerImpl", "constructSerializerForGivenTypeArgs", "(Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "createEnumSerializer", "findObjectSerializer", "getChecked", "index", "", "([Ljava/lang/Object;I)Ljava/lang/Object;", "", "interfaceSerializer", "isInstanceOf", "kclass", "isNotAnnotated", "isPolymorphicSerializer", "platformSpecificSerializerNotRegistered", "", "serializerNotRegistered", "toNativeArrayImpl", ExifInterface.LONGITUDE_EAST, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eClass", "(Ljava/util/ArrayList;Lkotlin/reflect/KClass;)[Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class PlatformKt {
    public static final <T> T getChecked(T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[i];
    }

    public static final boolean getChecked(boolean[] zArr, int i) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[i];
    }

    public static final <T> KSerializer<T> compiledSerializerImpl(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return constructSerializerForGivenTypeArgs(kClass, (KSerializer<Object>[]) new KSerializer[0]);
    }

    public static final <T, E extends T> E[] toNativeArrayImpl(ArrayList<E> arrayList, KClass<T> eClass) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(eClass, "eClass");
        Object newInstance = Array.newInstance((Class<?>) JvmClassMappingKt.getJavaClass((KClass) eClass), arrayList.size());
        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        E[] eArr = (E[]) arrayList.toArray((Object[]) newInstance);
        Intrinsics.checkNotNullExpressionValue(eArr, "toArray(java.lang.reflec….java, size) as Array<E>)");
        return eArr;
    }

    public static final Void platformSpecificSerializerNotRegistered(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Platform_commonKt.serializerNotRegistered(kClass);
        throw new KotlinNothingValueException();
    }

    public static final Void serializerNotRegistered(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        throw new SerializationException("Serializer for class '" + cls.getSimpleName() + "' is not found.\nMark the class as @Serializable or provide the serializer explicitly.");
    }

    public static final <T> KSerializer<T> constructSerializerForGivenTypeArgs(KClass<T> kClass, KSerializer<Object>... args) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        return constructSerializerForGivenTypeArgs(JvmClassMappingKt.getJavaClass((KClass) kClass), (KSerializer<Object>[]) Arrays.copyOf(args, args.length));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0068, code lost:
    
        if (r3 == false) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> kotlinx.serialization.KSerializer<T> constructSerializerForGivenTypeArgs(java.lang.Class<T> r8, kotlinx.serialization.KSerializer<java.lang.Object>... r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r0 = r8.isEnum()
            if (r0 == 0) goto L1b
            boolean r0 = isNotAnnotated(r8)
            if (r0 == 0) goto L1b
            kotlinx.serialization.KSerializer r8 = createEnumSerializer(r8)
            return r8
        L1b:
            boolean r0 = r8.isInterface()
            if (r0 == 0) goto L28
            kotlinx.serialization.KSerializer r0 = interfaceSerializer(r8)
            if (r0 == 0) goto L28
            return r0
        L28:
            int r0 = r9.length
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r0)
            kotlinx.serialization.KSerializer[] r9 = (kotlinx.serialization.KSerializer[]) r9
            kotlinx.serialization.KSerializer r9 = invokeSerializerOnCompanion(r8, r9)
            if (r9 == 0) goto L36
            return r9
        L36:
            kotlinx.serialization.KSerializer r9 = findObjectSerializer(r8)
            if (r9 == 0) goto L3d
            return r9
        L3d:
            r9 = 0
            java.lang.Class[] r0 = r8.getDeclaredClasses()     // Catch: java.lang.NoSuchFieldException -> L84
            java.lang.String r1 = "declaredClasses"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.NoSuchFieldException -> L84
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch: java.lang.NoSuchFieldException -> L84
            int r1 = r0.length     // Catch: java.lang.NoSuchFieldException -> L84
            r2 = 0
            r4 = r9
            r3 = r2
        L4d:
            if (r2 >= r1) goto L68
            r5 = r0[r2]     // Catch: java.lang.NoSuchFieldException -> L84
            r6 = r5
            java.lang.Class r6 = (java.lang.Class) r6     // Catch: java.lang.NoSuchFieldException -> L84
            java.lang.String r6 = r6.getSimpleName()     // Catch: java.lang.NoSuchFieldException -> L84
            java.lang.String r7 = "$serializer"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)     // Catch: java.lang.NoSuchFieldException -> L84
            if (r6 == 0) goto L65
            if (r3 == 0) goto L63
            goto L6a
        L63:
            r3 = 1
            r4 = r5
        L65:
            int r2 = r2 + 1
            goto L4d
        L68:
            if (r3 != 0) goto L6b
        L6a:
            r4 = r9
        L6b:
            java.lang.Class r4 = (java.lang.Class) r4     // Catch: java.lang.NoSuchFieldException -> L84
            if (r4 == 0) goto L7c
            java.lang.String r0 = "INSTANCE"
            java.lang.reflect.Field r0 = r4.getField(r0)     // Catch: java.lang.NoSuchFieldException -> L84
            if (r0 == 0) goto L7c
            java.lang.Object r0 = r0.get(r9)     // Catch: java.lang.NoSuchFieldException -> L84
            goto L7d
        L7c:
            r0 = r9
        L7d:
            boolean r1 = r0 instanceof kotlinx.serialization.KSerializer     // Catch: java.lang.NoSuchFieldException -> L84
            if (r1 == 0) goto L87
            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0     // Catch: java.lang.NoSuchFieldException -> L84
            goto L88
        L84:
            r0 = r9
            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
        L87:
            r0 = r9
        L88:
            if (r0 == 0) goto L8b
            return r0
        L8b:
            boolean r0 = isPolymorphicSerializer(r8)
            if (r0 == 0) goto L9d
            kotlinx.serialization.PolymorphicSerializer r9 = new kotlinx.serialization.PolymorphicSerializer
            kotlin.reflect.KClass r8 = kotlin.jvm.JvmClassMappingKt.getKotlinClass(r8)
            r9.<init>(r8)
            kotlinx.serialization.KSerializer r9 = (kotlinx.serialization.KSerializer) r9
            goto La0
        L9d:
            r8 = r9
            kotlinx.serialization.KSerializer r8 = (kotlinx.serialization.KSerializer) r8
        La0:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.constructSerializerForGivenTypeArgs(java.lang.Class, kotlinx.serialization.KSerializer[]):kotlinx.serialization.KSerializer");
    }

    private static final <T> boolean isNotAnnotated(Class<T> cls) {
        return cls.getAnnotation(Serializable.class) == null && cls.getAnnotation(Polymorphic.class) == null;
    }

    private static final <T> boolean isPolymorphicSerializer(Class<T> cls) {
        if (cls.getAnnotation(Polymorphic.class) != null) {
            return true;
        }
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        return serializable != null && Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(serializable.with()), Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class));
    }

    private static final <T> KSerializer<T> interfaceSerializer(Class<T> cls) {
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        if (serializable == null || Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(serializable.with()), Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class))) {
            return new PolymorphicSerializer(JvmClassMappingKt.getKotlinClass(cls));
        }
        return null;
    }

    private static final <T> KSerializer<T> invokeSerializerOnCompanion(Class<?> cls, KSerializer<Object>... kSerializerArr) {
        Class[] clsArr;
        Object companionOrNull = companionOrNull(cls);
        if (companionOrNull == null) {
            return null;
        }
        try {
            if (!(kSerializerArr.length == 0)) {
                int length = kSerializerArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr2[i] = KSerializer.class;
                }
                clsArr = clsArr2;
            } else {
                clsArr = new Class[0];
            }
            Object invoke = companionOrNull.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(companionOrNull, Arrays.copyOf(kSerializerArr, kSerializerArr.length));
            if (invoke instanceof KSerializer) {
                return (KSerializer) invoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                throw e;
            }
            String message = cause.getMessage();
            if (message == null) {
                message = e.getMessage();
            }
            throw new InvocationTargetException(cause, message);
        }
    }

    private static final Object companionOrNull(Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField("Companion");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static final <T> KSerializer<T> createEnumSerializer(Class<T> cls) {
        T[] enumConstants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        Intrinsics.checkNotNullExpressionValue(canonicalName, "canonicalName");
        Intrinsics.checkNotNull(enumConstants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new EnumSerializer(canonicalName, (Enum[]) enumConstants);
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a0, code lost:
    
        if (r5 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0046, code lost:
    
        if (r5 == false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final <T> kotlinx.serialization.KSerializer<T> findObjectSerializer(java.lang.Class<T> r12) {
        /*
            java.lang.reflect.Field[] r0 = r12.getDeclaredFields()
            java.lang.String r1 = "declaredFields"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            int r1 = r0.length
            r2 = 0
            r3 = 0
            r6 = r2
            r4 = r3
            r5 = r4
        L11:
            r7 = 1
            if (r4 >= r1) goto L46
            r8 = r0[r4]
            r9 = r8
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            java.lang.String r10 = r9.getName()
            java.lang.String r11 = "INSTANCE"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r11)
            if (r10 == 0) goto L3b
            java.lang.Class r10 = r9.getType()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r12)
            if (r10 == 0) goto L3b
            int r9 = r9.getModifiers()
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)
            if (r9 == 0) goto L3b
            r9 = r7
            goto L3c
        L3b:
            r9 = r3
        L3c:
            if (r9 == 0) goto L43
            if (r5 == 0) goto L41
            goto L48
        L41:
            r5 = r7
            r6 = r8
        L43:
            int r4 = r4 + 1
            goto L11
        L46:
            if (r5 != 0) goto L49
        L48:
            r6 = r2
        L49:
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            if (r6 != 0) goto L4e
            return r2
        L4e:
            java.lang.Object r0 = r6.get(r2)
            java.lang.reflect.Method[] r12 = r12.getMethods()
            java.lang.String r1 = "methods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r1)
            java.lang.Object[] r12 = (java.lang.Object[]) r12
            int r1 = r12.length
            r6 = r2
            r4 = r3
            r5 = r4
        L61:
            if (r4 >= r1) goto La0
            r8 = r12[r4]
            r9 = r8
            java.lang.reflect.Method r9 = (java.lang.reflect.Method) r9
            java.lang.String r10 = r9.getName()
            java.lang.String r11 = "serializer"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r11)
            if (r10 == 0) goto L95
            java.lang.Class[] r10 = r9.getParameterTypes()
            java.lang.String r11 = "it.parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            java.lang.Object[] r10 = (java.lang.Object[]) r10
            int r10 = r10.length
            if (r10 != 0) goto L84
            r10 = r7
            goto L85
        L84:
            r10 = r3
        L85:
            if (r10 == 0) goto L95
            java.lang.Class r9 = r9.getReturnType()
            java.lang.Class<kotlinx.serialization.KSerializer> r10 = kotlinx.serialization.KSerializer.class
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r10)
            if (r9 == 0) goto L95
            r9 = r7
            goto L96
        L95:
            r9 = r3
        L96:
            if (r9 == 0) goto L9d
            if (r5 == 0) goto L9b
            goto La2
        L9b:
            r5 = r7
            r6 = r8
        L9d:
            int r4 = r4 + 1
            goto L61
        La0:
            if (r5 != 0) goto La3
        La2:
            r6 = r2
        La3:
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r6 != 0) goto La8
            return r2
        La8:
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.Object r12 = r6.invoke(r0, r12)
            boolean r0 = r12 instanceof kotlinx.serialization.KSerializer
            if (r0 == 0) goto Lb5
            r2 = r12
            kotlinx.serialization.KSerializer r2 = (kotlinx.serialization.KSerializer) r2
        Lb5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.findObjectSerializer(java.lang.Class):kotlinx.serialization.KSerializer");
    }

    public static final boolean isInstanceOf(Object obj, KClass<?> kclass) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(kclass, "kclass");
        return JvmClassMappingKt.getJavaObjectType(kclass).isInstance(obj);
    }

    public static final boolean isReferenceArray(KClass<Object> rootClass) {
        Intrinsics.checkNotNullParameter(rootClass, "rootClass");
        return JvmClassMappingKt.getJavaClass((KClass) rootClass).isArray();
    }
}
