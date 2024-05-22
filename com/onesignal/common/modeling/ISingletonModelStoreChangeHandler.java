package com.onesignal.common.modeling;

import com.onesignal.common.modeling.Model;
import com.onesignal.core.BuildConfig;
import kotlin.Metadata;

/* compiled from: ISingletonModelStoreChangeHandler.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\r"}, d2 = {"Lcom/onesignal/common/modeling/ISingletonModelStoreChangeHandler;", "TModel", "Lcom/onesignal/common/modeling/Model;", "", "onModelReplaced", "", "model", "tag", "", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface ISingletonModelStoreChangeHandler<TModel extends Model> {
    void onModelReplaced(TModel model, String tag);

    void onModelUpdated(ModelChangedArgs args, String tag);
}
