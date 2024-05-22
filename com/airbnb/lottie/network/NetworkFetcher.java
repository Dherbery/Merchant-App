package com.airbnb.lottie.network;

import android.content.Context;
import android.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class NetworkFetcher {
    private final LottieNetworkFetcher fetcher;
    private final NetworkCache networkCache;

    public NetworkFetcher(NetworkCache networkCache, LottieNetworkFetcher lottieNetworkFetcher) {
        this.networkCache = networkCache;
        this.fetcher = lottieNetworkFetcher;
    }

    public LottieResult<LottieComposition> fetchSync(Context context, String str, String str2) {
        LottieComposition fetchFromCache = fetchFromCache(context, str, str2);
        if (fetchFromCache != null) {
            return new LottieResult<>(fetchFromCache);
        }
        Logger.debug("Animation for " + str + " not found in cache. Fetching from network.");
        return fetchFromNetwork(context, str, str2);
    }

    private LottieComposition fetchFromCache(Context context, String str, String str2) {
        NetworkCache networkCache;
        Pair<FileExtension, InputStream> fetch;
        LottieResult<LottieComposition> fromZipStreamSync;
        if (str2 == null || (networkCache = this.networkCache) == null || (fetch = networkCache.fetch(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) fetch.first;
        InputStream inputStream = (InputStream) fetch.second;
        int i = AnonymousClass1.$SwitchMap$com$airbnb$lottie$network$FileExtension[fileExtension.ordinal()];
        if (i == 1) {
            fromZipStreamSync = LottieCompositionFactory.fromZipStreamSync(context, new ZipInputStream(inputStream), str2);
        } else if (i == 2) {
            try {
                fromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(inputStream), str2);
            } catch (IOException e) {
                fromZipStreamSync = new LottieResult<>(e);
            }
        } else {
            fromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str2);
        }
        if (fromZipStreamSync.getValue() != null) {
            return fromZipStreamSync.getValue();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.network.NetworkFetcher$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$network$FileExtension;

        static {
            int[] iArr = new int[FileExtension.values().length];
            $SwitchMap$com$airbnb$lottie$network$FileExtension = iArr;
            try {
                iArr[FileExtension.ZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$network$FileExtension[FileExtension.GZIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private LottieResult<LottieComposition> fetchFromNetwork(Context context, String str, String str2) {
        Logger.debug("Fetching " + str);
        LottieFetchResult lottieFetchResult = null;
        try {
            try {
                LottieFetchResult fetchSync = this.fetcher.fetchSync(str);
                if (!fetchSync.isSuccessful()) {
                    LottieResult<LottieComposition> lottieResult = new LottieResult<>(new IllegalArgumentException(fetchSync.error()));
                    if (fetchSync != null) {
                        try {
                            fetchSync.close();
                        } catch (IOException e) {
                            Logger.warning("LottieFetchResult close failed ", e);
                        }
                    }
                    return lottieResult;
                }
                LottieResult<LottieComposition> fromInputStream = fromInputStream(context, str, fetchSync.bodyByteStream(), fetchSync.contentType(), str2);
                StringBuilder sb = new StringBuilder("Completed fetch from network. Success: ");
                sb.append(fromInputStream.getValue() != null);
                Logger.debug(sb.toString());
                if (fetchSync != null) {
                    try {
                        fetchSync.close();
                    } catch (IOException e2) {
                        Logger.warning("LottieFetchResult close failed ", e2);
                    }
                }
                return fromInputStream;
            } catch (Exception e3) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e3);
                if (0 != 0) {
                    try {
                        lottieFetchResult.close();
                    } catch (IOException e4) {
                        Logger.warning("LottieFetchResult close failed ", e4);
                    }
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    lottieFetchResult.close();
                } catch (IOException e5) {
                    Logger.warning("LottieFetchResult close failed ", e5);
                }
            }
            throw th;
        }
    }

    private LottieResult<LottieComposition> fromInputStream(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        LottieResult<LottieComposition> fromZipStream;
        FileExtension fileExtension;
        NetworkCache networkCache;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            Logger.debug("Handling zip response.");
            FileExtension fileExtension2 = FileExtension.ZIP;
            fromZipStream = fromZipStream(context, str, inputStream, str3);
            fileExtension = fileExtension2;
        } else if (str2.contains("application/gzip") || str2.contains("application/x-gzip") || str.split("\\?")[0].endsWith(".tgs")) {
            Logger.debug("Handling gzip response.");
            fileExtension = FileExtension.GZIP;
            fromZipStream = fromGzipStream(str, inputStream, str3);
        } else {
            Logger.debug("Received json response.");
            fileExtension = FileExtension.JSON;
            fromZipStream = fromJsonStream(str, inputStream, str3);
        }
        if (str3 != null && fromZipStream.getValue() != null && (networkCache = this.networkCache) != null) {
            networkCache.renameTempFile(str, fileExtension);
        }
        return fromZipStream;
    }

    private LottieResult<LottieComposition> fromZipStream(Context context, String str, InputStream inputStream, String str2) throws IOException {
        NetworkCache networkCache;
        if (str2 == null || (networkCache = this.networkCache) == null) {
            return LottieCompositionFactory.fromZipStreamSync(context, new ZipInputStream(inputStream), (String) null);
        }
        return LottieCompositionFactory.fromZipStreamSync(context, new ZipInputStream(new FileInputStream(networkCache.writeTempCacheFile(str, inputStream, FileExtension.ZIP))), str);
    }

    private LottieResult<LottieComposition> fromGzipStream(String str, InputStream inputStream, String str2) throws IOException {
        NetworkCache networkCache;
        if (str2 == null || (networkCache = this.networkCache) == null) {
            return LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(inputStream), null);
        }
        return LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(new FileInputStream(networkCache.writeTempCacheFile(str, inputStream, FileExtension.GZIP))), str);
    }

    private LottieResult<LottieComposition> fromJsonStream(String str, InputStream inputStream, String str2) throws IOException {
        NetworkCache networkCache;
        if (str2 == null || (networkCache = this.networkCache) == null) {
            return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null);
        }
        return LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(networkCache.writeTempCacheFile(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
    }
}
