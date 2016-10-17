package edu.umkc.wow;

public interface IClock {
	public void setCyclesPerSecond(float cyclesPerSecond);
	public void reset();
	public void update();
	public void Clock1(float cyclesPerSecond) ;
	public void setPaused(boolean paused) ;
	public boolean isPaused();	
	public boolean hasElapsedCycle() ;	
	public boolean peekElapsedCycle() ;
	public long getCurrentTime();
	public void start_mygame();

}
