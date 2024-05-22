package androidx.webkit;

import android.adservices.common.AdData;
import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.CustomAudienceManager;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.MeasurementManager;
import android.adservices.measurement.WebSourceParams;
import android.adservices.measurement.WebSourceRegistrationRequest;
import android.adservices.measurement.WebTriggerParams;
import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.net.Uri;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class WebViewCompat$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ AdData.Builder m() {
        return new AdData.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ CustomAudience.Builder m184m() {
        return new CustomAudience.Builder();
    }

    public static /* bridge */ /* synthetic */ CustomAudienceManager m(Object obj) {
        return (CustomAudienceManager) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ LeaveCustomAudienceRequest.Builder m185m() {
        return new LeaveCustomAudienceRequest.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ TrustedBiddingData.Builder m186m() {
        return new TrustedBiddingData.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ DeletionRequest.Builder m187m() {
        return new DeletionRequest.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ MeasurementManager m188m(Object obj) {
        return (MeasurementManager) obj;
    }

    public static /* synthetic */ WebSourceParams.Builder m(Uri uri) {
        return new WebSourceParams.Builder(uri);
    }

    public static /* synthetic */ WebSourceRegistrationRequest.Builder m(List list, Uri uri) {
        return new WebSourceRegistrationRequest.Builder(list, uri);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ WebTriggerParams.Builder m189m(Uri uri) {
        return new WebTriggerParams.Builder(uri);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ WebTriggerRegistrationRequest.Builder m190m(List list, Uri uri) {
        return new WebTriggerRegistrationRequest.Builder(list, uri);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ GetTopicsRequest.Builder m191m() {
        return new GetTopicsRequest.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ GetTopicsResponse m192m(Object obj) {
        return (GetTopicsResponse) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Topic m193m(Object obj) {
        return (Topic) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ TopicsManager m194m(Object obj) {
        return (TopicsManager) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m200m() {
        return MeasurementManager.class;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m202m() {
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return TopicsManager.class;
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m205m$1() {
    }

    public static /* synthetic */ void m$2() {
    }

    public static /* synthetic */ void m$3() {
    }
}
