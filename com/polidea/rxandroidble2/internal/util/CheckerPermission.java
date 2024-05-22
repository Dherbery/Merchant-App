package com.polidea.rxandroidble2.internal.util;

import android.content.Context;
import android.os.Process;
import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.ClientScope;
import java.util.HashSet;
import java.util.Set;

@ClientScope
/* loaded from: classes5.dex */
public class CheckerPermission {
    private final Context context;
    private final Set<String> grantedPermissions = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public CheckerPermission(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAnyPermissionGranted(String[] strArr) {
        for (String str : strArr) {
            if (isPermissionGranted(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPermissionGranted(String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        if (this.grantedPermissions.contains(str)) {
            return true;
        }
        boolean z = this.context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        if (z) {
            this.grantedPermissions.add(str);
        }
        return z;
    }
}
