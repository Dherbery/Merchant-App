package com.squareup.kotlinpoet;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import io.invertase.googlemobileads.ReactNativeGoogleMobileAdsEvent;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: LineWrapper.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\u0006\u0010\u001d\u001a\u00020\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/squareup/kotlinpoet/LineWrapper;", "Ljava/io/Closeable;", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "indent", "", "columnLimit", "", "(Ljava/lang/Appendable;Ljava/lang/String;I)V", ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_CLOSED, "", "hasPendingSegments", "getHasPendingSegments", "()Z", "indentLevel", "linePrefix", "segments", "", "append", "", "s", "appendNonWrapping", "close", "emitCurrentLine", "emitSegmentRange", "startIndex", "endIndex", "foldUnsafeBreaks", "newline", "Companion", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class LineWrapper implements Closeable {
    private static final char[] SPECIAL_CHARACTERS;
    private boolean closed;
    private final int columnLimit;
    private final String indent;
    private int indentLevel;
    private String linePrefix;
    private final Appendable out;
    private final List<String> segments;
    private static final Regex UNSAFE_LINE_START = new Regex("\\s*[-+].*");

    public LineWrapper(Appendable out, String indent, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(indent, "indent");
        this.out = out;
        this.indent = indent;
        this.columnLimit = i;
        this.segments = CollectionsKt.mutableListOf("");
        this.indentLevel = -1;
        this.linePrefix = "";
    }

    public final boolean getHasPendingSegments() {
        if (this.segments.size() == 1) {
            return this.segments.get(0).length() > 0;
        }
        return true;
    }

    public static /* synthetic */ void append$default(LineWrapper lineWrapper, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        lineWrapper.append(str, i, str2);
    }

    public final void append(String s, int indentLevel, String linePrefix) {
        Intrinsics.checkNotNullParameter(s, "s");
        Intrinsics.checkNotNullParameter(linePrefix, "linePrefix");
        if (!(!this.closed)) {
            throw new IllegalStateException(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_CLOSED.toString());
        }
        int i = 0;
        while (i < s.length()) {
            char charAt = s.charAt(i);
            if (charAt == ' ') {
                this.indentLevel = indentLevel;
                this.linePrefix = linePrefix;
                this.segments.add("");
            } else if (charAt == '\n') {
                newline();
            } else if (charAt == 183) {
                List<String> list = this.segments;
                int size = list.size() - 1;
                list.set(size, list.get(size) + ' ');
            } else {
                int indexOfAny$default = StringsKt.indexOfAny$default((CharSequence) s, SPECIAL_CHARACTERS, i, false, 4, (Object) null);
                if (indexOfAny$default == -1) {
                    indexOfAny$default = s.length();
                }
                List<String> list2 = this.segments;
                int size2 = list2.size() - 1;
                StringBuilder sb = new StringBuilder();
                sb.append(list2.get(size2));
                String substring = s.substring(i, indexOfAny$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb.append(substring);
                list2.set(size2, sb.toString());
                i = indexOfAny$default;
            }
            i++;
        }
    }

    public final void appendNonWrapping(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        if (!(!this.closed)) {
            throw new IllegalStateException(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_CLOSED.toString());
        }
        if (!(!StringsKt.contains$default((CharSequence) s, (CharSequence) "\n", false, 2, (Object) null))) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        List<String> list = this.segments;
        int size = list.size() - 1;
        list.set(size, list.get(size) + s);
    }

    public final void newline() {
        if (!(!this.closed)) {
            throw new IllegalStateException(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_CLOSED.toString());
        }
        emitCurrentLine();
        this.out.append("\n");
        this.indentLevel = -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        emitCurrentLine();
        this.closed = true;
    }

    private final void emitCurrentLine() {
        foldUnsafeBreaks();
        int i = 0;
        int length = this.segments.get(0).length();
        int size = this.segments.size();
        for (int i2 = 1; i2 < size; i2++) {
            String str = this.segments.get(i2);
            length = length + 1 + str.length();
            if (length > this.columnLimit) {
                emitSegmentRange(i, i2);
                length = str.length() + (this.indent.length() * this.indentLevel);
                i = i2;
            }
        }
        emitSegmentRange(i, this.segments.size());
        this.segments.clear();
        this.segments.add("");
    }

    private final void emitSegmentRange(int startIndex, int endIndex) {
        if (startIndex > 0) {
            this.out.append("\n");
            int i = this.indentLevel;
            for (int i2 = 0; i2 < i; i2++) {
                this.out.append(this.indent);
            }
            this.out.append(this.linePrefix);
        }
        this.out.append(this.segments.get(startIndex));
        while (true) {
            startIndex++;
            if (startIndex >= endIndex) {
                return;
            }
            this.out.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            this.out.append(this.segments.get(startIndex));
        }
    }

    private final void foldUnsafeBreaks() {
        int i = 1;
        while (i < this.segments.size()) {
            if (UNSAFE_LINE_START.matches(this.segments.get(i))) {
                int i2 = i - 1;
                this.segments.set(i2, this.segments.get(i2) + ' ' + this.segments.get(i));
                this.segments.remove(i);
                if (i > 1) {
                    i--;
                }
            } else {
                i++;
            }
        }
    }

    static {
        char[] charArray = " \n·".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        SPECIAL_CHARACTERS = charArray;
    }
}
