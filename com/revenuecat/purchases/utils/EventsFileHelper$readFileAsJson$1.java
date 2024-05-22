package com.revenuecat.purchases.utils;

import java.util.function.Function;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* compiled from: EventsFileHelper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "Lcom/revenuecat/purchases/utils/Event;", "stream", "Ljava/util/stream/Stream;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
final class EventsFileHelper$readFileAsJson$1 extends Lambda implements Function1<Stream<String>, Unit> {
    final /* synthetic */ Function1<Stream<JSONObject>, Unit> $streamBlock;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EventsFileHelper$readFileAsJson$1(Function1<? super Stream<JSONObject>, Unit> function1) {
        super(1);
        this.$streamBlock = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Stream<String> stream) {
        invoke2(PathTreeWalk$$ExternalSyntheticApiModelOutline0.m2563m((Object) stream));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject invoke$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (JSONObject) tmp0.invoke(obj);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Stream<String> stream) {
        Stream<JSONObject> map;
        Intrinsics.checkNotNullParameter(stream, "stream");
        Function1<Stream<JSONObject>, Unit> function1 = this.$streamBlock;
        final AnonymousClass1 anonymousClass1 = new Function1<String, JSONObject>() { // from class: com.revenuecat.purchases.utils.EventsFileHelper$readFileAsJson$1.1
            @Override // kotlin.jvm.functions.Function1
            public final JSONObject invoke(String str) {
                return new JSONObject(str);
            }
        };
        map = stream.map(new Function() { // from class: com.revenuecat.purchases.utils.EventsFileHelper$readFileAsJson$1$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                JSONObject invoke$lambda$0;
                invoke$lambda$0 = EventsFileHelper$readFileAsJson$1.invoke$lambda$0(Function1.this, obj);
                return invoke$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "stream.map { JSONObject(it) }");
        function1.invoke(map);
    }
}
