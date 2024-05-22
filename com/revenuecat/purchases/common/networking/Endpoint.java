package com.revenuecat.purchases.common.networking;

import android.net.Uri;
import com.amazon.a.a.o.b;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Endpoint.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\t\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018B\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0003H&R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R\u0011\u0010\r\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\u0082\u0001\t\u0019\u001a\u001b\u001c\u001d\u001e\u001f !¨\u0006\""}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint;", "", "pathTemplate", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "needsNonceToPerformSigning", "", "getNeedsNonceToPerformSigning", "()Z", "getPathTemplate", "supportsSignatureVerification", "getSupportsSignatureVerification", "getPath", "GetAmazonReceipt", "GetCustomerInfo", "GetOfferings", "GetProductEntitlementMapping", "LogIn", "PostAttributes", "PostDiagnostics", "PostPaywallEvents", "PostReceipt", "Lcom/revenuecat/purchases/common/networking/Endpoint$GetAmazonReceipt;", "Lcom/revenuecat/purchases/common/networking/Endpoint$GetCustomerInfo;", "Lcom/revenuecat/purchases/common/networking/Endpoint$GetOfferings;", "Lcom/revenuecat/purchases/common/networking/Endpoint$GetProductEntitlementMapping;", "Lcom/revenuecat/purchases/common/networking/Endpoint$LogIn;", "Lcom/revenuecat/purchases/common/networking/Endpoint$PostAttributes;", "Lcom/revenuecat/purchases/common/networking/Endpoint$PostDiagnostics;", "Lcom/revenuecat/purchases/common/networking/Endpoint$PostPaywallEvents;", "Lcom/revenuecat/purchases/common/networking/Endpoint$PostReceipt;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public abstract class Endpoint {
    private final String name;
    private final String pathTemplate;

    public /* synthetic */ Endpoint(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public abstract String getPath();

    private Endpoint(String str, String str2) {
        this.pathTemplate = str;
        this.name = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPathTemplate() {
        return this.pathTemplate;
    }

    /* compiled from: Endpoint.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\b\u0010\r\u001a\u00020\u0003H\u0016J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$GetCustomerInfo;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "userId", "", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "getPath", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class GetCustomerInfo extends Endpoint {
        private final String userId;

        public static /* synthetic */ GetCustomerInfo copy$default(GetCustomerInfo getCustomerInfo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = getCustomerInfo.userId;
            }
            return getCustomerInfo.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        public final GetCustomerInfo copy(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new GetCustomerInfo(userId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GetCustomerInfo) && Intrinsics.areEqual(this.userId, ((GetCustomerInfo) other).userId);
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "GetCustomerInfo(userId=" + this.userId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCustomerInfo(String userId) {
            super("/subscribers/%s", "get_customer", null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
        }

        public final String getUserId() {
            return this.userId;
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            String format = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            return format;
        }
    }

    /* compiled from: Endpoint.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$PostReceipt;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "()V", "getPath", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PostReceipt extends Endpoint {
        public static final PostReceipt INSTANCE = new PostReceipt();

        private PostReceipt() {
            super("/receipts", "post_receipt", null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            return getPathTemplate();
        }
    }

    /* compiled from: Endpoint.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\b\u0010\r\u001a\u00020\u0003H\u0016J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$GetOfferings;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "userId", "", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "getPath", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class GetOfferings extends Endpoint {
        private final String userId;

        public static /* synthetic */ GetOfferings copy$default(GetOfferings getOfferings, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = getOfferings.userId;
            }
            return getOfferings.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        public final GetOfferings copy(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new GetOfferings(userId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GetOfferings) && Intrinsics.areEqual(this.userId, ((GetOfferings) other).userId);
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "GetOfferings(userId=" + this.userId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetOfferings(String userId) {
            super("/subscribers/%s/offerings", "get_offerings", null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
        }

        public final String getUserId() {
            return this.userId;
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            String format = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            return format;
        }
    }

    /* compiled from: Endpoint.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$LogIn;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "()V", "getPath", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class LogIn extends Endpoint {
        public static final LogIn INSTANCE = new LogIn();

        private LogIn() {
            super("/subscribers/identify", "log_in", null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            return getPathTemplate();
        }
    }

    /* compiled from: Endpoint.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$PostDiagnostics;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "()V", "getPath", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PostDiagnostics extends Endpoint {
        public static final PostDiagnostics INSTANCE = new PostDiagnostics();

        private PostDiagnostics() {
            super("/diagnostics", "post_diagnostics", null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            return getPathTemplate();
        }
    }

    /* compiled from: Endpoint.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$PostPaywallEvents;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "()V", "getPath", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PostPaywallEvents extends Endpoint {
        public static final PostPaywallEvents INSTANCE = new PostPaywallEvents();

        private PostPaywallEvents() {
            super("/events", "post_paywall_events", null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            return getPathTemplate();
        }
    }

    /* compiled from: Endpoint.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\b\u0010\r\u001a\u00020\u0003H\u0016J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$PostAttributes;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "userId", "", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "getPath", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class PostAttributes extends Endpoint {
        private final String userId;

        public static /* synthetic */ PostAttributes copy$default(PostAttributes postAttributes, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = postAttributes.userId;
            }
            return postAttributes.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        public final PostAttributes copy(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new PostAttributes(userId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PostAttributes) && Intrinsics.areEqual(this.userId, ((PostAttributes) other).userId);
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "PostAttributes(userId=" + this.userId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostAttributes(String userId) {
            super("/subscribers/%s/attributes", "post_attributes", null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
        }

        public final String getUserId() {
            return this.userId;
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            String format = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            return format;
        }
    }

    /* compiled from: Endpoint.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$GetAmazonReceipt;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "userId", "", b.E, "(Ljava/lang/String;Ljava/lang/String;)V", "getReceiptId", "()Ljava/lang/String;", "getUserId", "component1", "component2", "copy", "equals", "", "other", "", "getPath", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class GetAmazonReceipt extends Endpoint {
        private final String receiptId;
        private final String userId;

        public static /* synthetic */ GetAmazonReceipt copy$default(GetAmazonReceipt getAmazonReceipt, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = getAmazonReceipt.userId;
            }
            if ((i & 2) != 0) {
                str2 = getAmazonReceipt.receiptId;
            }
            return getAmazonReceipt.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getReceiptId() {
            return this.receiptId;
        }

        public final GetAmazonReceipt copy(String userId, String receiptId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(receiptId, "receiptId");
            return new GetAmazonReceipt(userId, receiptId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetAmazonReceipt)) {
                return false;
            }
            GetAmazonReceipt getAmazonReceipt = (GetAmazonReceipt) other;
            return Intrinsics.areEqual(this.userId, getAmazonReceipt.userId) && Intrinsics.areEqual(this.receiptId, getAmazonReceipt.receiptId);
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + this.receiptId.hashCode();
        }

        public String toString() {
            return "GetAmazonReceipt(userId=" + this.userId + ", receiptId=" + this.receiptId + ')';
        }

        public final String getUserId() {
            return this.userId;
        }

        public final String getReceiptId() {
            return this.receiptId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetAmazonReceipt(String userId, String receiptId) {
            super("/receipts/amazon/%s/%s", "get_amazon_receipt", null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(receiptId, "receiptId");
            this.userId = userId;
            this.receiptId = receiptId;
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            String format = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId), this.receiptId}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            return format;
        }
    }

    /* compiled from: Endpoint.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$GetProductEntitlementMapping;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "()V", "getPath", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class GetProductEntitlementMapping extends Endpoint {
        public static final GetProductEntitlementMapping INSTANCE = new GetProductEntitlementMapping();

        private GetProductEntitlementMapping() {
            super("/product_entitlement_mapping", "get_product_entitlement_mapping", null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            return getPathTemplate();
        }
    }

    public final boolean getSupportsSignatureVerification() {
        if (this instanceof GetCustomerInfo ? true : Intrinsics.areEqual(this, LogIn.INSTANCE) ? true : Intrinsics.areEqual(this, PostReceipt.INSTANCE) ? true : this instanceof GetOfferings ? true : Intrinsics.areEqual(this, GetProductEntitlementMapping.INSTANCE)) {
            return true;
        }
        if (this instanceof GetAmazonReceipt ? true : this instanceof PostAttributes ? true : Intrinsics.areEqual(this, PostDiagnostics.INSTANCE) ? true : Intrinsics.areEqual(this, PostPaywallEvents.INSTANCE)) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getNeedsNonceToPerformSigning() {
        if (this instanceof GetCustomerInfo ? true : Intrinsics.areEqual(this, LogIn.INSTANCE) ? true : Intrinsics.areEqual(this, PostReceipt.INSTANCE)) {
            return true;
        }
        if (this instanceof GetAmazonReceipt ? true : this instanceof GetOfferings ? true : this instanceof PostAttributes ? true : Intrinsics.areEqual(this, PostDiagnostics.INSTANCE) ? true : Intrinsics.areEqual(this, PostPaywallEvents.INSTANCE) ? true : Intrinsics.areEqual(this, GetProductEntitlementMapping.INSTANCE)) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }
}
