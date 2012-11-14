package com.jaxjug.guava;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;


public class PreconditionExamples {

	public int javaWay(String message, int level) {
		if (level < 0) {
			throw new IllegalArgumentException("Level may not be negative");
		}
		if (level > 10) {
			throw new IllegalArgumentException("Level may not be greater than 10");
		}
		
		return message.length();
	}
	
	public int guavaWay(String message, int level) {
		checkNotNull(message);
		checkArgument(level >= 0, "Level may not be negative");
		checkArgument(level <= 10, "Level may not be > 10");
		
		return message.length();
	}
}
