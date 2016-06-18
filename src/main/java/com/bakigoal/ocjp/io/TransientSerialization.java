package com.bakigoal.ocjp.io;

import java.io.Serializable;

public class TransientSerialization {
	public static void main(String[] args) {
		President president = new President("Barack Obama", "2009 to --", "56th term");
		System.out.println("before serialization: " + president);
		String filePath = "president.data";
		ObjectSerializeUtils.serialize(president, filePath);
		President deserialized = (President) ObjectSerializeUtils.deserialize(filePath);
		System.out.println("after deserialization: " + deserialized);
	}
}

class President implements Serializable {

	private static final long serialVersionUID = -8816872877078048325L;
	private String name;
	private String period;
	private transient String term;

	President(String name, String period, String term) {
		this.name = name;
		this.period = period;
		this.term = term;
	}

	@Override
	public String toString() {
		return "President{name='" + name + "', period='" + period + "', term='" + term + "'}";
	}
}