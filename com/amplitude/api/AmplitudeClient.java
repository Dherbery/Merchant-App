package com.amplitude.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.os.Build;
import android.util.Pair;
import androidx.core.os.EnvironmentCompat;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.a.a.o.b;
import com.amplitude.analytics.connector.AnalyticsConnector;
import com.amplitude.analytics.connector.AnalyticsEvent;
import com.amplitude.analytics.connector.Identity;
import com.amplitude.analytics.connector.util.JSONUtil;
import com.amplitude.api.ConfigManager;
import com.amplitude.eventexplorer.EventExplorer;
import com.amplitude.util.DoubleCheck;
import com.amplitude.util.Provider;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AmplitudeClient {
    public static final String DEVICE_ID_KEY = "device_id";
    public static final String END_SESSION_EVENT = "session_end";
    public static final String LAST_EVENT_ID_KEY = "last_event_id";
    public static final String LAST_EVENT_TIME_KEY = "last_event_time";
    public static final String LAST_IDENTIFY_ID_KEY = "last_identify_id";
    public static final String OPT_OUT_KEY = "opt_out";
    public static final String PREVIOUS_SESSION_ID_KEY = "previous_session_id";
    public static final String SEQUENCE_NUMBER_KEY = "sequence_number";
    public static final String START_SESSION_EVENT = "session_start";
    private static final String TAG = "com.amplitude.api.AmplitudeClient";
    public static final String USER_ID_KEY = "user_id";
    private static final AmplitudeLog logger = AmplitudeLog.getLogger();
    protected String apiKey;
    JSONObject apiPropertiesTrackingOptions;
    TrackingOptions appliedTrackingOptions;
    private boolean backoffUpload;
    private int backoffUploadBatchSize;
    String bearerToken;
    protected Call.Factory callFactory;
    final AnalyticsConnector connector;
    protected Context context;
    private boolean coppaControlEnabled;
    protected DatabaseHelper dbHelper;
    protected String deviceId;
    private AmplitudeDeviceIdCallback deviceIdCallback;
    protected DeviceInfo deviceInfo;
    private EventExplorer eventExplorer;
    private int eventMaxCount;
    private int eventUploadMaxBatchSize;
    private long eventUploadPeriodMillis;
    private int eventUploadThreshold;
    private boolean flushEventsOnClose;
    WorkerThread httpThread;
    private long identifyBatchIntervalMillis;
    private IdentifyInterceptor identifyInterceptor;
    private boolean inForeground;
    private IngestionMetadata ingestionMetadata;
    protected boolean initialized;
    TrackingOptions inputTrackingOptions;
    protected String instanceName;
    private boolean isEnteringForeground;
    Throwable lastError;
    long lastEventId;
    long lastEventTime;
    long lastIdentifyId;
    private String libraryName;
    private String libraryVersion;
    private boolean locationListening;
    WorkerThread logThread;
    MiddlewareRunner middlewareRunner;
    private long minTimeBetweenSessionsMillis;
    private boolean newDeviceIdPerInstall;
    private boolean offline;
    private boolean optOut;
    private Plan plan;
    protected String platform;
    long previousSessionId;
    long sequenceNumber;
    private AmplitudeServerZone serverZone;
    long sessionId;
    private long sessionTimeoutMillis;
    private boolean trackingSessionEvents;
    private AtomicBoolean updateScheduled;
    AtomicBoolean uploadingCurrently;
    String url;
    private boolean useAdvertisingIdForDeviceId;
    private boolean useAppSetIdForDeviceId;
    private boolean useDynamicConfig;
    protected String userId;
    private boolean usingForegroundTracking;

    public static /* synthetic */ OkHttpClient $r8$lambda$uWBdBgn9ebx5ZjaSsGzJj44YwX4() {
        return new OkHttpClient();
    }

    public AmplitudeClient disableDiagnosticLogging() {
        return this;
    }

    public AmplitudeClient enableDiagnosticLogging() {
        return this;
    }

    public AmplitudeClient setDiagnosticEventMaxCount(int i) {
        return this;
    }

    public AmplitudeClient() {
        this(null);
    }

    public AmplitudeClient(String str) {
        this.newDeviceIdPerInstall = false;
        this.useAdvertisingIdForDeviceId = false;
        this.useAppSetIdForDeviceId = false;
        this.initialized = false;
        this.optOut = false;
        this.offline = false;
        TrackingOptions trackingOptions = new TrackingOptions();
        this.inputTrackingOptions = trackingOptions;
        TrackingOptions copyOf = TrackingOptions.copyOf(trackingOptions);
        this.appliedTrackingOptions = copyOf;
        this.apiPropertiesTrackingOptions = copyOf.getApiPropertiesTrackingOptions();
        this.coppaControlEnabled = false;
        this.locationListening = true;
        this.serverZone = AmplitudeServerZone.US;
        this.sessionId = -1L;
        this.sequenceNumber = 0L;
        this.lastEventId = -1L;
        this.lastIdentifyId = -1L;
        this.lastEventTime = -1L;
        this.previousSessionId = -1L;
        this.eventUploadThreshold = 30;
        this.eventUploadMaxBatchSize = 50;
        this.eventMaxCount = 1000;
        this.eventUploadPeriodMillis = 30000L;
        this.minTimeBetweenSessionsMillis = 300000L;
        this.identifyBatchIntervalMillis = 30000L;
        this.sessionTimeoutMillis = Constants.SESSION_TIMEOUT_MILLIS;
        this.backoffUpload = false;
        this.backoffUploadBatchSize = 50;
        this.usingForegroundTracking = false;
        this.trackingSessionEvents = false;
        this.inForeground = false;
        this.isEnteringForeground = false;
        this.flushEventsOnClose = true;
        this.libraryName = Constants.LIBRARY;
        this.libraryVersion = "2.39.7";
        this.useDynamicConfig = false;
        this.updateScheduled = new AtomicBoolean(false);
        this.uploadingCurrently = new AtomicBoolean(false);
        this.url = Constants.EVENT_LOG_URL;
        this.bearerToken = null;
        this.logThread = new WorkerThread("logThread");
        this.httpThread = new WorkerThread("httpThread");
        this.middlewareRunner = new MiddlewareRunner();
        this.instanceName = Utils.normalizeInstanceName(str);
        this.logThread.start();
        this.httpThread.start();
        this.connector = AnalyticsConnector.getInstance(this.instanceName);
    }

    public AmplitudeClient initialize(Context context, String str) {
        return initialize(context, str, null);
    }

    public AmplitudeClient initialize(Context context, String str, String str2) {
        return initialize(context, str, str2, null, false);
    }

    public synchronized AmplitudeClient initialize(Context context, String str, String str2, String str3, boolean z) {
        return initializeInternal(context, str, str2, str3, z, null);
    }

    public synchronized AmplitudeClient initialize(Context context, String str, String str2, String str3, boolean z, Call.Factory factory) {
        return initializeInternal(context, str, str2, str3, z, factory);
    }

    public synchronized AmplitudeClient initializeInternal(Context context, String str, final String str2, String str3, boolean z, final Call.Factory factory) {
        if (context == null) {
            logger.e(TAG, "Argument context cannot be null in initialize()");
            return this;
        }
        if (Utils.isEmptyString(str)) {
            logger.e(TAG, "Argument apiKey cannot be null or blank in initialize()");
            return this;
        }
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.apiKey = str;
        this.dbHelper = DatabaseHelper.getDatabaseHelper(applicationContext, this.instanceName);
        if (Utils.isEmptyString(str3)) {
            str3 = Constants.PLATFORM;
        }
        this.platform = str3;
        runOnLogThread(new Runnable() { // from class: com.amplitude.api.AmplitudeClient$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AmplitudeClient.this.m271lambda$initializeInternal$2$comamplitudeapiAmplitudeClient(factory, str2, this);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initializeInternal$2$com-amplitude-api-AmplitudeClient, reason: not valid java name */
    public /* synthetic */ void m271lambda$initializeInternal$2$comamplitudeapiAmplitudeClient(Call.Factory factory, String str, final AmplitudeClient amplitudeClient) {
        if (this.initialized) {
            return;
        }
        try {
            if (factory == null) {
                final Provider provider = DoubleCheck.provider(new Provider() { // from class: com.amplitude.api.AmplitudeClient$$ExternalSyntheticLambda1
                    @Override // com.amplitude.util.Provider
                    public final Object get() {
                        return AmplitudeClient.$r8$lambda$uWBdBgn9ebx5ZjaSsGzJj44YwX4();
                    }
                });
                this.callFactory = new Call.Factory() { // from class: com.amplitude.api.AmplitudeClient$$ExternalSyntheticLambda2
                    @Override // okhttp3.Call.Factory
                    public final Call newCall(Request request) {
                        Call newCall;
                        newCall = ((Call.Factory) Provider.this.get()).newCall(request);
                        return newCall;
                    }
                };
            } else {
                this.callFactory = factory;
            }
            if (this.useDynamicConfig) {
                ConfigManager.getInstance().refresh(new ConfigManager.RefreshListener() { // from class: com.amplitude.api.AmplitudeClient.1
                    @Override // com.amplitude.api.ConfigManager.RefreshListener
                    public void onFinished() {
                        AmplitudeClient.this.url = ConfigManager.getInstance().getIngestionEndpoint();
                    }
                }, this.serverZone);
            }
            this.deviceInfo = initializeDeviceInfo();
            String initializeDeviceId = initializeDeviceId();
            this.deviceId = initializeDeviceId;
            AmplitudeDeviceIdCallback amplitudeDeviceIdCallback = this.deviceIdCallback;
            if (amplitudeDeviceIdCallback != null) {
                amplitudeDeviceIdCallback.onDeviceIdReady(initializeDeviceId);
            }
            if (str != null) {
                amplitudeClient.userId = str;
                this.dbHelper.insertOrReplaceKeyValue(USER_ID_KEY, str);
            } else {
                amplitudeClient.userId = this.dbHelper.getValue(USER_ID_KEY);
            }
            this.connector.getEventBridge().setEventReceiver(new Function1() { // from class: com.amplitude.api.AmplitudeClient$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AmplitudeClient.this.m272lambda$null$1$comamplitudeapiAmplitudeClient((AnalyticsEvent) obj);
                }
            });
            this.connector.getIdentityStore().setIdentity(new Identity(str, this.deviceId, new HashMap()));
            this.deviceInfo.prefetch();
            Long longValue = this.dbHelper.getLongValue(OPT_OUT_KEY);
            this.optOut = longValue != null && longValue.longValue() == 1;
            long longvalue = getLongvalue(PREVIOUS_SESSION_ID_KEY, -1L);
            this.previousSessionId = longvalue;
            if (longvalue >= 0) {
                this.sessionId = longvalue;
            }
            this.sequenceNumber = getLongvalue(SEQUENCE_NUMBER_KEY, 0L);
            this.lastEventId = getLongvalue(LAST_EVENT_ID_KEY, -1L);
            this.lastIdentifyId = getLongvalue(LAST_IDENTIFY_ID_KEY, -1L);
            this.lastEventTime = getLongvalue(LAST_EVENT_TIME_KEY, -1L);
            this.dbHelper.setDatabaseResetListener(new DatabaseResetListener() { // from class: com.amplitude.api.AmplitudeClient.2
                @Override // com.amplitude.api.DatabaseResetListener
                public void onDatabaseReset(SQLiteDatabase sQLiteDatabase) {
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyValueToTable(sQLiteDatabase, ProductResponseJsonKeys.STORE, AmplitudeClient.DEVICE_ID_KEY, amplitudeClient.deviceId);
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyValueToTable(sQLiteDatabase, ProductResponseJsonKeys.STORE, AmplitudeClient.USER_ID_KEY, amplitudeClient.userId);
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyValueToTable(sQLiteDatabase, "long_store", AmplitudeClient.OPT_OUT_KEY, Long.valueOf(amplitudeClient.optOut ? 1L : 0L));
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyValueToTable(sQLiteDatabase, "long_store", AmplitudeClient.PREVIOUS_SESSION_ID_KEY, Long.valueOf(amplitudeClient.sessionId));
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyValueToTable(sQLiteDatabase, "long_store", AmplitudeClient.LAST_EVENT_TIME_KEY, Long.valueOf(amplitudeClient.lastEventTime));
                }
            });
            this.identifyInterceptor = new IdentifyInterceptor(this.dbHelper, this.logThread, this.identifyBatchIntervalMillis, this);
            this.initialized = true;
        } catch (CursorWindowAllocationException e) {
            logger.e(TAG, String.format("Failed to initialize Amplitude SDK due to: %s", e.getMessage()));
            amplitudeClient.apiKey = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$null$1$com-amplitude-api-AmplitudeClient, reason: not valid java name */
    public /* synthetic */ Unit m272lambda$null$1$comamplitudeapiAmplitudeClient(AnalyticsEvent analyticsEvent) {
        logEventAsync(analyticsEvent.getEventType(), JSONUtil.toJSONObject(analyticsEvent.getEventProperties()), null, JSONUtil.toJSONObject(analyticsEvent.getUserProperties()), null, null, getCurrentTimeMillis(), false);
        return Unit.INSTANCE;
    }

    public AmplitudeClient enableForegroundTracking(Application application) {
        if (!this.usingForegroundTracking && contextAndApiKeySet("enableForegroundTracking()")) {
            application.registerActivityLifecycleCallbacks(new AmplitudeCallbacks(this));
        }
        return this;
    }

    public AmplitudeClient enableNewDeviceIdPerInstall(boolean z) {
        this.newDeviceIdPerInstall = z;
        return this;
    }

    public AmplitudeClient useAdvertisingIdForDeviceId() {
        this.useAdvertisingIdForDeviceId = true;
        return this;
    }

    public AmplitudeClient useAppSetIdForDeviceId() {
        this.useAppSetIdForDeviceId = true;
        return this;
    }

    public AmplitudeClient enableLocationListening() {
        this.locationListening = true;
        DeviceInfo deviceInfo = this.deviceInfo;
        if (deviceInfo != null) {
            deviceInfo.setLocationListening(true);
        }
        return this;
    }

    public AmplitudeClient disableLocationListening() {
        this.locationListening = false;
        DeviceInfo deviceInfo = this.deviceInfo;
        if (deviceInfo != null) {
            deviceInfo.setLocationListening(false);
        }
        return this;
    }

    public AmplitudeClient setEventUploadThreshold(int i) {
        this.eventUploadThreshold = i;
        return this;
    }

    public AmplitudeClient setEventUploadMaxBatchSize(int i) {
        this.eventUploadMaxBatchSize = i;
        this.backoffUploadBatchSize = i;
        return this;
    }

    public AmplitudeClient setEventMaxCount(int i) {
        this.eventMaxCount = i;
        return this;
    }

    public AmplitudeClient setEventUploadPeriodMillis(int i) {
        this.eventUploadPeriodMillis = i;
        return this;
    }

    public AmplitudeClient setMinTimeBetweenSessionsMillis(long j) {
        this.minTimeBetweenSessionsMillis = j;
        return this;
    }

    public AmplitudeClient setIdentifyBatchIntervalMillis(long j) {
        if (j < this.eventUploadPeriodMillis) {
            logger.w(TAG, "Warning: minimum batch interval is event upload period.");
            return this;
        }
        this.identifyBatchIntervalMillis = j;
        IdentifyInterceptor identifyInterceptor = this.identifyInterceptor;
        if (identifyInterceptor != null) {
            identifyInterceptor.setIdentifyBatchIntervalMillis(j);
        }
        return this;
    }

    public AmplitudeClient setServerUrl(String str) {
        if (!Utils.isEmptyString(str)) {
            this.url = str;
        }
        return this;
    }

    public AmplitudeClient setBearerToken(String str) {
        this.bearerToken = str;
        return this;
    }

    public AmplitudeClient setSessionTimeoutMillis(long j) {
        this.sessionTimeoutMillis = j;
        return this;
    }

    public AmplitudeClient setTrackingOptions(TrackingOptions trackingOptions) {
        this.inputTrackingOptions = trackingOptions;
        TrackingOptions copyOf = TrackingOptions.copyOf(trackingOptions);
        this.appliedTrackingOptions = copyOf;
        if (this.coppaControlEnabled) {
            copyOf.mergeIn(TrackingOptions.forCoppaControl());
        }
        this.apiPropertiesTrackingOptions = this.appliedTrackingOptions.getApiPropertiesTrackingOptions();
        return this;
    }

    public AmplitudeClient enableCoppaControl() {
        this.coppaControlEnabled = true;
        this.appliedTrackingOptions.mergeIn(TrackingOptions.forCoppaControl());
        this.apiPropertiesTrackingOptions = this.appliedTrackingOptions.getApiPropertiesTrackingOptions();
        return this;
    }

    public AmplitudeClient disableCoppaControl() {
        this.coppaControlEnabled = false;
        TrackingOptions copyOf = TrackingOptions.copyOf(this.inputTrackingOptions);
        this.appliedTrackingOptions = copyOf;
        this.apiPropertiesTrackingOptions = copyOf.getApiPropertiesTrackingOptions();
        return this;
    }

    public AmplitudeClient setOptOut(final boolean z) {
        if (!contextAndApiKeySet("setOptOut()")) {
            return this;
        }
        runOnLogThread(new Runnable() { // from class: com.amplitude.api.AmplitudeClient.3
            @Override // java.lang.Runnable
            public void run() {
                if (Utils.isEmptyString(AmplitudeClient.this.apiKey)) {
                    return;
                }
                this.optOut = z;
                AmplitudeClient.this.dbHelper.insertOrReplaceKeyLongValue(AmplitudeClient.OPT_OUT_KEY, Long.valueOf(z ? 1L : 0L));
            }
        });
        return this;
    }

    public AmplitudeClient setLibraryName(String str) {
        this.libraryName = str;
        return this;
    }

    public AmplitudeClient setLibraryVersion(String str) {
        this.libraryVersion = str;
        return this;
    }

    public boolean isOptedOut() {
        return this.optOut;
    }

    public AmplitudeClient enableLogging(boolean z) {
        logger.setEnableLogging(z);
        return this;
    }

    public AmplitudeClient setLogLevel(int i) {
        logger.setLogLevel(i);
        return this;
    }

    public AmplitudeClient setLogCallback(AmplitudeLogCallback amplitudeLogCallback) {
        logger.setAmplitudeLogCallback(amplitudeLogCallback);
        return this;
    }

    public AmplitudeClient setOffline(boolean z) {
        this.offline = z;
        if (!z) {
            uploadEvents();
        }
        return this;
    }

    public AmplitudeClient setFlushEventsOnClose(boolean z) {
        this.flushEventsOnClose = z;
        return this;
    }

    public AmplitudeClient trackSessionEvents(boolean z) {
        this.trackingSessionEvents = z;
        return this;
    }

    public AmplitudeClient setUseDynamicConfig(boolean z) {
        this.useDynamicConfig = z;
        return this;
    }

    public void showEventExplorer(Activity activity) {
        if (this.eventExplorer == null) {
            this.eventExplorer = new EventExplorer(this.instanceName);
        }
        this.eventExplorer.show(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void useForegroundTracking() {
        this.usingForegroundTracking = true;
    }

    boolean isUsingForegroundTracking() {
        return this.usingForegroundTracking;
    }

    public void addEventMiddleware(Middleware middleware) {
        this.middlewareRunner.add(middleware);
    }

    boolean isInForeground() {
        return this.inForeground;
    }

    public void logEvent(String str) {
        logEvent(str, null);
    }

    public void logEvent(String str, JSONObject jSONObject) {
        logEvent(str, jSONObject, false);
    }

    public void logEvent(String str, JSONObject jSONObject, MiddlewareExtra middlewareExtra) {
        logEvent(str, jSONObject, null, getCurrentTimeMillis(), false, middlewareExtra);
    }

    public void logEvent(String str, JSONObject jSONObject, boolean z) {
        logEvent(str, jSONObject, null, z);
    }

    public void logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        logEvent(str, jSONObject, jSONObject2, false);
    }

    public void logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        logEvent(str, jSONObject, jSONObject2, getCurrentTimeMillis(), z);
    }

    public void logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, long j, boolean z) {
        logEvent(str, jSONObject, jSONObject2, j, z, null);
    }

    public void logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, long j, boolean z, MiddlewareExtra middlewareExtra) {
        if (validateLogEvent(str)) {
            logEventAsync(str, jSONObject, null, null, jSONObject2, null, j, z, middlewareExtra);
        }
    }

    public void logEventSync(String str) {
        logEventSync(str, null);
    }

    public void logEventSync(String str, JSONObject jSONObject) {
        logEventSync(str, jSONObject, false);
    }

    public void logEventSync(String str, JSONObject jSONObject, boolean z) {
        logEventSync(str, jSONObject, null, z);
    }

    public void logEventSync(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        logEventSync(str, jSONObject, jSONObject2, false);
    }

    public void logEventSync(String str, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        logEventSync(str, jSONObject, jSONObject2, getCurrentTimeMillis(), z);
    }

    public void logEventSync(String str, JSONObject jSONObject, JSONObject jSONObject2, long j, boolean z) {
        if (validateLogEvent(str)) {
            logEvent(str, jSONObject, null, null, jSONObject2, null, j, z, this.inForeground);
        }
    }

    protected boolean validateLogEvent(String str) {
        if (Utils.isEmptyString(str)) {
            logger.e(TAG, "Argument eventType cannot be null or blank in logEvent()");
            return false;
        }
        return contextAndApiKeySet("logEvent()");
    }

    protected void logEventAsync(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j, boolean z) {
        logEventAsync(str, jSONObject, jSONObject2, jSONObject3, jSONObject4, jSONObject5, j, z, null);
    }

    protected void logEventAsync(final String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, final long j, final boolean z, final MiddlewareExtra middlewareExtra) {
        final JSONObject cloneJSONObject = jSONObject != null ? Utils.cloneJSONObject(jSONObject) : jSONObject;
        final JSONObject cloneJSONObject2 = jSONObject2 != null ? Utils.cloneJSONObject(jSONObject2) : jSONObject2;
        final JSONObject cloneJSONObject3 = jSONObject3 != null ? Utils.cloneJSONObject(jSONObject3) : jSONObject3;
        final JSONObject cloneJSONObject4 = jSONObject4 != null ? Utils.cloneJSONObject(jSONObject4) : jSONObject4;
        final JSONObject cloneJSONObject5 = jSONObject5 != null ? Utils.cloneJSONObject(jSONObject5) : jSONObject5;
        final boolean z2 = this.inForeground;
        runOnLogThread(new Runnable() { // from class: com.amplitude.api.AmplitudeClient.4
            @Override // java.lang.Runnable
            public void run() {
                if (Utils.isEmptyString(AmplitudeClient.this.apiKey)) {
                    return;
                }
                AmplitudeClient.this.logEvent(str, cloneJSONObject, cloneJSONObject2, cloneJSONObject3, cloneJSONObject4, cloneJSONObject5, j, z, middlewareExtra, z2);
            }
        });
    }

    protected long logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j, boolean z, boolean z2) {
        return logEvent(str, jSONObject, jSONObject2, jSONObject3, jSONObject4, jSONObject5, j, z, null, z2);
    }

    protected long logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j, boolean z, MiddlewareExtra middlewareExtra, boolean z2) {
        long j2;
        JSONObject truncate;
        JSONObject truncate2;
        JSONObject truncate3;
        Location mostRecentLocation;
        logger.d(TAG, "Logged event to Amplitude: " + str);
        if (this.optOut) {
            return -1L;
        }
        if (!(this.trackingSessionEvents && (str.equals(START_SESSION_EVENT) || str.equals(END_SESSION_EVENT))) && !z) {
            if (!z2 || this.isEnteringForeground) {
                this.isEnteringForeground = false;
                startNewSessionIfNeeded(j);
            } else {
                refreshSessionTime(j);
            }
        }
        JSONObject jSONObject6 = new JSONObject();
        try {
            jSONObject6.put("event_type", replaceWithJSONNull(str));
            jSONObject6.put("timestamp", j);
            jSONObject6.put(USER_ID_KEY, replaceWithJSONNull(this.userId));
            jSONObject6.put(DEVICE_ID_KEY, replaceWithJSONNull(this.deviceId));
            jSONObject6.put("session_id", z ? -1L : this.sessionId);
            jSONObject6.put("uuid", UUID.randomUUID().toString());
            jSONObject6.put(SEQUENCE_NUMBER_KEY, getNextSequenceNumber());
            if (this.appliedTrackingOptions.shouldTrackVersionName()) {
                try {
                    jSONObject6.put(Constants.AMP_TRACKING_OPTION_VERSION_NAME, replaceWithJSONNull(this.deviceInfo.getVersionName()));
                } catch (JSONException e) {
                    e = e;
                    j2 = -1;
                    logger.e(TAG, String.format("JSON Serialization of event type %s failed, skipping: %s", str, e.toString()));
                    return j2;
                }
            }
            if (this.appliedTrackingOptions.shouldTrackOsName()) {
                jSONObject6.put(Constants.AMP_TRACKING_OPTION_OS_NAME, replaceWithJSONNull(this.deviceInfo.getOsName()));
            }
            if (this.appliedTrackingOptions.shouldTrackOsVersion()) {
                jSONObject6.put(Constants.AMP_TRACKING_OPTION_OS_VERSION, replaceWithJSONNull(this.deviceInfo.getOsVersion()));
            }
            if (this.appliedTrackingOptions.shouldTrackApiLevel()) {
                jSONObject6.put(Constants.AMP_TRACKING_OPTION_API_LEVEL, replaceWithJSONNull(Integer.valueOf(Build.VERSION.SDK_INT)));
            }
            if (this.appliedTrackingOptions.shouldTrackDeviceBrand()) {
                jSONObject6.put(Constants.AMP_TRACKING_OPTION_DEVICE_BRAND, replaceWithJSONNull(this.deviceInfo.getBrand()));
            }
            if (this.appliedTrackingOptions.shouldTrackDeviceManufacturer()) {
                jSONObject6.put(Constants.AMP_TRACKING_OPTION_DEVICE_MANUFACTURER, replaceWithJSONNull(this.deviceInfo.getManufacturer()));
            }
            if (this.appliedTrackingOptions.shouldTrackDeviceModel()) {
                jSONObject6.put(Constants.AMP_TRACKING_OPTION_DEVICE_MODEL, replaceWithJSONNull(this.deviceInfo.getModel()));
            }
            if (this.appliedTrackingOptions.shouldTrackCarrier()) {
                jSONObject6.put(Constants.AMP_TRACKING_OPTION_CARRIER, replaceWithJSONNull(this.deviceInfo.getCarrier()));
            }
            if (this.appliedTrackingOptions.shouldTrackCountry()) {
                jSONObject6.put(Constants.AMP_TRACKING_OPTION_COUNTRY, replaceWithJSONNull(this.deviceInfo.getCountry()));
            }
            if (this.appliedTrackingOptions.shouldTrackLanguage()) {
                jSONObject6.put(Constants.AMP_TRACKING_OPTION_LANGUAGE, replaceWithJSONNull(this.deviceInfo.getLanguage()));
            }
            if (this.appliedTrackingOptions.shouldTrackPlatform()) {
                jSONObject6.put(Constants.AMP_TRACKING_OPTION_PLATFORM, this.platform);
            }
            JSONObject jSONObject7 = new JSONObject();
            String str2 = this.libraryName;
            if (str2 == null) {
                str2 = Constants.LIBRARY_UNKNOWN;
            }
            jSONObject7.put("name", str2);
            String str3 = this.libraryVersion;
            if (str3 == null) {
                str3 = Constants.VERSION_UNKNOWN;
            }
            jSONObject7.put(Constants.AMP_PLAN_VERSION, str3);
            jSONObject6.put("library", jSONObject7);
            Plan plan = this.plan;
            if (plan != null) {
                jSONObject6.put("plan", plan.toJSONObject());
            }
            IngestionMetadata ingestionMetadata = this.ingestionMetadata;
            if (ingestionMetadata != null) {
                jSONObject6.put("ingestion_metadata", ingestionMetadata.toJSONObject());
            }
            JSONObject jSONObject8 = jSONObject2 == null ? new JSONObject() : jSONObject2;
            JSONObject jSONObject9 = this.apiPropertiesTrackingOptions;
            if (jSONObject9 != null && jSONObject9.length() > 0) {
                jSONObject8.put("tracking_options", this.apiPropertiesTrackingOptions);
            }
            if (this.appliedTrackingOptions.shouldTrackLatLng() && (mostRecentLocation = this.deviceInfo.getMostRecentLocation()) != null) {
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("lat", mostRecentLocation.getLatitude());
                jSONObject10.put("lng", mostRecentLocation.getLongitude());
                jSONObject8.put("location", jSONObject10);
            }
            if (this.appliedTrackingOptions.shouldTrackAdid() && this.deviceInfo.getAdvertisingId() != null) {
                jSONObject8.put("androidADID", this.deviceInfo.getAdvertisingId());
            }
            if (this.appliedTrackingOptions.shouldTrackAppSetId() && this.deviceInfo.getAppSetId() != null) {
                jSONObject8.put("android_app_set_id", this.deviceInfo.getAppSetId());
            }
            jSONObject8.put("limit_ad_tracking", this.deviceInfo.isLimitAdTrackingEnabled());
            jSONObject8.put("gps_enabled", this.deviceInfo.isGooglePlayServicesEnabled());
            jSONObject6.put("api_properties", jSONObject8);
            if (jSONObject == null) {
                truncate = new JSONObject();
            } else {
                truncate = truncate(jSONObject);
            }
            jSONObject6.put("event_properties", truncate);
            if (jSONObject3 == null) {
                truncate2 = new JSONObject();
            } else {
                truncate2 = truncate(jSONObject3);
            }
            jSONObject6.put("user_properties", truncate2);
            jSONObject6.put("groups", jSONObject4 == null ? new JSONObject() : truncate(jSONObject4));
            if (jSONObject5 == null) {
                truncate3 = new JSONObject();
            } else {
                truncate3 = truncate(jSONObject5);
            }
            jSONObject6.put("group_properties", truncate3);
            long saveEvent = saveEvent(str, jSONObject6, middlewareExtra);
            try {
                if (!str.equals(Constants.IDENTIFY_EVENT) || jSONObject3 == null) {
                    return saveEvent;
                }
                this.connector.getIdentityStore().editIdentity().updateUserProperties(JSONUtil.toUpdateUserPropertiesMap(jSONObject3)).commit();
                return saveEvent;
            } catch (JSONException e2) {
                e = e2;
                j2 = saveEvent;
                logger.e(TAG, String.format("JSON Serialization of event type %s failed, skipping: %s", str, e.toString()));
                return j2;
            }
        } catch (JSONException e3) {
            e = e3;
            j2 = -1;
        }
    }

    protected long saveEvent(String str, JSONObject jSONObject, MiddlewareExtra middlewareExtra) {
        if (!this.middlewareRunner.run(new MiddlewarePayload(jSONObject, middlewareExtra))) {
            return -1L;
        }
        if (Utils.isEmptyString(jSONObject.toString())) {
            logger.e(TAG, String.format("Detected empty event string for event type %s, skipping", str));
            return -1L;
        }
        JSONObject intercept = this.identifyInterceptor.intercept(str, jSONObject);
        if (intercept == null) {
            return -1L;
        }
        return saveEvent(str, intercept);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long saveEvent(String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        if (str.equals(Constants.IDENTIFY_EVENT) || str.equals(Constants.GROUP_IDENTIFY_EVENT)) {
            long addIdentify = this.dbHelper.addIdentify(jSONObject2);
            this.lastIdentifyId = addIdentify;
            setLastIdentifyId(addIdentify);
        } else {
            long addEvent = this.dbHelper.addEvent(jSONObject2);
            this.lastEventId = addEvent;
            setLastEventId(addEvent);
        }
        int min = Math.min(Math.max(1, this.eventMaxCount / 10), 20);
        if (this.dbHelper.getEventCount() > this.eventMaxCount) {
            DatabaseHelper databaseHelper = this.dbHelper;
            databaseHelper.removeEvents(databaseHelper.getNthEventId(min));
        }
        if (this.dbHelper.getIdentifyCount() > this.eventMaxCount) {
            DatabaseHelper databaseHelper2 = this.dbHelper;
            databaseHelper2.removeIdentifys(databaseHelper2.getNthIdentifyId(min));
        }
        long totalEventCount = this.dbHelper.getTotalEventCount();
        int i = this.eventUploadThreshold;
        if (totalEventCount % i == 0 && totalEventCount >= i) {
            updateServer();
        } else {
            updateServerLater(this.eventUploadPeriodMillis);
        }
        return (str.equals(Constants.IDENTIFY_EVENT) || str.equals(Constants.GROUP_IDENTIFY_EVENT)) ? this.lastIdentifyId : this.lastEventId;
    }

    private long getLongvalue(String str, long j) {
        Long longValue = this.dbHelper.getLongValue(str);
        return longValue == null ? j : longValue.longValue();
    }

    long getNextSequenceNumber() {
        long j = this.sequenceNumber + 1;
        this.sequenceNumber = j;
        this.dbHelper.insertOrReplaceKeyLongValue(SEQUENCE_NUMBER_KEY, Long.valueOf(j));
        return this.sequenceNumber;
    }

    void setLastEventTime(long j) {
        this.lastEventTime = j;
        this.dbHelper.insertOrReplaceKeyLongValue(LAST_EVENT_TIME_KEY, Long.valueOf(j));
    }

    void setLastEventId(long j) {
        this.lastEventId = j;
        this.dbHelper.insertOrReplaceKeyLongValue(LAST_EVENT_ID_KEY, Long.valueOf(j));
    }

    void setLastIdentifyId(long j) {
        this.lastIdentifyId = j;
        this.dbHelper.insertOrReplaceKeyLongValue(LAST_IDENTIFY_ID_KEY, Long.valueOf(j));
    }

    public long getSessionId() {
        return this.sessionId;
    }

    void setPreviousSessionId(long j) {
        this.previousSessionId = j;
        this.dbHelper.insertOrReplaceKeyLongValue(PREVIOUS_SESSION_ID_KEY, Long.valueOf(j));
    }

    public boolean startNewSessionIfNeeded(long j) {
        if (inSession()) {
            if (isWithinMinTimeBetweenSessions(j)) {
                refreshSessionTime(j);
                return false;
            }
            startNewSession(j);
            return true;
        }
        if (isWithinMinTimeBetweenSessions(j)) {
            long j2 = this.previousSessionId;
            if (j2 == -1) {
                startNewSession(j);
                return true;
            }
            setSessionId(j2);
            refreshSessionTime(j);
            return false;
        }
        startNewSession(j);
        return true;
    }

    private void startNewSession(long j) {
        if (this.trackingSessionEvents) {
            sendSessionEvent(END_SESSION_EVENT);
        }
        setSessionId(j);
        refreshSessionTime(j);
        if (this.trackingSessionEvents) {
            sendSessionEvent(START_SESSION_EVENT);
        }
    }

    private boolean inSession() {
        return this.sessionId >= 0;
    }

    private boolean isWithinMinTimeBetweenSessions(long j) {
        return j - this.lastEventTime < (this.usingForegroundTracking ? this.minTimeBetweenSessionsMillis : this.sessionTimeoutMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(long j) {
        this.sessionId = j;
        setPreviousSessionId(j);
    }

    void refreshSessionTime(long j) {
        if (inSession()) {
            setLastEventTime(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSessionEvent(String str) {
        if (contextAndApiKeySet(String.format("sendSessionEvent('%s')", str)) && inSession()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("special", str);
                logEvent(str, null, jSONObject, null, null, null, this.lastEventTime, false, false);
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onExitForeground(final long j) {
        this.isEnteringForeground = false;
        this.inForeground = false;
        runOnLogThread(new Runnable() { // from class: com.amplitude.api.AmplitudeClient.5
            @Override // java.lang.Runnable
            public void run() {
                if (Utils.isEmptyString(AmplitudeClient.this.apiKey)) {
                    return;
                }
                AmplitudeClient.this.refreshSessionTime(j);
                if (AmplitudeClient.this.flushEventsOnClose) {
                    AmplitudeClient.this.identifyInterceptor.transferInterceptedIdentify();
                    AmplitudeClient.this.updateServer();
                }
                AmplitudeClient.this.dbHelper.insertOrReplaceKeyValue(AmplitudeClient.DEVICE_ID_KEY, AmplitudeClient.this.deviceId);
                AmplitudeClient.this.dbHelper.insertOrReplaceKeyValue(AmplitudeClient.USER_ID_KEY, AmplitudeClient.this.userId);
                AmplitudeClient.this.dbHelper.insertOrReplaceKeyLongValue(AmplitudeClient.OPT_OUT_KEY, Long.valueOf(AmplitudeClient.this.optOut ? 1L : 0L));
                AmplitudeClient.this.dbHelper.insertOrReplaceKeyLongValue(AmplitudeClient.PREVIOUS_SESSION_ID_KEY, Long.valueOf(AmplitudeClient.this.sessionId));
                AmplitudeClient.this.dbHelper.insertOrReplaceKeyLongValue(AmplitudeClient.LAST_EVENT_TIME_KEY, Long.valueOf(AmplitudeClient.this.lastEventTime));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onEnterForeground(final long j) {
        this.isEnteringForeground = true;
        this.inForeground = true;
        runOnLogThread(new Runnable() { // from class: com.amplitude.api.AmplitudeClient.6
            @Override // java.lang.Runnable
            public void run() {
                if (Utils.isEmptyString(AmplitudeClient.this.apiKey)) {
                    return;
                }
                if (AmplitudeClient.this.useDynamicConfig) {
                    ConfigManager.getInstance().refresh(new ConfigManager.RefreshListener() { // from class: com.amplitude.api.AmplitudeClient.6.1
                        @Override // com.amplitude.api.ConfigManager.RefreshListener
                        public void onFinished() {
                            AmplitudeClient.this.url = ConfigManager.getInstance().getIngestionEndpoint();
                        }
                    }, AmplitudeClient.this.serverZone);
                }
                if (AmplitudeClient.this.isEnteringForeground) {
                    AmplitudeClient.this.startNewSessionIfNeeded(j);
                }
                AmplitudeClient.this.isEnteringForeground = false;
            }
        });
    }

    public void logRevenue(double d) {
        logRevenue(null, 1, d);
    }

    public void logRevenue(String str, int i, double d) {
        logRevenue(str, i, d, null, null);
    }

    public void logRevenue(String str, int i, double d, String str2, String str3) {
        logRevenue(str, i, d, str2, str3, null);
    }

    public void logRevenue(String str, int i, double d, String str2, String str3, MiddlewareExtra middlewareExtra) {
        if (contextAndApiKeySet("logRevenue()")) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("special", Constants.AMP_REVENUE_EVENT);
                jSONObject.put("productId", str);
                jSONObject.put("quantity", i);
                jSONObject.put(b.x, d);
                jSONObject.put(b.D, str2);
                jSONObject.put("receiptSig", str3);
            } catch (JSONException unused) {
            }
            logEventAsync(Constants.AMP_REVENUE_EVENT, null, jSONObject, null, null, null, getCurrentTimeMillis(), false, middlewareExtra);
        }
    }

    public void logRevenueV2(Revenue revenue) {
        logRevenueV2(revenue, null);
    }

    public void logRevenueV2(Revenue revenue, MiddlewareExtra middlewareExtra) {
        if (contextAndApiKeySet("logRevenueV2()") && revenue != null && revenue.isValidRevenue()) {
            logEvent(Constants.AMP_REVENUE_EVENT, revenue.toJSONObject(), null, null, null, null, getCurrentTimeMillis(), false, middlewareExtra, this.inForeground);
        }
    }

    public void setUserProperties(JSONObject jSONObject, boolean z) {
        setUserProperties(jSONObject);
    }

    public void setUserProperties(JSONObject jSONObject) {
        setUserProperties(jSONObject, (MiddlewareExtra) null);
    }

    public void setUserProperties(JSONObject jSONObject, MiddlewareExtra middlewareExtra) {
        Identify convertPropertiesToIdentify;
        if (jSONObject == null || jSONObject.length() == 0 || !contextAndApiKeySet("setUserProperties") || (convertPropertiesToIdentify = convertPropertiesToIdentify(jSONObject)) == null) {
            return;
        }
        identify(convertPropertiesToIdentify, false, middlewareExtra);
    }

    private Identify convertPropertiesToIdentify(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject truncate = truncate(jSONObject);
        if (truncate.length() == 0) {
            return null;
        }
        Identify identify = new Identify();
        Iterator<String> keys = truncate.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                identify.setUserProperty(next, truncate.get(next));
            } catch (JSONException e) {
                logger.e(TAG, e.toString());
            }
        }
        return identify;
    }

    public void clearUserProperties() {
        identify(new Identify().clearAll());
    }

    public void identify(Identify identify) {
        identify(identify, false);
    }

    public void identify(Identify identify, boolean z) {
        identify(identify, z, null);
    }

    public void identify(Identify identify, boolean z, MiddlewareExtra middlewareExtra) {
        if (identify == null || identify.userPropertiesOperations.length() == 0 || !contextAndApiKeySet("identify()")) {
            return;
        }
        logEventAsync(Constants.IDENTIFY_EVENT, null, null, identify.userPropertiesOperations, null, null, getCurrentTimeMillis(), z, middlewareExtra);
    }

    public void setGroup(String str, Object obj) {
        setGroup(str, obj, null);
    }

    public void setGroup(String str, Object obj, MiddlewareExtra middlewareExtra) {
        JSONObject jSONObject;
        if (!contextAndApiKeySet("setGroup()") || Utils.isEmptyString(str)) {
            return;
        }
        try {
            jSONObject = new JSONObject().put(str, obj);
        } catch (JSONException e) {
            logger.e(TAG, e.toString());
            jSONObject = null;
        }
        logEventAsync(Constants.IDENTIFY_EVENT, null, null, new Identify().setUserProperty(str, obj).userPropertiesOperations, jSONObject, null, getCurrentTimeMillis(), false, middlewareExtra);
    }

    public void groupIdentify(String str, Object obj, Identify identify) {
        groupIdentify(str, obj, identify, false);
    }

    public void groupIdentify(String str, Object obj, Identify identify, boolean z) {
        groupIdentify(str, obj, identify, z, (MiddlewareExtra) null);
    }

    public void groupIdentify(String str, Object obj, JSONObject jSONObject, boolean z, MiddlewareExtra middlewareExtra) {
        Identify convertPropertiesToIdentify = convertPropertiesToIdentify(jSONObject);
        if (convertPropertiesToIdentify != null) {
            groupIdentify(str, obj, convertPropertiesToIdentify, z, middlewareExtra);
        }
    }

    public void groupIdentify(String str, Object obj, Identify identify, boolean z, MiddlewareExtra middlewareExtra) {
        JSONObject jSONObject;
        if (identify == null || identify.userPropertiesOperations.length() == 0) {
            return;
        }
        if (!contextAndApiKeySet("groupIdentify()") || Utils.isEmptyString(str)) {
            return;
        }
        try {
            jSONObject = new JSONObject().put(str, obj);
        } catch (JSONException e) {
            logger.e(TAG, e.toString());
            jSONObject = null;
        }
        logEventAsync(Constants.GROUP_IDENTIFY_EVENT, null, null, null, jSONObject, identify.userPropertiesOperations, getCurrentTimeMillis(), z, middlewareExtra);
    }

    public JSONObject truncate(JSONObject jSONObject) {
        Object obj;
        if (jSONObject == null) {
            return new JSONObject();
        }
        if (jSONObject.length() > 1000) {
            logger.w(TAG, "Warning: too many properties (more than 1000), ignoring");
            return new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                obj = jSONObject.get(next);
            } catch (JSONException e) {
                logger.e(TAG, e.toString());
            }
            if (!next.equals(Constants.AMP_REVENUE_RECEIPT) && !next.equals(Constants.AMP_REVENUE_RECEIPT_SIG)) {
                if (obj.getClass().equals(String.class)) {
                    jSONObject.put(next, truncate((String) obj));
                } else if (obj.getClass().equals(JSONObject.class)) {
                    jSONObject.put(next, truncate((JSONObject) obj));
                } else if (obj.getClass().equals(JSONArray.class)) {
                    jSONObject.put(next, truncate((JSONArray) obj));
                }
            }
            jSONObject.put(next, obj);
        }
        return jSONObject;
    }

    public JSONArray truncate(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return new JSONArray();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj.getClass().equals(String.class)) {
                jSONArray.put(i, truncate((String) obj));
            } else if (obj.getClass().equals(JSONObject.class)) {
                jSONArray.put(i, truncate((JSONObject) obj));
            } else if (obj.getClass().equals(JSONArray.class)) {
                jSONArray.put(i, truncate((JSONArray) obj));
            }
        }
        return jSONArray;
    }

    public static String truncate(String str) {
        return str.length() <= 1024 ? str : str.substring(0, 1024);
    }

    public String getUserId() {
        return this.userId;
    }

    public AmplitudeClient setUserId(String str) {
        return setUserId(str, false);
    }

    public AmplitudeClient setUserId(final String str, final boolean z) {
        if (!contextAndApiKeySet("setUserId()")) {
            return this;
        }
        runOnLogThread(new Runnable() { // from class: com.amplitude.api.AmplitudeClient.7
            @Override // java.lang.Runnable
            public void run() {
                if (Utils.isEmptyString(this.apiKey)) {
                    return;
                }
                if (z && AmplitudeClient.this.trackingSessionEvents) {
                    AmplitudeClient.this.sendSessionEvent(AmplitudeClient.END_SESSION_EVENT);
                }
                this.userId = str;
                AmplitudeClient.this.dbHelper.insertOrReplaceKeyValue(AmplitudeClient.USER_ID_KEY, str);
                if (z) {
                    long currentTimeMillis = AmplitudeClient.this.getCurrentTimeMillis();
                    AmplitudeClient.this.setSessionId(currentTimeMillis);
                    AmplitudeClient.this.refreshSessionTime(currentTimeMillis);
                    if (AmplitudeClient.this.trackingSessionEvents) {
                        AmplitudeClient.this.sendSessionEvent(AmplitudeClient.START_SESSION_EVENT);
                    }
                }
                this.connector.getIdentityStore().editIdentity().setUserId(str).commit();
            }
        });
        return this;
    }

    public AmplitudeClient setDeviceId(final String str) {
        Set<String> invalidDeviceIds = getInvalidDeviceIds();
        if (contextAndApiKeySet("setDeviceId()") && !Utils.isEmptyString(str) && !invalidDeviceIds.contains(str)) {
            runOnLogThread(new Runnable() { // from class: com.amplitude.api.AmplitudeClient.8
                @Override // java.lang.Runnable
                public void run() {
                    if (Utils.isEmptyString(this.apiKey)) {
                        return;
                    }
                    this.deviceId = str;
                    AmplitudeClient.this.saveDeviceId(str);
                    this.connector.getIdentityStore().editIdentity().setDeviceId(str).commit();
                }
            });
        }
        return this;
    }

    public AmplitudeClient regenerateDeviceId() {
        if (!contextAndApiKeySet("regenerateDeviceId()")) {
            return this;
        }
        runOnLogThread(new Runnable() { // from class: com.amplitude.api.AmplitudeClient.9
            @Override // java.lang.Runnable
            public void run() {
                if (Utils.isEmptyString(this.apiKey)) {
                    return;
                }
                AmplitudeClient.this.setDeviceId(DeviceInfo.generateUUID() + "R");
            }
        });
        return this;
    }

    public void uploadEvents() {
        if (contextAndApiKeySet("uploadEvents()")) {
            this.logThread.post(new Runnable() { // from class: com.amplitude.api.AmplitudeClient.10
                @Override // java.lang.Runnable
                public void run() {
                    if (Utils.isEmptyString(AmplitudeClient.this.apiKey)) {
                        return;
                    }
                    AmplitudeClient.this.identifyInterceptor.transferInterceptedIdentify();
                    AmplitudeClient.this.updateServer();
                }
            });
        }
    }

    private void updateServerLater(long j) {
        if (this.updateScheduled.getAndSet(true)) {
            return;
        }
        this.logThread.postDelayed(new Runnable() { // from class: com.amplitude.api.AmplitudeClient.11
            @Override // java.lang.Runnable
            public void run() {
                AmplitudeClient.this.updateScheduled.set(false);
                AmplitudeClient.this.updateServer();
            }
        }, j);
    }

    protected void updateServer() {
        updateServer(false);
    }

    protected void updateServer(boolean z) {
        if (this.optOut || this.offline || this.uploadingCurrently.getAndSet(true)) {
            return;
        }
        long min = Math.min(z ? this.backoffUploadBatchSize : this.eventUploadMaxBatchSize, this.dbHelper.getTotalEventCount());
        if (min <= 0) {
            this.uploadingCurrently.set(false);
            return;
        }
        try {
            Pair<Pair<Long, Long>, JSONArray> mergeEventsAndIdentifys = mergeEventsAndIdentifys(this.dbHelper.getEvents(this.lastEventId, min), this.dbHelper.getIdentifys(this.lastIdentifyId, min), min);
            if (((JSONArray) mergeEventsAndIdentifys.second).length() == 0) {
                this.uploadingCurrently.set(false);
                return;
            }
            final long longValue = ((Long) ((Pair) mergeEventsAndIdentifys.first).first).longValue();
            final long longValue2 = ((Long) ((Pair) mergeEventsAndIdentifys.first).second).longValue();
            final String jSONArray = ((JSONArray) mergeEventsAndIdentifys.second).toString();
            this.httpThread.post(new Runnable() { // from class: com.amplitude.api.AmplitudeClient.12
                @Override // java.lang.Runnable
                public void run() {
                    AmplitudeClient amplitudeClient = AmplitudeClient.this;
                    amplitudeClient.makeEventUploadPostRequest(amplitudeClient.callFactory, jSONArray, longValue, longValue2);
                }
            });
        } catch (CursorWindowAllocationException e) {
            this.uploadingCurrently.set(false);
            logger.e(TAG, String.format("Caught Cursor window exception during event upload, deferring upload: %s", e.getMessage()));
        } catch (JSONException e2) {
            this.uploadingCurrently.set(false);
            logger.e(TAG, e2.toString());
        }
    }

    protected Pair<Pair<Long, Long>, JSONArray> mergeEventsAndIdentifys(List<JSONObject> list, List<JSONObject> list2, long j) throws JSONException {
        long j2;
        long j3;
        JSONArray jSONArray = new JSONArray();
        long j4 = -1;
        long j5 = -1;
        while (true) {
            if (jSONArray.length() >= j) {
                break;
            }
            boolean isEmpty = list.isEmpty();
            boolean isEmpty2 = list2.isEmpty();
            if (isEmpty && isEmpty2) {
                logger.w(TAG, String.format("mergeEventsAndIdentifys: number of events and identifys less than expected by %d", Long.valueOf(j - jSONArray.length())));
                break;
            }
            if (isEmpty2) {
                JSONObject remove = list.remove(0);
                j2 = remove.getLong("event_id");
                jSONArray.put(remove);
            } else {
                if (isEmpty) {
                    JSONObject remove2 = list2.remove(0);
                    j3 = remove2.getLong("event_id");
                    jSONArray.put(remove2);
                } else if (!list.get(0).has(SEQUENCE_NUMBER_KEY) || list.get(0).getLong(SEQUENCE_NUMBER_KEY) < list2.get(0).getLong(SEQUENCE_NUMBER_KEY)) {
                    JSONObject remove3 = list.remove(0);
                    j2 = remove3.getLong("event_id");
                    jSONArray.put(remove3);
                } else {
                    JSONObject remove4 = list2.remove(0);
                    j3 = remove4.getLong("event_id");
                    jSONArray.put(remove4);
                }
                j5 = j3;
            }
            j4 = j2;
        }
        return new Pair<>(new Pair(Long.valueOf(j4), Long.valueOf(j5)), jSONArray);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void makeEventUploadPostRequest(okhttp3.Call.Factory r14, java.lang.String r15, final long r16, final long r18) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.AmplitudeClient.makeEventUploadPostRequest(okhttp3.Call$Factory, java.lang.String, long, long):void");
    }

    protected DeviceInfo initializeDeviceInfo() {
        return new DeviceInfo(this.context, this.locationListening, this.appliedTrackingOptions.shouldTrackAdid());
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    private Set<String> getInvalidDeviceIds() {
        HashSet hashSet = new HashSet();
        hashSet.add("");
        hashSet.add("9774d56d682e549c");
        hashSet.add(EnvironmentCompat.MEDIA_UNKNOWN);
        hashSet.add("000000000000000");
        hashSet.add(Constants.PLATFORM);
        hashSet.add("DEFACE");
        hashSet.add("00000000-0000-0000-0000-000000000000");
        return hashSet;
    }

    private String initializeDeviceId() {
        Set<String> invalidDeviceIds = getInvalidDeviceIds();
        String value = this.dbHelper.getValue(DEVICE_ID_KEY);
        if (!Utils.isEmptyString(value) && !invalidDeviceIds.contains(value) && !value.endsWith(ExifInterface.LATITUDE_SOUTH)) {
            return value;
        }
        if (!this.newDeviceIdPerInstall && this.useAdvertisingIdForDeviceId && !this.deviceInfo.isLimitAdTrackingEnabled()) {
            String advertisingId = this.deviceInfo.getAdvertisingId();
            if (!Utils.isEmptyString(advertisingId) && !invalidDeviceIds.contains(advertisingId)) {
                saveDeviceId(advertisingId);
                return advertisingId;
            }
        }
        if (this.useAppSetIdForDeviceId) {
            String appSetId = this.deviceInfo.getAppSetId();
            if (!Utils.isEmptyString(appSetId) && !invalidDeviceIds.contains(appSetId)) {
                String str = appSetId + ExifInterface.LATITUDE_SOUTH;
                saveDeviceId(str);
                return str;
            }
        }
        String str2 = DeviceInfo.generateUUID() + "R";
        saveDeviceId(str2);
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveDeviceId(String str) {
        this.dbHelper.insertOrReplaceKeyValue(DEVICE_ID_KEY, str);
    }

    public AmplitudeClient setDeviceIdCallback(AmplitudeDeviceIdCallback amplitudeDeviceIdCallback) {
        this.deviceIdCallback = amplitudeDeviceIdCallback;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runOnLogThread(Runnable runnable) {
        Thread currentThread = Thread.currentThread();
        WorkerThread workerThread = this.logThread;
        if (currentThread != workerThread) {
            workerThread.post(runnable);
        } else {
            runnable.run();
        }
    }

    protected Object replaceWithJSONNull(Object obj) {
        return obj == null ? JSONObject.NULL : obj;
    }

    protected synchronized boolean contextAndApiKeySet(String str) {
        if (this.context == null) {
            logger.e(TAG, "context cannot be null, set context with initialize() before calling " + str);
            return false;
        }
        if (!Utils.isEmptyString(this.apiKey)) {
            return true;
        }
        logger.e(TAG, "apiKey cannot be null or empty, set apiKey with initialize() before calling " + str);
        return false;
    }

    protected String bytesToHexString(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr2[i3] = cArr[i2 >>> 4];
            cArr2[i3 + 1] = cArr[i2 & 15];
        }
        return new String(cArr2);
    }

    protected long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public AmplitudeClient setPlan(Plan plan) {
        this.plan = plan;
        return this;
    }

    public AmplitudeClient setIngestionMetadata(IngestionMetadata ingestionMetadata) {
        this.ingestionMetadata = ingestionMetadata;
        return this;
    }

    public AmplitudeClient setServerZone(AmplitudeServerZone amplitudeServerZone) {
        return setServerZone(amplitudeServerZone, true);
    }

    public AmplitudeClient setServerZone(AmplitudeServerZone amplitudeServerZone, boolean z) {
        if (amplitudeServerZone == null) {
            return null;
        }
        this.serverZone = amplitudeServerZone;
        if (z) {
            setServerUrl(AmplitudeServerZone.getEventLogApiForZone(amplitudeServerZone));
        }
        return this;
    }

    public AmplitudeServerZone getServerZone() {
        return this.serverZone;
    }
}
