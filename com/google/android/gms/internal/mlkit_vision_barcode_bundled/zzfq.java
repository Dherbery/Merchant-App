package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzfq {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzfo zzfoVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzfoVar, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzc(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (Character.isUpperCase(charAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(charAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzgw.zza(new zzcy(((String) obj).getBytes(zzem.zzb))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzdb) {
            sb.append(": \"");
            sb.append(zzgw.zza((zzdb) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzed) {
            sb.append(" {");
            zzd((zzed) obj, sb, i + 2);
            sb.append("\n");
            zzc(i, sb);
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i3 = i + 2;
            zzb(sb, i3, SubscriberAttributeKt.JSON_NAME_KEY, entry.getKey());
            zzb(sb, i3, "value", entry.getValue());
            sb.append("\n");
            zzc(i, sb);
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj);
    }

    private static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    private static void zzd(zzfo zzfoVar, StringBuilder sb, int i) {
        int i2;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzfoVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method3 = declaredMethods[i3];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith(b.ar)) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i2);
            if (!substring.endsWith("List") || substring.endsWith("OrBuilderList") || substring.equals("List") || (method2 = (Method) entry.getValue()) == null || !method2.getReturnType().equals(List.class)) {
                if (!substring.endsWith("Map") || substring.equals("Map") || (method = (Method) entry.getValue()) == null || !method.getReturnType().equals(Map.class) || method.isAnnotationPresent(Deprecated.class) || !Modifier.isPublic(method.getModifiers())) {
                    if (hashSet.contains("set".concat(String.valueOf(substring))) && (!substring.endsWith("Bytes") || !treeMap.containsKey(b.ar.concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                        Method method4 = (Method) entry.getValue();
                        Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring)));
                        if (method4 != null) {
                            Object zzQ = zzed.zzQ(method4, zzfoVar, new Object[0]);
                            if (method5 == null) {
                                if (zzQ instanceof Boolean) {
                                    if (!((Boolean) zzQ).booleanValue()) {
                                    }
                                    zzb(sb, i, substring, zzQ);
                                } else if (zzQ instanceof Integer) {
                                    if (((Integer) zzQ).intValue() == 0) {
                                    }
                                    zzb(sb, i, substring, zzQ);
                                } else if (zzQ instanceof Float) {
                                    if (Float.floatToRawIntBits(((Float) zzQ).floatValue()) == 0) {
                                    }
                                    zzb(sb, i, substring, zzQ);
                                } else if (!(zzQ instanceof Double)) {
                                    if (zzQ instanceof String) {
                                        equals = zzQ.equals("");
                                    } else if (zzQ instanceof zzdb) {
                                        equals = zzQ.equals(zzdb.zzb);
                                    } else if (zzQ instanceof zzfo) {
                                        if (zzQ == ((zzfo) zzQ).zzab()) {
                                        }
                                        zzb(sb, i, substring, zzQ);
                                    } else {
                                        if ((zzQ instanceof Enum) && ((Enum) zzQ).ordinal() == 0) {
                                        }
                                        zzb(sb, i, substring, zzQ);
                                    }
                                    if (equals) {
                                    }
                                    zzb(sb, i, substring, zzQ);
                                } else {
                                    if (Double.doubleToRawLongBits(((Double) zzQ).doubleValue()) == 0) {
                                    }
                                    zzb(sb, i, substring, zzQ);
                                }
                            } else {
                                if (!((Boolean) zzed.zzQ(method5, zzfoVar, new Object[0])).booleanValue()) {
                                }
                                zzb(sb, i, substring, zzQ);
                            }
                        }
                    }
                } else {
                    zzb(sb, i, substring.substring(0, substring.length() - 3), zzed.zzQ(method, zzfoVar, new Object[0]));
                }
            } else {
                zzb(sb, i, substring.substring(0, substring.length() - 4), zzed.zzQ(method2, zzfoVar, new Object[0]));
            }
            i2 = 3;
        }
        if (zzfoVar instanceof zzdz) {
            Iterator zzf = ((zzdz) zzfoVar).zza.zzf();
            while (zzf.hasNext()) {
                Map.Entry entry2 = (Map.Entry) zzf.next();
                zzb(sb, i, "[" + ((zzea) entry2.getKey()).zza + "]", entry2.getValue());
            }
        }
        zzgz zzgzVar = ((zzed) zzfoVar).zzc;
        if (zzgzVar != null) {
            zzgzVar.zzi(sb, i);
        }
    }
}
