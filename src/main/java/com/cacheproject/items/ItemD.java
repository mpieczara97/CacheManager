package com.cacheproject.items;

public class ItemD implements CacheItem {

    private String key;
    private Object value;

    public ItemD(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public Object getValue() {
        return this.value;
    }
}
