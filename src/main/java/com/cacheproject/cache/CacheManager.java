package com.cacheproject.cache;

import com.cacheproject.items.CacheItem;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CacheManager implements Cache {

    private final int cacheMaxSize = 3;
    static LinkedMap<String, CacheItem> cache = new LinkedMap<>();

    @Override
    public CacheItem cacheItem(Object item, String key) {

        CacheItem castItem = (CacheItem) item;

        if(cache.size() < cacheMaxSize) {
            cache.put(key, castItem);
        } else {
            cache.values().remove(cache.values().toArray()[0]);
            cache.put(key, castItem);
        }

        return castItem;
    }

    @Override
    public void invalidateCache() {
        cache.clear();
    }

    @Override
    public CacheView getView() {
        return CacheViewManager.getInstance();
    }


    public static class CacheViewManager implements CacheView {

        private static CacheViewManager instance = null;
        protected CacheViewManager() {}

        public static CacheViewManager getInstance() {
            if(instance == null) {
                instance = new CacheViewManager();
            }
            return instance;
        }

        @Override
        public int size() {
            int size = cache.size();
            return size;
        }

        @Override
        public CacheItem getItem(int index) {
            return cache.getValue(index);
        }

        @Override
        public CacheItem getItem(String key) {

            try {
                CacheItem item = cache.entrySet().stream()
                        .filter(map -> map.getKey().equals(key))
                        .map(map -> map.getValue()).findFirst().get();

                return item;
            } catch(NoSuchElementException e) {
                throw new NoSuchElementException("Element with specified key does not exist in cache.");
            }
        }

        public void getAllItems() {
            String currentCache = cache.entrySet().stream()
                    .map(map -> map.getKey())
                    .collect(Collectors.joining(", "));

            System.out.println("Current cache state: " +"[ " + currentCache +" ]");

        }
    }
}
