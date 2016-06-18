package com.bakigoal.tpConcurrency.demo;

/**
 * Created by ilmir on 29.05.16.
 */
public class ThreadDemoMain {
	public static void main(String[] args) {
		ThreadDemo demo1 = new ThreadDemo("Thread-1");
		demo1.start();
		ThreadDemo demo2 = new ThreadDemo("Thread-2");
		demo2.start();
	}
}
