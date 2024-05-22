package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class POJOPropertiesCollector {
    protected final AnnotationIntrospector _annotationIntrospector;
    protected LinkedList<AnnotatedMember> _anyGetters;
    protected LinkedList<AnnotatedMember> _anySetterField;
    protected LinkedList<AnnotatedMethod> _anySetters;
    protected final AnnotatedClass _classDef;
    protected boolean _collected;
    protected final MapperConfig<?> _config;
    protected LinkedList<POJOPropertyBuilder> _creatorProperties;
    protected final boolean _forSerialization;
    protected HashSet<String> _ignoredPropertyNames;
    protected LinkedHashMap<Object, AnnotatedMember> _injectables;
    protected LinkedList<AnnotatedMethod> _jsonValueGetters;
    protected final String _mutatorPrefix;
    protected LinkedHashMap<String, POJOPropertyBuilder> _properties;
    protected final boolean _stdBeanNaming;
    protected final JavaType _type;
    protected final VisibilityChecker<?> _visibilityChecker;

    @Deprecated
    public POJOPropertiesCollector collect() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public POJOPropertiesCollector(MapperConfig<?> mapperConfig, boolean z, JavaType javaType, AnnotatedClass annotatedClass, String str) {
        this._config = mapperConfig;
        this._stdBeanNaming = mapperConfig.isEnabled(MapperFeature.USE_STD_BEAN_NAMING);
        this._forSerialization = z;
        this._type = javaType;
        this._classDef = annotatedClass;
        this._mutatorPrefix = str == null ? "set" : str;
        AnnotationIntrospector annotationIntrospector = mapperConfig.isAnnotationProcessingEnabled() ? mapperConfig.getAnnotationIntrospector() : null;
        this._annotationIntrospector = annotationIntrospector;
        if (annotationIntrospector == null) {
            this._visibilityChecker = mapperConfig.getDefaultVisibilityChecker();
        } else {
            this._visibilityChecker = annotationIntrospector.findAutoDetectVisibility(annotatedClass, mapperConfig.getDefaultVisibilityChecker());
        }
    }

    public MapperConfig<?> getConfig() {
        return this._config;
    }

    public JavaType getType() {
        return this._type;
    }

    public AnnotatedClass getClassDef() {
        return this._classDef;
    }

    public AnnotationIntrospector getAnnotationIntrospector() {
        return this._annotationIntrospector;
    }

    public List<BeanPropertyDefinition> getProperties() {
        return new ArrayList(getPropertyMap().values());
    }

    public Map<Object, AnnotatedMember> getInjectables() {
        if (!this._collected) {
            collectAll();
        }
        return this._injectables;
    }

    public AnnotatedMethod getJsonValueMethod() {
        if (!this._collected) {
            collectAll();
        }
        LinkedList<AnnotatedMethod> linkedList = this._jsonValueGetters;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            reportProblem("Multiple value properties defined (" + this._jsonValueGetters.get(0) + " vs " + this._jsonValueGetters.get(1) + ")");
        }
        return this._jsonValueGetters.get(0);
    }

    public AnnotatedMember getAnyGetter() {
        if (!this._collected) {
            collectAll();
        }
        LinkedList<AnnotatedMember> linkedList = this._anyGetters;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            reportProblem("Multiple 'any-getters' defined (" + this._anyGetters.get(0) + " vs " + this._anyGetters.get(1) + ")");
        }
        return this._anyGetters.getFirst();
    }

    public AnnotatedMember getAnySetterField() {
        if (!this._collected) {
            collectAll();
        }
        LinkedList<AnnotatedMember> linkedList = this._anySetterField;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            reportProblem("Multiple 'any-Setters' defined (" + this._anySetters.get(0) + " vs " + this._anySetterField.get(1) + ")");
        }
        return this._anySetterField.getFirst();
    }

    public AnnotatedMethod getAnySetterMethod() {
        if (!this._collected) {
            collectAll();
        }
        LinkedList<AnnotatedMethod> linkedList = this._anySetters;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            reportProblem("Multiple 'any-setters' defined (" + this._anySetters.get(0) + " vs " + this._anySetters.get(1) + ")");
        }
        return this._anySetters.getFirst();
    }

    public Set<String> getIgnoredPropertyNames() {
        return this._ignoredPropertyNames;
    }

    public ObjectIdInfo getObjectIdInfo() {
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        if (annotationIntrospector == null) {
            return null;
        }
        ObjectIdInfo findObjectIdInfo = annotationIntrospector.findObjectIdInfo(this._classDef);
        return findObjectIdInfo != null ? this._annotationIntrospector.findObjectReferenceInfo(this._classDef, findObjectIdInfo) : findObjectIdInfo;
    }

    public Class<?> findPOJOBuilderClass() {
        return this._annotationIntrospector.findPOJOBuilder(this._classDef);
    }

    protected Map<String, POJOPropertyBuilder> getPropertyMap() {
        if (!this._collected) {
            collectAll();
        }
        return this._properties;
    }

    protected void collectAll() {
        LinkedHashMap<String, POJOPropertyBuilder> linkedHashMap = new LinkedHashMap<>();
        _addFields(linkedHashMap);
        _addMethods(linkedHashMap);
        if (!this._classDef.isNonStaticInnerClass()) {
            _addCreators(linkedHashMap);
        }
        _addInjectables(linkedHashMap);
        _removeUnwantedProperties(linkedHashMap);
        Iterator<POJOPropertyBuilder> it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            it.next().mergeAnnotations(this._forSerialization);
        }
        _removeUnwantedAccessor(linkedHashMap);
        _renameProperties(linkedHashMap);
        PropertyNamingStrategy _findNamingStrategy = _findNamingStrategy();
        if (_findNamingStrategy != null) {
            _renameUsing(linkedHashMap, _findNamingStrategy);
        }
        Iterator<POJOPropertyBuilder> it2 = linkedHashMap.values().iterator();
        while (it2.hasNext()) {
            it2.next().trimByVisibility();
        }
        if (this._config.isEnabled(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            _renameWithWrappers(linkedHashMap);
        }
        _sortProperties(linkedHashMap);
        this._properties = linkedHashMap;
        this._collected = true;
    }

    protected void _addFields(Map<String, POJOPropertyBuilder> map) {
        boolean z;
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        boolean z2 = (this._forSerialization || this._config.isEnabled(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS)) ? false : true;
        boolean isEnabled = this._config.isEnabled(MapperFeature.PROPAGATE_TRANSIENT_MARKER);
        for (AnnotatedField annotatedField : this._classDef.fields()) {
            PropertyName propertyName = null;
            String findImplicitPropertyName = annotationIntrospector == null ? null : annotationIntrospector.findImplicitPropertyName(annotatedField);
            if (findImplicitPropertyName == null) {
                findImplicitPropertyName = annotatedField.getName();
            }
            if (annotationIntrospector != null) {
                if (this._forSerialization) {
                    propertyName = annotationIntrospector.findNameForSerialization(annotatedField);
                } else {
                    propertyName = annotationIntrospector.findNameForDeserialization(annotatedField);
                }
            }
            boolean z3 = propertyName != null;
            if (z3 && propertyName.isEmpty()) {
                propertyName = _propNameFromSimple(findImplicitPropertyName);
                z = false;
            } else {
                z = z3;
            }
            boolean z4 = propertyName != null;
            if (!z4) {
                z4 = this._visibilityChecker.isFieldVisible(annotatedField);
            }
            boolean z5 = annotationIntrospector != null && annotationIntrospector.hasIgnoreMarker(annotatedField);
            if (annotatedField.isTransient() && !z3) {
                if (isEnabled) {
                    z5 = true;
                }
                z4 = false;
            }
            if (!z2 || propertyName != null || z5 || !Modifier.isFinal(annotatedField.getModifiers())) {
                if (annotatedField.hasAnnotation(JsonAnySetter.class)) {
                    if (this._anySetterField == null) {
                        this._anySetterField = new LinkedList<>();
                    }
                    this._anySetterField.add(annotatedField);
                }
                _property(map, findImplicitPropertyName).addField(annotatedField, propertyName, z, z4, z5);
            }
        }
    }

    protected void _addCreators(Map<String, POJOPropertyBuilder> map) {
        if (this._annotationIntrospector == null) {
            return;
        }
        Iterator<AnnotatedConstructor> it = this._classDef.getConstructors().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AnnotatedConstructor next = it.next();
            if (this._creatorProperties == null) {
                this._creatorProperties = new LinkedList<>();
            }
            int parameterCount = next.getParameterCount();
            for (int i = 0; i < parameterCount; i++) {
                _addCreatorParam(map, next.getParameter(i));
            }
        }
        for (AnnotatedMethod annotatedMethod : this._classDef.getStaticMethods()) {
            if (this._creatorProperties == null) {
                this._creatorProperties = new LinkedList<>();
            }
            int parameterCount2 = annotatedMethod.getParameterCount();
            for (int i2 = 0; i2 < parameterCount2; i2++) {
                _addCreatorParam(map, annotatedMethod.getParameter(i2));
            }
        }
    }

    protected void _addCreatorParam(Map<String, POJOPropertyBuilder> map, AnnotatedParameter annotatedParameter) {
        String findImplicitPropertyName = this._annotationIntrospector.findImplicitPropertyName(annotatedParameter);
        if (findImplicitPropertyName == null) {
            findImplicitPropertyName = "";
        }
        PropertyName findNameForDeserialization = this._annotationIntrospector.findNameForDeserialization(annotatedParameter);
        boolean z = (findNameForDeserialization == null || findNameForDeserialization.isEmpty()) ? false : true;
        if (!z) {
            if (findImplicitPropertyName.isEmpty() || !this._annotationIntrospector.hasCreatorAnnotation(annotatedParameter.getOwner())) {
                return;
            } else {
                findNameForDeserialization = PropertyName.construct(findImplicitPropertyName);
            }
        }
        PropertyName propertyName = findNameForDeserialization;
        POJOPropertyBuilder _property = (z && findImplicitPropertyName.isEmpty()) ? _property(map, propertyName) : _property(map, findImplicitPropertyName);
        _property.addCtor(annotatedParameter, propertyName, z, true, false);
        this._creatorProperties.add(_property);
    }

    protected void _addMethods(Map<String, POJOPropertyBuilder> map) {
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        for (AnnotatedMethod annotatedMethod : this._classDef.memberMethods()) {
            int parameterCount = annotatedMethod.getParameterCount();
            if (parameterCount == 0) {
                _addGetterMethod(map, annotatedMethod, annotationIntrospector);
            } else if (parameterCount == 1) {
                _addSetterMethod(map, annotatedMethod, annotationIntrospector);
            } else if (parameterCount == 2 && annotationIntrospector != null && annotationIntrospector.hasAnySetterAnnotation(annotatedMethod)) {
                if (this._anySetters == null) {
                    this._anySetters = new LinkedList<>();
                }
                this._anySetters.add(annotatedMethod);
            }
        }
    }

    protected void _addGetterMethod(Map<String, POJOPropertyBuilder> map, AnnotatedMethod annotatedMethod, AnnotationIntrospector annotationIntrospector) {
        String findImplicitPropertyName;
        if (annotatedMethod.hasReturnType()) {
            if (annotationIntrospector != null) {
                if (annotationIntrospector.hasAnyGetterAnnotation(annotatedMethod)) {
                    if (this._anyGetters == null) {
                        this._anyGetters = new LinkedList<>();
                    }
                    this._anyGetters.add(annotatedMethod);
                    return;
                } else if (annotationIntrospector.hasAsValueAnnotation(annotatedMethod)) {
                    if (this._jsonValueGetters == null) {
                        this._jsonValueGetters = new LinkedList<>();
                    }
                    this._jsonValueGetters.add(annotatedMethod);
                    return;
                }
            }
            PropertyName findNameForSerialization = annotationIntrospector == null ? null : annotationIntrospector.findNameForSerialization(annotatedMethod);
            boolean z = true;
            boolean z2 = findNameForSerialization != null;
            if (!z2) {
                findImplicitPropertyName = annotationIntrospector != null ? annotationIntrospector.findImplicitPropertyName(annotatedMethod) : null;
                if (findImplicitPropertyName == null) {
                    findImplicitPropertyName = BeanUtil.okNameForRegularGetter(annotatedMethod, annotatedMethod.getName(), this._stdBeanNaming);
                }
                if (findImplicitPropertyName == null) {
                    findImplicitPropertyName = BeanUtil.okNameForIsGetter(annotatedMethod, annotatedMethod.getName(), this._stdBeanNaming);
                    if (findImplicitPropertyName == null) {
                        return;
                    } else {
                        z = this._visibilityChecker.isIsGetterVisible(annotatedMethod);
                    }
                } else {
                    z = this._visibilityChecker.isGetterVisible(annotatedMethod);
                }
            } else {
                findImplicitPropertyName = annotationIntrospector != null ? annotationIntrospector.findImplicitPropertyName(annotatedMethod) : null;
                if (findImplicitPropertyName == null) {
                    findImplicitPropertyName = BeanUtil.okNameForGetter(annotatedMethod, this._stdBeanNaming);
                }
                if (findImplicitPropertyName == null) {
                    findImplicitPropertyName = annotatedMethod.getName();
                }
                if (findNameForSerialization.isEmpty()) {
                    findNameForSerialization = _propNameFromSimple(findImplicitPropertyName);
                    z2 = false;
                }
            }
            _property(map, findImplicitPropertyName).addGetter(annotatedMethod, findNameForSerialization, z2, z, annotationIntrospector != null ? annotationIntrospector.hasIgnoreMarker(annotatedMethod) : false);
        }
    }

    protected void _addSetterMethod(Map<String, POJOPropertyBuilder> map, AnnotatedMethod annotatedMethod, AnnotationIntrospector annotationIntrospector) {
        String findImplicitPropertyName;
        PropertyName findNameForDeserialization = annotationIntrospector == null ? null : annotationIntrospector.findNameForDeserialization(annotatedMethod);
        boolean z = true;
        boolean z2 = findNameForDeserialization != null;
        if (!z2) {
            findImplicitPropertyName = annotationIntrospector != null ? annotationIntrospector.findImplicitPropertyName(annotatedMethod) : null;
            if (findImplicitPropertyName == null) {
                findImplicitPropertyName = BeanUtil.okNameForMutator(annotatedMethod, this._mutatorPrefix, this._stdBeanNaming);
            }
            if (findImplicitPropertyName == null) {
                return;
            } else {
                z = this._visibilityChecker.isSetterVisible(annotatedMethod);
            }
        } else {
            findImplicitPropertyName = annotationIntrospector != null ? annotationIntrospector.findImplicitPropertyName(annotatedMethod) : null;
            if (findImplicitPropertyName == null) {
                findImplicitPropertyName = BeanUtil.okNameForMutator(annotatedMethod, this._mutatorPrefix, this._stdBeanNaming);
            }
            if (findImplicitPropertyName == null) {
                findImplicitPropertyName = annotatedMethod.getName();
            }
            if (findNameForDeserialization.isEmpty()) {
                findNameForDeserialization = _propNameFromSimple(findImplicitPropertyName);
                z2 = false;
            }
        }
        _property(map, findImplicitPropertyName).addSetter(annotatedMethod, findNameForDeserialization, z2, z, annotationIntrospector != null ? annotationIntrospector.hasIgnoreMarker(annotatedMethod) : false);
    }

    protected void _addInjectables(Map<String, POJOPropertyBuilder> map) {
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        if (annotationIntrospector == null) {
            return;
        }
        for (AnnotatedMember annotatedMember : this._classDef.fields()) {
            _doAddInjectable(annotationIntrospector.findInjectableValueId(annotatedMember), annotatedMember);
        }
        for (AnnotatedMethod annotatedMethod : this._classDef.memberMethods()) {
            if (annotatedMethod.getParameterCount() == 1) {
                _doAddInjectable(annotationIntrospector.findInjectableValueId(annotatedMethod), annotatedMethod);
            }
        }
    }

    protected void _doAddInjectable(Object obj, AnnotatedMember annotatedMember) {
        if (obj == null) {
            return;
        }
        if (this._injectables == null) {
            this._injectables = new LinkedHashMap<>();
        }
        if (this._injectables.put(obj, annotatedMember) == null) {
            return;
        }
        throw new IllegalArgumentException("Duplicate injectable value with id '" + String.valueOf(obj) + "' (of type " + obj.getClass().getName() + ")");
    }

    private PropertyName _propNameFromSimple(String str) {
        return PropertyName.construct(str, null);
    }

    protected void _removeUnwantedProperties(Map<String, POJOPropertyBuilder> map) {
        Iterator<POJOPropertyBuilder> it = map.values().iterator();
        while (it.hasNext()) {
            POJOPropertyBuilder next = it.next();
            if (!next.anyVisible()) {
                it.remove();
            } else if (next.anyIgnorals()) {
                if (!next.isExplicitlyIncluded()) {
                    it.remove();
                    _collectIgnorals(next.getName());
                } else {
                    next.removeIgnored();
                    if (!this._forSerialization && !next.couldDeserialize()) {
                        _collectIgnorals(next.getName());
                    }
                }
            }
        }
    }

    protected void _removeUnwantedAccessor(Map<String, POJOPropertyBuilder> map) {
        boolean isEnabled = this._config.isEnabled(MapperFeature.INFER_PROPERTY_MUTATORS);
        for (POJOPropertyBuilder pOJOPropertyBuilder : map.values()) {
            JsonProperty.Access removeNonVisible = pOJOPropertyBuilder.removeNonVisible(isEnabled);
            if (!this._forSerialization && removeNonVisible == JsonProperty.Access.READ_ONLY) {
                _collectIgnorals(pOJOPropertyBuilder.getName());
            }
        }
    }

    private void _collectIgnorals(String str) {
        if (this._forSerialization) {
            return;
        }
        if (this._ignoredPropertyNames == null) {
            this._ignoredPropertyNames = new HashSet<>();
        }
        this._ignoredPropertyNames.add(str);
    }

    protected void _renameProperties(Map<String, POJOPropertyBuilder> map) {
        Iterator<Map.Entry<String, POJOPropertyBuilder>> it = map.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            POJOPropertyBuilder value = it.next().getValue();
            Set<PropertyName> findExplicitNames = value.findExplicitNames();
            if (!findExplicitNames.isEmpty()) {
                it.remove();
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                if (findExplicitNames.size() == 1) {
                    linkedList.add(value.withName(findExplicitNames.iterator().next()));
                } else {
                    linkedList.addAll(value.explode(findExplicitNames));
                }
            }
        }
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                POJOPropertyBuilder pOJOPropertyBuilder = (POJOPropertyBuilder) it2.next();
                String name = pOJOPropertyBuilder.getName();
                POJOPropertyBuilder pOJOPropertyBuilder2 = map.get(name);
                if (pOJOPropertyBuilder2 == null) {
                    map.put(name, pOJOPropertyBuilder);
                } else {
                    pOJOPropertyBuilder2.addAll(pOJOPropertyBuilder);
                }
                _updateCreatorProperty(pOJOPropertyBuilder, this._creatorProperties);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void _renameUsing(java.util.Map<java.lang.String, com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder> r9, com.fasterxml.jackson.databind.PropertyNamingStrategy r10) {
        /*
            r8 = this;
            java.util.Collection r0 = r9.values()
            int r1 = r9.size()
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder[] r1 = new com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder[] r0 = (com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder[]) r0
            r9.clear()
            int r1 = r0.length
            r2 = 0
        L15:
            if (r2 >= r1) goto Ld9
            r3 = r0[r2]
            com.fasterxml.jackson.databind.PropertyName r4 = r3.getFullName()
            boolean r5 = r3.isExplicitlyNamed()
            if (r5 == 0) goto L2d
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5 = r8._config
            com.fasterxml.jackson.databind.MapperFeature r6 = com.fasterxml.jackson.databind.MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING
            boolean r5 = r5.isEnabled(r6)
            if (r5 == 0) goto Laf
        L2d:
            boolean r5 = r8._forSerialization
            if (r5 == 0) goto L5b
            boolean r5 = r3.hasGetter()
            if (r5 == 0) goto L46
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5 = r8._config
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r6 = r3.getGetter()
            java.lang.String r7 = r4.getSimpleName()
            java.lang.String r5 = r10.nameForGetterMethod(r5, r6, r7)
            goto Lb0
        L46:
            boolean r5 = r3.hasField()
            if (r5 == 0) goto Laf
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5 = r8._config
            com.fasterxml.jackson.databind.introspect.AnnotatedField r6 = r3.getField()
            java.lang.String r7 = r4.getSimpleName()
            java.lang.String r5 = r10.nameForField(r5, r6, r7)
            goto Lb0
        L5b:
            boolean r5 = r3.hasSetter()
            if (r5 == 0) goto L70
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5 = r8._config
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r6 = r3.getSetter()
            java.lang.String r7 = r4.getSimpleName()
            java.lang.String r5 = r10.nameForSetterMethod(r5, r6, r7)
            goto Lb0
        L70:
            boolean r5 = r3.hasConstructorParameter()
            if (r5 == 0) goto L85
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5 = r8._config
            com.fasterxml.jackson.databind.introspect.AnnotatedParameter r6 = r3.getConstructorParameter()
            java.lang.String r7 = r4.getSimpleName()
            java.lang.String r5 = r10.nameForConstructorParameter(r5, r6, r7)
            goto Lb0
        L85:
            boolean r5 = r3.hasField()
            if (r5 == 0) goto L9a
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5 = r8._config
            com.fasterxml.jackson.databind.introspect.AnnotatedField r6 = r3.getField()
            java.lang.String r7 = r4.getSimpleName()
            java.lang.String r5 = r10.nameForField(r5, r6, r7)
            goto Lb0
        L9a:
            boolean r5 = r3.hasGetter()
            if (r5 == 0) goto Laf
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5 = r8._config
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r6 = r3.getGetter()
            java.lang.String r7 = r4.getSimpleName()
            java.lang.String r5 = r10.nameForGetterMethod(r5, r6, r7)
            goto Lb0
        Laf:
            r5 = 0
        Lb0:
            if (r5 == 0) goto Lbd
            boolean r6 = r4.hasSimpleName(r5)
            if (r6 != 0) goto Lbd
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder r3 = r3.withSimpleName(r5)
            goto Lc1
        Lbd:
            java.lang.String r5 = r4.getSimpleName()
        Lc1:
            java.lang.Object r4 = r9.get(r5)
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder r4 = (com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder) r4
            if (r4 != 0) goto Lcd
            r9.put(r5, r3)
            goto Ld0
        Lcd:
            r4.addAll(r3)
        Ld0:
            java.util.LinkedList<com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder> r4 = r8._creatorProperties
            r8._updateCreatorProperty(r3, r4)
            int r2 = r2 + 1
            goto L15
        Ld9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector._renameUsing(java.util.Map, com.fasterxml.jackson.databind.PropertyNamingStrategy):void");
    }

    protected void _renameWithWrappers(Map<String, POJOPropertyBuilder> map) {
        PropertyName findWrapperName;
        Iterator<Map.Entry<String, POJOPropertyBuilder>> it = map.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            POJOPropertyBuilder value = it.next().getValue();
            AnnotatedMember primaryMember = value.getPrimaryMember();
            if (primaryMember != null && (findWrapperName = this._annotationIntrospector.findWrapperName(primaryMember)) != null && findWrapperName.hasSimpleName() && !findWrapperName.equals(value.getFullName())) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(value.withName(findWrapperName));
                it.remove();
            }
        }
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                POJOPropertyBuilder pOJOPropertyBuilder = (POJOPropertyBuilder) it2.next();
                String name = pOJOPropertyBuilder.getName();
                POJOPropertyBuilder pOJOPropertyBuilder2 = map.get(name);
                if (pOJOPropertyBuilder2 == null) {
                    map.put(name, pOJOPropertyBuilder);
                } else {
                    pOJOPropertyBuilder2.addAll(pOJOPropertyBuilder);
                }
            }
        }
    }

    protected void _sortProperties(Map<String, POJOPropertyBuilder> map) {
        boolean booleanValue;
        Map<? extends Object, ? extends Object> linkedHashMap;
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        Boolean findSerializationSortAlphabetically = annotationIntrospector == null ? null : annotationIntrospector.findSerializationSortAlphabetically(this._classDef);
        if (findSerializationSortAlphabetically == null) {
            booleanValue = this._config.shouldSortPropertiesAlphabetically();
        } else {
            booleanValue = findSerializationSortAlphabetically.booleanValue();
        }
        String[] findSerializationPropertyOrder = annotationIntrospector != null ? annotationIntrospector.findSerializationPropertyOrder(this._classDef) : null;
        if (!booleanValue && this._creatorProperties == null && findSerializationPropertyOrder == null) {
            return;
        }
        int size = map.size();
        if (booleanValue) {
            linkedHashMap = new TreeMap<>();
        } else {
            linkedHashMap = new LinkedHashMap<>(size + size);
        }
        for (POJOPropertyBuilder pOJOPropertyBuilder : map.values()) {
            linkedHashMap.put(pOJOPropertyBuilder.getName(), pOJOPropertyBuilder);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(size + size);
        if (findSerializationPropertyOrder != null) {
            for (String str : findSerializationPropertyOrder) {
                POJOPropertyBuilder pOJOPropertyBuilder2 = (POJOPropertyBuilder) linkedHashMap.get(str);
                if (pOJOPropertyBuilder2 == null) {
                    Iterator<POJOPropertyBuilder> it = map.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        POJOPropertyBuilder next = it.next();
                        if (str.equals(next.getInternalName())) {
                            str = next.getName();
                            pOJOPropertyBuilder2 = next;
                            break;
                        }
                    }
                }
                if (pOJOPropertyBuilder2 != null) {
                    linkedHashMap2.put(str, pOJOPropertyBuilder2);
                }
            }
        }
        Collection<POJOPropertyBuilder> collection = this._creatorProperties;
        if (collection != null) {
            if (booleanValue) {
                TreeMap treeMap = new TreeMap();
                Iterator<POJOPropertyBuilder> it2 = this._creatorProperties.iterator();
                while (it2.hasNext()) {
                    POJOPropertyBuilder next2 = it2.next();
                    treeMap.put(next2.getName(), next2);
                }
                collection = treeMap.values();
            }
            for (POJOPropertyBuilder pOJOPropertyBuilder3 : collection) {
                String name = pOJOPropertyBuilder3.getName();
                if (linkedHashMap.containsKey(name)) {
                    linkedHashMap2.put(name, pOJOPropertyBuilder3);
                }
            }
        }
        linkedHashMap2.putAll(linkedHashMap);
        map.clear();
        map.putAll(linkedHashMap2);
    }

    protected void reportProblem(String str) {
        throw new IllegalArgumentException("Problem with definition of " + this._classDef + ": " + str);
    }

    protected POJOPropertyBuilder _property(Map<String, POJOPropertyBuilder> map, PropertyName propertyName) {
        return _property(map, propertyName.getSimpleName());
    }

    protected POJOPropertyBuilder _property(Map<String, POJOPropertyBuilder> map, String str) {
        POJOPropertyBuilder pOJOPropertyBuilder = map.get(str);
        if (pOJOPropertyBuilder != null) {
            return pOJOPropertyBuilder;
        }
        POJOPropertyBuilder pOJOPropertyBuilder2 = new POJOPropertyBuilder(this._config, this._annotationIntrospector, this._forSerialization, PropertyName.construct(str));
        map.put(str, pOJOPropertyBuilder2);
        return pOJOPropertyBuilder2;
    }

    private PropertyNamingStrategy _findNamingStrategy() {
        PropertyNamingStrategy namingStrategyInstance;
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        Object findNamingStrategy = annotationIntrospector == null ? null : annotationIntrospector.findNamingStrategy(this._classDef);
        if (findNamingStrategy == null) {
            return this._config.getPropertyNamingStrategy();
        }
        if (findNamingStrategy instanceof PropertyNamingStrategy) {
            return (PropertyNamingStrategy) findNamingStrategy;
        }
        if (!(findNamingStrategy instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned PropertyNamingStrategy definition of type " + findNamingStrategy.getClass().getName() + "; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
        }
        Class<?> cls = (Class) findNamingStrategy;
        if (cls == PropertyNamingStrategy.class) {
            return null;
        }
        if (!PropertyNamingStrategy.class.isAssignableFrom(cls)) {
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<PropertyNamingStrategy>");
        }
        HandlerInstantiator handlerInstantiator = this._config.getHandlerInstantiator();
        return (handlerInstantiator == null || (namingStrategyInstance = handlerInstantiator.namingStrategyInstance(this._config, this._classDef, cls)) == null) ? (PropertyNamingStrategy) ClassUtil.createInstance(cls, this._config.canOverrideAccessModifiers()) : namingStrategyInstance;
    }

    protected void _updateCreatorProperty(POJOPropertyBuilder pOJOPropertyBuilder, List<POJOPropertyBuilder> list) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).getInternalName().equals(pOJOPropertyBuilder.getInternalName())) {
                    list.set(i, pOJOPropertyBuilder);
                    return;
                }
            }
        }
    }
}
