package expo.modules.core.logging;

import android.content.Context;
import com.amazon.a.a.o.b;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Logger.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003J\u001a\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003J$\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003J\u001a\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lexpo/modules/core/logging/Logger;", "", "category", "", "context", "Landroid/content/Context;", "options", "Lexpo/modules/core/logging/LoggerOptions;", "(Ljava/lang/String;Landroid/content/Context;Lexpo/modules/core/logging/LoggerOptions;)V", "handlers", "", "Lexpo/modules/core/logging/LogHandler;", "minOSLevel", "", b.ao, "", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "error", "cause", "", "fatal", "info", "log", "type", "Lexpo/modules/core/logging/LogType;", "trace", "warn", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Logger {
    private final List<LogHandler> handlers;
    private final int minOSLevel;

    public Logger(String category, Context context, LoggerOptions options) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(options, "options");
        ArrayList arrayList = new ArrayList();
        if (options.contains(LoggerOptions.INSTANCE.getLogToOS())) {
            arrayList.add(new OSLogHandler(category));
        }
        if (options.contains(LoggerOptions.INSTANCE.getLogToFile())) {
            if (context != null) {
                arrayList.add(new PersistentFileLogHandler(category, context));
            } else {
                throw new IllegalArgumentException("You have to provide the `Context` to create a file logger".toString());
            }
        }
        this.handlers = CollectionsKt.toList(arrayList);
        this.minOSLevel = 4;
    }

    public /* synthetic */ Logger(String str, Context context, LoggerOptions loggerOptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : context, loggerOptions);
    }

    public final void trace(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        log$default(this, LogType.Trace, message, null, 4, null);
    }

    public final void debug(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        log$default(this, LogType.Debug, message, null, 4, null);
    }

    public final void info(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        log$default(this, LogType.Info, message, null, 4, null);
    }

    public static /* synthetic */ void warn$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logger.warn(str, th);
    }

    public final void warn(String message, Throwable cause) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(LogType.Warn, message, cause);
    }

    public static /* synthetic */ void error$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logger.error(str, th);
    }

    public final void error(String message, Throwable cause) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(LogType.Error, message, cause);
    }

    public static /* synthetic */ void fatal$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logger.fatal(str, th);
    }

    public final void fatal(String message, Throwable cause) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(LogType.Fatal, message, cause);
    }

    static /* synthetic */ void log$default(Logger logger, LogType logType, String str, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logger.log(logType, str, th);
    }

    private final void log(LogType type, String message, Throwable cause) {
        if (LogType.INSTANCE.toOSLogType(type) >= this.minOSLevel) {
            Iterator<T> it = this.handlers.iterator();
            while (it.hasNext()) {
                ((LogHandler) it.next()).log$expo_modules_core_release(type, message, cause);
            }
        }
    }
}
