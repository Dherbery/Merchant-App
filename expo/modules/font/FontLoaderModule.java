package expo.modules.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import androidx.tracing.Trace;
import expo.modules.interfaces.font.FontManagerInterface;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: FontLoaderModule.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lexpo/modules/font/FontLoaderModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "prefix", "", "getPrefix$annotations", "getPrefix", "()Ljava/lang/String;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "queryCustomNativeFonts", "", "expo-font_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public class FontLoaderModule extends Module {
    private final String prefix = "";

    public static /* synthetic */ void getPrefix$annotations() {
    }

    private final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    public String getPrefix() {
        return this.prefix;
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        FontLoaderModule fontLoaderModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (fontLoaderModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(fontLoaderModule);
            moduleDefinitionBuilder.Name("ExpoFontLoader");
            moduleDefinitionBuilder.Constants(TuplesKt.to("customNativeFonts", queryCustomNativeFonts()));
            moduleDefinitionBuilder.getAsyncFunctions().put("loadAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("loadAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$2$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$2$$inlined$AsyncFunction$2
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Typeface createFromFile;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    String str2 = (String) promise;
                    Context reactContext = FontLoaderModule.this.getAppContext().getReactContext();
                    if (reactContext == null) {
                        throw new Exceptions.ReactContextLost();
                    }
                    Object obj2 = null;
                    if (StringsKt.startsWith$default(str2, "asset://", false, 2, (Object) null)) {
                        AssetManager assets = reactContext.getAssets();
                        String substring = str2.substring(9);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        createFromFile = Typeface.createFromAsset(assets, substring);
                        Intrinsics.checkNotNullExpressionValue(createFromFile, "{\n        Typeface.creat…th + 1)\n        )\n      }");
                    } else {
                        String path = Uri.parse(str2).getPath();
                        if (path == null) {
                            throw new FileNotFoundException(str2);
                        }
                        createFromFile = Typeface.createFromFile(new File(path));
                        Intrinsics.checkNotNullExpressionValue(createFromFile, "{\n        val file = Uri…ateFromFile(file)\n      }");
                    }
                    try {
                        obj2 = FontLoaderModule.this.getAppContext().getLegacyModuleRegistry().getModule(FontManagerInterface.class);
                    } catch (Exception unused) {
                    }
                    FontManagerInterface fontManagerInterface = (FontManagerInterface) obj2;
                    if (fontManagerInterface == null) {
                        throw new FontManagerInterfaceNotFoundException();
                    }
                    fontManagerInterface.setTypeface(FontLoaderModule.this.getPrefix() + str, 0, createFromFile);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("loadAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$2$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$2$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$2$$inlined$AsyncFunction$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Typeface createFromFile;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str2 = (String) obj2;
                    Context reactContext = FontLoaderModule.this.getAppContext().getReactContext();
                    if (reactContext == null) {
                        throw new Exceptions.ReactContextLost();
                    }
                    Object obj3 = null;
                    if (StringsKt.startsWith$default(str2, "asset://", false, 2, (Object) null)) {
                        AssetManager assets = reactContext.getAssets();
                        String substring = str2.substring(9);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        createFromFile = Typeface.createFromAsset(assets, substring);
                        Intrinsics.checkNotNullExpressionValue(createFromFile, "{\n        Typeface.creat…th + 1)\n        )\n      }");
                    } else {
                        String path = Uri.parse(str2).getPath();
                        if (path == null) {
                            throw new FileNotFoundException(str2);
                        }
                        createFromFile = Typeface.createFromFile(new File(path));
                        Intrinsics.checkNotNullExpressionValue(createFromFile, "{\n        val file = Uri…ateFromFile(file)\n      }");
                    }
                    try {
                        obj3 = FontLoaderModule.this.getAppContext().getLegacyModuleRegistry().getModule(FontManagerInterface.class);
                    } catch (Exception unused) {
                    }
                    FontManagerInterface fontManagerInterface = (FontManagerInterface) obj3;
                    if (fontManagerInterface == null) {
                        throw new FontManagerInterfaceNotFoundException();
                    }
                    fontManagerInterface.setTypeface(FontLoaderModule.this.getPrefix() + str, 0, createFromFile);
                    return Unit.INSTANCE;
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> queryCustomNativeFonts() {
        List<String> groupValues;
        AssetManager assets = getContext().getAssets();
        Regex regex = new Regex("^(.+?)(_bold|_italic|_bold_italic)?\\.(ttf|otf)$");
        String[] list = assets.list("fonts/");
        ArrayList arrayList = null;
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            for (String fileName : list) {
                Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
                MatchResult find$default = Regex.find$default(regex, fileName, 0, 2, null);
                String str = (find$default == null || (groupValues = find$default.getGroupValues()) == null) ? null : groupValues.get(1);
                if (str != null) {
                    arrayList2.add(str);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : arrayList2) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList3.add(obj);
                }
            }
            arrayList = arrayList3;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }
}
