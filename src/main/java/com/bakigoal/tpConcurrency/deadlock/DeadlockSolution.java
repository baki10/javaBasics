package com.bakigoal.tpConcurrency.deadlock;

/**
 * Created by ilmir on 01.06.16.
 */
public class DeadlockSolution {
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public static void main(String[] args) {
		T1 t1 = new T1();
		T2 t2 = new T2();
		t1.start();
		t2.start();
	}

	private static class T1 extends Thread{
		@Override
		public void run() {
			synchronized (lock1){
				System.out.println("Thread 1: Holding lock 1 ...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 1: Waiting for lock 2 ...");
				synchronized (lock2){
					System.out.println("Thread 1: Holding lock 1 & 2 ...");
				}
			}
		}
	}

	private static class T2 extends Thread{
		@Override
		public void run() {
			synchronized (lock1){
				System.out.println("Thread 2: Holding lock 2 ...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 2: Waiting for lock 1 ...");
				synchronized (lock2){
					System.out.println("Thread 2: Holding lock 1 & 2 ...");
				}
			}
		}
	}
}
