package expo.modules.kotlin.defaultmodules;

import androidx.tracing.Trace;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.uuidv5.InvalidNamespaceException;
import expo.modules.kotlin.uuidv5.Uuidv5Kt;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: CoreModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/defaultmodules/CoreModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CoreModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        CoreModule coreModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (coreModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(coreModule);
            moduleDefinitionBuilder.getSyncFunctions().put("uuidv4", new SyncFunctionComponent("uuidv4", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$2$$inlined$FunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return UUID.randomUUID().toString();
                }
            }));
            moduleDefinitionBuilder.getSyncFunctions().put("uuidv5", new SyncFunctionComponent("uuidv5", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$2$$inlined$Function$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$2$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$2$$inlined$Function$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
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
                    try {
                        UUID namespaceUUID = UUID.fromString(str2);
                        Intrinsics.checkNotNullExpressionValue(namespaceUUID, "namespaceUUID");
                        return Uuidv5Kt.uuidv5(namespaceUUID, str).toString();
                    } catch (IllegalArgumentException unused) {
                        throw new InvalidNamespaceException(str2);
                    }
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
