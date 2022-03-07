package me.zerodevstuff.zer0.utils;

public class Timer {
	
	private long prevTime;
	
	public Timer() {
		prevTime = 0;
	}
	
	public boolean hasTimePassed(long miliSec) {
		return (float)(getTime() - prevTime) >= miliSec;
	}
	
	public void reset() {
		prevTime = getTime();
	}
	
	public static long getTime() {
		return System.nanoTime() / 1000000;
	}

}