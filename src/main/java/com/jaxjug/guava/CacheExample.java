package com.jaxjug.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CacheExample {
	LoadingCache<String, String> cache = CacheBuilder.newBuilder()
			.maximumSize(1000)
			.build(new CacheLoader<String, String>() {

				@Override
				public String load(String key) throws Exception {
					return key.toUpperCase();
				}});
	
	public CacheExample() { 
		cache.put("test1", "Test1");
	}
}
