package com.revenuecat.purchases.common;

import java.util.function.Consumer;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: FileHelper.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "stream", "Ljava/util/stream/Stream;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
final class FileHelper$removeFirstLinesFromFile$1 extends Lambda implements Function1<Stream<String>, Unit> {
    final /* synthetic */ int $numberOfLinesToRemove;
    final /* synthetic */ StringBuilder $textToAppend;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileHelper$removeFirstLinesFromFile$1(int i, StringBuilder sb) {
        super(1);
        this.$numberOfLinesToRemove = i;
        this.$textToAppend = sb;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Stream<String> stream) {
        invoke2(PathTreeWalk$$ExternalSyntheticApiModelOutline0.m2563m((Object) stream));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Stream<String> stream) {
        Stream skip;
        Intrinsics.checkNotNullParameter(stream, "stream");
        skip = stream.skip(this.$numberOfLinesToRemove);
        final StringBuilder sb = this.$textToAppend;
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.revenuecat.purchases.common.FileHelper$removeFirstLinesFromFile$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                StringBuilder sb2 = sb;
                sb2.append(str);
                sb2.append("\n");
            }
        };
        skip.forEach(new Consumer() { // from class: com.revenuecat.purchases.common.FileHelper$removeFirstLinesFromFile$1$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                FileHelper$removeFirstLinesFromFile$1.invoke$lambda$0(Function1.this, obj);
            }
        });
    }
}
