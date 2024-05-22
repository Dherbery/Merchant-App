package com.google.crypto.tink;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes5.dex */
public final class Registry {
    private static final Logger logger = Logger.getLogger(Registry.class.getName());
    private static final AtomicReference<KeyManagerRegistry> keyManagerRegistry = new AtomicReference<>(new KeyManagerRegistry());
    private static final ConcurrentMap<String, KeyDeriverContainer> keyDeriverMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> newKeyAllowedMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Catalogue<?>> catalogueMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, KeyTemplate> keyTemplateMap = new ConcurrentHashMap();

    /* loaded from: classes5.dex */
    private interface KeyDeriverContainer {
        KeyData deriveKey(ByteString serializedKeyFormat, InputStream stream) throws GeneralSecurityException;
    }

    private static <KeyProtoT extends MessageLite> KeyDeriverContainer createDeriverFor(final KeyTypeManager<KeyProtoT> keyManager) {
        return new KeyDeriverContainer() { // from class: com.google.crypto.tink.Registry.1
            /* JADX WARN: Unknown type variable: KeyProtoT in type: com.google.crypto.tink.internal.KeyTypeManager$KeyFactory<KeyFormatProtoT extends com.google.crypto.tink.shaded.protobuf.MessageLite, KeyProtoT> */
            private <KeyFormatProtoT extends MessageLite> MessageLite deriveKeyWithFactory(ByteString serializedKeyFormat, InputStream stream, KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory) throws GeneralSecurityException {
                try {
                    KeyFormatProtoT parseKeyFormat = keyFactory.parseKeyFormat(serializedKeyFormat);
                    keyFactory.validateKeyFormat(parseKeyFormat);
                    return keyFactory.deriveKey(parseKeyFormat, stream);
                } catch (InvalidProtocolBufferException e) {
                    throw new GeneralSecurityException("parsing key format failed in deriveKey", e);
                }
            }

            @Override // com.google.crypto.tink.Registry.KeyDeriverContainer
            public KeyData deriveKey(ByteString serializedKeyFormat, InputStream stream) throws GeneralSecurityException {
                return (KeyData) KeyData.newBuilder().setTypeUrl(KeyTypeManager.this.getKeyType()).setValue(deriveKeyWithFactory(serializedKeyFormat, stream, KeyTypeManager.this.keyFactory()).toByteString()).setKeyMaterialType(KeyTypeManager.this.keyMaterialType()).build();
            }
        };
    }

    static synchronized void reset() {
        synchronized (Registry.class) {
            keyManagerRegistry.set(new KeyManagerRegistry());
            MutablePrimitiveRegistry.resetGlobalInstanceTestOnly();
            keyDeriverMap.clear();
            newKeyAllowedMap.clear();
            catalogueMap.clear();
            keyTemplateMap.clear();
        }
    }

