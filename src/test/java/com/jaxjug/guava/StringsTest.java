package com.jaxjug.guava;

import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Splitter;

public class StringsTest {
	@Test
	public void testJavaSplitter() { 
		Assert.assertThat(",a,,b,".split(","), arrayContaining("", "a", "", "b"));
	}

	@Test
	public void testSplitter() { 
		Assert.assertThat(Splitter.on(',')
	       .trimResults()
	       .omitEmptyStrings()
	       .split("   ,foo,bar,,   qux"), contains("foo", "bar", "qux"));
	}
}
