package expo.modules.annotationprocessor;

import com.google.devtools.ksp.UtilsKt;
import com.google.devtools.ksp.processing.CodeGenerator;
import com.google.devtools.ksp.processing.Dependencies;
import com.google.devtools.ksp.processing.KSPLogger;
import com.google.devtools.ksp.symbol.FunctionKind;
import com.google.devtools.ksp.symbol.KSFile;
import com.google.devtools.ksp.symbol.KSFunctionDeclaration;
import com.google.devtools.ksp.symbol.KSType;
import com.google.devtools.ksp.symbol.KSTypeArgument;
import com.google.devtools.ksp.symbol.KSTypeReference;
import com.google.devtools.ksp.symbol.KSValueParameter;
import com.google.devtools.ksp.symbol.KSVisitorVoid;
import com.google.devtools.ksp.symbol.Visibility;
import com.squareup.kotlinpoet.ClassName;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.FileSpec;
import com.squareup.kotlinpoet.FunSpec;
import com.squareup.kotlinpoet.KModifier;
import com.squareup.kotlinpoet.ParameterizedTypeName;
import com.squareup.kotlinpoet.TypeSpec;
import com.squareup.kotlinpoet.ksp.KsTypesKt;
import expo.modules.annotation.Config;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExpoSymbolProcessor.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lexpo/modules/annotationprocessor/ConverterBinderVisitor;", "Lcom/google/devtools/ksp/symbol/KSVisitorVoid;", "clazz", "Lcom/squareup/kotlinpoet/ClassName;", "codeGenerator", "Lcom/google/devtools/ksp/processing/CodeGenerator;", "logger", "Lcom/google/devtools/ksp/processing/KSPLogger;", "(Lcom/squareup/kotlinpoet/ClassName;Lcom/google/devtools/ksp/processing/CodeGenerator;Lcom/google/devtools/ksp/processing/KSPLogger;)V", "createFileDependencies", "Lcom/google/devtools/ksp/processing/Dependencies;", "function", "Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;", "generateConverterProvider", "Lcom/squareup/kotlinpoet/FileSpec;", "packageName", "", "className", "forType", "receivesType", "", "resolveConverterType", "shouldReceiveType", "(Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;)Ljava/lang/Boolean;", "visitFunctionDeclaration", "", "data", "(Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;Lkotlin/Unit;)V", "expo-modules-core$android-annotation-processor"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConverterBinderVisitor extends KSVisitorVoid {
    private final ClassName clazz;
    private final CodeGenerator codeGenerator;
    private final KSPLogger logger;

    @Override // com.google.devtools.ksp.symbol.KSVisitorVoid, com.google.devtools.ksp.symbol.KSVisitor
    public /* bridge */ /* synthetic */ Unit visitFunctionDeclaration(KSFunctionDeclaration kSFunctionDeclaration, Unit unit) {
        visitFunctionDeclaration2(kSFunctionDeclaration, unit);
        return Unit.INSTANCE;
    }

    public ConverterBinderVisitor(ClassName className, CodeGenerator codeGenerator, KSPLogger logger) {
        Intrinsics.checkNotNullParameter(codeGenerator, "codeGenerator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.clazz = className;
        this.codeGenerator = codeGenerator;
        this.logger = logger;
    }

    @Override // com.google.devtools.ksp.symbol.KSVisitorVoid
    /* renamed from: visitFunctionDeclaration, reason: avoid collision after fix types in other method */
    public void visitFunctionDeclaration2(KSFunctionDeclaration function, Unit data) {
        Boolean shouldReceiveType;
        Intrinsics.checkNotNullParameter(function, "function");
        Intrinsics.checkNotNullParameter(data, "data");
        if (function.getFunctionKind() != FunctionKind.TOP_LEVEL || UtilsKt.getVisibility(function) != Visibility.PUBLIC) {
            this.logger.error("ConverterBinder has to be a public top-level function", function);
            return;
        }
        ClassName resolveConverterType = resolveConverterType(function);
        if (resolveConverterType == null || (shouldReceiveType = shouldReceiveType(function)) == null) {
            return;
        }
        boolean booleanValue = shouldReceiveType.booleanValue();
        String str = Config.packageNamePrefix + resolveConverterType.getPackageName();
        String str2 = resolveConverterType.getSimpleName() + Config.classNameSuffix;
        FileSpec generateConverterProvider = generateConverterProvider(str, str2, function, resolveConverterType, booleanValue);
        KSPLogger.CC.info$default(this.logger, "Generating: " + str + "." + str2, null, 2, null);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(CodeGenerator.CC.createNewFile$default(this.codeGenerator, createFileDependencies(function), str, str2, null, 8, null), StandardCharsets.UTF_8);
        try {
            generateConverterProvider.writeTo(outputStreamWriter);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStreamWriter, null);
        } finally {
        }
    }

    private final Boolean shouldReceiveType(KSFunctionDeclaration function) {
        KSTypeReference type;
        int size = function.getParameters().size();
        String str = null;
        if (size != 0 && size != 1) {
            this.logger.error("ConverterBinder cannot receive more then one argument", function);
            return null;
        }
        KSValueParameter kSValueParameter = (KSValueParameter) CollectionsKt.firstOrNull((List) function.getParameters());
        if (kSValueParameter != null && (type = kSValueParameter.getType()) != null) {
            str = type.toString();
        }
        return Boolean.valueOf(Intrinsics.areEqual(str, "KType"));
    }

    private final Dependencies createFileDependencies(KSFunctionDeclaration function) {
        KSFile containingFile = function.getContainingFile();
        if (containingFile == null) {
            return new Dependencies(false, new KSFile[0]);
        }
        return new Dependencies(false, containingFile);
    }

    private final ClassName resolveConverterType(KSFunctionDeclaration function) {
        ClassName className = this.clazz;
        if (className != null) {
            return className;
        }
        KSTypeReference returnType = function.getReturnType();
        KSType resolve = returnType != null ? returnType.resolve() : null;
        if (resolve == null) {
            this.logger.error("Cannot resolve return type", function);
            return null;
        }
        if (resolve.getArguments().size() != 1) {
            this.logger.error("Incorrect return type", function);
            return null;
        }
        KSTypeReference type = ((KSTypeArgument) CollectionsKt.first((List) resolve.getArguments())).getType();
        KSType resolve2 = type != null ? type.resolve() : null;
        if (resolve2 == null) {
            this.logger.error("Cannot resolve converter inner type", function);
            return null;
        }
        return KsTypesKt.toClassName(resolve2);
    }

    private final FileSpec generateConverterProvider(String packageName, String className, KSFunctionDeclaration function, ClassName forType, boolean receivesType) {
        ParameterizedTypeName parameterizedTypeName = ParameterizedTypeName.INSTANCE.get(new ClassName("expo.modules.kotlin.types", "TypeConverter"), forType);
        ClassName className2 = new ClassName("kotlin.reflect", "KType");
        FileSpec.Builder builder = FileSpec.INSTANCE.builder(packageName, className);
        TypeSpec.Builder classBuilder = TypeSpec.INSTANCE.classBuilder(className);
        FunSpec.Builder returns$default = FunSpec.Builder.returns$default(FunSpec.INSTANCE.builder(Config.converterProviderFunctionName).addParameter("type", className2, new KModifier[0]), parameterizedTypeName, (CodeBlock) null, 2, (Object) null);
        if (receivesType) {
            returns$default.addStatement("return " + function.getPackageName().asString() + "." + function.getSimpleName().asString() + "(type)", new Object[0]);
        } else {
            returns$default.addStatement("return " + function.getPackageName().asString() + "." + function.getSimpleName().asString() + "()", new Object[0]);
        }
        Unit unit = Unit.INSTANCE;
        return builder.addType(classBuilder.addFunction(returns$default.build()).build()).build();
    }
}
