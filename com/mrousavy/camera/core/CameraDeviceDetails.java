package com.mrousavy.camera.core;

import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import android.util.SizeF;
import android.view.SurfaceHolder;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.mrousavy.camera.extensions.CameraCharacteristics_getOutputSizesKt;
import com.mrousavy.camera.extensions.List_toJSValueKt;
import com.mrousavy.camera.extensions.Size_ExtensionsKt;
import com.mrousavy.camera.types.AutoFocusSystem;
import com.mrousavy.camera.types.DeviceType;
import com.mrousavy.camera.types.HardwareLevel;
import com.mrousavy.camera.types.LensFacing;
import com.mrousavy.camera.types.Orientation;
import com.mrousavy.camera.types.PixelFormat;
import com.mrousavy.camera.types.VideoStabilizationMode;
import com.mrousavy.camera.utils.CamcorderProfileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraDeviceDetails.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0016\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 Ø\u00012\u00020\u0001:\u0002Ø\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J-\u0010¿\u0001\u001a\u00030À\u00012\b\u0010Á\u0001\u001a\u00030Â\u00012\b\u0010Ã\u0001\u001a\u00030Â\u00012\r\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020\r0GH\u0002J\n\u0010Å\u0001\u001a\u00030Æ\u0001H\u0002J\n\u0010Ç\u0001\u001a\u00030Æ\u0001H\u0002J\t\u0010È\u0001\u001a\u00020\u0016H\u0002J\t\u0010É\u0001\u001a\u00020\u001bH\u0002J\u0010\u0010Ê\u0001\u001a\t\u0012\u0005\u0012\u00030Ë\u00010\fH\u0002J\u0012\u0010Ì\u0001\u001a\u00020q2\u0007\u0010Í\u0001\u001a\u00020lH\u0002J\n\u0010Î\u0001\u001a\u00030Æ\u0001H\u0002J\t\u0010Ï\u0001\u001a\u00020ZH\u0002J\t\u0010Ð\u0001\u001a\u00020qH\u0002J\t\u0010Ñ\u0001\u001a\u00020qH\u0002J\u000e\u0010Ò\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u00010\fJ\u000e\u0010Ó\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u00010\fJ\u000f\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0017\u0010Õ\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u00010\f2\u0007\u0010Ö\u0001\u001a\u00020\rJ\t\u0010«\u0001\u001a\u00020ZH\u0002J\b\u0010×\u0001\u001a\u00030À\u0001R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b \u0010\u001dR\u001b\u0010\"\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b#\u0010\u001dR\u001b\u0010%\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b&\u0010\u001dR\u001b\u0010(\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b)\u0010\u001dR\u001b\u0010+\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0011\u001a\u0004\b,\u0010\u001dR\u001b\u0010.\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0011\u001a\u0004\b/\u0010\u001dR!\u00101\u001a\b\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0011\u001a\u0004\b2\u0010\u000fR\u001b\u00104\u001a\u0002058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0011\u001a\u0004\b6\u00107R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010;\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0011\u001a\u0004\b<\u0010\u001dR\u001b\u0010>\u001a\u00020?8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0011\u001a\u0004\b@\u0010AR\u001b\u0010C\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0011\u001a\u0004\bD\u0010\u001dR)\u0010F\u001a\u0010\u0012\f\u0012\n H*\u0004\u0018\u00010\r0\r0G8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\u0011\u001a\u0004\bI\u0010JR!\u0010L\u001a\b\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u0011\u001a\u0004\bM\u0010\u000fR\u001b\u0010O\u001a\u00020P8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u0011\u001a\u0004\bQ\u0010RR\u001b\u0010T\u001a\u00020U8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u0011\u001a\u0004\bV\u0010WR\u001b\u0010Y\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\u0011\u001a\u0004\b[\u0010\\R\u001b\u0010^\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\u0011\u001a\u0004\b^\u0010_R\u001b\u0010a\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\u0011\u001a\u0004\ba\u0010_R)\u0010c\u001a\u0010\u0012\f\u0012\n H*\u0004\u0018\u00010\r0\r0G8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u0011\u001a\u0004\bd\u0010JR\u001b\u0010f\u001a\u00020g8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bj\u0010\u0011\u001a\u0004\bh\u0010iR\u001b\u0010k\u001a\u00020l8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\u0011\u001a\u0004\bm\u0010nR\u001b\u0010p\u001a\u00020q8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\u0011\u001a\u0004\br\u0010sR\u001b\u0010u\u001a\u00020q8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bw\u0010\u0011\u001a\u0004\bv\u0010sR\u001b\u0010x\u001a\u00020q8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bz\u0010\u0011\u001a\u0004\by\u0010sR!\u0010{\u001a\b\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b}\u0010\u0011\u001a\u0004\b|\u0010\u000fR\u001c\u0010~\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\r\n\u0005\b\u0080\u0001\u0010\u0011\u001a\u0004\b\u007f\u0010:R\u001e\u0010\u0081\u0001\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010\u0011\u001a\u0005\b\u0082\u0001\u0010\u001dR\u0017\u0010\u0084\u0001\u001a\u00020\rX\u0086D¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R.\u0010\u0087\u0001\u001a\u0011\u0012\f\u0012\n H*\u0004\u0018\u00010\u00050\u00050\u0088\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u008b\u0001\u0010\u0011\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R \u0010\u008c\u0001\u001a\u00030\u008d\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u0090\u0001\u0010\u0011\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R \u0010\u0091\u0001\u001a\u00030\u0092\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u0095\u0001\u0010\u0011\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001e\u0010\u0096\u0001\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0098\u0001\u0010\u0011\u001a\u0005\b\u0097\u0001\u0010_R\u001e\u0010\u0099\u0001\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009b\u0001\u0010\u0011\u001a\u0005\b\u009a\u0001\u0010_R\u001e\u0010\u009c\u0001\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009e\u0001\u0010\u0011\u001a\u0005\b\u009d\u0001\u0010_R\u001e\u0010\u009f\u0001\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¡\u0001\u0010\u0011\u001a\u0005\b \u0001\u0010_R\u001e\u0010¢\u0001\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¤\u0001\u0010\u0011\u001a\u0005\b£\u0001\u0010_R\u001e\u0010¥\u0001\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b§\u0001\u0010\u0011\u001a\u0005\b¦\u0001\u0010_R\u001e\u0010¨\u0001\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bª\u0001\u0010\u0011\u001a\u0005\b©\u0001\u0010_R\u001e\u0010«\u0001\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u00ad\u0001\u0010\u0011\u001a\u0005\b¬\u0001\u0010_R\u001e\u0010®\u0001\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b°\u0001\u0010\u0011\u001a\u0005\b¯\u0001\u0010_R\u001e\u0010±\u0001\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b³\u0001\u0010\u0011\u001a\u0005\b²\u0001\u0010_R\u001e\u0010´\u0001\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¶\u0001\u0010\u0011\u001a\u0005\bµ\u0001\u0010_R\u001e\u0010·\u0001\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¹\u0001\u0010\u0011\u001a\u0005\b¸\u0001\u0010_R\u0017\u0010º\u0001\u001a\u00020\rX\u0086D¢\u0006\n\n\u0000\u001a\u0006\b»\u0001\u0010\u0086\u0001R,\u0010¼\u0001\u001a\u0010\u0012\f\u0012\n H*\u0004\u0018\u00010l0l0G8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¾\u0001\u0010\u0011\u001a\u0005\b½\u0001\u0010J¨\u0006Ù\u0001"}, d2 = {"Lcom/mrousavy/camera/core/CameraDeviceDetails;", "", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "cameraId", "", "(Landroid/hardware/camera2/CameraManager;Ljava/lang/String;)V", "activeSize", "Landroid/graphics/Rect;", "getActiveSize", "()Landroid/graphics/Rect;", "aeModes", "", "", "getAeModes", "()Ljava/util/List;", "aeModes$delegate", "Lkotlin/Lazy;", "afModes", "getAfModes", "afModes$delegate", "autoFocusSystem", "Lcom/mrousavy/camera/types/AutoFocusSystem;", "getAutoFocusSystem", "()Lcom/mrousavy/camera/types/AutoFocusSystem;", "autoFocusSystem$delegate", "availableAberrationModes", "", "getAvailableAberrationModes", "()[I", "availableAberrationModes$delegate", "availableDistortionCorrectionModes", "getAvailableDistortionCorrectionModes", "availableDistortionCorrectionModes$delegate", "availableEdgeModes", "getAvailableEdgeModes", "availableEdgeModes$delegate", "availableHotPixelModes", "getAvailableHotPixelModes", "availableHotPixelModes$delegate", "availableNoiseReductionModes", "getAvailableNoiseReductionModes", "availableNoiseReductionModes$delegate", "availableShadingModes", "getAvailableShadingModes", "availableShadingModes$delegate", "availableToneMapModes", "getAvailableToneMapModes", "availableToneMapModes$delegate", "awbModes", "getAwbModes", "awbModes$delegate", "cameraConfig", "Landroid/hardware/camera2/params/StreamConfigurationMap;", "getCameraConfig", "()Landroid/hardware/camera2/params/StreamConfigurationMap;", "cameraConfig$delegate", "getCameraId", "()Ljava/lang/String;", "capabilities", "getCapabilities", "capabilities$delegate", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "getCharacteristics", "()Landroid/hardware/camera2/CameraCharacteristics;", "characteristics$delegate", "digitalStabilizationModes", "getDigitalStabilizationModes", "digitalStabilizationModes$delegate", "exposureRange", "Landroid/util/Range;", "kotlin.jvm.PlatformType", "getExposureRange", "()Landroid/util/Range;", "exposureRange$delegate", "extensions", "getExtensions", "extensions$delegate", "focalLengths", "", "getFocalLengths", "()[F", "focalLengths$delegate", "hardwareLevel", "Lcom/mrousavy/camera/types/HardwareLevel;", "getHardwareLevel", "()Lcom/mrousavy/camera/types/HardwareLevel;", "hardwareLevel$delegate", "hasFlash", "", "getHasFlash", "()Ljava/lang/Boolean;", "hasFlash$delegate", "isBackwardsCompatible", "()Z", "isBackwardsCompatible$delegate", "isMultiCam", "isMultiCam$delegate", "isoRange", "getIsoRange", "isoRange$delegate", "lensFacing", "Lcom/mrousavy/camera/types/LensFacing;", "getLensFacing", "()Lcom/mrousavy/camera/types/LensFacing;", "lensFacing$delegate", "maxDigitalZoom", "", "getMaxDigitalZoom", "()Ljava/lang/Float;", "maxDigitalZoom$delegate", "maxZoom", "", "getMaxZoom", "()D", "maxZoom$delegate", "minFocusDistance", "getMinFocusDistance", "minFocusDistance$delegate", "minZoom", "getMinZoom", "minZoom$delegate", "modes", "getModes", "modes$delegate", "name", "getName", "name$delegate", "opticalStabilizationModes", "getOpticalStabilizationModes", "opticalStabilizationModes$delegate", "photoFormat", "getPhotoFormat", "()I", "physicalDevices", "", "getPhysicalDevices", "()Ljava/util/Set;", "physicalDevices$delegate", "sensorOrientation", "Lcom/mrousavy/camera/types/Orientation;", "getSensorOrientation", "()Lcom/mrousavy/camera/types/Orientation;", "sensorOrientation$delegate", "sensorSize", "Landroid/util/SizeF;", "getSensorSize", "()Landroid/util/SizeF;", "sensorSize$delegate", "supportsDepthCapture", "getSupportsDepthCapture", "supportsDepthCapture$delegate", "supportsExposureRegions", "getSupportsExposureRegions", "supportsExposureRegions$delegate", "supportsFocusRegions", "getSupportsFocusRegions", "supportsFocusRegions$delegate", "supportsLowLightBoost", "getSupportsLowLightBoost", "supportsLowLightBoost$delegate", "supportsPhotoHdr", "getSupportsPhotoHdr", "supportsPhotoHdr$delegate", "supportsPrivateProcessing", "getSupportsPrivateProcessing", "supportsPrivateProcessing$delegate", "supportsRawCapture", "getSupportsRawCapture", "supportsRawCapture$delegate", "supportsSnapshotCapture", "getSupportsSnapshotCapture", "supportsSnapshotCapture$delegate", "supportsVideoHdr", "getSupportsVideoHdr", "supportsVideoHdr$delegate", "supportsWhiteBalanceRegions", "getSupportsWhiteBalanceRegions", "supportsWhiteBalanceRegions$delegate", "supportsYuvProcessing", "getSupportsYuvProcessing", "supportsYuvProcessing$delegate", "supportsZsl", "getSupportsZsl", "supportsZsl$delegate", "videoFormat", "getVideoFormat", "zoomRange", "getZoomRange", "zoomRange$delegate", "buildFormatMap", "Lcom/facebook/react/bridge/ReadableMap;", "photoSize", "Landroid/util/Size;", "videoSize", "fpsRange", "createPixelFormats", "Lcom/facebook/react/bridge/ReadableArray;", "createStabilizationModes", "getAutoFocusSystemMode", "getAvailableDistortionCorrectionModesOrEmptyArray", "getDeviceTypes", "Lcom/mrousavy/camera/types/DeviceType;", "getFieldOfView", "focalLength", "getFormats", "getHasVideoHdr", "getMaxFieldOfView", "getMinFocusDistanceCm", "getPhotoSizes", "getPreviewSizes", "getSupportedExtensions", "getVideoSizes", "format", "toMap", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraDeviceDetails {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "CameraDeviceDetails";

    /* renamed from: aeModes$delegate, reason: from kotlin metadata */
    private final Lazy aeModes;

    /* renamed from: afModes$delegate, reason: from kotlin metadata */
    private final Lazy afModes;

    /* renamed from: autoFocusSystem$delegate, reason: from kotlin metadata */
    private final Lazy autoFocusSystem;

    /* renamed from: availableAberrationModes$delegate, reason: from kotlin metadata */
    private final Lazy availableAberrationModes;

    /* renamed from: availableDistortionCorrectionModes$delegate, reason: from kotlin metadata */
    private final Lazy availableDistortionCorrectionModes;

    /* renamed from: availableEdgeModes$delegate, reason: from kotlin metadata */
    private final Lazy availableEdgeModes;

    /* renamed from: availableHotPixelModes$delegate, reason: from kotlin metadata */
    private final Lazy availableHotPixelModes;

    /* renamed from: availableNoiseReductionModes$delegate, reason: from kotlin metadata */
    private final Lazy availableNoiseReductionModes;

    /* renamed from: availableShadingModes$delegate, reason: from kotlin metadata */
    private final Lazy availableShadingModes;

    /* renamed from: availableToneMapModes$delegate, reason: from kotlin metadata */
    private final Lazy availableToneMapModes;

    /* renamed from: awbModes$delegate, reason: from kotlin metadata */
    private final Lazy awbModes;

    /* renamed from: cameraConfig$delegate, reason: from kotlin metadata */
    private final Lazy cameraConfig;
    private final String cameraId;
    private final CameraManager cameraManager;

    /* renamed from: capabilities$delegate, reason: from kotlin metadata */
    private final Lazy capabilities;

    /* renamed from: characteristics$delegate, reason: from kotlin metadata */
    private final Lazy characteristics;

    /* renamed from: digitalStabilizationModes$delegate, reason: from kotlin metadata */
    private final Lazy digitalStabilizationModes;

    /* renamed from: exposureRange$delegate, reason: from kotlin metadata */
    private final Lazy exposureRange;

    /* renamed from: extensions$delegate, reason: from kotlin metadata */
    private final Lazy extensions;

    /* renamed from: focalLengths$delegate, reason: from kotlin metadata */
    private final Lazy focalLengths;

    /* renamed from: hardwareLevel$delegate, reason: from kotlin metadata */
    private final Lazy hardwareLevel;

    /* renamed from: hasFlash$delegate, reason: from kotlin metadata */
    private final Lazy hasFlash;

    /* renamed from: isBackwardsCompatible$delegate, reason: from kotlin metadata */
    private final Lazy isBackwardsCompatible;

    /* renamed from: isMultiCam$delegate, reason: from kotlin metadata */
    private final Lazy isMultiCam;

    /* renamed from: isoRange$delegate, reason: from kotlin metadata */
    private final Lazy isoRange;

    /* renamed from: lensFacing$delegate, reason: from kotlin metadata */
    private final Lazy lensFacing;

    /* renamed from: maxDigitalZoom$delegate, reason: from kotlin metadata */
    private final Lazy maxDigitalZoom;

    /* renamed from: maxZoom$delegate, reason: from kotlin metadata */
    private final Lazy maxZoom;

    /* renamed from: minFocusDistance$delegate, reason: from kotlin metadata */
    private final Lazy minFocusDistance;

    /* renamed from: minZoom$delegate, reason: from kotlin metadata */
    private final Lazy minZoom;

    /* renamed from: modes$delegate, reason: from kotlin metadata */
    private final Lazy modes;

    /* renamed from: name$delegate, reason: from kotlin metadata */
    private final Lazy name;

    /* renamed from: opticalStabilizationModes$delegate, reason: from kotlin metadata */
    private final Lazy opticalStabilizationModes;
    private final int photoFormat;

    /* renamed from: physicalDevices$delegate, reason: from kotlin metadata */
    private final Lazy physicalDevices;

    /* renamed from: sensorOrientation$delegate, reason: from kotlin metadata */
    private final Lazy sensorOrientation;

    /* renamed from: sensorSize$delegate, reason: from kotlin metadata */
    private final Lazy sensorSize;

    /* renamed from: supportsDepthCapture$delegate, reason: from kotlin metadata */
    private final Lazy supportsDepthCapture;

    /* renamed from: supportsExposureRegions$delegate, reason: from kotlin metadata */
    private final Lazy supportsExposureRegions;

    /* renamed from: supportsFocusRegions$delegate, reason: from kotlin metadata */
    private final Lazy supportsFocusRegions;

    /* renamed from: supportsLowLightBoost$delegate, reason: from kotlin metadata */
    private final Lazy supportsLowLightBoost;

    /* renamed from: supportsPhotoHdr$delegate, reason: from kotlin metadata */
    private final Lazy supportsPhotoHdr;

    /* renamed from: supportsPrivateProcessing$delegate, reason: from kotlin metadata */
    private final Lazy supportsPrivateProcessing;

    /* renamed from: supportsRawCapture$delegate, reason: from kotlin metadata */
    private final Lazy supportsRawCapture;

    /* renamed from: supportsSnapshotCapture$delegate, reason: from kotlin metadata */
    private final Lazy supportsSnapshotCapture;

    /* renamed from: supportsVideoHdr$delegate, reason: from kotlin metadata */
    private final Lazy supportsVideoHdr;

    /* renamed from: supportsWhiteBalanceRegions$delegate, reason: from kotlin metadata */
    private final Lazy supportsWhiteBalanceRegions;

    /* renamed from: supportsYuvProcessing$delegate, reason: from kotlin metadata */
    private final Lazy supportsYuvProcessing;

    /* renamed from: supportsZsl$delegate, reason: from kotlin metadata */
    private final Lazy supportsZsl;
    private final int videoFormat;

    /* renamed from: zoomRange$delegate, reason: from kotlin metadata */
    private final Lazy zoomRange;

    /* compiled from: CameraDeviceDetails.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/CameraDeviceDetails$Companion;", "", "()V", "TAG", "", "getMaximumPreviewSize", "Landroid/util/Size;", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Size getMaximumPreviewSize() {
            Size size = new Size(1920, 1080);
            Size size2 = new Size(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels);
            return Size_ExtensionsKt.getBigger(size2) >= Size_ExtensionsKt.getBigger(size) || Size_ExtensionsKt.getSmaller(size2) >= Size_ExtensionsKt.getSmaller(size) ? size : size2;
        }
    }

    public CameraDeviceDetails(CameraManager cameraManager, String cameraId) {
        Intrinsics.checkNotNullParameter(cameraManager, "cameraManager");
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        this.cameraManager = cameraManager;
        this.cameraId = cameraId;
        this.characteristics = LazyKt.lazy(new Function0<CameraCharacteristics>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$characteristics$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CameraCharacteristics invoke() {
                CameraManager cameraManager2;
                cameraManager2 = CameraDeviceDetails.this.cameraManager;
                return cameraManager2.getCameraCharacteristics(CameraDeviceDetails.this.getCameraId());
            }
        });
        this.hardwareLevel = LazyKt.lazy(new Function0<HardwareLevel>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$hardwareLevel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HardwareLevel invoke() {
                HardwareLevel.Companion companion = HardwareLevel.INSTANCE;
                CameraCharacteristics characteristics = CameraDeviceDetails.this.getCharacteristics();
                Intrinsics.checkNotNullExpressionValue(characteristics, "characteristics");
                return companion.fromCameraCharacteristics(characteristics);
            }
        });
        this.capabilities = LazyKt.lazy(new Function0<int[]>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$capabilities$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final int[] invoke() {
                int[] iArr = (int[]) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
                return iArr == null ? new int[0] : iArr;
            }
        });
        this.extensions = LazyKt.lazy(new Function0<List<? extends Integer>>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$extensions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Integer> invoke() {
                List<? extends Integer> supportedExtensions;
                supportedExtensions = CameraDeviceDetails.this.getSupportedExtensions();
                return supportedExtensions;
            }
        });
        this.isMultiCam = LazyKt.lazy(new Function0<Boolean>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$isMultiCam$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                int[] capabilities = CameraDeviceDetails.this.getCapabilities();
                Intrinsics.checkNotNullExpressionValue(capabilities, "capabilities");
                return Boolean.valueOf(ArraysKt.contains(capabilities, 11));
            }
        });
        this.supportsDepthCapture = LazyKt.lazy(new Function0<Boolean>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$supportsDepthCapture$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                int[] capabilities = CameraDeviceDetails.this.getCapabilities();
                Intrinsics.checkNotNullExpressionValue(capabilities, "capabilities");
                return Boolean.valueOf(ArraysKt.contains(capabilities, 8));
            }
        });
        this.supportsRawCapture = LazyKt.lazy(new Function0<Boolean>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$supportsRawCapture$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                int[] capabilities = CameraDeviceDetails.this.getCapabilities();
                Intrinsics.checkNotNullExpressionValue(capabilities, "capabilities");
                return Boolean.valueOf(ArraysKt.contains(capabilities, 3));
            }
        });
        this.supportsLowLightBoost = LazyKt.lazy(new Function0<Boolean>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$supportsLowLightBoost$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(CameraDeviceDetails.this.getExtensions().contains(4) && CameraDeviceDetails.this.getModes().contains(2));
            }
        });
        this.lensFacing = LazyKt.lazy(new Function0<LensFacing>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$lensFacing$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LensFacing invoke() {
                LensFacing.Companion companion = LensFacing.INSTANCE;
                CameraCharacteristics characteristics = CameraDeviceDetails.this.getCharacteristics();
                Intrinsics.checkNotNullExpressionValue(characteristics, "characteristics");
                return companion.fromCameraCharacteristics(characteristics);
            }
        });
        this.hasFlash = LazyKt.lazy(new Function0<Boolean>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$hasFlash$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Boolean bool = (Boolean) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
                if (bool == null) {
                    return false;
                }
                return bool;
            }
        });
        this.focalLengths = LazyKt.lazy(new Function0<float[]>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$focalLengths$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final float[] invoke() {
                float[] fArr = (float[]) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
                return fArr == null ? new float[]{35.0f} : fArr;
            }
        });
        this.sensorSize = LazyKt.lazy(new Function0<SizeF>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$sensorSize$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SizeF invoke() {
                SizeF sizeF = (SizeF) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
                return sizeF == null ? new SizeF(0.0f, 0.0f) : sizeF;
            }
        });
        this.sensorOrientation = LazyKt.lazy(new Function0<Orientation>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$sensorOrientation$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Orientation invoke() {
                int i = (Integer) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.SENSOR_ORIENTATION);
                if (i == null) {
                    i = 0;
                }
                return Orientation.INSTANCE.fromRotationDegrees(i.intValue());
            }
        });
        this.minFocusDistance = LazyKt.lazy(new Function0<Double>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$minFocusDistance$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Double invoke() {
                double minFocusDistanceCm;
                minFocusDistanceCm = CameraDeviceDetails.this.getMinFocusDistanceCm();
                return Double.valueOf(minFocusDistanceCm);
            }
        });
        this.name = LazyKt.lazy(new Function0<String>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$name$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str;
                CameraCharacteristics.Key key;
                if (Build.VERSION.SDK_INT >= 28) {
                    CameraCharacteristics characteristics = CameraDeviceDetails.this.getCharacteristics();
                    key = CameraCharacteristics.INFO_VERSION;
                    str = (String) characteristics.get(key);
                } else {
                    str = null;
                }
                if (str != null) {
                    return str;
                }
                return CameraDeviceDetails.this.getLensFacing() + " (" + CameraDeviceDetails.this.getCameraId() + ")";
            }
        });
        this.maxDigitalZoom = LazyKt.lazy(new Function0<Float>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$maxDigitalZoom$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Float f = (Float) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
                return f == null ? Float.valueOf(1.0f) : f;
            }
        });
        this.zoomRange = LazyKt.lazy(new Function0<Range<Float>>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$zoomRange$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Range<Float> invoke() {
                Range<Float> range;
                CameraCharacteristics.Key key;
                if (Build.VERSION.SDK_INT >= 30) {
                    CameraCharacteristics characteristics = CameraDeviceDetails.this.getCharacteristics();
                    key = CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE;
                    range = (Range) characteristics.get(key);
                } else {
                    range = null;
                }
                return range == null ? new Range<>(Float.valueOf(1.0f), CameraDeviceDetails.this.getMaxDigitalZoom()) : range;
            }
        });
        this.physicalDevices = LazyKt.lazy(new Function0<Set<? extends String>>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$physicalDevices$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends String> invoke() {
                Set physicalCameraIds;
                Set<? extends String> physicalCameraIds2;
                if (Build.VERSION.SDK_INT >= 28) {
                    physicalCameraIds = CameraDeviceDetails.this.getCharacteristics().getPhysicalCameraIds();
                    Intrinsics.checkNotNullExpressionValue(physicalCameraIds, "characteristics.physicalCameraIds");
                    if (!physicalCameraIds.isEmpty()) {
                        physicalCameraIds2 = CameraDeviceDetails.this.getCharacteristics().getPhysicalCameraIds();
                        Intrinsics.checkNotNullExpressionValue(physicalCameraIds2, "{\n      characteristics.physicalCameraIds\n    }");
                        return physicalCameraIds2;
                    }
                }
                return SetsKt.setOf(CameraDeviceDetails.this.getCameraId());
            }
        });
        this.minZoom = LazyKt.lazy(new Function0<Double>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$minZoom$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Double invoke() {
                return Double.valueOf(CameraDeviceDetails.this.getZoomRange().getLower().floatValue());
            }
        });
        this.maxZoom = LazyKt.lazy(new Function0<Double>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$maxZoom$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Double invoke() {
                return Double.valueOf(CameraDeviceDetails.this.getZoomRange().getUpper().floatValue());
            }
        });
        this.cameraConfig = LazyKt.lazy(new Function0<StreamConfigurationMap>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$cameraConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final StreamConfigurationMap invoke() {
                Object obj = CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                Intrinsics.checkNotNull(obj);
                return (StreamConfigurationMap) obj;
            }
        });
        this.isoRange = LazyKt.lazy(new Function0<Range<Integer>>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$isoRange$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Range<Integer> invoke() {
                Range<Integer> range = (Range) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE);
                return range == null ? new Range<>((Comparable) 0, (Comparable) 0) : range;
            }
        });
        this.exposureRange = LazyKt.lazy(new Function0<Range<Integer>>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$exposureRange$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Range<Integer> invoke() {
                Range<Integer> range = (Range) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
                return range == null ? new Range<>((Comparable) 0, (Comparable) 0) : range;
            }
        });
        this.digitalStabilizationModes = LazyKt.lazy(new Function0<int[]>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$digitalStabilizationModes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final int[] invoke() {
                int[] iArr = (int[]) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
                return iArr == null ? new int[0] : iArr;
            }
        });
        this.opticalStabilizationModes = LazyKt.lazy(new Function0<int[]>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$opticalStabilizationModes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final int[] invoke() {
                int[] iArr = (int[]) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
                return iArr == null ? new int[0] : iArr;
            }
        });
        this.supportsPhotoHdr = LazyKt.lazy(new Function0<Boolean>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$supportsPhotoHdr$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(CameraDeviceDetails.this.getExtensions().contains(3));
            }
        });
        this.supportsVideoHdr = LazyKt.lazy(new Function0<Boolean>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$supportsVideoHdr$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean hasVideoHdr;
                hasVideoHdr = CameraDeviceDetails.this.getHasVideoHdr();
                return Boolean.valueOf(hasVideoHdr);
            }
        });
        this.autoFocusSystem = LazyKt.lazy(new Function0<AutoFocusSystem>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$autoFocusSystem$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AutoFocusSystem invoke() {
                AutoFocusSystem autoFocusSystemMode;
                autoFocusSystemMode = CameraDeviceDetails.this.getAutoFocusSystemMode();
                return autoFocusSystemMode;
            }
        });
        this.supportsYuvProcessing = LazyKt.lazy(new Function0<Boolean>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$supportsYuvProcessing$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                int[] capabilities = CameraDeviceDetails.this.getCapabilities();
                Intrinsics.checkNotNullExpressionValue(capabilities, "capabilities");
                return Boolean.valueOf(ArraysKt.contains(capabilities, 7));
            }
        });
        this.supportsPrivateProcessing = LazyKt.lazy(new Function0<Boolean>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$supportsPrivateProcessing$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                int[] capabilities = CameraDeviceDetails.this.getCapabilities();
                Intrinsics.checkNotNullExpressionValue(capabilities, "capabilities");
                return Boolean.valueOf(ArraysKt.contains(capabilities, 4));
            }
        });
        this.supportsZsl = LazyKt.lazy(new Function0<Boolean>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$supportsZsl$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(CameraDeviceDetails.this.getSupportsYuvProcessing() || CameraDeviceDetails.this.getSupportsPrivateProcessing());
            }
        });
        this.isBackwardsCompatible = LazyKt.lazy(new Function0<Boolean>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$isBackwardsCompatible$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                int[] capabilities = CameraDeviceDetails.this.getCapabilities();
                Intrinsics.checkNotNullExpressionValue(capabilities, "capabilities");
                return Boolean.valueOf(ArraysKt.contains(capabilities, 0));
            }
        });
        this.supportsSnapshotCapture = LazyKt.lazy(new Function0<Boolean>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$supportsSnapshotCapture$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean supportsSnapshotCapture;
                supportsSnapshotCapture = CameraDeviceDetails.this.supportsSnapshotCapture();
                return Boolean.valueOf(supportsSnapshotCapture);
            }
        });
        this.supportsFocusRegions = LazyKt.lazy(new Function0<Boolean>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$supportsFocusRegions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                int i = (Integer) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
                if (i == null) {
                    i = 0;
                }
                return Boolean.valueOf(i.intValue() > 0);
            }
        });
        this.supportsExposureRegions = LazyKt.lazy(new Function0<Boolean>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$supportsExposureRegions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                int i = (Integer) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
                if (i == null) {
                    i = 0;
                }
                return Boolean.valueOf(i.intValue() > 0);
            }
        });
        this.supportsWhiteBalanceRegions = LazyKt.lazy(new Function0<Boolean>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$supportsWhiteBalanceRegions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                int i = (Integer) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
                if (i == null) {
                    i = 0;
                }
                return Boolean.valueOf(i.intValue() > 0);
            }
        });
        this.modes = LazyKt.lazy(new Function0<List<? extends Integer>>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$modes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Integer> invoke() {
                List<Integer> list;
                int[] iArr = (int[]) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.CONTROL_AVAILABLE_MODES);
                return (iArr == null || (list = ArraysKt.toList(iArr)) == null) ? CollectionsKt.emptyList() : list;
            }
        });
        this.afModes = LazyKt.lazy(new Function0<List<? extends Integer>>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$afModes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Integer> invoke() {
                List<Integer> list;
                int[] iArr = (int[]) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
                return (iArr == null || (list = ArraysKt.toList(iArr)) == null) ? CollectionsKt.emptyList() : list;
            }
        });
        this.aeModes = LazyKt.lazy(new Function0<List<? extends Integer>>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$aeModes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Integer> invoke() {
                List<Integer> list;
                int[] iArr = (int[]) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
                return (iArr == null || (list = ArraysKt.toList(iArr)) == null) ? CollectionsKt.emptyList() : list;
            }
        });
        this.awbModes = LazyKt.lazy(new Function0<List<? extends Integer>>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$awbModes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Integer> invoke() {
                List<Integer> list;
                int[] iArr = (int[]) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
                return (iArr == null || (list = ArraysKt.toList(iArr)) == null) ? CollectionsKt.emptyList() : list;
            }
        });
        this.availableAberrationModes = LazyKt.lazy(new Function0<int[]>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$availableAberrationModes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final int[] invoke() {
                int[] iArr = (int[]) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.COLOR_CORRECTION_AVAILABLE_ABERRATION_MODES);
                return iArr == null ? new int[0] : iArr;
            }
        });
        this.availableHotPixelModes = LazyKt.lazy(new Function0<int[]>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$availableHotPixelModes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final int[] invoke() {
                int[] iArr = (int[]) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.HOT_PIXEL_AVAILABLE_HOT_PIXEL_MODES);
                return iArr == null ? new int[0] : iArr;
            }
        });
        this.availableEdgeModes = LazyKt.lazy(new Function0<int[]>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$availableEdgeModes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final int[] invoke() {
                int[] iArr = (int[]) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.EDGE_AVAILABLE_EDGE_MODES);
                return iArr == null ? new int[0] : iArr;
            }
        });
        this.availableDistortionCorrectionModes = LazyKt.lazy(new Function0<int[]>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$availableDistortionCorrectionModes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final int[] invoke() {
                int[] availableDistortionCorrectionModesOrEmptyArray;
                availableDistortionCorrectionModesOrEmptyArray = CameraDeviceDetails.this.getAvailableDistortionCorrectionModesOrEmptyArray();
                return availableDistortionCorrectionModesOrEmptyArray;
            }
        });
        this.availableShadingModes = LazyKt.lazy(new Function0<int[]>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$availableShadingModes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final int[] invoke() {
                int[] iArr = (int[]) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.SHADING_AVAILABLE_MODES);
                return iArr == null ? new int[0] : iArr;
            }
        });
        this.availableToneMapModes = LazyKt.lazy(new Function0<int[]>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$availableToneMapModes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final int[] invoke() {
                int[] iArr = (int[]) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.TONEMAP_AVAILABLE_TONE_MAP_MODES);
                return iArr == null ? new int[0] : iArr;
            }
        });
        this.availableNoiseReductionModes = LazyKt.lazy(new Function0<int[]>() { // from class: com.mrousavy.camera.core.CameraDeviceDetails$availableNoiseReductionModes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final int[] invoke() {
                int[] iArr = (int[]) CameraDeviceDetails.this.getCharacteristics().get(CameraCharacteristics.NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES);
                return iArr == null ? new int[0] : iArr;
            }
        });
        this.videoFormat = 35;
        this.photoFormat = 256;
    }

    public final String getCameraId() {
        return this.cameraId;
    }

    public final CameraCharacteristics getCharacteristics() {
        return (CameraCharacteristics) this.characteristics.getValue();
    }

    public final HardwareLevel getHardwareLevel() {
        return (HardwareLevel) this.hardwareLevel.getValue();
    }

    public final int[] getCapabilities() {
        return (int[]) this.capabilities.getValue();
    }

    public final List<Integer> getExtensions() {
        return (List) this.extensions.getValue();
    }

    public final boolean isMultiCam() {
        return ((Boolean) this.isMultiCam.getValue()).booleanValue();
    }

    public final boolean getSupportsDepthCapture() {
        return ((Boolean) this.supportsDepthCapture.getValue()).booleanValue();
    }

    public final boolean getSupportsRawCapture() {
        return ((Boolean) this.supportsRawCapture.getValue()).booleanValue();
    }

    public final boolean getSupportsLowLightBoost() {
        return ((Boolean) this.supportsLowLightBoost.getValue()).booleanValue();
    }

    public final LensFacing getLensFacing() {
        return (LensFacing) this.lensFacing.getValue();
    }

    public final Boolean getHasFlash() {
        return (Boolean) this.hasFlash.getValue();
    }

    public final float[] getFocalLengths() {
        return (float[]) this.focalLengths.getValue();
    }

    public final SizeF getSensorSize() {
        return (SizeF) this.sensorSize.getValue();
    }

    public final Rect getActiveSize() {
        Object obj = getCharacteristics().get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        Intrinsics.checkNotNull(obj);
        return (Rect) obj;
    }

    public final Orientation getSensorOrientation() {
        return (Orientation) this.sensorOrientation.getValue();
    }

    public final double getMinFocusDistance() {
        return ((Number) this.minFocusDistance.getValue()).doubleValue();
    }

    public final String getName() {
        return (String) this.name.getValue();
    }

    public final Float getMaxDigitalZoom() {
        return (Float) this.maxDigitalZoom.getValue();
    }

    public final Range<Float> getZoomRange() {
        return (Range) this.zoomRange.getValue();
    }

    public final Set<String> getPhysicalDevices() {
        return (Set) this.physicalDevices.getValue();
    }

    public final double getMinZoom() {
        return ((Number) this.minZoom.getValue()).doubleValue();
    }

    public final double getMaxZoom() {
        return ((Number) this.maxZoom.getValue()).doubleValue();
    }

    public final StreamConfigurationMap getCameraConfig() {
        return (StreamConfigurationMap) this.cameraConfig.getValue();
    }

    public final Range<Integer> getIsoRange() {
        return (Range) this.isoRange.getValue();
    }

    public final Range<Integer> getExposureRange() {
        return (Range) this.exposureRange.getValue();
    }

    public final int[] getDigitalStabilizationModes() {
        return (int[]) this.digitalStabilizationModes.getValue();
    }

    public final int[] getOpticalStabilizationModes() {
        return (int[]) this.opticalStabilizationModes.getValue();
    }

    public final boolean getSupportsPhotoHdr() {
        return ((Boolean) this.supportsPhotoHdr.getValue()).booleanValue();
    }

    public final boolean getSupportsVideoHdr() {
        return ((Boolean) this.supportsVideoHdr.getValue()).booleanValue();
    }

    public final AutoFocusSystem getAutoFocusSystem() {
        return (AutoFocusSystem) this.autoFocusSystem.getValue();
    }

    public final boolean getSupportsYuvProcessing() {
        return ((Boolean) this.supportsYuvProcessing.getValue()).booleanValue();
    }

    public final boolean getSupportsPrivateProcessing() {
        return ((Boolean) this.supportsPrivateProcessing.getValue()).booleanValue();
    }

    public final boolean getSupportsZsl() {
        return ((Boolean) this.supportsZsl.getValue()).booleanValue();
    }

    public final boolean isBackwardsCompatible() {
        return ((Boolean) this.isBackwardsCompatible.getValue()).booleanValue();
    }

    public final boolean getSupportsSnapshotCapture() {
        return ((Boolean) this.supportsSnapshotCapture.getValue()).booleanValue();
    }

    public final boolean getSupportsFocusRegions() {
        return ((Boolean) this.supportsFocusRegions.getValue()).booleanValue();
    }

    public final boolean getSupportsExposureRegions() {
        return ((Boolean) this.supportsExposureRegions.getValue()).booleanValue();
    }

    public final boolean getSupportsWhiteBalanceRegions() {
        return ((Boolean) this.supportsWhiteBalanceRegions.getValue()).booleanValue();
    }

    public final List<Integer> getModes() {
        return (List) this.modes.getValue();
    }

    public final List<Integer> getAfModes() {
        return (List) this.afModes.getValue();
    }

    public final List<Integer> getAeModes() {
        return (List) this.aeModes.getValue();
    }

    public final List<Integer> getAwbModes() {
        return (List) this.awbModes.getValue();
    }

    public final int[] getAvailableAberrationModes() {
        return (int[]) this.availableAberrationModes.getValue();
    }

    public final int[] getAvailableHotPixelModes() {
        return (int[]) this.availableHotPixelModes.getValue();
    }

    public final int[] getAvailableEdgeModes() {
        return (int[]) this.availableEdgeModes.getValue();
    }

    public final int[] getAvailableDistortionCorrectionModes() {
        return (int[]) this.availableDistortionCorrectionModes.getValue();
    }

    public final int[] getAvailableShadingModes() {
        return (int[]) this.availableShadingModes.getValue();
    }

    public final int[] getAvailableToneMapModes() {
        return (int[]) this.availableToneMapModes.getValue();
    }

    public final int[] getAvailableNoiseReductionModes() {
        return (int[]) this.availableNoiseReductionModes.getValue();
    }

    public final int getVideoFormat() {
        return this.videoFormat;
    }

    public final int getPhotoFormat() {
        return this.photoFormat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Integer> getSupportedExtensions() {
        CameraExtensionCharacteristics cameraExtensionCharacteristics;
        List<Integer> supportedExtensions;
        if (Build.VERSION.SDK_INT >= 31) {
            cameraExtensionCharacteristics = this.cameraManager.getCameraExtensionCharacteristics(this.cameraId);
            Intrinsics.checkNotNullExpressionValue(cameraExtensionCharacteristics, "cameraManager.getCameraE…Characteristics(cameraId)");
            supportedExtensions = cameraExtensionCharacteristics.getSupportedExtensions();
            Intrinsics.checkNotNullExpressionValue(supportedExtensions, "{\n      val extensions =…supportedExtensions\n    }");
            return supportedExtensions;
        }
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] getAvailableDistortionCorrectionModesOrEmptyArray() {
        CameraCharacteristics.Key key;
        if (Build.VERSION.SDK_INT < 28) {
            return new int[0];
        }
        CameraCharacteristics characteristics = getCharacteristics();
        key = CameraCharacteristics.DISTORTION_CORRECTION_AVAILABLE_MODES;
        int[] iArr = (int[]) characteristics.get(key);
        return iArr == null ? new int[0] : iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasVideoHdr() {
        CameraCharacteristics.Key key;
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        int[] capabilities = getCapabilities();
        Intrinsics.checkNotNullExpressionValue(capabilities, "capabilities");
        if (!ArraysKt.contains(capabilities, 18)) {
            return false;
        }
        CameraCharacteristics characteristics = getCharacteristics();
        key = CameraCharacteristics.REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE;
        return ((Long) characteristics.get(key)) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double getMinFocusDistanceCm() {
        Float f = (Float) getCharacteristics().get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
        if (f == null || Intrinsics.areEqual(f, 0.0f) || Float.isNaN(f.floatValue()) || Float.isInfinite(f.floatValue())) {
            return 0.0d;
        }
        return (1.0d / f.floatValue()) * 100.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean supportsSnapshotCapture() {
        if (getHardwareLevel() == HardwareLevel.LEGACY) {
            return false;
        }
        return !getSupportsDepthCapture() || isBackwardsCompatible();
    }

    private final ReadableArray createStabilizationModes() {
        WritableArray array = Arguments.createArray();
        int[] digitalStabilizationModes = getDigitalStabilizationModes();
        Intrinsics.checkNotNullExpressionValue(digitalStabilizationModes, "digitalStabilizationModes");
        for (int i : digitalStabilizationModes) {
            array.pushString(VideoStabilizationMode.INSTANCE.fromDigitalVideoStabilizationMode(i).getUnionValue());
        }
        int[] opticalStabilizationModes = getOpticalStabilizationModes();
        Intrinsics.checkNotNullExpressionValue(opticalStabilizationModes, "opticalStabilizationModes");
        for (int i2 : opticalStabilizationModes) {
            array.pushString(VideoStabilizationMode.INSTANCE.fromOpticalVideoStabilizationMode(i2).getUnionValue());
        }
        Intrinsics.checkNotNullExpressionValue(array, "array");
        return array;
    }

    private final List<DeviceType> getDeviceTypes() {
        DeviceType deviceType;
        Set<String> physicalDevices = getPhysicalDevices();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(physicalDevices, 10));
        for (String id : physicalDevices) {
            CameraManager cameraManager = this.cameraManager;
            Intrinsics.checkNotNullExpressionValue(id, "id");
            double maxFieldOfView = new CameraDeviceDetails(cameraManager, id).getMaxFieldOfView();
            if (maxFieldOfView > 94.0d) {
                deviceType = DeviceType.ULTRA_WIDE_ANGLE;
            } else {
                boolean z = false;
                if (60.0d <= maxFieldOfView && maxFieldOfView <= 94.0d) {
                    z = true;
                }
                if (z) {
                    deviceType = DeviceType.WIDE_ANGLE;
                } else if (maxFieldOfView < 60.0d) {
                    deviceType = DeviceType.TELEPHOTO;
                } else {
                    throw new Error("Invalid Field Of View! (" + maxFieldOfView + ")");
                }
            }
            arrayList.add(deviceType);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AutoFocusSystem getAutoFocusSystemMode() {
        int[] iArr = (int[]) getCharacteristics().get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        boolean z = false;
        if (iArr != null && ArraysKt.contains(iArr, 1)) {
            z = true;
        }
        if (!z) {
            return AutoFocusSystem.NONE;
        }
        Integer num = (Integer) getCharacteristics().get(CameraCharacteristics.LENS_INFO_FOCUS_DISTANCE_CALIBRATION);
        return (num != null && num.intValue() == 2) ? AutoFocusSystem.PHASE_DETECTION : AutoFocusSystem.CONTRAST_DETECTION;
    }

    private final double getFieldOfView(float focalLength) {
        if (getSensorSize().getWidth() == 0.0f) {
            return 0.0d;
        }
        if (getSensorSize().getHeight() == 0.0f) {
            return 0.0d;
        }
        return Math.toDegrees(Math.atan2(Math.sqrt((getSensorSize().getWidth() * getSensorSize().getWidth()) + (getSensorSize().getHeight() * getSensorSize().getHeight())), focalLength * 2.0d) * 2.0d);
    }

    private final double getMaxFieldOfView() {
        float[] focalLengths = getFocalLengths();
        Intrinsics.checkNotNullExpressionValue(focalLengths, "focalLengths");
        Float minOrNull = ArraysKt.minOrNull(focalLengths);
        if (minOrNull != null) {
            return getFieldOfView(minOrNull.floatValue());
        }
        return 0.0d;
    }

    public final List<Size> getVideoSizes(int format) {
        CameraCharacteristics characteristics = getCharacteristics();
        Intrinsics.checkNotNullExpressionValue(characteristics, "characteristics");
        return CameraCharacteristics_getOutputSizesKt.getVideoSizes(characteristics, this.cameraId, format);
    }

    public final List<Size> getPhotoSizes() {
        CameraCharacteristics characteristics = getCharacteristics();
        Intrinsics.checkNotNullExpressionValue(characteristics, "characteristics");
        return CameraCharacteristics_getOutputSizesKt.getPhotoSizes(characteristics, this.photoFormat);
    }

    public final List<Size> getPreviewSizes() {
        Size maximumPreviewSize = INSTANCE.getMaximumPreviewSize();
        Size[] outputSizes = getCameraConfig().getOutputSizes(SurfaceHolder.class);
        Intrinsics.checkNotNullExpressionValue(outputSizes, "cameraConfig.getOutputSi…urfaceHolder::class.java)");
        ArrayList arrayList = new ArrayList();
        for (Size size : outputSizes) {
            Size it = size;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (Size_ExtensionsKt.getBigger(it) <= Size_ExtensionsKt.getBigger(maximumPreviewSize) && Size_ExtensionsKt.getSmaller(it) <= Size_ExtensionsKt.getSmaller(maximumPreviewSize)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    private final ReadableArray getFormats() {
        WritableArray array = Arguments.createArray();
        List<Size> videoSizes = getVideoSizes(this.videoFormat);
        List<Size> photoSizes = getPhotoSizes();
        for (Size size : videoSizes) {
            int outputMinFrameDuration = (int) (1.0d / (getCameraConfig().getOutputMinFrameDuration(this.videoFormat, size) / 1000000000));
            Integer maximumFps = CamcorderProfileUtils.INSTANCE.getMaximumFps(this.cameraId, size);
            if (maximumFps != null && maximumFps.intValue() < outputMinFrameDuration) {
                Log.i(TAG, "Camera could do " + outputMinFrameDuration + " FPS at " + size + ", but Media Encoder can only do " + maximumFps + " FPS. Clamping to " + maximumFps + " FPS...");
                outputMinFrameDuration = maximumFps.intValue();
            }
            Iterator<T> it = photoSizes.iterator();
            while (it.hasNext()) {
                array.pushMap(buildFormatMap((Size) it.next(), size, new Range<>((Comparable) 1, Integer.valueOf(outputMinFrameDuration))));
            }
        }
        Intrinsics.checkNotNullExpressionValue(array, "array");
        return array;
    }

    private final ReadableArray createPixelFormats() {
        WritableArray array = Arguments.createArray();
        array.pushString(PixelFormat.YUV.getUnionValue());
        array.pushString(PixelFormat.NATIVE.getUnionValue());
        Intrinsics.checkNotNullExpressionValue(array, "array");
        return array;
    }

    private final ReadableMap buildFormatMap(Size photoSize, Size videoSize, Range<Integer> fpsRange) {
        WritableMap map = Arguments.createMap();
        map.putInt("photoHeight", photoSize.getHeight());
        map.putInt("photoWidth", photoSize.getWidth());
        map.putInt("videoHeight", videoSize.getHeight());
        map.putInt("videoWidth", videoSize.getWidth());
        Integer lower = getIsoRange().getLower();
        Intrinsics.checkNotNullExpressionValue(lower, "isoRange.lower");
        map.putInt("minISO", lower.intValue());
        Integer upper = getIsoRange().getUpper();
        Intrinsics.checkNotNullExpressionValue(upper, "isoRange.upper");
        map.putInt("maxISO", upper.intValue());
        Integer lower2 = fpsRange.getLower();
        Intrinsics.checkNotNullExpressionValue(lower2, "fpsRange.lower");
        map.putInt("minFps", lower2.intValue());
        Integer upper2 = fpsRange.getUpper();
        Intrinsics.checkNotNullExpressionValue(upper2, "fpsRange.upper");
        map.putInt("maxFps", upper2.intValue());
        map.putDouble("maxZoom", getMaxZoom());
        map.putDouble("fieldOfView", getMaxFieldOfView());
        map.putBoolean("supportsVideoHdr", getSupportsVideoHdr());
        map.putBoolean("supportsPhotoHdr", getSupportsPhotoHdr());
        map.putBoolean("supportsDepthCapture", getSupportsDepthCapture());
        map.putString("autoFocusSystem", getAutoFocusSystem().getUnionValue());
        map.putArray("videoStabilizationModes", createStabilizationModes());
        map.putArray("pixelFormats", createPixelFormats());
        Intrinsics.checkNotNullExpressionValue(map, "map");
        return map;
    }

    public final ReadableMap toMap() {
        List<DeviceType> deviceTypes = getDeviceTypes();
        WritableMap map = Arguments.createMap();
        map.putString("id", this.cameraId);
        map.putArray("physicalDevices", List_toJSValueKt.toJSValue(deviceTypes));
        map.putString(ViewProps.POSITION, getLensFacing().getUnionValue());
        map.putString("name", getName());
        Boolean hasFlash = getHasFlash();
        Intrinsics.checkNotNullExpressionValue(hasFlash, "hasFlash");
        map.putBoolean("hasFlash", hasFlash.booleanValue());
        Boolean hasFlash2 = getHasFlash();
        Intrinsics.checkNotNullExpressionValue(hasFlash2, "hasFlash");
        map.putBoolean("hasTorch", hasFlash2.booleanValue());
        map.putDouble("minFocusDistance", getMinFocusDistance());
        map.putBoolean("isMultiCam", isMultiCam());
        map.putBoolean("supportsRawCapture", getSupportsRawCapture());
        map.putBoolean("supportsLowLightBoost", getSupportsLowLightBoost());
        map.putBoolean("supportsFocus", getSupportsFocusRegions());
        map.putDouble("minZoom", getMinZoom());
        map.putDouble("maxZoom", getMaxZoom());
        map.putDouble("neutralZoom", 1.0d);
        map.putDouble("minExposure", getExposureRange().getLower().intValue());
        map.putDouble("maxExposure", getExposureRange().getUpper().intValue());
        map.putString("hardwareLevel", getHardwareLevel().getUnionValue());
        map.putString("sensorOrientation", getSensorOrientation().getUnionValue());
        map.putArray("formats", getFormats());
        Intrinsics.checkNotNullExpressionValue(map, "map");
        return map;
    }
}
