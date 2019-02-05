package com.cacheproject.items;

public class ItemC implements CacheItem {

    private String key;
    private Object value;

    public ItemC(String key, Object value) {
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
