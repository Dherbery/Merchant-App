package com.mrousavy.camera.utils;

import android.media.CamcorderProfile;
import android.util.Size;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* compiled from: CamcorderProfileUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/mrousavy/camera/utils/CamcorderProfileUtils;", "", "()V", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CamcorderProfileUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: CamcorderProfileUtils.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¨\u0006\u0011"}, d2 = {"Lcom/mrousavy/camera/utils/CamcorderProfileUtils$Companion;", "", "()V", "findClosestCamcorderProfileQuality", "", "cameraId", "", "resolution", "Landroid/util/Size;", "allowLargerSize", "", "getMaximumFps", "size", "(Ljava/lang/String;Landroid/util/Size;)Ljava/lang/Integer;", "getMaximumVideoSize", "getResolutionForCamcorderProfileQuality", "camcorderProfile", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final int getResolutionForCamcorderProfileQuality(int camcorderProfile) {
            switch (camcorderProfile) {
                case 2:
                    return 25344;
                case 3:
                    return 101376;
                case 4:
                    return 345600;
                case 5:
                    return 921600;
                case 6:
                    return 2073600;
                case 7:
                    return 76800;
                case 8:
                    return 8294400;
                case 9:
                    return 307200;
                case 10:
                    return 8847360;
                case 11:
                    return 3686400;
                case 12:
                    return 2211840;
                case 13:
                    return 33177600;
                default:
                    throw new Error("Invalid CamcorderProfile \"" + camcorderProfile + "\"!");
            }
        }

        public final int findClosestCamcorderProfileQuality(String cameraId, Size resolution, boolean allowLargerSize) {
            boolean hasProfile;
            Intrinsics.checkNotNullParameter(cameraId, "cameraId");
            Intrinsics.checkNotNullParameter(resolution, "resolution");
            int width = resolution.getWidth() * resolution.getHeight();
            Integer intOrNull = StringsKt.toIntOrNull(cameraId);
            IntRange intRange = new IntRange(2, 13);
            ArrayList arrayList = new ArrayList();
            for (Integer num : intRange) {
                int intValue = num.intValue();
                if (intOrNull != null) {
                    hasProfile = CamcorderProfile.hasProfile(intOrNull.intValue(), intValue);
                } else {
                    hasProfile = CamcorderProfile.hasProfile(intValue);
                }
                if (hasProfile) {
                    arrayList.add(num);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (!allowLargerSize) {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : arrayList2) {
                    if (CamcorderProfileUtils.INSTANCE.getResolutionForCamcorderProfileQuality(((Number) obj).intValue()) <= width) {
                        arrayList3.add(obj);
                    }
                }
                arrayList2 = arrayList3;
            }
            Iterator it = arrayList2.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it.next();
            if (it.hasNext()) {
                int abs = Math.abs(CamcorderProfileUtils.INSTANCE.getResolutionForCamcorderProfileQuality(((Number) next).intValue()) - width);
                do {
                    Object next2 = it.next();
                    int abs2 = Math.abs(CamcorderProfileUtils.INSTANCE.getResolutionForCamcorderProfileQuality(((Number) next2).intValue()) - width);
                    if (abs > abs2) {
                        next = next2;
                        abs = abs2;
                    }
                } while (it.hasNext());
            }
            return ((Number) next).intValue();
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
        
            r1 = android.media.CamcorderProfile.getAll(r9, 1);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final android.util.Size getMaximumVideoSize(java.lang.String r9) {
            /*
                r8 = this;
                java.lang.String r0 = "cameraId"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                r0 = 0
                int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L8f
                r2 = 31
                r3 = 1
                if (r1 < r2) goto L77
                android.media.EncoderProfiles r1 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m(r9, r3)     // Catch: java.lang.Throwable -> L8f
                if (r1 == 0) goto L77
                java.util.List r1 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m(r1)     // Catch: java.lang.Throwable -> L8f
                java.lang.String r2 = "profiles.videoProfiles"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.lang.Throwable -> L8f
                java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L8f
                java.util.List r1 = kotlin.collections.CollectionsKt.filterNotNull(r1)     // Catch: java.lang.Throwable -> L8f
                java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L8f
                java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L8f
                boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L8f
                if (r2 != 0) goto L30
                r2 = r0
                goto L63
            L30:
                java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L8f
                boolean r4 = r1.hasNext()     // Catch: java.lang.Throwable -> L8f
                if (r4 != 0) goto L3b
                goto L63
            L3b:
                android.media.EncoderProfiles$VideoProfile r4 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m(r2)     // Catch: java.lang.Throwable -> L8f
                int r5 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m$3(r4)     // Catch: java.lang.Throwable -> L8f
                int r4 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m$4(r4)     // Catch: java.lang.Throwable -> L8f
                int r5 = r5 * r4
            L48:
                java.lang.Object r4 = r1.next()     // Catch: java.lang.Throwable -> L8f
                android.media.EncoderProfiles$VideoProfile r6 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m(r4)     // Catch: java.lang.Throwable -> L8f
                int r7 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m$3(r6)     // Catch: java.lang.Throwable -> L8f
                int r6 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m$4(r6)     // Catch: java.lang.Throwable -> L8f
                int r7 = r7 * r6
                if (r5 >= r7) goto L5d
                r2 = r4
                r5 = r7
            L5d:
                boolean r4 = r1.hasNext()     // Catch: java.lang.Throwable -> L8f
                if (r4 != 0) goto L48
            L63:
                android.media.EncoderProfiles$VideoProfile r1 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m(r2)     // Catch: java.lang.Throwable -> L8f
                if (r1 == 0) goto L77
                android.util.Size r9 = new android.util.Size     // Catch: java.lang.Throwable -> L8f
                int r2 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m$3(r1)     // Catch: java.lang.Throwable -> L8f
                int r1 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m$4(r1)     // Catch: java.lang.Throwable -> L8f
                r9.<init>(r2, r1)     // Catch: java.lang.Throwable -> L8f
                return r9
            L77:
                java.lang.Integer r9 = kotlin.text.StringsKt.toIntOrNull(r9)     // Catch: java.lang.Throwable -> L8f
                if (r9 == 0) goto L8f
                int r9 = r9.intValue()     // Catch: java.lang.Throwable -> L8f
                android.media.CamcorderProfile r9 = android.media.CamcorderProfile.get(r9, r3)     // Catch: java.lang.Throwable -> L8f
                android.util.Size r1 = new android.util.Size     // Catch: java.lang.Throwable -> L8f
                int r2 = r9.videoFrameWidth     // Catch: java.lang.Throwable -> L8f
                int r9 = r9.videoFrameHeight     // Catch: java.lang.Throwable -> L8f
                r1.<init>(r2, r9)     // Catch: java.lang.Throwable -> L8f
                return r1
            L8f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.utils.CamcorderProfileUtils.Companion.getMaximumVideoSize(java.lang.String):android.util.Size");
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0016, code lost:
        
            r0 = android.media.CamcorderProfile.getAll(r4, r5);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Integer getMaximumFps(java.lang.String r4, android.util.Size r5) {
            /*
                r3 = this;
                java.lang.String r0 = "cameraId"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "size"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                r0 = 0
                r1 = 0
                int r5 = r3.findClosestCamcorderProfileQuality(r4, r5, r0)     // Catch: java.lang.Throwable -> L81
                int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L81
                r2 = 31
                if (r0 < r2) goto L6c
                android.media.EncoderProfiles r0 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m(r4, r5)     // Catch: java.lang.Throwable -> L81
                if (r0 == 0) goto L6c
                java.util.List r4 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m(r0)     // Catch: java.lang.Throwable -> L81
                java.lang.String r5 = "profiles.videoProfiles"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch: java.lang.Throwable -> L81
                java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Throwable -> L81
                java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L81
                boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L81
                if (r5 == 0) goto L66
                java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> L81
                android.media.EncoderProfiles$VideoProfile r5 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m(r5)     // Catch: java.lang.Throwable -> L81
                int r5 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m$2(r5)     // Catch: java.lang.Throwable -> L81
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L81
                java.lang.Comparable r5 = (java.lang.Comparable) r5     // Catch: java.lang.Throwable -> L81
            L43:
                boolean r0 = r4.hasNext()     // Catch: java.lang.Throwable -> L81
                if (r0 == 0) goto L63
                java.lang.Object r0 = r4.next()     // Catch: java.lang.Throwable -> L81
                android.media.EncoderProfiles$VideoProfile r0 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m(r0)     // Catch: java.lang.Throwable -> L81
                int r0 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m$2(r0)     // Catch: java.lang.Throwable -> L81
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L81
                java.lang.Comparable r0 = (java.lang.Comparable) r0     // Catch: java.lang.Throwable -> L81
                int r2 = r5.compareTo(r0)     // Catch: java.lang.Throwable -> L81
                if (r2 >= 0) goto L43
                r5 = r0
                goto L43
            L63:
                java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.Throwable -> L81
                return r5
            L66:
                java.util.NoSuchElementException r4 = new java.util.NoSuchElementException     // Catch: java.lang.Throwable -> L81
                r4.<init>()     // Catch: java.lang.Throwable -> L81
                throw r4     // Catch: java.lang.Throwable -> L81
            L6c:
                java.lang.Integer r4 = kotlin.text.StringsKt.toIntOrNull(r4)     // Catch: java.lang.Throwable -> L81
                if (r4 == 0) goto L81
                int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L81
                android.media.CamcorderProfile r4 = android.media.CamcorderProfile.get(r4, r5)     // Catch: java.lang.Throwable -> L81
                int r4 = r4.videoFrameRate     // Catch: java.lang.Throwable -> L81
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L81
                return r4
            L81:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.utils.CamcorderProfileUtils.Companion.getMaximumFps(java.lang.String, android.util.Size):java.lang.Integer");
        }
    }
}
