package expo.modules.kotlin.objects;

import com.amazon.a.a.o.b;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.EventsDefinition;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.FunctionBuilder;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: ObjectDefinitionBuilder.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0005J,\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u00012\u0006\u0010(\u001a\u00020\u00052\u000e\b\u0004\u0010*\u001a\b\u0012\u0004\u0012\u0002H)0\u000fH\u0086\bø\u0001\u0000J+\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00052\u0010\b\u0004\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH\u0087\bø\u0001\u0000¢\u0006\u0002\b+JI\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u00012\u0006\u0010(\u001a\u00020\u00052#\b\u0004\u0010*\u001a\u001d\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0004\u0012\u0002H)0-H\u0086\bø\u0001\u0000Jf\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u00012\u0006\u0010(\u001a\u00020\u000528\b\u0004\u0010*\u001a2\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0004\u0012\u0002H)01H\u0086\bø\u0001\u0000J\u0083\u0001\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u00012\u0006\u0010(\u001a\u00020\u00052M\b\u0004\u0010*\u001aG\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0004\u0012\u0002H)04H\u0086\bø\u0001\u0000J \u0001\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u00012\u0006\u0010(\u001a\u00020\u00052b\b\u0004\u0010*\u001a\\\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0004\u0012\u0002H)07H\u0086\bø\u0001\u0000J½\u0001\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u00012\u0006\u0010(\u001a\u00020\u00052w\b\u0004\u0010*\u001aq\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0004\u0012\u0002H)0:H\u0086\bø\u0001\u0000JÜ\u0001\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u0001\"\u0006\b\u0006\u0010<\u0018\u00012\u0006\u0010(\u001a\u00020\u00052\u008d\u0001\b\u0004\u0010*\u001a\u0086\u0001\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002H)0=H\u0086\bø\u0001\u0000Jù\u0001\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u0001\"\u0006\b\u0006\u0010<\u0018\u0001\"\u0006\b\u0007\u0010?\u0018\u00012\u0006\u0010(\u001a\u00020\u00052¢\u0001\b\u0004\u0010*\u001a\u009b\u0001\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(A\u0012\u0004\u0012\u0002H)0@H\u0086\bø\u0001\u0000J\u0096\u0002\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u0001\"\u0006\b\u0006\u0010<\u0018\u0001\"\u0006\b\u0007\u0010?\u0018\u0001\"\u0006\b\b\u0010B\u0018\u00012\u0006\u0010(\u001a\u00020\u00052·\u0001\b\u0004\u0010*\u001a°\u0001\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002H)0CH\u0086\bø\u0001\u0000J\"\u0010E\u001a\u00020F2\u001a\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00100\u000fJ;\u0010E\u001a\u00020F2.\u0010G\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010I0H\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010I¢\u0006\u0002\u0010JJ\u001f\u0010K\u001a\u00020F\"\u0014\b\u0000\u0010L\u0018\u0001*\u00020M*\b\u0012\u0004\u0012\u0002HL0NH\u0086\bJ\u001d\u0010K\u001a\u00020F2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00050HH\u0007¢\u0006\u0004\bP\u0010QJ\u001f\u0010K\u001a\u00020F2\u0012\u0010O\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050H\"\u00020\u0005¢\u0006\u0002\u0010QJ\u000e\u0010R\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u0005J,\u0010R\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u00012\u0006\u0010(\u001a\u00020\u00052\u000e\b\u0004\u0010*\u001a\b\u0012\u0004\u0012\u0002H)0\u000fH\u0086\bø\u0001\u0000J+\u0010R\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00052\u0010\b\u0004\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH\u0087\bø\u0001\u0000¢\u0006\u0002\bSJI\u0010R\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u00012\u0006\u0010(\u001a\u00020\u00052#\b\u0004\u0010*\u001a\u001d\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0004\u0012\u0002H)0-H\u0086\bø\u0001\u0000Jf\u0010R\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u00012\u0006\u0010(\u001a\u00020\u000528\b\u0004\u0010*\u001a2\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0004\u0012\u0002H)01H\u0086\bø\u0001\u0000J\u0083\u0001\u0010R\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u00012\u0006\u0010(\u001a\u00020\u00052M\b\u0004\u0010*\u001aG\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0004\u0012\u0002H)04H\u0086\bø\u0001\u0000J \u0001\u0010R\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u00012\u0006\u0010(\u001a\u00020\u00052b\b\u0004\u0010*\u001a\\\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0004\u0012\u0002H)07H\u0086\bø\u0001\u0000J½\u0001\u0010R\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u00012\u0006\u0010(\u001a\u00020\u00052w\b\u0004\u0010*\u001aq\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0004\u0012\u0002H)0:H\u0086\bø\u0001\u0000JÜ\u0001\u0010R\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u0001\"\u0006\b\u0006\u0010<\u0018\u00012\u0006\u0010(\u001a\u00020\u00052\u008d\u0001\b\u0004\u0010*\u001a\u0086\u0001\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002H)0=H\u0086\bø\u0001\u0000Jù\u0001\u0010R\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u0001\"\u0006\b\u0006\u0010<\u0018\u0001\"\u0006\b\u0007\u0010?\u0018\u00012\u0006\u0010(\u001a\u00020\u00052¢\u0001\b\u0004\u0010*\u001a\u009b\u0001\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(A\u0012\u0004\u0012\u0002H)0@H\u0086\bø\u0001\u0000J\u0096\u0002\u0010R\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u0001\"\u0006\b\u0006\u0010<\u0018\u0001\"\u0006\b\u0007\u0010?\u0018\u0001\"\u0006\b\b\u0010B\u0018\u00012\u0006\u0010(\u001a\u00020\u00052·\u0001\b\u0004\u0010*\u001a°\u0001\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002H)0CH\u0086\bø\u0001\u0000J\u001c\u0010T\u001a\u00020F2\u000e\b\u0004\u0010*\u001a\b\u0012\u0004\u0012\u00020F0\u000fH\u0086\bø\u0001\u0000J\u001c\u0010U\u001a\u00020F2\u000e\b\u0004\u0010*\u001a\b\u0012\u0004\u0012\u00020F0\u000fH\u0086\bø\u0001\u0000J\u0010\u0010V\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0005H\u0016J*\u0010V\u001a\u00020\u0019\"\u0004\b\u0000\u0010L2\u0006\u0010(\u001a\u00020\u00052\u000e\b\u0004\u0010*\u001a\b\u0012\u0004\u0012\u0002HL0\u000fH\u0086\bø\u0001\u0000J\u0006\u0010W\u001a\u00020XJ\u0010\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R0\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR0\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR0\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020#0\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u0002\u001a\u0004\b%\u0010\u000b\"\u0004\b&\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\\"}, d2 = {"Lexpo/modules/kotlin/objects/ObjectDefinitionBuilder;", "", "()V", "asyncFunctionBuilders", "", "", "Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;", "asyncFunctions", "Lexpo/modules/kotlin/functions/AsyncFunction;", "getAsyncFunctions$annotations", "getAsyncFunctions", "()Ljava/util/Map;", "setAsyncFunctions", "(Ljava/util/Map;)V", "constantsProvider", "Lkotlin/Function0;", "", "eventsDefinition", "Lexpo/modules/kotlin/events/EventsDefinition;", "getEventsDefinition$annotations", "getEventsDefinition", "()Lexpo/modules/kotlin/events/EventsDefinition;", "setEventsDefinition", "(Lexpo/modules/kotlin/events/EventsDefinition;)V", DiagnosticsEntry.Event.PROPERTIES_KEY, "Lexpo/modules/kotlin/objects/PropertyComponentBuilder;", "getProperties$annotations", "getProperties", "setProperties", "syncFunctionBuilder", "Lexpo/modules/kotlin/functions/FunctionBuilder;", "getSyncFunctionBuilder$annotations", "getSyncFunctionBuilder", "setSyncFunctionBuilder", "syncFunctions", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getSyncFunctions$annotations", "getSyncFunctions", "setSyncFunctions", "AsyncFunction", "name", "R", TtmlNode.TAG_BODY, "AsyncFunctionWithoutArgs", "P0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "Constants", "", "constants", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "Events", "T", "Lexpo/modules/kotlin/types/Enumerable;", "", "events", "EventsWithArray", "([Ljava/lang/String;)V", "Function", "FunctionWithoutArgs", "OnStartObserving", "OnStopObserving", "Property", "buildObject", "Lexpo/modules/kotlin/objects/ObjectDefinitionData;", "containsFunction", "", "functionName", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ObjectDefinitionBuilder {
    private EventsDefinition eventsDefinition;
    private Function0<? extends Map<String, ? extends Object>> constantsProvider = new Function0<Map<String, ? extends Object>>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$constantsProvider$1
        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends Object> invoke() {
            return MapsKt.emptyMap();
        }
    };
    private Map<String, SyncFunctionComponent> syncFunctions = new LinkedHashMap();
    private Map<String, FunctionBuilder> syncFunctionBuilder = new LinkedHashMap();
    private Map<String, AsyncFunction> asyncFunctions = new LinkedHashMap();
    private Map<String, AsyncFunctionBuilder> asyncFunctionBuilders = new LinkedHashMap();
    private Map<String, PropertyComponentBuilder> properties = new LinkedHashMap();

    public static /* synthetic */ void getAsyncFunctions$annotations() {
    }

    public static /* synthetic */ void getEventsDefinition$annotations() {
    }

    public static /* synthetic */ void getProperties$annotations() {
    }

    public static /* synthetic */ void getSyncFunctionBuilder$annotations() {
    }

    public static /* synthetic */ void getSyncFunctions$annotations() {
    }

    public final EventsDefinition getEventsDefinition() {
        return this.eventsDefinition;
    }

    public final void setEventsDefinition(EventsDefinition eventsDefinition) {
        this.eventsDefinition = eventsDefinition;
    }

    public final Map<String, SyncFunctionComponent> getSyncFunctions() {
        return this.syncFunctions;
    }

    public final void setSyncFunctions(Map<String, SyncFunctionComponent> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.syncFunctions = map;
    }

    public final Map<String, FunctionBuilder> getSyncFunctionBuilder() {
        return this.syncFunctionBuilder;
    }

    public final void setSyncFunctionBuilder(Map<String, FunctionBuilder> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.syncFunctionBuilder = map;
    }

    public final Map<String, AsyncFunction> getAsyncFunctions() {
        return this.asyncFunctions;
    }

    public final void setAsyncFunctions(Map<String, AsyncFunction> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.asyncFunctions = map;
    }

    public final Map<String, PropertyComponentBuilder> getProperties() {
        return this.properties;
    }

    public final void setProperties(Map<String, PropertyComponentBuilder> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.properties = map;
    }

    public final ObjectDefinitionData buildObject() {
        if (this.eventsDefinition != null) {
            if (!containsFunction("addListener")) {
                getSyncFunctions().put("addListener", new SyncFunctionComponent("addListener", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$buildObject$lambda$2$$inlined$Function$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$buildObject$lambda$2$$inlined$Function$2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        return new Function0<Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$buildObject$1$1$1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }));
            }
            if (!containsFunction("removeListeners")) {
                getSyncFunctions().put("removeListeners", new SyncFunctionComponent("removeListeners", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$buildObject$lambda$2$$inlined$Function$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$buildObject$lambda$2$$inlined$Function$4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                        }
                        ((Integer) obj).intValue();
                        return new Function0<Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$buildObject$1$2$1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }));
            }
        }
        Function0<? extends Map<String, ? extends Object>> function0 = this.constantsProvider;
        Map<String, SyncFunctionComponent> map = this.syncFunctions;
        Map<String, FunctionBuilder> map2 = this.syncFunctionBuilder;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
        Iterator<T> it = map2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((FunctionBuilder) entry.getValue()).build$expo_modules_core_release());
        }
        Map plus = MapsKt.plus(map, linkedHashMap);
        Map<String, AsyncFunction> map3 = this.asyncFunctions;
        Map<String, AsyncFunctionBuilder> map4 = this.asyncFunctionBuilders;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map4.size()));
        Iterator<T> it2 = map4.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            linkedHashMap2.put(entry2.getKey(), ((AsyncFunctionBuilder) entry2.getValue()).build$expo_modules_core_release());
        }
        Map plus2 = MapsKt.plus(map3, linkedHashMap2);
        EventsDefinition eventsDefinition = this.eventsDefinition;
        Map<String, PropertyComponentBuilder> map5 = this.properties;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(map5.size()));
        Iterator<T> it3 = map5.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            linkedHashMap3.put(entry3.getKey(), ((PropertyComponentBuilder) entry3.getValue()).build());
        }
        return new ObjectDefinitionData(function0, plus, plus2, eventsDefinition, linkedHashMap3);
    }

    private final boolean containsFunction(String functionName) {
        return this.syncFunctions.containsKey(functionName) || this.asyncFunctions.containsKey(functionName) || this.asyncFunctionBuilders.containsKey(functionName);
    }

    public final void Constants(Function0<? extends Map<String, ? extends Object>> constantsProvider) {
        Intrinsics.checkNotNullParameter(constantsProvider, "constantsProvider");
        this.constantsProvider = constantsProvider;
    }

    public final void Constants(final Pair<String, ? extends Object>... constants) {
        Intrinsics.checkNotNullParameter(constants, "constants");
        this.constantsProvider = new Function0<Map<String, ? extends Object>>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Constants$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends Object> invoke() {
                return MapsKt.toMap(constants);
            }
        };
    }

    public final FunctionBuilder Function(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        FunctionBuilder functionBuilder = new FunctionBuilder(name);
        this.syncFunctionBuilder.put(name, functionBuilder);
        return functionBuilder;
    }

    public final SyncFunctionComponent FunctionWithoutArgs(String name, final Function0<? extends Object> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R> SyncFunctionComponent Function(String name, final Function0<? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> SyncFunctionComponent Function(String name, final Function1<? super P0, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$6 objectDefinitionBuilder$Function$6 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$6
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$Function$6))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<P0, R> function1 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                return function1.invoke(obj);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1> SyncFunctionComponent Function(String name, final Function2<? super P0, ? super P1, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$9 objectDefinitionBuilder$Function$9 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$9
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$10 objectDefinitionBuilder$Function$10 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$10
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$Function$9)), new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$Function$10))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function2<P0, P1, R> function2 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                return function2.invoke(obj, obj2);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> SyncFunctionComponent Function(String name, final Function3<? super P0, ? super P1, ? super P2, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$13 objectDefinitionBuilder$Function$13 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$13
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$14 objectDefinitionBuilder$Function$14 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$14
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$15 objectDefinitionBuilder$Function$15 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$15
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P2");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$Function$13)), new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$Function$14)), new AnyType(new LazyKType(orCreateKotlinClass3, false, objectDefinitionBuilder$Function$15))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function3<P0, P1, P2, R> function3 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                Object obj3 = it[2];
                Intrinsics.reifiedOperationMarker(1, "P2");
                return function3.invoke(obj, obj2, obj3);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> SyncFunctionComponent Function(String name, final Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$18 objectDefinitionBuilder$Function$18 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$18
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$19 objectDefinitionBuilder$Function$19 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$19
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$20 objectDefinitionBuilder$Function$20 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$20
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P2");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$21 objectDefinitionBuilder$Function$21 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$21
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P3");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$Function$18)), new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$Function$19)), new AnyType(new LazyKType(orCreateKotlinClass3, false, objectDefinitionBuilder$Function$20)), new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$Function$21))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$22
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function4<P0, P1, P2, P3, R> function4 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                Object obj3 = it[2];
                Intrinsics.reifiedOperationMarker(1, "P2");
                Object obj4 = it[3];
                Intrinsics.reifiedOperationMarker(1, "P3");
                return function4.invoke(obj, obj2, obj3, obj4);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> SyncFunctionComponent Function(String name, final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$24 objectDefinitionBuilder$Function$24 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$24
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$25 objectDefinitionBuilder$Function$25 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$25
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$26 objectDefinitionBuilder$Function$26 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$26
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P2");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$27 objectDefinitionBuilder$Function$27 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$27
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P3");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$28 objectDefinitionBuilder$Function$28 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$28
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P4");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$Function$24)), new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$Function$25)), new AnyType(new LazyKType(orCreateKotlinClass3, false, objectDefinitionBuilder$Function$26)), new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$Function$27)), new AnyType(new LazyKType(orCreateKotlinClass5, false, objectDefinitionBuilder$Function$28))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$29
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function5<P0, P1, P2, P3, P4, R> function5 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                Object obj3 = it[2];
                Intrinsics.reifiedOperationMarker(1, "P2");
                Object obj4 = it[3];
                Intrinsics.reifiedOperationMarker(1, "P3");
                Object obj5 = it[4];
                Intrinsics.reifiedOperationMarker(1, "P4");
                return function5.invoke(obj, obj2, obj3, obj4, obj5);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> SyncFunctionComponent Function(String name, final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$31 objectDefinitionBuilder$Function$31 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$31
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$32 objectDefinitionBuilder$Function$32 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$32
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$33 objectDefinitionBuilder$Function$33 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$33
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P2");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$34 objectDefinitionBuilder$Function$34 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$34
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P3");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$35 objectDefinitionBuilder$Function$35 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$35
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P4");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$36 objectDefinitionBuilder$Function$36 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$36
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P5");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$Function$31)), new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$Function$32)), new AnyType(new LazyKType(orCreateKotlinClass3, false, objectDefinitionBuilder$Function$33)), new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$Function$34)), new AnyType(new LazyKType(orCreateKotlinClass5, false, objectDefinitionBuilder$Function$35)), new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$Function$36))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$37
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function6<P0, P1, P2, P3, P4, P5, R> function6 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                Object obj3 = it[2];
                Intrinsics.reifiedOperationMarker(1, "P2");
                Object obj4 = it[3];
                Intrinsics.reifiedOperationMarker(1, "P3");
                Object obj5 = it[4];
                Intrinsics.reifiedOperationMarker(1, "P4");
                Object obj6 = it[5];
                Intrinsics.reifiedOperationMarker(1, "P5");
                return function6.invoke(obj, obj2, obj3, obj4, obj5, obj6);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> SyncFunctionComponent Function(String name, final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$39 objectDefinitionBuilder$Function$39 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$39
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$40 objectDefinitionBuilder$Function$40 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$40
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$41 objectDefinitionBuilder$Function$41 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$41
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P2");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$42 objectDefinitionBuilder$Function$42 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$42
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P3");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$43 objectDefinitionBuilder$Function$43 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$43
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P4");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$44 objectDefinitionBuilder$Function$44 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$44
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P5");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$45 objectDefinitionBuilder$Function$45 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$45
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P6");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$Function$39)), new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$Function$40)), new AnyType(new LazyKType(orCreateKotlinClass3, false, objectDefinitionBuilder$Function$41)), new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$Function$42)), new AnyType(new LazyKType(orCreateKotlinClass5, false, objectDefinitionBuilder$Function$43)), new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$Function$44)), new AnyType(new LazyKType(orCreateKotlinClass7, false, objectDefinitionBuilder$Function$45))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$46
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function7<P0, P1, P2, P3, P4, P5, P6, R> function7 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                Object obj3 = it[2];
                Intrinsics.reifiedOperationMarker(1, "P2");
                Object obj4 = it[3];
                Intrinsics.reifiedOperationMarker(1, "P3");
                Object obj5 = it[4];
                Intrinsics.reifiedOperationMarker(1, "P4");
                Object obj6 = it[5];
                Intrinsics.reifiedOperationMarker(1, "P5");
                Object obj7 = it[6];
                Intrinsics.reifiedOperationMarker(1, "P6");
                return function7.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> SyncFunctionComponent Function(String name, final Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$48 objectDefinitionBuilder$Function$48 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$48
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$49 objectDefinitionBuilder$Function$49 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$49
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$50 objectDefinitionBuilder$Function$50 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$50
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P2");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$51 objectDefinitionBuilder$Function$51 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$51
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P3");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$52 objectDefinitionBuilder$Function$52 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$52
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P4");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$53 objectDefinitionBuilder$Function$53 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$53
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P5");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$54 objectDefinitionBuilder$Function$54 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$54
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P6");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        Intrinsics.needClassReification();
        ObjectDefinitionBuilder$Function$55 objectDefinitionBuilder$Function$55 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$55
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P7");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$Function$48)), new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$Function$49)), new AnyType(new LazyKType(orCreateKotlinClass3, false, objectDefinitionBuilder$Function$50)), new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$Function$51)), new AnyType(new LazyKType(orCreateKotlinClass5, false, objectDefinitionBuilder$Function$52)), new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$Function$53)), new AnyType(new LazyKType(orCreateKotlinClass7, false, objectDefinitionBuilder$Function$54)), new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$Function$55))};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$56
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function8<P0, P1, P2, P3, P4, P5, P6, P7, R> function8 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, "P0");
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, "P1");
                Object obj3 = it[2];
                Intrinsics.reifiedOperationMarker(1, "P2");
                Object obj4 = it[3];
                Intrinsics.reifiedOperationMarker(1, "P3");
                Object obj5 = it[4];
                Intrinsics.reifiedOperationMarker(1, "P4");
                Object obj6 = it[5];
                Intrinsics.reifiedOperationMarker(1, "P5");
                Object obj7 = it[6];
                Intrinsics.reifiedOperationMarker(1, "P6");
                Object obj8 = it[7];
                Intrinsics.reifiedOperationMarker(1, "P7");
                return function8.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final AsyncFunction AsyncFunctionWithoutArgs(String name, Function0<? extends Object> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent(name, new AnyType[0], new ObjectDefinitionBuilder$AsyncFunction$1(body));
        getAsyncFunctions().put(name, asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R> AsyncFunction AsyncFunction(String name, final Function0<? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent(name, new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        });
        getAsyncFunctions().put(name, asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> AsyncFunction AsyncFunction(String name, final Function1<? super P0, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P0");
        if (Object.class == Promise.class) {
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Function1<P0, R> function1 = body;
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    function1.invoke(promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
        } else {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$6 objectDefinitionBuilder$AsyncFunction$6 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$AsyncFunction$6))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Function1<P0, R> function1 = body;
                    Object obj = it[0];
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    return function1.invoke(obj);
                }
            });
        }
        getAsyncFunctions().put(name, asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1> AsyncFunction AsyncFunction(String name, final Function2<? super P0, ? super P1, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P1");
        if (Object.class == Promise.class) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$9 objectDefinitionBuilder$AsyncFunction$9 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$AsyncFunction$9))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$10
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Function2<P0, P1, R> function2 = body;
                    Object obj = args[0];
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    Intrinsics.reifiedOperationMarker(1, "P1");
                    function2.invoke(obj, promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
        } else {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$11 objectDefinitionBuilder$AsyncFunction$11 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$12 objectDefinitionBuilder$AsyncFunction$12 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$11)), new AnyType(new LazyKType(orCreateKotlinClass3, false, objectDefinitionBuilder$AsyncFunction$12))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$13
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Function2<P0, P1, R> function2 = body;
                    Object obj = it[0];
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    Object obj2 = it[1];
                    Intrinsics.reifiedOperationMarker(1, "P1");
                    return function2.invoke(obj, obj2);
                }
            });
        }
        getAsyncFunctions().put(name, asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> AsyncFunction AsyncFunction(String name, final Function3<? super P0, ? super P1, ? super P2, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P2");
        if (Object.class == Promise.class) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$15 objectDefinitionBuilder$AsyncFunction$15 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$16 objectDefinitionBuilder$AsyncFunction$16 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$AsyncFunction$15)), new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$16))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$17
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Function3<P0, P1, P2, R> function3 = body;
                    Object obj = args[0];
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    Object obj2 = args[1];
                    Intrinsics.reifiedOperationMarker(1, "P1");
                    Intrinsics.reifiedOperationMarker(1, "P2");
                    function3.invoke(obj, obj2, promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
        } else {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$18 objectDefinitionBuilder$AsyncFunction$18 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$19 objectDefinitionBuilder$AsyncFunction$19 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$20 objectDefinitionBuilder$AsyncFunction$20 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass3, false, objectDefinitionBuilder$AsyncFunction$18)), new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$19)), new AnyType(new LazyKType(orCreateKotlinClass5, false, objectDefinitionBuilder$AsyncFunction$20))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$21
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Function3<P0, P1, P2, R> function3 = body;
                    Object obj = it[0];
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    Object obj2 = it[1];
                    Intrinsics.reifiedOperationMarker(1, "P1");
                    Object obj3 = it[2];
                    Intrinsics.reifiedOperationMarker(1, "P2");
                    return function3.invoke(obj, obj2, obj3);
                }
            });
        }
        getAsyncFunctions().put(name, asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> AsyncFunction AsyncFunction(String name, final Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P3");
        if (Object.class == Promise.class) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$23 objectDefinitionBuilder$AsyncFunction$23 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$24 objectDefinitionBuilder$AsyncFunction$24 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$25 objectDefinitionBuilder$AsyncFunction$25 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$25
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$AsyncFunction$23)), new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$24)), new AnyType(new LazyKType(orCreateKotlinClass3, false, objectDefinitionBuilder$AsyncFunction$25))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$26
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Function4<P0, P1, P2, P3, R> function4 = body;
                    Object obj = args[0];
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    Object obj2 = args[1];
                    Intrinsics.reifiedOperationMarker(1, "P1");
                    Object obj3 = args[2];
                    Intrinsics.reifiedOperationMarker(1, "P2");
                    Intrinsics.reifiedOperationMarker(1, "P3");
                    function4.invoke(obj, obj2, obj3, promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
        } else {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$27 objectDefinitionBuilder$AsyncFunction$27 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$27
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$28 objectDefinitionBuilder$AsyncFunction$28 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$28
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$29 objectDefinitionBuilder$AsyncFunction$29 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$29
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$30 objectDefinitionBuilder$AsyncFunction$30 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$27)), new AnyType(new LazyKType(orCreateKotlinClass5, false, objectDefinitionBuilder$AsyncFunction$28)), new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$29)), new AnyType(new LazyKType(orCreateKotlinClass7, false, objectDefinitionBuilder$AsyncFunction$30))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$31
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Function4<P0, P1, P2, P3, R> function4 = body;
                    Object obj = it[0];
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    Object obj2 = it[1];
                    Intrinsics.reifiedOperationMarker(1, "P1");
                    Object obj3 = it[2];
                    Intrinsics.reifiedOperationMarker(1, "P2");
                    Object obj4 = it[3];
                    Intrinsics.reifiedOperationMarker(1, "P3");
                    return function4.invoke(obj, obj2, obj3, obj4);
                }
            });
        }
        getAsyncFunctions().put(name, asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> AsyncFunction AsyncFunction(String name, final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P4");
        if (Object.class == Promise.class) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$33 objectDefinitionBuilder$AsyncFunction$33 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$33
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$34 objectDefinitionBuilder$AsyncFunction$34 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$34
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$35 objectDefinitionBuilder$AsyncFunction$35 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$35
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$36 objectDefinitionBuilder$AsyncFunction$36 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$AsyncFunction$33)), new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$34)), new AnyType(new LazyKType(orCreateKotlinClass3, false, objectDefinitionBuilder$AsyncFunction$35)), new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$36))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$37
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Function5<P0, P1, P2, P3, P4, R> function5 = body;
                    Object obj = args[0];
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    Object obj2 = args[1];
                    Intrinsics.reifiedOperationMarker(1, "P1");
                    Object obj3 = args[2];
                    Intrinsics.reifiedOperationMarker(1, "P2");
                    Object obj4 = args[3];
                    Intrinsics.reifiedOperationMarker(1, "P3");
                    Intrinsics.reifiedOperationMarker(1, "P4");
                    function5.invoke(obj, obj2, obj3, obj4, promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
        } else {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$38 objectDefinitionBuilder$AsyncFunction$38 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$38
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$39 objectDefinitionBuilder$AsyncFunction$39 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$39
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$40 objectDefinitionBuilder$AsyncFunction$40 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$40
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$41 objectDefinitionBuilder$AsyncFunction$41 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$41
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$42 objectDefinitionBuilder$AsyncFunction$42 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$42
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass5, false, objectDefinitionBuilder$AsyncFunction$38)), new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$39)), new AnyType(new LazyKType(orCreateKotlinClass7, false, objectDefinitionBuilder$AsyncFunction$40)), new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$AsyncFunction$41)), new AnyType(new LazyKType(orCreateKotlinClass9, false, objectDefinitionBuilder$AsyncFunction$42))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$43
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Function5<P0, P1, P2, P3, P4, R> function5 = body;
                    Object obj = it[0];
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    Object obj2 = it[1];
                    Intrinsics.reifiedOperationMarker(1, "P1");
                    Object obj3 = it[2];
                    Intrinsics.reifiedOperationMarker(1, "P2");
                    Object obj4 = it[3];
                    Intrinsics.reifiedOperationMarker(1, "P3");
                    Object obj5 = it[4];
                    Intrinsics.reifiedOperationMarker(1, "P4");
                    return function5.invoke(obj, obj2, obj3, obj4, obj5);
                }
            });
        }
        getAsyncFunctions().put(name, asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> AsyncFunction AsyncFunction(String name, final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P5");
        if (Object.class == Promise.class) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$45 objectDefinitionBuilder$AsyncFunction$45 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$45
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$46 objectDefinitionBuilder$AsyncFunction$46 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$46
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$47 objectDefinitionBuilder$AsyncFunction$47 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$47
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$48 objectDefinitionBuilder$AsyncFunction$48 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$48
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$49 objectDefinitionBuilder$AsyncFunction$49 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$49
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$AsyncFunction$45)), new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$46)), new AnyType(new LazyKType(orCreateKotlinClass3, false, objectDefinitionBuilder$AsyncFunction$47)), new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$48)), new AnyType(new LazyKType(orCreateKotlinClass5, false, objectDefinitionBuilder$AsyncFunction$49))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$50
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Function6<P0, P1, P2, P3, P4, P5, R> function6 = body;
                    Object obj = args[0];
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    Object obj2 = args[1];
                    Intrinsics.reifiedOperationMarker(1, "P1");
                    Object obj3 = args[2];
                    Intrinsics.reifiedOperationMarker(1, "P2");
                    Object obj4 = args[3];
                    Intrinsics.reifiedOperationMarker(1, "P3");
                    Object obj5 = args[4];
                    Intrinsics.reifiedOperationMarker(1, "P4");
                    Intrinsics.reifiedOperationMarker(1, "P5");
                    function6.invoke(obj, obj2, obj3, obj4, obj5, promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
        } else {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$51 objectDefinitionBuilder$AsyncFunction$51 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$51
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$52 objectDefinitionBuilder$AsyncFunction$52 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$52
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$53 objectDefinitionBuilder$AsyncFunction$53 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$53
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$54 objectDefinitionBuilder$AsyncFunction$54 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$54
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$55 objectDefinitionBuilder$AsyncFunction$55 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$55
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$56 objectDefinitionBuilder$AsyncFunction$56 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$56
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$51)), new AnyType(new LazyKType(orCreateKotlinClass7, false, objectDefinitionBuilder$AsyncFunction$52)), new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$AsyncFunction$53)), new AnyType(new LazyKType(orCreateKotlinClass9, false, objectDefinitionBuilder$AsyncFunction$54)), new AnyType(new LazyKType(orCreateKotlinClass10, false, objectDefinitionBuilder$AsyncFunction$55)), new AnyType(new LazyKType(orCreateKotlinClass11, false, objectDefinitionBuilder$AsyncFunction$56))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$57
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Function6<P0, P1, P2, P3, P4, P5, R> function6 = body;
                    Object obj = it[0];
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    Object obj2 = it[1];
                    Intrinsics.reifiedOperationMarker(1, "P1");
                    Object obj3 = it[2];
                    Intrinsics.reifiedOperationMarker(1, "P2");
                    Object obj4 = it[3];
                    Intrinsics.reifiedOperationMarker(1, "P3");
                    Object obj5 = it[4];
                    Intrinsics.reifiedOperationMarker(1, "P4");
                    Object obj6 = it[5];
                    Intrinsics.reifiedOperationMarker(1, "P5");
                    return function6.invoke(obj, obj2, obj3, obj4, obj5, obj6);
                }
            });
        }
        getAsyncFunctions().put(name, asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> AsyncFunction AsyncFunction(String name, final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P6");
        if (Object.class == Promise.class) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$59 objectDefinitionBuilder$AsyncFunction$59 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$59
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$60 objectDefinitionBuilder$AsyncFunction$60 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$60
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$61 objectDefinitionBuilder$AsyncFunction$61 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$61
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$62 objectDefinitionBuilder$AsyncFunction$62 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$62
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$63 objectDefinitionBuilder$AsyncFunction$63 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$63
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$64 objectDefinitionBuilder$AsyncFunction$64 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$64
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$AsyncFunction$59)), new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$60)), new AnyType(new LazyKType(orCreateKotlinClass3, false, objectDefinitionBuilder$AsyncFunction$61)), new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$62)), new AnyType(new LazyKType(orCreateKotlinClass5, false, objectDefinitionBuilder$AsyncFunction$63)), new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$64))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$65
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Function7<P0, P1, P2, P3, P4, P5, P6, R> function7 = body;
                    Object obj = args[0];
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    Object obj2 = args[1];
                    Intrinsics.reifiedOperationMarker(1, "P1");
                    Object obj3 = args[2];
                    Intrinsics.reifiedOperationMarker(1, "P2");
                    Object obj4 = args[3];
                    Intrinsics.reifiedOperationMarker(1, "P3");
                    Object obj5 = args[4];
                    Intrinsics.reifiedOperationMarker(1, "P4");
                    Object obj6 = args[5];
                    Intrinsics.reifiedOperationMarker(1, "P5");
                    Intrinsics.reifiedOperationMarker(1, "P6");
                    function7.invoke(obj, obj2, obj3, obj4, obj5, obj6, promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
        } else {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$66 objectDefinitionBuilder$AsyncFunction$66 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$66
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$67 objectDefinitionBuilder$AsyncFunction$67 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$67
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$68 objectDefinitionBuilder$AsyncFunction$68 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$68
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$69 objectDefinitionBuilder$AsyncFunction$69 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$69
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$70 objectDefinitionBuilder$AsyncFunction$70 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$70
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$71 objectDefinitionBuilder$AsyncFunction$71 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$71
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$72 objectDefinitionBuilder$AsyncFunction$72 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$72
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass7, false, objectDefinitionBuilder$AsyncFunction$66)), new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$AsyncFunction$67)), new AnyType(new LazyKType(orCreateKotlinClass9, false, objectDefinitionBuilder$AsyncFunction$68)), new AnyType(new LazyKType(orCreateKotlinClass10, false, objectDefinitionBuilder$AsyncFunction$69)), new AnyType(new LazyKType(orCreateKotlinClass11, false, objectDefinitionBuilder$AsyncFunction$70)), new AnyType(new LazyKType(orCreateKotlinClass12, false, objectDefinitionBuilder$AsyncFunction$71)), new AnyType(new LazyKType(orCreateKotlinClass13, false, objectDefinitionBuilder$AsyncFunction$72))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$73
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Function7<P0, P1, P2, P3, P4, P5, P6, R> function7 = body;
                    Object obj = it[0];
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    Object obj2 = it[1];
                    Intrinsics.reifiedOperationMarker(1, "P1");
                    Object obj3 = it[2];
                    Intrinsics.reifiedOperationMarker(1, "P2");
                    Object obj4 = it[3];
                    Intrinsics.reifiedOperationMarker(1, "P3");
                    Object obj5 = it[4];
                    Intrinsics.reifiedOperationMarker(1, "P4");
                    Object obj6 = it[5];
                    Intrinsics.reifiedOperationMarker(1, "P5");
                    Object obj7 = it[6];
                    Intrinsics.reifiedOperationMarker(1, "P6");
                    return function7.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7);
                }
            });
        }
        getAsyncFunctions().put(name, asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> AsyncFunction AsyncFunction(String name, final Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> body) {
        String str;
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P7");
        if (Object.class == Promise.class) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$75 objectDefinitionBuilder$AsyncFunction$75 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$75
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$76 objectDefinitionBuilder$AsyncFunction$76 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$76
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$77 objectDefinitionBuilder$AsyncFunction$77 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$77
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$78 objectDefinitionBuilder$AsyncFunction$78 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$78
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$79 objectDefinitionBuilder$AsyncFunction$79 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$79
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$80 objectDefinitionBuilder$AsyncFunction$80 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$80
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$81 objectDefinitionBuilder$AsyncFunction$81 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$81
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, objectDefinitionBuilder$AsyncFunction$75)), new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$76)), new AnyType(new LazyKType(orCreateKotlinClass3, false, objectDefinitionBuilder$AsyncFunction$77)), new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$78)), new AnyType(new LazyKType(orCreateKotlinClass5, false, objectDefinitionBuilder$AsyncFunction$79)), new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$80)), new AnyType(new LazyKType(orCreateKotlinClass7, false, objectDefinitionBuilder$AsyncFunction$81))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$82
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Function8<P0, P1, P2, P3, P4, P5, P6, P7, R> function8 = body;
                    Object obj = args[0];
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    Object obj2 = args[1];
                    Intrinsics.reifiedOperationMarker(1, "P1");
                    Object obj3 = args[2];
                    Intrinsics.reifiedOperationMarker(1, "P2");
                    Object obj4 = args[3];
                    Intrinsics.reifiedOperationMarker(1, "P3");
                    Object obj5 = args[4];
                    Intrinsics.reifiedOperationMarker(1, "P4");
                    Object obj6 = args[5];
                    Intrinsics.reifiedOperationMarker(1, "P5");
                    Object obj7 = args[6];
                    Intrinsics.reifiedOperationMarker(1, "P6");
                    Intrinsics.reifiedOperationMarker(1, "P7");
                    function8.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            str = name;
        } else {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$83 objectDefinitionBuilder$AsyncFunction$83 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$83
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$84 objectDefinitionBuilder$AsyncFunction$84 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$84
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$85 objectDefinitionBuilder$AsyncFunction$85 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$85
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$86 objectDefinitionBuilder$AsyncFunction$86 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$86
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$87 objectDefinitionBuilder$AsyncFunction$87 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$87
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$88 objectDefinitionBuilder$AsyncFunction$88 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$88
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$89 objectDefinitionBuilder$AsyncFunction$89 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$89
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$90 objectDefinitionBuilder$AsyncFunction$90 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$90
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P7");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P7");
            KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P7");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$AsyncFunction$83)), new AnyType(new LazyKType(orCreateKotlinClass9, false, objectDefinitionBuilder$AsyncFunction$84)), new AnyType(new LazyKType(orCreateKotlinClass10, false, objectDefinitionBuilder$AsyncFunction$85)), new AnyType(new LazyKType(orCreateKotlinClass11, false, objectDefinitionBuilder$AsyncFunction$86)), new AnyType(new LazyKType(orCreateKotlinClass12, false, objectDefinitionBuilder$AsyncFunction$87)), new AnyType(new LazyKType(orCreateKotlinClass13, false, objectDefinitionBuilder$AsyncFunction$88)), new AnyType(new LazyKType(orCreateKotlinClass14, false, objectDefinitionBuilder$AsyncFunction$89)), new AnyType(new LazyKType(orCreateKotlinClass15, false, objectDefinitionBuilder$AsyncFunction$90))};
            Intrinsics.needClassReification();
            str = name;
            asyncFunctionComponent = new AsyncFunctionComponent(str, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$91
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Function8<P0, P1, P2, P3, P4, P5, P6, P7, R> function8 = body;
                    Object obj = it[0];
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    Object obj2 = it[1];
                    Intrinsics.reifiedOperationMarker(1, "P1");
                    Object obj3 = it[2];
                    Intrinsics.reifiedOperationMarker(1, "P2");
                    Object obj4 = it[3];
                    Intrinsics.reifiedOperationMarker(1, "P3");
                    Object obj5 = it[4];
                    Intrinsics.reifiedOperationMarker(1, "P4");
                    Object obj6 = it[5];
                    Intrinsics.reifiedOperationMarker(1, "P5");
                    Object obj7 = it[6];
                    Intrinsics.reifiedOperationMarker(1, "P6");
                    Object obj8 = it[7];
                    Intrinsics.reifiedOperationMarker(1, "P7");
                    return function8.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
                }
            });
        }
        getAsyncFunctions().put(str, asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final AsyncFunctionBuilder AsyncFunction(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        AsyncFunctionBuilder asyncFunctionBuilder = new AsyncFunctionBuilder(name);
        this.asyncFunctionBuilders.put(name, asyncFunctionBuilder);
        return asyncFunctionBuilder;
    }

    public final void Events(String... events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.eventsDefinition = new EventsDefinition(events);
    }

    public final void EventsWithArray(String[] events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.eventsDefinition = new EventsDefinition(events);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
    
        if (r4.size() == 1) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ <T extends java.lang.Enum<T> & expo.modules.kotlin.types.Enumerable> void Events() {
        /*
            r7 = this;
            r0 = 4
            java.lang.String r1 = "T"
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r0, r1)
            java.lang.Class<java.lang.Enum> r2 = java.lang.Enum.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            kotlin.reflect.KFunction r2 = kotlin.reflect.full.KClasses.getPrimaryConstructor(r2)
            r3 = 0
            if (r2 == 0) goto L21
            java.util.List r4 = r2.getParameters()
            if (r4 == 0) goto L21
            int r4 = r4.size()
            r5 = 1
            if (r4 != r5) goto L21
            goto L22
        L21:
            r5 = r3
        L22:
            r4 = 5
            if (r5 == 0) goto Lad
            java.util.List r2 = r2.getParameters()
            java.lang.Object r2 = kotlin.collections.CollectionsKt.first(r2)
            kotlin.reflect.KParameter r2 = (kotlin.reflect.KParameter) r2
            java.lang.String r2 = r2.getName()
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r0, r1)
            java.lang.Class<java.lang.Enum> r0 = java.lang.Enum.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.util.Collection r0 = kotlin.reflect.full.KClasses.getDeclaredMemberProperties(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L46:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L5e
            java.lang.Object r5 = r0.next()
            r6 = r5
            kotlin.reflect.KProperty1 r6 = (kotlin.reflect.KProperty1) r6
            java.lang.String r6 = r6.getName()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r2)
            if (r6 == 0) goto L46
            goto L5f
        L5e:
            r5 = 0
        L5f:
            kotlin.reflect.KProperty1 r5 = (kotlin.reflect.KProperty1) r5
            if (r5 == 0) goto L90
            kotlin.reflect.KType r0 = r5.getReturnType()
            kotlin.reflect.KClassifier r0 = r0.getClassifier()
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r0 == 0) goto L84
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r4, r1)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r3)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.List r0 = (java.util.List) r0
            goto Lb9
        L84:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The enum parameter has to be a string."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L90:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Cannot find a property for "
            r0.<init>(r1)
            r0.append(r2)
            java.lang.String r1 = " parameter"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        Lad:
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r4, r1)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r3)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.List r0 = (java.util.List) r0
        Lb9:
            expo.modules.kotlin.events.EventsDefinition r1 = new expo.modules.kotlin.events.EventsDefinition
            java.util.Collection r0 = (java.util.Collection) r0
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.String[] r2 = new java.lang.String[r3]
            java.lang.Object[] r0 = r0.toArray(r2)
            java.lang.String[] r0 = (java.lang.String[]) r0
            r1.<init>(r0)
            r7.setEventsDefinition(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.objects.ObjectDefinitionBuilder.Events():void");
    }

    public PropertyComponentBuilder Property(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        PropertyComponentBuilder propertyComponentBuilder = new PropertyComponentBuilder(name);
        this.properties.put(name, propertyComponentBuilder);
        return propertyComponentBuilder;
    }

    public final <T> PropertyComponentBuilder Property(String name, Function0<? extends T> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        PropertyComponentBuilder propertyComponentBuilder = new PropertyComponentBuilder(name);
        propertyComponentBuilder.setGetter(new SyncFunctionComponent(b.ar, new AnyType[0], new PropertyComponentBuilder$get$1$1(body)));
        getProperties().put(name, propertyComponentBuilder);
        return propertyComponentBuilder;
    }

    public final void OnStartObserving(Function0<Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        getAsyncFunctions().put("startObserving", new AsyncFunctionComponent("startObserving", new AnyType[0], new ObjectDefinitionBuilder$AsyncFunction$1(body)));
    }

    public final void OnStopObserving(Function0<Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        getAsyncFunctions().put("stopObserving", new AsyncFunctionComponent("stopObserving", new AnyType[0], new ObjectDefinitionBuilder$AsyncFunction$1(body)));
    }
}
