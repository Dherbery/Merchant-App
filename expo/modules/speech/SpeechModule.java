package expo.modules.speech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import androidx.tracing.Trace;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.speech.SpeechModule;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: SpeechModule.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lexpo/modules/speech/SpeechModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "_textToSpeech", "Landroid/speech/tts/TextToSpeech;", "_ttsReady", "", "delayedUtterances", "Ljava/util/Queue;", "Lexpo/modules/speech/SpeechModule$Utterance;", "isTextToSpeechReady", "()Z", "textToSpeech", "getTextToSpeech", "()Landroid/speech/tts/TextToSpeech;", "textToSpeech$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "idToMap", "Landroid/os/Bundle;", "id", "", "speakOut", "", "text", "options", "Lexpo/modules/speech/SpeechOptions;", "Utterance", "expo-speech_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpeechModule extends Module {
    private TextToSpeech _textToSpeech;
    private boolean _ttsReady;
    private final Queue<Utterance> delayedUtterances = new ArrayDeque();

    /* renamed from: textToSpeech$delegate, reason: from kotlin metadata */
    private final Lazy textToSpeech = LazyKt.lazy(new SpeechModule$textToSpeech$2(this));

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        SpeechModule speechModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (speechModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(speechModule);
            moduleDefinitionBuilder.Name("ExpoSpeech");
            moduleDefinitionBuilder.Events(SpeechModuleKt.speakingStartedEvent, SpeechModuleKt.speakingWillSayNextStringEvent, SpeechModuleKt.speakingDoneEvent, SpeechModuleKt.speakingStoppedEvent, SpeechModuleKt.speakingErrorEvent);
            moduleDefinitionBuilder.Constants(TuplesKt.to("maxSpeechInputLength", Integer.valueOf(TextToSpeech.getMaxSpeechInputLength())));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_DESTROYS, new BasicEventListener(EventName.ACTIVITY_DESTROYS, new Function0<Unit>() { // from class: expo.modules.speech.SpeechModule$definition$lambda$6$$inlined$OnActivityDestroys$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    TextToSpeech textToSpeech;
                    textToSpeech = SpeechModule.this.getTextToSpeech();
                    textToSpeech.shutdown();
                }
            }));
            AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("isSpeaking", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.speech.SpeechModule$definition$lambda$6$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    TextToSpeech textToSpeech;
                    Intrinsics.checkNotNullParameter(it, "it");
                    textToSpeech = SpeechModule.this.getTextToSpeech();
                    return Boolean.valueOf(textToSpeech.isSpeaking());
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("isSpeaking", asyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionComponent;
            AsyncFunctionComponent asyncFunctionComponent3 = new AsyncFunctionComponent("getVoices", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.speech.SpeechModule$definition$lambda$6$$inlined$AsyncFunctionWithoutArgs$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    List emptyList;
                    VoiceQuality voiceQuality;
                    TextToSpeech textToSpeech;
                    Intrinsics.checkNotNullParameter(it, "it");
                    try {
                        textToSpeech = SpeechModule.this.getTextToSpeech();
                        Set<Voice> voices = textToSpeech.getVoices();
                        Intrinsics.checkNotNullExpressionValue(voices, "textToSpeech.voices");
                        emptyList = CollectionsKt.toList(voices);
                    } catch (Exception unused) {
                        emptyList = CollectionsKt.emptyList();
                    }
                    List<Voice> list = emptyList;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (Voice voice : list) {
                        if (voice.getQuality() > 300) {
                            voiceQuality = VoiceQuality.ENHANCED;
                        } else {
                            voiceQuality = VoiceQuality.DEFAULT;
                        }
                        String name = voice.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "it.name");
                        String name2 = voice.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "it.name");
                        LanguageUtils languageUtils = LanguageUtils.INSTANCE;
                        Locale locale = voice.getLocale();
                        Intrinsics.checkNotNullExpressionValue(locale, "it.locale");
                        arrayList.add(new VoiceRecord(name, name2, voiceQuality, languageUtils.getISOCode(locale)));
                    }
                    return arrayList;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getVoices", asyncFunctionComponent3);
            AsyncFunctionComponent asyncFunctionComponent4 = asyncFunctionComponent3;
            AsyncFunctionComponent asyncFunctionComponent5 = new AsyncFunctionComponent("stop", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.speech.SpeechModule$definition$lambda$6$$inlined$AsyncFunctionWithoutArgs$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    TextToSpeech textToSpeech;
                    Intrinsics.checkNotNullParameter(it, "it");
                    textToSpeech = SpeechModule.this.getTextToSpeech();
                    return Integer.valueOf(textToSpeech.stop());
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("stop", asyncFunctionComponent5);
            AsyncFunctionComponent asyncFunctionComponent6 = asyncFunctionComponent5;
            moduleDefinitionBuilder.getAsyncFunctions().put("speak", SpeechOptions.class == Promise.class ? new AsyncFunctionWithPromiseComponent("speak", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.speech.SpeechModule$definition$lambda$6$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.speech.SpeechModule$definition$lambda$6$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.speech.SpeechModule$definition$lambda$6$$inlined$AsyncFunction$3
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    boolean z;
                    Queue queue;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = args[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str2 = (String) obj2;
                    SpeechOptions speechOptions = (SpeechOptions) promise;
                    if (str2.length() <= TextToSpeech.getMaxSpeechInputLength()) {
                        z = SpeechModule.this.get_ttsReady();
                        if (z) {
                            SpeechModule.this.speakOut(str, str2, speechOptions);
                            return;
                        }
                        queue = SpeechModule.this.delayedUtterances;
                        queue.add(new SpeechModule.Utterance(str, str2, speechOptions));
                        SpeechModule.this.getTextToSpeech();
                        return;
                    }
                    throw new SpeechInputIsToLongException();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("speak", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.speech.SpeechModule$definition$lambda$6$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.speech.SpeechModule$definition$lambda$6$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SpeechOptions.class), false, new Function0<KType>() { // from class: expo.modules.speech.SpeechModule$definition$lambda$6$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SpeechOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.speech.SpeechModule$definition$lambda$6$$inlined$AsyncFunction$7
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    boolean z;
                    Queue queue;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str2 = (String) obj2;
                    Object obj3 = it[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.speech.SpeechOptions");
                    }
                    SpeechOptions speechOptions = (SpeechOptions) obj3;
                    if (str2.length() <= TextToSpeech.getMaxSpeechInputLength()) {
                        z = SpeechModule.this.get_ttsReady();
                        if (z) {
                            SpeechModule.this.speakOut(str, str2, speechOptions);
                        } else {
                            queue = SpeechModule.this.delayedUtterances;
                            queue.add(new SpeechModule.Utterance(str, str2, speechOptions));
                            SpeechModule.this.getTextToSpeech();
                        }
                        return Unit.INSTANCE;
                    }
                    throw new SpeechInputIsToLongException();
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
    
        if (r2 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void speakOut(java.lang.String r5, java.lang.String r6, expo.modules.speech.SpeechOptions r7) {
        /*
            r4 = this;
            java.lang.Float r0 = r7.getPitch()
            if (r0 == 0) goto L13
            android.speech.tts.TextToSpeech r1 = r4.getTextToSpeech()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            r1.setPitch(r0)
        L13:
            java.lang.Float r0 = r7.getRate()
            if (r0 == 0) goto L26
            android.speech.tts.TextToSpeech r1 = r4.getTextToSpeech()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            r1.setSpeechRate(r0)
        L26:
            android.speech.tts.TextToSpeech r0 = r4.getTextToSpeech()
            java.lang.String r1 = r7.getLanguage()
            if (r1 == 0) goto L4a
            java.util.Locale r2 = new java.util.Locale
            r2.<init>(r1)
            android.speech.tts.TextToSpeech r1 = r4.getTextToSpeech()
            int r1 = r1.isLanguageAvailable(r2)
            r3 = -1
            if (r1 == r3) goto L44
            r3 = -2
            if (r1 == r3) goto L44
            goto L48
        L44:
            java.util.Locale r2 = java.util.Locale.getDefault()
        L48:
            if (r2 != 0) goto L4e
        L4a:
            java.util.Locale r2 = java.util.Locale.getDefault()
        L4e:
            r0.setLanguage(r2)
            java.lang.String r7 = r7.getVoice()
            r0 = 0
            if (r7 == 0) goto L8f
            android.speech.tts.TextToSpeech r1 = r4.getTextToSpeech()
            java.util.Set r1 = r1.getVoices()
            java.lang.String r2 = "textToSpeech.voices"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L6b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L83
            java.lang.Object r2 = r1.next()
            r3 = r2
            android.speech.tts.Voice r3 = (android.speech.tts.Voice) r3
            java.lang.String r3 = r3.getName()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r7)
            if (r3 == 0) goto L6b
            goto L84
        L83:
            r2 = r0
        L84:
            android.speech.tts.Voice r2 = (android.speech.tts.Voice) r2
            if (r2 == 0) goto L8f
            android.speech.tts.TextToSpeech r7 = r4.getTextToSpeech()
            r7.setVoice(r2)
        L8f:
            android.speech.tts.TextToSpeech r7 = r4.getTextToSpeech()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r1 = 1
            r7.speak(r6, r1, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.speech.SpeechModule.speakOut(java.lang.String, java.lang.String, expo.modules.speech.SpeechOptions):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isTextToSpeechReady, reason: from getter */
    public final boolean get_ttsReady() {
        return this._ttsReady;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextToSpeech getTextToSpeech() {
        return (TextToSpeech) this.textToSpeech.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle idToMap(String id) {
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SpeechModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lexpo/modules/speech/SpeechModule$Utterance;", "", "id", "", "text", "options", "Lexpo/modules/speech/SpeechOptions;", "(Ljava/lang/String;Ljava/lang/String;Lexpo/modules/speech/SpeechOptions;)V", "getId", "()Ljava/lang/String;", "getOptions", "()Lexpo/modules/speech/SpeechOptions;", "getText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "expo-speech_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Utterance {
        private final String id;
        private final SpeechOptions options;
        private final String text;

        public static /* synthetic */ Utterance copy$default(Utterance utterance, String str, String str2, SpeechOptions speechOptions, int i, Object obj) {
            if ((i & 1) != 0) {
                str = utterance.id;
            }
            if ((i & 2) != 0) {
                str2 = utterance.text;
            }
            if ((i & 4) != 0) {
                speechOptions = utterance.options;
            }
            return utterance.copy(str, str2, speechOptions);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component3, reason: from getter */
        public final SpeechOptions getOptions() {
            return this.options;
        }

        public final Utterance copy(String id, String text, SpeechOptions options) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(options, "options");
            return new Utterance(id, text, options);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Utterance)) {
                return false;
            }
            Utterance utterance = (Utterance) other;
            return Intrinsics.areEqual(this.id, utterance.id) && Intrinsics.areEqual(this.text, utterance.text) && Intrinsics.areEqual(this.options, utterance.options);
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.text.hashCode()) * 31) + this.options.hashCode();
        }

        public String toString() {
            return "Utterance(id=" + this.id + ", text=" + this.text + ", options=" + this.options + ")";
        }

        public Utterance(String id, String text, SpeechOptions options) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(options, "options");
            this.id = id;
            this.text = text;
            this.options = options;
        }

        public final String getId() {
            return this.id;
        }

        public final String getText() {
            return this.text;
        }

        public final SpeechOptions getOptions() {
            return this.options;
        }
    }
}
