package expo.modules.av;

/* loaded from: classes5.dex */
public interface AudioEventHandler {
    void handleAudioFocusGained();

    void handleAudioFocusInterruptionBegan();

    void onPause();

    void onResume();

    void pauseImmediately();

    boolean requiresAudioFocus();

    void updateVolumeMuteAndDuck();
}
