package com.onesignal.core.internal.operations.impl;

import com.onesignal.common.modeling.ModelStore;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.operations.CreateSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteAliasOperation;
import com.onesignal.user.internal.operations.DeleteSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteTagOperation;
import com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation;
import com.onesignal.user.internal.operations.LoginUserOperation;
import com.onesignal.user.internal.operations.RefreshUserOperation;
import com.onesignal.user.internal.operations.SetAliasOperation;
import com.onesignal.user.internal.operations.SetPropertyOperation;
import com.onesignal.user.internal.operations.SetTagOperation;
import com.onesignal.user.internal.operations.TrackPurchaseOperation;
import com.onesignal.user.internal.operations.TrackSessionEndOperation;
import com.onesignal.user.internal.operations.TrackSessionStartOperation;
import com.onesignal.user.internal.operations.TransferSubscriptionOperation;
import com.onesignal.user.internal.operations.UpdateSubscriptionOperation;
import com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: OperationModelStore.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/onesignal/core/internal/operations/impl/OperationModelStore;", "Lcom/onesignal/common/modeling/ModelStore;", "Lcom/onesignal/core/internal/operations/Operation;", "prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "create", "jsonObject", "Lorg/json/JSONObject;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OperationModelStore extends ModelStore<Operation> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationModelStore(IPreferencesService prefs) {
        super("operations", prefs);
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        load();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0022. Please report as an issue. */
    @Override // com.onesignal.common.modeling.IModelStore
    public Operation create(JSONObject jsonObject) {
        DeleteAliasOperation deleteAliasOperation;
        if (jsonObject == null) {
            Logging.error$default("null jsonObject sent to OperationModelStore.create", null, 2, null);
            return null;
        }
        if (!jsonObject.has("name")) {
            Logging.error$default("jsonObject must have 'name' attribute", null, 2, null);
            return null;
        }
        String string = jsonObject.getString("name");
        if (string != null) {
            switch (string.hashCode()) {
                case -1865677906:
                    if (string.equals(IdentityOperationExecutor.DELETE_ALIAS)) {
                        deleteAliasOperation = new DeleteAliasOperation();
                        deleteAliasOperation.initializeFromJson(jsonObject);
                        return deleteAliasOperation;
                    }
                    break;
                case -1793763409:
                    if (string.equals(LoginUserOperationExecutor.LOGIN_USER)) {
                        deleteAliasOperation = new LoginUserOperation();
                        deleteAliasOperation.initializeFromJson(jsonObject);
                        return deleteAliasOperation;
                    }
                    break;
                case -1606689981:
                    if (string.equals(UpdateUserOperationExecutor.TRACK_PURCHASE)) {
                        deleteAliasOperation = new TrackPurchaseOperation();
                        deleteAliasOperation.initializeFromJson(jsonObject);
                        return deleteAliasOperation;
                    }
                    break;
                case -1188793632:
                    if (string.equals(UpdateUserOperationExecutor.SET_PROPERTY)) {
                        deleteAliasOperation = new SetPropertyOperation();
                        deleteAliasOperation.initializeFromJson(jsonObject);
                        return deleteAliasOperation;
                    }
                    break;
                case -1080179201:
                    if (string.equals(SubscriptionOperationExecutor.DELETE_SUBSCRIPTION)) {
                        deleteAliasOperation = new DeleteSubscriptionOperation();
                        deleteAliasOperation.initializeFromJson(jsonObject);
                        return deleteAliasOperation;
                    }
                    break;
                case -828599391:
                    if (string.equals(SubscriptionOperationExecutor.UPDATE_SUBSCRIPTION)) {
                        deleteAliasOperation = new UpdateSubscriptionOperation();
                        deleteAliasOperation.initializeFromJson(jsonObject);
                        return deleteAliasOperation;
                    }
                    break;
                case -516221659:
                    if (string.equals(IdentityOperationExecutor.SET_ALIAS)) {
                        deleteAliasOperation = new SetAliasOperation();
                        deleteAliasOperation.initializeFromJson(jsonObject);
                        return deleteAliasOperation;
                    }
                    break;
                case -92337283:
                    if (string.equals(RefreshUserOperationExecutor.REFRESH_USER)) {
                        deleteAliasOperation = new RefreshUserOperation();
                        deleteAliasOperation.initializeFromJson(jsonObject);
                        return deleteAliasOperation;
                    }
                    break;
                case 532599746:
                    if (string.equals(LoginUserFromSubscriptionOperationExecutor.LOGIN_USER_FROM_SUBSCRIPTION_USER)) {
                        deleteAliasOperation = new LoginUserFromSubscriptionOperation();
                        deleteAliasOperation.initializeFromJson(jsonObject);
                        return deleteAliasOperation;
                    }
                    break;
                case 846157390:
                    if (string.equals(SubscriptionOperationExecutor.CREATE_SUBSCRIPTION)) {
                        deleteAliasOperation = new CreateSubscriptionOperation();
                        deleteAliasOperation.initializeFromJson(jsonObject);
                        return deleteAliasOperation;
                    }
                    break;
                case 1707031487:
                    if (string.equals(SubscriptionOperationExecutor.TRANSFER_SUBSCRIPTION)) {
                        deleteAliasOperation = new TransferSubscriptionOperation();
                        deleteAliasOperation.initializeFromJson(jsonObject);
                        return deleteAliasOperation;
                    }
                    break;
                case 1763437688:
                    if (string.equals(UpdateUserOperationExecutor.DELETE_TAG)) {
                        deleteAliasOperation = new DeleteTagOperation();
                        deleteAliasOperation.initializeFromJson(jsonObject);
                        return deleteAliasOperation;
                    }
                    break;
                case 1852485538:
                    if (string.equals(UpdateUserOperationExecutor.TRACK_SESSION_END)) {
                        deleteAliasOperation = new TrackSessionEndOperation();
                        deleteAliasOperation.initializeFromJson(jsonObject);
                        return deleteAliasOperation;
                    }
                    break;
                case 1983836079:
                    if (string.equals(UpdateUserOperationExecutor.SET_TAG)) {
                        deleteAliasOperation = new SetTagOperation();
                        deleteAliasOperation.initializeFromJson(jsonObject);
                        return deleteAliasOperation;
                    }
                    break;
                case 2135250281:
                    if (string.equals(UpdateUserOperationExecutor.TRACK_SESSION_START)) {
                        deleteAliasOperation = new TrackSessionStartOperation();
                        deleteAliasOperation.initializeFromJson(jsonObject);
                        return deleteAliasOperation;
                    }
                    break;
            }
        }
        throw new Exception("Unrecognized operation: " + string);
    }
}
