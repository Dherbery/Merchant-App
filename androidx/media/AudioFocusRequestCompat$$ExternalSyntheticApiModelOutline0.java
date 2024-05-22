package androidx.media;

import android.adservices.adid.AdId;
import android.adservices.adid.AdIdManager;
import android.adservices.adselection.AdSelectionConfig;
import android.adservices.adselection.AdSelectionManager;
import android.adservices.adselection.AdSelectionOutcome;
import android.adservices.adselection.ReportImpressionRequest;
import android.adservices.appsetid.AppSetId;
import android.adservices.appsetid.AppSetIdManager;
import android.adservices.customaudience.CustomAudienceManager;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.media.AudioFocusRequest;
import android.media.session.MediaSessionManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import android.view.inputmethod.InputContentInfo;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class AudioFocusRequestCompat$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ AdId m(Object obj) {
        return (AdId) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AdIdManager m144m(Object obj) {
        return (AdIdManager) obj;
    }

    public static /* synthetic */ AdSelectionConfig.Builder m() {
        return new AdSelectionConfig.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AdSelectionManager m145m(Object obj) {
        return (AdSelectionManager) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AdSelectionOutcome m146m(Object obj) {
        return (AdSelectionOutcome) obj;
    }

    public static /* synthetic */ ReportImpressionRequest m(long j, AdSelectionConfig adSelectionConfig) {
        return new ReportImpressionRequest(j, adSelectionConfig);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AppSetId m147m(Object obj) {
        return (AppSetId) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AppSetIdManager m148m(Object obj) {
        return (AppSetIdManager) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ JoinCustomAudienceRequest.Builder m150m() {
        return new JoinCustomAudienceRequest.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AudioFocusRequest m151m(Object obj) {
        return (AudioFocusRequest) obj;
    }

    public static /* synthetic */ MediaSessionManager.RemoteUserInfo m(String str, int i, int i2) {
        return new MediaSessionManager.RemoteUserInfo(str, i, i2);
    }

    public static /* synthetic */ AccessibilityNodeInfo.TouchDelegateInfo m(Map map) {
        return new AccessibilityNodeInfo.TouchDelegateInfo(map);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AutofillId m155m(Object obj) {
        return (AutofillId) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ContentCaptureSession m156m(Object obj) {
        return (ContentCaptureSession) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ InputContentInfo m157m(Object obj) {
        return (InputContentInfo) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m159m() {
        return AdIdManager.class;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m162m() {
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m165m$1() {
        return AdSelectionManager.class;
    }

    /* renamed from: m$2, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m167m$2() {
        return AppSetIdManager.class;
    }

    /* renamed from: m$3, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m168m$3() {
        return CustomAudienceManager.class;
    }
}
