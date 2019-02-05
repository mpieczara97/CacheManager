package com.cacheproject.cache;

import com.cacheproject.items.CacheItem;

public interface Cache {
    CacheItem cacheItem(Object item, String key);
    void invalidateCache();
    CacheView getView();
}
