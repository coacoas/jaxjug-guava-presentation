package com.jaxjug.guava;

import static org.hamcrest.core.Is.is;

import org.junit.Assert;
import org.junit.Test;

public class ObjectsExamplesGuavaTest {
	@Test
	public void testToString() {
		Assert.assertThat(new ObjectsExamplesGuava("Bill", "Carlson").toString(), 
				is("ObjectsExamplesGuava{firstName=Bill, lastName=Carlson}"));
	}
}
