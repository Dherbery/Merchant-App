package com.onesignal.core.internal.config.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConfigModelStoreListener.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.core.internal.config.impl.ConfigModelStoreListener$fetchParams$1", f = "ConfigModelStoreListener.kt", i = {0, 0, 1, 1}, l = {70, 120}, m = "invokeSuspend", n = {"androidParamsRetries", "success", "androidParamsRetries", "success"}, s = {"I$0", "I$1", "I$0", "I$1"})
/* loaded from: classes5.dex */
public final class ConfigModelStoreListener$fetchParams$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appId;
    int I$0;
    int I$1;
    int label;
    final /* synthetic */ ConfigModelStoreListener this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigModelStoreListener$fetchParams$1(String str, ConfigModelStoreListener configModelStoreListener, Continuation<? super ConfigModelStoreListener$fetchParams$1> continuation) {
        super(1, continuation);
        this.$appId = str;
        this.this$0 = configModelStoreListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ConfigModelStoreListener$fetchParams$1(this.$appId, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ConfigModelStoreListener$fetchParams$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:5|6|7|(2:9|10)|12|13|(1:15)(1:143)|(1:17)|18|(1:20)(48:21|22|23|(3:25|(1:27)(1:29)|28)|30|(3:32|(1:34)(1:36)|35)|37|(3:39|(1:41)(1:43)|42)|44|(3:46|(1:48)(1:50)|49)|51|(3:53|(1:55)(1:57)|56)|58|(3:60|(1:62)(1:64)|63)|65|(3:67|(1:69)(1:71)|70)|72|(3:74|(1:76)(1:78)|77)|79|(3:81|(1:83)(1:85)|84)|86|(3:88|(1:90)(1:92)|91)|93|(1:95)|96|(1:98)|99|(1:101)|102|(1:104)|105|(1:107)|108|(3:110|(1:112)(1:114)|113)|115|(3:117|(1:119)(1:121)|120)|122|(3:124|(1:126)(1:128)|127)|129|130|7|(0)|12|13|(0)(0)|(0)|18|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x027c, code lost:
    
        com.onesignal.debug.internal.logging.Logging.fatal$default("403 error getting OneSignal params, omitting further retries!", null, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0283, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0284, code lost:
    
        r13 = (r7 * 10000) + com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x028b, code lost:
    
        if (r13 > 90000) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x028d, code lost:
    
        r13 = 90000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x028e, code lost:
    
        com.onesignal.debug.internal.logging.Logging.info$default("Failed to get Android parameters, trying again in " + (r13 / 1000) + " seconds.", null, 2, null);
        r0.I$0 = r7;
        r0.I$1 = r6;
        r0.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02b4, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r13, r0) == r1) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02b6, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x026d, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x026e, code lost:
    
        r11 = r0;
        r0 = r13;
        r13 = r7;
        r7 = r6;
        r6 = r1;
        r1 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01d1 A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01e8 A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01ff A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0216 A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0230 A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x024a A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ef A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0101 A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0113 A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0125 A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0137 A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0149 A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015b A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016d A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x017f A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0191 A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a7 A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ba A[Catch: BackendException -> 0x026b, TryCatch #2 {BackendException -> 0x026b, blocks: (B:23:0x0092, B:25:0x00ef, B:28:0x00f8, B:30:0x00fb, B:32:0x0101, B:35:0x010a, B:37:0x010d, B:39:0x0113, B:42:0x011c, B:44:0x011f, B:46:0x0125, B:49:0x012e, B:51:0x0131, B:53:0x0137, B:56:0x0140, B:58:0x0143, B:60:0x0149, B:63:0x0152, B:65:0x0155, B:67:0x015b, B:70:0x0164, B:72:0x0167, B:74:0x016d, B:77:0x0176, B:79:0x0179, B:81:0x017f, B:84:0x0188, B:86:0x018b, B:88:0x0191, B:91:0x019a, B:93:0x01a1, B:95:0x01a7, B:96:0x01b0, B:98:0x01ba, B:99:0x01c7, B:101:0x01d1, B:102:0x01de, B:104:0x01e8, B:105:0x01f5, B:107:0x01ff, B:108:0x020c, B:110:0x0216, B:113:0x0223, B:115:0x0226, B:117:0x0230, B:120:0x023d, B:122:0x0240, B:124:0x024a, B:127:0x0257, B:129:0x025a), top: B:22:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x02be  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:130:0x0267 -> B:7:0x02bb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:141:0x02b4 -> B:6:0x02b7). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 705
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.config.impl.ConfigModelStoreListener$fetchParams$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
