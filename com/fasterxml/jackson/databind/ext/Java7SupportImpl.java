package com.fasterxml.jackson.databind.ext;

import com.facebook.react.views.text.ReactTextView$$ExternalSyntheticApiModelOutline0;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import java.beans.ConstructorProperties;
import java.beans.Transient;

/* loaded from: classes3.dex */
public class Java7SupportImpl extends Java7Support {
    private final Class<?> _bogus = ConstructorProperties.class;

    @Override // com.fasterxml.jackson.databind.ext.Java7Support
    public Class<?> getClassJavaNioFilePath() {
        return ReactTextView$$ExternalSyntheticApiModelOutline0.m661m();
    }

    @Override // com.fasterxml.jackson.databind.ext.Java7Support
    public JsonDeserializer<?> getDeserializerForJavaNioFilePath(Class<?> cls) {
        if (cls == ReactTextView$$ExternalSyntheticApiModelOutline0.m661m()) {
            return new NioPathDeserializer();
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.ext.Java7Support
    public JsonSerializer<?> getSerializerForJavaNioFilePath(Class<?> cls) {
        if (ReactTextView$$ExternalSyntheticApiModelOutline0.m661m().isAssignableFrom(cls)) {
            return new NioPathSerializer();
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.ext.Java7Support
    public Boolean findTransient(Annotated annotated) {
        Transient annotation = annotated.getAnnotation(Transient.class);
        if (annotation != null) {
            return Boolean.valueOf(annotation.value());
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.ext.Java7Support
    public Boolean hasCreatorAnnotation(Annotated annotated) {
        if (annotated.getAnnotation(ConstructorProperties.class) != null) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.ext.Java7Support
    public PropertyName findConstructorName(AnnotatedParameter annotatedParameter) {
        ConstructorProperties annotation;
        AnnotatedWithParams owner = annotatedParameter.getOwner();
        if (owner == null || (annotation = owner.getAnnotation(ConstructorProperties.class)) == null) {
            return null;
        }
        String[] value = annotation.value();
        int index = annotatedParameter.getIndex();
        if (index < value.length) {
            return PropertyName.construct(value[index]);
        }
        return null;
    }
}
