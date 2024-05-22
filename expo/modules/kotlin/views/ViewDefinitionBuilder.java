package expo.modules.kotlin.views;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.defaultmodules.ErrorManagerModule;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import expo.modules.kotlin.functions.Queues;
import expo.modules.kotlin.modules.DefinitionMarker;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
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
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;

/* compiled from: ViewDefinitionBuilder.kt */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020\u000bJ,\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u00012\u0006\u00106\u001a\u00020\u000b2\u000e\b\u0004\u00108\u001a\b\u0012\u0004\u0012\u0002H709H\u0086\bø\u0001\u0000J+\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\u000b2\u0010\b\u0004\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000309H\u0087\bø\u0001\u0000¢\u0006\u0002\b:JI\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u00012\u0006\u00106\u001a\u00020\u000b2#\b\u0004\u00108\u001a\u001d\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0004\u0012\u0002H70\u0018H\u0086\bø\u0001\u0000Jf\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u00012\u0006\u00106\u001a\u00020\u000b28\b\u0004\u00108\u001a2\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0004\u0012\u0002H70?H\u0086\bø\u0001\u0000J\u0083\u0001\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u00012\u0006\u00106\u001a\u00020\u000b2M\b\u0004\u00108\u001aG\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002H70BH\u0086\bø\u0001\u0000J \u0001\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u0001\"\u0006\b\u0005\u0010D\u0018\u00012\u0006\u00106\u001a\u00020\u000b2b\b\u0004\u00108\u001a\\\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0013\u0012\u0011HD¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(F\u0012\u0004\u0012\u0002H70EH\u0086\bø\u0001\u0000J½\u0001\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u0001\"\u0006\b\u0005\u0010D\u0018\u0001\"\u0006\b\u0006\u0010G\u0018\u00012\u0006\u00106\u001a\u00020\u000b2w\b\u0004\u00108\u001aq\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0013\u0012\u0011HD¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(F\u0012\u0013\u0012\u0011HG¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(I\u0012\u0004\u0012\u0002H70HH\u0086\bø\u0001\u0000JÜ\u0001\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u0001\"\u0006\b\u0005\u0010D\u0018\u0001\"\u0006\b\u0006\u0010G\u0018\u0001\"\u0006\b\u0007\u0010J\u0018\u00012\u0006\u00106\u001a\u00020\u000b2\u008d\u0001\b\u0004\u00108\u001a\u0086\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0013\u0012\u0011HD¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(F\u0012\u0013\u0012\u0011HG¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(I\u0012\u0013\u0012\u0011HJ¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(L\u0012\u0004\u0012\u0002H70KH\u0086\bø\u0001\u0000Jù\u0001\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u0001\"\u0006\b\u0005\u0010D\u0018\u0001\"\u0006\b\u0006\u0010G\u0018\u0001\"\u0006\b\u0007\u0010J\u0018\u0001\"\u0006\b\b\u0010M\u0018\u00012\u0006\u00106\u001a\u00020\u000b2¢\u0001\b\u0004\u00108\u001a\u009b\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0013\u0012\u0011HD¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(F\u0012\u0013\u0012\u0011HG¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(I\u0012\u0013\u0012\u0011HJ¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(L\u0012\u0013\u0012\u0011HM¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(O\u0012\u0004\u0012\u0002H70NH\u0086\bø\u0001\u0000J\u0096\u0002\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u0001\"\u0006\b\u0005\u0010D\u0018\u0001\"\u0006\b\u0006\u0010G\u0018\u0001\"\u0006\b\u0007\u0010J\u0018\u0001\"\u0006\b\b\u0010M\u0018\u0001\"\u0006\b\t\u0010P\u0018\u00012\u0006\u00106\u001a\u00020\u000b2·\u0001\b\u0004\u00108\u001a°\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0013\u0012\u0011HD¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(F\u0012\u0013\u0012\u0011HG¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(I\u0012\u0013\u0012\u0011HJ¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(L\u0012\u0013\u0012\u0011HM¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(O\u0012\u0013\u0012\u0011HP¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(R\u0012\u0004\u0012\u0002H70QH\u0086\bø\u0001\u0000J\u001d\u0010S\u001a\u00020\u00192\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u000b0UH\u0007¢\u0006\u0004\bV\u0010WJ\u001f\u0010S\u001a\u00020\u00192\u0012\u0010T\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0U\"\u00020\u000b¢\u0006\u0002\u0010WJ7\u0010X\u001a\u00020\u0019\"\n\b\u0001\u0010Y\u0018\u0001*\u00020Z2\u001d\u00108\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002HY0[\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\\H\u0086\bø\u0001\u0000J1\u0010]\u001a\u00020\u00192#\b\u0004\u00108\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(^\u0012\u0004\u0012\u00020\u00190\u0018H\u0086\bø\u0001\u0000JB\u0010]\u001a\u00020\u0019\"\n\b\u0001\u0010_\u0018\u0001*\u00028\u00002#\b\b\u00108\u001a\u001d\u0012\u0013\u0012\u0011H_¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(^\u0012\u0004\u0012\u00020\u00190\u0018H\u0087\bø\u0001\u0000¢\u0006\u0002\b`J1\u0010a\u001a\u00020\u00192#\b\u0004\u00108\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(^\u0012\u0004\u0012\u00020\u00190\u0018H\u0086\bø\u0001\u0000JB\u0010a\u001a\u00020\u0019\"\n\b\u0001\u0010_\u0018\u0001*\u00028\u00002#\b\b\u00108\u001a\u001d\u0012\u0013\u0012\u0011H_¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(^\u0012\u0004\u0012\u00020\u00190\u0018H\u0087\bø\u0001\u0000¢\u0006\u0002\bbJV\u0010c\u001a\u00020\u0019\"\u0006\b\u0001\u0010d\u0018\u00012\u0006\u00106\u001a\u00020\u000b28\b\b\u00108\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(^\u0012\u0013\u0012\u0011Hd¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(e\u0012\u0004\u0012\u00020\u00190?H\u0086\bø\u0001\u0000Jg\u0010c\u001a\u00020\u0019\"\n\b\u0001\u0010_\u0018\u0001*\u00020\u0002\"\u0006\b\u0002\u0010d\u0018\u00012\u0006\u00106\u001a\u00020\u000b28\b\b\u00108\u001a2\u0012\u0013\u0012\u0011H_¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(^\u0012\u0013\u0012\u0011Hd¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(e\u0012\u0004\u0012\u00020\u00190?H\u0087\bø\u0001\u0000¢\u0006\u0002\bfJ\u0006\u0010g\u001a\u00020hJ\u001a\u0010i\u001a\u0014\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020\u00020?H\u0002J\u0010\u0010l\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010mH\u0002J \u0010n\u001a\u00020\u00022\u0006\u0010o\u001a\u00020j2\u0006\u0010p\u001a\u00020k2\u0006\u0010q\u001a\u00020rH\u0002R0\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00160\nX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR2\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR0\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020$0\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010\u000e\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u000e\u001a\u0004\b)\u0010*R&\u0010+\u001a\u0004\u0018\u00010,8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u000e\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u000e\u001a\u0004\b3\u00104\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006s"}, d2 = {"Lexpo/modules/kotlin/views/ViewDefinitionBuilder;", "T", "Landroid/view/View;", "", "viewClass", "Lkotlin/reflect/KClass;", "viewType", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KType;)V", "asyncFunctions", "", "", "Lexpo/modules/kotlin/functions/AsyncFunction;", "getAsyncFunctions$annotations", "()V", "getAsyncFunctions", "()Ljava/util/Map;", "setAsyncFunctions", "(Ljava/util/Map;)V", "callbacksDefinition", "Lexpo/modules/kotlin/views/CallbacksDefinition;", "functionBuilders", "Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;", "onViewDestroys", "Lkotlin/Function1;", "", "getOnViewDestroys$annotations", "getOnViewDestroys", "()Lkotlin/jvm/functions/Function1;", "setOnViewDestroys", "(Lkotlin/jvm/functions/Function1;)V", "onViewDidUpdateProps", "getOnViewDidUpdateProps$annotations", "getOnViewDidUpdateProps", "setOnViewDidUpdateProps", "props", "Lexpo/modules/kotlin/views/AnyViewProp;", "getProps$annotations", "getProps", "setProps", "getViewClass$annotations", "getViewClass", "()Lkotlin/reflect/KClass;", "viewGroupDefinition", "Lexpo/modules/kotlin/views/ViewGroupDefinition;", "getViewGroupDefinition$annotations", "getViewGroupDefinition", "()Lexpo/modules/kotlin/views/ViewGroupDefinition;", "setViewGroupDefinition", "(Lexpo/modules/kotlin/views/ViewGroupDefinition;)V", "getViewType$annotations", "getViewType", "()Lkotlin/reflect/KType;", "AsyncFunction", "name", "R", TtmlNode.TAG_BODY, "Lkotlin/Function0;", "AsyncFunctionWithoutArgs", "P0", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "Events", "callbacks", "", "EventsWithArray", "([Ljava/lang/String;)V", "GroupView", "ParentType", "Landroid/view/ViewGroup;", "Lexpo/modules/kotlin/views/ViewGroupDefinitionBuilder;", "Lkotlin/ExtensionFunctionType;", "OnViewDestroys", "view", "ViewType", "OnViewDestroysGeneric", "OnViewDidUpdateProps", "OnViewDidUpdatePropsGeneric", "Prop", "PropType", "prop", "PropGeneric", "build", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "createViewFactory", "Landroid/content/Context;", "Lexpo/modules/kotlin/AppContext;", "getPrimaryConstructor", "Lkotlin/reflect/KFunction;", "handleFailureDuringViewCreation", "context", "appContext", "e", "", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@DefinitionMarker
/* loaded from: classes5.dex */
public final class ViewDefinitionBuilder<T extends View> {
    private Map<String, AsyncFunction> asyncFunctions;
    private CallbacksDefinition callbacksDefinition;
    private Map<String, AsyncFunctionBuilder> functionBuilders;
    private Function1<? super View, Unit> onViewDestroys;
    private Function1<? super View, Unit> onViewDidUpdateProps;
    private Map<String, AnyViewProp> props;
    private final KClass<T> viewClass;
    private ViewGroupDefinition viewGroupDefinition;
    private final KType viewType;

