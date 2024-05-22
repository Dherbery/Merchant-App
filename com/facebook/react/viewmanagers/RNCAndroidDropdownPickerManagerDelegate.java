package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerInterface;

/* loaded from: classes3.dex */
public class RNCAndroidDropdownPickerManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNCAndroidDropdownPickerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNCAndroidDropdownPickerManagerDelegate(BaseViewManagerInterface baseViewManagerInterface) {
        super(baseViewManagerInterface);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1902983847:
                if (str.equals("dropdownIconColor")) {
                    c = 0;
                    break;
                }
                break;
            case -1808880503:
                if (str.equals("dropdownIconRippleColor")) {
                    c = 1;
                    break;
                }
                break;
            case -1609594047:
                if (str.equals(ViewProps.ENABLED)) {
                    c = 2;
                    break;
                }
                break;
            case -1329887265:
                if (str.equals(ViewProps.NUMBER_OF_LINES)) {
                    c = 3;
                    break;
                }
                break;
            case -979805852:
                if (str.equals("prompt")) {
                    c = 4;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c = 5;
                    break;
                }
                break;
            case 100526016:
                if (str.equals("items")) {
                    c = 6;
                    break;
                }
                break;
            case 1191572123:
                if (str.equals("selected")) {
                    c = 7;
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setDropdownIconColor(t, obj != null ? ((Double) obj).intValue() : 0);
                return;
            case 1:
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setDropdownIconRippleColor(t, obj != null ? ((Double) obj).intValue() : 0);
                return;
            case 2:
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                return;
            case 3:
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setNumberOfLines(t, obj != null ? ((Double) obj).intValue() : 0);
                return;
            case 4:
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setPrompt(t, obj == null ? null : (String) obj);
                return;
            case 5:
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            case 6:
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setItems(t, (ReadableArray) obj);
                return;
            case 7:
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setSelected(t, obj != null ? ((Double) obj).intValue() : 0);
                return;
            case '\b':
                this.mViewManager.setBackgroundColor(t, obj != null ? ((Double) obj).intValue() : 0);
                return;
            default:
                super.setProperty(t, str, obj);
                return;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void receiveCommand(T t, String str, ReadableArray readableArray) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 3027047:
                if (str.equals("blur")) {
                    c = 0;
                    break;
                }
                break;
            case 97604824:
                if (str.equals("focus")) {
                    c = 1;
                    break;
                }
                break;
            case 361157844:
                if (str.equals("setNativeSelected")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).blur(t);
                return;
            case 1:
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).focus(t);
                return;
            case 2:
                ((RNCAndroidDropdownPickerManagerInterface) this.mViewManager).setNativeSelected(t, readableArray.getInt(0));
                return;
            default:
                return;
        }
    }
}
