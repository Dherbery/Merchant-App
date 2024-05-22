package com.onesignal.core.internal.operations;

import com.onesignal.common.modeling.Model;
import com.onesignal.core.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Operation.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u001c\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001bH\u0016R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00038F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/onesignal/core/internal/operations/Operation;", "Lcom/onesignal/common/modeling/Model;", "name", "", "(Ljava/lang/String;)V", "applyToRecordId", "getApplyToRecordId", "()Ljava/lang/String;", "canStartExecute", "", "getCanStartExecute", "()Z", "createComparisonKey", "getCreateComparisonKey", "groupComparisonType", "Lcom/onesignal/core/internal/operations/GroupComparisonType;", "getGroupComparisonType", "()Lcom/onesignal/core/internal/operations/GroupComparisonType;", "modifyComparisonKey", "getModifyComparisonKey", "value", "getName", "setName", "toString", "translateIds", "", "map", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public abstract class Operation extends Model {
    public abstract String getApplyToRecordId();

    public abstract boolean getCanStartExecute();

    public abstract String getCreateComparisonKey();

    public abstract GroupComparisonType getGroupComparisonType();

    public abstract String getModifyComparisonKey();

    public void translateIds(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Operation(String name) {
        super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(name, "name");
        setName(name);
    }

    public final String getName() {
        return Model.getStringProperty$default(this, "name", null, 2, null);
    }

    private final void setName(String str) {
        Model.setStringProperty$default(this, "name", str, null, false, 12, null);
    }

    public String toString() {
        String jSONObject = toJSON().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toJSON().toString()");
        return jSONObject;
    }
}
