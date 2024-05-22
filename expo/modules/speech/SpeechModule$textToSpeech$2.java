package expo.modules.speech;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import expo.modules.speech.SpeechModule;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: SpeechModule.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/speech/tts/TextToSpeech;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
final class SpeechModule$textToSpeech$2 extends Lambda implements Function0<TextToSpeech> {
    final /* synthetic */ SpeechModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeechModule$textToSpeech$2(SpeechModule speechModule) {
        super(0);
        this.this$0 = speechModule;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final TextToSpeech invoke() {
        Context reactContext = this.this$0.getAppContext().getReactContext();
        final SpeechModule speechModule = this.this$0;
        TextToSpeech textToSpeech = new TextToSpeech(reactContext, new TextToSpeech.OnInitListener() { // from class: expo.modules.speech.SpeechModule$textToSpeech$2$$ExternalSyntheticLambda0
            @Override // android.speech.tts.TextToSpeech.OnInitListener
            public final void onInit(int i) {
                SpeechModule$textToSpeech$2.invoke$lambda$1(SpeechModule.this, i);
            }
        });
        this.this$0._textToSpeech = textToSpeech;
        return textToSpeech;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(final SpeechModule this$0, int i) {
        TextToSpeech textToSpeech;
        Queue<SpeechModule.Utterance> queue;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == 0) {
            synchronized (this$0) {
                this$0._ttsReady = true;
                textToSpeech = this$0._textToSpeech;
                Intrinsics.checkNotNull(textToSpeech);
                textToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() { // from class: expo.modules.speech.SpeechModule$textToSpeech$2$newTtsInstance$1$1$1
                    @Override // android.speech.tts.UtteranceProgressListener
                    public void onStart(String utteranceId) {
                        Bundle idToMap;
                        Intrinsics.checkNotNullParameter(utteranceId, "utteranceId");
                        SpeechModule speechModule = SpeechModule.this;
                        idToMap = speechModule.idToMap(utteranceId);
                        speechModule.sendEvent(SpeechModuleKt.speakingStartedEvent, idToMap);
                    }

                    @Override // android.speech.tts.UtteranceProgressListener
                    public void onRangeStart(String utteranceId, int start, int end, int frame) {
                        Intrinsics.checkNotNullParameter(utteranceId, "utteranceId");
                        Bundle bundle = new Bundle();
                        bundle.putString("id", utteranceId);
                        bundle.putInt("charIndex", start);
                        bundle.putInt("charLength", end - start);
                        SpeechModule.this.sendEvent(SpeechModuleKt.speakingWillSayNextStringEvent, bundle);
                    }

                    @Override // android.speech.tts.UtteranceProgressListener
                    public void onDone(String utteranceId) {
                        Bundle idToMap;
                        Intrinsics.checkNotNullParameter(utteranceId, "utteranceId");
                        SpeechModule speechModule = SpeechModule.this;
                        idToMap = speechModule.idToMap(utteranceId);
                        speechModule.sendEvent(SpeechModuleKt.speakingDoneEvent, idToMap);
                    }

                    @Override // android.speech.tts.UtteranceProgressListener
                    public void onStop(String utteranceId, boolean interrupted) {
                        Bundle idToMap;
                        Intrinsics.checkNotNullParameter(utteranceId, "utteranceId");
                        SpeechModule speechModule = SpeechModule.this;
                        idToMap = speechModule.idToMap(utteranceId);
                        speechModule.sendEvent(SpeechModuleKt.speakingStoppedEvent, idToMap);
                    }

                    @Override // android.speech.tts.UtteranceProgressListener
                    public void onError(String utteranceId) {
                        Bundle idToMap;
                        Intrinsics.checkNotNullParameter(utteranceId, "utteranceId");
                        SpeechModule speechModule = SpeechModule.this;
                        idToMap = speechModule.idToMap(utteranceId);
                        speechModule.sendEvent(SpeechModuleKt.speakingErrorEvent, idToMap);
                    }
                });
                queue = this$0.delayedUtterances;
                for (SpeechModule.Utterance utterance : queue) {
                    this$0.speakOut(utterance.getId(), utterance.getText(), utterance.getOptions());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
