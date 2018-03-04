package org.itstep.service;

public class Timer {
	public static void waitSeconds(int seconds) {
		Thread thread = new Thread();
		try {
			thread.sleep(4000*seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
