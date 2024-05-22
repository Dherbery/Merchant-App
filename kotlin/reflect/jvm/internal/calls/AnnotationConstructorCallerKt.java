package kotlin.reflect.jvm.internal.calls;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Typography;

/* compiled from: AnnotationConstructorCaller.kt */
@Metadata(d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001aI\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\u0010\u000b\u001a$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u001a\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¨\u0006\u0014²\u0006\u0014\u0010\u0015\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002²\u0006\u0014\u0010\u0016\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"createAnnotationInstance", "T", "", "annotationClass", "Ljava/lang/Class;", DiagnosticsEntry.Histogram.VALUES_KEY, "", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection", "hashCode", "toString"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AnnotationConstructorCallerKt {
    public static final Object transformKotlinToJvm(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof KClass) {
            obj = JvmClassMappingKt.getJavaClass((KClass) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof KClass[]) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                KClass[] kClassArr = (KClass[]) obj;
                ArrayList arrayList = new ArrayList(kClassArr.length);
                for (KClass kClass : kClassArr) {
                    arrayList.add(JvmClassMappingKt.getJavaClass(kClass));
                }
                obj = arrayList.toArray(new Class[0]);
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }

    public static final Void throwIllegalArgumentType(int i, String str, Class<?> cls) {
        KClass orCreateKotlinClass;
        String qualifiedName;
        if (Intrinsics.areEqual(cls, Class.class)) {
            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KClass.class);
        } else {
            orCreateKotlinClass = (cls.isArray() && Intrinsics.areEqual(cls.getComponentType(), Class.class)) ? Reflection.getOrCreateKotlinClass(KClass[].class) : JvmClassMappingKt.getKotlinClass(cls);
        }
        if (Intrinsics.areEqual(orCreateKotlinClass.getQualifiedName(), Reflection.getOrCreateKotlinClass(Object[].class).getQualifiedName())) {
            StringBuilder sb = new StringBuilder();
            sb.append(orCreateKotlinClass.getQualifiedName());
            sb.append(Typography.less);
            Class<?> componentType = JvmClassMappingKt.getJavaClass(orCreateKotlinClass).getComponentType();
            Intrinsics.checkNotNullExpressionValue(componentType, "kotlinClass.java.componentType");
            sb.append(JvmClassMappingKt.getKotlinClass(componentType).getQualifiedName());
            sb.append(Typography.greater);
            qualifiedName = sb.toString();
        } else {
            qualifiedName = orCreateKotlinClass.getQualifiedName();
        }
        throw new IllegalArgumentException("Argument #" + i + ' ' + str + " is not of the required type " + qualifiedName);
    }

    public static /* synthetic */ Object createAnnotationInstance$default(Class cls, Map map, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            Set keySet = map.keySet();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(keySet, 10));
            Iterator it = keySet.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), new Class[0]));
            }
            list = arrayList;
        }
        return createAnnotationInstance(cls, map, list);
    }

    private static final <T> boolean createAnnotationInstance$equals(Class<T> cls, List<Method> list, Map<String, ? extends Object> map, Object obj) {
        boolean areEqual;
        boolean z;
        KClass annotationClass;
        Class cls2 = null;
        Annotation annotation = obj instanceof Annotation ? (Annotation) obj : null;
        if (annotation != null && (annotationClass = JvmClassMappingKt.getAnnotationClass(annotation)) != null) {
            cls2 = JvmClassMappingKt.getJavaClass(annotationClass);
        }
        if (!Intrinsics.areEqual(cls2, cls)) {
            return false;
        }
        List<Method> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            for (Method method : list2) {
                Object obj2 = map.get(method.getName());
                Object invoke = method.invoke(obj, new Object[0]);
                if (obj2 instanceof boolean[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.BooleanArray");
                    areEqual = Arrays.equals((boolean[]) obj2, (boolean[]) invoke);
                } else if (obj2 instanceof char[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.CharArray");
                    areEqual = Arrays.equals((char[]) obj2, (char[]) invoke);
                } else if (obj2 instanceof byte[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.ByteArray");
                    areEqual = Arrays.equals((byte[]) obj2, (byte[]) invoke);
                } else if (obj2 instanceof short[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.ShortArray");
                    areEqual = Arrays.equals((short[]) obj2, (short[]) invoke);
                } else if (obj2 instanceof int[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.IntArray");
                    areEqual = Arrays.equals((int[]) obj2, (int[]) invoke);
                } else if (obj2 instanceof float[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.FloatArray");
                    areEqual = Arrays.equals((float[]) obj2, (float[]) invoke);
                } else if (obj2 instanceof long[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.LongArray");
                    areEqual = Arrays.equals((long[]) obj2, (long[]) invoke);
                } else if (obj2 instanceof double[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.DoubleArray");
                    areEqual = Arrays.equals((double[]) obj2, (double[]) invoke);
                } else if (obj2 instanceof Object[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
                    areEqual = Arrays.equals((Object[]) obj2, (Object[]) invoke);
                } else {
                    areEqual = Intrinsics.areEqual(obj2, invoke);
                }
                if (!areEqual) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        return z;
    }

    public static final <T> T createAnnotationInstance(final Class<T> annotationClass, final Map<String, ? extends Object> values, List<Method> methods) {
        Intrinsics.checkNotNullParameter(annotationClass, "annotationClass");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(methods, "methods");
        Lazy lazy = LazyKt.lazy(new Function0<Integer>() { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                int hashCode;
                Iterator<T> it = values.entrySet().iterator();
                int i = 0;
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof boolean[]) {
                        hashCode = Arrays.hashCode((boolean[]) value);
                    } else if (value instanceof char[]) {
                        hashCode = Arrays.hashCode((char[]) value);
                    } else if (value instanceof byte[]) {
                        hashCode = Arrays.hashCode((byte[]) value);
                    } else if (value instanceof short[]) {
                        hashCode = Arrays.hashCode((short[]) value);
                    } else if (value instanceof int[]) {
                        hashCode = Arrays.hashCode((int[]) value);
                    } else if (value instanceof float[]) {
                        hashCode = Arrays.hashCode((float[]) value);
                    } else if (value instanceof long[]) {
                        hashCode = Arrays.hashCode((long[]) value);
                    } else if (value instanceof double[]) {
                        hashCode = Arrays.hashCode((double[]) value);
                    } else {
                        hashCode = value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode();
                    }
                    i += hashCode ^ (str.hashCode() * 127);
                }
                return Integer.valueOf(i);
            }
        });
        T t = (T) Proxy.newProxyInstance(annotationClass.getClassLoader(), new Class[]{annotationClass}, new InvocationHandler(annotationClass, values, LazyKt.lazy(new Function0<String>() { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$toString$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Class<T> cls = annotationClass;
                Map<String, Object> map = values;
                StringBuilder sb = new StringBuilder();
                sb.append('@');
                sb.append(cls.getCanonicalName());
                CollectionsKt.joinTo(map.entrySet(), sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : "(", (r14 & 8) != 0 ? "" : ")", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : new Function1<Map.Entry<? extends String, ? extends Object>, CharSequence>() { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends Object> entry) {
                        return invoke2((Map.Entry<String, ? extends Object>) entry);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final CharSequence invoke2(Map.Entry<String, ? extends Object> entry) {
                        String obj;
                        Intrinsics.checkNotNullParameter(entry, "entry");
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof boolean[]) {
                            obj = Arrays.toString((boolean[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
                        } else if (value instanceof char[]) {
                            obj = Arrays.toString((char[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
                        } else if (value instanceof byte[]) {
                            obj = Arrays.toString((byte[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
                        } else if (value instanceof short[]) {
                            obj = Arrays.toString((short[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
                        } else if (value instanceof int[]) {
                            obj = Arrays.toString((int[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
                        } else if (value instanceof float[]) {
                            obj = Arrays.toString((float[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
                        } else if (value instanceof long[]) {
                            obj = Arrays.toString((long[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
                        } else if (value instanceof double[]) {
                            obj = Arrays.toString((double[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
                        } else if (value instanceof Object[]) {
                            obj = Arrays.toString((Object[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
                        } else {
                            obj = value.toString();
                        }
                        return key + '=' + obj;
                    }
                });
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
        }), lazy, methods) { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$0
            private final Class arg$0;
            private final Map arg$1;
            private final Lazy arg$2;
            private final Lazy arg$3;
            private final List arg$4;

            {
                this.arg$0 = annotationClass;
                this.arg$1 = values;
                this.arg$2 = r3;
                this.arg$3 = lazy;
                this.arg$4 = methods;
            }

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                Object createAnnotationInstance$lambda$4;
                createAnnotationInstance$lambda$4 = AnnotationConstructorCallerKt.createAnnotationInstance$lambda$4(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4, obj, method, objArr);
                return createAnnotationInstance$lambda$4;
            }
        });
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return t;
    }

    private static final int createAnnotationInstance$lambda$2(Lazy<Integer> lazy) {
        return lazy.getValue().intValue();
    }

    private static final String createAnnotationInstance$lambda$3(Lazy<String> lazy) {
        return lazy.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:
    
        if (r9.length == 1) goto L73;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object createAnnotationInstance$lambda$4(java.lang.Class r2, java.util.Map r3, kotlin.Lazy r4, kotlin.Lazy r5, java.util.List r6, java.lang.Object r7, java.lang.reflect.Method r8, java.lang.Object[] r9) {
        /*
            java.lang.String r7 = "$annotationClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r7)
            java.lang.String r7 = "$values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r7)
            java.lang.String r7 = "$toString$delegate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r7)
            java.lang.String r7 = "$hashCode$delegate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r7)
            java.lang.String r7 = "$methods"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            java.lang.String r7 = r8.getName()
            if (r7 == 0) goto L5c
            int r0 = r7.hashCode()
            r1 = -1776922004(0xffffffff9616526c, float:-1.2142911E-25)
            if (r0 == r1) goto L4e
            r4 = 147696667(0x8cdac1b, float:1.23784505E-33)
            if (r0 == r4) goto L3c
            r4 = 1444986633(0x5620bf09, float:4.4185588E13)
            if (r0 == r4) goto L33
            goto L5c
        L33:
            java.lang.String r4 = "annotationType"
            boolean r4 = r7.equals(r4)
            if (r4 != 0) goto L8b
            goto L5c
        L3c:
            java.lang.String r4 = "hashCode"
            boolean r4 = r7.equals(r4)
            if (r4 != 0) goto L45
            goto L5c
        L45:
            int r2 = createAnnotationInstance$lambda$2(r5)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L8b
        L4e:
            java.lang.String r5 = "toString"
            boolean r5 = r7.equals(r5)
            if (r5 != 0) goto L57
            goto L5c
        L57:
            java.lang.String r2 = createAnnotationInstance$lambda$3(r4)
            goto L8b
        L5c:
            java.lang.String r4 = "equals"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r4)
            r5 = 0
            if (r4 == 0) goto L81
            if (r9 == 0) goto L6c
            int r4 = r9.length
            r0 = 1
            if (r4 != r0) goto L6c
            goto L6d
        L6c:
            r0 = r5
        L6d:
            if (r0 == 0) goto L81
            java.lang.String r4 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r4)
            java.lang.Object r4 = kotlin.collections.ArraysKt.single(r9)
            boolean r2 = createAnnotationInstance$equals(r2, r6, r3, r4)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L8b
        L81:
            boolean r2 = r3.containsKey(r7)
            if (r2 == 0) goto L8c
            java.lang.Object r2 = r3.get(r7)
        L8b:
            return r2
        L8c:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r2 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Method is not supported: "
            r3.<init>(r4)
            r3.append(r8)
            java.lang.String r4 = " (args: "
            r3.append(r4)
            if (r9 != 0) goto La1
            java.lang.Object[] r9 = new java.lang.Object[r5]
        La1:
            java.util.List r4 = kotlin.collections.ArraysKt.toList(r9)
            r3.append(r4)
            r4 = 41
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance$lambda$4(java.lang.Class, java.util.Map, kotlin.Lazy, kotlin.Lazy, java.util.List, java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }
}
