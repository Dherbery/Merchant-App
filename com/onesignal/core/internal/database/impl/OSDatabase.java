package com.onesignal.core.internal.database.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.amplitude.api.Constants;
import com.google.android.gms.actions.SearchIntents;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.outcomes.impl.OutcomeTableProvider;
import com.onesignal.session.internal.outcomes.impl.OutcomesDbContract;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: OSDatabase.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0010\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ/\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J$\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J$\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J \u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J \u0010 \u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J{\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\b\u0010#\u001a\u0004\u0018\u00010\r2\b\u0010$\u001a\u0004\u0018\u00010\r2\b\u0010%\u001a\u0004\u0018\u00010\r2\b\u0010&\u001a\u0004\u0018\u00010\r2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000b0(H\u0016¢\u0006\u0002\u0010*J\u0018\u0010+\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\rH\u0002J7\u0010-\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u00100\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u00101\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u00102\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u00103\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u00104\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u00105\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u00106\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/onesignal/core/internal/database/impl/OSDatabase;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Lcom/onesignal/core/internal/database/IDatabase;", "_outcomeTableProvider", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeTableProvider;", "context", "Landroid/content/Context;", Constants.AMP_PLAN_VERSION, "", "(Lcom/onesignal/session/internal/outcomes/impl/OutcomeTableProvider;Landroid/content/Context;I)V", "delete", "", "table", "", "whereClause", "whereArgs", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getSQLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "getSQLiteDatabaseWithRetries", "insert", "nullColumnHack", DiagnosticsEntry.Histogram.VALUES_KEY, "Landroid/content/ContentValues;", "insertOrThrow", "internalOnUpgrade", "db", "oldVersion", "newVersion", "onCreate", "onDowngrade", "onUpgrade", SearchIntents.EXTRA_QUERY, "columns", "groupBy", "having", "orderBy", "limit", "action", "Lkotlin/Function1;", "Lcom/onesignal/core/internal/database/ICursor;", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "safeExecSQL", "sql", "update", "(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "upgradeFromV5ToV6", "upgradeToV2", "upgradeToV3", "upgradeToV4", "upgradeToV5", "upgradeToV7", "upgradeToV8", "upgradeToV9", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public class OSDatabase extends SQLiteOpenHelper implements IDatabase {
    private static final String COMMA_SEP = ",";
    private static final String DATABASE_NAME = "OneSignal.db";
    private static final int DB_OPEN_RETRY_BACKOFF = 400;
    private static final int DB_OPEN_RETRY_MAX = 5;
    private static final int DB_VERSION = 9;
    public static final int DEFAULT_TTL_IF_NOT_IN_PAYLOAD = 259200;
    private static final String FLOAT_TYPE = " FLOAT";
    private static final String INTEGER_PRIMARY_KEY_TYPE = " INTEGER PRIMARY KEY";
    private static final String INT_TYPE = " INTEGER";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE notification (_id INTEGER PRIMARY KEY,notification_id TEXT,android_notification_id INTEGER,group_id TEXT,collapse_id TEXT,is_summary INTEGER DEFAULT 0,opened INTEGER DEFAULT 0,dismissed INTEGER DEFAULT 0,title TEXT,message TEXT,full_data TEXT,created_time TIMESTAMP DEFAULT (strftime('%s', 'now')),expire_time TIMESTAMP);";
    private static final String SQL_CREATE_IN_APP_MESSAGE_ENTRIES = "CREATE TABLE in_app_message (_id INTEGER PRIMARY KEY,display_quantity INTEGER,last_display INTEGER,message_id TEXT,displayed_in_session INTEGER,click_ids TEXT);";
    private static final String TEXT_TYPE = " TEXT";
    private static final String TIMESTAMP_TYPE = " TIMESTAMP";
    private final OutcomeTableProvider _outcomeTableProvider;
    private static final Object LOCK = new Object();
    private static final String[] SQL_INDEX_ENTRIES = {OneSignalDbContract.NotificationTable.INDEX_CREATE_NOTIFICATION_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_ANDROID_NOTIFICATION_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_GROUP_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_COLLAPSE_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_CREATED_TIME, OneSignalDbContract.NotificationTable.INDEX_CREATE_EXPIRE_TIME};

    public /* synthetic */ OSDatabase(OutcomeTableProvider outcomeTableProvider, Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(outcomeTableProvider, context, (i2 & 4) != 0 ? 9 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OSDatabase(OutcomeTableProvider _outcomeTableProvider, Context context, int i) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, i);
        Intrinsics.checkNotNullParameter(_outcomeTableProvider, "_outcomeTableProvider");
        this._outcomeTableProvider = _outcomeTableProvider;
    }

    private final SQLiteDatabase getSQLiteDatabase() {
        SQLiteDatabase writableDatabase;
        synchronized (LOCK) {
            try {
                writableDatabase = getWritableDatabase();
                Intrinsics.checkNotNullExpressionValue(writableDatabase, "{\n                writableDatabase\n            }");
            } catch (SQLiteCantOpenDatabaseException e) {
                throw e;
            } catch (SQLiteDatabaseLockedException e2) {
                throw e2;
            }
        }
        return writableDatabase;
    }

    private final SQLiteDatabase getSQLiteDatabaseWithRetries() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (LOCK) {
            int i = 0;
            while (true) {
                try {
                    sQLiteDatabase = getSQLiteDatabase();
                } catch (SQLiteCantOpenDatabaseException e) {
                    i++;
                    if (i >= 5) {
                        throw e;
                    }
                    SystemClock.sleep(i * 400);
                } catch (SQLiteDatabaseLockedException e2) {
                    i++;
                    if (i >= 5) {
                        throw e2;
                    }
                    SystemClock.sleep(i * 400);
                }
            }
        }
        return sQLiteDatabase;
    }

    @Override // com.onesignal.core.internal.database.IDatabase
    public void query(String table, String[] columns, String whereClause, String[] whereArgs, String groupBy, String having, String orderBy, String limit, Function1<? super ICursor, Unit> action) {
        Cursor query;
        Intrinsics.checkNotNullParameter(table, "table");
        Intrinsics.checkNotNullParameter(action, "action");
        synchronized (LOCK) {
            if (limit == null) {
                query = getSQLiteDatabaseWithRetries().query(table, columns, whereClause, whereArgs, groupBy, having, orderBy);
                Intrinsics.checkNotNullExpressionValue(query, "getSQLiteDatabaseWithRet…By,\n                    )");
            } else {
                query = getSQLiteDatabaseWithRetries().query(table, columns, whereClause, whereArgs, groupBy, having, orderBy, limit);
                Intrinsics.checkNotNullExpressionValue(query, "getSQLiteDatabaseWithRet…it,\n                    )");
            }
            Unit unit = Unit.INSTANCE;
        }
        Cursor cursor = query;
        try {
            action.invoke(new DatabaseCursor(cursor));
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, null);
        } finally {
        }
    }

    @Override // com.onesignal.core.internal.database.IDatabase
    public void insert(String table, String nullColumnHack, ContentValues values) {
        String str;
        SQLiteException sQLiteException;
        String str2;
        IllegalStateException illegalStateException;
        Intrinsics.checkNotNullParameter(table, "table");
        synchronized (LOCK) {
            SQLiteDatabase sQLiteDatabaseWithRetries = getSQLiteDatabaseWithRetries();
            try {
                try {
                    try {
                        sQLiteDatabaseWithRetries.beginTransaction();
                        sQLiteDatabaseWithRetries.insert(table, nullColumnHack, values);
                        sQLiteDatabaseWithRetries.setTransactionSuccessful();
                        try {
                            try {
                                sQLiteDatabaseWithRetries.endTransaction();
                            } catch (SQLiteException e) {
                                str = "Error closing transaction! ";
                                sQLiteException = e;
                                Logging.error(str, sQLiteException);
                                Unit unit = Unit.INSTANCE;
                            }
                        } catch (IllegalStateException e2) {
                            str2 = "Error closing transaction! ";
                            illegalStateException = e2;
                            Logging.error(str2, illegalStateException);
                            Unit unit2 = Unit.INSTANCE;
                        }
                    } catch (SQLiteException e3) {
                        Logging.error("Error inserting on table: " + table + " with nullColumnHack: " + nullColumnHack + " and values: " + values, e3);
                        try {
                            try {
                                sQLiteDatabaseWithRetries.endTransaction();
                            } catch (SQLiteException e4) {
                                str = "Error closing transaction! ";
                                sQLiteException = e4;
                                Logging.error(str, sQLiteException);
                                Unit unit22 = Unit.INSTANCE;
                            }
                        } catch (IllegalStateException e5) {
                            str2 = "Error closing transaction! ";
                            illegalStateException = e5;
                            Logging.error(str2, illegalStateException);
                            Unit unit222 = Unit.INSTANCE;
                        }
                    }
                } catch (IllegalStateException e6) {
                    Logging.error("Error under inserting transaction under table: " + table + " with nullColumnHack: " + nullColumnHack + " and values: " + values, e6);
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (SQLiteException e7) {
                        str = "Error closing transaction! ";
                        sQLiteException = e7;
                        Logging.error(str, sQLiteException);
                        Unit unit2222 = Unit.INSTANCE;
                    } catch (IllegalStateException e8) {
                        str2 = "Error closing transaction! ";
                        illegalStateException = e8;
                        Logging.error(str2, illegalStateException);
                        Unit unit22222 = Unit.INSTANCE;
                    }
                }
                Unit unit222222 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e9) {
                        Logging.error("Error closing transaction! ", e9);
                    }
                } catch (SQLiteException e10) {
                    Logging.error("Error closing transaction! ", e10);
                }
                throw th;
            }
        }
    }

    @Override // com.onesignal.core.internal.database.IDatabase
    public void insertOrThrow(String table, String nullColumnHack, ContentValues values) throws SQLException {
        String str;
        SQLiteException sQLiteException;
        String str2;
        IllegalStateException illegalStateException;
        Intrinsics.checkNotNullParameter(table, "table");
        synchronized (LOCK) {
            SQLiteDatabase sQLiteDatabaseWithRetries = getSQLiteDatabaseWithRetries();
            try {
                try {
                    try {
                        sQLiteDatabaseWithRetries.beginTransaction();
                        sQLiteDatabaseWithRetries.insertOrThrow(table, nullColumnHack, values);
                        sQLiteDatabaseWithRetries.setTransactionSuccessful();
                        try {
                            try {
                                sQLiteDatabaseWithRetries.endTransaction();
                            } catch (SQLiteException e) {
                                str = "Error closing transaction! ";
                                sQLiteException = e;
                                Logging.error(str, sQLiteException);
                                Unit unit = Unit.INSTANCE;
                            }
                        } catch (IllegalStateException e2) {
                            str2 = "Error closing transaction! ";
                            illegalStateException = e2;
                            Logging.error(str2, illegalStateException);
                            Unit unit2 = Unit.INSTANCE;
                        }
                    } catch (SQLiteException e3) {
                        Logging.error("Error inserting or throw on table: " + table + " with nullColumnHack: " + nullColumnHack + " and values: " + values, e3);
                        try {
                            try {
                                sQLiteDatabaseWithRetries.endTransaction();
                            } catch (SQLiteException e4) {
                                str = "Error closing transaction! ";
                                sQLiteException = e4;
                                Logging.error(str, sQLiteException);
                                Unit unit22 = Unit.INSTANCE;
                            }
                        } catch (IllegalStateException e5) {
                            str2 = "Error closing transaction! ";
                            illegalStateException = e5;
                            Logging.error(str2, illegalStateException);
                            Unit unit222 = Unit.INSTANCE;
                        }
                    }
                } catch (IllegalStateException e6) {
                    Logging.error("Error under inserting or throw transaction under table: " + table + " with nullColumnHack: " + nullColumnHack + " and values: " + values, e6);
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (SQLiteException e7) {
                        str = "Error closing transaction! ";
                        sQLiteException = e7;
                        Logging.error(str, sQLiteException);
                        Unit unit2222 = Unit.INSTANCE;
                    } catch (IllegalStateException e8) {
                        str2 = "Error closing transaction! ";
                        illegalStateException = e8;
                        Logging.error(str2, illegalStateException);
                        Unit unit22222 = Unit.INSTANCE;
                    }
                }
                Unit unit222222 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e9) {
                        Logging.error("Error closing transaction! ", e9);
                    }
                } catch (SQLiteException e10) {
                    Logging.error("Error closing transaction! ", e10);
                }
                throw th;
            }
        }
    }

    @Override // com.onesignal.core.internal.database.IDatabase
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        String str;
        IllegalStateException illegalStateException;
        String str2;
        SQLiteException sQLiteException;
        Intrinsics.checkNotNullParameter(table, "table");
        Intrinsics.checkNotNullParameter(values, "values");
        String contentValues = values.toString();
        Intrinsics.checkNotNullExpressionValue(contentValues, "values.toString()");
        int i = 0;
        if (contentValues.length() == 0) {
            return 0;
        }
        synchronized (LOCK) {
            SQLiteDatabase sQLiteDatabaseWithRetries = getSQLiteDatabaseWithRetries();
            try {
                try {
                    sQLiteDatabaseWithRetries.beginTransaction();
                    i = sQLiteDatabaseWithRetries.update(table, values, whereClause, whereArgs);
                    sQLiteDatabaseWithRetries.setTransactionSuccessful();
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (SQLiteException e) {
                        str2 = "Error closing transaction! ";
                        sQLiteException = e;
                        Logging.error(str2, sQLiteException);
                        Unit unit = Unit.INSTANCE;
                        return i;
                    } catch (IllegalStateException e2) {
                        str = "Error closing transaction! ";
                        illegalStateException = e2;
                        Logging.error(str, illegalStateException);
                        Unit unit2 = Unit.INSTANCE;
                        return i;
                    }
                } catch (SQLiteException e3) {
                    Logging.error("Error updating on table: " + table + " with whereClause: " + whereClause + " and whereArgs: " + whereArgs, e3);
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (SQLiteException e4) {
                        str2 = "Error closing transaction! ";
                        sQLiteException = e4;
                        Logging.error(str2, sQLiteException);
                        Unit unit22 = Unit.INSTANCE;
                        return i;
                    } catch (IllegalStateException e5) {
                        str = "Error closing transaction! ";
                        illegalStateException = e5;
                        Logging.error(str, illegalStateException);
                        Unit unit222 = Unit.INSTANCE;
                        return i;
                    }
                } catch (IllegalStateException e6) {
                    Logging.error("Error under update transaction under table: " + table + " with whereClause: " + whereClause + " and whereArgs: " + whereArgs, e6);
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (SQLiteException e7) {
                        str2 = "Error closing transaction! ";
                        sQLiteException = e7;
                        Logging.error(str2, sQLiteException);
                        Unit unit2222 = Unit.INSTANCE;
                        return i;
                    } catch (IllegalStateException e8) {
                        str = "Error closing transaction! ";
                        illegalStateException = e8;
                        Logging.error(str, illegalStateException);
                        Unit unit22222 = Unit.INSTANCE;
                        return i;
                    }
                }
                Unit unit222222 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    sQLiteDatabaseWithRetries.endTransaction();
                } catch (SQLiteException e9) {
                    Logging.error("Error closing transaction! ", e9);
                } catch (IllegalStateException e10) {
                    Logging.error("Error closing transaction! ", e10);
                }
                throw th;
            }
        }
        return i;
    }

    @Override // com.onesignal.core.internal.database.IDatabase
    public void delete(String table, String whereClause, String[] whereArgs) {
        String str;
        SQLiteException sQLiteException;
        String str2;
        IllegalStateException illegalStateException;
        Intrinsics.checkNotNullParameter(table, "table");
        synchronized (LOCK) {
            SQLiteDatabase sQLiteDatabaseWithRetries = getSQLiteDatabaseWithRetries();
            try {
                try {
                    try {
                        sQLiteDatabaseWithRetries.beginTransaction();
                        sQLiteDatabaseWithRetries.delete(table, whereClause, whereArgs);
                        sQLiteDatabaseWithRetries.setTransactionSuccessful();
                        try {
                            try {
                                sQLiteDatabaseWithRetries.endTransaction();
                            } catch (SQLiteException e) {
                                str = "Error closing transaction! ";
                                sQLiteException = e;
                                Logging.error(str, sQLiteException);
                                Unit unit = Unit.INSTANCE;
                            }
                        } catch (IllegalStateException e2) {
                            str2 = "Error closing transaction! ";
                            illegalStateException = e2;
                            Logging.error(str2, illegalStateException);
                            Unit unit2 = Unit.INSTANCE;
                        }
                    } catch (SQLiteException e3) {
                        Logging.error("Error deleting on table: " + table + " with whereClause: " + whereClause + " and whereArgs: " + whereArgs, e3);
                        try {
                            try {
                                sQLiteDatabaseWithRetries.endTransaction();
                            } catch (SQLiteException e4) {
                                str = "Error closing transaction! ";
                                sQLiteException = e4;
                                Logging.error(str, sQLiteException);
                                Unit unit22 = Unit.INSTANCE;
                            }
                        } catch (IllegalStateException e5) {
                            str2 = "Error closing transaction! ";
                            illegalStateException = e5;
                            Logging.error(str2, illegalStateException);
                            Unit unit222 = Unit.INSTANCE;
                        }
                    }
                } catch (IllegalStateException e6) {
                    Logging.error("Error under delete transaction under table: " + table + " with whereClause: " + whereClause + " and whereArgs: " + whereArgs, e6);
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (SQLiteException e7) {
                        str = "Error closing transaction! ";
                        sQLiteException = e7;
                        Logging.error(str, sQLiteException);
                        Unit unit2222 = Unit.INSTANCE;
                    } catch (IllegalStateException e8) {
                        str2 = "Error closing transaction! ";
                        illegalStateException = e8;
                        Logging.error(str2, illegalStateException);
                        Unit unit22222 = Unit.INSTANCE;
                    }
                }
                Unit unit222222 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e9) {
                        Logging.error("Error closing transaction! ", e9);
                    }
                } catch (SQLiteException e10) {
                    Logging.error("Error closing transaction! ", e10);
                }
                throw th;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL(OutcomesDbContract.SQL_CREATE_OUTCOME_ENTRIES_V4);
        db.execSQL(OutcomesDbContract.SQL_CREATE_UNIQUE_OUTCOME_ENTRIES_V2);
        db.execSQL(SQL_CREATE_IN_APP_MESSAGE_ENTRIES);
        for (String str : SQL_INDEX_ENTRIES) {
            db.execSQL(str);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Intrinsics.checkNotNullParameter(db, "db");
        Logging.debug$default("OneSignal Database onUpgrade from: " + oldVersion + " to: " + newVersion, null, 2, null);
        try {
            internalOnUpgrade(db, oldVersion, newVersion);
        } catch (SQLiteException e) {
            Logging.error("Error in upgrade, migration may have already run! Skipping!", e);
        }
    }

    private final synchronized void internalOnUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2 && newVersion >= 2) {
            try {
                upgradeToV2(db);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (oldVersion < 3 && newVersion >= 3) {
            upgradeToV3(db);
        }
        if (oldVersion < 4 && newVersion >= 4) {
            upgradeToV4(db);
        }
        if (oldVersion < 5 && newVersion >= 5) {
            upgradeToV5(db);
        }
        if (oldVersion == 5 && newVersion >= 6) {
            upgradeFromV5ToV6(db);
        }
        if (oldVersion < 7 && newVersion >= 7) {
            upgradeToV7(db);
        }
        if (oldVersion < 8 && newVersion >= 8) {
            upgradeToV8(db);
        }
        if (oldVersion < 9 && newVersion >= 9) {
            upgradeToV9(db);
        }
    }

    private final void upgradeToV2(SQLiteDatabase db) {
        safeExecSQL(db, "ALTER TABLE notification ADD COLUMN collapse_id TEXT;");
        safeExecSQL(db, OneSignalDbContract.NotificationTable.INDEX_CREATE_GROUP_ID);
    }

    private final void upgradeToV3(SQLiteDatabase db) {
        safeExecSQL(db, "ALTER TABLE notification ADD COLUMN expire_time TIMESTAMP;");
        safeExecSQL(db, "UPDATE notification SET expire_time = created_time + 259200;");
        safeExecSQL(db, OneSignalDbContract.NotificationTable.INDEX_CREATE_EXPIRE_TIME);
    }

    private final void upgradeToV4(SQLiteDatabase db) {
        safeExecSQL(db, OutcomesDbContract.SQL_CREATE_OUTCOME_ENTRIES_V1);
    }

    private final void upgradeToV5(SQLiteDatabase db) {
        safeExecSQL(db, OutcomesDbContract.SQL_CREATE_UNIQUE_OUTCOME_ENTRIES_V1);
        upgradeFromV5ToV6(db);
    }

    private final void upgradeFromV5ToV6(SQLiteDatabase db) {
        this._outcomeTableProvider.upgradeOutcomeTableRevision1To2(db);
    }

    private final void upgradeToV7(SQLiteDatabase db) {
        safeExecSQL(db, SQL_CREATE_IN_APP_MESSAGE_ENTRIES);
    }

    private final void safeExecSQL(SQLiteDatabase db, String sql) {
        try {
            db.execSQL(sql);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    private final synchronized void upgradeToV8(SQLiteDatabase db) {
        this._outcomeTableProvider.upgradeOutcomeTableRevision2To3(db);
        this._outcomeTableProvider.upgradeCacheOutcomeTableRevision1To2(db);
    }

    private final void upgradeToV9(SQLiteDatabase db) {
        this._outcomeTableProvider.upgradeOutcomeTableRevision3To4(db);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Intrinsics.checkNotNullParameter(db, "db");
        Logging.warn$default("SDK version rolled back! Clearing OneSignal.db as it could be in an unexpected state.", null, 2, null);
        Cursor rawQuery = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        try {
            Cursor cursor = rawQuery;
            ArrayList<String> arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                String string = cursor.getString(0);
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(0)");
                arrayList.add(string);
            }
            for (String str : arrayList) {
                if (!StringsKt.startsWith$default(str, "sqlite_", false, 2, (Object) null)) {
                    db.execSQL("DROP TABLE IF EXISTS " + str);
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(rawQuery, null);
            onCreate(db);
        } finally {
        }
    }
}
