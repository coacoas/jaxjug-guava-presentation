package com.jaxjug.guava;

import static org.hamcrest.core.Is.is;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class CollectionsExamplesTest {
	@Test
	public void testFilterUpperCase() {
		List<String> base = ImmutableList.of("one", "TWO", "Three", "FOUR");
		List<String> filter = ImmutableList.copyOf(new CollectionsExample().getAllUppercase(base));
		List<String> expected = ImmutableList.of("TWO", "FOUR");
		Assert.assertThat(filter, is(expected));
	}
}
