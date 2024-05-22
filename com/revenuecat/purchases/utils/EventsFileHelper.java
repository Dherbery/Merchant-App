package com.revenuecat.purchases.utils;

import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.utils.Event;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: EventsFileHelper.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\fJ\u0017\u0010\u0013\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0015J \u0010\u0016\u001a\u00020\f2\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0018\u0012\u0004\u0012\u00020\f0\tJ \u0010\u0019\u001a\u00020\f2\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0018\u0012\u0004\u0012\u00020\f0\tR\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/utils/EventsFileHelper;", "T", "Lcom/revenuecat/purchases/utils/Event;", "", "fileHelper", "Lcom/revenuecat/purchases/common/FileHelper;", "filePath", "", "eventDeserializer", "Lkotlin/Function1;", "(Lcom/revenuecat/purchases/common/FileHelper;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "appendEvent", "", NotificationCompat.CATEGORY_EVENT, "(Lcom/revenuecat/purchases/utils/Event;)V", "clear", "eventsToDeleteCount", "", "deleteFile", "mapToEvent", "string", "(Ljava/lang/String;)Lcom/revenuecat/purchases/utils/Event;", "readFile", "streamBlock", "Ljava/util/stream/Stream;", "readFileAsJson", "Lorg/json/JSONObject;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public class EventsFileHelper<T extends Event> {
    private final Function1<String, T> eventDeserializer;
    private final FileHelper fileHelper;
    private final String filePath;

    /* JADX WARN: Multi-variable type inference failed */
    public EventsFileHelper(FileHelper fileHelper, String filePath, Function1<? super String, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(fileHelper, "fileHelper");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.fileHelper = fileHelper;
        this.filePath = filePath;
        this.eventDeserializer = function1;
    }

    public /* synthetic */ EventsFileHelper(FileHelper fileHelper, String str, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileHelper, str, (i & 4) != 0 ? null : function1);
    }

    public final synchronized void appendEvent(T event) {
        Intrinsics.checkNotNullParameter(event, "event");
        FileHelper fileHelper = this.fileHelper;
        String str = this.filePath;
        StringBuilder sb = new StringBuilder();
        sb.append(event);
        sb.append('\n');
        fileHelper.appendToFile(str, sb.toString());
    }

    public final synchronized void readFile(Function1<? super Stream<T>, Unit> streamBlock) {
        Stream empty;
        Intrinsics.checkNotNullParameter(streamBlock, "streamBlock");
        if (this.eventDeserializer != null && !this.fileHelper.fileIsEmpty(this.filePath)) {
            this.fileHelper.readFilePerLines(this.filePath, new EventsFileHelper$readFile$1(streamBlock, this));
        }
        empty = Stream.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "empty()");
        streamBlock.invoke(empty);
    }

    public final synchronized void readFileAsJson(Function1<? super Stream<JSONObject>, Unit> streamBlock) {
        Stream empty;
        Intrinsics.checkNotNullParameter(streamBlock, "streamBlock");
        if (this.fileHelper.fileIsEmpty(this.filePath)) {
            empty = Stream.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "empty()");
            streamBlock.invoke(empty);
        } else {
            this.fileHelper.readFilePerLines(this.filePath, new EventsFileHelper$readFileAsJson$1(streamBlock));
        }
    }

    public final synchronized void clear(int eventsToDeleteCount) {
        this.fileHelper.removeFirstLinesFromFile(this.filePath, eventsToDeleteCount);
    }

    public final synchronized void deleteFile() {
        if (!this.fileHelper.deleteFile(this.filePath)) {
            LogUtilsKt.verboseLog("Failed to delete events file in " + this.filePath + '.');
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T mapToEvent(String string) {
        Function1<String, T> function1 = this.eventDeserializer;
        if (function1 == null) {
            return null;
        }
        try {
            return function1.invoke(string);
        } catch (SerializationException e) {
            LogUtilsKt.errorLog("Error parsing event from file: " + string, e);
            return null;
        } catch (IllegalArgumentException e2) {
            LogUtilsKt.errorLog("Error parsing event from file: " + string, e2);
            return null;
        }
    }
}
