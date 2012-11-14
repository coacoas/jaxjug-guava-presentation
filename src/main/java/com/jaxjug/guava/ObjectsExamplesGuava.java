package com.jaxjug.guava;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class ObjectsExamplesGuava implements Comparable<ObjectsExamplesGuava> {
	final String firstName;
	final String lastName;
	
	public ObjectsExamplesGuava(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectsExamplesGuava other = (ObjectsExamplesGuava) obj;

		return Objects.equal(firstName, other.firstName) && Objects.equal(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(getClass())
				.add("firstName", firstName)
				.add("lastName", lastName)
				.omitNullValues()
				.toString();
	}

	@Override
	public int compareTo(ObjectsExamplesGuava other) {
		return ComparisonChain.start()
				.compare(firstName, other.firstName)
				.compare(lastName, other.lastName)
				.result();
	}
	
}
