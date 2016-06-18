package com.bakigoal.thinkingInJava.classesAndInterfaces;

import java.util.Map;
import java.util.Objects;

/**
 * Created by ilmir on 22.05.16.
 */
//Skeletal implementations
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
	//Primitive operations
	public abstract K getKey();

	public abstract V getValue();

	//Entries in modifiable maps must override this method
	public V setValue(V v) {
		throw new UnsupportedOperationException();
	}

	//Implements the general contract of Map.Entry.equals
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Map.Entry)) {
			return false;
		}
		Map.Entry<?, ?> entry = (Map.Entry) obj;
		return Objects.equals(getKey(), entry.getKey())
				&& Objects.equals(getValue(), entry.getValue());
	}

	//Implements the general contract of Map.Entry.hashCode
	@Override
	public int hashCode() {
		return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
	}
}
