package com.mrousavy.camera.types;

import androidx.core.os.EnvironmentCompat;
import com.mrousavy.camera.core.CodeTypeNotSupportedError;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import com.mrousavy.camera.types.JSUnionValue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CodeType.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0018B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/mrousavy/camera/types/CodeType;", "", "Lcom/mrousavy/camera/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "toBarcodeType", "", "CODE_128", "CODE_39", "CODE_93", "CODABAR", "EAN_13", "EAN_8", "ITF", "UPC_E", "UPC_A", "QR", "PDF_417", "AZTEC", "DATA_MATRIX", "UNKNOWN", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum CodeType implements JSUnionValue {
    CODE_128("code-128"),
    CODE_39("code-39"),
    CODE_93("code-93"),
    CODABAR("codabar"),
    EAN_13("ean-13"),
    EAN_8("ean-8"),
    ITF("itf"),
    UPC_E("upc-e"),
    UPC_A("upc-a"),
    QR("qr"),
    PDF_417("pdf-417"),
    AZTEC("aztec"),
    DATA_MATRIX("data-matrix"),
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String unionValue;

    /* compiled from: CodeType.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CodeType.values().length];
            try {
                iArr[CodeType.CODE_128.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CodeType.CODE_39.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CodeType.CODE_93.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CodeType.CODABAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CodeType.EAN_13.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CodeType.EAN_8.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CodeType.ITF.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[CodeType.UPC_E.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[CodeType.UPC_A.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[CodeType.QR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[CodeType.PDF_417.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[CodeType.AZTEC.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[CodeType.DATA_MATRIX.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[CodeType.UNKNOWN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    CodeType(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public final int toBarcodeType() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 8;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 1024;
            case 9:
                return 512;
            case 10:
                return 256;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 16;
            case 14:
                throw new CodeTypeNotSupportedError(getUnionValue());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: CodeType.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/mrousavy/camera/types/CodeType$Companion;", "Lcom/mrousavy/camera/types/JSUnionValue$Companion;", "Lcom/mrousavy/camera/types/CodeType;", "()V", "fromBarcodeType", "barcodeType", "", "fromUnionValue", "unionValue", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion implements JSUnionValue.Companion<CodeType> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CodeType fromBarcodeType(int barcodeType) {
            if (barcodeType == 1) {
                return CodeType.CODE_128;
            }
            if (barcodeType == 2) {
                return CodeType.CODE_39;
            }
            switch (barcodeType) {
                case 4:
                    return CodeType.CODE_93;
                case 8:
                    return CodeType.CODABAR;
                case 16:
                    return CodeType.DATA_MATRIX;
                case 32:
                    return CodeType.EAN_13;
                case 64:
                    return CodeType.EAN_8;
                case 128:
                    return CodeType.ITF;
                case 256:
                    return CodeType.QR;
                case 512:
                    return CodeType.UPC_A;
                case 1024:
                    return CodeType.UPC_E;
                case 2048:
                    return CodeType.PDF_417;
                case 4096:
                    return CodeType.AZTEC;
                default:
                    return CodeType.UNKNOWN;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.types.JSUnionValue.Companion
        public CodeType fromUnionValue(String unionValue) {
            if (unionValue != null) {
                switch (unionValue.hashCode()) {
                    case -1310519683:
                        if (unionValue.equals("ean-13")) {
                            return CodeType.EAN_13;
                        }
                        break;
                    case -869195177:
                        if (unionValue.equals("code-128")) {
                            return CodeType.CODE_128;
                        }
                        break;
                    case -720296449:
                        if (unionValue.equals("pdf-417")) {
                            return CodeType.PDF_417;
                        }
                        break;
                    case 3617:
                        if (unionValue.equals("qr")) {
                            return CodeType.QR;
                        }
                        break;
                    case 104603:
                        if (unionValue.equals("itf")) {
                            return CodeType.ITF;
                        }
                        break;
                    case 93330745:
                        if (unionValue.equals("aztec")) {
                            return CodeType.AZTEC;
                        }
                        break;
                    case 96272509:
                        if (unionValue.equals("ean-8")) {
                            return CodeType.EAN_8;
                        }
                        break;
                    case 111485180:
                        if (unionValue.equals("upc-a")) {
                            return CodeType.UPC_A;
                        }
                        break;
                    case 111485184:
                        if (unionValue.equals("upc-e")) {
                            return CodeType.UPC_E;
                        }
                        break;
                    case 941726090:
                        if (unionValue.equals("codabar")) {
                            return CodeType.CODABAR;
                        }
                        break;
                    case 941792838:
                        if (unionValue.equals("code-39")) {
                            return CodeType.CODE_39;
                        }
                        break;
                    case 941793018:
                        if (unionValue.equals("code-93")) {
                            return CodeType.CODE_93;
                        }
                        break;
                    case 1350827844:
                        if (unionValue.equals("data-matrix")) {
                            return CodeType.DATA_MATRIX;
                        }
                        break;
                }
            }
            if (unionValue == null) {
                unionValue = "(null)";
            }
            throw new InvalidTypeScriptUnionError("codeType", unionValue);
        }
    }
}
