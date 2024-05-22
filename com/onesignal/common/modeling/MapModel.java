package com.onesignal.common.modeling;

import androidx.exifinterface.media.ExifInterface;
import com.amazon.a.a.o.b;
import com.google.firebase.messaging.Constants;
import com.onesignal.core.BuildConfig;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: MapModel.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u0015\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u001aH\u0016J\u001d\u0010\"\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010#J\u001e\u0010$\u001a\u00020\u00182\u0014\u0010%\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000&H\u0016J\u0015\u0010'\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010 R&\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Lcom/onesignal/common/modeling/MapModel;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/onesignal/common/modeling/Model;", "", "", "parentModel", "parentProperty", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", DiagnosticsEntry.Histogram.VALUES_KEY, "", "getValues", "()Ljava/util/Collection;", "clear", "", "containsKey", "", SubscriberAttributeKt.JSON_NAME_KEY, "containsValue", "value", "(Ljava/lang/Object;)Z", b.ar, "(Ljava/lang/String;)Ljava/lang/Object;", "isEmpty", "put", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", Constants.MessagePayloadKeys.FROM, "", "remove", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public class MapModel<V> extends Model implements Map<String, V>, KMutableMap {
    public MapModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ MapModel(Model model, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : model, (i & 2) != 0 ? null : str);
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ V get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(String str, Object obj) {
        return put2(str, (String) obj);
    }

    @Override // java.util.Map
    public final /* bridge */ V remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public MapModel(Model model, String str) {
        super(model, str);
    }

    public int getSize() {
        return getData().size();
    }

    public Set<Map.Entry<String, V>> getEntries() {
        Set<Map.Entry<String, Object>> entrySet = getData().entrySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : entrySet) {
            if (TypeIntrinsics.isMutableMapEntry(obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toMutableSet(arrayList);
    }

    public Set<String> getKeys() {
        return getData().keySet();
    }

    public Collection<V> getValues() {
        Collection<Object> values = getData().values();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }

    public boolean containsKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getData().containsKey(key);
    }

    @Override // java.util.Map
    public boolean containsValue(V value) {
        return getData().containsValue(value);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getData().isEmpty();
    }

    public V get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (V) Model.getOptAnyProperty$default(this, key, null, 2, null);
    }

    @Override // java.util.Map
    public void clear() {
        Iterator<String> it = getData().keySet().iterator();
        while (it.hasNext()) {
            Model.setOptAnyProperty$default(this, it.next(), null, null, false, 12, null);
        }
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public V put2(String key, V value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Model.setOptAnyProperty$default(this, key, value, null, false, 12, null);
        return value;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        for (Map.Entry<? extends String, ? extends V> entry : from.entrySet()) {
            Model.setOptAnyProperty$default(this, entry.getKey(), entry.getValue(), null, false, 12, null);
        }
    }

    public V remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MapModel<V> mapModel = this;
        V v = (V) Model.getOptAnyProperty$default(mapModel, key, null, 2, null);
        Model.setOptAnyProperty$default(mapModel, key, null, null, false, 12, null);
        return v;
    }
}
