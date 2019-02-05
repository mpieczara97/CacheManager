package com.cacheproject.main;

import com.cacheproject.cache.CacheManager;
import com.cacheproject.items.*;

public class Main {

	public static void main(String[] args) {

		CacheManager cache = new CacheManager();
		CacheManager.CacheViewManager cacheView = (CacheManager.CacheViewManager) cache.getView();
		int cacheSize;

		ItemA objA = new ItemA("A", "itemA");
		ItemB objB = new ItemB("B", "itemB");
		ItemC objC = new ItemC("C", "itemC");
		ItemD objD = new ItemD("D", "itemD");

		CacheItem[] itemTbl = new CacheItem[]{objA, objB, objC, objD};

		/*
		 * Save all item in cache using cacheItem() method
		 * For each iteration call getAllItems() and size() method
		 */
		for(CacheItem item : itemTbl) {
			cache.cacheItem(item, item.getKey());
			cacheView.getAllItems();
			cacheSize = cacheView.size();
			System.out.println("Size: " + cacheSize);
		}

		System.out.println();

		System.out.println("Get item by index: ");
		CacheItem item1 = cacheView.getItem(0);
		System.out.println(item1);
		System.out.println();

		System.out.println("Get item by key: ");
		CacheItem item2 = cacheView.getItem("C");
		System.out.println(item2);
		System.out.println();


		System.out.println("Clear cache.");
		cache.invalidateCache();
		System.out.println();
		cacheView.getAllItems();
		System.out.println("Cache size after invalidation: " + cacheView.size());
	}
}