package Bogosort;

public class StopWatch {
	private long t0;  // time that Stopwatch was started

	public StopWatch() {
		restart();
	}

	// resets the Stopwatch to zero
	public final synchronized void restart() {
		t0 = System.currentTimeMillis();
	}

	// returns elapsed time in seconds
	public final synchronized double read() {
		long tnow = System.currentTimeMillis() - t0;
		return tnow / 1000.0;
	}

	// Returns elapsed time in seconds
	public final synchronized double elapsedS() {
		return read();
	} // elapsedS()

	// Returns elapsed time in milliseconds.
	public final synchronized long elapsedMs() {
		return System.currentTimeMillis() - t0;
	} // elapsedMs() 
} // Stopwatch class