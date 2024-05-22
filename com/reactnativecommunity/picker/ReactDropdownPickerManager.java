package com.reactnativecommunity.picker;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerDelegate;
import com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerInterface;
import javax.annotation.Nullable;

@ReactModule(name = ReactDropdownPickerManager.REACT_CLASS)
/* loaded from: classes5.dex */
public class ReactDropdownPickerManager extends ReactPickerManager implements RNCAndroidDropdownPickerManagerInterface<ReactPicker> {
    public static final String REACT_CLASS = "RNCAndroidDropdownPicker";
    private final ViewManagerDelegate<ReactPicker> mDelegate = new RNCAndroidDropdownPickerManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerInterface
    public /* bridge */ /* synthetic */ void blur(ReactPicker reactPicker) {
        super.blur(reactPicker);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerInterface
    public /* bridge */ /* synthetic */ void focus(ReactPicker reactPicker) {
        super.focus(reactPicker);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerInterface
    @ReactProp(customType = "Color", name = "color")
    public /* bridge */ /* synthetic */ void setColor(ReactPicker reactPicker, @Nullable Integer num) {
        super.setColor(reactPicker, num);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerInterface
    @ReactProp(name = "dropdownIconColor")
    public /* bridge */ /* synthetic */ void setDropdownIconColor(ReactPicker reactPicker, @Nullable int i) {
        super.setDropdownIconColor(reactPicker, i);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerInterface
    @ReactProp(name = "dropdownIconRippleColor")
    public /* bridge */ /* synthetic */ void setDropdownIconRippleColor(ReactPicker reactPicker, @Nullable int i) {
        super.setDropdownIconRippleColor(reactPicker, i);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerInterface
    @ReactProp(defaultBoolean = true, name = ViewProps.ENABLED)
    public /* bridge */ /* synthetic */ void setEnabled(ReactPicker reactPicker, boolean z) {
        super.setEnabled(reactPicker, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerInterface
    @ReactProp(name = "items")
    public /* bridge */ /* synthetic */ void setItems(ReactPicker reactPicker, @Nullable ReadableArray readableArray) {
        super.setItems(reactPicker, readableArray);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerInterface
    public /* bridge */ /* synthetic */ void setNativeSelected(ReactPicker reactPicker, int i) {
        super.setNativeSelected(reactPicker, i);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerInterface
    @ReactProp(defaultInt = 1, name = ViewProps.NUMBER_OF_LINES)
    public /* bridge */ /* synthetic */ void setNumberOfLines(ReactPicker reactPicker, int i) {
        super.setNumberOfLines(reactPicker, i);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerInterface
    @ReactProp(name = "prompt")
    public /* bridge */ /* synthetic */ void setPrompt(ReactPicker reactPicker, @Nullable String str) {
        super.setPrompt(reactPicker, str);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerInterface
    @ReactProp(name = "selected")
    public /* bridge */ /* synthetic */ void setSelected(ReactPicker reactPicker, int i) {
        super.setSelected(reactPicker, i);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<ReactPicker> getDelegate() {
        return this.mDelegate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactPicker createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactPicker(themedReactContext, 1);
    }
}