    public static /* synthetic */ void getAsyncFunctions$annotations() {
    }

    public static /* synthetic */ void getOnViewDestroys$annotations() {
    }

    public static /* synthetic */ void getOnViewDidUpdateProps$annotations() {
    }

    public static /* synthetic */ void getProps$annotations() {
    }

    public static /* synthetic */ void getViewClass$annotations() {
    }

    public static /* synthetic */ void getViewGroupDefinition$annotations() {
    }

    public static /* synthetic */ void getViewType$annotations() {
    }

    public ViewDefinitionBuilder(KClass<T> viewClass, KType viewType) {
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        this.viewClass = viewClass;
        this.viewType = viewType;
        this.props = new LinkedHashMap();
        this.asyncFunctions = new LinkedHashMap();
        this.functionBuilders = new LinkedHashMap();
    }

    public final KClass<T> getViewClass() {
        return this.viewClass;
    }

    public final KType getViewType() {
        return this.viewType;
    }

    public final Map<String, AnyViewProp> getProps() {
        return this.props;
    }

    public final void setProps(Map<String, AnyViewProp> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.props = map;
    }

    public final Function1<View, Unit> getOnViewDestroys() {
        return this.onViewDestroys;
    }

    public final void setOnViewDestroys(Function1<? super View, Unit> function1) {
        this.onViewDestroys = function1;
    }