    @Deprecated
    public static synchronized void addCatalogue(String catalogueName, Catalogue<?> catalogue) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (catalogueName == null) {
                throw new IllegalArgumentException("catalogueName must be non-null.");
            }
            if (catalogue == null) {
                throw new IllegalArgumentException("catalogue must be non-null.");
            }
            ConcurrentMap<String, Catalogue<?>> concurrentMap = catalogueMap;
            if (concurrentMap.containsKey(catalogueName.toLowerCase(Locale.US))) {
                if (!catalogue.getClass().getName().equals(concurrentMap.get(catalogueName.toLowerCase(Locale.US)).getClass().getName())) {
                    logger.warning("Attempted overwrite of a catalogueName catalogue for name " + catalogueName);
                    throw new GeneralSecurityException("catalogue for name " + catalogueName + " has been already registered");
                }
            }
            concurrentMap.put(catalogueName.toLowerCase(Locale.US), catalogue);
        }
    }

    @Deprecated
    public static Catalogue<?> getCatalogue(String catalogueName) throws GeneralSecurityException {
        if (catalogueName == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        Catalogue<?> catalogue = catalogueMap.get(catalogueName.toLowerCase(Locale.US));
        if (catalogue != null) {
            return catalogue;
        }
        String format = String.format("no catalogue found for %s. ", catalogueName);
        if (catalogueName.toLowerCase(Locale.US).startsWith("tinkaead")) {
            format = format + "Maybe call AeadConfig.register().";
        }
        if (catalogueName.toLowerCase(Locale.US).startsWith("tinkdeterministicaead")) {
            format = format + "Maybe call DeterministicAeadConfig.register().";
        } else if (catalogueName.toLowerCase(Locale.US).startsWith("tinkstreamingaead")) {
            format = format + "Maybe call StreamingAeadConfig.register().";
        } else if (catalogueName.toLowerCase(Locale.US).startsWith("tinkhybriddecrypt") || catalogueName.toLowerCase(Locale.US).startsWith("tinkhybridencrypt")) {
            format = format + "Maybe call HybridConfig.register().";
        } else if (catalogueName.toLowerCase(Locale.US).startsWith("tinkmac")) {
            format = format + "Maybe call MacConfig.register().";
        } else if (catalogueName.toLowerCase(Locale.US).startsWith("tinkpublickeysign") || catalogueName.toLowerCase(Locale.US).startsWith("tinkpublickeyverify")) {
            format = format + "Maybe call SignatureConfig.register().";
        } else if (catalogueName.toLowerCase(Locale.US).startsWith("tink")) {
            format = format + "Maybe call TinkConfig.register().";
        }
        throw new GeneralSecurityException(format);
    }

    public static synchronized <P> void registerKeyManager(final KeyManager<P> manager) throws GeneralSecurityException {
        synchronized (Registry.class) {
            registerKeyManager((KeyManager) manager, true);
        }
    }

    public static synchronized <P> void registerKeyManager(final KeyManager<P> manager, boolean newKeyAllowed) throws GeneralSecurityException {
        synchronized (Registry.class) {
            try {
                if (manager == null) {
                    throw new IllegalArgumentException("key manager must be non-null.");
                }
                AtomicReference<KeyManagerRegistry> atomicReference = keyManagerRegistry;
                KeyManagerRegistry keyManagerRegistry2 = new KeyManagerRegistry(atomicReference.get());
                keyManagerRegistry2.registerKeyManager(manager);
                if (!TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
                    throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");
                }
                String keyType = manager.getKeyType();
                ensureKeyManagerInsertable(keyType, Collections.emptyMap(), newKeyAllowed);
                newKeyAllowedMap.put(keyType, Boolean.valueOf(newKeyAllowed));
                atomicReference.set(keyManagerRegistry2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized <KeyProtoT extends MessageLite> void registerKeyManager(final KeyTypeManager<KeyProtoT> manager, boolean newKeyAllowed) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (manager == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            AtomicReference<KeyManagerRegistry> atomicReference = keyManagerRegistry;
            KeyManagerRegistry keyManagerRegistry2 = new KeyManagerRegistry(atomicReference.get());
            keyManagerRegistry2.registerKeyManager(manager);
            String keyType = manager.getKeyType();
            ensureKeyManagerInsertable(keyType, newKeyAllowed ? manager.keyFactory().keyFormats() : Collections.emptyMap(), newKeyAllowed);
            if (!atomicReference.get().typeUrlExists(keyType)) {
                keyDeriverMap.put(keyType, createDeriverFor(manager));
                if (newKeyAllowed) {
                    registerKeyTemplates(keyType, manager.keyFactory().keyFormats());
                }
            }
            newKeyAllowedMap.put(keyType, Boolean.valueOf(newKeyAllowed));
            atomicReference.set(keyManagerRegistry2);
        }
    }

    @Deprecated
    public static synchronized <P> void registerKeyManager(String typeUrl, final KeyManager<P> manager) throws GeneralSecurityException {
        synchronized (Registry.class) {
            registerKeyManager(typeUrl, manager, true);
        }
    }

    @Deprecated
    public static synchronized <P> void registerKeyManager(String typeUrl, final KeyManager<P> manager, boolean newKeyAllowed) throws GeneralSecurityException {
        synchronized (Registry.class) {
            try {
                if (manager == null) {
                    throw new IllegalArgumentException("key manager must be non-null.");
                }
                if (!typeUrl.equals(manager.getKeyType())) {
                    throw new GeneralSecurityException("Manager does not support key type " + typeUrl + ".");
                }
                registerKeyManager(manager, newKeyAllowed);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004f, code lost:
    
        r6 = r5.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x005f, code lost:
    
        if (com.google.crypto.tink.Registry.keyTemplateMap.containsKey(r6.getKey()) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0086, code lost:
    
        throw new java.security.GeneralSecurityException("Attempted to register a new key template " + r6.getKey() + " from an existing key manager of type " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0087, code lost:
    
        r4 = r5.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0093, code lost:
    
        if (r4.hasNext() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0095, code lost:
    
        r5 = r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a5, code lost:
    
        if (com.google.crypto.tink.Registry.keyTemplateMap.containsKey(r5.getKey()) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c4, code lost:
    
        throw new java.security.GeneralSecurityException("Attempted overwrite of a registered key template " + r5.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x003f, code lost:
    
        if (com.google.crypto.tink.Registry.keyManagerRegistry.get().typeUrlExists(r4) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0041, code lost:
    
        r5 = r5.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004d, code lost:
    
        if (r5.hasNext() == false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized <KeyProtoT extends com.google.crypto.tink.shaded.protobuf.MessageLite, KeyFormatProtoT extends com.google.crypto.tink.shaded.protobuf.MessageLite> void ensureKeyManagerInsertable(java.lang.String r4, java.util.Map<java.lang.String, com.google.crypto.tink.internal.KeyTypeManager.KeyFactory.KeyFormat<KeyFormatProtoT>> r5, boolean r6) throws java.security.GeneralSecurityException {
        /*
            java.lang.String r0 = "New keys are already disallowed for key type "
            java.lang.Class<com.google.crypto.tink.Registry> r1 = com.google.crypto.tink.Registry.class
            monitor-enter(r1)
            if (r6 == 0) goto L31
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r2 = com.google.crypto.tink.Registry.newKeyAllowedMap     // Catch: java.lang.Throwable -> L2e
            boolean r3 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto L31
            java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L2e
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L2e
            if (r2 == 0) goto L1c
            goto L31
        L1c:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L2e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L2e
            r6.append(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> L2e
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L2e
            throw r5     // Catch: java.lang.Throwable -> L2e
        L2e:
            r4 = move-exception
            goto Lc5
        L31:
            if (r6 == 0) goto Lc7
            java.util.concurrent.atomic.AtomicReference<com.google.crypto.tink.KeyManagerRegistry> r6 = com.google.crypto.tink.Registry.keyManagerRegistry     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r6 = r6.get()     // Catch: java.lang.Throwable -> L2e
            com.google.crypto.tink.KeyManagerRegistry r6 = (com.google.crypto.tink.KeyManagerRegistry) r6     // Catch: java.lang.Throwable -> L2e
            boolean r6 = r6.typeUrlExists(r4)     // Catch: java.lang.Throwable -> L2e
            if (r6 == 0) goto L87
            java.util.Set r5 = r5.entrySet()     // Catch: java.lang.Throwable -> L2e
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L2e
        L49:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Throwable -> L2e
            if (r6 == 0) goto Lc7
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Throwable -> L2e
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch: java.lang.Throwable -> L2e
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.crypto.tink.KeyTemplate> r0 = com.google.crypto.tink.Registry.keyTemplateMap     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r2 = r6.getKey()     // Catch: java.lang.Throwable -> L2e
            boolean r0 = r0.containsKey(r2)     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L62
            goto L49
        L62:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L2e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r0.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r2 = "Attempted to register a new key template "
            r0.append(r2)     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r6 = r6.getKey()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L2e
            r0.append(r6)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r6 = " from an existing key manager of type "
            r0.append(r6)     // Catch: java.lang.Throwable -> L2e
            r0.append(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L2e
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L2e
            throw r5     // Catch: java.lang.Throwable -> L2e
        L87:
            java.util.Set r4 = r5.entrySet()     // Catch: java.lang.Throwable -> L2e
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L2e
        L8f:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L2e
            if (r5 == 0) goto Lc7
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> L2e
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Throwable -> L2e
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.crypto.tink.KeyTemplate> r6 = com.google.crypto.tink.Registry.keyTemplateMap     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r0 = r5.getKey()     // Catch: java.lang.Throwable -> L2e
            boolean r6 = r6.containsKey(r0)     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto La8
            goto L8f
        La8:
            java.security.GeneralSecurityException r4 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L2e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r6.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r0 = "Attempted overwrite of a registered key template "
            r6.append(r0)     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r5 = r5.getKey()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L2e
            r6.append(r5)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L2e
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L2e
            throw r4     // Catch: java.lang.Throwable -> L2e
        Lc5:
            monitor-exit(r1)
            throw r4
        Lc7:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.Registry.ensureKeyManagerInsertable(java.lang.String, java.util.Map, boolean):void");
    }

    public static synchronized <KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> void registerAsymmetricKeyManagers(final PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyTypeManager, final KeyTypeManager<PublicKeyProtoT> publicKeyTypeManager, boolean newKeyAllowed) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (privateKeyTypeManager == null || publicKeyTypeManager == null) {
                throw new IllegalArgumentException("given key managers must be non-null.");
            }
            AtomicReference<KeyManagerRegistry> atomicReference = keyManagerRegistry;
            KeyManagerRegistry keyManagerRegistry2 = new KeyManagerRegistry(atomicReference.get());
            keyManagerRegistry2.registerAsymmetricKeyManagers(privateKeyTypeManager, publicKeyTypeManager);
            String keyType = privateKeyTypeManager.getKeyType();
            String keyType2 = publicKeyTypeManager.getKeyType();
            ensureKeyManagerInsertable(keyType, newKeyAllowed ? privateKeyTypeManager.keyFactory().keyFormats() : Collections.emptyMap(), newKeyAllowed);
            ensureKeyManagerInsertable(keyType2, Collections.emptyMap(), false);
            if (!atomicReference.get().typeUrlExists(keyType)) {
                keyDeriverMap.put(keyType, createDeriverFor(privateKeyTypeManager));
                if (newKeyAllowed) {
                    registerKeyTemplates(privateKeyTypeManager.getKeyType(), privateKeyTypeManager.keyFactory().keyFormats());
                }
            }
            ConcurrentMap<String, Boolean> concurrentMap = newKeyAllowedMap;
            concurrentMap.put(keyType, Boolean.valueOf(newKeyAllowed));
            concurrentMap.put(keyType2, false);
            atomicReference.set(keyManagerRegistry2);
        }
    }

    private static <KeyFormatProtoT extends MessageLite> void registerKeyTemplates(String typeUrl, Map<String, KeyTypeManager.KeyFactory.KeyFormat<KeyFormatProtoT>> keyFormats) {
        for (Map.Entry<String, KeyTypeManager.KeyFactory.KeyFormat<KeyFormatProtoT>> entry : keyFormats.entrySet()) {
            keyTemplateMap.put(entry.getKey(), KeyTemplate.create(typeUrl, entry.getValue().keyFormat.toByteArray(), entry.getValue().outputPrefixType));
        }
    }

    public static synchronized <B, P> void registerPrimitiveWrapper(final PrimitiveWrapper<B, P> wrapper) throws GeneralSecurityException {
        synchronized (Registry.class) {
            MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(wrapper);
        }
    }

    @Deprecated
    public static <P> KeyManager<P> getKeyManager(String typeUrl) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(typeUrl);
    }

    public static <P> KeyManager<P> getKeyManager(String typeUrl, Class<P> primitiveClass) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(typeUrl, primitiveClass);
    }

    public static KeyManager<?> getUntypedKeyManager(String typeUrl) throws GeneralSecurityException {
        return keyManagerRegistry.get().getUntypedKeyManager(typeUrl);
    }

    public static synchronized KeyData newKeyData(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData newKeyData;
        synchronized (Registry.class) {
            KeyManager<?> untypedKeyManager = getUntypedKeyManager(keyTemplate.getTypeUrl());
            if (newKeyAllowedMap.get(keyTemplate.getTypeUrl()).booleanValue()) {
                newKeyData = untypedKeyManager.newKeyData(keyTemplate.getValue());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
        }
        return newKeyData;
    }

    public static synchronized KeyData newKeyData(KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData newKeyData;
        synchronized (Registry.class) {
            newKeyData = newKeyData(keyTemplate.getProto());
        }
        return newKeyData;
    }

    public static synchronized MessageLite newKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        MessageLite newKey;
        synchronized (Registry.class) {
            KeyManager<?> untypedKeyManager = getUntypedKeyManager(keyTemplate.getTypeUrl());
            if (newKeyAllowedMap.get(keyTemplate.getTypeUrl()).booleanValue()) {
                newKey = untypedKeyManager.newKey(keyTemplate.getValue());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
        }
        return newKey;
    }

    public static synchronized MessageLite newKey(String typeUrl, MessageLite format) throws GeneralSecurityException {
        MessageLite newKey;
        synchronized (Registry.class) {
            KeyManager keyManager = getKeyManager(typeUrl);
            if (newKeyAllowedMap.get(typeUrl).booleanValue()) {
                newKey = keyManager.newKey(format);
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + typeUrl);
            }
        }
        return newKey;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized KeyData deriveKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate, InputStream randomStream) throws GeneralSecurityException {
        KeyData deriveKey;
        synchronized (Registry.class) {
            String typeUrl = keyTemplate.getTypeUrl();
            ConcurrentMap<String, KeyDeriverContainer> concurrentMap = keyDeriverMap;
            if (!concurrentMap.containsKey(typeUrl)) {
                throw new GeneralSecurityException("No keymanager registered or key manager cannot derive keys for " + typeUrl);
            }
            deriveKey = concurrentMap.get(typeUrl).deriveKey(keyTemplate.getValue(), randomStream);
        }
        return deriveKey;
    }

    public static KeyData getPublicKeyData(String typeUrl, ByteString serializedPrivateKey) throws GeneralSecurityException {
        KeyManager keyManager = getKeyManager(typeUrl);
        if (!(keyManager instanceof PrivateKeyManager)) {
            throw new GeneralSecurityException("manager for key type " + typeUrl + " is not a PrivateKeyManager");
        }
        return ((PrivateKeyManager) keyManager).getPublicKeyData(serializedPrivateKey);
    }

    @Deprecated
    public static <P> P getPrimitive(String typeUrl, MessageLite key) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(typeUrl).getPrimitive(key);
    }

    public static <P> P getPrimitive(String typeUrl, MessageLite key, Class<P> primitiveClass) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(typeUrl, primitiveClass).getPrimitive(key);
    }

    @Deprecated
    public static <P> P getPrimitive(String typeUrl, ByteString serializedKey) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(typeUrl).getPrimitive(serializedKey);
    }

    public static <P> P getPrimitive(String typeUrl, ByteString serializedKey, Class<P> primitiveClass) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(typeUrl, primitiveClass).getPrimitive(serializedKey);
    }

    @Deprecated
    public static <P> P getPrimitive(String str, byte[] bArr) throws GeneralSecurityException {
        return (P) getPrimitive(str, ByteString.copyFrom(bArr));
    }

    public static <P> P getPrimitive(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return (P) getPrimitive(str, ByteString.copyFrom(bArr), cls);
    }

    @Deprecated
    public static <P> P getPrimitive(KeyData keyData) throws GeneralSecurityException {
        return (P) getPrimitive(keyData.getTypeUrl(), keyData.getValue());
    }

    public static <P> P getPrimitive(KeyData keyData, Class<P> cls) throws GeneralSecurityException {
        return (P) getPrimitive(keyData.getTypeUrl(), keyData.getValue(), cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <KeyT extends Key, P> P getFullPrimitive(KeyT keyt, Class<P> cls) throws GeneralSecurityException {
        return (P) MutablePrimitiveRegistry.globalInstance().getPrimitive(keyt, cls);
    }

    public static <B, P> P wrap(PrimitiveSet<B> primitiveSet, Class<P> cls) throws GeneralSecurityException {
        return (P) MutablePrimitiveRegistry.globalInstance().wrap(primitiveSet, cls);
    }

    public static <P> P wrap(PrimitiveSet<P> primitiveSet) throws GeneralSecurityException {
        return (P) wrap(primitiveSet, primitiveSet.getPrimitiveClass());
    }

    public static synchronized List<String> keyTemplates() {
        List<String> unmodifiableList;
        synchronized (Registry.class) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(keyTemplateMap.keySet());
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized Map<String, KeyTemplate> keyTemplateMap() {
        Map<String, KeyTemplate> unmodifiableMap;
        synchronized (Registry.class) {
            unmodifiableMap = Collections.unmodifiableMap(keyTemplateMap);
        }
        return unmodifiableMap;
    }

    @Nullable
    public static Class<?> getInputPrimitive(Class<?> wrappedPrimitive) {
        try {
            return MutablePrimitiveRegistry.globalInstance().getInputPrimitiveClass(wrappedPrimitive);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MessageLite parseKeyData(KeyData keyData) throws GeneralSecurityException, InvalidProtocolBufferException {
        return keyManagerRegistry.get().parseKeyData(keyData);
    }

    public static synchronized void restrictToFipsIfEmpty() throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (TinkFipsUtil.useOnlyFips()) {
                return;
            }
            if (keyManagerRegistry.get().isEmpty()) {
                TinkFipsUtil.setFipsRestricted();
                return;
            }
            throw new GeneralSecurityException("Could not enable FIPS mode as Registry is not empty.");
        }
    }

    private Registry() {
    }
}
