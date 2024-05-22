package com.onesignal.rnonesignalandroid;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.inAppMessages.IInAppMessage;
import com.onesignal.inAppMessages.IInAppMessageClickEvent;
import com.onesignal.inAppMessages.IInAppMessageClickResult;
import com.onesignal.inAppMessages.IInAppMessageDidDismissEvent;
import com.onesignal.inAppMessages.IInAppMessageDidDisplayEvent;
import com.onesignal.inAppMessages.IInAppMessageWillDismissEvent;
import com.onesignal.inAppMessages.IInAppMessageWillDisplayEvent;
import com.onesignal.notifications.INotification;
import com.onesignal.notifications.INotificationClickEvent;
import com.onesignal.notifications.INotificationClickResult;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.user.state.UserChangedState;
import com.onesignal.user.state.UserState;
import com.onesignal.user.subscriptions.PushSubscriptionChangedState;
import com.onesignal.user.subscriptions.PushSubscriptionState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class RNUtils {
    public static WritableMap convertHashMapToWritableMap(HashMap<String, Object> hashMap) throws JSONException {
        WritableMap createMap = Arguments.createMap();
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                createMap.putString(key, (String) value);
            } else if (value instanceof Boolean) {
                createMap.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Integer) {
                createMap.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Double) {
                createMap.putDouble(key, ((Double) value).doubleValue());
            } else if (value instanceof Float) {
                createMap.putDouble(key, ((Float) value).doubleValue());
            } else if (value instanceof Long) {
                createMap.putDouble(key, ((Long) value).doubleValue());
            } else if (value instanceof HashMap) {
                createMap.putMap(key, convertHashMapToWritableMap((HashMap) value));
            } else {
                createMap.putNull(key);
            }
        }
        return createMap;
    }

    public static HashMap<String, Object> convertNotificationClickEventToMap(INotificationClickEvent iNotificationClickEvent) throws JSONException {
        HashMap hashMap = new HashMap();
        HashMap<String, Object> hashMap2 = new HashMap<>();
        HashMap<String, Object> convertNotificationToMap = convertNotificationToMap(iNotificationClickEvent.getNotification());
        INotificationClickResult result = iNotificationClickEvent.getResult();
        hashMap.put(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID, result.getActionId());
        hashMap.put(ImagesContract.URL, result.getUrl());
        hashMap2.put(OneSignalDbContract.NotificationTable.TABLE_NAME, convertNotificationToMap);
        hashMap2.put("result", hashMap);
        return hashMap2;
    }

    public static HashMap<String, Object> convertNotificationToMap(INotification iNotification) throws JSONException {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, Integer.valueOf(iNotification.getAndroidNotificationId()));
        if (iNotification.getGroupedNotifications() != null) {
            hashMap.put("groupKey", iNotification.getGroupKey());
            hashMap.put("groupMessage", iNotification.getGroupMessage());
            hashMap.put("groupedNotifications", iNotification.getGroupedNotifications());
        }
        hashMap.put("notificationId", iNotification.getNotificationId());
        hashMap.put("title", iNotification.getTitle());
        if (iNotification.getBody() != null) {
            hashMap.put(TtmlNode.TAG_BODY, iNotification.getBody());
        }
        if (iNotification.getSmallIcon() != null) {
            hashMap.put("smallIcon", iNotification.getSmallIcon());
        }
        if (iNotification.getLargeIcon() != null) {
            hashMap.put("largeIcon", iNotification.getLargeIcon());
        }
        if (iNotification.getBigPicture() != null) {
            hashMap.put("bigPicture", iNotification.getBigPicture());
        }
        if (iNotification.getSmallIconAccentColor() != null) {
            hashMap.put("smallIconAccentColor", iNotification.getSmallIconAccentColor());
        }
        if (iNotification.getLaunchURL() != null) {
            hashMap.put("launchUrl", iNotification.getLaunchURL());
        }
        if (iNotification.getSound() != null) {
            hashMap.put("sound", iNotification.getSound());
        }
        if (iNotification.getLedColor() != null) {
            hashMap.put("ledColor", iNotification.getLedColor());
        }
        hashMap.put("lockScreenVisibility", Integer.valueOf(iNotification.getLockScreenVisibility()));
        if (iNotification.getGroupKey() != null) {
            hashMap.put("groupKey", iNotification.getGroupKey());
        }
        if (iNotification.getGroupMessage() != null) {
            hashMap.put("groupMessage", iNotification.getGroupMessage());
        }
        if (iNotification.getFromProjectNumber() != null) {
            hashMap.put("fromProjectNumber", iNotification.getFromProjectNumber());
        }
        if (iNotification.getCollapseId() != null) {
            hashMap.put("collapseId", iNotification.getCollapseId());
        }
        hashMap.put("priority", Integer.valueOf(iNotification.getPriority()));
        if (iNotification.getAdditionalData() != null && iNotification.getAdditionalData().length() > 0) {
            hashMap.put("additionalData", convertJSONObjectToHashMap(iNotification.getAdditionalData()));
        }
        if (iNotification.getActionButtons() != null) {
            hashMap.put("actionButtons", iNotification.getActionButtons());
        }
        hashMap.put("rawPayload", iNotification.getRawPayload());
        return hashMap;
    }

    private static HashMap<String, Object> convertInAppMessageToMap(IInAppMessage iInAppMessage) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("messageId", iInAppMessage.getMessageId());
        return hashMap;
    }

    public static HashMap<String, Object> convertInAppMessageWillDisplayEventToMap(IInAppMessageWillDisplayEvent iInAppMessageWillDisplayEvent) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, convertInAppMessageToMap(iInAppMessageWillDisplayEvent.getMessage()));
        return hashMap;
    }

    public static HashMap<String, Object> convertInAppMessageDidDisplayEventToMap(IInAppMessageDidDisplayEvent iInAppMessageDidDisplayEvent) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, convertInAppMessageToMap(iInAppMessageDidDisplayEvent.getMessage()));
        return hashMap;
    }

    public static HashMap<String, Object> convertInAppMessageWillDismissEventToMap(IInAppMessageWillDismissEvent iInAppMessageWillDismissEvent) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, convertInAppMessageToMap(iInAppMessageWillDismissEvent.getMessage()));
        return hashMap;
    }

    public static HashMap<String, Object> convertInAppMessageDidDismissEventToMap(IInAppMessageDidDismissEvent iInAppMessageDidDismissEvent) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, convertInAppMessageToMap(iInAppMessageDidDismissEvent.getMessage()));
        return hashMap;
    }

    public static HashMap<String, Object> convertInAppMessageClickEventToMap(IInAppMessageClickEvent iInAppMessageClickEvent) {
        HashMap hashMap = new HashMap();
        HashMap<String, Object> hashMap2 = new HashMap<>();
        IInAppMessageClickResult result = iInAppMessageClickEvent.getResult();
        hashMap.put(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID, result.getActionId());
        hashMap.put("urlTarget", result.getUrlTarget());
        hashMap.put(ImagesContract.URL, result.getUrl());
        hashMap.put("closingMessage", Boolean.valueOf(result.getClosingMessage()));
        hashMap2.put("result", hashMap);
        hashMap2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, convertInAppMessageToMap(iInAppMessageClickEvent.getMessage()));
        return hashMap2;
    }

    public static HashMap<String, Object> convertPushSubscriptionStateToMap(PushSubscriptionState pushSubscriptionState) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (pushSubscriptionState.getToken() != null && !pushSubscriptionState.getToken().isEmpty()) {
            hashMap.put("token", pushSubscriptionState.getToken());
        } else {
            hashMap.put("token", JSONObject.NULL);
        }
        if (pushSubscriptionState.getId() != null && !pushSubscriptionState.getId().isEmpty()) {
            hashMap.put("id", pushSubscriptionState.getId());
        } else {
            hashMap.put("id", JSONObject.NULL);
        }
        hashMap.put("optedIn", Boolean.valueOf(pushSubscriptionState.getOptedIn()));
        return hashMap;
    }

    public static HashMap<String, Object> convertUserStateToMap(UserState userState) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (userState.getExternalId() != null && !userState.getExternalId().isEmpty()) {
            hashMap.put("externalId", userState.getExternalId());
        } else {
            hashMap.put("externalId", JSONObject.NULL);
        }
        if (userState.getOnesignalId() != null && !userState.getOnesignalId().isEmpty()) {
            hashMap.put("onesignalId", userState.getOnesignalId());
        } else {
            hashMap.put("onesignalId", JSONObject.NULL);
        }
        return hashMap;
    }

    public static HashMap<String, Object> convertPushSubscriptionChangedStateToMap(PushSubscriptionChangedState pushSubscriptionChangedState) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("current", convertPushSubscriptionStateToMap(pushSubscriptionChangedState.getCurrent()));
        hashMap.put("previous", convertPushSubscriptionStateToMap(pushSubscriptionChangedState.getPrevious()));
        return hashMap;
    }

    public static HashMap<String, Object> convertUserChangedStateToMap(UserChangedState userChangedState) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("current", convertUserStateToMap(userChangedState.getCurrent()));
        return hashMap;
    }

    public static HashMap<String, Object> convertJSONObjectToHashMap(JSONObject jSONObject) throws JSONException {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (jSONObject != null && jSONObject != JSONObject.NULL) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!jSONObject.isNull(next)) {
                    Object obj = jSONObject.get(next);
                    if (obj instanceof JSONArray) {
                        obj = convertJSONArrayToList((JSONArray) obj);
                    } else if (obj instanceof JSONObject) {
                        obj = convertJSONObjectToHashMap((JSONObject) obj);
                    }
                    hashMap.put(next, obj);
                }
            }
        }
        return hashMap;
    }

    public static Collection<String> convertReadableArrayIntoStringCollection(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = readableArray.toArrayList().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof String) {
                arrayList.add((String) next);
            }
        }
        return arrayList;
    }

    public static HashMap<String, String> convertReadableMapIntoStringMap(ReadableMap readableMap) {
        HashMap<String, String> hashMap = new HashMap<>();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            if (readableMap.getType(nextKey) == ReadableType.String) {
                hashMap.put(nextKey, readableMap.getString(nextKey));
            }
        }
        return hashMap;
    }

    public static HashMap<String, Object> convertPermissionToMap(boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("permission", Boolean.valueOf(z));
        return hashMap;
    }

    private static List<Object> convertJSONArrayToList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = convertJSONArrayToList((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = convertJSONObjectToHashMap((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
