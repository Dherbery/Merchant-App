package com.amazon.a.b;

import com.amazon.a.a.i.c;

/* compiled from: LicenseFailurePromptContent.java */
/* loaded from: classes.dex */
public class e {
    private static final String h = "Quit";
    private static final String i = "Help";
    public static final com.amazon.a.a.i.c a = new com.amazon.a.a.i.c(new String[]{"Amazon Appstore required"}, "Amazon Appstore is not installed on your device. Please install Amazon Appstore and sign in to Amazon to use this app.", new String[]{h, i}, new c.a[]{c.a.DEFAULT, c.a.HELP}, true, true, 1, 1);
    public static final com.amazon.a.a.i.c b = new com.amazon.a.a.i.c("Amazon Appstore connection failure", "An error occurred connecting to Amazon Appstore. Please try opening this app again", h, true, false);
    public static final com.amazon.a.a.i.c c = new com.amazon.a.a.i.c(new String[]{"New Appstore version required", "Amazon Appstore Update Required"}, "Amazon Appstore is out of date.  Please visit the Amazon website to install the latest version of the Appstore. ", new String[]{h, i}, new c.a[]{c.a.DEFAULT, c.a.HELP}, true, true, 1, 2);
    public static final com.amazon.a.a.i.c d = new com.amazon.a.a.i.c("Internet connection required", "An internet connection is required to open this app. Please connect to the internet and reopen this app.", h, true, false);
    public static final com.amazon.a.a.i.c e = new com.amazon.a.a.i.c(new String[]{"Connection error"}, "An unknown error occurred connecting to Amazon Appstore.", new String[]{h, i}, new c.a[]{c.a.DEFAULT, c.a.HELP}, true, true, 1, 3);
    public static final com.amazon.a.a.i.c f = new com.amazon.a.a.i.c("Internal error", "An internal error occurred, please try opening this app again", h, true, false);
    private static final String j = "Update";
    public static final com.amazon.a.a.i.c g = new com.amazon.a.a.i.c("App update required", "Please update this app from the Amazon Appstore.", new String[]{h, j}, new c.a[]{c.a.DEFAULT, c.a.DEEPLINK}, true, false, 0);

    private e() {
    }
}
