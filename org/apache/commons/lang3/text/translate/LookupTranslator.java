package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class LookupTranslator extends CharSequenceTranslator {
    private final int longest;
    private final HashMap<CharSequence, CharSequence> lookupMap = new HashMap<>();
    private final int shortest;

    public LookupTranslator(CharSequence[]... charSequenceArr) {
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        if (charSequenceArr != null) {
            int i3 = 0;
            for (CharSequence[] charSequenceArr2 : charSequenceArr) {
                this.lookupMap.put(charSequenceArr2[0], charSequenceArr2[1]);
                int length = charSequenceArr2[0].length();
                i = length < i ? length : i;
                if (length > i3) {
                    i3 = length;
                }
            }
            i2 = i3;
        }
        this.shortest = i;
        this.longest = i2;
    }

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        int i2 = this.longest;
        if (i + i2 > charSequence.length()) {
            i2 = charSequence.length() - i;
        }
        while (i2 >= this.shortest) {
            CharSequence charSequence2 = this.lookupMap.get(charSequence.subSequence(i, i + i2));
            if (charSequence2 != null) {
                writer.write(charSequence2.toString());
                return i2;
            }
            i2--;
        }
        return 0;
    }
}
