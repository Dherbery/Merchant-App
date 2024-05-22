package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.media.MediaSessionManager;
import androidx.media.MediaSessionManagerImplBase;

/* loaded from: classes.dex */
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {
    android.media.session.MediaSessionManager mObject;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaSessionManagerImplApi28(Context context) {
        super(context);
        this.mObject = (android.media.session.MediaSessionManager) context.getSystemService("media_session");
    }

    @Override // androidx.media.MediaSessionManagerImplApi21, androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl userInfo) {
        return super.isTrustedForMediaControl(userInfo);
    }

    /* loaded from: classes.dex */
    static final class RemoteUserInfoImplApi28 extends MediaSessionManagerImplBase.RemoteUserInfoImplBase {
        final MediaSessionManager.RemoteUserInfo mObject;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RemoteUserInfoImplApi28(String packageName, int pid, int uid) {
            super(packageName, pid, uid);
            this.mObject = AudioFocusRequestCompat$$ExternalSyntheticApiModelOutline0.m(packageName, pid, uid);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public RemoteUserInfoImplApi28(android.media.session.MediaSessionManager.RemoteUserInfo r4) {
            /*
                r3 = this;
                java.lang.String r0 = androidx.media.AudioFocusRequestCompat$$ExternalSyntheticApiModelOutline0.m161m(r4)
                int r1 = androidx.media.AudioFocusRequestCompat$$ExternalSyntheticApiModelOutline0.m(r4)
                int r2 = androidx.media.AudioFocusRequestCompat$$ExternalSyntheticApiModelOutline0.m$1(r4)
                r3.<init>(r0, r1, r2)
                r3.mObject = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media.MediaSessionManagerImplApi28.RemoteUserInfoImplApi28.<init>(android.media.session.MediaSessionManager$RemoteUserInfo):void");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static String getPackageName(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            String packageName;
            packageName = remoteUserInfo.getPackageName();
            return packageName;
        }
    }
}
