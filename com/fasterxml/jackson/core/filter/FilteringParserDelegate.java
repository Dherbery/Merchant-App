package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes3.dex */
public class FilteringParserDelegate extends JsonParserDelegate {
    protected boolean _allowMultipleMatches;
    protected JsonToken _currToken;
    protected TokenFilterContext _exposedContext;
    protected TokenFilterContext _headContext;

    @Deprecated
    protected boolean _includeImmediateParent;
    protected boolean _includePath;
    protected TokenFilter _itemFilter;
    protected JsonToken _lastClearedToken;
    protected int _matchCount;
    protected TokenFilter rootFilter;

    public FilteringParserDelegate(JsonParser jsonParser, TokenFilter tokenFilter, boolean z, boolean z2) {
        super(jsonParser);
        this.rootFilter = tokenFilter;
        this._itemFilter = tokenFilter;
        this._headContext = TokenFilterContext.createRootContext(tokenFilter);
        this._includePath = z;
        this._allowMultipleMatches = z2;
    }

    public TokenFilter getFilter() {
        return this.rootFilter;
    }

    public int getMatchCount() {
        return this._matchCount;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonToken getCurrentToken() {
        return this._currToken;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonToken currentToken() {
        return this._currToken;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public final int getCurrentTokenId() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return 0;
        }
        return jsonToken.id();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public final int currentTokenId() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return 0;
        }
        return jsonToken.id();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean hasCurrentToken() {
        return this._currToken != null;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean hasTokenId(int i) {
        JsonToken jsonToken = this._currToken;
        return jsonToken == null ? i == 0 : jsonToken.id() == i;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public final boolean hasToken(JsonToken jsonToken) {
        return this._currToken == jsonToken;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean isExpectedStartArrayToken() {
        return this._currToken == JsonToken.START_ARRAY;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean isExpectedStartObjectToken() {
        return this._currToken == JsonToken.START_OBJECT;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonLocation getCurrentLocation() {
        return this.delegate.getCurrentLocation();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonStreamContext getParsingContext() {
        return _filterContext();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public String getCurrentName() throws IOException {
        JsonStreamContext _filterContext = _filterContext();
        if (this._currToken == JsonToken.START_OBJECT || this._currToken == JsonToken.START_ARRAY) {
            JsonStreamContext parent = _filterContext.getParent();
            if (parent == null) {
                return null;
            }
            return parent.getCurrentName();
        }
        return _filterContext.getCurrentName();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public void clearCurrentToken() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != null) {
            this._lastClearedToken = jsonToken;
            this._currToken = null;
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonToken getLastClearedToken() {
        return this._lastClearedToken;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public void overrideCurrentName(String str) {
        throw new UnsupportedOperationException("Can not currently override name during filtering read");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0119, code lost:
    
        r1 = r5._itemFilter;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x011d, code lost:
    
        if (r1 != com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x011f, code lost:
    
        r5._headContext = r5._headContext.createChildArrayContext(r1, true);
        r5._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0129, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x012a, code lost:
    
        if (r1 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x012c, code lost:
    
        r5.delegate.skipChildren();
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0133, code lost:
    
        r1 = r5._headContext.checkValue(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0139, code lost:
    
        if (r1 != null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x013b, code lost:
    
        r5.delegate.skipChildren();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0144, code lost:
    
        if (r1 == com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0146, code lost:
    
        r1 = r1.filterStartArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x014a, code lost:
    
        r5._itemFilter = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x014e, code lost:
    
        if (r1 != com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0150, code lost:
    
        r5._headContext = r5._headContext.createChildArrayContext(r1, true);
        r5._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x015a, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x015b, code lost:
    
        r0 = r5._headContext.createChildArrayContext(r1, false);
        r5._headContext = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0165, code lost:
    
        if (r5._includePath == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0167, code lost:
    
        r0 = _nextTokenWithBuffering(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x016b, code lost:
    
        if (r0 == null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x016d, code lost:
    
        r5._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x016f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0170, code lost:
    
        r1 = r5._headContext.isStartHandled();
        r2 = r5._headContext.getFilter();
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x017c, code lost:
    
        if (r2 == null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0180, code lost:
    
        if (r2 == com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0182, code lost:
    
        r2.filterFinishArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0185, code lost:
    
        r2 = r5._headContext.getParent();
        r5._headContext = r2;
        r5._itemFilter = r2.getFilter();
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0193, code lost:
    
        if (r1 == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0195, code lost:
    
        r5._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0197, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0198, code lost:
    
        r1 = r5._itemFilter;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x019c, code lost:
    
        if (r1 != com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x019e, code lost:
    
        r5._headContext = r5._headContext.createChildObjectContext(r1, true);
        r5._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01a8, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01a9, code lost:
    
        if (r1 != null) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01ab, code lost:
    
        r5.delegate.skipChildren();
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x01b1, code lost:
    
        r1 = r5._headContext.checkValue(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01b7, code lost:
    
        if (r1 != null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x01b9, code lost:
    
        r5.delegate.skipChildren();
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01c1, code lost:
    
        if (r1 == com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01c3, code lost:
    
        r1 = r1.filterStartObject();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01c7, code lost:
    
        r5._itemFilter = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01cb, code lost:
    
        if (r1 != com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x01cd, code lost:
    
        r5._headContext = r5._headContext.createChildObjectContext(r1, true);
        r5._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01d7, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01d8, code lost:
    
        r0 = r5._headContext.createChildObjectContext(r1, false);
        r5._headContext = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01e2, code lost:
    
        if (r5._includePath == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01e4, code lost:
    
        r0 = _nextTokenWithBuffering(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x01e8, code lost:
    
        if (r0 == null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x01ea, code lost:
    
        r5._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x01ec, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003d, code lost:
    
        if (r0 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        r2 = r0.nextTokenToRead();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        if (r2 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
    
        r2 = r5._headContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
    
        if (r0 != r2) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
    
        r0 = r2.findChildOf(r0);
        r5._exposedContext = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0063, code lost:
    
        if (r0 == null) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006c, code lost:
    
        throw _constructError("Unexpected problem: chain of filtered context broken");
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x004c, code lost:
    
        r5._exposedContext = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0052, code lost:
    
        if (r0.inArray() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0054, code lost:
    
        r0 = r5.delegate.getCurrentToken();
        r5._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0045, code lost:
    
        r5._currToken = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0047, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006d, code lost:
    
        r0 = r5.delegate.nextToken();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0073, code lost:
    
        if (r0 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0075, code lost:
    
        r5._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0077, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0078, code lost:
    
        r1 = r0.id();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x007e, code lost:
    
        if (r1 == 1) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0081, code lost:
    
        if (r1 == 2) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0084, code lost:
    
        if (r1 == 3) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0087, code lost:
    
        if (r1 == 4) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x008a, code lost:
    
        if (r1 == 5) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x008c, code lost:
    
        r1 = r5._itemFilter;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0090, code lost:
    
        if (r1 != com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0092, code lost:
    
        r5._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0094, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0095, code lost:
    
        if (r1 == null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0097, code lost:
    
        r1 = r5._headContext.checkValue(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x009f, code lost:
    
        if (r1 == com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a1, code lost:
    
        if (r1 == null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00a9, code lost:
    
        if (r1.includeValue(r5.delegate) == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ab, code lost:
    
        r5._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ad, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01f1, code lost:
    
        return _nextToken2();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ae, code lost:
    
        r1 = r5.delegate.getCurrentName();
        r2 = r5._headContext.setFieldName(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00bc, code lost:
    
        if (r2 != com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00be, code lost:
    
        r5._itemFilter = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c2, code lost:
    
        if (r5._includePath != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c6, code lost:
    
        if (r5._includeImmediateParent == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00ce, code lost:
    
        if (r5._headContext.isStartHandled() != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00d0, code lost:
    
        r0 = r5._headContext.nextTokenToRead();
        r5._exposedContext = r5._headContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00da, code lost:
    
        r5._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00dc, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00dd, code lost:
    
        if (r2 != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00df, code lost:
    
        r5.delegate.nextToken();
        r5.delegate.skipChildren();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00eb, code lost:
    
        r1 = r2.includeProperty(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00ef, code lost:
    
        if (r1 != null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00f1, code lost:
    
        r5.delegate.nextToken();
        r5.delegate.skipChildren();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00fd, code lost:
    
        r5._itemFilter = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0101, code lost:
    
        if (r1 != com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0105, code lost:
    
        if (r5._includePath == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0107, code lost:
    
        r5._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0109, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x010c, code lost:
    
        if (r5._includePath == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x010e, code lost:
    
        r0 = _nextTokenWithBuffering(r5._headContext);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0114, code lost:
    
        if (r0 == null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0116, code lost:
    
        r5._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0118, code lost:
    
        return r0;
     */
    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.fasterxml.jackson.core.JsonToken nextToken() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.filter.FilteringParserDelegate.nextToken():com.fasterxml.jackson.core.JsonToken");
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x003e, code lost:
    
        r5._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0040, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.fasterxml.jackson.core.JsonToken _nextToken2() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.filter.FilteringParserDelegate._nextToken2():com.fasterxml.jackson.core.JsonToken");
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x0042, code lost:
    
        return _nextBuffered(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.fasterxml.jackson.core.JsonToken _nextTokenWithBuffering(com.fasterxml.jackson.core.filter.TokenFilterContext r6) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.filter.FilteringParserDelegate._nextTokenWithBuffering(com.fasterxml.jackson.core.filter.TokenFilterContext):com.fasterxml.jackson.core.JsonToken");
    }

    private JsonToken _nextBuffered(TokenFilterContext tokenFilterContext) throws IOException {
        this._exposedContext = tokenFilterContext;
        JsonToken nextTokenToRead = tokenFilterContext.nextTokenToRead();
        if (nextTokenToRead != null) {
            return nextTokenToRead;
        }
        while (tokenFilterContext != this._headContext) {
            tokenFilterContext = this._exposedContext.findChildOf(tokenFilterContext);
            this._exposedContext = tokenFilterContext;
            if (tokenFilterContext == null) {
                throw _constructError("Unexpected problem: chain of filtered context broken");
            }
            JsonToken nextTokenToRead2 = tokenFilterContext.nextTokenToRead();
            if (nextTokenToRead2 != null) {
                return nextTokenToRead2;
            }
        }
        throw _constructError("Internal error: failed to locate expected buffered tokens");
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonToken nextValue() throws IOException {
        JsonToken nextToken = nextToken();
        return nextToken == JsonToken.FIELD_NAME ? nextToken() : nextToken;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonParser skipChildren() throws IOException {
        if (this._currToken != JsonToken.START_OBJECT && this._currToken != JsonToken.START_ARRAY) {
            return this;
        }
        int i = 1;
        while (true) {
            JsonToken nextToken = nextToken();
            if (nextToken == null) {
                return this;
            }
            if (nextToken.isStructStart()) {
                i++;
            } else if (nextToken.isStructEnd() && i - 1 == 0) {
                return this;
            }
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public String getText() throws IOException {
        return this.delegate.getText();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean hasTextCharacters() {
        return this.delegate.hasTextCharacters();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public char[] getTextCharacters() throws IOException {
        return this.delegate.getTextCharacters();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int getTextLength() throws IOException {
        return this.delegate.getTextLength();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int getTextOffset() throws IOException {
        return this.delegate.getTextOffset();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public BigInteger getBigIntegerValue() throws IOException {
        return this.delegate.getBigIntegerValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean getBooleanValue() throws IOException {
        return this.delegate.getBooleanValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public byte getByteValue() throws IOException {
        return this.delegate.getByteValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public short getShortValue() throws IOException {
        return this.delegate.getShortValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public BigDecimal getDecimalValue() throws IOException {
        return this.delegate.getDecimalValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public double getDoubleValue() throws IOException {
        return this.delegate.getDoubleValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public float getFloatValue() throws IOException {
        return this.delegate.getFloatValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int getIntValue() throws IOException {
        return this.delegate.getIntValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public long getLongValue() throws IOException {
        return this.delegate.getLongValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberType getNumberType() throws IOException {
        return this.delegate.getNumberType();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public Number getNumberValue() throws IOException {
        return this.delegate.getNumberValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt() throws IOException {
        return this.delegate.getValueAsInt();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt(int i) throws IOException {
        return this.delegate.getValueAsInt(i);
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public long getValueAsLong() throws IOException {
        return this.delegate.getValueAsLong();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public long getValueAsLong(long j) throws IOException {
        return this.delegate.getValueAsLong(j);
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public double getValueAsDouble() throws IOException {
        return this.delegate.getValueAsDouble();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public double getValueAsDouble(double d) throws IOException {
        return this.delegate.getValueAsDouble(d);
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean getValueAsBoolean() throws IOException {
        return this.delegate.getValueAsBoolean();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean getValueAsBoolean(boolean z) throws IOException {
        return this.delegate.getValueAsBoolean(z);
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString() throws IOException {
        return this.delegate.getValueAsString();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString(String str) throws IOException {
        return this.delegate.getValueAsString(str);
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public Object getEmbeddedObject() throws IOException {
        return this.delegate.getEmbeddedObject();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException {
        return this.delegate.getBinaryValue(base64Variant);
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        return this.delegate.readBinaryValue(base64Variant, outputStream);
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonLocation getTokenLocation() {
        return this.delegate.getTokenLocation();
    }

    protected JsonStreamContext _filterContext() {
        TokenFilterContext tokenFilterContext = this._exposedContext;
        return tokenFilterContext != null ? tokenFilterContext : this._headContext;
    }
}
