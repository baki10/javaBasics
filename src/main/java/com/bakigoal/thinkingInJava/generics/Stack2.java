package com.bakigoal.thinkingInJava.generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * Created by ilmir on 22.05.16.
 */
public class Stack2<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	// The elements array will contain only E instances from push(E).
	// This is sufficient to ensure type safety, but the runtime
	// type of the array won'thread be E[]; it will always be Object[]!
	@SuppressWarnings("unchecked")
	public Stack2() {
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public E pop() {
		if (size == 0)
			throw new EmptyStackException();
		E result = elements[--size];
		elements[size] = null;
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}

	// Wildcard type for parameter that serves as an E producer
	public void pushAll(Iterable<? extends E> src) {
		for (E e : src)
			push(e);
	}

	// Wildcard type for parameter that serves as an E consumer
	public void popAll(Collection<? super E> dst) {
		while (!isEmpty())
			dst.add(pop());
	}

	// Little program to exercise our generic Stack
	public static void main(String[] args) {
		args = new String[5];
		for (int i = 0; i < args.length; i++) {
			args[i] = "String " + i;
		}
		Stack2<String> stack = new Stack2<>();
		for (String arg : args)
			stack.push(arg);
		while (!stack.isEmpty())
			System.out.println(stack.pop().toString().toUpperCase());
	}
}
