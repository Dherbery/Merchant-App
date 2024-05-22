package com.amplitude.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class DatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_EVENTS_TABLE = "CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);";
    private static final String CREATE_IDENTIFYS_TABLE = "CREATE TABLE IF NOT EXISTS identifys (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);";
    private static final String CREATE_IDENTIFY_INTERCEPTOR_TABLE = "CREATE TABLE IF NOT EXISTS identify_interceptor (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);";
    private static final String CREATE_LONG_STORE_TABLE = "CREATE TABLE IF NOT EXISTS long_store (key TEXT PRIMARY KEY NOT NULL, value INTEGER);";
    private static final String CREATE_STORE_TABLE = "CREATE TABLE IF NOT EXISTS store (key TEXT PRIMARY KEY NOT NULL, value TEXT);";
    private static final String EVENT_FIELD = "event";
    protected static final String EVENT_TABLE_NAME = "events";
    protected static final String IDENTIFY_INTERCEPTOR_TABLE_NAME = "identify_interceptor";
    protected static final String IDENTIFY_TABLE_NAME = "identifys";
    private static final String ID_FIELD = "id";
    private static final String KEY_FIELD = "key";
    protected static final String LONG_STORE_TABLE_NAME = "long_store";
    protected static final String STORE_TABLE_NAME = "store";
    private static final String TAG = "com.amplitude.api.DatabaseHelper";
    private static final String VALUE_FIELD = "value";
    static final Map<String, DatabaseHelper> instances = new HashMap();
    private static final AmplitudeLog logger = AmplitudeLog.getLogger();
    private boolean callResetListenerOnDatabaseReset;
    private DatabaseResetListener databaseResetListener;
    File file;
    private String instanceName;

    @Deprecated
    static DatabaseHelper getDatabaseHelper(Context context) {
        return getDatabaseHelper(context, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized DatabaseHelper getDatabaseHelper(Context context, String str) {
        DatabaseHelper databaseHelper;
        synchronized (DatabaseHelper.class) {
            String normalizeInstanceName = Utils.normalizeInstanceName(str);
            Map<String, DatabaseHelper> map = instances;
            databaseHelper = map.get(normalizeInstanceName);
            if (databaseHelper == null) {
                databaseHelper = new DatabaseHelper(context.getApplicationContext(), normalizeInstanceName);
                map.put(normalizeInstanceName, databaseHelper);
            }
        }
        return databaseHelper;
    }

    private static String getDatabaseName(String str) {
        if (Utils.isEmptyString(str) || str.equals(Constants.DEFAULT_INSTANCE)) {
            return "com.amplitude.api";
        }
        return "com.amplitude.api_" + str;
    }

    protected DatabaseHelper(Context context) {
        this(context, null);
    }

    protected DatabaseHelper(Context context, String str) {
        super(context, getDatabaseName(str), (SQLiteDatabase.CursorFactory) null, 4);
        this.callResetListenerOnDatabaseReset = true;
        this.file = context.getDatabasePath(getDatabaseName(str));
        this.instanceName = Utils.normalizeInstanceName(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDatabaseResetListener(DatabaseResetListener databaseResetListener) {
        this.databaseResetListener = databaseResetListener;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_STORE_TABLE);
        sQLiteDatabase.execSQL(CREATE_LONG_STORE_TABLE);
        sQLiteDatabase.execSQL(CREATE_EVENTS_TABLE);
        sQLiteDatabase.execSQL(CREATE_IDENTIFYS_TABLE);
        sQLiteDatabase.execSQL(CREATE_IDENTIFY_INTERCEPTOR_TABLE);
        DatabaseResetListener databaseResetListener = this.databaseResetListener;
        if (databaseResetListener == null || !this.callResetListenerOnDatabaseReset) {
            return;
        }
        try {
            try {
                this.callResetListenerOnDatabaseReset = false;
                databaseResetListener.onDatabaseReset(sQLiteDatabase);
            } catch (SQLiteException e) {
                logger.e(TAG, String.format("databaseReset callback failed during onCreate", new Object[0]), e);
            }
        } finally {
            this.callResetListenerOnDatabaseReset = true;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            logger.e(TAG, "onUpgrade() with invalid oldVersion and newVersion");
            resetDatabase(sQLiteDatabase);
            return;
        }
        if (i2 <= 1) {
            return;
        }
        if (i == 1) {
            sQLiteDatabase.execSQL(CREATE_STORE_TABLE);
            if (i2 <= 2) {
                return;
            }
        } else if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    logger.e(TAG, "onUpgrade() with unknown oldVersion " + i);
                    resetDatabase(sQLiteDatabase);
                    return;
                }
                return;
            }
            sQLiteDatabase.execSQL(CREATE_IDENTIFY_INTERCEPTOR_TABLE);
        }
        sQLiteDatabase.execSQL(CREATE_IDENTIFYS_TABLE);
        sQLiteDatabase.execSQL(CREATE_LONG_STORE_TABLE);
        if (i2 <= 3) {
            return;
        }
        sQLiteDatabase.execSQL(CREATE_IDENTIFY_INTERCEPTOR_TABLE);
    }

    private void resetDatabase(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS long_store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS identifys");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS identify_interceptor");
        onCreate(sQLiteDatabase);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long insertOrReplaceKeyValue(String str, String str2) {
        long insertOrReplaceKeyValueToTable;
        if (str2 == null) {
            insertOrReplaceKeyValueToTable = deleteKeyFromTable("store", str);
        } else {
            insertOrReplaceKeyValueToTable = insertOrReplaceKeyValueToTable("store", str, str2);
        }
        return insertOrReplaceKeyValueToTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long insertOrReplaceKeyLongValue(String str, Long l) {
        long insertOrReplaceKeyValueToTable;
        if (l == null) {
            insertOrReplaceKeyValueToTable = deleteKeyFromTable(LONG_STORE_TABLE_NAME, str);
        } else {
            insertOrReplaceKeyValueToTable = insertOrReplaceKeyValueToTable(LONG_STORE_TABLE_NAME, str, l);
        }
        return insertOrReplaceKeyValueToTable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:
    
        if (r2.isOpen() != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0037, code lost:
    
        close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r2.isOpen() != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    synchronized long insertOrReplaceKeyValueToTable(java.lang.String r6, java.lang.String r7, java.lang.Object r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 1
            r2 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.getWritableDatabase()     // Catch: java.lang.Throwable -> L18 java.lang.StackOverflowError -> L1a android.database.sqlite.SQLiteException -> L3b
            long r6 = r5.insertOrReplaceKeyValueToTable(r2, r6, r7, r8)     // Catch: java.lang.Throwable -> L18 java.lang.StackOverflowError -> L1a android.database.sqlite.SQLiteException -> L3b
            if (r2 == 0) goto L5b
            boolean r8 = r2.isOpen()     // Catch: java.lang.Throwable -> L69
            if (r8 == 0) goto L5b
            r5.close()     // Catch: java.lang.Throwable -> L69
            goto L5b
        L18:
            r6 = move-exception
            goto L5d
        L1a:
            r7 = move-exception
            com.amplitude.api.AmplitudeLog r8 = com.amplitude.api.DatabaseHelper.logger     // Catch: java.lang.Throwable -> L18
            java.lang.String r3 = com.amplitude.api.DatabaseHelper.TAG     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = "insertOrReplaceKeyValue in %s failed"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L18
            r1[r0] = r6     // Catch: java.lang.Throwable -> L18
            java.lang.String r6 = java.lang.String.format(r4, r1)     // Catch: java.lang.Throwable -> L18
            r8.e(r3, r6, r7)     // Catch: java.lang.Throwable -> L18
            r5.delete()     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L59
            boolean r6 = r2.isOpen()     // Catch: java.lang.Throwable -> L69
            if (r6 == 0) goto L59
        L37:
            r5.close()     // Catch: java.lang.Throwable -> L69
            goto L59
        L3b:
            r7 = move-exception
            com.amplitude.api.AmplitudeLog r8 = com.amplitude.api.DatabaseHelper.logger     // Catch: java.lang.Throwable -> L18
            java.lang.String r3 = com.amplitude.api.DatabaseHelper.TAG     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = "insertOrReplaceKeyValue in %s failed"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L18
            r1[r0] = r6     // Catch: java.lang.Throwable -> L18
            java.lang.String r6 = java.lang.String.format(r4, r1)     // Catch: java.lang.Throwable -> L18
            r8.e(r3, r6, r7)     // Catch: java.lang.Throwable -> L18
            r5.delete()     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L59
            boolean r6 = r2.isOpen()     // Catch: java.lang.Throwable -> L69
            if (r6 == 0) goto L59
            goto L37
        L59:
            r6 = -1
        L5b:
            monitor-exit(r5)
            return r6
        L5d:
            if (r2 == 0) goto L68
            boolean r7 = r2.isOpen()     // Catch: java.lang.Throwable -> L69
            if (r7 == 0) goto L68
            r5.close()     // Catch: java.lang.Throwable -> L69
        L68:
            throw r6     // Catch: java.lang.Throwable -> L69
        L69:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.insertOrReplaceKeyValueToTable(java.lang.String, java.lang.String, java.lang.Object):long");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long insertOrReplaceKeyValueToTable(SQLiteDatabase sQLiteDatabase, String str, String str2, Object obj) throws SQLiteException, StackOverflowError {
        long insertKeyValueContentValuesIntoTable;
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", str2);
        if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            contentValues.put("value", (String) obj);
        }
        insertKeyValueContentValuesIntoTable = insertKeyValueContentValuesIntoTable(sQLiteDatabase, str, contentValues);
        if (insertKeyValueContentValuesIntoTable == -1) {
            logger.w(TAG, "Insert failed");
        }
        return insertKeyValueContentValuesIntoTable;
    }

    synchronized long insertKeyValueContentValuesIntoTable(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) throws SQLiteException, StackOverflowError {
        return sQLiteDatabase.insertWithOnConflict(str, null, contentValues, 5);
    }

    synchronized long deleteKeyFromTable(String str, String str2) {
        long j;
        try {
            try {
                try {
                    j = getWritableDatabase().delete(str, "key=?", new String[]{str2});
                } catch (SQLiteException e) {
                    logger.e(TAG, String.format("deleteKey from %s failed", str), e);
                    delete();
                    close();
                    j = -1;
                    return j;
                }
            } catch (StackOverflowError e2) {
                logger.e(TAG, String.format("deleteKey from %s failed", str), e2);
                delete();
                close();
                j = -1;
                return j;
            }
        } finally {
            close();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long addEvent(String str) {
        return addEventToTable(EVENT_TABLE_NAME, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long addIdentify(String str) {
        return addEventToTable(IDENTIFY_TABLE_NAME, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long addIdentifyInterceptor(String str) {
        return addEventToTable(IDENTIFY_INTERCEPTOR_TABLE_NAME, str);
    }

    private synchronized long addEventToTable(String str, String str2) {
        long j;
        long j2 = -1;
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("event", str2);
                j = insertEventContentValuesIntoTable(writableDatabase, str, contentValues);
                if (j == -1) {
                    try {
                        logger.w(TAG, String.format("Insert into %s failed", str));
                    } catch (SQLiteException e) {
                        e = e;
                        j2 = j;
                        logger.e(TAG, String.format("addEvent to %s failed", str), e);
                        delete();
                        close();
                        j = j2;
                        return j;
                    } catch (StackOverflowError e2) {
                        e = e2;
                        j2 = j;
                        logger.e(TAG, String.format("addEvent to %s failed", str), e);
                        delete();
                        close();
                        j = j2;
                        return j;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
            } catch (StackOverflowError e4) {
                e = e4;
            }
        } finally {
            close();
        }
        return j;
    }

    synchronized long insertEventContentValuesIntoTable(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) throws SQLiteException, StackOverflowError {
        return sQLiteDatabase.insert(str, null, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String getValue(String str) {
        return (String) getValueFromTable("store", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Long getLongValue(String str) {
        return (Long) getValueFromTable(LONG_STORE_TABLE_NAME, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a9 A[Catch: all -> 0x0069, TRY_ENTER, TryCatch #3 {, blocks: (B:15:0x0042, B:16:0x0065, B:31:0x0057, B:27:0x0062, B:35:0x0083, B:23:0x009f, B:40:0x00a9, B:41:0x00ac, B:42:0x00af), top: B:3:0x0004 }] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected synchronized java.lang.Object getValueFromTable(java.lang.String r14, java.lang.String r15) {
        /*
            r13 = this;
            monitor-enter(r13)
            r0 = 0
            r1 = 1
            r2 = 0
            android.database.sqlite.SQLiteDatabase r4 = r13.getReadableDatabase()     // Catch: java.lang.Throwable -> L4e java.lang.RuntimeException -> L50 java.lang.IllegalStateException -> L5b java.lang.StackOverflowError -> L6b android.database.sqlite.SQLiteException -> L87
            r3 = 2
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L4e java.lang.RuntimeException -> L50 java.lang.IllegalStateException -> L5b java.lang.StackOverflowError -> L6b android.database.sqlite.SQLiteException -> L87
            java.lang.String r3 = "key"
            r6[r0] = r3     // Catch: java.lang.Throwable -> L4e java.lang.RuntimeException -> L50 java.lang.IllegalStateException -> L5b java.lang.StackOverflowError -> L6b android.database.sqlite.SQLiteException -> L87
            java.lang.String r3 = "value"
            r6[r1] = r3     // Catch: java.lang.Throwable -> L4e java.lang.RuntimeException -> L50 java.lang.IllegalStateException -> L5b java.lang.StackOverflowError -> L6b android.database.sqlite.SQLiteException -> L87
            java.lang.String r7 = "key = ?"
            java.lang.String[] r8 = new java.lang.String[]{r15}     // Catch: java.lang.Throwable -> L4e java.lang.RuntimeException -> L50 java.lang.IllegalStateException -> L5b java.lang.StackOverflowError -> L6b android.database.sqlite.SQLiteException -> L87
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r3 = r13
            r5 = r14
            android.database.Cursor r15 = r3.queryDb(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L4e java.lang.RuntimeException -> L50 java.lang.IllegalStateException -> L5b java.lang.StackOverflowError -> L6b android.database.sqlite.SQLiteException -> L87
            boolean r3 = r15.moveToFirst()     // Catch: java.lang.RuntimeException -> L46 java.lang.IllegalStateException -> L48 java.lang.StackOverflowError -> L4a android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> La5
            if (r3 == 0) goto L40
            java.lang.String r3 = "store"
            boolean r3 = r14.equals(r3)     // Catch: java.lang.RuntimeException -> L46 java.lang.IllegalStateException -> L48 java.lang.StackOverflowError -> L4a android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> La5
            if (r3 == 0) goto L37
            java.lang.String r14 = r15.getString(r1)     // Catch: java.lang.RuntimeException -> L46 java.lang.IllegalStateException -> L48 java.lang.StackOverflowError -> L4a android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> La5
            goto L3f
        L37:
            long r3 = r15.getLong(r1)     // Catch: java.lang.RuntimeException -> L46 java.lang.IllegalStateException -> L48 java.lang.StackOverflowError -> L4a android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> La5
            java.lang.Long r14 = java.lang.Long.valueOf(r3)     // Catch: java.lang.RuntimeException -> L46 java.lang.IllegalStateException -> L48 java.lang.StackOverflowError -> L4a android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> La5
        L3f:
            r2 = r14
        L40:
            if (r15 == 0) goto L65
            r15.close()     // Catch: java.lang.Throwable -> L69
            goto L65
        L46:
            r14 = move-exception
            goto L52
        L48:
            r14 = move-exception
            goto L5d
        L4a:
            r3 = move-exception
            goto L6d
        L4c:
            r3 = move-exception
            goto L89
        L4e:
            r14 = move-exception
            goto La7
        L50:
            r14 = move-exception
            r15 = r2
        L52:
            convertIfCursorWindowException(r14)     // Catch: java.lang.Throwable -> La5
            if (r15 == 0) goto L65
            r15.close()     // Catch: java.lang.Throwable -> L69
            goto L65
        L5b:
            r14 = move-exception
            r15 = r2
        L5d:
            r13.handleIfCursorRowTooLargeException(r14)     // Catch: java.lang.Throwable -> La5
            if (r15 == 0) goto L65
            r15.close()     // Catch: java.lang.Throwable -> L69
        L65:
            r13.close()     // Catch: java.lang.Throwable -> L69
            goto La3
        L69:
            r14 = move-exception
            goto Lb0
        L6b:
            r3 = move-exception
            r15 = r2
        L6d:
            com.amplitude.api.AmplitudeLog r4 = com.amplitude.api.DatabaseHelper.logger     // Catch: java.lang.Throwable -> La5
            java.lang.String r5 = com.amplitude.api.DatabaseHelper.TAG     // Catch: java.lang.Throwable -> La5
            java.lang.String r6 = "getValue from %s failed"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> La5
            r1[r0] = r14     // Catch: java.lang.Throwable -> La5
            java.lang.String r14 = java.lang.String.format(r6, r1)     // Catch: java.lang.Throwable -> La5
            r4.e(r5, r14, r3)     // Catch: java.lang.Throwable -> La5
            r13.delete()     // Catch: java.lang.Throwable -> La5
            if (r15 == 0) goto L65
            r15.close()     // Catch: java.lang.Throwable -> L69
            goto L65
        L87:
            r3 = move-exception
            r15 = r2
        L89:
            com.amplitude.api.AmplitudeLog r4 = com.amplitude.api.DatabaseHelper.logger     // Catch: java.lang.Throwable -> La5
            java.lang.String r5 = com.amplitude.api.DatabaseHelper.TAG     // Catch: java.lang.Throwable -> La5
            java.lang.String r6 = "getValue from %s failed"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> La5
            r1[r0] = r14     // Catch: java.lang.Throwable -> La5
            java.lang.String r14 = java.lang.String.format(r6, r1)     // Catch: java.lang.Throwable -> La5
            r4.e(r5, r14, r3)     // Catch: java.lang.Throwable -> La5
            r13.delete()     // Catch: java.lang.Throwable -> La5
            if (r15 == 0) goto L65
            r15.close()     // Catch: java.lang.Throwable -> L69
            goto L65
        La3:
            monitor-exit(r13)
            return r2
        La5:
            r14 = move-exception
            r2 = r15
        La7:
            if (r2 == 0) goto Lac
            r2.close()     // Catch: java.lang.Throwable -> L69
        Lac:
            r13.close()     // Catch: java.lang.Throwable -> L69
            throw r14     // Catch: java.lang.Throwable -> L69
        Lb0:
            monitor-exit(r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.getValueFromTable(java.lang.String, java.lang.String):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<JSONObject> getEvents(long j, long j2) throws JSONException {
        return getEventsFromTable(EVENT_TABLE_NAME, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<JSONObject> getIdentifys(long j, long j2) throws JSONException {
        return getEventsFromTable(IDENTIFY_TABLE_NAME, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<JSONObject> getIdentifyInterceptors(long j, long j2) throws JSONException {
        return getEventsFromTable(IDENTIFY_INTERCEPTOR_TABLE_NAME, j, j2);
    }

    protected synchronized List<JSONObject> getEventsFromTable(String str, long j, long j2) throws JSONException {
        try {
        } catch (CursorWindowAllocationException unused) {
            return getEventsRowByRowFromTable(str, j, j2);
        }
        return getEventsBatchFromTable(str, j, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0086, code lost:
    
        if (r15 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0096, code lost:
    
        close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0093, code lost:
    
        r15.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d8, code lost:
    
        if (r15 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0091, code lost:
    
        if (r15 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a2, code lost:
    
        if (r15 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<org.json.JSONObject> getEventsBatchFromTable(java.lang.String r20, long r21, long r23) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.getEventsBatchFromTable(java.lang.String, long, long):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e2, code lost:
    
        if (r16 != null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ac, code lost:
    
        if (r16 == null) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x010c, TryCatch #4 {all -> 0x010c, blocks: (B:24:0x00e5, B:25:0x00ee, B:27:0x00f4, B:30:0x0104), top: B:23:0x00e5 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<org.json.JSONObject> getEventsRowByRowFromTable(java.lang.String r22, long r23, long r25) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.getEventsRowByRowFromTable(java.lang.String, long, long):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c4, code lost:
    
        if (r16 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0088, code lost:
    
        if (r16 == null) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected synchronized org.json.JSONObject getEventFromTable(java.lang.String r18, long r19) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.getEventFromTable(java.lang.String, long):org.json.JSONObject");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long getEventCount() {
        return getEventCountFromTable(EVENT_TABLE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long getIdentifyCount() {
        return getEventCountFromTable(IDENTIFY_TABLE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long getTotalEventCount() {
        return getEventCount() + getIdentifyCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long getIdentifyInterceptorCount() {
        return getEventCountFromTable(IDENTIFY_INTERCEPTOR_TABLE_NAME);
    }

    private synchronized long getEventCountFromTable(String str) {
        long j;
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                sQLiteStatement = getReadableDatabase().compileStatement("SELECT COUNT(*) FROM " + str);
                j = sQLiteStatement.simpleQueryForLong();
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                close();
            } catch (SQLiteException e) {
                logger.e(TAG, String.format("getNumberRows for %s failed", str), e);
                delete();
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                close();
                j = 0;
                return j;
            } catch (StackOverflowError e2) {
                logger.e(TAG, String.format("getNumberRows for %s failed", str), e2);
                delete();
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                close();
                j = 0;
                return j;
            }
        } catch (Throwable th) {
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            close();
            throw th;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long getNthEventId(long j) {
        return getNthEventIdFromTable(EVENT_TABLE_NAME, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long getNthIdentifyId(long j) {
        return getNthEventIdFromTable(IDENTIFY_TABLE_NAME, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long getLastIdentifyInterceptorId() {
        return getNthEventIdFromTable(IDENTIFY_INTERCEPTOR_TABLE_NAME, 1L, "DESC");
    }

    private synchronized long getNthEventIdFromTable(String str, long j) {
        return getNthEventIdFromTable(str, j, "ASC");
    }

    private synchronized long getNthEventIdFromTable(String str, long j, String str2) {
        long j2;
        j2 = -1;
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                SQLiteStatement compileStatement = getReadableDatabase().compileStatement("SELECT id FROM " + str + " ORDER BY id " + str2 + " LIMIT 1 OFFSET " + (j - 1));
                try {
                    j2 = compileStatement.simpleQueryForLong();
                } catch (SQLiteDoneException e) {
                    logger.w(TAG, e);
                }
                if (compileStatement != null) {
                    compileStatement.close();
                }
            } catch (SQLiteException e2) {
                logger.e(TAG, String.format("getNthEventId from %s failed", str), e2);
                delete();
                if (0 != 0) {
                    sQLiteStatement.close();
                }
            } catch (StackOverflowError e3) {
                logger.e(TAG, String.format("getNthEventId from %s failed", str), e3);
                delete();
                if (0 != 0) {
                    sQLiteStatement.close();
                }
            }
            close();
        } catch (Throwable th) {
            if (0 != 0) {
                sQLiteStatement.close();
            }
            close();
            throw th;
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void removeEvents(long j) {
        removeEventsFromTable(EVENT_TABLE_NAME, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void removeIdentifys(long j) {
        removeEventsFromTable(IDENTIFY_TABLE_NAME, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void removeIdentifyInterceptors(long j) {
        removeEventsFromTable(IDENTIFY_INTERCEPTOR_TABLE_NAME, j);
    }

    private synchronized void removeEventsFromTable(String str, long j) {
        try {
            try {
                getWritableDatabase().delete(str, "id <= " + j, null);
            } catch (SQLiteException e) {
                logger.e(TAG, String.format("removeEvents from %s failed", str), e);
                delete();
            } catch (StackOverflowError e2) {
                logger.e(TAG, String.format("removeEvents from %s failed", str), e2);
                delete();
            }
        } finally {
            close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void removeEvent(long j) {
        removeEventFromTable(EVENT_TABLE_NAME, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void removeIdentify(long j) {
        removeEventFromTable(IDENTIFY_TABLE_NAME, j);
    }

    synchronized void removeIdentifyIntercept(long j) {
        removeEventFromTable(IDENTIFY_INTERCEPTOR_TABLE_NAME, j);
    }

    private synchronized void removeEventFromTable(String str, long j) {
        try {
            try {
                getWritableDatabase().delete(str, "id = " + j, null);
            } catch (SQLiteException e) {
                logger.e(TAG, String.format("removeEvent from %s failed", str), e);
                delete();
            } catch (StackOverflowError e2) {
                logger.e(TAG, String.format("removeEvent from %s failed", str), e2);
                delete();
            }
        } finally {
            close();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c7, code lost:
    
        if (r1.isOpen() != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c9, code lost:
    
        close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e5, code lost:
    
        if (r1.isOpen() != false) goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void delete() {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.delete():void");
    }

    boolean dbFileExists() {
        return this.file.exists();
    }

    Cursor queryDb(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    private void handleIfCursorRowTooLargeException(IllegalStateException illegalStateException) {
        String message = illegalStateException.getMessage();
        if (Utils.isEmptyString(message)) {
            throw illegalStateException;
        }
        if (!message.contains("Couldn't read")) {
            throw illegalStateException;
        }
        if (message.contains("CursorWindow")) {
            delete();
            return;
        }
        throw illegalStateException;
    }

    private static void convertIfCursorWindowException(RuntimeException runtimeException) {
        String message = runtimeException.getMessage();
        if (Utils.isEmptyString(message)) {
            throw runtimeException;
        }
        if (message.startsWith("Cursor window allocation of") || message.startsWith("Could not allocate CursorWindow")) {
            throw new CursorWindowAllocationException(message);
        }
        throw runtimeException;
    }
}
