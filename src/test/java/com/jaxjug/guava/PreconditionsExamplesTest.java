package com.jaxjug.guava;

import org.junit.Test;

public class PreconditionsExamplesTest {

	@Test(expected=IllegalArgumentException.class)
	public void testIllegalArgument() { 
		new PreconditionExamples().guavaWay("", -1);
	}
	
	@Test(expected=NullPointerException.class)
	public void testNullArgument() { 
		new PreconditionExamples().guavaWay(null, 1);
	}
}
