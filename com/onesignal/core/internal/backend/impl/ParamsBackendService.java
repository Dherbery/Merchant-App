package com.onesignal.core.internal.backend.impl;

import com.facebook.react.uimanager.ViewProps;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.backend.IParamsBackendService;
import com.onesignal.core.internal.backend.InfluenceParamsObject;
import com.onesignal.core.internal.http.IHttpClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* compiled from: ParamsBackendService.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/onesignal/core/internal/backend/impl/ParamsBackendService;", "Lcom/onesignal/core/internal/backend/IParamsBackendService;", "_http", "Lcom/onesignal/core/internal/http/IHttpClient;", "(Lcom/onesignal/core/internal/http/IHttpClient;)V", "fetchParams", "Lcom/onesignal/core/internal/backend/ParamsObject;", "appId", "", "subscriptionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processOutcomeJson", "Lcom/onesignal/core/internal/backend/InfluenceParamsObject;", "outcomeJson", "Lorg/json/JSONObject;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ParamsBackendService implements IParamsBackendService {
    private final IHttpClient _http;

    public ParamsBackendService(IHttpClient _http) {
        Intrinsics.checkNotNullParameter(_http, "_http");
        this._http = _http;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    @Override // com.onesignal.core.internal.backend.IParamsBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object fetchParams(java.lang.String r31, java.lang.String r32, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.backend.ParamsObject> r33) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.backend.impl.ParamsBackendService.fetchParams(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final InfluenceParamsObject processOutcomeJson(JSONObject outcomeJson) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
        JSONObjectExtensionsKt.expandJSONObject(outcomeJson, "direct", new Function1<JSONObject, Unit>() { // from class: com.onesignal.core.internal.backend.impl.ParamsBackendService$processOutcomeJson$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                invoke2(jSONObject);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Boolean] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject it) {
                Intrinsics.checkNotNullParameter(it, "it");
                objectRef5.element = JSONObjectExtensionsKt.safeBool(it, ViewProps.ENABLED);
            }
        });
        JSONObjectExtensionsKt.expandJSONObject(outcomeJson, "indirect", new Function1<JSONObject, Unit>() { // from class: com.onesignal.core.internal.backend.impl.ParamsBackendService$processOutcomeJson$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                invoke2(jSONObject);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Boolean] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject indirectJSON) {
                Intrinsics.checkNotNullParameter(indirectJSON, "indirectJSON");
                objectRef6.element = JSONObjectExtensionsKt.safeBool(indirectJSON, ViewProps.ENABLED);
                final Ref.ObjectRef<Integer> objectRef8 = objectRef;
                final Ref.ObjectRef<Integer> objectRef9 = objectRef2;
                JSONObjectExtensionsKt.expandJSONObject(indirectJSON, "notification_attribution", new Function1<JSONObject, Unit>() { // from class: com.onesignal.core.internal.backend.impl.ParamsBackendService$processOutcomeJson$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                        invoke2(jSONObject);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Integer] */
                    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Integer] */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(JSONObject it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        objectRef8.element = JSONObjectExtensionsKt.safeInt(it, "minutes_since_displayed");
                        objectRef9.element = JSONObjectExtensionsKt.safeInt(it, "limit");
                    }
                });
                final Ref.ObjectRef<Integer> objectRef10 = objectRef3;
                final Ref.ObjectRef<Integer> objectRef11 = objectRef4;
                JSONObjectExtensionsKt.expandJSONObject(indirectJSON, "in_app_message_attribution", new Function1<JSONObject, Unit>() { // from class: com.onesignal.core.internal.backend.impl.ParamsBackendService$processOutcomeJson$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                        invoke2(jSONObject);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Integer] */
                    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Integer] */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(JSONObject it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        objectRef10.element = JSONObjectExtensionsKt.safeInt(it, "minutes_since_displayed");
                        objectRef11.element = JSONObjectExtensionsKt.safeInt(it, "limit");
                    }
                });
            }
        });
        JSONObjectExtensionsKt.expandJSONObject(outcomeJson, "unattributed", new Function1<JSONObject, Unit>() { // from class: com.onesignal.core.internal.backend.impl.ParamsBackendService$processOutcomeJson$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                invoke2(jSONObject);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Boolean] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject it) {
                Intrinsics.checkNotNullParameter(it, "it");
                objectRef7.element = JSONObjectExtensionsKt.safeBool(it, ViewProps.ENABLED);
            }
        });
        return new InfluenceParamsObject((Integer) objectRef.element, (Integer) objectRef2.element, (Integer) objectRef3.element, (Integer) objectRef4.element, (Boolean) objectRef5.element, (Boolean) objectRef6.element, (Boolean) objectRef7.element);
    }
}
