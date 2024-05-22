package com.reactnativecommunity.asyncstorage;

import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.common.ModuleDataCleaner;
import java.util.concurrent.Executor;

@ReactModule(name = AsyncStorageModule.NAME)
/* loaded from: classes5.dex */
public final class AsyncStorageModule extends NativeAsyncStorageModuleSpec implements ModuleDataCleaner.Cleanable, LifecycleEventListener {
    private static final int MAX_SQL_KEYS = 999;
    public static final String NAME = "RNCAsyncStorage";
    private final SerialExecutor executor;
    private ReactDatabaseSupplier mReactDatabaseSupplier;
    private boolean mShuttingDown;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    public AsyncStorageModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @VisibleForTesting
    AsyncStorageModule(ReactApplicationContext reactApplicationContext, Executor executor) {
        super(reactApplicationContext);
        this.mShuttingDown = false;
        AsyncStorageExpoMigration.migrate(reactApplicationContext);
        this.executor = new SerialExecutor(executor);
        reactApplicationContext.addLifecycleEventListener(this);
        this.mReactDatabaseSupplier = ReactDatabaseSupplier.getInstance(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
        this.mShuttingDown = false;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
    }

    @Override // com.facebook.react.modules.common.ModuleDataCleaner.Cleanable
    public void clearSensitiveData() {
        this.mReactDatabaseSupplier.clearAndCloseDatabase();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        this.mReactDatabaseSupplier.closeDatabase();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$1] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void multiGet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray == null) {
            callback.invoke(AsyncStorageErrorUtil.getInvalidKeyError(null), null);
        } else {
            new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.1
                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Code restructure failed: missing block: B:19:0x0090, code lost:
                
                    if (r7.moveToFirst() != false) goto L18;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:20:0x0092, code lost:
                
                    r8 = com.facebook.react.bridge.Arguments.createArray();
                    r8.pushString(r7.getString(0));
                    r8.pushString(r7.getString(1));
                    r15.pushArray(r8);
                    r6.remove(r7.getString(0));
                 */
                /* JADX WARN: Code restructure failed: missing block: B:21:0x00b2, code lost:
                
                    if (r7.moveToNext() != false) goto L41;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:24:0x00b4, code lost:
                
                    r7.close();
                    r7 = r6.iterator();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:26:0x00bf, code lost:
                
                    if (r7.hasNext() == false) goto L42;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:27:0x00c1, code lost:
                
                    r8 = (java.lang.String) r7.next();
                    r9 = com.facebook.react.bridge.Arguments.createArray();
                    r9.pushString(r8);
                    r9.pushNull();
                    r15.pushArray(r9);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:29:0x00d5, code lost:
                
                    r6.clear();
                    r14 = r4 + 999;
                 */
                @Override // com.facebook.react.bridge.GuardedAsyncTask
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void doInBackgroundGuarded(java.lang.Void... r20) {
                    /*
                        Method dump skipped, instructions count: 274
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.asyncstorage.AsyncStorageModule.AnonymousClass1.doInBackgroundGuarded(java.lang.Void[]):void");
                }
            }.executeOnExecutor(this.executor, new Void[0]);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$2] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void multiSet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[0]);
        } else {
            new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.facebook.react.bridge.GuardedAsyncTask
                public void doInBackgroundGuarded(Void... voidArr) {
                    WritableMap writableMap = null;
                    if (!AsyncStorageModule.this.ensureDatabase()) {
                        callback.invoke(AsyncStorageErrorUtil.getDBError(null));
                        return;
                    }
                    SQLiteStatement compileStatement = AsyncStorageModule.this.mReactDatabaseSupplier.get().compileStatement("INSERT OR REPLACE INTO catalystLocalStorage VALUES (?, ?);");
                    try {
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                            for (int i = 0; i < readableArray.size(); i++) {
                                if (readableArray.getArray(i).size() != 2) {
                                    WritableMap invalidValueError = AsyncStorageErrorUtil.getInvalidValueError(null);
                                    try {
                                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                        return;
                                    } catch (Exception e) {
                                        FLog.w(ReactConstants.TAG, e.getMessage(), e);
                                        if (invalidValueError == null) {
                                            AsyncStorageErrorUtil.getError(null, e.getMessage());
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (readableArray.getArray(i).getString(0) == null) {
                                    WritableMap invalidKeyError = AsyncStorageErrorUtil.getInvalidKeyError(null);
                                    try {
                                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                        return;
                                    } catch (Exception e2) {
                                        FLog.w(ReactConstants.TAG, e2.getMessage(), e2);
                                        if (invalidKeyError == null) {
                                            AsyncStorageErrorUtil.getError(null, e2.getMessage());
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (readableArray.getArray(i).getString(1) == null) {
                                    WritableMap invalidValueError2 = AsyncStorageErrorUtil.getInvalidValueError(null);
                                    try {
                                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                        return;
                                    } catch (Exception e3) {
                                        FLog.w(ReactConstants.TAG, e3.getMessage(), e3);
                                        if (invalidValueError2 == null) {
                                            AsyncStorageErrorUtil.getError(null, e3.getMessage());
                                            return;
                                        }
                                        return;
                                    }
                                }
                                compileStatement.clearBindings();
                                compileStatement.bindString(1, readableArray.getArray(i).getString(0));
                                compileStatement.bindString(2, readableArray.getArray(i).getString(1));
                                compileStatement.execute();
                            }
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                            } catch (Exception e4) {
                                FLog.w(ReactConstants.TAG, e4.getMessage(), e4);
                                writableMap = AsyncStorageErrorUtil.getError(null, e4.getMessage());
                            }
                        } catch (Exception e5) {
                            FLog.w(ReactConstants.TAG, e5.getMessage(), e5);
                            WritableMap error = AsyncStorageErrorUtil.getError(null, e5.getMessage());
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                            } catch (Exception e6) {
                                FLog.w(ReactConstants.TAG, e6.getMessage(), e6);
                                if (error == null) {
                                    writableMap = AsyncStorageErrorUtil.getError(null, e6.getMessage());
                                }
                            }
                            writableMap = error;
                        }
                        if (writableMap != null) {
                            callback.invoke(writableMap);
                        } else {
                            callback.invoke(new Object[0]);
                        }
                    } catch (Throwable th) {
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e7) {
                            FLog.w(ReactConstants.TAG, e7.getMessage(), e7);
                            AsyncStorageErrorUtil.getError(null, e7.getMessage());
                        }
                        throw th;
                    }
                }
            }.executeOnExecutor(this.executor, new Void[0]);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$3] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void multiRemove(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[0]);
        } else {
            new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.facebook.react.bridge.GuardedAsyncTask
                public void doInBackgroundGuarded(Void... voidArr) {
                    WritableMap writableMap = null;
                    try {
                        if (!AsyncStorageModule.this.ensureDatabase()) {
                            callback.invoke(AsyncStorageErrorUtil.getDBError(null));
                            return;
                        }
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                            for (int i = 0; i < readableArray.size(); i += 999) {
                                int min = Math.min(readableArray.size() - i, 999);
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().delete("catalystLocalStorage", AsyncLocalStorageUtil.buildKeySelection(min), AsyncLocalStorageUtil.buildKeySelectionArgs(readableArray, i, min));
                            }
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                            } catch (Exception e) {
                                FLog.w(ReactConstants.TAG, e.getMessage(), e);
                                writableMap = AsyncStorageErrorUtil.getError(null, e.getMessage());
                            }
                        } catch (Exception e2) {
                            FLog.w(ReactConstants.TAG, e2.getMessage(), e2);
                            WritableMap error = AsyncStorageErrorUtil.getError(null, e2.getMessage());
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                            } catch (Exception e3) {
                                FLog.w(ReactConstants.TAG, e3.getMessage(), e3);
                                if (error == null) {
                                    writableMap = AsyncStorageErrorUtil.getError(null, e3.getMessage());
                                }
                            }
                            writableMap = error;
                        }
                        if (writableMap != null) {
                            callback.invoke(writableMap);
                        } else {
                            callback.invoke(new Object[0]);
                        }
                    } catch (Throwable th) {
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e4) {
                            FLog.w(ReactConstants.TAG, e4.getMessage(), e4);
                            AsyncStorageErrorUtil.getError(null, e4.getMessage());
                        }
                        throw th;
                    }
                }
            }.executeOnExecutor(this.executor, new Void[0]);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$4] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void multiMerge(final ReadableArray readableArray, final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void... voidArr) {
                WritableMap writableMap = null;
                try {
                    if (!AsyncStorageModule.this.ensureDatabase()) {
                        callback.invoke(AsyncStorageErrorUtil.getDBError(null));
                        return;
                    }
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                        for (int i = 0; i < readableArray.size(); i++) {
                            if (readableArray.getArray(i).size() != 2) {
                                WritableMap invalidValueError = AsyncStorageErrorUtil.getInvalidValueError(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e) {
                                    FLog.w(ReactConstants.TAG, e.getMessage(), e);
                                    if (invalidValueError == null) {
                                        AsyncStorageErrorUtil.getError(null, e.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (readableArray.getArray(i).getString(0) == null) {
                                WritableMap invalidKeyError = AsyncStorageErrorUtil.getInvalidKeyError(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e2) {
                                    FLog.w(ReactConstants.TAG, e2.getMessage(), e2);
                                    if (invalidKeyError == null) {
                                        AsyncStorageErrorUtil.getError(null, e2.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (readableArray.getArray(i).getString(1) == null) {
                                WritableMap invalidValueError2 = AsyncStorageErrorUtil.getInvalidValueError(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e3) {
                                    FLog.w(ReactConstants.TAG, e3.getMessage(), e3);
                                    if (invalidValueError2 == null) {
                                        AsyncStorageErrorUtil.getError(null, e3.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (!AsyncLocalStorageUtil.mergeImpl(AsyncStorageModule.this.mReactDatabaseSupplier.get(), readableArray.getArray(i).getString(0), readableArray.getArray(i).getString(1))) {
                                WritableMap dBError = AsyncStorageErrorUtil.getDBError(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e4) {
                                    FLog.w(ReactConstants.TAG, e4.getMessage(), e4);
                                    if (dBError == null) {
                                        AsyncStorageErrorUtil.getError(null, e4.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e5) {
                            FLog.w(ReactConstants.TAG, e5.getMessage(), e5);
                            writableMap = AsyncStorageErrorUtil.getError(null, e5.getMessage());
                        }
                    } catch (Exception e6) {
                        FLog.w(ReactConstants.TAG, e6.getMessage(), e6);
                        WritableMap error = AsyncStorageErrorUtil.getError(null, e6.getMessage());
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e7) {
                            FLog.w(ReactConstants.TAG, e7.getMessage(), e7);
                            if (error == null) {
                                writableMap = AsyncStorageErrorUtil.getError(null, e7.getMessage());
                            }
                        }
                        writableMap = error;
                    }
                    if (writableMap != null) {
                        callback.invoke(writableMap);
                    } else {
                        callback.invoke(new Object[0]);
                    }
                } catch (Throwable th) {
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e8) {
                        FLog.w(ReactConstants.TAG, e8.getMessage(), e8);
                        AsyncStorageErrorUtil.getError(null, e8.getMessage());
                    }
                    throw th;
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$5] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void clear(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void... voidArr) {
                if (!AsyncStorageModule.this.mReactDatabaseSupplier.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError(null));
                    return;
                }
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.clear();
                    callback.invoke(new Object[0]);
                } catch (Exception e) {
                    FLog.w(ReactConstants.TAG, e.getMessage(), e);
                    callback.invoke(AsyncStorageErrorUtil.getError(null, e.getMessage()));
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$6] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void getAllKeys(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.6
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
            
                r14.pushString(r4.getString(0));
             */
            /* JADX WARN: Code restructure failed: missing block: B:11:0x004c, code lost:
            
                if (r4.moveToNext() != false) goto L25;
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
            
                r4.close();
                r3.invoke(null, r14);
             */
            /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:9:0x003f, code lost:
            
                if (r4.moveToFirst() != false) goto L9;
             */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void doInBackgroundGuarded(java.lang.Void... r14) {
                /*
                    r13 = this;
                    com.reactnativecommunity.asyncstorage.AsyncStorageModule r14 = com.reactnativecommunity.asyncstorage.AsyncStorageModule.this
                    boolean r14 = com.reactnativecommunity.asyncstorage.AsyncStorageModule.m1055$$Nest$mensureDatabase(r14)
                    r0 = 1
                    r1 = 2
                    r2 = 0
                    r3 = 0
                    if (r14 != 0) goto L1c
                    com.facebook.react.bridge.Callback r14 = r3
                    java.lang.Object[] r1 = new java.lang.Object[r1]
                    com.facebook.react.bridge.WritableMap r4 = com.reactnativecommunity.asyncstorage.AsyncStorageErrorUtil.getDBError(r3)
                    r1[r2] = r4
                    r1[r0] = r3
                    r14.invoke(r1)
                    return
                L1c:
                    com.facebook.react.bridge.WritableArray r14 = com.facebook.react.bridge.Arguments.createArray()
                    java.lang.String r4 = "key"
                    java.lang.String[] r7 = new java.lang.String[]{r4}
                    com.reactnativecommunity.asyncstorage.AsyncStorageModule r4 = com.reactnativecommunity.asyncstorage.AsyncStorageModule.this
                    com.reactnativecommunity.asyncstorage.ReactDatabaseSupplier r4 = com.reactnativecommunity.asyncstorage.AsyncStorageModule.m1054$$Nest$fgetmReactDatabaseSupplier(r4)
                    android.database.sqlite.SQLiteDatabase r5 = r4.get()
                    java.lang.String r6 = "catalystLocalStorage"
                    r8 = 0
                    r9 = 0
                    r10 = 0
                    r11 = 0
                    r12 = 0
                    android.database.Cursor r4 = r5.query(r6, r7, r8, r9, r10, r11, r12)
                    boolean r5 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
                    if (r5 == 0) goto L4e
                L41:
                    java.lang.String r5 = r4.getString(r2)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
                    r14.pushString(r5)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
                    boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
                    if (r5 != 0) goto L41
                L4e:
                    r4.close()
                    com.facebook.react.bridge.Callback r4 = r3
                    java.lang.Object[] r1 = new java.lang.Object[r1]
                    r1[r2] = r3
                    r1[r0] = r14
                    r4.invoke(r1)
                    return
                L5d:
                    r14 = move-exception
                    goto L80
                L5f:
                    r14 = move-exception
                    java.lang.String r5 = "ReactNative"
                    java.lang.String r6 = r14.getMessage()     // Catch: java.lang.Throwable -> L5d
                    com.facebook.common.logging.FLog.w(r5, r6, r14)     // Catch: java.lang.Throwable -> L5d
                    com.facebook.react.bridge.Callback r5 = r3     // Catch: java.lang.Throwable -> L5d
                    java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5d
                    java.lang.String r14 = r14.getMessage()     // Catch: java.lang.Throwable -> L5d
                    com.facebook.react.bridge.WritableMap r14 = com.reactnativecommunity.asyncstorage.AsyncStorageErrorUtil.getError(r3, r14)     // Catch: java.lang.Throwable -> L5d
                    r1[r2] = r14     // Catch: java.lang.Throwable -> L5d
                    r1[r0] = r3     // Catch: java.lang.Throwable -> L5d
                    r5.invoke(r1)     // Catch: java.lang.Throwable -> L5d
                    r4.close()
                    return
                L80:
                    r4.close()
                    throw r14
                */
                throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.asyncstorage.AsyncStorageModule.AnonymousClass6.doInBackgroundGuarded(java.lang.Void[]):void");
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ensureDatabase() {
        return !this.mShuttingDown && this.mReactDatabaseSupplier.ensureDatabase();
    }
}
