package com.onesignal.inAppMessages.internal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.JSONUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.modeling.IModelStore;
import com.onesignal.common.modeling.ISingletonModelStoreChangeHandler;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.BuildConfig;
import com.onesignal.inAppMessages.IInAppMessageClickListener;
import com.onesignal.inAppMessages.IInAppMessageLifecycleListener;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.onesignal.inAppMessages.InAppMessageActionUrlType;
import com.onesignal.inAppMessages.R;
import com.onesignal.inAppMessages.internal.backend.IInAppBackendService;
import com.onesignal.inAppMessages.internal.common.InAppHelper;
import com.onesignal.inAppMessages.internal.common.OneSignalChromeTab;
import com.onesignal.inAppMessages.internal.display.IInAppDisplayer;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController;
import com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt;
import com.onesignal.inAppMessages.internal.repositories.IInAppRepository;
import com.onesignal.inAppMessages.internal.state.InAppStateService;
import com.onesignal.inAppMessages.internal.triggers.ITriggerController;
import com.onesignal.inAppMessages.internal.triggers.ITriggerHandler;
import com.onesignal.inAppMessages.internal.triggers.TriggerModel;
import com.onesignal.inAppMessages.internal.triggers.TriggerModelStore;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.IUserManager;
import com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.onesignal.user.subscriptions.ISubscription;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: InAppMessagesManager.kt */
@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u00062\u00020\u00072\u00020\b2\u00020\tB\u008d\u0001\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010(\u001a\u00020)\u0012\u0006\u0010*\u001a\u00020+¢\u0006\u0002\u0010,J\u0010\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020;H\u0016J\u0010\u0010O\u001a\u00020M2\u0006\u0010N\u001a\u000209H\u0016J\u0018\u0010P\u001a\u00020M2\u0006\u0010Q\u001a\u00020/2\u0006\u0010D\u001a\u00020/H\u0016J\u001c\u0010R\u001a\u00020M2\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0TH\u0016J\u0011\u0010U\u001a\u00020MH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010VJ'\u0010W\u001a\u00020M2\u0006\u0010X\u001a\u00020>2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0AH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010[J\b\u0010\\\u001a\u00020MH\u0016J\u0011\u0010]\u001a\u00020MH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010VJ\u0011\u0010^\u001a\u00020MH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010VJ\u0010\u0010_\u001a\u00020M2\u0006\u0010`\u001a\u00020aH\u0002J'\u0010b\u001a\u00020M2\u0006\u0010c\u001a\u00020/2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020e0AH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010fJ!\u0010g\u001a\u00020M2\u0006\u0010X\u001a\u00020>2\u0006\u0010`\u001a\u00020aH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010hJ!\u0010i\u001a\u00020M2\u0006\u0010X\u001a\u00020>2\u0006\u0010`\u001a\u00020aH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010hJ!\u0010j\u001a\u00020M2\u0006\u0010X\u001a\u00020>2\u0006\u0010k\u001a\u00020lH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010mJ\u0010\u0010n\u001a\u00020M2\u0006\u0010`\u001a\u00020aH\u0002J\u0010\u0010o\u001a\u00020C2\u0006\u0010X\u001a\u00020>H\u0002J\u0010\u0010p\u001a\u00020M2\u0006\u0010`\u001a\u00020aH\u0002J\u0016\u0010q\u001a\u00020M2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020/0sH\u0002J#\u0010t\u001a\u00020M2\u0006\u0010X\u001a\u00020>2\b\b\u0002\u0010u\u001a\u00020CH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010vJ\b\u0010w\u001a\u00020MH\u0016J\u0018\u0010x\u001a\u00020M2\u0006\u0010X\u001a\u00020>2\u0006\u0010`\u001a\u00020aH\u0016J\u0018\u0010y\u001a\u00020M2\u0006\u0010X\u001a\u00020>2\u0006\u0010`\u001a\u00020aH\u0016J\u0018\u0010z\u001a\u00020M2\u0006\u0010X\u001a\u00020>2\u0006\u0010k\u001a\u00020lH\u0016J\u0010\u0010{\u001a\u00020M2\u0006\u0010X\u001a\u00020>H\u0016J\u0010\u0010|\u001a\u00020M2\u0006\u0010X\u001a\u00020>H\u0016J\u0010\u0010}\u001a\u00020M2\u0006\u0010X\u001a\u00020>H\u0016J\u0010\u0010~\u001a\u00020M2\u0006\u0010X\u001a\u00020>H\u0016J\u001a\u0010\u007f\u001a\u00020M2\u0007\u0010\u0080\u0001\u001a\u00020\u00052\u0007\u0010\u0081\u0001\u001a\u00020/H\u0016J\u001c\u0010\u0082\u0001\u001a\u00020M2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0081\u0001\u001a\u00020/H\u0016J\t\u0010\u0085\u0001\u001a\u00020MH\u0016J\u0012\u0010\u0086\u0001\u001a\u00020M2\u0007\u0010\u0087\u0001\u001a\u000205H\u0016J\t\u0010\u0088\u0001\u001a\u00020MH\u0016J\u0013\u0010\u0089\u0001\u001a\u00020M2\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0016J\u001d\u0010\u008c\u0001\u001a\u00020M2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\u0013\u0010\u008d\u0001\u001a\u00020M2\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0016J\u0012\u0010\u008e\u0001\u001a\u00020M2\u0007\u0010\u008f\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0090\u0001\u001a\u00020M2\u0007\u0010\u0091\u0001\u001a\u00020/H\u0016J\t\u0010\u0092\u0001\u001a\u00020MH\u0016J\t\u0010\u0093\u0001\u001a\u00020MH\u0016J\u001b\u0010\u0094\u0001\u001a\u00020M2\u0006\u0010X\u001a\u00020>H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u0095\u0001J\u001b\u0010\u0096\u0001\u001a\u00020M2\u0006\u0010X\u001a\u00020>H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u0095\u0001J\u0011\u0010\u0097\u0001\u001a\u00020M2\u0006\u0010N\u001a\u00020;H\u0016J\u0011\u0010\u0098\u0001\u001a\u00020M2\u0006\u0010N\u001a\u000209H\u0016J\u0011\u0010\u0099\u0001\u001a\u00020M2\u0006\u0010Q\u001a\u00020/H\u0016J\u0018\u0010\u009a\u0001\u001a\u00020M2\r\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020/0sH\u0016J\u0011\u0010\u009c\u0001\u001a\u00020M2\u0006\u0010X\u001a\u00020>H\u0002J \u0010\u009d\u0001\u001a\u00020M2\u0007\u0010\u009e\u0001\u001a\u00020>2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0AH\u0002J)\u0010\u009f\u0001\u001a\u00020M2\u0007\u0010\u009e\u0001\u001a\u00020>2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0AH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010[J\t\u0010 \u0001\u001a\u00020MH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0004\n\u0002\u00106R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020908X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020;08X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020>0AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010E\u001a\u00020C2\u0006\u0010D\u001a\u00020C8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020>0=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006¡\u0001"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessagesManager;", "Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionChangedHandler;", "Lcom/onesignal/common/modeling/ISingletonModelStoreChangeHandler;", "Lcom/onesignal/core/internal/config/ConfigModel;", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleEventHandler;", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerHandler;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_sessionService", "Lcom/onesignal/session/internal/session/ISessionService;", "_influenceManager", "Lcom/onesignal/session/internal/influence/IInfluenceManager;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_userManager", "Lcom/onesignal/user/IUserManager;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "_outcomeEventsController", "Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;", "_state", "Lcom/onesignal/inAppMessages/internal/state/InAppStateService;", "_prefs", "Lcom/onesignal/inAppMessages/internal/preferences/IInAppPreferencesController;", "_repository", "Lcom/onesignal/inAppMessages/internal/repositories/IInAppRepository;", "_backend", "Lcom/onesignal/inAppMessages/internal/backend/IInAppBackendService;", "_triggerController", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerController;", "_triggerModelStore", "Lcom/onesignal/inAppMessages/internal/triggers/TriggerModelStore;", "_displayer", "Lcom/onesignal/inAppMessages/internal/display/IInAppDisplayer;", "_lifecycle", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;", "_languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/session/internal/influence/IInfluenceManager;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/IUserManager;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;Lcom/onesignal/inAppMessages/internal/state/InAppStateService;Lcom/onesignal/inAppMessages/internal/preferences/IInAppPreferencesController;Lcom/onesignal/inAppMessages/internal/repositories/IInAppRepository;Lcom/onesignal/inAppMessages/internal/backend/IInAppBackendService;Lcom/onesignal/inAppMessages/internal/triggers/ITriggerController;Lcom/onesignal/inAppMessages/internal/triggers/TriggerModelStore;Lcom/onesignal/inAppMessages/internal/display/IInAppDisplayer;Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;Lcom/onesignal/core/internal/language/ILanguageContext;Lcom/onesignal/core/internal/time/ITime;)V", "clickedClickIds", "", "", "dismissedMessages", "fetchIAMMutex", "Lkotlinx/coroutines/sync/Mutex;", "impressionedMessages", "lastTimeFetchedIAMs", "", "Ljava/lang/Long;", "lifecycleCallback", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/inAppMessages/IInAppMessageLifecycleListener;", "messageClickCallback", "Lcom/onesignal/inAppMessages/IInAppMessageClickListener;", "messageDisplayQueue", "", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "messageDisplayQueueMutex", "messages", "", "onFocusCalled", "", "value", "paused", "getPaused", "()Z", "setPaused", "(Z)V", "redisplayedInAppMessages", "viewedPageIds", "addClickListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addLifecycleListener", "addTrigger", SubscriberAttributeKt.JSON_NAME_KEY, "addTriggers", "triggers", "", "attemptToShowInAppMessage", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "beginProcessingPrompts", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "prompts", "Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt;", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearTriggers", "evaluateInAppMessages", "fetchMessages", "fireClickAction", "action", "Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;", "fireOutcomesForClick", "messageId", "outcomes", "Lcom/onesignal/inAppMessages/internal/InAppMessageOutcome;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firePublicClickHandler", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fireRESTCallForClick", "fireRESTCallForPageChange", "page", "Lcom/onesignal/inAppMessages/internal/InAppMessagePage;", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lcom/onesignal/inAppMessages/internal/InAppMessagePage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fireTagCallForClick", "hasMessageTriggerChanged", "logInAppMessagePreviewActions", "makeRedisplayMessagesAvailableWithTriggers", "newTriggersKeys", "", "messageWasDismissed", "failed", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFocus", "onMessageActionOccurredOnMessage", "onMessageActionOccurredOnPreview", "onMessagePageChanged", "onMessageWasDismissed", "onMessageWasDisplayed", "onMessageWillDismiss", "onMessageWillDisplay", "onModelReplaced", "model", "tag", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "onSessionActive", "onSessionEnded", "duration", "onSessionStarted", "onSubscriptionAdded", "subscription", "Lcom/onesignal/user/subscriptions/ISubscription;", "onSubscriptionChanged", "onSubscriptionRemoved", "onTriggerChanged", "newTriggerKey", "onTriggerCompleted", "triggerId", "onTriggerConditionChanged", "onUnfocused", "persistInAppMessage", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queueMessageForDisplay", "removeClickListener", "removeLifecycleListener", "removeTrigger", "removeTriggers", "keys", "setDataForRedisplay", "showAlertDialogMessage", "inAppMessage", "showMultiplePrompts", "start", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppMessagesManager implements IInAppMessagesManager, IStartableService, ISubscriptionChangedHandler, ISingletonModelStoreChangeHandler<ConfigModel>, IInAppLifecycleEventHandler, ITriggerHandler, ISessionLifecycleHandler, IApplicationLifecycleHandler {
    private final IApplicationService _applicationService;
    private final IInAppBackendService _backend;
    private final ConfigModelStore _configModelStore;
    private final IInAppDisplayer _displayer;
    private final IInfluenceManager _influenceManager;
    private final ILanguageContext _languageContext;
    private final IInAppLifecycleService _lifecycle;
    private final IOutcomeEventsController _outcomeEventsController;
    private final IInAppPreferencesController _prefs;
    private final IInAppRepository _repository;
    private final ISessionService _sessionService;
    private final InAppStateService _state;
    private final ISubscriptionManager _subscriptionManager;
    private final ITime _time;
    private final ITriggerController _triggerController;
    private final TriggerModelStore _triggerModelStore;
    private final IUserManager _userManager;
    private final Set<String> clickedClickIds;
    private final Set<String> dismissedMessages;
    private final Mutex fetchIAMMutex;
    private final Set<String> impressionedMessages;
    private Long lastTimeFetchedIAMs;
    private final EventProducer<IInAppMessageLifecycleListener> lifecycleCallback;
    private final EventProducer<IInAppMessageClickListener> messageClickCallback;
    private final List<InAppMessage> messageDisplayQueue;
    private final Mutex messageDisplayQueueMutex;
    private List<InAppMessage> messages;
    private boolean onFocusCalled;
    private final List<InAppMessage> redisplayedInAppMessages;
    private final Set<String> viewedPageIds;

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionActive() {
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionEnded(long duration) {
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler
    public void onSubscriptionAdded(ISubscription subscription) {
        Intrinsics.checkNotNullParameter(subscription, "subscription");
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler
    public void onSubscriptionRemoved(ISubscription subscription) {
        Intrinsics.checkNotNullParameter(subscription, "subscription");
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
    }

    public InAppMessagesManager(IApplicationService _applicationService, ISessionService _sessionService, IInfluenceManager _influenceManager, ConfigModelStore _configModelStore, IUserManager _userManager, ISubscriptionManager _subscriptionManager, IOutcomeEventsController _outcomeEventsController, InAppStateService _state, IInAppPreferencesController _prefs, IInAppRepository _repository, IInAppBackendService _backend, ITriggerController _triggerController, TriggerModelStore _triggerModelStore, IInAppDisplayer _displayer, IInAppLifecycleService _lifecycle, ILanguageContext _languageContext, ITime _time) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_sessionService, "_sessionService");
        Intrinsics.checkNotNullParameter(_influenceManager, "_influenceManager");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_userManager, "_userManager");
        Intrinsics.checkNotNullParameter(_subscriptionManager, "_subscriptionManager");
        Intrinsics.checkNotNullParameter(_outcomeEventsController, "_outcomeEventsController");
        Intrinsics.checkNotNullParameter(_state, "_state");
        Intrinsics.checkNotNullParameter(_prefs, "_prefs");
        Intrinsics.checkNotNullParameter(_repository, "_repository");
        Intrinsics.checkNotNullParameter(_backend, "_backend");
        Intrinsics.checkNotNullParameter(_triggerController, "_triggerController");
        Intrinsics.checkNotNullParameter(_triggerModelStore, "_triggerModelStore");
        Intrinsics.checkNotNullParameter(_displayer, "_displayer");
        Intrinsics.checkNotNullParameter(_lifecycle, "_lifecycle");
        Intrinsics.checkNotNullParameter(_languageContext, "_languageContext");
        Intrinsics.checkNotNullParameter(_time, "_time");
        this._applicationService = _applicationService;
        this._sessionService = _sessionService;
        this._influenceManager = _influenceManager;
        this._configModelStore = _configModelStore;
        this._userManager = _userManager;
        this._subscriptionManager = _subscriptionManager;
        this._outcomeEventsController = _outcomeEventsController;
        this._state = _state;
        this._prefs = _prefs;
        this._repository = _repository;
        this._backend = _backend;
        this._triggerController = _triggerController;
        this._triggerModelStore = _triggerModelStore;
        this._displayer = _displayer;
        this._lifecycle = _lifecycle;
        this._languageContext = _languageContext;
        this._time = _time;
        this.lifecycleCallback = new EventProducer<>();
        this.messageClickCallback = new EventProducer<>();
        this.messages = CollectionsKt.emptyList();
        this.dismissedMessages = new LinkedHashSet();
        this.impressionedMessages = new LinkedHashSet();
        this.viewedPageIds = new LinkedHashSet();
        this.clickedClickIds = new LinkedHashSet();
        this.messageDisplayQueue = new ArrayList();
        this.messageDisplayQueueMutex = MutexKt.Mutex$default(false, 1, null);
        this.redisplayedInAppMessages = new ArrayList();
        this.fetchIAMMutex = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    public boolean getPaused() {
        return this._state.getPaused();
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    public void setPaused(boolean z) {
        Logging.debug$default("InAppMessagesManager.setPaused(value: " + z + ')', null, 2, null);
        this._state.setPaused(z);
        if (z) {
            return;
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$paused$1(this, null), 1, null);
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        Set<String> dismissedMessagesId = this._prefs.getDismissedMessagesId();
        if (dismissedMessagesId != null) {
            this.dismissedMessages.addAll(dismissedMessagesId);
        }
        Long lastTimeInAppDismissed = this._prefs.getLastTimeInAppDismissed();
        if (lastTimeInAppDismissed != null) {
            this._state.setLastTimeInAppDismissed(lastTimeInAppDismissed);
        }
        this._subscriptionManager.subscribe(this);
        this._configModelStore.subscribe((ISingletonModelStoreChangeHandler) this);
        this._lifecycle.subscribe(this);
        this._triggerController.subscribe(this);
        this._sessionService.subscribe(this);
        this._applicationService.addApplicationLifecycleHandler(this);
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$start$1(this, null), 1, null);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* renamed from: addLifecycleListener */
    public void mo1015addLifecycleListener(IInAppMessageLifecycleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logging.debug$default("InAppMessagesManager.addLifecycleListener(listener: " + listener + ')', null, 2, null);
        this.lifecycleCallback.subscribe(listener);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* renamed from: removeLifecycleListener */
    public void mo1020removeLifecycleListener(IInAppMessageLifecycleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logging.debug$default("InAppMessagesManager.removeLifecycleListener(listener: " + listener + ')', null, 2, null);
        this.lifecycleCallback.unsubscribe(listener);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* renamed from: addClickListener */
    public void mo1014addClickListener(IInAppMessageClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logging.debug$default("InAppMessagesManager.addClickListener(listener: " + listener + ')', null, 2, null);
        this.messageClickCallback.subscribe(listener);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* renamed from: removeClickListener */
    public void mo1019removeClickListener(IInAppMessageClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logging.debug$default("InAppMessagesManager.removeClickListener(listener: " + listener + ')', null, 2, null);
        this.messageClickCallback.unsubscribe(listener);
    }

    @Override // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs args, String tag) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (Intrinsics.areEqual(args.getProperty(), "appId")) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onModelUpdated$2(this, null), 1, null);
        }
    }

    @Override // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelReplaced(ConfigModel model, String tag) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(tag, "tag");
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onModelReplaced$1(this, null), 1, null);
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler
    public void onSubscriptionChanged(ISubscription subscription, ModelChangedArgs args) {
        Intrinsics.checkNotNullParameter(subscription, "subscription");
        Intrinsics.checkNotNullParameter(args, "args");
        if ((subscription instanceof IPushSubscription) && Intrinsics.areEqual(args.getPath(), "id")) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onSubscriptionChanged$2(this, null), 1, null);
        }
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionStarted() {
        Iterator<InAppMessage> it = this.redisplayedInAppMessages.iterator();
        while (it.hasNext()) {
            it.next().setDisplayedInSession(false);
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onSessionStarted$1(this, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6 A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:27:0x00bc, B:29:0x00c6, B:31:0x00df, B:34:0x00e5), top: B:26:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0102 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchMessages(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.fetchMessages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object evaluateInAppMessages(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager$evaluateInAppMessages$1
            if (r0 == 0) goto L14
            r0 = r8
            com.onesignal.inAppMessages.internal.InAppMessagesManager$evaluateInAppMessages$1 r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager$evaluateInAppMessages$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$evaluateInAppMessages$1 r0 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$evaluateInAppMessages$1
            r0.<init>(r7, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r2 = r0.L$1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r4 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4c
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = "InAppMessagesManager.evaluateInAppMessages()"
            r2 = 2
            r4 = 0
            com.onesignal.debug.internal.logging.Logging.debug$default(r8, r4, r2, r4)
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r8 = r7.messages
            java.util.Iterator r8 = r8.iterator()
            r4 = r7
            r2 = r8
        L4c:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L82
            java.lang.Object r8 = r2.next()
            com.onesignal.inAppMessages.internal.InAppMessage r8 = (com.onesignal.inAppMessages.internal.InAppMessage) r8
            com.onesignal.inAppMessages.internal.triggers.ITriggerController r5 = r4._triggerController
            boolean r5 = r5.evaluateMessageTriggers(r8)
            if (r5 == 0) goto L4c
            r4.setDataForRedisplay(r8)
            java.util.Set<java.lang.String> r5 = r4.dismissedMessages
            java.lang.String r6 = r8.getMessageId()
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L4c
            boolean r5 = r8.isFinished()
            if (r5 != 0) goto L4c
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r8 = r4.queueMessageForDisplay(r8, r0)
            if (r8 != r1) goto L4c
            return r1
        L82:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.evaluateInAppMessages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void setDataForRedisplay(InAppMessage message) {
        boolean contains = this.dismissedMessages.contains(message.getMessageId());
        int indexOf = this.redisplayedInAppMessages.indexOf(message);
        if (!contains || indexOf == -1) {
            return;
        }
        InAppMessage inAppMessage = this.redisplayedInAppMessages.get(indexOf);
        message.getRedisplayStats().setDisplayStats(inAppMessage.getRedisplayStats());
        message.setDisplayedInSession(inAppMessage.getDisplayedInSession());
        boolean hasMessageTriggerChanged = hasMessageTriggerChanged(message);
        Logging.debug$default("InAppMessagesManager.setDataForRedisplay: " + message + " triggerHasChanged: " + hasMessageTriggerChanged, null, 2, null);
        if (hasMessageTriggerChanged && message.getRedisplayStats().isDelayTimeSatisfied() && message.getRedisplayStats().shouldDisplayAgain()) {
            Logging.debug$default("InAppMessagesManager.setDataForRedisplay message available for redisplay: " + message.getMessageId(), null, 2, null);
            this.dismissedMessages.remove(message.getMessageId());
            this.impressionedMessages.remove(message.getMessageId());
            this.viewedPageIds.clear();
            this._prefs.setViewPageImpressionedIds(this.viewedPageIds);
            message.clearClickIds();
        }
    }

    private final boolean hasMessageTriggerChanged(InAppMessage message) {
        if (this._triggerController.messageHasOnlyDynamicTriggers(message)) {
            return !message.getDisplayedInSession();
        }
        return message.getTriggerChanged() || (!message.getDisplayedInSession() && message.getTriggers().isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object queueMessageForDisplay(com.onesignal.inAppMessages.internal.InAppMessage r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "InAppMessagesManager.queueMessageForDisplay: In app message with id: "
            boolean r1 = r10 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager$queueMessageForDisplay$1
            if (r1 == 0) goto L16
            r1 = r10
            com.onesignal.inAppMessages.internal.InAppMessagesManager$queueMessageForDisplay$1 r1 = (com.onesignal.inAppMessages.internal.InAppMessagesManager$queueMessageForDisplay$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r10 = r1.label
            int r10 = r10 - r3
            r1.label = r10
            goto L1b
        L16:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$queueMessageForDisplay$1 r1 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$queueMessageForDisplay$1
            r1.<init>(r8, r10)
        L1b:
            java.lang.Object r10 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            r5 = 2
            r6 = 0
            if (r3 == 0) goto L4b
            if (r3 == r4) goto L39
            if (r3 != r5) goto L31
            kotlin.ResultKt.throwOnFailure(r10)
            goto La9
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            java.lang.Object r9 = r1.L$2
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r3 = r1.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r3 = (com.onesignal.inAppMessages.internal.InAppMessage) r3
            java.lang.Object r4 = r1.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r4 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r4
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            r9 = r3
            goto L60
        L4b:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.sync.Mutex r10 = r8.messageDisplayQueueMutex
            r1.L$0 = r8
            r1.L$1 = r9
            r1.L$2 = r10
            r1.label = r4
            java.lang.Object r3 = r10.lock(r6, r1)
            if (r3 != r2) goto L5f
            return r2
        L5f:
            r4 = r8
        L60:
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r3 = r4.messageDisplayQueue     // Catch: java.lang.Throwable -> Lac
            boolean r3 = r3.contains(r9)     // Catch: java.lang.Throwable -> Lac
            if (r3 != 0) goto L95
            com.onesignal.inAppMessages.internal.state.InAppStateService r3 = r4._state     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = r3.getInAppMessageIdShowing()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r7 = r9.getMessageId()     // Catch: java.lang.Throwable -> Lac
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r7)     // Catch: java.lang.Throwable -> Lac
            if (r3 != 0) goto L95
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r3 = r4.messageDisplayQueue     // Catch: java.lang.Throwable -> Lac
            r3.add(r9)     // Catch: java.lang.Throwable -> Lac
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac
            r3.<init>(r0)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r9 = r9.getMessageId()     // Catch: java.lang.Throwable -> Lac
            r3.append(r9)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r9 = ", added to the queue"
            r3.append(r9)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r9 = r3.toString()     // Catch: java.lang.Throwable -> Lac
            com.onesignal.debug.internal.logging.Logging.debug$default(r9, r6, r5, r6)     // Catch: java.lang.Throwable -> Lac
        L95:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lac
            r10.unlock(r6)
            r1.L$0 = r6
            r1.L$1 = r6
            r1.L$2 = r6
            r1.label = r5
            java.lang.Object r9 = r4.attemptToShowInAppMessage(r1)
            if (r9 != r2) goto La9
            return r2
        La9:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        Lac:
            r9 = move-exception
            r10.unlock(r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.queueMessageForDisplay(com.onesignal.inAppMessages.internal.InAppMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00be A[Catch: all -> 0x016a, TryCatch #0 {all -> 0x016a, blocks: (B:37:0x00a7, B:39:0x00be, B:40:0x00fd, B:48:0x00c4, B:50:0x00cc, B:51:0x00d2, B:53:0x00da, B:54:0x00e0), top: B:36:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c4 A[Catch: all -> 0x016a, TryCatch #0 {all -> 0x016a, blocks: (B:37:0x00a7, B:39:0x00be, B:40:0x00fd, B:48:0x00c4, B:50:0x00cc, B:51:0x00d2, B:53:0x00da, B:54:0x00e0), top: B:36:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Type inference failed for: r0v10, types: [T, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object attemptToShowInAppMessage(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.attemptToShowInAppMessage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object messageWasDismissed(final com.onesignal.inAppMessages.internal.InAppMessage r10, boolean r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.messageWasDismissed(com.onesignal.inAppMessages.internal.InAppMessage, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object messageWasDismissed$default(InAppMessagesManager inAppMessagesManager, InAppMessage inAppMessage, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return inAppMessagesManager.messageWasDismissed(inAppMessage, z, continuation);
    }

    private final void makeRedisplayMessagesAvailableWithTriggers(Collection<String> newTriggersKeys) {
        for (InAppMessage inAppMessage : this.messages) {
            if (!inAppMessage.getTriggerChanged() && this.redisplayedInAppMessages.contains(inAppMessage) && this._triggerController.isTriggerOnMessage(inAppMessage, newTriggersKeys)) {
                Logging.debug$default("InAppMessagesManager.makeRedisplayMessagesAvailableWithTriggers: Trigger changed for message: " + inAppMessage, null, 2, null);
                inAppMessage.setTriggerChanged(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object persistInAppMessage(com.onesignal.inAppMessages.internal.InAppMessage r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager$persistInAppMessage$1
            if (r0 == 0) goto L14
            r0 = r10
            com.onesignal.inAppMessages.internal.InAppMessagesManager$persistInAppMessage$1 r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager$persistInAppMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$persistInAppMessage$1 r0 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$persistInAppMessage$1
            r0.<init>(r8, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r9 = r0.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r9 = (com.onesignal.inAppMessages.internal.InAppMessage) r9
            java.lang.Object r0 = r0.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L6c
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            kotlin.ResultKt.throwOnFailure(r10)
            com.onesignal.core.internal.time.ITime r10 = r8._time
            long r4 = r10.getCurrentTimeMillis()
            r10 = 1000(0x3e8, float:1.401E-42)
            long r6 = (long) r10
            long r4 = r4 / r6
            com.onesignal.inAppMessages.internal.InAppMessageRedisplayStats r10 = r9.getRedisplayStats()
            r10.setLastDisplayTime(r4)
            com.onesignal.inAppMessages.internal.InAppMessageRedisplayStats r10 = r9.getRedisplayStats()
            r10.incrementDisplayQuantity()
            r10 = 0
            r9.setTriggerChanged(r10)
            r9.setDisplayedInSession(r3)
            com.onesignal.inAppMessages.internal.repositories.IInAppRepository r10 = r8._repository
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r10 = r10.saveInAppMessage(r9, r0)
            if (r10 != r1) goto L6b
            return r1
        L6b:
            r0 = r8
        L6c:
            com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController r10 = r0._prefs
            com.onesignal.inAppMessages.internal.state.InAppStateService r1 = r0._state
            java.lang.Long r1 = r1.getLastTimeInAppDismissed()
            r10.setLastTimeInAppDismissed(r1)
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r10 = r0.redisplayedInAppMessages
            int r10 = r10.indexOf(r9)
            r1 = -1
            if (r10 == r1) goto L86
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r1 = r0.redisplayedInAppMessages
            r1.set(r10, r9)
            goto L8b
        L86:
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r10 = r0.redisplayedInAppMessages
            r10.add(r9)
        L8b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r1 = "InAppMessagesManager.persistInAppMessage: "
            r10.<init>(r1)
            r10.append(r9)
            java.lang.String r9 = " with msg array data: "
            r10.append(r9)
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r9 = r0.redisplayedInAppMessages
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r10 = 2
            r0 = 0
            com.onesignal.debug.internal.logging.Logging.debug$default(r9, r0, r10, r0)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.persistInAppMessage(com.onesignal.inAppMessages.internal.InAppMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* renamed from: addTriggers */
    public void mo1017addTriggers(Map<String, String> triggers) {
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        Logging.debug$default("InAppMessagesManager.addTriggers(triggers: " + triggers + ')', null, 2, null);
        for (Map.Entry<String, String> entry : triggers.entrySet()) {
            mo1016addTrigger(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* renamed from: addTrigger */
    public void mo1016addTrigger(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Logging.debug$default("InAppMessagesManager.addTrigger(key: " + key + ", value: " + value + ')', null, 2, null);
        TriggerModel triggerModel = (TriggerModel) this._triggerModelStore.get(key);
        if (triggerModel != null) {
            triggerModel.setValue(value);
            return;
        }
        TriggerModel triggerModel2 = new TriggerModel();
        triggerModel2.setId(key);
        triggerModel2.setKey(key);
        triggerModel2.setValue(value);
        IModelStore.DefaultImpls.add$default(this._triggerModelStore, triggerModel2, null, 2, null);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* renamed from: removeTriggers */
    public void mo1022removeTriggers(Collection<String> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Logging.debug$default("InAppMessagesManager.removeTriggers(keys: " + keys + ')', null, 2, null);
        Iterator<T> it = keys.iterator();
        while (it.hasNext()) {
            mo1021removeTrigger((String) it.next());
        }
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* renamed from: removeTrigger */
    public void mo1021removeTrigger(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Logging.debug$default("InAppMessagesManager.removeTrigger(key: " + key + ')', null, 2, null);
        IModelStore.DefaultImpls.remove$default(this._triggerModelStore, key, null, 2, null);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* renamed from: clearTriggers */
    public void mo1018clearTriggers() {
        Logging.debug$default("InAppMessagesManager.clearTriggers()", null, 2, null);
        IModelStore.DefaultImpls.clear$default(this._triggerModelStore, null, 1, null);
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageWillDisplay(final InAppMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (!this.lifecycleCallback.getHasSubscribers()) {
            Logging.verbose$default("InAppMessagesManager.onMessageWillDisplay: inAppMessageLifecycleHandler is null", null, 2, null);
        } else {
            this.lifecycleCallback.fireOnMain(new Function1<IInAppMessageLifecycleListener, Unit>() { // from class: com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageWillDisplay$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IInAppMessageLifecycleListener iInAppMessageLifecycleListener) {
                    invoke2(iInAppMessageLifecycleListener);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IInAppMessageLifecycleListener it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onWillDisplay(new InAppMessageLifecycleEvent(InAppMessage.this));
                }
            });
        }
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageWasDisplayed(final InAppMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.lifecycleCallback.getHasSubscribers()) {
            this.lifecycleCallback.fireOnMain(new Function1<IInAppMessageLifecycleListener, Unit>() { // from class: com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageWasDisplayed$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IInAppMessageLifecycleListener iInAppMessageLifecycleListener) {
                    invoke2(iInAppMessageLifecycleListener);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IInAppMessageLifecycleListener it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onDidDisplay(new InAppMessageLifecycleEvent(InAppMessage.this));
                }
            });
        } else {
            Logging.verbose$default("InAppMessagesManager.onMessageWasDisplayed: inAppMessageLifecycleHandler is null", null, 2, null);
        }
        if (message.getIsPreview() || this.impressionedMessages.contains(message.getMessageId())) {
            return;
        }
        this.impressionedMessages.add(message.getMessageId());
        String variantIdForMessage = InAppHelper.INSTANCE.variantIdForMessage(message, this._languageContext);
        if (variantIdForMessage == null) {
            return;
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onMessageWasDisplayed$2(this, variantIdForMessage, message, null), 1, null);
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageActionOccurredOnPreview(InAppMessage message, InAppMessageClickResult action) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(action, "action");
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onMessageActionOccurredOnPreview$1(action, message, this, null), 1, null);
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageActionOccurredOnMessage(InAppMessage message, InAppMessageClickResult action) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(action, "action");
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onMessageActionOccurredOnMessage$1(action, message, this, null), 1, null);
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessagePageChanged(InAppMessage message, InAppMessagePage page) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(page, "page");
        if (message.getIsPreview()) {
            return;
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onMessagePageChanged$1(this, message, page, null), 1, null);
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageWillDismiss(final InAppMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (!this.lifecycleCallback.getHasSubscribers()) {
            Logging.verbose$default("InAppMessagesManager.onMessageWillDismiss: inAppMessageLifecycleHandler is null", null, 2, null);
        } else {
            this.lifecycleCallback.fireOnMain(new Function1<IInAppMessageLifecycleListener, Unit>() { // from class: com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageWillDismiss$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IInAppMessageLifecycleListener iInAppMessageLifecycleListener) {
                    invoke2(iInAppMessageLifecycleListener);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IInAppMessageLifecycleListener it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onWillDismiss(new InAppMessageLifecycleEvent(InAppMessage.this));
                }
            });
        }
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageWasDismissed(InAppMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onMessageWasDismissed$1(this, message, null), 1, null);
    }

    @Override // com.onesignal.inAppMessages.internal.triggers.ITriggerHandler
    public void onTriggerCompleted(String triggerId) {
        Intrinsics.checkNotNullParameter(triggerId, "triggerId");
        Logging.debug$default("InAppMessagesManager.onTriggerCompleted: called with triggerId: " + triggerId, null, 2, null);
        HashSet hashSet = new HashSet();
        hashSet.add(triggerId);
        makeRedisplayMessagesAvailableWithTriggers(hashSet);
    }

    @Override // com.onesignal.inAppMessages.internal.triggers.ITriggerHandler
    public void onTriggerConditionChanged() {
        Logging.debug$default("InAppMessagesManager.onTriggerConditionChanged()", null, 2, null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onTriggerConditionChanged$1(this, null), 1, null);
    }

    @Override // com.onesignal.inAppMessages.internal.triggers.ITriggerHandler
    public void onTriggerChanged(String newTriggerKey) {
        Intrinsics.checkNotNullParameter(newTriggerKey, "newTriggerKey");
        Logging.debug$default("InAppMessagesManager.onTriggerChanged(newTriggerKey: " + newTriggerKey + ')', null, 2, null);
        makeRedisplayMessagesAvailableWithTriggers(CollectionsKt.listOf(newTriggerKey));
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onTriggerChanged$1(this, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object beginProcessingPrompts(InAppMessage inAppMessage, List<? extends InAppMessagePrompt> list, Continuation<? super Unit> continuation) {
        if (!list.isEmpty()) {
            Logging.debug$default("InAppMessagesManager.beginProcessingPrompts: IAM showing prompts from IAM: " + inAppMessage, null, 2, null);
            this._displayer.dismissCurrentInAppMessage();
            Object showMultiplePrompts = showMultiplePrompts(inAppMessage, list, continuation);
            return showMultiplePrompts == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? showMultiplePrompts : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fireOutcomesForClick(java.lang.String r9, java.util.List<com.onesignal.inAppMessages.internal.InAppMessageOutcome> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager$fireOutcomesForClick$1
            if (r0 == 0) goto L14
            r0 = r11
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fireOutcomesForClick$1 r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager$fireOutcomesForClick$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fireOutcomesForClick$1 r0 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$fireOutcomesForClick$1
            r0.<init>(r8, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L35
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            goto L35
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            java.lang.Object r9 = r0.L$1
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r0.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L4e
        L41:
            kotlin.ResultKt.throwOnFailure(r11)
            com.onesignal.session.internal.influence.IInfluenceManager r11 = r8._influenceManager
            r11.onDirectInfluenceFromIAM(r9)
            java.util.Iterator r9 = r10.iterator()
            r10 = r8
        L4e:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L9e
            java.lang.Object r11 = r9.next()
            com.onesignal.inAppMessages.internal.InAppMessageOutcome r11 = (com.onesignal.inAppMessages.internal.InAppMessageOutcome) r11
            java.lang.String r2 = r11.getName()
            boolean r6 = r11.getIsUnique()
            if (r6 == 0) goto L73
            com.onesignal.session.internal.outcomes.IOutcomeEventsController r11 = r10._outcomeEventsController
            r0.L$0 = r10
            r0.L$1 = r9
            r0.label = r5
            java.lang.Object r11 = r11.sendUniqueOutcomeEvent(r2, r0)
            if (r11 != r1) goto L4e
            return r1
        L73:
            float r6 = r11.getWeight()
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L8f
            com.onesignal.session.internal.outcomes.IOutcomeEventsController r6 = r10._outcomeEventsController
            float r11 = r11.getWeight()
            r0.L$0 = r10
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r11 = r6.sendOutcomeEventWithValue(r2, r11, r0)
            if (r11 != r1) goto L4e
            return r1
        L8f:
            com.onesignal.session.internal.outcomes.IOutcomeEventsController r11 = r10._outcomeEventsController
            r0.L$0 = r10
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r11 = r11.sendOutcomeEvent(r2, r0)
            if (r11 != r1) goto L4e
            return r1
        L9e:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.fireOutcomesForClick(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fireTagCallForClick(InAppMessageClickResult action) {
        if (action.getTags() != null) {
            InAppMessageTag tags = action.getTags();
            if ((tags != null ? tags.getTagsToAdd() : null) != null) {
                JSONUtils jSONUtils = JSONUtils.INSTANCE;
                JSONObject tagsToAdd = tags.getTagsToAdd();
                Intrinsics.checkNotNull(tagsToAdd);
                this._userManager.addTags(jSONUtils.newStringMapFromJSONObject(tagsToAdd));
            }
            if ((tags != null ? tags.getTagsToRemove() : null) != null) {
                JSONUtils jSONUtils2 = JSONUtils.INSTANCE;
                JSONArray tagsToRemove = tags != null ? tags.getTagsToRemove() : null;
                Intrinsics.checkNotNull(tagsToRemove);
                this._userManager.removeTags(jSONUtils2.newStringSetFromJSONArray(tagsToRemove));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00bb -> B:17:0x00c0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object showMultiplePrompts(com.onesignal.inAppMessages.internal.InAppMessage r20, java.util.List<? extends com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt> r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.showMultiplePrompts(com.onesignal.inAppMessages.internal.InAppMessage, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fireClickAction(InAppMessageClickResult action) {
        if (action.getUrl() != null) {
            if (action.getUrl().length() > 0) {
                if (action.getUrlTarget() == InAppMessageActionUrlType.BROWSER) {
                    AndroidUtils.INSTANCE.openURLInBrowser(this._applicationService.getAppContext(), action.getUrl());
                } else if (action.getUrlTarget() == InAppMessageActionUrlType.IN_APP_WEBVIEW) {
                    OneSignalChromeTab.INSTANCE.open$com_onesignal_inAppMessages(action.getUrl(), true, this._applicationService.getAppContext());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logInAppMessagePreviewActions(InAppMessageClickResult action) {
        if (action.getTags() != null) {
            Logging.debug$default("InAppMessagesManager.logInAppMessagePreviewActions: Tags detected inside of the action click payload, ignoring because action came from IAM preview:: " + action.getTags(), null, 2, null);
        }
        if (action.getOutcomes().size() > 0) {
            Logging.debug$default("InAppMessagesManager.logInAppMessagePreviewActions: Outcomes detected inside of the action click payload, ignoring because action came from IAM preview: " + action.getOutcomes(), null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object firePublicClickHandler(InAppMessage inAppMessage, InAppMessageClickResult inAppMessageClickResult, Continuation<? super Unit> continuation) {
        if (!this.messageClickCallback.getHasSubscribers()) {
            return Unit.INSTANCE;
        }
        this._influenceManager.onDirectInfluenceFromIAM(inAppMessage.getMessageId());
        Object suspendingFireOnMain = this.messageClickCallback.suspendingFireOnMain(new InAppMessagesManager$firePublicClickHandler$2(new InAppMessageClickEvent(inAppMessage, inAppMessageClickResult), null), continuation);
        return suspendingFireOnMain == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? suspendingFireOnMain : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fireRESTCallForPageChange(com.onesignal.inAppMessages.internal.InAppMessage r9, com.onesignal.inAppMessages.internal.InAppMessagePage r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForPageChange$1
            if (r0 == 0) goto L14
            r0 = r11
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForPageChange$1 r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForPageChange$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForPageChange$1 r0 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForPageChange$1
            r0.<init>(r8, r11)
        L19:
            r7 = r0
            java.lang.Object r11 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L3c
            if (r1 != r2) goto L34
            java.lang.Object r9 = r7.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r7.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: com.onesignal.common.exceptions.BackendException -> Lc0
            goto Lb6
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            kotlin.ResultKt.throwOnFailure(r11)
            com.onesignal.inAppMessages.internal.common.InAppHelper r11 = com.onesignal.inAppMessages.internal.common.InAppHelper.INSTANCE
            com.onesignal.core.internal.language.ILanguageContext r1 = r8._languageContext
            java.lang.String r4 = r11.variantIdForMessage(r9, r1)
            if (r4 != 0) goto L4c
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L4c:
            java.lang.String r6 = r10.getPageId()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = r9.getMessageId()
            r10.append(r11)
            r10.append(r6)
            java.lang.String r10 = r10.toString()
            java.util.Set<java.lang.String> r11 = r8.viewedPageIds
            boolean r11 = r11.contains(r10)
            if (r11 == 0) goto L81
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "InAppMessagesManager: Already sent page impression for id: "
            r9.<init>(r10)
            r9.append(r6)
            java.lang.String r9 = r9.toString()
            r10 = 2
            r11 = 0
            com.onesignal.debug.internal.logging.Logging.verbose$default(r9, r11, r10, r11)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L81:
            java.util.Set<java.lang.String> r11 = r8.viewedPageIds
            r11.add(r10)
            com.onesignal.inAppMessages.internal.backend.IInAppBackendService r1 = r8._backend     // Catch: com.onesignal.common.exceptions.BackendException -> Lbe
            com.onesignal.core.internal.config.ConfigModelStore r11 = r8._configModelStore     // Catch: com.onesignal.common.exceptions.BackendException -> Lbe
            com.onesignal.common.modeling.Model r11 = r11.getModel()     // Catch: com.onesignal.common.exceptions.BackendException -> Lbe
            com.onesignal.core.internal.config.ConfigModel r11 = (com.onesignal.core.internal.config.ConfigModel) r11     // Catch: com.onesignal.common.exceptions.BackendException -> Lbe
            java.lang.String r11 = r11.getAppId()     // Catch: com.onesignal.common.exceptions.BackendException -> Lbe
            com.onesignal.user.internal.subscriptions.ISubscriptionManager r3 = r8._subscriptionManager     // Catch: com.onesignal.common.exceptions.BackendException -> Lbe
            com.onesignal.user.internal.subscriptions.SubscriptionList r3 = r3.getSubscriptions()     // Catch: com.onesignal.common.exceptions.BackendException -> Lbe
            com.onesignal.user.subscriptions.IPushSubscription r3 = r3.getPush()     // Catch: com.onesignal.common.exceptions.BackendException -> Lbe
            java.lang.String r3 = r3.getId()     // Catch: com.onesignal.common.exceptions.BackendException -> Lbe
            java.lang.String r5 = r9.getMessageId()     // Catch: com.onesignal.common.exceptions.BackendException -> Lbe
            r7.L$0 = r8     // Catch: com.onesignal.common.exceptions.BackendException -> Lbe
            r7.L$1 = r10     // Catch: com.onesignal.common.exceptions.BackendException -> Lbe
            r7.label = r2     // Catch: com.onesignal.common.exceptions.BackendException -> Lbe
            r2 = r11
            java.lang.Object r9 = r1.sendIAMPageImpression(r2, r3, r4, r5, r6, r7)     // Catch: com.onesignal.common.exceptions.BackendException -> Lbe
            if (r9 != r0) goto Lb4
            return r0
        Lb4:
            r9 = r10
            r10 = r8
        Lb6:
            com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController r11 = r10._prefs     // Catch: com.onesignal.common.exceptions.BackendException -> Lc0
            java.util.Set<java.lang.String> r0 = r10.viewedPageIds     // Catch: com.onesignal.common.exceptions.BackendException -> Lc0
            r11.setViewPageImpressionedIds(r0)     // Catch: com.onesignal.common.exceptions.BackendException -> Lc0
            goto Lc5
        Lbe:
            r9 = r10
            r10 = r8
        Lc0:
            java.util.Set<java.lang.String> r10 = r10.viewedPageIds
            r10.remove(r9)
        Lc5:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.fireRESTCallForPageChange(com.onesignal.inAppMessages.internal.InAppMessage, com.onesignal.inAppMessages.internal.InAppMessagePage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|(1:(4:9|10|11|12)(2:26|27))(2:28|(2:30|31)(3:32|(1:52)(1:37)|(4:(1:44)|45|46|(1:48)(1:49))(2:41|42)))|13|14|15|16))|53|6|(0)(0)|13|14|15|16|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d6, code lost:
    
        r11.removeClickId(r10);
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fireRESTCallForClick(com.onesignal.inAppMessages.internal.InAppMessage r10, com.onesignal.inAppMessages.internal.InAppMessageClickResult r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.fireRESTCallForClick(com.onesignal.inAppMessages.internal.InAppMessage, com.onesignal.inAppMessages.internal.InAppMessageClickResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void showAlertDialogMessage(final InAppMessage inAppMessage, final List<? extends InAppMessagePrompt> prompts) {
        String string = this._applicationService.getAppContext().getString(R.string.location_permission_missing_title);
        Intrinsics.checkNotNullExpressionValue(string, "_applicationService.appC…permission_missing_title)");
        String string2 = this._applicationService.getAppContext().getString(R.string.location_permission_missing_message);
        Intrinsics.checkNotNullExpressionValue(string2, "_applicationService.appC…rmission_missing_message)");
        new AlertDialog.Builder(this._applicationService.get_current()).setTitle(string).setMessage(string2).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.onesignal.inAppMessages.internal.InAppMessagesManager$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                InAppMessagesManager.m1013showAlertDialogMessage$lambda5(InAppMessagesManager.this, inAppMessage, prompts, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showAlertDialogMessage$lambda-5, reason: not valid java name */
    public static final void m1013showAlertDialogMessage$lambda5(InAppMessagesManager this$0, InAppMessage inAppMessage, List prompts, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(inAppMessage, "$inAppMessage");
        Intrinsics.checkNotNullParameter(prompts, "$prompts");
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$showAlertDialogMessage$1$1(this$0, inAppMessage, prompts, null), 1, null);
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus() {
        if (this.onFocusCalled) {
            return;
        }
        this.onFocusCalled = true;
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onFocus$1(this, null), 1, null);
    }
}
