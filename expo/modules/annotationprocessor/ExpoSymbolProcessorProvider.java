package expo.modules.annotationprocessor;

import com.google.devtools.ksp.processing.SymbolProcessor;
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment;
import com.google.devtools.ksp.processing.SymbolProcessorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExpoSymbolProcessorProvider.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lexpo/modules/annotationprocessor/ExpoSymbolProcessorProvider;", "Lcom/google/devtools/ksp/processing/SymbolProcessorProvider;", "()V", "create", "Lcom/google/devtools/ksp/processing/SymbolProcessor;", "environment", "Lcom/google/devtools/ksp/processing/SymbolProcessorEnvironment;", "expo-modules-core$android-annotation-processor"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpoSymbolProcessorProvider implements SymbolProcessorProvider {
    @Override // com.google.devtools.ksp.processing.SymbolProcessorProvider
    public SymbolProcessor create(SymbolProcessorEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        return new ExpoSymbolProcessor(environment.getCodeGenerator(), environment.getLogger());
    }
}
