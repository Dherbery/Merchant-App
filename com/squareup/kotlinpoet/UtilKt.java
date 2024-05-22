package com.squareup.kotlinpoet;

import androidx.exifinterface.media.ExifInterface;
import com.amazon.a.a.o.b;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.squareup.kotlinpoet.CodeBlock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.io.IOUtils;

/* compiled from: Util.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0004\u001a\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0000\u001a/\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00052\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u001c\"\u00020\u001aH\u0000¢\u0006\u0002\u0010\u001d\u001a/\u0010\u001e\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00052\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u001c\"\u00020\u001aH\u0000¢\u0006\u0002\u0010\u001d\u001a$\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\b\b\u0002\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\nH\u0000\u001a\f\u0010$\u001a\u00020\n*\u00020\u0007H\u0002\u001a1\u0010%\u001a\u00020\n\"\u0004\b\u0000\u0010&*\b\u0012\u0004\u0012\u0002H&0'2\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u0002H&0\u001c\"\u0002H&H\u0000¢\u0006\u0002\u0010)\u001a\f\u0010*\u001a\u00020+*\u00020+H\u0000\u001a\f\u0010,\u001a\u00020\u0007*\u00020\u0007H\u0002\u001a\f\u0010-\u001a\u00020\u0007*\u00020\u0007H\u0002\u001a\f\u0010.\u001a\u00020\u0007*\u00020\u0007H\u0002\u001a\u0016\u0010/\u001a\u00020\u0007*\u00020\u00072\b\b\u0002\u00100\u001a\u00020\nH\u0000\u001a\f\u00101\u001a\u00020\u0007*\u00020\u0007H\u0002\u001a\u0016\u00102\u001a\u00020\u0007*\u00020\u00072\b\b\u0002\u00103\u001a\u00020\u0001H\u0000\u001a\f\u00104\u001a\u00020\u0018*\u00020\u0007H\u0002\u001aW\u00105\u001a\u00020\n\"\u0004\b\u0000\u0010&*\u0002H&2\u0006\u00106\u001a\u0002H&2\u0006\u00107\u001a\u0002H&2\n\b\u0002\u00108\u001a\u0004\u0018\u0001H&2\n\b\u0002\u00109\u001a\u0004\u0018\u0001H&2\n\b\u0002\u0010:\u001a\u0004\u0018\u0001H&2\n\b\u0002\u0010;\u001a\u0004\u0018\u0001H&H\u0000¢\u0006\u0002\u0010<\u001a+\u0010=\u001a\b\u0012\u0004\u0012\u0002H&0\u0005\"\u0010\b\u0000\u0010&\u0018\u0001*\b\u0012\u0004\u0012\u0002H&0>*\b\u0012\u0004\u0012\u0002H&0'H\u0080\b\u001a\u001e\u0010?\u001a\b\u0012\u0004\u0012\u0002H&0@\"\u0004\b\u0000\u0010&*\b\u0012\u0004\u0012\u0002H&0'H\u0000\u001a0\u0010A\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u0002HD0B\"\u0004\b\u0000\u0010C\"\u0004\b\u0001\u0010D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u0002HD0BH\u0000\u001a\u001e\u0010E\u001a\b\u0012\u0004\u0012\u0002H&0\u0005\"\u0004\b\u0000\u0010&*\b\u0012\u0004\u0012\u0002H&0'H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\t\u001a\u00020\n*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0018\u0010\r\u001a\u00020\n*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f\"\u0018\u0010\u000f\u001a\u00020\n*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f\"\u0018\u0010\u0010\u001a\u00020\n*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0012\u001a\u00020\n*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\f¨\u0006F"}, d2 = {"ALLOWED_CHARACTER", "", "IDENTIFIER_REGEX", "Lkotlin/text/Regex;", "ILLEGAL_CHARACTERS_TO_ESCAPE", "", "KEYWORDS", "", "UNDERSCORE_CHARACTER", "allCharactersAreUnderscore", "", "getAllCharactersAreUnderscore", "(Ljava/lang/String;)Z", "hasAllowedCharacters", "getHasAllowedCharacters", "isIdentifier", "isIsoControl", "(C)Z", "isKeyword", "characterLiteralWithoutSingleQuotes", "c", "escapeCharacterLiterals", "s", "requireNoneOf", "", "modifiers", "Lcom/squareup/kotlinpoet/KModifier;", "forbidden", "", "(Ljava/util/Set;[Lcom/squareup/kotlinpoet/KModifier;)V", "requireNoneOrOneOf", "mutuallyExclusive", "stringLiteralWithQuotes", "value", "escapeDollarSign", "isConstantContext", "alreadyEscaped", "containsAnyOf", "T", "", "t", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "ensureEndsWithNewLine", "Lcom/squareup/kotlinpoet/CodeBlock;", "escapeIfAllCharactersAreUnderscore", "escapeIfHasAllowedCharacters", "escapeIfKeyword", "escapeIfNecessary", "validate", "escapeIfNotJavaIdentifier", "escapeSegmentsIfNecessary", TtmlNode.RUBY_DELIMITER, "failIfEscapeInvalid", "isOneOf", "t1", "t2", "t3", "t4", "t5", "t6", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "toEnumSet", "", "toImmutableList", "", "toImmutableMap", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "toImmutableSet", "kotlinpoet"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class UtilKt {
    private static final char ALLOWED_CHARACTER = '$';
    private static final char UNDERSCORE_CHARACTER = '_';
    private static final Regex IDENTIFIER_REGEX = new Regex("((\\p{gc=Lu}+|\\p{gc=Ll}+|\\p{gc=Lt}+|\\p{gc=Lm}+|\\p{gc=Lo}+|\\p{gc=Nl}+)+\\d*\\p{gc=Lu}*\\p{gc=Ll}*\\p{gc=Lt}*\\p{gc=Lm}*\\p{gc=Lo}*\\p{gc=Nl}*)|(`[^\n\r`]+`)");
    private static final Set<String> KEYWORDS = SetsKt.setOf((Object[]) new String[]{"as", "break", "class", "continue", "do", "else", "false", "for", "fun", "if", "in", "interface", "is", "null", "object", "package", "return", "super", "this", "throw", b.ac, "try", "typealias", "typeof", "val", "var", "when", "while", "by", "catch", "constructor", "delegate", "dynamic", "field", "file", "finally", b.ar, "import", "init", "param", "property", "receiver", "set", "setparam", "where", "actual", "abstract", "annotation", "companion", "const", "crossinline", "data", "enum", "expect", "external", "final", "infix", "inline", "inner", "internal", "lateinit", "noinline", TtmlNode.TEXT_EMPHASIS_MARK_OPEN, "operator", "out", "override", "private", "protected", "public", "reified", "sealed", "suspend", "tailrec", "value", "vararg", "header", "impl", "yield"});
    private static final Set<Character> ILLEGAL_CHARACTERS_TO_ESCAPE = SetsKt.setOf((Object[]) new Character[]{'.', ';', Character.valueOf(AbstractJsonLexerKt.BEGIN_LIST), Character.valueOf(AbstractJsonLexerKt.END_LIST), Character.valueOf(IOUtils.DIR_SEPARATOR_UNIX), Character.valueOf(Typography.less), Character.valueOf(Typography.greater), Character.valueOf(AbstractJsonLexerKt.COLON), '\\'});

    private static final boolean isIsoControl(char c) {
        if (c >= 0 && c < ' ') {
            return true;
        }
        return 127 <= c && c < 160;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(LinkedHashMap(this))");
        return unmodifiableMap;
    }

    public static final <T> List<T> toImmutableList(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        List<T> unmodifiableList = Collections.unmodifiableList(new ArrayList(collection));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(ArrayList(this))");
        return unmodifiableList;
    }

    public static final <T> Set<T> toImmutableSet(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Set<T> unmodifiableSet = Collections.unmodifiableSet(new LinkedHashSet(collection));
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(LinkedHashSet(this))");
        return unmodifiableSet;
    }

    public static final /* synthetic */ <T extends Enum<T>> Set<T> toEnumSet(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.reifiedOperationMarker(5, "T");
        return new LinkedHashSet();
    }

    public static final <T> boolean isOneOf(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        return Intrinsics.areEqual(t, t2) || Intrinsics.areEqual(t, t3) || Intrinsics.areEqual(t, t4) || Intrinsics.areEqual(t, t5) || Intrinsics.areEqual(t, t6) || Intrinsics.areEqual(t, t7);
    }

    public static final String characterLiteralWithoutSingleQuotes(char c) {
        if (c == '\b') {
            return "\\b";
        }
        if (c == '\t') {
            return "\\t";
        }
        if (c == '\n') {
            return "\\n";
        }
        if (c == '\r') {
            return "\\r";
        }
        if (c == '\"') {
            return "\"";
        }
        if (c == '\'') {
            return "\\'";
        }
        if (c == '\\') {
            return "\\\\";
        }
        if (!isIsoControl(c)) {
            return String.valueOf(c);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(c)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public static final String escapeCharacterLiterals(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            sb.append(characterLiteralWithoutSingleQuotes(s.charAt(i)));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String stringLiteralWithQuotes$default(String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return stringLiteralWithQuotes(str, z, z2);
    }

    public static final String stringLiteralWithQuotes(String value, boolean z, boolean z2) {
        int i;
        Intrinsics.checkNotNullParameter(value, "value");
        if (!z2 && StringsKt.contains$default((CharSequence) value, '\n', false, 2, (Object) null)) {
            StringBuilder sb = new StringBuilder(value.length() + 32);
            sb.append("\"\"\"\n|");
            int i2 = 0;
            while (i2 < value.length()) {
                char charAt = value.charAt(i2);
                int i3 = i2;
                StringBuilder sb2 = sb;
                if (StringsKt.regionMatches$default(value, i2, "\"\"\"", 0, 3, false, 16, (Object) null)) {
                    sb2.append("\"\"${'\"'}");
                    i = i3 + 2;
                } else {
                    if (charAt == '\n') {
                        sb2.append("\n|");
                    } else if (charAt == '$' && z) {
                        sb2.append("${'$'}");
                    } else {
                        sb2.append(charAt);
                    }
                    i = i3;
                }
                i2 = i + 1;
                sb = sb2;
            }
            StringBuilder sb3 = sb;
            if (!StringsKt.endsWith$default(value, "\n", false, 2, (Object) null)) {
                sb3.append("\n");
            }
            sb3.append("\"\"\".trimMargin()");
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "result.toString()");
            return sb4;
        }
        StringBuilder sb5 = new StringBuilder(value.length() + 32);
        if (z) {
            sb5.append('\"');
        } else {
            sb5.append("\"\"\"");
        }
        int length = value.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt2 = value.charAt(i4);
            if (charAt2 == '\'') {
                sb5.append("'");
            } else if (charAt2 == '\"' && z) {
                sb5.append("\\\"");
            } else if (charAt2 == '$' && z) {
                sb5.append("${'$'}");
            } else {
                sb5.append(characterLiteralWithoutSingleQuotes(charAt2));
            }
        }
        if (z) {
            sb5.append('\"');
        } else {
            sb5.append("\"\"\"");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    public static final CodeBlock ensureEndsWithNewLine(CodeBlock codeBlock) {
        Intrinsics.checkNotNullParameter(codeBlock, "<this>");
        if (codeBlock.isEmpty()) {
            return codeBlock;
        }
        CodeBlock.Builder builder = codeBlock.toBuilder();
        String str = (String) CollectionsKt.last((List) codeBlock.trim$kotlinpoet().getFormatParts$kotlinpoet());
        if (CodeBlock.Companion.isPlaceholder$kotlinpoet(str) && (!builder.getArgs$kotlinpoet().isEmpty())) {
            Object last = CollectionsKt.last((List<? extends Object>) builder.getArgs$kotlinpoet());
            if (last instanceof String) {
                builder.getArgs$kotlinpoet().set(builder.getArgs$kotlinpoet().size() - 1, StringsKt.trimEnd((String) last, '\n') + '\n');
            }
        } else {
            builder.getFormatParts$kotlinpoet().set(builder.getFormatParts$kotlinpoet().lastIndexOf(str), StringsKt.trimEnd(str, '\n'));
            builder.getFormatParts$kotlinpoet().add("\n");
        }
        return builder.build();
    }

    public static final boolean isIdentifier(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return IDENTIFIER_REGEX.matches(str);
    }

    public static final boolean isKeyword(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return KEYWORDS.contains(str);
    }

    public static final boolean getHasAllowedCharacters(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = str;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == '$') {
                return true;
            }
        }
        return false;
    }

    public static final boolean getAllCharactersAreUnderscore(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = str;
        int i = 0;
        while (true) {
            if (i >= str2.length()) {
                return true;
            }
            if (!(str2.charAt(i) == '_')) {
                return false;
            }
            i++;
        }
    }

    private static final void failIfEscapeInvalid(String str) {
        String str2 = str;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= str2.length()) {
                break;
            }
            if (ILLEGAL_CHARACTERS_TO_ESCAPE.contains(Character.valueOf(str2.charAt(i)))) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return;
        }
        throw new IllegalArgumentException(("Can't escape identifier " + str + " because it contains illegal characters: " + CollectionsKt.joinToString$default(CollectionsKt.intersect(ILLEGAL_CHARACTERS_TO_ESCAPE, StringsKt.toSet(str2)), "", null, null, 0, null, null, 62, null)).toString());
    }

    public static final String escapeIfNecessary(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String escapeIfAllCharactersAreUnderscore = escapeIfAllCharactersAreUnderscore(escapeIfHasAllowedCharacters(escapeIfKeyword(escapeIfNotJavaIdentifier(str))));
        if (z) {
            failIfEscapeInvalid(escapeIfAllCharactersAreUnderscore);
        }
        return escapeIfAllCharactersAreUnderscore;
    }

    public static /* synthetic */ String escapeIfNecessary$default(String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return escapeIfNecessary(str, z);
    }

    private static final boolean alreadyEscaped(String str) {
        return StringsKt.startsWith$default(str, "`", false, 2, (Object) null) && StringsKt.endsWith$default(str, "`", false, 2, (Object) null);
    }

    private static final String escapeIfKeyword(String str) {
        if (!isKeyword(str) || alreadyEscaped(str)) {
            return str;
        }
        return "`" + str + '`';
    }

    private static final String escapeIfHasAllowedCharacters(String str) {
        if (!getHasAllowedCharacters(str) || alreadyEscaped(str)) {
            return str;
        }
        return "`" + str + '`';
    }

    private static final String escapeIfAllCharactersAreUnderscore(String str) {
        if (!getAllCharactersAreUnderscore(str) || alreadyEscaped(str)) {
            return str;
        }
        return "`" + str + '`';
    }

    private static final String escapeIfNotJavaIdentifier(String str) {
        if (Character.isJavaIdentifierStart(StringsKt.first(str))) {
            boolean z = true;
            String drop = StringsKt.drop(str, 1);
            int i = 0;
            while (true) {
                if (i >= drop.length()) {
                    z = false;
                    break;
                }
                if (!Character.isJavaIdentifierPart(drop.charAt(i))) {
                    break;
                }
                i++;
            }
            if (!z) {
                return str;
            }
        }
        if (alreadyEscaped(str)) {
            return str;
        }
        return StringsKt.replace$default("`" + str + '`', ' ', Typography.middleDot, false, 4, (Object) null);
    }

    public static final String escapeSegmentsIfNecessary(String str, char c) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        List split$default = StringsKt.split$default((CharSequence) str, new char[]{c}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, String.valueOf(c), null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.squareup.kotlinpoet.UtilKt$escapeSegmentsIfNecessary$2
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return UtilKt.escapeIfNecessary$default(it, false, 1, null);
            }
        }, 30, null);
    }

    public static /* synthetic */ String escapeSegmentsIfNecessary$default(String str, char c, int i, Object obj) {
        if ((i & 1) != 0) {
            c = '.';
        }
        return escapeSegmentsIfNecessary(str, c);
    }

    public static final void requireNoneOrOneOf(Set<? extends KModifier> modifiers, KModifier... mutuallyExclusive) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        Intrinsics.checkNotNullParameter(mutuallyExclusive, "mutuallyExclusive");
        int i = 0;
        for (KModifier kModifier : mutuallyExclusive) {
            if (modifiers.contains(kModifier)) {
                i++;
            }
        }
        if (i <= 1) {
            return;
        }
        StringBuilder sb = new StringBuilder("modifiers ");
        sb.append(modifiers);
        sb.append(" must contain none or only one of ");
        String arrays = Arrays.toString(mutuallyExclusive);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb.append(arrays);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public static final void requireNoneOf(Set<? extends KModifier> modifiers, KModifier... forbidden) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        Intrinsics.checkNotNullParameter(forbidden, "forbidden");
        int length = forbidden.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            } else if (modifiers.contains(forbidden[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        StringBuilder sb = new StringBuilder("modifiers ");
        sb.append(modifiers);
        sb.append(" must contain none of ");
        String arrays = Arrays.toString(forbidden);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb.append(arrays);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public static final <T> boolean containsAnyOf(Collection<? extends T> collection, T... t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(t, "t");
        for (T t2 : t) {
            if (collection.contains(t2)) {
                return true;
            }
        }
        return false;
    }
}
