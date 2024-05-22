package com.google.devtools.ksp.processing;

import java.util.List;
import java.util.Map;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SymbolProcessorEnvironment.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B3\b\u0016\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bBO\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/google/devtools/ksp/processing/SymbolProcessorEnvironment;", "", "options", "", "", "kotlinVersion", "Lkotlin/KotlinVersion;", "codeGenerator", "Lcom/google/devtools/ksp/processing/CodeGenerator;", "logger", "Lcom/google/devtools/ksp/processing/KSPLogger;", "(Ljava/util/Map;Lkotlin/KotlinVersion;Lcom/google/devtools/ksp/processing/CodeGenerator;Lcom/google/devtools/ksp/processing/KSPLogger;)V", "apiVersion", "compilerVersion", "platforms", "", "Lcom/google/devtools/ksp/processing/PlatformInfo;", "(Ljava/util/Map;Lkotlin/KotlinVersion;Lcom/google/devtools/ksp/processing/CodeGenerator;Lcom/google/devtools/ksp/processing/KSPLogger;Lkotlin/KotlinVersion;Lkotlin/KotlinVersion;Ljava/util/List;)V", "getApiVersion", "()Lkotlin/KotlinVersion;", "getCodeGenerator", "()Lcom/google/devtools/ksp/processing/CodeGenerator;", "getCompilerVersion", "getKotlinVersion", "getLogger", "()Lcom/google/devtools/ksp/processing/KSPLogger;", "getOptions", "()Ljava/util/Map;", "getPlatforms", "()Ljava/util/List;", "api"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SymbolProcessorEnvironment {
    private final KotlinVersion apiVersion;
    private final CodeGenerator codeGenerator;
    private final KotlinVersion compilerVersion;
    private final KotlinVersion kotlinVersion;
    private final KSPLogger logger;
    private final Map<String, String> options;
    private final List<PlatformInfo> platforms;

    /* JADX WARN: Multi-variable type inference failed */
    public SymbolProcessorEnvironment(Map<String, String> options, KotlinVersion kotlinVersion, CodeGenerator codeGenerator, KSPLogger logger, KotlinVersion apiVersion, KotlinVersion compilerVersion, List<? extends PlatformInfo> platforms) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(kotlinVersion, "kotlinVersion");
        Intrinsics.checkNotNullParameter(codeGenerator, "codeGenerator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(apiVersion, "apiVersion");
        Intrinsics.checkNotNullParameter(compilerVersion, "compilerVersion");
        Intrinsics.checkNotNullParameter(platforms, "platforms");
        this.options = options;
        this.kotlinVersion = kotlinVersion;
        this.codeGenerator = codeGenerator;
        this.logger = logger;
        this.apiVersion = apiVersion;
        this.compilerVersion = compilerVersion;
        this.platforms = platforms;
    }

    public final Map<String, String> getOptions() {
        return this.options;
    }

    public final KotlinVersion getKotlinVersion() {
        return this.kotlinVersion;
    }

    public final CodeGenerator getCodeGenerator() {
        return this.codeGenerator;
    }

    public final KSPLogger getLogger() {
        return this.logger;
    }

    public final KotlinVersion getApiVersion() {
        return this.apiVersion;
    }

    public final KotlinVersion getCompilerVersion() {
        return this.compilerVersion;
    }

    public final List<PlatformInfo> getPlatforms() {
        return this.platforms;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SymbolProcessorEnvironment(Map<String, String> options, KotlinVersion kotlinVersion, CodeGenerator codeGenerator, KSPLogger logger) {
        this(options, kotlinVersion, codeGenerator, logger, kotlinVersion, kotlinVersion, CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(kotlinVersion, "kotlinVersion");
        Intrinsics.checkNotNullParameter(codeGenerator, "codeGenerator");
        Intrinsics.checkNotNullParameter(logger, "logger");
    }
}
