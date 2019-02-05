package com.cacheproject.cache;

import com.cacheproject.items.ItemA;
import com.cacheproject.items.ItemB;
import com.cacheproject.items.ItemC;
import com.cacheproject.items.ItemD;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.fail;


public class CacheManagerTest {

    private CacheManager cache = new CacheManager();
    private CacheManager.CacheViewManager cacheView = new CacheManager.CacheViewManager();

    private ItemA itemA = new ItemA("A", "itemA");
    private ItemB itemB = new ItemB("B", "itemB");
    private ItemC itemC = new ItemC("C", "itemC");
    private ItemD itemD = new ItemD("D", "itemD");


    @Before
    public void precondition() {
        cache.cacheItem(itemA, itemA.getKey());
        cache.cacheItem(itemB, itemB.getKey());
        cache.cacheItem(itemC, itemC.getKey());
        cache.cacheItem(itemD, itemD.getKey());
    }

    @Test
    public void cacheItemsShouldBeAddedToCache() {
        int cacheSize = cacheView.size();
        int maxCacheSize = 3;
        Assert.assertEquals("Items were not added properly.", maxCacheSize, cacheSize);
    }

    @Test
    public void cacheShouldBeEmpty() {
        cache.invalidateCache();
        int cacheSize = cacheView.size();
        Assert.assertEquals("Cache is not empty.",0, cacheSize);
    }

    @Test
    public void checkIfExceptionIsThrown() {
        try {
            cacheView.getItem("H");
            fail("Exception wasn't thrown!");
        }
        catch (NoSuchElementException exception) {
            Assert.assertEquals("Element with specified key does not exist in cache.", exception.getMessage());
        }
    }
}