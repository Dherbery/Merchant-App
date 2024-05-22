package com.onesignal.common.services;

import com.onesignal.core.BuildConfig;
import com.onesignal.debug.internal.logging.Logging;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServiceRegistration.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/onesignal/common/services/ServiceRegistrationReflection;", "T", "Lcom/onesignal/common/services/ServiceRegistration;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "obj", "Ljava/lang/Object;", "doesHaveAllParameters", "", "constructor", "Ljava/lang/reflect/Constructor;", "provider", "Lcom/onesignal/common/services/IServiceProvider;", "resolve", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ServiceRegistrationReflection<T> extends ServiceRegistration<T> {
    private final Class<?> clazz;
    private T obj;

    public ServiceRegistrationReflection(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        this.clazz = clazz;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.onesignal.common.services.ServiceRegistration
    public Object resolve(IServiceProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (this.obj != null) {
            Logging.debug$default(ServiceProvider.INSTANCE.getIndent() + "Already instantiated: " + this.obj, null, 2, null);
            return this.obj;
        }
        Constructor<?>[] constructors = this.clazz.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "clazz.constructors");
        int length = constructors.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Constructor<?> constructor = constructors[i];
            Intrinsics.checkNotNullExpressionValue(constructor, "constructor");
            if (doesHaveAllParameters(constructor, provider)) {
                Logging.debug$default(ServiceProvider.INSTANCE.getIndent() + "Found constructor: " + constructor, null, 2, null);
                ArrayList arrayList = new ArrayList();
                Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
                for (Type type : genericParameterTypes) {
                    if (type instanceof ParameterizedType) {
                        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "param.actualTypeArguments");
                        Type type2 = (Type) ArraysKt.firstOrNull(actualTypeArguments);
                        if (type2 instanceof WildcardType) {
                            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                            Intrinsics.checkNotNullExpressionValue(upperBounds, "argType.upperBounds");
                            Type type3 = (Type) ArraysKt.first(upperBounds);
                            if (type3 instanceof Class) {
                                arrayList.add(provider.getAllServices((Class) type3));
                            } else {
                                arrayList.add(null);
                            }
                        } else if (type2 instanceof Class) {
                            arrayList.add(provider.getAllServices((Class) type2));
                        } else {
                            arrayList.add(null);
                        }
                    } else if (type instanceof Class) {
                        arrayList.add(provider.getService((Class) type));
                    } else {
                        arrayList.add(null);
                    }
                }
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                this.obj = (T) constructor.newInstance(Arrays.copyOf(array, array.length));
            } else {
                i++;
            }
        }
        return this.obj;
    }

    private final boolean doesHaveAllParameters(Constructor<?> constructor, IServiceProvider provider) {
        Type[] genericParameterTypes = constructor.getGenericParameterTypes();
        Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
        for (Type type : genericParameterTypes) {
            if (type instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "param.actualTypeArguments");
                Type type2 = (Type) ArraysKt.firstOrNull(actualTypeArguments);
                if (type2 instanceof WildcardType) {
                    Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds, "argType.upperBounds");
                    Type type3 = (Type) ArraysKt.first(upperBounds);
                    if ((type3 instanceof Class) && !provider.hasService((Class) type3)) {
                        Logging.debug$default("Constructor " + constructor + " could not find service: " + type3, null, 2, null);
                        return false;
                    }
                } else {
                    if (type2 instanceof Class) {
                        if (!provider.hasService((Class) type2)) {
                            Logging.debug$default("Constructor " + constructor + " could not find service: " + type2, null, 2, null);
                        }
                    }
                    return false;
                }
            } else {
                if (!(type instanceof Class)) {
                    Logging.debug$default("Constructor " + constructor + " could not identify param type: " + type, null, 2, null);
                    return false;
                }
                if (!provider.hasService((Class) type)) {
                    Logging.debug$default("Constructor " + constructor + " could not find service: " + type, null, 2, null);
                    return false;
                }
            }
        }
        return true;
    }
}
