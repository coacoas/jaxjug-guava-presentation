package com.jaxjug.guava;

import static org.hamcrest.core.Is.is;

import org.junit.Assert;
import org.junit.Test;

public class CacheExampleTest {
	@Test
	public void testCaching() throws Exception { 
		CacheExample example = new CacheExample();
		// Test element manually entered
		Assert.assertThat(example.cache.get("test1"), is("Test1"));
		// Test element inserted by CacheLoader
		Assert.assertThat(example.cache.get("test2"), is("TEST2"));
	}
}
