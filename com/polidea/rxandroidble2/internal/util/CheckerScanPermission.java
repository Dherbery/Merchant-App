package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.ClientScope;

@ClientScope
/* loaded from: classes5.dex */
public class CheckerScanPermission {
    private final CheckerPermission checkerPermission;
    private final String[][] scanPermissions;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public CheckerScanPermission(CheckerPermission checkerPermission, @Named("scan-permissions") String[][] strArr) {
        this.checkerPermission = checkerPermission;
        this.scanPermissions = strArr;
    }

    public boolean isScanRuntimePermissionGranted() {
        boolean z = true;
        for (String[] strArr : this.scanPermissions) {
            z &= this.checkerPermission.isAnyPermissionGranted(strArr);
        }
        return z;
    }

    public String[] getRecommendedScanRuntimePermissions() {
        int i = 0;
        for (String[] strArr : this.scanPermissions) {
            i += strArr.length;
        }
        String[] strArr2 = new String[i];
        int i2 = 0;
        for (String[] strArr3 : this.scanPermissions) {
            int length = strArr3.length;
            int i3 = 0;
            while (i3 < length) {
                strArr2[i2] = strArr3[i3];
                i3++;
                i2++;
            }
        }
        return strArr2;
    }
}