    public final Function1<View, Unit> getOnViewDidUpdateProps() {
        return this.onViewDidUpdateProps;
    }

    public final void setOnViewDidUpdateProps(Function1<? super View, Unit> function1) {
        this.onViewDidUpdateProps = function1;
    }

    public final ViewGroupDefinition getViewGroupDefinition() {
        return this.viewGroupDefinition;
    }

    public final void setViewGroupDefinition(ViewGroupDefinition viewGroupDefinition) {
        this.viewGroupDefinition = viewGroupDefinition;
    }

    public final Map<String, AsyncFunction> getAsyncFunctions() {
        return this.asyncFunctions;
    }

    public final void setAsyncFunctions(Map<String, AsyncFunction> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.asyncFunctions = map;
    }

    public final ViewManagerDefinition build() {
        Map<String, AsyncFunction> map = this.asyncFunctions;
        Map<String, AsyncFunctionBuilder> map2 = this.functionBuilders;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
        Iterator<T> it = map2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((AsyncFunctionBuilder) entry.getValue()).build$expo_modules_core_release());
        }
        Map plus = MapsKt.plus(map, linkedHashMap);
        Iterator it2 = plus.entrySet().iterator();
        while (it2.hasNext()) {
            BaseAsyncFunctionComponent baseAsyncFunctionComponent = (BaseAsyncFunctionComponent) ((Map.Entry) it2.next()).getValue();
            baseAsyncFunctionComponent.runOnQueue(Queues.MAIN);
            baseAsyncFunctionComponent.setOwnerType(this.viewType);
            baseAsyncFunctionComponent.setCanTakeOwner(true);
        }
        return new ViewManagerDefinition(createViewFactory(), JvmClassMappingKt.getJavaClass((KClass) this.viewClass), this.props, this.onViewDestroys, this.callbacksDefinition, this.viewGroupDefinition, this.onViewDidUpdateProps, CollectionsKt.toList(plus.values()));
    }

    public final void OnViewDestroys(final Function1<? super T, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        setOnViewDestroys(new Function1<View, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$OnViewDestroys$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                body.invoke(it);
            }
        });
    }

    public final /* synthetic */ <ViewType extends T> void OnViewDestroysGeneric(final Function1<? super ViewType, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        setOnViewDestroys(new Function1<View, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$OnViewDestroys$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<ViewType, Unit> function1 = body;
                Intrinsics.reifiedOperationMarker(1, "ViewType");
                function1.invoke(it);
            }
        });
    }

    public final void OnViewDidUpdateProps(final Function1<? super T, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        setOnViewDidUpdateProps(new Function1<View, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$OnViewDidUpdateProps$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                body.invoke(it);
            }
        });
    }

    public final /* synthetic */ <ViewType extends T> void OnViewDidUpdatePropsGeneric(final Function1<? super ViewType, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        setOnViewDidUpdateProps(new Function1<View, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$OnViewDidUpdateProps$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<ViewType, Unit> function1 = body;
                Intrinsics.reifiedOperationMarker(1, "ViewType");
                function1.invoke(it);
            }
        });
    }

    public final /* synthetic */ <PropType> void Prop(String name, Function2<? super T, ? super PropType, Unit> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Map<String, AnyViewProp> props = getProps();
        Intrinsics.needClassReification();
        ViewDefinitionBuilder$Prop$1 viewDefinitionBuilder$Prop$1 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$Prop$1
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "PropType");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "PropType");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "PropType");
        props.put(name, new ConcreteViewProp(name, new AnyType(new LazyKType(orCreateKotlinClass, false, viewDefinitionBuilder$Prop$1)), body));
    }

    public final /* synthetic */ <ViewType extends View, PropType> void PropGeneric(String name, Function2<? super ViewType, ? super PropType, Unit> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Map<String, AnyViewProp> props = getProps();
        Intrinsics.needClassReification();
        ViewDefinitionBuilder$Prop$2 viewDefinitionBuilder$Prop$2 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$Prop$2
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "PropType");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "PropType");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "PropType");
        props.put(name, new ConcreteViewProp(name, new AnyType(new LazyKType(orCreateKotlinClass, false, viewDefinitionBuilder$Prop$2)), body));
    }

    public final void Events(String... callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.callbacksDefinition = new CallbacksDefinition(callbacks);
    }

    public final void EventsWithArray(String[] callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.callbacksDefinition = new CallbacksDefinition(callbacks);
    }

    public final /* synthetic */ <ParentType extends ViewGroup> void GroupView(Function1<? super ViewGroupDefinitionBuilder<ParentType>, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        KClass<T> viewClass = getViewClass();
        Intrinsics.reifiedOperationMarker(4, "ParentType");
        Intrinsics.areEqual(viewClass, Reflection.getOrCreateKotlinClass(ViewGroup.class));
        if (!(getViewGroupDefinition() == null)) {
            throw new IllegalArgumentException("The viewManager definition may have exported only one groupView definition.".toString());
        }
        ViewGroupDefinitionBuilder viewGroupDefinitionBuilder = new ViewGroupDefinitionBuilder();
        body.invoke(viewGroupDefinitionBuilder);
        setViewGroupDefinition(viewGroupDefinitionBuilder.build());
    }

    public final AsyncFunction AsyncFunctionWithoutArgs(String name, final Function0<? extends Object> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent(name, new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$1
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
        getAsyncFunctions().put(name, asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R> AsyncFunction AsyncFunction(String name, final Function0<? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent(name, new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$3
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
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$5
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
            ViewDefinitionBuilder$AsyncFunction$6 viewDefinitionBuilder$AsyncFunction$6 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, viewDefinitionBuilder$AsyncFunction$6))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$7
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
            ViewDefinitionBuilder$AsyncFunction$9 viewDefinitionBuilder$AsyncFunction$9 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, viewDefinitionBuilder$AsyncFunction$9))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$10
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
            ViewDefinitionBuilder$AsyncFunction$11 viewDefinitionBuilder$AsyncFunction$11 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$11
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
            ViewDefinitionBuilder$AsyncFunction$12 viewDefinitionBuilder$AsyncFunction$12 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$11)), new AnyType(new LazyKType(orCreateKotlinClass3, false, viewDefinitionBuilder$AsyncFunction$12))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$13
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
            ViewDefinitionBuilder$AsyncFunction$15 viewDefinitionBuilder$AsyncFunction$15 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$15
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
            ViewDefinitionBuilder$AsyncFunction$16 viewDefinitionBuilder$AsyncFunction$16 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, viewDefinitionBuilder$AsyncFunction$15)), new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$16))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$17
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
            ViewDefinitionBuilder$AsyncFunction$18 viewDefinitionBuilder$AsyncFunction$18 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$18
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
            ViewDefinitionBuilder$AsyncFunction$19 viewDefinitionBuilder$AsyncFunction$19 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$19
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
            ViewDefinitionBuilder$AsyncFunction$20 viewDefinitionBuilder$AsyncFunction$20 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass3, false, viewDefinitionBuilder$AsyncFunction$18)), new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$19)), new AnyType(new LazyKType(orCreateKotlinClass5, false, viewDefinitionBuilder$AsyncFunction$20))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$21
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
            ViewDefinitionBuilder$AsyncFunction$23 viewDefinitionBuilder$AsyncFunction$23 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$23
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
            ViewDefinitionBuilder$AsyncFunction$24 viewDefinitionBuilder$AsyncFunction$24 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$24
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
            ViewDefinitionBuilder$AsyncFunction$25 viewDefinitionBuilder$AsyncFunction$25 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$25
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, viewDefinitionBuilder$AsyncFunction$23)), new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$24)), new AnyType(new LazyKType(orCreateKotlinClass3, false, viewDefinitionBuilder$AsyncFunction$25))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$26
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
            ViewDefinitionBuilder$AsyncFunction$27 viewDefinitionBuilder$AsyncFunction$27 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$27
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
            ViewDefinitionBuilder$AsyncFunction$28 viewDefinitionBuilder$AsyncFunction$28 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$28
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
            ViewDefinitionBuilder$AsyncFunction$29 viewDefinitionBuilder$AsyncFunction$29 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$29
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
            ViewDefinitionBuilder$AsyncFunction$30 viewDefinitionBuilder$AsyncFunction$30 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$27)), new AnyType(new LazyKType(orCreateKotlinClass5, false, viewDefinitionBuilder$AsyncFunction$28)), new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$29)), new AnyType(new LazyKType(orCreateKotlinClass7, false, viewDefinitionBuilder$AsyncFunction$30))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$31
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
            ViewDefinitionBuilder$AsyncFunction$33 viewDefinitionBuilder$AsyncFunction$33 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$33
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
            ViewDefinitionBuilder$AsyncFunction$34 viewDefinitionBuilder$AsyncFunction$34 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$34
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
            ViewDefinitionBuilder$AsyncFunction$35 viewDefinitionBuilder$AsyncFunction$35 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$35
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
            ViewDefinitionBuilder$AsyncFunction$36 viewDefinitionBuilder$AsyncFunction$36 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, viewDefinitionBuilder$AsyncFunction$33)), new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$34)), new AnyType(new LazyKType(orCreateKotlinClass3, false, viewDefinitionBuilder$AsyncFunction$35)), new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$36))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$37
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
            ViewDefinitionBuilder$AsyncFunction$38 viewDefinitionBuilder$AsyncFunction$38 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$38
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
            ViewDefinitionBuilder$AsyncFunction$39 viewDefinitionBuilder$AsyncFunction$39 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$39
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
            ViewDefinitionBuilder$AsyncFunction$40 viewDefinitionBuilder$AsyncFunction$40 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$40
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
            ViewDefinitionBuilder$AsyncFunction$41 viewDefinitionBuilder$AsyncFunction$41 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$41
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
            ViewDefinitionBuilder$AsyncFunction$42 viewDefinitionBuilder$AsyncFunction$42 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$42
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass5, false, viewDefinitionBuilder$AsyncFunction$38)), new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$39)), new AnyType(new LazyKType(orCreateKotlinClass7, false, viewDefinitionBuilder$AsyncFunction$40)), new AnyType(new LazyKType(orCreateKotlinClass8, false, viewDefinitionBuilder$AsyncFunction$41)), new AnyType(new LazyKType(orCreateKotlinClass9, false, viewDefinitionBuilder$AsyncFunction$42))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$43
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
            ViewDefinitionBuilder$AsyncFunction$45 viewDefinitionBuilder$AsyncFunction$45 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$45
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
            ViewDefinitionBuilder$AsyncFunction$46 viewDefinitionBuilder$AsyncFunction$46 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$46
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
            ViewDefinitionBuilder$AsyncFunction$47 viewDefinitionBuilder$AsyncFunction$47 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$47
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
            ViewDefinitionBuilder$AsyncFunction$48 viewDefinitionBuilder$AsyncFunction$48 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$48
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
            ViewDefinitionBuilder$AsyncFunction$49 viewDefinitionBuilder$AsyncFunction$49 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$49
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, viewDefinitionBuilder$AsyncFunction$45)), new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$46)), new AnyType(new LazyKType(orCreateKotlinClass3, false, viewDefinitionBuilder$AsyncFunction$47)), new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$48)), new AnyType(new LazyKType(orCreateKotlinClass5, false, viewDefinitionBuilder$AsyncFunction$49))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$50
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
            ViewDefinitionBuilder$AsyncFunction$51 viewDefinitionBuilder$AsyncFunction$51 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$51
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
            ViewDefinitionBuilder$AsyncFunction$52 viewDefinitionBuilder$AsyncFunction$52 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$52
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
            ViewDefinitionBuilder$AsyncFunction$53 viewDefinitionBuilder$AsyncFunction$53 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$53
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
            ViewDefinitionBuilder$AsyncFunction$54 viewDefinitionBuilder$AsyncFunction$54 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$54
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
            ViewDefinitionBuilder$AsyncFunction$55 viewDefinitionBuilder$AsyncFunction$55 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$55
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
            ViewDefinitionBuilder$AsyncFunction$56 viewDefinitionBuilder$AsyncFunction$56 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$56
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$51)), new AnyType(new LazyKType(orCreateKotlinClass7, false, viewDefinitionBuilder$AsyncFunction$52)), new AnyType(new LazyKType(orCreateKotlinClass8, false, viewDefinitionBuilder$AsyncFunction$53)), new AnyType(new LazyKType(orCreateKotlinClass9, false, viewDefinitionBuilder$AsyncFunction$54)), new AnyType(new LazyKType(orCreateKotlinClass10, false, viewDefinitionBuilder$AsyncFunction$55)), new AnyType(new LazyKType(orCreateKotlinClass11, false, viewDefinitionBuilder$AsyncFunction$56))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$57
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
            ViewDefinitionBuilder$AsyncFunction$59 viewDefinitionBuilder$AsyncFunction$59 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$59
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
            ViewDefinitionBuilder$AsyncFunction$60 viewDefinitionBuilder$AsyncFunction$60 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$60
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
            ViewDefinitionBuilder$AsyncFunction$61 viewDefinitionBuilder$AsyncFunction$61 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$61
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
            ViewDefinitionBuilder$AsyncFunction$62 viewDefinitionBuilder$AsyncFunction$62 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$62
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
            ViewDefinitionBuilder$AsyncFunction$63 viewDefinitionBuilder$AsyncFunction$63 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$63
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
            ViewDefinitionBuilder$AsyncFunction$64 viewDefinitionBuilder$AsyncFunction$64 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$64
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, viewDefinitionBuilder$AsyncFunction$59)), new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$60)), new AnyType(new LazyKType(orCreateKotlinClass3, false, viewDefinitionBuilder$AsyncFunction$61)), new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$62)), new AnyType(new LazyKType(orCreateKotlinClass5, false, viewDefinitionBuilder$AsyncFunction$63)), new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$64))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$65
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
            ViewDefinitionBuilder$AsyncFunction$66 viewDefinitionBuilder$AsyncFunction$66 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$66
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
            ViewDefinitionBuilder$AsyncFunction$67 viewDefinitionBuilder$AsyncFunction$67 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$67
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
            ViewDefinitionBuilder$AsyncFunction$68 viewDefinitionBuilder$AsyncFunction$68 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$68
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
            ViewDefinitionBuilder$AsyncFunction$69 viewDefinitionBuilder$AsyncFunction$69 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$69
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
            ViewDefinitionBuilder$AsyncFunction$70 viewDefinitionBuilder$AsyncFunction$70 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$70
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
            ViewDefinitionBuilder$AsyncFunction$71 viewDefinitionBuilder$AsyncFunction$71 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$71
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
            ViewDefinitionBuilder$AsyncFunction$72 viewDefinitionBuilder$AsyncFunction$72 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$72
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass7, false, viewDefinitionBuilder$AsyncFunction$66)), new AnyType(new LazyKType(orCreateKotlinClass8, false, viewDefinitionBuilder$AsyncFunction$67)), new AnyType(new LazyKType(orCreateKotlinClass9, false, viewDefinitionBuilder$AsyncFunction$68)), new AnyType(new LazyKType(orCreateKotlinClass10, false, viewDefinitionBuilder$AsyncFunction$69)), new AnyType(new LazyKType(orCreateKotlinClass11, false, viewDefinitionBuilder$AsyncFunction$70)), new AnyType(new LazyKType(orCreateKotlinClass12, false, viewDefinitionBuilder$AsyncFunction$71)), new AnyType(new LazyKType(orCreateKotlinClass13, false, viewDefinitionBuilder$AsyncFunction$72))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$73
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
            ViewDefinitionBuilder$AsyncFunction$75 viewDefinitionBuilder$AsyncFunction$75 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$75
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
            ViewDefinitionBuilder$AsyncFunction$76 viewDefinitionBuilder$AsyncFunction$76 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$76
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
            ViewDefinitionBuilder$AsyncFunction$77 viewDefinitionBuilder$AsyncFunction$77 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$77
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
            ViewDefinitionBuilder$AsyncFunction$78 viewDefinitionBuilder$AsyncFunction$78 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$78
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
            ViewDefinitionBuilder$AsyncFunction$79 viewDefinitionBuilder$AsyncFunction$79 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$79
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
            ViewDefinitionBuilder$AsyncFunction$80 viewDefinitionBuilder$AsyncFunction$80 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$80
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
            ViewDefinitionBuilder$AsyncFunction$81 viewDefinitionBuilder$AsyncFunction$81 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$81
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, viewDefinitionBuilder$AsyncFunction$75)), new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$76)), new AnyType(new LazyKType(orCreateKotlinClass3, false, viewDefinitionBuilder$AsyncFunction$77)), new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$78)), new AnyType(new LazyKType(orCreateKotlinClass5, false, viewDefinitionBuilder$AsyncFunction$79)), new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$80)), new AnyType(new LazyKType(orCreateKotlinClass7, false, viewDefinitionBuilder$AsyncFunction$81))};
            Intrinsics.needClassReification();
            asyncFunctionComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$82
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
            ViewDefinitionBuilder$AsyncFunction$83 viewDefinitionBuilder$AsyncFunction$83 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$83
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
            ViewDefinitionBuilder$AsyncFunction$84 viewDefinitionBuilder$AsyncFunction$84 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$84
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
            ViewDefinitionBuilder$AsyncFunction$85 viewDefinitionBuilder$AsyncFunction$85 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$85
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
            ViewDefinitionBuilder$AsyncFunction$86 viewDefinitionBuilder$AsyncFunction$86 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$86
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
            ViewDefinitionBuilder$AsyncFunction$87 viewDefinitionBuilder$AsyncFunction$87 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$87
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
            ViewDefinitionBuilder$AsyncFunction$88 viewDefinitionBuilder$AsyncFunction$88 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$88
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
            ViewDefinitionBuilder$AsyncFunction$89 viewDefinitionBuilder$AsyncFunction$89 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$89
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
            ViewDefinitionBuilder$AsyncFunction$90 viewDefinitionBuilder$AsyncFunction$90 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$90
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P7");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P7");
            KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P7");
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(orCreateKotlinClass8, false, viewDefinitionBuilder$AsyncFunction$83)), new AnyType(new LazyKType(orCreateKotlinClass9, false, viewDefinitionBuilder$AsyncFunction$84)), new AnyType(new LazyKType(orCreateKotlinClass10, false, viewDefinitionBuilder$AsyncFunction$85)), new AnyType(new LazyKType(orCreateKotlinClass11, false, viewDefinitionBuilder$AsyncFunction$86)), new AnyType(new LazyKType(orCreateKotlinClass12, false, viewDefinitionBuilder$AsyncFunction$87)), new AnyType(new LazyKType(orCreateKotlinClass13, false, viewDefinitionBuilder$AsyncFunction$88)), new AnyType(new LazyKType(orCreateKotlinClass14, false, viewDefinitionBuilder$AsyncFunction$89)), new AnyType(new LazyKType(orCreateKotlinClass15, false, viewDefinitionBuilder$AsyncFunction$90))};
            Intrinsics.needClassReification();
            str = name;
            asyncFunctionComponent = new AsyncFunctionComponent(str, anyTypeArr2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$91
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
        this.functionBuilders.put(name, asyncFunctionBuilder);
        return asyncFunctionBuilder;
    }

    private final Function2<Context, AppContext, View> createViewFactory() {
        return new Function2<Context, AppContext, View>(this) { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$createViewFactory$1
            final /* synthetic */ ViewDefinitionBuilder<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public final View invoke(Context context, AppContext appContext) {
                Constructor constructor;
                View handleFailureDuringViewCreation;
                View handleFailureDuringViewCreation2;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(appContext, "appContext");
                Constructor constructor2 = null;
                try {
                    constructor = JvmClassMappingKt.getJavaClass(this.this$0.getViewClass()).getConstructor(Context.class, AppContext.class);
                } catch (NoSuchMethodException unused) {
                    constructor = null;
                }
                if (constructor != null) {
                    ViewDefinitionBuilder<T> viewDefinitionBuilder = this.this$0;
                    try {
                        Object newInstance = constructor.newInstance(context, appContext);
                        Intrinsics.checkNotNullExpressionValue(newInstance, "{\n        it.newInstance…text, appContext)\n      }");
                        return (View) newInstance;
                    } catch (Throwable th) {
                        handleFailureDuringViewCreation2 = viewDefinitionBuilder.handleFailureDuringViewCreation(context, appContext, th);
                        return handleFailureDuringViewCreation2;
                    }
                }
                try {
                    constructor2 = JvmClassMappingKt.getJavaClass(this.this$0.getViewClass()).getConstructor(Context.class);
                } catch (NoSuchMethodException unused2) {
                }
                if (constructor2 != null) {
                    ViewDefinitionBuilder<T> viewDefinitionBuilder2 = this.this$0;
                    try {
                        Object newInstance2 = constructor2.newInstance(context);
                        Intrinsics.checkNotNullExpressionValue(newInstance2, "{\n        it.newInstance(context)\n      }");
                        return (View) newInstance2;
                    } catch (Throwable th2) {
                        handleFailureDuringViewCreation = viewDefinitionBuilder2.handleFailureDuringViewCreation(context, appContext, th2);
                        return handleFailureDuringViewCreation;
                    }
                }
                throw new IllegalStateException("Didn't find a correct constructor for " + this.this$0.getViewClass());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View handleFailureDuringViewCreation(Context context, AppContext appContext, Throwable e) {
        UnexpectedException unexpectedException;
        Log.e("ExpoModulesCore", "Couldn't create view of type " + this.viewClass, e);
        ErrorManagerModule errorManager = appContext.getErrorManager();
        if (errorManager != null) {
            if (e instanceof CodedException) {
                unexpectedException = (CodedException) e;
            } else {
                unexpectedException = new UnexpectedException(e);
            }
            errorManager.reportExceptionToLogBox(unexpectedException);
        }
        if (ViewGroup.class.isAssignableFrom(JvmClassMappingKt.getJavaClass((KClass) this.viewClass))) {
            return new ErrorGroupView(context);
        }
        return new ErrorView(context);
    }

    private final KFunction<T> getPrimaryConstructor() {
        KFunction<T> primaryConstructor = KClasses.getPrimaryConstructor(this.viewClass);
        return primaryConstructor != null ? primaryConstructor : (KFunction) CollectionsKt.firstOrNull(this.viewClass.getConstructors());
    }
}
