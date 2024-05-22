package com.revenuecat.purchases.utils;

import java.util.function.Function;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventsFileHelper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "Lcom/revenuecat/purchases/utils/Event;", "stream", "Ljava/util/stream/Stream;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class EventsFileHelper$readFile$1 extends Lambda implements Function1<Stream<String>, Unit> {
    final /* synthetic */ Function1<Stream<T>, Unit> $streamBlock;
    final /* synthetic */ EventsFileHelper<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EventsFileHelper$readFile$1(Function1<? super Stream<T>, Unit> function1, EventsFileHelper<T> eventsFileHelper) {
        super(1);
        this.$streamBlock = function1;
        this.this$0 = eventsFileHelper;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Stream<String> stream) {
        invoke2(PathTreeWalk$$ExternalSyntheticApiModelOutline0.m2563m((Object) stream));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Event invoke$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Event) tmp0.invoke(obj);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Stream<String> stream) {
        Stream map;
        Intrinsics.checkNotNullParameter(stream, "stream");
        Function1<Stream<T>, Unit> function1 = this.$streamBlock;
        final EventsFileHelper<T> eventsFileHelper = this.this$0;
        final Function1 function12 = new Function1<String, T>() { // from class: com.revenuecat.purchases.utils.EventsFileHelper$readFile$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
            @Override // kotlin.jvm.functions.Function1
            public final Event invoke(String line) {
                Event mapToEvent;
                EventsFileHelper<T> eventsFileHelper2 = eventsFileHelper;
                Intrinsics.checkNotNullExpressionValue(line, "line");
                mapToEvent = eventsFileHelper2.mapToEvent(line);
                return mapToEvent;
            }
        };
        map = stream.map(new Function() { // from class: com.revenuecat.purchases.utils.EventsFileHelper$readFile$1$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Event invoke$lambda$0;
                invoke$lambda$0 = EventsFileHelper$readFile$1.invoke$lambda$0(Function1.this, obj);
                return invoke$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "@Synchronized\n    fun re…        }\n        }\n    }");
        function1.invoke(map);
    }
}
