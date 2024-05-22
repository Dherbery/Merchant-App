package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/* compiled from: OfferingStrings.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/revenuecat/purchases/strings/OfferingStrings;", "", "()V", "BUILDING_OFFERINGS", "", "CANNOT_FIND_PRODUCT_CONFIGURATION_ERROR", "CONFIGURATION_ERROR_NO_PRODUCTS_FOR_OFFERINGS", "CONFIGURATION_ERROR_PRODUCTS_NOT_FOUND", "CREATED_OFFERINGS", "EMPTY_PRODUCT_ID_LIST", "ERROR_FETCHING_OFFERINGS_USING_DISK_CACHE", "EXTRA_GET_BILLING_CONFIG_RESPONSE", "EXTRA_QUERY_PRODUCT_DETAILS_RESPONSE", "EXTRA_QUERY_PURCHASES_RESPONSE", "FETCHING_OFFERINGS_ERROR", "FETCHING_PRODUCTS", "FETCHING_PRODUCTS_FINISHED", "JSON_EXCEPTION_ERROR", "LIST_PRODUCTS", "NO_CACHED_OFFERINGS_FETCHING_NETWORK", "OFFERINGS_STALE_UPDATING_IN_BACKGROUND", "OFFERINGS_STALE_UPDATING_IN_FOREGROUND", "OFFERINGS_START_UPDATE_FROM_NETWORK", "OFFERING_EMPTY", "RETRIEVED_PRODUCTS", "VENDING_OFFERINGS_CACHE", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OfferingStrings {
    public static final String BUILDING_OFFERINGS = "Building offerings response with %d products";
    public static final String CANNOT_FIND_PRODUCT_CONFIGURATION_ERROR = "Could not find ProductDetails for %s \nThere is a problem with your configuration in Play Store Developer Console. More info here: https://errors.rev.cat/configuring-products";
    public static final String CONFIGURATION_ERROR_NO_PRODUCTS_FOR_OFFERINGS = "There are no products registered in the RevenueCat dashboard for your offerings. If you don't want to use the offerings system, you can safely ignore this message. To configure offerings and their products, follow the instructions in https://rev.cat/how-to-configure-offerings.\nMore information: https://rev.cat/why-are-offerings-empty";
    public static final String CONFIGURATION_ERROR_PRODUCTS_NOT_FOUND = "There's a problem with your configuration. None of the products registered in the RevenueCat dashboard could be fetched from the Play Store.\nMore information: https://rev.cat/why-are-offerings-empty";
    public static final String CREATED_OFFERINGS = "Offerings object created: %s";
    public static final String EMPTY_PRODUCT_ID_LIST = "productId list is empty, skipping queryProductDetailsAsync call";
    public static final String ERROR_FETCHING_OFFERINGS_USING_DISK_CACHE = "Error fetching offerings. Using disk cache.";
    public static final String EXTRA_GET_BILLING_CONFIG_RESPONSE = "BillingClient getBillingConfigAsync has returned more than once, with result: %s.";
    public static final String EXTRA_QUERY_PRODUCT_DETAILS_RESPONSE = "BillingClient queryProductDetails has returned more than once, with result: %s. More info here: https://rev.cat/google-duplicated-listener-timeouts";
    public static final String EXTRA_QUERY_PURCHASES_RESPONSE = "BillingClient queryPurchases has returned more than once, with result: %s.";
    public static final String FETCHING_OFFERINGS_ERROR = "Error fetching offerings - %s";
    public static final String FETCHING_PRODUCTS = "Requesting products from the store with identifiers: %s";
    public static final String FETCHING_PRODUCTS_FINISHED = "Products request finished for %s";
    public static final OfferingStrings INSTANCE = new OfferingStrings();
    public static final String JSON_EXCEPTION_ERROR = "JSONException when building Offerings object. Message: %s";
    public static final String LIST_PRODUCTS = "%s - %s";
    public static final String NO_CACHED_OFFERINGS_FETCHING_NETWORK = "No cached Offerings, fetching from network";
    public static final String OFFERINGS_STALE_UPDATING_IN_BACKGROUND = "Offerings cache is stale, updating from network in background";
    public static final String OFFERINGS_STALE_UPDATING_IN_FOREGROUND = "Offerings cache is stale, updating from network in foreground";
    public static final String OFFERINGS_START_UPDATE_FROM_NETWORK = "Start Offerings update from network.";
    public static final String OFFERING_EMPTY = "There's a problem with your configuration. No packages could be found for offering with identifier %s. This could be due to Products not being configured correctly in the RevenueCat dashboard or Play Store.\nTo configure products, follow the instructions in https://rev.cat/how-to-configure-offerings.\nMore information: https://rev.cat/why-are-offerings-empty";
    public static final String RETRIEVED_PRODUCTS = "Retrieved productDetailsList: %s";
    public static final String VENDING_OFFERINGS_CACHE = "Vending Offerings from cache";

    private OfferingStrings() {
    }
}
