package com.bakigoal.tpConcurrency.demo;

/**
 * Created by ilmir on 29.05.16.
 */
public class RunnableDemoMain {
	public static void main(String[] args) {
		RunnableDemo demo1 = new RunnableDemo("Thread-1");
		demo1.start();
		RunnableDemo demo2 = new RunnableDemo("Thread-2");
		demo2.start();
	}
}
