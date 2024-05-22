package expo.modules;

import expo.modules.adapters.react.ReactAdapterPackage;
import expo.modules.av.AVModule;
import expo.modules.av.AVPackage;
import expo.modules.av.video.VideoViewModule;
import expo.modules.constants.ConstantsModule;
import expo.modules.constants.ConstantsPackage;
import expo.modules.core.BasePackage;
import expo.modules.core.interfaces.Package;
import expo.modules.crypto.CryptoModule;
import expo.modules.documentpicker.DocumentPickerModule;
import expo.modules.filesystem.FileSystemModule;
import expo.modules.filesystem.FileSystemPackage;
import expo.modules.font.FontLoaderModule;
import expo.modules.imageloader.ImageLoaderPackage;
import expo.modules.imagepicker.ImagePickerModule;
import expo.modules.inapppurchases.InAppPurchasesPackage;
import expo.modules.keepawake.KeepAwakeModule;
import expo.modules.keepawake.KeepAwakePackage;
import expo.modules.kotlin.ModulesProvider;
import expo.modules.kotlin.modules.Module;
import expo.modules.location.LocationModule;
import expo.modules.screenorientation.ScreenOrientationModule;
import expo.modules.sensors.SensorsPackage;
import expo.modules.sensors.modules.AccelerometerModule;
import expo.modules.sensors.modules.BarometerModule;
import expo.modules.sensors.modules.DeviceMotionModule;
import expo.modules.sensors.modules.GyroscopeModule;
import expo.modules.sensors.modules.LightSensorModule;
import expo.modules.sensors.modules.MagnetometerModule;
import expo.modules.sensors.modules.MagnetometerUncalibratedModule;
import expo.modules.sensors.modules.PedometerModule;
import expo.modules.sms.SMSModule;
import expo.modules.speech.SpeechModule;
import expo.modules.splashscreen.SplashScreenModule;
import expo.modules.splashscreen.SplashScreenPackage;
import expo.modules.trackingtransparency.TrackingTransparencyModule;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public class ExpoModulesPackageList implements ModulesProvider {

    /* loaded from: classes5.dex */
    private static class LazyHolder {
        static final List<Package> packagesList = Arrays.asList(new ReactAdapterPackage(), new AVPackage(), new ConstantsPackage(), new BasePackage(), new FileSystemPackage(), new ImageLoaderPackage(), new InAppPurchasesPackage(), new KeepAwakePackage(), new SensorsPackage(), new SplashScreenPackage());
        static final List<Class<? extends Module>> modulesList = Arrays.asList(VideoViewModule.class, AVModule.class, ConstantsModule.class, CryptoModule.class, DocumentPickerModule.class, FileSystemModule.class, FontLoaderModule.class, ImagePickerModule.class, KeepAwakeModule.class, LocationModule.class, ScreenOrientationModule.class, AccelerometerModule.class, BarometerModule.class, GyroscopeModule.class, LightSensorModule.class, DeviceMotionModule.class, MagnetometerModule.class, MagnetometerUncalibratedModule.class, PedometerModule.class, SMSModule.class, SpeechModule.class, SplashScreenModule.class, TrackingTransparencyModule.class);

        private LazyHolder() {
        }
    }

    public static List<Package> getPackageList() {
        return LazyHolder.packagesList;
    }

    @Override // expo.modules.kotlin.ModulesProvider
    public List<Class<? extends Module>> getModulesList() {
        return LazyHolder.modulesList;
    }
}
