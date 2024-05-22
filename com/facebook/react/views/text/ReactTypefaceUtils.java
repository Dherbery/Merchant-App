package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import com.facebook.react.common.assets.ReactFontManager;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes3.dex */
public class ReactTypefaceUtils {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int parseFontWeight(String str) {
        char c;
        if (str != null) {
            str.hashCode();
            switch (str.hashCode()) {
                case -1039745817:
                    if (str.equals("normal")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 48625:
                    if (str.equals("100")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 49586:
                    if (str.equals("200")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 50547:
                    if (str.equals("300")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 51508:
                    if (str.equals("400")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 52469:
                    if (str.equals("500")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 53430:
                    if (str.equals("600")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 54391:
                    if (str.equals("700")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 55352:
                    if (str.equals("800")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 56313:
                    if (str.equals("900")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 3029637:
                    if (str.equals(TtmlNode.BOLD)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 4:
                    return 400;
                case 1:
                    return 100;
                case 2:
                    return 200;
                case 3:
                    return 300;
                case 5:
                    return 500;
                case 6:
                    return 600;
                case 7:
                case '\n':
                    return ReactFontManager.TypefaceStyle.BOLD;
                case '\b':
                    return 800;
                case '\t':
                    return 900;
            }
        }
        return -1;
    }

    public static int parseFontStyle(String str) {
        if (str == null) {
            return -1;
        }
        if (TtmlNode.ITALIC.equals(str)) {
            return 2;
        }
        return "normal".equals(str) ? 0 : -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01df, code lost:
    
        switch(r5) {
            case 0: goto L180;
            case 1: goto L179;
            case 2: goto L178;
            case 3: goto L177;
            case 4: goto L176;
            case 5: goto L175;
            case 6: goto L174;
            case 7: goto L173;
            case 8: goto L172;
            case 9: goto L171;
            case 10: goto L170;
            case 11: goto L169;
            case 12: goto L168;
            case 13: goto L167;
            case 14: goto L166;
            case 15: goto L165;
            case 16: goto L164;
            case 17: goto L163;
            case 18: goto L162;
            case 19: goto L161;
            case 20: goto L160;
            case 21: goto L159;
            case 22: goto L158;
            case 23: goto L157;
            case 24: goto L156;
            case 25: goto L155;
            case 26: goto L154;
            case 27: goto L153;
            case 28: goto L152;
            case 29: goto L151;
            case 30: goto L150;
            case 31: goto L149;
            case 32: goto L148;
            default: goto L221;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01e4, code lost:
    
        r0.add("'ss17'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01eb, code lost:
    
        r0.add("'ss14'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01f2, code lost:
    
        r0.add("'ss19'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01f9, code lost:
    
        r0.add("'liga'");
        r0.add("'clig'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0205, code lost:
    
        r0.add("'smcp'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x020c, code lost:
    
        r0.add("'dlig' off");
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0213, code lost:
    
        r0.add("'ss20'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x021a, code lost:
    
        r0.add("'ss12'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0221, code lost:
    
        r0.add("'ss16'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0228, code lost:
    
        r0.add("'ss02'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x022f, code lost:
    
        r0.add("'ss10'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0236, code lost:
    
        r0.add("'ss06'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x023d, code lost:
    
        r0.add("'ss01'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0244, code lost:
    
        r0.add("'ss09'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x024b, code lost:
    
        r0.add("'ss04'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0252, code lost:
    
        r0.add("'ss05'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0259, code lost:
    
        r0.add("'hlig' off");
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0260, code lost:
    
        r0.add("'ss11'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0266, code lost:
    
        r0.add("'ss03'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x026c, code lost:
    
        r0.add("'ss07'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0272, code lost:
    
        r0.add("'ss08'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0278, code lost:
    
        r0.add("'liga' off");
        r0.add("'clig' off");
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0283, code lost:
    
        r0.add("'calt'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0289, code lost:
    
        r0.add("'calt' off");
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x028f, code lost:
    
        r0.add("'onum'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0295, code lost:
    
        r0.add("'dlig'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x029b, code lost:
    
        r0.add("'tnum'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02a1, code lost:
    
        r0.add("'hlig'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02a7, code lost:
    
        r0.add("'lnum'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x02ad, code lost:
    
        r0.add("'pnum'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x02b3, code lost:
    
        r0.add("'ss18'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x02b9, code lost:
    
        r0.add("'ss15'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x02bf, code lost:
    
        r0.add("'ss13'");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String parseFontVariant(com.facebook.react.bridge.ReadableArray r6) {
        /*
            Method dump skipped, instructions count: 926
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTypefaceUtils.parseFontVariant(com.facebook.react.bridge.ReadableArray):java.lang.String");
    }

    public static Typeface applyStyles(Typeface typeface, int i, int i2, String str, AssetManager assetManager) {
        ReactFontManager.TypefaceStyle typefaceStyle = new ReactFontManager.TypefaceStyle(i, i2);
        if (str != null) {
            return com.facebook.react.common.assets.ReactFontManager.getInstance().getTypeface(str, typefaceStyle, assetManager);
        }
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        return typefaceStyle.apply(typeface);
    }
}
