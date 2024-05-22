package expo.modules.sms;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMSOptions.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lexpo/modules/sms/SMSOptions;", "Lexpo/modules/kotlin/records/Record;", "attachments", "", "Lexpo/modules/sms/SMSAttachment;", "(Ljava/util/List;)V", "getAttachments$annotations", "()V", "getAttachments", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-sms_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SMSOptions implements Record {
    private final List<SMSAttachment> attachments;

    public SMSOptions() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SMSOptions copy$default(SMSOptions sMSOptions, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = sMSOptions.attachments;
        }
        return sMSOptions.copy(list);
    }

    @Field
    public static /* synthetic */ void getAttachments$annotations() {
    }

    public final List<SMSAttachment> component1() {
        return this.attachments;
    }

    public final SMSOptions copy(List<SMSAttachment> attachments) {
        Intrinsics.checkNotNullParameter(attachments, "attachments");
        return new SMSOptions(attachments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SMSOptions) && Intrinsics.areEqual(this.attachments, ((SMSOptions) other).attachments);
    }

    public int hashCode() {
        return this.attachments.hashCode();
    }

    public String toString() {
        return "SMSOptions(attachments=" + this.attachments + ")";
    }

    public SMSOptions(List<SMSAttachment> attachments) {
        Intrinsics.checkNotNullParameter(attachments, "attachments");
        this.attachments = attachments;
    }

    public /* synthetic */ SMSOptions(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<SMSAttachment> getAttachments() {
        return this.attachments;
    }
}
