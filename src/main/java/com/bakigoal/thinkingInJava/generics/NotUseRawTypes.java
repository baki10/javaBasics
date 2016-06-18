package com.bakigoal.thinkingInJava.generics;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ilmir on 22.05.16.
 */
public class NotUseRawTypes {
	//Raw collection type - DON'T DO THIS!!!
	private final Collection rawTypeStamps = new ArrayList();
	//Parametrized collection type - TYPE SAFE
	private final Collection<Stamp> safeTypeStamps = new ArrayList<>();

	public static void main(String[] args) {
		NotUseRawTypes notUseRawTypes = new NotUseRawTypes();
//		notUseRawTypes.rawCollection();
		notUseRawTypes.safeCollection();

	}

	private void safeCollection() {
		safeTypeStamps.add(new Stamp("Safe Stamp 1"));
		safeTypeStamps.add(new Stamp("Safe Stamp 2"));

		//safeTypeStamps.add(new Coin("Coin 1"));
		// for loop with parameterized iterator declaration - typesafe
		for (Stamp s : safeTypeStamps) {
			System.out.println(s);
		}
	}

	private void rawCollection() {
		rawTypeStamps.add(new Stamp("Stamp 1"));
		rawTypeStamps.add(new Stamp("Stamp 2"));
		// Erroneous insertion of coin into stamp collection
		rawTypeStamps.add(new Coin("Coin 1"));
		// Now a raw iterator type - don'thread do this!
		for (Object rawTypeStamp : rawTypeStamps) {
			Stamp s = (Stamp) rawTypeStamp; // Throws ClassCastException
			System.out.println(s);
		}
	}
}

class Stamp {

	private final String name;

	Stamp(String s) {
		this.name = s;
	}

	@Override
	public String toString() {
		return name;
	}
}

class Coin {

	private final String name;

	Coin(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}