package com.cacheproject.cache;

import com.cacheproject.items.CacheItem;

public interface CacheView {
    int size();
    CacheItem getItem(int index);
    CacheItem getItem(String key);
}
