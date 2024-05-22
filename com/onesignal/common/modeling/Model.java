package com.onesignal.common.modeling;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.events.IEventNotifier;
import com.onesignal.core.BuildConfig;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Model.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b)\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\"\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010#H\u0004J\"\u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010#H\u0004J\"\u0010&\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010#H\u0004J\"\u0010'\u001a\u00020(2\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010#H\u0004J(\u0010)\u001a\u0002H*\"\u0010\b\u0000\u0010*\u0018\u0001*\b\u0012\u0004\u0012\u0002H*0+2\u0006\u0010!\u001a\u00020\u0005H\u0084\b¢\u0006\u0002\u0010,J\"\u0010-\u001a\u00020.2\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010#H\u0004J\"\u0010/\u001a\u0002002\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010#H\u0004J4\u00101\u001a\b\u0012\u0004\u0012\u0002H*0\u0019\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\u0016\b\u0002\u0010\"\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H*0\u0019\u0018\u00010#H\u0004J\"\u00102\u001a\u0002032\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010#H\u0004J4\u00104\u001a\b\u0012\u0004\u0012\u0002H*05\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\u0016\b\u0002\u0010\"\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H*05\u0018\u00010#H\u0004J&\u00106\u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010#H\u0004J&\u00107\u001a\u0004\u0018\u00010%2\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010#H\u0004J+\u00108\u001a\u0004\u0018\u00010\u000f2\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010#H\u0004¢\u0006\u0002\u00109J+\u0010:\u001a\u0004\u0018\u00010(2\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010#H\u0004¢\u0006\u0002\u0010;J*\u0010<\u001a\u0004\u0018\u0001H*\"\u0010\b\u0000\u0010*\u0018\u0001*\b\u0012\u0004\u0012\u0002H*0+2\u0006\u0010!\u001a\u00020\u0005H\u0084\b¢\u0006\u0002\u0010,J+\u0010=\u001a\u0004\u0018\u00010.2\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u00010#H\u0004¢\u0006\u0002\u0010>J+\u0010?\u001a\u0004\u0018\u0001002\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010#H\u0004¢\u0006\u0002\u0010@J8\u0010A\u001a\n\u0012\u0004\u0012\u0002H*\u0018\u00010\u0019\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\u0018\b\u0002\u0010\"\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u0002H*\u0018\u00010\u0019\u0018\u00010#H\u0004J+\u0010B\u001a\u0004\u0018\u0001032\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u00010#H\u0004¢\u0006\u0002\u0010CJ8\u0010D\u001a\n\u0012\u0004\u0012\u0002H*\u0018\u000105\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\u0018\b\u0002\u0010\"\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u0002H*\u0018\u000105\u0018\u00010#H\u0004J&\u0010E\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010#H\u0004J\"\u0010F\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010#H\u0004J\u000e\u0010G\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0005J\u000e\u0010H\u001a\u00020I2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010J\u001a\u00020I2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010K\u001a\u00020\u0000J4\u0010L\u001a\u00020I2\u0006\u0010M\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u00052\b\u0010O\u001a\u0004\u0018\u00010\u000b2\b\u0010P\u001a\u0004\u0018\u00010\u000bH\u0002J*\u0010Q\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ*\u0010S\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020%2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ*\u0010T\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ*\u0010U\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020(2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJD\u0010V\u001a\u00020I\"\u0010\b\u0000\u0010*\u0018\u0001*\b\u0012\u0004\u0012\u0002H*0+2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u0002H*2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fH\u0086\b¢\u0006\u0002\u0010WJ*\u0010X\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020.2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ*\u0010Y\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u0002002\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ6\u0010Z\u001a\u00020I\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H*0\u00192\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ*\u0010[\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u0002032\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ6\u0010\\\u001a\u00020I\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H*052\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ,\u0010]\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ,\u0010^\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ1\u0010_\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000f¢\u0006\u0002\u0010`J1\u0010a\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000f¢\u0006\u0002\u0010bJF\u0010c\u001a\u00020I\"\u0010\b\u0000\u0010*\u0018\u0001*\b\u0012\u0004\u0012\u0002H*0+2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u0001H*2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fH\u0086\b¢\u0006\u0002\u0010WJ1\u0010d\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000f¢\u0006\u0002\u0010eJ1\u0010f\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u0001002\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000f¢\u0006\u0002\u0010gJ8\u0010h\u001a\u00020I\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H*\u0018\u00010\u00192\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ1\u0010i\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u0001032\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000f¢\u0006\u0002\u0010jJ8\u0010k\u001a\u00020I\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H*\u0018\u0001052\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ,\u0010l\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ*\u0010m\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ\u0010\u0010n\u001a\u00020I2\u0006\u0010o\u001a\u00020\u0002H\u0016J\u0006\u0010p\u001a\u00020\u001fJ\u0010\u0010q\u001a\u00020I2\u0006\u0010o\u001a\u00020\u0002H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006r"}, d2 = {"Lcom/onesignal/common/modeling/Model;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/common/modeling/IModelChangedHandler;", "_parentModel", "_parentProperty", "", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "changeNotifier", "Lcom/onesignal/common/events/EventProducer;", "data", "", "", "getData", "()Ljava/util/Map;", "hasSubscribers", "", "getHasSubscribers", "()Z", "value", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "createListForProperty", "", "property", "jsonArray", "Lorg/json/JSONArray;", "createModelForProperty", "jsonObject", "Lorg/json/JSONObject;", "getAnyProperty", "name", "create", "Lkotlin/Function0;", "getBigDecimalProperty", "Ljava/math/BigDecimal;", "getBooleanProperty", "getDoubleProperty", "", "getEnumProperty", "T", "", "(Ljava/lang/String;)Ljava/lang/Enum;", "getFloatProperty", "", "getIntProperty", "", "getListProperty", "getLongProperty", "", "getMapModelProperty", "Lcom/onesignal/common/modeling/MapModel;", "getOptAnyProperty", "getOptBigDecimalProperty", "getOptBooleanProperty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Boolean;", "getOptDoubleProperty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Double;", "getOptEnumProperty", "getOptFloatProperty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Float;", "getOptIntProperty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Integer;", "getOptListProperty", "getOptLongProperty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Long;", "getOptMapModelProperty", "getOptStringProperty", "getStringProperty", "hasProperty", "initializeFromJson", "", "initializeFromModel", "model", "notifyChanged", ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, "tag", "oldValue", "newValue", "setAnyProperty", "forceChange", "setBigDecimalProperty", "setBooleanProperty", "setDoubleProperty", "setEnumProperty", "(Ljava/lang/String;Ljava/lang/Enum;Ljava/lang/String;Z)V", "setFloatProperty", "setIntProperty", "setListProperty", "setLongProperty", "setMapModelProperty", "setOptAnyProperty", "setOptBigDecimalProperty", "setOptBooleanProperty", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Z)V", "setOptDoubleProperty", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Z)V", "setOptEnumProperty", "setOptFloatProperty", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Z)V", "setOptIntProperty", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Z)V", "setOptListProperty", "setOptLongProperty", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Z)V", "setOptMapModelProperty", "setOptStringProperty", "setStringProperty", "subscribe", "handler", "toJSON", "unsubscribe", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public class Model implements IEventNotifier<IModelChangedHandler> {
    private Model _parentModel;
    private final String _parentProperty;
    private final EventProducer<IModelChangedHandler> changeNotifier;
    private final Map<String, Object> data;

    public Model() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    protected List<?> createListForProperty(String property, JSONArray jsonArray) {
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        return null;
    }

    protected Model createModelForProperty(String property, JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        return null;
    }

    public Model(Model model, String str) {
        this._parentModel = model;
        this._parentProperty = str;
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(synchronizedMap, "synchronizedMap(mutableMapOf())");
        this.data = synchronizedMap;
        this.changeNotifier = new EventProducer<>();
        Model model2 = this._parentModel;
        if (model2 != null && str == null) {
            throw new Exception("If parent model is set, parent property must also be set.");
        }
        if (model2 == null && str != null) {
            throw new Exception("If parent property is set, parent model must also be set.");
        }
    }

    public /* synthetic */ Model(Model model, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : model, (i & 2) != 0 ? null : str);
    }

    public final String getId() {
        return getStringProperty$default(this, "id", null, 2, null);
    }

    public final void setId(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        setStringProperty$default(this, "id", value, null, false, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map<String, Object> getData() {
        return this.data;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0099 A[Catch: all -> 0x01a9, LOOP:1: B:14:0x0066->B:22:0x0099, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0008, B:5:0x0016, B:7:0x001c, B:99:0x002a, B:102:0x0037, B:10:0x003d, B:92:0x0041, B:95:0x004e, B:13:0x0054, B:16:0x0069, B:18:0x007a, B:25:0x009d, B:86:0x00a1, B:28:0x00b1, B:82:0x00c7, B:33:0x00db, B:78:0x00ed, B:38:0x0101, B:74:0x0113, B:43:0x0128, B:70:0x013a, B:48:0x014e, B:66:0x0160, B:53:0x0174, B:62:0x0185, B:58:0x0195, B:64:0x017d, B:68:0x0158, B:72:0x0132, B:76:0x010b, B:80:0x00e5, B:84:0x00bf, B:22:0x0099, B:106:0x01a5), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0098 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void initializeFromJson(org.json.JSONObject r13) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.common.modeling.Model.initializeFromJson(org.json.JSONObject):void");
    }

    public final void initializeFromModel(String id, Model model) {
        Intrinsics.checkNotNullParameter(model, "model");
        Map<? extends String, ? extends Object> newData = Collections.synchronizedMap(new LinkedHashMap());
        for (Map.Entry<String, Object> entry : model.data.entrySet()) {
            if (entry.getValue() instanceof Model) {
                Object value = entry.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.onesignal.common.modeling.Model");
                Model model2 = (Model) value;
                model2._parentModel = this;
                Intrinsics.checkNotNullExpressionValue(newData, "newData");
                newData.put(entry.getKey(), model2);
            } else {
                Intrinsics.checkNotNullExpressionValue(newData, "newData");
                newData.put(entry.getKey(), entry.getValue());
            }
        }
        if (id != null) {
            Intrinsics.checkNotNullExpressionValue(newData, "newData");
            newData.put("id", id);
        }
        synchronized (this.data) {
            this.data.clear();
            Map<String, Object> map = this.data;
            Intrinsics.checkNotNullExpressionValue(newData, "newData");
            map.putAll(newData);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void setEnumProperty$default(Model model, String name, Enum value, String tag, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                tag = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(tag, "tag");
            model.setOptAnyProperty(name, value.toString(), tag, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setEnumProperty");
    }

    public static /* synthetic */ void setMapModelProperty$default(Model model, String str, MapModel mapModel, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMapModelProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setMapModelProperty(str, mapModel, str2, z);
    }

    public final <T> void setMapModelProperty(String name, MapModel<T> value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptMapModelProperty(name, value, tag, forceChange);
    }

    public static /* synthetic */ void setListProperty$default(Model model, String str, List list, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setListProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setListProperty(str, list, str2, z);
    }

    public final <T> void setListProperty(String name, List<? extends T> value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptListProperty(name, value, tag, forceChange);
    }

    public static /* synthetic */ void setStringProperty$default(Model model, String str, String str2, String str3, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStringProperty");
        }
        if ((i & 4) != 0) {
            str3 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setStringProperty(str, str2, str3, z);
    }

    public final void setStringProperty(String name, String value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptStringProperty(name, value, tag, forceChange);
    }

    public static /* synthetic */ void setBooleanProperty$default(Model model, String str, boolean z, String str2, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBooleanProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        model.setBooleanProperty(str, z, str2, z2);
    }

    public final void setBooleanProperty(String name, boolean value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptBooleanProperty(name, Boolean.valueOf(value), tag, forceChange);
    }

    public static /* synthetic */ void setLongProperty$default(Model model, String str, long j, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLongProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            z = false;
        }
        model.setLongProperty(str, j, str3, z);
    }

    public final void setLongProperty(String name, long value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptLongProperty(name, Long.valueOf(value), tag, forceChange);
    }

    public static /* synthetic */ void setDoubleProperty$default(Model model, String str, double d, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDoubleProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            z = false;
        }
        model.setDoubleProperty(str, d, str3, z);
    }

    public final void setDoubleProperty(String name, double value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptDoubleProperty(name, Double.valueOf(value), tag, forceChange);
    }

    public static /* synthetic */ void setFloatProperty$default(Model model, String str, float f, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFloatProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setFloatProperty(str, f, str2, z);
    }

    public final void setFloatProperty(String name, float value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptFloatProperty(name, Float.valueOf(value), tag, forceChange);
    }

    public static /* synthetic */ void setIntProperty$default(Model model, String str, int i, String str2, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIntProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        model.setIntProperty(str, i, str2, z);
    }

    public final void setIntProperty(String name, int value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptIntProperty(name, Integer.valueOf(value), tag, forceChange);
    }

    public static /* synthetic */ void setBigDecimalProperty$default(Model model, String str, BigDecimal bigDecimal, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBigDecimalProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setBigDecimalProperty(str, bigDecimal, str2, z);
    }

    public final void setBigDecimalProperty(String name, BigDecimal value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptBigDecimalProperty(name, value, tag, forceChange);
    }

    public static /* synthetic */ void setAnyProperty$default(Model model, String str, Object obj, String str2, boolean z, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAnyProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setAnyProperty(str, obj, str2, z);
    }

    public final void setAnyProperty(String name, Object value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptAnyProperty(name, value, tag, forceChange);
    }

    public static /* synthetic */ void setOptEnumProperty$default(Model model, String name, Enum r2, String tag, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                tag = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(tag, "tag");
            model.setOptAnyProperty(name, r2 != null ? r2.toString() : null, tag, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptEnumProperty");
    }

    public final /* synthetic */ <T extends Enum<T>> void setOptEnumProperty(String name, T value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptAnyProperty(name, value != null ? value.toString() : null, tag, forceChange);
    }

    public static /* synthetic */ void setOptMapModelProperty$default(Model model, String str, MapModel mapModel, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptMapModelProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setOptMapModelProperty(str, mapModel, str2, z);
    }

    public final <T> void setOptMapModelProperty(String name, MapModel<T> value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptAnyProperty(name, value, tag, forceChange);
    }

    public static /* synthetic */ void setOptListProperty$default(Model model, String str, List list, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptListProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setOptListProperty(str, list, str2, z);
    }

    public final <T> void setOptListProperty(String name, List<? extends T> value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptAnyProperty(name, value, tag, forceChange);
    }

    public static /* synthetic */ void setOptStringProperty$default(Model model, String str, String str2, String str3, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptStringProperty");
        }
        if ((i & 4) != 0) {
            str3 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setOptStringProperty(str, str2, str3, z);
    }

    public final void setOptStringProperty(String name, String value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptAnyProperty(name, value, tag, forceChange);
    }

    public static /* synthetic */ void setOptBooleanProperty$default(Model model, String str, Boolean bool, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptBooleanProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setOptBooleanProperty(str, bool, str2, z);
    }

    public final void setOptBooleanProperty(String name, Boolean value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptAnyProperty(name, value, tag, forceChange);
    }

    public static /* synthetic */ void setOptLongProperty$default(Model model, String str, Long l, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptLongProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setOptLongProperty(str, l, str2, z);
    }

    public final void setOptLongProperty(String name, Long value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptAnyProperty(name, value, tag, forceChange);
    }

    public static /* synthetic */ void setOptDoubleProperty$default(Model model, String str, Double d, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptDoubleProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setOptDoubleProperty(str, d, str2, z);
    }

    public final void setOptDoubleProperty(String name, Double value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptAnyProperty(name, value, tag, forceChange);
    }

    public static /* synthetic */ void setOptFloatProperty$default(Model model, String str, Float f, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptFloatProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setOptFloatProperty(str, f, str2, z);
    }

    public final void setOptFloatProperty(String name, Float value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptAnyProperty(name, value, tag, forceChange);
    }

    public static /* synthetic */ void setOptIntProperty$default(Model model, String str, Integer num, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptIntProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setOptIntProperty(str, num, str2, z);
    }

    public final void setOptIntProperty(String name, Integer value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptAnyProperty(name, value, tag, forceChange);
    }

    public static /* synthetic */ void setOptBigDecimalProperty$default(Model model, String str, BigDecimal bigDecimal, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptBigDecimalProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setOptBigDecimalProperty(str, bigDecimal, str2, z);
    }

    public final void setOptBigDecimalProperty(String name, BigDecimal value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptAnyProperty(name, value != null ? value.toString() : null, tag, forceChange);
    }

    public static /* synthetic */ void setOptAnyProperty$default(Model model, String str, Object obj, String str2, boolean z, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptAnyProperty");
        }
        if ((i & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        model.setOptAnyProperty(str, obj, str2, z);
    }

    public final void setOptAnyProperty(String name, Object value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Object obj = this.data.get(name);
        synchronized (this.data) {
            if (!Intrinsics.areEqual(obj, value) || forceChange) {
                if (value != null) {
                    this.data.put(name, value);
                } else if (this.data.containsKey(name)) {
                    this.data.remove(name);
                }
                Unit unit = Unit.INSTANCE;
                notifyChanged(name, name, tag, obj, value);
            }
        }
    }

    public final boolean hasProperty(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.data.containsKey(name);
    }

    public static /* synthetic */ MapModel getMapModelProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMapModelProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getMapModelProperty(str, function0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> MapModel<T> getMapModelProperty(String name, Function0<? extends MapModel<T>> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        MapModel<T> optMapModelProperty = getOptMapModelProperty(name, create);
        Intrinsics.checkNotNull(optMapModelProperty, "null cannot be cast to non-null type com.onesignal.common.modeling.MapModel<T of com.onesignal.common.modeling.Model.getMapModelProperty>");
        return optMapModelProperty;
    }

    public static /* synthetic */ List getListProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getListProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getListProperty(str, function0);
    }

    protected final <T> List<T> getListProperty(String name, Function0<? extends List<? extends T>> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<T> optListProperty = getOptListProperty(name, create);
        Intrinsics.checkNotNull(optListProperty, "null cannot be cast to non-null type kotlin.collections.List<T of com.onesignal.common.modeling.Model.getListProperty>");
        return optListProperty;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String getStringProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getStringProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getStringProperty(str, function0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getStringProperty(String name, Function0<String> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        String optStringProperty = getOptStringProperty(name, create);
        Intrinsics.checkNotNull(optStringProperty, "null cannot be cast to non-null type kotlin.String");
        return optStringProperty;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean getBooleanProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBooleanProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getBooleanProperty(str, function0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getBooleanProperty(String name, Function0<Boolean> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        Boolean optBooleanProperty = getOptBooleanProperty(name, create);
        Intrinsics.checkNotNull(optBooleanProperty, "null cannot be cast to non-null type kotlin.Boolean");
        return optBooleanProperty.booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ long getLongProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLongProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getLongProperty(str, function0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long getLongProperty(String name, Function0<Long> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        Long optLongProperty = getOptLongProperty(name, create);
        Intrinsics.checkNotNull(optLongProperty, "null cannot be cast to non-null type kotlin.Long");
        return optLongProperty.longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ double getDoubleProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDoubleProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getDoubleProperty(str, function0);
    }

    protected final double getDoubleProperty(String name, Function0<Double> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        Double optDoubleProperty = getOptDoubleProperty(name, create);
        Intrinsics.checkNotNull(optDoubleProperty, "null cannot be cast to non-null type kotlin.Double");
        return optDoubleProperty.doubleValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ float getFloatProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFloatProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getFloatProperty(str, function0);
    }

    protected final float getFloatProperty(String name, Function0<Float> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        Float optFloatProperty = getOptFloatProperty(name, create);
        Intrinsics.checkNotNull(optFloatProperty, "null cannot be cast to non-null type kotlin.Float");
        return optFloatProperty.floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ int getIntProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getIntProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getIntProperty(str, function0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getIntProperty(String name, Function0<Integer> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer optIntProperty = getOptIntProperty(name, create);
        Intrinsics.checkNotNull(optIntProperty, "null cannot be cast to non-null type kotlin.Int");
        return optIntProperty.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BigDecimal getBigDecimalProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBigDecimalProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getBigDecimalProperty(str, function0);
    }

    protected final BigDecimal getBigDecimalProperty(String name, Function0<? extends BigDecimal> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        BigDecimal optBigDecimalProperty = getOptBigDecimalProperty(name, create);
        Intrinsics.checkNotNull(optBigDecimalProperty, "null cannot be cast to non-null type java.math.BigDecimal");
        return optBigDecimalProperty;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getAnyProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAnyProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getAnyProperty(str, function0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object getAnyProperty(String name, Function0<? extends Object> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object optAnyProperty = getOptAnyProperty(name, create);
        Intrinsics.checkNotNull(optAnyProperty, "null cannot be cast to non-null type kotlin.Any");
        return optAnyProperty;
    }

    protected final /* synthetic */ <T extends Enum<T>> T getOptEnumProperty(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object optAnyProperty$default = getOptAnyProperty$default(this, name, null, 2, null);
        if (optAnyProperty$default == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(3, "T");
        if (optAnyProperty$default instanceof Enum) {
            return (T) optAnyProperty$default;
        }
        if (optAnyProperty$default instanceof String) {
            Intrinsics.reifiedOperationMarker(5, "T");
            return (T) Enum.valueOf(null, (String) optAnyProperty$default);
        }
        Intrinsics.reifiedOperationMarker(1, "T");
        return (T) optAnyProperty$default;
    }

    public static /* synthetic */ MapModel getOptMapModelProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptMapModelProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getOptMapModelProperty(str, function0);
    }

    protected final <T> MapModel<T> getOptMapModelProperty(String name, Function0<? extends MapModel<T>> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (MapModel) getOptAnyProperty(name, create);
    }

    public static /* synthetic */ List getOptListProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptListProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getOptListProperty(str, function0);
    }

    protected final <T> List<T> getOptListProperty(String name, Function0<? extends List<? extends T>> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (List) getOptAnyProperty(name, create);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String getOptStringProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptStringProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getOptStringProperty(str, function0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getOptStringProperty(String name, Function0<String> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (String) getOptAnyProperty(name, create);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Boolean getOptBooleanProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptBooleanProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getOptBooleanProperty(str, function0);
    }

    protected final Boolean getOptBooleanProperty(String name, Function0<Boolean> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (Boolean) getOptAnyProperty(name, create);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Long getOptLongProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptLongProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getOptLongProperty(str, function0);
    }

    protected final Long getOptLongProperty(String name, Function0<Long> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object optAnyProperty = getOptAnyProperty(name, create);
        if (optAnyProperty == null) {
            return null;
        }
        return optAnyProperty instanceof Long ? (Long) optAnyProperty : optAnyProperty instanceof Integer ? Long.valueOf(((Number) optAnyProperty).intValue()) : optAnyProperty instanceof Float ? Long.valueOf(((Number) optAnyProperty).floatValue()) : optAnyProperty instanceof Double ? Long.valueOf((long) ((Number) optAnyProperty).doubleValue()) : (Long) optAnyProperty;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Float getOptFloatProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptFloatProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getOptFloatProperty(str, function0);
    }

    protected final Float getOptFloatProperty(String name, Function0<Float> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object optAnyProperty = getOptAnyProperty(name, create);
        if (optAnyProperty == null) {
            return null;
        }
        return optAnyProperty instanceof Float ? (Float) optAnyProperty : optAnyProperty instanceof Double ? Float.valueOf((float) ((Number) optAnyProperty).doubleValue()) : optAnyProperty instanceof Integer ? Float.valueOf(((Number) optAnyProperty).intValue()) : optAnyProperty instanceof Long ? Float.valueOf((float) ((Number) optAnyProperty).longValue()) : (Float) optAnyProperty;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Double getOptDoubleProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptDoubleProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getOptDoubleProperty(str, function0);
    }

    protected final Double getOptDoubleProperty(String name, Function0<Double> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object optAnyProperty = getOptAnyProperty(name, create);
        if (optAnyProperty == null) {
            return null;
        }
        return optAnyProperty instanceof Double ? (Double) optAnyProperty : optAnyProperty instanceof Float ? Double.valueOf(((Number) optAnyProperty).floatValue()) : optAnyProperty instanceof Integer ? Double.valueOf(((Number) optAnyProperty).intValue()) : optAnyProperty instanceof Long ? Double.valueOf(((Number) optAnyProperty).longValue()) : (Double) optAnyProperty;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Integer getOptIntProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptIntProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getOptIntProperty(str, function0);
    }

    protected final Integer getOptIntProperty(String name, Function0<Integer> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object optAnyProperty = getOptAnyProperty(name, create);
        if (optAnyProperty == null) {
            return null;
        }
        return optAnyProperty instanceof Integer ? (Integer) optAnyProperty : optAnyProperty instanceof Long ? Integer.valueOf((int) ((Number) optAnyProperty).longValue()) : optAnyProperty instanceof Float ? Integer.valueOf((int) ((Number) optAnyProperty).floatValue()) : optAnyProperty instanceof Double ? Integer.valueOf((int) ((Number) optAnyProperty).doubleValue()) : (Integer) optAnyProperty;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BigDecimal getOptBigDecimalProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptBigDecimalProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getOptBigDecimalProperty(str, function0);
    }

    protected final BigDecimal getOptBigDecimalProperty(String name, Function0<? extends BigDecimal> create) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object optAnyProperty = getOptAnyProperty(name, create);
        if (optAnyProperty == null) {
            return null;
        }
        return optAnyProperty instanceof Integer ? new BigDecimal(((Number) optAnyProperty).intValue()) : optAnyProperty instanceof Long ? new BigDecimal(((Number) optAnyProperty).longValue()) : optAnyProperty instanceof Float ? new BigDecimal(((Number) optAnyProperty).floatValue()) : optAnyProperty instanceof Double ? new BigDecimal(((Number) optAnyProperty).doubleValue()) : optAnyProperty instanceof String ? new BigDecimal((String) optAnyProperty) : (BigDecimal) optAnyProperty;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getOptAnyProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptAnyProperty");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return model.getOptAnyProperty(str, function0);
    }

    protected final Object getOptAnyProperty(String name, Function0<? extends Object> create) {
        Object obj;
        Intrinsics.checkNotNullParameter(name, "name");
        synchronized (this.data) {
            if (!this.data.containsKey(name) && create != null) {
                obj = create.invoke();
                this.data.put(name, obj);
            }
            obj = this.data.get(name);
        }
        return obj;
    }

    private final void notifyChanged(String path, String property, final String tag, Object oldValue, Object newValue) {
        final ModelChangedArgs modelChangedArgs = new ModelChangedArgs(this, path, property, oldValue, newValue);
        this.changeNotifier.fire(new Function1<IModelChangedHandler, Unit>() { // from class: com.onesignal.common.modeling.Model$notifyChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IModelChangedHandler iModelChangedHandler) {
                invoke2(iModelChangedHandler);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IModelChangedHandler it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onChanged(ModelChangedArgs.this, tag);
            }
        });
        if (this._parentModel != null) {
            String str = this._parentProperty + '.' + path;
            Model model = this._parentModel;
            Intrinsics.checkNotNull(model);
            model.notifyChanged(str, property, tag, oldValue, newValue);
        }
    }

    public final JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        synchronized (this.data) {
            for (Map.Entry<String, Object> entry : this.data.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof Model) {
                    jSONObject.put(entry.getKey(), ((Model) value).toJSON());
                } else if (value instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (Object obj : (List) value) {
                        if (obj instanceof Model) {
                            jSONArray.put(((Model) obj).toJSON());
                        } else {
                            jSONArray.put(obj);
                        }
                    }
                    jSONObject.put(entry.getKey(), jSONArray);
                } else {
                    jSONObject.put(entry.getKey(), value);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return jSONObject;
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(IModelChangedHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.changeNotifier.subscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(IModelChangedHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.changeNotifier.unsubscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.changeNotifier.getHasSubscribers();
    }

    public final /* synthetic */ <T extends Enum<T>> void setEnumProperty(String name, T value, String tag, boolean forceChange) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(tag, "tag");
        setOptAnyProperty(name, value.toString(), tag, forceChange);
    }

    protected final /* synthetic */ <T extends Enum<T>> T getEnumProperty(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        T t = null;
        Object optAnyProperty$default = getOptAnyProperty$default(this, name, null, 2, null);
        if (optAnyProperty$default != null) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (optAnyProperty$default instanceof Enum) {
                t = (T) optAnyProperty$default;
            } else if (optAnyProperty$default instanceof String) {
                Intrinsics.reifiedOperationMarker(5, "T");
                t = (T) Enum.valueOf(null, (String) optAnyProperty$default);
            } else {
                Intrinsics.reifiedOperationMarker(1, "T");
                t = (T) optAnyProperty$default;
            }
        }
        Intrinsics.reifiedOperationMarker(1, "T");
        T t2 = t;
        return t;
    }
}
