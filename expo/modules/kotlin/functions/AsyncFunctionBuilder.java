package expo.modules.kotlin.functions;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: AsyncFunctionBuilder.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u00012\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\u0086\bø\u0001\u0000J#\u0010\u0010\u001a\u00020\u00112\u0010\b\u0004\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0015JA\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u00012#\b\u0004\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u0002H\u00120\u0017H\u0086\bø\u0001\u0000J^\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u000128\b\u0004\u0010\u0013\u001a2\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\u00120\u001bH\u0086\bø\u0001\u0000J{\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u00012M\b\u0004\u0010\u0013\u001aG\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002H\u00120\u001eH\u0086\bø\u0001\u0000J\u0098\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u00012b\b\u0004\u0010\u0013\u001a\\\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u00120!H\u0086\bø\u0001\u0000Jµ\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u00012w\b\u0004\u0010\u0013\u001aq\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0004\u0012\u0002H\u00120$H\u0086\bø\u0001\u0000JÔ\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u00012\u008d\u0001\b\u0004\u0010\u0013\u001a\u0086\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H\u00120'H\u0086\bø\u0001\u0000Jñ\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u0001\"\u0006\b\u0007\u0010)\u0018\u00012¢\u0001\b\u0004\u0010\u0013\u001a\u009b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u00120*H\u0086\bø\u0001\u0000J\u008e\u0002\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u0001\"\u0006\b\u0007\u0010)\u0018\u0001\"\u0006\b\b\u0010,\u0018\u00012·\u0001\b\u0004\u0010\u0013\u001a°\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(.\u0012\u0004\u0012\u0002H\u00120-H\u0086\bø\u0001\u0000J9\u0010/\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0012\u0018\u00012\u001e\b\u0004\u00100\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001201\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H\u0086\bø\u0001\u0001¢\u0006\u0002\u00102JV\u0010/\u001a\u000203\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u000123\b\u0004\u00100\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001201\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001bH\u0086\bø\u0001\u0001¢\u0006\u0002\u00104Js\u0010/\u001a\u000203\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u00012H\b\u0004\u00100\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001201\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001eH\u0086\bø\u0001\u0001¢\u0006\u0002\u00105J\u0090\u0001\u0010/\u001a\u000203\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u00012]\b\u0004\u00100\u001aW\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001201\u0012\u0006\u0012\u0004\u0018\u00010\u00010!H\u0086\bø\u0001\u0001¢\u0006\u0002\u00106J\u00ad\u0001\u0010/\u001a\u000203\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u00012r\b\u0004\u00100\u001al\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001201\u0012\u0006\u0012\u0004\u0018\u00010\u00010$H\u0086\bø\u0001\u0001¢\u0006\u0002\u00107JÌ\u0001\u0010/\u001a\u000203\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u00012\u0088\u0001\b\u0004\u00100\u001a\u0081\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001201\u0012\u0006\u0012\u0004\u0018\u00010\u00010'H\u0086\bø\u0001\u0001¢\u0006\u0002\u00108Jé\u0001\u0010/\u001a\u000203\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u00012\u009d\u0001\b\u0004\u00100\u001a\u0096\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001201\u0012\u0006\u0012\u0004\u0018\u00010\u00010*H\u0086\bø\u0001\u0001¢\u0006\u0002\u00109J\u0086\u0002\u0010/\u001a\u000203\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u0001\"\u0006\b\u0007\u0010)\u0018\u00012²\u0001\b\u0004\u00100\u001a«\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001201\u0012\u0006\u0012\u0004\u0018\u00010\u00010-H\u0086\bø\u0001\u0001¢\u0006\u0002\u0010:J£\u0002\u0010/\u001a\u000203\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u0001\"\u0006\b\u0007\u0010)\u0018\u0001\"\u0006\b\b\u0010,\u0018\u00012Ç\u0001\b\u0004\u00100\u001aÀ\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(.\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001201\u0012\u0006\u0012\u0004\u0018\u00010\u00010;H\u0086\bø\u0001\u0001¢\u0006\u0002\u0010<J\r\u0010=\u001a\u00020\u0006H\u0000¢\u0006\u0002\b>R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006?"}, d2 = {"Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;", "", "name", "", "(Ljava/lang/String;)V", "asyncFunctionComponent", "Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "getAsyncFunctionComponent$annotations", "()V", "getAsyncFunctionComponent", "()Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "setAsyncFunctionComponent", "(Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;)V", "getName$annotations", "getName", "()Ljava/lang/String;", "AsyncBody", "Lexpo/modules/kotlin/functions/AsyncFunction;", "R", TtmlNode.TAG_BODY, "Lkotlin/Function0;", "AsyncBodyWithoutArgs", "P0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "SuspendBody", "block", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function2;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function3;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function4;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function5;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function6;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function7;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function8;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "Lkotlin/Function9;", "(Lkotlin/jvm/functions/Function9;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "build", "build$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AsyncFunctionBuilder {
    private BaseAsyncFunctionComponent asyncFunctionComponent;
    private final String name;

    public static /* synthetic */ void getAsyncFunctionComponent$annotations() {
    }

    public static /* synthetic */ void getName$annotations() {
    }

    public AsyncFunctionBuilder(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    public final BaseAsyncFunctionComponent getAsyncFunctionComponent() {
        return this.asyncFunctionComponent;
    }

    public final void setAsyncFunctionComponent(BaseAsyncFunctionComponent baseAsyncFunctionComponent) {
        this.asyncFunctionComponent = baseAsyncFunctionComponent;
    }

    public final /* synthetic */ <R> BaseAsyncFunctionComponent SuspendBody(Function1<? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(getName(), new AnyType[0], new AsyncFunctionBuilder$SuspendBody$1(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0> SuspendFunctionComponent SuspendBody(Function2<? super P0, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
        Intrinsics.needClassReification();
        AsyncFunctionBuilder$SuspendBody$3 asyncFunctionBuilder$SuspendBody$3 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$3
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P0");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$SuspendBody$3))};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$4(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1> SuspendFunctionComponent SuspendBody(Function3<? super P0, ? super P1, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
        Intrinsics.needClassReification();
        AsyncFunctionBuilder$SuspendBody$6 asyncFunctionBuilder$SuspendBody$6 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$6
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
        AsyncFunctionBuilder$SuspendBody$7 asyncFunctionBuilder$SuspendBody$7 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$7
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P1");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$SuspendBody$6)), new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$7))};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$8(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> SuspendFunctionComponent SuspendBody(Function4<? super P0, ? super P1, ? super P2, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
        Intrinsics.needClassReification();
        AsyncFunctionBuilder$SuspendBody$10 asyncFunctionBuilder$SuspendBody$10 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$10
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
        AsyncFunctionBuilder$SuspendBody$11 asyncFunctionBuilder$SuspendBody$11 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$11
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
        AsyncFunctionBuilder$SuspendBody$12 asyncFunctionBuilder$SuspendBody$12 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$12
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P2");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$SuspendBody$10)), new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$11)), new AnyType(new LazyKType(orCreateKotlinClass3, false, asyncFunctionBuilder$SuspendBody$12))};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$13(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> SuspendFunctionComponent SuspendBody(Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
        Intrinsics.needClassReification();
        AsyncFunctionBuilder$SuspendBody$15 asyncFunctionBuilder$SuspendBody$15 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$15
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
        AsyncFunctionBuilder$SuspendBody$16 asyncFunctionBuilder$SuspendBody$16 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$16
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
        AsyncFunctionBuilder$SuspendBody$17 asyncFunctionBuilder$SuspendBody$17 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$17
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
        AsyncFunctionBuilder$SuspendBody$18 asyncFunctionBuilder$SuspendBody$18 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$18
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P3");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$SuspendBody$15)), new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$16)), new AnyType(new LazyKType(orCreateKotlinClass3, false, asyncFunctionBuilder$SuspendBody$17)), new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$18))};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$19(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> SuspendFunctionComponent SuspendBody(Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
        Intrinsics.needClassReification();
        AsyncFunctionBuilder$SuspendBody$21 asyncFunctionBuilder$SuspendBody$21 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$21
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
        AsyncFunctionBuilder$SuspendBody$22 asyncFunctionBuilder$SuspendBody$22 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$22
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
        AsyncFunctionBuilder$SuspendBody$23 asyncFunctionBuilder$SuspendBody$23 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$23
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
        AsyncFunctionBuilder$SuspendBody$24 asyncFunctionBuilder$SuspendBody$24 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$24
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
        AsyncFunctionBuilder$SuspendBody$25 asyncFunctionBuilder$SuspendBody$25 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$25
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P4");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$SuspendBody$21)), new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$22)), new AnyType(new LazyKType(orCreateKotlinClass3, false, asyncFunctionBuilder$SuspendBody$23)), new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$24)), new AnyType(new LazyKType(orCreateKotlinClass5, false, asyncFunctionBuilder$SuspendBody$25))};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$26(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> SuspendFunctionComponent SuspendBody(Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
        Intrinsics.needClassReification();
        AsyncFunctionBuilder$SuspendBody$28 asyncFunctionBuilder$SuspendBody$28 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$28
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
        AsyncFunctionBuilder$SuspendBody$29 asyncFunctionBuilder$SuspendBody$29 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$29
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
        AsyncFunctionBuilder$SuspendBody$30 asyncFunctionBuilder$SuspendBody$30 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$30
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
        AsyncFunctionBuilder$SuspendBody$31 asyncFunctionBuilder$SuspendBody$31 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$31
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
        AsyncFunctionBuilder$SuspendBody$32 asyncFunctionBuilder$SuspendBody$32 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$32
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
        AsyncFunctionBuilder$SuspendBody$33 asyncFunctionBuilder$SuspendBody$33 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$33
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P5");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$SuspendBody$28)), new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$29)), new AnyType(new LazyKType(orCreateKotlinClass3, false, asyncFunctionBuilder$SuspendBody$30)), new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$31)), new AnyType(new LazyKType(orCreateKotlinClass5, false, asyncFunctionBuilder$SuspendBody$32)), new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$SuspendBody$33))};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$34(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> SuspendFunctionComponent SuspendBody(Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
        Intrinsics.needClassReification();
        AsyncFunctionBuilder$SuspendBody$36 asyncFunctionBuilder$SuspendBody$36 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$36
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
        AsyncFunctionBuilder$SuspendBody$37 asyncFunctionBuilder$SuspendBody$37 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$37
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
        AsyncFunctionBuilder$SuspendBody$38 asyncFunctionBuilder$SuspendBody$38 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$38
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
        AsyncFunctionBuilder$SuspendBody$39 asyncFunctionBuilder$SuspendBody$39 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$39
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
        AsyncFunctionBuilder$SuspendBody$40 asyncFunctionBuilder$SuspendBody$40 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$40
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
        AsyncFunctionBuilder$SuspendBody$41 asyncFunctionBuilder$SuspendBody$41 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$41
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
        AsyncFunctionBuilder$SuspendBody$42 asyncFunctionBuilder$SuspendBody$42 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$42
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P6");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$SuspendBody$36)), new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$37)), new AnyType(new LazyKType(orCreateKotlinClass3, false, asyncFunctionBuilder$SuspendBody$38)), new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$39)), new AnyType(new LazyKType(orCreateKotlinClass5, false, asyncFunctionBuilder$SuspendBody$40)), new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$SuspendBody$41)), new AnyType(new LazyKType(orCreateKotlinClass7, false, asyncFunctionBuilder$SuspendBody$42))};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$43(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> SuspendFunctionComponent SuspendBody(Function9<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
        Intrinsics.needClassReification();
        AsyncFunctionBuilder$SuspendBody$45 asyncFunctionBuilder$SuspendBody$45 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$45
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
        AsyncFunctionBuilder$SuspendBody$46 asyncFunctionBuilder$SuspendBody$46 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$46
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
        AsyncFunctionBuilder$SuspendBody$47 asyncFunctionBuilder$SuspendBody$47 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$47
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
        AsyncFunctionBuilder$SuspendBody$48 asyncFunctionBuilder$SuspendBody$48 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$48
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
        AsyncFunctionBuilder$SuspendBody$49 asyncFunctionBuilder$SuspendBody$49 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$49
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
        AsyncFunctionBuilder$SuspendBody$50 asyncFunctionBuilder$SuspendBody$50 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$50
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
        AsyncFunctionBuilder$SuspendBody$51 asyncFunctionBuilder$SuspendBody$51 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$51
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
        AsyncFunctionBuilder$SuspendBody$52 asyncFunctionBuilder$SuspendBody$52 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$52
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "P7");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$SuspendBody$45)), new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$46)), new AnyType(new LazyKType(orCreateKotlinClass3, false, asyncFunctionBuilder$SuspendBody$47)), new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$48)), new AnyType(new LazyKType(orCreateKotlinClass5, false, asyncFunctionBuilder$SuspendBody$49)), new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$SuspendBody$50)), new AnyType(new LazyKType(orCreateKotlinClass7, false, asyncFunctionBuilder$SuspendBody$51)), new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$SuspendBody$52))};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$53(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final AsyncFunction AsyncBodyWithoutArgs(final Function0<? extends Object> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent(getName(), new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$1
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
        setAsyncFunctionComponent(asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R> AsyncFunction AsyncBody(final Function0<? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent(getName(), new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$3
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
        setAsyncFunctionComponent(asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> AsyncFunction AsyncBody(final Function1<? super P0, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P0");
        if (Object.class == Promise.class) {
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(getName(), new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$5
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
            String name = getName();
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$6 asyncFunctionBuilder$AsyncBody$6 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$AsyncBody$6))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$7
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
        setAsyncFunctionComponent(asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1> AsyncFunction AsyncBody(final Function2<? super P0, ? super P1, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P1");
        if (Object.class == Promise.class) {
            String name = getName();
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$9 asyncFunctionBuilder$AsyncBody$9 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$AsyncBody$9))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$10
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
            String name2 = getName();
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$11 asyncFunctionBuilder$AsyncBody$11 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$11
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
            AsyncFunctionBuilder$AsyncBody$12 asyncFunctionBuilder$AsyncBody$12 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$11)), new AnyType(new LazyKType(orCreateKotlinClass3, false, asyncFunctionBuilder$AsyncBody$12))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name2, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$13
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
        setAsyncFunctionComponent(asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> AsyncFunction AsyncBody(final Function3<? super P0, ? super P1, ? super P2, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P2");
        if (Object.class == Promise.class) {
            String name = getName();
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$15 asyncFunctionBuilder$AsyncBody$15 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$15
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
            AsyncFunctionBuilder$AsyncBody$16 asyncFunctionBuilder$AsyncBody$16 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$AsyncBody$15)), new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$16))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$17
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
            String name2 = getName();
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$18 asyncFunctionBuilder$AsyncBody$18 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$18
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
            AsyncFunctionBuilder$AsyncBody$19 asyncFunctionBuilder$AsyncBody$19 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$19
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
            AsyncFunctionBuilder$AsyncBody$20 asyncFunctionBuilder$AsyncBody$20 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass3, false, asyncFunctionBuilder$AsyncBody$18)), new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$19)), new AnyType(new LazyKType(orCreateKotlinClass5, false, asyncFunctionBuilder$AsyncBody$20))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name2, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$21
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
        setAsyncFunctionComponent(asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> AsyncFunction AsyncBody(final Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P3");
        if (Object.class == Promise.class) {
            String name = getName();
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$23 asyncFunctionBuilder$AsyncBody$23 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$23
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
            AsyncFunctionBuilder$AsyncBody$24 asyncFunctionBuilder$AsyncBody$24 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$24
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
            AsyncFunctionBuilder$AsyncBody$25 asyncFunctionBuilder$AsyncBody$25 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$25
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$AsyncBody$23)), new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$24)), new AnyType(new LazyKType(orCreateKotlinClass3, false, asyncFunctionBuilder$AsyncBody$25))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$26
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
            String name2 = getName();
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$27 asyncFunctionBuilder$AsyncBody$27 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$27
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
            AsyncFunctionBuilder$AsyncBody$28 asyncFunctionBuilder$AsyncBody$28 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$28
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
            AsyncFunctionBuilder$AsyncBody$29 asyncFunctionBuilder$AsyncBody$29 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$29
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
            AsyncFunctionBuilder$AsyncBody$30 asyncFunctionBuilder$AsyncBody$30 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$27)), new AnyType(new LazyKType(orCreateKotlinClass5, false, asyncFunctionBuilder$AsyncBody$28)), new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$29)), new AnyType(new LazyKType(orCreateKotlinClass7, false, asyncFunctionBuilder$AsyncBody$30))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name2, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$31
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
        setAsyncFunctionComponent(asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> AsyncFunction AsyncBody(final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P4");
        if (Object.class == Promise.class) {
            String name = getName();
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$33 asyncFunctionBuilder$AsyncBody$33 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$33
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
            AsyncFunctionBuilder$AsyncBody$34 asyncFunctionBuilder$AsyncBody$34 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$34
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
            AsyncFunctionBuilder$AsyncBody$35 asyncFunctionBuilder$AsyncBody$35 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$35
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
            AsyncFunctionBuilder$AsyncBody$36 asyncFunctionBuilder$AsyncBody$36 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$AsyncBody$33)), new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$34)), new AnyType(new LazyKType(orCreateKotlinClass3, false, asyncFunctionBuilder$AsyncBody$35)), new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$36))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$37
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
            String name2 = getName();
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$38 asyncFunctionBuilder$AsyncBody$38 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$38
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
            AsyncFunctionBuilder$AsyncBody$39 asyncFunctionBuilder$AsyncBody$39 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$39
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
            AsyncFunctionBuilder$AsyncBody$40 asyncFunctionBuilder$AsyncBody$40 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$40
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
            AsyncFunctionBuilder$AsyncBody$41 asyncFunctionBuilder$AsyncBody$41 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$41
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
            AsyncFunctionBuilder$AsyncBody$42 asyncFunctionBuilder$AsyncBody$42 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$42
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass5, false, asyncFunctionBuilder$AsyncBody$38)), new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$39)), new AnyType(new LazyKType(orCreateKotlinClass7, false, asyncFunctionBuilder$AsyncBody$40)), new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$41)), new AnyType(new LazyKType(orCreateKotlinClass9, false, asyncFunctionBuilder$AsyncBody$42))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name2, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$43
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
        setAsyncFunctionComponent(asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> AsyncFunction AsyncBody(final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P5");
        if (Object.class == Promise.class) {
            String name = getName();
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$45 asyncFunctionBuilder$AsyncBody$45 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$45
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
            AsyncFunctionBuilder$AsyncBody$46 asyncFunctionBuilder$AsyncBody$46 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$46
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
            AsyncFunctionBuilder$AsyncBody$47 asyncFunctionBuilder$AsyncBody$47 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$47
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
            AsyncFunctionBuilder$AsyncBody$48 asyncFunctionBuilder$AsyncBody$48 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$48
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
            AsyncFunctionBuilder$AsyncBody$49 asyncFunctionBuilder$AsyncBody$49 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$49
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$AsyncBody$45)), new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$46)), new AnyType(new LazyKType(orCreateKotlinClass3, false, asyncFunctionBuilder$AsyncBody$47)), new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$48)), new AnyType(new LazyKType(orCreateKotlinClass5, false, asyncFunctionBuilder$AsyncBody$49))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$50
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
            String name2 = getName();
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$51 asyncFunctionBuilder$AsyncBody$51 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$51
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
            AsyncFunctionBuilder$AsyncBody$52 asyncFunctionBuilder$AsyncBody$52 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$52
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
            AsyncFunctionBuilder$AsyncBody$53 asyncFunctionBuilder$AsyncBody$53 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$53
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
            AsyncFunctionBuilder$AsyncBody$54 asyncFunctionBuilder$AsyncBody$54 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$54
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
            AsyncFunctionBuilder$AsyncBody$55 asyncFunctionBuilder$AsyncBody$55 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$55
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
            AsyncFunctionBuilder$AsyncBody$56 asyncFunctionBuilder$AsyncBody$56 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$56
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$51)), new AnyType(new LazyKType(orCreateKotlinClass7, false, asyncFunctionBuilder$AsyncBody$52)), new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$53)), new AnyType(new LazyKType(orCreateKotlinClass9, false, asyncFunctionBuilder$AsyncBody$54)), new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$55)), new AnyType(new LazyKType(orCreateKotlinClass11, false, asyncFunctionBuilder$AsyncBody$56))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name2, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$57
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
        setAsyncFunctionComponent(asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> AsyncFunction AsyncBody(final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P6");
        if (Object.class == Promise.class) {
            String name = getName();
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$59 asyncFunctionBuilder$AsyncBody$59 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$59
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
            AsyncFunctionBuilder$AsyncBody$60 asyncFunctionBuilder$AsyncBody$60 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$60
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
            AsyncFunctionBuilder$AsyncBody$61 asyncFunctionBuilder$AsyncBody$61 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$61
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
            AsyncFunctionBuilder$AsyncBody$62 asyncFunctionBuilder$AsyncBody$62 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$62
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
            AsyncFunctionBuilder$AsyncBody$63 asyncFunctionBuilder$AsyncBody$63 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$63
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
            AsyncFunctionBuilder$AsyncBody$64 asyncFunctionBuilder$AsyncBody$64 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$64
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$AsyncBody$59)), new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$60)), new AnyType(new LazyKType(orCreateKotlinClass3, false, asyncFunctionBuilder$AsyncBody$61)), new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$62)), new AnyType(new LazyKType(orCreateKotlinClass5, false, asyncFunctionBuilder$AsyncBody$63)), new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$64))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$65
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
            String name2 = getName();
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$66 asyncFunctionBuilder$AsyncBody$66 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$66
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
            AsyncFunctionBuilder$AsyncBody$67 asyncFunctionBuilder$AsyncBody$67 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$67
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
            AsyncFunctionBuilder$AsyncBody$68 asyncFunctionBuilder$AsyncBody$68 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$68
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
            AsyncFunctionBuilder$AsyncBody$69 asyncFunctionBuilder$AsyncBody$69 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$69
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
            AsyncFunctionBuilder$AsyncBody$70 asyncFunctionBuilder$AsyncBody$70 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$70
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
            AsyncFunctionBuilder$AsyncBody$71 asyncFunctionBuilder$AsyncBody$71 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$71
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
            AsyncFunctionBuilder$AsyncBody$72 asyncFunctionBuilder$AsyncBody$72 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$72
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass7, false, asyncFunctionBuilder$AsyncBody$66)), new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$67)), new AnyType(new LazyKType(orCreateKotlinClass9, false, asyncFunctionBuilder$AsyncBody$68)), new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$69)), new AnyType(new LazyKType(orCreateKotlinClass11, false, asyncFunctionBuilder$AsyncBody$70)), new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$AsyncBody$71)), new AnyType(new LazyKType(orCreateKotlinClass13, false, asyncFunctionBuilder$AsyncBody$72))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name2, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$73
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
        setAsyncFunctionComponent(asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> AsyncFunction AsyncBody(final Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P7");
        if (Object.class == Promise.class) {
            String name = getName();
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$75 asyncFunctionBuilder$AsyncBody$75 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$75
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
            AsyncFunctionBuilder$AsyncBody$76 asyncFunctionBuilder$AsyncBody$76 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$76
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
            AsyncFunctionBuilder$AsyncBody$77 asyncFunctionBuilder$AsyncBody$77 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$77
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
            AsyncFunctionBuilder$AsyncBody$78 asyncFunctionBuilder$AsyncBody$78 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$78
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
            AsyncFunctionBuilder$AsyncBody$79 asyncFunctionBuilder$AsyncBody$79 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$79
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
            AsyncFunctionBuilder$AsyncBody$80 asyncFunctionBuilder$AsyncBody$80 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$80
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
            AsyncFunctionBuilder$AsyncBody$81 asyncFunctionBuilder$AsyncBody$81 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$81
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, asyncFunctionBuilder$AsyncBody$75)), new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$76)), new AnyType(new LazyKType(orCreateKotlinClass3, false, asyncFunctionBuilder$AsyncBody$77)), new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$78)), new AnyType(new LazyKType(orCreateKotlinClass5, false, asyncFunctionBuilder$AsyncBody$79)), new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$80)), new AnyType(new LazyKType(orCreateKotlinClass7, false, asyncFunctionBuilder$AsyncBody$81))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$82
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
        } else {
            String name2 = getName();
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$83 asyncFunctionBuilder$AsyncBody$83 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$83
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
            AsyncFunctionBuilder$AsyncBody$84 asyncFunctionBuilder$AsyncBody$84 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$84
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
            AsyncFunctionBuilder$AsyncBody$85 asyncFunctionBuilder$AsyncBody$85 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$85
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
            AsyncFunctionBuilder$AsyncBody$86 asyncFunctionBuilder$AsyncBody$86 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$86
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
            AsyncFunctionBuilder$AsyncBody$87 asyncFunctionBuilder$AsyncBody$87 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$87
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
            AsyncFunctionBuilder$AsyncBody$88 asyncFunctionBuilder$AsyncBody$88 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$88
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
            AsyncFunctionBuilder$AsyncBody$89 asyncFunctionBuilder$AsyncBody$89 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$89
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
            AsyncFunctionBuilder$AsyncBody$90 asyncFunctionBuilder$AsyncBody$90 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$90
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P7");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P7");
            KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P7");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$83)), new AnyType(new LazyKType(orCreateKotlinClass9, false, asyncFunctionBuilder$AsyncBody$84)), new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$85)), new AnyType(new LazyKType(orCreateKotlinClass11, false, asyncFunctionBuilder$AsyncBody$86)), new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$AsyncBody$87)), new AnyType(new LazyKType(orCreateKotlinClass13, false, asyncFunctionBuilder$AsyncBody$88)), new AnyType(new LazyKType(orCreateKotlinClass14, false, asyncFunctionBuilder$AsyncBody$89)), new AnyType(new LazyKType(orCreateKotlinClass15, false, asyncFunctionBuilder$AsyncBody$90))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name2, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$91
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
        setAsyncFunctionComponent(asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final BaseAsyncFunctionComponent build$expo_modules_core_release() {
        BaseAsyncFunctionComponent baseAsyncFunctionComponent = this.asyncFunctionComponent;
        if (baseAsyncFunctionComponent != null) {
            return baseAsyncFunctionComponent;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
