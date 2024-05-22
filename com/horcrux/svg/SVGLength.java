package com.horcrux.svg;

import com.amazon.a.a.o.b.f;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;

/* loaded from: classes5.dex */
class SVGLength {
    final UnitType unit;
    final double value;

    /* loaded from: classes5.dex */
    public enum UnitType {
        UNKNOWN,
        NUMBER,
        PERCENTAGE,
        EMS,
        EXS,
        PX,
        CM,
        MM,
        IN,
        PT,
        PC
    }

    private SVGLength() {
        this.value = 0.0d;
        this.unit = UnitType.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SVGLength(double d) {
        this.value = d;
        this.unit = UnitType.NUMBER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SVGLength(String str) {
        String trim = str.trim();
        int length = trim.length();
        int i = length - 1;
        if (length == 0 || trim.equals("normal")) {
            this.unit = UnitType.UNKNOWN;
            this.value = 0.0d;
            return;
        }
        if (trim.codePointAt(i) == 37) {
            this.unit = UnitType.PERCENTAGE;
            this.value = Double.valueOf(trim.substring(0, i)).doubleValue();
            return;
        }
        int i2 = length - 2;
        if (i2 > 0) {
            String substring = trim.substring(i2);
            substring.hashCode();
            char c = 65535;
            switch (substring.hashCode()) {
                case 3178:
                    if (substring.equals("cm")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (substring.equals("em")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3251:
                    if (substring.equals("ex")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3365:
                    if (substring.equals("in")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3488:
                    if (substring.equals("mm")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3571:
                    if (substring.equals("pc")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3588:
                    if (substring.equals("pt")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3592:
                    if (substring.equals("px")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.unit = UnitType.CM;
                    length = i2;
                    break;
                case 1:
                    this.unit = UnitType.EMS;
                    length = i2;
                    break;
                case 2:
                    this.unit = UnitType.EXS;
                    length = i2;
                    break;
                case 3:
                    this.unit = UnitType.IN;
                    length = i2;
                    break;
                case 4:
                    this.unit = UnitType.MM;
                    length = i2;
                    break;
                case 5:
                    this.unit = UnitType.PC;
                    length = i2;
                    break;
                case 6:
                    this.unit = UnitType.PT;
                    length = i2;
                    break;
                case 7:
                    this.unit = UnitType.NUMBER;
                    length = i2;
                    break;
                default:
                    this.unit = UnitType.NUMBER;
                    break;
            }
            this.value = Double.valueOf(trim.substring(0, length)).doubleValue();
            return;
        }
        this.unit = UnitType.NUMBER;
        this.value = Double.valueOf(trim).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.horcrux.svg.SVGLength$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SVGLength from(Dynamic dynamic) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()];
        if (i == 1) {
            return new SVGLength(dynamic.asDouble());
        }
        if (i == 2) {
            return new SVGLength(dynamic.asString());
        }
        return new SVGLength();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SVGLength from(String str) {
        return str != null ? new SVGLength(str) : new SVGLength();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SVGLength from(Double d) {
        return d != null ? new SVGLength(d.doubleValue()) : new SVGLength();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toString(Dynamic dynamic) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()];
        if (i == 1) {
            return String.valueOf(dynamic.asDouble());
        }
        if (i != 2) {
            return null;
        }
        return dynamic.asString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<SVGLength> arrayFrom(Dynamic dynamic) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()];
        if (i == 1) {
            ArrayList<SVGLength> arrayList = new ArrayList<>(1);
            arrayList.add(new SVGLength(dynamic.asDouble()));
            return arrayList;
        }
        int i2 = 0;
        if (i == 2) {
            String[] split = dynamic.asString().trim().replaceAll(f.a, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            ArrayList<SVGLength> arrayList2 = new ArrayList<>(split.length);
            int length = split.length;
            while (i2 < length) {
                arrayList2.add(new SVGLength(split[i2]));
                i2++;
            }
            return arrayList2;
        }
        if (i != 3) {
            return null;
        }
        ReadableArray asArray = dynamic.asArray();
        int size = asArray.size();
        ArrayList<SVGLength> arrayList3 = new ArrayList<>(size);
        while (i2 < size) {
            arrayList3.add(from(asArray.getDynamic(i2)));
            i2++;
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<SVGLength> arrayFrom(ReadableArray readableArray) {
        int size = readableArray.size();
        ArrayList<SVGLength> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(from(readableArray.getDynamic(i)));
        }
        return arrayList;
    }
}
