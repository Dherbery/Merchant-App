package expo.modules.crypto;

import android.util.Base64;
import androidx.tracing.Trace;
import expo.modules.crypto.DigestOptions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.typedarray.TypedArray;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;

/* compiled from: CryptoModule.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0010H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"Lexpo/modules/crypto/CryptoModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "secureRandom", "Ljava/security/SecureRandom;", "getSecureRandom", "()Ljava/security/SecureRandom;", "secureRandom$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "digest", "", "algorithm", "Lexpo/modules/crypto/DigestAlgorithm;", "output", "Lexpo/modules/kotlin/typedarray/TypedArray;", "data", "digestString", "", "options", "Lexpo/modules/crypto/DigestOptions;", "getRandomBase64String", "randomByteCount", "", "getRandomValues", "typedArray", "expo-crypto_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CryptoModule extends Module {

    /* renamed from: secureRandom$delegate, reason: from kotlin metadata */
    private final Lazy secureRandom = LazyKt.lazy(new Function0<SecureRandom>() { // from class: expo.modules.crypto.CryptoModule$secureRandom$2
        @Override // kotlin.jvm.functions.Function0
        public final SecureRandom invoke() {
            return new SecureRandom();
        }
    });

    /* compiled from: CryptoModule.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DigestOptions.Encoding.values().length];
            try {
                iArr[DigestOptions.Encoding.BASE64.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DigestOptions.Encoding.HEX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final SecureRandom getSecureRandom() {
        return (SecureRandom) this.secureRandom.getValue();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        CryptoModule cryptoModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (cryptoModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(cryptoModule);
            moduleDefinitionBuilder.Name("ExpoCrypto");
            moduleDefinitionBuilder.getSyncFunctions().put("digestString", new SyncFunctionComponent("digestString", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestAlgorithm.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(DigestAlgorithm.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestOptions.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(DigestOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String digestString;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.crypto.DigestAlgorithm");
                    }
                    DigestAlgorithm digestAlgorithm = (DigestAlgorithm) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj2;
                    Object obj3 = it[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.crypto.DigestOptions");
                    }
                    digestString = CryptoModule.this.digestString(digestAlgorithm, str, (DigestOptions) obj3);
                    return digestString;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("digestStringAsync", DigestOptions.class == Promise.class ? new AsyncFunctionWithPromiseComponent("digestStringAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestAlgorithm.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(DigestAlgorithm.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$3
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.crypto.DigestAlgorithm");
                    }
                    DigestAlgorithm digestAlgorithm = (DigestAlgorithm) obj;
                    Object obj2 = args[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    CryptoModule.this.digestString(digestAlgorithm, (String) obj2, (DigestOptions) promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("digestStringAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestAlgorithm.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(DigestAlgorithm.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestOptions.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(DigestOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$7
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String digestString;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.crypto.DigestAlgorithm");
                    }
                    DigestAlgorithm digestAlgorithm = (DigestAlgorithm) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj2;
                    Object obj3 = it[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.crypto.DigestOptions");
                    }
                    digestString = CryptoModule.this.digestString(digestAlgorithm, str, (DigestOptions) obj3);
                    return digestString;
                }
            }));
            moduleDefinitionBuilder.getSyncFunctions().put("getRandomBase64String", new SyncFunctionComponent("getRandomBase64String", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String randomBase64String;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        randomBase64String = CryptoModule.this.getRandomBase64String(((Integer) obj).intValue());
                        return randomBase64String;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getRandomBase64StringAsync", Integer.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getRandomBase64StringAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$8
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    CryptoModule.this.getRandomBase64String(((Integer) promise).intValue());
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getRandomBase64StringAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$10
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String randomBase64String;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        randomBase64String = CryptoModule.this.getRandomBase64String(((Integer) obj).intValue());
                        return randomBase64String;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            }));
            moduleDefinitionBuilder.getSyncFunctions().put("getRandomValues", new SyncFunctionComponent("getRandomValues", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(TypedArray.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(TypedArray.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$8
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.typedarray.TypedArray");
                    }
                    CryptoModule.this.getRandomValues((TypedArray) obj);
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getSyncFunctions().put("digest", new SyncFunctionComponent("digest", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestAlgorithm.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(DigestAlgorithm.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(TypedArray.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(TypedArray.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(TypedArray.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(TypedArray.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$12
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.crypto.DigestAlgorithm");
                    }
                    DigestAlgorithm digestAlgorithm = (DigestAlgorithm) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.typedarray.TypedArray");
                    }
                    TypedArray typedArray = (TypedArray) obj2;
                    Object obj3 = it[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.typedarray.TypedArray");
                    }
                    CryptoModule.this.digest(digestAlgorithm, typedArray, (TypedArray) obj3);
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getSyncFunctions().put("randomUUID", new SyncFunctionComponent("randomUUID", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$FunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return UUID.randomUUID().toString();
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getRandomBase64String(int randomByteCount) {
        byte[] bArr = new byte[randomByteCount];
        getSecureRandom().nextBytes(bArr);
        String encodeToString = Base64.encodeToString(bArr, 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(output, Base64.NO_WRAP)");
        return encodeToString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String digestString(DigestAlgorithm algorithm, String data, DigestOptions options) {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm.getValue());
        byte[] bytes = data.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "messageDigest.digest()");
        int i = WhenMappings.$EnumSwitchMapping$0[options.getEncoding().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: expo.modules.crypto.CryptoModule$digestString$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                        return invoke(b.byteValue());
                    }

                    public final CharSequence invoke(byte b) {
                        String num = Integer.toString((b & 255) + 256, CharsKt.checkRadix(16));
                        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                        String substring = num.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        return substring;
                    }
                }, 30, (Object) null);
            }
            throw new NoWhenBranchMatchedException();
        }
        String encodeToString = Base64.encodeToString(digest, 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "{\n        Base64.encodeT…, Base64.NO_WRAP)\n      }");
        return encodeToString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void digest(DigestAlgorithm algorithm, TypedArray output, TypedArray data) {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm.getValue());
        messageDigest.update(data.toDirectBuffer());
        byte[] digest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "messageDigest.digest()");
        output.write(digest, output.getByteOffset(), output.getByteLength());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getRandomValues(TypedArray typedArray) {
        byte[] bArr = new byte[typedArray.getByteLength()];
        getSecureRandom().nextBytes(bArr);
        typedArray.write(bArr, typedArray.getByteOffset(), typedArray.getByteLength());
    }
}
